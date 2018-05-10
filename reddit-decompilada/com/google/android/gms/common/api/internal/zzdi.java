package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

final class zzdi extends Handler {
    private /* synthetic */ zzdg f5832a;

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                PendingResult pendingResult = (PendingResult) message.obj;
                synchronized (this.f5832a.f13947d) {
                    if (pendingResult == null) {
                        this.f5832a.f13951h.m13022b(new Status(13, "Transform returned null"));
                    } else if (pendingResult instanceof zzct) {
                        this.f5832a.f13951h.m13022b((Status) ((zzct) pendingResult).f13943a);
                    } else {
                        ResultCallback e = this.f5832a.f13951h;
                        synchronized (e.f13947d) {
                            e.f13946c = pendingResult;
                            if (!(e.f13944a == null && e.f13945b == null)) {
                                GoogleApiClient googleApiClient = (GoogleApiClient) e.f13949f.get();
                                if (!(e.f13950g || e.f13944a == null || googleApiClient == null)) {
                                    googleApiClient.mo1593a((zzdg) e);
                                    e.f13950g = true;
                                }
                                if (e.f13948e != null) {
                                    e.m13027a(e.f13948e);
                                } else if (e.f13946c != null) {
                                    e.f13946c.mo1543a(e);
                                }
                            }
                        }
                    }
                }
                return;
            case 1:
                RuntimeException runtimeException = (RuntimeException) message.obj;
                String str = "TransformedResultImpl";
                String str2 = "Runtime exception on the transformation worker thread: ";
                String valueOf = String.valueOf(runtimeException.getMessage());
                Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                throw runtimeException;
            default:
                message = message.what;
                StringBuilder stringBuilder = new StringBuilder(70);
                stringBuilder.append("TransformationResultHandler received unknown message type: ");
                stringBuilder.append(message);
                Log.e("TransformedResultImpl", stringBuilder.toString());
                return;
        }
    }
}
