package com.reddit.frontpage.presentation.listing;

import android.content.Context;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.frontpage.presentation.listing.common.MutableListingLinkActions;
import com.reddit.frontpage.presentation.listing.common.SubscribeListingAdapter;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import com.reddit.frontpage.presentation.listing.popular.PopularListingPresenter;
import com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u001d\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00060\u0001H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/listing/common/SubscribeListingAdapter;", "Lcom/reddit/frontpage/presentation/listing/popular/PopularListingPresenter;", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "Lkotlin/ParameterName;", "name", "initialSort", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: PopularListingScreen.kt */
final class PopularListingScreen$adapter$2 extends Lambda implements Function0<SubscribeListingAdapter<PopularListingPresenter, SortType>> {
    final /* synthetic */ PopularListingScreen f36524a;

    PopularListingScreen$adapter$2(PopularListingScreen popularListingScreen) {
        this.f36524a = popularListingScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Object am_ = this.f36524a.am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        Context context = (Context) am_;
        MutableListingLinkActions w = this.f36524a.mo7641w();
        Function1 c28581 = new Function1<LinkViewHolder, Unit>(this.f36524a) {
            public final KDeclarationContainer mo6931a() {
                return Reflection.m26850a(PopularListingScreen.class);
            }

            public final String mo5687b() {
                return "retainPlayersInFeed";
            }

            public final String mo6932c() {
                return "retainPlayersInFeed(Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LinkViewHolder;)V";
            }

            public final /* bridge */ /* synthetic */ Object mo6492a(Object obj) {
                ((PopularListingScreen) this.b).m40627a((LinkViewHolder) obj);
                return Unit.f25273a;
            }
        };
        ListingViewMode b = this.f36524a.f40038G;
        if (b == null) {
            Intrinsics.m26842a();
        }
        return new SubscribeListingAdapter(context, w, c28581, b, this.f36524a.geopopularRegionName, "popular", new Function0<Boolean>() {
            public final /* synthetic */ Object invoke() {
                return Boolean.valueOf(this.f36524a.an());
            }
        }, new Function2<SortType, SortTimeFrame, Unit>(this.f36524a) {
            public final KDeclarationContainer mo6931a() {
                return Reflection.m26850a(PopularListingScreen.class);
            }

            public final String mo5687b() {
                return "showSortDialog";
            }

            public final String mo6932c() {
                return "showSortDialog(Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;)V";
            }

            public final /* synthetic */ Object mo6497a(Object obj, Object obj2) {
                SortType sortType = (SortType) obj;
                SortTimeFrame sortTimeFrame = (SortTimeFrame) obj2;
                Intrinsics.m26847b(sortType, "p1");
                PopularListingScreen.m42015a((PopularListingScreen) this.b, sortType, sortTimeFrame);
                return Unit.f25273a;
            }
        }, new Function0<Unit>(this.f36524a) {
            public final KDeclarationContainer mo6931a() {
                return Reflection.m26850a(PopularListingScreen.class);
            }

            public final String mo5687b() {
                return "showViewModeOptions";
            }

            public final String mo6932c() {
                return "showViewModeOptions()V";
            }

            public final /* synthetic */ Object invoke() {
                PopularListingScreen.m42018d((PopularListingScreen) this.b);
                return Unit.f25273a;
            }
        }, new Function0<Unit>(this.f36524a) {
            public final KDeclarationContainer mo6931a() {
                return Reflection.m26850a(PopularListingScreen.class);
            }

            public final String mo5687b() {
                return "showGeopopularDialog";
            }

            public final String mo6932c() {
                return "showGeopopularDialog()V";
            }

            public final /* synthetic */ Object invoke() {
                PopularListingScreen.m42019e((PopularListingScreen) this.b);
                return Unit.f25273a;
            }
        });
    }
}
