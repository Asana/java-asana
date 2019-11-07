package com.asana.examples;

import com.asana.Client;
import com.asana.models.Event;
import com.asana.models.Project;
import com.asana.models.Workspace;
import com.asana.models.Story;
import com.asana.models.ResultBodyCollection;
import com.asana.models.Task;
import com.asana.errors.InvalidTokenError;

import com.hubspot.slack.client.SlackClient;
import com.hubspot.slack.client.SlackClientFactory;
import com.hubspot.slack.client.SlackClientRuntimeConfig;
import com.hubspot.slack.client.methods.params.chat.ChatPostMessageParams;
import com.hubspot.slack.client.models.response.SlackError;

import java.io.File;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.util.List;


/**
 * PAT Instructions:
 * <p>
 * 1. set your ASANA_ACCESS_TOKEN environment variable to a personal access token
 * 2. set your SLACK_TOKEN environment variable to a personal slack access token
 * 3. replace CHANNEL_ID with a chosen slack channel
 */

public class ExampleMilestoneCelebratorySlackMessage {

    private String CHANNEL_ID = "#asana-notifications";

    public static void main(String[] args) throws Exception {

        Client client = getAsanaClient();
        SlackClient slackClient = getSlackClient();

        String projectId = args[0];

        // Attempt to get latest sync token.
        File syncFile = new File("asana_sync_token_for_project_" + projectId);

        // If the file does not exist, we fetch a new sync token for future use.
        if (syncFile.createNewFile()) {
        	String initialSync = null;

            try {
                ResultBodyCollection<Event> eventResponse = client.events.get(projectId, "random_sync_token").executeRaw();
            } catch(InvalidTokenError e) {
                initialSync = e.sync;
            }

            writeSyncToken(syncFile, initialSync);
            System.out.println("First run, saved sync token. Ready for future use.");
            return;
        }

        String sync = readSyncToken(syncFile);

        ResultBodyCollection<Event> eventResponse = null;

        try {
        	eventResponse = client.events.get(projectId, sync).executeRaw();
        } catch(InvalidTokenError e) {
        	writeSyncToken(syncFile, e.sync);
        	System.out.println("Sync token expired or invalid. Saved a new sync token.");
        	return;
        }
        
        String nextSync = eventResponse.sync;
        List<Event> events = eventResponse.data;

        if (events.size() == 0) {
        	System.out.println("There are no new events. A new token has been saved.");
        }

        // Pass through list of events and find stories of completing milestones. Notify slack of completed milestones.
        for (Event event : events) {
            if (event.type.equals("story") && event.action.equals("added") && event.resource.resourceType.equals("story")) {
                Story story = client.stories.findById(event.resource.gid).execute();
                if (story.text.equals("marked this milestone complete") && story.target.resourceType.equals("task")) {
                    Task task = client.tasks.findById(story.target.gid).execute();
                    if (task.completed && task.resourceSubtype.equals("milestone")) {
                        notifySlack(slackClient, task.name);
                    }
                }
            }
        }

        writeSyncToken(syncFile, nextSync);
    }

    private static Client getAsanaClient() throws Exception {
    	if (System.getenv("ASANA_ACCESS_TOKEN") == null) {
            throw new Error("Please set the ASANA_ACCESS_TOKEN environment variable.");
        }

        // create a client with your Asana PAT
        return Client.accessToken(System.getenv("ASANA_ACCESS_TOKEN"));
    }

    private static void writeSyncToken(File f, String sync) throws Exception {
    	FileWriter writer = new FileWriter(f);
        writer.write(sync);
        writer.close();
    }

    private static String readSyncToken(File f) throws Exception {
    	FileInputStream fis = new FileInputStream(f);
        byte[] data = new byte[(int) f.length()];
        fis.read(data);
        fis.close();
        return new String(data, "UTF-8");
    }

    private static SlackClient getSlackClient() throws Exception {
        if (System.getenv("SLACK_TOKEN") == null) {
            throw new Error("Please set the SLACK_TOKEN environment variable.");
        }

        String slackToken = System.getenv("SLACK_TOKEN");

        return SlackClientFactory
            .defaultFactory()
            .build(SlackClientRuntimeConfig
                .builder()
                .setTokenSupplier(() -> slackToken)
                .build());
    }

    private static void notifySlack(SlackClient slackClient, String taskName) {
        String message = String.format("Celebrate! Milestone: %s completed", taskName);

    	try {
	    	slackClient.postMessage(ChatPostMessageParams.builder()
	            .setText(message)
	            .setChannelId(CHANNEL_ID)
	            .build()
	    	);
    	} catch(Exception e) {
    		System.out.println(String.format("Error sending message to slack for task %s", taskName));
    	}
    }

}
