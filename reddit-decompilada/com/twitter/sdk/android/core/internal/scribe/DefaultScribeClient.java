package com.twitter.sdk.android.core.internal.scribe;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.twitter.sdk.android.core.GuestSessionProvider;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.internal.scribe.ScribeEvent.Transform;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.ExecutorUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public class DefaultScribeClient extends ScribeClient {
    private static volatile ScheduledExecutorService f30726b;
    private final Kit f30727c;
    private final SessionManager<? extends Session<TwitterAuthToken>> f30728d;
    private final String f30729e;

    private DefaultScribeClient(Kit kit, String str, Gson gson, SessionManager<? extends Session<TwitterAuthToken>> sessionManager, GuestSessionProvider guestSessionProvider, IdManager idManager) {
        int i;
        int i2;
        ScribeClient scribeClient = this;
        ScheduledExecutorService a = m31750a();
        SettingsData b = Settings.m26437a().m26440b();
        StringBuilder stringBuilder = new StringBuilder("Fabric/");
        kit.getFabric();
        stringBuilder.append(Fabric.m26238a());
        stringBuilder.append(" (Android ");
        stringBuilder.append(VERSION.SDK_INT);
        stringBuilder.append(") ");
        stringBuilder.append(str);
        stringBuilder.append(Operation.DIVISION);
        stringBuilder.append(kit.getVersion());
        String stringBuilder2 = stringBuilder.toString();
        if (b == null || b.f24928e == null) {
            i = 100;
            i2 = 600;
        } else {
            int i3 = b.f24928e.f24867e;
            i2 = b.f24928e.f24864b;
            i = i3;
        }
        CharSequence charSequence = "";
        super(kit, a, new ScribeConfig("release".equals("debug") ^ 1, !TextUtils.isEmpty(charSequence) ? charSequence : "https://syndication.twitter.com", "i", "sdk", "", stringBuilder2, i, i2), new Transform(gson), TwitterCore.m31719a().f30696d, sessionManager, guestSessionProvider, TwitterCore.m31719a().m31725b(), idManager);
        scribeClient.f30728d = sessionManager;
        scribeClient.f30727c = kit;
        scribeClient.f30729e = idManager.m26335e();
    }

    public final void m31752a(EventNamespace... eventNamespaceArr) {
        for (int i = 0; i <= 0; i++) {
            m31751a(eventNamespaceArr[0], Collections.emptyList());
        }
    }

    private static ScheduledExecutorService m31750a() {
        if (f30726b == null) {
            synchronized (DefaultScribeClient.class) {
                if (f30726b == null) {
                    f30726b = ExecutorUtils.m26322b("scribe");
                }
            }
        }
        return f30726b;
    }

    public DefaultScribeClient(Kit kit, String str, SessionManager<? extends Session<TwitterAuthToken>> sessionManager, GuestSessionProvider guestSessionProvider, IdManager idManager) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.b = FieldNamingPolicy.d;
        this(kit, str, gsonBuilder.a(), sessionManager, guestSessionProvider, idManager);
    }

    public final void m31751a(EventNamespace eventNamespace, List<ScribeItem> list) {
        long j;
        eventNamespace = ScribeEventFactory.m25880a(eventNamespace, "", System.currentTimeMillis(), this.f30727c.getContext() != null ? this.f30727c.getContext().getResources().getConfiguration().locale.getLanguage() : "", this.f30729e, list);
        list = this.f30728d.mo5463a();
        if (list != null) {
            j = list.f23923b;
        } else {
            j = 0;
        }
        super.m25879a(eventNamespace, j);
    }
}
