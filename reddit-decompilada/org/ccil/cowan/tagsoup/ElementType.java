package org.ccil.cowan.tagsoup;

public class ElementType {
    String f26734a;
    String f26735b;
    String f26736c;
    int f26737d;
    int f26738e;
    int f26739f;
    AttributesImpl f26740g = new AttributesImpl();
    ElementType f26741h;
    private Schema f26742i;

    public ElementType(String str, int i, int i2, int i3, Schema schema) {
        this.f26734a = str;
        this.f26737d = i;
        this.f26738e = i2;
        this.f26739f = i3;
        this.f26742i = schema;
        this.f26735b = m28345a(str, 0);
        this.f26736c = m28344a(str);
    }

    private String m28345a(String str, boolean z) {
        int indexOf = str.indexOf(58);
        if (indexOf != -1) {
            str = str.substring(false, indexOf);
            if (str.equals("xml")) {
                return "http://www.w3.org/XML/1998/namespace";
            }
            z = new StringBuffer("urn:x-prefix:");
            z.append(str);
            return z.toString().intern();
        } else if (z) {
            return "";
        } else {
            return this.f26742i.f26744b;
        }
    }

    private static String m28344a(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf == -1) {
            return str;
        }
        return str.substring(indexOf + 1).intern();
    }

    public final void m28348a(AttributesImpl attributesImpl, String str, String str2, String str3) {
        if (!str.equals("xmlns")) {
            if (!str.startsWith("xmlns:")) {
                String a = m28345a(str, true);
                String a2 = m28344a(str);
                int index = attributesImpl.getIndex(str);
                if (index == -1) {
                    str = str.intern();
                    if (str2 == null) {
                        str2 = "CDATA";
                    }
                    if (!str2.equals("CDATA")) {
                        str3 = m28346b(str3);
                    }
                    index = attributesImpl.f26728a + 1;
                    if (index > 0) {
                        int length;
                        Object obj;
                        if (attributesImpl.f26729b != null) {
                            if (attributesImpl.f26729b.length != 0) {
                                if (attributesImpl.f26729b.length < index * 5) {
                                    length = attributesImpl.f26729b.length;
                                    while (length < index * 5) {
                                        length *= 2;
                                    }
                                    obj = new String[length];
                                    if (attributesImpl.f26728a > 0) {
                                        System.arraycopy(attributesImpl.f26729b, 0, obj, 0, attributesImpl.f26728a * 5);
                                    }
                                    attributesImpl.f26729b = obj;
                                }
                            }
                        }
                        length = 25;
                        while (length < index * 5) {
                            length *= 2;
                        }
                        obj = new String[length];
                        if (attributesImpl.f26728a > 0) {
                            System.arraycopy(attributesImpl.f26729b, 0, obj, 0, attributesImpl.f26728a * 5);
                        }
                        attributesImpl.f26729b = obj;
                    }
                    attributesImpl.f26729b[attributesImpl.f26728a * 5] = a;
                    attributesImpl.f26729b[(attributesImpl.f26728a * 5) + 1] = a2;
                    attributesImpl.f26729b[(attributesImpl.f26728a * 5) + 2] = str;
                    attributesImpl.f26729b[(attributesImpl.f26728a * 5) + 3] = str2;
                    attributesImpl.f26729b[(attributesImpl.f26728a * 5) + 4] = str3;
                    attributesImpl.f26728a += 1;
                    return;
                }
                if (str2 == null) {
                    str2 = attributesImpl.getType(index);
                }
                if (!str2.equals("CDATA")) {
                    str3 = m28346b(str3);
                }
                if (index < 0 || index >= attributesImpl.f26728a) {
                    AttributesImpl.m28339b(index);
                    return;
                }
                index *= 5;
                attributesImpl.f26729b[index] = a;
                attributesImpl.f26729b[index + 1] = a2;
                attributesImpl.f26729b[index + 2] = str;
                attributesImpl.f26729b[index + 3] = str2;
                attributesImpl.f26729b[index + 4] = str3;
            }
        }
    }

    private static String m28346b(String str) {
        if (str == null) {
            return str;
        }
        str = str.trim();
        if (str.indexOf("  ") == -1) {
            return str;
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        int i = 0;
        int i2 = i;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == ' ') {
                if (i2 == 0) {
                    stringBuffer.append(charAt);
                }
                i2 = 1;
            } else {
                stringBuffer.append(charAt);
                i2 = 0;
            }
            i++;
        }
        return stringBuffer.toString();
    }

    public final void m28347a(String str, String str2, String str3) {
        m28348a(this.f26740g, str, str2, str3);
    }
}
