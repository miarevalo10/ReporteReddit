package com.reddit.frontpage.presentation.listing.common;

import com.reddit.frontpage.domain.repository.LinkRepository;
import io.reactivex.Completable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0015\u0010\u0004\u001a\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Lio/reactivex/Completable;", "T", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "p1", "", "Lkotlin/ParameterName;", "name", "id", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditModeratorLinkActions.kt */
final class RedditModeratorLinkActions$onModerateMarkSpoiler$markSpoiler$1 extends FunctionReference implements Function1<String, Completable> {
    RedditModeratorLinkActions$onModerateMarkSpoiler$markSpoiler$1(LinkRepository linkRepository) {
        super(1, linkRepository);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(LinkRepository.class);
    }

    public final String mo5687b() {
        return "markSpoiler";
    }

    public final String mo6932c() {
        return "markSpoiler(Ljava/lang/String;)Lio/reactivex/Completable;";
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        String str = (String) obj;
        Intrinsics.m26847b(str, "p1");
        return ((LinkRepository) this.b).m22424c(str);
    }
}
