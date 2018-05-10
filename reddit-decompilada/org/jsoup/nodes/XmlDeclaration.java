package org.jsoup.nodes;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.IOException;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document.OutputSettings;

public class XmlDeclaration extends Node {
    public final String f33340a;
    private final boolean f33341b;

    public final String mo6328a() {
        return "#declaration";
    }

    final void mo6330b(Appendable appendable, int i, OutputSettings outputSettings) {
    }

    public XmlDeclaration(String str, String str2, boolean z) {
        super(str2);
        Validate.m28452a((Object) str);
        this.f33340a = str;
        this.f33341b = z;
    }

    final void mo6329a(Appendable appendable, int i, OutputSettings outputSettings) throws IOException {
        appendable.append(Operation.LESS_THAN).append(this.f33341b ? "!" : Operation.EMPTY_PARAM).append(this.f33340a);
        this.f.m28469a(appendable, outputSettings);
        appendable.append(this.f33341b != 0 ? "!" : Operation.EMPTY_PARAM).append(Operation.GREATER_THAN);
    }

    public String toString() {
        return aU_();
    }
}
