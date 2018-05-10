package com.google.common.base;

public final class Preconditions {
    public static void m6913a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void m6914a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void m6915a(boolean z, String str, char c) {
        if (!z) {
            throw new IllegalArgumentException(m6911a(str, Character.valueOf(c)));
        }
    }

    public static void m6916a(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalArgumentException(m6911a(str, Long.valueOf(j)));
        }
    }

    public static void m6917a(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(m6911a(str, obj));
        }
    }

    public static void m6918a(boolean z, String str, Object obj, int i) {
        if (!z) {
            throw new IllegalArgumentException(m6911a(str, obj, Integer.valueOf(i)));
        }
    }

    public static void m6919a(boolean z, String str, Object obj, Object obj2) {
        if (!z) {
            throw new IllegalArgumentException(m6911a(str, obj, obj2));
        }
    }

    public static void m6921b(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void m6922b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void m6923b(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalStateException(m6911a(str, obj));
        }
    }

    public static <T> T m6908a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static <T> T m6909a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    private static String m6910a(int i, int i2, String str) {
        if (i < 0) {
            return m6911a("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 < 0) {
            str = new StringBuilder("negative size: ");
            str.append(i2);
            throw new IllegalArgumentException(str.toString());
        } else {
            return m6911a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public static void m6912a(int i, int i2, int i3) {
        if (i >= 0 && i2 >= i) {
            if (i2 <= i3) {
                return;
            }
        }
        if (i >= 0) {
            if (i <= i3) {
                if (i2 >= 0) {
                    if (i2 <= i3) {
                        i = m6911a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
                        throw new IndexOutOfBoundsException(i);
                    }
                }
                i = m6910a(i2, i3, "end index");
                throw new IndexOutOfBoundsException(i);
            }
        }
        i = m6910a(i, i3, "start index");
        throw new IndexOutOfBoundsException(i);
    }

    static String m6911a(String str, Object... objArr) {
        str = String.valueOf(str);
        int i = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        }
        StringBuilder stringBuilder = new StringBuilder(str.length() + (16 * objArr.length));
        int i2 = 0;
        while (i < objArr.length) {
            int indexOf = str.indexOf("%s", i2);
            if (indexOf == -1) {
                break;
            }
            stringBuilder.append(str, i2, indexOf);
            i2 = i + 1;
            stringBuilder.append(objArr[i]);
            int i3 = i2;
            i2 = indexOf + 2;
            i = i3;
        }
        stringBuilder.append(str, i2, str.length());
        if (i < objArr.length) {
            stringBuilder.append(" [");
            str = i + 1;
            stringBuilder.append(objArr[i]);
            while (str < objArr.length) {
                stringBuilder.append(", ");
                i = str + 1;
                stringBuilder.append(objArr[str]);
                str = i;
            }
            stringBuilder.append(']');
        }
        return stringBuilder.toString();
    }

    public static int m6907a(int i, int i2) {
        String str = "index";
        if (i >= 0) {
            if (i < i2) {
                return i;
            }
        }
        if (i < 0) {
            i = m6911a("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 < 0) {
            StringBuilder stringBuilder = new StringBuilder("negative size: ");
            stringBuilder.append(i2);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            i = m6911a("%s (%s) must be less than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(i);
    }

    public static int m6920b(int i, int i2) {
        String str = "index";
        if (i >= 0) {
            if (i <= i2) {
                return i;
            }
        }
        throw new IndexOutOfBoundsException(m6910a(i, i2, str));
    }
}
