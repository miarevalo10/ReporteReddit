package com.squareup.moshi;

import com.evernote.android.state.StateSaver;
import com.squareup.moshi.JsonAdapter.Factory;
import com.squareup.moshi.JsonReader.Options;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

final class ClassJsonAdapter<T> extends JsonAdapter<T> {
    public static final Factory f30615a = new C25031();
    private final ClassFactory<T> f30616b;
    private final FieldBinding<?>[] f30617c;
    private final Options f30618d;

    static class FieldBinding<T> {
        final String f23628a;
        final Field f23629b;
        final JsonAdapter<T> f23630c;

        FieldBinding(String str, Field field, JsonAdapter<T> jsonAdapter) {
            this.f23628a = str;
            this.f23629b = field;
            this.f23630c = jsonAdapter;
        }
    }

    class C25031 implements Factory {
        C25031() {
        }

        public final JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            Class b = Types.m25728b(type);
            if (!b.isInterface()) {
                if (!b.isEnum()) {
                    if (ClassJsonAdapter.m31587a(b) && !Types.m25734f(b)) {
                        StringBuilder stringBuilder = new StringBuilder("Platform ");
                        stringBuilder.append(type);
                        stringBuilder.append(" annotated ");
                        stringBuilder.append(set);
                        stringBuilder.append(" requires explicit JsonAdapter to be registered");
                        throw new IllegalArgumentException(stringBuilder.toString());
                    } else if (set.isEmpty() == null) {
                        return null;
                    } else {
                        if (b.getEnclosingClass() == null || Modifier.isStatic(b.getModifiers()) != null) {
                            if (Modifier.isAbstract(b.getModifiers()) != null) {
                                set = new StringBuilder("Cannot serialize abstract class ");
                                set.append(b.getName());
                                throw new IllegalArgumentException(set.toString());
                            }
                            set = ClassFactory.m25651a(b);
                            Map treeMap = new TreeMap();
                            while (type != Object.class) {
                                C25031.m31586a(moshi, type, treeMap);
                                type = Types.m25732d(type);
                            }
                            return new ClassJsonAdapter(set, treeMap).nullSafe();
                        } else if (b.getSimpleName().isEmpty() != null) {
                            set = new StringBuilder("Cannot serialize anonymous class ");
                            set.append(b.getName());
                            throw new IllegalArgumentException(set.toString());
                        } else {
                            set = new StringBuilder("Cannot serialize non-static nested class ");
                            set.append(b.getName());
                            throw new IllegalArgumentException(set.toString());
                        }
                    }
                }
            }
            return null;
        }

