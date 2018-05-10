package com.crashlytics.android.answers;

import android.content.Context;
import android.os.Build.VERSION;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import java.util.Map;
import java.util.UUID;

class SessionMetadataCollector {
    private final Context context;
    private final IdManager idManager;
    private final String versionCode;
    private final String versionName;

    public SessionMetadataCollector(Context context, IdManager idManager, String str, String str2) {
        this.context = context;
        this.idManager = idManager;
        this.versionCode = str;
        this.versionName = str2;
    }

    public SessionEventMetadata getMetadata() {
        Boolean h;
        Map c = this.idManager.c();
        String str = this.idManager.b;
        String a = this.idManager.a();
        String str2 = (String) c.get(DeviceIdentifierType.d);
        String str3 = (String) c.get(DeviceIdentifierType.g);
        IdManager idManager = this.idManager;
        if (idManager.g()) {
            h = idManager.h();
        } else {
            h = null;
        }
        Boolean bool = h;
        String str4 = (String) c.get(DeviceIdentifierType.c);
        String k = CommonUtils.k(this.context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(IdManager.a(VERSION.RELEASE));
        stringBuilder.append(Operation.DIVISION);
        stringBuilder.append(IdManager.a(VERSION.INCREMENTAL));
        return new SessionEventMetadata(str, UUID.randomUUID().toString(), a, str2, str3, bool, str4, k, stringBuilder.toString(), IdManager.b(), this.versionCode, this.versionName);
    }
}
