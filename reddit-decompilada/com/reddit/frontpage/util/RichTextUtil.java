package com.reddit.frontpage.util;

import android.os.Build.VERSION;
import android.text.Html;
import android.text.Spannable;
import android.widget.TextView;
import com.reddit.datalibrary.frontpage.requests.models.v2.FlairRichTextItem;
import com.reddit.frontpage.domain.model.FlairRichTextItemType;
import com.reddit.frontpage.image.GlideImageGetter;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/util/RichTextUtil;", "", "()V", "HTML_IMG_FORMAT", "", "getRichTextAsString", "flairRichTextList", "", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/FlairRichTextItem;", "getRichTextString", "Lcom/reddit/frontpage/domain/model/FlairRichTextItem;", "setText", "", "richFlairText", "textView", "Landroid/widget/TextView;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RichTextUtil.kt */
public final class RichTextUtil {
    public static final RichTextUtil f21787a = new RichTextUtil();
    private static final String f21788b = "<img src=\"%s\">";

    private RichTextUtil() {
    }

    public static final String m23882a(List<? extends FlairRichTextItem> list) {
        Intrinsics.m26847b(list, "flairRichTextList");
        StringBuilder stringBuilder = new StringBuilder();
        for (FlairRichTextItem flairRichTextItem : list) {
            if (Intrinsics.m26845a(flairRichTextItem.getType(), FlairRichTextItemType.Text)) {
                stringBuilder.append(flairRichTextItem.text);
            } else {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f25295a;
                Object format = String.format(f21788b, Arrays.copyOf(new Object[]{flairRichTextItem.emojiUrl}, 1));
                Intrinsics.m26843a(format, "java.lang.String.format(format, *args)");
                stringBuilder.append(format);
            }
        }
        Object stringBuilder2 = stringBuilder.toString();
        Intrinsics.m26843a(stringBuilder2, "stringBuilder.toString()");
        return stringBuilder2;
    }

    public static final String m23884b(List<com.reddit.frontpage.domain.model.FlairRichTextItem> list) {
        Intrinsics.m26847b(list, "flairRichTextList");
        StringBuilder stringBuilder = new StringBuilder();
        for (com.reddit.frontpage.domain.model.FlairRichTextItem flairRichTextItem : list) {
            if (Intrinsics.m26845a(flairRichTextItem.getType(), FlairRichTextItemType.Text)) {
                stringBuilder.append(flairRichTextItem.getText());
            } else {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f25295a;
                Object format = String.format(f21788b, Arrays.copyOf(new Object[]{flairRichTextItem.getEmojiUrl()}, 1));
                Intrinsics.m26843a(format, "java.lang.String.format(format, *args)");
                stringBuilder.append(format);
            }
        }
        Object stringBuilder2 = stringBuilder.toString();
        Intrinsics.m26843a(stringBuilder2, "stringBuilder.toString()");
        return stringBuilder2;
    }

    public static final void m23883a(String str, TextView textView) {
        Intrinsics.m26847b(str, "richFlairText");
        Intrinsics.m26847b(textView, "textView");
        if (VERSION.SDK_INT >= 24) {
            str = Html.fromHtml(str, 0, new GlideImageGetter(textView), null);
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.text.Spannable");
            }
            str = (Spannable) str;
        } else {
            str = Html.fromHtml(str, new GlideImageGetter(textView), null);
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.text.Spannable");
            }
            str = (Spannable) str;
        }
        textView.setText(str);
    }
}
