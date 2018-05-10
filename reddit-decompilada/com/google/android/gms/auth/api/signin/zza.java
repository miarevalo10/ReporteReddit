package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

final /* synthetic */ class zza implements Comparator {
    static final Comparator f5727a = new zza();

    private zza() {
    }

    public final int compare(Object obj, Object obj2) {
        return ((Scope) obj).f17261a.compareTo(((Scope) obj2).f17261a);
    }
}
