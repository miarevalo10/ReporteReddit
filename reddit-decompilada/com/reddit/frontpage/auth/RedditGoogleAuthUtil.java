package com.reddit.frontpage.auth;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/auth/RedditGoogleAuthUtil;", "", "()V", "getCurrentSignedInAccount", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "context", "Landroid/content/Context;", "isAllowedAccount", "", "email", "", "isCurrentSignedInAccountAllowed", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditGoogleAuthUtil.kt */
public final class RedditGoogleAuthUtil {
    public static final RedditGoogleAuthUtil f19939a = new RedditGoogleAuthUtil();

    private RedditGoogleAuthUtil() {
    }

    public static final boolean m21798a(String str) {
        if (str == null) {
            return false;
        }
        str = StringsKt__StringsKt.m42456b((CharSequence) str).toString();
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        Object toLowerCase = str.toLowerCase();
        Intrinsics.m26843a(toLowerCase, "(this as java.lang.String).toLowerCase()");
        if (StringsKt__StringsJVMKt.m41948b(toLowerCase, "@reddit.com") || Intrinsics.m26845a(toLowerCase, (Object) "reddit.qa@lodestonesoftware.com") || Intrinsics.m26845a(toLowerCase, (Object) "testingreddit@testlio.com") != null) {
            return true;
        }
        return false;
    }

    public static final GoogleSignInAccount m21797a(Context context) {
        Intrinsics.m26847b(context, "context");
        return GoogleSignIn.a(context);
    }
}
