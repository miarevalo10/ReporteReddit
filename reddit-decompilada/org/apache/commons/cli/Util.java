package org.apache.commons.cli;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;

class Util {
    static String m28331a(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("--")) {
            return str.substring(2, str.length());
        }
        return str.startsWith(Operation.MINUS) ? str.substring(1, str.length()) : str;
    }

    static String m28332b(String str) {
        if (str.startsWith("\"")) {
            str = str.substring(1, str.length());
        }
        return str.endsWith("\"") ? str.substring(0, str.length() - 1) : str;
    }
}
