package com.reddit.datalibrary.frontpage.requests.models.v2;

public class SendBirdConfig {
    public final int max_message_length;
    public final String proxy_host;

    public SendBirdConfig(String str, int i) {
        this.proxy_host = str;
        this.max_message_length = i;
    }
}
