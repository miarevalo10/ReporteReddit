package org.jsoup.nodes;

import com.reddit.frontpage.commons.analytics.builders.ModEventBuilder;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map.Entry;
import org.jsoup.SerializationException;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.nodes.Document.OutputSettings.Syntax;

public class Attribute implements Cloneable, Entry<String, String> {
    private static final String[] f26963c = new String[]{"allowfullscreen", "async", "autofocus", "checked", "compact", "declare", "default", "defer", "disabled", "formnovalidate", "hidden", "inert", "ismap", "itemscope", "multiple", ModEventBuilder.f27453d, "nohref", "noresize", "noshade", "novalidate", "nowrap", "open", "readonly", "required", "reversed", "seamless", "selected", "sortable", "truespeed", "typemustmatch"};
    public String f26964a;
    String f26965b;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m28465b();
    }

    public /* synthetic */ Object setValue(Object obj) {
        obj = (String) obj;
        Validate.m28452a(obj);
        String str = this.f26965b;
        this.f26965b = obj;
        return str;
    }

    public Attribute(String str, String str2) {
        Validate.m28454a(str);
        Validate.m28452a((Object) str2);
        this.f26964a = str.trim();
        this.f26965b = str2;
    }

    private String m28462c() {
        Appendable stringBuilder = new StringBuilder();
        try {
            m28463a(stringBuilder, new Document("").f36228a);
            return stringBuilder.toString();
        } catch (Throwable e) {
            throw new SerializationException(e);
        }
    }

    protected final void m28463a(Appendable appendable, OutputSettings outputSettings) throws IOException {
        appendable.append(this.f26964a);
        boolean z = ("".equals(this.f26965b) || this.f26965b.equalsIgnoreCase(this.f26964a)) && outputSettings.f26975f == Syntax.html && mo6327a();
        if (!z) {
            appendable.append("=\"");
            Entities.m28490a(appendable, this.f26965b, outputSettings, true, false);
            appendable.append('\"');
        }
    }

    public String toString() {
        return m28462c();
    }

    protected boolean mo6327a() {
        return Arrays.binarySearch(f26963c, this.f26964a) >= 0;
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
        r1 = r5 instanceof org.jsoup.nodes.Attribute;
        r2 = 0;
        if (r1 != 0) goto L_0x000a;
    L_0x0009:
        return r2;
    L_0x000a:
        r5 = (org.jsoup.nodes.Attribute) r5;
        r1 = r4.f26964a;
        if (r1 == 0) goto L_0x001b;
    L_0x0010:
        r1 = r4.f26964a;
        r3 = r5.f26964a;
        r1 = r1.equals(r3);
        if (r1 != 0) goto L_0x0020;
    L_0x001a:
        goto L_0x001f;
    L_0x001b:
        r1 = r5.f26964a;
        if (r1 == 0) goto L_0x0020;
    L_0x001f:
        return r2;
    L_0x0020:
        r1 = r4.f26965b;
        if (r1 == 0) goto L_0x002f;
    L_0x0024:
        r1 = r4.f26965b;
        r5 = r5.f26965b;
        r5 = r1.equals(r5);
        if (r5 != 0) goto L_0x0033;
    L_0x002e:
        goto L_0x0034;
    L_0x002f:
        r5 = r5.f26965b;
        if (r5 != 0) goto L_0x0034;
    L_0x0033:
        return r0;
    L_0x0034:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.nodes.Attribute.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = 31 * (this.f26964a != null ? this.f26964a.hashCode() : 0);
        if (this.f26965b != null) {
            i = this.f26965b.hashCode();
        }
        return hashCode + i;
    }

    public final Attribute m28465b() {
        try {
            return (Attribute) super.clone();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public /* bridge */ /* synthetic */ Object getValue() {
        return this.f26965b;
    }

    public /* bridge */ /* synthetic */ Object getKey() {
        return this.f26964a;
    }
}
