package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

@zzzv
public final class zzhr {
    private final int f7703a;
    private final int f7704b;
    private final int f7705c;
    private final zzhq f7706d = new zzhv();

    public zzhr(int i) {
        this.f7704b = i;
        this.f7703a = 6;
        this.f7705c = 0;
    }

    private final String m6298a(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        zzht com_google_android_gms_internal_zzht = new zzht();
        PriorityQueue priorityQueue = new PriorityQueue(this.f7704b, new zzhs());
        for (String a : split) {
            String[] a2 = zzhu.m6302a(a, false);
            if (a2.length != 0) {
                zzhx.m6308a(a2, this.f7704b, this.f7703a, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                com_google_android_gms_internal_zzht.m6300a(this.f7706d.mo1953a(((zzhy) it.next()).f7710b));
            } catch (Throwable e) {
                zzakb.m5367b("Error while writing hash to byteStream", e);
            }
        }
        return com_google_android_gms_internal_zzht.toString();
    }

    public final String m6299a(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            stringBuffer.append(((String) obj).toLowerCase(Locale.US));
            stringBuffer.append('\n');
        }
        return m6298a(stringBuffer.toString());
    }
}
