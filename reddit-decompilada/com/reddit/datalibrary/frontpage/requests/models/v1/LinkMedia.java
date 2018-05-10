package com.reddit.datalibrary.frontpage.requests.models.v1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.parceler.Parcel;

@Parcel
public class LinkMedia implements Serializable {
    LinkOEmbed oembed;
    @SerializedName(a = "reddit_video")
    @Expose
    RedditVideo redditVideo;

    public LinkMedia(com.reddit.frontpage.domain.model.LinkMedia linkMedia) {
        if (linkMedia.getRedditVideo() == null) {
            linkMedia = null;
        } else {
            linkMedia = new RedditVideo(linkMedia.getRedditVideo());
        }
        this.redditVideo = linkMedia;
    }

    public LinkOEmbed getOEmbed() {
        return this.oembed;
    }

    public RedditVideo getRedditVideo() {
        return this.redditVideo;
    }
}
