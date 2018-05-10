package com.sendbird.android;

class CountDownTimer {
    CountDownTimerEventHandler f22578a;
    private boolean f22579b;
    private int f22580c;
    private int f22581d;
    private Thread f22582e;
    private boolean f22583f;

    class C19601 extends Thread {
        final /* synthetic */ CountDownTimer f22577a;

        C19601(CountDownTimer countDownTimer) {
            this.f22577a = countDownTimer;
        }

        public void run() {
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
            r4 = this;
            r0 = r4.f22577a;
            r0 = r0.f22578a;
            if (r0 == 0) goto L_0x0011;
        L_0x0008:
            r0 = r4.f22577a;
            r0 = r0.f22578a;
            r0.mo5221a();
        L_0x0011:
            r0 = 0;
        L_0x0012:
            r1 = r0;
        L_0x0013:
            r2 = r4.f22577a;	 Catch:{ InterruptedException -> 0x0066 }
            r2 = r2.f22581d;	 Catch:{ InterruptedException -> 0x0066 }
            r2 = (long) r2;	 Catch:{ InterruptedException -> 0x0066 }
            java.lang.Thread.sleep(r2);	 Catch:{ InterruptedException -> 0x0066 }
            r2 = r4.f22577a;	 Catch:{ InterruptedException -> 0x0066 }
            r2 = r2.f22581d;	 Catch:{ InterruptedException -> 0x0066 }
            r1 = r1 + r2;	 Catch:{ InterruptedException -> 0x0066 }
            r2 = r4.f22577a;	 Catch:{ InterruptedException -> 0x0066 }
            r2 = r2.f22580c;	 Catch:{ InterruptedException -> 0x0066 }
            if (r1 >= r2) goto L_0x0044;	 Catch:{ InterruptedException -> 0x0066 }
        L_0x002c:
            r2 = r4.f22577a;	 Catch:{ InterruptedException -> 0x0066 }
            r2 = r2.f22578a;	 Catch:{ InterruptedException -> 0x0066 }
            if (r2 == 0) goto L_0x0055;	 Catch:{ InterruptedException -> 0x0066 }
        L_0x0034:
            r2 = r4.f22577a;	 Catch:{ InterruptedException -> 0x0066 }
            r2 = r2.f22578a;	 Catch:{ InterruptedException -> 0x0066 }
            r3 = r4.f22577a;	 Catch:{ InterruptedException -> 0x0066 }
            r3 = r3.f22580c;	 Catch:{ InterruptedException -> 0x0066 }
            r2.mo5222a(r3, r1);	 Catch:{ InterruptedException -> 0x0066 }
            goto L_0x0055;	 Catch:{ InterruptedException -> 0x0066 }
        L_0x0044:
            r2 = r4.f22577a;	 Catch:{ InterruptedException -> 0x0066 }
            r2 = r2.f22578a;	 Catch:{ InterruptedException -> 0x0066 }
            if (r2 == 0) goto L_0x0055;	 Catch:{ InterruptedException -> 0x0066 }
        L_0x004c:
            r2 = r4.f22577a;	 Catch:{ InterruptedException -> 0x0066 }
            r2 = r2.f22578a;	 Catch:{ InterruptedException -> 0x0066 }
            r2.mo5225d();	 Catch:{ InterruptedException -> 0x0066 }
        L_0x0055:
            r2 = r4.f22577a;	 Catch:{ InterruptedException -> 0x0066 }
            r2 = r2.f22580c;	 Catch:{ InterruptedException -> 0x0066 }
            if (r1 < r2) goto L_0x0013;	 Catch:{ InterruptedException -> 0x0066 }
        L_0x005d:
            r1 = r4.f22577a;	 Catch:{ InterruptedException -> 0x0066 }
            r1 = r1.f22579b;	 Catch:{ InterruptedException -> 0x0066 }
            if (r1 == 0) goto L_0x0066;
        L_0x0065:
            goto L_0x0012;
        L_0x0066:
            r0 = r4.f22577a;
            r0 = r0.f22578a;
            if (r0 == 0) goto L_0x0089;
        L_0x006e:
            r0 = r4.f22577a;
            r0 = r0.f22583f;
            if (r0 == 0) goto L_0x0080;
        L_0x0076:
            r0 = r4.f22577a;
            r0 = r0.f22578a;
            r0.mo5224c();
            return;
        L_0x0080:
            r0 = r4.f22577a;
            r0 = r0.f22578a;
            r0.mo5223b();
        L_0x0089:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.CountDownTimer.1.run():void");
        }
    }

    public interface CountDownTimerEventHandler {
        void mo5221a();

        void mo5222a(int i, int i2);

        void mo5223b();

        void mo5224c();

        void mo5225d();
    }

    public CountDownTimer() {
        this(5000, 100);
    }

    public CountDownTimer(int i, int i2) {
        this(i, i2, false);
    }

    public CountDownTimer(int i, int i2, boolean z) {
        this.f22580c = i;
        this.f22581d = i2;
        this.f22579b = z;
    }

    public final synchronized void m24907a() {
        m24908b();
        this.f22582e = new C19601(this);
        this.f22582e.start();
    }

    public final synchronized void m24908b() {
        if (this.f22582e != null) {
            this.f22582e.interrupt();
            this.f22582e = null;
        }
    }

    public final synchronized void m24909c() {
        this.f22583f = true;
        m24908b();
    }
}
