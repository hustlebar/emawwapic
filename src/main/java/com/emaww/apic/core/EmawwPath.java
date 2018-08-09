package com.emaww.apic.core;

/**
 * @author tham
 */

public class EmawwPath {
    public static final String SCHEME_HTTP = "http";
    private static final String SLASH = "/";

    private static final String BASE_PATH = "tedapi.emaww.com";
    private static final String SENSITIVITY = "sensitivity";
    private static final String EXPRESSION_ANALYTICS = "expression_analytics";
    private static final String IS_EMOTION = "is_emotion";
    private static final String DIMENSION_LEVEL = "dimension_level";
    private static final String DELETE_EXPRESSION = "delete_expression";

    public static final String sensitivity() {
        return new StringBuilder(BASE_PATH)
                .append(SLASH)
                .append(SENSITIVITY)
                .toString();
    }

    public static final String expressionAnalytics() {
        return new StringBuilder(BASE_PATH)
                .append(SLASH)
                .append(EXPRESSION_ANALYTICS)
                .toString();
    }

    public static final String expressionAnalytics(String id) {
        return new StringBuilder(expressionAnalytics())
                .append(SLASH)
                .append(id)
                .toString();
    }

    private static final String isEmotion() {
        return new StringBuilder(BASE_PATH)
                .append(SLASH)
                .append(IS_EMOTION)
                .toString();
    }

    private static final String isEmotion(String expressionId) {
        return new StringBuilder(isEmotion())
                .append(SLASH)
                .append(expressionId)
                .toString();
    }

    public static final String dimensionLevel() {
        return new StringBuilder(BASE_PATH)
                .append(SLASH)
                .append(DIMENSION_LEVEL)
                .toString();
    }

    public static final String dimensionLevel(String expressionId) {
        return new StringBuilder(dimensionLevel())
                .append(SLASH)
                .append(expressionId)
                .toString();
    }

    public static final String deleteExpression() {
        return new StringBuilder(BASE_PATH)
                .append(SLASH)
                .append(DELETE_EXPRESSION)
                .toString();
    }

    public static final String deleteExpression(String id) {
        return new StringBuilder(deleteExpression())
                .append(SLASH)
                .append(id)
                .toString();
    }
}
