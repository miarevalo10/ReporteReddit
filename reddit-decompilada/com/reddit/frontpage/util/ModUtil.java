package com.reddit.frontpage.util;

import android.util.LruCache;
import android.view.View;
import android.widget.ImageView;
import com.reddit.common.ThingUtil;
import com.reddit.datalibrary.frontpage.data.model.ModPermissions;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ModEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.ModNoun;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.widgets.modtools.modqueue.ModModeable;
import timber.log.Timber;

public class ModUtil {
    private static final ModCacheLinks f21758a = new ModCacheLinks();
    private static final LruCache<String, ModCacheComments> f21759b = new LruCache(10);
    private static boolean f21760c = false;
    private static boolean f21761d = false;

    public static ModCacheLinks m23824a() {
        return f21758a;
    }

    public static void m23832b() {
        f21760c ^= 1;
    }

    public static void m23835c() {
        f21761d ^= 1;
    }

    public static void m23830a(String str, String str2) {
        String str3;
        ModEventBuilder modEventBuilder = (ModEventBuilder) ((ModEventBuilder) AppAnalytics.m21880q().m21888a("modmode")).m21892b("click");
        if (f21760c) {
            str3 = ModNoun.f20042a.f20068M;
        } else {
            str3 = ModNoun.f20043b.f20068M;
        }
        modEventBuilder = (ModEventBuilder) modEventBuilder.m21895c(str3);
        if (!ThingUtil.b(str).isEmpty()) {
            modEventBuilder.m21889a(str, str2);
        }
        modEventBuilder.m21891a();
    }

    public static boolean m23831a(Screen screen) {
        return (screen == null || !f21760c || (screen instanceof ModModeable) == null) ? false : true;
    }

    public static boolean m23834b(Screen screen) {
        return (screen == null || !f21761d || (screen instanceof ModModeable) == null) ? false : true;
    }

    public static ModCacheComments m23823a(String str) {
        if (str == null) {
            return ModCacheCommentsDummy.m35278a();
        }
        ModCacheComments modCacheComments = (ModCacheComments) f21759b.get(str);
        if (modCacheComments == null) {
            modCacheComments = new ModCacheComments();
            f21759b.put(str, modCacheComments);
        }
        return modCacheComments;
    }

    public static ModCacheComments m23822a(Link link) {
        if (link == null) {
            return ModCacheCommentsDummy.m35278a();
        }
        if (link.getSubredditDetail() != null) {
            if (link.getSubredditDetail().user_is_moderator) {
                return m23823a(link.getName());
            }
        }
        return ModCacheCommentsDummy.m35278a();
    }

    public static void m23837d() {
        f21758a.clearCache();
        f21759b.evictAll();
    }

    public static void m23838e() {
        f21759b.evictAll();
    }

    static final /* synthetic */ void m23836c(Runnable runnable, View view) {
        runnable.run();
        m23825a(view);
    }

    public static void m23827a(Subreddit subreddit, View view, ModPermissions modPermissions, Runnable runnable) {
        if (subreddit != null) {
            if (Boolean.TRUE.equals(subreddit.getUserIsModerator()) != null) {
                if (modPermissions.getPosts() != null) {
                    view.setVisibility(null);
                    view.setSelected(m23831a(Routing.m22617a(view.getContext())));
                    view.setOnClickListener(new ModUtil$$Lambda$1(runnable));
                }
            }
        }
    }

    static final /* synthetic */ void m23833b(Runnable runnable, View view) {
        runnable.run();
        m23825a(view);
    }

    public static void m23828a(Subreddit subreddit, View view, Runnable runnable) {
        if (subreddit != null) {
            if (Boolean.TRUE.equals(subreddit.getUserIsModerator()) != null) {
                view.setVisibility(null);
                view.setSelected(m23831a(Routing.m22617a(view.getContext())));
                view.setOnClickListener(new ModUtil$$Lambda$2(runnable));
            }
        }
    }

    static final /* synthetic */ void m23829a(Runnable runnable, View view) {
        runnable.run();
        m23825a(view);
    }

    public static void m23825a(View view) {
        if (view instanceof ImageView) {
            int i;
            ImageView imageView = (ImageView) view;
            if (m23831a(Routing.m22617a(view.getContext()))) {
                Timber.c("deactivating mod mode", new Object[0]);
                i = C1761R.drawable.ic_icon_unmod;
            } else {
                Timber.c("activating mod mode", new Object[0]);
                i = C1761R.drawable.ic_icon_moderate;
            }
            imageView.setImageDrawable(ResourcesUtil.m22732e(view.getContext(), i));
        }
    }

    @Deprecated
    public static void m23826a(com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit subreddit, View view, Runnable runnable) {
        if (subreddit != null) {
            if (subreddit.user_is_moderator != null) {
                view.setVisibility(null);
                view.setSelected(m23831a(Routing.m22617a(view.getContext())));
                view.setOnClickListener(new ModUtil$$Lambda$0(runnable));
            }
        }
    }
}
