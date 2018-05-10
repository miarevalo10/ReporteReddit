package com.squareup.moshi;

final class JsonScope {
    static String m25678a(int i, int[] iArr, String[] strArr, int[] iArr2) {
        StringBuilder stringBuilder = new StringBuilder("$");
        for (int i2 = 0; i2 < i; i2++) {
            switch (iArr[i2]) {
                case 1:
                case 2:
                    stringBuilder.append('[');
                    stringBuilder.append(iArr2[i2]);
                    stringBuilder.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    stringBuilder.append('.');
                    if (strArr[i2] == null) {
                        break;
                    }
                    stringBuilder.append(strArr[i2]);
                    break;
                default:
                    break;
            }
        }
        return stringBuilder.toString();
    }
}
