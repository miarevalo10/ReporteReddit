package com.reddit.frontpage.ui.listing;

import android.app.Activity;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.ui.home.TooltipPopupWindow;
import com.reddit.frontpage.ui.home.TooltipPopupWindow.Companion;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.ListingFilterBarView;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "seen", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 1, 9})
/* compiled from: LegacyPopularListingScreen.kt */
final class LegacyPopularListingScreen$showGeopopularTooltipIfNeeded$1<T> implements Consumer<Boolean> {
    final /* synthetic */ LegacyPopularListingScreen f29049a;
    final /* synthetic */ ListingFilterBarView f29050b;
    final /* synthetic */ PreferenceRepository f29051c;

    LegacyPopularListingScreen$showGeopopularTooltipIfNeeded$1(LegacyPopularListingScreen legacyPopularListingScreen, ListingFilterBarView listingFilterBarView, PreferenceRepository preferenceRepository) {
        this.f29049a = legacyPopularListingScreen;
        this.f29050b = listingFilterBarView;
        this.f29051c = preferenceRepository;
    }

    public final /* synthetic */ void accept(Object obj) {
        if (((Boolean) obj).booleanValue() == null) {
            obj = this.f29050b.getGeopopularTextPosition();
            Activity am_ = this.f29049a.am_();
            if (am_ == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.content.Context");
            }
            TooltipPopupWindow tooltipPopupWindow = new TooltipPopupWindow(am_, Util.m23955a(this.f29049a.am_()).x);
            Object T_ = this.f29049a.T_();
            if (T_ == null) {
                Intrinsics.m26842a();
            }
            Intrinsics.m26843a(T_, "view!!");
            int i = obj.x;
            obj = obj.y;
            Intrinsics.m26847b(T_, "parent");
            LayoutParams layoutParams = tooltipPopupWindow.f21228b.getLayoutParams();
            if (layoutParams == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.rightMargin = (tooltipPopupWindow.f21229c / 2) - i;
            tooltipPopupWindow.f21228b.setLayoutParams(layoutParams2);
            tooltipPopupWindow.f21227a.showAtLocation(T_, 0, i, obj);
            Function0 function0 = (Function0) new Function0<Unit>() {
                public final /* synthetic */ Object invoke() {
                    PreferenceRepository preferenceRepository = this.f29051c;
                    Companion companion = TooltipPopupWindow.f21224d;
                    preferenceRepository.m22468a(Companion.m23372a()).subscribe();
                    return Unit.f25273a;
                }
            };
            Intrinsics.m26847b(function0, "listener");
            tooltipPopupWindow.f21227a.setOnDismissListener(new TooltipPopupWindow$setOnDismissListener$1(function0));
        }
    }
}
