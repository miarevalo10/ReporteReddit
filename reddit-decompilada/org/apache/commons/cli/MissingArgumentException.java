package org.apache.commons.cli;

public class MissingArgumentException extends ParseException {
    private Option f33207a;

    private MissingArgumentException(String str) {
        super(str);
    }

    public MissingArgumentException(Option option) {
        StringBuffer stringBuffer = new StringBuffer("Missing argument for option: ");
        stringBuffer.append(option.m28322a());
        this(stringBuffer.toString());
        this.f33207a = option;
    }
}
