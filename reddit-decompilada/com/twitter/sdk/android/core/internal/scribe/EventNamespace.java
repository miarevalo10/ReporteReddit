package com.twitter.sdk.android.core.internal.scribe;

import com.google.gson.annotations.SerializedName;

public class EventNamespace {
    @SerializedName(a = "client")
    public final String f23975a;
    @SerializedName(a = "page")
    public final String f23976b;
    @SerializedName(a = "section")
    public final String f23977c;
    @SerializedName(a = "component")
    public final String f23978d;
    @SerializedName(a = "element")
    public final String f23979e;
    @SerializedName(a = "action")
    public final String f23980f;

    public static class Builder {
        public String f23969a;
        public String f23970b;
        public String f23971c;
        public String f23972d;
        public String f23973e;
        public String f23974f;

        public final EventNamespace m25878a() {
            return new EventNamespace(this.f23969a, this.f23970b, this.f23971c, this.f23972d, this.f23973e, this.f23974f);
        }
    }

    public EventNamespace(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f23975a = str;
        this.f23976b = str2;
        this.f23977c = str3;
        this.f23978d = str4;
        this.f23979e = str5;
        this.f23980f = str6;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("client=");
        stringBuilder.append(this.f23975a);
        stringBuilder.append(", page=");
        stringBuilder.append(this.f23976b);
        stringBuilder.append(", section=");
        stringBuilder.append(this.f23977c);
        stringBuilder.append(", component=");
        stringBuilder.append(this.f23978d);
        stringBuilder.append(", element=");
        stringBuilder.append(this.f23979e);
        stringBuilder.append(", action=");
        stringBuilder.append(this.f23980f);
        return stringBuilder.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1;
        if (r4 != r5) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 0;
        if (r5 == 0) goto L_0x008e;
    L_0x0007:
        r2 = r4.getClass();
        r3 = r5.getClass();
        if (r2 == r3) goto L_0x0013;
    L_0x0011:
        goto L_0x008e;
    L_0x0013:
        r5 = (com.twitter.sdk.android.core.internal.scribe.EventNamespace) r5;
        r2 = r4.f23980f;
        if (r2 == 0) goto L_0x0024;
    L_0x0019:
        r2 = r4.f23980f;
        r3 = r5.f23980f;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0029;
    L_0x0023:
        goto L_0x0028;
    L_0x0024:
        r2 = r5.f23980f;
        if (r2 == 0) goto L_0x0029;
    L_0x0028:
        return r1;
    L_0x0029:
        r2 = r4.f23975a;
        if (r2 == 0) goto L_0x0038;
    L_0x002d:
        r2 = r4.f23975a;
        r3 = r5.f23975a;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x003d;
    L_0x0037:
        goto L_0x003c;
    L_0x0038:
        r2 = r5.f23975a;
        if (r2 == 0) goto L_0x003d;
    L_0x003c:
        return r1;
    L_0x003d:
        r2 = r4.f23978d;
        if (r2 == 0) goto L_0x004c;
    L_0x0041:
        r2 = r4.f23978d;
        r3 = r5.f23978d;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0051;
    L_0x004b:
        goto L_0x0050;
    L_0x004c:
        r2 = r5.f23978d;
        if (r2 == 0) goto L_0x0051;
    L_0x0050:
        return r1;
    L_0x0051:
        r2 = r4.f23979e;
        if (r2 == 0) goto L_0x0060;
    L_0x0055:
        r2 = r4.f23979e;
        r3 = r5.f23979e;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0065;
    L_0x005f:
        goto L_0x0064;
    L_0x0060:
        r2 = r5.f23979e;
        if (r2 == 0) goto L_0x0065;
    L_0x0064:
        return r1;
    L_0x0065:
        r2 = r4.f23976b;
        if (r2 == 0) goto L_0x0074;
    L_0x0069:
        r2 = r4.f23976b;
        r3 = r5.f23976b;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0079;
    L_0x0073:
        goto L_0x0078;
    L_0x0074:
        r2 = r5.f23976b;
        if (r2 == 0) goto L_0x0079;
    L_0x0078:
        return r1;
    L_0x0079:
        r2 = r4.f23977c;
        if (r2 == 0) goto L_0x0088;
    L_0x007d:
        r2 = r4.f23977c;
        r5 = r5.f23977c;
        r5 = r2.equals(r5);
        if (r5 != 0) goto L_0x008d;
    L_0x0087:
        goto L_0x008c;
    L_0x0088:
        r5 = r5.f23977c;
        if (r5 == 0) goto L_0x008d;
    L_0x008c:
        return r1;
    L_0x008d:
        return r0;
    L_0x008e:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.core.internal.scribe.EventNamespace.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = 31 * (((((((((this.f23975a != null ? this.f23975a.hashCode() : 0) * 31) + (this.f23976b != null ? this.f23976b.hashCode() : 0)) * 31) + (this.f23977c != null ? this.f23977c.hashCode() : 0)) * 31) + (this.f23978d != null ? this.f23978d.hashCode() : 0)) * 31) + (this.f23979e != null ? this.f23979e.hashCode() : 0));
        if (this.f23980f != null) {
            i = this.f23980f.hashCode();
        }
        return hashCode + i;
    }
}
