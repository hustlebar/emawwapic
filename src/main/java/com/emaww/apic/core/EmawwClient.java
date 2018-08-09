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

        return new EmawwHttpClient().get(builder);
    }

    public JsonObject postSensitivity(JsonObject payload) {
        JsonObject response = null;

        URIBuilder builder = new URIBuilder().setScheme(EmawwPath.SCHEME_HTTP)
                .setHost(EmawwPath.sensitivity());
        try {
            response = new EmawwHttpClient().post(builder, payload);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    public JsonObject postExpressionAnalytics(JsonObject payload) {
        JsonObject response = null;

        URIBuilder builder = new URIBuilder().setScheme(EmawwPath.SCHEME_HTTP)
                .setHost(EmawwPath.expressionAnalytics());
        try {
            response = new EmawwHttpClient().post(builder, payload);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    public JsonObject getExpressionAnalytics(String id) {
        JsonObject response = null;

        URIBuilder builder = new URIBuilder().setScheme(EmawwPath.SCHEME_HTTP)
                .setHost(EmawwPath.expressionAnalytics())
                .addParameter("expression_id", id);
        try {
            response = new EmawwHttpClient().get(builder);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
}
