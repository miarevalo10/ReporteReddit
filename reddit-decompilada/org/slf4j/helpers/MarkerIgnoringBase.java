package org.slf4j.helpers;

import org.slf4j.Logger;

public abstract class MarkerIgnoringBase extends NamedLoggerBase implements Logger {
    public /* bridge */ /* synthetic */ String mo6865a() {
        return super.mo6865a();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append("(");
        stringBuilder.append(mo6865a());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
