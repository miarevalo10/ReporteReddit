package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.zzp;
import java.io.File;

@TargetApi(17)
public class zzahz extends zzaib {
    public final android.graphics.drawable.Drawable mo4387a(android.content.Context r4, android.graphics.Bitmap r5, boolean r6, float r7) {
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
        if (r6 == 0) goto L_0x0053;
    L_0x0002:
        r6 = 0;
        r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1));
        if (r6 <= 0) goto L_0x0053;
    L_0x0007:
        r6 = 1103626240; // 0x41c80000 float:25.0 double:5.45263811E-315;
        r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1));
        if (r6 <= 0) goto L_0x000e;
    L_0x000d:
        goto L_0x0053;
    L_0x000e:
        r6 = r5.getWidth();	 Catch:{ RuntimeException -> 0x0049 }
        r0 = r5.getHeight();	 Catch:{ RuntimeException -> 0x0049 }
        r1 = 0;	 Catch:{ RuntimeException -> 0x0049 }
        r6 = android.graphics.Bitmap.createScaledBitmap(r5, r6, r0, r1);	 Catch:{ RuntimeException -> 0x0049 }
        r0 = android.graphics.Bitmap.createBitmap(r6);	 Catch:{ RuntimeException -> 0x0049 }
        r1 = android.renderscript.RenderScript.create(r4);	 Catch:{ RuntimeException -> 0x0049 }
        r2 = android.renderscript.Element.U8_4(r1);	 Catch:{ RuntimeException -> 0x0049 }
        r2 = android.renderscript.ScriptIntrinsicBlur.create(r1, r2);	 Catch:{ RuntimeException -> 0x0049 }
        r6 = android.renderscript.Allocation.createFromBitmap(r1, r6);	 Catch:{ RuntimeException -> 0x0049 }
        r1 = android.renderscript.Allocation.createFromBitmap(r1, r0);	 Catch:{ RuntimeException -> 0x0049 }
        r2.setRadius(r7);	 Catch:{ RuntimeException -> 0x0049 }
        r2.setInput(r6);	 Catch:{ RuntimeException -> 0x0049 }
        r2.forEach(r1);	 Catch:{ RuntimeException -> 0x0049 }
        r1.copyTo(r0);	 Catch:{ RuntimeException -> 0x0049 }
        r6 = new android.graphics.drawable.BitmapDrawable;	 Catch:{ RuntimeException -> 0x0049 }
        r7 = r4.getResources();	 Catch:{ RuntimeException -> 0x0049 }
        r6.<init>(r7, r0);	 Catch:{ RuntimeException -> 0x0049 }
        return r6;
    L_0x0049:
        r6 = new android.graphics.drawable.BitmapDrawable;
        r4 = r4.getResources();
        r6.<init>(r4, r5);
        return r6;
    L_0x0053:
        r6 = new android.graphics.drawable.BitmapDrawable;
        r4 = r4.getResources();
        r6.<init>(r4, r5);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzahz.a(android.content.Context, android.graphics.Bitmap, boolean, float):android.graphics.drawable.Drawable");
    }

    public final String mo4388a(Context context) {
        zzajl a = zzajl.m5304a();
        if (TextUtils.isEmpty(a.f6454a)) {
            a.f6454a = (String) zzajk.m5302a(context, new zzajm(zzp.getRemoteContext(context), context));
        }
        return a.f6454a;
    }

    public final boolean mo3438a(Context context, WebSettings webSettings) {
        super.mo3438a(context, webSettings);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        return true;
    }

    public final void mo4389b(Context context) {
        zzajl a = zzajl.m5304a();
        zzagf.m13278a("Updating user agent.");
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        if (!defaultUserAgent.equals(a.f6454a)) {
            Context remoteContext = zzp.getRemoteContext(context);
            if (remoteContext == null) {
                Editor putString = context.getSharedPreferences("admob_user_agent", 0).edit().putString("user_agent", WebSettings.getDefaultUserAgent(context));
                if (remoteContext == null) {
                    putString.apply();
                } else {
                    String str = "admob_user_agent";
                    File file = new File(context.getApplicationInfo().dataDir, "shared_prefs");
                    File parentFile = file.getParentFile();
                    if (parentFile != null) {
                        parentFile.setExecutable(true, false);
                    }
                    file.setExecutable(true, false);
                    putString.commit();
                    new File(file, String.valueOf(str).concat(".xml")).setReadable(true, false);
                }
            }
            a.f6454a = defaultUserAgent;
        }
        zzagf.m13278a("User agent is updated.");
        zzbs.m4490i().m13271s();
    }
}
