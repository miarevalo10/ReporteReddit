package com.squareup.moshi;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

abstract class ClassFactory<T> {

    class C24991 extends ClassFactory<T> {
        final /* synthetic */ Constructor f30605a;
        final /* synthetic */ Class f30606b;

        C24991(Constructor constructor, Class cls) {
            this.f30605a = constructor;
            this.f30606b = cls;
        }

        public final T mo5415a() throws IllegalAccessException, InvocationTargetException, InstantiationException {
            return this.f30605a.newInstance(null);
        }

        public final String toString() {
            return this.f30606b.getName();
        }
    }

    class C25002 extends ClassFactory<T> {
        final /* synthetic */ Method f30607a;
        final /* synthetic */ Object f30608b;
        final /* synthetic */ Class f30609c;

        C25002(Method method, Object obj, Class cls) {
            this.f30607a = method;
            this.f30608b = obj;
            this.f30609c = cls;
        }

        public final T mo5415a() throws InvocationTargetException, IllegalAccessException {
            return this.f30607a.invoke(this.f30608b, new Object[]{this.f30609c});
        }

        public final String toString() {
            return this.f30609c.getName();
        }
    }

    class C25013 extends ClassFactory<T> {
        final /* synthetic */ Method f30610a;
        final /* synthetic */ Class f30611b;
        final /* synthetic */ int f30612c;

        C25013(Method method, Class cls, int i) {
            this.f30610a = method;
            this.f30611b = cls;
            this.f30612c = i;
        }

        public final T mo5415a() throws InvocationTargetException, IllegalAccessException {
            return this.f30610a.invoke(null, new Object[]{this.f30611b, Integer.valueOf(this.f30612c)});
        }

        public final String toString() {
            return this.f30611b.getName();
        }
    }

    class C25024 extends ClassFactory<T> {
        final /* synthetic */ Method f30613a;
        final /* synthetic */ Class f30614b;

        C25024(Method method, Class cls) {
            this.f30613a = method;
            this.f30614b = cls;
        }

        public final T mo5415a() throws InvocationTargetException, IllegalAccessException {
            return this.f30613a.invoke(null, new Object[]{this.f30614b, Object.class});
        }

        public final String toString() {
            return this.f30614b.getName();
        }
    }

    abstract T mo5415a() throws InvocationTargetException, IllegalAccessException, InstantiationException;

    ClassFactory() {
    }

