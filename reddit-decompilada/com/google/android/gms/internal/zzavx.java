package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.internal.zzbq;
import org.jcodec.codecs.common.biari.MQEncoder;

public final class zzavx {
    public static PendingIntent m5492a(Context context, AuthCredentialsOptions authCredentialsOptions, HintRequest hintRequest) {
        zzbq.m4809a((Object) context, (Object) "context must not be null");
        zzbq.m4809a((Object) hintRequest, (Object) "request must not be null");
        authCredentialsOptions = (authCredentialsOptions == null || authCredentialsOptions.f19080a == null) ? PasswordSpecification.f17216a : authCredentialsOptions.f19080a;
        Intent putExtra = new Intent("com.google.android.gms.auth.api.credentials.PICKER").putExtra("com.google.android.gms.credentials.hintRequestVersion", 2).putExtra("com.google.android.gms.credentials.RequestType", "Hints").putExtra("com.google.android.gms.credentials.ClaimedCallingPackage", null);
        zzbfr.m5560a(authCredentialsOptions, putExtra, "com.google.android.gms.credentials.PasswordSpecification");
        zzbfr.m5560a(hintRequest, putExtra, "com.google.android.gms.credentials.HintRequest");
        return PendingIntent.getActivity(context, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, putExtra, MQEncoder.CARRY_MASK);
    }
}
