package com.google.android.gms.internal;

public class zzbey<T> {
    private static final Object f6687a = new Object();
    private static zzbfe f6688b = null;
    private static int f6689c = 0;
    private static String f6690d = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    private String f6691e;
    private T f6692f;
    private T f6693g = null;

    protected zzbey(String str, T t) {
        this.f6691e = str;
        this.f6692f = t;
    }

    public static zzbey<Integer> m5507a(String str, Integer num) {
        return new zzbfb(str, num);
    }

    public static zzbey<Long> m5508a(String str, Long l) {
        return new zzbfa(str, l);
    }

    public static zzbey<String> m5509a(String str, String str2) {
        return new zzbfd(str, str2);
    }

    public static zzbey<Boolean> m5510a(String str, boolean z) {
        return new zzbez(str, Boolean.valueOf(z));
    }
}
