package com.asana.resources;

import com.asana.AsanaTest;
import com.asana.models.Attachment;
import com.asana.models.Task;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TasksTest extends AsanaTest {
  @Test
  public void testGetTaskWithAttachments() throws IOException {
    String res = "{ \"data\": {\"gid\": 1, \"name\": \"test task\", \"attachments\": " +
        "[{\"gid\": 2, \"name\": \"test attachment\"}] } }";
    dispatcher
        .registerResponse("GET", "http://app/tasks/1?opt_fields=gid,name,attachments.name")
        .code(200)
        .content(res);

    Task task = client.tasks
        .findById("1")
        .option("fields", Arrays.asList("gid", "name", "attachments.name"))
        .execute();

    assertEquals("1", task.gid);
    assertEquals("test task", task.name);
    assertEquals(1, task.attachments.size());
    Attachment attachment = new ArrayList<>(task.attachments).get(0);
    assertEquals("2", attachment.gid);
    assertEquals("test attachment", attachment.name);
  }
}
