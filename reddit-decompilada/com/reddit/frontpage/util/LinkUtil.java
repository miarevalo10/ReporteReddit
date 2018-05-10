package com.reddit.frontpage.util;

import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import com.reddit.common.ThingUtil;
import com.reddit.datalibrary.frontpage.data.common.busevents.MessageEvent;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.job.ApproveJob;
import com.reddit.datalibrary.frontpage.job.DeletePostJob;
import com.reddit.datalibrary.frontpage.job.DistinguishJob;
import com.reddit.datalibrary.frontpage.job.EditLinkJob;
import com.reddit.datalibrary.frontpage.job.LockJobs.Lock;
import com.reddit.datalibrary.frontpage.job.LockJobs.Unlock;
import com.reddit.datalibrary.frontpage.job.NsfwJobs.Mark;
import com.reddit.datalibrary.frontpage.job.NsfwJobs.Unmark;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import com.reddit.datalibrary.frontpage.job.RemoveJob;
import com.reddit.datalibrary.frontpage.job.SaveJobs.Save;
import com.reddit.datalibrary.frontpage.job.SaveJobs.Unsave;
import com.reddit.datalibrary.frontpage.job.SpoilerJobs;
import com.reddit.datalibrary.frontpage.job.StickyJob;
import com.reddit.datalibrary.frontpage.job.VoteJob;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.Votable.AdAnalyticsInfo;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.SharePiggyback;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v1.ImageResolution;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkPreview;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.Shareable;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v2.ShareEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.ShareEventBuilder.Action;
import com.reddit.frontpage.commons.analytics.events.v2.ShareEventBuilder.Noun;
import com.reddit.frontpage.commons.analytics.events.v2.ShareEventBuilder.Source;
import com.reddit.frontpage.commons.analytics.events.v2.TheaterModeEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.TheaterModeEvents;
import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.analytics.RedditAdsAnalytics;
import com.reddit.frontpage.presentation.common.ui.Features;
import com.reddit.frontpage.ui.listing.newcard.LinkViewHolder;
import com.reddit.frontpage.ui.listing.newcard.LinkViewHolder$$Lambda$2;
import com.reddit.frontpage.ui.listing.newcard.LinkViewHolder.OnViewMediaListener;
import com.reddit.frontpage.ui.submit.LinkFlairSelectScreen;
import com.reddit.frontpage.widgets.LinkFooterView.OnModerateListener;
import com.reddit.frontpage.widgets.LinkFooterView.OnShareListener;
import com.reddit.frontpage.widgets.vote.OnVoteChangeListener;
import de.greenrobot.event.EventBus;
import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import timber.log.Timber;

public class LinkUtil {

    static class C23803 implements CompletableObserver {
        public final void onSubscribe(Disposable disposable) {
        }

        C23803() {
        }

        public final void onComplete() {
            EventBus.getDefault().post(MessageEvent.a(Util.m24027f((int) C1761R.string.success_post_hide)));
        }

        public final void onError(Throwable th) {
            EventBus.getDefault().post(MessageEvent.a(Util.m24027f((int) C1761R.string.error_post_hide_failure)));
        }
    }

    static class C23815 implements CompletableObserver {
        public final void onSubscribe(Disposable disposable) {
        }

        C23815() {
        }

        public final void onComplete() {
            EventBus.getDefault().post(MessageEvent.a(Util.m24027f((int) C1761R.string.success_post_unhide)));
        }

        public final void onError(Throwable th) {
            EventBus.getDefault().post(MessageEvent.a(Util.m24027f((int) C1761R.string.error_post_unhide_failure)));
        }
    }

    static class C23826 implements OnModerateListener {
        C23826() {
        }

        public final void mo5038d(Thing thing, boolean z) {
            if (!(thing instanceof Comment)) {
                if (thing instanceof Link) {
                    LinkUtil.m23784a(SessionManager.b().c, thing.getName(), z);
                }
            } else if (z) {
                LinkUtil.m23808k(SessionManager.b().c, thing.getName());
            } else {
                mo5039e(thing, false);
            }
        }

        public final void mo5032a(Thing thing, Screen screen) {
            if (screen != null && thing != null) {
                Screen screen2 = (LinkFlairSelectScreen) Nav.m22550a(((Link) thing).getSubreddit(), thing, null, null);
                screen2.m29363b(screen);
                Routing.m22623a(screen, screen2);
            }
        }

        public final void mo5033a(Thing thing, boolean z) {
            if (z) {
                LinkUtil.m23797c(SessionManager.b().c, thing.getName());
            } else {
                LinkUtil.m23799d(SessionManager.b().c, thing.getName());
            }
        }

