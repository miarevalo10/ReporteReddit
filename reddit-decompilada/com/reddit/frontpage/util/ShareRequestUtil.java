package com.reddit.frontpage.util;

import android.content.Context;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.view.View;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.ShareOnUpvote;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.AppAnalytics.ShareEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v1.ShareEvent;
import timber.log.Timber;

public class ShareRequestUtil {
    public static void m23901a(View view, String str, String str2, String str3, ShareEventBuilder shareEventBuilder) {
        if (str2 == null) {
            Timber.e("ShareRequestUtil.promptShareLink() called with a null link", new Object[0]);
            return;
        }
        ShareOnUpvote shareOnUpvote = FrontpageSettings.a().t().experiments.upvote_toast;
        if (Uri.parse(str2).getHost() == null) {
            str2 = Util.m23960a((int) C1761R.string.fmt_permalink_base, str2);
        }
        str2 = LinkUtil.m23778a(str2);
        str = Util.m23960a((int) C1761R.string.share_post_link, str, str2, shareOnUpvote.link_copy, shareOnUpvote.link);
        str2 = view.getContext();
        view = Snackbar.a(view, shareOnUpvote.copy, 0);
        view.a(C1761R.string.action_share, new ShareRequestUtil$$Lambda$0(str2, str, shareEventBuilder));
        view.a();
        view = AppAnalytics.m21864c();
        view.f20004a = "upvote_share";
        view.f20005b = str3;
        view.m21846a();
    }

    static final /* synthetic */ void m23900a(Context context, String str, ShareEventBuilder shareEventBuilder) {
        context.startActivity(IntentUtil.m23746a(context, str));
        shareEventBuilder.f20002l = ShareEvent.SOURCE_UPVOTE_TOAST;
        shareEventBuilder.m21837a();
    }
}
