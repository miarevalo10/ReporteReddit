package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import android.text.TextUtils;
import com.twitter.sdk.android.core.GuestSessionProvider;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.internal.network.GuestAuthInterceptor;
import com.twitter.sdk.android.core.internal.network.OAuth1aInterceptor;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.QueueFile;
import io.fabric.sdk.android.services.common.QueueFile.ElementReader;
import io.fabric.sdk.android.services.events.FilesSender;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

class ScribeFilesSender implements FilesSender {
    private static final byte[] f30736a = new byte[]{(byte) 91};
    private static final byte[] f30737b = new byte[]{(byte) 44};
    private static final byte[] f30738c = new byte[]{(byte) 93};
    private final Context f30739d;
    private final ScribeConfig f30740e;
    private final long f30741f;
    private final TwitterAuthConfig f30742g;
    private final SessionManager<? extends Session<TwitterAuthToken>> f30743h;
    private final GuestSessionProvider f30744i;
    private final SSLSocketFactory f30745j;
    private final AtomicReference<ScribeService> f30746k = new AtomicReference();
    private final ExecutorService f30747l;
    private final IdManager f30748m;

    interface ScribeService {
        @FormUrlEncoded
        @POST(a = "/{version}/jot/{type}")
        @Headers(a = {"Content-Type: application/x-www-form-urlencoded;charset=UTF-8"})
        Call<ResponseBody> upload(@Path(a = "version") String str, @Path(a = "type") String str2, @Field(a = "log[]") String str3);

        @FormUrlEncoded
        @POST(a = "/scribe/{sequence}")
        @Headers(a = {"Content-Type: application/x-www-form-urlencoded;charset=UTF-8"})
        Call<ResponseBody> uploadSequence(@Path(a = "sequence") String str, @Field(a = "log[]") String str2);
    }

    static class ConfigRequestInterceptor implements Interceptor {
        private final ScribeConfig f30734a;
        private final IdManager f30735b;

        ConfigRequestInterceptor(ScribeConfig scribeConfig, IdManager idManager) {
            this.f30734a = scribeConfig;
            this.f30735b = idManager;
        }

        public Response intercept(Chain chain) throws IOException {
            Builder newBuilder = chain.request().newBuilder();
            if (!TextUtils.isEmpty(this.f30734a.f23996f)) {
                newBuilder.header("User-Agent", this.f30734a.f23996f);
            }
            if (!TextUtils.isEmpty(this.f30735b.getDeviceUUID())) {
                newBuilder.header("X-Client-UUID", this.f30735b.getDeviceUUID());
            }
            newBuilder.header("X-Twitter-Polling", "true");
            return chain.proceed(newBuilder.build());
        }
    }

    public ScribeFilesSender(Context context, ScribeConfig scribeConfig, long j, TwitterAuthConfig twitterAuthConfig, SessionManager<? extends Session<TwitterAuthToken>> sessionManager, GuestSessionProvider guestSessionProvider, SSLSocketFactory sSLSocketFactory, ExecutorService executorService, IdManager idManager) {
        this.f30739d = context;
        this.f30740e = scribeConfig;
        this.f30741f = j;
        this.f30742g = twitterAuthConfig;
        this.f30743h = sessionManager;
        this.f30744i = guestSessionProvider;
        this.f30745j = sSLSocketFactory;
        this.f30747l = executorService;
        this.f30748m = idManager;
    }

    private String m31753a(List<File> list) throws IOException {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        final boolean[] zArr = new boolean[1];
        byteArrayOutputStream.write(f30736a);
        for (File queueFile : list) {
            Closeable queueFile2;
            try {
                queueFile2 = new QueueFile(queueFile);
                try {
                    queueFile2.m26358a(new ElementReader(this) {
                        final /* synthetic */ ScribeFilesSender f30733c;

                        public void read(InputStream inputStream, int i) throws IOException {
                            i = new byte[i];
                            inputStream.read(i);
                            if (zArr[0] != null) {
                                byteArrayOutputStream.write(ScribeFilesSender.f30737b);
                            } else {
                                zArr[0] = true;
                            }
                            byteArrayOutputStream.write(i);
                        }
                    });
                    CommonUtils.m26293a(queueFile2);
                } catch (Throwable th) {
                    list = th;
                }
            } catch (Throwable th2) {
                list = th2;
                queueFile2 = null;
            }
        }
        byteArrayOutputStream.write(f30738c);
        return byteArrayOutputStream.toString("UTF-8");
        CommonUtils.m26293a(queueFile2);
        throw list;
    }

