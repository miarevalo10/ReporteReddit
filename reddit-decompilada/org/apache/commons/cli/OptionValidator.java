package org.apache.commons.cli;

class OptionValidator {
    static void m28326a(String str) throws IllegalArgumentException {
        if (str != null) {
            int i = 0;
            if (str.length() == 1) {
                str = str.charAt(0);
                if (Character.isJavaIdentifierPart(str) || str == 32 || str == 63 || str == 64) {
                    i = 1;
                }
                if (i == 0) {
                    StringBuffer stringBuffer = new StringBuffer("illegal option value '");
                    stringBuffer.append(str);
                    stringBuffer.append("'");
                    throw new IllegalArgumentException(stringBuffer.toString());
                }
                return;
            }
            str = str.toCharArray();
            while (i < str.length) {
                if (Character.isJavaIdentifierPart(str[i])) {
                    i++;
                } else {
                    StringBuffer stringBuffer2 = new StringBuffer("opt contains illegal character value '");
                    stringBuffer2.append(str[i]);
                    stringBuffer2.append("'");
                    throw new IllegalArgumentException(stringBuffer2.toString());
                }
            }
        }
    }
}
