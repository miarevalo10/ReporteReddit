package com.cookpad.puree.outputs;

import com.cookpad.puree.async.AsyncFlushTask;
import com.cookpad.puree.async.AsyncInsertTask;
import com.cookpad.puree.async.AsyncResult;
import com.cookpad.puree.retryable.RetryableTaskRunner;
import com.cookpad.puree.storage.PureeStorage;
import com.cookpad.puree.storage.Record;
import com.cookpad.puree.storage.Records;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class PureeBufferedOutput extends PureeOutput {
    private RetryableTaskRunner f12675d;

    class C02821 implements Runnable {
        final /* synthetic */ PureeBufferedOutput f3700a;

        C02821(PureeBufferedOutput pureeBufferedOutput) {
            this.f3700a = pureeBufferedOutput;
        }

        public void run() {
            this.f3700a.mo1032a();
        }
    }

    public abstract void m11745a(JSONArray jSONArray, AsyncResult asyncResult);

    public final void mo1035b(JSONObject jSONObject) {
    }

    public final void mo1033a(PureeStorage pureeStorage) {
        super.mo1033a(pureeStorage);
        this.f12675d = new RetryableTaskRunner(new C02821(this), this.a.f3697a, this.a.f3699c);
    }

    public final void mo1034a(JSONObject jSONObject) {
        new AsyncInsertTask(this, m3265c(), jSONObject).execute(new Void[null]);
        this.f12675d.m3268a();
    }

    public final void m11744a(java.lang.String r2, org.json.JSONObject r3) {
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
        r1 = this;
        r3 = r1.m3266c(r3);	 Catch:{ JSONException -> 0x000a }
        r0 = r1.b;	 Catch:{ JSONException -> 0x000a }
        r0.mo1039a(r2, r3);	 Catch:{ JSONException -> 0x000a }
        return;
    L_0x000a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cookpad.puree.outputs.PureeBufferedOutput.a(java.lang.String, org.json.JSONObject):void");
    }

    public final void mo1032a() {
        new AsyncFlushTask(this).execute(new Void[0]);
    }

    public final void m11747b() {
        Records d = m11741d();
        if (!d.isEmpty()) {
            while (!d.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = d.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((Record) it.next()).f3714b);
                }
                if (m11740a(jSONArray)) {
                    this.f12675d.m3269b();
                    this.b.mo1038a(d);
                    d = m11741d();
                } else {
                    this.f12675d.m3270c();
                    return;
                }
            }
        }
    }

    private Records m11741d() {
        return this.b.mo1036a(m3265c(), this.a.f3698b);
    }

    private boolean m11740a(org.json.JSONArray r4) {
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
        r0 = new com.cookpad.puree.async.AsyncResult;	 Catch:{ InterruptedException -> 0x0012 }
        r0.<init>();	 Catch:{ InterruptedException -> 0x0012 }
        r3.m11745a(r4, r0);	 Catch:{ InterruptedException -> 0x0012 }
        r1 = 1;	 Catch:{ InterruptedException -> 0x0012 }
        r4 = java.util.concurrent.TimeUnit.MINUTES;	 Catch:{ InterruptedException -> 0x0012 }
        r0.await(r1, r4);	 Catch:{ InterruptedException -> 0x0012 }
        r4 = r0.f3696a;	 Catch:{ InterruptedException -> 0x0012 }
        return r4;
    L_0x0012:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cookpad.puree.outputs.PureeBufferedOutput.a(org.json.JSONArray):boolean");
    }
}
