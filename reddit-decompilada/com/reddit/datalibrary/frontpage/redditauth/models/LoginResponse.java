package com.reddit.datalibrary.frontpage.redditauth.models;

import java.util.List;

public class LoginResponse {
    public static final int ERROR_FIELD = 2;
    public static final int ERROR_MESSAGE = 1;
    public static final int ERROR_NAME = 0;
    private Json json;

    public class Data {
        private String cookie;
        private String modhash;

        public String getCookie() {
            return this.cookie;
        }

        public String getModhash() {
            return this.modhash;
        }
    }

    public class Json {
        private Data data;
        private List<List<String>> errors;

        public Data getData() {
            return this.data;
        }

        public List<List<String>> getErrors() {
            return this.errors;
        }
    }

    public Json getJson() {
        return this.json;
    }
}
