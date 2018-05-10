package com.reddit.frontpage.ui.search;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.util.Util;

final /* synthetic */ class CombinedSearchResultScreen$SubredditResultAdapter$$Lambda$0 implements OnClickListener {
    private final SubredditResultAdapter f21586a;
    private final Account f21587b;
    private final Subreddit f21588c;

    CombinedSearchResultScreen$SubredditResultAdapter$$Lambda$0(SubredditResultAdapter subredditResultAdapter, Account account, Subreddit subreddit) {
        this.f21586a = subredditResultAdapter;
        this.f21587b = account;
        this.f21588c = subreddit;
    }

    public final void onClick(View view) {
        SubredditResultAdapter subredditResultAdapter = this.f21586a;
        Account account = this.f21587b;
        Subreddit subreddit = this.f21588c;
        if (account == null) {
            Object obj = 1;
            if (!subreddit.c()) {
                if (!subreddit.user_is_moderator) {
                    if (TextUtils.isEmpty(subreddit.description) || subreddit.subscribers == 0) {
                        obj = null;
                    }
                }
            }
            if (obj != null) {
                CombinedSearchResultScreen combinedSearchResultScreen = subredditResultAdapter.f29286a;
                String id = subreddit.getId();
                String name = subreddit.getName();
                String str = subreddit.display_name;
                String str2 = subreddit.display_name_prefixed;
                String str3 = subreddit.icon_img;
                String str4 = subreddit.key_color;
                String str5 = subreddit.banner_img;
                String str6 = subreddit.header_img;
                String str7 = subreddit.title;
                String str8 = subreddit.description;
                String str9 = subreddit.description_html;
                String str10 = subreddit.public_description;
                CombinedSearchResultScreen combinedSearchResultScreen2 = combinedSearchResultScreen;
                long j = subreddit.subscribers;
                String str11 = subreddit.url;
                boolean z = subreddit.over_18;
                String str12 = str9;
                String str13 = str8;
                String str14 = str12;
                String str15 = str10;
                long j2 = j;
                String str16 = str11;
                boolean z2 = z;
                combinedSearchResultScreen = combinedSearchResultScreen2;
                Routing.m22623a((Screen) combinedSearchResultScreen, Nav.m22544a(new com.reddit.frontpage.domain.model.Subreddit(id, name, str, str2, str3, str4, str5, str6, str7, str13, str14, str15, "", j2, Long.valueOf(subreddit.accounts_active), subreddit.getCreatedUtc(), "", str16, z2, Boolean.valueOf(subreddit.wiki_enabled), subreddit.whitelist_status, Boolean.valueOf(subreddit.is_enrolled_in_new_modmail), "any", Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(subreddit.user_is_moderator), Boolean.valueOf(subreddit.user_is_subscriber), Boolean.valueOf(false))));
                return;
            }
            Routing.m22623a((Screen) subredditResultAdapter.f29286a, Nav.m22566b(subreddit.display_name));
        } else if (!Util.m24041k(account.getName())) {
            Routing.m22623a((Screen) subredditResultAdapter.f29286a, Nav.m22594j(account.getName()));
        }
    }
}
