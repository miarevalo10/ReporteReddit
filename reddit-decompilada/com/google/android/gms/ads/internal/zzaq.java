package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzol;
import com.google.android.gms.internal.zzpq;
import com.google.android.gms.internal.zzpr;
import com.google.android.gms.internal.zzuo;
import com.google.android.gms.internal.zzvj;
import com.google.android.gms.internal.zzvm;
import com.google.android.gms.internal.zzzv;
import com.instabug.chat.model.Attachment;
import com.instabug.library.model.NetworkLog;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

@zzzv
public final class zzaq {
    public static View m4459a(zzafo com_google_android_gms_internal_zzafo) {
        if (com_google_android_gms_internal_zzafo == null) {
            zzakb.m5368c("AdState is null");
            return null;
        } else if (!m4468b(com_google_android_gms_internal_zzafo) || com_google_android_gms_internal_zzafo.f6289b == null) {
            try {
                IObjectWrapper a = com_google_android_gms_internal_zzafo.f6302o != null ? com_google_android_gms_internal_zzafo.f6302o.mo2170a() : null;
                if (a != null) {
                    return (View) zzn.m17693a(a);
                }
                zzakb.m5371e("View in mediation adapter is null.");
                return null;
            } catch (Throwable e) {
                zzakb.m5369c("Could not get View from mediation adapter.", e);
                return null;
            }
        } else {
            zzanh com_google_android_gms_internal_zzanh = com_google_android_gms_internal_zzafo.f6289b;
            if (com_google_android_gms_internal_zzanh != null) {
                return (View) com_google_android_gms_internal_zzanh;
            }
            throw null;
        }
    }

    static zzt<zzanh> m4460a(zzvj com_google_android_gms_internal_zzvj, zzvm com_google_android_gms_internal_zzvm, zzab com_google_android_gms_ads_internal_zzab) {
        return new zzav(com_google_android_gms_internal_zzvj, com_google_android_gms_ads_internal_zzab, com_google_android_gms_internal_zzvm);
    }

