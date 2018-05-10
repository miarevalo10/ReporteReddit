package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;

public final class MessageFormatter {
    private static FormattingTuple m28700a(String str, Object[] objArr, Throwable th) {
        if (str == null) {
            return new FormattingTuple(null, objArr, th);
        }
        if (objArr == null) {
            return new FormattingTuple(str);
        }
        StringBuilder stringBuilder = new StringBuilder(str.length() + 50);
        int i = 0;
        int i2 = i;
        while (i < objArr.length) {
            int indexOf = str.indexOf("{}", i2);
            if (indexOf != -1) {
                int i3 = (indexOf == 0 || str.charAt(indexOf - 1) != '\\') ? 0 : 1;
                if (i3 != 0) {
                    int i4 = (indexOf < 2 || str.charAt(indexOf - 2) != '\\') ? 0 : 1;
                    if (i4 == 0) {
                        i--;
                        stringBuilder.append(str, i2, indexOf - 1);
                        stringBuilder.append('{');
                        indexOf++;
                    } else {
                        stringBuilder.append(str, i2, indexOf - 1);
                        m28701a(stringBuilder, objArr[i], new HashMap());
                        indexOf += 2;
                    }
                } else {
                    stringBuilder.append(str, i2, indexOf);
                    m28701a(stringBuilder, objArr[i], new HashMap());
                    indexOf += 2;
                }
                i2 = indexOf;
                i++;
            } else if (i2 == 0) {
                return new FormattingTuple(str, objArr, th);
            } else {
                stringBuilder.append(str, i2, str.length());
                return new FormattingTuple(stringBuilder.toString(), objArr, th);
            }
        }
        stringBuilder.append(str, i2, str.length());
        return new FormattingTuple(stringBuilder.toString(), objArr, th);
    }

    private static void m28701a(StringBuilder stringBuilder, Object obj, Map<Object[], Object> map) {
        if (obj == null) {
            stringBuilder.append("null");
        } else if (!obj.getClass().isArray()) {
            try {
                stringBuilder.append(obj.toString());
            } catch (Map<Object[], Object> map2) {
                StringBuilder stringBuilder2 = new StringBuilder("SLF4J: Failed toString() invocation on an object of type [");
                stringBuilder2.append(obj.getClass().getName());
                stringBuilder2.append("]");
                Util.m28712a(stringBuilder2.toString(), map2);
                stringBuilder.append("[FAILED toString()]");
            }
        } else if (obj instanceof boolean[]) {
            m28710a(stringBuilder, (boolean[]) obj);
        } else if (obj instanceof byte[]) {
            m28702a(stringBuilder, (byte[]) obj);
        } else if (obj instanceof char[]) {
            m28703a(stringBuilder, (char[]) obj);
        } else if (obj instanceof short[]) {
            m28709a(stringBuilder, (short[]) obj);
        } else if (obj instanceof int[]) {
            m28706a(stringBuilder, (int[]) obj);
        } else if (obj instanceof long[]) {
            m28707a(stringBuilder, (long[]) obj);
        } else if (obj instanceof float[]) {
            m28705a(stringBuilder, (float[]) obj);
        } else if (obj instanceof double[]) {
            m28704a(stringBuilder, (double[]) obj);
        } else {
            m28708a(stringBuilder, (Object[]) obj, (Map) map2);
        }
    }

    private static void m28708a(StringBuilder stringBuilder, Object[] objArr, Map<Object[], Object> map) {
        stringBuilder.append('[');
        if (map.containsKey(objArr)) {
            stringBuilder.append("...");
        } else {
            map.put(objArr, null);
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                m28701a(stringBuilder, objArr[i], (Map) map);
                if (i != length - 1) {
                    stringBuilder.append(", ");
                }
            }
            map.remove(objArr);
        }
        stringBuilder.append(93);
    }

    private static void m28710a(StringBuilder stringBuilder, boolean[] zArr) {
        stringBuilder.append('[');
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(zArr[i]);
            if (i != length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(93);
    }

    private static void m28702a(StringBuilder stringBuilder, byte[] bArr) {
        stringBuilder.append('[');
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(bArr[i]);
            if (i != length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(93);
    }

    private static void m28703a(StringBuilder stringBuilder, char[] cArr) {
        stringBuilder.append('[');
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(cArr[i]);
            if (i != length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(93);
    }

    private static void m28709a(StringBuilder stringBuilder, short[] sArr) {
        stringBuilder.append('[');
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(sArr[i]);
            if (i != length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(93);
    }

    private static void m28706a(StringBuilder stringBuilder, int[] iArr) {
        stringBuilder.append('[');
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(iArr[i]);
            if (i != length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(93);
    }

    private static void m28707a(StringBuilder stringBuilder, long[] jArr) {
        stringBuilder.append('[');
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(jArr[i]);
            if (i != length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(93);
    }

    private static void m28705a(StringBuilder stringBuilder, float[] fArr) {
        stringBuilder.append('[');
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(fArr[i]);
            if (i != length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(93);
    }

    private static void m28704a(StringBuilder stringBuilder, double[] dArr) {
        stringBuilder.append('[');
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(dArr[i]);
            if (i != length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(93);
    }

    public static final FormattingTuple m28699a(String str, Object[] objArr) {
        Throwable th = null;
        if (objArr != null) {
            if (objArr.length != 0) {
                Object obj = objArr[objArr.length - 1];
                if (obj instanceof Throwable) {
                    th = (Throwable) obj;
                }
            }
        }
        if (th != null) {
            if (objArr != null) {
                if (objArr.length != 0) {
                    int length = objArr.length - 1;
                    Object obj2 = new Object[length];
                    System.arraycopy(objArr, 0, obj2, 0, length);
                    objArr = obj2;
                }
            }
            throw new IllegalStateException("non-sensical empty or null argument array");
        }
        return m28700a(str, objArr, th);
    }
}
