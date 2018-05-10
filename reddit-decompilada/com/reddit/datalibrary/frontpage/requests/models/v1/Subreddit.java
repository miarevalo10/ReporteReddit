package com.reddit.datalibrary.frontpage.requests.models.v1;

import com.google.common.base.Optional;
import com.reddit.common.ThingUtil;
import com.reddit.frontpage.domain.model.SubredditDetail;
import com.reddit.frontpage.util.SubredditUtil;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class Subreddit extends BaseThing {
    public final long accounts_active;
    public final String banner_img;
    public final List<CommunityRule> community_rules;
    public final String description;
    public final String description_html;
    public final String display_name;
    public final String display_name_prefixed;
    public final String header_img;
    public final String icon_img;
    public final boolean is_enrolled_in_new_modmail;
    public final String key_color;
    public final boolean over_18;
    public final String public_description;
    public final long subscribers;
    public String title;
    public final String url;
    public final boolean user_is_moderator;
    public final boolean user_is_subscriber;
    public final String whitelist_status;
    public final boolean wiki_enabled;

    public Subreddit(String str, String str2, String str3, String str4, String str5, List<CommunityRule> list, String str6, String str7, long j, long j2, String str8, boolean z, boolean z2, String str9, String str10, boolean z3, boolean z4, boolean z5, String str11) {
        super((byte) 0);
        this.display_name = str;
        this.display_name_prefixed = str2;
        this.icon_img = str3;
        this.key_color = str4;
        this.url = str5;
        this.community_rules = list;
        this.public_description = str6;
        this.header_img = str7;
        this.subscribers = j;
        this.accounts_active = j2;
        this.banner_img = str8;
        this.user_is_subscriber = z;
        this.user_is_moderator = z2;
        this.description = str9;
        this.description_html = str10;
        this.wiki_enabled = z3;
        this.over_18 = z4;
        this.is_enrolled_in_new_modmail = z5;
        this.whitelist_status = str11;
    }

    public Subreddit(SubredditDetail subredditDetail) {
        super(ThingUtil.m8720b(subredditDetail.getKindWithId()), subredditDetail.getKindWithId());
        this.key_color = subredditDetail.getKeyColor();
        this.icon_img = subredditDetail.getIconImage();
        this.user_is_moderator = ((Boolean) Optional.m6897c(subredditDetail.getUserIsModerator()).mo2314a(Boolean.valueOf(false))).booleanValue();
        this.display_name = subredditDetail.getDisplayName();
        this.display_name_prefixed = "";
        this.url = "";
        this.community_rules = new ArrayList();
        this.public_description = "";
        this.header_img = "";
        this.subscribers = 0;
        this.accounts_active = 0;
        this.banner_img = "";
        this.user_is_subscriber = false;
        this.description = "";
        this.description_html = "";
        this.wiki_enabled = false;
        this.over_18 = false;
        this.is_enrolled_in_new_modmail = false;
        this.whitelist_status = "";
    }

    public final String m19808a() {
        return this.key_color;
    }

    public final String m19809b() {
        return this.display_name;
    }

    public final boolean m19810c() {
        return SubredditUtil.a(this.display_name, this.user_is_subscriber).booleanValue();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Subreddit{display_name='");
        stringBuilder.append(this.display_name);
        stringBuilder.append('\'');
        stringBuilder.append(", display_name_prefixed='");
        stringBuilder.append(this.display_name_prefixed);
        stringBuilder.append('\'');
        stringBuilder.append(", icon_img='");
        stringBuilder.append(this.icon_img);
        stringBuilder.append('\'');
        stringBuilder.append(", key_color='");
        stringBuilder.append(this.key_color);
        stringBuilder.append('\'');
        stringBuilder.append(", url='");
        stringBuilder.append(this.url);
        stringBuilder.append('\'');
        stringBuilder.append(", community_rules=");
        stringBuilder.append(this.community_rules);
        stringBuilder.append(", public_description='");
        stringBuilder.append(this.public_description);
        stringBuilder.append('\'');
        stringBuilder.append(", header_img='");
        stringBuilder.append(this.header_img);
        stringBuilder.append('\'');
        stringBuilder.append(", subscribers=");
        stringBuilder.append(this.subscribers);
        stringBuilder.append(", accounts_active=");
        stringBuilder.append(this.accounts_active);
        stringBuilder.append(", banner_img='");
        stringBuilder.append(this.banner_img);
        stringBuilder.append('\'');
        stringBuilder.append(", user_is_subscriber=");
        stringBuilder.append(this.user_is_subscriber);
        stringBuilder.append(", user_is_moderator=");
        stringBuilder.append(this.user_is_moderator);
        stringBuilder.append(", description='");
        stringBuilder.append(this.description);
        stringBuilder.append('\'');
        stringBuilder.append(", description_html='");
        stringBuilder.append(this.description_html);
        stringBuilder.append('\'');
        stringBuilder.append(", wiki_enabled=");
        stringBuilder.append(this.wiki_enabled);
        stringBuilder.append(", over_18=");
        stringBuilder.append(this.over_18);
        stringBuilder.append(", whitelist_status='");
        stringBuilder.append(this.whitelist_status);
        stringBuilder.append('\'');
        stringBuilder.append(", title='");
        stringBuilder.append(this.title);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static Subreddit m19807a(String str, String str2) {
        Subreddit subreddit = r0;
        Subreddit subreddit2 = new Subreddit(str, "r", "", "#24a0ed", ",", null, "", "", 1, 1, "", true, true, "", "", false, true, true, "");
        Subreddit subreddit3 = subreddit;
        subreddit3.m16420b(str2);
        return subreddit3;
    }
}
