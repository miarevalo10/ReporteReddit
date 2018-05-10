package com.twitter.sdk.android.tweetui;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.twitter.sdk.android.tweetui.internal.ClickableLinkSpan;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

final class TweetTextLinkifier {

    static class C20771 implements Comparator<FormattedUrlEntity> {
        C20771() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            FormattedUrlEntity formattedUrlEntity = (FormattedUrlEntity) obj;
            FormattedUrlEntity formattedUrlEntity2 = (FormattedUrlEntity) obj2;
            if (formattedUrlEntity == null && formattedUrlEntity2 != null) {
                return -1;
            }
            if (formattedUrlEntity != null && formattedUrlEntity2 == null) {
                return 1;
            }
            if (!(formattedUrlEntity == null && formattedUrlEntity2 == null)) {
                if (formattedUrlEntity.f24170c < formattedUrlEntity2.f24170c) {
                    return -1;
                }
                if (formattedUrlEntity.f24170c > formattedUrlEntity2.f24170c) {
                    return 1;
                }
            }
            return null;
        }
    }

    static CharSequence m25934a(FormattedTweetText formattedTweetText, LinkClickListener linkClickListener, boolean z, int i, int i2) {
        CharSequence charSequence = null;
        if (formattedTweetText == null) {
            return null;
        }
        if (TextUtils.isEmpty(formattedTweetText.f24167a)) {
            return formattedTweetText.f24167a;
        }
        CharSequence spannableStringBuilder = new SpannableStringBuilder(formattedTweetText.f24167a);
        List list = formattedTweetText.f24168b;
        Collection collection = formattedTweetText.f24169c;
        if (z) {
            charSequence = m25933a(formattedTweetText);
        }
        FormattedMediaEntity formattedMediaEntity = charSequence;
        if (collection != null) {
            z = new ArrayList(list);
            z.addAll(collection);
            Collections.sort(z, new C20771());
            list = z;
        }
        m25935a(spannableStringBuilder, list, formattedMediaEntity, linkClickListener, i, i2);
        return spannableStringBuilder;
    }

    private static void m25935a(SpannableStringBuilder spannableStringBuilder, List<FormattedUrlEntity> list, FormattedMediaEntity formattedMediaEntity, final LinkClickListener linkClickListener, int i, int i2) {
        if (list != null) {
            if (!list.isEmpty()) {
                int i3 = 0;
                for (final FormattedUrlEntity formattedUrlEntity : list) {
                    int i4 = formattedUrlEntity.f24170c - i3;
                    int i5 = formattedUrlEntity.f24171d - i3;
                    if (i4 >= 0 && i5 <= spannableStringBuilder.length()) {
                        if (formattedMediaEntity != null && formattedMediaEntity.c == formattedUrlEntity.f24170c) {
                            spannableStringBuilder.replace(i4, i5, "");
                            i3 += i5 - i4;
                        } else if (!TextUtils.isEmpty(formattedUrlEntity.f24172e)) {
                            spannableStringBuilder.replace(i4, i5, formattedUrlEntity.f24172e);
                            int length = i5 - (formattedUrlEntity.f24172e.length() + i4);
                            i3 += length;
                            spannableStringBuilder.setSpan(new ClickableLinkSpan(i2, i) {
                                public final void onClick(View view) {
                                    if (linkClickListener != null) {
                                        linkClickListener.mo5491a(formattedUrlEntity.f24173f);
                                    }
                                }
                            }, i4, i5 - length, 33);
                        }
                    }
                }
            }
        }
    }

    private static FormattedMediaEntity m25933a(FormattedTweetText formattedTweetText) {
        if (formattedTweetText == null) {
            return null;
        }
        formattedTweetText = formattedTweetText.f24169c;
        if (formattedTweetText.isEmpty()) {
            return null;
        }
        for (int size = formattedTweetText.size() - 1; size >= 0; size--) {
            FormattedMediaEntity formattedMediaEntity = (FormattedMediaEntity) formattedTweetText.get(size);
            if ("photo".equals(formattedMediaEntity.f30765a)) {
                return formattedMediaEntity;
            }
        }
        return null;
    }
}
