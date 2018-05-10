package com.reddit.frontpage.ui.listing.adapter.ads;

import com.reddit.datalibrary.frontpage.requests.models.v2.Identifiable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000*\n\b\u0000\u0010\u0001 \u0000*\u00020\u00022\u00020\u0003B=\b\u0007\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001b\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u000eH\u0002¢\u0006\u0002\u0010\u0014J\u001d\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u000eH\u0002¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0016R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00100\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/reddit/frontpage/ui/listing/adapter/ads/AdImpressionCalculator;", "T", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Identifiable;", "", "onImpression", "Lkotlin/Function1;", "", "onViewableImpression", "delayer", "Lcom/reddit/frontpage/ui/listing/adapter/ads/Delayer;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcom/reddit/frontpage/ui/listing/adapter/ads/Delayer;)V", "adLastVisibility", "", "", "", "viewableImpressionRunnable", "Ljava/lang/Runnable;", "adVisibilityChanged", "link", "visiblePercent", "(Lcom/reddit/datalibrary/frontpage/requests/models/v2/Identifiable;F)V", "cancelViewableImpressionCounter", "(Lcom/reddit/datalibrary/frontpage/requests/models/v2/Identifiable;)V", "checkImpression", "checkViewableImpression", "startViewableImpressionCounter", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AdImpressionCalculator.kt */
public final class AdImpressionCalculator<T extends Identifiable> {
    private final Map<Long, Float> f21331a;
    private final Map<Long, Runnable> f21332b;
    private final Function1<T, Unit> f21333c;
    private final Function1<T, Unit> f21334d;
    private final Delayer f21335e;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002 \u0000*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Identifiable;", "it", "invoke", "(Lcom/reddit/datalibrary/frontpage/requests/models/v2/Identifiable;)V"}, k = 3, mv = {1, 1, 9})
    /* compiled from: AdImpressionCalculator.kt */
    static final class C29001 extends Lambda implements Function1<T, Unit> {
        public static final C29001 f37289a = new C29001();

        C29001() {
            super(1);
        }

        public final /* synthetic */ Object mo6492a(Object obj) {
            Intrinsics.m26847b((Identifiable) obj, "it");
            return Unit.f25273a;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002 \u0000*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Identifiable;", "it", "invoke", "(Lcom/reddit/datalibrary/frontpage/requests/models/v2/Identifiable;)V"}, k = 3, mv = {1, 1, 9})
    /* compiled from: AdImpressionCalculator.kt */
    static final class C29012 extends Lambda implements Function1<T, Unit> {
        public static final C29012 f37290a = new C29012();

        C29012() {
            super(1);
        }

        public final /* synthetic */ Object mo6492a(Object obj) {
            Intrinsics.m26847b((Identifiable) obj, "it");
            return Unit.f25273a;
        }
    }

    public AdImpressionCalculator() {
        this(null, null, null, 7);
    }

    public AdImpressionCalculator(Function1<? super T, Unit> function1, Function1<? super T, Unit> function12) {
        this(function1, function12, null, 4);
    }

    private AdImpressionCalculator(Function1<? super T, Unit> function1, Function1<? super T, Unit> function12, Delayer delayer) {
        Intrinsics.m26847b(function1, "onImpression");
        Intrinsics.m26847b(function12, "onViewableImpression");
        Intrinsics.m26847b(delayer, "delayer");
        this.f21333c = function1;
        this.f21334d = function12;
        this.f21335e = delayer;
        this.f21331a = (Map) new LinkedHashMap();
        this.f21332b = (Map) new LinkedHashMap();
    }

    private /* synthetic */ AdImpressionCalculator(Function1 function1, Function1 function12, Delayer delayer, int i) {
        if ((i & 1) != 0) {
            function1 = C29001.f37289a;
        }
        if ((i & 2) != 0) {
            function12 = C29012.f37290a;
        }
        if ((i & 4) != 0) {
            delayer = new DelayedHandler();
        }
        this(function1, function12, delayer);
    }

    public final void m23442a(T t, float f) {
        Intrinsics.m26847b(t, "link");
        if (!this.f21331a.containsKey(Long.valueOf(t.getUniqueID()))) {
            this.f21331a.put(Long.valueOf(t.getUniqueID()), Float.valueOf(0.0f));
        }
        Object obj = this.f21331a.get(Long.valueOf(t.getUniqueID()));
        if (obj == null) {
            Intrinsics.m26842a();
        }
        if (((Number) obj).floatValue() <= 0.0f && f > 0.0f) {
            this.f21333c.mo6492a(t);
        }
        obj = this.f21331a.get(Long.valueOf(t.getUniqueID()));
        if (obj == null) {
            Intrinsics.m26842a();
        }
        Runnable runnable;
        if (((Number) obj).doubleValue() >= 0.5d || ((double) f) < 0.5d) {
            obj = this.f21331a.get(Long.valueOf(t.getUniqueID()));
            if (obj == null) {
                Intrinsics.m26842a();
            }
            if (((Number) obj).doubleValue() >= 0.5d && ((double) f) < 0.5d) {
                runnable = (Runnable) this.f21332b.get(Long.valueOf(t.getUniqueID()));
                this.f21332b.put(Long.valueOf(t.getUniqueID()), null);
                if (runnable != null) {
                    StringBuilder stringBuilder = new StringBuilder("Cancelling viewable impression counter for ad ");
                    stringBuilder.append(t.getUniqueID());
                    Timber.a(stringBuilder.toString(), new Object[0]);
                    this.f21335e.mo4998b(runnable);
                }
            }
        } else if (this.f21332b.get(Long.valueOf(t.getUniqueID())) == null) {
            runnable = new AdImpressionCalculator$startViewableImpressionCounter$runnable$1(this, t);
            this.f21332b.put(Long.valueOf(t.getUniqueID()), runnable);
            this.f21335e.mo4997a(runnable);
            StringBuilder stringBuilder2 = new StringBuilder("Starting viewable impression counter for ad ");
            stringBuilder2.append(t.getUniqueID());
            Timber.a(stringBuilder2.toString(), new Object[0]);
        }
        this.f21331a.put(Long.valueOf(t.getUniqueID()), Float.valueOf(f));
    }
}
