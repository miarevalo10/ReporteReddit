package org.ccil.cowan.tagsoup;

public class Element {
    ElementType f26730a;
    AttributesImpl f26731b;
    Element f26732c;
    boolean f26733d;

    public Element(ElementType elementType, boolean z) {
        this.f26730a = elementType;
        if (z) {
            this.f26731b = new AttributesImpl(elementType.f26740g);
        } else {
            this.f26731b = new AttributesImpl();
        }
        this.f26732c = null;
        this.f26733d = null;
    }

    public final boolean m28343a(Element element) {
        return (element.f26730a.f26738e & this.f26730a.f26737d) != null ? true : null;
    }

    public final void m28342a(String str, String str2) {
        this.f26730a.m28348a(this.f26731b, str, null, str2);
    }
}
