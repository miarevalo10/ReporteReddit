package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.provider.SubscribedSubredditProvider.SubscribedSubredditLoadEvent;
import com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.RecentSubreddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.SubredditInfo;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.submit.search.SubredditData;
import com.reddit.frontpage.ui.submit.search.SubredditDivider;
import com.reddit.frontpage.ui.submit.search.SubredditSelectData;
import com.reddit.frontpage.util.PromoterUtil;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.util.Util;
import de.greenrobot.event.EventBus;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import timber.log.Timber;

public class SubredditSelectDataProvider {
    public LoaderProvider<RecentSubreddit> f10800a;
    public SubscribedSubredditProvider f10801b;
    public boolean f10802c;
    public boolean f10803d;
    public int f10804e;
    public int f10805f;
    public final PublishSubject<List<SubredditSelectData>> f10806g = PublishSubject.create();

    private void m9149a() {
        int i;
        List arrayList = new ArrayList();
        Subreddit a = PromoterUtil.a();
        boolean z = true;
        boolean z2 = a != null;
        if (a != null) {
            arrayList.add(new SubredditDivider(Util.f(C1761R.string.title_profile_communities), z2));
            arrayList.add(new SubredditData(m9148a(a.display_name, true), a.getName(), a.icon_img, a.key_color));
        }
        if (this.f10800a.m16269c() > 0) {
            arrayList.add(new SubredditDivider(Util.f(C1761R.string.title_recent_communities), z2));
            for (i = 0; i < this.f10804e; i++) {
                RecentSubreddit recentSubreddit = (RecentSubreddit) this.f10800a.mo3804a(i);
                if (recentSubreddit == null) {
                    break;
                }
                arrayList.add(new SubredditData(m9148a(recentSubreddit.subredditName, false), recentSubreddit.subredditId, recentSubreddit.icon, recentSubreddit.keyColor));
            }
        } else {
            z = z2;
        }
        i = this.f10801b.m16269c();
        if (i > 0) {
            arrayList.add(new SubredditDivider(Util.f(C1761R.string.title_subscribed_communities), z));
            int i2 = 0;
            while (i2 < i && i2 < this.f10805f) {
                if (!SubredditUtil.a(this.f10801b.m19751b(i2).getDisplayName())) {
                    SubredditInfo b = this.f10801b.m19751b(i2);
                    arrayList.add(new SubredditData(m9148a(b.getSubredditName(), false), b.getName(), b.getIconImage(), b.getKeyColor()));
                }
                i2++;
            }
        }
        this.f10806g.onNext(arrayList);
        EventBus.getDefault().unregister(this);
    }

    private static String m9148a(String str, boolean z) {
        if (z) {
            if (SubredditUtil.a(str)) {
                return str;
            }
            return String.format(Util.f(true), new Object[]{str});
        } else if (SubredditUtil.b(str)) {
            return str;
        } else {
            return String.format(Util.f(true), new Object[]{str});
        }
    }

    public void onEvent(RecentSubredditCursorEvent recentSubredditCursorEvent) {
        if (this.f10800a != null) {
            if (this.f10802c == null) {
                this.f10802c = true;
                if (this.f10803d != null) {
                    m9149a();
                }
                Timber.b("Got recent subreddit event", new Object[0]);
            }
        }
    }

    public void onEvent(SubscribedSubredditLoadEvent subscribedSubredditLoadEvent) {
        if (this.f10801b != null) {
            if (this.f10803d == null) {
                this.f10803d = true;
                if (this.f10802c != null) {
                    m9149a();
                }
                Timber.b("Got subscribed subreddit event", new Object[0]);
            }
        }
    }
}