    private static String m4462a(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap == null) {
            zzakb.m5371e("Bitmap is null. Returning empty string");
            return "";
        }
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        String valueOf = String.valueOf("data:image/png;base64,");
        encodeToString = String.valueOf(encodeToString);
        return encodeToString.length() != 0 ? valueOf.concat(encodeToString) : new String(valueOf);
    }

    static java.lang.String m4463a(com.google.android.gms.internal.zzpq r1) {
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
        if (r1 != 0) goto L_0x000a;
    L_0x0002:
        r1 = "Image is null. Returning empty string";
        com.google.android.gms.internal.zzakb.m5371e(r1);
        r1 = "";
        return r1;
    L_0x000a:
        r0 = r1.mo2092b();	 Catch:{ RemoteException -> 0x0015 }
        if (r0 == 0) goto L_0x001a;	 Catch:{ RemoteException -> 0x0015 }
    L_0x0010:
        r0 = r0.toString();	 Catch:{ RemoteException -> 0x0015 }
        return r0;
    L_0x0015:
        r0 = "Unable to get image uri. Trying data uri next";
        com.google.android.gms.internal.zzakb.m5371e(r0);
    L_0x001a:
        r1 = m4467b(r1);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzaq.a(com.google.android.gms.internal.zzpq):java.lang.String");
    }

    private static java.lang.String m4467b(com.google.android.gms.internal.zzpq r1) {
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
        r1 = r1.mo2091a();	 Catch:{ RemoteException -> 0x002b }
        if (r1 != 0) goto L_0x000e;	 Catch:{ RemoteException -> 0x002b }
    L_0x0006:
        r1 = "Drawable is null. Returning empty string";	 Catch:{ RemoteException -> 0x002b }
        com.google.android.gms.internal.zzakb.m5371e(r1);	 Catch:{ RemoteException -> 0x002b }
        r1 = "";	 Catch:{ RemoteException -> 0x002b }
        return r1;	 Catch:{ RemoteException -> 0x002b }
    L_0x000e:
        r1 = com.google.android.gms.dynamic.zzn.m17693a(r1);	 Catch:{ RemoteException -> 0x002b }
        r1 = (android.graphics.drawable.Drawable) r1;	 Catch:{ RemoteException -> 0x002b }
        r0 = r1 instanceof android.graphics.drawable.BitmapDrawable;
        if (r0 != 0) goto L_0x0020;
    L_0x0018:
        r1 = "Drawable is not an instance of BitmapDrawable. Returning empty string";
        com.google.android.gms.internal.zzakb.m5371e(r1);
        r1 = "";
        return r1;
    L_0x0020:
        r1 = (android.graphics.drawable.BitmapDrawable) r1;
        r1 = r1.getBitmap();
        r1 = m4462a(r1);
        return r1;
    L_0x002b:
        r1 = "Unable to get drawable. Returning empty string";
        com.google.android.gms.internal.zzakb.m5371e(r1);
        r1 = "";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzaq.b(com.google.android.gms.internal.zzpq):java.lang.String");
    }

    public static boolean m4468b(zzafo com_google_android_gms_internal_zzafo) {
        return (com_google_android_gms_internal_zzafo == null || !com_google_android_gms_internal_zzafo.f6300m || com_google_android_gms_internal_zzafo.f6301n == null || com_google_android_gms_internal_zzafo.f6301n.f8058m == null) ? false : true;
    }

    public static boolean m4466a(zzanh com_google_android_gms_internal_zzanh, zzuo com_google_android_gms_internal_zzuo, CountDownLatch countDownLatch) {
        zzanh com_google_android_gms_internal_zzanh2 = com_google_android_gms_internal_zzanh;
        zzuo com_google_android_gms_internal_zzuo2 = com_google_android_gms_internal_zzuo;
        CountDownLatch countDownLatch2 = countDownLatch;
        View view = null;
        boolean z = false;
        if (com_google_android_gms_internal_zzanh2 == null) {
            try {
                throw null;
            } catch (Throwable e) {
                zzakb.m5369c("Unable to invoke load assets", e);
            } catch (RuntimeException e2) {
                RuntimeException runtimeException = e2;
                countDownLatch.countDown();
                throw runtimeException;
            }
        }
        String str;
        View view2 = (View) com_google_android_gms_internal_zzanh2;
        if (view2 == null) {
            str = "AdWebView is null";
        } else {
            view2.setVisibility(4);
            List list = com_google_android_gms_internal_zzuo2.f8087b.f8061p;
            if (list != null) {
                if (!list.isEmpty()) {
                    String str2;
                    com_google_android_gms_internal_zzanh.mo4019w().m5446a("/nativeExpressAssetsLoaded", new zzat(countDownLatch2));
                    com_google_android_gms_internal_zzanh.mo4019w().m5446a("/nativeExpressAssetsLoadingFailed", new zzau(countDownLatch2));
                    zzvj h = com_google_android_gms_internal_zzuo2.f8088c.mo2188h();
                    zzvm i = com_google_android_gms_internal_zzuo2.f8088c.mo2189i();
                    String e3;
                    if (list.contains("2") && h != null) {
                        String a = h.mo2208a();
                        List b = h.mo2210b();
                        String c = h.mo2212c();
                        zzpq d = h.mo2214d();
                        e3 = h.mo2215e();
                        double f = h.mo2216f();
                        String g = h.mo2217g();
                        String h2 = h.mo2218h();
                        Bundle l = h.mo2222l();
                        if (h.mo2226p() != null) {
                            view = (View) zzn.m17693a(h.mo2226p());
                        }
                        zzoj com_google_android_gms_internal_zzoj = new zzoj(a, b, c, d, e3, f, g, h2, null, l, null, view, h.mo2227q(), null);
                        str2 = com_google_android_gms_internal_zzuo2.f8087b.f8060o;
                        com_google_android_gms_internal_zzanh.mo4019w().f6617d = new zzar(com_google_android_gms_internal_zzoj, str2, com_google_android_gms_internal_zzanh2);
                    } else if (!list.contains("1") || i == null) {
                        zzakb.m5371e("No matching template id and mapper");
                        if (!z) {
                            countDownLatch.countDown();
                        }
                        return z;
                    } else {
                        String a2 = i.mo2228a();
                        List b2 = i.mo2230b();
                        String c2 = i.mo2232c();
                        zzpq d2 = i.mo2234d();
                        String e4 = i.mo2235e();
                        e3 = i.mo2236f();
                        Bundle j = i.mo2240j();
                        if (i.mo2244n() != null) {
                            view = (View) zzn.m17693a(i.mo2244n());
                        }
                        zzol com_google_android_gms_internal_zzol = new zzol(a2, b2, c2, d2, e4, e3, null, j, null, view, i.mo2245o(), null);
                        str2 = com_google_android_gms_internal_zzuo2.f8087b.f8060o;
                        com_google_android_gms_internal_zzanh.mo4019w().f6617d = new zzas(com_google_android_gms_internal_zzol, str2, com_google_android_gms_internal_zzanh2);
                    }
                    str2 = com_google_android_gms_internal_zzuo2.f8087b.f8058m;
                    String str3 = com_google_android_gms_internal_zzuo2.f8087b.f8059n;
                    if (str3 != null) {
                        com_google_android_gms_internal_zzanh2.loadDataWithBaseURL(str3, str2, NetworkLog.HTML, "UTF-8", null);
                    } else {
                        com_google_android_gms_internal_zzanh2.loadData(str2, NetworkLog.HTML, "UTF-8");
                    }
                    z = true;
                    if (z) {
                        countDownLatch.countDown();
                    }
                    return z;
                }
            }
            str = "No template ids present in mediation response";
        }
        zzakb.m5371e(str);
        if (z) {
            countDownLatch.countDown();
        }
        return z;
    }

    static /* synthetic */ zzpq m4461a(Object obj) {
        return obj instanceof IBinder ? zzpr.m14158a((IBinder) obj) : null;
    }

    static /* synthetic */ JSONObject m4464a(Bundle bundle, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (bundle != null) {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject2 = new JSONObject(str);
                str = jSONObject2.keys();
                while (str.hasNext()) {
                    String str2 = (String) str.next();
                    if (bundle.containsKey(str2)) {
                        Object obj;
                        if (Attachment.TYPE_IMAGE.equals(jSONObject2.getString(str2))) {
                            obj = bundle.get(str2);
                            if (obj instanceof Bitmap) {
                                obj = m4462a((Bitmap) obj);
                            } else {
                                str2 = "Invalid type. An image type extra should return a bitmap";
                                zzakb.m5371e(str2);
                            }
                        } else if (bundle.get(str2) instanceof Bitmap) {
                            str2 = "Invalid asset type. Bitmap should be returned only for image type";
                            zzakb.m5371e(str2);
                        } else {
                            obj = String.valueOf(bundle.get(str2));
                        }
                        jSONObject.put(str2, obj);
                    }
                }
            }
        }
        return jSONObject;
    }

    static /* synthetic */ void m4465a(zzanh com_google_android_gms_internal_zzanh) {
        OnClickListener I = com_google_android_gms_internal_zzanh.mo3972I();
        if (I == null) {
            return;
        }
        if (com_google_android_gms_internal_zzanh == null) {
            throw null;
        }
        I.onClick((View) com_google_android_gms_internal_zzanh);
    }
}
