package com.emaww.apic.core;

import org.junit.Test;

import javax.json.JsonObject;

/**
 * @author tham
 */

public class EmawwClientTest {
    private static final String DEVICE = "Lge LG-D802";
    public static final String OS = "7.1.2";

    private static final String EXPRESSION_ID = "e73wYBYys0";

    @Test
    public void testGetSensitivity() {
        final JsonObject sensitivity = new EmawwClient().getSensitivity(DEVICE, OS);
        System.out.println(sensitivity.toString());
    }

    @Test
    public void testPostSensitivity() {
        final JsonObject response = new EmawwClient().postSensitivity(
                EmawwJsonReader.read("sensitivity.json"));
        System.out.println(response.toString());
    }

    @Test
    public void testPostExpressionAnalytics() {
        final JsonObject response = new EmawwClient().postExpressionAnalytics(
                EmawwJsonReader.read("expression_analytics.json"));
        System.out.println(response.toString());
    }

    @Test
    public void testGetExpressionAnalytics() {
        final JsonObject response = new EmawwClient().getExpressionAnalytics(EXPRESSION_ID);
        System.out.println(response.toString());
    }
}
