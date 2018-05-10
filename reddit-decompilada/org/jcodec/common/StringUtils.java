package org.jcodec.common;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    private static String[] splitWorker(String str, String str2, int i, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return new String[0];
        }
        int i2;
        int i3;
        String str3;
        List arrayList = new ArrayList();
        int i4;
        int i5;
        if (str2 == null) {
            str2 = null;
            String str4 = str2;
            i4 = str4;
            i5 = i4;
            i2 = 1;
            while (str2 < length) {
                if (Character.isWhitespace(str.charAt(str2))) {
                    if (str4 != null || z) {
                        i3 = i2 + 1;
                        if (i2 == i) {
                            str2 = length;
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                        arrayList.add(str.substring(i4, str2));
                        i5 = i2;
                        i2 = i3;
                        str4 = 0;
                    }
                    i4 = str2 + 1;
                    str2 = i4;
                } else {
                    str2++;
                    i5 = 0;
                    str4 = 1;
                }
            }
            i2 = i4;
            str3 = str4;
            i3 = str2;
        } else if (str2.length() == 1) {
            str2 = str2.charAt(0);
            i3 = 0;
            i2 = i3;
            str3 = i2;
            i5 = str3;
            r8 = 1;
            while (i3 < length) {
                if (str.charAt(i3) == str2) {
                    if (str3 != 0 || z) {
                        i4 = r8 + 1;
                        if (r8 == i) {
                            i3 = length;
                            i5 = 0;
                        } else {
                            i5 = 1;
                        }
                        arrayList.add(str.substring(i2, i3));
                        r8 = i4;
                        str3 = 0;
                    }
                    i2 = i3 + 1;
                    i3 = i2;
                } else {
                    i3++;
                    i5 = 0;
                    str3 = 1;
                }
            }
        } else {
            i3 = 0;
            i2 = i3;
            str3 = i2;
            i5 = str3;
            r8 = 1;
            while (i3 < length) {
                if (str2.indexOf(str.charAt(i3)) >= 0) {
                    if (str3 != 0 || z) {
                        i4 = r8 + 1;
                        if (r8 == i) {
                            i3 = length;
                            i5 = 0;
                        } else {
                            i5 = 1;
                        }
                        arrayList.add(str.substring(i2, i3));
                        r8 = i4;
                        str3 = 0;
                    }
                    i2 = i3 + 1;
                    i3 = i2;
                } else {
                    i3++;
                    i5 = 0;
                    str3 = 1;
                }
            }
        }
        if (str3 != null || (z && r7 != 0)) {
            arrayList.add(str.substring(i2, i3));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static String[] splitWorker(String str, char c, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return new String[0];
        }
        List arrayList = new ArrayList();
        int i = 0;
        int i2 = i;
        int i3 = i2;
        int i4 = i3;
        while (i < length) {
            if (str.charAt(i) == c) {
                if (i2 != 0 || z) {
                    arrayList.add(str.substring(i3, i));
                    i2 = 0;
                    i4 = 1;
                }
                i3 = i + 1;
                i = i3;
            } else {
                i++;
                i4 = 0;
                i2 = 1;
            }
        }
        if (i2 != 0 || (z && r7 != 0)) {
            arrayList.add(str.substring(i3, i));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] split(String str) {
        return split(str, null, -1);
    }

    public static String[] split(String str, String str2) {
        return splitWorker(str, str2, -1, false);
    }

    public static String[] split(String str, String str2, int i) {
        return splitWorker(str, str2, i, false);
    }

    public static String[] split(String str, char c) {
        return splitWorker(str, c, false);
    }

    public static boolean isEmpty(String str) {
        if (str != null) {
            if (str.length() != null) {
                return null;
            }
        }
        return true;
    }

    private static boolean isDelimiter(char c, char[] cArr) {
        if (cArr == null) {
            return Character.isWhitespace(c);
        }
        for (char c2 : cArr) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }

    public static String capitaliseAllWords(String str) {
        return capitalize(str);
    }

    public static String capitalize(String str) {
        return capitalize(str, null);
    }

    public static String capitalize(String str, char[] cArr) {
        int length = cArr == null ? -1 : cArr.length;
        if (!(str == null || str.length() == 0)) {
            if (length != 0) {
                length = str.length();
                StringBuffer stringBuffer = new StringBuffer(length);
                Object obj = 1;
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (isDelimiter(charAt, cArr)) {
                        stringBuffer.append(charAt);
                        obj = 1;
                    } else if (obj != null) {
                        stringBuffer.append(Character.toTitleCase(charAt));
                        obj = null;
                    } else {
                        stringBuffer.append(charAt);
                    }
                }
                return stringBuffer.toString();
            }
        }
        return str;
    }

    public static String join(Object[] objArr) {
        return join(objArr, null);
    }

    public static String join(Object[] objArr, char c) {
        return objArr == null ? null : join(objArr, c, 0, objArr.length);
    }

    public static String join(Object[] objArr, char c, int i, int i2) {
        if (objArr == null) {
            return null;
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(i3 * ((objArr[i] == null ? 16 : objArr[i].toString().length()) + 1));
        for (i3 = i; i3 < i2; i3++) {
            if (i3 > i) {
                stringBuffer.append(c);
            }
            if (objArr[i3] != null) {
                stringBuffer.append(objArr[i3]);
            }
        }
        return stringBuffer.toString();
    }

    public static String join(Object[] objArr, String str) {
        return objArr == null ? null : join(objArr, str, 0, objArr.length);
    }

    public static String join(Object[] objArr, String str, int i, int i2) {
        if (objArr == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(i3 * ((objArr[i] == null ? 16 : objArr[i].toString().length()) + str.length()));
        for (i3 = i; i3 < i2; i3++) {
            if (i3 > i) {
                stringBuffer.append(str);
            }
            if (objArr[i3] != null) {
                stringBuffer.append(objArr[i3]);
            }
        }
        return stringBuffer.toString();
    }
}
