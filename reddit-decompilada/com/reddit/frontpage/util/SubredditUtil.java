package com.reddit.frontpage.util;

import android.text.TextUtils;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.repo.SubscriptionCountRepository;
import com.reddit.datalibrary.frontpage.data.model.UserSubreddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.nav.Screens;
import com.reddit.frontpage.ui.BaseScreen;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SubredditUtil {
    private static final Map<String, Boolean> f21803a = new HashMap();

    public static void m23913a() {
        String e = SessionUtil.m23899e();
        if (e == null) {
            e = "";
        }
        FrontpageApplication.m28875k().mo4635w().m22500c(e).observeOn(FrontpageApplication.m28875k().mo4633u().a()).subscribe(SubredditUtil$$Lambda$0.f29408a);
    }

    static final /* synthetic */ void m23919a(List list) throws Exception {
        for (Subreddit displayName : list) {
            m23932c(displayName.getDisplayName(), true);
        }
        FrontpageApplication.m28875k().mo4636x().a(list.size());
    }

    public static Boolean m23911a(String str, boolean z) {
        str = m23937h(str);
        return str == null ? Boolean.valueOf(z) : str;
    }

    public static void m23928b(String str, boolean z) {
        SubscriptionCountRepository x = FrontpageApplication.m28875k().mo4636x();
        if (Boolean.TRUE.equals(m23937h(str)) != z) {
            if (z) {
                x.a(x.a + 1);
            } else {
                x.a(x.a - 1);
            }
        }
        m23932c(str, z);
    }

    public static void m23922b() {
        f21803a.clear();
        FrontpageApplication.m28875k().mo4636x().a(0);
    }

    public static void m23918a(Subreddit subreddit, String str) {
        AppAnalytics.m21869f().m21819a(subreddit.getDisplayName()).m21821b(subreddit.getUrl()).m21822c(str).mo4571a();
        String displayName = subreddit.getDisplayName();
        m23928b(displayName, true);
        m23935f(displayName);
    }

    @Deprecated
    public static void m23915a(com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit subreddit, String str) {
        AppAnalytics.m21869f().m21819a(subreddit.display_name).m21821b(subreddit.url).m21822c(str).mo4571a();
        String str2 = subreddit.display_name;
        m23928b(str2, true);
        m23935f(str2);
    }

    public static void m23914a(UserSubreddit userSubreddit, String str) {
        AppAnalytics.m21869f().m21819a(userSubreddit.getDisplayName()).m21821b(userSubreddit.getUrl()).m21822c(str).mo4571a();
        String displayName = userSubreddit.getDisplayName();
        m23928b(displayName, true);
        m23935f(displayName);
    }

    public static void m23916a(Link link, BaseScreen baseScreen) {
        String subreddit = link.getSubreddit();
        AppAnalytics.m21869f().m21819a(subreddit).m21822c(baseScreen.getAnalyticsScreenName()).mo4571a();
        m23928b(subreddit, true);
        m23935f(subreddit);
        link = Screens.m22629a(baseScreen, Util.m23960a((int) C1761R.string.fmt_now_subscribed, link.getSubredditNamePrefixed()), -1);
        if (link != null) {
            link.a();
        }
    }

    public static void m23917a(com.reddit.frontpage.domain.model.Link link) {
        String subreddit = link.getSubreddit();
        m23928b(subreddit, true);
        m23935f(subreddit);
    }

    private static void m23935f(String str) {
        FrontpageApplication.m28875k().mo4635w().m22506g(str).subscribe();
    }

    @Deprecated
    public static void m23924b(com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit subreddit, String str) {
        AppAnalytics.m21870g().m21819a(subreddit.display_name).m21821b(subreddit.url).m21822c(str).mo4571a();
        String str2 = subreddit.display_name;
        m23928b(str2, (boolean) null);
        m23936g(str2);
    }

    public static void m23923b(UserSubreddit userSubreddit, String str) {
        AppAnalytics.m21870g().m21819a(userSubreddit.getDisplayName()).m21821b(userSubreddit.getUrl()).m21822c(str).mo4571a();
        String displayName = userSubreddit.getDisplayName();
        m23928b(displayName, (boolean) null);
        m23936g(displayName);
    }

    public static void m23927b(Subreddit subreddit, String str) {
        AppAnalytics.m21870g().m21819a(subreddit.getDisplayName()).m21821b(subreddit.getUrl()).m21822c(str).mo4571a();
        String displayName = subreddit.getDisplayName();
        m23928b(displayName, (boolean) null);
        m23936g(displayName);
    }

    @Deprecated
    public static void m23925b(Link link, BaseScreen baseScreen) {
        String subreddit = link.getSubreddit();
        AppAnalytics.m21870g().m21819a(subreddit).m21822c(baseScreen.getAnalyticsScreenName()).mo4571a();
        m23928b(subreddit, false);
        m23936g(subreddit);
        link = Screens.m22629a(baseScreen, Util.m23960a((int) C1761R.string.fmt_now_unsubscribed, link.getSubredditNamePrefixed()), -1);
        if (link != null) {
            link.a();
        }
    }

    public static void m23926b(com.reddit.frontpage.domain.model.Link link) {
        String subreddit = link.getSubreddit();
        m23928b(subreddit, false);
        m23936g(subreddit);
    }

    private static void m23936g(String str) {
        FrontpageApplication.m28875k().mo4635w().m22507h(str).subscribe();
    }

    public static boolean m23920a(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return false;
        }
        int i = charSequence.charAt(0) == '/' ? 1 : 0;
        if (charSequence.length() >= i + 2 && charSequence.charAt(i) == 'u') {
            i++;
            if (charSequence.charAt(i) == '_' || charSequence.charAt(i) == 47) {
                return true;
            }
        }
        return false;
    }

    public static boolean m23929b(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return false;
        }
        int i = charSequence.charAt(0) == '/' ? 1 : 0;
        if (charSequence.length() >= i + 2 && charSequence.charAt(i) == 'r' && charSequence.charAt(i + 1) == 47) {
            return true;
        }
        return false;
    }

    public static String m23912a(String str) {
        if (!m23929b((CharSequence) str)) {
            return str;
        }
        int i = 0;
        if (str.charAt(0) == '/') {
            i = 1;
        }
        return str.substring(2 + i);
    }

    public static String m23921b(String str) {
        if (!m23920a((CharSequence) str)) {
            return str;
        }
        int i = 0;
        if (str.charAt(0) == '/') {
            i = 1;
        }
        return str.substring(2 + i);
    }

    public static Set<String> m23931c() {
        Set hashSet = new HashSet();
        for (Entry entry : f21803a.entrySet()) {
            if (entry.getValue() != null && ((Boolean) entry.getValue()).booleanValue()) {
                hashSet.add(entry.getKey());
            }
        }
        return hashSet;
    }

    public static String m23930c(String str) {
        return str.replaceFirst("^/?r/", "");
    }

    public static String m23934e(String str) {
        if (str.isEmpty()) {
            return str;
        }
        str = str.split(Operation.DIVISION);
        return String.format("%s%s%s%s", new Object[]{str[0], "/<b>", str[1], "</b>"});
    }

    public static boolean m23933d(String str) {
        str = str.trim().toLowerCase();
        return (!f21803a.containsKey(str) || ((Boolean) f21803a.get(str)).booleanValue() == null) ? null : true;
    }

    private static void m23932c(String str, boolean z) {
        f21803a.put(str.trim().toLowerCase(), Boolean.valueOf(z));
    }

    private static Boolean m23937h(String str) {
        return (Boolean) f21803a.get(str.trim().toLowerCase());
    }
}
