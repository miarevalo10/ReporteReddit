package com.reddit.frontpage.ui.tokenautocomplete;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.MultiAutoCompleteTextView.Tokenizer;
import java.util.ArrayList;

public class CharacterTokenizer implements Tokenizer {
    ArrayList<Character> f21649a;

    CharacterTokenizer(char[] cArr) {
        this.f21649a = new ArrayList(cArr.length);
        for (char valueOf : cArr) {
            this.f21649a.add(Character.valueOf(valueOf));
        }
    }

    public int findTokenStart(CharSequence charSequence, int i) {
        int i2 = i;
        while (i2 > 0 && !this.f21649a.contains(Character.valueOf(charSequence.charAt(i2 - 1)))) {
            i2--;
        }
        while (i2 < i && charSequence.charAt(i2) == ' ') {
            i2++;
        }
        return i2;
    }

    public int findTokenEnd(CharSequence charSequence, int i) {
        int length = charSequence.length();
        while (i < length) {
            if (this.f21649a.contains(Character.valueOf(charSequence.charAt(i)))) {
                return i;
            }
            i++;
        }
        return length;
    }

    public CharSequence terminateToken(CharSequence charSequence) {
        int length = charSequence.length();
        while (length > 0 && charSequence.charAt(length - 1) == ' ') {
            length--;
        }
        if (length > 0 && this.f21649a.contains(Character.valueOf(charSequence.charAt(length - 1)))) {
            return charSequence;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = (this.f21649a.size() <= 1 || ((Character) this.f21649a.get(0)).charValue() != ' ') ? this.f21649a.get(0) : this.f21649a.get(1);
        stringBuilder.append((Character) obj);
        stringBuilder.append(" ");
        String stringBuilder2 = stringBuilder.toString();
        if (charSequence instanceof Spanned) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(charSequence);
            stringBuilder3.append(stringBuilder2);
            CharSequence spannableString = new SpannableString(stringBuilder3.toString());
            TextUtils.copySpansFrom((Spanned) charSequence, 0, charSequence.length(), Object.class, spannableString, 0);
            return spannableString;
        }
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(charSequence);
        stringBuilder4.append(stringBuilder2);
        return stringBuilder4.toString();
    }
}
