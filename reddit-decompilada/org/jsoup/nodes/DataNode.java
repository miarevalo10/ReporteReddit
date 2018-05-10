package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.nodes.Document.OutputSettings;

public class DataNode extends Node {
    public final String mo6328a() {
        return "#data";
    }

    final void mo6330b(Appendable appendable, int i, OutputSettings outputSettings) {
    }

    public DataNode(String str, String str2) {
        super(str2);
        this.f.m28470a("data", str);
    }

    public final String m33908b() {
        return this.f.m28468a("data");
    }

    final void mo6329a(Appendable appendable, int i, OutputSettings outputSettings) throws IOException {
        appendable.append(m33908b());
    }

    public String toString() {
        return aU_();
    }
}
