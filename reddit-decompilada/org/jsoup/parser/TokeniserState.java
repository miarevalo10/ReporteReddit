package org.jsoup.parser;

import java.util.Arrays;

enum TokeniserState {
    ;
    
    static final char[] ap = null;
    static final char[] aq = null;
    static final char[] ar = null;
    static final char[] as = null;
    static final String at = "�";

    abstract void mo6351a(Tokeniser tokeniser, CharacterReader characterReader);

    static {
        ap = new char[]{'\'', '&', '\u0000'};
        aq = new char[]{'\"', '&', '\u0000'};
        ar = new char[]{'\t', '\n', '\r', '\f', ' ', '/', '=', '>', '\u0000', '\"', '\'', '<'};
        as = new char[]{'\t', '\n', '\r', '\f', ' ', '&', '>', '\u0000', '\"', '\'', '<', '=', '`'};
        Arrays.sort(ap);
        Arrays.sort(aq);
        Arrays.sort(ar);
        Arrays.sort(as);
    }
}
