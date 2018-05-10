package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import com.nytimes.android.external.store3.base.Persister;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Link;
import io.reactivex.Maybe;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001BØ\u0001\u0012r\u0010\u0005\u001an\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0006\u0012]\u0010\u0012\u001aY\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00140\u0013¢\u0006\u0002\u0010\u0015J\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0017\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016Re\u0010\u0012\u001aY\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00140\u0013X\u0004¢\u0006\u0002\n\u0000Rz\u0010\u0005\u001an\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/link/repo/LinkPersister;", "Lcom/nytimes/android/external/store3/base/Persister;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "Lcom/reddit/datalibrary/frontpage/data/feature/link/repo/RequestKey;", "persist", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "links", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "sortTimeFrame", "", "after", "Lio/reactivex/Single;", "", "fetch", "Lkotlin/Function3;", "Lio/reactivex/Maybe;", "(Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function3;)V", "read", "key", "write", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditLinkRepository.kt */
final class LinkPersister implements Persister<Listing<? extends Link>, RequestKey> {
    private final Function4<Listing<Link>, SortType, SortTimeFrame, String, Single<Boolean>> f18700a;
    private final Function3<SortType, SortTimeFrame, String, Maybe<Listing<Link>>> f18701b;

    public LinkPersister(Function4<? super Listing<Link>, ? super SortType, ? super SortTimeFrame, ? super String, ? extends Single<Boolean>> function4, Function3<? super SortType, ? super SortTimeFrame, ? super String, ? extends Maybe<Listing<Link>>> function3) {
        Intrinsics.b(function4, "persist");
        Intrinsics.b(function3, "fetch");
        this.f18700a = function4;
        this.f18701b = function3;
    }

    public final /* synthetic */ Maybe mo2708a(Object obj) {
        RequestKey requestKey = (RequestKey) obj;
        Intrinsics.b(requestKey, "key");
        return (Maybe) this.f18701b.a(requestKey.f10706a, requestKey.f10707b, requestKey.f10708c);
    }

    public final /* synthetic */ Single mo2709a(Object obj, Object obj2) {
        RequestKey requestKey = (RequestKey) obj;
        Listing listing = (Listing) obj2;
        Intrinsics.b(requestKey, "key");
        Intrinsics.b(listing, "links");
        return (Single) this.f18700a.a(listing, requestKey.f10706a, requestKey.f10707b, requestKey.f10708c);
    }
}
