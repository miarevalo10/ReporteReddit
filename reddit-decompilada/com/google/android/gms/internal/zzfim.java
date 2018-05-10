package com.google.android.gms.internal;

import java.util.List;

public final class zzfim extends RuntimeException {
    private final List<String> f7464a = null;

    public zzfim() {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzfge m6081a() {
        return new zzfge(getMessage());
    }
}
