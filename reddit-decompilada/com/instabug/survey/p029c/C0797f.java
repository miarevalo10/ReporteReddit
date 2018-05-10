package com.instabug.survey.p029c;

import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.instabug.library.logging.InstabugUserEventLogger;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.p027a.C1411a;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

/* compiled from: SurveysValidator */
public class C0797f {
    private String f9963a;
    private String f9964b;

    public C0797f(String str, String str2) {
        this.f9964b = str;
        this.f9963a = str2;
    }

    private static String m8415a(String str) {
        str = Pattern.compile("\\d+(\\.\\d+)*").matcher(str);
        return str.find() ? str.group(0) : null;
    }

    private static boolean m8419a(ArrayList<C1411a> arrayList, String str) {
        boolean equals = str.equals("and");
        for (int i = 0; i < arrayList.size(); i++) {
            C1411a c1411a = (C1411a) arrayList.get(i);
            HashMap all = UserAttributesCacheManager.getAll();
            boolean z = all != null && all.containsKey(c1411a.f15562a) && C0797f.m8417a(c1411a, (String) all.get(c1411a.f15562a));
            if (i == 0) {
                equals = z;
            } else {
                int i2;
                Object obj = -1;
                int hashCode = str.hashCode();
                if (hashCode != 3555) {
                    if (hashCode == 96727) {
                        if (str.equals("and")) {
                            obj = null;
                        }
                    }
                } else if (str.equals("or")) {
                    obj = 1;
                }
                switch (obj) {
                    case null:
                        i2 = equals & z;
                        break;
                    case 1:
                        i2 = equals | z;
                        break;
                    default:
                        i2 = equals & z;
                        break;
                }
                equals = i2 & z;
            }
        }
        return equals;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m8421b(java.util.ArrayList<com.instabug.survey.p027a.C1411a> r10, java.lang.String r11) throws java.text.ParseException {
        /*
        r0 = "and";
        r0 = r11.equals(r0);
        if (r10 != 0) goto L_0x0009;
    L_0x0008:
        return r0;
    L_0x0009:
        r1 = 0;
        r2 = r0;
        r0 = r1;
    L_0x000c:
        r3 = r10.size();
        if (r0 >= r3) goto L_0x00b2;
    L_0x0012:
        r3 = r10.get(r0);
        r3 = (com.instabug.survey.p027a.C1411a) r3;
        r4 = r3.f15562a;
        r4 = com.instabug.survey.p029c.C0797f.m8420b(r4);
        r5 = r3.f15563b;
        r6 = -1;
        r7 = 1;
        if (r5 == 0) goto L_0x007f;
    L_0x0024:
        r5 = r3.f15563b;
        r5 = java.lang.Integer.parseInt(r5);
        r3 = r3.f15564c;
        r8 = r3.hashCode();
        r9 = -1374681402; // 0xffffffffae1006c6 float:-3.2747825E-11 double:NaN;
        if (r8 == r9) goto L_0x0063;
    L_0x0035:
        r9 = 96757556; // 0x5c46734 float:1.8469662E-35 double:4.78045844E-316;
        if (r8 == r9) goto L_0x0059;
    L_0x003a:
        r9 = 365984903; // 0x15d07c87 float:8.4207E-26 double:1.808205675E-315;
        if (r8 == r9) goto L_0x004f;
    L_0x003f:
        r9 = 1614662344; // 0x603dcac8 float:5.4703852E19 double:7.97749194E-315;
        if (r8 == r9) goto L_0x0045;
    L_0x0044:
        goto L_0x006d;
    L_0x0045:
        r8 = "not_equal";
        r3 = r3.equals(r8);
        if (r3 == 0) goto L_0x006d;
    L_0x004d:
        r3 = r7;
        goto L_0x006e;
    L_0x004f:
        r8 = "less_than";
        r3 = r3.equals(r8);
        if (r3 == 0) goto L_0x006d;
    L_0x0057:
        r3 = 3;
        goto L_0x006e;
    L_0x0059:
        r8 = "equal";
        r3 = r3.equals(r8);
        if (r3 == 0) goto L_0x006d;
    L_0x0061:
        r3 = r1;
        goto L_0x006e;
    L_0x0063:
        r8 = "greater_than";
        r3 = r3.equals(r8);
        if (r3 == 0) goto L_0x006d;
    L_0x006b:
        r3 = 2;
        goto L_0x006e;
    L_0x006d:
        r3 = r6;
    L_0x006e:
        switch(r3) {
            case 0: goto L_0x007b;
            case 1: goto L_0x0078;
            case 2: goto L_0x0075;
            case 3: goto L_0x0072;
            default: goto L_0x0071;
        };
    L_0x0071:
        goto L_0x007f;
    L_0x0072:
        if (r4 >= r5) goto L_0x007f;
    L_0x0074:
        goto L_0x007d;
    L_0x0075:
        if (r4 <= r5) goto L_0x007f;
    L_0x0077:
        goto L_0x007d;
    L_0x0078:
        if (r4 == r5) goto L_0x007f;
    L_0x007a:
        goto L_0x007d;
    L_0x007b:
        if (r4 != r5) goto L_0x007f;
    L_0x007d:
        r3 = r7;
        goto L_0x0080;
    L_0x007f:
        r3 = r1;
    L_0x0080:
        if (r0 != 0) goto L_0x0084;
    L_0x0082:
        r2 = r3;
        goto L_0x00ae;
    L_0x0084:
        r4 = r11.hashCode();
        r5 = 3555; // 0xde3 float:4.982E-42 double:1.7564E-320;
        if (r4 == r5) goto L_0x009c;
    L_0x008c:
        r5 = 96727; // 0x179d7 float:1.35543E-40 double:4.77895E-319;
        if (r4 == r5) goto L_0x0092;
    L_0x0091:
        goto L_0x00a5;
    L_0x0092:
        r4 = "and";
        r4 = r11.equals(r4);
        if (r4 == 0) goto L_0x00a5;
    L_0x009a:
        r6 = r1;
        goto L_0x00a5;
    L_0x009c:
        r4 = "or";
        r4 = r11.equals(r4);
        if (r4 == 0) goto L_0x00a5;
    L_0x00a4:
        r6 = r7;
    L_0x00a5:
        switch(r6) {
            case 0: goto L_0x00ac;
            case 1: goto L_0x00aa;
            default: goto L_0x00a8;
        };
    L_0x00a8:
        r2 = r2 & r3;
        goto L_0x00ad;
    L_0x00aa:
        r2 = r2 | r3;
        goto L_0x00ad;
    L_0x00ac:
        r2 = r2 & r3;
    L_0x00ad:
        r2 = r2 & r3;
    L_0x00ae:
        r0 = r0 + 1;
        goto L_0x000c;
    L_0x00b2:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.c.f.b(java.util.ArrayList, java.lang.String):boolean");
    }

    private static int m8420b(String str) {
        try {
            Method declaredMethod = InstabugUserEventLogger.class.getDeclaredMethod("getLoggingEventCount", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(InstabugUserEventLogger.getInstance(), new Object[]{str})).intValue();
        } catch (String str2) {
            InstabugSDKLogger.m8357e(C0797f.class, "METHOD NOT FOUND !");
            str2.printStackTrace();
            return 0;
        } catch (String str22) {
            InstabugSDKLogger.m8357e(C0797f.class, "METHOD NOT FOUND !");
            str22.printStackTrace();
            return 0;
        } catch (String str222) {
            InstabugSDKLogger.m8357e(C0797f.class, "METHOD NOT FOUND !");
            str222.printStackTrace();
            return 0;
        }
    }

    private static boolean m8418a(ArrayList<C1411a> arrayList) throws ParseException {
        arrayList = arrayList.iterator();
        while (arrayList.hasNext()) {
            if (((C1411a) arrayList.next()).f15562a.equals("days_since_dismiss")) {
                return true;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m8422a(com.instabug.survey.p027a.C1413c r23) throws java.text.ParseException {
        /*
        r22 = this;
        r0 = r23;
        r1 = r0.f15574d;
        r2 = r0.f15577g;
        r3 = r0.f15580j;
        r5 = "and";
        r5 = r2.equals(r5);
        r7 = r5;
        r5 = 0;
    L_0x0010:
        r8 = r1.size();
        if (r5 >= r8) goto L_0x0280;
    L_0x0016:
        r8 = r1.get(r5);
        r8 = (com.instabug.survey.p027a.C1411a) r8;
        r13 = r8.f15562a;
        r14 = r13.hashCode();
        r16 = 3;
        switch(r14) {
            case -1464712027: goto L_0x005b;
            case -901870406: goto L_0x0051;
            case 3076014: goto L_0x0047;
            case 96619420: goto L_0x003d;
            case 1421955229: goto L_0x0033;
            case 1905908461: goto L_0x0028;
            default: goto L_0x0027;
        };
    L_0x0027:
        goto L_0x0065;
    L_0x0028:
        r14 = "sessions_count";
        r13 = r13.equals(r14);
        if (r13 == 0) goto L_0x0065;
    L_0x0030:
        r13 = r16;
        goto L_0x0066;
    L_0x0033:
        r14 = "days_since_dismiss";
        r13 = r13.equals(r14);
        if (r13 == 0) goto L_0x0065;
    L_0x003b:
        r13 = 5;
        goto L_0x0066;
    L_0x003d:
        r14 = "email";
        r13 = r13.equals(r14);
        if (r13 == 0) goto L_0x0065;
    L_0x0045:
        r13 = 2;
        goto L_0x0066;
    L_0x0047:
        r14 = "date";
        r13 = r13.equals(r14);
        if (r13 == 0) goto L_0x0065;
    L_0x004f:
        r13 = 1;
        goto L_0x0066;
    L_0x0051:
        r14 = "app_version";
        r13 = r13.equals(r14);
        if (r13 == 0) goto L_0x0065;
    L_0x0059:
        r13 = 0;
        goto L_0x0066;
    L_0x005b:
        r14 = "days_since_signup";
        r13 = r13.equals(r14);
        if (r13 == 0) goto L_0x0065;
    L_0x0063:
        r13 = 4;
        goto L_0x0066;
    L_0x0065:
        r13 = -1;
    L_0x0066:
        r14 = 1614662344; // 0x603dcac8 float:5.4703852E19 double:7.97749194E-315;
        r11 = 365984903; // 0x15d07c87 float:8.4207E-26 double:1.808205675E-315;
        r15 = 96757556; // 0x5c46734 float:1.8469662E-35 double:4.78045844E-316;
        r12 = -1374681402; // 0xffffffffae1006c6 float:-3.2747825E-11 double:NaN;
        switch(r13) {
            case 0: goto L_0x023e;
            case 1: goto L_0x01c4;
            case 2: goto L_0x01b5;
            case 3: goto L_0x014e;
            case 4: goto L_0x00ea;
            case 5: goto L_0x007b;
            default: goto L_0x0075;
        };
    L_0x0075:
        r6 = r22;
        r18 = r7;
        goto L_0x0247;
    L_0x007b:
        r13 = java.lang.Long.valueOf(r3);
        r18 = r7;
        r6 = r13.longValue();
        r13 = r8.f15563b;
        if (r13 == 0) goto L_0x01b1;
    L_0x0089:
        r19 = 0;
        r13 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1));
        if (r13 != 0) goto L_0x0094;
    L_0x008f:
        r6 = r22;
        r7 = 1;
        goto L_0x0248;
    L_0x0094:
        r13 = r8.f15563b;
        r13 = java.lang.Integer.parseInt(r13);
        r6 = com.instabug.survey.p029c.C0792a.m8407a(r6);
        r7 = r8.f15564c;
        r8 = r7.hashCode();
        if (r8 == r12) goto L_0x00cc;
    L_0x00a6:
        if (r8 == r15) goto L_0x00c1;
    L_0x00a8:
        if (r8 == r11) goto L_0x00b8;
    L_0x00aa:
        if (r8 == r14) goto L_0x00ad;
    L_0x00ac:
        goto L_0x00d7;
    L_0x00ad:
        r8 = "not_equal";
        r7 = r7.equals(r8);
        if (r7 == 0) goto L_0x00d7;
    L_0x00b5:
        r16 = 1;
        goto L_0x00d9;
    L_0x00b8:
        r8 = "less_than";
        r7 = r7.equals(r8);
        if (r7 == 0) goto L_0x00d7;
    L_0x00c0:
        goto L_0x00d9;
    L_0x00c1:
        r8 = "equal";
        r7 = r7.equals(r8);
        if (r7 == 0) goto L_0x00d7;
    L_0x00c9:
        r16 = 0;
        goto L_0x00d9;
    L_0x00cc:
        r8 = "greater_than";
        r7 = r7.equals(r8);
        if (r7 == 0) goto L_0x00d7;
    L_0x00d4:
        r16 = 2;
        goto L_0x00d9;
    L_0x00d7:
        r16 = -1;
    L_0x00d9:
        switch(r16) {
            case 0: goto L_0x00e7;
            case 1: goto L_0x00e4;
            case 2: goto L_0x00e1;
            case 3: goto L_0x00de;
            default: goto L_0x00dc;
        };
    L_0x00dc:
        goto L_0x01b1;
    L_0x00de:
        if (r6 >= r13) goto L_0x01b1;
    L_0x00e0:
        goto L_0x008f;
    L_0x00e1:
        if (r6 <= r13) goto L_0x01b1;
    L_0x00e3:
        goto L_0x008f;
    L_0x00e4:
        if (r6 == r13) goto L_0x01b1;
    L_0x00e6:
        goto L_0x008f;
    L_0x00e7:
        if (r6 != r13) goto L_0x01b1;
    L_0x00e9:
        goto L_0x008f;
    L_0x00ea:
        r18 = r7;
        r6 = r8.f15563b;
        if (r6 == 0) goto L_0x01b1;
    L_0x00f0:
        r6 = r8.f15563b;
        r6 = java.lang.Integer.parseInt(r6);
        r9 = com.instabug.library.core.InstabugCore.getFirstRunAt();
        r7 = com.instabug.survey.p029c.C0792a.m8407a(r9);
        r8 = r8.f15564c;
        r9 = r8.hashCode();
        if (r9 == r12) goto L_0x012c;
    L_0x0106:
        if (r9 == r15) goto L_0x0121;
    L_0x0108:
        if (r9 == r11) goto L_0x0118;
    L_0x010a:
        if (r9 == r14) goto L_0x010d;
    L_0x010c:
        goto L_0x0137;
    L_0x010d:
        r9 = "not_equal";
        r8 = r8.equals(r9);
        if (r8 == 0) goto L_0x0137;
    L_0x0115:
        r16 = 1;
        goto L_0x0139;
    L_0x0118:
        r9 = "less_than";
        r8 = r8.equals(r9);
        if (r8 == 0) goto L_0x0137;
    L_0x0120:
        goto L_0x0139;
    L_0x0121:
        r9 = "equal";
        r8 = r8.equals(r9);
        if (r8 == 0) goto L_0x0137;
    L_0x0129:
        r16 = 0;
        goto L_0x0139;
    L_0x012c:
        r9 = "greater_than";
        r8 = r8.equals(r9);
        if (r8 == 0) goto L_0x0137;
    L_0x0134:
        r16 = 2;
        goto L_0x0139;
    L_0x0137:
        r16 = -1;
    L_0x0139:
        switch(r16) {
            case 0: goto L_0x014a;
            case 1: goto L_0x0146;
            case 2: goto L_0x0142;
            case 3: goto L_0x013e;
            default: goto L_0x013c;
        };
    L_0x013c:
        goto L_0x01b1;
    L_0x013e:
        if (r7 >= r6) goto L_0x01b1;
    L_0x0140:
        goto L_0x008f;
    L_0x0142:
        if (r7 <= r6) goto L_0x01b1;
    L_0x0144:
        goto L_0x008f;
    L_0x0146:
        if (r7 == r6) goto L_0x01b1;
    L_0x0148:
        goto L_0x008f;
    L_0x014a:
        if (r7 != r6) goto L_0x01b1;
    L_0x014c:
        goto L_0x008f;
    L_0x014e:
        r18 = r7;
        r6 = com.instabug.library.settings.SettingsManager.getInstance();
        r6 = r6.getSessionsCount();
        r7 = r8.f15563b;
        if (r7 == 0) goto L_0x01b1;
    L_0x015c:
        r7 = r8.f15563b;
        r7 = java.lang.Integer.parseInt(r7);
        r8 = r8.f15564c;
        r9 = r8.hashCode();
        if (r9 == r12) goto L_0x0190;
    L_0x016a:
        if (r9 == r15) goto L_0x0185;
    L_0x016c:
        if (r9 == r11) goto L_0x017c;
    L_0x016e:
        if (r9 == r14) goto L_0x0171;
    L_0x0170:
        goto L_0x019b;
    L_0x0171:
        r9 = "not_equal";
        r8 = r8.equals(r9);
        if (r8 == 0) goto L_0x019b;
    L_0x0179:
        r16 = 1;
        goto L_0x019d;
    L_0x017c:
        r9 = "less_than";
        r8 = r8.equals(r9);
        if (r8 == 0) goto L_0x019b;
    L_0x0184:
        goto L_0x019d;
    L_0x0185:
        r9 = "equal";
        r8 = r8.equals(r9);
        if (r8 == 0) goto L_0x019b;
    L_0x018d:
        r16 = 0;
        goto L_0x019d;
    L_0x0190:
        r9 = "greater_than";
        r8 = r8.equals(r9);
        if (r8 == 0) goto L_0x019b;
    L_0x0198:
        r16 = 2;
        goto L_0x019d;
    L_0x019b:
        r16 = -1;
    L_0x019d:
        switch(r16) {
            case 0: goto L_0x01ad;
            case 1: goto L_0x01a9;
            case 2: goto L_0x01a5;
            case 3: goto L_0x01a1;
            default: goto L_0x01a0;
        };
    L_0x01a0:
        goto L_0x01b1;
    L_0x01a1:
        if (r6 >= r7) goto L_0x01b1;
    L_0x01a3:
        goto L_0x008f;
    L_0x01a5:
        if (r6 <= r7) goto L_0x01b1;
    L_0x01a7:
        goto L_0x008f;
    L_0x01a9:
        if (r6 == r7) goto L_0x01b1;
    L_0x01ab:
        goto L_0x008f;
    L_0x01ad:
        if (r6 != r7) goto L_0x01b1;
    L_0x01af:
        goto L_0x008f;
    L_0x01b1:
        r6 = r22;
        goto L_0x0247;
    L_0x01b5:
        r18 = r7;
        r6 = com.instabug.library.core.InstabugCore.getUserEmail();
        r6 = com.instabug.survey.p029c.C0797f.m8417a(r8, r6);
    L_0x01bf:
        r7 = r6;
        r6 = r22;
        goto L_0x0248;
    L_0x01c4:
        r18 = r7;
        r6 = new java.util.Date;
        r6.<init>();
        r7 = r8.f15563b;
        if (r7 == 0) goto L_0x01b1;
    L_0x01cf:
        r7 = r8.f15563b;
        r7 = com.instabug.library.util.InstabugDateFormatter.getDate(r7);
        r7 = com.instabug.library.util.InstabugDateFormatter.getStandardizedDate(r7);
        r6 = com.instabug.library.util.InstabugDateFormatter.getStandardizedDate(r6);
        r8 = r8.f15564c;
        r9 = r8.hashCode();
        if (r9 == r12) goto L_0x020b;
    L_0x01e5:
        if (r9 == r15) goto L_0x0200;
    L_0x01e7:
        if (r9 == r11) goto L_0x01f7;
    L_0x01e9:
        if (r9 == r14) goto L_0x01ec;
    L_0x01eb:
        goto L_0x0216;
    L_0x01ec:
        r9 = "not_equal";
        r8 = r8.equals(r9);
        if (r8 == 0) goto L_0x0216;
    L_0x01f4:
        r16 = 1;
        goto L_0x0218;
    L_0x01f7:
        r9 = "less_than";
        r8 = r8.equals(r9);
        if (r8 == 0) goto L_0x0216;
    L_0x01ff:
        goto L_0x0218;
    L_0x0200:
        r9 = "equal";
        r8 = r8.equals(r9);
        if (r8 == 0) goto L_0x0216;
    L_0x0208:
        r16 = 0;
        goto L_0x0218;
    L_0x020b:
        r9 = "greater_than";
        r8 = r8.equals(r9);
        if (r8 == 0) goto L_0x0216;
    L_0x0213:
        r16 = 2;
        goto L_0x0218;
    L_0x0216:
        r16 = -1;
    L_0x0218:
        switch(r16) {
            case 0: goto L_0x0232;
            case 1: goto L_0x0226;
            case 2: goto L_0x0221;
            case 3: goto L_0x021c;
            default: goto L_0x021b;
        };
    L_0x021b:
        goto L_0x01b1;
    L_0x021c:
        r6 = r6.before(r7);
        goto L_0x01bf;
    L_0x0221:
        r6 = r6.after(r7);
        goto L_0x01bf;
    L_0x0226:
        r6 = r6.getDate();
        r7 = r7.getDate();
        if (r6 == r7) goto L_0x01b1;
    L_0x0230:
        goto L_0x008f;
    L_0x0232:
        r6 = r6.getDate();
        r7 = r7.getDate();
        if (r6 != r7) goto L_0x01b1;
    L_0x023c:
        goto L_0x008f;
    L_0x023e:
        r6 = r22;
        r18 = r7;
        r7 = r6.m8416a(r8);
        goto L_0x0248;
    L_0x0247:
        r7 = 0;
    L_0x0248:
        if (r5 != 0) goto L_0x024b;
    L_0x024a:
        goto L_0x027c;
    L_0x024b:
        r8 = r2.hashCode();
        r9 = 3555; // 0xde3 float:4.982E-42 double:1.7564E-320;
        if (r8 == r9) goto L_0x0264;
    L_0x0253:
        r9 = 96727; // 0x179d7 float:1.35543E-40 double:4.77895E-319;
        if (r8 == r9) goto L_0x0259;
    L_0x0258:
        goto L_0x026f;
    L_0x0259:
        r8 = "and";
        r8 = r2.equals(r8);
        if (r8 == 0) goto L_0x026f;
    L_0x0261:
        r17 = 0;
        goto L_0x0271;
    L_0x0264:
        r8 = "or";
        r8 = r2.equals(r8);
        if (r8 == 0) goto L_0x026f;
    L_0x026c:
        r17 = 1;
        goto L_0x0271;
    L_0x026f:
        r17 = -1;
    L_0x0271:
        switch(r17) {
            case 0: goto L_0x027a;
            case 1: goto L_0x0277;
            default: goto L_0x0274;
        };
    L_0x0274:
        r7 = r18 & r7;
        goto L_0x027c;
    L_0x0277:
        r7 = r18 | r7;
        goto L_0x027c;
    L_0x027a:
        r7 = r18 & r7;
    L_0x027c:
        r5 = r5 + 1;
        goto L_0x0010;
    L_0x0280:
        r6 = r22;
        r18 = r7;
        r1 = r0.f15575e;
        r2 = r0.f15577g;
        r1 = com.instabug.survey.p029c.C0797f.m8419a(r1, r2);
        r2 = r0.f15576f;
        r3 = r0.f15577g;
        r2 = com.instabug.survey.p029c.C0797f.m8421b(r2, r3);
        r3 = r0.f15581k;
        r4 = r0.f15574d;
        r4 = com.instabug.survey.p029c.C0797f.m8418a(r4);
        if (r3 == 0) goto L_0x02a2;
    L_0x029e:
        if (r4 != 0) goto L_0x02a2;
    L_0x02a0:
        r3 = 0;
        return r3;
    L_0x02a2:
        r3 = r0.f15576f;
        if (r3 == 0) goto L_0x02ae;
    L_0x02a6:
        r3 = r0.f15576f;
        r3 = r3.size();
        if (r3 > 0) goto L_0x02c1;
    L_0x02ae:
        r3 = r0.f15575e;
        r3 = r3.size();
        if (r3 > 0) goto L_0x02c1;
    L_0x02b6:
        r3 = r0.f15574d;
        r3 = r3.size();
        if (r3 <= 0) goto L_0x02bf;
    L_0x02be:
        goto L_0x02c1;
    L_0x02bf:
        r3 = 1;
        return r3;
    L_0x02c1:
        r0 = r0.f15577g;
        r3 = r0.hashCode();
        r4 = 3555; // 0xde3 float:4.982E-42 double:1.7564E-320;
        if (r3 == r4) goto L_0x02dc;
    L_0x02cb:
        r4 = 96727; // 0x179d7 float:1.35543E-40 double:4.77895E-319;
        if (r3 == r4) goto L_0x02d1;
    L_0x02d0:
        goto L_0x02e7;
    L_0x02d1:
        r3 = "and";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x02e7;
    L_0x02d9:
        r17 = 0;
        goto L_0x02e9;
    L_0x02dc:
        r3 = "or";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x02e7;
    L_0x02e4:
        r17 = 1;
        goto L_0x02e9;
    L_0x02e7:
        r17 = -1;
    L_0x02e9:
        switch(r17) {
            case 0: goto L_0x0300;
            case 1: goto L_0x02f5;
            default: goto L_0x02ec;
        };
    L_0x02ec:
        r0 = 0;
        r3 = 1;
        if (r18 == 0) goto L_0x030a;
    L_0x02f0:
        if (r1 == 0) goto L_0x030a;
    L_0x02f2:
        if (r2 == 0) goto L_0x030a;
    L_0x02f4:
        return r3;
    L_0x02f5:
        if (r18 != 0) goto L_0x02fe;
    L_0x02f7:
        if (r1 != 0) goto L_0x02fe;
    L_0x02f9:
        if (r2 == 0) goto L_0x02fc;
    L_0x02fb:
        goto L_0x02fe;
    L_0x02fc:
        r0 = 0;
        return r0;
    L_0x02fe:
        r3 = 1;
        return r3;
    L_0x0300:
        r0 = 0;
        r3 = 1;
        if (r18 == 0) goto L_0x0309;
    L_0x0304:
        if (r1 == 0) goto L_0x0309;
    L_0x0306:
        if (r2 == 0) goto L_0x0309;
    L_0x0308:
        return r3;
    L_0x0309:
        return r0;
    L_0x030a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.c.f.a(com.instabug.survey.a.c):boolean");
    }

    private boolean m8416a(com.instabug.survey.p027a.C1411a r7) {
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
        r6 = this;
        r0 = r7.f15563b;
        r0 = com.instabug.survey.p029c.C0797f.m8415a(r0);
        r1 = r6.f9963a;
        r1 = com.instabug.survey.p029c.C0797f.m8415a(r1);
        if (r0 == 0) goto L_0x006e;
    L_0x000e:
        r2 = 0;
        r0 = com.instabug.library.util.StringUtility.compareVersion(r1, r0);	 Catch:{ NumberFormatException -> 0x006d }
        r7 = r7.f15564c;
        r1 = r7.hashCode();
        r3 = -1374681402; // 0xffffffffae1006c6 float:-3.2747825E-11 double:NaN;
        r4 = -1;
        r5 = 1;
        if (r1 == r3) goto L_0x004e;
    L_0x0020:
        r3 = 96757556; // 0x5c46734 float:1.8469662E-35 double:4.78045844E-316;
        if (r1 == r3) goto L_0x0044;
    L_0x0025:
        r3 = 365984903; // 0x15d07c87 float:8.4207E-26 double:1.808205675E-315;
        if (r1 == r3) goto L_0x003a;
    L_0x002a:
        r3 = 1614662344; // 0x603dcac8 float:5.4703852E19 double:7.97749194E-315;
        if (r1 == r3) goto L_0x0030;
    L_0x002f:
        goto L_0x0058;
    L_0x0030:
        r1 = "not_equal";
        r7 = r7.equals(r1);
        if (r7 == 0) goto L_0x0058;
    L_0x0038:
        r7 = r5;
        goto L_0x0059;
    L_0x003a:
        r1 = "less_than";
        r7 = r7.equals(r1);
        if (r7 == 0) goto L_0x0058;
    L_0x0042:
        r7 = 3;
        goto L_0x0059;
    L_0x0044:
        r1 = "equal";
        r7 = r7.equals(r1);
        if (r7 == 0) goto L_0x0058;
    L_0x004c:
        r7 = r2;
        goto L_0x0059;
    L_0x004e:
        r1 = "greater_than";
        r7 = r7.equals(r1);
        if (r7 == 0) goto L_0x0058;
    L_0x0056:
        r7 = 2;
        goto L_0x0059;
    L_0x0058:
        r7 = r4;
    L_0x0059:
        switch(r7) {
            case 0: goto L_0x0069;
            case 1: goto L_0x0065;
            case 2: goto L_0x0061;
            case 3: goto L_0x005d;
            default: goto L_0x005c;
        };
    L_0x005c:
        return r2;
    L_0x005d:
        if (r0 != r4) goto L_0x0060;
    L_0x005f:
        return r5;
    L_0x0060:
        return r2;
    L_0x0061:
        if (r0 != r5) goto L_0x0064;
    L_0x0063:
        return r5;
    L_0x0064:
        return r2;
    L_0x0065:
        if (r0 == 0) goto L_0x0068;
    L_0x0067:
        return r5;
    L_0x0068:
        return r2;
    L_0x0069:
        if (r0 != 0) goto L_0x006c;
    L_0x006b:
        return r5;
    L_0x006c:
        return r2;
    L_0x006d:
        return r2;
    L_0x006e:
        r0 = r6.f9964b;
        r7 = com.instabug.survey.p029c.C0797f.m8417a(r7, r0);
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.c.f.a(com.instabug.survey.a.a):boolean");
    }

    private static boolean m8417a(C1411a c1411a, String str) {
        if (c1411a.f15563b != null) {
            if (str != null) {
                CharSequence charSequence = c1411a.f15563b;
                c1411a = c1411a.f15564c;
                int hashCode = c1411a.hashCode();
                if (hashCode != -630852760) {
                    if (hashCode != 96757556) {
                        if (hashCode != 951526612) {
                            if (hashCode == 1614662344) {
                                if (c1411a.equals("not_equal") != null) {
                                    c1411a = 1;
                                    switch (c1411a) {
                                        case null:
                                            return str.equals(charSequence);
                                        case 1:
                                            if (str.equals(charSequence) == null) {
                                                return true;
                                            }
                                            return false;
                                        case 2:
                                            return str.contains(charSequence);
                                        case 3:
                                            if (str.contains(charSequence) == null) {
                                                return true;
                                            }
                                            return false;
                                        default:
                                            return false;
                                    }
                                }
                            }
                        } else if (c1411a.equals("contain") != null) {
                            c1411a = 2;
                            switch (c1411a) {
                                case null:
                                    return str.equals(charSequence);
                                case 1:
                                    if (str.equals(charSequence) == null) {
                                        return false;
                                    }
                                    return true;
                                case 2:
                                    return str.contains(charSequence);
                                case 3:
                                    if (str.contains(charSequence) == null) {
                                        return false;
                                    }
                                    return true;
                                default:
                                    return false;
                            }
                        }
                    } else if (c1411a.equals("equal") != null) {
                        c1411a = null;
                        switch (c1411a) {
                            case null:
                                return str.equals(charSequence);
                            case 1:
                                if (str.equals(charSequence) == null) {
                                    return true;
                                }
                                return false;
                            case 2:
                                return str.contains(charSequence);
                            case 3:
                                if (str.contains(charSequence) == null) {
                                    return true;
                                }
                                return false;
                            default:
                                return false;
                        }
                    }
                } else if (c1411a.equals("not_contain") != null) {
                    c1411a = 3;
                    switch (c1411a) {
                        case null:
                            return str.equals(charSequence);
                        case 1:
                            if (str.equals(charSequence) == null) {
                                return false;
                            }
                            return true;
                        case 2:
                            return str.contains(charSequence);
                        case 3:
                            if (str.contains(charSequence) == null) {
                                return false;
                            }
                            return true;
                        default:
                            return false;
                    }
                }
                c1411a = -1;
                switch (c1411a) {
                    case null:
                        return str.equals(charSequence);
                    case 1:
                        if (str.equals(charSequence) == null) {
                            return true;
                        }
                        return false;
                    case 2:
                        return str.contains(charSequence);
                    case 3:
                        if (str.contains(charSequence) == null) {
                            return true;
                        }
                        return false;
                    default:
                        return false;
                }
            }
        }
        return false;
    }
}