        public final void mo5035b(Thing thing, boolean z) {
            if (z) {
                LinkUtil.m23801e(SessionManager.b().c, thing.getName());
            } else {
                LinkUtil.m23803f(SessionManager.b().c, thing.getName());
            }
        }

        public final void mo5037c(Thing thing, boolean z) {
            if (z) {
                LinkUtil.m23804g(SessionManager.b().c, thing.getName());
            } else {
                LinkUtil.m23805h(SessionManager.b().c, thing.getName());
            }
        }

        public final void mo5031a(Thing thing) {
            LinkUtil.m23793b(SessionManager.b().c, thing.getName(), false);
        }

        public final void mo5034b(Thing thing) {
            LinkUtil.m23793b(SessionManager.b().c, thing.getName(), true);
        }

        public final void mo5036c(Thing thing) {
            LinkUtil.m23806i(SessionManager.b().c, thing.getName());
        }

        public final void mo5039e(Thing thing, boolean z) {
            LinkUtil.m23798c(SessionManager.b().c, thing.getName(), z);
        }
    }

    public static void m23779a(Context context, Shareable shareable) {
        shareable.getTitle();
        m23780a(context, shareable.getPermalink());
    }

    public static void m23780a(Context context, String str) {
        if (Uri.parse(str).getHost() == null) {
            str = String.format(context.getResources().getString(C1761R.string.fmt_permalink_base), new Object[]{str});
        }
        str = m23778a(str);
        AppConfiguration t = FrontpageSettings.a().t();
        if (t.g()) {
            SharePiggyback sharePiggyback = t.experiments.share_copy_link;
            str = Util.m23960a((int) C1761R.string.share_post_link_with_app_link_no_title, str, sharePiggyback.copy, sharePiggyback.link);
        } else {
            str = Util.m23960a((int) C1761R.string.share_post_link_no_title, str);
        }
        context.startActivity(IntentUtil.m23746a(context, str));
    }

    public static String m23778a(String str) {
        if (str == null) {
            return null;
        }
        Uri parse = Uri.parse(str);
        if (parse.isHierarchical() && (parse.getHost() == null || parse.getHost().toLowerCase().endsWith(".reddit.com"))) {
            if (parse.getQueryParameter("utm_source") != null) {
                str = parse.buildUpon().clearQuery();
                for (String str2 : parse.getQueryParameterNames()) {
                    if ("utm_source".equalsIgnoreCase(str2)) {
                        str.appendQueryParameter("utm_source", "reddit-android");
                    } else {
                        str.appendQueryParameter(str2, parse.getQueryParameter(str2));
                    }
                }
                str = str.build().toString();
            } else {
                str = parse.buildUpon().appendQueryParameter("utm_source", "reddit-android").build().toString();
            }
        }
        return str;
    }

    public static OnVoteChangeListener m23777a(final Context context) {
        return new OnVoteChangeListener() {
            public final boolean mo4894a() {
                if (!SessionManager.b().c.isAnonymous()) {
                    return true;
                }
                SessionManager.b().a(Util.m24019e(context), true);
                return false;
            }

            public final void mo4893a(String str, int i, AdAnalyticsInfo adAnalyticsInfo) {
                RedditJobManager.a().a(new VoteJob(SessionManager.b().c, str, i));
                Timber.b("Logging a vote %s", new Object[]{str});
                if (adAnalyticsInfo != null) {
                    if (adAnalyticsInfo.isComment != null) {
                        if (i == 1) {
                            RedditAdsAnalytics.m22650a(context, adAnalyticsInfo, 8);
                        } else if (i == -1) {
                            RedditAdsAnalytics.m22650a(context, adAnalyticsInfo, 9);
                        }
                    } else if (i == 1) {
                        RedditAdsAnalytics.m22650a(context, adAnalyticsInfo, 4);
                    } else if (i == -1) {
                        RedditAdsAnalytics.m22650a(context, adAnalyticsInfo, 5);
                    }
                }
            }
        };
    }

    static final /* synthetic */ void m23781a(Context context, String str, Link link) {
        new ShareEventBuilder().m21941a(Source.PostListing).m21939a(Action.Clicked).m21940a(Noun.Share).m21938a(link).m21937a(link.getSubredditDetail()).m21944a();
        new ShareEventBuilder().m21941a(Source.PostShareComplete).m21939a(Action.ShareComplete).m21940a(Noun.ShareSuccess).m21938a(link).m21937a(link.getSubredditDetail()).m21945b();
        m23780a(context, str);
    }

