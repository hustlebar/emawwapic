package com.emaww.apic.core;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.*;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

public class EmawwApiClient {
    public void get() {
//        HttpHost targetHost = new HttpHost("tedapi.emaww.com/sensitivity?device=Lge LG-D802&os=7.1.2", 80, "http");
//        CredentialsProvider credsProvider = new BasicCredentialsProvider();
//        credsProvider.setCredentials(AuthScope.ANY,
//                new UsernamePasswordCredentials("system", "manager"));
//
//        AuthCache authCache = new BasicAuthCache();
//        authCache.put(targetHost, new BasicScheme());
//
//        // Add AuthCache to the execution context
//        final HttpClientContext context = HttpClientContext.create();
//        context.setCredentialsProvider(credsProvider);
//        context.setAuthCache(authCache);
//
//        CloseableHttpClient client = HttpClientBuilder.create().build();
        CloseableHttpClient client = HttpClients.createDefault();

        URIBuilder builder = new URIBuilder().setScheme("http")
                .setHost("tedapi.emaww.com/sensitivity")
                .addParameter("device", "Lge LG-D802")
                .addParameter("os", "7.1.2");

        HttpGet httpGet = null;
        try {
            httpGet = new HttpGet(builder.build());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        httpGet.addHeader("App-Id", "22198024");
        httpGet.addHeader("App-Key", "MjQtemFydWIya0BnbWFpbC5jb20tMTUxOTY1NTczMQ==");

        CloseableHttpResponse response = null;
        InputStream responseStream = null;
        try {
//            response = client.execute(httpGet, context);
            response = client.execute(httpGet);
            System.out.println(response.getStatusLine().getStatusCode());

            responseStream = response.getEntity().getContent();
            JsonObject sensitiveJson = Json.createReader(responseStream).readObject();
            System.out.println(sensitiveJson);
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
    }
}
