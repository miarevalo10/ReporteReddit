package org.apache.commons.cli;

import java.util.List;

public class MissingOptionException extends ParseException {
    private List f33208a;

    private MissingOptionException(String str) {
        super(str);
    }

    public MissingOptionException(List list) {
        this(m33813a(list));
        this.f33208a = list;
    }

    private static String m33813a(List list) {
        StringBuffer stringBuffer = new StringBuffer("Missing required option");
        stringBuffer.append(list.size() == 1 ? "" : "s");
        stringBuffer.append(": ");
        list = list.iterator();
        while (list.hasNext()) {
            stringBuffer.append(list.next());
            if (list.hasNext()) {
                stringBuffer.append(", ");
            }
        }
        return stringBuffer.toString();
    }
}
