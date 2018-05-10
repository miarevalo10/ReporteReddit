package com.instabug.library.internal.media;

import android.media.MediaRecorder;
import com.instabug.library.util.InstabugSDKLogger;

/* compiled from: AudioRecorder */
public class C0679a {
    private final String f9610a;
    private MediaRecorder f9611b = null;

    public C0679a(String str) {
        this.f9610a = str;
    }

    public final void m8188a() {
        this.f9611b = new MediaRecorder();
        this.f9611b.setAudioSource(1);
        this.f9611b.setOutputFormat(2);
        this.f9611b.setOutputFile(this.f9610a);
        this.f9611b.setAudioEncoder(3);
        try {
            this.f9611b.prepare();
            this.f9611b.start();
        } catch (Throwable e) {
            InstabugSDKLogger.m8358e(this, "Recording audio failed", e);
        }
    }

    public final void m8189b() {
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
        r3 = this;
        r0 = r3.f9611b;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = 0;
        r1 = r3.f9611b;	 Catch:{ RuntimeException -> 0x0010, all -> 0x0018 }
        r1.stop();	 Catch:{ RuntimeException -> 0x0010, all -> 0x0018 }
        r1 = r3.f9611b;	 Catch:{ RuntimeException -> 0x0010, all -> 0x0018 }
        r1.reset();	 Catch:{ RuntimeException -> 0x0010, all -> 0x0018 }
    L_0x0010:
        r1 = r3.f9611b;
        r1.release();
        r3.f9611b = r0;
        return;
    L_0x0018:
        r1 = move-exception;
        r2 = r3.f9611b;
        r2.release();
        r3.f9611b = r0;
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.media.a.b():void");
    }
}
