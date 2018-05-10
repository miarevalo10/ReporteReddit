package org.slf4j.impl;

import android.util.Log;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;

class AndroidLoggerAdapter extends MarkerIgnoringBase {
    AndroidLoggerAdapter(String str) {
        this.b = str;
    }

    public final void mo6368a(String str) {
        m38873a(3, str, null);
    }

    public final void mo6372b(String str) {
        m38873a(4, str, null);
    }

    public final void mo6373c(String str) {
        m38873a(5, str, null);
    }

    public final void mo6369a(String str, Object obj) {
        m38874a(str, obj);
    }

    public final void mo6370a(String str, Object obj, Object obj2) {
        m38874a(str, obj, obj2);
    }

    public final void mo6374d(String str) {
        m38873a(6, str, null);
    }

    public final void mo6371a(String str, Throwable th) {
        m38873a(6, str, th);
    }

    private void m38874a(String str, Object... objArr) {
        if (m38875a(5)) {
            str = MessageFormatter.m28699a(str, objArr);
            m38876b(5, str.f27226b, str.f27227c);
        }
    }

    private void m38873a(int i, String str, Throwable th) {
        if (m38875a(i)) {
            m38876b(i, str, th);
        }
    }

    private boolean m38875a(int i) {
        return Log.isLoggable(this.b, i);
    }

    private void m38876b(int i, String str, Throwable th) {
        if (th != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append('\n');
            stringBuilder.append(Log.getStackTraceString(th));
            str = stringBuilder.toString();
        }
        Log.println(i, this.b, str);
    }
}
