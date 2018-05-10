package com.reddit.frontpage.presentation.analytics;

import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v1.BaseEvent;
import com.reddit.frontpage.commons.analytics.events.v1.CarouselEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ControlTabEvent;
import com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u0005¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0002J>\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0002J&\u0010\u0010\u001a\u00020\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0006H\u0016J&\u0010\u0014\u001a\u00020\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0006H\u0016J.\u0010\u0015\u001a\u00020\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0006H\u0016J.\u0010\u0016\u001a\u00020\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0006H\u0016J6\u0010\u0017\u001a\u00020\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J.\u0010\u001a\u001a\u00020\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0006H\u0016J&\u0010\u001b\u001a\u00020\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\f\u0010\u001e\u001a\u00020\u000b*\u00020\u0013H\u0002¨\u0006!"}, d2 = {"Lcom/reddit/frontpage/presentation/analytics/RedditCarouselAnalytics;", "Lcom/reddit/frontpage/presentation/analytics/CarouselAnalytics;", "()V", "createCarouselEvent", "Lcom/reddit/frontpage/commons/analytics/events/v1/CarouselEvent;", "controlName", "", "eventType", "idsSeen", "", "info", "Lcom/reddit/frontpage/presentation/analytics/RedditCarouselAnalytics$CarouselCollectionInfo;", "screenName", "createCarouselItemEvent", "position", "", "onCarouselCollectionSubscribed", "", "item", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;", "onCarouselImpression", "onCarouselItemDismissed", "onCarouselItemSelected", "onCarouselItemSubscribed", "subscribed", "", "onCarouselSelected", "onCarouselShowLessSelected", "send", "event", "getCarouselCollectionInfo", "CarouselCollectionInfo", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditCarouselAnalytics.kt */
public final class RedditCarouselAnalytics implements CarouselAnalytics {
    public static final Companion f28061a = new Companion();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/reddit/frontpage/presentation/analytics/RedditCarouselAnalytics$CarouselCollectionInfo;", "", "discoveryUnit", "Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;", "numItems", "", "(Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;I)V", "getDiscoveryUnit", "()Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;", "getNumItems", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RedditCarouselAnalytics.kt */
    private static final class CarouselCollectionInfo {
        final DiscoveryUnit f20325a;
        final int f20326b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CarouselCollectionInfo) {
                CarouselCollectionInfo carouselCollectionInfo = (CarouselCollectionInfo) obj;
                if (Intrinsics.m26845a(this.f20325a, carouselCollectionInfo.f20325a)) {
                    if (this.f20326b == carouselCollectionInfo.f20326b) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final int hashCode() {
            DiscoveryUnit discoveryUnit = this.f20325a;
            return ((discoveryUnit != null ? discoveryUnit.hashCode() : 0) * 31) + this.f20326b;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("CarouselCollectionInfo(discoveryUnit=");
            stringBuilder.append(this.f20325a);
            stringBuilder.append(", numItems=");
            stringBuilder.append(this.f20326b);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public CarouselCollectionInfo(DiscoveryUnit discoveryUnit, int i) {
            Intrinsics.m26847b(discoveryUnit, "discoveryUnit");
            this.f20325a = discoveryUnit;
            this.f20326b = i;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/presentation/analytics/RedditCarouselAnalytics$Companion;", "", "()V", "CONTROL_NAME_CAROUSEL_ITEM_CLICK", "", "CONTROL_NAME_CAROUSEL_ITEM_DISMISS", "CONTROL_NAME_CAROUSEL_ITEM_SUBSCRIBE", "CONTROL_NAME_CAROUSEL_ITEM_UNSUBSCRIBE", "CONTROL_NAME_CAROUSEL_POST_GALLERY_LINK", "CONTROL_NAME_CAROUSEL_POST_GALLERY_SUBSCRIBE", "CONTROL_NAME_CAROUSEL_SHOW_LESS_BUTTON", "EVENT_TYPE_CLICK", "EVENT_TYPE_IMPRESSION", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RedditCarouselAnalytics.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final void mo4773a(Set<String> set, CarouselCollectionPresentationModel carouselCollectionPresentationModel, String str) {
        Intrinsics.m26847b(set, "idsSeen");
        Intrinsics.m26847b(carouselCollectionPresentationModel, "item");
        Intrinsics.m26847b(str, "screenName");
        AppAnalytics.m21852a((BaseEvent) m29388a("carousel_post_gallery_link", ControlTabEvent.CONTROL_TAB_EVENT_TYPE, (Set) set, m29389a(carouselCollectionPresentationModel), str));
    }

    public final void mo4771a(Set<String> set, int i, CarouselCollectionPresentationModel carouselCollectionPresentationModel, String str) {
        Intrinsics.m26847b(set, "idsSeen");
        Intrinsics.m26847b(carouselCollectionPresentationModel, "item");
        Intrinsics.m26847b(str, "screenName");
        AppAnalytics.m21852a((BaseEvent) m29387a("carousel_item_post", ControlTabEvent.CONTROL_TAB_EVENT_TYPE, set, i, m29389a(carouselCollectionPresentationModel), str));
    }

    public final void mo4774b(Set<String> set, int i, CarouselCollectionPresentationModel carouselCollectionPresentationModel, String str) {
        Intrinsics.m26847b(set, "idsSeen");
        Intrinsics.m26847b(carouselCollectionPresentationModel, "item");
        Intrinsics.m26847b(str, "screenName");
        AppAnalytics.m21852a((BaseEvent) m29387a("carousel_hide_subreddit", ControlTabEvent.CONTROL_TAB_EVENT_TYPE, set, i, m29389a(carouselCollectionPresentationModel), str));
    }

    public final void mo4772a(Set<String> set, int i, CarouselCollectionPresentationModel carouselCollectionPresentationModel, String str, boolean z) {
        Intrinsics.m26847b(set, "idsSeen");
        Intrinsics.m26847b(carouselCollectionPresentationModel, "item");
        Intrinsics.m26847b(str, "screenName");
        AppAnalytics.m21852a((BaseEvent) m29387a(z ? "carousel_subreddit_subscribe" : "carousel_subreddit_unsubscribe", ControlTabEvent.CONTROL_TAB_EVENT_TYPE, set, i, m29389a(carouselCollectionPresentationModel), str));
    }

    public final void mo4775b(Set<String> set, CarouselCollectionPresentationModel carouselCollectionPresentationModel, String str) {
        Intrinsics.m26847b(set, "idsSeen");
        Intrinsics.m26847b(carouselCollectionPresentationModel, "item");
        Intrinsics.m26847b(str, "screenName");
        AppAnalytics.m21852a((BaseEvent) m29388a("carousel_post_gallery_subscribe", ControlTabEvent.CONTROL_TAB_EVENT_TYPE, (Set) set, m29389a(carouselCollectionPresentationModel), str));
    }

    public final void mo4776c(Set<String> set, CarouselCollectionPresentationModel carouselCollectionPresentationModel, String str) {
        Intrinsics.m26847b(set, "idsSeen");
        Intrinsics.m26847b(carouselCollectionPresentationModel, "item");
        Intrinsics.m26847b(str, "screenName");
        AppAnalytics.m21852a((BaseEvent) m29388a("", "cs.carousel_impression", (Set) set, m29389a(carouselCollectionPresentationModel), str));
    }

    public final void mo4777d(Set<String> set, CarouselCollectionPresentationModel carouselCollectionPresentationModel, String str) {
        Intrinsics.m26847b(set, "idsSeen");
        Intrinsics.m26847b(carouselCollectionPresentationModel, "item");
        Intrinsics.m26847b(str, "screenName");
        AppAnalytics.m21852a((BaseEvent) m29388a("carousel_show_less_button", ControlTabEvent.CONTROL_TAB_EVENT_TYPE, (Set) set, m29389a(carouselCollectionPresentationModel), str));
    }

    private static CarouselCollectionInfo m29389a(CarouselCollectionPresentationModel carouselCollectionPresentationModel) {
        DiscoveryUnit a = carouselCollectionPresentationModel.mo6934a();
        if (a == null) {
            Intrinsics.m26842a();
        }
        return new CarouselCollectionInfo(a, carouselCollectionPresentationModel.mo6935b());
    }

    private static CarouselEvent m29388a(String str, String str2, Set<String> set, CarouselCollectionInfo carouselCollectionInfo, String str3) {
        DiscoveryUnit discoveryUnit = carouselCollectionInfo.f20325a;
        String str4 = carouselCollectionInfo.f20325a.unique_id;
        String str5 = discoveryUnit.unit_type;
        int i = carouselCollectionInfo.f20326b;
        carouselCollectionInfo = discoveryUnit.url;
        if (carouselCollectionInfo == null) {
            carouselCollectionInfo = "";
        }
        return new CarouselEvent(str3, str2, set, str4, str5, str, i, carouselCollectionInfo);
    }

    private static CarouselEvent m29387a(String str, String str2, Set<String> set, int i, CarouselCollectionInfo carouselCollectionInfo, String str3) {
        CarouselCollectionInfo carouselCollectionInfo2 = carouselCollectionInfo;
        DiscoveryUnit discoveryUnit = carouselCollectionInfo2.f20325a;
        String str4 = discoveryUnit.unique_id;
        String str5 = discoveryUnit.unit_type;
        int i2 = carouselCollectionInfo2.f20326b;
        Integer valueOf = Integer.valueOf(i);
        String str6 = discoveryUnit.url;
        if (str6 == null) {
            str6 = "";
        }
        return new CarouselEvent(str3, str2, set, str4, str5, str, i2, valueOf, str6);
    }
}
