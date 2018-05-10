package com.reddit.datalibrary.frontpage.requests.models.v1;

import java.io.Serializable;
import org.parceler.Parcel;

@Parcel
public class LinkOEmbed implements Serializable {
    String thumbnail_url;

    public String getThumbnailUrl() {
        return this.thumbnail_url;
    }
}
