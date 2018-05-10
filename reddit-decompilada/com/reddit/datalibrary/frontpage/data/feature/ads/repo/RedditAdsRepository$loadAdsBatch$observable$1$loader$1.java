package com.reddit.datalibrary.frontpage.data.feature.ads.repo;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditAdsRepository.kt */
final class RedditAdsRepository$loadAdsBatch$observable$1$loader$1 extends FunctionReference implements Function0<Integer> {
    RedditAdsRepository$loadAdsBatch$observable$1$loader$1(AtomicInteger atomicInteger) {
        super(0, atomicInteger);
    }

    public final KDeclarationContainer m20618a() {
        return Reflection.a(AtomicInteger.class);
    }

    public final String m20619b() {
        return "getAndIncrement";
    }

    public final String m20620c() {
        return "getAndIncrement()I";
    }

    public final /* synthetic */ Object invoke() {
        return Integer.valueOf(((AtomicInteger) this.b).getAndIncrement());
    }
}
