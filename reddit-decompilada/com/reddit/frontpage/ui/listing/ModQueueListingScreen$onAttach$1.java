package com.reddit.frontpage.ui.listing;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "numSelected", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 1, 9})
/* compiled from: ModQueueListingScreen.kt */
final class ModQueueListingScreen$onAttach$1<T> implements Consumer<Integer> {
    final /* synthetic */ ModQueueListingScreen f29059a;

    ModQueueListingScreen$onAttach$1(ModQueueListingScreen modQueueListingScreen) {
        this.f29059a = modQueueListingScreen;
    }

    public final /* synthetic */ void accept(Object obj) {
        Integer num = (Integer) obj;
        if (num != null) {
            if (num.intValue() == 0) {
                this.f29059a.C.e();
                obj = this.f29059a.as();
                if (obj != null) {
                    obj.setVisibility(8);
                }
                return;
            }
        }
        if (num != null && num.intValue() == 1) {
            obj = this.f29059a.as();
            if (obj != null) {
                obj.setVisibility(0);
            }
        }
    }
}
