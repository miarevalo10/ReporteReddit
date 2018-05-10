package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class MediaEntity extends UrlEntity {
    @SerializedName(a = "id")
    public final long f34646b;
    @SerializedName(a = "media_url_https")
    public final String f34647c;
    @SerializedName(a = "sizes")
    public final Sizes f34648d;
    @SerializedName(a = "type")
    public final String f34649e;
    @SerializedName(a = "video_info")
    public final VideoInfo f34650f;
    @SerializedName(a = "ext_alt_text")
    public final String f34651g;

    public static class Size implements Serializable {
        @SerializedName(a = "w")
        public final int f24032a;
        @SerializedName(a = "h")
        public final int f24033b;
    }

    public static class Sizes implements Serializable {
        @SerializedName(a = "medium")
        public final Size f24034a;
    }
}
