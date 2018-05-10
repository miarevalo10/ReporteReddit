package com.reddit.frontpage.presentation.detail;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ReplyPresenter.kt */
final class ReplyPresenter$onSubmitSelected$2<T> implements Consumer<Throwable> {
    final /* synthetic */ ReplyPresenter f28177a;

    ReplyPresenter$onSubmitSelected$2(ReplyPresenter replyPresenter) {
        this.f28177a = replyPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        Timber.c((Throwable) obj, "Unable to reply to kindWithId=%s", new Object[]{this.f28177a.f33840d.f20498a});
        this.f28177a.f33837a.mo7170g();
        this.f28177a.f33837a.mo7168e();
    }
}
