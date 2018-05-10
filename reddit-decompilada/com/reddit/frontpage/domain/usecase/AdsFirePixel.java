package com.reddit.frontpage.domain.usecase;

import android.content.Context;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/AdsFirePixel;", "Lcom/reddit/frontpage/domain/usecase/UseCase;", "", "Lcom/reddit/frontpage/domain/usecase/AdsPixelParams;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "execute", "params", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AdsFirePixel.kt */
public final class AdsFirePixel {
    public final Context f20267a;

    @Inject
    public AdsFirePixel(Context context) {
        Intrinsics.m26847b(context, "context");
        this.f20267a = context;
    }
}
