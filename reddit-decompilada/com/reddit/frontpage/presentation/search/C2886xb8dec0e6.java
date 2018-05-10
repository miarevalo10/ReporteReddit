package com.reddit.frontpage.presentation.search;

import com.reddit.frontpage.domain.repository.SubredditRepository;
import io.reactivex.Completable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lio/reactivex/Completable;", "p1", "", "Lkotlin/ParameterName;", "name", "subredditName", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitySearchResultsPresenter.kt */
final class C2886xb8dec0e6 extends FunctionReference implements Function1<String, Completable> {
    C2886xb8dec0e6(SubredditRepository subredditRepository) {
        super(1, subredditRepository);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(SubredditRepository.class);
    }

    public final String mo5687b() {
        return "subscribe";
    }

    public final String mo6932c() {
        return "subscribe(Ljava/lang/String;)Lio/reactivex/Completable;";
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        String str = (String) obj;
        Intrinsics.m26847b(str, "p1");
        return ((SubredditRepository) this.b).m22506g(str);
    }
}
