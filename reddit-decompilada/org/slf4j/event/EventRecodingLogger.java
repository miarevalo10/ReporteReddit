package org.slf4j.event;

import java.util.Queue;
import org.slf4j.Logger;
import org.slf4j.helpers.SubstituteLogger;

public class EventRecodingLogger implements Logger {
    String f33432a;
    SubstituteLogger f33433b;
    Queue<SubstituteLoggingEvent> f33434c;

    public EventRecodingLogger(SubstituteLogger substituteLogger, Queue<SubstituteLoggingEvent> queue) {
        this.f33433b = substituteLogger;
        this.f33432a = substituteLogger.f33444a;
        this.f33434c = queue;
    }

    public final void mo6368a(String str) {
        m34223a(Level.TRACE, str, null, null);
    }

    public final void mo6372b(String str) {
        m34223a(Level.INFO, str, null, null);
    }

    public final void mo6373c(String str) {
        m34223a(Level.WARN, str, null, null);
    }

    public final void mo6369a(String str, Object obj) {
        m34223a(Level.WARN, str, new Object[]{obj}, null);
    }

    public final void mo6370a(String str, Object obj, Object obj2) {
        m34223a(Level.WARN, str, new Object[]{obj, obj2}, null);
    }

    public final void mo6374d(String str) {
        m34223a(Level.ERROR, str, null, null);
    }

    public final void mo6371a(String str, Throwable th) {
        m34223a(Level.ERROR, str, null, th);
    }

    private void m34223a(Level level, String str, Object[] objArr, Throwable th) {
        SubstituteLoggingEvent substituteLoggingEvent = new SubstituteLoggingEvent();
        substituteLoggingEvent.f33441g = System.currentTimeMillis();
        substituteLoggingEvent.f33435a = level;
        substituteLoggingEvent.f33437c = this.f33433b;
        substituteLoggingEvent.f33436b = this.f33432a;
        substituteLoggingEvent.f33439e = str;
        substituteLoggingEvent.f33440f = objArr;
        substituteLoggingEvent.f33442h = th;
        substituteLoggingEvent.f33438d = Thread.currentThread().getName();
        this.f33434c.add(substituteLoggingEvent);
    }
}
