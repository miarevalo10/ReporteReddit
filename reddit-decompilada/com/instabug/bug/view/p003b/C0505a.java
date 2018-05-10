package com.instabug.bug.view.p003b;

import java.io.Serializable;

/* compiled from: Disclaimer */
public class C0505a implements Serializable {
    public static String m7843a(String str, int i) {
        return str.replaceAll("\\[([^\\]]+)\\]\\(([^\\]]+)\\)", String.format("<font color=\"#%06X\"><a href=\"$2\">$1</a></font>", new Object[]{Integer.valueOf(i & 16777215)}));
    }

    public static String m7842a(String str) {
        return str.replace("#metadata", "instabug://instabug.com/disclaimer");
    }
}
