package com.google.android.gms.internal;

final class zzfih {
    static String m6078a(zzfes com_google_android_gms_internal_zzfes) {
        zzfij com_google_android_gms_internal_zzfii = new zzfii(com_google_android_gms_internal_zzfes);
        StringBuilder stringBuilder = new StringBuilder(com_google_android_gms_internal_zzfii.mo1919a());
        for (int i = 0; i < com_google_android_gms_internal_zzfii.mo1919a(); i++) {
            String str;
            byte a = com_google_android_gms_internal_zzfii.mo1918a(i);
            if (a == (byte) 34) {
                str = "\\\"";
            } else if (a == (byte) 39) {
                str = "\\'";
            } else if (a != (byte) 92) {
                switch (a) {
                    case (byte) 7:
                        str = "\\a";
                        break;
                    case (byte) 8:
                        str = "\\b";
                        break;
                    case (byte) 9:
                        str = "\\t";
                        break;
                    case (byte) 10:
                        str = "\\n";
                        break;
                    case (byte) 11:
                        str = "\\v";
                        break;
                    case (byte) 12:
                        str = "\\f";
                        break;
                    case (byte) 13:
                        str = "\\r";
                        break;
                    default:
                        char c;
                        if (a < (byte) 32 || a > (byte) 126) {
                            stringBuilder.append('\\');
                            stringBuilder.append((char) (((a >>> 6) & 3) + 48));
                            stringBuilder.append((char) (((a >>> 3) & 7) + 48));
                            c = (char) (48 + (a & 7));
                        } else {
                            c = (char) a;
                        }
                        stringBuilder.append(c);
                        continue;
                }
            } else {
                str = "\\\\";
            }
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }
}
