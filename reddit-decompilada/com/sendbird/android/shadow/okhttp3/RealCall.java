package com.sendbird.android.shadow.okhttp3;

import com.sendbird.android.shadow.okhttp3.internal.NamedRunnable;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okhttp3.internal.cache.CacheInterceptor;
import com.sendbird.android.shadow.okhttp3.internal.connection.ConnectInterceptor;
import com.sendbird.android.shadow.okhttp3.internal.connection.RealConnection;
import com.sendbird.android.shadow.okhttp3.internal.connection.StreamAllocation;
import com.sendbird.android.shadow.okhttp3.internal.http.BridgeInterceptor;
import com.sendbird.android.shadow.okhttp3.internal.http.CallServerInterceptor;
import com.sendbird.android.shadow.okhttp3.internal.http.HttpCodec;
import com.sendbird.android.shadow.okhttp3.internal.http.RealInterceptorChain;
import com.sendbird.android.shadow.okhttp3.internal.http.RetryAndFollowUpInterceptor;
import com.sendbird.android.shadow.okhttp3.internal.platform.Platform;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class RealCall implements Call {
    final OkHttpClient f30367a;
    final RetryAndFollowUpInterceptor f30368b;
    EventListener f30369c;
    final Request f30370d;
    final boolean f30371e;
    private boolean f30372f;

    final class AsyncCall extends NamedRunnable {
        final /* synthetic */ RealCall f30365a;
        private final Callback f30366c;

        AsyncCall(RealCall realCall, Callback callback) {
            this.f30365a = realCall;
            super("OkHttp %s", realCall.m31342d());
            this.f30366c = callback;
        }

        final String m31335a() {
            return this.f30365a.f30370d.url().f23215b;
        }

        protected final void mo5317b() {
            IOException iOException;
            Object obj;
            Platform b;
            StringBuilder stringBuilder;
            RealCall realCall;
            StringBuilder stringBuilder2;
            Dispatcher dispatcher;
            try {
                RealCall realCall2 = this.f30365a;
                List arrayList = new ArrayList();
                arrayList.addAll(realCall2.f30367a.f23265g);
                arrayList.add(realCall2.f30368b);
                arrayList.add(new BridgeInterceptor(realCall2.f30367a.f23269k));
                OkHttpClient okHttpClient = realCall2.f30367a;
                arrayList.add(new CacheInterceptor(okHttpClient.f23270l != null ? okHttpClient.f23270l.internalCache : okHttpClient.f23271m));
                arrayList.add(new ConnectInterceptor(realCall2.f30367a));
                if (!realCall2.f30371e) {
                    arrayList.addAll(realCall2.f30367a.f23266h);
                }
                arrayList.add(new CallServerInterceptor(realCall2.f30371e));
                RealInterceptorChain realInterceptorChain = r4;
                RealCall realCall3 = realCall2;
                RealInterceptorChain realInterceptorChain2 = new RealInterceptorChain(arrayList, null, null, null, 0, realCall2.f30370d, realCall2, realCall2.f30369c, realCall2.f30367a.f23284z, realCall2.f30367a.f23258A, realCall2.f30367a.f23259B);
                Response a = realInterceptorChain.mo5330a(realCall3.f30370d);
                if (r1.f30365a.f30368b.f30424c) {
                    try {
                        r1.f30366c.mo5209a(r1.f30365a, new IOException("Canceled"));
                    } catch (Throwable e) {
                        iOException = e;
                        obj = 1;
                        if (obj == null) {
                            try {
                                b = Platform.m25549b();
                                stringBuilder = new StringBuilder("Callback failure for ");
                                realCall = r1.f30365a;
                                stringBuilder2 = new StringBuilder();
                                stringBuilder2.append(realCall.f30368b.f30424c ? "canceled " : "");
                                stringBuilder2.append(realCall.f30371e ? "web socket" : "call");
                                stringBuilder2.append(" to ");
                                stringBuilder2.append(realCall.m31342d());
                                stringBuilder.append(stringBuilder2.toString());
                                b.mo5370a(4, stringBuilder.toString(), (Throwable) iOException);
                            } catch (Throwable e2) {
                                Throwable th = e2;
                                r1.f30365a.f30367a.f23261c.m25233b(r1);
                            }
                        } else {
                            EventListener.m25256t();
                            r1.f30366c.mo5209a(r1.f30365a, iOException);
                        }
                        dispatcher = r1.f30365a.f30367a.f23261c;
                        dispatcher.m25233b(r1);
                    }
                }
                r1.f30366c.mo5208a(r1.f30365a, a);
                dispatcher = r1.f30365a.f30367a.f23261c;
            } catch (Throwable e22) {
                iOException = e22;
                obj = null;
                if (obj == null) {
                    EventListener.m25256t();
                    r1.f30366c.mo5209a(r1.f30365a, iOException);
                } else {
                    b = Platform.m25549b();
                    stringBuilder = new StringBuilder("Callback failure for ");
                    realCall = r1.f30365a;
                    stringBuilder2 = new StringBuilder();
                    if (realCall.f30368b.f30424c) {
                    }
                    stringBuilder2.append(realCall.f30368b.f30424c ? "canceled " : "");
                    if (realCall.f30371e) {
                    }
                    stringBuilder2.append(realCall.f30371e ? "web socket" : "call");
                    stringBuilder2.append(" to ");
                    stringBuilder2.append(realCall.m31342d());
                    stringBuilder.append(stringBuilder2.toString());
                    b.mo5370a(4, stringBuilder.toString(), (Throwable) iOException);
                }
                dispatcher = r1.f30365a.f30367a.f23261c;
                dispatcher.m25233b(r1);
            }
            dispatcher.m25233b(r1);
        }
    }

    private RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        this.f30367a = okHttpClient;
        this.f30370d = request;
        this.f30371e = z;
        this.f30368b = new RetryAndFollowUpInterceptor(okHttpClient, z);
    }

    public static RealCall m31337a(OkHttpClient okHttpClient, Request request, boolean z) {
        RealCall realCall = new RealCall(okHttpClient, request, z);
        realCall.f30369c = okHttpClient.f23267i.mo5302a();
        return realCall;
    }

    public final Request mo5318a() {
        return this.f30370d;
    }

    public final void mo5319a(Callback callback) {
        synchronized (this) {
            if (this.f30372f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f30372f = true;
        }
        this.f30368b.f30423b = Platform.m25549b().mo5368a("response.body().close()");
        EventListener.m25237a();
        this.f30367a.f23261c.m25231a(new AsyncCall(this, callback));
    }

    public final void mo5320b() {
        RetryAndFollowUpInterceptor retryAndFollowUpInterceptor = this.f30368b;
        retryAndFollowUpInterceptor.f30424c = true;
        StreamAllocation streamAllocation = retryAndFollowUpInterceptor.f30422a;
        if (streamAllocation != null) {
            HttpCodec httpCodec;
            RealConnection realConnection;
            synchronized (streamAllocation.f23410d) {
                streamAllocation.f23415i = true;
                httpCodec = streamAllocation.f23416j;
                realConnection = streamAllocation.f23414h;
            }
            if (httpCodec != null) {
                httpCodec.mo5344c();
            } else if (realConnection != null) {
                Util.m25367a(realConnection.f30392b);
            }
        }
    }

    public final boolean mo5321c() {
        return this.f30368b.f30424c;
    }

    final String m31342d() {
        return this.f30370d.url().m25300h();
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m31337a(this.f30367a, this.f30370d, this.f30371e);
    }
}
