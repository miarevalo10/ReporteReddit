package com.reddit.frontpage.presentation.listing.linkpager;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.domain.usecase.LinkPagerLoadData;
import com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams;
import com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams.HistoryParams;
import com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams.StandardParams.LoadData;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.listing.linkpager.LinkPagerContract.Parameters;
import com.reddit.frontpage.presentation.listing.linkpager.LinkPagerContract.Parameters.HistoryParameters;
import com.reddit.frontpage.presentation.listing.linkpager.LinkPagerContract.Parameters.StandardParameters;
import com.reddit.frontpage.presentation.listing.linkpager.LinkPagerContract.Presenter;
import com.reddit.frontpage.presentation.listing.linkpager.LinkPagerContract.View;
import com.reddit.frontpage.util.kotlin.CompletablesKt;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.rxkotlin.SubscribersKt;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u0018\u001a\u00020\u0019H\u0016JD\u0010\u001a\u001a\u00020\u00192\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00190\u001c2\u0014\b\u0002\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00190\u001c2\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190 H\u0002J\b\u0010!\u001a\u00020\u0019H\u0016J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00150#H\u0002J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0012H\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerContract$View;", "linkPagerLoadData", "Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadData;", "parameters", "Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerContract$Parameters;", "postExecutionThread", "Lcom/reddit/common/rx/PostExecutionThread;", "linkRepository", "Lcom/reddit/frontpage/domain/repository/LinkRepository;", "(Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerContract$View;Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadData;Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerContract$Parameters;Lcom/reddit/common/rx/PostExecutionThread;Lcom/reddit/frontpage/domain/repository/LinkRepository;)V", "isLoadingMore", "", "isPreviouslyAttached", "linkPosition", "", "links", "", "Lcom/reddit/frontpage/domain/model/Link;", "params", "Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadDataParams;", "attach", "", "loadLinks", "onSuccess", "Lkotlin/Function1;", "onError", "", "postExecution", "Lkotlin/Function0;", "loadMore", "mapLinks", "", "onPageSelected", "position", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkPagerPresenter.kt */
public final class LinkPagerPresenter extends DisposablePresenter implements Presenter {
    boolean f33932a;
    LinkPagerLoadDataParams f33933b;
    private final List<Link> f33934c = ((List) new ArrayList());
    private boolean f33935d;
    private int f33936e;
    private final View f33937f;
    private final LinkPagerLoadData f33938g;
    private final PostExecutionThread f33939h;
    private final LinkRepository f33940i;

    @Inject
    public LinkPagerPresenter(View view, LinkPagerLoadData linkPagerLoadData, Parameters parameters, PostExecutionThread postExecutionThread, LinkRepository linkRepository) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(linkPagerLoadData, "linkPagerLoadData");
        Intrinsics.m26847b(parameters, "parameters");
        Intrinsics.m26847b(postExecutionThread, "postExecutionThread");
        Intrinsics.m26847b(linkRepository, "linkRepository");
        this.f33937f = view;
        this.f33938g = linkPagerLoadData;
        this.f33939h = postExecutionThread;
        this.f33940i = linkRepository;
        if ((parameters instanceof StandardParameters) != null) {
            StandardParameters standardParameters = (StandardParameters) parameters;
            view = (LinkPagerLoadDataParams) new LoadData(parameters.mo4888a(), parameters.mo4889b(), parameters.mo4890c(), standardParameters.f28419a, standardParameters.f28420b);
        } else if ((parameters instanceof HistoryParameters) != null) {
            HistoryParameters historyParameters = (HistoryParameters) parameters;
            view = (LinkPagerLoadDataParams) new HistoryParams.LoadData(parameters.mo4888a(), parameters.mo4889b(), historyParameters.f28414a, historyParameters.f28415b);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.f33933b = view;
        this.f33936e = parameters.mo4889b();
    }

    public final void attach() {
        if (this.f33935d) {
            this.f33937f.mo7364d();
            this.f33937f.mo7361a(this.f33934c);
            this.f33937f.mo7363c();
            this.f33937f.mo7360a(this.f33936e);
            return;
        }
        m34733a(this, new LinkPagerPresenter$attach$1(this), new LinkPagerPresenter$attach$2(this), null, 4);
    }

    static /* synthetic */ void m34733a(LinkPagerPresenter linkPagerPresenter, Function1 function1, Function1 function12, Function0 function0, int i) {
        if ((i & 1) != 0) {
            function1 = LinkPagerPresenter$loadLinks$1.f36690a;
        }
        if ((i & 2) != 0) {
            function12 = LinkPagerPresenter$loadLinks$2.f36691a;
        }
        if ((i & 4) != 0) {
            function0 = LinkPagerPresenter$loadLinks$3.f36692a;
        }
        i = SinglesKt.m24094b(linkPagerPresenter.f33938g.m22528b(linkPagerPresenter.f33933b), linkPagerPresenter.f33939h);
        if (function0 != null) {
            function0 = new LinkPagerPresenterKt$sam$Action$1b259dd7(function0);
        }
        Single doFinally = i.doFinally((Action) function0);
        Intrinsics.m26843a((Object) doFinally, "linkPagerLoadData.execut….doFinally(postExecution)");
        SubscribersKt.m26769a(doFinally, (Function1) new LinkPagerPresenter$loadLinks$4(function12), new LinkPagerPresenter$loadLinks$5(linkPagerPresenter, function1));
    }

    public final void m34740a(int i) {
        this.f33936e = i;
        Link link = (Link) this.f33934c.get(i);
        if (!link.isRead()) {
            Object subscribe = CompletablesKt.m24074b(this.f33940i.m22431j(link.getId()), this.f33939h).subscribe((Action) new LinkPagerPresenter$onPageSelected$1(this, i, link));
            Intrinsics.m26843a(subscribe, "linkRepository.markLinkA…ead = true)\n            }");
            handleDispose(subscribe);
        }
    }
}
