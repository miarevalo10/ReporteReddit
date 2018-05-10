package org.slf4j.helpers;

public class FormattingTuple {
    public static FormattingTuple f27225a = new FormattingTuple(null);
    public String f27226b;
    public Throwable f27227c;
    private Object[] f27228d;

    public FormattingTuple(String str) {
        this(str, null, null);
    }

    public FormattingTuple(String str, Object[] objArr, Throwable th) {
        this.f27226b = str;
        this.f27227c = th;
        this.f27228d = objArr;
    }
}
