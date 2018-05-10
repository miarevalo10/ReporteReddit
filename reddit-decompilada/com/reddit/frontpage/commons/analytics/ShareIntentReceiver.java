package com.reddit.frontpage.commons.analytics;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.reddit.data.events.models.components.Share.Builder;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.frontpage.commons.analytics.events.v1.BaseEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ShareEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ShareEvent.SharePayload;
import com.reddit.frontpage.commons.analytics.events.v2.ShareEventBuilder;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

public class ShareIntentReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        context = intent.getExtras().get("android.intent.extra.CHOSEN_COMPONENT");
        context = (context instanceof ComponentName) != null ? ((ComponentName) context).getPackageName() : null;
        if (InternalSettings.a().h() != null) {
            int i;
            BaseEvent shareEvent;
            SharePayload sharePayload;
            intent = AppAnalytics.m21868e();
            SharePayload sharePayload2 = (SharePayload) InternalSettings.a().h().payload;
            intent.f19991a = sharePayload2.action;
            intent.f19992b = sharePayload2.screen_name;
            intent.f19993c = sharePayload2.compact_view;
            intent.f19994d = sharePayload2.nightmode;
            intent.f19995e = sharePayload2.target_url;
            intent.f19996f = sharePayload2.target_fullname;
            intent.f19997g = sharePayload2.target_type;
            intent.f19998h = sharePayload2.target_url_domain;
            intent.f19999i = sharePayload2.target_title;
            intent.f20000j = sharePayload2.sr_name;
            intent.f20001k = sharePayload2.sr_id;
            intent.f20002l = sharePayload2.source;
            intent.f19991a = context;
            if (!TextUtils.isEmpty(intent.f19992b)) {
                if (!TextUtils.isEmpty(intent.f19991a)) {
                    i = 0;
                    if (i != 0) {
                        Timber.e(String.format("Invalid click event: screenName(%s) action(%s)", new Object[]{intent.f19992b, intent.f19991a}), new Object[0]);
                    }
                    shareEvent = new ShareEvent(intent.f19992b);
                    sharePayload = (SharePayload) shareEvent.payload;
                    sharePayload.action = intent.f19991a;
                    sharePayload.screen_name = intent.f19992b;
                    sharePayload.compact_view = intent.f19993c;
                    sharePayload.nightmode = intent.f19994d;
                    sharePayload.target_url = intent.f19995e;
                    sharePayload.target_fullname = intent.f19996f;
                    sharePayload.target_type = intent.f19997g;
                    sharePayload.target_url_domain = intent.f19998h;
                    sharePayload.target_title = intent.f19999i;
                    sharePayload.sr_name = intent.f20000j;
                    sharePayload.sr_id = intent.f20001k;
                    sharePayload.source = intent.f20002l;
                    AppAnalytics.m21852a(shareEvent);
                    InternalSettings.a().a.edit().remove("com.reddit.frontpage.share_event").apply();
                }
            }
            i = 1;
            if (i != 0) {
                Timber.e(String.format("Invalid click event: screenName(%s) action(%s)", new Object[]{intent.f19992b, intent.f19991a}), new Object[0]);
            }
            shareEvent = new ShareEvent(intent.f19992b);
            sharePayload = (SharePayload) shareEvent.payload;
            sharePayload.action = intent.f19991a;
            sharePayload.screen_name = intent.f19992b;
            sharePayload.compact_view = intent.f19993c;
            sharePayload.nightmode = intent.f19994d;
            sharePayload.target_url = intent.f19995e;
            sharePayload.target_fullname = intent.f19996f;
            sharePayload.target_type = intent.f19997g;
            sharePayload.target_url_domain = intent.f19998h;
            sharePayload.target_title = intent.f19999i;
            sharePayload.sr_name = intent.f20000j;
            sharePayload.sr_id = intent.f20001k;
            sharePayload.source = intent.f20002l;
            AppAnalytics.m21852a(shareEvent);
            InternalSettings.a().a.edit().remove("com.reddit.frontpage.share_event").apply();
        }
        intent = ShareEventBuilder.m21934c();
        if (intent != null) {
            Intrinsics.m26847b(context, "app");
            intent.builder.share(new Builder().target(context).build());
            intent.m21944a();
            ShareEventBuilder.m21935d();
        }
    }
}
