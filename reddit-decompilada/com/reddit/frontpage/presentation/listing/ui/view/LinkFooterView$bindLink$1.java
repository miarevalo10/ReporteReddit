package com.reddit.frontpage.presentation.listing.ui.view;

import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.requests.models.Votable.AdAnalyticsInfo;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.util.AnimUtil;
import com.reddit.frontpage.util.ShareRequestUtil;
import com.reddit.frontpage.widgets.vote.OnVoteChangeListener;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"com/reddit/frontpage/presentation/listing/ui/view/LinkFooterView$bindLink$1", "Lcom/reddit/frontpage/widgets/vote/OnVoteChangeListener;", "(Lcom/reddit/frontpage/presentation/listing/ui/view/LinkFooterView;Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;)V", "beforeVoteChanged", "", "onVoteChanged", "", "votableFullName", "", "voteDirection", "", "adInfo", "Lcom/reddit/datalibrary/frontpage/requests/models/Votable$AdAnalyticsInfo;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkFooterView.kt */
public final class LinkFooterView$bindLink$1 implements OnVoteChangeListener {
    final /* synthetic */ LinkFooterView f28477a;
    final /* synthetic */ LinkPresentationModel f28478b;

    LinkFooterView$bindLink$1(LinkFooterView linkFooterView, LinkPresentationModel linkPresentationModel) {
        this.f28477a = linkFooterView;
        this.f28478b = linkPresentationModel;
    }

    public final boolean mo4894a() {
        Iterable<OnVoteChangeListener> a = this.f28477a.f20743b;
        if (!((a instanceof Collection) && ((Collection) a).isEmpty())) {
            for (OnVoteChangeListener a2 : a) {
                if (!a2.mo4894a()) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void mo4893a(String str, int i, AdAnalyticsInfo adAnalyticsInfo) {
        Intrinsics.m26847b(str, "votableFullName");
        for (OnVoteChangeListener a : this.f28477a.f20743b) {
            a.mo4893a(str, i, adAnalyticsInfo);
        }
        Object a2;
        if (i == 1 && FrontpageSettings.a().n() != null) {
            a2 = Routing.m22617a(this.f28477a.getVoteView().getContext());
            Intrinsics.m26843a(a2, "Routing.getCurrentScreen(voteView.context)");
            ShareRequestUtil.m23901a(a2.T_(), this.f28478b.f33999z, this.f28478b.ad, this.f28478b.getName(), this.f28477a.getShareEventBuilder());
        } else if (i == 1) {
            a2 = FrontpageSettings.a();
            Intrinsics.m26843a(a2, "FrontpageSettings.getInstance()");
            a2 = a2.t();
            Intrinsics.m26843a(a2, "FrontpageSettings.getInstance().appConfig");
            if (a2.d() != null) {
                this.f28477a.getExtraActionText().startAnimation(AnimUtil.m23638a(this.f28477a.getExtraActionText().getWidth(), this.f28477a.getExtraActionText().getHeight()));
            }
        }
        FrontpageSettings.a().m();
    }
}
