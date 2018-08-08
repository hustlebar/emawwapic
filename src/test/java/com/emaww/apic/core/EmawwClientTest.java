package com.emaww.apic.core;

import org.junit.Test;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringReader;

/**
 * @author tham
 */

public class EmawwClientTest {
    private static final String DEVICE = "Lge LG-D802";
    public static final String OS = "7.1.2";

    private static final String PAYLOAD_SENSITIVITY = "{\"expression\":[{\"x\":[-0.29,-0.29,-0.29,-0.29,-0.29,-0.29,0.0,0.27,0.29,0.29],\"y\":[5.88,6.46,6.85,7.05,7.93,8.16,9.68,11.06,11.15,11.15],\"force\":[0.464,0.46,0.46,0.448,0.428,0.428,0.372,0.372,0.132,0.132],\"area\":[0.6,0.6,0.6,0.6,0.567,0.567,0.467,0.467,0.167,0.167],\"date_time\":[1500310246514,1500310246572,1500310246572,1500310246589,1500310246589,1500310246589,1500310246606,1500310246606,1500310246611,1500310246611]}],\"device\":\"Lge LG-D802\",\"os\":\"7.1.2\",\"density\":\"424\"}";

    @Test
    public void testGetSensitivity() {
        final JsonObject sensitivity = new EmawwClient().getSensitivity(DEVICE, OS);
        System.out.println(sensitivity.toString());
    }

    @Test
    public void testPostSensitivity() {
        final JsonObject payload = Json.createReader(new StringReader(PAYLOAD_SENSITIVITY)).readObject();
        final JsonObject response = new EmawwClient().postSensitivity(payload);
        System.out.println(response.toString());
    }
}
