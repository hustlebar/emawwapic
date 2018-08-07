package com.emaww.apic.core;

import org.apache.http.client.utils.URIBuilder;

import javax.json.JsonObject;

/**
 * @author tham
 */

public class EmawwClient {
    public void getSensitivity(String device, String os) {
        URIBuilder builder = new URIBuilder().setScheme(EmawwPath.SCHEME_HTTP)
                .setHost(EmawwPath.getSensitivity())
                .addParameter("device", device)
                .addParameter("os", os);

        final JsonObject sensitivityJson = new EmawwHttpClient().get(builder);
        System.out.println(sensitivityJson.toString());
    }

    public void postSensitivity(JsonObject payload) {
        URIBuilder builder = new URIBuilder().setScheme(EmawwPath.SCHEME_HTTP)
                .setHost(EmawwPath.getSensitivity());
        try {
            new EmawwHttpClient().post(builder, payload);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
