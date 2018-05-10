package com.reddit.frontpage.ui.color;

import com.reddit.frontpage.ui.color.ColorSource.OnColorChangedCallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0002R0\u0010\u0003\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005`\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR*\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@VX\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@VX\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/reddit/frontpage/ui/color/ColorSourceHelper;", "Lcom/reddit/frontpage/ui/color/ColorSource;", "()V", "callbacks", "Ljava/util/ArrayList;", "Ljava/lang/ref/WeakReference;", "Lcom/reddit/frontpage/ui/color/ColorSource$OnColorChangedCallback;", "Lkotlin/collections/ArrayList;", "getCallbacks", "()Ljava/util/ArrayList;", "color", "", "keyColor", "getKeyColor", "()Ljava/lang/Integer;", "setKeyColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "topColor", "getTopColor", "setTopColor", "addOnColorChangedCallback", "", "callback", "removeOnColorChangedCallback", "trimCallbacks", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ColorSource.kt */
public final class ColorSourceHelper implements ColorSource {
    public Integer f28924a;
    public Integer f28925b;
    private final ArrayList<WeakReference<OnColorChangedCallback>> f28926c = new ArrayList();

    public final Integer mo4954w() {
        return this.f28924a;
    }

    public final void mo4951a(Integer num) {
        if ((Intrinsics.m26845a((Object) num, this.f28924a) ^ 1) != 0) {
            this.f28924a = num;
            for (WeakReference weakReference : this.f28926c) {
                OnColorChangedCallback onColorChangedCallback = (OnColorChangedCallback) weakReference.get();
                if (onColorChangedCallback != null) {
                    onColorChangedCallback.mo4943c(num);
                }
            }
        }
        m29976a();
    }

    public final Integer mo4949M() {
        return this.f28925b;
    }

    public final void mo4953b(Integer num) {
        if ((Intrinsics.m26845a((Object) num, this.f28925b) ^ 1) != 0) {
            this.f28925b = num;
            for (WeakReference weakReference : this.f28926c) {
                OnColorChangedCallback onColorChangedCallback = (OnColorChangedCallback) weakReference.get();
                if (onColorChangedCallback != null) {
                    onColorChangedCallback.mo4944d(num);
                }
            }
        }
        m29976a();
    }

    public final void mo4950a(OnColorChangedCallback onColorChangedCallback) {
        Intrinsics.m26847b(onColorChangedCallback, "callback");
        this.f28926c.add(new WeakReference(onColorChangedCallback));
    }

    public final void mo4952b(OnColorChangedCallback onColorChangedCallback) {
        Intrinsics.m26847b(onColorChangedCallback, "callback");
        CollectionsKt__MutableCollectionsKt.m38197b((List) this.f28926c, (Function1) new ColorSourceHelper$removeOnColorChangedCallback$1(onColorChangedCallback));
    }

    private final boolean m29976a() {
        return CollectionsKt__MutableCollectionsKt.m38198c(this.f28926c, ColorSourceHelper$trimCallbacks$1.f37246a);
    }
}
