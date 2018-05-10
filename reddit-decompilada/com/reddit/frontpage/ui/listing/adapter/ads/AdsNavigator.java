package com.reddit.frontpage.ui.listing.adapter.ads;

import com.reddit.frontpage.domain.model.Link;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\f\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/ui/listing/adapter/ads/AdsNavigator;", "", "()V", "getOutboundUrl", "", "link", "Lcom/reddit/frontpage/domain/model/Link;", "navigateToAdUrl", "", "context", "Landroid/content/Context;", "sourcePage", "shouldNavigateToAdUrl", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AdsNavigator.kt */
public final class AdsNavigator {
    public static String m23453a(Link link) {
        if (!link.getPromoted()) {
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
}
