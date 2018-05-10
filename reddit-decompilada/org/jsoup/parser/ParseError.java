package org.jsoup.parser;

public class ParseError {
    private int f27049a;
    private String f27050b;

    ParseError(int i, String str) {
        this.f27049a = i;
        this.f27050b = str;
    }

    ParseError(int i, String str, Object... objArr) {
        this.f27050b = String.format(str, objArr);
        this.f27049a = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f27049a);
        stringBuilder.append(": ");
        stringBuilder.append(this.f27050b);
        return stringBuilder.toString();
    }
}
