package org.jsoup.nodes;

import org.jsoup.nodes.Document.OutputSettings;

public class TextNode extends Node {
    String f33339a;

    public final String mo6328a() {
        return "#text";
    }

    final void mo6330b(Appendable appendable, int i, OutputSettings outputSettings) {
    }

    public TextNode(String str, String str2) {
        this.g = str2;
        this.f33339a = str;
    }

    public final String m33953c() {
        return this.f == null ? this.f33339a : this.f.m28468a("text");
    }

    public String toString() {
        return aU_();
    }

    static boolean m33946a(StringBuilder stringBuilder) {
        return (stringBuilder.length() == 0 || stringBuilder.charAt(stringBuilder.length() - 1) != 32) ? null : true;
    }

    private void m33947e() {
        if (this.f == null) {
            this.f = new Attributes();
            this.f.m28470a("text", this.f33339a);
        }
    }

    public final String mo6341b(String str) {
        m33947e();
        return super.mo6341b(str);
    }

    public final Attributes mo6344m() {
        m33947e();
        return super.mo6344m();
    }

    public final Node mo6336b(String str, String str2) {
        m33947e();
        return super.mo6336b(str, str2);
    }

    public final boolean mo6342c(String str) {
        m33947e();
        return super.mo6342c(str);
    }

    public final String mo6343d(String str) {
        m33947e();
        return super.mo6343d(str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void mo6329a(java.lang.Appendable r5, int r6, org.jsoup.nodes.Document.OutputSettings r7) throws java.io.IOException {
        /*
        r4 = this;
        r0 = r7.f26972c;
        r1 = 1;
        if (r0 == 0) goto L_0x0068;
    L_0x0005:
        r0 = r4.f27000h;
        if (r0 != 0) goto L_0x0023;
    L_0x0009:
        r0 = r4.d;
        r0 = r0 instanceof org.jsoup.nodes.Element;
        if (r0 == 0) goto L_0x0023;
    L_0x000f:
        r0 = r4.d;
        r0 = (org.jsoup.nodes.Element) r0;
        r0 = r0.f33334c;
        r0 = r0.f27070c;
        if (r0 == 0) goto L_0x0023;
    L_0x0019:
        r0 = r4.m33953c();
        r0 = org.jsoup.helper.StringUtil.m28447a(r0);
        if (r0 == 0) goto L_0x0065;
    L_0x0023:
        r0 = r7.f26973d;
        if (r0 == 0) goto L_0x0068;
    L_0x0027:
        r0 = r4.f26996d;
        if (r0 != 0) goto L_0x0030;
    L_0x002b:
        r0 = java.util.Collections.emptyList();
        goto L_0x0055;
    L_0x0030:
        r0 = r4.f26996d;
        r0 = r0.f26997e;
        r2 = new java.util.ArrayList;
        r3 = r0.size();
        r3 = r3 - r1;
        r2.<init>(r3);
        r0 = r0.iterator();
    L_0x0042:
        r3 = r0.hasNext();
        if (r3 == 0) goto L_0x0054;
    L_0x0048:
        r3 = r0.next();
        r3 = (org.jsoup.nodes.Node) r3;
        if (r3 == r4) goto L_0x0042;
    L_0x0050:
        r2.add(r3);
        goto L_0x0042;
    L_0x0054:
        r0 = r2;
    L_0x0055:
        r0 = r0.size();
        if (r0 <= 0) goto L_0x0068;
    L_0x005b:
        r0 = r4.m33953c();
        r0 = org.jsoup.helper.StringUtil.m28447a(r0);
        if (r0 != 0) goto L_0x0068;
    L_0x0065:
        org.jsoup.nodes.Node.m28498c(r5, r6, r7);
    L_0x0068:
        r6 = r7.f26972c;
        r0 = 0;
        if (r6 == 0) goto L_0x0080;
    L_0x006d:
        r6 = r4.mo6340l();
        r6 = r6 instanceof org.jsoup.nodes.Element;
        if (r6 == 0) goto L_0x0080;
    L_0x0075:
        r6 = r4.mo6340l();
        r6 = org.jsoup.nodes.Element.m33921c(r6);
        if (r6 != 0) goto L_0x0080;
    L_0x007f:
        goto L_0x0081;
    L_0x0080:
        r1 = r0;
    L_0x0081:
        r6 = r4.m33953c();
        org.jsoup.nodes.Entities.m28490a(r5, r6, r7, r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.nodes.TextNode.a(java.lang.Appendable, int, org.jsoup.nodes.Document$OutputSettings):void");
    }
}
