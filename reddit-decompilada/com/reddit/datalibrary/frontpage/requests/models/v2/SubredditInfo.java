package com.reddit.datalibrary.frontpage.requests.models.v2;

import com.raizlabs.android.dbflow.structure.BaseModel;
import org.parceler.Parcel;

@Parcel
public class SubredditInfo extends BaseModel {
    long _id;
    long accounts_active;
    String banner_img;
    String description;
    String description_html;
    String display_name;
    String display_name_prefixed;
    String icon_img;
    String id;
    boolean is_default;
    String key_color;
    String name;
    boolean over18;
    String subreddit_type;
    long subscribers;
    String url;
    String whitelist_status;
    boolean wiki_enabled;

    public long getDatabaseId() {
        return this._id;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDisplayName() {
        return this.display_name;
    }

    public String getDisplayNamePrefixed() {
        return this.display_name_prefixed;
    }

    public String getSubredditName() {
        return this.display_name;
    }

    public String getIconImage() {
        return this.icon_img;
    }

    public String getKeyColor() {
        return this.key_color;
    }

    public String getUrl() {
        return this.url;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDescriptionHtml() {
        return this.description_html;
    }

    public long getSubscribers() {
        return this.subscribers;
    }

    public long getAccountsActive() {
        return this.accounts_active;
    }

    public String getBannerImage() {
        return this.banner_img;
    }

    public boolean isWikiEnabled() {
        return this.wiki_enabled;
    }

    public boolean isDefault() {
        return this.is_default;
    }

    public boolean isOver18() {
        return this.over18;
    }

    public boolean isNsfw() {
        return this.over18;
    }

    public String getWhitelistStatus() {
        return this.whitelist_status;
    }

    public String getSubredditType() {
        return this.subreddit_type;
    }
}
