package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.util.zzn;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

final class zzabk implements Runnable {
    private /* synthetic */ OutputStream f6068a;
    private /* synthetic */ byte[] f6069b;

    zzabk(OutputStream outputStream, byte[] bArr) {
        this.f6068a = outputStream;
        this.f6069b = bArr;
    }

    public final void run() {
        Closeable dataOutputStream;
        Throwable e;
        Throwable th;
        try {
            dataOutputStream = new DataOutputStream(this.f6068a);
            try {
                dataOutputStream.writeInt(this.f6069b.length);
                dataOutputStream.write(this.f6069b);
                zzn.m4907a(dataOutputStream);
            } catch (IOException e2) {
                e = e2;
                try {
                    zzakb.m5367b("Error transporting the ad response", e);
                    zzbs.m4490i().m13246a(e, "LargeParcelTeleporter.pipeData.1");
                    if (dataOutputStream != null) {
                        zzn.m4907a(this.f6068a);
                    } else {
                        zzn.m4907a(dataOutputStream);
                    }
                } catch (Throwable th2) {
                    e = th2;
                    if (dataOutputStream == null) {
                        dataOutputStream = this.f6068a;
                    }
                    zzn.m4907a(dataOutputStream);
                    throw e;
                }
            }
        } catch (Throwable e3) {
            th = e3;
            dataOutputStream = null;
            e = th;
            zzakb.m5367b("Error transporting the ad response", e);
            zzbs.m4490i().m13246a(e, "LargeParcelTeleporter.pipeData.1");
            if (dataOutputStream != null) {
                zzn.m4907a(dataOutputStream);
            } else {
                zzn.m4907a(this.f6068a);
            }
        } catch (Throwable e32) {
            th = e32;
            dataOutputStream = null;
            e = th;
            if (dataOutputStream == null) {
                dataOutputStream = this.f6068a;
            }
            zzn.m4907a(dataOutputStream);
            throw e;
        }
    }
}
