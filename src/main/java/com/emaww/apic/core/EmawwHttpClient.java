package com.emaww.apic.core;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

/**
 * @author tham
 */

public class EmawwHttpClient {
    private static final String APPID = "22198024";
    private static final String APPKEY = "MjQtemFydWIya0BnbWFpbC5jb20tMTUxOTY1NTczMQ==";

    public JsonObject get(URIBuilder builder) {
        JsonObject responseJson = null;

        HttpGet httpGet = null;
        try {
            httpGet = new HttpGet(builder.build());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        httpGet.addHeader("App-Id", APPID);
        httpGet.addHeader("App-Key", APPKEY);

        CloseableHttpResponse response = null;
        InputStream responseStream = null;
        try {
            response = HttpClients.createDefault().execute(httpGet);
            System.out.println("Response code: " + response.getStatusLine().getStatusCode());

            responseStream = response.getEntity().getContent();
            responseJson = Json.createReader(responseStream).readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (responseStream != null) {
                    responseStream.close();
                }

                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return responseJson;
    }

    public JsonObject post(URIBuilder builder, JsonObject payload) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(builder.build());
        httpPost.addHeader("App-Id", APPID);
        httpPost.addHeader("App-Key", APPKEY);

        httpPost.setEntity(new StringEntity(payload.toString(), ContentType.APPLICATION_JSON));
        CloseableHttpResponse response = client.execute(httpPost);
        System.out.println("Response code: " + response.getStatusLine().getStatusCode());

        InputStream responseStream = response.getEntity().getContent();
        JsonObject responseJson = Json.createReader(responseStream).readObject();
        client.close();

        return responseJson;
    }
}
