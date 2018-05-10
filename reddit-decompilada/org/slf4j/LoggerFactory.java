package org.slf4j;

import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;
import org.slf4j.helpers.NOPLoggerFactory;
import org.slf4j.helpers.SubstituteLogger;
import org.slf4j.helpers.SubstituteLoggerFactory;
import org.slf4j.helpers.Util;
import org.slf4j.impl.StaticLoggerBinder;

public final class LoggerFactory {
    static volatile int f27211a = 0;
    static SubstituteLoggerFactory f27212b = new SubstituteLoggerFactory();
    static NOPLoggerFactory f27213c = new NOPLoggerFactory();
    static boolean f27214d = Util.m28713b("slf4j.detectLoggerNameMismatch");
    private static final String[] f27215e = new String[]{"1.6", "1.7"};
    private static String f27216f = "org/slf4j/impl/StaticLoggerBinder.class";

    private LoggerFactory() {
    }

    private static void m28692a() {
        synchronized (f27212b) {
            f27212b.f33451a = true;
            for (SubstituteLogger substituteLogger : new ArrayList(f27212b.f33452b.values())) {
                substituteLogger.f33445b = m28691a(substituteLogger.f33444a);
            }
        }
    }

    private static void m28693a(Throwable th) {
        f27211a = 2;
        Util.m28712a("Failed to instantiate SLF4J LoggerFactory", th);
    }

