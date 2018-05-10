package com.reddit.frontpage.presentation.analytics;

import com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel;
import java.util.Set;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H&J&\u0010\n\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H&J.\u0010\u000b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H&J.\u0010\u000e\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H&J6\u0010\u000f\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H&J.\u0010\u0012\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H&J&\u0010\u0013\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H&¨\u0006\u0014"}, d2 = {"Lcom/reddit/frontpage/presentation/analytics/CarouselAnalytics;", "", "onCarouselCollectionSubscribed", "", "idsSeen", "", "", "item", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;", "screenName", "onCarouselImpression", "onCarouselItemDismissed", "position", "", "onCarouselItemSelected", "onCarouselItemSubscribed", "subscribed", "", "onCarouselSelected", "onCarouselShowLessSelected", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CarouselAnalytics.kt */
public interface CarouselAnalytics {
    void mo4771a(Set<String> set, int i, CarouselCollectionPresentationModel carouselCollectionPresentationModel, String str);

    void mo4772a(Set<String> set, int i, CarouselCollectionPresentationModel carouselCollectionPresentationModel, String str, boolean z);

    void mo4773a(Set<String> set, CarouselCollectionPresentationModel carouselCollectionPresentationModel, String str);

    void mo4774b(Set<String> set, int i, CarouselCollectionPresentationModel carouselCollectionPresentationModel, String str);

    void mo4775b(Set<String> set, CarouselCollectionPresentationModel carouselCollectionPresentationModel, String str);

    void mo4776c(Set<String> set, CarouselCollectionPresentationModel carouselCollectionPresentationModel, String str);

    void mo4777d(Set<String> set, CarouselCollectionPresentationModel carouselCollectionPresentationModel, String str);
}
