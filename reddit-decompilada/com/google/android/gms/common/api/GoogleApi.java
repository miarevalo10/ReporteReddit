package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArraySet;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions;
import com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.internal.zzah;
import com.google.android.gms.common.api.internal.zzbm;
import com.google.android.gms.common.api.internal.zzbo;
import com.google.android.gms.common.api.internal.zzbw;
import com.google.android.gms.common.api.internal.zzc;
import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.common.api.internal.zzck;
import com.google.android.gms.common.api.internal.zzcm;
import com.google.android.gms.common.api.internal.zzcp;
import com.google.android.gms.common.api.internal.zzcq;
import com.google.android.gms.common.api.internal.zzcr;
import com.google.android.gms.common.api.internal.zzcv;
import com.google.android.gms.common.api.internal.zzcz;
import com.google.android.gms.common.api.internal.zzd;
import com.google.android.gms.common.api.internal.zzdd;
import com.google.android.gms.common.api.internal.zzdn;
import com.google.android.gms.common.api.internal.zze;
import com.google.android.gms.common.api.internal.zzf;
import com.google.android.gms.common.api.internal.zzg;
import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.common.api.internal.zzm;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collection;
import java.util.Collections;

public class GoogleApi<O extends ApiOptions> {
    private final Context mContext;
    private final int mId;
    private final Looper zzall;
    private final Api<O> zzfin;
    private final O zzfme;
    private final zzh<O> zzfmf;
    private final GoogleApiClient zzfmg;
    private final zzcz zzfmh;
    protected final zzbm zzfmi;

    public static class zza {
        public static final zza f5739a = new zzd().m4775a();
        public final zzcz f5740b;
        public final Looper f5741c;

        private zza(zzcz com_google_android_gms_common_api_internal_zzcz, Looper looper) {
            this.f5740b = com_google_android_gms_common_api_internal_zzcz;
            this.f5741c = looper;
        }
    }

    @Deprecated
    public GoogleApi(Activity activity, Api<O> api, O o, zzcz com_google_android_gms_common_api_internal_zzcz) {
        this(activity, (Api) api, (ApiOptions) o, new zzd().m4777a(com_google_android_gms_common_api_internal_zzcz).m4776a(activity.getMainLooper()).m4775a());
    }

    @Deprecated
    public GoogleApi(Context context, Api<O> api, O o, Looper looper, zzcz com_google_android_gms_common_api_internal_zzcz) {
        this(context, (Api) api, null, new zzd().m4776a(looper).m4777a(com_google_android_gms_common_api_internal_zzcz).m4775a());
    }

    @Deprecated
    public GoogleApi(Context context, Api<O> api, O o, zzcz com_google_android_gms_common_api_internal_zzcz) {
        this(context, (Api) api, (ApiOptions) o, new zzd().m4777a(com_google_android_gms_common_api_internal_zzcz).m4775a());
    }

    public final Context getApplicationContext() {
        return this.mContext;
    }

    public final int getInstanceId() {
        return this.mId;
    }

    public final Looper getLooper() {
        return this.zzall;
    }

    public final <L> zzci<L> zza(L l, String str) {
        return zzcm.m4756a(l, this.zzall, str);
    }

    public zzcv zza(Context context, Handler handler) {
        return new zzcv(context, handler, zzagp().m4875a());
    }

    public final <A extends zzb, T extends zzm<? extends Result, A>> T zza(T t) {
        return zza(0, (zzm) t);
    }

    public final <TResult, A extends zzb> Task<TResult> zza(zzdd<A, TResult> com_google_android_gms_common_api_internal_zzdd_A__TResult) {
        return zza(0, (zzdd) com_google_android_gms_common_api_internal_zzdd_A__TResult);
    }

    public final Api<O> zzagl() {
        return this.zzfin;
    }

    public final O zzagm() {
        return this.zzfme;
    }

    public final zzh<O> zzagn() {
        return this.zzfmf;
    }

    public final GoogleApiClient zzago() {
        return this.zzfmg;
    }

    public final <A extends zzb, T extends zzm<? extends Result, A>> T zzb(T t) {
        return zza(1, (zzm) t);
    }

    public final <TResult, A extends zzb> Task<TResult> zzb(zzdd<A, TResult> com_google_android_gms_common_api_internal_zzdd_A__TResult) {
        return zza(1, (zzdd) com_google_android_gms_common_api_internal_zzdd_A__TResult);
    }

    public final <A extends zzb, T extends zzm<? extends Result, A>> T zzc(T t) {
        return zza(2, (zzm) t);
    }

    protected GoogleApi(Context context, Api<O> api, Looper looper) {
        zzbq.m4809a((Object) context, (Object) "Null context is not permitted.");
        zzbq.m4809a((Object) api, (Object) "Api must not be null.");
        zzbq.m4809a((Object) looper, (Object) "Looper must not be null.");
        this.mContext = context.getApplicationContext();
        this.zzfin = api;
        this.zzfme = null;
        this.zzall = looper;
        this.zzfmf = zzh.m4766a(api);
        this.zzfmg = new zzbw(this);
        this.zzfmi = zzbm.m4711a(this.mContext);
        this.mId = this.zzfmi.f5779d.getAndIncrement();
        this.zzfmh = new zzg();
    }

