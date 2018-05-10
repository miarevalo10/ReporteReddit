package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.nodes.Document.OutputSettings.Syntax;

public class DocumentType extends Node {
    public final String mo6328a() {
        return "#doctype";
    }

    final void mo6330b(Appendable appendable, int i, OutputSettings outputSettings) {
    }

    public DocumentType(String str, String str2, String str3, String str4, String str5) {
        super(str5);
        mo6336b("name", str);
        if (str2 != null) {
            mo6336b("pubSysKey", str2);
        }
        mo6336b("publicId", str3);
        mo6336b("systemId", str4);
    }

    private boolean m33910a(String str) {
        return StringUtil.m28447a(mo6341b(str)) == null ? true : null;
    }

    final void mo6329a(Appendable appendable, int i, OutputSettings outputSettings) throws IOException {
        if (outputSettings.f26975f == Syntax.html && m33910a("publicId") == 0 && m33910a("systemId") == 0) {
            appendable.append("<!doctype");
        } else {
            appendable.append("<!DOCTYPE");
        }
        if (m33910a("name") != 0) {
            appendable.append(" ").append(mo6341b("name"));
        }
        if (m33910a("pubSysKey") != 0) {
            appendable.append(" ").append(mo6341b("pubSysKey"));
        }
        if (m33910a("publicId") != 0) {
            appendable.append(" \"").append(mo6341b("publicId")).append('\"');
        }
        if (m33910a("systemId") != 0) {
            appendable.append(" \"").append(mo6341b("systemId")).append('\"');
        }
        appendable.append(62);
    }
}
