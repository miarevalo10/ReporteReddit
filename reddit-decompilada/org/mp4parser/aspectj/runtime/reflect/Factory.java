package org.mp4parser.aspectj.runtime.reflect;

import java.util.Hashtable;
import java.util.StringTokenizer;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.lang.Signature;
import org.mp4parser.aspectj.lang.reflect.MethodSignature;

public final class Factory {
    static Hashtable f27183e;
    static Class f27184f;
    private static Object[] f27185g = new Object[0];
    Class f27186a;
    ClassLoader f27187b;
    String f27188c;
    int f27189d = null;

    static {
        Hashtable hashtable = new Hashtable();
        f27183e = hashtable;
        hashtable.put("void", Void.TYPE);
        f27183e.put("boolean", Boolean.TYPE);
        f27183e.put("byte", Byte.TYPE);
        f27183e.put("char", Character.TYPE);
        f27183e.put("short", Short.TYPE);
        f27183e.put("int", Integer.TYPE);
        f27183e.put("long", Long.TYPE);
        f27183e.put("float", Float.TYPE);
        f27183e.put("double", Double.TYPE);
    }

    static java.lang.Class m28647a(java.lang.String r1, java.lang.ClassLoader r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "*";
        r0 = r1.equals(r0);
        if (r0 == 0) goto L_0x000a;
    L_0x0008:
        r1 = 0;
        return r1;
    L_0x000a:
        r0 = f27183e;
        r0 = r0.get(r1);
        r0 = (java.lang.Class) r0;
        if (r0 == 0) goto L_0x0015;
    L_0x0014:
        return r0;
    L_0x0015:
        if (r2 != 0) goto L_0x001c;
    L_0x0017:
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0022 }
        return r1;	 Catch:{ ClassNotFoundException -> 0x0022 }
    L_0x001c:
        r0 = 0;	 Catch:{ ClassNotFoundException -> 0x0022 }
        r1 = java.lang.Class.forName(r1, r0, r2);	 Catch:{ ClassNotFoundException -> 0x0022 }
        return r1;
    L_0x0022:
        r1 = f27184f;
        if (r1 != 0) goto L_0x002f;
    L_0x0026:
        r1 = "java.lang.ClassNotFoundException";
        r1 = m28646a(r1);
        f27184f = r1;
        return r1;
    L_0x002f:
        r1 = f27184f;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mp4parser.aspectj.runtime.reflect.Factory.a(java.lang.String, java.lang.ClassLoader):java.lang.Class");
    }

    private static Class m28646a(String str) {
        try {
            return Class.forName(str);
        } catch (String str2) {
            throw new NoClassDefFoundError(str2.getMessage());
        }
    }

    public Factory(String str, Class cls) {
        this.f27188c = str;
        this.f27186a = cls;
        this.f27187b = cls.getClassLoader();
    }

    public final StaticPart m28652a(String str, Signature signature, int i) {
        int i2 = this.f27189d;
        this.f27189d = i2 + 1;
        return new StaticPartImpl(i2, str, signature, new SourceLocationImpl(this.f27186a, this.f27188c, i));
    }

    public static JoinPoint m28648a(StaticPart staticPart, Object obj, Object obj2) {
        return new JoinPointImpl(staticPart, obj, obj2, f27185g);
    }

    public static JoinPoint m28649a(StaticPart staticPart, Object obj, Object obj2, Object obj3) {
        return new JoinPointImpl(staticPart, obj, obj2, new Object[]{obj3});
    }

    public static JoinPoint m28650a(StaticPart staticPart, Object obj, Object obj2, Object obj3, Object obj4) {
        return new JoinPointImpl(staticPart, obj, obj2, new Object[]{obj3, obj4});
    }

    public static JoinPoint m28651a(StaticPart staticPart, Object obj, Object obj2, Object[] objArr) {
        return new JoinPointImpl(staticPart, obj, obj2, objArr);
    }

    public final MethodSignature m28653a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int parseInt = Integer.parseInt(str, 16);
        Class a = m28647a(str3, this.f27187b);
        StringTokenizer stringTokenizer = new StringTokenizer(str4, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        int i = 0;
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = m28647a(stringTokenizer.nextToken(), r0.f27187b);
        }
        stringTokenizer = new StringTokenizer(str5, ":");
        countTokens = stringTokenizer.countTokens();
        String[] strArr = new String[countTokens];
        for (int i3 = 0; i3 < countTokens; i3++) {
            strArr[i3] = stringTokenizer.nextToken();
        }
        stringTokenizer = new StringTokenizer(str6, ":");
        countTokens = stringTokenizer.countTokens();
        Class[] clsArr2 = new Class[countTokens];
        while (i < countTokens) {
            clsArr2[i] = m28647a(stringTokenizer.nextToken(), r0.f27187b);
            i++;
        }
        return new MethodSignatureImpl(parseInt, str2, a, clsArr, strArr, clsArr2, m28647a(str7, r0.f27187b));
    }
}
