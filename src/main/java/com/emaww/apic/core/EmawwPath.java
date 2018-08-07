package com.emaww.apic.core;

/**
 * @author tham
 */

public class EmawwPath {
    public static final String SCHEME_HTTP = "http";
    private static final String SLASH = "/";

    private static final String BASE_PATH = "tedapi.emaww.com";
    private static final String SENSITIVITY = "sensitivity";

    public static final String getSensitivity() {
        return new StringBuilder(BASE_PATH)
                .append(SLASH)
                .append(SENSITIVITY)
                .toString();
    }
}
