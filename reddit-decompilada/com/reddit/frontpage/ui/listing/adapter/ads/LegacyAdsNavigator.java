package com.reddit.frontpage.ui.listing.adapter.ads;

import android.content.Context;
import android.net.Uri;
import com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.util.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0003J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/ui/listing/adapter/ads/LegacyAdsNavigator;", "", "()V", "getOutboundUrl", "", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "navigateToAdUrl", "", "context", "Landroid/content/Context;", "sourcePage", "shouldNavigateToAdUrl", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LegacyAdsNavigator.kt */
public final class LegacyAdsNavigator {
    public static final LegacyAdsNavigator f21349a = new LegacyAdsNavigator();

    private LegacyAdsNavigator() {
    }

    public static final boolean m23457a(Context context, Link link, String str) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(link, "link");
        if (!link.isPromoted()) {
            return false;
        }
        String b = m23459b(link);
        if (b == null) {
            return false;
        }
        Subreddit subredditDetail = link.getSubredditDetail();
        Util.m23967a(Util.m24014d(context), Uri.parse(b), Util.m23951a(context, subredditDetail != null ? subredditDetail.a() : null), link.getName(), str);
        return true;
    }

    public static final boolean m23458a(Link link) {
        Intrinsics.m26847b(link, "link");
        return m23459b(link) != null ? true : null;
    }

    private static final String m23459b(Link link) {
        if (!link.isPromoted()) {
            return null;
        }
        Object obj;
        link = link.getOutboundLink();
        link = link != null ? link.getUrl() : null;
        CharSequence charSequence = (CharSequence) link;
        if (charSequence != null) {
            if (charSequence.length() != 0) {
                obj = null;
                if (obj == null) {
                    return null;
                }
                return link;
            }
        }
        obj = 1;
        if (obj == null) {
            return link;
        }
        return null;
    }

    public static final boolean m23456a(Context context, Link link) {
        return m23457a(context, link, null);
    }
}
