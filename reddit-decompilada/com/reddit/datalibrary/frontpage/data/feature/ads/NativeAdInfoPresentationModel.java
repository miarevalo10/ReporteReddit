package com.reddit.datalibrary.frontpage.data.feature.ads;

import com.google.android.gms.ads.formats.NativeAd;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003B\u0017\b\u0000\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001a\u001a\u00020\u001bH&J\u0006\u0010\u001c\u001a\u00020\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u0016XD¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/ads/NativeAdInfoPresentationModel;", "T", "Lcom/google/android/gms/ads/formats/NativeAd;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "nativeAd", "aspectRatio", "", "(Lcom/google/android/gms/ads/formats/NativeAd;F)V", "getAspectRatio", "()F", "destroyed", "", "getDestroyed", "()Z", "setDestroyed", "(Z)V", "hasVideo", "getHasVideo", "getNativeAd", "()Lcom/google/android/gms/ads/formats/NativeAd;", "Lcom/google/android/gms/ads/formats/NativeAd;", "position", "", "getPosition", "()I", "seen", "destroy", "", "markSeen", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: NativeAdInfoPresentationModel.kt */
public abstract class NativeAdInfoPresentationModel<T extends NativeAd> implements Listable {
    public final int f18683a = -1;
    public boolean f18684b;
    public final T f18685c;
    public final float f18686d;

    public abstract boolean mo4198a();

    public int getMinAndroidVersion() {
        return 0;
    }

    public NativeAdInfoPresentationModel(T t, float f) {
        Intrinsics.b(t, "nativeAd");
        this.f18685c = t;
        this.f18686d = f;
    }
}
