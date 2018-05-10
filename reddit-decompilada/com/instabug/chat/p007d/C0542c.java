package com.instabug.chat.p007d;

import android.content.Context;
import android.os.Handler;
import com.instabug.chat.settings.C0554a;
import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.network.RequestResponse;
import com.instabug.library.util.InstabugSDKLogger;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Subscription;
import rx.functions.Action1;

/* compiled from: SynchronizationManager */
public class C0542c {
    private static C0542c f9251e;
    public Handler f9252a;
    public C0541a f9253b;
    public Subscription f9254c;
    public Action1<Long> f9255d = new C13062(this);
    private boolean f9256f = false;
    private boolean f9257g = false;
    private Action1<Long> f9258h = new C13051(this);

    /* compiled from: SynchronizationManager */
    private class C0541a implements Runnable {
        WeakReference<Context> f9249a;
        final /* synthetic */ C0542c f9250b;

        public C0541a(C0542c c0542c, Context context) {
            this.f9250b = c0542c;
            this.f9249a = new WeakReference(context);
        }

        public void run() {
            if (this.f9249a == null || this.f9249a.get() == null) {
                this.f9250b.f9258h.a(Long.valueOf(C0554a.m7948e()));
            } else {
                C0542c.m7915a(this.f9250b, (Context) this.f9249a.get(), this.f9250b.f9258h);
            }
        }
    }

    /* compiled from: SynchronizationManager */
    class C13051 implements Action1<Long> {
        final /* synthetic */ C0542c f15367a;

        C13051(C0542c c0542c) {
            this.f15367a = c0542c;
        }

        public final /* synthetic */ void m15265a(Object obj) {
            Long l = (Long) obj;
            if (this.f15367a.f9256f) {
                StringBuilder stringBuilder = new StringBuilder("Waiting ");
                stringBuilder.append(l);
                stringBuilder.append(" seconds until the  next sync");
                InstabugSDKLogger.m8360v(this, stringBuilder.toString());
                this.f15367a.f9252a.postDelayed(this.f15367a.f9253b, l.longValue() * 1000);
            }
        }
    }

    /* compiled from: SynchronizationManager */
    class C13062 implements Action1<Long> {
        final /* synthetic */ C0542c f15368a;

        C13062(C0542c c0542c) {
            this.f15368a = c0542c;
        }

        public final /* synthetic */ void m15266a(Object obj) {
            this.f15368a.m7924b();
        }
    }

    public static C0542c m7913a() {
        if (f9251e == null) {
            f9251e = new C0542c();
        }
        return f9251e;
    }

    public final void m7925c() {
        this.f9256f = false;
        if (this.f9252a != null && this.f9253b != null) {
            this.f9252a.removeCallbacks(this.f9253b);
        }
    }

    private void m7919a(Action1<Long> action1) {
        InstabugSDKLogger.m8360v(this, "Something went wrong while sync messages");
        this.f9257g = false;
        action1.a(Long.valueOf(C0554a.m7948e()));
    }

    private void m7914a(Context context, JSONArray jSONArray, boolean z) throws JSONException {
        if (jSONArray.length() != 0) {
            StringBuilder stringBuilder = new StringBuilder("new messages received: ");
            stringBuilder.append(jSONArray.toString());
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            JSONObject[] jSONObjectArr = new JSONObject[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                jSONObjectArr[i] = jSONArray.getJSONObject(i);
            }
            jSONArray = new StringBuilder("messages count:");
            jSONArray.append(jSONObjectArr.length);
            InstabugSDKLogger.m8360v(this, jSONArray.toString());
            C0539a.m7900a().m7910a(context, z, jSONObjectArr);
        }
    }

    public final void m7924b() {
        if ((InstabugCore.getFeatureState(Feature.IN_APP_MESSAGING) == State.ENABLED) && !this.f9257g) {
            m7925c();
            this.f9256f = true;
            this.f9252a.post(this.f9253b);
        }
    }

