package com.reddit.frontpage.util.kotlin;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¨\u0006\u0005"}, d2 = {"tint", "", "color", "", "Lcom/reddit/frontpage/util/kotlin/ColorRes;", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: CharSequences.kt */
public final class CharSequencesKt {
    public static final CharSequence m24071a(CharSequence charSequence) {
        Intrinsics.m26847b(charSequence, "$receiver");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Util.m23950a((int) C1761R.color.rdt_red));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        spannableStringBuilder.setSpan(foregroundColorSpan, 0, charSequence.length(), 18);
        return spannableStringBuilder;
    }
}
