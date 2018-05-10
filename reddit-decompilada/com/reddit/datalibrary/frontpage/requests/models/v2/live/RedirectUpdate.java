package com.reddit.datalibrary.frontpage.requests.models.v2.live;

import com.google.gson.annotations.SerializedName;

public abstract class RedirectUpdate {

    public static class RedirectPayload {
        @SerializedName(a = "redirect")
        public String link;
    }

    public static class Redirect extends RedirectUpdate {
        public RedirectPayload payload;
    }
}
