package com.reddit.frontpage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import bolts.Task;
import butterknife.BindView;
import com.bluelinelabs.conductor.RouterTransaction;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.feature.legacy.AsyncCallback;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository$.Lambda.15;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository$.Lambda.17;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository$.Lambda.18;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.datalibrary.frontpage.data.provider.LinkProvider;
import com.reddit.datalibrary.frontpage.data.provider.LinkProvider.1;
import com.reddit.datalibrary.frontpage.data.provider.LinkProvider.LinkEvent;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.ParcelerBundler;
import com.reddit.frontpage.commons.analytics.events.v2.CommentPerformanceEventBuilder.Source;
import com.reddit.frontpage.commons.analytics.performance.CommentsPerformanceTracker;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.detail.OnLinkActionListener;
import com.reddit.frontpage.ui.detail.OnViewAllCommentsListener;
import com.reddit.frontpage.ui.detail.image.ImageDetailScreen;
import com.reddit.frontpage.ui.detail.self.SelfDetailScreen;
import com.reddit.frontpage.ui.detail.video.VideoDetailScreen;
import com.reddit.frontpage.ui.detail.video.VideoDetailScreenLegacy;
import com.reddit.frontpage.ui.detail.web.WebDetailScreen;
import com.reddit.frontpage.ui.detail.xpost.XPostImageDetailScreen;
import com.reddit.frontpage.ui.detail.xpost.XPostSmallDetailScreen;
import com.reddit.frontpage.ui.detail.xpost.XPostVideoDetailScreen;
import com.reddit.frontpage.ui.detail.xpost.XPostVideoLegacyDetailScreen;
import com.reddit.frontpage.util.DeepLinkUtil.ScreenDeepLinker;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.modtools.modqueue.ModModeable;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import javax.inject.Inject;
import org.parceler.Parcel;

public class DetailHolderScreen extends BaseScreen implements OnLinkActionListener, OnViewAllCommentsListener, ModModeable {
    @State
    String comment;
    @State
    String commentContext;
    @BindView
    ViewGroup container;
    @State(ParcelerBundler.class)
    Link link;
    @State
    String linkId;
    @State
    String sourcePage;
    @BindView
    ViewStub stub;
    @Inject
    LegacyLinkRepository f39058v;
    LinkProvider f39059w;

    @Parcel
    public static class DeepLinker implements ScreenDeepLinker {
        String comment;
        String commentContext;
        String linkId;

        public Screen createScreen() {
            return DetailHolderScreen.m38885a(this.linkId, this.comment, this.commentContext);
        }
    }

    public final int mo7141s() {
        return C1761R.layout.screen_detail_holder;
    }

    public final int mo7143u() {
        return 2;
    }

    public static DetailHolderScreen m38885a(String str, String str2, String str3) {
        DetailHolderScreen detailHolderScreen = new DetailHolderScreen();
        detailHolderScreen.linkId = str;
        detailHolderScreen.comment = str2;
        detailHolderScreen.commentContext = str3;
        return detailHolderScreen;
    }

    public static DetailHolderScreen m38884a(Link link, String str) {
        DetailHolderScreen detailHolderScreen = new DetailHolderScreen();
        detailHolderScreen.link = link;
        detailHolderScreen.sourcePage = str;
        return detailHolderScreen;
    }

    public static DeepLinker m38887b(String str, String str2, String str3) {
        DeepLinker deepLinker = new DeepLinker();
        deepLinker.linkId = str;
        deepLinker.comment = str2;
        deepLinker.commentContext = str3;
        return deepLinker;
    }

    protected final void mo7142t() {
        super.mo7142t();
        FrontpageApplication.m28868d().a(this);
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        layoutInflater = a(this.container, null);
        if (this.link == null) {
            this.stub.inflate();
        } else if (layoutInflater.n() == null) {
            layoutInflater.b(RouterTransaction.a(m38886a(this.link)).a(Routing.m22615a()).b(Routing.m22615a()));
        }
        return this.K;
    }

    protected final void mo7144v() {
        this.f39059w = new LinkProvider(this.f39058v, this.linkId);
        m37523a(this.f39059w);
    }

    protected final void mo6992b(View view) {
        super.mo6992b(view);
        if (this.link == null) {
            view = this.f39059w;
            String a = CommentsPerformanceTracker.m21953a(Source.DetailHolder);
            LegacyLinkRepository legacyLinkRepository = view.a;
            String str = view.b;
            AsyncCallback 1 = new 1(view, a);
            view = new ArrayList();
            Task a2 = Task.a(new 17(legacyLinkRepository, str, a));
            Task a3 = Task.a(new 18(legacyLinkRepository, str));
            view.add(a2);
            view.add(a3);
            Task.a(view).a(new 15(legacyLinkRepository, 1, a2, a3), Task.b);
        }
    }

    private Screen m38886a(Link link) {
        Bundle bundle = new Bundle();
        bundle.putString("comment", this.comment);
        bundle.putString("context", this.commentContext);
        bundle.putString("com.reddit.arg.sourcePage", this.sourcePage);
        if (link.getLinkType() == 10) {
            Link link2 = (ClientLink) link.getCrosspostParentList().get(0);
            if (Util.m24043l(link2)) {
                link = XPostImageDetailScreen.m42481a(link, bundle);
            } else if (link2.isVideo()) {
                link = XPostVideoDetailScreen.m42487a(link, bundle);
            } else if (Util.m24010c(link2)) {
                link = XPostVideoLegacyDetailScreen.m42501a(link, bundle);
            } else {
                link = XPostSmallDetailScreen.m42484a(link, bundle);
            }
        } else if (link.isSelf()) {
            link = SelfDetailScreen.m42157a(link, bundle);
        } else if (Util.m24043l(link)) {
            link = ImageDetailScreen.m42154a(link, bundle);
        } else if (Util.m24010c(link)) {
            if (Util.m24031g(link)) {
                if (!InternalSettings.a().q()) {
                    link = VideoDetailScreen.m42165a(link, bundle);
                }
            }
            link = VideoDetailScreenLegacy.m42203a(link, bundle);
        } else {
            link = WebDetailScreen.m42213a(link, bundle);
        }
        link.a.putBoolean("com.reddit.arg.fromFeed", true);
        link.a.putAll(this.a);
        link.m29363b((Screen) this);
        return link;
    }

    public final void mo7145w() {
        this.comment = null;
        this.commentContext = null;
    }

    public void onEventMainThread(LinkEvent linkEvent) {
        this.link = linkEvent.a;
        EventBus.getDefault().removeStickyEvent((Object) linkEvent);
        a(this.container, null).c(RouterTransaction.a(m38886a(this.link)));
    }

    public final void mo7146x() {
        m29351F();
    }

    public final void mo7147y() {
        m29351F();
    }

    public final void q_() {
        m29351F();
    }
}
