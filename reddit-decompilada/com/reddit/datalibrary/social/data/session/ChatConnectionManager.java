package com.reddit.datalibrary.social.data.session;

import android.content.Context;
import android.text.TextUtils;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v2.SendBirdAccessTokenData;
import com.reddit.datalibrary.social.data.repo.ChatCredentialsRepository;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.Connectivity;
import com.reddit.frontpage.util.NetworkUtil;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import com.reddit.social.util.ChatSharedPreferencesUtil;
import com.sendbird.android.SendBird;
import com.sendbird.android.SendBird.ConnectionHandler;
import com.sendbird.android.SendBird.ConnectionState;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import java.util.Map;
import java.util.Random;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 #2\u00020\u0001:\u0003\"#$B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0014H\u0007J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0003J\b\u0010\u0016\u001a\u00020\nH\u0002J\b\u0010\u0017\u001a\u00020\nH\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u0014H\u0002J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u00142\u0006\u0010\u001f\u001a\u00020\rH\u0003J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\u0014H\u0002J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\u0014H\u0003R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/reddit/datalibrary/social/data/session/ChatConnectionManager;", "", "()V", "chatCredentialsRepository", "Lcom/reddit/datalibrary/social/data/repo/ChatCredentialsRepository;", "getChatCredentialsRepository", "()Lcom/reddit/datalibrary/social/data/repo/ChatCredentialsRepository;", "setChatCredentialsRepository", "(Lcom/reddit/datalibrary/social/data/repo/ChatCredentialsRepository;)V", "connecting", "", "connectionSubject", "Lio/reactivex/subjects/PublishSubject;", "", "hasNetworkConnection", "needsReconnect", "reconnectSubject", "sendBirdAccessTokenData", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/SendBirdAccessTokenData;", "connect", "Lio/reactivex/Observable;", "connectObservable", "goodConnectionSubject", "hasOpenConnection", "initConnectionHandler", "", "networkStateChange", "connectivity", "Lcom/reddit/frontpage/util/Connectivity;", "proxyHost", "sendBirdConnectObservable", "sendBirdProxyHost", "sendBirdReconnectObservable", "userDataForConnect", "Callback", "Companion", "RetryWithDelay", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatConnectionManager.kt */
public final class ChatConnectionManager {
    public static final Companion f19854b = new Companion();
    private static final Lazy f19855i = LazyKt.m26777a(ChatConnectionManager$Companion$instance$2.f36328a);
    private static final String f19856j = "REMOTE_DATA_SOURCE_CONNECTION_HANDLER";
    private static final int f19857k = 500;
    private static final long f19858l = 5;
    private static boolean f19859m;
    @Inject
    public ChatCredentialsRepository f19860a;
    private SendBirdAccessTokenData f19861c;
    private boolean f19862d;
    private PublishSubject<String> f19863e;
    private PublishSubject<String> f19864f;
    private boolean f19865g;
    private boolean f19866h;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/reddit/datalibrary/social/data/session/ChatConnectionManager$Companion;", "", "()V", "CONNECTION_HANDLER_ID", "", "getCONNECTION_HANDLER_ID", "()Ljava/lang/String;", "RETRY_TIMEFRAME", "", "getRETRY_TIMEFRAME", "()I", "SENDBIRD_CONNECT_TIMEOUT", "", "getSENDBIRD_CONNECT_TIMEOUT", "()J", "instance", "Lcom/reddit/datalibrary/social/data/session/ChatConnectionManager;", "getInstance", "()Lcom/reddit/datalibrary/social/data/session/ChatConnectionManager;", "instance$delegate", "Lkotlin/Lazy;", "sendbirdInitialized", "", "getSendbirdInitialized", "()Z", "setSendbirdInitialized", "(Z)V", "init", "", "forceInit", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ChatConnectionManager.kt */
    public static final class Companion {
        static final /* synthetic */ KProperty[] f19852a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(Companion.class), "instance", "getInstance()Lcom/reddit/datalibrary/social/data/session/ChatConnectionManager;"))};

        public static ChatConnectionManager m21750a() {
            return (ChatConnectionManager) ChatConnectionManager.f19855i.mo5678b();
        }

        private Companion() {
        }

        public static void m21751a(boolean z) {
            if (!ChatConnectionManager.f19859m || z) {
                Object obj = FrontpageApplication.f27402a;
                Intrinsics.m26843a(obj, "FrontpageApplication.instance");
                SendBird.m24975a("2515BDA8-9D3A-47CF-9325-330BC37ADA13", obj.getApplicationContext());
                ChatConnectionManager.f19859m = true;
            }
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0004\u0018\u00002\u001a\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u001c\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00022\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\t\"\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/reddit/datalibrary/social/data/session/ChatConnectionManager$RetryWithDelay;", "Lio/reactivex/functions/Function;", "Lio/reactivex/Observable;", "", "maxRetries", "", "retryDelayMillis", "(Lcom/reddit/datalibrary/social/data/session/ChatConnectionManager;II)V", "getMaxRetries", "()I", "retryCount", "getRetryCount", "setRetryCount", "(I)V", "getRetryDelayMillis", "apply", "attempts", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ChatConnectionManager.kt */
    private final class RetryWithDelay implements Function<Observable<? extends Throwable>, Observable<?>> {
        int f27374a;
        final int f27375b = 1;
        final int f27376c;
        final /* synthetic */ ChatConnectionManager f27377d;

        public RetryWithDelay(ChatConnectionManager chatConnectionManager, int i) {
            this.f27377d = chatConnectionManager;
            this.f27376c = i;
        }

        public final /* synthetic */ Object apply(Object obj) {
            Observable observable = (Observable) obj;
            Intrinsics.m26847b(observable, "attempts");
            obj = observable.flatMap(new ChatConnectionManager$RetryWithDelay$apply$1(this));
            Intrinsics.m26843a(obj, "attempts\n          .flat…>(throwable)\n          })");
            return obj;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "userId", "", "invoke"}, k = 3, mv = {1, 1, 9})
    /* compiled from: ChatConnectionManager.kt */
    static final class C28111 extends Lambda implements Function1<String, Unit> {
        public static final C28111 f36326a = new C28111();

        C28111() {
            super(1);
        }

        public final /* synthetic */ Object mo6492a(Object obj) {
            String str = (String) obj;
            Intrinsics.m26847b(str, "userId");
            StringBuilder stringBuilder = new StringBuilder("Connected: ");
            stringBuilder.append(str);
            Timber.b(stringBuilder.toString(), new Object[0]);
            return Unit.f25273a;
        }
    }

    private ChatConnectionManager() {
        Object create = PublishSubject.create();
        Intrinsics.m26843a(create, "PublishSubject.create()");
        this.f19863e = create;
        create = PublishSubject.create();
        Intrinsics.m26843a(create, "PublishSubject.create()");
        this.f19864f = create;
        FrontpageApplication.m28878n().mo5079a(this);
        Companion.m21751a(true);
        SendBird.m24970a(f19856j, (ConnectionHandler) new ChatConnectionManager$initConnectionHandler$1(this));
        this.f19865g = NetworkUtil.m23842b();
        ObservablesKt.m24091a(m21772b(), (Function1) C28111.f36326a);
        ObservablesKt.m24091a(NetworkUtil.m23840a(), (Function1) new Function1<Connectivity, Unit>() {
            public final /* synthetic */ Object mo6492a(Object obj) {
                Connectivity connectivity = (Connectivity) obj;
                Intrinsics.m26847b(connectivity, "it");
                ChatConnectionManager.m21758a(this, connectivity);
                return Unit.f25273a;
            }
        });
    }

    public final ChatCredentialsRepository m21771a() {
        ChatCredentialsRepository chatCredentialsRepository = this.f19860a;
        if (chatCredentialsRepository == null) {
            Intrinsics.m26844a("chatCredentialsRepository");
        }
        return chatCredentialsRepository;
    }

    public final Observable<String> m21772b() {
        if (SessionUtil.m23898d() == null) {
            Object error = Observable.error((Throwable) new NullPointerException("user account is null"));
            Intrinsics.m26843a(error, "Observable.error(NullPoi…(\"user account is null\"))");
            return error;
        }
        String d;
        Observable just;
        if (!(this.f19862d || SendBird.m25001k() == null || this.f19866h || !Intrinsics.m26845a(SendBird.m24995h(), ConnectionState.OPEN))) {
            error = SessionManager.b();
            Intrinsics.m26843a(error, "SessionManager.getInstance()");
            error = error.c();
            Intrinsics.m26843a(error, "SessionManager.getInstance().activeSession");
            if (!error.d()) {
                error = 1;
                if (error == null) {
                    error = SendBird.m25001k();
                    Intrinsics.m26843a(error, "SendBird.getCurrentUser()");
                    error = Observable.just(error.m25021d());
                    Intrinsics.m26843a(error, "Observable.just(SendBird.getCurrentUser().userId)");
                    return error;
                }
                if (this.f19864f.hasComplete() || this.f19864f.hasThrowable()) {
                    error = PublishSubject.create();
                    Intrinsics.m26843a(error, "PublishSubject.create()");
                    this.f19864f = error;
                }
                if (this.f19866h) {
                    d = SessionUtil.m23898d();
                    if (d == null) {
                        Intrinsics.m26842a();
                    }
                    just = Observable.just(d);
                    Intrinsics.m26843a((Object) just, "Observable.just(SessionU…rentSessionAccountID()!!)");
                } else {
                    just = this.f19864f;
                }
                error = just.flatMap(new ChatConnectionManager$connect$1(this));
                Intrinsics.m26843a(error, "sendBirdReconnectObserva…p { connectObservable() }");
                return error;
            }
        }
        error = null;
        if (error == null) {
            error = PublishSubject.create();
            Intrinsics.m26843a(error, "PublishSubject.create()");
            this.f19864f = error;
            if (this.f19866h) {
                d = SessionUtil.m23898d();
                if (d == null) {
                    Intrinsics.m26842a();
                }
                just = Observable.just(d);
                Intrinsics.m26843a((Object) just, "Observable.just(SessionU…rentSessionAccountID()!!)");
            } else {
                just = this.f19864f;
            }
            error = just.flatMap(new ChatConnectionManager$connect$1(this));
            Intrinsics.m26843a(error, "sendBirdReconnectObserva…p { connectObservable() }");
            return error;
        }
        error = SendBird.m25001k();
        Intrinsics.m26843a(error, "SendBird.getCurrentUser()");
        error = Observable.just(error.m25021d());
        Intrinsics.m26843a(error, "Observable.just(SendBird.getCurrentUser().userId)");
        return error;
    }

    public static final /* synthetic */ PublishSubject m21765e(ChatConnectionManager chatConnectionManager) {
        if (chatConnectionManager.f19862d) {
            boolean z = (chatConnectionManager.f19863e.hasThrowable() || chatConnectionManager.f19863e.hasComplete()) ? false : true;
            if (z) {
                return chatConnectionManager.f19863e;
            }
        }
        Object create = PublishSubject.create();
        Intrinsics.m26843a(create, "PublishSubject.create()");
        chatConnectionManager.f19863e = create;
        chatConnectionManager.f19862d = true;
        create = SessionManager.b();
        Intrinsics.m26843a(create, "SessionManager.getInstance()");
        Session c = create.c();
        Object b = SessionManager.b();
        Intrinsics.m26843a(b, "SessionManager.getInstance()");
        create = Observable.zip(b.h(), Observable.fromCallable(new ChatConnectionManager$userDataForConnect$1(c)).subscribeOn(SchedulerProvider.m23886b()), ChatConnectionManager$userDataForConnect$2.f27393a);
        Intrinsics.m26843a(create, "Observable.zip(\n        …on { token, _ -> token })");
        create.flatMap(new ChatConnectionManager$connectObservable$1(chatConnectionManager)).flatMap(new ChatConnectionManager$connectObservable$2(chatConnectionManager)).doFinally(new ChatConnectionManager$connectObservable$3(chatConnectionManager)).retryWhen(new RetryWithDelay(chatConnectionManager, new Random().nextInt(f19857k))).subscribe(new ChatConnectionManager$connectObservable$4(chatConnectionManager), new ChatConnectionManager$connectObservable$5(chatConnectionManager), new ChatConnectionManager$connectObservable$6(chatConnectionManager));
        return chatConnectionManager.f19863e;
    }

    public static final /* synthetic */ Observable m21767f(ChatConnectionManager chatConnectionManager) {
        Object obj;
        Observable just;
        Object map;
        ChatCredentialsRepository chatCredentialsRepository = chatConnectionManager.f19860a;
        if (chatCredentialsRepository == null) {
            Intrinsics.m26844a("chatCredentialsRepository");
        }
        String d = SessionUtil.m23898d();
        if (d == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26847b(d, "userId");
        if (chatCredentialsRepository.f19851c == null) {
            chatCredentialsRepository.f19851c = ChatSharedPreferencesUtil.m24743a((Context) FrontpageApplication.f27402a);
        }
        if (chatCredentialsRepository.f19851c != null) {
            Map map2 = chatCredentialsRepository.f19851c;
            obj = map2 != null ? (SendBirdAccessTokenData) map2.get(d) : null;
            if (!(obj == null || TextUtils.isEmpty(obj.sb_access_token) || obj.valid_until <= System.currentTimeMillis())) {
                if (obj == null) {
                    just = Observable.just(obj);
                    Intrinsics.m26843a((Object) just, "Observable.just(sendBirdAccessTokenData)");
                } else {
                    just = chatCredentialsRepository.f19849a.m28846b().subscribeOn(SchedulerProvider.m23886b()).doOnNext(new ChatCredentialsRepository$fetchSendBirdAccessTokenData$1(chatCredentialsRepository, d));
                    Intrinsics.m26843a((Object) just, "baseplateClient.fetchSen…Data(userId, tokenData) }");
                }
                map = just.doOnNext(new ChatConnectionManager$proxyHost$1(chatConnectionManager)).flatMap(new ChatConnectionManager$proxyHost$2(chatConnectionManager)).map(ChatConnectionManager$proxyHost$3.f27388a);
                Intrinsics.m26843a(map, "chatCredentialsRepositor…   .map { it.proxy_host }");
                return map;
            }
        }
        obj = null;
        if (obj == null) {
            just = chatCredentialsRepository.f19849a.m28846b().subscribeOn(SchedulerProvider.m23886b()).doOnNext(new ChatCredentialsRepository$fetchSendBirdAccessTokenData$1(chatCredentialsRepository, d));
            Intrinsics.m26843a((Object) just, "baseplateClient.fetchSen…Data(userId, tokenData) }");
        } else {
            just = Observable.just(obj);
            Intrinsics.m26843a((Object) just, "Observable.just(sendBirdAccessTokenData)");
        }
        map = just.doOnNext(new ChatConnectionManager$proxyHost$1(chatConnectionManager)).flatMap(new ChatConnectionManager$proxyHost$2(chatConnectionManager)).map(ChatConnectionManager$proxyHost$3.f27388a);
        Intrinsics.m26843a(map, "chatCredentialsRepositor…   .map { it.proxy_host }");
        return map;
    }

    public static final /* synthetic */ Observable m21755a(ChatConnectionManager chatConnectionManager, String str) {
        Object a = FrontpageSettings.a();
        Intrinsics.m26843a(a, "FrontpageSettings.getInstance()");
        if (a.l()) {
            Object create = Observable.create(new ChatConnectionManager$sendBirdConnectObservable$1(chatConnectionManager, str));
            Intrinsics.m26843a(create, "Observable.create { e ->…plete()\n        }\n      }");
            return create;
        }
        chatConnectionManager = chatConnectionManager.f19860a;
        if (chatConnectionManager == null) {
            Intrinsics.m26844a("chatCredentialsRepository");
        }
        Object d = SessionUtil.m23898d();
        Intrinsics.m26843a(d, "SessionUtil.getTypedCurrentSessionAccountID()");
        chatConnectionManager.m21698a(d);
        create = Observable.empty();
        Intrinsics.m26843a(create, "Observable.empty()");
        return create;
    }

    public static final /* synthetic */ void m21758a(ChatConnectionManager chatConnectionManager, Connectivity connectivity) {
        if (connectivity.f21708a != chatConnectionManager.f19865g) {
            chatConnectionManager.f19865g = connectivity.f21708a;
            if (chatConnectionManager.f19865g != null) {
                SendBird.m24998i();
                return;
            }
            chatConnectionManager.f19866h = true;
        }
    }
}
