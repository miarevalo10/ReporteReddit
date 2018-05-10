package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

public abstract class NativeContentAd extends NativeAd {

    public interface OnContentAdLoadedListener {
        void mo1265a(NativeContentAd nativeContentAd);
    }

    public abstract CharSequence mo3557b();

    public abstract List<Image> mo3558c();

    public abstract CharSequence mo3559d();

    public abstract Image mo3560e();

    public abstract CharSequence mo3561f();

    public abstract CharSequence mo3562g();

    public abstract VideoController mo3563h();

    public abstract void mo3564i();
}
