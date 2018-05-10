package org.sufficientlysecure.htmltextview;

import android.text.style.ClickableSpan;

public abstract class ClickableTableSpan extends ClickableSpan {
    protected String f27234a;

    public abstract ClickableTableSpan mo5069a();

    public final void m28718a(String str) {
        this.f27234a = str;
    }

    public final String m28719b() {
        return this.f27234a;
    }
}
