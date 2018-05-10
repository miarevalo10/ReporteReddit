package com.reddit.frontpage.di.module;

import android.app.Application;
import android.content.Context;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.domain.common.ResourceProvider;
import com.reddit.frontpage.presentation.common.AndroidResourceProvider;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0002\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\b\u0010\u0011\u001a\u00020\u0010H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/di/module/ApplicationModule;", "", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "applicationSharedPreferences", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "provideFrontpageSettings", "Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;", "resourceProvider", "Lcom/reddit/frontpage/domain/common/ResourceProvider;", "session", "Lcom/reddit/datalibrary/frontpage/redditauth/account/Session;", "manager", "Lcom/reddit/datalibrary/frontpage/redditauth/account/SessionManager;", "sessionManager", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ApplicationModule.kt */
public final class ApplicationModule {
    final Application f20230a;

    public ApplicationModule(Application application) {
        Intrinsics.m26847b(application, "application");
        this.f20230a = application;
    }

    @Singleton
    public static SessionManager m22324a() {
        Object b = SessionManager.b();
        Intrinsics.m26843a(b, "SessionManager.getInstance()");
        return b;
    }

    public static Session m22323a(SessionManager sessionManager) {
        Intrinsics.m26847b(sessionManager, "manager");
        Object c = sessionManager.c();
        Intrinsics.m26843a(c, "manager.activeSession");
        return c;
    }

    @Singleton
    public static FrontpageSettings m22326b() {
        Object a = FrontpageSettings.a();
        Intrinsics.m26843a(a, "FrontpageSettings.getInstance()");
        return a;
    }

    @Singleton
    public static ResourceProvider m22325a(Context context) {
        Intrinsics.m26847b(context, "context");
        Object resources = context.getResources();
        Intrinsics.m26843a(resources, "context.resources");
        return new AndroidResourceProvider(resources);
    }
}
