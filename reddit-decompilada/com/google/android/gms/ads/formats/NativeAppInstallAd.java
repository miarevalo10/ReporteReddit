package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

public abstract class NativeAppInstallAd extends NativeAd {

    public interface OnAppInstallAdLoadedListener {
        void mo1264a(NativeAppInstallAd nativeAppInstallAd);
    }

    public abstract CharSequence mo3547b();

    public abstract List<Image> mo3548c();

    public abstract CharSequence mo3549d();

    public abstract Image mo3550e();

    public abstract CharSequence mo3551f();

    public abstract Double mo3552g();

    public abstract CharSequence mo3553h();

    public abstract CharSequence mo3554i();

    public abstract VideoController mo3555j();

    public abstract void mo3556k();
}
