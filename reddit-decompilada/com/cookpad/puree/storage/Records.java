package com.cookpad.puree.storage;

import java.util.ArrayList;
import java.util.Iterator;

public class Records extends ArrayList<Record> {
    public final String m3275a() {
        if (isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = iterator();
        while (it.hasNext()) {
            stringBuilder.append(((Record) it.next()).f3713a);
            stringBuilder.append(',');
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
