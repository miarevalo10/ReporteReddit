package org.apache.commons.cli;

public class AlreadySelectedException extends ParseException {
    private OptionGroup f33205a;
    private Option f33206b;

    private AlreadySelectedException(String str) {
        super(str);
    }

    public AlreadySelectedException(OptionGroup optionGroup, Option option) {
        StringBuffer stringBuffer = new StringBuffer("The option '");
        stringBuffer.append(option.m28322a());
        stringBuffer.append("' was specified but an option from this group has already been selected: '");
        stringBuffer.append(optionGroup.f26709a);
        stringBuffer.append("'");
        this(stringBuffer.toString());
        this.f33205a = optionGroup;
        this.f33206b = option;
    }
}
