package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzca;
import com.google.android.gms.common.util.zzu;
import java.util.Arrays;

public final class FirebaseOptions {
    public final String f8603a;
    public final String f8604b;
    private final String f8605c;
    private final String f8606d;
    private final String f8607e;
    private final String f8608f;
    private final String f8609g;

    private FirebaseOptions(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        zzbq.m4814a(zzu.m4921a(str) ^ 1, (Object) "ApplicationId must be set.");
        this.f8603a = str;
        this.f8605c = str2;
        this.f8606d = str3;
        this.f8607e = str4;
        this.f8604b = str5;
        this.f8608f = str6;
        this.f8609g = str7;
    }

    public static FirebaseOptions m7355a(Context context) {
        zzca com_google_android_gms_common_internal_zzca = new zzca(context);
        Object a = com_google_android_gms_common_internal_zzca.m4822a("google_app_id");
        return TextUtils.isEmpty(a) ? null : new FirebaseOptions(a, com_google_android_gms_common_internal_zzca.m4822a("google_api_key"), com_google_android_gms_common_internal_zzca.m4822a("firebase_database_url"), com_google_android_gms_common_internal_zzca.m4822a("ga_trackingId"), com_google_android_gms_common_internal_zzca.m4822a("gcm_defaultSenderId"), com_google_android_gms_common_internal_zzca.m4822a("google_storage_bucket"), com_google_android_gms_common_internal_zzca.m4822a("project_id"));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof FirebaseOptions)) {
            return false;
        }
        FirebaseOptions firebaseOptions = (FirebaseOptions) obj;
        return zzbg.m4806a(this.f8603a, firebaseOptions.f8603a) && zzbg.m4806a(this.f8605c, firebaseOptions.f8605c) && zzbg.m4806a(this.f8606d, firebaseOptions.f8606d) && zzbg.m4806a(this.f8607e, firebaseOptions.f8607e) && zzbg.m4806a(this.f8604b, firebaseOptions.f8604b) && zzbg.m4806a(this.f8608f, firebaseOptions.f8608f) && zzbg.m4806a(this.f8609g, firebaseOptions.f8609g);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8603a, this.f8605c, this.f8606d, this.f8607e, this.f8604b, this.f8608f, this.f8609g});
    }

    public final String toString() {
        return zzbg.m4805a(this).m4807a("applicationId", this.f8603a).m4807a("apiKey", this.f8605c).m4807a("databaseUrl", this.f8606d).m4807a("gcmSenderId", this.f8604b).m4807a("storageBucket", this.f8608f).m4807a("projectId", this.f8609g).toString();
    }
}
