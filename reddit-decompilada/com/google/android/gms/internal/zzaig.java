package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.zzbs;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@zzzv
public final class zzaig {
    public String f6394a;
    public String f6395b;
    public String f6396c;
    public String f6397d;
    private final Context f6398e;
    private final float f6399f;
    private float f6400g;
    private float f6401h;
    private float f6402i;
    private int f6403j;

    public zzaig(Context context) {
        this.f6403j = 0;
        this.f6398e = context;
        this.f6399f = context.getResources().getDisplayMetrics().density;
    }

    public zzaig(Context context, String str) {
        this(context);
        this.f6394a = str;
    }

    private static int m5264a(List<String> list, String str, boolean z) {
        if (!z) {
            return -1;
        }
        list.add(str);
        return list.size() - 1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m5265a(int r5, float r6, float r7) {
        /*
        r4 = this;
        if (r5 != 0) goto L_0x000c;
    L_0x0002:
        r5 = 0;
        r4.f6403j = r5;
        r4.f6400g = r6;
        r4.f6401h = r7;
        r4.f6402i = r7;
        return;
    L_0x000c:
        r0 = r4.f6403j;
        r1 = -1;
        if (r0 != r1) goto L_0x0012;
    L_0x0011:
        return;
    L_0x0012:
        r0 = 2;
        r2 = 1;
        if (r5 != r0) goto L_0x008b;
    L_0x0016:
        r5 = r4.f6401h;
        r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1));
        if (r5 <= 0) goto L_0x001f;
    L_0x001c:
        r4.f6401h = r7;
        goto L_0x0027;
    L_0x001f:
        r5 = r4.f6402i;
        r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1));
        if (r5 >= 0) goto L_0x0027;
    L_0x0025:
        r4.f6402i = r7;
    L_0x0027:
        r5 = r4.f6401h;
        r7 = r4.f6402i;
        r5 = r5 - r7;
        r7 = 1106247680; // 0x41f00000 float:30.0 double:5.465589745E-315;
        r3 = r4.f6399f;
        r7 = r7 * r3;
        r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r5 <= 0) goto L_0x0038;
    L_0x0035:
        r4.f6403j = r1;
        return;
    L_0x0038:
        r5 = r4.f6403j;
        r7 = 3;
        if (r5 == 0) goto L_0x0058;
    L_0x003d:
        r5 = r4.f6403j;
        if (r5 != r0) goto L_0x0042;
    L_0x0041:
        goto L_0x0058;
    L_0x0042:
        r5 = r4.f6403j;
        if (r5 == r2) goto L_0x004a;
    L_0x0046:
        r5 = r4.f6403j;
        if (r5 != r7) goto L_0x006c;
    L_0x004a:
        r5 = r4.f6400g;
        r5 = r6 - r5;
        r1 = -1035468800; // 0xffffffffc2480000 float:-50.0 double:NaN;
        r3 = r4.f6399f;
        r1 = r1 * r3;
        r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1));
        if (r5 > 0) goto L_0x006c;
    L_0x0057:
        goto L_0x0065;
    L_0x0058:
        r5 = r4.f6400g;
        r5 = r6 - r5;
        r1 = 1112014848; // 0x42480000 float:50.0 double:5.49408334E-315;
        r3 = r4.f6399f;
        r1 = r1 * r3;
        r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1));
        if (r5 < 0) goto L_0x006c;
    L_0x0065:
        r4.f6400g = r6;
        r5 = r4.f6403j;
        r5 = r5 + r2;
        r4.f6403j = r5;
    L_0x006c:
        r5 = r4.f6403j;
        if (r5 == r2) goto L_0x0082;
    L_0x0070:
        r5 = r4.f6403j;
        if (r5 != r7) goto L_0x0075;
    L_0x0074:
        goto L_0x0082;
    L_0x0075:
        r5 = r4.f6403j;
        if (r5 != r0) goto L_0x0095;
    L_0x0079:
        r5 = r4.f6400g;
        r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r5 >= 0) goto L_0x0095;
    L_0x007f:
        r4.f6400g = r6;
        return;
    L_0x0082:
        r5 = r4.f6400g;
        r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r5 <= 0) goto L_0x0095;
    L_0x0088:
        r4.f6400g = r6;
        return;
    L_0x008b:
        if (r5 != r2) goto L_0x0095;
    L_0x008d:
        r5 = r4.f6403j;
        r6 = 4;
        if (r5 != r6) goto L_0x0095;
    L_0x0092:
        r4.m5274a();
    L_0x0095:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaig.a(int, float, float):void");
    }

    private final void m5267b() {
        if (this.f6398e instanceof Activity) {
            Builder builder;
            Object obj = this.f6394a;
            if (!TextUtils.isEmpty(obj)) {
                Uri build = new Uri.Builder().encodedQuery(obj.replaceAll("\\+", "%20")).build();
                StringBuilder stringBuilder = new StringBuilder();
                zzbs.m4486e();
                Map a = zzahn.m5163a(build);
                for (String str : a.keySet()) {
                    stringBuilder.append(str);
                    stringBuilder.append(" = ");
                    stringBuilder.append((String) a.get(str));
                    stringBuilder.append("\n\n");
                }
                obj = stringBuilder.toString().trim();
                if (!TextUtils.isEmpty(obj)) {
                    builder = new Builder(this.f6398e);
                    builder.setMessage(obj);
                    builder.setTitle("Ad Information");
                    builder.setPositiveButton("Share", new zzaii(this, obj));
                    builder.setNegativeButton("Close", new zzaij());
                    builder.create().show();
                    return;
                }
            }
            obj = "No debug information";
            builder = new Builder(this.f6398e);
            builder.setMessage(obj);
            builder.setTitle("Ad Information");
            builder.setPositiveButton("Share", new zzaii(this, obj));
            builder.setNegativeButton("Close", new zzaij());
            builder.create().show();
            return;
        }
        zzakb.m5370d("Can not create dialog without Activity Context");
    }

    public final void m5274a() {
        if (!((Boolean) zzkb.m6350f().m6488a(zznh.cz)).booleanValue()) {
            if (!((Boolean) zzkb.m6350f().m6488a(zznh.cy)).booleanValue()) {
                m5267b();
                return;
            }
        }
        if (this.f6398e instanceof Activity) {
            String str = !TextUtils.isEmpty(zzbs.m4495n().m5280a()) ? "Creative Preview (Enabled)" : "Creative Preview";
            String str2 = zzbs.m4495n().m5283b() ? "Troubleshooting (Enabled)" : "Troubleshooting";
            List arrayList = new ArrayList();
            int a = m5264a(arrayList, "Ad Information", true);
            int a2 = m5264a(arrayList, str, ((Boolean) zzkb.m6350f().m6488a(zznh.cy)).booleanValue());
            int a3 = m5264a(arrayList, str2, ((Boolean) zzkb.m6350f().m6488a(zznh.cz)).booleanValue());
            Builder builder = new Builder(this.f6398e, zzbs.m4488g().mo3963f());
            builder.setTitle("Select a Debug Mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new zzaih(this, a, a2, a3));
            builder.create().show();
            return;
        }
        zzakb.m5370d("Can not create dialog without Activity Context");
    }

    public final void m5275a(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            m5265a(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        m5265a(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }

    static /* synthetic */ void m5268b(zzaig com_google_android_gms_internal_zzaig) {
        zzakb.m5366b("Debug mode [Creative Preview] selected.");
        zzahh.m5148a(new zzaik(com_google_android_gms_internal_zzaig));
    }

    static /* synthetic */ void m5269c(zzaig com_google_android_gms_internal_zzaig) {
        zzakb.m5366b("Debug mode [Troubleshooting] selected.");
        zzahh.m5148a(new zzail(com_google_android_gms_internal_zzaig));
    }
}
