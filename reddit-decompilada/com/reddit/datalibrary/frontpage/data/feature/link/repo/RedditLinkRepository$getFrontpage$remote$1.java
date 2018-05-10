package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.ILink;
import com.reddit.frontpage.domain.model.Link;
import io.reactivex.Maybe;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/ILink;", "kotlin.jvm.PlatformType", "listing", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditLinkRepository.kt */
final class RedditLinkRepository$getFrontpage$remote$1<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ RedditLinkRepository f16077a;
    final /* synthetic */ SortType f16078b;
    final /* synthetic */ SortTimeFrame f16079c;
    final /* synthetic */ String f16080d;
    final /* synthetic */ Maybe f16081e;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "apply"}, k = 3, mv = {1, 1, 9})
    /* compiled from: RedditLinkRepository.kt */
    static final class C15051<T, R> implements Function<Throwable, Boolean> {
        public static final C15051 f16073a = new C15051();

        C15051() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            Intrinsics.b((Throwable) obj, "it");
            Timber.e("Unable to save frontpage links", new Object[]{r4});
            return Boolean.valueOf(false);
        }
    }

    RedditLinkRepository$getFrontpage$remote$1(RedditLinkRepository redditLinkRepository, SortType sortType, SortTimeFrame sortTimeFrame, String str, Maybe maybe) {
        this.f16077a = redditLinkRepository;
        this.f16078b = sortType;
        this.f16079c = sortTimeFrame;
        this.f16080d = str;
        this.f16081e = maybe;
    }

    public final /* synthetic */ Object apply(Object obj) {
        final Listing listing = (Listing) obj;
        Intrinsics.b(listing, "listing");
        return this.f16077a.f16099j.mo2960a(new Listing(CollectionsKt.a(listing.getChildren(), Link.class), listing.getAfter(), listing.getBefore(), null, 8, null), this.f16078b, this.f16079c, this.f16080d).onErrorReturn(C15051.f16073a).flatMap(new Function<T, SingleSource<? extends R>>() {
            public final /* synthetic */ Object apply(Object obj) {
                Intrinsics.b((Boolean) obj, "it");
                return this.f16081e.map(new Function<T, R>() {
                    public final /* synthetic */ Object apply(Object obj) {
                        Listing listing = (Listing) obj;
                        Intrinsics.b(listing, "localListing");
                        List c = CollectionsKt.c(listing.getChildren());
                        Iterable<ILink> children = listing.getChildren();
                        Collection arrayList = new ArrayList(CollectionsKt.b(children));
                        int i = 0;
                        for (ILink a : children) {
                            int i2 = i + 1;
                            arrayList.add(TuplesKt.a(Integer.valueOf(i), a));
                            i = i2;
                        }
                        Collection collection = (Collection) new ArrayList();
                        for (Object next : (List) arrayList) {
                            if ((!(((Pair) next).b instanceof Link) ? 1 : null) != null) {
                                collection.add(next);
                            }
                        }
                        for (Entry entry : MapsKt.a((List) collection).entrySet()) {
                            if (((Number) entry.getKey()).intValue() < c.size()) {
                                c.add(((Number) entry.getKey()).intValue(), entry.getValue());
                            }
                        }
                        return Listing.copy$default(listing, c, null, null, null, 14, null);
                    }
                }).toSingle(listing);
            }
        });
    }
}
