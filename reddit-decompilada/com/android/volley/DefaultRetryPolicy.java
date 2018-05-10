package com.android.volley;

public class DefaultRetryPolicy implements RetryPolicy {
    private int f12118a;
    private int f12119b;
    private final int f12120c;
    private final float f12121d;

    public DefaultRetryPolicy() {
        this(2500, 0, 1.0f);
    }

    public DefaultRetryPolicy(int i, int i2, float f) {
        this.f12118a = i;
        this.f12120c = i2;
        this.f12121d = f;
    }

    public final int mo771a() {
        return this.f12118a;
    }

    public final int mo773b() {
        return this.f12119b;
    }

    public final void mo772a(VolleyError volleyError) throws VolleyError {
        int i = 1;
        this.f12119b++;
        this.f12118a = (int) (((float) this.f12118a) + (((float) this.f12118a) * this.f12121d));
        if (this.f12119b > this.f12120c) {
            i = 0;
        }
        if (i == 0) {
            throw volleyError;
        }
    }
}
