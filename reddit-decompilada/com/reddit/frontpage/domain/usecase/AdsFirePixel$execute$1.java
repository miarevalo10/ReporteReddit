package com.reddit.frontpage.domain.usecase;

import com.bumptech.glide.load.model.Headers;
import com.reddit.datalibrary.frontpage.redditauth.Config;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u001e\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getHeaders"}, k = 3, mv = {1, 1, 9})
/* compiled from: AdsFirePixel.kt */
final class AdsFirePixel$execute$1 implements Headers {
    public static final AdsFirePixel$execute$1 f27964c = new AdsFirePixel$execute$1();

    AdsFirePixel$execute$1() {
    }

    public final Map<String, String> m29309a() {
        return MapsKt__MapsKt.m36121a(TuplesKt.m26780a("X-Dev-Ad-Id", Config.f()), TuplesKt.m26780a("x-reddaid", Config.e()));
    }
}
