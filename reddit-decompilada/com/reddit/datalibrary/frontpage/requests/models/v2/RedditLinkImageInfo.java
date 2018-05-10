package com.reddit.datalibrary.frontpage.requests.models.v2;

import com.reddit.datalibrary.frontpage.requests.models.v1.ImageResolution;

public class RedditLinkImageInfo {
    private ImageResolution gif;
    private ImageResolution mp4;
    private ImageResolution nsfw;
    private ImageResolution source;

    public RedditLinkImageInfo(ImageResolution imageResolution, ImageResolution imageResolution2, ImageResolution imageResolution3, ImageResolution imageResolution4) {
        this.source = imageResolution;
        this.nsfw = imageResolution2;
        this.gif = imageResolution3;
        this.mp4 = imageResolution4;
    }

    public final String m21640a() {
        return this.source == null ? null : this.source.getUrl();
    }

    public final String m21641b() {
        return this.gif == null ? null : this.gif.getUrl();
    }

    public final String m21642c() {
        return this.mp4 == null ? null : this.mp4.getUrl();
    }
}
