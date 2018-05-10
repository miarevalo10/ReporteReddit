package com.reddit.frontpage.presentation.flair;

import com.reddit.datalibrary.frontpage.data.provider.FlairProvider;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.flair.LinkFlairSelectContract.View;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.SubredditUtil;
import io.reactivex.Flowable;
import io.reactivex.rxkotlin.SubscribersKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/presentation/flair/LinkFlairSelectPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/flair/LinkFlairSelectContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/flair/LinkFlairSelectContract$View;", "(Lcom/reddit/frontpage/presentation/flair/LinkFlairSelectContract$View;)V", "previouslyAttached", "", "attach", "", "loadFlairs", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkFlairSelectPresenter.kt */
public final class LinkFlairSelectPresenter extends DisposablePresenter {
    private boolean f33855a;
    private final View f33856b;

    @Inject
    public LinkFlairSelectPresenter(View view) {
        Intrinsics.m26847b(view, "view");
        this.f33856b = view;
    }

    public final void attach() {
        if (!this.f33855a) {
            this.f33855a = true;
            FlairProvider flairProvider = new FlairProvider();
            Flowable observeOn = FlairProvider.a(SubredditUtil.m23912a(this.f33856b.mo7244a())).observeOn(SchedulerProvider.m23887c());
            Intrinsics.m26843a((Object) observeOn, "FlairProvider().fetch(\n …n(SchedulerProvider.ui())");
            handleDispose(SubscribersKt.m26768a(observeOn, (Function1) new LinkFlairSelectPresenter$loadFlairs$1(this), (Function1) new LinkFlairSelectPresenter$loadFlairs$2(this)));
        }
    }
}
