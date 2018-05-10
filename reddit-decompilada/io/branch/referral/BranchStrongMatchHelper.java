package io.branch.referral;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import io.branch.referral.Defines.Jsonkey;
import java.lang.reflect.Method;

class BranchStrongMatchHelper {
    private static BranchStrongMatchHelper f24508j = null;
    private static int f24509k = 750;
    Object f24510a = null;
    final Handler f24511b;
    boolean f24512c = true;
    boolean f24513d = false;
    Class<?> f24514e;
    Class<?> f24515f;
    Class<?> f24516g;
    Class<?> f24517h;
    Class<?> f24518i;

    class C21041 implements Runnable {
        final /* synthetic */ StrongMatchCheckEvents f24503a;
        final /* synthetic */ BranchStrongMatchHelper f24504b;

        C21041(BranchStrongMatchHelper branchStrongMatchHelper, StrongMatchCheckEvents strongMatchCheckEvents) {
            this.f24504b = branchStrongMatchHelper;
            this.f24503a = strongMatchCheckEvents;
        }

        public void run() {
            this.f24504b.m26107a(this.f24503a, this.f24504b.f24513d);
        }
    }

    private abstract class MockCustomTabServiceConnection implements ServiceConnection {
        final /* synthetic */ BranchStrongMatchHelper f24507h;

        public abstract void mo5547a(Object obj);

        public MockCustomTabServiceConnection(BranchStrongMatchHelper branchStrongMatchHelper) {
            this.f24507h = branchStrongMatchHelper;
        }

