package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class VideoInfo implements Serializable {
    @SerializedName(a = "duration_millis")
    public final long f24113a;
    @SerializedName(a = "variants")
    public final List<Variant> f24114b;

    public static class Variant implements Serializable {
        @SerializedName(a = "content_type")
        public final String f24111a;
        @SerializedName(a = "url")
        public final String f24112b;
    }
}
