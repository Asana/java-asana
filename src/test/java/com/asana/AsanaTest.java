package com.asana;

import com.asana.dispatcher.MockDispatcher;
import org.junit.Before;

public class AsanaTest
{
    protected Client client;
    protected MockDispatcher dispatcher;

    @Before
    public void setUp()
    {
        this.dispatcher = new MockDispatcher();
        this.client =  new Client(this.dispatcher);
        this.client.options.put("base_url", "http://app");
    }

}
