package org.slf4j.helpers;

import java.lang.reflect.Method;
import java.util.Queue;
import org.slf4j.Logger;
import org.slf4j.event.EventRecodingLogger;
import org.slf4j.event.SubstituteLoggingEvent;

public class SubstituteLogger implements Logger {
    public final String f33444a;
    public volatile Logger f33445b;
    public Method f33446c;
    private Boolean f33447d;
    private EventRecodingLogger f33448e;
    private Queue<SubstituteLoggingEvent> f33449f;
    private final boolean f33450g;

    public SubstituteLogger(String str, Queue<SubstituteLoggingEvent> queue, boolean z) {
        this.f33444a = str;
        this.f33449f = queue;
        this.f33450g = z;
    }

    public final void mo6368a(String str) {
        m34233b().mo6368a(str);
    }

    public final void mo6372b(String str) {
        m34233b().mo6372b(str);
    }

    public final void mo6373c(String str) {
        m34233b().mo6373c(str);
    }

    public final void mo6369a(String str, Object obj) {
        m34233b().mo6369a(str, obj);
    }

    public final void mo6370a(String str, Object obj, Object obj2) {
        m34233b().mo6370a(str, obj, obj2);
    }

    public final void mo6374d(String str) {
        m34233b().mo6374d(str);
    }

    public final void mo6371a(String str, Throwable th) {
        m34233b().mo6371a(str, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                return this.f33444a.equals(((SubstituteLogger) obj).f33444a) != null;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f33444a.hashCode();
    }

    private Logger m34233b() {
        if (this.f33445b != null) {
            return this.f33445b;
        }
        if (this.f33450g) {
            return NOPLogger.f39057a;
        }
        if (this.f33448e == null) {
            this.f33448e = new EventRecodingLogger(this, this.f33449f);
        }
        return this.f33448e;
    }

    public final boolean m34238a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r5.f33447d;
        if (r0 == 0) goto L_0x000b;
    L_0x0004:
        r0 = r5.f33447d;
        r0 = r0.booleanValue();
        return r0;
    L_0x000b:
        r0 = r5.f33445b;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r0 = r0.getClass();	 Catch:{ NoSuchMethodException -> 0x0026 }
        r1 = "log";	 Catch:{ NoSuchMethodException -> 0x0026 }
        r2 = 1;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r2 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x0026 }
        r3 = 0;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r4 = org.slf4j.event.LoggingEvent.class;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r2[r3] = r4;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r0 = r0.getMethod(r1, r2);	 Catch:{ NoSuchMethodException -> 0x0026 }
        r5.f33446c = r0;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r0 = java.lang.Boolean.TRUE;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r5.f33447d = r0;	 Catch:{ NoSuchMethodException -> 0x0026 }
        goto L_0x002a;
    L_0x0026:
        r0 = java.lang.Boolean.FALSE;
        r5.f33447d = r0;
    L_0x002a:
        r0 = r5.f33447d;
        r0 = r0.booleanValue();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.slf4j.helpers.SubstituteLogger.a():boolean");
    }
}
