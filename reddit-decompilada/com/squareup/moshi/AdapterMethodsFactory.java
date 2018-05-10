package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter.Factory;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

final class AdapterMethodsFactory implements Factory {
    private final List<AdapterMethod> f30600a;
    private final List<AdapterMethod> f30601b;

    static abstract class AdapterMethod {
        final Type f23621d;
        final Set<? extends Annotation> f23622e;
        final Object f23623f;
        final Method f23624g;
        final int f23625h;
        final JsonAdapter<?>[] f23626i;
        final boolean f23627j;

        AdapterMethod(Type type, Set<? extends Annotation> set, Object obj, Method method, int i, int i2, boolean z) {
            this.f23621d = Types.m25722a(type);
            this.f23622e = set;
            this.f23623f = obj;
            this.f23624g = method;
            this.f23625h = i2;
            this.f23626i = new JsonAdapter[(i - i2)];
            this.f23627j = z;
        }

        public void mo5412a(Moshi moshi, Factory factory) {
            if (this.f23626i.length > 0) {
                Type[] genericParameterTypes = this.f23624g.getGenericParameterTypes();
                Annotation[][] parameterAnnotations = this.f23624g.getParameterAnnotations();
                int length = genericParameterTypes.length;
                for (int i = this.f23625h; i < length; i++) {
                    JsonAdapter a;
                    Type type = ((ParameterizedType) genericParameterTypes[i]).getActualTypeArguments()[0];
                    Set a2 = Util.m25738a(parameterAnnotations[i]);
                    JsonAdapter[] jsonAdapterArr = this.f23626i;
                    int i2 = i - this.f23625h;
                    if (Types.m25727a(this.f23621d, type) && this.f23622e.equals(a2)) {
                        a = moshi.m25715a(factory, type, a2);
                    } else {
                        a = moshi.m25718a(type, a2);
                    }
                    jsonAdapterArr[i2] = a;
                }
            }
        }

        public void mo5411a(JsonWriter jsonWriter, Object obj) throws IOException, InvocationTargetException {
            throw new AssertionError();
        }

        public Object mo5413a(JsonReader jsonReader) throws IOException, InvocationTargetException {
            throw new AssertionError();
        }

        protected final java.lang.Object m25647a(java.lang.Object r5) throws java.lang.reflect.InvocationTargetException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r0 = r4.f23626i;
            r1 = 0;
            r2 = 1;
            r0 = r0.length;
            r0 = r0 + r2;
            r0 = new java.lang.Object[r0];
            r0[r1] = r5;
            r5 = r4.f23626i;
            r3 = r4.f23626i;
            r3 = r3.length;
            java.lang.System.arraycopy(r5, r1, r0, r2, r3);
            r5 = r4.f23624g;	 Catch:{ IllegalAccessException -> 0x001b }
            r1 = r4.f23623f;	 Catch:{ IllegalAccessException -> 0x001b }
            r5 = r5.invoke(r1, r0);	 Catch:{ IllegalAccessException -> 0x001b }
            return r5;
        L_0x001b:
            r5 = new java.lang.AssertionError;
            r5.<init>();
            throw r5;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.AdapterMethodsFactory.AdapterMethod.a(java.lang.Object):java.lang.Object");
        }

