package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Locale;

public final class UrlTemplate {
    private final String[] f4849a;
    private final int[] f4850b;
    private final String[] f4851c;
    private final int f4852d;

    public static UrlTemplate m4009a(String str) {
        String[] strArr = new String[5];
        int[] iArr = new int[4];
        String[] strArr2 = new String[4];
        strArr[0] = "";
        int i = 0;
        int i2 = i;
        while (i < str.length()) {
            int indexOf = str.indexOf("$", i);
            int i3 = -1;
            StringBuilder stringBuilder;
            if (indexOf == -1) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(strArr[i2]);
                stringBuilder.append(str.substring(i));
                strArr[i2] = stringBuilder.toString();
                i = str.length();
            } else if (indexOf != i) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(strArr[i2]);
                stringBuilder2.append(str.substring(i, indexOf));
                strArr[i2] = stringBuilder2.toString();
                i = indexOf;
            } else if (str.startsWith("$$", i)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(strArr[i2]);
                stringBuilder.append("$");
                strArr[i2] = stringBuilder.toString();
                i += 2;
            } else {
                i++;
                indexOf = str.indexOf("$", i);
                String substring = str.substring(i, indexOf);
                if (substring.equals("RepresentationID")) {
                    iArr[i2] = 1;
                } else {
                    int indexOf2 = substring.indexOf("%0");
                    String str2 = "%01d";
                    if (indexOf2 != -1) {
                        str2 = substring.substring(indexOf2);
                        if (!str2.endsWith("d")) {
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append(str2);
                            stringBuilder3.append("d");
                            str2 = stringBuilder3.toString();
                        }
                        substring = substring.substring(0, indexOf2);
                    }
                    indexOf2 = substring.hashCode();
                    if (indexOf2 != -1950496919) {
                        if (indexOf2 != 2606829) {
                            if (indexOf2 == 38199441) {
                                if (substring.equals("Bandwidth")) {
                                    i3 = 1;
                                }
                            }
                        } else if (substring.equals("Time")) {
                            i3 = 2;
                        }
                    } else if (substring.equals("Number")) {
                        i3 = 0;
                    }
                    switch (i3) {
                        case 0:
                            iArr[i2] = 2;
                            break;
                        case 1:
                            iArr[i2] = 3;
                            break;
                        case 2:
                            iArr[i2] = 4;
                            break;
                        default:
                            StringBuilder stringBuilder4 = new StringBuilder("Invalid template: ");
                            stringBuilder4.append(str);
                            throw new IllegalArgumentException(stringBuilder4.toString());
                    }
                    strArr2[i2] = str2;
                }
                i2++;
                strArr[i2] = "";
                i = indexOf + 1;
            }
        }
        return new UrlTemplate(strArr, iArr, strArr2, i2);
    }

    private UrlTemplate(String[] strArr, int[] iArr, String[] strArr2, int i) {
        this.f4849a = strArr;
        this.f4850b = iArr;
        this.f4851c = strArr2;
        this.f4852d = i;
    }

    public final String m4010a(String str, int i, int i2, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i3 = 0; i3 < this.f4852d; i3++) {
            stringBuilder.append(this.f4849a[i3]);
            if (this.f4850b[i3] == 1) {
                stringBuilder.append(str);
            } else if (this.f4850b[i3] == 2) {
                stringBuilder.append(String.format(Locale.US, this.f4851c[i3], new Object[]{Integer.valueOf(i)}));
            } else if (this.f4850b[i3] == 3) {
                stringBuilder.append(String.format(Locale.US, this.f4851c[i3], new Object[]{Integer.valueOf(i2)}));
            } else if (this.f4850b[i3] == 4) {
                stringBuilder.append(String.format(Locale.US, this.f4851c[i3], new Object[]{Long.valueOf(j)}));
            }
        }
        stringBuilder.append(this.f4849a[this.f4852d]);
        return stringBuilder.toString();
    }
}
