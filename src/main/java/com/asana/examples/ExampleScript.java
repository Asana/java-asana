package com.asana.examples;

import com.asana.Client;
import com.asana.models.ResultBody;
import com.asana.models.Task;
import com.asana.models.User;
import com.google.common.collect.ImmutableList;

public class ExampleScript {

    public static void main( String[] args) throws Exception
    {
        Client client = Client.basicAuth(System.getenv("ASANA_API_KEY"));
//        client.options.put("base_url", "http://localhost:8080");

        ResultBody<User> user = client.users.me()
                .option("pretty", true)
                .executeRaw();

        System.out.println(user.data.name);
        System.out.println(user.data.id);
        System.out.println(user.data.photo.image_128x128);
        System.out.println(user.data.workspaces.iterator().next().name);

//        Collection<User> users = client.users.findAll();
//        for (User u: users) {
//            System.out.println(u.name);
//        }

        Task task = client.tasks.create()
                .option("pretty", true)
                .data("name", "hello2")
                .data("workspace", "498346170860")
                .data("projects", ImmutableList.of("29898626391464"))
                .execute();

        System.out.println(task.id);

        client.tasks.update(task.id)
                .data("name", "barrrr2")
                .execute();

        task = client.tasks.findById(task.id).execute();
        System.out.println(task.id);
        System.out.println(task.name);

        client.tasks.delete(task.id).execute();
    }
}
