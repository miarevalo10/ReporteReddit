package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzr<T> {
    final int f8665a;
    final TaskCompletionSource<T> f8666b = new TaskCompletionSource();
    final int f8667c;
    final Bundle f8668d;

    zzr(int i, int i2, Bundle bundle) {
        this.f8665a = i;
        this.f8667c = i2;
        this.f8668d = bundle;
    }

    abstract void mo2453a(Bundle bundle);

    final void m7397a(zzs com_google_firebase_iid_zzs) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(com_google_firebase_iid_zzs);
            StringBuilder stringBuilder = new StringBuilder((14 + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length());
            stringBuilder.append("Failing ");
            stringBuilder.append(valueOf);
            stringBuilder.append(" with ");
            stringBuilder.append(valueOf2);
            Log.d("MessengerIpcClient", stringBuilder.toString());
        }
        this.f8666b.m6858a((Exception) com_google_firebase_iid_zzs);
    }

    final void m7398a(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t);
            StringBuilder stringBuilder = new StringBuilder((16 + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length());
            stringBuilder.append("Finishing ");
            stringBuilder.append(valueOf);
            stringBuilder.append(" with ");
            stringBuilder.append(valueOf2);
            Log.d("MessengerIpcClient", stringBuilder.toString());
        }
        this.f8666b.m6859a((Object) t);
    }

    abstract boolean mo2454a();

    public String toString() {
        int i = this.f8667c;
        int i2 = this.f8665a;
        boolean a = mo2454a();
        StringBuilder stringBuilder = new StringBuilder(55);
        stringBuilder.append("Request { what=");
        stringBuilder.append(i);
        stringBuilder.append(" id=");
        stringBuilder.append(i2);
        stringBuilder.append(" oneWay=");
        stringBuilder.append(a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
