package com.reddit.frontpage.di.module;

import android.content.Context;
import com.reddit.frontpage.presentation.formatter.AccountFormatter;
import com.reddit.frontpage.presentation.formatter.NumberFormatter;
import com.reddit.frontpage.presentation.formatter.RedditAccountFormatter;
import com.reddit.frontpage.presentation.formatter.RedditNumberFormatter;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/di/module/FormatterModule;", "", "()V", "accountFormatter", "Lcom/reddit/frontpage/presentation/formatter/AccountFormatter;", "context", "Landroid/content/Context;", "subredditFormatter", "Lcom/reddit/frontpage/presentation/formatter/NumberFormatter;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: FormatterModule.kt */
public final class FormatterModule {
    @Singleton
    public static NumberFormatter m22334a() {
        return new RedditNumberFormatter();
    }

    @Singleton
    public static AccountFormatter m22333a(Context context) {
        Intrinsics.m26847b(context, "context");
        return new RedditAccountFormatter(context);
    }
}
