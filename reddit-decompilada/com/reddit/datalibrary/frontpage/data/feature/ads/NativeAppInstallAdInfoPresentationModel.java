package com.reddit.datalibrary.frontpage.data.feature.ads;

import com.google.android.gms.ads.formats.NativeAppInstallAd;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/ads/NativeAppInstallAdInfoPresentationModel;", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/NativeAdInfoPresentationModel;", "Lcom/google/android/gms/ads/formats/NativeAppInstallAd;", "stableId", "", "nativeAd", "aspectRatio", "", "(JLcom/google/android/gms/ads/formats/NativeAppInstallAd;F)V", "hasVideo", "", "getHasVideo", "()Z", "listableType", "", "getListableType", "()I", "destroy", "", "getUniqueID", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: NativeAdInfoPresentationModel.kt */
public final class NativeAppInstallAdInfoPresentationModel extends NativeAdInfoPresentationModel<NativeAppInstallAd> {
    private final boolean f19340e;
    private final long f19341f;

    public final int getListableType() {
        return 9;
    }

    public NativeAppInstallAdInfoPresentationModel(long j, NativeAppInstallAd nativeAppInstallAd, float f) {
        Intrinsics.b(nativeAppInstallAd, "nativeAd");
        super(nativeAppInstallAd, f);
        this.f19341f = j;
        this.f19340e = nativeAppInstallAd.mo3555j().m4384b();
    }

    public final long getUniqueID() {
        return this.f19341f;
    }

    public final boolean mo4198a() {
        return this.f19340e;
    }
}
