package com.reddit.datalibrary.frontpage.requests.models.v1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.parceler.Parcel;

@Parcel
public class RedditVideo implements Serializable {
    @SerializedName(a = "dash_url")
    @Expose
    String dashUrl;
    @SerializedName(a = "duration")
    @Expose
    int duration;
    @SerializedName(a = "fallback_url")
    @Expose
    String fallbackUrl;
    @SerializedName(a = "height")
    @Expose
    int height;
    @SerializedName(a = "hls_url")
    @Expose
    String hlsUrl;
    @SerializedName(a = "is_gif")
    @Expose
    boolean isGif;
    @SerializedName(a = "scrubber_media_url")
    @Expose
    String scrubberMediaUrl;
    @SerializedName(a = "transcoding_status")
    @Expose
    String transcodingStatus;
    @SerializedName(a = "width")
    @Expose
    int width;

    public RedditVideo(com.reddit.frontpage.domain.model.RedditVideo redditVideo) {
        this.transcodingStatus = redditVideo.getTranscodingStatus();
        this.width = redditVideo.getWidth();
        this.height = redditVideo.getHeight();
        this.duration = redditVideo.getDuration();
        this.fallbackUrl = redditVideo.getFallBackUrl();
        this.hlsUrl = redditVideo.getHlsUrl();
        this.dashUrl = redditVideo.getDashUrl();
        this.scrubberMediaUrl = redditVideo.getScrubbedMediaUrl();
        this.isGif = redditVideo.isGif();
    }

    public String getTranscodingStatus() {
        return this.transcodingStatus;
    }

    public void setTranscodingStatus(String str) {
        this.transcodingStatus = str;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public String getFallbackUrl() {
        return this.fallbackUrl;
    }

    public void setFallbackUrl(String str) {
        this.fallbackUrl = str;
    }

    public String getHlsUrl() {
        return this.hlsUrl;
    }

    public void setHlsUrl(String str) {
        this.hlsUrl = str;
    }

    public String getDashUrl() {
        return this.dashUrl;
    }

    public void setDashUrl(String str) {
        this.dashUrl = str;
    }

    public String getScrubberMediaUrl() {
        return this.scrubberMediaUrl;
    }

    public void setScrubberMediaUrl(String str) {
        this.scrubberMediaUrl = str;
    }

    public boolean isGif() {
        return this.isGif;
    }

    public void setGif(boolean z) {
        this.isGif = z;
    }
}
