package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzan;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzr;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class Api<O extends ApiOptions> {
    private final String mName;
    private final zza<?, O> zzfls;
    private final zzh<?, O> zzflt = null;
    private final zzf<?> zzflu;
    private final zzi<?> zzflv;

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public interface HasAccountOptions extends HasOptions, NotRequiredOptions {
            Account m17585a();
        }

        public interface HasGoogleSignInAccountOptions extends HasOptions {
            GoogleSignInAccount m17586a();
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    public interface zzb {
    }

    public static class zzc<C extends zzb> {
    }

    public static abstract class zzd<T extends zzb, O> {
        public List<Scope> mo3408a(O o) {
            return Collections.emptyList();
        }
    }

    public static abstract class zza<T extends zze, O> extends zzd<T, O> {
        public abstract T mo3407a(Context context, Looper looper, zzr com_google_android_gms_common_internal_zzr, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener);
    }

    public interface zze extends zzb {
        void m12805a(zzan com_google_android_gms_common_internal_zzan, Set<Scope> set);

        void m12806a(zzj com_google_android_gms_common_internal_zzj);

        void m12807a(zzp com_google_android_gms_common_internal_zzp);

        void m12808a(String str, PrintWriter printWriter);

        boolean mo3957c();

        Intent mo3958d();

        void mo4292e();

        boolean m12812f();

        boolean m12813g();

        boolean mo4023h();

        IBinder m12815i();

        String m12816j();
    }

    public static final class zzf<C extends zze> extends zzc<C> {
    }

    public interface zzg<T extends IInterface> extends zzb {
    }

    public static abstract class zzh<T extends zzg, O> extends zzd<T, O> {
    }

    public static final class zzi<C extends zzg> extends zzc<C> {
    }

    public <C extends zze> Api(String str, zza<C, O> com_google_android_gms_common_api_Api_zza_C__O, zzf<C> com_google_android_gms_common_api_Api_zzf_C) {
        zzbq.m4809a((Object) com_google_android_gms_common_api_Api_zza_C__O, (Object) "Cannot construct an Api with a null ClientBuilder");
        zzbq.m4809a((Object) com_google_android_gms_common_api_Api_zzf_C, (Object) "Cannot construct an Api with a null ClientKey");
        this.mName = str;
        this.zzfls = com_google_android_gms_common_api_Api_zza_C__O;
        this.zzflu = com_google_android_gms_common_api_Api_zzf_C;
        this.zzflv = null;
    }

    public final String getName() {
        return this.mName;
    }

    public final zzd<?, O> zzagd() {
        return this.zzfls;
    }

    public final zza<?, O> zzage() {
        zzbq.m4814a(this.zzfls != null, (Object) "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.zzfls;
    }

    public final zzc<?> zzagf() {
        if (this.zzflu != null) {
            return this.zzflu;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }
}
