package org.jsoup.helper;

public final class Validate {
    public static void m28452a(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object must not be null");
        }
    }

    public static void m28453a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void m28456a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException("Must be true");
        }
    }

    public static void m28457a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void m28460b(boolean z) {
        if (z) {
            throw new IllegalArgumentException("Must be false");
        }
    }

    public static void m28461b(boolean z, String str) {
        if (z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void m28454a(String str) {
        if (str != null) {
            if (str.length() != null) {
                return;
            }
        }
        throw new IllegalArgumentException("String must not be empty");
    }

    public static void m28455a(String str, String str2) {
        if (str != null) {
            if (str.length() != null) {
                return;
            }
        }
        throw new IllegalArgumentException(str2);
    }

    public static void m28459b(String str) {
        throw new IllegalArgumentException(str);
    }

    public static void m28458a(Object[] objArr) {
        String str = "Array must not contain any null objects";
        for (int i = 0; i <= 0; i++) {
            if (objArr[0] == null) {
                throw new IllegalArgumentException(str);
            }
        }
    }
}
