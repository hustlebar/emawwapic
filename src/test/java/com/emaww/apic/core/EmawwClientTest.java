package com.emaww.apic.core;

import org.junit.Test;

/**
 * @author tham
 */

public class EmawwClientTest {
    private static final String DEVICE = "Lge LG-D802";
    public static final String OS = "7.1.2";

    @Test
    public void testSensitivity() {
        new EmawwClient().getSensitivity(DEVICE, OS);
    }
}