    public static void m23783a(Session session, String str, String str2, String str3) {
        if (!session.isAnonymous()) {
            RedditJobManager.a().a(new EditLinkJob(session, str, str2, str3));
        }
    }

    public static void m23782a(Session session, String str) {
        if (!session.isAnonymous()) {
            RedditJobManager.a().a(new Save(session, str));
        }
    }

    public static void m23792b(Session session, String str) {
        if (!session.isAnonymous()) {
            RedditJobManager.a().a(new Unsave(session, str));
        }
    }

    public static void m23797c(Session session, String str) {
        if (!session.isAnonymous()) {
            RedditJobManager.a().a(new Mark(session, str));
        }
    }

    public static void m23799d(Session session, String str) {
        if (!session.isAnonymous()) {
            RedditJobManager.a().a(new Unmark(session, str));
        }
    }

    public static void m23801e(Session session, String str) {
        if (!session.isAnonymous()) {
            RedditJobManager.a().a(new SpoilerJobs.Mark(session, str));
        }
    }

    public static void m23803f(Session session, String str) {
        if (!session.isAnonymous()) {
            RedditJobManager.a().a(new SpoilerJobs.Unmark(session, str));
        }
    }

    public static void m23804g(Session session, String str) {
        if (!session.isAnonymous()) {
            RedditJobManager.a().a(new Lock(session, str));
        }
    }

    public static void m23805h(Session session, String str) {
        if (!session.isAnonymous()) {
            RedditJobManager.a().a(new Unlock(session, str));
        }
    }

    public static void m23784a(Session session, String str, boolean z) {
        if (!session.isAnonymous()) {
            RedditJobManager.a().a(new StickyJob(session, str, z));
        }
    }

    public static void m23806i(Session session, String str) {
        if (!session.isAnonymous()) {
            RedditJobManager.a().a(new ApproveJob(session, str));
        }
    }

    public static void m23793b(Session session, String str, boolean z) {
        if (!session.isAnonymous()) {
            RedditJobManager.a().a(new RemoveJob(session, str, z));
        }
    }

    public static void m23807j(Session session, String str) {
        if (!session.isAnonymous()) {
            m23796c().m22434m(ThingUtil.b(str)).observeOn(m23791b()).subscribe();
            RedditJobManager.a().a(new DeletePostJob(session, str));
        }
    }

    public static void m23798c(Session session, String str, boolean z) {
        if (!session.isAnonymous()) {
            RedditJobManager.a().a(new DistinguishJob(session, str, z));
        }
    }

    public static void m23808k(Session session, String str) {
        if (!session.isAnonymous()) {
            RedditJobManager.a().a(new DistinguishJob(session, str, true, true));
        }
    }

    public static void m23786a(Link link, LegacyLinkRepository legacyLinkRepository) {
        m23796c().m22431j(link.getId()).observeOn(m23791b()).subscribe();
        link.markRead();
        legacyLinkRepository.a(link);
        if (Features.m22742a() == null && Features.m22743b() == null) {
            FrontpageApplication.m28875k().mo4613a().m22479c(link.getName()).observeOn(m23791b()).subscribe();
        }
    }

    public static boolean m23794b(String str) {
        boolean z;
        str = Uri.parse(str);
        String host = str.getHost();
        if (!host.endsWith("reddit.com")) {
            if (!host.endsWith("redd.it")) {
                z = false;
                return (z || str.getPathSegments().indexOf("wiki") == null) ? false : true;
            }
        }
        z = true;
        if (z) {
            return false;
        }
    }

    public static Uri m23795c(String str) {
        return Uri.parse(str).buildUpon().authority("reddit").scheme("reddit").build();
    }

    public static ImageResolution m23774a(Link link) {
        LinkPreview preview = link.getPreview();
        if (preview == null) {
            Timber.b("No preview for %s", new Object[]{link.getUrl()});
            return null;
        }
        ImageResolution source = preview.getSource();
        if (source == null) {
            Timber.b("No source image for %s", new Object[]{link.getUrl()});
        }
        return source;
    }

    public static void m23800d(final String str) {
        m23796c().m22432k(ThingUtil.b(str)).observeOn(m23791b()).subscribe();
        ArrayList c19222 = new ArrayList<String>() {
        };
        str = new RemoteRedditApiDataSource();
        RemoteRedditApiDataSource.a(c19222).subscribeOn(SchedulerProvider.m23886b()).observeOn(SchedulerProvider.m23887c()).subscribe(new C23803());
    }

