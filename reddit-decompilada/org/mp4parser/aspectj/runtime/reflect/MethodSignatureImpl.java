package org.mp4parser.aspectj.runtime.reflect;

import java.lang.reflect.Modifier;
import org.mp4parser.aspectj.lang.reflect.MethodSignature;

class MethodSignatureImpl extends CodeSignatureImpl implements MethodSignature {
    Class f39997d;

    MethodSignatureImpl(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i, str, cls, clsArr, strArr, clsArr2);
        this.f39997d = cls2;
    }

    protected final String mo7316a(StringMaker stringMaker) {
        String modifier;
        StringBuffer stringBuffer = new StringBuffer();
        if (this.f33413e == -1) {
            this.f33413e = Integer.parseInt(m34175a(0), 16);
        }
        int i = this.f33413e;
        if (stringMaker.f27196d) {
            modifier = Modifier.toString(i);
            if (modifier.length() == 0) {
                modifier = "";
            } else {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(modifier);
                stringBuffer2.append(" ");
                modifier = stringBuffer2.toString();
            }
        } else {
            modifier = "";
        }
        stringBuffer.append(modifier);
        if (stringMaker.f27194b) {
            if (this.f39997d == null) {
                this.f39997d = m34177b(6);
            }
            stringBuffer.append(stringMaker.m28657a(this.f39997d));
        }
        if (stringMaker.f27194b) {
            stringBuffer.append(" ");
        }
        Class c = m34179c();
        if (this.f33415g == null) {
            this.f33415g = m34179c().getName();
        }
        stringBuffer.append(stringMaker.m28658a(c, this.f33415g, stringMaker.f27197e));
        stringBuffer.append(".");
        if (this.f33414f == null) {
            this.f33414f = m34175a(1);
        }
        stringBuffer.append(this.f33414f);
        Class[] a = mo7129a();
        if (a != null) {
            if (stringMaker.f27194b) {
                stringBuffer.append("(");
                stringMaker.m28659a(stringBuffer, a);
                stringBuffer.append(")");
            } else if (a.length == 0) {
                stringBuffer.append("()");
            } else {
                stringBuffer.append("(..)");
            }
        }
        a = m38818b();
        if (stringMaker.f27195c && a != null) {
            if (a.length != 0) {
                stringBuffer.append(" throws ");
                stringMaker.m28659a(stringBuffer, a);
            }
        }
        return stringBuffer.toString();
    }
}
