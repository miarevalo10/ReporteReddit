package com.google.android.gms.internal;

import java.io.PrintStream;
import java.io.PrintWriter;

public final class zzdvl {
    private static zzdvm f7344a;
    private static int f7345b;

    static final class zza extends zzdvm {
        zza() {
        }

        public final void mo1869a(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
        }
    }

    static {
        Integer a;
        zzdvm com_google_android_gms_internal_zzdvq;
        Throwable th;
        PrintStream printStream;
        String name;
        StringBuilder stringBuilder;
        int i = 1;
        try {
            a = m5925a();
            if (a != null) {
                try {
                    if (a.intValue() >= 19) {
                        com_google_android_gms_internal_zzdvq = new zzdvq();
                        f7344a = com_google_android_gms_internal_zzdvq;
                        if (a != null) {
                            i = a.intValue();
                        }
                        f7345b = i;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    printStream = System.err;
                    name = zza.class.getName();
                    stringBuilder = new StringBuilder(132 + String.valueOf(name).length());
                    stringBuilder.append("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ");
                    stringBuilder.append(name);
                    stringBuilder.append("will be used. The error is: ");
                    printStream.println(stringBuilder.toString());
                    th.printStackTrace(System.err);
                    com_google_android_gms_internal_zzdvq = new zza();
                    f7344a = com_google_android_gms_internal_zzdvq;
                    if (a != null) {
                        i = a.intValue();
                    }
                    f7345b = i;
                }
            }
            com_google_android_gms_internal_zzdvq = (Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ^ 1) != 0 ? new zzdvp() : new zza();
        } catch (Throwable th3) {
            th = th3;
            a = null;
            printStream = System.err;
            name = zza.class.getName();
            stringBuilder = new StringBuilder(132 + String.valueOf(name).length());
            stringBuilder.append("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ");
            stringBuilder.append(name);
            stringBuilder.append("will be used. The error is: ");
            printStream.println(stringBuilder.toString());
            th.printStackTrace(System.err);
            com_google_android_gms_internal_zzdvq = new zza();
            f7344a = com_google_android_gms_internal_zzdvq;
            if (a != null) {
                i = a.intValue();
            }
            f7345b = i;
        }
        f7344a = com_google_android_gms_internal_zzdvq;
        if (a != null) {
            i = a.intValue();
        }
        f7345b = i;
    }

    private static Integer m5925a() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }

    public static void m5926a(Throwable th, PrintWriter printWriter) {
        f7344a.mo1869a(th, printWriter);
    }
}
