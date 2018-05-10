package org.ccil.cowan.tagsoup;

import java.util.HashMap;

public abstract class Schema {
    HashMap f26743a = new HashMap();
    String f26744b = "";
    String f26745c = "";
    ElementType f26746d = null;
    private HashMap f26747e = new HashMap();

    public final void m28369a(String str, int i, int i2, int i3) {
        ElementType elementType = new ElementType(str, i, i2, i3, this);
        this.f26747e.put(str.toLowerCase(), elementType);
        if (i2 == Integer.MIN_VALUE) {
            this.f26746d = elementType;
        }
    }

    public final void m28371a(String str, String str2, String str3, String str4) {
        ElementType a = m28367a(str);
        if (a == null) {
            str4 = new StringBuffer("Attribute ");
            str4.append(str2);
            str4.append(" specified for unknown element type ");
            str4.append(str);
            throw new Error(str4.toString());
        }
        a.m28347a(str2, str3, str4);
    }

    public final void m28370a(String str, String str2) {
        ElementType a = m28367a(str);
        ElementType a2 = m28367a(str2);
        StringBuffer stringBuffer;
        if (a == null) {
            stringBuffer = new StringBuffer("No child ");
            stringBuffer.append(str);
            stringBuffer.append(" for parent ");
            stringBuffer.append(str2);
            throw new Error(stringBuffer.toString());
        } else if (a2 == null) {
            stringBuffer = new StringBuffer("No parent ");
            stringBuffer.append(str2);
            stringBuffer.append(" for child ");
            stringBuffer.append(str);
            throw new Error(stringBuffer.toString());
        } else {
            a.f26741h = a2;
        }
    }

    public final void m28368a(String str, int i) {
        this.f26743a.put(str, new Integer(i));
    }

    public final ElementType m28367a(String str) {
        return (ElementType) this.f26747e.get(str.toLowerCase());
    }

    public final void m28372b(String str) {
        this.f26744b = str;
    }

    public final void m28373c(String str) {
        this.f26745c = str;
    }
}
