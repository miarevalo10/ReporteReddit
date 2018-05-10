package com.reddit.datalibrary.frontpage.redditauth.redditclient;

import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;

public class ProhibitRetryPolicy implements RetryPolicy {
    private final int f16292a;

    public final int mo773b() {
        return 0;
    }

    public ProhibitRetryPolicy() {
        this((byte) 0);
    }

    private ProhibitRetryPolicy(byte b) {
        this.f16292a = (byte) 76;
    }

    public final int mo771a() {
        return this.f16292a;
    }

    public final void mo772a(VolleyError volleyError) throws VolleyError {
        throw volleyError;
    }
}
