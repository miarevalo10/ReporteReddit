package com.reddit.frontpage.util;

import android.content.Intent;
import android.content.IntentFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B#\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005\"\u00020\u0003¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0014\u0010\u0012\u001a\u00020\u000f*\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001b\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fj\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lcom/reddit/frontpage/util/ShareType;", "", "action", "", "mimeTypes", "", "(Ljava/lang/String;ILjava/lang/String;[Ljava/lang/String;)V", "filter", "Landroid/content/IntentFilter;", "getFilter", "()Landroid/content/IntentFilter;", "getMimeTypes", "()[Ljava/lang/String;", "[Ljava/lang/String;", "matches", "", "intent", "Landroid/content/Intent;", "match", "TEXT", "LINK", "IMAGE", "VIDEO", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ShareType.kt */
public enum ShareType {
    ;
    
    public static final Companion f21798f = null;
    public final String[] f21800e;
    private final String f21801h;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/util/ShareType$Companion;", "", "()V", "get", "Lcom/reddit/frontpage/util/ShareType;", "intent", "Landroid/content/Intent;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ShareType.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.reddit.frontpage.util.ShareType m23902a(android.content.Intent r8) {
            /*
            r0 = "intent";
            kotlin.jvm.internal.Intrinsics.m26847b(r8, r0);
            r0 = com.reddit.frontpage.util.ShareType.values();
            r0 = (java.lang.Object[]) r0;
            r1 = 0;
            r2 = r0.length;
            r3 = r1;
        L_0x000e:
            if (r3 >= r2) goto L_0x0078;
        L_0x0010:
            r4 = r0[r3];
            r5 = r4;
            r5 = (com.reddit.frontpage.util.ShareType) r5;
            r6 = "intent";
            kotlin.jvm.internal.Intrinsics.m26847b(r8, r6);
            r6 = com.reddit.frontpage.util.ShareType.WhenMappings.f21793a;
            r7 = r5.ordinal();
            r6 = r6[r7];
            r7 = 1;
            switch(r6) {
                case 1: goto L_0x0057;
                case 2: goto L_0x003e;
                case 3: goto L_0x0035;
                case 4: goto L_0x002c;
                default: goto L_0x0026;
            };
        L_0x0026:
            r8 = new kotlin.NoWhenBranchMatchedException;
            r8.<init>();
            throw r8;
        L_0x002c:
            r5 = r5.m23905a();
            r5 = com.reddit.frontpage.util.ShareType.m23904a(r5, r8);
            goto L_0x0072;
        L_0x0035:
            r5 = r5.m23905a();
            r5 = com.reddit.frontpage.util.ShareType.m23904a(r5, r8);
            goto L_0x0072;
        L_0x003e:
            r5 = r5.m23905a();
            r5 = com.reddit.frontpage.util.ShareType.m23904a(r5, r8);
            if (r5 == 0) goto L_0x0071;
        L_0x0048:
            r5 = "android.intent.extra.TEXT";
            r5 = r8.getStringExtra(r5);
            r5 = (java.lang.CharSequence) r5;
            r5 = com.reddit.frontpage.util.LinkUtil.m23789a(r5);
            if (r5 == 0) goto L_0x0071;
        L_0x0056:
            goto L_0x006f;
        L_0x0057:
            r5 = r5.m23905a();
            r5 = com.reddit.frontpage.util.ShareType.m23904a(r5, r8);
            if (r5 == 0) goto L_0x0071;
        L_0x0061:
            r5 = "android.intent.extra.TEXT";
            r5 = r8.getStringExtra(r5);
            r5 = (java.lang.CharSequence) r5;
            r5 = com.reddit.frontpage.util.LinkUtil.m23789a(r5);
            if (r5 != 0) goto L_0x0071;
        L_0x006f:
            r5 = r7;
            goto L_0x0072;
        L_0x0071:
            r5 = r1;
        L_0x0072:
            if (r5 == 0) goto L_0x0075;
        L_0x0074:
            goto L_0x0079;
        L_0x0075:
            r3 = r3 + 1;
            goto L_0x000e;
        L_0x0078:
            r4 = 0;
        L_0x0079:
            r4 = (com.reddit.frontpage.util.ShareType) r4;
            return r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.util.ShareType.Companion.a(android.content.Intent):com.reddit.frontpage.util.ShareType");
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f21793a = null;

        static {
            int[] iArr = new int[ShareType.values().length];
            f21793a = iArr;
            iArr[ShareType.f21794a.ordinal()] = 1;
            f21793a[ShareType.f21795b.ordinal()] = 2;
            f21793a[ShareType.f21796c.ordinal()] = 3;
            f21793a[ShareType.f21797d.ordinal()] = 4;
        }
    }

    public static final ShareType m23903a(Intent intent) {
        return Companion.m23902a(intent);
    }

    private ShareType(String str, String... strArr) {
        Intrinsics.m26847b(str, "action");
        Intrinsics.m26847b(strArr, "mimeTypes");
        this.f21801h = str;
        this.f21800e = strArr;
    }

    static {
        f21798f = new Companion();
    }

    final IntentFilter m23905a() {
        IntentFilter intentFilter = new IntentFilter(this.f21801h);
        for (Object obj : (Object[]) this.f21800e) {
            intentFilter.addDataType((String) obj);
        }
        return intentFilter;
    }

    static boolean m23904a(IntentFilter intentFilter, Intent intent) {
        return intentFilter.match(intent.getAction(), intent.getType(), null, null, null, "ShareType") > null ? true : null;
    }
}
