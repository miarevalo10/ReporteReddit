package com.reddit.datalibrary.frontpage.requests.models.v2;

import org.parceler.Parcel;

@Parcel
public class Banner extends ClientIdentified implements Listable {
    String background_color;
    String deeplink_url;
    String id;
    int min_android_version;
    int num_votes;
    boolean show_right_arrow = true;
    String title_tag;
    String title_tag_icon;
    String title_text;

    public int getListableType() {
        return 4;
    }

    Banner() {
    }

    Banner(long j) {
        super(j);
    }

    public String getId() {
        return this.id;
    }

    public String getTitleText() {
        return this.title_text;
    }

    public String getTitleTag() {
        return this.title_tag;
    }

    public String getDeeplinkUrl() {
        return this.deeplink_url;
    }

    public String getBackgroundColor() {
        return this.background_color;
    }

    public boolean isShowRightArrow() {
        return this.show_right_arrow;
    }

    public int getNumVotes() {
        return this.num_votes;
    }

    public int getMinAndroidVersion() {
        return this.min_android_version;
    }
}
