package com.asana.dispatcher;

import com.google.api.client.http.*;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.common.base.Joiner;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class MockDispatcher extends Dispatcher {
    public class Call {
        public LowLevelHttpRequest request;
        public LowLevelHttpResponse response;
        public String requestBody;
        public JsonElement parsedRequestBody;

        public Call(LowLevelHttpRequest request, LowLevelHttpResponse response, String requestBody) {
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
    private HashMap<String, LinkedList<MockLowLevelHttpResponse>> responses;
    public ArrayList<Call> calls;
    public ArrayList<Integer> sleepCalls;

    public MockDispatcher() {
        this.calls = new ArrayList<Call>();
        this.sleepCalls = new ArrayList<Integer>();
        this.responses = new HashMap<String, LinkedList<MockLowLevelHttpResponse>>();

        this.transport = new MockHttpTransport() {
            @Override
            public LowLevelHttpRequest buildRequest(final String method, final String url) throws IOException {
                return new MockLowLevelHttpRequest() {
                    @Override
                    public LowLevelHttpResponse execute() throws IOException {
                        String key = formatRequestKey(method, url);
                        if (responses.containsKey(key) && responses.get(key).size() > 0) {
                            LowLevelHttpResponse response = responses.get(key).removeFirst();

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

    public HttpRequest buildRequest(String method, GenericUrl url, HttpContent content) throws IOException {
        return this.transport.createRequestFactory().buildRequest(method, url, content);
    }

    public void sleep(long millis) {
        this.sleepCalls.add(new Integer((int) millis));
    }

    public MockHttpResponse registerResponse(String method, String path) {
        MockHttpResponse response = new MockHttpResponse();

        String key = formatRequestKey(method, path);
        if (!responses.containsKey(key)) {
            responses.put(key, new LinkedList<MockLowLevelHttpResponse>());
        }
        responses.get(key).add(response);

        return response;
    }

    public class MockHttpResponse extends MockLowLevelHttpResponse {
        public MockHttpResponse code(int statusCode) {
            return (MockHttpResponse) super.setStatusCode(statusCode);
        }

        public MockHttpResponse content(String content) {
            return (MockHttpResponse) super.setContent(content);
        }

        public MockHttpResponse header(String name, String value) {
            return (MockHttpResponse) super.addHeader(name, value);
        }
    }

    private String formatRequestKey(String method, String path) {
        String[] components = path.split("\\?");
        String result = method + ":" + components[0];
        if (components.length == 2 && components[1].length() > 0) {
            String[] params = components[1].split("&");
            Arrays.sort(params);
            result += "?" + Joiner.on("&").join(params);
        }
        return result;
    }
}
