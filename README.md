java-asana
==========

Java client library for Asana.

![Build Status](https://api.travis-ci.org/Asana/java-asana.svg)

Authentication
--------------

### Basic Auth

Create a client using your Asana API key:

    Client client = Client.basicAuth("ASANA_API_KEY");

### OAuth 2

Asana supports OAuth 2. `java-asana` handles some of the details of the OAuth flow for you.

Create a client using your OAuth Client ID and secret:

    Client client = Client.oauth(
        "ASANA_CLIENT_ID"
        "ASANA_CLIENT_SECRET"
        "urn:ietf:wg:oauth:2.0:oob"
    );

Redirect the user to the authorization URL obtained from the client's `session` object:
    
    OAuthDispatcher dispatcher = (OAuthDispatcher)client.dispatcher;
    String url = dispatcher.getAuthorizationUrl()

`getAuthorizationUrl()` takes an optional state parameter to be used for preventing CSRF attacks:
    
    String state = UUID.randomUUID().toString();
    String url = dispatcher.getAuthorizationUrl(state);

When the user is redirected back to your callback, check the `state` URL parameter matches, then pass the `code` parameter to obtain a bearer token:

    if (request.param("state").equals(state)) {
      String token = dispatcher.fetchToken(request.params("code"));
      // ... 
    } else {
      // error! possible CSRF attack
    }

Note: if you're writing a non-browser-based application (e.x. a command line tool) you can use the special redirect URI `urn:ietf:wg:oauth:2.0:oob` to prompt the user to copy and paste the code into the application.

Usage
-----

The client's methods are divided into several resources: `attachments`, `events`, `projects`, `stories`, `tags`, `tasks`, `teams`, `users`, and `workspaces`.

Request methods use the "builder" pattern to set query string or JSON body parameters, and various request options, so a request must be initated using the `execute` or `executeRaw` methods:

Methods that return a single object return that object directly:

    User me = client.users.me().execute();
    System.out.println("Hello " + name.name);

    String workspaceId = me.workspaces.get(0).id;
    Project project = client.projects.createInWorkspace(workspaceId)
        .data("name", "new project")
        .execute();
    System.out.println("Created project with id: " + project.id);

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
