package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.internal.zzzv;

@zzzv
public final class NativeAdOptions {
    public final boolean f5400a;
    public final int f5401b;
    public final boolean f5402c;
    public final int f5403d;
    public final VideoOptions f5404e;

    public static final class Builder {
        public boolean f5395a = false;
        public int f5396b = -1;
        public boolean f5397c = false;
        public VideoOptions f5398d;
        public int f5399e = 1;

        public final Builder m4403a() {
            this.f5395a = true;
            return this;
        }

        public final Builder m4404a(VideoOptions videoOptions) {
            this.f5398d = videoOptions;
            return this;
        }

        public final Builder m4405b() {
            this.f5399e = 1;
            return this;
        }

        public final NativeAdOptions m4406c() {
            return new NativeAdOptions();
        }
    }

    private NativeAdOptions(Builder builder) {
        this.f5400a = builder.f5395a;
        this.f5401b = builder.f5396b;
        this.f5402c = builder.f5397c;
        this.f5403d = builder.f5399e;
        this.f5404e = builder.f5398d;
    }
}
