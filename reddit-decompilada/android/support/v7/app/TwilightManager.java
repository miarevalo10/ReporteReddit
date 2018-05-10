package android.support.v7.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

class TwilightManager {
    private static TwilightManager f1851a;
    private final Context f1852b;
    private final LocationManager f1853c;
    private final TwilightState f1854d = new TwilightState();

    private static class TwilightState {
        boolean f1845a;
        long f1846b;
        long f1847c;
        long f1848d;
        long f1849e;
        long f1850f;

        TwilightState() {
        }
    }

    static TwilightManager m1565a(Context context) {
        if (f1851a == null) {
            context = context.getApplicationContext();
            f1851a = new TwilightManager(context, (LocationManager) context.getSystemService("location"));
        }
        return f1851a;
    }

    private TwilightManager(Context context, LocationManager locationManager) {
        this.f1852b = context;
        this.f1853c = locationManager;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final boolean m1566a() {
        /*
        r24 = this;
        r0 = r24;
        r1 = r0.f1854d;
        r2 = r0.f1854d;
        r2 = r2.f1850f;
        r4 = java.lang.System.currentTimeMillis();
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        r3 = 0;
        r4 = 1;
        if (r2 <= 0) goto L_0x0014;
    L_0x0012:
        r2 = r4;
        goto L_0x0015;
    L_0x0014:
        r2 = r3;
    L_0x0015:
        if (r2 == 0) goto L_0x001a;
    L_0x0017:
        r1 = r1.f1845a;
        return r1;
    L_0x001a:
        r2 = r0.f1852b;
        r5 = "android.permission.ACCESS_COARSE_LOCATION";
        r2 = android.support.v4.content.PermissionChecker.m759a(r2, r5);
        r5 = 0;
        if (r2 != 0) goto L_0x002c;
    L_0x0025:
        r2 = "network";
        r2 = r0.m1564a(r2);
        goto L_0x002d;
    L_0x002c:
        r2 = r5;
    L_0x002d:
        r6 = r0.f1852b;
        r7 = "android.permission.ACCESS_FINE_LOCATION";
        r6 = android.support.v4.content.PermissionChecker.m759a(r6, r7);
        if (r6 != 0) goto L_0x003d;
    L_0x0037:
        r5 = "gps";
        r5 = r0.m1564a(r5);
    L_0x003d:
        if (r5 == 0) goto L_0x004e;
    L_0x003f:
        if (r2 == 0) goto L_0x004e;
    L_0x0041:
        r6 = r5.getTime();
        r8 = r2.getTime();
        r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r6 <= 0) goto L_0x0051;
    L_0x004d:
        goto L_0x0050;
    L_0x004e:
        if (r5 == 0) goto L_0x0051;
    L_0x0050:
        r2 = r5;
    L_0x0051:
        if (r2 == 0) goto L_0x00db;
    L_0x0053:
        r5 = r0.f1854d;
        r13 = java.lang.System.currentTimeMillis();
        r15 = android.support.v7.app.TwilightCalculator.m1562a();
        r16 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r7 = r13 - r16;
        r9 = r2.getLatitude();
        r11 = r2.getLongitude();
        r6 = r15;
        r6.m1563a(r7, r9, r11);
        r11 = r15.f1842a;
        r9 = r2.getLatitude();
        r18 = r2.getLongitude();
        r7 = r13;
        r20 = r11;
        r11 = r18;
        r6.m1563a(r7, r9, r11);
        r6 = r15.f1844c;
        if (r6 != r4) goto L_0x0085;
    L_0x0084:
        r3 = r4;
    L_0x0085:
        r11 = r15.f1843b;
        r9 = r15.f1842a;
        r7 = r13 + r16;
        r16 = r2.getLatitude();
        r18 = r2.getLongitude();
        r6 = r15;
        r22 = r1;
        r0 = r9;
        r9 = r16;
        r23 = r3;
        r2 = r11;
        r11 = r18;
        r6.m1563a(r7, r9, r11);
        r6 = r15.f1843b;
        r8 = -1;
        r4 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r4 == 0) goto L_0x00c2;
    L_0x00a9:
        r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r4 != 0) goto L_0x00ae;
    L_0x00ad:
        goto L_0x00c2;
    L_0x00ae:
        r4 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1));
        r8 = 0;
        if (r4 <= 0) goto L_0x00b6;
    L_0x00b4:
        r8 = r8 + r6;
        goto L_0x00bd;
    L_0x00b6:
        r4 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1));
        if (r4 <= 0) goto L_0x00bc;
    L_0x00ba:
        r8 = r8 + r0;
        goto L_0x00bd;
    L_0x00bc:
        r8 = r8 + r2;
    L_0x00bd:
        r10 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r8 = r8 + r10;
        goto L_0x00c6;
    L_0x00c2:
        r8 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        r8 = r8 + r13;
    L_0x00c6:
        r4 = r23;
        r5.f1845a = r4;
        r10 = r20;
        r5.f1846b = r10;
        r5.f1847c = r2;
        r5.f1848d = r0;
        r5.f1849e = r6;
        r5.f1850f = r8;
        r0 = r22;
        r0 = r0.f1845a;
        return r0;
    L_0x00db:
        r0 = "TwilightManager";
        r1 = "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.";
        android.util.Log.i(r0, r1);
        r0 = java.util.Calendar.getInstance();
        r1 = 11;
        r0 = r0.get(r1);
        r1 = 6;
        if (r0 < r1) goto L_0x00f5;
    L_0x00ef:
        r1 = 22;
        if (r0 < r1) goto L_0x00f4;
    L_0x00f3:
        goto L_0x00f5;
    L_0x00f4:
        return r3;
    L_0x00f5:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.TwilightManager.a():boolean");
    }

    private Location m1564a(String str) {
        try {
            if (this.f1853c.isProviderEnabled(str)) {
                return this.f1853c.getLastKnownLocation(str);
            }
        } catch (String str2) {
            Log.d("TwilightManager", "Failed to get last known location", str2);
        }
        return null;
    }
}
