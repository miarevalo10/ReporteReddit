package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api.zze;
import java.util.ArrayList;

final class zzau extends zzay {
    private final ArrayList<zze> f13888a;
    private /* synthetic */ zzao f13889b;

    public zzau(zzao com_google_android_gms_common_api_internal_zzao, ArrayList<zze> arrayList) {
        this.f13889b = com_google_android_gms_common_api_internal_zzao;
        super(com_google_android_gms_common_api_internal_zzao);
        this.f13888a = arrayList;
    }

    public final void mo1580a() {
        this.f13889b.f13859a.f17288m.f13897c = zzao.m12913g(this.f13889b);
        ArrayList arrayList = this.f13888a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((zze) obj).m12805a(this.f13889b.f13873o, this.f13889b.f13859a.f17288m.f13897c);
        }
    }
}
