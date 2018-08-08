package com.emaww.apic.core;

import org.apache.http.client.methods.*;
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
        System.out.println("Enters EmawwHttpClient.get()");

        JsonObject responseJson = null;

        HttpGet httpGet = null;
        try {
            httpGet = new HttpGet(builder.build());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        setHeaders(httpGet);

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
        System.out.println("Enters EmawwHttpClient.post()");

        CloseableHttpClient client = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(builder.build());
        setHeaders(httpPost);
        httpPost.setEntity(new StringEntity(payload.toString(), ContentType.APPLICATION_JSON));

        CloseableHttpResponse response = client.execute(httpPost);
        System.out.println("Response code: " + response.getStatusLine().getStatusCode());

        client.close();

        return getJson(response);
    }

    public JsonObject put(URIBuilder builder, JsonObject payload) throws Exception {
        System.out.println("Enters EmawwHttpClient.put()");

        CloseableHttpClient client = HttpClients.createDefault();

        HttpPut httpPut = new HttpPut(builder.build());
        setHeaders(httpPut);
        httpPut.setEntity(new StringEntity(payload.toString(), ContentType.APPLICATION_JSON));

        CloseableHttpResponse response = client.execute(httpPut);
        System.out.println("Response code: " + response.getStatusLine().getStatusCode());

        client.close();

        return getJson(response);
    }

    public JsonObject delete(URIBuilder builder) throws Exception {
        System.out.println("Enters EmawwHttpClient.delete()");
        CloseableHttpClient client = HttpClients.createDefault();
        final HttpDelete httpDelete = new HttpDelete(builder.build());
        setHeaders(httpDelete);

        CloseableHttpResponse response = client.execute(httpDelete);
        System.out.println("Response code: " + response.getStatusLine().getStatusCode());

        client.close();

        return getJson(response);
    }

    private JsonObject getJson(CloseableHttpResponse response) throws Exception {
        InputStream responseStream = response.getEntity().getContent();
        return Json.createReader(responseStream).readObject();
    }

    private void setHeaders(HttpRequestBase httpRequest) {
        httpRequest.addHeader("App-Id", APPID);
        httpRequest.addHeader("App-Key", APPKEY);
    }
}
