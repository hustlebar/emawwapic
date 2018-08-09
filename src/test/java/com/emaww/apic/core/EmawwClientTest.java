package com.emaww.apic.core;

import org.junit.Test;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.StringReader;

/**
 * @author tham
 */

public class EmawwClientTest {
    private static final String DEVICE = "Lge LG-D802";
    public static final String OS = "7.1.2";

    @Test
    public void testGetSensitivity() {
        final JsonObject sensitivity = new EmawwClient().getSensitivity(DEVICE, OS);
        System.out.println(sensitivity.toString());
    }

    @Test
    public void testPostSensitivity() {
        final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        final InputStream inputStream = classLoader.getResourceAsStream("sensitivity.json");
        final JsonObject payload = Json.createReader(inputStream).readObject();
        final JsonObject response = new EmawwClient().postSensitivity(payload);
        System.out.println(response.toString());
    }
}
