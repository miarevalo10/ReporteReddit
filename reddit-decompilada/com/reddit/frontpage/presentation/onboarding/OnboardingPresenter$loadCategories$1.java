package com.reddit.frontpage.presentation.onboarding;

import com.reddit.frontpage.domain.model.SubredditCategory;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "categories", "", "Lcom/reddit/frontpage/domain/model/SubredditCategory;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: OnboardingPresenter.kt */
final class OnboardingPresenter$loadCategories$1<T> implements Consumer<List<? extends SubredditCategory>> {
    final /* synthetic */ OnboardingPresenter f28707a;

    OnboardingPresenter$loadCategories$1(OnboardingPresenter onboardingPresenter) {
        this.f28707a = onboardingPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        List list = (List) obj;
        OnboardingPresenter onboardingPresenter = this.f28707a;
        Intrinsics.m26843a((Object) list, "categories");
        onboardingPresenter.f34101d = list;
        if ((list.isEmpty() ^ 1) != 0) {
            this.f28707a.f34100c.mo7413a(list);
            this.f28707a.f34100c.mo7414b();
            return;
        }
        this.f28707a.f34100c.mo7416d();
    }
}
