package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor f15076a;
    private final FieldNamingStrategy f15077b;
    private final Excluder f15078c;
    private final JsonAdapterAnnotationTypeAdapterFactory f15079d;

    static abstract class BoundField {
        final String f8777h;
        final boolean f8778i;
        final boolean f8779j;

        abstract void mo2501a(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException;

        abstract void mo2502a(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException;

        abstract boolean mo2503a(Object obj) throws IOException, IllegalAccessException;

        protected BoundField(String str, boolean z, boolean z2) {
            this.f8777h = str;
            this.f8778i = z;
            this.f8779j = z2;
        }
    }

    public static final class Adapter<T> extends TypeAdapter<T> {
        private final ObjectConstructor<T> f15074a;
        private final Map<String, BoundField> f15075b;

        Adapter(ObjectConstructor<T> objectConstructor, Map<String, BoundField> map) {
            this.f15074a = objectConstructor;
            this.f15075b = map;
        }

        public final T mo2458a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo2475f() == JsonToken.NULL) {
                jsonReader.mo2480k();
                return null;
            }
            Object a = this.f15074a.mo2466a();
            try {
                jsonReader.mo2471c();
                while (jsonReader.mo2474e()) {
                    BoundField boundField = (BoundField) this.f15075b.get(jsonReader.mo2477h());
                    if (boundField != null) {
                        if (boundField.f8779j) {
                            boundField.mo2501a(jsonReader, a);
                        }
                    }
                    jsonReader.mo2484o();
                }
                jsonReader.mo2473d();
                return a;
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            } catch (JsonReader jsonReader2) {
                throw new AssertionError(jsonReader2);
            }
        }

        public final void mo2459a(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.mo2499f();
                return;
            }
            jsonWriter.mo2497d();
            try {
                for (BoundField boundField : this.f15075b.values()) {
                    if (boundField.mo2503a(t)) {
                        jsonWriter.mo2491a(boundField.f8777h);
                        boundField.mo2502a(jsonWriter, (Object) t);
                    }
                }
                jsonWriter.mo2498e();
            } catch (JsonWriter jsonWriter2) {
                throw new AssertionError(jsonWriter2);
            }
        }
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.f15076a = constructorConstructor;
        this.f15077b = fieldNamingStrategy;
        this.f15078c = excluder;
        this.f15079d = jsonAdapterAnnotationTypeAdapterFactory;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m15033a(java.lang.reflect.Field r9, boolean r10) {
        /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:410)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.fixIterableType(LoopRegionVisitor.java:308)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkIterableForEach(LoopRegionVisitor.java:249)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.processLoopRegion(LoopRegionVisitor.java:68)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.enterRegion(LoopRegionVisitor.java:52)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:56)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:18)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.visit(LoopRegionVisitor.java:46)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r0 = r8.f15078c;
        r1 = r9.getType();
        r1 = r0.m14968a(r1, r10);
        r2 = 0;
        if (r1 != 0) goto L_0x00a6;
    L_0x000d:
        r1 = r0.f15026c;
        r3 = r9.getModifiers();
        r1 = r1 & r3;
        r3 = 1;
        if (r1 == 0) goto L_0x001a;
    L_0x0017:
        r9 = r3;
        goto L_0x00a3;
    L_0x001a:
        r4 = r0.f15025b;
        r6 = -4616189618054758400; // 0xbff0000000000000 float:0.0 double:-1.0;
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 == 0) goto L_0x0039;
    L_0x0022:
        r1 = com.google.gson.annotations.Since.class;
        r1 = r9.getAnnotation(r1);
        r1 = (com.google.gson.annotations.Since) r1;
        r4 = com.google.gson.annotations.Until.class;
        r4 = r9.getAnnotation(r4);
        r4 = (com.google.gson.annotations.Until) r4;
        r1 = r0.m14967a(r1, r4);
        if (r1 != 0) goto L_0x0039;
    L_0x0038:
        goto L_0x0017;
    L_0x0039:
        r1 = r9.isSynthetic();
        if (r1 == 0) goto L_0x0040;
    L_0x003f:
        goto L_0x0017;
    L_0x0040:
        r1 = r0.f15028e;
        if (r1 == 0) goto L_0x005e;
    L_0x0044:
        r1 = com.google.gson.annotations.Expose.class;
        r1 = r9.getAnnotation(r1);
        r1 = (com.google.gson.annotations.Expose) r1;
        if (r1 == 0) goto L_0x0017;
    L_0x004e:
        if (r10 == 0) goto L_0x0057;
    L_0x0050:
        r1 = r1.m7513a();
        if (r1 != 0) goto L_0x005e;
    L_0x0056:
        goto L_0x005d;
    L_0x0057:
        r1 = r1.m7514b();
        if (r1 != 0) goto L_0x005e;
    L_0x005d:
        goto L_0x0017;
    L_0x005e:
        r1 = r0.f15027d;
        if (r1 != 0) goto L_0x006d;
    L_0x0062:
        r1 = r9.getType();
        r1 = com.google.gson.internal.Excluder.m14964b(r1);
        if (r1 == 0) goto L_0x006d;
    L_0x006c:
        goto L_0x0017;
    L_0x006d:
        r1 = r9.getType();
        r1 = com.google.gson.internal.Excluder.m14963a(r1);
        if (r1 == 0) goto L_0x0078;
    L_0x0077:
        goto L_0x0017;
    L_0x0078:
        if (r10 == 0) goto L_0x007d;
    L_0x007a:
        r10 = r0.f15029f;
        goto L_0x007f;
    L_0x007d:
        r10 = r0.f15030g;
    L_0x007f:
        r0 = r10.isEmpty();
        if (r0 != 0) goto L_0x00a2;
    L_0x0085:
        r0 = new com.google.gson.FieldAttributes;
        r0.<init>(r9);
        r9 = r10.iterator();
    L_0x008e:
        r10 = r9.hasNext();
        if (r10 == 0) goto L_0x00a2;
    L_0x0094:
        r10 = r9.next();
        r10 = (com.google.gson.ExclusionStrategy) r10;
        r10 = r10.mo3035a(r0);
        if (r10 == 0) goto L_0x008e;
    L_0x00a0:
        goto L_0x0017;
    L_0x00a2:
        r9 = r2;
    L_0x00a3:
        if (r9 != 0) goto L_0x00a6;
    L_0x00a5:
        return r3;
    L_0x00a6:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.a(java.lang.reflect.Field, boolean):boolean");
    }

    private List<String> m15031a(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            return Collections.singletonList(this.f15077b.mo3617a(field));
        }
        field = serializedName.m7517a();
        String[] b = serializedName.m7518b();
        if (b.length == 0) {
            return Collections.singletonList(field);
        }
        List<String> arrayList = new ArrayList(b.length + 1);
        arrayList.add(field);
        for (Object add : b) {
            arrayList.add(add);
        }
        return arrayList;
    }

    private Map<String, BoundField> m15032a(Gson gson, TypeToken<?> typeToken, Class<?> cls) {
        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory = this;
        Gson gson2 = gson;
        Map<String, BoundField> linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        TypeToken<?> typeToken2 = typeToken;
        Type type = typeToken2.f8835b;
        Class cls2 = cls;
        TypeToken typeToken3 = typeToken2;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            boolean z = false;
            int length = declaredFields.length;
            int i = 0;
            while (i < length) {
                int i2;
                int i3;
                boolean z2;
                Field[] fieldArr;
                TypeToken typeToken4;
                Class cls3;
                BoundField boundField;
                Field field = declaredFields[i];
                boolean a = reflectiveTypeAdapterFactory.m15033a(field, true);
                boolean a2 = reflectiveTypeAdapterFactory.m15033a(field, z);
                if (!a) {
                    if (!a2) {
                        i2 = i;
                        i3 = length;
                        z2 = z;
                        fieldArr = declaredFields;
                        typeToken4 = typeToken3;
                        cls3 = cls2;
                        i = i2 + 1;
                        typeToken3 = typeToken4;
                        declaredFields = fieldArr;
                        z = z2;
                        cls2 = cls3;
                        length = i3;
                        reflectiveTypeAdapterFactory = this;
                        gson2 = gson;
                    }
                }
                field.setAccessible(true);
                Type a3 = C$Gson$Types.m7527a(typeToken3.f8835b, cls2, field.getGenericType());
                List a4 = reflectiveTypeAdapterFactory.m15031a(field);
                boolean z3 = a;
                int i4 = z;
                BoundField boundField2 = null;
                while (i4 < a4.size()) {
                    BoundField boundField3;
                    TypeAdapter a5;
                    String str = (String) a4.get(i4);
                    if (i4 != 0) {
                        z3 = z;
                    }
                    fieldArr = declaredFields;
                    final TypeToken a6 = TypeToken.m7571a(a3);
                    boolean a7 = Primitives.m7552a(a6.f8834a);
                    JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
                    if (jsonAdapter != null) {
                        boundField3 = boundField2;
                        a5 = JsonAdapterAnnotationTypeAdapterFactory.m14984a(reflectiveTypeAdapterFactory.f15076a, gson2, a6, jsonAdapter);
                    } else {
                        boundField3 = boundField2;
                        a5 = null;
                    }
                    z = a5 != null;
                    if (a5 == null) {
                        a5 = gson2.m7475a(a6);
                    }
                    C12381 c12381 = r0;
                    cls3 = cls2;
                    boundField = boundField3;
                    int i5 = i4;
                    List list = a4;
                    Type type2 = a3;
                    String str2 = str;
                    Field field2 = field;
                    i2 = i;
                    final boolean z4 = z;
                    i3 = length;
                    final TypeAdapter typeAdapter = a5;
                    final Gson gson3 = gson2;
                    typeToken4 = typeToken3;
                    final boolean z5 = a7;
                    C12381 c123812 = new BoundField(reflectiveTypeAdapterFactory, str, z3, a2) {
                        final /* synthetic */ ReflectiveTypeAdapterFactory f15073g;

                        final void mo2502a(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException {
                            TypeAdapter typeAdapter;
                            obj = field.get(obj);
                            if (z4) {
                                typeAdapter = typeAdapter;
                            } else {
                                typeAdapter = new TypeAdapterRuntimeTypeWrapper(gson3, typeAdapter, a6.f8835b);
                            }
                            typeAdapter.mo2459a(jsonWriter, obj);
                        }

                        final void mo2501a(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
                            jsonReader = typeAdapter.mo2458a(jsonReader);
                            if (jsonReader != null || !z5) {
                                field.set(obj, jsonReader);
                            }
                        }

                        public final boolean mo2503a(Object obj) throws IOException, IllegalAccessException {
                            if (this.i && field.get(obj) != obj) {
                                return true;
                            }
                            return false;
                        }
                    };
                    boundField2 = (BoundField) linkedHashMap.put(str2, c123812);
                    if (boundField != null) {
                        boundField2 = boundField;
                    }
                    i4 = i5 + 1;
                    typeToken3 = typeToken4;
                    declaredFields = fieldArr;
                    z = false;
                    cls2 = cls3;
                    a4 = list;
                    a3 = type2;
                    field = field2;
                    i = i2;
                    length = i3;
                    reflectiveTypeAdapterFactory = this;
                    gson2 = gson;
                }
                i2 = i;
                i3 = length;
                z2 = z;
                fieldArr = declaredFields;
                typeToken4 = typeToken3;
                cls3 = cls2;
                boundField = boundField2;
                if (boundField != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(type);
                    stringBuilder.append(" declares multiple JSON fields named ");
                    stringBuilder.append(boundField.f8777h);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                i = i2 + 1;
                typeToken3 = typeToken4;
                declaredFields = fieldArr;
                z = z2;
                cls2 = cls3;
                length = i3;
                reflectiveTypeAdapterFactory = this;
                gson2 = gson;
            }
            Class cls4 = cls2;
            typeToken3 = TypeToken.m7571a(C$Gson$Types.m7527a(typeToken3.f8835b, cls4, cls4.getGenericSuperclass()));
            cls2 = typeToken3.f8834a;
            reflectiveTypeAdapterFactory = this;
            gson2 = gson;
        }
        return linkedHashMap;
    }

    public final <T> TypeAdapter<T> mo2467a(Gson gson, TypeToken<T> typeToken) {
        Class cls = typeToken.f8834a;
        if (Object.class.isAssignableFrom(cls)) {
            return new Adapter(this.f15076a.m7537a((TypeToken) typeToken), m15032a(gson, typeToken, cls));
        }
        return null;
    }
}
