package com.reddit.frontpage;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import com.airbnb.deeplinkdispatch.DeepLink;
import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.Crashlytics.Builder;
import com.crashlytics.android.core.CrashlyticsCore;
import com.jakewharton.threetenabp.AndroidThreeTen;
import com.livefront.bridge.Bridge;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveThread;
import com.reddit.frontpage.ui.live.LiveThreadContainerFragment;
import com.reddit.frontpage.util.Util;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.tweetui.TweetUi;
import io.fabric.sdk.android.Fabric;
import java.lang.reflect.Method;
import org.parceler.Parcels;
import timber.log.Timber;

public class LiveThreadActivity extends BaseActivity {
    public final int mo7724d() {
        return C1761R.layout.activity_single_container;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AppConfiguration t = FrontpageSettings.a().t();
        try {
            TwitterCore twitterCore = new TwitterCore(new TwitterAuthConfig("TLCvAmRtFUpYkMMs9FffExvkz", "jszC54upkzun8GI7JWdZ9jl9nb3jB540Ftn0Y1189bDkilfUq7"));
            TweetUi tweetUi = new TweetUi();
            Crashlytics build = new Builder().core(new CrashlyticsCore.Builder().build()).build();
            Fabric a = new Fabric.Builder(FrontpageApplication.f27402a).m26233a(build, twitterCore, tweetUi).m26234a();
            Method declaredMethod = Fabric.class.getDeclaredMethod("a", new Class[]{Fabric.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[]{a});
        } catch (Throwable e) {
            Timber.c(e, e.getMessage(), new Object[0]);
        }
        AndroidThreeTen.a(this);
        if (bundle == null) {
            bundle = getIntent();
            if (!bundle.getBooleanExtra(DeepLink.IS_DEEP_LINK, false)) {
                if (!bundle.hasExtra("live_thread_id")) {
                    if (bundle.hasExtra("live_thread_id_mvp")) {
                        getSupportFragmentManager().a().b(C1761R.id.container, LiveThreadContainerFragment.m39324a(bundle.getStringExtra("live_thread_id_mvp"))).c();
                        return;
                    }
                    getSupportFragmentManager().a().b(C1761R.id.container, LiveThreadContainerFragment.m39323a((LiveThread) Parcels.m28673a(bundle.getParcelableExtra("com.reddit.live_thread")))).c();
                    return;
                }
            }
            String stringExtra = bundle.getStringExtra("live_thread_id");
            if (t.experiments.a().active) {
                getSupportFragmentManager().a().b(C1761R.id.container, LiveThreadContainerFragment.m39324a(stringExtra)).c();
                return;
            }
            Object[] objArr = new Object[1];
            StringBuilder stringBuilder = new StringBuilder("/live/");
            stringBuilder.append(stringExtra);
            objArr[0] = stringBuilder.toString();
            Util.m23973a((RedditThemedActivity) this, Uri.parse(getString(C1761R.string.fmt_permalink_base, objArr)), "live_thread");
            finish();
            return;
        }
        Bridge.a(this, bundle);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
