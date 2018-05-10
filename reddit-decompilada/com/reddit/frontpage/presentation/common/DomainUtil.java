package com.reddit.frontpage.presentation.common;

import android.text.TextUtils;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/presentation/common/DomainUtil;", "", "()V", "REDDIT_FILTER", "", "SUBDOMAIN_TO_STRIP", "TLD_TO_STRIP", "formatDomain", "domain", "stripSubdomain", "stripTLD", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: DomainUtil.kt */
public final class DomainUtil {
    public static final DomainUtil f20377a = new DomainUtil();
    private static final String f20378b = ".com";
    private static final String f20379c = "www.";
    private static final String f20380d = "reddit";

    private DomainUtil() {
    }

    public static final String m22714a(String str) {
        Intrinsics.m26847b(str, "domain");
        Object a = FrontpageSettings.a();
        Intrinsics.m26843a(a, "FrontpageSettings.getInstance()");
        a = a.t().experiments.domain_name.domain_aliases;
        Intrinsics.m26843a(a, "domainNames.domain_aliases");
        a = a.get(str);
        if (a == null) {
            Intrinsics.m26847b(str, "domain");
            if (StringsKt__StringsJVMKt.m41948b(str, f20378b)) {
                str = str.substring(0, str.length() - f20378b.length());
                Intrinsics.m26843a((Object) str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            a = str;
            Intrinsics.m26847b(a, "domain");
            if (StringsKt__StringsJVMKt.m41944a((String) a, f20379c) != null) {
                a = a.substring(f20379c.length());
                Intrinsics.m26843a(a, "(this as java.lang.String).substring(startIndex)");
            }
        }
        String str2 = (String) a;
        return TextUtils.equals((CharSequence) str2, (CharSequence) f20380d) != null ? null : str2;
    }
}
