package com.asana;

import com.asana.dispatcher.MockDispatcher;
import junit.framework.TestCase;

public class AsanaTest extends TestCase
{
    protected Client client;
    protected MockDispatcher dispatcher;

    public AsanaTest( String testName )
    {
        super( testName );
    }

    protected void setUp()
    {
        this.dispatcher = new MockDispatcher();
        this.client =  new Client(this.dispatcher);
        this.client.options.put("base_url", "http://app");
    }

}
