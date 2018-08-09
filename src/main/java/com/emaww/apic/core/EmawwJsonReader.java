package com.emaww.apic.core;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.InputStream;

/**
 * @author tham
 */

public class EmawwJsonReader {
    public static JsonObject read(String fileName) {
        final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        final InputStream inputStream = classLoader.getResourceAsStream(fileName);
        return Json.createReader(inputStream).readObject();
    }
}
