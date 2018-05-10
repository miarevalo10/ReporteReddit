package io.branch.referral;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.stetho.server.http.HttpStatus;
import io.branch.referral.BranchViewHandler.IBranchViewEvents;
import io.branch.referral.DeferredAppLinkDataHandler.AppLinkFetchEvents;
import io.branch.referral.Defines.Jsonkey;
import io.branch.referral.network.BranchRemoteInterface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import net.hockeyapp.android.UpdateFragment;
import org.json.JSONObject;

public class Branch implements IBranchViewEvents, IInstallReferrerEvents, GAdsParamsFetchEvents {
    private static CUSTOM_REFERRABLE_SETTINGS f30911A = CUSTOM_REFERRABLE_SETTINGS.USE_DEFAULT;
    private static String f30912G = "app.link";
    private static int f30913H = 2500;
    private static final String[] f30914I = new String[]{"extra_launch_uri"};
    static boolean f30915a = true;
    private static boolean f30916g = false;
    private static boolean f30917i = false;
    private static boolean f30918j = false;
    private static long f30919k = 1500;
    private static Branch f30920l = null;
    private static boolean f30921u = false;
    private static boolean f30922v = false;
    private boolean f30923B = false;
    private final ConcurrentHashMap<String, String> f30924C;
    private boolean f30925D = false;
    private List<String> f30926E;
    private List<String> f30927F;
    private CountDownLatch f30928J = null;
    private CountDownLatch f30929K = null;
    private boolean f30930L = false;
    PrefHelper f30931b;
    final Object f30932c;
    WeakReference<Activity> f30933d;
    String f30934e;
    private JSONObject f30935f;
    private boolean f30936h = false;
    private BranchRemoteInterface f30937m;
    private final SystemObserver f30938n;
    private Context f30939o;
    private Semaphore f30940p;
    private ServerRequestQueue f30941q;
    private int f30942r;
    private boolean f30943s;
    private Map<BranchLinkData, String> f30944t;
    private INTENT_STATE f30945w = INTENT_STATE.PENDING;
    private boolean f30946x = false;
    private SESSION_STATE f30947y = SESSION_STATE.UNINITIALISED;
    private ShareLinkManager f30948z;

    @TargetApi(14)
    private class BranchActivityLifeCycleObserver implements ActivityLifecycleCallbacks {
        final /* synthetic */ Branch f24479a;
        private int f24480b;

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        private BranchActivityLifeCycleObserver(Branch branch) {
            this.f24479a = branch;
            this.f24480b = null;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            this.f24479a.f30945w = this.f24479a.f30946x ? INTENT_STATE.PENDING : INTENT_STATE.READY;
            bundle = BranchViewHandler.m26121a();
            bundle = (bundle.f24539b == null || BranchView.m26112a(bundle.f24539b, activity.getApplicationContext()) == null) ? null : true;
            if (bundle != null) {
                bundle = BranchViewHandler.m26121a();
                if (bundle.m26133a(bundle.f24539b, activity, null) != null) {
                    bundle.f24539b = null;
                }
            }
        }

        public void onActivityStarted(android.app.Activity r3) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.f24479a;
            r1 = r2.f24479a;
            r1 = r1.f30946x;
            if (r1 == 0) goto L_0x000d;
        L_0x000a:
            r1 = io.branch.referral.Branch.INTENT_STATE.PENDING;
            goto L_0x000f;
        L_0x000d:
            r1 = io.branch.referral.Branch.INTENT_STATE.READY;
        L_0x000f:
            r0.f30945w = r1;
            r0 = r2.f24479a;
            r0 = r0.f30947y;
            r1 = io.branch.referral.Branch.SESSION_STATE.INITIALISED;
            if (r0 != r1) goto L_0x0027;
        L_0x001c:
            r0 = io.branch.indexing.ContentDiscoverer.m26068a();	 Catch:{ Exception -> 0x0027 }
            r1 = r2.f24479a;	 Catch:{ Exception -> 0x0027 }
            r1 = r1.f30934e;	 Catch:{ Exception -> 0x0027 }
            r0.m26087a(r3, r1);	 Catch:{ Exception -> 0x0027 }
        L_0x0027:
            r0 = r2.f24480b;
            if (r0 > 0) goto L_0x0062;
        L_0x002b:
            r0 = r2.f24479a;
            r0 = r0.f30947y;
            r1 = io.branch.referral.Branch.SESSION_STATE.INITIALISED;
            if (r0 != r1) goto L_0x003c;
        L_0x0035:
            r0 = r2.f24479a;
            r1 = io.branch.referral.Branch.SESSION_STATE.UNINITIALISED;
            r0.f30947y = r1;
        L_0x003c:
            r0 = r2.f24479a;
            r0 = r0.f30939o;
            r0 = io.branch.referral.BranchUtil.m26108a(r0);
            if (r0 == 0) goto L_0x0050;
        L_0x0048:
            r0 = r2.f24479a;
            r0.f30931b;
            io.branch.referral.PrefHelper.m26178i();
        L_0x0050:
            r0 = r2.f24479a;
            r0.f30931b;
            r0 = io.branch.referral.Branch.m31894f();
            io.branch.referral.PrefHelper.m26168c(r0);
            r0 = r2.f24479a;
            io.branch.referral.Branch.m31880a(r0, r3);
            goto L_0x0078;
        L_0x0062:
            r0 = r3.getIntent();
            r0 = io.branch.referral.Branch.m31888b(r0);
            if (r0 == 0) goto L_0x0078;
        L_0x006c:
            r0 = r2.f24479a;
            r1 = io.branch.referral.Branch.SESSION_STATE.UNINITIALISED;
            r0.f30947y = r1;
            r0 = r2.f24479a;
            io.branch.referral.Branch.m31880a(r0, r3);
        L_0x0078:
            r3 = r2.f24480b;
            r3 = r3 + 1;
            r2.f24480b = r3;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.Branch.BranchActivityLifeCycleObserver.onActivityStarted(android.app.Activity):void");
        }

        public void onActivityResumed(Activity activity) {
            if (Branch.m31888b(activity.getIntent())) {
                this.f24479a.f30947y = SESSION_STATE.UNINITIALISED;
                Branch.m31880a(this.f24479a, activity);
            }
            this.f24479a.f30933d = new WeakReference(activity);
            if (this.f24479a.f30946x) {
                this.f24479a.f30945w = INTENT_STATE.READY;
                boolean z = (activity.getIntent() == null || this.f24479a.f30947y == SESSION_STATE.INITIALISED) ? false : true;
                Branch.m31881a(this.f24479a, activity, z);
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.f24479a.f30948z != null) {
                activity = this.f24479a.f30948z;
                if (activity.f24668a != null && activity.f24668a.isShowing()) {
                    activity.f24668a.cancel();
                }
            }
        }