    public static void m23802e(final String str) {
        m23796c().m22433l(ThingUtil.b(str)).observeOn(m23791b()).subscribe();
        ArrayList c19234 = new ArrayList<String>() {
        };
        str = new RemoteRedditApiDataSource();
        RemoteRedditApiDataSource.b(c19234).subscribeOn(SchedulerProvider.m23886b()).observeOn(SchedulerProvider.m23887c()).subscribe(new C23815());
    }

    private static Scheduler m23791b() {
        return FrontpageApplication.m28875k().mo4633u().a();
    }

    private static LinkRepository m23796c() {
        return FrontpageApplication.m28875k().mo4628p();
    }

    public static OnModerateListener m23776a() {
        return new C23826();
    }

    public static void m23785a(Link link, View view) {
        view = AppAnalytics.m21868e().m21834a(view);
        view.f19996f = link.getName();
        view.f19995e = link.getUrl();
        view.f19998h = link.getDomain();
        view.f19997g = link.isSelf() ? "self" : "link";
        view.f19999i = link.getTitle();
        view.f20000j = link.getSubreddit();
        view.f20001k = link.getSubredditDetail() == null ? null : link.getSubredditDetail().getId();
        view.m21837a();
    }

    public static boolean m23789a(CharSequence charSequence) {
        return (TextUtils.isEmpty(charSequence) || Patterns.WEB_URL.matcher(charSequence).matches() == null) ? null : true;
    }

    public static OnViewMediaListener m23790b(final Context context, final String str) {
        return new OnViewMediaListener() {
            final /* synthetic */ int f29385b = null;

            public final void mo4993a(Link link) {
                int linkType = link.getLinkType();
                if (linkType != 1) {
                    if (linkType != 9) {
                        switch (linkType) {
                            case 3:
                            case 4:
                                LinkPreview preview = link.getPreview();
                                if (!(preview == null || preview.getSource() == null)) {
                                    Timber.b("Loading image thumbnailView URL: %s", new Object[]{preview.getSourceUrl()});
                                    context.startActivity(IntentUtil.m23760b(context, link, str));
                                }
                                return;
                            case 5:
                                break;
                            default:
                                Timber.e("Unexpected link type for viewing media: %d", new Object[]{Integer.valueOf(link.getLinkType())});
                                return;
                        }
                    }
                    TheaterModeEventBuilder.m21947a("click", (1 & this.f29385b) != 0 ? TheaterModeEvents.NOUN_ENTER_SUBREDDIT : TheaterModeEvents.NOUN_ENTER_FEED);
                    IntentUtil.m23757a(context, link, str);
                    return;
                }
                m30446d(link);
            }

            public final void mo4994b(Link link) {
                m30446d(link);
            }

            public final void mo4995c(Link link) {
                Routing.m22627b(Routing.m22617a(context), Nav.m22541a(link));
            }

            private void m30446d(Link link) {
                String str;
                if (link.getSubredditDetail() != null) {
                    str = link.getSubredditDetail().key_color;
                } else {
                    str = null;
                }
                Util.m23967a(Util.m24014d(context), Uri.parse(link.getUrl()), Util.m23951a(context, str), link.getName(), str);
            }
        };
    }

    public static void m23788a(LinkViewHolder linkViewHolder) {
        linkViewHolder.footerView.setOnVoteChangeListener(m23777a(linkViewHolder.c.getContext()));
        OnShareListener linkUtil$$Lambda$0 = new LinkUtil$$Lambda$0(linkViewHolder.c.getContext());
        linkViewHolder.footerView.setOnShareListener(linkUtil$$Lambda$0);
        linkViewHolder.f34382r = linkUtil$$Lambda$0;
        linkViewHolder.c.getContext();
        linkViewHolder.footerView.setOnModerateListener(new C23826());
        linkViewHolder.footerView.setOnModActionCompletedListener(new LinkViewHolder$$Lambda$2(linkViewHolder));
    }

    public static ImageResolution m23775a(Link link, boolean z, Point point) {
        if (link != null) {
            if (link.getPreview() != null) {
                boolean b = ModUtil.m23824a().m30455b(link.getName(), link.isSpoiler());
                boolean a = ModUtil.m23824a().m30453a(link.getName(), link.isNsfw());
                if ((z && a) || b) {
                    link = link.getPreview().getObfuscated();
                    if (link != null) {
                        return link;
                    }
                    return null;
                }
                if (!link.getPreview().getSourceResolutions().isEmpty()) {
                    z = Util.m23958a(link.getPreview().getSourceResolutions(), point);
                    if (z) {
                        return z;
                    }
                }
                return link.getPreview().getSource();
            }
        }
        return null;
    }

    public static void m23787a(com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder linkViewHolder) {
        linkViewHolder.m34779a(m23777a(linkViewHolder.c.getContext()));
    }
}
