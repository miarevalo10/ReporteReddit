package com.sendbird.android;

import com.sendbird.android.APIClient.APIClientHandler;
import com.sendbird.android.APIClient.CheckRouting.CheckRoutingHandler;
import com.sendbird.android.CountDownTimer.CountDownTimerEventHandler;
import com.sendbird.android.SendBird.ConnectionState;
import com.sendbird.android.shadow.okhttp3.EventListener;
import com.sendbird.android.shadow.okhttp3.OkHttpClient;
import com.sendbird.android.shadow.okhttp3.Protocol;
import com.sendbird.android.shadow.okhttp3.Request;
import com.sendbird.android.shadow.okhttp3.Request.Builder;
import com.sendbird.android.shadow.okhttp3.WebSocket;
import com.sendbird.android.shadow.okhttp3.WebSocketListener;
import com.sendbird.android.shadow.okhttp3.internal.Internal;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket;
import com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.C24862;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class WSClient {
    WSClientHandler f22870a;
    private StringBuffer f22871b;
    private CountDownTimer f22872c;
    private CountDownTimer f22873d;
    private long f22874e;
    private boolean f22875f;
    private Request f22876g;
    private ExecutorService f22877h;
    private OkHttpClient f22878i;
    private WebSocket f22879j;
    private boolean f22880k;
    private boolean f22881l;
    private final Object f22882m;
    private final Object f22883n;
    private final Object f22884o;

    public interface WSClientHandler {
        void mo5227a();

        void mo5228a(SendBirdException sendBirdException);

        void mo5229a(String str);

        void mo5230b();

        void mo5231c();
    }

    public interface WSClientSendHandler {
        void mo5226a(SendBirdException sendBirdException);
    }

    class C24151 implements CountDownTimerEventHandler {
        final /* synthetic */ WSClient f30216a;

        public final void mo5222a(int i, int i2) {
        }

        C24151(WSClient wSClient) {
            this.f30216a = wSClient;
        }

        public final void mo5221a() {
            Logger.m24934b("Watchdog start.");
        }

        public final void mo5223b() {
            Logger.m24934b("Watchdog stop.");
        }

        public final void mo5224c() {
            Logger.m24934b("Watchdog cancel.");
        }

        public final void mo5225d() {
            Logger.m24934b("Watchdog timeout.");
            synchronized (this.f30216a.f22882m) {
                if (this.f30216a.f22870a != null) {
                    this.f30216a.f22870a.mo5228a(new SendBirdException("Server is unreachable.", 800120));
                }
                this.f30216a.f22870a = null;
            }
            this.f30216a.m25039d();
        }
    }

    class C24162 implements CountDownTimerEventHandler {
        final /* synthetic */ WSClient f30217a;

        public final void mo5222a(int i, int i2) {
        }

        C24162(WSClient wSClient) {
            this.f30217a = wSClient;
        }

        public final void mo5221a() {
            Logger.m24934b("Pinger start.");
            this.f30217a.f22872c.m24908b();
        }

        public final void mo5223b() {
            Logger.m24934b("Pinger stop.");
            this.f30217a.f22872c.m24908b();
        }

        public final void mo5224c() {
            Logger.m24934b("Pinger cancel.");
        }

        public final void mo5225d() {
            if (System.currentTimeMillis() - this.f30217a.f22874e >= 15000) {
                this.f30217a.f22874e = System.currentTimeMillis();
                this.f30217a.m25053a(Command.m24892e(), null);
                this.f30217a.f22872c.m24907a();
            }
        }
    }

    class C24184 extends WebSocketListener {
        final /* synthetic */ WSClient f30221a;

        C24184(WSClient wSClient) {
            this.f30221a = wSClient;
        }

        public final void mo5238a(WebSocket webSocket) {
            this.f30221a.f22879j = webSocket;
            if (this.f30221a.f22870a != null) {
                this.f30221a.f22870a.mo5230b();
            }
            this.f30221a.f22873d.m24907a();
        }

        public final void mo5240a(Throwable th) {
            if (this.f30221a.f22875f) {
                synchronized (this.f30221a.f22882m) {
                    if (this.f30221a.f22870a != null) {
                        this.f30221a.f22870a.mo5231c();
                    }
                    this.f30221a.f22870a = null;
                }
                return;
            }
            this.f30221a.m25039d();
            synchronized (this.f30221a.f22882m) {
                if (this.f30221a.f22870a != null) {
                    this.f30221a.f22870a.mo5228a(new SendBirdException(th.getMessage(), 800120));
                }
                this.f30221a.f22870a = null;
            }
        }

        public final void mo5239a(String str) {
            WSClient.m25049m(this.f30221a);
            this.f30221a.f22871b.append(str);
            while (true) {
                str = this.f30221a.f22871b.indexOf("\n");
                if (str >= null) {
                    String substring = this.f30221a.f22871b.substring(0, str);
                    this.f30221a.f22871b.delete(0, str + 1);
                    if (this.f30221a.f22870a != null) {
                        str = new StringBuilder("Recv: ");
                        str.append(substring);
                        Logger.m24934b(str.toString());
                        this.f30221a.f22870a.mo5229a(substring);
                    }
                } else {
                    return;
                }
            }
        }

        public final void mo5237a(int i) {
            if (this.f30221a.f22875f) {
                synchronized (this.f30221a.f22882m) {
                    if (this.f30221a.f22870a != 0) {
                        this.f30221a.f22870a.mo5231c();
                    }
                    this.f30221a.f22870a = null;
                }
                return;
            }
            this.f30221a.m25039d();
            synchronized (this.f30221a.f22882m) {
                if (this.f30221a.f22870a != null) {
                    WSClientHandler b = this.f30221a.f22870a;
                    StringBuilder stringBuilder = new StringBuilder("WS connection closed by server. ");
                    stringBuilder.append(i);
                    b.mo5228a(new SendBirdException(stringBuilder.toString(), 800200));
                }
                this.f30221a.f22870a = null;
            }
        }
    }

    public WSClient() {
        this.f22882m = new Object();
        this.f22883n = new Object();
        this.f22884o = new Object();
        this.f22871b = new StringBuffer();
        this.f22872c = new CountDownTimer();
        this.f22872c.f22578a = new C24151(this);
        this.f22873d = new CountDownTimer(1000, 100, true);
        this.f22873d.f22578a = new C24162(this);
    }

    final void m25054a(final String str, final String str2) {
        synchronized (this.f22883n) {
            this.f22880k = true;
        }
        APIClient.m24818a().m24837a(new CheckRoutingHandler(this) {
            final /* synthetic */ WSClient f30220c;

            public final void mo5210a(String str, String str2, SendBirdException sendBirdException) {
                if (sendBirdException != null) {
                    try {
                        if (this.f30220c.f22870a != null) {
                            this.f30220c.f22870a.mo5228a(sendBirdException);
                        }
                        synchronized (this.f30220c.f22883n) {
                            this.f30220c.f22880k = false;
                        }
                    } catch (String str3) {
                        try {
                            if (this.f30220c.f22870a != null) {
                                this.f30220c.f22870a.mo5228a(new SendBirdException(str3.getMessage(), 800120));
                            }
                            synchronized (this.f30220c.f22883n) {
                                this.f30220c.f22880k = false;
                            }
                        } catch (Throwable th) {
                            synchronized (this.f30220c.f22883n) {
                                this.f30220c.f22880k = false;
                            }
                        }
                    }
                } else {
                    WSClient wSClient;
                    StringBuilder stringBuilder;
                    StringBuilder stringBuilder2;
                    sendBirdException = new StringBuilder(str2);
                    sendBirdException.append("/?p=Android&pv=");
                    sendBirdException.append(SendBird.m24977b());
                    sendBirdException.append("&sv=");
                    sendBirdException.append(SendBird.m24983c());
                    sendBirdException.append("&ai=");
                    sendBirdException.append(SendBird.m24986d());
                    if (APIClient.m24818a().m24856e() != null) {
                        if (APIClient.m24818a().m24856e().equals("") == null) {
                            sendBirdException.append("&key=");
                            sendBirdException.append(APIClient.m24818a().m24856e());
                            wSClient = this.f30220c;
                            stringBuilder = new StringBuilder("Jand/");
                            stringBuilder.append(SendBird.m24983c());
                            wSClient.f22876g = new Builder().m25317a("User-Agent", stringBuilder.toString()).m25315a(sendBirdException.toString()).m25318a();
                            str2 = new StringBuilder("WS request: ");
                            str2.append(sendBirdException.toString());
                            Logger.m24934b(str2.toString());
                            wSClient = this.f30220c;
                            sendBirdException = new OkHttpClient.Builder();
                            sendBirdException.f23254y = Util.m25355a("timeout", 0, TimeUnit.MILLISECONDS);
                            wSClient.f22878i = sendBirdException.m25309a();
                            this.f30220c.f22877h = Executors.newSingleThreadExecutor();
                            if (this.f30220c.f22870a != null) {
                                synchronized (this.f30220c.f22884o) {
                                    sendBirdException = this.f30220c.f22881l ^ 1;
                                }
                                if (sendBirdException == null) {
                                    this.f30220c.f22870a.mo5227a();
                                } else {
                                    this.f30220c.f22870a.mo5231c();
                                }
                            }
                            str2 = APIClient.m24818a();
                            stringBuilder2 = new StringBuilder("Jand/");
                            stringBuilder2.append(SendBird.m24983c());
                            stringBuilder2 = new StringBuilder("Android,");
                            stringBuilder2.append(SendBird.m24977b());
                            stringBuilder2.append(",");
                            stringBuilder2.append(SendBird.m24983c());
                            stringBuilder2.append(",");
                            stringBuilder2.append(SendBird.m24986d());
                            str2.m24838a(new Builder().m25317a("Accept", "application/json").m25317a("User-Agent", stringBuilder2.toString()).m25317a("SendBird", stringBuilder2.toString()).m25317a("Connection", "keep-alive").m25315a(str3).m25318a(), (APIClientHandler) null);
                            synchronized (this.f30220c.f22883n) {
                                this.f30220c.f22880k = false;
                            }
                        }
                    }
                    sendBirdException.append("&user_id=");
                    sendBirdException.append(UrlUtil.m24816a(str));
                    if (str2 != null) {
                        sendBirdException.append("&access_token=");
                        sendBirdException.append(str2);
                    }
                    wSClient = this.f30220c;
                    stringBuilder = new StringBuilder("Jand/");
                    stringBuilder.append(SendBird.m24983c());
                    wSClient.f22876g = new Builder().m25317a("User-Agent", stringBuilder.toString()).m25315a(sendBirdException.toString()).m25318a();
                    str2 = new StringBuilder("WS request: ");
                    str2.append(sendBirdException.toString());
                    Logger.m24934b(str2.toString());
                    wSClient = this.f30220c;
                    sendBirdException = new OkHttpClient.Builder();
                    sendBirdException.f23254y = Util.m25355a("timeout", 0, TimeUnit.MILLISECONDS);
                    wSClient.f22878i = sendBirdException.m25309a();
                    this.f30220c.f22877h = Executors.newSingleThreadExecutor();
                    if (this.f30220c.f22870a != null) {
                        synchronized (this.f30220c.f22884o) {
                            sendBirdException = this.f30220c.f22881l ^ 1;
                        }
                        if (sendBirdException == null) {
                            this.f30220c.f22870a.mo5231c();
                        } else {
                            this.f30220c.f22870a.mo5227a();
                        }
                    }
                    str2 = APIClient.m24818a();
                    stringBuilder2 = new StringBuilder("Jand/");
                    stringBuilder2.append(SendBird.m24983c());
                    stringBuilder2 = new StringBuilder("Android,");
                    stringBuilder2.append(SendBird.m24977b());
                    stringBuilder2.append(",");
                    stringBuilder2.append(SendBird.m24983c());
                    stringBuilder2.append(",");
                    stringBuilder2.append(SendBird.m24986d());
                    str2.m24838a(new Builder().m25317a("Accept", "application/json").m25317a("User-Agent", stringBuilder2.toString()).m25317a("SendBird", stringBuilder2.toString()).m25317a("Connection", "keep-alive").m25315a(str3).m25318a(), (APIClientHandler) null);
                    synchronized (this.f30220c.f22883n) {
                        this.f30220c.f22880k = false;
                    }
                }
            }
        });
    }

    public final synchronized void m25052a() {
        if (this.f22878i != null) {
            OkHttpClient okHttpClient = this.f22878i;
            WebSocket realWebSocket = new RealWebSocket(this.f22876g, new C24184(this), new Random());
            OkHttpClient.Builder builder = new OkHttpClient.Builder(okHttpClient);
            EventListener eventListener = EventListener.f23191a;
            if (eventListener == null) {
                throw new NullPointerException("eventListener == null");
            }
            builder.f23236g = EventListener.m25236a(eventListener);
            List arrayList = new ArrayList(RealWebSocket.f30532a);
            StringBuilder stringBuilder;
            if (!arrayList.contains(Protocol.HTTP_1_1)) {
                stringBuilder = new StringBuilder("protocols doesn't contain http/1.1: ");
                stringBuilder.append(arrayList);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (arrayList.contains(Protocol.HTTP_1_0)) {
                stringBuilder = new StringBuilder("protocols must not contain http/1.0: ");
                stringBuilder.append(arrayList);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (arrayList.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            } else {
                arrayList.remove(Protocol.SPDY_3);
                builder.f23232c = Collections.unmodifiableList(arrayList);
                okHttpClient = builder.m25309a();
                int i = okHttpClient.f23260C;
                Request a = realWebSocket.f30534b.newBuilder().m25317a("Upgrade", "websocket").m25317a("Connection", "Upgrade").m25317a("Sec-WebSocket-Key", realWebSocket.f30537e).m25317a("Sec-WebSocket-Version", "13").m25318a();
                realWebSocket.f30538f = Internal.instance.newWebSocketCall(okHttpClient, a);
                realWebSocket.f30538f.mo5319a(new C24862(realWebSocket, a, i));
                this.f22879j = realWebSocket;
                this.f22878i.f23261c.m25230a().shutdown();
            }
        }
    }

    public final void m25055b() {
        this.f22875f = true;
        m25039d();
    }

    public final ConnectionState m25056c() {
        if (this.f22878i != null && this.f22879j != null && SendBird.m24988e().m25016a()) {
            return ConnectionState.OPEN;
        }
        if (this.f22878i == null) {
            if (!this.f22880k) {
                return ConnectionState.CLOSED;
            }
        }
        return ConnectionState.CONNECTING;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m25039d() {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.f22884o;	 Catch:{ all -> 0x005c }
        monitor-enter(r0);	 Catch:{ all -> 0x005c }
        r1 = r3.f22881l;	 Catch:{ all -> 0x0059 }
        if (r1 == 0) goto L_0x000b;
    L_0x0008:
        monitor-exit(r0);	 Catch:{ all -> 0x0059 }
        monitor-exit(r3);
        return;
    L_0x000b:
        monitor-exit(r0);	 Catch:{ all -> 0x0059 }
        r0 = r3.f22873d;	 Catch:{ all -> 0x005c }
        r0.m24908b();	 Catch:{ all -> 0x005c }
        r0 = r3.f22877h;	 Catch:{ all -> 0x005c }
        r1 = 0;
        if (r0 == 0) goto L_0x0028;
    L_0x0016:
        r0 = r3.f22877h;	 Catch:{ Exception -> 0x0020 }
        r0.shutdown();	 Catch:{ Exception -> 0x0020 }
    L_0x001b:
        r3.f22877h = r1;	 Catch:{ all -> 0x005c }
        goto L_0x0028;
    L_0x001e:
        r0 = move-exception;
        goto L_0x0025;
    L_0x0020:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x001e }
        goto L_0x001b;
    L_0x0025:
        r3.f22877h = r1;	 Catch:{ all -> 0x005c }
        throw r0;	 Catch:{ all -> 0x005c }
    L_0x0028:
        r0 = r3.f22879j;	 Catch:{ all -> 0x005c }
        if (r0 == 0) goto L_0x0031;
    L_0x002c:
        r0 = r3.f22879j;	 Catch:{ all -> 0x005c }
        r0.mo5377a();	 Catch:{ all -> 0x005c }
    L_0x0031:
        r0 = r3.f22879j;	 Catch:{ Exception -> 0x003d }
        if (r0 == 0) goto L_0x0041;
    L_0x0035:
        r0 = r3.f22879j;	 Catch:{ Exception -> 0x003d }
        r2 = "";
        r0.mo5381b(r2);	 Catch:{ Exception -> 0x003d }
        goto L_0x0041;
    L_0x003d:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x005c }
    L_0x0041:
        r0 = com.sendbird.android.SendBird.m24988e();	 Catch:{ all -> 0x005c }
        r2 = 0;
        r0.m25015a(r2);	 Catch:{ all -> 0x005c }
        r3.f22879j = r1;	 Catch:{ all -> 0x005c }
        r3.f22878i = r1;	 Catch:{ all -> 0x005c }
        r0 = r3.f22884o;	 Catch:{ all -> 0x005c }
        monitor-enter(r0);	 Catch:{ all -> 0x005c }
        r1 = 1;
        r3.f22881l = r1;	 Catch:{ all -> 0x0056 }
        monitor-exit(r0);	 Catch:{ all -> 0x0056 }
        monitor-exit(r3);
        return;
    L_0x0056:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0056 }
        throw r1;	 Catch:{ all -> 0x005c }
    L_0x0059:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0059 }
        throw r1;	 Catch:{ all -> 0x005c }
    L_0x005c:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.WSClient.d():void");
    }

    public final void m25053a(final Command command, final WSClientSendHandler wSClientSendHandler) {
        StringBuilder stringBuilder = new StringBuilder("Send: ");
        stringBuilder.append(command.m24895c());
        Logger.m24934b(stringBuilder.toString());
        if (this.f22878i == null || this.f22879j == null || this.f22877h == null) {
            if (wSClientSendHandler != null) {
                wSClientSendHandler.mo5226a(new SendBirdException("Connection closed.", 800200));
            }
            return;
        }
        try {
            this.f22877h.execute(new Runnable(this) {
                final /* synthetic */ WSClient f22869c;

                public void run() {
                    if (this.f22869c.f22879j != null) {
                        try {
                            this.f22869c.f22879j.mo5380a(command.m24895c());
                            if (wSClientSendHandler != null) {
                                wSClientSendHandler.mo5226a(null);
                            }
                        } catch (Exception e) {
                            if (wSClientSendHandler != null) {
                                wSClientSendHandler.mo5226a(new SendBirdException(e.getMessage(), 800210));
                            }
                        }
                    }
                }
            });
        } catch (Command command2) {
            if (wSClientSendHandler != null) {
                wSClientSendHandler.mo5226a(new SendBirdException(command2.getMessage(), 800120));
            }
        }
    }

    static /* synthetic */ void m25049m(WSClient wSClient) {
        wSClient.f22874e = System.currentTimeMillis();
        wSClient.f22872c.m24908b();
    }
}
