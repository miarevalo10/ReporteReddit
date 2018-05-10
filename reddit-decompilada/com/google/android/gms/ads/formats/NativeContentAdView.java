package com.google.android.gms.ads.formats;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.gms.internal.zzakb;

public final class NativeContentAdView extends NativeAdView {
    public NativeContentAdView(Context context) {
        super(context);
    }

    public NativeContentAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NativeContentAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public NativeContentAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public final View getAdvertiserView() {
        return super.m4409a("1004");
    }

    public final View getBodyView() {
        return super.m4409a("1002");
    }

    public final View getCallToActionView() {
        return super.m4409a("1003");
    }

    public final View getHeadlineView() {
        return super.m4409a("1001");
    }

    public final View getImageView() {
        return super.m4409a("1005");
    }

    public final View getLogoView() {
        return super.m4409a("1006");
    }

    public final MediaView getMediaView() {
        View a = super.m4409a("1009");
        if (a instanceof MediaView) {
            return (MediaView) a;
        }
        if (a != null) {
            zzakb.m5366b("View is not an instance of MediaView");
        }
        return null;
    }

    public final void setAdvertiserView(View view) {
        super.m4410a("1004", view);
    }

    public final void setBodyView(View view) {
        super.m4410a("1002", view);
    }

    public final void setCallToActionView(View view) {
        super.m4410a("1003", view);
    }

    public final void setHeadlineView(View view) {
        super.m4410a("1001", view);
    }

    public final void setImageView(View view) {
        super.m4410a("1005", view);
    }

    public final void setLogoView(View view) {
        super.m4410a("1006", view);
    }

    public final void setMediaView(MediaView mediaView) {
        super.m4410a("1009", mediaView);
    }
}
