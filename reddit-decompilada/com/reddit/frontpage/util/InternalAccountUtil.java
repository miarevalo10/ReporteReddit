package com.reddit.frontpage.util;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0003J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/util/InternalAccountUtil;", "", "()V", "qaAccounts", "", "", "testAccounts", "voicesTeamAccounts", "isInternalAccount", "", "isQaAccount", "username", "isTestAccount", "isVoicesTeamAccount", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: InternalAccountUtil.kt */
public final class InternalAccountUtil {
    public static final InternalAccountUtil f21746a = new InternalAccountUtil();
    private static final List<String> f21747b = CollectionsKt__CollectionsKt.m26796b((Object[]) new String[]{"lssqa11", "lssqa12", "lssqa18", "lssqa17", "lssqa22", "lssplreddit008"});
    private static final List<String> f21748c = CollectionsKt__CollectionsKt.m26796b((Object[]) new String[]{"bjorn_thorbjorn", "sidorovroman", "rustest", "kyleadolson", "sermilion"});
    private static final List<String> f21749d = CollectionsKt__CollectionsKt.m26796b((Object[]) new String[]{"dijorno", "miamiz", "hidehidehidden", "arbeitrary", "porlllest", "___uzi___", "uzi", "kalluraya", "lilsnoo4", "pretzelsthirst", "wintlu", "sidorovroman", "test--1", "test--2", "test--3"});

    private InternalAccountUtil() {
    }

    public static final boolean m23767a(String str) {
        Intrinsics.m26847b(str, "username");
        List list = f21747b;
        Object toLowerCase = str.toLowerCase();
        Intrinsics.m26843a(toLowerCase, "(this as java.lang.String).toLowerCase()");
        return list.contains(toLowerCase);
    }

    public static final boolean m23768b(String str) {
        Intrinsics.m26847b(str, "username");
        List list = f21749d;
        Object toLowerCase = str.toLowerCase();
        Intrinsics.m26843a(toLowerCase, "(this as java.lang.String).toLowerCase()");
        return list.contains(toLowerCase);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean m23766a() {
        /*
        r0 = com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings.a();
        r0 = r0.o();
        r1 = 1;
        if (r0 == 0) goto L_0x000c;
    L_0x000b:
        return r1;
    L_0x000c:
        r0 = com.reddit.datalibrary.frontpage.redditauth.account.SessionManager.b();
        r2 = "SessionManager.getInstance()";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r2);
        r0 = r0.c();
        r2 = r0.isAnonymous();
        r3 = 0;
        if (r2 != 0) goto L_0x0055;
    L_0x0020:
        r2 = r0.getUsername();
        r4 = "session.username";
        kotlin.jvm.internal.Intrinsics.m26843a(r2, r4);
        r2 = m23767a(r2);
        if (r2 != 0) goto L_0x0053;
    L_0x002f:
        r0 = r0.getUsername();
        r2 = "session.username";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r2);
        r2 = f21748c;
        if (r0 != 0) goto L_0x0044;
    L_0x003c:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type java.lang.String";
        r0.<init>(r1);
        throw r0;
    L_0x0044:
        r0 = r0.toLowerCase();
        r4 = "(this as java.lang.String).toLowerCase()";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r4);
        r0 = r2.contains(r0);
        if (r0 == 0) goto L_0x0055;
    L_0x0053:
        r0 = r1;
        goto L_0x0056;
    L_0x0055:
        r0 = r3;
    L_0x0056:
        if (r0 == 0) goto L_0x0059;
    L_0x0058:
        return r1;
    L_0x0059:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.util.InternalAccountUtil.a():boolean");
    }
}
