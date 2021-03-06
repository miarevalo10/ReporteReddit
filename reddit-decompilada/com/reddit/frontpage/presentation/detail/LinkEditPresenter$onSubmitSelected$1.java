package com.reddit.frontpage.presentation.detail;

import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.model.Result;
import com.reddit.frontpage.domain.model.Result.Error;
import com.reddit.frontpage.domain.model.Result.Success;
import com.reddit.frontpage.presentation.detail.common.Editable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "result", "Lcom/reddit/frontpage/domain/model/Result;", "Lcom/reddit/frontpage/domain/model/Link;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkEditPresenter.kt */
final class LinkEditPresenter$onSubmitSelected$1<T> implements Consumer<Result<? extends Link>> {
    final /* synthetic */ LinkEditPresenter f28173a;

    LinkEditPresenter$onSubmitSelected$1(LinkEditPresenter linkEditPresenter) {
        this.f28173a = linkEditPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        Result result = (Result) obj;
        this.f28173a.f33833a.mo7158d();
        if (result instanceof Success) {
            this.f28173a.f33833a.mo7154a((Editable) new com.reddit.frontpage.presentation.detail.common.Link((Link) ((Success) result).getResult()));
            return;
        }
        if (result instanceof Error) {
            this.f28173a.f33833a.mo7155a(((Error) result).getError());
        }
    }
}
