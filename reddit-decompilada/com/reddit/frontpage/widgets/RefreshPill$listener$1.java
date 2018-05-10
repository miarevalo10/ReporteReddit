package com.reddit.frontpage.widgets;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\"\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0006\u0010\u0019\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\f\u0010\u0007R\u000e\u0010\u000e\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"com/reddit/frontpage/widgets/RefreshPill$listener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "(Lcom/reddit/frontpage/widgets/RefreshPill;Landroid/content/Context;)V", "DEFAULT_PIXELS_SCROLLED", "", "INITIAL_DISTANCE_TO_TRAVEL", "getINITIAL_DISTANCE_TO_TRAVEL", "()F", "INITIAL_DISTANCE_TO_TRAVEL$delegate", "Lkotlin/Lazy;", "MAX_SCROLL_THRESHOLD", "MIN_SCROLL_THRESHOLD", "getMIN_SCROLL_THRESHOLD", "MIN_SCROLL_THRESHOLD$delegate", "SCROLL_DAMPENING", "numPixelsScrolled", "moveVertically", "", "amount", "onScrolled", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "reset", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RefreshPill.kt */
public final class RefreshPill$listener$1 extends OnScrollListener {
    static final /* synthetic */ KProperty[] f29477a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(RefreshPill$listener$1.class), "MIN_SCROLL_THRESHOLD", "getMIN_SCROLL_THRESHOLD()F")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(RefreshPill$listener$1.class), "INITIAL_DISTANCE_TO_TRAVEL", "getINITIAL_DISTANCE_TO_TRAVEL()F"))};
    final float f29478b;
    float f29479c = this.f29478b;
    final /* synthetic */ RefreshPill f29480d;
    final /* synthetic */ Context f29481e;
    private final float f29482f = 10.0f;
    private final float f29483g;
    private final Lazy f29484h = LazyKt.m26777a((Function0) new RefreshPill$listener$1$MIN_SCROLL_THRESHOLD$2(this));
    private final Lazy f29485i = LazyKt.m26777a((Function0) new RefreshPill$listener$1$INITIAL_DISTANCE_TO_TRAVEL$2(this));

    RefreshPill$listener$1(RefreshPill refreshPill, Context context) {
        this.f29480d = refreshPill;
        this.f29481e = context;
    }

    public final void m30494a(RecyclerView recyclerView, int i, int i2) {
        super.a(recyclerView, i, i2);
        recyclerView = (-((float) i2)) / this.f29482f;
        if (this.f29480d.f21943b != 0 && this.f29479c + recyclerView <= this.f29483g) {
            if (this.f29479c + recyclerView >= ((Number) this.f29484h.mo5678b()).floatValue()) {
                this.f29479c += recyclerView;
                i = this.f29480d;
                i.setY(i.getY() + recyclerView);
            }
        }
    }
}
