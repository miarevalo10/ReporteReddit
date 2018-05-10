package com.instabug.library.network;

public class RequestResponse {
    private Object responseBody;
    private int responseCode;

    public int getResponseCode() {
        return this.responseCode;
    }

    public RequestResponse setResponseCode(int i) {
        this.responseCode = i;
        return this;
    }

    public Object getResponseBody() {
        return this.responseBody;
    }

    public RequestResponse setResponseBody(Object obj) {
        this.responseBody = obj;
        return this;
    }
}
