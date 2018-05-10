package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;
import java.util.ArrayList;

@zzzv
public final class zzhe {
    final Object f7637a = new Object();
    int f7638b = 0;
    int f7639c = 0;
    int f7640d = 0;
    int f7641e;
    String f7642f = "";
    String f7643g = "";
    String f7644h = "";
    private final int f7645i;
    private final int f7646j;
    private final int f7647k;
    private final zzhr f7648l;
    private final zzia f7649m;
    private ArrayList<String> f7650n = new ArrayList();
    private ArrayList<String> f7651o = new ArrayList();
    private ArrayList<zzhp> f7652p = new ArrayList();

    public zzhe(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f7645i = i;
        this.f7646j = i2;
        this.f7647k = i3;
        this.f7648l = new zzhr(i4);
        this.f7649m = new zzia(i5, i6, i7);
    }

    private static String m6273a(ArrayList<String> arrayList) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            stringBuffer.append((String) obj);
            stringBuffer.append(' ');
            if (stringBuffer.length() > 100) {
                break;
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() < 100 ? stringBuffer2 : stringBuffer2.substring(0, 100);
    }

    public final void m6274a(String str, boolean z, float f, float f2, float f3, float f4) {
        m6277b(str, z, f, f2, f3, f4);
        synchronized (this.f7637a) {
            if (this.f7640d < 0) {
                zzakb.m5366b("ActivityContent: negative number of WebViews.");
            }
            m6278c();
        }
    }

    public final boolean m6275a() {
        boolean z;
        synchronized (this.f7637a) {
            z = this.f7640d == 0;
        }
        return z;
    }

    public final void m6276b() {
        synchronized (this.f7637a) {
            this.f7640d++;
        }
    }

    final void m6277b(String str, boolean z, float f, float f2, float f3, float f4) {
        if (str != null && str.length() >= this.f7647k) {
            synchronized (this.f7637a) {
                this.f7650n.add(str);
                this.f7638b += str.length();
                if (z) {
                    this.f7651o.add(str);
                    this.f7652p.add(new zzhp(f, f2, f3, f4, this.f7651o.size() - 1));
                }
            }
        }
    }

    public final void m6278c() {
        synchronized (this.f7637a) {
            int i = (this.f7638b * this.f7645i) + (this.f7639c * this.f7646j);
            if (i > this.f7641e) {
                this.f7641e = i;
                if (((Boolean) zzkb.m6350f().m6488a(zznh.f7881Q)).booleanValue() && !zzbs.m4490i().m13248a()) {
                    this.f7642f = this.f7648l.m6299a(this.f7650n);
                    this.f7643g = this.f7648l.m6299a(this.f7651o);
                }
                if (((Boolean) zzkb.m6350f().m6488a(zznh.f7883S)).booleanValue() && !zzbs.m4490i().m13252b()) {
                    this.f7644h = this.f7649m.m6310a(this.f7651o, this.f7652p);
                }
            }
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhe)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzhe com_google_android_gms_internal_zzhe = (zzhe) obj;
        return com_google_android_gms_internal_zzhe.f7642f != null && com_google_android_gms_internal_zzhe.f7642f.equals(this.f7642f);
    }

    public final int hashCode() {
        return this.f7642f.hashCode();
    }

    public final String toString() {
        int i = this.f7639c;
        int i2 = this.f7641e;
        int i3 = this.f7638b;
        String a = m6273a(this.f7650n);
        String a2 = m6273a(this.f7651o);
        String str = this.f7642f;
        String str2 = this.f7643g;
        String str3 = this.f7644h;
        StringBuilder stringBuilder = new StringBuilder(((((165 + String.valueOf(a).length()) + String.valueOf(a2).length()) + String.valueOf(str).length()) + String.valueOf(str2).length()) + String.valueOf(str3).length());
        stringBuilder.append("ActivityContent fetchId: ");
        stringBuilder.append(i);
        stringBuilder.append(" score:");
        stringBuilder.append(i2);
        stringBuilder.append(" total_length:");
        stringBuilder.append(i3);
        stringBuilder.append("\n text: ");
        stringBuilder.append(a);
        stringBuilder.append("\n viewableText");
        stringBuilder.append(a2);
        stringBuilder.append("\n signture: ");
        stringBuilder.append(str);
        stringBuilder.append("\n viewableSignture: ");
        stringBuilder.append(str2);
        stringBuilder.append("\n viewableSignatureForVertical: ");
        stringBuilder.append(str3);
        return stringBuilder.toString();
    }
}
