package com.reddit.frontpage.presentation.detail;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkEditPresenter.kt */
final class LinkEditPresenter$onSubmitSelected$2<T> implements Consumer<Throwable> {
    final /* synthetic */ LinkEditPresenter f28174a;

    LinkEditPresenter$onSubmitSelected$2(LinkEditPresenter linkEditPresenter) {
        this.f28174a = linkEditPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        Timber.c((Throwable) obj, "Unable to edit link with kindWithId=%s", new Object[]{this.f28174a.f33836d.f20495a.getKindWithId()});
        this.f28174a.f33833a.mo7158d();
        this.f28174a.f33833a.mo7156b();
    }
}
