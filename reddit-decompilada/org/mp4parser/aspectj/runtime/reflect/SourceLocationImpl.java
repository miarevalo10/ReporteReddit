package org.mp4parser.aspectj.runtime.reflect;

import org.mp4parser.aspectj.lang.reflect.SourceLocation;

class SourceLocationImpl implements SourceLocation {
    Class f33419a;
    String f33420b;
    int f33421c;

    SourceLocationImpl(Class cls, String str, int i) {
        this.f33419a = cls;
        this.f33420b = str;
        this.f33421c = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f33420b);
        stringBuffer.append(":");
        stringBuffer.append(this.f33421c);
        return stringBuffer.toString();
    }
}
