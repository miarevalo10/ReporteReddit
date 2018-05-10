package com.reddit.frontpage.util;

import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.data.feature.settings.UserSettingsStorage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\u0007J\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/util/AccountPrefsUtil;", "", "()V", "isLoggedInUserOver18", "", "shouldMarkNsfw", "isNsfw", "(Ljava/lang/Boolean;)Z", "userName", "", "(Ljava/lang/String;Ljava/lang/Boolean;)Z", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AccountPrefsUtil.kt */
public final class AccountPrefsUtil {
    public static final AccountPrefsUtil f21687a = new AccountPrefsUtil();

    private AccountPrefsUtil() {
    }

    public static final boolean m23630a(String str, Boolean bool) {
        Intrinsics.m26847b(str, "userName");
        return (m23629a(bool) == null || (Intrinsics.m26845a(SessionUtil.m23899e(), (Object) str) ^ 1) == null) ? null : true;
    }

    public static final boolean m23629a(Boolean bool) {
        if (bool == null) {
            return false;
        }
        bool.booleanValue();
        boolean a = m23628a();
        boolean g = FrontpageSettings.a().g();
        if (bool.booleanValue() == null || (a && !g)) {
            return false;
        }
        return true;
    }

    public static final boolean m23628a() {
        Object a = UserSettingsStorage.a().a(SessionUtil.m23899e());
        Intrinsics.m26843a(a, "UserSettingsStorage.getI….forUser(currentUserName)");
        return a.a().over_18;
    }
}
