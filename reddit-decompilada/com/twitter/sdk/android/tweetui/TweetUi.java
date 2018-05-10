package com.twitter.sdk.android.tweetui;

import android.os.Handler;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.GuestSessionProvider;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.internal.scribe.DefaultScribeClient;
import com.twitter.sdk.android.core.internal.scribe.EventNamespace;
import com.twitter.sdk.android.core.internal.scribe.ScribeItem;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.concurrency.DependsOn;
import java.util.List;

@DependsOn(a = {TwitterCore.class})
public class TweetUi extends Kit<Boolean> {
    SessionManager<TwitterSession> f30780a;
    GuestSessionProvider f30781b;
    DefaultScribeClient f30782c;
    TweetRepository f30783d;
    public Picasso f30784e;

    public String getIdentifier() {
        return "com.twitter.sdk.android:tweet-ui";
    }

    public String getVersion() {
        return "2.1.1.156";
    }

    protected boolean onPreExecute() {
        super.onPreExecute();
        TwitterCore a = TwitterCore.m31719a();
        TwitterCore.m31720c();
        this.f30780a = a.f30693a;
        this.f30781b = a.m31726d();
        Handler handler = getFabric().f24696d;
        TwitterCore.m31720c();
        this.f30783d = new TweetRepository(handler, a.f30693a);
        return true;
    }

    final void m31788a(EventNamespace... eventNamespaceArr) {
        if (this.f30782c != null) {
            for (int i = 0; i <= 0; i++) {
                EventNamespace eventNamespace = eventNamespaceArr[0];
                this.f30782c.m31752a(eventNamespace);
            }
        }
    }

    final void m31787a(EventNamespace eventNamespace, List<ScribeItem> list) {
        if (this.f30782c != null) {
            this.f30782c.m31751a(eventNamespace, list);
        }
    }

    public static TweetUi m31786a() {
        if (Fabric.m26237a(TweetUi.class) != null) {
            return (TweetUi) Fabric.m26237a(TweetUi.class);
        }
        throw new IllegalStateException("Must start TweetUi Kit in Fabric.with().");
    }

    protected /* synthetic */ Object doInBackground() {
        this.f30784e = Picasso.m25774a(getContext());
        this.f30782c = new DefaultScribeClient(this, "TweetUi", this.f30780a, this.f30781b, getIdManager());
        return Boolean.valueOf(true);
    }
}
