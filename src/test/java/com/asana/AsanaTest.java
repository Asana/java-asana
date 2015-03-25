package com.asana;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for Client.
 */
public class AsanaTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AsanaTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AsanaTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testClient()
    {
        assertTrue( true );
    }
}
