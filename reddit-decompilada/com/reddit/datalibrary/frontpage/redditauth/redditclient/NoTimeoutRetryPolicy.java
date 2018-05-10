package com.reddit.datalibrary.frontpage.redditauth.redditclient;

import com.android.volley.RetryPolicy;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;

public class NoTimeoutRetryPolicy implements RetryPolicy {
    private final RetryPolicy f16291a;

    public final int mo771a() {
        return 0;
    }

    public final int mo773b() {
        return 0;
    }

    public static NoTimeoutRetryPolicy m16319a(RetryPolicy retryPolicy) {
        return retryPolicy == null ? null : new NoTimeoutRetryPolicy(retryPolicy);
    }

    private NoTimeoutRetryPolicy(RetryPolicy retryPolicy) {
        this.f16291a = retryPolicy;
    }

    public final void mo772a(VolleyError volleyError) throws VolleyError {
        if (volleyError instanceof TimeoutError) {
            throw volleyError;
        }
        this.f16291a.mo772a(volleyError);
    }
}