    static /* synthetic */ void m7916a(C0542c c0542c, RequestResponse requestResponse, Context context, Action1 action1) {
        InstabugSDKLogger.m8360v(c0542c, "Chats synced successfully");
        boolean z = false;
        c0542c.f9257g = false;
        try {
            JSONArray jSONArray = new JSONObject((String) requestResponse.getResponseBody()).getJSONArray("missing_messages");
            if (requestResponse.getResponseCode() == 203) {
                z = true;
            }
            c0542c.m7914a(context, jSONArray, z);
            long j = new JSONObject((String) requestResponse.getResponseBody()).getLong("ttl");
            StringBuilder stringBuilder = new StringBuilder("Next TTL: ");
            stringBuilder.append(j);
            InstabugSDKLogger.m8360v(c0542c, stringBuilder.toString());
            if (j != -1) {
                C0554a.m7942b(j);
                action1.a(Long.valueOf(j));
            }
        } catch (RequestResponse requestResponse2) {
            InstabugSDKLogger.m8358e(c0542c, requestResponse2.getMessage(), requestResponse2);
            action1.a(Long.valueOf(C0554a.m7948e()));
        }
    }

    static /* synthetic */ void m7915a(com.instabug.chat.p007d.C0542c r9, final android.content.Context r10, final rx.functions.Action1 r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = com.instabug.library.network.NetworkManager.isOnline(r10);
        if (r0 == 0) goto L_0x007f;
    L_0x0006:
        r0 = com.instabug.library.core.InstabugCore.isFeaturesFetchedBefore();
        if (r0 == 0) goto L_0x007f;
    L_0x000c:
        r0 = 1;
        r9.f9257g = r0;	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        r0 = com.instabug.chat.cache.ReadQueueCacheManager.getInstance();	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        r0 = r0.getAll();	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        r1 = com.instabug.chat.network.p008a.C0553a.m7928a();	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        r2 = com.instabug.chat.cache.ChatsCacheManager.getLastMessageMessagedAt();	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        r4 = com.instabug.chat.cache.ChatsCacheManager.getTotalMessagesCount();	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        r5 = com.instabug.chat.cache.ReadQueueCacheManager.getInstance();	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        r5 = r5.getReadMessagesArray();	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        r6 = new com.instabug.chat.d.c$3;	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        r6.<init>(r9, r10, r11, r0);	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        r0 = "Syncing messages with server";	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        com.instabug.library.util.InstabugSDKLogger.m8360v(r1, r0);	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        r0 = r1.f9293a;	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        r7 = com.instabug.library.network.Request.Endpoint.SyncChats;	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        r8 = com.instabug.library.network.Request.RequestMethod.Post;	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        r10 = r0.buildRequest(r10, r7, r8);	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        r7 = 0;	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        r0 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1));	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        if (r0 == 0) goto L_0x004e;	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
    L_0x0045:
        r0 = "last_message_messaged_at";	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        r2 = com.instabug.library.util.InstabugDateFormatter.formatUTCDate(r2);	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        r10.addParameter(r0, r2);	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
    L_0x004e:
        r0 = "messages_count";	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        r2 = java.lang.Integer.valueOf(r4);	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        r10.addParameter(r0, r2);	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        if (r5 == 0) goto L_0x0064;	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
    L_0x0059:
        r0 = r5.length();	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        if (r0 == 0) goto L_0x0064;	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
    L_0x005f:
        r0 = "read_messages";	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        r10.addParameter(r0, r5);	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
    L_0x0064:
        r0 = r1.f9293a;	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        r10 = r0.doRequest(r10);	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        r0 = rx.schedulers.Schedulers.d();	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        r10 = r10.b(r0);	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        r0 = new com.instabug.chat.network.a.a$4;	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        r0.<init>(r1, r6);	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        rx.Observable.a(r0, r10);	 Catch:{ IOException -> 0x007b, IOException -> 0x007b }
        return;
    L_0x007b:
        r9.m7919a(r11);
        return;
    L_0x007f:
        r10 = "device is offline, can't sync";
        com.instabug.library.util.InstabugSDKLogger.m8361w(r9, r10);
        r9 = com.instabug.chat.settings.C0554a.m7948e();
        r9 = java.lang.Long.valueOf(r9);
        r11.a(r9);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.chat.d.c.a(com.instabug.chat.d.c, android.content.Context, rx.functions.Action1):void");
    }
}
