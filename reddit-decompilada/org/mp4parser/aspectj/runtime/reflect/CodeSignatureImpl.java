package org.mp4parser.aspectj.runtime.reflect;

import org.mp4parser.aspectj.lang.reflect.CodeSignature;

abstract class CodeSignatureImpl extends MemberSignatureImpl implements CodeSignature {
    Class[] f39054a;
    String[] f39055b;
    Class[] f39056c;

    CodeSignatureImpl(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.f39054a = clsArr;
        this.f39055b = strArr;
        this.f39056c = clsArr2;
    }

    public final Class[] mo7129a() {
        if (this.f39054a == null) {
            this.f39054a = m34180c(3);
        }
        return this.f39054a;
    }

    public final Class[] m38818b() {
        if (this.f39056c == null) {
            this.f39056c = m34180c(5);
        }
        return this.f39056c;
    }
}
