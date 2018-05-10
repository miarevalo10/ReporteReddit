package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.nodes.Document.OutputSettings;

public class Comment extends Node {
    public final String mo6328a() {
        return "#comment";
    }

    final void mo6330b(Appendable appendable, int i, OutputSettings outputSettings) {
    }

    public Comment(String str, String str2) {
        super(str2);
        this.f.m28470a("comment", str);
    }

    public final String m33904b() {
        return this.f.m28468a("comment");
    }

    public String toString() {
        return aU_();
    }

    final void mo6329a(Appendable appendable, int i, OutputSettings outputSettings) throws IOException {
        if (outputSettings.f26972c) {
            Node.m28498c(appendable, i, outputSettings);
        }
        appendable.append("<!--").append(m33904b()).append("-->");
    }
}