        protected final java.lang.Object m25648a(java.lang.Object r5, java.lang.Object r6) throws java.lang.reflect.InvocationTargetException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r0 = r4.f23626i;
            r1 = 0;
            r2 = 2;
            r3 = 1;
            r0 = r0.length;
            r0 = r0 + r2;
            r0 = new java.lang.Object[r0];
            r0[r1] = r5;
            r0[r3] = r6;
            r5 = r4.f23626i;
            r6 = r4.f23626i;
            r6 = r6.length;
            java.lang.System.arraycopy(r5, r1, r0, r2, r6);
            r5 = r4.f23624g;	 Catch:{ IllegalAccessException -> 0x001e }
            r6 = r4.f23623f;	 Catch:{ IllegalAccessException -> 0x001e }
            r5 = r5.invoke(r6, r0);	 Catch:{ IllegalAccessException -> 0x001e }
            return r5;
        L_0x001e:
            r5 = new java.lang.AssertionError;
            r5.<init>();
            throw r5;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.AdapterMethodsFactory.AdapterMethod.a(java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    class C24942 extends AdapterMethod {
        C24942(Type type, Set set, Object obj, Method method, int i) {
            super(type, set, obj, method, i, 2, true);
        }

        public final void mo5411a(JsonWriter jsonWriter, Object obj) throws IOException, InvocationTargetException {
            m25648a((Object) jsonWriter, obj);
        }
    }

    class C24953 extends AdapterMethod {
        final /* synthetic */ Type f30594a;
        final /* synthetic */ Set f30595b;
        private JsonAdapter<Object> f30596c;

        C24953(Type type, Set set, Object obj, Method method, int i, boolean z, Type type2, Set set2) {
            this.f30594a = type2;
            this.f30595b = set2;
            super(type, set, obj, method, i, 1, z);
        }

        public final void mo5412a(Moshi moshi, Factory factory) {
            super.mo5412a(moshi, factory);
            this.f30596c = moshi.m25718a(this.f30594a, this.f30595b);
        }

        public final void mo5411a(JsonWriter jsonWriter, Object obj) throws IOException, InvocationTargetException {
            this.f30596c.toJson(jsonWriter, m25647a(obj));
        }
    }

    class C24964 extends AdapterMethod {
        C24964(Type type, Set set, Object obj, Method method, int i) {
            super(type, set, obj, method, i, 1, true);
        }

        public final Object mo5413a(JsonReader jsonReader) throws IOException, InvocationTargetException {
            return m25647a((Object) jsonReader);
        }
    }

    class C24975 extends AdapterMethod {
        JsonAdapter<Object> f30597a;
        final /* synthetic */ Type[] f30598b;
        final /* synthetic */ Set f30599c;

        C24975(Type type, Set set, Object obj, Method method, int i, boolean z, Type[] typeArr, Set set2) {
            this.f30598b = typeArr;
            this.f30599c = set2;
            super(type, set, obj, method, i, 1, z);
        }

        public final void mo5412a(Moshi moshi, Factory factory) {
            super.mo5412a(moshi, factory);
            this.f30597a = moshi.m25718a(this.f30598b[0], this.f30599c);
        }

        public final Object mo5413a(JsonReader jsonReader) throws IOException, InvocationTargetException {
            return m25647a((Object) this.f30597a.fromJson(jsonReader));
        }
    }

    private AdapterMethodsFactory(List<AdapterMethod> list, List<AdapterMethod> list2) {
        this.f30600a = list;
        this.f30601b = list2;
    }

    public final com.squareup.moshi.JsonAdapter<?> create(java.lang.reflect.Type r10, java.util.Set<? extends java.lang.annotation.Annotation> r11, com.squareup.moshi.Moshi r12) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r9 = this;
        r0 = r9.f30600a;
        r3 = m31579a(r0, r10, r11);
        r0 = r9.f30601b;
        r6 = m31579a(r0, r10, r11);
        r0 = 0;
        if (r3 != 0) goto L_0x0012;
    L_0x000f:
        if (r6 != 0) goto L_0x0012;
    L_0x0011:
        return r0;
    L_0x0012:
        if (r3 == 0) goto L_0x0019;
    L_0x0014:
        if (r6 != 0) goto L_0x0017;
    L_0x0016:
        goto L_0x0019;
    L_0x0017:
        r4 = r0;
        goto L_0x001e;
    L_0x0019:
        r0 = r12.m25715a(r9, r10, r11);	 Catch:{ IllegalArgumentException -> 0x0033 }
        goto L_0x0017;
    L_0x001e:
        if (r3 == 0) goto L_0x0023;
    L_0x0020:
        r3.mo5412a(r12, r9);
    L_0x0023:
        if (r6 == 0) goto L_0x0028;
    L_0x0025:
        r6.mo5412a(r12, r9);
    L_0x0028:
        r0 = new com.squareup.moshi.AdapterMethodsFactory$1;
        r1 = r0;
        r2 = r9;
        r5 = r12;
        r7 = r11;
        r8 = r10;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8);
        return r0;
    L_0x0033:
        if (r3 != 0) goto L_0x0038;
    L_0x0035:
        r12 = "@ToJson";
        goto L_0x003a;
    L_0x0038:
        r12 = "@FromJson";
    L_0x003a:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r2 = "No ";
        r1.<init>(r2);
        r1.append(r12);
        r12 = " adapter for ";
        r1.append(r12);
        r1.append(r10);
        r10 = " annotated ";
        r1.append(r10);
        r1.append(r11);
        r10 = r1.toString();
        r0.<init>(r10);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.AdapterMethodsFactory.create(java.lang.reflect.Type, java.util.Set, com.squareup.moshi.Moshi):com.squareup.moshi.JsonAdapter<?>");
    }

    public static AdapterMethodsFactory m31580a(Object obj) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (Class cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            Method[] declaredMethods = cls.getDeclaredMethods();
            int i = 0;
            int length = declaredMethods.length;
            int i2 = 0;
            while (i2 < length) {
                AdapterMethod c24942;
                AnnotatedElement annotatedElement;
                StringBuilder stringBuilder;
                AdapterMethod c24953;
                int i3;
                AnnotatedElement annotatedElement2 = declaredMethods[i2];
                if (annotatedElement2.isAnnotationPresent(ToJson.class)) {
                    annotatedElement2.setAccessible(true);
                    Type genericReturnType = annotatedElement2.getGenericReturnType();
                    Type[] genericParameterTypes = annotatedElement2.getGenericParameterTypes();
                    Annotation[][] parameterAnnotations = annotatedElement2.getParameterAnnotations();
                    if (genericParameterTypes.length >= 2 && genericParameterTypes[i] == JsonWriter.class && genericReturnType == Void.TYPE && m31581a(2, genericParameterTypes)) {
                        c24942 = new C24942(genericParameterTypes[1], Util.m25738a(parameterAnnotations[1]), obj, annotatedElement2, genericParameterTypes.length);
                        annotatedElement = annotatedElement2;
                    } else if (genericParameterTypes.length != 1 || genericReturnType == Void.TYPE) {
                        annotatedElement = annotatedElement2;
                        stringBuilder = new StringBuilder("Unexpected signature for ");
                        stringBuilder.append(annotatedElement);
                        stringBuilder.append(".\n@ToJson method signatures may have one of the following structures:\n    <any access modifier> void toJson(JsonWriter writer, T value) throws <any>;\n    <any access modifier> void toJson(JsonWriter writer, JsonAdapter<any> delegate, <any more delegates>) throws <any>;\n    <any access modifier> void toJson(JsonWriter writer, T value JsonAdapter<any> delegate, <any more delegates>) throws <any>;\n    <any access modifier> R toJson(T value) throws <any>;\n");
                        throw new IllegalArgumentException(stringBuilder.toString());
                    } else {
                        Set a = Util.m25737a(annotatedElement2);
                        Object obj2 = obj;
                        AnnotatedElement annotatedElement3 = annotatedElement2;
                        boolean z = true;
                        annotatedElement = annotatedElement2;
                        c24953 = new C24953(genericParameterTypes[i], Util.m25738a(parameterAnnotations[i]), obj2, annotatedElement3, genericParameterTypes.length, Util.m25739b(parameterAnnotations[i]), genericReturnType, a);
                    }
                    c24942 = m31579a(arrayList, c24953.f23621d, c24953.f23622e);
                    if (c24942 != null) {
                        stringBuilder = new StringBuilder("Conflicting @ToJson methods:\n    ");
                        stringBuilder.append(c24942.f23624g);
                        stringBuilder.append("\n    ");
                        stringBuilder.append(c24953.f23624g);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                    arrayList.add(c24953);
                } else {
                    annotatedElement = annotatedElement2;
                }
                if (annotatedElement.isAnnotationPresent(FromJson.class)) {
                    annotatedElement.setAccessible(true);
                    Type genericReturnType2 = annotatedElement.getGenericReturnType();
                    Set a2 = Util.m25737a(annotatedElement);
                    Type[] genericParameterTypes2 = annotatedElement.getGenericParameterTypes();
                    Annotation[][] parameterAnnotations2 = annotatedElement.getParameterAnnotations();
                    if (genericParameterTypes2.length > 0 && genericParameterTypes2[0] == JsonReader.class && genericReturnType2 != Void.TYPE && m31581a(1, genericParameterTypes2)) {
                        c24942 = new C24964(genericReturnType2, a2, obj, annotatedElement, genericParameterTypes2.length);
                        i3 = 0;
                    } else if (genericParameterTypes2.length != 1 || genericReturnType2 == Void.TYPE) {
                        stringBuilder = new StringBuilder("Unexpected signature for ");
                        stringBuilder.append(annotatedElement);
                        stringBuilder.append(".\n@FromJson method signatures may have one of the following structures:\n    <any access modifier> R fromJson(JsonReader jsonReader) throws <any>;\n    <any access modifier> R fromJson(JsonReader jsonReader, JsonAdapter<any> delegate, <any more delegates>) throws <any>;\n    <any access modifier> R fromJson(T value) throws <any>;\n");
                        throw new IllegalArgumentException(stringBuilder.toString());
                    } else {
                        i3 = 0;
                        Set a3 = Util.m25738a(parameterAnnotations2[0]);
                        obj2 = obj;
                        annotatedElement3 = annotatedElement;
                        c24953 = new C24975(genericReturnType2, a2, obj2, annotatedElement3, genericParameterTypes2.length, Util.m25739b(parameterAnnotations2[0]), genericParameterTypes2, a3);
                    }
                    AdapterMethod a4 = m31579a(arrayList2, c24953.f23621d, c24953.f23622e);
                    if (a4 != null) {
                        stringBuilder = new StringBuilder("Conflicting @FromJson methods:\n    ");
                        stringBuilder.append(a4.f23624g);
                        stringBuilder.append("\n    ");
                        stringBuilder.append(c24953.f23624g);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                    arrayList2.add(c24953);
                } else {
                    i3 = 0;
                }
                i2++;
                i = i3;
            }
        }
        if (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
            return new AdapterMethodsFactory(arrayList, arrayList2);
        }
        stringBuilder = new StringBuilder("Expected at least one @ToJson or @FromJson method on ");
        stringBuilder.append(obj.getClass().getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private static boolean m31581a(int i, Type[] typeArr) {
        int length = typeArr.length;
        while (i < length) {
            if (!(typeArr[i] instanceof ParameterizedType) || ((ParameterizedType) typeArr[i]).getRawType() != JsonAdapter.class) {
                return false;
            }
            i++;
        }
        return true;
    }

    private static AdapterMethod m31579a(List<AdapterMethod> list, Type type, Set<? extends Annotation> set) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AdapterMethod adapterMethod = (AdapterMethod) list.get(i);
            if (adapterMethod.f23621d.equals(type) && adapterMethod.f23622e.equals(set)) {
                return adapterMethod;
            }
        }
        return null;
    }
}
