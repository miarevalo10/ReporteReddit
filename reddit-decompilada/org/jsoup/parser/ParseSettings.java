package org.jsoup.parser;

import java.util.Iterator;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;

public class ParseSettings {
    public static final ParseSettings f27052a = new ParseSettings(false, false);
    public static final ParseSettings f27053b = new ParseSettings(true, true);
    private final boolean f27054c;
    private final boolean f27055d;

    private ParseSettings(boolean z, boolean z2) {
        this.f27054c = z;
        this.f27055d = z2;
    }

    final String m28562a(String str) {
        str = str.trim();
        return !this.f27054c ? str.toLowerCase() : str;
    }

    final Attributes m28563a(Attributes attributes) {
        if (!this.f27055d) {
            Iterator it = attributes.iterator();
            while (it.hasNext()) {
                Attribute attribute = (Attribute) it.next();
                String toLowerCase = attribute.f26964a.toLowerCase();
                Validate.m28454a(toLowerCase);
                attribute.f26964a = toLowerCase.trim();
            }
        }
        return attributes;
    }
}
