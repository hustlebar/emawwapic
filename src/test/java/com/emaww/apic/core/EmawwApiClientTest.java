package com.emaww.apic.core;

import org.junit.Test;

import java.net.URISyntaxException;

public class EmawwApiClientTest {
    @Test
    public void testGet() throws URISyntaxException {
        new EmawwApiClient().get();
    }
}
