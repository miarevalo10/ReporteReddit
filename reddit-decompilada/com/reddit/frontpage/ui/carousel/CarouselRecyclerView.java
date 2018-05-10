package com.reddit.frontpage.ui.carousel;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\n*\u0001\u001b\u0018\u00002\u00020\u0001:\u0001#BL\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012%\b\u0002\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\t¢\u0006\u0002\u0010\u000eJ\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u0010H\u0002R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0004\n\u0002\u0010\u001cR7\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/reddit/frontpage/ui/carousel/CarouselRecyclerView;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "snapListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "position", "", "(Landroid/content/Context;Landroid/util/AttributeSet;ILkotlin/jvm/functions/Function1;)V", "allowSnapping", "", "getAllowSnapping", "()Z", "setAllowSnapping", "(Z)V", "idsSeen", "", "", "getIdsSeen", "()Ljava/util/Set;", "snapHelper", "com/reddit/frontpage/ui/carousel/CarouselRecyclerView$snapHelper$1", "Lcom/reddit/frontpage/ui/carousel/CarouselRecyclerView$snapHelper$1;", "getSnapListener", "()Lkotlin/jvm/functions/Function1;", "setSnapListener", "(Lkotlin/jvm/functions/Function1;)V", "applySnapHelper", "enable", "ViewAttachListener", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CarouselRecyclerView.kt */
public final class CarouselRecyclerView extends RecyclerView {
    private HashMap _$_findViewCache;
    private boolean allowSnapping;
    private final Set<String> idsSeen;
    private final CarouselRecyclerView$snapHelper$1 snapHelper;
    private Function1<? super Integer, Unit> snapListener;

    public CarouselRecyclerView(Context context) {
        this(context, null, 0, null, 14, null);
    }

    public CarouselRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, null, 12, null);
    }

    public CarouselRecyclerView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null, 8, null);
    }

    public final void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    public final View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), view);
        return view;
    }

    public /* synthetic */ CarouselRecyclerView(Context context, AttributeSet attributeSet, int i, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != null) {
            i = 0;
        }
        if ((i2 & 8) != 0) {
            function1 = null;
        }
        this(context, attributeSet, i, function1);
    }

    public final Function1<Integer, Unit> getSnapListener() {
        return this.snapListener;
    }

    public final void setSnapListener(Function1<? super Integer, Unit> function1) {
        this.snapListener = function1;
    }

    public CarouselRecyclerView(Context context, AttributeSet attributeSet, int i, Function1<? super Integer, Unit> function1) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        this.snapListener = function1;
        this.idsSeen = (Set) new LinkedHashSet();
        this.snapHelper = new CarouselRecyclerView$snapHelper$1(this);
        setLayoutManager((LayoutManager) new LinearLayoutManager(context, 0, false));
        addItemDecoration((ItemDecoration) new CarouselItemDecoration(Util.m24012d((int) C1761R.dimen.half_pad)));
        applySnapHelper(this.allowSnapping);
        addOnItemTouchListener((OnItemTouchListener) new OnItemTouchListener() {
            private float f28908b;
            private float f28909c;

            public final void m29958a(MotionEvent motionEvent) {
            }

            public final boolean m29959a(RecyclerView recyclerView, MotionEvent motionEvent) {
                Intrinsics.m26847b(recyclerView, "rv");
                recyclerView = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
                if (recyclerView != null) {
                    if (recyclerView.intValue() == 0) {
                        this.f28908b = motionEvent.getX();
                        this.f28909c = motionEvent.getY();
                        return false;
                    }
                }
                if (recyclerView != null) {
                    if (recyclerView.intValue() == 2) {
                        boolean z = true;
                        if (Math.abs(this.f28909c - motionEvent.getY()) < Math.abs(this.f28908b - motionEvent.getX())) {
                            this.getParent().requestDisallowInterceptTouchEvent(true);
                        }
                        recyclerView = this;
                        if (this.f28908b <= motionEvent.getX()) {
                            z = false;
                        }
                        recyclerView.applySnapHelper(z);
                    }
                }
                return false;
            }
        });
        addOnChildAttachStateChangeListener((OnChildAttachStateChangeListener) new OnChildAttachStateChangeListener() {
            public final void m29961b(View view) {
                Intrinsics.m26847b(view, "view");
                view = this.findContainingViewHolder(view);
                if (!(view instanceof LinkCarouselItemViewHolder)) {
                    view = null;
                }
                if (((LinkCarouselItemViewHolder) view) != null) {
                    LinkCarouselItemViewHolder.m29971x();
                }
            }

            public final void m29960a(View view) {
                Intrinsics.m26847b(view, "view");
                Set idsSeen = this.getIdsSeen();
                ViewHolder childViewHolder = this.getChildViewHolder(view);
                if (childViewHolder == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.ui.carousel.CarouselItemViewHolder");
                }
                idsSeen.add(((CarouselItemViewHolder) childViewHolder).ac_());
                view = this.findContainingViewHolder(view);
                if (!(view instanceof LinkCarouselItemViewHolder)) {
                    view = null;
                }
                if (((LinkCarouselItemViewHolder) view) != null) {
                    LinkCarouselItemViewHolder.m29972y();
                }
            }
        });
        if (VERSION.SDK_INT >= 26) {
            setFocusable(0);
        }
    }

    public final boolean getAllowSnapping() {
        return this.allowSnapping;
    }

    public final void setAllowSnapping(boolean z) {
        this.allowSnapping = z;
    }

    public final Set<String> getIdsSeen() {
        return this.idsSeen;
    }

    private final void applySnapHelper(boolean z) {
        if (this.allowSnapping) {
            this.snapHelper.a((RecyclerView) (z ? this : false));
        }
    }
}
