package io.branch.referral;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import io.branch.referral.Branch.BranchReferralInitListener;
import io.branch.referral.Defines.RequestPath;
import java.util.List;

class ServerRequestQueue {
    private static ServerRequestQueue f24660b;
    final List<ServerRequest> f24661a;
    private SharedPreferences f24662c;
    private Editor f24663d = this.f24662c.edit();

    class C21111 implements Runnable {
        final /* synthetic */ ServerRequestQueue f24659a;

        C21111(ServerRequestQueue serverRequestQueue) {
            this.f24659a = serverRequestQueue;
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
            r6 = this;
            r0 = r6.f24659a;
            r0 = r0.f24661a;
            monitor-enter(r0);
            r1 = new org.json.JSONArray;	 Catch:{ all -> 0x0083 }
            r1.<init>();	 Catch:{ all -> 0x0083 }
            r2 = r6.f24659a;	 Catch:{ all -> 0x0083 }
            r2 = r2.f24661a;	 Catch:{ all -> 0x0083 }
            r2 = r2.iterator();	 Catch:{ all -> 0x0083 }
        L_0x0016:
            r3 = r2.hasNext();	 Catch:{ all -> 0x0083 }
            if (r3 == 0) goto L_0x002c;	 Catch:{ all -> 0x0083 }
        L_0x001c:
            r3 = r2.next();	 Catch:{ all -> 0x0083 }
            r3 = (io.branch.referral.ServerRequest) r3;	 Catch:{ all -> 0x0083 }
            r3 = r3.toJSON();	 Catch:{ all -> 0x0083 }
            if (r3 == 0) goto L_0x0016;	 Catch:{ all -> 0x0083 }
        L_0x0028:
            r1.put(r3);	 Catch:{ all -> 0x0083 }
            goto L_0x0016;
        L_0x002c:
            r2 = r6.f24659a;	 Catch:{ ConcurrentModificationException -> 0x0042 }
            r2 = r2.f24663d;	 Catch:{ ConcurrentModificationException -> 0x0042 }
            r3 = "BNCServerRequestQueue";	 Catch:{ ConcurrentModificationException -> 0x0042 }
            r4 = r1.toString();	 Catch:{ ConcurrentModificationException -> 0x0042 }
            r2 = r2.putString(r3, r4);	 Catch:{ ConcurrentModificationException -> 0x0042 }
            r2.commit();	 Catch:{ ConcurrentModificationException -> 0x0042 }
            goto L_0x006d;
        L_0x0040:
            r2 = move-exception;
            goto L_0x006f;
        L_0x0042:
            r2 = move-exception;
            r3 = "Persisting Queue: ";	 Catch:{ all -> 0x0040 }
            r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0040 }
            r5 = "Failed to persit queue ";	 Catch:{ all -> 0x0040 }
            r4.<init>(r5);	 Catch:{ all -> 0x0040 }
            r2 = r2.getMessage();	 Catch:{ all -> 0x0040 }
            r4.append(r2);	 Catch:{ all -> 0x0040 }
            r2 = r4.toString();	 Catch:{ all -> 0x0040 }
            io.branch.referral.PrefHelper.m26161b(r3, r2);	 Catch:{ all -> 0x0040 }
            r2 = r6.f24659a;	 Catch:{ ConcurrentModificationException -> 0x006d }
            r2 = r2.f24663d;	 Catch:{ ConcurrentModificationException -> 0x006d }
            r3 = "BNCServerRequestQueue";	 Catch:{ ConcurrentModificationException -> 0x006d }
            r1 = r1.toString();	 Catch:{ ConcurrentModificationException -> 0x006d }
            r1 = r2.putString(r3, r1);	 Catch:{ ConcurrentModificationException -> 0x006d }
            r1.commit();	 Catch:{ ConcurrentModificationException -> 0x006d }
        L_0x006d:
            monitor-exit(r0);	 Catch:{ all -> 0x0083 }
            return;
        L_0x006f:
            r3 = r6.f24659a;	 Catch:{ ConcurrentModificationException -> 0x0082 }
            r3 = r3.f24663d;	 Catch:{ ConcurrentModificationException -> 0x0082 }
            r4 = "BNCServerRequestQueue";	 Catch:{ ConcurrentModificationException -> 0x0082 }
            r1 = r1.toString();	 Catch:{ ConcurrentModificationException -> 0x0082 }
            r1 = r3.putString(r4, r1);	 Catch:{ ConcurrentModificationException -> 0x0082 }
            r1.commit();	 Catch:{ ConcurrentModificationException -> 0x0082 }
        L_0x0082:
            throw r2;	 Catch:{ all -> 0x0083 }
        L_0x0083:
            r1 = move-exception;	 Catch:{ all -> 0x0083 }
            monitor-exit(r0);	 Catch:{ all -> 0x0083 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ServerRequestQueue.1.run():void");
        }
    }

