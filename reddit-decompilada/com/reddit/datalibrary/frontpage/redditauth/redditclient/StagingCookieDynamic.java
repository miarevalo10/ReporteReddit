package com.reddit.datalibrary.frontpage.redditauth.redditclient;

import com.reddit.datalibrary.frontpage.requests.api.v1.Dynamic;
import com.reddit.frontpage.FrontpageApplication;
import java.io.File;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/reddit/datalibrary/frontpage/redditauth/redditclient/StagingCookieDynamic;", "Lcom/reddit/datalibrary/frontpage/requests/api/v1/Dynamic;", "()V", "cookie", "", "getCookie", "()Ljava/lang/String;", "cookie$delegate", "Lkotlin/Lazy;", "addDynamicHeadersTo", "", "headers", "", "cookieFile", "Ljava/io/File;", "loadCookie", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: StagingCookieDynamic.kt */
public final class StagingCookieDynamic implements Dynamic {
    static final /* synthetic */ KProperty[] f16322a = new KProperty[]{Reflection.a(new PropertyReference1Impl(Reflection.a(StagingCookieDynamic.class), "cookie", "getCookie()Ljava/lang/String;"))};
    public static final Companion f16323b = new Companion();
    private final Lazy f16324c = LazyKt.a(new StagingCookieDynamic$cookie$2(this));

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/datalibrary/frontpage/redditauth/redditclient/StagingCookieDynamic$Companion;", "", "()V", "COOKIE_FILE", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: StagingCookieDynamic.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    private final String m16377b() {
        return (String) this.f16324c.b();
    }

    public final void mo3034a(Map<String, String> map) {
        Intrinsics.b(map, "headers");
        if ((StringsKt.a(m16377b()) ^ 1) != 0) {
            map.put("Cookie", m16377b());
            return;
        }
        map = new StringBuilder("Cookie not found in ");
        map.append(m16379d().getAbsolutePath());
        Timber.d(map.toString(), new Object[0]);
    }

    private static String m16378c() {
        try {
            return FilesKt.b(m16379d());
        } catch (Exception e) {
            Timber.c(e, "Failed to read cookie", new Object[0]);
            return "";
        }
    }

    private static File m16379d() {
        FrontpageApplication frontpageApplication = FrontpageApplication.a;
        Intrinsics.a(frontpageApplication, "FrontpageApplication.instance");
        return new File(frontpageApplication.getApplicationContext().getExternalFilesDir(null), "staging_cookie.txt");
    }
}