        private static void m31586a(Moshi moshi, Type type, Map<String, FieldBinding<?>> map) {
            Class b = Types.m25728b(type);
            boolean a = ClassJsonAdapter.m31587a(b);
            for (AnnotatedElement annotatedElement : b.getDeclaredFields()) {
                boolean z;
                FieldBinding fieldBinding;
                FieldBinding fieldBinding2;
                int modifiers = annotatedElement.getModifiers();
                if (!Modifier.isStatic(modifiers)) {
                    if (!Modifier.isTransient(modifiers)) {
                        if (Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers) || !a) {
                            z = true;
                            if (z) {
                                JsonAdapter a2 = moshi.m25718a(Types.m25725a(type, b, annotatedElement.getGenericType()), Util.m25737a(annotatedElement));
                                annotatedElement.setAccessible(true);
                                Json json = (Json) annotatedElement.getAnnotation(Json.class);
                                String a3 = json == null ? json.m25653a() : annotatedElement.getName();
                                fieldBinding = new FieldBinding(a3, annotatedElement, a2);
                                fieldBinding2 = (FieldBinding) map.put(a3, fieldBinding);
                                if (fieldBinding2 != null) {
                                    type = new StringBuilder("Conflicting fields:\n    ");
                                    type.append(fieldBinding2.f23629b);
                                    type.append("\n    ");
                                    type.append(fieldBinding.f23629b);
                                    throw new IllegalArgumentException(type.toString());
                                }
                            }
                        }
                    }
                }
                z = false;
                if (z) {
                    JsonAdapter a22 = moshi.m25718a(Types.m25725a(type, b, annotatedElement.getGenericType()), Util.m25737a(annotatedElement));
                    annotatedElement.setAccessible(true);
                    Json json2 = (Json) annotatedElement.getAnnotation(Json.class);
                    if (json2 == null) {
                    }
                    fieldBinding = new FieldBinding(a3, annotatedElement, a22);
                    fieldBinding2 = (FieldBinding) map.put(a3, fieldBinding);
                    if (fieldBinding2 != null) {
                        type = new StringBuilder("Conflicting fields:\n    ");
                        type.append(fieldBinding2.f23629b);
                        type.append("\n    ");
                        type.append(fieldBinding.f23629b);
                        throw new IllegalArgumentException(type.toString());
                    }
                }
            }
        }
    }

    static boolean m31587a(Class<?> cls) {
        cls = cls.getName();
        if (!(cls.startsWith(StateSaver.ANDROID_PREFIX) || cls.startsWith(StateSaver.JAVA_PREFIX) || cls.startsWith("javax.") || cls.startsWith("kotlin."))) {
            if (cls.startsWith("scala.") == null) {
                return null;
            }
        }
        return true;
    }

    ClassJsonAdapter(ClassFactory<T> classFactory, Map<String, FieldBinding<?>> map) {
        this.f30616b = classFactory;
        this.f30617c = (FieldBinding[]) map.values().toArray(new FieldBinding[map.size()]);
        this.f30618d = Options.m25654a((String[]) map.keySet().toArray(new String[map.size()]));
    }

    public final T fromJson(com.squareup.moshi.JsonReader r4) throws java.io.IOException {
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
        r3 = this;
        r0 = r3.f30616b;	 Catch:{ InstantiationException -> 0x0058, InvocationTargetException -> 0x003f, IllegalAccessException -> 0x0039 }
        r0 = r0.mo5415a();	 Catch:{ InstantiationException -> 0x0058, InvocationTargetException -> 0x003f, IllegalAccessException -> 0x0039 }
        r4.mo5420c();	 Catch:{ IllegalAccessException -> 0x0033 }
    L_0x0009:
        r1 = r4.mo5422e();	 Catch:{ IllegalAccessException -> 0x0033 }
        if (r1 == 0) goto L_0x002f;	 Catch:{ IllegalAccessException -> 0x0033 }
    L_0x000f:
        r1 = r3.f30618d;	 Catch:{ IllegalAccessException -> 0x0033 }
        r1 = r4.mo5416a(r1);	 Catch:{ IllegalAccessException -> 0x0033 }
        r2 = -1;	 Catch:{ IllegalAccessException -> 0x0033 }
        if (r1 == r2) goto L_0x0028;	 Catch:{ IllegalAccessException -> 0x0033 }
    L_0x0018:
        r2 = r3.f30617c;	 Catch:{ IllegalAccessException -> 0x0033 }
        r1 = r2[r1];	 Catch:{ IllegalAccessException -> 0x0033 }
        r2 = r1.f23630c;	 Catch:{ IllegalAccessException -> 0x0033 }
        r2 = r2.fromJson(r4);	 Catch:{ IllegalAccessException -> 0x0033 }
        r1 = r1.f23629b;	 Catch:{ IllegalAccessException -> 0x0033 }
        r1.set(r0, r2);	 Catch:{ IllegalAccessException -> 0x0033 }
        goto L_0x0009;	 Catch:{ IllegalAccessException -> 0x0033 }
    L_0x0028:
        r4.mo5424g();	 Catch:{ IllegalAccessException -> 0x0033 }
        r4.mo5431n();	 Catch:{ IllegalAccessException -> 0x0033 }
        goto L_0x0009;	 Catch:{ IllegalAccessException -> 0x0033 }
    L_0x002f:
        r4.mo5421d();	 Catch:{ IllegalAccessException -> 0x0033 }
        return r0;
    L_0x0033:
        r4 = new java.lang.AssertionError;
        r4.<init>();
        throw r4;
    L_0x0039:
        r4 = new java.lang.AssertionError;
        r4.<init>();
        throw r4;
    L_0x003f:
        r4 = move-exception;
        r4 = r4.getTargetException();
        r0 = r4 instanceof java.lang.RuntimeException;
        if (r0 == 0) goto L_0x004b;
    L_0x0048:
        r4 = (java.lang.RuntimeException) r4;
        throw r4;
    L_0x004b:
        r0 = r4 instanceof java.lang.Error;
        if (r0 == 0) goto L_0x0052;
    L_0x004f:
        r4 = (java.lang.Error) r4;
        throw r4;
    L_0x0052:
        r0 = new java.lang.RuntimeException;
        r0.<init>(r4);
        throw r0;
    L_0x0058:
        r4 = move-exception;
        r0 = new java.lang.RuntimeException;
        r0.<init>(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.ClassJsonAdapter.fromJson(com.squareup.moshi.JsonReader):T");
    }

    public final void toJson(com.squareup.moshi.JsonWriter r6, T r7) throws java.io.IOException {
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
        r5 = this;
        r6.mo5441c();	 Catch:{ IllegalAccessException -> 0x0022 }
        r0 = r5.f30617c;	 Catch:{ IllegalAccessException -> 0x0022 }
        r1 = r0.length;	 Catch:{ IllegalAccessException -> 0x0022 }
        r2 = 0;	 Catch:{ IllegalAccessException -> 0x0022 }
    L_0x0007:
        if (r2 >= r1) goto L_0x001e;	 Catch:{ IllegalAccessException -> 0x0022 }
    L_0x0009:
        r3 = r0[r2];	 Catch:{ IllegalAccessException -> 0x0022 }
        r4 = r3.f23628a;	 Catch:{ IllegalAccessException -> 0x0022 }
        r6.mo5440b(r4);	 Catch:{ IllegalAccessException -> 0x0022 }
        r4 = r3.f23629b;	 Catch:{ IllegalAccessException -> 0x0022 }
        r4 = r4.get(r7);	 Catch:{ IllegalAccessException -> 0x0022 }
        r3 = r3.f23630c;	 Catch:{ IllegalAccessException -> 0x0022 }
        r3.toJson(r6, r4);	 Catch:{ IllegalAccessException -> 0x0022 }
        r2 = r2 + 1;	 Catch:{ IllegalAccessException -> 0x0022 }
        goto L_0x0007;	 Catch:{ IllegalAccessException -> 0x0022 }
    L_0x001e:
        r6.mo5443d();	 Catch:{ IllegalAccessException -> 0x0022 }
        return;
    L_0x0022:
        r6 = new java.lang.AssertionError;
        r6.<init>();
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.ClassJsonAdapter.toJson(com.squareup.moshi.JsonWriter, java.lang.Object):void");
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("JsonAdapter(");
        stringBuilder.append(this.f30616b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
