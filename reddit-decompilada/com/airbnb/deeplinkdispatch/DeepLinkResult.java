package com.airbnb.deeplinkdispatch;

public final class DeepLinkResult {
    private final String error;
    private final boolean successful;
    private final String uriString;

    public DeepLinkResult(boolean z, String str, String str2) {
        this.successful = z;
        this.uriString = str;
        this.error = str2;
    }

    public final boolean isSuccessful() {
        return this.successful;
    }

    public final String uriString() {
        return this.uriString;
    }

    public final String error() {
        return this.error;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1;
        if (r4 != r5) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 0;
        if (r5 == 0) goto L_0x0042;
    L_0x0007:
        r2 = r4.getClass();
        r3 = r5.getClass();
        if (r2 == r3) goto L_0x0012;
    L_0x0011:
        goto L_0x0042;
    L_0x0012:
        r5 = (com.airbnb.deeplinkdispatch.DeepLinkResult) r5;
        r2 = r4.successful;
        r3 = r5.successful;
        if (r2 == r3) goto L_0x001b;
    L_0x001a:
        return r1;
    L_0x001b:
        r2 = r4.uriString;
        if (r2 == 0) goto L_0x002a;
    L_0x001f:
        r2 = r4.uriString;
        r3 = r5.uriString;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x002f;
    L_0x0029:
        goto L_0x002e;
    L_0x002a:
        r2 = r5.uriString;
        if (r2 == 0) goto L_0x002f;
    L_0x002e:
        return r1;
    L_0x002f:
        r2 = r4.error;
        if (r2 == 0) goto L_0x003c;
    L_0x0033:
        r0 = r4.error;
        r5 = r5.error;
        r5 = r0.equals(r5);
        return r5;
    L_0x003c:
        r5 = r5.error;
        if (r5 != 0) goto L_0x0041;
    L_0x0040:
        return r0;
    L_0x0041:
        return r1;
    L_0x0042:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.deeplinkdispatch.DeepLinkResult.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = 31 * ((this.successful * 31) + (this.uriString != null ? this.uriString.hashCode() : 0));
        if (this.error != null) {
            i = this.error.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("DeepLinkResult{successful=");
        stringBuilder.append(this.successful);
        stringBuilder.append(", uriString=");
        stringBuilder.append(this.uriString);
        stringBuilder.append(", error='");
        stringBuilder.append(this.error);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
