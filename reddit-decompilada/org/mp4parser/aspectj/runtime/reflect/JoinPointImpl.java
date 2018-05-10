package org.mp4parser.aspectj.runtime.reflect;

import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.lang.ProceedingJoinPoint;
import org.mp4parser.aspectj.lang.Signature;
import org.mp4parser.aspectj.lang.reflect.SourceLocation;

class JoinPointImpl implements ProceedingJoinPoint {
    Object f36233a;
    Object f36234b;
    Object[] f36235c;
    StaticPart f36236d;

    static class StaticPartImpl implements StaticPart {
        String f33404a;
        Signature f33405b;
        SourceLocation f33406c;
        private int f33407d;

        public StaticPartImpl(int i, String str, Signature signature, SourceLocation sourceLocation) {
            this.f33404a = str;
            this.f33405b = signature;
            this.f33406c = sourceLocation;
            this.f33407d = i;
        }

        public final String toString() {
            StringMaker stringMaker = StringMaker.f27191k;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(StringMaker.m28656a(this.f33404a));
            stringBuffer.append("(");
            stringBuffer.append(((SignatureImpl) this.f33405b).m34178b(stringMaker));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }
    }

    public JoinPointImpl(StaticPart staticPart, Object obj, Object obj2, Object[] objArr) {
        this.f36236d = staticPart;
        this.f36233a = obj;
        this.f36234b = obj2;
        this.f36235c = objArr;
    }

    public final Object mo6860a() {
        return this.f36234b;
    }

    public final String toString() {
        return this.f36236d.toString();
    }
}
