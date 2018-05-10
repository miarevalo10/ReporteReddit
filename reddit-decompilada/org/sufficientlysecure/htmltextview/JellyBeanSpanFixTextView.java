package org.sufficientlysecure.htmltextview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.List;

public class JellyBeanSpanFixTextView extends TextView {

    private static class FixingResult {
        public final boolean f27248a;
        public final List<Object> f27249b;
        public final List<Object> f27250c;

        public static FixingResult m28728a(List<Object> list, List<Object> list2) {
            return new FixingResult(true, list, list2);
        }

        public static FixingResult m28727a() {
            return new FixingResult(false, null, null);
        }

        private FixingResult(boolean z, List<Object> list, List<Object> list2) {
            this.f27248a = z;
            this.f27249b = list;
            this.f27250c = list2;
        }
    }

    public JellyBeanSpanFixTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public JellyBeanSpanFixTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public JellyBeanSpanFixTextView(Context context) {
        super(context);
    }

    protected void onMeasure(int r4, int r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        super.onMeasure(r4, r5);	 Catch:{ IndexOutOfBoundsException -> 0x0004 }
        return;
    L_0x0004:
        r0 = r3.getText();
        r1 = r0 instanceof android.text.Spanned;
        if (r1 == 0) goto L_0x0024;
    L_0x000c:
        r1 = new android.text.SpannableStringBuilder;
        r1.<init>(r0);
        java.lang.System.currentTimeMillis();
        r0 = r3.m28729a(r1, r4, r5);
        r2 = r0.f27248a;
        if (r2 == 0) goto L_0x0020;
    L_0x001c:
        r3.m28731a(r4, r5, r1, r0);
        return;
    L_0x0020:
        r3.m28730a(r4, r5);
        return;
    L_0x0024:
        r3.m28730a(r4, r5);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.sufficientlysecure.htmltextview.JellyBeanSpanFixTextView.onMeasure(int, int):void");
    }

    private org.sufficientlysecure.htmltextview.JellyBeanSpanFixTextView.FixingResult m28729a(android.text.SpannableStringBuilder r9, int r10, int r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = r9.length();
        r1 = java.lang.Object.class;
        r2 = 0;
        r0 = r9.getSpans(r2, r0, r1);
        r1 = new java.util.ArrayList;
        r3 = r0.length;
        r1.<init>(r3);
        r3 = new java.util.ArrayList;
        r4 = r0.length;
        r3.<init>(r4);
        r4 = r0.length;
    L_0x0018:
        if (r2 >= r4) goto L_0x004d;
    L_0x001a:
        r5 = r0[r2];
        r6 = r9.getSpanStart(r5);
        r7 = r6 + -1;
        r7 = m28733a(r9, r7);
        if (r7 == 0) goto L_0x0030;
    L_0x0028:
        r7 = " ";
        r9.insert(r6, r7);
        r1.add(r5);
    L_0x0030:
        r6 = r9.getSpanEnd(r5);
        r7 = m28733a(r9, r6);
        if (r7 == 0) goto L_0x0042;
    L_0x003a:
        r7 = " ";
        r9.insert(r6, r7);
        r3.add(r5);
    L_0x0042:
        r8.m28732a(r9, r10, r11);	 Catch:{ IndexOutOfBoundsException -> 0x004a }
        r5 = org.sufficientlysecure.htmltextview.JellyBeanSpanFixTextView.FixingResult.m28728a(r1, r3);	 Catch:{ IndexOutOfBoundsException -> 0x004a }
        return r5;
    L_0x004a:
        r2 = r2 + 1;
        goto L_0x0018;
    L_0x004d:
        r9 = org.sufficientlysecure.htmltextview.JellyBeanSpanFixTextView.FixingResult.m28727a();
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.sufficientlysecure.htmltextview.JellyBeanSpanFixTextView.a(android.text.SpannableStringBuilder, int, int):org.sufficientlysecure.htmltextview.JellyBeanSpanFixTextView$FixingResult");
    }

    private static boolean m28733a(CharSequence charSequence, int i) {
        if (i >= 0 && i < charSequence.length()) {
            if (charSequence.charAt(i) == 32) {
                return null;
            }
        }
        return true;
    }

    @SuppressLint({"WrongCall"})
    private void m28732a(CharSequence charSequence, int i, int i2) {
        setText(charSequence);
        super.onMeasure(i, i2);
    }

    @android.annotation.SuppressLint({"WrongCall"})
    private void m28731a(int r4, int r5, android.text.SpannableStringBuilder r6, org.sufficientlysecure.htmltextview.JellyBeanSpanFixTextView.FixingResult r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r7.f27250c;
        r0 = r0.iterator();
    L_0x0006:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x0023;
    L_0x000c:
        r1 = r0.next();
        r1 = r6.getSpanEnd(r1);
        r2 = r1 + 1;
        r6.delete(r1, r2);
        r3.m28732a(r6, r4, r5);	 Catch:{ IndexOutOfBoundsException -> 0x001d }
        goto L_0x0006;
    L_0x001d:
        r2 = " ";
        r6.insert(r1, r2);
        goto L_0x0006;
    L_0x0023:
        r7 = r7.f27249b;
        r7 = r7.iterator();
        r0 = 1;
    L_0x002a:
        r1 = r0;
    L_0x002b:
        r2 = r7.hasNext();
        if (r2 == 0) goto L_0x0049;
    L_0x0031:
        r1 = r7.next();
        r1 = r6.getSpanStart(r1);
        r2 = r1 + -1;
        r6.delete(r2, r1);
        r3.m28732a(r6, r4, r5);	 Catch:{ IndexOutOfBoundsException -> 0x0043 }
        r1 = 0;
        goto L_0x002b;
    L_0x0043:
        r1 = " ";
        r6.insert(r2, r1);
        goto L_0x002a;
    L_0x0049:
        if (r1 == 0) goto L_0x0051;
    L_0x004b:
        r3.setText(r6);
        super.onMeasure(r4, r5);
    L_0x0051:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.sufficientlysecure.htmltextview.JellyBeanSpanFixTextView.a(int, int, android.text.SpannableStringBuilder, org.sufficientlysecure.htmltextview.JellyBeanSpanFixTextView$FixingResult):void");
    }

    private void m28730a(int i, int i2) {
        m28732a(getText().toString(), i, i2);
    }
}
