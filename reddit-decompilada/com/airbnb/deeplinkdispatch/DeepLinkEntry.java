package com.airbnb.deeplinkdispatch;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public final class DeepLinkEntry {
    private static final String PARAM = "([a-zA-Z][a-zA-Z0-9_-]*)";
    private static final Pattern PARAM_PATTERN = Pattern.compile(PARAM_REGEX);
    private static final String PARAM_REGEX = "%7B(([a-zA-Z][a-zA-Z0-9_-]*))%7D";
    private static final String PARAM_VALUE = "([a-zA-Z0-9_#'!+%~,\\-\\.\\@\\$\\:]+)";
    private final Class<?> activityClass;
    private final String method;
    private final Set<String> parameters;
    private final Pattern regex;
    private final Type type;

    public enum Type {
        CLASS,
        METHOD
    }

    public DeepLinkEntry(String str, Type type, Class<?> cls, String str2) {
        str = DeepLinkUri.parse(str);
        String schemeHostAndPath = schemeHostAndPath(str);
        this.type = type;
        this.activityClass = cls;
        this.method = str2;
        this.parameters = parseParameters(str);
        str = new StringBuilder();
        str.append(schemeHostAndPath.replaceAll(PARAM_REGEX, PARAM_VALUE));
        str.append("$");
        this.regex = Pattern.compile(str.toString());
    }

    public final Type getType() {
        return this.type;
    }

    public final Class<?> getActivityClass() {
        return this.activityClass;
    }

    public final String getMethod() {
        return this.method;
    }

    private static Set<String> parseParameters(DeepLinkUri deepLinkUri) {
        Pattern pattern = PARAM_PATTERN;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(deepLinkUri.encodedHost());
        stringBuilder.append(deepLinkUri.encodedPath());
        deepLinkUri = pattern.matcher(stringBuilder.toString());
        Set<String> linkedHashSet = new LinkedHashSet();
        while (deepLinkUri.find()) {
            linkedHashSet.add(deepLinkUri.group(1));
        }
        return linkedHashSet;
    }

    public final Map<String, String> getParameters(String str) {
        Map<String, String> hashMap = new HashMap(this.parameters.size());
        str = this.regex.matcher(schemeHostAndPath(DeepLinkUri.parse(str)));
        if (str.matches()) {
            int i = 1;
            for (String str2 : this.parameters) {
                int i2 = i + 1;
                String group = str.group(i);
                if (!(group == null || "".equals(group.trim()))) {
                    hashMap.put(str2, group);
                }
                i = i2;
            }
        }
        return hashMap;
    }

    private static String parsePath(DeepLinkUri deepLinkUri) {
        return deepLinkUri.encodedPath();
    }

    public final boolean matches(String str) {
        str = DeepLinkUri.parse(str);
        return (str == null || this.regex.matcher(schemeHostAndPath(str)).find() == null) ? null : true;
    }

    private String schemeHostAndPath(DeepLinkUri deepLinkUri) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(deepLinkUri.scheme());
        stringBuilder.append("://");
        stringBuilder.append(deepLinkUri.encodedHost());
        stringBuilder.append(parsePath(deepLinkUri));
        return stringBuilder.toString();
    }
}
