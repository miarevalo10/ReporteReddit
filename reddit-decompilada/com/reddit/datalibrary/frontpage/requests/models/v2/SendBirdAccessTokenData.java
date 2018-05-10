package com.reddit.datalibrary.frontpage.requests.models.v2;

public class SendBirdAccessTokenData {
    public final String sb_access_token;
    public final long valid_until;

    public SendBirdAccessTokenData(long j, String str) {
        this.valid_until = j;
        this.sb_access_token = str;
    }
}
