package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzbq;

public abstract class zzp<T> {
    private final String f5982a;
    private T f5983b;

    protected zzp(String str) {
        this.f5982a = str;
    }

    protected final T m4950a(Context context) throws zzq {
        if (this.f5983b == null) {
            zzbq.m4808a((Object) context);
            context = com.google.android.gms.common.zzp.getRemoteContext(context);
            if (context == null) {
                throw new zzq("Could not get remote context.");
            }
            try {
                this.f5983b = mo1683a((IBinder) context.getClassLoader().loadClass(this.f5982a).newInstance());
            } catch (Throwable e) {
                throw new zzq("Could not load creator class.", e);
            } catch (Throwable e2) {
                throw new zzq("Could not instantiate creator.", e2);
            } catch (Throwable e22) {
                throw new zzq("Could not access creator.", e22);
            }
        }
        return this.f5983b;
    }

    public abstract T mo1683a(IBinder iBinder);
}
