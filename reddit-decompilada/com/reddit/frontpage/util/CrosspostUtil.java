package com.reddit.frontpage.util;

import com.reddit.datalibrary.frontpage.requests.models.v1.ImageResolution;
import com.reddit.frontpage.C1761R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R!\u0010\u0005\u001a\u00020\u00048FX\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/util/CrosspostUtil;", "", "()V", "MIN_PREVIEW_HEIGHT", "", "crosspostContentWidth", "crosspostContentWidth$annotations", "getCrosspostContentWidth", "()I", "crosspostContentWidth$delegate", "Lkotlin/Lazy;", "getCroppedImageHeight", "previewImage", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/ImageResolution;", "parentWidth", "getScaledImageHeight", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CrosspostUtil.kt */
public final class CrosspostUtil {
    static final /* synthetic */ KProperty[] f21710a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CrosspostUtil.class), "crosspostContentWidth", "getCrosspostContentWidth()I"))};
    public static final int f21711b = Util.m24012d((int) C1761R.dimen.link_image_min_height);
    public static final CrosspostUtil f21712c = new CrosspostUtil();
    private static final Lazy f21713d = LazyKt.m26777a(CrosspostUtil$crosspostContentWidth$2.f37393a);

    public static final int m23675a() {
        return ((Number) f21713d.mo5678b()).intValue();
    }

    private CrosspostUtil() {
    }

    public static final int m23676a(ImageResolution imageResolution, int i) {
        Intrinsics.m26847b(imageResolution, "previewImage");
        int height = imageResolution.getHeight();
        imageResolution = imageResolution.getWidth();
        if (height >= imageResolution) {
            return (int) (((float) i) * 1061158912);
        }
        return Math.max((i * height) / imageResolution, f21711b);
    }

    public static final int m23677b(ImageResolution imageResolution, int i) {
        Intrinsics.m26847b(imageResolution, "previewImage");
        return Math.max(((i * imageResolution.getHeight()) / imageResolution.getWidth()) + 1, f21711b);
    }
}
