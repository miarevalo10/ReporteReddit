package com.reddit.frontpage.debug;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.reddit.data.events.Analytics;
import com.reddit.data.events.models.AnalyticsSession;
import com.reddit.data.events.models.Event.Builder;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v2.DummyEventBuilder;
import com.reddit.frontpage.util.NotificationUtil;
import com.reddit.frontpage.util.Platform;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public class DebugActivity extends ListActivity {
    private final List<DebugItem> f20143a = new ArrayList();

    class C17831 implements Runnable {
        int f20136a;
        final /* synthetic */ DebugActivity f20137b;
        private final String[] f20138c = new String[]{"https://www.reddit.com/r/Games/comments/5p3squ/strafe_release_date_announcement_march_28th/", "https://www.reddit.com/r/Games/comments/5p3squ/strafe_release_date_announcement_march_28th/dco87v9/", "https://www.reddit.com/r/Games/comments/5p3squ/strafe_release_date_announcement_march_28th/dcolnk9/?context=3", "https://www.reddit.com/message/messages/7hnn6o"};

        C17831(DebugActivity debugActivity) {
            this.f20137b = debugActivity;
        }

        public void run() {
            NotificationUtil.m23852a("Test notification", this.f20138c[this.f20136a], this.f20138c[this.f20136a]);
            this.f20136a = (this.f20136a + 1) % this.f20138c.length;
        }
    }

    private class DebugItem {
        String f20139a;
        Runnable f20140b;
        final /* synthetic */ DebugActivity f20141c;

        DebugItem(DebugActivity debugActivity, String str, Runnable runnable) {
            this.f20141c = debugActivity;
            this.f20139a = str;
            this.f20140b = runnable;
        }

        public String toString() {
            return this.f20139a;
        }
    }

    private class DebugListAdapter extends ArrayAdapter<DebugItem> {
        final /* synthetic */ DebugActivity f20142a;

        DebugListAdapter(DebugActivity debugActivity, Context context) {
            this.f20142a = debugActivity;
            super(context, 17367043);
            addAll(debugActivity.f20143a);
        }
    }

    public DebugActivity() {
        this.f20143a.add(new DebugItem(this, "Clear Event Log Buffer", new DebugActivity$$Lambda$0(this)));
        this.f20143a.add(new DebugItem(this, "Flush Event Log Buffer", new DebugActivity$$Lambda$1(this)));
        this.f20143a.add(new DebugItem(this, "time.com", new DebugActivity$$Lambda$2(this)));
        this.f20143a.add(new DebugItem(this, "Bust Token", DebugActivity$$Lambda$3.f20129a));
        this.f20143a.add(new DebugItem(this, "Video Player", new DebugActivity$$Lambda$4(this)));
        this.f20143a.add(new DebugItem(this, "Mark Introduction Unseen", DebugActivity$$Lambda$5.f20131a));
        this.f20143a.add(new DebugItem(this, "Show Snackbar", new DebugActivity$$Lambda$6(this)));
        this.f20143a.add(new DebugItem(this, "Show Community Error", new DebugActivity$$Lambda$7(this)));
        this.f20143a.add(new DebugItem(this, "Show Progress Dialog", new DebugActivity$$Lambda$8(this)));
        this.f20143a.add(new DebugItem(this, "Send Test Notification", new C17831(this)));
        this.f20143a.add(new DebugItem(this, "Toggle Test Upcoming Event in Carousel", new DebugActivity$$Lambda$9(this)));
        this.f20143a.add(new DebugItem(this, "Toggle Video Player", new DebugActivity$$Lambda$10(this)));
        this.f20143a.add(new DebugItem(this, "Send Dummy V2 Event", DebugActivity$$Lambda$11.f20123a));
        this.f20143a.add(new DebugItem(this, "Launch onboarding", new DebugActivity$$Lambda$12(this)));
        this.f20143a.add(new DebugItem(this, "Test Live Thread", new DebugActivity$$Lambda$13(this)));
        this.f20143a.add(new DebugItem(this, "Test Chat Connection", new DebugActivity$$Lambda$14(this)));
    }

    static final /* synthetic */ void m21981c() {
        SessionManager b = SessionManager.b();
        b.a(b.c);
    }

    static final /* synthetic */ void m21979a() {
        DummyEventBuilder l = AppAnalytics.m21875l();
        String str = "dummysource";
        Intrinsics.m26847b(str, "source");
        l.builder.source(str);
        str = "dummyaction";
        Intrinsics.m26847b(str, "action");
        l.builder.action(str);
        str = "dummynoun";
        Intrinsics.m26847b(str, "noun");
        l.builder.noun(str);
        Analytics analytics = Analytics.a;
        Builder builder = l.builder;
        Object b = SessionManager.b();
        Intrinsics.m26843a(b, "SessionManager.getInstance()");
        b = b.c;
        Intrinsics.m26843a(b, "SessionManager.getInstance().activeSession");
        Analytics.a(builder, (AnalyticsSession) b, Platform.f29397a);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setListAdapter(new DebugListAdapter(this, this));
    }

    protected void onListItemClick(ListView listView, View view, int i, long j) {
        super.onListItemClick(listView, view, i, j);
        ((DebugItem) this.f20143a.get(i)).f20140b.run();
    }
}
