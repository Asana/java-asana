# Asana [![Build Status][travis-image]][travis-url] [![Maven Version][mvn-image]][mvn-url]

Java client library for the Asana API.

Installation
------------

If you use [Maven](http://maven.apache.org/) to manage dependencies you can include the "asana" artifact by adding it as a dependency in your `pom.xml` file.

    <dependency>
         <groupId>com.asana</groupId>
         <artifactId>asana</artifactId>
         <version>0.10.1</version>
    </dependency>

Or, you can build the artifact and install it to your local Maven repository:

    mvn install


Compile
-------

    mvn compile

Test
----

    mvn test

Examples
--------

Be sure to run `mvn compile` first.

Set the ASANA_ACCESS_TOKEN, ASANA_CLIENT_ID, and ASANA_CLIENT_SECRET environment variables. The app's redirect URL 
should be set to "urn:ietf:wg:oauth:2.0:oob" for command line scripts examples, and "http://localhost:5000/auth/asana/callback" for the server example.

    export ASANA_ACCESS_TOKEN="X"
    export ASANA_CLIENT_ID="X"
    export ASANA_CLIENT_SECRET="X"

Web application example:

    mvn exec:java -Dexec.mainClass="com.asana.examples.ExampleServer"

OAuth command line script example:

    mvn exec:java -Dexec.mainClass="com.asana.examples.ExampleOAuth"

Personal access token command line script example:

    mvn exec:java -Dexec.mainClass="com.asana.examples.ExamplePersonalAccessToken"

Demo create a task and upload an attachment:

    mvn exec:java -Dexec.mainClass="com.asana.examples.ExampleCreateTaskAndUpload"

Demo create project and stream change events:

    mvn exec:java -Dexec.mainClass="com.asana.examples.ExampleCreateProjectAndStreamEvents"

Authentication
--------------

### Personal Access Token

Create a client using a personal access token:

    Client client = Client.accessToken("ASANA_ACCESS_TOKEN");

### OAuth 2

Asana supports OAuth 2. `java-asana` handles some of the details of the OAuth flow for you.

Create a client using your OAuth Client ID and secret:

    OAuthApp app = new OAuthApp(
        "ASANA_CLIENT_ID",
        "ASANA_CLIENT_SECRET",
        "urn:ietf:wg:oauth:2.0:oob"
    );
    Client client = Client.oauth(app);

Redirect the user to the authorization URL obtained from the client's `session` object:
    
    String url = app.getAuthorizationUrl()

`getAuthorizationUrl()` takes an optional state parameter to be used for preventing CSRF attacks:
    
    String state = UUID.randomUUID().toString();
    String url = app.getAuthorizationUrl(state);

When the user is redirected back to your callback, check the `state` URL parameter matches, then pass the `code` parameter to obtain a bearer token:

    if (request.param("state").equals(state)) {
      String token = app.fetchToken(request.params("code"));
      // ... 
    } else {
      // error! possible CSRF attack
    }

Note: if you're writing a non-browser-based application (e.x. a command line tool) you can use the special redirect URI `urn:ietf:wg:oauth:2.0:oob` to prompt the user to copy and paste the code into the application.

Usage
-----

The client's methods are divided into several resources: `attachments`, `customFields`, `customFieldSettings`, `events`, `jobs`, `organizationExports`, `portfolios`, `portfolioMemberships`, `projects`, `projectMemberships`, `projectStatuses`, `stories`, `tags`, `tasks`, `teams`, `users`, `userTaskLists`, `webhooks`, and `workspaces`.

Request methods use the "builder" pattern to set query string or JSON body parameters, and various request options, so a request must be initated using the `execute` or `executeRaw` methods:

Methods that return a single object return that object directly:

    User me = client.users.me().execute();
    System.out.println("Hello " + me.name);

    String workspaceId = me.workspaces.get(0).gid;
    Project project = client.projects.createInWorkspace(workspaceId)
        .data("name", "new project")
        .execute();
    System.out.println("Created project with id: " + project.gid);

Methods that return multiple items (e.x. `findAll`) return an `Iterable` object. See the "Collections" section

Options
-------

Various options can be set globally on the `Client.DEFAULTS` object, per-client on `client.options`, or per-request using the `option` method. For example:


    // global:
    Client.DEFAULTS.put("page_size", 1000);

    // per-client:
    client.options.put("page_size", 1000);

    // per-request:
    client.tasks.findAll().query("project", 1234).option("page_size", 1000).execute();

### Available options

* `base_url` (default: "https://app.asana.com/api/1.0"): API endpoint base URL to connect to
* `max_retries` (default: 5): number to times to retry if API rate limit is reached or a server error occures. Rate limit retries delay until the rate limit expires, server errors exponentially backoff starting with a 1 second delay.
* `fields` and `expand`: array of field names to include in the response, or sub-objects to expand in the response. For example `.option("fields", Arrays.asList("followers", "assignee"))`. See [API documentation](https://asana.com/developers/documentation/getting-started/input-output-options)

Collections (methods returning an array as it's 'data' property):

* `item_limit` (default: -1): limits the total number of items of a collection to return (spanning multiple requests in the case of an iterator).
* `page_size` (default: 50): limits the number of items per page to fetch at a time when using an iterator.
* `offset`: offset token returned by previous calls to the same method, when using `executeRaw()` (in `response.nextPage.offset`)

Events:

* `poll_interval` (default: 5): polling interval for getting new events via an `EventsRequest` iterator (e.x. `for (Event event : client.events.get(resourceId)) { ... }`)
* `sync`: sync token returned by previous calls to `events.get` (e.x. `client.events.get(resourceId, syncToken).executeRaw().sync`)

Headers
-------

To add global headers (like for our [deprecation framework](https://asana.com/developers/documentation/getting-started/deprecations)), you simply add them to the client.

    client.headers.put("asana-enable", "string_ids");
    
### Asana Change Warnings

You will receive warning logs if performing requests that may be affected by a deprecation. The warning contains a link that explains the deprecation.

If you receive one of these warnings, you should:
* Read about the deprecation.
* Resolve sections of your code that would be affected by the deprecation.
* Add the deprecation flag to your "asana-enable" header.

You can place it on the client for all requests.

    client.headers.put("asana-enable", "string_ids,new_sections");
    or
    client.headers.put("asana-disable", "string_ids");

If you would rather suppress these warnings, you can set

    client.logAsanaChangeWarnings = false;

Collections
-----------

### Items Iterator

APIs that return a collection return a CollectionsRequest, which is an iterable:

    Iterable<Workspace> workspaces = client.workspaces.findAll();
    for (Workspace workspace: workspaces) {
        System.out.println("Workspace: " + workspace.name);
    }

Internally the iterator may make multiple HTTP requests, with the number of requested results per page being controlled by the `page_size` option.

### Raw API

You can also use the raw API to fetch a page at a time:

    String offset = null;
    while (true) {
        ResultBodyCollection<Workspace> page = client.workspaces.findAll()
                .option("offset", offset)
                .option("limit", 2)
                .executeRaw();
        System.out.println("received " + page.data.size() + " results");
        if (page.nextPage != null) {
            offset = page.nextPage.offset;
        } else {
            break;
        }
    }

# Deployment

To deploy a new version to the Maven Central Repository, you can run:

`mvn deploy -P release --settings settings.xml`

Before you do this, you must set a few environment variables to authenticate:

* Maven credentials: `MAVEN_USERNAME` and `MAVEN_PASSWORD`
* GPG keyname and password: `MAVEN_GPG_KEYNAME` and `MAVEN_GPG_PASSWORD`

You then can [log in](https://oss.sonatype.org/) to close and deploy the release.

[travis-url]: http://travis-ci.org/Asana/java-asana
[travis-image]: http://img.shields.io/travis/Asana/java-asana.svg?style=flat-square

[mvn-url]: http://search.maven.org/#browse|-135285720
[mvn-image]: https://img.shields.io/maven-central/v/com.asana/asana.svg
