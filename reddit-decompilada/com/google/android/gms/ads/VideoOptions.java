package com.google.android.gms.ads;

import com.google.android.gms.internal.zzmr;
import com.google.android.gms.internal.zzzv;

@zzzv
public final class VideoOptions {
    public final boolean f5390a;
    public final boolean f5391b;
    public final boolean f5392c;

    public static final class Builder {
        public boolean f5387a = true;
        private boolean f5388b = false;
        private boolean f5389c = false;

        public final Builder m4388a() {
            this.f5387a = true;
            return this;
        }

        public final VideoOptions m4389b() {
            return new VideoOptions();
        }
    }

    private VideoOptions(Builder builder) {
        this.f5390a = builder.f5387a;
        this.f5391b = builder.f5388b;
        this.f5392c = builder.f5389c;
    }

    public VideoOptions(zzmr com_google_android_gms_internal_zzmr) {
        this.f5390a = com_google_android_gms_internal_zzmr.f18171a;
        this.f5391b = com_google_android_gms_internal_zzmr.f18172b;
        this.f5392c = com_google_android_gms_internal_zzmr.f18173c;
    }
}
