package org.jsoup.nodes;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import org.jsoup.SerializationException;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document.OutputSettings;

public class Attributes implements Cloneable, Iterable<Attribute> {
    public LinkedHashMap<String, Attribute> f26966a = null;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m28474b();
    }

    public final String m28468a(String str) {
        Validate.m28454a(str);
        if (this.f26966a == null) {
            return "";
        }
        Attribute attribute = (Attribute) this.f26966a.get(str);
        return attribute != null ? attribute.f26965b : "";
    }

    public final String m28473b(String str) {
        Validate.m28454a(str);
        if (this.f26966a == null) {
            return "";
        }
        for (String str2 : this.f26966a.keySet()) {
            if (str2.equalsIgnoreCase(str)) {
                return ((Attribute) this.f26966a.get(str2)).f26965b;
            }
        }
        return "";
    }

    public final void m28470a(String str, String str2) {
        m28471a(new Attribute(str, str2));
    }

    public final void m28471a(Attribute attribute) {
        Validate.m28452a((Object) attribute);
        if (this.f26966a == null) {
            this.f26966a = new LinkedHashMap(2);
        }
        this.f26966a.put(attribute.f26964a, attribute);
    }

    public final boolean m28475c(String str) {
        return (this.f26966a == null || this.f26966a.containsKey(str) == null) ? null : true;
    }

    public final boolean m28476d(String str) {
        if (this.f26966a == null) {
            return false;
        }
        for (String equalsIgnoreCase : this.f26966a.keySet()) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public final int m28467a() {
        if (this.f26966a == null) {
            return 0;
        }
        return this.f26966a.size();
    }

    public final void m28472a(Attributes attributes) {
        if (attributes.m28467a() != 0) {
            if (this.f26966a == null) {
                this.f26966a = new LinkedHashMap(attributes.m28467a());
            }
            this.f26966a.putAll(attributes.f26966a);
        }
    }

    public Iterator<Attribute> iterator() {
        if (this.f26966a != null) {
            if (!this.f26966a.isEmpty()) {
                return this.f26966a.values().iterator();
            }
        }
        return Collections.emptyList().iterator();
    }

    private String m28466c() {
        Appendable stringBuilder = new StringBuilder();
        try {
            m28469a(stringBuilder, new Document("").f36228a);
            return stringBuilder.toString();
        } catch (Throwable e) {
            throw new SerializationException(e);
        }
    }

    final void m28469a(Appendable appendable, OutputSettings outputSettings) throws IOException {
        if (this.f26966a != null) {
            for (Entry value : this.f26966a.entrySet()) {
                Attribute attribute = (Attribute) value.getValue();
                appendable.append(" ");
                attribute.m28463a(appendable, outputSettings);
            }
        }
    }

    public String toString() {
        return m28466c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Attributes)) {
            return false;
        }
        Attributes attributes = (Attributes) obj;
        if (this.f26966a == null) {
            return attributes.f26966a == null;
        } else {
            if (this.f26966a.equals(attributes.f26966a) == null) {
            }
        }
    }

    public int hashCode() {
        return this.f26966a != null ? this.f26966a.hashCode() : 0;
    }

    public final Attributes m28474b() {
        if (this.f26966a == null) {
            return new Attributes();
        }
        try {
            Attributes attributes = (Attributes) super.clone();
            attributes.f26966a = new LinkedHashMap(this.f26966a.size());
            Iterator it = iterator();
            while (it.hasNext()) {
                Attribute attribute = (Attribute) it.next();
                attributes.f26966a.put(attribute.f26964a, attribute.m28465b());
            }
            return attributes;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