    public GoogleApi(Activity activity, Api<O> api, O o, zza com_google_android_gms_common_api_GoogleApi_zza) {
        zzbq.m4809a((Object) activity, (Object) "Null activity is not permitted.");
        zzbq.m4809a((Object) api, (Object) "Api must not be null.");
        zzbq.m4809a((Object) com_google_android_gms_common_api_GoogleApi_zza, (Object) "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.mContext = activity.getApplicationContext();
        this.zzfin = api;
        this.zzfme = o;
        this.zzall = com_google_android_gms_common_api_GoogleApi_zza.f5741c;
        this.zzfmf = zzh.m4767a(this.zzfin, this.zzfme);
        this.zzfmg = new zzbw(this);
        this.zzfmi = zzbm.m4711a(this.mContext);
        this.mId = this.zzfmi.f5779d.getAndIncrement();
        this.zzfmh = com_google_android_gms_common_api_GoogleApi_zza.f5740b;
        zzah.m17589a(activity, this.zzfmi, this.zzfmf);
        this.zzfmi.m4727a(this);
    }

    public GoogleApi(Context context, Api<O> api, O o, zza com_google_android_gms_common_api_GoogleApi_zza) {
        zzbq.m4809a((Object) context, (Object) "Null context is not permitted.");
        zzbq.m4809a((Object) api, (Object) "Api must not be null.");
        zzbq.m4809a((Object) com_google_android_gms_common_api_GoogleApi_zza, (Object) "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.mContext = context.getApplicationContext();
        this.zzfin = api;
        this.zzfme = o;
        this.zzall = com_google_android_gms_common_api_GoogleApi_zza.f5741c;
        this.zzfmf = zzh.m4767a(this.zzfin, this.zzfme);
        this.zzfmg = new zzbw(this);
        this.zzfmi = zzbm.m4711a(this.mContext);
        this.mId = this.zzfmi.f5779d.getAndIncrement();
        this.zzfmh = com_google_android_gms_common_api_GoogleApi_zza.f5740b;
        this.zzfmi.m4727a(this);
    }

    private final <A extends zzb, T extends zzm<? extends Result, A>> T zza(int i, T t) {
        t.m12835f();
        zzbm com_google_android_gms_common_api_internal_zzbm = this.zzfmi;
        com_google_android_gms_common_api_internal_zzbm.f5784i.sendMessage(com_google_android_gms_common_api_internal_zzbm.f5784i.obtainMessage(4, new zzcp(new zzc(i, t), com_google_android_gms_common_api_internal_zzbm.f5780e.get(), this)));
        return t;
    }

    private final <TResult, A extends zzb> Task<TResult> zza(int i, zzdd<A, TResult> com_google_android_gms_common_api_internal_zzdd_A__TResult) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zzbm com_google_android_gms_common_api_internal_zzbm = this.zzfmi;
        com_google_android_gms_common_api_internal_zzbm.f5784i.sendMessage(com_google_android_gms_common_api_internal_zzbm.f5784i.obtainMessage(4, new zzcp(new zze(i, com_google_android_gms_common_api_internal_zzdd_A__TResult, taskCompletionSource, this.zzfmh), com_google_android_gms_common_api_internal_zzbm.f5780e.get(), this)));
        return taskCompletionSource.f8211a;
    }

    public final <A extends zzb, T extends zzcq<A, ?>, U extends zzdn<A, ?>> Task<Void> zza(T t, U u) {
        zzbq.m4808a((Object) t);
        zzbq.m4808a((Object) u);
        zzbq.m4809a(t.f5820a.f5811b, (Object) "Listener has already been released.");
        zzbq.m4809a(u.f5838a, (Object) "Listener has already been released.");
        zzbq.m4818b(t.f5820a.f5811b.equals(u.f5838a), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        zzbm com_google_android_gms_common_api_internal_zzbm = this.zzfmi;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        com_google_android_gms_common_api_internal_zzbm.f5784i.sendMessage(com_google_android_gms_common_api_internal_zzbm.f5784i.obtainMessage(8, new zzcp(new zzd(new zzcr(t, u), taskCompletionSource), com_google_android_gms_common_api_internal_zzbm.f5780e.get(), this)));
        return taskCompletionSource.f8211a;
    }

    public final Task<Boolean> zza(zzck<?> com_google_android_gms_common_api_internal_zzck_) {
        zzbq.m4809a((Object) com_google_android_gms_common_api_internal_zzck_, (Object) "Listener key cannot be null.");
        zzbm com_google_android_gms_common_api_internal_zzbm = this.zzfmi;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        com_google_android_gms_common_api_internal_zzbm.f5784i.sendMessage(com_google_android_gms_common_api_internal_zzbm.f5784i.obtainMessage(13, new zzcp(new zzf(com_google_android_gms_common_api_internal_zzck_, taskCompletionSource), com_google_android_gms_common_api_internal_zzbm.f5780e.get(), this)));
        return taskCompletionSource.f8211a;
    }

    public Api.zze zza(Looper looper, zzbo<O> com_google_android_gms_common_api_internal_zzbo_O) {
        zzs zzagp = zzagp();
        zzagp.f5953c = this.mContext.getPackageName();
        zzagp.f5954d = this.mContext.getClass().getName();
        return this.zzfin.zzage().mo3407a(this.mContext, looper, zzagp.m4875a(), this.zzfme, com_google_android_gms_common_api_internal_zzbo_O, com_google_android_gms_common_api_internal_zzbo_O);
    }

    private final zzs zzagp() {
        GoogleSignInAccount a;
        Account account;
        Collection a2;
        zzs com_google_android_gms_common_internal_zzs = new zzs();
        if (this.zzfme instanceof HasGoogleSignInAccountOptions) {
            a = ((HasGoogleSignInAccountOptions) this.zzfme).m17586a();
            if (a != null) {
                if (a.f17232b != null) {
                    account = new Account(a.f17232b, "com.google");
                    com_google_android_gms_common_internal_zzs.f5951a = account;
                    if (this.zzfme instanceof HasGoogleSignInAccountOptions) {
                        a = ((HasGoogleSignInAccountOptions) this.zzfme).m17586a();
                        if (a != null) {
                            a2 = a.m17565a();
                            if (com_google_android_gms_common_internal_zzs.f5952b == null) {
                                com_google_android_gms_common_internal_zzs.f5952b = new ArraySet();
                            }
                            com_google_android_gms_common_internal_zzs.f5952b.addAll(a2);
                            return com_google_android_gms_common_internal_zzs;
                        }
                    }
                    a2 = Collections.emptySet();
                    if (com_google_android_gms_common_internal_zzs.f5952b == null) {
                        com_google_android_gms_common_internal_zzs.f5952b = new ArraySet();
                    }
                    com_google_android_gms_common_internal_zzs.f5952b.addAll(a2);
                    return com_google_android_gms_common_internal_zzs;
                }
                account = null;
                com_google_android_gms_common_internal_zzs.f5951a = account;
                if (this.zzfme instanceof HasGoogleSignInAccountOptions) {
                    a = ((HasGoogleSignInAccountOptions) this.zzfme).m17586a();
                    if (a != null) {
                        a2 = a.m17565a();
                        if (com_google_android_gms_common_internal_zzs.f5952b == null) {
                            com_google_android_gms_common_internal_zzs.f5952b = new ArraySet();
                        }
                        com_google_android_gms_common_internal_zzs.f5952b.addAll(a2);
                        return com_google_android_gms_common_internal_zzs;
                    }
                }
                a2 = Collections.emptySet();
                if (com_google_android_gms_common_internal_zzs.f5952b == null) {
                    com_google_android_gms_common_internal_zzs.f5952b = new ArraySet();
                }
                com_google_android_gms_common_internal_zzs.f5952b.addAll(a2);
                return com_google_android_gms_common_internal_zzs;
            }
        }
        if (this.zzfme instanceof HasAccountOptions) {
            account = ((HasAccountOptions) this.zzfme).m17585a();
            com_google_android_gms_common_internal_zzs.f5951a = account;
            if (this.zzfme instanceof HasGoogleSignInAccountOptions) {
                a = ((HasGoogleSignInAccountOptions) this.zzfme).m17586a();
                if (a != null) {
                    a2 = a.m17565a();
                    if (com_google_android_gms_common_internal_zzs.f5952b == null) {
                        com_google_android_gms_common_internal_zzs.f5952b = new ArraySet();
                    }
                    com_google_android_gms_common_internal_zzs.f5952b.addAll(a2);
                    return com_google_android_gms_common_internal_zzs;
                }
            }
            a2 = Collections.emptySet();
            if (com_google_android_gms_common_internal_zzs.f5952b == null) {
                com_google_android_gms_common_internal_zzs.f5952b = new ArraySet();
            }
            com_google_android_gms_common_internal_zzs.f5952b.addAll(a2);
            return com_google_android_gms_common_internal_zzs;
        }
        account = null;
        com_google_android_gms_common_internal_zzs.f5951a = account;
        if (this.zzfme instanceof HasGoogleSignInAccountOptions) {
            a = ((HasGoogleSignInAccountOptions) this.zzfme).m17586a();
            if (a != null) {
                a2 = a.m17565a();
                if (com_google_android_gms_common_internal_zzs.f5952b == null) {
                    com_google_android_gms_common_internal_zzs.f5952b = new ArraySet();
                }
                com_google_android_gms_common_internal_zzs.f5952b.addAll(a2);
                return com_google_android_gms_common_internal_zzs;
            }
        }
        a2 = Collections.emptySet();
        if (com_google_android_gms_common_internal_zzs.f5952b == null) {
            com_google_android_gms_common_internal_zzs.f5952b = new ArraySet();
        }
        com_google_android_gms_common_internal_zzs.f5952b.addAll(a2);
        return com_google_android_gms_common_internal_zzs;
    }
}