    public static ServerRequestQueue m26182a(Context context) {
        if (f24660b == null) {
            synchronized (ServerRequestQueue.class) {
                if (f24660b == null) {
                    f24660b = new ServerRequestQueue(context);
                }
            }
        }
        return f24660b;
    }

    @SuppressLint({"CommitPrefEdits"})
    private ServerRequestQueue(Context context) {
        this.f24662c = context.getSharedPreferences("BNC_Server_Request_Queue", 0);
        this.f24661a = m26185b(context);
    }

    final void m26187a() {
        new Thread(new C21111(this)).start();
    }

    private java.util.List<io.branch.referral.ServerRequest> m26185b(android.content.Context r6) {
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
        r5 = this;
        r0 = new java.util.LinkedList;
        r0.<init>();
        r0 = java.util.Collections.synchronizedList(r0);
        r1 = r5.f24662c;
        r2 = "BNCServerRequestQueue";
        r3 = 0;
        r1 = r1.getString(r2, r3);
        if (r1 == 0) goto L_0x003e;
    L_0x0014:
        r2 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x003e }
        r2.<init>(r1);	 Catch:{ JSONException -> 0x003e }
        r1 = 0;	 Catch:{ JSONException -> 0x003e }
    L_0x001a:
        r3 = r2.length();	 Catch:{ JSONException -> 0x003e }
        r4 = 25;	 Catch:{ JSONException -> 0x003e }
        r3 = java.lang.Math.min(r3, r4);	 Catch:{ JSONException -> 0x003e }
        if (r1 >= r3) goto L_0x003e;	 Catch:{ JSONException -> 0x003e }
    L_0x0026:
        r3 = r2.getJSONObject(r1);	 Catch:{ JSONException -> 0x003e }
        r3 = io.branch.referral.ServerRequest.fromJSON(r3, r6);	 Catch:{ JSONException -> 0x003e }
        if (r3 == 0) goto L_0x003b;	 Catch:{ JSONException -> 0x003e }
    L_0x0030:
        r4 = r3 instanceof io.branch.referral.ServerRequestRegisterClose;	 Catch:{ JSONException -> 0x003e }
        if (r4 != 0) goto L_0x003b;	 Catch:{ JSONException -> 0x003e }
    L_0x0034:
        r4 = r3 instanceof io.branch.referral.ServerRequestLogout;	 Catch:{ JSONException -> 0x003e }
        if (r4 != 0) goto L_0x003b;	 Catch:{ JSONException -> 0x003e }
    L_0x0038:
        r0.add(r3);	 Catch:{ JSONException -> 0x003e }
    L_0x003b:
        r1 = r1 + 1;
        goto L_0x001a;
    L_0x003e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ServerRequestQueue.b(android.content.Context):java.util.List<io.branch.referral.ServerRequest>");
    }

    public final int m26192b() {
        return this.f24661a.size();
    }

    public final io.branch.referral.ServerRequest m26193c() {
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
        r0 = r2.f24661a;	 Catch:{ IndexOutOfBoundsException -> 0x000d, IndexOutOfBoundsException -> 0x000d }
        r1 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x000d, IndexOutOfBoundsException -> 0x000d }
        r0 = r0.remove(r1);	 Catch:{ IndexOutOfBoundsException -> 0x000d, IndexOutOfBoundsException -> 0x000d }
        r0 = (io.branch.referral.ServerRequest) r0;	 Catch:{ IndexOutOfBoundsException -> 0x000d, IndexOutOfBoundsException -> 0x000d }
        r2.m26187a();	 Catch:{ IndexOutOfBoundsException -> 0x000e, IndexOutOfBoundsException -> 0x000e }
        goto L_0x000e;
    L_0x000d:
        r0 = 0;
    L_0x000e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ServerRequestQueue.c():io.branch.referral.ServerRequest");
    }

    public final io.branch.referral.ServerRequest m26194d() {
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
        r0 = r2.f24661a;	 Catch:{ IndexOutOfBoundsException -> 0x000a, IndexOutOfBoundsException -> 0x000a }
        r1 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x000a, IndexOutOfBoundsException -> 0x000a }
        r0 = r0.get(r1);	 Catch:{ IndexOutOfBoundsException -> 0x000a, IndexOutOfBoundsException -> 0x000a }
        r0 = (io.branch.referral.ServerRequest) r0;	 Catch:{ IndexOutOfBoundsException -> 0x000a, IndexOutOfBoundsException -> 0x000a }
        goto L_0x000b;
    L_0x000a:
        r0 = 0;
    L_0x000b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ServerRequestQueue.d():io.branch.referral.ServerRequest");
    }

    public final io.branch.referral.ServerRequest m26186a(int r2) {
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
        r1 = this;
        r0 = r1.f24661a;	 Catch:{ IndexOutOfBoundsException -> 0x0009, IndexOutOfBoundsException -> 0x0009 }
        r2 = r0.get(r2);	 Catch:{ IndexOutOfBoundsException -> 0x0009, IndexOutOfBoundsException -> 0x0009 }
        r2 = (io.branch.referral.ServerRequest) r2;	 Catch:{ IndexOutOfBoundsException -> 0x0009, IndexOutOfBoundsException -> 0x0009 }
        goto L_0x000a;
    L_0x0009:
        r2 = 0;
    L_0x000a:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ServerRequestQueue.a(int):io.branch.referral.ServerRequest");
    }

    public final void m26190a(io.branch.referral.ServerRequest r2, int r3) {
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
        r1 = this;
        r0 = r1.f24661a;	 Catch:{ IndexOutOfBoundsException -> 0x0017 }
        r0 = r0.size();	 Catch:{ IndexOutOfBoundsException -> 0x0017 }
        if (r0 >= r3) goto L_0x000e;	 Catch:{ IndexOutOfBoundsException -> 0x0017 }
    L_0x0008:
        r3 = r1.f24661a;	 Catch:{ IndexOutOfBoundsException -> 0x0017 }
        r3 = r3.size();	 Catch:{ IndexOutOfBoundsException -> 0x0017 }
    L_0x000e:
        r0 = r1.f24661a;	 Catch:{ IndexOutOfBoundsException -> 0x0017 }
        r0.add(r3, r2);	 Catch:{ IndexOutOfBoundsException -> 0x0017 }
        r1.m26187a();	 Catch:{ IndexOutOfBoundsException -> 0x0017 }
        return;
    L_0x0017:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ServerRequestQueue.a(io.branch.referral.ServerRequest, int):void");
    }

    public final boolean m26191a(io.branch.referral.ServerRequest r2) {
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
        r1 = this;
        r0 = r1.f24661a;	 Catch:{ UnsupportedOperationException -> 0x000a }
        r2 = r0.remove(r2);	 Catch:{ UnsupportedOperationException -> 0x000a }
        r1.m26187a();	 Catch:{ UnsupportedOperationException -> 0x000b }
        goto L_0x000b;
    L_0x000a:
        r2 = 0;
    L_0x000b:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ServerRequestQueue.a(io.branch.referral.ServerRequest):boolean");
    }

    public final void m26195e() {
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
        r1 = this;
        r0 = r1.f24661a;	 Catch:{ UnsupportedOperationException -> 0x0009 }
        r0.clear();	 Catch:{ UnsupportedOperationException -> 0x0009 }
        r1.m26187a();	 Catch:{ UnsupportedOperationException -> 0x0009 }
        return;
    L_0x0009:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ServerRequestQueue.e():void");
    }

    public final boolean m26196f() {
        synchronized (this.f24661a) {
            for (ServerRequest serverRequest : this.f24661a) {
                if (serverRequest != null && serverRequest.getRequestPath().equals(RequestPath.RegisterClose.f24623l)) {
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean m26197g() {
        synchronized (this.f24661a) {
            for (ServerRequest serverRequest : this.f24661a) {
                if (serverRequest != null && ((serverRequest instanceof ServerRequestRegisterInstall) || (serverRequest instanceof ServerRequestRegisterOpen))) {
                    return true;
                }
            }
            return false;
        }
    }

    public final void m26188a(BranchReferralInitListener branchReferralInitListener) {
        synchronized (this.f24661a) {
            for (ServerRequest serverRequest : this.f24661a) {
                if (serverRequest != null) {
                    if (serverRequest instanceof ServerRequestRegisterInstall) {
                        ServerRequestRegisterInstall serverRequestRegisterInstall = (ServerRequestRegisterInstall) serverRequest;
                        if (branchReferralInitListener != null) {
                            serverRequestRegisterInstall.f34671a = branchReferralInitListener;
                        }
                    } else if (serverRequest instanceof ServerRequestRegisterOpen) {
                        ServerRequestRegisterOpen serverRequestRegisterOpen = (ServerRequestRegisterOpen) serverRequest;
                        if (branchReferralInitListener != null) {
                            serverRequestRegisterOpen.f34673a = branchReferralInitListener;
                        }
                    }
                }
            }
        }
    }

    public final void m26189a(PROCESS_WAIT_LOCK process_wait_lock) {
        synchronized (this.f24661a) {
            for (ServerRequest serverRequest : this.f24661a) {
                if (serverRequest != null) {
                    serverRequest.removeProcessWaitLock(process_wait_lock);
                }
            }
        }
    }
}
