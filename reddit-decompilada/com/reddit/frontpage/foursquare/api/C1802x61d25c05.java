package com.reddit.frontpage.foursquare.api;

import com.reddit.frontpage.foursquare.model.LocationDistance;
import java.util.Comparator;

final /* synthetic */ class C1802x61d25c05 implements Comparator {
    static final Comparator f20300a = new C1802x61d25c05();

    private C1802x61d25c05() {
    }

    public final int compare(Object obj, Object obj2) {
        return Double.compare(((LocationDistance) obj).f20307d, ((LocationDistance) obj2).f20307d);
    }
}
