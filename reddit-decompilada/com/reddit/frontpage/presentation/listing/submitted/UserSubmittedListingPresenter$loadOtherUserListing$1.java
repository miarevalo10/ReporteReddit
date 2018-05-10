package com.reddit.frontpage.presentation.listing.submitted;

import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Karma;
import com.reddit.frontpage.domain.model.Link;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0001\u0012B\b\u0001\u0012>\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005 \u0007*\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00020\u0002 \u0007*H\u0012B\b\u0001\u0012>\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005 \u0007*\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lkotlin/Pair;", "", "Lcom/reddit/frontpage/domain/model/Karma;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "kotlin.jvm.PlatformType", "account", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: UserSubmittedListingPresenter.kt */
final class UserSubmittedListingPresenter$loadOtherUserListing$1<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ Single f28458a;
    final /* synthetic */ Single f28459b;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lcom/reddit/frontpage/domain/model/Karma;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "karma", "listing", "apply"}, k = 3, mv = {1, 1, 9})
    /* compiled from: UserSubmittedListingPresenter.kt */
    static final class C23041<T1, T2, R> implements BiFunction<List<? extends Karma>, Listing<? extends Link>, Pair<? extends List<? extends Karma>, ? extends Listing<? extends Link>>> {
        public static final C23041 f28456a = new C23041();

        C23041() {
        }

        public final /* synthetic */ Object apply(Object obj, Object obj2) {
            List list = (List) obj;
            Listing listing = (Listing) obj2;
            Intrinsics.m26847b(list, "karma");
            Intrinsics.m26847b(listing, "listing");
            return new Pair(list, listing);
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "listing", "apply"}, k = 3, mv = {1, 1, 9})
    /* compiled from: UserSubmittedListingPresenter.kt */
    static final class C23052<T, R> implements Function<T, R> {
        public static final C23052 f28457a = new C23052();

        C23052() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            Listing listing = (Listing) obj;
            Intrinsics.m26847b(listing, "listing");
            return new Pair(null, listing);
        }
    }

    UserSubmittedListingPresenter$loadOtherUserListing$1(Single single, Single single2) {
        this.f28458a = single;
        this.f28459b = single2;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Account account = (Account) obj;
        Intrinsics.m26847b(account, "account");
        if (account.getSubreddit() != null) {
            return this.f28458a.zipWith(this.f28459b, C23041.f28456a);
        }
        return this.f28459b.map(C23052.f28457a);
    }
}
