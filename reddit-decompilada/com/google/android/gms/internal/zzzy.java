package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zziu.zza.zzb;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

@zzzv
public final class zzzy extends zzagb implements zzaal {
    final zzaau f18364a;
    final Context f18365b;
    zzaif f18366c;
    private final zzzx f18367d;
    private final Object f18368e = new Object();
    private final zzis f18369f;
    private final zzix f18370g;
    private zzaat f18371h;
    private Runnable f18372i;
    private zzaax f18373j;
    private zzui f18374k;

    public zzzy(Context context, zzaau com_google_android_gms_internal_zzaau, zzzx com_google_android_gms_internal_zzzx, zzix com_google_android_gms_internal_zzix) {
        zzis com_google_android_gms_internal_zzis;
        zzit com_google_android_gms_internal_zzit;
        this.f18367d = com_google_android_gms_internal_zzzx;
        this.f18365b = context;
        this.f18364a = com_google_android_gms_internal_zzaau;
        this.f18370g = com_google_android_gms_internal_zzix;
        this.f18369f = new zzis(this.f18370g, ((Boolean) zzkb.m6350f().m6488a(zznh.cJ)).booleanValue());
        this.f18369f.m6325a(new zzzz(this));
        zzjd com_google_android_gms_internal_zzjd = new zzjd();
        com_google_android_gms_internal_zzjd.f18129a = Integer.valueOf(this.f18364a.f6051j.f17552b);
        com_google_android_gms_internal_zzjd.f18130b = Integer.valueOf(this.f18364a.f6051j.f17553c);
        com_google_android_gms_internal_zzjd.f18131c = Integer.valueOf(this.f18364a.f6051j.f17554d ? 0 : 2);
        this.f18369f.m6325a(new zzaaa(com_google_android_gms_internal_zzjd));
        if (this.f18364a.f6047f != null) {
            this.f18369f.m6325a(new zzaab(this));
        }
        zzjn com_google_android_gms_internal_zzjn = this.f18364a.f6044c;
        if (com_google_android_gms_internal_zzjn.f18155d && "interstitial_mb".equals(com_google_android_gms_internal_zzjn.f18152a)) {
            com_google_android_gms_internal_zzis = this.f18369f;
            com_google_android_gms_internal_zzit = zzaac.f14022a;
        } else if (com_google_android_gms_internal_zzjn.f18155d && "reward_mb".equals(com_google_android_gms_internal_zzjn.f18152a)) {
            com_google_android_gms_internal_zzis = this.f18369f;
            com_google_android_gms_internal_zzit = zzaad.f14023a;
        } else if (com_google_android_gms_internal_zzjn.f18159h || com_google_android_gms_internal_zzjn.f18155d) {
            com_google_android_gms_internal_zzis = this.f18369f;
            com_google_android_gms_internal_zzit = zzaaf.f14025a;
        } else {
            com_google_android_gms_internal_zzis = this.f18369f;
            com_google_android_gms_internal_zzit = zzaae.f14024a;
        }
        com_google_android_gms_internal_zzis.m6325a(com_google_android_gms_internal_zzit);
        this.f18369f.m6326a(zzb.AD_REQUEST);
    }

