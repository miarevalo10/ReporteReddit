package com.reddit.frontpage.presentation.formatter;

import android.content.Context;
import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.DateUtil;
import com.reddit.frontpage.util.Util;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/presentation/formatter/RedditAccountFormatter;", "Lcom/reddit/frontpage/presentation/formatter/AccountFormatter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "formatAge", "", "account", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "formatDefaultAge", "formatDefaultDescription", "formatDefaultKarma", "formatDescription", "formatKarma", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditAccountFormatter.kt */
public final class RedditAccountFormatter implements AccountFormatter {
    private final Context f28232a;

    public final String mo4821c() {
        return "";
    }

    public RedditAccountFormatter(Context context) {
        Intrinsics.m26847b(context, "context");
        this.f28232a = context;
    }

    public final String mo4818a(Account account) {
        Intrinsics.m26847b(account, "account");
        return DateUtil.m22704a(TimeUnit.SECONDS.toMillis(account.getCreatedUtc()), 3);
    }

    public final String mo4820b(Account account) {
        Intrinsics.m26847b(account, "account");
        Object a = Util.m23960a((int) C1761R.string.fmt_num, Integer.valueOf(account.getLinkKarma() + account.getCommentKarma()));
        Intrinsics.m26843a(a, "Util.getString(R.string.…a + account.commentKarma)");
        return a;
    }

    public final String mo4822c(Account account) {
        Intrinsics.m26847b(account, "account");
        account = account.getSubreddit();
        account = account != null ? account.getPublicDescription() : null;
        return account == null ? "" : account;
    }

    public final String mo4817a() {
        Object string = this.f28232a.getString(C1761R.string.value_placeholder);
        Intrinsics.m26843a(string, "context.getString(R.string.value_placeholder)");
        return string;
    }

    public final String mo4819b() {
        Object string = this.f28232a.getString(C1761R.string.value_placeholder);
        Intrinsics.m26843a(string, "context.getString(R.string.value_placeholder)");
        return string;
    }
}
