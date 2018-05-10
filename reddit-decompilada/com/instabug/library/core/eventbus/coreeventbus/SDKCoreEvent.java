package com.instabug.library.core.eventbus.coreeventbus;

public class SDKCoreEvent {
    private String type;
    private String value;

    public static class Feature {
        public static final String TYPE_FEATURES = "features";
        public static final String VALUE_FETCHED = "fetched";
    }

    public static class Invocation {
        public static final String TYPE_INVOCATION = "invocation";
        public static final String VALUE_DISMISSED = "dismissed";
        public static final String VALUE_INVOKED = "invoked";
    }

    public static class Network {
        public static final String TYPE_NETWORK = "network";
        public static final String VALUE_ACTIVATED = "activated";
    }

    public static class Session {
        public static final String TYPE_SESSION = "session";
        public static final String VALUE_FINISHED = "finished";
        public static final String VALUE_STARTED = "started";
    }

    public static class User {
        public static final String TYPE_USER = "user";
        public static final String VALUE_LOGGED_IN = "logged_in";
        public static final String VALUE_LOGGED_OUT = "logged_out";
    }

    public SDKCoreEvent(String str, String str2) {
        this.type = str;
        this.value = str2;
    }

    public String getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("type: ");
        stringBuilder.append(this.type);
        stringBuilder.append(", value: ");
        stringBuilder.append(this.value);
        return stringBuilder.toString();
    }
}