    private final com.google.android.gms.internal.zzjn m19183a(com.google.android.gms.internal.zzaat r12) throws com.google.android.gms.internal.zzaai {
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
        r0 = r11.f18371h;
        r1 = 1;
        r2 = 0;
        if (r0 == 0) goto L_0x0018;
    L_0x0006:
        r0 = r11.f18371h;
        r0 = r0.f17389V;
        if (r0 == 0) goto L_0x0018;
    L_0x000c:
        r0 = r11.f18371h;
        r0 = r0.f17389V;
        r0 = r0.size();
        if (r0 <= r1) goto L_0x0018;
    L_0x0016:
        r0 = r1;
        goto L_0x0019;
    L_0x0018:
        r0 = r2;
    L_0x0019:
        if (r0 == 0) goto L_0x0027;
    L_0x001b:
        r0 = r11.f18374k;
        if (r0 == 0) goto L_0x0027;
    L_0x001f:
        r0 = r11.f18374k;
        r0 = r0.f8083s;
        if (r0 != 0) goto L_0x0027;
    L_0x0025:
        r12 = 0;
        return r12;
    L_0x0027:
        r0 = r11.f18373j;
        r0 = r0.f17465y;
        if (r0 == 0) goto L_0x0048;
    L_0x002d:
        r0 = r12.f17397d;
        r0 = r0.f18158g;
        r3 = r0.length;
        r4 = r2;
    L_0x0033:
        if (r4 >= r3) goto L_0x0048;
    L_0x0035:
        r5 = r0[r4];
        r6 = r5.f18160i;
        if (r6 == 0) goto L_0x0045;
    L_0x003b:
        r0 = new com.google.android.gms.internal.zzjn;
        r12 = r12.f17397d;
        r12 = r12.f18158g;
        r0.<init>(r5, r12);
        return r0;
    L_0x0045:
        r4 = r4 + 1;
        goto L_0x0033;
    L_0x0048:
        r0 = r11.f18373j;
        r0 = r0.f17452l;
        if (r0 != 0) goto L_0x0056;
    L_0x004e:
        r12 = new com.google.android.gms.internal.zzaai;
        r0 = "The ad response must specify one of the supported ad sizes.";
        r12.<init>(r0, r2);
        throw r12;
    L_0x0056:
        r0 = r11.f18373j;
        r0 = r0.f17452l;
        r3 = "x";
        r0 = r0.split(r3);
        r3 = r0.length;
        r4 = 2;
        if (r3 == r4) goto L_0x0085;
    L_0x0064:
        r12 = new com.google.android.gms.internal.zzaai;
        r0 = "Invalid ad size format from the ad response: ";
        r1 = r11.f18373j;
        r1 = r1.f17452l;
        r1 = java.lang.String.valueOf(r1);
        r3 = r1.length();
        if (r3 == 0) goto L_0x007b;
    L_0x0076:
        r0 = r0.concat(r1);
        goto L_0x0081;
    L_0x007b:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1;
    L_0x0081:
        r12.<init>(r0, r2);
        throw r12;
    L_0x0085:
        r3 = r0[r2];	 Catch:{ NumberFormatException -> 0x00f7 }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ NumberFormatException -> 0x00f7 }
        r0 = r0[r1];	 Catch:{ NumberFormatException -> 0x00f7 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x00f7 }
        r1 = r12.f17397d;
        r1 = r1.f18158g;
        r4 = r1.length;
        r5 = r2;
    L_0x0097:
        if (r5 >= r4) goto L_0x00d6;
    L_0x0099:
        r6 = r1[r5];
        r7 = r11.f18365b;
        r7 = r7.getResources();
        r7 = r7.getDisplayMetrics();
        r7 = r7.density;
        r8 = r6.f18156e;
        r9 = -1;
        if (r8 != r9) goto L_0x00b2;
    L_0x00ac:
        r8 = r6.f18157f;
        r8 = (float) r8;
        r8 = r8 / r7;
        r8 = (int) r8;
        goto L_0x00b4;
    L_0x00b2:
        r8 = r6.f18156e;
    L_0x00b4:
        r9 = r6.f18153b;
        r10 = -2;
        if (r9 != r10) goto L_0x00bf;
    L_0x00b9:
        r9 = r6.f18154c;
        r9 = (float) r9;
        r9 = r9 / r7;
        r7 = (int) r9;
        goto L_0x00c1;
    L_0x00bf:
        r7 = r6.f18153b;
    L_0x00c1:
        if (r3 != r8) goto L_0x00d3;
    L_0x00c3:
        if (r0 != r7) goto L_0x00d3;
    L_0x00c5:
        r7 = r6.f18160i;
        if (r7 != 0) goto L_0x00d3;
    L_0x00c9:
        r0 = new com.google.android.gms.internal.zzjn;
        r12 = r12.f17397d;
        r12 = r12.f18158g;
        r0.<init>(r6, r12);
        return r0;
    L_0x00d3:
        r5 = r5 + 1;
        goto L_0x0097;
    L_0x00d6:
        r12 = new com.google.android.gms.internal.zzaai;
        r0 = "The ad size from the ad response was not one of the requested sizes: ";
        r1 = r11.f18373j;
        r1 = r1.f17452l;
        r1 = java.lang.String.valueOf(r1);
        r3 = r1.length();
        if (r3 == 0) goto L_0x00ed;
    L_0x00e8:
        r0 = r0.concat(r1);
        goto L_0x00f3;
    L_0x00ed:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1;
    L_0x00f3:
        r12.<init>(r0, r2);
        throw r12;
    L_0x00f7:
        r12 = new com.google.android.gms.internal.zzaai;
        r0 = "Invalid ad size number from the ad response: ";
        r1 = r11.f18373j;
        r1 = r1.f17452l;
        r1 = java.lang.String.valueOf(r1);
        r3 = r1.length();
        if (r3 == 0) goto L_0x010e;
    L_0x0109:
        r0 = r0.concat(r1);
        goto L_0x0114;
    L_0x010e:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1;
    L_0x0114:
        r12.<init>(r0, r2);
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzzy.a(com.google.android.gms.internal.zzaat):com.google.android.gms.internal.zzjn");
    }

    private final void m19185a(int i, String str) {
        zzaat com_google_android_gms_internal_zzaat;
        zzzy com_google_android_gms_internal_zzzy = this;
        int i2 = i;
        if (i2 != 3) {
            if (i2 != -1) {
                zzakb.m5371e(str);
                com_google_android_gms_internal_zzzy.f18373j = com_google_android_gms_internal_zzzy.f18373j != null ? new zzaax(i2) : new zzaax(i2, com_google_android_gms_internal_zzzy.f18373j.f17450j);
                if (com_google_android_gms_internal_zzzy.f18371h == null) {
                    com_google_android_gms_internal_zzaat = com_google_android_gms_internal_zzzy.f18371h;
                } else {
                    zzaat com_google_android_gms_internal_zzaat2 = new zzaat(com_google_android_gms_internal_zzzy.f18364a, -1, null, null, null);
                }
                com_google_android_gms_internal_zzzy.f18367d.mo3386a(new zzafp(com_google_android_gms_internal_zzaat, com_google_android_gms_internal_zzzy.f18373j, com_google_android_gms_internal_zzzy.f18374k, null, i2, -1, com_google_android_gms_internal_zzzy.f18373j.f17453m, null, com_google_android_gms_internal_zzzy.f18369f, null));
            }
        }
        zzakb.m5370d(str);
        if (com_google_android_gms_internal_zzzy.f18373j != null) {
        }
        com_google_android_gms_internal_zzzy.f18373j = com_google_android_gms_internal_zzzy.f18373j != null ? new zzaax(i2) : new zzaax(i2, com_google_android_gms_internal_zzzy.f18373j.f17450j);
        if (com_google_android_gms_internal_zzzy.f18371h == null) {
            zzaat com_google_android_gms_internal_zzaat22 = new zzaat(com_google_android_gms_internal_zzzy.f18364a, -1, null, null, null);
        } else {
            com_google_android_gms_internal_zzaat = com_google_android_gms_internal_zzzy.f18371h;
        }
        com_google_android_gms_internal_zzzy.f18367d.mo3386a(new zzafp(com_google_android_gms_internal_zzaat, com_google_android_gms_internal_zzzy.f18373j, com_google_android_gms_internal_zzzy.f18374k, null, i2, -1, com_google_android_gms_internal_zzzy.f18373j.f17453m, null, com_google_android_gms_internal_zzzy.f18369f, null));
    }

    public final void mo3384a() {
        zzakb.m5366b("AdLoaderBackgroundTask started.");
        this.f18372i = new zzaag(this);
        zzahn.f6379a.postDelayed(this.f18372i, ((Long) zzkb.m6350f().m6488a(zznh.bm)).longValue());
        long b = zzbs.m4492k().mo1633b();
        if (((Boolean) zzkb.m6350f().m6488a(zznh.bk)).booleanValue() && this.f18364a.f6043b.f18136c != null) {
            String string = this.f18364a.f6043b.f18136c.getString("_ad");
            if (string != null) {
                this.f18371h = new zzaat(this.f18364a, b, null, null, null);
                mo1643a(zzacg.m4987a(this.f18365b, this.f18371h, string));
                return;
            }
        }
        zzalh com_google_android_gms_internal_zzall = new zzall();
        zzahh.m5148a(new zzaah(this, com_google_android_gms_internal_zzall));
        String g = zzbs.m4507z().m5102g(this.f18365b);
        String h = zzbs.m4507z().m5103h(this.f18365b);
        String i = zzbs.m4507z().m5104i(this.f18365b);
        zzbs.m4507z().m5096c(this.f18365b, i);
        this.f18371h = new zzaat(this.f18364a, b, g, h, i);
        com_google_android_gms_internal_zzall.mo1737a(this.f18371h);
    }

    public final void mo3385b() {
        synchronized (this.f18368e) {
            if (this.f18366c != null) {
                this.f18366c.mo1644d();
            }
        }
    }

    public final void mo1643a(zzaax com_google_android_gms_internal_zzaax) {
        String str;
        zzakb.m5366b("Received ad response.");
        this.f18373j = com_google_android_gms_internal_zzaax;
        long b = zzbs.m4492k().mo1633b();
        synchronized (this.f18368e) {
            zzaif com_google_android_gms_internal_zzaif = null;
            this.f18366c = null;
        }
        zzbs.m4490i().m13249b(this.f18365b, this.f18373j.f17426F);
        if (((Boolean) zzkb.m6350f().m6488a(zznh.aF)).booleanValue() != null) {
            Set hashSet;
            Collection stringSet;
            if (this.f18373j.f17434N != null) {
                zzbs.m4490i();
                com_google_android_gms_internal_zzaax = this.f18365b;
                str = this.f18371h.f17398e;
                com_google_android_gms_internal_zzaax = com_google_android_gms_internal_zzaax.getSharedPreferences("admob", 0);
                stringSet = com_google_android_gms_internal_zzaax.getStringSet("never_pool_slots", Collections.emptySet());
                if (!stringSet.contains(str)) {
                    hashSet = new HashSet(stringSet);
                    hashSet.add(str);
                }
            } else {
                zzbs.m4490i();
                com_google_android_gms_internal_zzaax = this.f18365b;
                str = this.f18371h.f17398e;
                com_google_android_gms_internal_zzaax = com_google_android_gms_internal_zzaax.getSharedPreferences("admob", 0);
                stringSet = com_google_android_gms_internal_zzaax.getStringSet("never_pool_slots", Collections.emptySet());
                if (stringSet.contains(str)) {
                    hashSet = new HashSet(stringSet);
                    hashSet.remove(str);
                }
            }
            com_google_android_gms_internal_zzaax = com_google_android_gms_internal_zzaax.edit();
            com_google_android_gms_internal_zzaax.putStringSet("never_pool_slots", hashSet);
            com_google_android_gms_internal_zzaax.apply();
        }
        try {
            if (this.f18373j.f17444d == -2 || this.f18373j.f17444d == -3) {
                JSONObject jSONObject;
                Boolean valueOf;
                if (this.f18373j.f17444d != -3) {
                    if (TextUtils.isEmpty(this.f18373j.f17442b) != null) {
                        throw new zzaai("No fill from ad server.", 3);
                    }
                    zzbs.m4490i().m13240a(this.f18365b, this.f18373j.f17460t);
                    if (this.f18373j.f17447g != null) {
                        this.f18374k = new zzui(this.f18373j.f17442b);
                        zzbs.m4490i().m13254c(this.f18374k.f8071g);
                    } else {
                        zzbs.m4490i().m13254c(this.f18373j.f17429I);
                    }
                    if (TextUtils.isEmpty(this.f18373j.f17427G) == null) {
                        if (((Boolean) zzkb.m6350f().m6488a(zznh.cm)).booleanValue() != null) {
                            zzakb.m5366b("Received cookie from server. Setting webview cookie in CookieManager.");
                            com_google_android_gms_internal_zzaax = zzbs.m4488g().mo4448c(this.f18365b);
                            if (com_google_android_gms_internal_zzaax != null) {
                                com_google_android_gms_internal_zzaax.setCookie("googleads.g.doubleclick.net", this.f18373j.f17427G);
                            }
                        }
                    }
                }
                zzjn a = this.f18371h.f17397d.f18158g != null ? m19183a(this.f18371h) : null;
                zzbs.m4490i().m13247a(this.f18373j.f17461u);
                zzbs.m4490i().m13251b(this.f18373j.f17433M);
                if (TextUtils.isEmpty(this.f18373j.f17457q) == null) {
                    try {
                        jSONObject = new JSONObject(this.f18373j.f17457q);
                    } catch (zzaax com_google_android_gms_internal_zzaax2) {
                        zzakb.m5367b("Error parsing the JSON for Active View.", com_google_android_gms_internal_zzaax2);
                    }
                    if (this.f18373j.f17436P == 2) {
                        com_google_android_gms_internal_zzaif = Boolean.valueOf(true);
                        zzbs.m4486e();
                        zzahn.m5172a(this.f18371h.f17396c);
                    }
                    if (this.f18373j.f17436P == 1) {
                        com_google_android_gms_internal_zzaif = Boolean.valueOf(false);
                    }
                    if (this.f18373j.f17436P != null) {
                        zzbs.m4486e();
                        valueOf = Boolean.valueOf(zzahn.m5195b(this.f18371h.f17396c));
                    } else {
                        valueOf = com_google_android_gms_internal_zzaif;
                    }
                    this.f18367d.mo3386a(new zzafp(this.f18371h, this.f18373j, this.f18374k, a, -2, b, this.f18373j.f17453m, jSONObject, this.f18369f, valueOf));
                    zzahn.f6379a.removeCallbacks(this.f18372i);
                    return;
                }
                jSONObject = null;
                if (this.f18373j.f17436P == 2) {
                    com_google_android_gms_internal_zzaif = Boolean.valueOf(true);
                    zzbs.m4486e();
                    zzahn.m5172a(this.f18371h.f17396c);
                }
                if (this.f18373j.f17436P == 1) {
                    com_google_android_gms_internal_zzaif = Boolean.valueOf(false);
                }
                if (this.f18373j.f17436P != null) {
                    valueOf = com_google_android_gms_internal_zzaif;
                } else {
                    zzbs.m4486e();
                    valueOf = Boolean.valueOf(zzahn.m5195b(this.f18371h.f17396c));
                }
                this.f18367d.mo3386a(new zzafp(this.f18371h, this.f18373j, this.f18374k, a, -2, b, this.f18373j.f17453m, jSONObject, this.f18369f, valueOf));
                zzahn.f6379a.removeCallbacks(this.f18372i);
                return;
            }
            int i = this.f18373j.f17444d;
            StringBuilder stringBuilder = new StringBuilder(66);
            stringBuilder.append("There was a problem getting an ad response. ErrorCode: ");
            stringBuilder.append(i);
            throw new zzaai(stringBuilder.toString(), this.f18373j.f17444d);
        } catch (zzaax com_google_android_gms_internal_zzaax22) {
            zzakb.m5367b("Could not parse mediation config.", com_google_android_gms_internal_zzaax22);
            String str2 = "Could not parse mediation config: ";
            str = String.valueOf(this.f18373j.f17442b);
            throw new zzaai(str.length() != 0 ? str2.concat(str) : new String(str2), 0);
        } catch (zzaax com_google_android_gms_internal_zzaax222) {
            m19185a(com_google_android_gms_internal_zzaax222.f6018a, com_google_android_gms_internal_zzaax222.getMessage());
        }
    }
}
