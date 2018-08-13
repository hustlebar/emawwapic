package com.emaww.apic.core;

import org.apache.http.client.utils.URIBuilder;

import javax.json.Json;
import javax.json.JsonObject;

/**
 * @author tham
 */

public class EmawwClient {
    public JsonObject getSensitivity(String device, String os) {
        URIBuilder builder = new URIBuilder().setScheme(EmawwPath.SCHEME_HTTP)
                .setHost(EmawwPath.sensitivity())
                .addParameter("device", device)
                .addParameter("os", os);

        return invokeGet(builder);
    }

    public JsonObject postSensitivity(JsonObject sensitivity) {
        URIBuilder builder = new URIBuilder().setScheme(EmawwPath.SCHEME_HTTP)
                .setHost(EmawwPath.sensitivity());
        return invokePost(builder, sensitivity);
    }

    public JsonObject postExpressionAnalytics(JsonObject expression) {
        URIBuilder builder = new URIBuilder().setScheme(EmawwPath.SCHEME_HTTP)
                .setHost(EmawwPath.expressionAnalytics());
        return invokePost(builder, expression);
    }

    public JsonObject getExpressionAnalytics(String id) {
        URIBuilder builder = new URIBuilder().setScheme(EmawwPath.SCHEME_HTTP)
                .setHost(EmawwPath.expressionAnalytics())
                .addParameter("expression_id", id);
        return invokeGet(builder);
    }

    public JsonObject postIsEmotion(JsonObject emotion) {
        final URIBuilder builder = new URIBuilder().setScheme(EmawwPath.SCHEME_HTTP)
                .setHost(EmawwPath.isEmotion());

        return invokePost(builder, emotion);
    }

    public JsonObject getIsEmotion(String id) {
        URIBuilder builder = new URIBuilder().setScheme(EmawwPath.SCHEME_HTTP)
                .setHost(EmawwPath.isEmotion())
                .addParameter("expression_id", id);
        return invokeGet(builder);
    }

    public JsonObject postDimensionLevel(JsonObject dimensionLevel) {
        final URIBuilder builder = new URIBuilder().setScheme(EmawwPath.SCHEME_HTTP)
                .setHost(EmawwPath.dimensionLevel());

        return invokePost(builder, dimensionLevel);
    }

    public JsonObject getDimensionLevel(String id) {
        final URIBuilder builder = new URIBuilder().setScheme(EmawwPath.SCHEME_HTTP)
                .setHost(EmawwPath.dimensionLevel())
                .addParameter("expression_id", id);
        return invokeGet(builder);
    }

    private JsonObject invokeGet(URIBuilder builder) {
        JsonObject response = null;

        try {
            response = new EmawwHttpClient().get(builder);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    private JsonObject invokePost(URIBuilder builder, JsonObject payload) {
        JsonObject response = null;
        try {
            response = new EmawwHttpClient().post(builder, payload);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
}
