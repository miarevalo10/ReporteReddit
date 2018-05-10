package org.apache.commons.io.output;

import java.io.Serializable;
import java.io.Writer;

public class StringBuilderWriter extends Writer implements Serializable {
    private final StringBuilder f26727a;

    public void close() {
    }

    public void flush() {
    }

    public StringBuilderWriter() {
        this.f26727a = new StringBuilder();
    }

    public StringBuilderWriter(byte b) {
        this.f26727a = new StringBuilder(4);
    }

    public Writer append(char c) {
        this.f26727a.append(c);
        return this;
    }

    public Writer append(CharSequence charSequence) {
        this.f26727a.append(charSequence);
        return this;
    }

    public Writer append(CharSequence charSequence, int i, int i2) {
        this.f26727a.append(charSequence, i, i2);
        return this;
    }

    public void write(String str) {
        if (str != null) {
            this.f26727a.append(str);
        }
    }

    public void write(char[] cArr, int i, int i2) {
        if (cArr != null) {
            this.f26727a.append(cArr, i, i2);
        }
    }

    public String toString() {
        return this.f26727a.toString();
    }
}
