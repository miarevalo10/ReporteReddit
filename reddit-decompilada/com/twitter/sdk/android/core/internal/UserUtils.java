package com.twitter.sdk.android.core.internal;

import android.text.TextUtils;
import com.twitter.sdk.android.core.models.User;

public final class UserUtils {

    public enum AvatarSize {
        NORMAL("_normal"),
        BIGGER("_bigger"),
        MINI("_mini"),
        ORIGINAL("_original"),
        REASONABLY_SMALL("_reasonably_small");
        
        final String f23953f;

        private AvatarSize(String str) {
            this.f23953f = str;
        }
    }

    public static String m25863a(User user, AvatarSize avatarSize) {
        if (user == null || user.f24107c == null) {
            return null;
        }
        user = user.f24107c;
        if (avatarSize != null) {
            if (user != null) {
                switch (avatarSize) {
                    case NORMAL:
                    case BIGGER:
                    case MINI:
                    case ORIGINAL:
                    case REASONABLY_SMALL:
                        return user.replace(AvatarSize.NORMAL.f23953f, avatarSize.f23953f);
                    default:
                        return user;
                }
            }
        }
        return user;
    }

    public static CharSequence m25862a(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return "";
        }
        if (charSequence.charAt(0) == '@') {
            return charSequence;
        }
        StringBuilder stringBuilder = new StringBuilder("@");
        stringBuilder.append(charSequence);
        return stringBuilder.toString();
    }
}
