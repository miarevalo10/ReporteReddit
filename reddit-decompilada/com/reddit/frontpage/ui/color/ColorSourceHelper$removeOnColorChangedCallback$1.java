package com.reddit.frontpage.ui.color;

import com.reddit.frontpage.ui.color.ColorSource.OnColorChangedCallback;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/ref/WeakReference;", "Lcom/reddit/frontpage/ui/color/ColorSource$OnColorChangedCallback;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ColorSource.kt */
final class ColorSourceHelper$removeOnColorChangedCallback$1 extends Lambda implements Function1<WeakReference<OnColorChangedCallback>, Boolean> {
    final /* synthetic */ OnColorChangedCallback f37245a;

    ColorSourceHelper$removeOnColorChangedCallback$1(OnColorChangedCallback onColorChangedCallback) {
        this.f37245a = onColorChangedCallback;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        WeakReference weakReference = (WeakReference) obj;
        Intrinsics.m26847b(weakReference, "it");
        return Boolean.valueOf(Intrinsics.m26845a((OnColorChangedCallback) weakReference.get(), this.f37245a));
    }
}
