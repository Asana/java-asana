package com.asana;

import com.asana.dispatcher.MockDispatcher;
import com.google.gson.JsonParser;
import org.junit.Before;

public class AsanaTest
{
    protected Client client;
    protected MockDispatcher dispatcher;
    protected JsonParser parser;

    @Before
    public void setUp()
    {
        this.parser = new JsonParser();
        this.dispatcher = new MockDispatcher();
        this.client =  new Client(this.dispatcher);
        this.client.options.put("base_url", "http://app");
    }

}
