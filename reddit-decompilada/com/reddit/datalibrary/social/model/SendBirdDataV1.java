package com.reddit.datalibrary.social.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class SendBirdDataV1 {
    @SerializedName(a = "v1")
    private Message v1;

    public static class EmbedData {
        @SerializedName(a = "description")
        private final String description;
        @SerializedName(a = "image")
        private final String image;
        @SerializedName(a = "site_name")
        private final String site_name;
        @SerializedName(a = "title")
        private final String title;
        @SerializedName(a = "url")
        private final String url;

        public EmbedData(String str, String str2, String str3, String str4, String str5) {
            this.url = str;
            this.image = str2;
            this.site_name = str3;
            this.title = str4;
            this.description = str5;
        }

        public String getUrl() {
            return this.url;
        }

        public String getImage() {
            return this.image;
        }

        public String getSiteName() {
            return this.site_name;
        }

        public String getTitle() {
            return this.title;
        }

        public String getDescription() {
            return this.description;
        }
    }

    public static class Message {
        @SerializedName(a = "embed_data")
        private final EmbedData embed_data;
        @SerializedName(a = "hidden")
        private final boolean hidden;
        @SerializedName(a = "message_body")
        private final String message_body;
        @SerializedName(a = "reddit_username")
        private final String reddit_username;
        @SerializedName(a = "snoomoji")
        private final String snoomoji;

        public Message(String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            this.message_body = str;
            this.hidden = z;
            this.reddit_username = str2;
            this.snoomoji = str8;
            this.embed_data = new EmbedData(str3, str4, str5, str6, str7);
        }

        public String getMessageBody() {
            return this.message_body;
        }

        public EmbedData getEmbedData() {
            return this.embed_data;
        }

        public boolean isHidden() {
            return this.hidden;
        }

        public String getRedditUsername() {
            return this.reddit_username;
        }

        public String getSnoomoji() {
            return this.snoomoji;
        }
    }

    public SendBirdDataV1(String str, String str2, boolean z, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.v1 = new Message(str, z, str3, str2, str4, str5, str6, str7, str8);
    }

    public Message getMessage() {
        return this.v1;
    }

    public String toString() {
        return new Gson().b(this);
    }
}
