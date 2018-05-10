package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import com.reddit.frontpage.domain.model.CreateEditLinkResponse;
import com.reddit.frontpage.domain.model.Result.Error;
import com.reddit.frontpage.domain.model.Result.Success;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lcom/reddit/frontpage/domain/model/Result;", "Lcom/reddit/frontpage/domain/model/Link;", "kotlin.jvm.PlatformType", "it", "Lcom/reddit/frontpage/domain/model/CreateEditLinkResponse;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditLinkRepository.kt */
final class RedditLinkRepository$edit$1<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ RedditLinkRepository f16070a;
    final /* synthetic */ String f16071b;

    RedditLinkRepository$edit$1(RedditLinkRepository redditLinkRepository, String str) {
        this.f16070a = redditLinkRepository;
        this.f16071b = str;
    }

    public final /* synthetic */ Object apply(Object obj) {
        CreateEditLinkResponse createEditLinkResponse = (CreateEditLinkResponse) obj;
        Intrinsics.b(createEditLinkResponse, "it");
        if (createEditLinkResponse.hasErrors()) {
            String firstError = createEditLinkResponse.getFirstError();
            if (firstError == null) {
                Intrinsics.a();
            }
            return Single.just(new Error(firstError, createEditLinkResponse.isTextFirstError()));
        }
        obj = createEditLinkResponse.getLink();
        if (obj == null) {
            Intrinsics.a();
        }
        return this.f16070a.f16099j.mo2969e(this.f16071b).flatMapSingleElement(new RedditLinkRepository$edit$1$$special$$inlined$run$lambda$1(obj, this)).switchIfEmpty(Single.just(new Success(obj)));
    }
}
