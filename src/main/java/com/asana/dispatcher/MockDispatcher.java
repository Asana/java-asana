package com.asana.dispatcher;

import com.google.api.client.http.*;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MockDispatcher extends Dispatcher {
    public class Call
    {
        public LowLevelHttpRequest request;
        public LowLevelHttpResponse response;
        public String requestBody;
        public JsonElement parsedRequestBody;

        public Call(LowLevelHttpRequest request, LowLevelHttpResponse response, String requestBody)
        {
            this.request = request;
            this.response = response;
            this.requestBody = requestBody;
            try {
                this.parsedRequestBody = new JsonParser().parse(requestBody);
            } catch (Exception e) {
            }
        }
    }

    private HttpTransport transport;
    private HashMap<String,MockLowLevelHttpResponse> responses;
    public ArrayList<Call> calls;

    public MockDispatcher()
    {
        this.calls = new ArrayList<Call>();
        this.responses = new HashMap<String,MockLowLevelHttpResponse>();

        this.transport = new MockHttpTransport() {
            @Override
            public LowLevelHttpRequest buildRequest(final String method, final String url) throws IOException {
                return new MockLowLevelHttpRequest() {
                    @Override
                    public LowLevelHttpResponse execute() throws IOException {
                        String key = method + ":" + url;
                        if (responses.containsKey(key)) {
                            LowLevelHttpResponse response = responses.get(key);

                            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                            if (this.getStreamingContent() != null) {
                                this.getStreamingContent().writeTo(buffer);
                            }
                            calls.add(new Call(this, response, buffer.toString()));

                            return response;
                        } else {
                            throw new IOException("No response registered for " + key);
                        }
                    }
                };
            }
        };
    }

    public HttpRequest buildRequest(String method, GenericUrl url, ByteArrayContent content) throws IOException
    {
        return this.transport.createRequestFactory().buildRequest(method, url, content);
    }

    public MockLowLevelHttpResponse registerResponse(String method, String path, int status) {
        return this.registerResponse(method, path, status, null);
    }

    public MockLowLevelHttpResponse registerResponse(String method, String path, int status, String content) {
        MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
        response.setStatusCode(status);
        if (content != null) {
            response.setContent(content);
        }
        responses.put(method + ":" + path, response);
        return response;
    }
}
