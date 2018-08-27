package com.emaww.apic.core;

import org.junit.Test;

import javax.json.JsonObject;
import java.util.UUID;

/**
 * @author tham
 */

public class EmawwClientTest {
    private static final String DEVICE = "Lge LG-D802";
    public static final String OS = "7.1.2";

    private static final String EXPRESSION_ID = "e73wYBYys0";
    private static final String ISEMOTION_EXP_ID = "uHcKkzfNBO";

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

    @Test
    public void testPostIsEmotion() {
        final JsonObject isEmotionJson = new EmawwClient().postIsEmotion(
                EmawwJsonReader.read("emotion.json")
        );

        System.out.println(isEmotionJson.toString());
    }

    @Test
    public void testGetIsEmotion() {
        final JsonObject isEmotionJson = new EmawwClient().getIsEmotion(ISEMOTION_EXP_ID);
        System.out.println(isEmotionJson.toString());
    }

    @Test
    public void testAggregation() {
        new EmawwClient().getAggregation();
    }

    @Test
    public void testUUID() {
        System.out.println(UUID.randomUUID().toString());
    }
}