        public final void onServiceConnected(android.content.ComponentName r10, android.os.IBinder r11) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r9 = this;
            r0 = 0;
            r1 = r9.f24507h;	 Catch:{ Throwable -> 0x0043 }
            r1 = r1.f24514e;	 Catch:{ Throwable -> 0x0043 }
            r2 = 2;	 Catch:{ Throwable -> 0x0043 }
            r3 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x0043 }
            r4 = r9.f24507h;	 Catch:{ Throwable -> 0x0043 }
            r4 = r4.f24518i;	 Catch:{ Throwable -> 0x0043 }
            r5 = 0;	 Catch:{ Throwable -> 0x0043 }
            r3[r5] = r4;	 Catch:{ Throwable -> 0x0043 }
            r4 = android.content.ComponentName.class;	 Catch:{ Throwable -> 0x0043 }
            r6 = 1;	 Catch:{ Throwable -> 0x0043 }
            r3[r6] = r4;	 Catch:{ Throwable -> 0x0043 }
            r1 = r1.getDeclaredConstructor(r3);	 Catch:{ Throwable -> 0x0043 }
            r1.setAccessible(r6);	 Catch:{ Throwable -> 0x0043 }
            r3 = "android.support.customtabs.ICustomTabsService$Stub";	 Catch:{ Throwable -> 0x0043 }
            r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x0043 }
            r4 = "asInterface";	 Catch:{ Throwable -> 0x0043 }
            r7 = new java.lang.Class[r6];	 Catch:{ Throwable -> 0x0043 }
            r8 = android.os.IBinder.class;	 Catch:{ Throwable -> 0x0043 }
            r7[r5] = r8;	 Catch:{ Throwable -> 0x0043 }
            r3 = r3.getMethod(r4, r7);	 Catch:{ Throwable -> 0x0043 }
            r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0043 }
            r4 = new java.lang.Object[r6];	 Catch:{ Throwable -> 0x0043 }
            r4[r5] = r11;	 Catch:{ Throwable -> 0x0043 }
            r11 = r3.invoke(r0, r4);	 Catch:{ Throwable -> 0x0043 }
            r2[r5] = r11;	 Catch:{ Throwable -> 0x0043 }
            r2[r6] = r10;	 Catch:{ Throwable -> 0x0043 }
            r10 = r1.newInstance(r2);	 Catch:{ Throwable -> 0x0043 }
            r9.mo5547a(r10);	 Catch:{ Throwable -> 0x0043 }
            return;
        L_0x0043:
            r9.mo5547a(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.BranchStrongMatchHelper.MockCustomTabServiceConnection.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
        }
    }

    interface StrongMatchCheckEvents {
        void mo5541a();
    }

    class C25362 extends MockCustomTabServiceConnection {
        final /* synthetic */ Method f30949a;
        final /* synthetic */ Method f30950b;
        final /* synthetic */ Uri f30951c;
        final /* synthetic */ Method f30952d;
        final /* synthetic */ PrefHelper f30953e;
        final /* synthetic */ StrongMatchCheckEvents f30954f;
        final /* synthetic */ BranchStrongMatchHelper f30955g;

        C25362(BranchStrongMatchHelper branchStrongMatchHelper, Method method, Method method2, Uri uri, Method method3, PrefHelper prefHelper, StrongMatchCheckEvents strongMatchCheckEvents) {
            this.f30955g = branchStrongMatchHelper;
            this.f30949a = method;
            this.f30950b = method2;
            this.f30951c = uri;
            this.f30952d = method3;
            this.f30953e = prefHelper;
            this.f30954f = strongMatchCheckEvents;
            super(branchStrongMatchHelper);
        }

        public final void mo5547a(java.lang.Object r7) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r6 = this;
            r0 = r6.f30955g;
            r1 = r6.f30955g;
            r1 = r1.f24514e;
            r7 = r1.cast(r7);
            r0.f24510a = r7;
            r7 = r6.f30955g;
            r7 = r7.f24510a;
            if (r7 == 0) goto L_0x0079;
        L_0x0012:
            r7 = 0;
            r0 = r6.f30949a;	 Catch:{ Throwable -> 0x006a }
            r1 = r6.f30955g;	 Catch:{ Throwable -> 0x006a }
            r1 = r1.f24510a;	 Catch:{ Throwable -> 0x006a }
            r2 = 1;	 Catch:{ Throwable -> 0x006a }
            r3 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x006a }
            r4 = 0;	 Catch:{ Throwable -> 0x006a }
            r5 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x006a }
            r3[r4] = r5;	 Catch:{ Throwable -> 0x006a }
            r0.invoke(r1, r3);	 Catch:{ Throwable -> 0x006a }
            r0 = r6.f30950b;	 Catch:{ Throwable -> 0x006a }
            r1 = r6.f30955g;	 Catch:{ Throwable -> 0x006a }
            r1 = r1.f24510a;	 Catch:{ Throwable -> 0x006a }
            r3 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x006a }
            r3[r4] = r7;	 Catch:{ Throwable -> 0x006a }
            r0 = r0.invoke(r1, r3);	 Catch:{ Throwable -> 0x006a }
            if (r0 == 0) goto L_0x0069;	 Catch:{ Throwable -> 0x006a }
        L_0x0036:
            r1 = "BranchSDK";	 Catch:{ Throwable -> 0x006a }
            r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x006a }
            r5 = "Strong match request ";	 Catch:{ Throwable -> 0x006a }
            r3.<init>(r5);	 Catch:{ Throwable -> 0x006a }
            r5 = r6.f30951c;	 Catch:{ Throwable -> 0x006a }
            r3.append(r5);	 Catch:{ Throwable -> 0x006a }
            r3 = r3.toString();	 Catch:{ Throwable -> 0x006a }
            io.branch.referral.PrefHelper.m26161b(r1, r3);	 Catch:{ Throwable -> 0x006a }
            r1 = r6.f30952d;	 Catch:{ Throwable -> 0x006a }
            r3 = 3;	 Catch:{ Throwable -> 0x006a }
            r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x006a }
            r5 = r6.f30951c;	 Catch:{ Throwable -> 0x006a }
            r3[r4] = r5;	 Catch:{ Throwable -> 0x006a }
            r3[r2] = r7;	 Catch:{ Throwable -> 0x006a }
            r4 = 2;	 Catch:{ Throwable -> 0x006a }
            r3[r4] = r7;	 Catch:{ Throwable -> 0x006a }
            r1.invoke(r0, r3);	 Catch:{ Throwable -> 0x006a }
            r0 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x006a }
            r3 = "bnc_branch_strong_match_time";	 Catch:{ Throwable -> 0x006a }
            io.branch.referral.PrefHelper.m26154a(r3, r0);	 Catch:{ Throwable -> 0x006a }
            r0 = r6.f30955g;	 Catch:{ Throwable -> 0x006a }
            r0.f24513d = r2;	 Catch:{ Throwable -> 0x006a }
        L_0x0069:
            return;
        L_0x006a:
            r0 = r6.f30955g;
            r0.f24510a = r7;
            r7 = r6.f30955g;
            r0 = r6.f30954f;
            r1 = r6.f30955g;
            r1 = r1.f24513d;
            r7.m26107a(r0, r1);
        L_0x0079:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.BranchStrongMatchHelper.2.a(java.lang.Object):void");
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.f30955g.f24510a = null;
            this.f30955g.m26107a(this.f30954f, this.f30955g.f24513d);
        }
    }

    private BranchStrongMatchHelper() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = this;
        r2.<init>();
        r0 = 0;
        r2.f24510a = r0;
        r0 = 1;
        r2.f24512c = r0;
        r0 = 0;
        r2.f24513d = r0;
        r1 = "android.support.customtabs.CustomTabsClient";	 Catch:{ Throwable -> 0x0035 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Throwable -> 0x0035 }
        r2.f24514e = r1;	 Catch:{ Throwable -> 0x0035 }
        r1 = "android.support.customtabs.CustomTabsServiceConnection";	 Catch:{ Throwable -> 0x0035 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Throwable -> 0x0035 }
        r2.f24515f = r1;	 Catch:{ Throwable -> 0x0035 }
        r1 = "android.support.customtabs.CustomTabsCallback";	 Catch:{ Throwable -> 0x0035 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Throwable -> 0x0035 }
        r2.f24516g = r1;	 Catch:{ Throwable -> 0x0035 }
        r1 = "android.support.customtabs.CustomTabsSession";	 Catch:{ Throwable -> 0x0035 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Throwable -> 0x0035 }
        r2.f24517h = r1;	 Catch:{ Throwable -> 0x0035 }
        r1 = "android.support.customtabs.ICustomTabsService";	 Catch:{ Throwable -> 0x0035 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Throwable -> 0x0035 }
        r2.f24518i = r1;	 Catch:{ Throwable -> 0x0035 }
        goto L_0x0037;
    L_0x0035:
        r2.f24512c = r0;
    L_0x0037:
        r0 = new android.os.Handler;
        r0.<init>();
        r2.f24511b = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.BranchStrongMatchHelper.<init>():void");
    }

    public static BranchStrongMatchHelper m26105a() {
        if (f24508j == null) {
            f24508j = new BranchStrongMatchHelper();
        }
        return f24508j;
    }

    final void m26107a(final StrongMatchCheckEvents strongMatchCheckEvents, boolean z) {
        if (strongMatchCheckEvents != null) {
            if (z) {
                new Handler().postDelayed(new Runnable(this) {
                    final /* synthetic */ BranchStrongMatchHelper f24506b;

                    public void run() {
                        strongMatchCheckEvents.mo5541a();
                    }
                }, (long) f24509k);
                return;
            }
            strongMatchCheckEvents.mo5541a();
        }
    }

    static Uri m26104a(String str, DeviceInfo deviceInfo, SystemObserver systemObserver, Context context) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2;
        StringBuilder stringBuilder = new StringBuilder("https://");
        stringBuilder.append(str);
        stringBuilder.append("/_strong_match?os=");
        stringBuilder.append(deviceInfo.f24634j);
        str = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("&");
        stringBuilder.append(Jsonkey.HardwareID.bc);
        stringBuilder.append(Operation.EQUALS);
        stringBuilder.append(deviceInfo.m26140b());
        str = stringBuilder.toString();
        if (deviceInfo.f24626b) {
            str2 = Jsonkey.HardwareIDTypeVendor.bc;
        } else {
            str2 = Jsonkey.HardwareIDTypeRandom.bc;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append("&");
        stringBuilder2.append(Jsonkey.HardwareIDType.bc);
        stringBuilder2.append(Operation.EQUALS);
        stringBuilder2.append(str2);
        str = stringBuilder2.toString();
        if (systemObserver.f24671a != null && BranchUtil.m26108a(context) == null) {
            context = new StringBuilder();
            context.append(str);
            context.append("&");
            context.append(Jsonkey.GoogleAdvertisingID.bc);
            context.append(Operation.EQUALS);
            context.append(systemObserver.f24671a);
            str = context.toString();
        }
        if (PrefHelper.m26170d("bnc_device_fingerprint_id").equals("bnc_no_value") == null) {
            systemObserver = new StringBuilder();
            systemObserver.append(str);
            systemObserver.append("&");
            systemObserver.append(Jsonkey.DeviceFingerprintID.bc);
            systemObserver.append(Operation.EQUALS);
            systemObserver.append(PrefHelper.m26170d("bnc_device_fingerprint_id"));
            str = systemObserver.toString();
        }
        if (deviceInfo.f24636l.equals("bnc_no_value") == null) {
            systemObserver = new StringBuilder();
            systemObserver.append(str);
            systemObserver.append("&");
            systemObserver.append(Jsonkey.AppVersion.bc);
            systemObserver.append(Operation.EQUALS);
            systemObserver.append(deviceInfo.f24636l);
            str = systemObserver.toString();
        }
        if (PrefHelper.m26169d().equals("bnc_no_value") == null) {
            deviceInfo = new StringBuilder();
            deviceInfo.append(str);
            deviceInfo.append("&");
            deviceInfo.append(Jsonkey.BranchKey.bc);
            deviceInfo.append(Operation.EQUALS);
            deviceInfo.append(PrefHelper.m26169d());
            str = deviceInfo.toString();
        }
        deviceInfo = new StringBuilder();
        deviceInfo.append(str);
        deviceInfo.append("&sdk=android2.12.0");
        return Uri.parse(deviceInfo.toString());
    }
}
