package org.mp4parser.aspectj.runtime.reflect;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
import org.mp4parser.aspectj.lang.Signature;

abstract class SignatureImpl implements Signature {
    private static boolean f33409a = true;
    static String[] f33410k = new String[0];
    static Class[] f33411l = new Class[0];
    private String f33412b;
    int f33413e = -1;
    String f33414f;
    String f33415g;
    Class f33416h;
    Cache f33417i;
    ClassLoader f33418j = null;

    private interface Cache {
        String mo6356a(int i);

        void mo6357a(int i, String str);
    }

    private static final class CacheImpl implements Cache {
        private SoftReference f33408a;

        public CacheImpl() {
            m34171b();
        }

        public final String mo6356a(int i) {
            String[] a = m34170a();
            if (a == null) {
                return 0;
            }
            return a[i];
        }

        public final void mo6357a(int i, String str) {
            String[] a = m34170a();
            if (a == null) {
                a = m34171b();
            }
            a[i] = str;
        }

        private String[] m34170a() {
            return (String[]) this.f33408a.get();
        }

        private String[] m34171b() {
            Object obj = new String[3];
            this.f33408a = new SoftReference(obj);
            return obj;
        }
    }

    protected abstract String mo7316a(StringMaker stringMaker);

    SignatureImpl(int i, String str, Class cls) {
        this.f33413e = i;
        this.f33414f = str;
        this.f33416h = cls;
    }

    final java.lang.String m34178b(org.mp4parser.aspectj.runtime.reflect.StringMaker r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = f33409a;
        if (r0 == 0) goto L_0x001d;
    L_0x0004:
        r0 = r2.f33417i;
        if (r0 != 0) goto L_0x0014;
    L_0x0008:
        r0 = new org.mp4parser.aspectj.runtime.reflect.SignatureImpl$CacheImpl;	 Catch:{ Throwable -> 0x0010 }
        r0.<init>();	 Catch:{ Throwable -> 0x0010 }
        r2.f33417i = r0;	 Catch:{ Throwable -> 0x0010 }
        goto L_0x001d;
    L_0x0010:
        r0 = 0;
        f33409a = r0;
        goto L_0x001d;
    L_0x0014:
        r0 = r2.f33417i;
        r1 = r3.f27201i;
        r0 = r0.mo6356a(r1);
        goto L_0x001e;
    L_0x001d:
        r0 = 0;
    L_0x001e:
        if (r0 != 0) goto L_0x0024;
    L_0x0020:
        r0 = r2.mo7316a(r3);
    L_0x0024:
        r1 = f33409a;
        if (r1 == 0) goto L_0x002f;
    L_0x0028:
        r1 = r2.f33417i;
        r3 = r3.f27201i;
        r1.mo6357a(r3, r0);
    L_0x002f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mp4parser.aspectj.runtime.reflect.SignatureImpl.b(org.mp4parser.aspectj.runtime.reflect.StringMaker):java.lang.String");
    }

    public final String toString() {
        return m34178b(StringMaker.f27191k);
    }

    public final Class m34179c() {
        if (this.f33416h == null) {
            this.f33416h = m34177b(2);
        }
        return this.f33416h;
    }

    private ClassLoader mo7129a() {
        if (this.f33418j == null) {
            this.f33418j = getClass().getClassLoader();
        }
        return this.f33418j;
    }

    final String m34175a(int i) {
        int indexOf = this.f33412b.indexOf(45);
        int i2 = 0;
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.f33412b.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.f33412b.length();
        }
        return this.f33412b.substring(i2, indexOf);
    }

    final Class m34177b(int i) {
        return Factory.m28647a(m34175a(i), mo7129a());
    }

    final Class[] m34180c(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(m34175a(i), ":");
        i = stringTokenizer.countTokens();
        Class[] clsArr = new Class[i];
        for (int i2 = 0; i2 < i; i2++) {
            clsArr[i2] = Factory.m28647a(stringTokenizer.nextToken(), mo7129a());
        }
        return clsArr;
    }
}
