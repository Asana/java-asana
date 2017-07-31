package com.asana.examples;

import com.asana.Client;
import com.asana.models.Section;

import java.util.List;

/**
 *
 */
public class ExampleSection {
    public static void main(String[] args) throws Exception {
        if (System.getenv("ASANA_ACCESS_TOKEN") == null) {
            throw new Error("Please set the ASANA_API_KEY environment variable.");
        }

        System.out.println("== Example using a personal access token:");

        // create a client with a personal access token
        Client client = Client.accessToken(System.getenv("ASANA_ACCESS_TOKEN"));

        Section newSection = client.sections.createInProject("145619319717806")
                .data("name", "New section")
                .execute();
        System.out.println("Created section: " + newSection.name);

        Section section = client.sections.findById(newSection.id).execute();
        System.out.println("Looking up created section: " + section.name);

        System.out.println("All Sections in project:");
        List<Section> sections = client.projects.sections("145619319717806").execute();
        for(Section sec: sections){
            System.out.println("Section - " + sec.name + " Id: " + sec.id);
        }

        Section updatedSection = client.sections.findById(section.id)
                .data("Name", "New Section title").execute();
        System.out.println("New section Name: " + updatedSection.name);

        System.out.println("All Sections in project:");
        sections = client.projects.sections("145619319717806").execute();
        for(Section sec: sections){
            System.out.println("Section - " + sec.name);
        }

        Section deletedSection = client.sections.delete(section.id).execute();
        System.out.println("Deleted section: " + deletedSection.name);
    }
}
