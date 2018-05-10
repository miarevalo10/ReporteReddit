package io.branch.referral;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;

class ApkParser {
    public static int f24474a = 1048833;
    public static int f24475b = 1048834;
    public static int f24476c = 1048835;

    ApkParser() {
    }

    public static String m26093a(byte[] bArr) {
        int i;
        int a = 36 + (m26092a(bArr, 16) * 4);
        int a2 = m26092a(bArr, 12);
        for (i = a2; i < bArr.length - 4; i += 4) {
            if (m26092a(bArr, i) == f24475b) {
                a2 = i;
                break;
            }
        }
        while (a2 < bArr.length) {
            i = m26092a(bArr, a2);
            if (i != f24475b) {
                if (i != f24476c) {
                    break;
                }
                a2 += 24;
            } else {
                i = m26092a(bArr, a2 + 28);
                int i2 = a2 + 36;
                for (a2 = 0; a2 < i; a2++) {
                    int a3 = m26092a(bArr, i2 + 4);
                    int a4 = m26092a(bArr, i2 + 8);
                    int a5 = m26092a(bArr, i2 + 16);
                    i2 += 20;
                    if (m26094a(bArr, a, a3).equals("scheme")) {
                        String a6;
                        if (a4 != -1) {
                            a6 = m26094a(bArr, a, a4);
                        } else {
                            StringBuilder stringBuilder = new StringBuilder("resourceID 0x");
                            stringBuilder.append(Integer.toHexString(a5));
                            a6 = stringBuilder.toString();
                        }
                        Object obj = (a6 == null || a6.equals("http") || a6.equals("https") || a6.equals("geo") || a6.equals(Operation.MULTIPLY) || a6.equals("package") || a6.equals("sms") || a6.equals("smsto") || a6.equals("mms") || a6.equals("mmsto") || a6.equals("tel") || a6.equals("voicemail") || a6.equals("file") || a6.equals("content") || a6.equals("mailto")) ? null : 1;
                        if (obj != null) {
                            return a6;
                        }
                    }
                }
                a2 = i2;
            }
        }
        return "bnc_no_value";
    }

    private static String m26094a(byte[] bArr, int i, int i2) {
        if (i2 < 0) {
            return null;
        }
        i += m26092a(bArr, 36 + (i2 * 4));
        i2 = ((bArr[i + 1] << 8) & 65280) | (bArr[i] & 255);
        byte[] bArr2 = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr2[i3] = bArr[(i + 2) + (i3 * 2)];
        }
        return new String(bArr2);
    }

    private static int m26092a(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((((bArr[i + 3] << 24) & -16777216) | ((bArr[i + 2] << 16) & 16711680)) | ((bArr[i + 1] << 8) & 65280));
    }
}
