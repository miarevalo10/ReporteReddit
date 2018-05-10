package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

public final class zzb {
    public static ApiException m4800a(Status status) {
        return (status.f17272i != null ? 1 : null) != null ? new ResolvableApiException(status) : new ApiException(status);
    }
}