        public void onActivityStopped(android.app.Activity r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r0 = io.branch.indexing.ContentDiscoverer.m26068a();
            r1 = r0.f24444b;
            if (r1 == 0) goto L_0x0038;
        L_0x0008:
            r1 = r0.f24444b;
            r1 = r1.get();
            if (r1 == 0) goto L_0x0038;
        L_0x0010:
            r1 = r0.f24444b;
            r1 = r1.get();
            r1 = (android.app.Activity) r1;
            r1 = r1.getClass();
            r1 = r1.getName();
            r5 = r5.getClass();
            r5 = r5.getName();
            r5 = r1.equals(r5);
            if (r5 == 0) goto L_0x0038;
        L_0x002e:
            r5 = r0.f24443a;
            r1 = r0.f24448f;
            r5.removeCallbacks(r1);
            r5 = 0;
            r0.f24444b = r5;
        L_0x0038:
            r5 = r0.f24445c;	 Catch:{ JSONException -> 0x0047 }
            if (r5 == 0) goto L_0x0047;	 Catch:{ JSONException -> 0x0047 }
        L_0x003c:
            r5 = r0.f24445c;	 Catch:{ JSONException -> 0x0047 }
            r1 = "tc";	 Catch:{ JSONException -> 0x0047 }
            r2 = java.lang.System.currentTimeMillis();	 Catch:{ JSONException -> 0x0047 }
            r5.put(r1, r2);	 Catch:{ JSONException -> 0x0047 }
        L_0x0047:
            r5 = r0.f24446d;
            r5 = r5.values();
            r5 = r5.iterator();
        L_0x0051:
            r1 = r5.hasNext();
            if (r1 == 0) goto L_0x006b;
        L_0x0057:
            r1 = r5.next();
            r1 = (java.lang.ref.WeakReference) r1;
            r1 = r1.get();
            r1 = (android.view.ViewTreeObserver) r1;
            if (r1 == 0) goto L_0x0051;
        L_0x0065:
            r2 = r0.f24449g;
            r1.removeOnScrollChangedListener(r2);
            goto L_0x0051;
        L_0x006b:
            r5 = r0.f24446d;
            r5.clear();
            r5 = r4.f24480b;
            r5 = r5 + -1;
            r4.f24480b = r5;
            r5 = r4.f24480b;
            if (r5 > 0) goto L_0x007f;
        L_0x007a:
            r5 = r4.f24479a;
            io.branch.referral.Branch.m31898h(r5);
        L_0x007f:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.Branch.BranchActivityLifeCycleObserver.onActivityStopped(android.app.Activity):void");
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.f24479a.f30933d != null && this.f24479a.f30933d.get() == activity) {
                this.f24479a.f30933d.clear();
            }
            BranchViewHandler a = BranchViewHandler.m26121a();
            if (a.f24540c != null && a.f24540c.equalsIgnoreCase(activity.getClass().getName()) != null) {
                a.f24538a = null;
            }
        }
    }

    public interface BranchLinkCreateListener {
    }

    public interface BranchListResponseListener {
    }

    public interface BranchReferralInitListener {
        void mo4560a(JSONObject jSONObject, BranchError branchError);
    }

    public interface BranchReferralStateChangedListener {
    }

    private enum CUSTOM_REFERRABLE_SETTINGS {
        USE_DEFAULT,
        REFERRABLE,
        NON_REFERRABLE
    }

    public interface IBranchViewControl {
        boolean m26098a();
    }

    private enum INTENT_STATE {
        PENDING,
        READY
    }

    public interface LogoutStatusListener {
    }

    private enum SESSION_STATE {
        INITIALISED,
        INITIALISING,
        UNINITIALISED
    }

    class C25341 implements AppLinkFetchEvents {
        final /* synthetic */ Branch f30907a;

        C25341(Branch branch) {
            this.f30907a = branch;
        }

        public final void mo5540a(String str) {
            this.f30907a.f30931b;
            PrefHelper.m26155a("bnc_triggered_by_fb_app_link", Boolean.valueOf(true));
            if (str != null) {
                str = Uri.parse(str).getQueryParameter(Jsonkey.LinkClickID.bc);
                if (!TextUtils.isEmpty(str)) {
                    this.f30907a.f30931b;
                    PrefHelper.m26156a("bnc_link_click_identifier", str);
                }
            }
            this.f30907a.f30941q.m26189a(PROCESS_WAIT_LOCK.FB_APP_LINK_WAIT_LOCK);
            this.f30907a.m31897h();
        }
    }

    class C25352 implements StrongMatchCheckEvents {
        final /* synthetic */ Branch f30908a;

        C25352(Branch branch) {
            this.f30908a = branch;
        }

        public final void mo5541a() {
            this.f30908a.f30941q.m26189a(PROCESS_WAIT_LOCK.STRONG_MATCH_PENDING_WAIT_LOCK);
            this.f30908a.m31897h();
        }
    }

    private class BranchPostTask extends BranchAsyncTask<Void, Void, ServerResponse> {
        ServerRequest f30909a;
        final /* synthetic */ Branch f30910b;

        protected /* synthetic */ void onPostExecute(Object obj) {
            ServerResponse serverResponse = (ServerResponse) obj;
            super.onPostExecute(serverResponse);
            if (serverResponse != null) {
                try {
                    int i = serverResponse.f24664a;
                    boolean z = true;
                    this.f30910b.f30943s = true;
                    boolean z2 = false;
                    if (i != HttpStatus.HTTP_OK) {
                        if (this.f30909a instanceof ServerRequestInitSession) {
                            this.f30910b.f30947y = SESSION_STATE.UNINITIALISED;
                        }
                        if (i == 409) {
                            this.f30910b.f30941q.m26191a(this.f30909a);
                            if ((this.f30909a instanceof ServerRequestCreateUrl) == null) {
                                Log.i("BranchSDK", "Branch API Error: Conflicting resource error code from API");
                                this.f30910b.m31876a(0, i);
                            } else if (((ServerRequestCreateUrl) this.f30909a).f30958b != null) {
                                obj = new BranchError("Trouble creating a URL.", -105);
                            }
                        } else {
                            this.f30910b.f30943s = false;
                            ArrayList arrayList = new ArrayList();
                            int i2;
                            while (i2 < this.f30910b.f30941q.m26192b()) {
                                arrayList.add(this.f30910b.f30941q.m26186a(i2));
                                i2++;
                            }
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ServerRequest serverRequest = (ServerRequest) it.next();
                                if (serverRequest == null || !serverRequest.shouldRetryOnFail()) {
                                    this.f30910b.f30941q.m26191a(serverRequest);
                                }
                            }
                            this.f30910b.f30942r = 0;
                            Iterator it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                ServerRequest serverRequest2 = (ServerRequest) it2.next();
                                if (serverRequest2 != null) {
                                    serverRequest2.handleFailure(i, serverResponse.m26199b());
                                    if (serverRequest2.shouldRetryOnFail()) {
                                        serverRequest2.clearCallbacks();
                                    }
                                }
                            }
                        }
                    } else {
                        this.f30910b.f30943s = true;
                        if (this.f30909a instanceof ServerRequestCreateUrl) {
                            if (serverResponse.m26198a() != null) {
                                this.f30910b.f30944t.put(((ServerRequestCreateUrl) this.f30909a).f30957a, serverResponse.m26198a().getString(UpdateFragment.FRAGMENT_URL));
                            }
                        } else if (this.f30909a instanceof ServerRequestLogout) {
                            this.f30910b.f30944t.clear();
                            this.f30910b.f30941q.m26195e();
                        }
                        this.f30910b.f30941q.m26193c();
                        if (!(this.f30909a instanceof ServerRequestInitSession)) {
                            if (!(this.f30909a instanceof ServerRequestIdentifyUserRequest)) {
                                this.f30909a.onRequestSucceeded(serverResponse, Branch.f30920l);
                            }
                        }
                        JSONObject a = serverResponse.m26198a();
                        if (a != null) {
                            if (a.has(Jsonkey.SessionID.bc)) {
                                this.f30910b.f30931b;
                                PrefHelper.m26156a("bnc_session_id", a.getString(Jsonkey.SessionID.bc));
                                z2 = true;
                            }
                            if (a.has(Jsonkey.IdentityID.bc)) {
                                String string = a.getString(Jsonkey.IdentityID.bc);
                                this.f30910b.f30931b;
                                if (!PrefHelper.m26170d("bnc_identity_id").equals(string)) {
                                    this.f30910b.f30944t.clear();
                                    this.f30910b.f30931b;
                                    PrefHelper.m26156a("bnc_identity_id", a.getString(Jsonkey.IdentityID.bc));
                                    z2 = true;
                                }
                            }
                            if (a.has(Jsonkey.DeviceFingerprintID.bc)) {
                                this.f30910b.f30931b;
                                PrefHelper.m26156a("bnc_device_fingerprint_id", a.getString(Jsonkey.DeviceFingerprintID.bc));
                            } else {
                                z = z2;
                            }
                            if (z) {
                                Branch.m31908n(this.f30910b);
                            }
                            if (this.f30909a instanceof ServerRequestInitSession) {
                                this.f30910b.f30947y = SESSION_STATE.INITIALISED;
                                this.f30909a.onRequestSucceeded(serverResponse, Branch.f30920l);
                                this.f30910b.f30923B = ((ServerRequestInitSession) this.f30909a).mo6587a();
                                if (((ServerRequestInitSession) this.f30909a).m31928a(serverResponse) == null) {
                                    this.f30910b.m31906l();
                                }
                                if (this.f30910b.f30929K != null) {
                                    this.f30910b.f30929K.countDown();
                                }
                                if (this.f30910b.f30928J != null) {
                                    this.f30910b.f30928J.countDown();
                                }
                            } else {
                                this.f30909a.onRequestSucceeded(serverResponse, Branch.f30920l);
                            }
                        }
                    }
                    this.f30910b.f30942r = 0;
                    if (!(this.f30910b.f30943s == null || this.f30910b.f30947y == SESSION_STATE.UNINITIALISED)) {
                        this.f30910b.m31897h();
                    }
                } catch (Object obj2) {
                    obj2.printStackTrace();
                }
            }
        }

        public BranchPostTask(Branch branch, ServerRequest serverRequest) {
            this.f30910b = branch;
            this.f30909a = serverRequest;
        }

        protected void onPreExecute() {
            super.onPreExecute();
            this.f30909a.onPreExecute();
        }

        protected /* synthetic */ java.lang.Object doInBackground(java.lang.Object[] r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r5 = r4.f30909a;
            r5 = r5 instanceof io.branch.referral.ServerRequestInitSession;
            if (r5 == 0) goto L_0x007a;
        L_0x0006:
            r5 = r4.f30909a;
            r5 = (io.branch.referral.ServerRequestInitSession) r5;
            r0 = "bnc_link_click_identifier";
            r0 = io.branch.referral.PrefHelper.m26170d(r0);
            r1 = "bnc_no_value";
            r1 = r0.equals(r1);
            if (r1 != 0) goto L_0x0023;
        L_0x0018:
            r1 = r5.getPost();	 Catch:{ JSONException -> 0x0023 }
            r2 = io.branch.referral.Defines.Jsonkey.LinkIdentifier;	 Catch:{ JSONException -> 0x0023 }
            r2 = r2.bc;	 Catch:{ JSONException -> 0x0023 }
            r1.put(r2, r0);	 Catch:{ JSONException -> 0x0023 }
        L_0x0023:
            r0 = "bnc_google_search_install_identifier";
            r0 = io.branch.referral.PrefHelper.m26170d(r0);
            r1 = "bnc_no_value";
            r1 = r0.equals(r1);
            if (r1 != 0) goto L_0x003c;
        L_0x0031:
            r1 = r5.getPost();	 Catch:{ JSONException -> 0x003c }
            r2 = io.branch.referral.Defines.Jsonkey.GoogleSearchInstallReferrer;	 Catch:{ JSONException -> 0x003c }
            r2 = r2.bc;	 Catch:{ JSONException -> 0x003c }
            r1.put(r2, r0);	 Catch:{ JSONException -> 0x003c }
        L_0x003c:
            r0 = "bnc_google_play_install_referrer_extras";
            r0 = io.branch.referral.PrefHelper.m26170d(r0);
            r1 = "bnc_no_value";
            r1 = r0.equals(r1);
            if (r1 != 0) goto L_0x0055;
        L_0x004a:
            r1 = r5.getPost();	 Catch:{ JSONException -> 0x0055 }
            r2 = io.branch.referral.Defines.Jsonkey.GooglePlayInstallReferrer;	 Catch:{ JSONException -> 0x0055 }
            r2 = r2.bc;	 Catch:{ JSONException -> 0x0055 }
            r1.put(r2, r0);	 Catch:{ JSONException -> 0x0055 }
        L_0x0055:
            r0 = "bnc_is_full_app_conversion";
            r0 = io.branch.referral.PrefHelper.m26172e(r0);
            if (r0 == 0) goto L_0x007a;
        L_0x005d:
            r0 = r5.getPost();	 Catch:{ JSONException -> 0x007a }
            r1 = io.branch.referral.Defines.Jsonkey.AndroidAppLinkURL;	 Catch:{ JSONException -> 0x007a }
            r1 = r1.bc;	 Catch:{ JSONException -> 0x007a }
            r2 = "bnc_app_link";	 Catch:{ JSONException -> 0x007a }
            r2 = io.branch.referral.PrefHelper.m26170d(r2);	 Catch:{ JSONException -> 0x007a }
            r0.put(r1, r2);	 Catch:{ JSONException -> 0x007a }
            r5 = r5.getPost();	 Catch:{ JSONException -> 0x007a }
            r0 = io.branch.referral.Defines.Jsonkey.IsFullAppConv;	 Catch:{ JSONException -> 0x007a }
            r0 = r0.bc;	 Catch:{ JSONException -> 0x007a }
            r1 = 1;	 Catch:{ JSONException -> 0x007a }
            r5.put(r0, r1);	 Catch:{ JSONException -> 0x007a }
        L_0x007a:
            r5 = r4.f30910b;
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r1 = r4.f30909a;
            r1 = r1.getRequestPath();
            r0.append(r1);
            r1 = "-";
            r0.append(r1);
            r1 = io.branch.referral.Defines.Jsonkey.Queue_Wait_Time;
            r1 = r1.bc;
            r0.append(r1);
            r0 = r0.toString();
            r1 = r4.f30909a;
            r1 = r1.getQueueWaitTime();
            r1 = java.lang.String.valueOf(r1);
            r5.m31914a(r0, r1);
            r5 = r4.f30909a;
            r5 = r5.isGAdsParamsRequired();
            if (r5 == 0) goto L_0x00c6;
        L_0x00af:
            r5 = r4.f30910b;
            r5 = r5.f30939o;
            r5 = io.branch.referral.BranchUtil.m26108a(r5);
            if (r5 != 0) goto L_0x00c6;
        L_0x00bb:
            r5 = r4.f30909a;
            r0 = r4.f30910b;
            r0 = r0.f30938n;
            r5.updateGAdsParams(r0);
        L_0x00c6:
            r5 = r4.f30909a;
            r5 = r5.isGetRequest();
            if (r5 == 0) goto L_0x00f4;
        L_0x00ce:
            r5 = r4.f30910b;
            r5 = r5.f30937m;
            r0 = r4.f30909a;
            r0 = r0.getRequestUrl();
            r1 = r4.f30909a;
            r1 = r1.getGetParams();
            r2 = r4.f30909a;
            r2 = r2.getRequestPath();
            r3 = r4.f30910b;
            r3.f30931b;
            r3 = io.branch.referral.PrefHelper.m26169d();
            r5 = r5.m26226a(r0, r1, r2, r3);
            return r5;
        L_0x00f4:
            r5 = r4.f30910b;
            r5 = r5.f30937m;
            r0 = r4.f30909a;
            r1 = r4.f30910b;
            r1 = r1.f30924C;
            r0 = r0.getPostWithInstrumentationValues(r1);
            r1 = r4.f30909a;
            r1 = r1.getRequestUrl();
            r2 = r4.f30909a;
            r2 = r2.getRequestPath();
            r3 = r4.f30910b;
            r3.f30931b;
            r3 = io.branch.referral.PrefHelper.m26169d();
            r5 = r5.m26227a(r0, r1, r2, r3);
            return r5;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.Branch.BranchPostTask.doInBackground(java.lang.Object[]):java.lang.Object");
        }
    }

    private Branch(Context context) {
        this.f30931b = PrefHelper.m26151a(context);
        this.f30937m = BranchRemoteInterface.m26223a(context);
        this.f30938n = new SystemObserver(context);
        this.f30941q = ServerRequestQueue.m26182a(context);
        this.f30940p = new Semaphore(1);
        this.f30932c = new Object();
        this.f30942r = 0;
        this.f30943s = true;
        this.f30944t = new HashMap();
        this.f30924C = new ConcurrentHashMap();
        context = this.f30938n;
        if (TextUtils.isEmpty(context.f24671a)) {
            new GAdsPrefetchTask(context, this).m26099a(new Void[0]);
            context = 1;
        } else {
            context = null;
        }
        this.f30925D = context;
        InstallListener.m26148a((IInstallReferrerEvents) this);
        if (VERSION.SDK_INT >= 15) {
            this.f30946x = true;
            this.f30945w = INTENT_STATE.PENDING;
        } else {
            this.f30946x = false;
            this.f30945w = INTENT_STATE.READY;
        }
        this.f30926E = new ArrayList();
        this.f30927F = new ArrayList();
    }

    @TargetApi(14)
    public static Branch m31871a() {
        if (f30920l == null) {
            Log.e("BranchSDK", "Branch instance is not created yet. Make sure you have initialised Branch. [Consider Calling getInstance(Context ctx) if you still have issue.]");
        } else if (f30921u && !f30922v) {
            Log.e("BranchSDK", "Branch instance is not properly initialised. Make sure your Application class is extending BranchApp class. If you are not extending BranchApp class make sure you are initialising Branch in your Applications onCreate()");
        }
        return f30920l;
    }

    private static io.branch.referral.Branch m31873a(android.content.Context r4, boolean r5) {
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
        r0 = f30920l;
        if (r0 != 0) goto L_0x009b;
    L_0x0004:
        r0 = new io.branch.referral.Branch;
        r1 = r4.getApplicationContext();
        r0.<init>(r1);
        f30920l = r0;
        r0 = r0.f30931b;
        r5 = r0.m26180a(r5);
        if (r5 == 0) goto L_0x001f;
    L_0x0017:
        r0 = "bnc_no_value";
        r0 = r5.equalsIgnoreCase(r0);
        if (r0 == 0) goto L_0x004d;
    L_0x001f:
        r5 = 0;
        r0 = r4.getResources();	 Catch:{ Exception -> 0x0035 }
        r1 = "io.branch.apiKey";	 Catch:{ Exception -> 0x0035 }
        r2 = "string";	 Catch:{ Exception -> 0x0035 }
        r3 = r4.getPackageName();	 Catch:{ Exception -> 0x0035 }
        r1 = r0.getIdentifier(r1, r2, r3);	 Catch:{ Exception -> 0x0035 }
        r0 = r0.getString(r1);	 Catch:{ Exception -> 0x0035 }
        r5 = r0;
    L_0x0035:
        r0 = android.text.TextUtils.isEmpty(r5);
        if (r0 == 0) goto L_0x004d;
    L_0x003b:
        r5 = "BranchSDK";
        r0 = "Branch Warning: Please enter your branch_key in your project's Manifest file!";
        android.util.Log.i(r5, r0);
        r5 = f30920l;
        r5 = r5.f30931b;
        r0 = "bnc_no_value";
        r5 = r5.m26181a(r0);
        goto L_0x0055;
    L_0x004d:
        r0 = f30920l;
        r0 = r0.f30931b;
        r5 = r0.m26181a(r5);
    L_0x0055:
        if (r5 == 0) goto L_0x0065;
    L_0x0057:
        r5 = f30920l;
        r5 = r5.f30944t;
        r5.clear();
        r5 = f30920l;
        r5 = r5.f30941q;
        r5.m26195e();
    L_0x0065:
        r5 = f30920l;
        r0 = r4.getApplicationContext();
        r5.f30939o = r0;
        r5 = r4 instanceof android.app.Application;
        if (r5 == 0) goto L_0x009b;
    L_0x0071:
        r5 = 1;
        f30921u = r5;
        r0 = f30920l;
        r4 = (android.app.Application) r4;
        r1 = 0;
        r2 = new io.branch.referral.Branch$BranchActivityLifeCycleObserver;	 Catch:{ NoSuchMethodError -> 0x0087, NoSuchMethodError -> 0x0087 }
        r2.<init>();	 Catch:{ NoSuchMethodError -> 0x0087, NoSuchMethodError -> 0x0087 }
        r4.unregisterActivityLifecycleCallbacks(r2);	 Catch:{ NoSuchMethodError -> 0x0087, NoSuchMethodError -> 0x0087 }
        r4.registerActivityLifecycleCallbacks(r2);	 Catch:{ NoSuchMethodError -> 0x0087, NoSuchMethodError -> 0x0087 }
        f30922v = r5;	 Catch:{ NoSuchMethodError -> 0x0087, NoSuchMethodError -> 0x0087 }
        goto L_0x009b;
    L_0x0087:
        f30922v = r1;
        f30921u = r1;
        r4 = "BranchSDK";
        r5 = new io.branch.referral.BranchError;
        r0 = "";
        r1 = -108; // 0xffffffffffffff94 float:NaN double:NaN;
        r5.<init>(r0, r1);
        r5 = r5.f24492a;
        android.util.Log.w(r4, r5);
    L_0x009b:
        r4 = f30920l;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.Branch.a(android.content.Context, boolean):io.branch.referral.Branch");
    }

    @TargetApi(14)
    public static Branch m31872a(Context context) {
        f30921u = true;
        f30911A = CUSTOM_REFERRABLE_SETTINGS.USE_DEFAULT;
        m31873a(context, true ^ BranchUtil.m26108a(context));
        return f30920l;
    }

    public static boolean m31887b() {
        return f30916g;
    }

    public final boolean m31915a(BranchReferralInitListener branchReferralInitListener, Activity activity) {
        if (f30911A == CUSTOM_REFERRABLE_SETTINGS.USE_DEFAULT) {
            m31877a(branchReferralInitListener, activity, true);
        } else {
            m31877a(branchReferralInitListener, activity, f30911A == CUSTOM_REFERRABLE_SETTINGS.REFERRABLE);
        }
        return true;
    }

    public final boolean m31916a(BranchReferralInitListener branchReferralInitListener, Uri uri, Activity activity) {
        m31883a(uri, activity);
        return m31915a(branchReferralInitListener, activity);
    }

    private void m31877a(BranchReferralInitListener branchReferralInitListener, Activity activity, boolean z) {
        if (activity != null) {
            this.f30933d = new WeakReference(activity);
        }
        if (m31902j() == null || m31900i() == null || this.f30947y != SESSION_STATE.INITIALISED) {
            if (z) {
                PrefHelper.m26167c("bnc_is_referrable", 1);
            } else {
                PrefHelper.m26167c("bnc_is_referrable", false);
            }
            if (this.f30947y != SESSION_STATE.INITIALISING) {
                this.f30947y = SESSION_STATE.INITIALISING;
                if (PrefHelper.m26169d() != null) {
                    if (PrefHelper.m26169d().equalsIgnoreCase("bnc_no_value") == null) {
                        if (!(PrefHelper.m26169d() == null || PrefHelper.m26169d().startsWith("key_test_") == null)) {
                            Log.i("BranchSDK", "Branch Warning: You are using your test app's Branch Key. Remember to change it to live Branch Key during deployment.");
                        }
                        if (PrefHelper.m26170d("bnc_external_intent_uri").equals("bnc_no_value") != null) {
                            if (this.f30936h != null) {
                                if (DeferredAppLinkDataHandler.m26137a(this.f30939o, new C25341(this)).booleanValue() != null) {
                                    m31878a(branchReferralInitListener, PROCESS_WAIT_LOCK.FB_APP_LINK_WAIT_LOCK);
                                    return;
                                }
                                m31878a(branchReferralInitListener, null);
                            }
                        }
                        m31878a(branchReferralInitListener, null);
                        return;
                    }
                }
                this.f30947y = SESSION_STATE.UNINITIALISED;
                if (branchReferralInitListener != null) {
                    branchReferralInitListener.mo4560a(null, new BranchError("Trouble initializing Branch.", -114));
                }
                Log.i("BranchSDK", "Branch Warning: Please enter your branch_key in your project's res/values/strings.xml!");
            } else if (branchReferralInitListener != null) {
                this.f30941q.m26188a(branchReferralInitListener);
            }
        } else if (branchReferralInitListener != null) {
            if (f30921u == null) {
                branchReferralInitListener.mo4560a(new JSONObject(), null);
            } else if (this.f30923B == null) {
                branchReferralInitListener.mo4560a(m31922e(), null);
                this.f30923B = true;
            } else {
                branchReferralInitListener.mo4560a(new JSONObject(), null);
            }
        }
    }

    private boolean m31883a(android.net.Uri r11, android.app.Activity r12) {
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
        r10 = this;
        r0 = r10.f30945w;
        r1 = io.branch.referral.Branch.INTENT_STATE.READY;
        r2 = 0;
        if (r0 != r1) goto L_0x01fd;
    L_0x0007:
        r0 = 1;
        if (r11 == 0) goto L_0x00aa;
    L_0x000a:
        r1 = r10.f30926E;	 Catch:{ Exception -> 0x00aa }
        r1 = r1.size();	 Catch:{ Exception -> 0x00aa }
        if (r1 <= 0) goto L_0x001d;	 Catch:{ Exception -> 0x00aa }
    L_0x0012:
        r1 = r10.f30926E;	 Catch:{ Exception -> 0x00aa }
        r3 = r11.getScheme();	 Catch:{ Exception -> 0x00aa }
        r1 = r1.contains(r3);	 Catch:{ Exception -> 0x00aa }
        goto L_0x001e;	 Catch:{ Exception -> 0x00aa }
    L_0x001d:
        r1 = r0;	 Catch:{ Exception -> 0x00aa }
    L_0x001e:
        r3 = r10.f30927F;	 Catch:{ Exception -> 0x00aa }
        r3 = r3.size();	 Catch:{ Exception -> 0x00aa }
        if (r3 <= 0) goto L_0x0046;	 Catch:{ Exception -> 0x00aa }
    L_0x0026:
        r3 = r10.f30927F;	 Catch:{ Exception -> 0x00aa }
        r3 = r3.iterator();	 Catch:{ Exception -> 0x00aa }
    L_0x002c:
        r4 = r3.hasNext();	 Catch:{ Exception -> 0x00aa }
        if (r4 == 0) goto L_0x0046;	 Catch:{ Exception -> 0x00aa }
    L_0x0032:
        r4 = r3.next();	 Catch:{ Exception -> 0x00aa }
        r4 = (java.lang.String) r4;	 Catch:{ Exception -> 0x00aa }
        r5 = r11.getHost();	 Catch:{ Exception -> 0x00aa }
        if (r5 == 0) goto L_0x002c;	 Catch:{ Exception -> 0x00aa }
    L_0x003e:
        r4 = r5.equals(r4);	 Catch:{ Exception -> 0x00aa }
        if (r4 == 0) goto L_0x002c;	 Catch:{ Exception -> 0x00aa }
    L_0x0044:
        r3 = r0;	 Catch:{ Exception -> 0x00aa }
        goto L_0x0047;	 Catch:{ Exception -> 0x00aa }
    L_0x0046:
        r3 = r2;	 Catch:{ Exception -> 0x00aa }
    L_0x0047:
        if (r1 == 0) goto L_0x00aa;	 Catch:{ Exception -> 0x00aa }
    L_0x0049:
        if (r3 != 0) goto L_0x00aa;	 Catch:{ Exception -> 0x00aa }
    L_0x004b:
        r1 = r11.toString();	 Catch:{ Exception -> 0x00aa }
        r10.f30934e = r1;	 Catch:{ Exception -> 0x00aa }
        r1 = r11.toString();	 Catch:{ Exception -> 0x00aa }
        r3 = "bnc_external_intent_uri";	 Catch:{ Exception -> 0x00aa }
        io.branch.referral.PrefHelper.m26156a(r3, r1);	 Catch:{ Exception -> 0x00aa }
        if (r12 == 0) goto L_0x00aa;	 Catch:{ Exception -> 0x00aa }
    L_0x005c:
        r1 = r12.getIntent();	 Catch:{ Exception -> 0x00aa }
        if (r1 == 0) goto L_0x00aa;	 Catch:{ Exception -> 0x00aa }
    L_0x0062:
        r1 = r12.getIntent();	 Catch:{ Exception -> 0x00aa }
        r1 = r1.getExtras();	 Catch:{ Exception -> 0x00aa }
        if (r1 == 0) goto L_0x00aa;	 Catch:{ Exception -> 0x00aa }
    L_0x006c:
        r1 = r12.getIntent();	 Catch:{ Exception -> 0x00aa }
        r1 = r1.getExtras();	 Catch:{ Exception -> 0x00aa }
        r3 = r1.keySet();	 Catch:{ Exception -> 0x00aa }
        r4 = r3.size();	 Catch:{ Exception -> 0x00aa }
        if (r4 <= 0) goto L_0x00aa;	 Catch:{ Exception -> 0x00aa }
    L_0x007e:
        r4 = new org.json.JSONObject;	 Catch:{ Exception -> 0x00aa }
        r4.<init>();	 Catch:{ Exception -> 0x00aa }
        r5 = f30914I;	 Catch:{ Exception -> 0x00aa }
        r6 = r5.length;	 Catch:{ Exception -> 0x00aa }
        r7 = r2;	 Catch:{ Exception -> 0x00aa }
    L_0x0087:
        if (r7 >= r6) goto L_0x009b;	 Catch:{ Exception -> 0x00aa }
    L_0x0089:
        r8 = r5[r7];	 Catch:{ Exception -> 0x00aa }
        r9 = r3.contains(r8);	 Catch:{ Exception -> 0x00aa }
        if (r9 == 0) goto L_0x0098;	 Catch:{ Exception -> 0x00aa }
    L_0x0091:
        r9 = r1.get(r8);	 Catch:{ Exception -> 0x00aa }
        r4.put(r8, r9);	 Catch:{ Exception -> 0x00aa }
    L_0x0098:
        r7 = r7 + 1;	 Catch:{ Exception -> 0x00aa }
        goto L_0x0087;	 Catch:{ Exception -> 0x00aa }
    L_0x009b:
        r1 = r4.length();	 Catch:{ Exception -> 0x00aa }
        if (r1 <= 0) goto L_0x00aa;	 Catch:{ Exception -> 0x00aa }
    L_0x00a1:
        r1 = r4.toString();	 Catch:{ Exception -> 0x00aa }
        r3 = "bnc_external_intent_extra";	 Catch:{ Exception -> 0x00aa }
        io.branch.referral.PrefHelper.m26156a(r3, r1);	 Catch:{ Exception -> 0x00aa }
    L_0x00aa:
        if (r12 == 0) goto L_0x00fa;
    L_0x00ac:
        r1 = r12.getIntent();	 Catch:{ Exception -> 0x00fa }
        if (r1 == 0) goto L_0x00fa;	 Catch:{ Exception -> 0x00fa }
    L_0x00b2:
        r1 = r12.getIntent();	 Catch:{ Exception -> 0x00fa }
        r1 = r1.getExtras();	 Catch:{ Exception -> 0x00fa }
        if (r1 == 0) goto L_0x00fa;	 Catch:{ Exception -> 0x00fa }
    L_0x00bc:
        r1 = r12.getIntent();	 Catch:{ Exception -> 0x00fa }
        r1 = r1.getExtras();	 Catch:{ Exception -> 0x00fa }
        r3 = io.branch.referral.Defines.Jsonkey.BranchLinkUsed;	 Catch:{ Exception -> 0x00fa }
        r3 = r3.bc;	 Catch:{ Exception -> 0x00fa }
        r1 = r1.getBoolean(r3);	 Catch:{ Exception -> 0x00fa }
        if (r1 != 0) goto L_0x00fa;	 Catch:{ Exception -> 0x00fa }
    L_0x00ce:
        r1 = r12.getIntent();	 Catch:{ Exception -> 0x00fa }
        r1 = r1.getExtras();	 Catch:{ Exception -> 0x00fa }
        r3 = io.branch.referral.Defines.Jsonkey.AndroidPushNotificationKey;	 Catch:{ Exception -> 0x00fa }
        r3 = r3.bc;	 Catch:{ Exception -> 0x00fa }
        r1 = r1.getString(r3);	 Catch:{ Exception -> 0x00fa }
        if (r1 == 0) goto L_0x00fa;	 Catch:{ Exception -> 0x00fa }
    L_0x00e0:
        r3 = r1.length();	 Catch:{ Exception -> 0x00fa }
        if (r3 <= 0) goto L_0x00fa;	 Catch:{ Exception -> 0x00fa }
    L_0x00e6:
        r3 = "bnc_push_identifier";	 Catch:{ Exception -> 0x00fa }
        io.branch.referral.PrefHelper.m26156a(r3, r1);	 Catch:{ Exception -> 0x00fa }
        r1 = r12.getIntent();	 Catch:{ Exception -> 0x00fa }
        r3 = io.branch.referral.Defines.Jsonkey.BranchLinkUsed;	 Catch:{ Exception -> 0x00fa }
        r3 = r3.bc;	 Catch:{ Exception -> 0x00fa }
        r1.putExtra(r3, r0);	 Catch:{ Exception -> 0x00fa }
        r12.setIntent(r1);	 Catch:{ Exception -> 0x00fa }
        return r2;
    L_0x00fa:
        if (r11 == 0) goto L_0x01fd;
    L_0x00fc:
        r1 = r11.isHierarchical();
        if (r1 == 0) goto L_0x01fd;
    L_0x0102:
        if (r12 == 0) goto L_0x01fd;
    L_0x0104:
        r1 = io.branch.referral.Defines.Jsonkey.LinkClickID;	 Catch:{ Exception -> 0x01fd }
        r1 = r1.bc;	 Catch:{ Exception -> 0x01fd }
        r1 = r11.getQueryParameter(r1);	 Catch:{ Exception -> 0x01fd }
        if (r1 == 0) goto L_0x01aa;	 Catch:{ Exception -> 0x01fd }
    L_0x010e:
        r1 = io.branch.referral.Defines.Jsonkey.LinkClickID;	 Catch:{ Exception -> 0x01fd }
        r1 = r1.bc;	 Catch:{ Exception -> 0x01fd }
        r1 = r11.getQueryParameter(r1);	 Catch:{ Exception -> 0x01fd }
        r3 = "bnc_link_click_identifier";	 Catch:{ Exception -> 0x01fd }
        io.branch.referral.PrefHelper.m26156a(r3, r1);	 Catch:{ Exception -> 0x01fd }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01fd }
        r3 = "link_click_id=";	 Catch:{ Exception -> 0x01fd }
        r1.<init>(r3);	 Catch:{ Exception -> 0x01fd }
        r3 = io.branch.referral.Defines.Jsonkey.LinkClickID;	 Catch:{ Exception -> 0x01fd }
        r3 = r3.bc;	 Catch:{ Exception -> 0x01fd }
        r3 = r11.getQueryParameter(r3);	 Catch:{ Exception -> 0x01fd }
        r1.append(r3);	 Catch:{ Exception -> 0x01fd }
        r1 = r1.toString();	 Catch:{ Exception -> 0x01fd }
        r3 = 0;	 Catch:{ Exception -> 0x01fd }
        r4 = r12.getIntent();	 Catch:{ Exception -> 0x01fd }
        if (r4 == 0) goto L_0x0140;	 Catch:{ Exception -> 0x01fd }
    L_0x0138:
        r3 = r12.getIntent();	 Catch:{ Exception -> 0x01fd }
        r3 = r3.getDataString();	 Catch:{ Exception -> 0x01fd }
    L_0x0140:
        r11 = r11.getQuery();	 Catch:{ Exception -> 0x01fd }
        r11 = r11.length();	 Catch:{ Exception -> 0x01fd }
        r4 = r1.length();	 Catch:{ Exception -> 0x01fd }
        if (r11 != r4) goto L_0x015d;	 Catch:{ Exception -> 0x01fd }
    L_0x014e:
        r11 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01fd }
        r4 = "\\?";	 Catch:{ Exception -> 0x01fd }
        r11.<init>(r4);	 Catch:{ Exception -> 0x01fd }
        r11.append(r1);	 Catch:{ Exception -> 0x01fd }
        r11 = r11.toString();	 Catch:{ Exception -> 0x01fd }
        goto L_0x018e;	 Catch:{ Exception -> 0x01fd }
    L_0x015d:
        if (r3 == 0) goto L_0x017d;	 Catch:{ Exception -> 0x01fd }
    L_0x015f:
        r11 = r3.length();	 Catch:{ Exception -> 0x01fd }
        r4 = r1.length();	 Catch:{ Exception -> 0x01fd }
        r11 = r11 - r4;	 Catch:{ Exception -> 0x01fd }
        r4 = r3.indexOf(r1);	 Catch:{ Exception -> 0x01fd }
        if (r11 != r4) goto L_0x017d;	 Catch:{ Exception -> 0x01fd }
    L_0x016e:
        r11 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01fd }
        r4 = "&";	 Catch:{ Exception -> 0x01fd }
        r11.<init>(r4);	 Catch:{ Exception -> 0x01fd }
        r11.append(r1);	 Catch:{ Exception -> 0x01fd }
        r11 = r11.toString();	 Catch:{ Exception -> 0x01fd }
        goto L_0x018e;	 Catch:{ Exception -> 0x01fd }
    L_0x017d:
        r11 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01fd }
        r11.<init>();	 Catch:{ Exception -> 0x01fd }
        r11.append(r1);	 Catch:{ Exception -> 0x01fd }
        r1 = "&";	 Catch:{ Exception -> 0x01fd }
        r11.append(r1);	 Catch:{ Exception -> 0x01fd }
        r11 = r11.toString();	 Catch:{ Exception -> 0x01fd }
    L_0x018e:
        if (r3 == 0) goto L_0x01a2;	 Catch:{ Exception -> 0x01fd }
    L_0x0190:
        r1 = "";	 Catch:{ Exception -> 0x01fd }
        r11 = r3.replaceFirst(r11, r1);	 Catch:{ Exception -> 0x01fd }
        r11 = android.net.Uri.parse(r11);	 Catch:{ Exception -> 0x01fd }
        r12 = r12.getIntent();	 Catch:{ Exception -> 0x01fd }
        r12.setData(r11);	 Catch:{ Exception -> 0x01fd }
        goto L_0x01a9;	 Catch:{ Exception -> 0x01fd }
    L_0x01a2:
        r11 = "BranchSDK";	 Catch:{ Exception -> 0x01fd }
        r12 = "Branch Warning. URI for the launcher activity is null. Please make sure that intent data is not set to null before calling Branch#InitSession ";	 Catch:{ Exception -> 0x01fd }
        android.util.Log.w(r11, r12);	 Catch:{ Exception -> 0x01fd }
    L_0x01a9:
        return r0;	 Catch:{ Exception -> 0x01fd }
    L_0x01aa:
        r1 = r11.getScheme();	 Catch:{ Exception -> 0x01fd }
        r3 = r12.getIntent();	 Catch:{ Exception -> 0x01fd }
        if (r1 == 0) goto L_0x01fd;	 Catch:{ Exception -> 0x01fd }
    L_0x01b4:
        if (r3 == 0) goto L_0x01fd;	 Catch:{ Exception -> 0x01fd }
    L_0x01b6:
        r4 = r3.getFlags();	 Catch:{ Exception -> 0x01fd }
        r5 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;	 Catch:{ Exception -> 0x01fd }
        r4 = r4 & r5;	 Catch:{ Exception -> 0x01fd }
        if (r4 != 0) goto L_0x01fd;	 Catch:{ Exception -> 0x01fd }
    L_0x01bf:
        r4 = "http";	 Catch:{ Exception -> 0x01fd }
        r4 = r1.equalsIgnoreCase(r4);	 Catch:{ Exception -> 0x01fd }
        if (r4 != 0) goto L_0x01cf;	 Catch:{ Exception -> 0x01fd }
    L_0x01c7:
        r4 = "https";	 Catch:{ Exception -> 0x01fd }
        r1 = r1.equalsIgnoreCase(r4);	 Catch:{ Exception -> 0x01fd }
        if (r1 == 0) goto L_0x01fd;	 Catch:{ Exception -> 0x01fd }
    L_0x01cf:
        r1 = r11.getHost();	 Catch:{ Exception -> 0x01fd }
        if (r1 == 0) goto L_0x01fd;	 Catch:{ Exception -> 0x01fd }
    L_0x01d5:
        r1 = r11.getHost();	 Catch:{ Exception -> 0x01fd }
        r1 = r1.length();	 Catch:{ Exception -> 0x01fd }
        if (r1 <= 0) goto L_0x01fd;	 Catch:{ Exception -> 0x01fd }
    L_0x01df:
        r1 = io.branch.referral.Defines.Jsonkey.BranchLinkUsed;	 Catch:{ Exception -> 0x01fd }
        r1 = r1.bc;	 Catch:{ Exception -> 0x01fd }
        r1 = r3.getBooleanExtra(r1, r2);	 Catch:{ Exception -> 0x01fd }
        if (r1 != 0) goto L_0x01fd;	 Catch:{ Exception -> 0x01fd }
    L_0x01e9:
        r11 = r11.toString();	 Catch:{ Exception -> 0x01fd }
        r1 = "bnc_app_link";	 Catch:{ Exception -> 0x01fd }
        io.branch.referral.PrefHelper.m26156a(r1, r11);	 Catch:{ Exception -> 0x01fd }
        r11 = io.branch.referral.Defines.Jsonkey.BranchLinkUsed;	 Catch:{ Exception -> 0x01fd }
        r11 = r11.bc;	 Catch:{ Exception -> 0x01fd }
        r3.putExtra(r11, r0);	 Catch:{ Exception -> 0x01fd }
        r12.setIntent(r3);	 Catch:{ Exception -> 0x01fd }
        return r2;
    L_0x01fd:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.Branch.a(android.net.Uri, android.app.Activity):boolean");
    }

    public final void mo5543c() {
        this.f30925D = false;
        this.f30941q.m26189a(PROCESS_WAIT_LOCK.GAID_FETCH_WAIT_LOCK);
        if (this.f30930L) {
            m31904k();
            this.f30930L = false;
            return;
        }
        m31897h();
    }

    public final void mo5545d() {
        this.f30941q.m26189a(PROCESS_WAIT_LOCK.INSTALL_REFERRER_FETCH_WAIT_LOCK);
        m31897h();
    }

    final org.json.JSONObject m31913a(org.json.JSONObject r4) {
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
        r3 = this;
        if (r4 == 0) goto L_0x0031;
    L_0x0002:
        r0 = r3.f30935f;	 Catch:{ Exception -> 0x0031 }
        if (r0 == 0) goto L_0x0031;	 Catch:{ Exception -> 0x0031 }
    L_0x0006:
        r0 = r3.f30935f;	 Catch:{ Exception -> 0x0031 }
        r0 = r0.length();	 Catch:{ Exception -> 0x0031 }
        if (r0 <= 0) goto L_0x0015;	 Catch:{ Exception -> 0x0031 }
    L_0x000e:
        r0 = "BranchSDK";	 Catch:{ Exception -> 0x0031 }
        r1 = "You're currently in deep link debug mode. Please comment out 'setDeepLinkDebugMode' to receive the deep link parameters from a real Branch link";	 Catch:{ Exception -> 0x0031 }
        android.util.Log.w(r0, r1);	 Catch:{ Exception -> 0x0031 }
    L_0x0015:
        r0 = r3.f30935f;	 Catch:{ Exception -> 0x0031 }
        r0 = r0.keys();	 Catch:{ Exception -> 0x0031 }
    L_0x001b:
        r1 = r0.hasNext();	 Catch:{ Exception -> 0x0031 }
        if (r1 == 0) goto L_0x0031;	 Catch:{ Exception -> 0x0031 }
    L_0x0021:
        r1 = r0.next();	 Catch:{ Exception -> 0x0031 }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x0031 }
        r2 = r3.f30935f;	 Catch:{ Exception -> 0x0031 }
        r2 = r2.get(r1);	 Catch:{ Exception -> 0x0031 }
        r4.put(r1, r2);	 Catch:{ Exception -> 0x0031 }
        goto L_0x001b;
    L_0x0031:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.Branch.a(org.json.JSONObject):org.json.JSONObject");
    }

    static org.json.JSONObject m31875a(java.lang.String r2) {
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
        r0 = "bnc_no_value";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x000e;
    L_0x0008:
        r2 = new org.json.JSONObject;
        r2.<init>();
        return r2;
    L_0x000e:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0014 }
        r0.<init>(r2);	 Catch:{ JSONException -> 0x0014 }
        return r0;
    L_0x0014:
        r2 = r2.getBytes();
        r2 = io.branch.referral.Base64.m26095a(r2);
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0027 }
        r1 = new java.lang.String;	 Catch:{ JSONException -> 0x0027 }
        r1.<init>(r2);	 Catch:{ JSONException -> 0x0027 }
        r0.<init>(r1);	 Catch:{ JSONException -> 0x0027 }
        return r0;
    L_0x0027:
        r2 = move-exception;
        r2.printStackTrace();
        r2 = new org.json.JSONObject;
        r2.<init>();
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.Branch.a(java.lang.String):org.json.JSONObject");
    }

    private void m31897h() {
        try {
            this.f30940p.acquire();
            if (this.f30942r != 0 || this.f30941q.m26192b() <= 0) {
                this.f30940p.release();
                return;
            }
            this.f30942r = 1;
            ServerRequest d = this.f30941q.m26194d();
            this.f30940p.release();
            if (d == null) {
                this.f30941q.m26191a(null);
            } else if (d.isWaitingOnProcessToFinish()) {
                this.f30942r = 0;
            } else if (!(d instanceof ServerRequestRegisterInstall) && !m31902j()) {
                Log.i("BranchSDK", "Branch Error: User session has not been initialized!");
                this.f30942r = 0;
                m31876a(this.f30941q.m26192b() - 1, -101);
            } else if ((d instanceof ServerRequestInitSession) || (m31900i() && (PrefHelper.m26170d("bnc_device_fingerprint_id").equals("bnc_no_value") ^ 1) != 0)) {
                new BranchPostTask(this, d).m26099a(new Void[0]);
            } else {
                this.f30942r = 0;
                m31876a(this.f30941q.m26192b() - 1, -101);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m31876a(int i, int i2) {
        if (i >= this.f30941q.m26192b()) {
            i = this.f30941q.m26186a(this.f30941q.m26192b() - 1);
        } else {
            i = this.f30941q.m26186a(i);
        }
        if (i != 0) {
            i.handleFailure(i2, "");
        }
    }

    private void m31878a(BranchReferralInitListener branchReferralInitListener, PROCESS_WAIT_LOCK process_wait_lock) {
        ServerRequest serverRequestRegisterOpen;
        if (m31902j()) {
            serverRequestRegisterOpen = new ServerRequestRegisterOpen(this.f30939o, branchReferralInitListener, this.f30938n);
        } else {
            serverRequestRegisterOpen = new ServerRequestRegisterInstall(this.f30939o, branchReferralInitListener, this.f30938n, InstallListener.m26146a());
        }
        serverRequestRegisterOpen.addProcessWaitLock(process_wait_lock);
        if (this.f30925D != null) {
            serverRequestRegisterOpen.addProcessWaitLock(PROCESS_WAIT_LOCK.GAID_FETCH_WAIT_LOCK);
        }
        if (this.f30945w != INTENT_STATE.READY) {
            serverRequestRegisterOpen.addProcessWaitLock(PROCESS_WAIT_LOCK.INTENT_PENDING_WAIT_LOCK);
        }
        if (!(f30915a == null || (serverRequestRegisterOpen instanceof ServerRequestRegisterInstall) == null)) {
            serverRequestRegisterOpen.addProcessWaitLock(PROCESS_WAIT_LOCK.INSTALL_REFERRER_FETCH_WAIT_LOCK);
            InstallListener.m26147a(f30919k);
        }
        if (this.f30941q.m26197g() != null) {
            if (branchReferralInitListener != null) {
                this.f30941q.m26188a(branchReferralInitListener);
            }
            branchReferralInitListener = this.f30941q;
            process_wait_lock = this.f30942r;
            synchronized (branchReferralInitListener.f24661a) {
                Iterator it = branchReferralInitListener.f24661a.iterator();
                while (it.hasNext()) {
                    ServerRequest serverRequest = (ServerRequest) it.next();
                    if (serverRequest != null && ((serverRequest instanceof ServerRequestRegisterInstall) || (serverRequest instanceof ServerRequestRegisterOpen))) {
                        it.remove();
                        break;
                    }
                }
            }
            if (process_wait_lock == null) {
                branchReferralInitListener.m26190a(serverRequestRegisterOpen, 0);
            } else {
                branchReferralInitListener.m26190a(serverRequestRegisterOpen, 1);
            }
        } else if (this.f30942r == null) {
            this.f30941q.m26190a(serverRequestRegisterOpen, 0);
        } else {
            this.f30941q.m26190a(serverRequestRegisterOpen, 1);
        }
        m31897h();
    }

    private void m31904k() {
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
        r15 = this;
        r0 = io.branch.referral.PrefHelper.m26179j();
        r1 = 1;
        r2 = 0;
        if (r0 != 0) goto L_0x000f;
    L_0x0008:
        r0 = f30917i;
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        goto L_0x000f;
    L_0x000d:
        r0 = r2;
        goto L_0x0010;
    L_0x000f:
        r0 = r1;
    L_0x0010:
        r3 = r15.f30938n;
        r4 = f30916g;
        r0 = io.branch.referral.DeviceInfo.m26139a(r0, r3, r4);
        r3 = r15.f30933d;
        r4 = 0;
        if (r3 == 0) goto L_0x0026;
    L_0x001d:
        r3 = r15.f30933d;
        r3 = r3.get();
        r3 = (android.app.Activity) r3;
        goto L_0x0027;
    L_0x0026:
        r3 = r4;
    L_0x0027:
        if (r3 == 0) goto L_0x002d;
    L_0x0029:
        r4 = r3.getApplicationContext();
    L_0x002d:
        if (r4 == 0) goto L_0x0121;
    L_0x002f:
        r3 = r15.f30941q;
        r5 = r3.f24661a;
        monitor-enter(r5);
        r3 = r3.f24661a;	 Catch:{ all -> 0x011e }
        r3 = r3.iterator();	 Catch:{ all -> 0x011e }
    L_0x003a:
        r6 = r3.hasNext();	 Catch:{ all -> 0x011e }
        if (r6 == 0) goto L_0x0052;	 Catch:{ all -> 0x011e }
    L_0x0040:
        r6 = r3.next();	 Catch:{ all -> 0x011e }
        r6 = (io.branch.referral.ServerRequest) r6;	 Catch:{ all -> 0x011e }
        if (r6 == 0) goto L_0x003a;	 Catch:{ all -> 0x011e }
    L_0x0048:
        r7 = r6 instanceof io.branch.referral.ServerRequestInitSession;	 Catch:{ all -> 0x011e }
        if (r7 == 0) goto L_0x003a;	 Catch:{ all -> 0x011e }
    L_0x004c:
        r7 = io.branch.referral.ServerRequest.PROCESS_WAIT_LOCK.STRONG_MATCH_PENDING_WAIT_LOCK;	 Catch:{ all -> 0x011e }
        r6.addProcessWaitLock(r7);	 Catch:{ all -> 0x011e }
        goto L_0x003a;	 Catch:{ all -> 0x011e }
    L_0x0052:
        monitor-exit(r5);	 Catch:{ all -> 0x011e }
        r3 = io.branch.referral.BranchStrongMatchHelper.m26105a();
        r5 = f30912G;
        r12 = r15.f30931b;
        r6 = r15.f30938n;
        r14 = new io.branch.referral.Branch$2;
        r14.<init>(r15);
        r3.f24513d = r2;
        r7 = java.lang.System.currentTimeMillis();
        r9 = "bnc_branch_strong_match_time";
        r9 = io.branch.referral.PrefHelper.m26165c(r9);
        r7 = r7 - r9;
        r9 = 2592000000; // 0x9a7ec800 float:-5.2687528E-23 double:1.280618154E-314;
        r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));
        if (r7 >= 0) goto L_0x007e;
    L_0x0078:
        r0 = r3.f24513d;
        r3.m26107a(r14, r0);
        return;
    L_0x007e:
        r7 = r3.f24512c;
        if (r7 != 0) goto L_0x0088;
    L_0x0082:
        r0 = r3.f24513d;
        r3.m26107a(r14, r0);
        return;
    L_0x0088:
        r7 = r0.m26140b();	 Catch:{ Throwable -> 0x0118 }
        if (r7 == 0) goto L_0x010b;	 Catch:{ Throwable -> 0x0118 }
    L_0x008e:
        r10 = io.branch.referral.BranchStrongMatchHelper.m26104a(r5, r0, r6, r4);	 Catch:{ Throwable -> 0x0118 }
        if (r10 == 0) goto L_0x0105;	 Catch:{ Throwable -> 0x0118 }
    L_0x0094:
        r0 = r3.f24511b;	 Catch:{ Throwable -> 0x0118 }
        r5 = new io.branch.referral.BranchStrongMatchHelper$1;	 Catch:{ Throwable -> 0x0118 }
        r5.<init>(r3, r14);	 Catch:{ Throwable -> 0x0118 }
        r6 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;	 Catch:{ Throwable -> 0x0118 }
        r0.postDelayed(r5, r6);	 Catch:{ Throwable -> 0x0118 }
        r0 = r3.f24514e;	 Catch:{ Throwable -> 0x0118 }
        r5 = "bindCustomTabsService";	 Catch:{ Throwable -> 0x0118 }
        r6 = 3;	 Catch:{ Throwable -> 0x0118 }
        r7 = new java.lang.Class[r6];	 Catch:{ Throwable -> 0x0118 }
        r8 = android.content.Context.class;	 Catch:{ Throwable -> 0x0118 }
        r7[r2] = r8;	 Catch:{ Throwable -> 0x0118 }
        r8 = java.lang.String.class;	 Catch:{ Throwable -> 0x0118 }
        r7[r1] = r8;	 Catch:{ Throwable -> 0x0118 }
        r8 = r3.f24515f;	 Catch:{ Throwable -> 0x0118 }
        r9 = 2;	 Catch:{ Throwable -> 0x0118 }
        r7[r9] = r8;	 Catch:{ Throwable -> 0x0118 }
        r0.getMethod(r5, r7);	 Catch:{ Throwable -> 0x0118 }
        r0 = r3.f24514e;	 Catch:{ Throwable -> 0x0118 }
        r5 = "warmup";	 Catch:{ Throwable -> 0x0118 }
        r7 = new java.lang.Class[r1];	 Catch:{ Throwable -> 0x0118 }
        r8 = java.lang.Long.TYPE;	 Catch:{ Throwable -> 0x0118 }
        r7[r2] = r8;	 Catch:{ Throwable -> 0x0118 }
        r8 = r0.getMethod(r5, r7);	 Catch:{ Throwable -> 0x0118 }
        r0 = r3.f24514e;	 Catch:{ Throwable -> 0x0118 }
        r5 = "newSession";	 Catch:{ Throwable -> 0x0118 }
        r7 = new java.lang.Class[r1];	 Catch:{ Throwable -> 0x0118 }
        r11 = r3.f24516g;	 Catch:{ Throwable -> 0x0118 }
        r7[r2] = r11;	 Catch:{ Throwable -> 0x0118 }
        r0 = r0.getMethod(r5, r7);	 Catch:{ Throwable -> 0x0118 }
        r5 = r3.f24517h;	 Catch:{ Throwable -> 0x0118 }
        r7 = "mayLaunchUrl";	 Catch:{ Throwable -> 0x0118 }
        r6 = new java.lang.Class[r6];	 Catch:{ Throwable -> 0x0118 }
        r11 = android.net.Uri.class;	 Catch:{ Throwable -> 0x0118 }
        r6[r2] = r11;	 Catch:{ Throwable -> 0x0118 }
        r2 = android.os.Bundle.class;	 Catch:{ Throwable -> 0x0118 }
        r6[r1] = r2;	 Catch:{ Throwable -> 0x0118 }
        r1 = java.util.List.class;	 Catch:{ Throwable -> 0x0118 }
        r6[r9] = r1;	 Catch:{ Throwable -> 0x0118 }
        r11 = r5.getMethod(r7, r6);	 Catch:{ Throwable -> 0x0118 }
        r1 = new android.content.Intent;	 Catch:{ Throwable -> 0x0118 }
        r2 = "android.support.customtabs.action.CustomTabsService";	 Catch:{ Throwable -> 0x0118 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x0118 }
        r2 = "com.android.chrome";	 Catch:{ Throwable -> 0x0118 }
        r1.setPackage(r2);	 Catch:{ Throwable -> 0x0118 }
        r2 = new io.branch.referral.BranchStrongMatchHelper$2;	 Catch:{ Throwable -> 0x0118 }
        r6 = r2;	 Catch:{ Throwable -> 0x0118 }
        r7 = r3;	 Catch:{ Throwable -> 0x0118 }
        r9 = r0;	 Catch:{ Throwable -> 0x0118 }
        r13 = r14;	 Catch:{ Throwable -> 0x0118 }
        r6.<init>(r7, r8, r9, r10, r11, r12, r13);	 Catch:{ Throwable -> 0x0118 }
        r0 = 33;	 Catch:{ Throwable -> 0x0118 }
        r4.bindService(r1, r2, r0);	 Catch:{ Throwable -> 0x0118 }
        return;	 Catch:{ Throwable -> 0x0118 }
    L_0x0105:
        r0 = r3.f24513d;	 Catch:{ Throwable -> 0x0118 }
        r3.m26107a(r14, r0);	 Catch:{ Throwable -> 0x0118 }
        return;	 Catch:{ Throwable -> 0x0118 }
    L_0x010b:
        r0 = r3.f24513d;	 Catch:{ Throwable -> 0x0118 }
        r3.m26107a(r14, r0);	 Catch:{ Throwable -> 0x0118 }
        r0 = "BranchSDK";	 Catch:{ Throwable -> 0x0118 }
        r1 = "Cannot use cookie-based matching since device id is not available";	 Catch:{ Throwable -> 0x0118 }
        android.util.Log.d(r0, r1);	 Catch:{ Throwable -> 0x0118 }
        return;
    L_0x0118:
        r0 = r3.f24513d;
        r3.m26107a(r14, r0);
        goto L_0x0121;
    L_0x011e:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x011e }
        throw r0;
    L_0x0121:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.Branch.k():void");
    }

    private static boolean m31888b(android.content.Intent r3) {
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
        r0 = 0;
        if (r3 == 0) goto L_0x0017;
    L_0x0003:
        r1 = io.branch.referral.Defines.Jsonkey.ForceNewBranchSession;	 Catch:{ BadParcelableException -> 0x000c }
        r1 = r1.bc;	 Catch:{ BadParcelableException -> 0x000c }
        r1 = r3.getBooleanExtra(r1, r0);	 Catch:{ BadParcelableException -> 0x000c }
        goto L_0x000d;
    L_0x000c:
        r1 = r0;
    L_0x000d:
        if (r1 == 0) goto L_0x0016;
    L_0x000f:
        r2 = io.branch.referral.Defines.Jsonkey.ForceNewBranchSession;
        r2 = r2.bc;
        r3.putExtra(r2, r0);
    L_0x0016:
        r0 = r1;
    L_0x0017:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.Branch.b(android.content.Intent):boolean");
    }

    private void m31906l() {
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
        r11 = this;
        r0 = r11.m31922e();
        r1 = 0;
        r2 = io.branch.referral.Defines.Jsonkey.Clicked_Branch_Link;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r2 = r2.bc;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r2 = r0.has(r2);	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        if (r2 == 0) goto L_0x010d;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x000f:
        r2 = io.branch.referral.Defines.Jsonkey.Clicked_Branch_Link;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r2 = r2.bc;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r2 = r0.getBoolean(r2);	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        if (r2 != 0) goto L_0x001b;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x0019:
        goto L_0x010d;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x001b:
        r2 = r0.length();	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        if (r2 <= 0) goto L_0x010c;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x0021:
        r2 = r11.f30939o;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r2 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r3 = r11.f30939o;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r3 = r3.getPackageName();	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r4 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r2 = r2.getApplicationInfo(r3, r4);	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r3 = r2.metaData;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r4 = 0;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        if (r3 == 0) goto L_0x0043;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x0038:
        r2 = r2.metaData;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r3 = "io.branch.sdk.auto_link_disable";	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r2 = r2.getBoolean(r3, r4);	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        if (r2 == 0) goto L_0x0043;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x0042:
        return;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x0043:
        r2 = r11.f30939o;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r2 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r3 = r11.f30939o;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r3 = r3.getPackageName();	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r5 = 129; // 0x81 float:1.81E-43 double:6.37E-322;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r2 = r2.getPackageInfo(r3, r5);	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r2 = r2.activities;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        if (r2 == 0) goto L_0x00be;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x0059:
        r3 = r2.length;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r5 = r4;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x005b:
        if (r5 >= r3) goto L_0x00be;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x005d:
        r6 = r2[r5];	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        if (r6 == 0) goto L_0x00bb;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x0061:
        r7 = r6.metaData;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        if (r7 == 0) goto L_0x00bb;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x0065:
        r7 = r6.metaData;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r8 = "io.branch.sdk.auto_link_keys";	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r7 = r7.getString(r8);	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        if (r7 != 0) goto L_0x0079;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x006f:
        r7 = r6.metaData;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r8 = "io.branch.sdk.auto_link_path";	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r7 = r7.getString(r8);	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        if (r7 == 0) goto L_0x00bb;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x0079:
        r7 = r6.metaData;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r8 = "io.branch.sdk.auto_link_keys";	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r7 = r7.getString(r8);	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        if (r7 == 0) goto L_0x00a2;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x0083:
        r7 = r6.metaData;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r8 = "io.branch.sdk.auto_link_keys";	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r7 = r7.getString(r8);	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r8 = ",";	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r7 = r7.split(r8);	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r8 = r7.length;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r9 = r4;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x0093:
        if (r9 >= r8) goto L_0x00a2;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x0095:
        r10 = r7[r9];	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r10 = r0.has(r10);	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        if (r10 == 0) goto L_0x009f;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x009d:
        r7 = 1;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        goto L_0x00a3;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x009f:
        r9 = r9 + 1;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        goto L_0x0093;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x00a2:
        r7 = r4;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x00a3:
        if (r7 != 0) goto L_0x00ab;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x00a5:
        r7 = m31885a(r0, r6);	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        if (r7 == 0) goto L_0x00bb;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x00ab:
        r2 = r6.name;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r1 = r6.metaData;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x00b9, Exception -> 0x010e }
        r3 = "io.branch.sdk.auto_link_request_code";	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x00b9, Exception -> 0x010e }
        r4 = 1501; // 0x5dd float:2.103E-42 double:7.416E-321;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x00b9, Exception -> 0x010e }
        r4 = r1.getInt(r3, r4);	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x00b9, Exception -> 0x010e }
        r1 = r2;
        goto L_0x00be;
    L_0x00b9:
        r1 = r2;
        goto L_0x010f;
    L_0x00bb:
        r5 = r5 + 1;
        goto L_0x005b;
    L_0x00be:
        if (r1 == 0) goto L_0x010c;
    L_0x00c0:
        r2 = r11.f30933d;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        if (r2 == 0) goto L_0x010c;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x00c4:
        r2 = r11.f30933d;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r2 = r2.get();	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r2 = (android.app.Activity) r2;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        if (r2 == 0) goto L_0x0105;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x00ce:
        r3 = new android.content.Intent;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r5 = java.lang.Class.forName(r1);	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r3.<init>(r2, r5);	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r5 = "io.branch.sdk.auto_linked";	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r6 = "true";	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r3.putExtra(r5, r6);	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r5 = io.branch.referral.Defines.Jsonkey.ReferringData;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r5 = r5.bc;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r6 = r0.toString();	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r3.putExtra(r5, r6);	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r5 = r0.keys();	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x00ed:
        r6 = r5.hasNext();	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        if (r6 == 0) goto L_0x0101;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x00f3:
        r6 = r5.next();	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r6 = (java.lang.String) r6;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r7 = r0.getString(r6);	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r3.putExtra(r6, r7);	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        goto L_0x00ed;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x0101:
        r2.startActivityForResult(r3, r4);	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        return;	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x0105:
        r0 = "BranchSDK";	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        r2 = "No activity reference to launch deep linked activity";	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
        android.util.Log.w(r0, r2);	 Catch:{ NameNotFoundException -> 0x0123, ClassNotFoundException -> 0x010f, Exception -> 0x010e }
    L_0x010c:
        return;
    L_0x010d:
        return;
    L_0x010e:
        return;
    L_0x010f:
        r0 = "BranchSDK";
        r2 = new java.lang.StringBuilder;
        r3 = "Branch Warning: Please make sure Activity names set for auto deep link are correct! Error while looking for activity ";
        r2.<init>(r3);
        r2.append(r1);
        r1 = r2.toString();
        android.util.Log.i(r0, r1);
        return;
    L_0x0123:
        r0 = "BranchSDK";
        r1 = "Branch Warning: Please make sure Activity names set for auto deep link are correct!";
        android.util.Log.i(r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.Branch.l():void");
    }

    private static boolean m31885a(org.json.JSONObject r9, android.content.pm.ActivityInfo r10) {
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
        r0 = 0;
        r1 = io.branch.referral.Defines.Jsonkey.AndroidDeepLinkPath;	 Catch:{ JSONException -> 0x0028 }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x0028 }
        r1 = r9.has(r1);	 Catch:{ JSONException -> 0x0028 }
        if (r1 == 0) goto L_0x0015;	 Catch:{ JSONException -> 0x0028 }
    L_0x000b:
        r1 = io.branch.referral.Defines.Jsonkey.AndroidDeepLinkPath;	 Catch:{ JSONException -> 0x0028 }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x0028 }
        r9 = r9.getString(r1);	 Catch:{ JSONException -> 0x0028 }
    L_0x0013:
        r0 = r9;	 Catch:{ JSONException -> 0x0028 }
        goto L_0x0028;	 Catch:{ JSONException -> 0x0028 }
    L_0x0015:
        r1 = io.branch.referral.Defines.Jsonkey.DeepLinkPath;	 Catch:{ JSONException -> 0x0028 }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x0028 }
        r1 = r9.has(r1);	 Catch:{ JSONException -> 0x0028 }
        if (r1 == 0) goto L_0x0028;	 Catch:{ JSONException -> 0x0028 }
    L_0x001f:
        r1 = io.branch.referral.Defines.Jsonkey.DeepLinkPath;	 Catch:{ JSONException -> 0x0028 }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x0028 }
        r9 = r9.getString(r1);	 Catch:{ JSONException -> 0x0028 }
        goto L_0x0013;
    L_0x0028:
        r9 = r10.metaData;
        r1 = "io.branch.sdk.auto_link_path";
        r9 = r9.getString(r1);
        r1 = 0;
        if (r9 == 0) goto L_0x0094;
    L_0x0033:
        if (r0 == 0) goto L_0x0094;
    L_0x0035:
        r9 = r10.metaData;
        r10 = "io.branch.sdk.auto_link_path";
        r9 = r9.getString(r10);
        r10 = ",";
        r9 = r9.split(r10);
        r10 = r9.length;
        r2 = r1;
    L_0x0045:
        if (r2 >= r10) goto L_0x0094;
    L_0x0047:
        r3 = r9[r2];
        r3 = r3.trim();
        r4 = "\\?";
        r3 = r3.split(r4);
        r3 = r3[r1];
        r4 = "/";
        r3 = r3.split(r4);
        r4 = "\\?";
        r4 = r0.split(r4);
        r4 = r4[r1];
        r5 = "/";
        r4 = r4.split(r5);
        r5 = 1;
        r6 = r3.length;
        r7 = r4.length;
        if (r6 == r7) goto L_0x0070;
    L_0x006e:
        r3 = r1;
        goto L_0x008e;
    L_0x0070:
        r6 = r1;
    L_0x0071:
        r7 = r3.length;
        if (r6 >= r7) goto L_0x008d;
    L_0x0074:
        r7 = r4.length;
        if (r6 >= r7) goto L_0x008d;
    L_0x0077:
        r7 = r3[r6];
        r8 = r4[r6];
        r8 = r7.equals(r8);
        if (r8 != 0) goto L_0x008a;
    L_0x0081:
        r8 = "*";
        r7 = r7.contains(r8);
        if (r7 != 0) goto L_0x008a;
    L_0x0089:
        goto L_0x006e;
    L_0x008a:
        r6 = r6 + 1;
        goto L_0x0071;
    L_0x008d:
        r3 = r5;
    L_0x008e:
        if (r3 == 0) goto L_0x0091;
    L_0x0090:
        return r5;
    L_0x0091:
        r2 = r2 + 1;
        goto L_0x0045;
    L_0x0094:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.Branch.a(org.json.JSONObject, android.content.pm.ActivityInfo):boolean");
    }

    public static boolean m31894f() {
        return f30918j;
    }

    public final void m31914a(String str, String str2) {
        this.f30924C.put(str, str2);
    }

    public final void mo5542b(String str) {
        if (ServerRequestInitSession.m31925a(str) != null) {
            m31906l();
        }
    }

    public final void mo5544c(String str) {
        if (ServerRequestInitSession.m31925a(str) != null) {
            m31906l();
        }
    }

    public final void mo5546d(String str) {
        if (ServerRequestInitSession.m31925a(str) != null) {
            m31906l();
        }
    }

    public final JSONObject m31922e() {
        return m31913a(m31875a(PrefHelper.m26170d("bnc_session_params")));
    }

    private static boolean m31900i() {
        return !PrefHelper.m26170d("bnc_session_id").equals("bnc_no_value");
    }

    private static boolean m31902j() {
        return !PrefHelper.m26170d("bnc_identity_id").equals("bnc_no_value");
    }

    static /* synthetic */ void m31880a(Branch branch, Activity activity) {
        branch.m31883a(activity.getIntent() != null ? activity.getIntent().getData() : null, activity);
        branch.m31915a(null, activity);
    }

    static /* synthetic */ void m31881a(Branch branch, Activity activity, boolean z) {
        branch.f30941q.m26189a(PROCESS_WAIT_LOCK.INTENT_PENDING_WAIT_LOCK);
        if (z) {
            branch.m31883a(activity.getIntent().getData(), activity);
            if (f30912G == null || PrefHelper.m26169d() == null || PrefHelper.m26169d().equalsIgnoreCase("bnc_no_value") != null) {
                branch.m31897h();
                return;
            } else if (branch.f30925D != null) {
                branch.f30930L = true;
                return;
            } else {
                branch.m31904k();
                return;
            }
        }
        branch.m31897h();
    }

    static /* synthetic */ void m31898h(Branch branch) {
        if (branch.f30947y != SESSION_STATE.UNINITIALISED) {
            ServerRequest d;
            if (!branch.f30943s) {
                d = branch.f30941q.m26194d();
                if ((d != null && (d instanceof ServerRequestRegisterInstall)) || (d instanceof ServerRequestRegisterOpen)) {
                    branch.f30941q.m26193c();
                }
            } else if (!branch.f30941q.m26196f()) {
                d = new ServerRequestRegisterClose(branch.f30939o);
                if (branch.f30947y == SESSION_STATE.INITIALISED || (d instanceof ServerRequestInitSession)) {
                    ServerRequestQueue serverRequestQueue = branch.f30941q;
                    serverRequestQueue.f24661a.add(d);
                    if (serverRequestQueue.m26192b() >= 25) {
                        serverRequestQueue.f24661a.remove(1);
                    }
                    serverRequestQueue.m26187a();
                    d.onRequestQueued();
                    branch.m31897h();
                } else if (d instanceof ServerRequestLogout) {
                    d.handleFailure(-101, "");
                    Log.i("BranchSDK", "Branch is not initialized, cannot logout");
                } else {
                    Log.i("BranchSDK", "Branch is not initialized, cannot close session");
                }
            }
            branch.f30947y = SESSION_STATE.UNINITIALISED;
        }
        branch.f30934e = null;
    }

    static /* synthetic */ void m31908n(Branch branch) {
        int i = 0;
        while (i < branch.f30941q.m26192b()) {
            try {
                ServerRequest a = branch.f30941q.m26186a(i);
                if (a != null) {
                    JSONObject post = a.getPost();
                    if (post != null) {
                        if (post.has(Jsonkey.SessionID.bc)) {
                            a.getPost().put(Jsonkey.SessionID.bc, PrefHelper.m26170d("bnc_session_id"));
                        }
                        if (post.has(Jsonkey.IdentityID.bc)) {
                            a.getPost().put(Jsonkey.IdentityID.bc, PrefHelper.m26170d("bnc_identity_id"));
                        }
                        if (post.has(Jsonkey.DeviceFingerprintID.bc)) {
                            a.getPost().put(Jsonkey.DeviceFingerprintID.bc, PrefHelper.m26170d("bnc_device_fingerprint_id"));
                        }
                    }
                }
                i++;
            } catch (Branch branch2) {
                branch2.printStackTrace();
                return;
            }
        }
    }
}