    private synchronized ScribeService m31755b() {
        if (this.f30746k.get() == null) {
            OkHttpClient build;
            Session a = this.f30743h.mo5464a(this.f30741f);
            Object obj = (a == null || a.f23922a == null) ? null : 1;
            if (obj != null) {
                build = new OkHttpClient.Builder().sslSocketFactory(this.f30745j).addInterceptor(new ConfigRequestInterceptor(this.f30740e, this.f30748m)).addInterceptor(new OAuth1aInterceptor(a, this.f30742g)).build();
            } else {
                build = new OkHttpClient.Builder().sslSocketFactory(this.f30745j).addInterceptor(new ConfigRequestInterceptor(this.f30740e, this.f30748m)).addInterceptor(new GuestAuthInterceptor(this.f30744i)).build();
            }
            this.f30746k.compareAndSet(null, new Retrofit.Builder().a(this.f30740e.f23992b).a(build).a().a(ScribeService.class));
        }
        return (ScribeService) this.f30746k.get();
    }

    public boolean send(java.util.List<java.io.File> r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r5.m31755b();
        r1 = 0;
        r2 = 1;
        if (r0 == 0) goto L_0x000a;
    L_0x0008:
        r0 = r2;
        goto L_0x000b;
    L_0x000a:
        r0 = r1;
    L_0x000b:
        if (r0 == 0) goto L_0x0070;
    L_0x000d:
        r6 = r5.m31753a(r6);	 Catch:{ Exception -> 0x0068 }
        r0 = r5.f30739d;	 Catch:{ Exception -> 0x0068 }
        io.fabric.sdk.android.services.common.CommonUtils.m26292a(r0, r6);	 Catch:{ Exception -> 0x0068 }
        r0 = r5.m31755b();	 Catch:{ Exception -> 0x0068 }
        r3 = r5.f30740e;	 Catch:{ Exception -> 0x0068 }
        r3 = r3.f23995e;	 Catch:{ Exception -> 0x0068 }
        r3 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Exception -> 0x0068 }
        if (r3 != 0) goto L_0x0031;	 Catch:{ Exception -> 0x0068 }
    L_0x0024:
        r3 = r5.f30740e;	 Catch:{ Exception -> 0x0068 }
        r3 = r3.f23995e;	 Catch:{ Exception -> 0x0068 }
        r6 = r0.uploadSequence(r3, r6);	 Catch:{ Exception -> 0x0068 }
        r6 = r6.a();	 Catch:{ Exception -> 0x0068 }
        goto L_0x0041;	 Catch:{ Exception -> 0x0068 }
    L_0x0031:
        r3 = r5.f30740e;	 Catch:{ Exception -> 0x0068 }
        r3 = r3.f23993c;	 Catch:{ Exception -> 0x0068 }
        r4 = r5.f30740e;	 Catch:{ Exception -> 0x0068 }
        r4 = r4.f23994d;	 Catch:{ Exception -> 0x0068 }
        r6 = r0.upload(r3, r4, r6);	 Catch:{ Exception -> 0x0068 }
        r6 = r6.a();	 Catch:{ Exception -> 0x0068 }
    L_0x0041:
        r0 = r6.a;	 Catch:{ Exception -> 0x0068 }
        r0 = r0.code();	 Catch:{ Exception -> 0x0068 }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Exception -> 0x0068 }
        if (r0 != r3) goto L_0x004c;	 Catch:{ Exception -> 0x0068 }
    L_0x004b:
        return r2;	 Catch:{ Exception -> 0x0068 }
    L_0x004c:
        r0 = r5.f30739d;	 Catch:{ Exception -> 0x0068 }
        r3 = "Failed sending files";	 Catch:{ Exception -> 0x0068 }
        io.fabric.sdk.android.services.common.CommonUtils.m26302b(r0, r3);	 Catch:{ Exception -> 0x0068 }
        r0 = r6.a;	 Catch:{ Exception -> 0x0068 }
        r0 = r0.code();	 Catch:{ Exception -> 0x0068 }
        r3 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;	 Catch:{ Exception -> 0x0068 }
        if (r0 == r3) goto L_0x0067;	 Catch:{ Exception -> 0x0068 }
    L_0x005d:
        r6 = r6.a;	 Catch:{ Exception -> 0x0068 }
        r6 = r6.code();	 Catch:{ Exception -> 0x0068 }
        r0 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r6 != r0) goto L_0x0077;
    L_0x0067:
        return r2;
    L_0x0068:
        r6 = r5.f30739d;
        r0 = "Failed sending files";
        io.fabric.sdk.android.services.common.CommonUtils.m26302b(r6, r0);
        goto L_0x0077;
    L_0x0070:
        r6 = r5.f30739d;
        r0 = "Cannot attempt upload at this time";
        io.fabric.sdk.android.services.common.CommonUtils.m26292a(r6, r0);
    L_0x0077:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.core.internal.scribe.ScribeFilesSender.send(java.util.List):boolean");
    }
}
