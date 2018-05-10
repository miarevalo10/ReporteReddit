package com.reddit.frontpage.foursquare;

import android.content.Context;
import android.location.Geocoder;
import io.reactivex.functions.BiFunction;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final /* synthetic */ class FoursquareVenueDataProvider$$Lambda$0 implements BiFunction {
    private final FoursquareVenueDataProvider f28028a;
    private final Context f28029b;

    public FoursquareVenueDataProvider$$Lambda$0(FoursquareVenueDataProvider foursquareVenueDataProvider, Context context) {
        this.f28028a = foursquareVenueDataProvider;
        this.f28029b = context;
    }

    public final Object apply(Object obj, Object obj2) {
        List list = (List) obj;
        List list2 = (List) obj2;
        Geocoder geocoder = new Geocoder(this.f28029b);
        Map linkedHashMap = new LinkedHashMap();
        FoursquareVenueDataProvider.m29339a(geocoder, list, linkedHashMap);
        FoursquareVenueDataProvider.m29339a(geocoder, list2, linkedHashMap);
        ArrayList arrayList = new ArrayList((linkedHashMap.size() + list2.size()) + list.size());
        arrayList.addAll(linkedHashMap.values());
        arrayList.addAll(list2);
        arrayList.addAll(list);
        return arrayList;
    }
}
