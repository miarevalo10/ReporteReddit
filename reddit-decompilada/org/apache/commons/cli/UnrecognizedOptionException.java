package org.apache.commons.cli;

public class UnrecognizedOptionException extends ParseException {
    private String f33212a;

    private UnrecognizedOptionException(String str) {
        super(str);
    }

    public UnrecognizedOptionException(String str, String str2) {
        this(str);
        this.f33212a = str2;
    }
}
