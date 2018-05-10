package com.twitter.sdk.android.core.internal.scribe;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import io.fabric.sdk.android.services.events.EventTransform;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ScribeEvent {
    @SerializedName(a = "event_namespace")
    final EventNamespace f23999a;
    @SerializedName(a = "ts")
    final String f24000b;
    @SerializedName(a = "format_version")
    final String f24001c = "2";
    @SerializedName(a = "_category_")
    final String f24002d;
    @SerializedName(a = "items")
    final List<ScribeItem> f24003e;

    public static class Transform implements EventTransform<ScribeEvent> {
        private final Gson f30730a;

        public /* synthetic */ byte[] toBytes(Object obj) throws IOException {
            return this.f30730a.b((ScribeEvent) obj).getBytes("UTF-8");
        }

        public Transform(Gson gson) {
            this.f30730a = gson;
        }
    }

    public ScribeEvent(String str, EventNamespace eventNamespace, long j, List<ScribeItem> list) {
        this.f24002d = str;
        this.f23999a = eventNamespace;
        this.f24000b = String.valueOf(j);
        this.f24003e = Collections.unmodifiableList(list);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("event_namespace=");
        stringBuilder.append(this.f23999a);
        stringBuilder.append(", ts=");
        stringBuilder.append(this.f24000b);
        stringBuilder.append(", format_version=");
        stringBuilder.append(this.f24001c);
        stringBuilder.append(", _category_=");
        stringBuilder.append(this.f24002d);
        stringBuilder.append(", items=");
        StringBuilder stringBuilder2 = new StringBuilder("[");
        stringBuilder2.append(TextUtils.join(", ", this.f24003e));
        stringBuilder2.append("]");
        stringBuilder.append(stringBuilder2.toString());
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
        if (r5 == 0) goto L_0x007a;
    L_0x0007:
        r2 = r4.getClass();
        r3 = r5.getClass();
        if (r2 == r3) goto L_0x0013;
    L_0x0011:
        goto L_0x007a;
    L_0x0013:
        r5 = (com.twitter.sdk.android.core.internal.scribe.ScribeEvent) r5;
        r2 = r4.f24002d;
        if (r2 == 0) goto L_0x0024;
    L_0x0019:
        r2 = r4.f24002d;
        r3 = r5.f24002d;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0029;
    L_0x0023:
        goto L_0x0028;
    L_0x0024:
        r2 = r5.f24002d;
        if (r2 == 0) goto L_0x0029;
    L_0x0028:
        return r1;
    L_0x0029:
        r2 = r4.f23999a;
        if (r2 == 0) goto L_0x0038;
    L_0x002d:
        r2 = r4.f23999a;
        r3 = r5.f23999a;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x003d;
    L_0x0037:
        goto L_0x003c;
    L_0x0038:
        r2 = r5.f23999a;
        if (r2 == 0) goto L_0x003d;
    L_0x003c:
        return r1;
    L_0x003d:
        r2 = r4.f24001c;
        if (r2 == 0) goto L_0x004c;
    L_0x0041:
        r2 = r4.f24001c;
        r3 = r5.f24001c;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0051;
    L_0x004b:
        goto L_0x0050;
    L_0x004c:
        r2 = r5.f24001c;
        if (r2 == 0) goto L_0x0051;
    L_0x0050:
        return r1;
    L_0x0051:
        r2 = r4.f24000b;
        if (r2 == 0) goto L_0x0060;
    L_0x0055:
        r2 = r4.f24000b;
        r3 = r5.f24000b;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0065;
    L_0x005f:
        goto L_0x0064;
    L_0x0060:
        r2 = r5.f24000b;
        if (r2 == 0) goto L_0x0065;
    L_0x0064:
        return r1;
    L_0x0065:
        r2 = r4.f24003e;
        if (r2 == 0) goto L_0x0074;
    L_0x0069:
        r2 = r4.f24003e;
        r5 = r5.f24003e;
        r5 = r2.equals(r5);
        if (r5 != 0) goto L_0x0079;
    L_0x0073:
        goto L_0x0078;
    L_0x0074:
        r5 = r5.f24003e;
        if (r5 == 0) goto L_0x0079;
    L_0x0078:
        return r1;
    L_0x0079:
        return r0;
    L_0x007a:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.core.internal.scribe.ScribeEvent.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = 31 * (((((((this.f23999a != null ? this.f23999a.hashCode() : 0) * 31) + (this.f24000b != null ? this.f24000b.hashCode() : 0)) * 31) + (this.f24001c != null ? this.f24001c.hashCode() : 0)) * 31) + (this.f24002d != null ? this.f24002d.hashCode() : 0));
        if (this.f24003e != null) {
            i = this.f24003e.hashCode();
        }
        return hashCode + i;
    }
}
