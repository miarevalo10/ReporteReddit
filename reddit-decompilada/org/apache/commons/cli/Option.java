package org.apache.commons.cli;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Option implements Serializable, Cloneable {
    public String f26699a;
    String f26700b;
    String f26701c = "arg";
    String f26702d;
    boolean f26703e;
    boolean f26704f;
    int f26705g = -1;
    List f26706h = new ArrayList();
    private Object f26707i;
    private char f26708j;

    public Option(String str, String str2, boolean z, String str3) throws IllegalArgumentException {
        OptionValidator.m28326a(str);
        this.f26699a = str;
        this.f26700b = str2;
        if (z) {
            this.f26705g = 1;
        }
        this.f26702d = str3;
    }

    final String m28322a() {
        if (this.f26699a == null) {
            return this.f26700b;
        }
        return this.f26699a;
    }

    public final boolean m28324b() {
        return this.f26700b != null;
    }

    public final boolean m28325c() {
        if (this.f26705g <= 0) {
            if (this.f26705g != -2) {
                return false;
            }
        }
        return true;
    }

    private void m28321b(String str) {
        if (this.f26705g <= 0 || this.f26706h.size() <= this.f26705g - 1) {
            this.f26706h.add(str);
            return;
        }
        throw new RuntimeException("Cannot add value, list full.");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[ option: ");
        stringBuffer.append(this.f26699a);
        if (this.f26700b != null) {
            stringBuffer.append(" ");
            stringBuffer.append(this.f26700b);
        }
        stringBuffer.append(" ");
        Object obj = 1;
        if (this.f26705g <= 1) {
            if (this.f26705g != -2) {
                obj = null;
            }
        }
        if (obj != null) {
            stringBuffer.append("[ARG...]");
        } else if (m28325c()) {
            stringBuffer.append(" [ARG]");
        }
        stringBuffer.append(" :: ");
        stringBuffer.append(this.f26702d);
        if (this.f26707i != null) {
            stringBuffer.append(" :: ");
            stringBuffer.append(this.f26707i);
        }
        stringBuffer.append(" ]");
        return stringBuffer.toString();
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
        if (r5 == 0) goto L_0x003d;
    L_0x0007:
        r2 = r4.getClass();
        r3 = r5.getClass();
        if (r2 == r3) goto L_0x0012;
    L_0x0011:
        goto L_0x003d;
    L_0x0012:
        r5 = (org.apache.commons.cli.Option) r5;
        r2 = r4.f26699a;
        if (r2 == 0) goto L_0x0023;
    L_0x0018:
        r2 = r4.f26699a;
        r3 = r5.f26699a;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0028;
    L_0x0022:
        goto L_0x0027;
    L_0x0023:
        r2 = r5.f26699a;
        if (r2 == 0) goto L_0x0028;
    L_0x0027:
        return r1;
    L_0x0028:
        r2 = r4.f26700b;
        if (r2 == 0) goto L_0x0037;
    L_0x002c:
        r2 = r4.f26700b;
        r5 = r5.f26700b;
        r5 = r2.equals(r5);
        if (r5 != 0) goto L_0x003c;
    L_0x0036:
        goto L_0x003b;
    L_0x0037:
        r5 = r5.f26700b;
        if (r5 == 0) goto L_0x003c;
    L_0x003b:
        return r1;
    L_0x003c:
        return r0;
    L_0x003d:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.cli.Option.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = 31 * (this.f26699a != null ? this.f26699a.hashCode() : 0);
        if (this.f26700b != null) {
            i = this.f26700b.hashCode();
        }
        return hashCode + i;
    }

    public Object clone() {
        try {
            Option option = (Option) super.clone();
            option.f26706h = new ArrayList(this.f26706h);
            return option;
        } catch (CloneNotSupportedException e) {
            StringBuffer stringBuffer = new StringBuffer("A CloneNotSupportedException was thrown: ");
            stringBuffer.append(e.getMessage());
            throw new RuntimeException(stringBuffer.toString());
        }
    }

    final void m28323a(String str) {
        if ((this.f26708j > '\u0000' ? 1 : 0) != 0) {
            char c = this.f26708j;
            int indexOf = str.indexOf(c);
            while (indexOf != -1 && this.f26706h.size() != this.f26705g - 1) {
                m28321b(str.substring(0, indexOf));
                str = str.substring(indexOf + 1);
                indexOf = str.indexOf(c);
            }
        }
        m28321b(str);
    }
}
