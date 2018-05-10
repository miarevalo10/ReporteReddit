package org.jetbrains.anko;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.AnkoContext.DefaultImpls;

@Metadata(bv = {1, 0, 1}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\u0013\u001a\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0014J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\fH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, d2 = {"Lorg/jetbrains/anko/AnkoContextImpl;", "T", "Lorg/jetbrains/anko/AnkoContext;", "ctx", "Landroid/content/Context;", "owner", "setContentView", "", "(Landroid/content/Context;Ljava/lang/Object;Z)V", "getCtx", "()Landroid/content/Context;", "myView", "Landroid/view/View;", "getOwner", "()Ljava/lang/Object;", "Ljava/lang/Object;", "view", "getView", "()Landroid/view/View;", "addView", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "alreadyHasView", "doAddView", "context", "commons_release"}, k = 1, mv = {1, 1, 5})
/* compiled from: AnkoContext.kt */
public class AnkoContextImpl<T> implements AnkoContext<T> {
    private View f33321b;
    private final Context f33322c;
    private final T f33323d;
    private final boolean f33324e = null;

    public AnkoContextImpl(Context context, T t) {
        Intrinsics.m26847b(context, "ctx");
        this.f33322c = context;
        this.f33323d = t;
    }

    public void removeView(View view) {
        Intrinsics.m26847b(view, "view");
        DefaultImpls.m28396a(view);
    }

    public void updateViewLayout(View view, LayoutParams layoutParams) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(layoutParams, "params");
        DefaultImpls.m28397a(view, layoutParams);
    }

    public final Context mo6314a() {
        return this.f33322c;
    }

    public final View mo6315b() {
        View view = this.f33321b;
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("View was not set previously");
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (view != null) {
            if (this.f33321b != null) {
                layoutParams = new StringBuilder("View is already set: ");
                layoutParams.append(this.f33321b);
                throw ((Throwable) new IllegalStateException(layoutParams.toString()));
            }
            this.f33321b = view;
            if (this.f33324e != null) {
                m33888a(this.f33322c, view);
            }
        }
    }

    private static void m33888a(Context context, View view) {
        while (!(context instanceof Activity)) {
            if (context instanceof ContextWrapper) {
                Object baseContext = ((ContextWrapper) context).getBaseContext();
                Intrinsics.m26843a(baseContext, "context.baseContext");
            } else {
                throw ((Throwable) new IllegalStateException("Context is not an Activity, can't set content view"));
            }
        }
        ((Activity) context).setContentView(view);
    }
}
