package com.reddit.frontpage.di.module;

import android.content.Context;
import com.reddit.frontpage.presentation.accounts.AccountHelper;
import com.reddit.frontpage.presentation.accounts.RedditAccountHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/di/module/AccountPickerViewModule;", "", "()V", "provideAccountSource", "Lcom/reddit/frontpage/presentation/accounts/AccountHelper;", "context", "Landroid/content/Context;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AccountPickerViewModule.kt */
public final class AccountPickerViewModule {
    public static AccountHelper m22314a(Context context) {
        Intrinsics.m26847b(context, "context");
        return new RedditAccountHelper(context);
    }
}