    private static void m28695b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = f27212b;
        r0 = r0.f33453c;
        r1 = r0.size();
        r2 = new java.util.ArrayList;
        r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r2.<init>(r3);
        r4 = 0;
        r5 = r4;
    L_0x0011:
        r6 = r0.drainTo(r2, r3);
        if (r6 == 0) goto L_0x00b6;
    L_0x0017:
        r6 = r2.iterator();
    L_0x001b:
        r7 = r6.hasNext();
        if (r7 == 0) goto L_0x00b1;
    L_0x0021:
        r7 = r6.next();
        r7 = (org.slf4j.event.SubstituteLoggingEvent) r7;
        if (r7 == 0) goto L_0x0060;
    L_0x0029:
        r8 = r7.f33437c;
        r9 = r8.f33444a;
        r10 = r8.f33445b;
        r11 = 1;
        if (r10 != 0) goto L_0x0034;
    L_0x0032:
        r10 = r11;
        goto L_0x0035;
    L_0x0034:
        r10 = r4;
    L_0x0035:
        if (r10 == 0) goto L_0x003f;
    L_0x0037:
        r0 = new java.lang.IllegalStateException;
        r1 = "Delegate logger cannot be null at this state.";
        r0.<init>(r1);
        throw r0;
    L_0x003f:
        r10 = r8.f33445b;
        r10 = r10 instanceof org.slf4j.helpers.NOPLogger;
        if (r10 != 0) goto L_0x0060;
    L_0x0045:
        r10 = r8.m34238a();
        if (r10 == 0) goto L_0x005d;
    L_0x004b:
        r9 = r8.m34238a();
        if (r9 == 0) goto L_0x0060;
    L_0x0051:
        r9 = r8.f33446c;	 Catch:{ IllegalAccessException -> 0x0060, IllegalAccessException -> 0x0060, IllegalAccessException -> 0x0060 }
        r8 = r8.f33445b;	 Catch:{ IllegalAccessException -> 0x0060, IllegalAccessException -> 0x0060, IllegalAccessException -> 0x0060 }
        r10 = new java.lang.Object[r11];	 Catch:{ IllegalAccessException -> 0x0060, IllegalAccessException -> 0x0060, IllegalAccessException -> 0x0060 }
        r10[r4] = r7;	 Catch:{ IllegalAccessException -> 0x0060, IllegalAccessException -> 0x0060, IllegalAccessException -> 0x0060 }
        r9.invoke(r8, r10);	 Catch:{ IllegalAccessException -> 0x0060, IllegalAccessException -> 0x0060, IllegalAccessException -> 0x0060 }
        goto L_0x0060;
    L_0x005d:
        org.slf4j.helpers.Util.m28714c(r9);
    L_0x0060:
        r8 = r5 + 1;
        if (r5 != 0) goto L_0x00ae;
    L_0x0064:
        r5 = r7.f33437c;
        r5 = r5.m34238a();
        if (r5 == 0) goto L_0x008d;
    L_0x006c:
        r5 = new java.lang.StringBuilder;
        r7 = "A number (";
        r5.<init>(r7);
        r5.append(r1);
        r7 = ") of logging calls during the initialization phase have been intercepted and are";
        r5.append(r7);
        r5 = r5.toString();
        org.slf4j.helpers.Util.m28714c(r5);
        r5 = "now being replayed. These are subject to the filtering rules of the underlying logging system.";
        org.slf4j.helpers.Util.m28714c(r5);
        r5 = "See also http://www.slf4j.org/codes.html#replay";
        org.slf4j.helpers.Util.m28714c(r5);
        goto L_0x00ae;
    L_0x008d:
        r5 = r7.f33437c;
        r5 = r5.f33445b;
        r5 = r5 instanceof org.slf4j.helpers.NOPLogger;
        if (r5 != 0) goto L_0x00ae;
    L_0x0095:
        r5 = "The following set of substitute loggers may have been accessed";
        org.slf4j.helpers.Util.m28714c(r5);
        r5 = "during the initialization phase. Logging calls during this";
        org.slf4j.helpers.Util.m28714c(r5);
        r5 = "phase were not honored. However, subsequent logging calls to these";
        org.slf4j.helpers.Util.m28714c(r5);
        r5 = "loggers will work as normally expected.";
        org.slf4j.helpers.Util.m28714c(r5);
        r5 = "See also http://www.slf4j.org/codes.html#substituteLogger";
        org.slf4j.helpers.Util.m28714c(r5);
    L_0x00ae:
        r5 = r8;
        goto L_0x001b;
    L_0x00b1:
        r2.clear();
        goto L_0x0011;
    L_0x00b6:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.slf4j.LoggerFactory.b():void");
    }

    private static final void m28696c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = org.slf4j.impl.StaticLoggerBinder.f27230a;	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
        r1 = f27215e;	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
        r2 = r1.length;	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
        r3 = 0;	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
        r4 = r3;	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
    L_0x0007:
        if (r3 >= r2) goto L_0x0015;	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
    L_0x0009:
        r5 = r1[r3];	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
        r5 = r0.startsWith(r5);	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
        if (r5 == 0) goto L_0x0012;	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
    L_0x0011:
        r4 = 1;	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
    L_0x0012:
        r3 = r3 + 1;	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
        goto L_0x0007;	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
    L_0x0015:
        if (r4 != 0) goto L_0x003f;	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
    L_0x0017:
        r1 = new java.lang.StringBuilder;	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
        r2 = "The requested version ";	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
        r1.<init>(r2);	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
        r1.append(r0);	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
        r0 = " by your slf4j binding is not compatible with ";	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
        r1.append(r0);	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
        r0 = f27215e;	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
        r0 = java.util.Arrays.asList(r0);	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
        r0 = r0.toString();	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
        r1.append(r0);	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
        r0 = r1.toString();	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
        org.slf4j.helpers.Util.m28714c(r0);	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
        r0 = "See http://www.slf4j.org/codes.html#version_mismatch for further details.";	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
        org.slf4j.helpers.Util.m28714c(r0);	 Catch:{ NoSuchFieldError -> 0x0047, Throwable -> 0x0040 }
    L_0x003f:
        return;
    L_0x0040:
        r0 = move-exception;
        r1 = "Unexpected problem occured during version sanity check";
        org.slf4j.helpers.Util.m28712a(r1, r0);
        return;
    L_0x0047:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.slf4j.LoggerFactory.c():void");
    }

    private static Set<URL> m28697d() {
        Set<URL> linkedHashSet = new LinkedHashSet();
        try {
            Enumeration systemResources;
            ClassLoader classLoader = LoggerFactory.class.getClassLoader();
            if (classLoader == null) {
                systemResources = ClassLoader.getSystemResources(f27216f);
            } else {
                systemResources = classLoader.getResources(f27216f);
            }
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add((URL) systemResources.nextElement());
            }
        } catch (Throwable e) {
            Util.m28712a("Error getting resources from path", e);
        }
        return linkedHashSet;
    }

    private static boolean m28694a(Set<URL> set) {
        return set.size() > 1 ? true : null;
    }

    public static Logger m28691a(String str) {
        return m28698e().mo6375a(str);
    }

    private static ILoggerFactory m28698e() {
        if (f27211a == 0) {
            synchronized (LoggerFactory.class) {
                if (f27211a == 0) {
                    int i = 1;
                    f27211a = 1;
                    Set set = null;
                    String a;
                    try {
                        boolean z;
                        a = Util.m28711a("java.vendor.url");
                        if (a == null) {
                            z = false;
                        } else {
                            z = a.toLowerCase().contains("android");
                        }
                        if (!z) {
                            Set<URL> d = m28697d();
                            if (m28694a((Set) d)) {
                                Util.m28714c("Class path contains multiple SLF4J bindings.");
                                for (URL url : d) {
                                    StringBuilder stringBuilder = new StringBuilder("Found binding in [");
                                    stringBuilder.append(url);
                                    stringBuilder.append("]");
                                    Util.m28714c(stringBuilder.toString());
                                }
                                Util.m28714c("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
                            }
                        }
                        StaticLoggerBinder.m28715a();
                        f27211a = 3;
                        if (set != null && m28694a(set)) {
                            StringBuilder stringBuilder2 = new StringBuilder("Actual binding is of type [");
                            StaticLoggerBinder.m28715a();
                            stringBuilder2.append(StaticLoggerBinder.m28716b());
                            stringBuilder2.append("]");
                            Util.m28714c(stringBuilder2.toString());
                        }
                        m28692a();
                        m28695b();
                        SubstituteLoggerFactory substituteLoggerFactory = f27212b;
                        substituteLoggerFactory.f33452b.clear();
                        substituteLoggerFactory.f33453c.clear();
                    } catch (Throwable e) {
                        a = e.getMessage();
                        if (a != null) {
                            if (!a.contains("org/slf4j/impl/StaticLoggerBinder")) {
                                if (a.contains("org.slf4j.impl.StaticLoggerBinder")) {
                                }
                            }
                            if (i == 0) {
                                f27211a = 4;
                                Util.m28714c("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                                Util.m28714c("Defaulting to no-operation (NOP) logger implementation");
                                Util.m28714c("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
                            } else {
                                m28693a(e);
                                throw e;
                            }
                        }
                        i = 0;
                        if (i == 0) {
                            m28693a(e);
                            throw e;
                        }
                        f27211a = 4;
                        Util.m28714c("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                        Util.m28714c("Defaulting to no-operation (NOP) logger implementation");
                        Util.m28714c("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
                    } catch (NoSuchMethodError e2) {
                        String message = e2.getMessage();
                        if (message != null && message.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                            f27211a = 2;
                            Util.m28714c("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                            Util.m28714c("Your binding is version 1.5.5 or earlier.");
                            Util.m28714c("Upgrade your binding to version 1.6.x.");
                        }
                        throw e2;
                    } catch (Throwable e3) {
                        m28693a(e3);
                        throw new IllegalStateException("Unexpected initialization failure", e3);
                    }
                    if (f27211a == 3) {
                        m28696c();
                    }
                }
            }
        }
        switch (f27211a) {
            case 1:
                return f27212b;
            case 2:
                throw new IllegalStateException("org.slf4j.LoggerFactory could not be successfully initialized. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
            case 3:
                return StaticLoggerBinder.m28715a().f27233b;
            case 4:
                return f27213c;
            default:
                throw new IllegalStateException("Unreachable code");
        }
    }
}