    public static <T> com.squareup.moshi.ClassFactory<T> m25651a(java.lang.Class<?> r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = 0;
        r1 = 1;
        r2 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x0011 }
        r2 = r8.getDeclaredConstructor(r2);	 Catch:{ NoSuchMethodException -> 0x0011 }
        r2.setAccessible(r1);	 Catch:{ NoSuchMethodException -> 0x0011 }
        r3 = new com.squareup.moshi.ClassFactory$1;	 Catch:{ NoSuchMethodException -> 0x0011 }
        r3.<init>(r2, r8);	 Catch:{ NoSuchMethodException -> 0x0011 }
        return r3;
    L_0x0011:
        r2 = 0;
        r3 = "sun.misc.Unsafe";	 Catch:{ IllegalAccessException -> 0x00b4, ClassNotFoundException -> 0x0037, ClassNotFoundException -> 0x0037, ClassNotFoundException -> 0x0037 }
        r3 = java.lang.Class.forName(r3);	 Catch:{ IllegalAccessException -> 0x00b4, ClassNotFoundException -> 0x0037, ClassNotFoundException -> 0x0037, ClassNotFoundException -> 0x0037 }
        r4 = "theUnsafe";	 Catch:{ IllegalAccessException -> 0x00b4, ClassNotFoundException -> 0x0037, ClassNotFoundException -> 0x0037, ClassNotFoundException -> 0x0037 }
        r4 = r3.getDeclaredField(r4);	 Catch:{ IllegalAccessException -> 0x00b4, ClassNotFoundException -> 0x0037, ClassNotFoundException -> 0x0037, ClassNotFoundException -> 0x0037 }
        r4.setAccessible(r1);	 Catch:{ IllegalAccessException -> 0x00b4, ClassNotFoundException -> 0x0037, ClassNotFoundException -> 0x0037, ClassNotFoundException -> 0x0037 }
        r4 = r4.get(r2);	 Catch:{ IllegalAccessException -> 0x00b4, ClassNotFoundException -> 0x0037, ClassNotFoundException -> 0x0037, ClassNotFoundException -> 0x0037 }
        r5 = "allocateInstance";	 Catch:{ IllegalAccessException -> 0x00b4, ClassNotFoundException -> 0x0037, ClassNotFoundException -> 0x0037, ClassNotFoundException -> 0x0037 }
        r6 = new java.lang.Class[r1];	 Catch:{ IllegalAccessException -> 0x00b4, ClassNotFoundException -> 0x0037, ClassNotFoundException -> 0x0037, ClassNotFoundException -> 0x0037 }
        r7 = java.lang.Class.class;	 Catch:{ IllegalAccessException -> 0x00b4, ClassNotFoundException -> 0x0037, ClassNotFoundException -> 0x0037, ClassNotFoundException -> 0x0037 }
        r6[r0] = r7;	 Catch:{ IllegalAccessException -> 0x00b4, ClassNotFoundException -> 0x0037, ClassNotFoundException -> 0x0037, ClassNotFoundException -> 0x0037 }
        r3 = r3.getMethod(r5, r6);	 Catch:{ IllegalAccessException -> 0x00b4, ClassNotFoundException -> 0x0037, ClassNotFoundException -> 0x0037, ClassNotFoundException -> 0x0037 }
        r5 = new com.squareup.moshi.ClassFactory$2;	 Catch:{ IllegalAccessException -> 0x00b4, ClassNotFoundException -> 0x0037, ClassNotFoundException -> 0x0037, ClassNotFoundException -> 0x0037 }
        r5.<init>(r3, r4, r8);	 Catch:{ IllegalAccessException -> 0x00b4, ClassNotFoundException -> 0x0037, ClassNotFoundException -> 0x0037, ClassNotFoundException -> 0x0037 }
        return r5;
    L_0x0037:
        r3 = 2;
        r4 = java.io.ObjectStreamClass.class;	 Catch:{ IllegalAccessException -> 0x00ae, InvocationTargetException -> 0x00a7, NoSuchMethodException -> 0x0074 }
        r5 = "getConstructorId";	 Catch:{ IllegalAccessException -> 0x00ae, InvocationTargetException -> 0x00a7, NoSuchMethodException -> 0x0074 }
        r6 = new java.lang.Class[r1];	 Catch:{ IllegalAccessException -> 0x00ae, InvocationTargetException -> 0x00a7, NoSuchMethodException -> 0x0074 }
        r7 = java.lang.Class.class;	 Catch:{ IllegalAccessException -> 0x00ae, InvocationTargetException -> 0x00a7, NoSuchMethodException -> 0x0074 }
        r6[r0] = r7;	 Catch:{ IllegalAccessException -> 0x00ae, InvocationTargetException -> 0x00a7, NoSuchMethodException -> 0x0074 }
        r4 = r4.getDeclaredMethod(r5, r6);	 Catch:{ IllegalAccessException -> 0x00ae, InvocationTargetException -> 0x00a7, NoSuchMethodException -> 0x0074 }
        r4.setAccessible(r1);	 Catch:{ IllegalAccessException -> 0x00ae, InvocationTargetException -> 0x00a7, NoSuchMethodException -> 0x0074 }
        r5 = new java.lang.Object[r1];	 Catch:{ IllegalAccessException -> 0x00ae, InvocationTargetException -> 0x00a7, NoSuchMethodException -> 0x0074 }
        r6 = java.lang.Object.class;	 Catch:{ IllegalAccessException -> 0x00ae, InvocationTargetException -> 0x00a7, NoSuchMethodException -> 0x0074 }
        r5[r0] = r6;	 Catch:{ IllegalAccessException -> 0x00ae, InvocationTargetException -> 0x00a7, NoSuchMethodException -> 0x0074 }
        r2 = r4.invoke(r2, r5);	 Catch:{ IllegalAccessException -> 0x00ae, InvocationTargetException -> 0x00a7, NoSuchMethodException -> 0x0074 }
        r2 = (java.lang.Integer) r2;	 Catch:{ IllegalAccessException -> 0x00ae, InvocationTargetException -> 0x00a7, NoSuchMethodException -> 0x0074 }
        r2 = r2.intValue();	 Catch:{ IllegalAccessException -> 0x00ae, InvocationTargetException -> 0x00a7, NoSuchMethodException -> 0x0074 }
        r4 = java.io.ObjectStreamClass.class;	 Catch:{ IllegalAccessException -> 0x00ae, InvocationTargetException -> 0x00a7, NoSuchMethodException -> 0x0074 }
        r5 = "newInstance";	 Catch:{ IllegalAccessException -> 0x00ae, InvocationTargetException -> 0x00a7, NoSuchMethodException -> 0x0074 }
        r6 = new java.lang.Class[r3];	 Catch:{ IllegalAccessException -> 0x00ae, InvocationTargetException -> 0x00a7, NoSuchMethodException -> 0x0074 }
        r7 = java.lang.Class.class;	 Catch:{ IllegalAccessException -> 0x00ae, InvocationTargetException -> 0x00a7, NoSuchMethodException -> 0x0074 }
        r6[r0] = r7;	 Catch:{ IllegalAccessException -> 0x00ae, InvocationTargetException -> 0x00a7, NoSuchMethodException -> 0x0074 }
        r7 = java.lang.Integer.TYPE;	 Catch:{ IllegalAccessException -> 0x00ae, InvocationTargetException -> 0x00a7, NoSuchMethodException -> 0x0074 }
        r6[r1] = r7;	 Catch:{ IllegalAccessException -> 0x00ae, InvocationTargetException -> 0x00a7, NoSuchMethodException -> 0x0074 }
        r4 = r4.getDeclaredMethod(r5, r6);	 Catch:{ IllegalAccessException -> 0x00ae, InvocationTargetException -> 0x00a7, NoSuchMethodException -> 0x0074 }
        r4.setAccessible(r1);	 Catch:{ IllegalAccessException -> 0x00ae, InvocationTargetException -> 0x00a7, NoSuchMethodException -> 0x0074 }
        r5 = new com.squareup.moshi.ClassFactory$3;	 Catch:{ IllegalAccessException -> 0x00ae, InvocationTargetException -> 0x00a7, NoSuchMethodException -> 0x0074 }
        r5.<init>(r4, r8, r2);	 Catch:{ IllegalAccessException -> 0x00ae, InvocationTargetException -> 0x00a7, NoSuchMethodException -> 0x0074 }
        return r5;
    L_0x0074:
        r2 = java.io.ObjectInputStream.class;	 Catch:{ Exception -> 0x008f }
        r4 = "newInstance";	 Catch:{ Exception -> 0x008f }
        r3 = new java.lang.Class[r3];	 Catch:{ Exception -> 0x008f }
        r5 = java.lang.Class.class;	 Catch:{ Exception -> 0x008f }
        r3[r0] = r5;	 Catch:{ Exception -> 0x008f }
        r0 = java.lang.Class.class;	 Catch:{ Exception -> 0x008f }
        r3[r1] = r0;	 Catch:{ Exception -> 0x008f }
        r0 = r2.getDeclaredMethod(r4, r3);	 Catch:{ Exception -> 0x008f }
        r0.setAccessible(r1);	 Catch:{ Exception -> 0x008f }
        r1 = new com.squareup.moshi.ClassFactory$4;	 Catch:{ Exception -> 0x008f }
        r1.<init>(r0, r8);	 Catch:{ Exception -> 0x008f }
        return r1;
    L_0x008f:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r2 = "cannot construct instances of ";
        r1.<init>(r2);
        r8 = r8.getName();
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x00a7:
        r8 = move-exception;
        r0 = new java.lang.RuntimeException;
        r0.<init>(r8);
        throw r0;
    L_0x00ae:
        r8 = new java.lang.AssertionError;
        r8.<init>();
        throw r8;
    L_0x00b4:
        r8 = new java.lang.AssertionError;
        r8.<init>();
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.ClassFactory.a(java.lang.Class):com.squareup.moshi.ClassFactory<T>");
    }
}
