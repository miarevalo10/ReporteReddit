package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzcxe;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzr {
    public final Account f5941a;
    public final Set<Scope> f5942b;
    public final Set<Scope> f5943c;
    public final Map<Api<?>, zzt> f5944d;
    public final String f5945e;
    final String f5946f;
    public final zzcxe f5947g;
    public Integer f5948h;
    private final int f5949i;
    private final View f5950j;

    public zzr(Account account, Set<Scope> set, Map<Api<?>, zzt> map, int i, View view, String str, String str2, zzcxe com_google_android_gms_internal_zzcxe) {
        Map map2;
        this.f5941a = account;
        this.f5942b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map == null) {
            map2 = Collections.EMPTY_MAP;
        }
        this.f5944d = map2;
        this.f5950j = view;
        this.f5949i = i;
        this.f5945e = str;
        this.f5946f = str2;
        this.f5947g = com_google_android_gms_internal_zzcxe;
        Set hashSet = new HashSet(this.f5942b);
        for (zzt com_google_android_gms_common_internal_zzt : this.f5944d.values()) {
            hashSet.addAll(com_google_android_gms_common_internal_zzt.f5957a);
        }
        this.f5943c = Collections.unmodifiableSet(hashSet);
    }
}
