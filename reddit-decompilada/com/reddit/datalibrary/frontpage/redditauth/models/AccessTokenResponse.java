package com.reddit.datalibrary.frontpage.redditauth.models;

public class AccessTokenResponse {
    private static final int DEFAULT_EXPIRES_IN = 3600;
    private String access_token;
    private long expires_in = 3600;
    private String refresh_token;

    public String getAccessToken() {
        return this.access_token;
    }

    public String getRefreshToken() {
        return this.refresh_token;
    }

    public long getExpiresIn() {
        return this.expires_in;
    }
}
