package com.sendbird.android.shadow.com.google.gson.internal.bind;

import com.sendbird.android.shadow.com.google.gson.FieldNamingStrategy;
import com.sendbird.android.shadow.com.google.gson.Gson;
import com.sendbird.android.shadow.com.google.gson.JsonSyntaxException;
import com.sendbird.android.shadow.com.google.gson.TypeAdapter;
import com.sendbird.android.shadow.com.google.gson.TypeAdapterFactory;
import com.sendbird.android.shadow.com.google.gson.annotations.JsonAdapter;
import com.sendbird.android.shadow.com.google.gson.annotations.SerializedName;
import com.sendbird.android.shadow.com.google.gson.internal.C$Gson$Types;
import com.sendbird.android.shadow.com.google.gson.internal.ConstructorConstructor;
import com.sendbird.android.shadow.com.google.gson.internal.Excluder;
import com.sendbird.android.shadow.com.google.gson.internal.ObjectConstructor;
import com.sendbird.android.shadow.com.google.gson.internal.Primitives;
import com.sendbird.android.shadow.com.google.gson.reflect.TypeToken;
import com.sendbird.android.shadow.com.google.gson.stream.JsonReader;
import com.sendbird.android.shadow.com.google.gson.stream.JsonToken;
import com.sendbird.android.shadow.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor f30320a;
    private final FieldNamingStrategy f30321b;
    private final Excluder f30322c;
    private final JsonAdapterAnnotationTypeAdapterFactory f30323d;

    static abstract class BoundField {
        final String f22938h;
        final boolean f22939i;
        final boolean f22940j;

        abstract void mo5283a(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException;

        abstract void mo5284a(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException;

        abstract boolean mo5285a(Object obj) throws IOException, IllegalAccessException;

        protected BoundField(String str, boolean z, boolean z2) {
            this.f22938h = str;
            this.f22939i = z;
            this.f22940j = z2;
        }
    }

    public static final class Adapter<T> extends TypeAdapter<T> {
        private final ObjectConstructor<T> f30318a;
        private final Map<String, BoundField> f30319b;

        Adapter(ObjectConstructor<T> objectConstructor, Map<String, BoundField> map) {
            this.f30318a = objectConstructor;
            this.f30319b = map;
        }

        public final T mo5241a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo5258f() == JsonToken.NULL) {
                jsonReader.mo5263k();
                return null;
            }
            Object a = this.f30318a.mo5249a();
            try {
                jsonReader.mo5254c();
                while (jsonReader.mo5257e()) {
                    BoundField boundField = (BoundField) this.f30319b.get(jsonReader.mo5260h());
                    if (boundField != null) {
                        if (boundField.f22940j) {
                            boundField.mo5283a(jsonReader, a);
                        }
                    }
                    jsonReader.mo5267o();
                }
                jsonReader.mo5256d();
                return a;
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            } catch (JsonReader jsonReader2) {
                throw new AssertionError(jsonReader2);
            }
        }

        public final void mo5242a(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.mo5281e();
                return;
            }
            jsonWriter.mo5278c();
            try {
                for (BoundField boundField : this.f30319b.values()) {
                    if (boundField.mo5285a(t)) {
                        jsonWriter.mo5274a(boundField.f22938h);
                        boundField.mo5284a(jsonWriter, (Object) t);
                    }
                }
                jsonWriter.mo5280d();
            } catch (JsonWriter jsonWriter2) {
                throw new AssertionError(jsonWriter2);
            }
        }
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.f30320a = constructorConstructor;
        this.f30321b = fieldNamingStrategy;
        this.f30322c = excluder;
        this.f30323d = jsonAdapterAnnotationTypeAdapterFactory;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m31229a(java.lang.reflect.Field r9, boolean r10) {
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
        r0 = r8.f30322c;
        r1 = r9.getType();
        r1 = r0.m31165a(r1, r10);
        r2 = 0;
        if (r1 != 0) goto L_0x00a6;
    L_0x000d:
        r1 = r0.f30270c;
        r3 = r9.getModifiers();
        r1 = r1 & r3;
        r3 = 1;
        if (r1 == 0) goto L_0x001a;
    L_0x0017:
        r9 = r3;
        goto L_0x00a3;
    L_0x001a:
        r4 = r0.f30269b;
        r6 = -4616189618054758400; // 0xbff0000000000000 float:0.0 double:-1.0;
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 == 0) goto L_0x0039;
    L_0x0022:
        r1 = com.sendbird.android.shadow.com.google.gson.annotations.Since.class;
        r1 = r9.getAnnotation(r1);
        r1 = (com.sendbird.android.shadow.com.google.gson.annotations.Since) r1;
        r4 = com.sendbird.android.shadow.com.google.gson.annotations.Until.class;
        r4 = r9.getAnnotation(r4);
        r4 = (com.sendbird.android.shadow.com.google.gson.annotations.Until) r4;
        r1 = r0.m31164a(r1, r4);
        if (r1 != 0) goto L_0x0039;
    L_0x0038:
        goto L_0x0017;
    L_0x0039:
        r1 = r9.isSynthetic();
        if (r1 == 0) goto L_0x0040;
    L_0x003f:
        goto L_0x0017;
    L_0x0040:
        r1 = r0.f30272e;
        if (r1 == 0) goto L_0x005e;
    L_0x0044:
        r1 = com.sendbird.android.shadow.com.google.gson.annotations.Expose.class;
        r1 = r9.getAnnotation(r1);
        r1 = (com.sendbird.android.shadow.com.google.gson.annotations.Expose) r1;
        if (r1 == 0) goto L_0x0017;
    L_0x004e:
        if (r10 == 0) goto L_0x0057;
    L_0x0050:
        r1 = r1.m25085a();
        if (r1 != 0) goto L_0x005e;
    L_0x0056:
        goto L_0x005d;
    L_0x0057:
        r1 = r1.m25086b();
        if (r1 != 0) goto L_0x005e;
    L_0x005d:
        goto L_0x0017;
    L_0x005e:
        r1 = r0.f30271d;
        if (r1 != 0) goto L_0x006d;
    L_0x0062:
        r1 = r9.getType();
        r1 = com.sendbird.android.shadow.com.google.gson.internal.Excluder.m31162b(r1);
        if (r1 == 0) goto L_0x006d;
    L_0x006c:
        goto L_0x0017;
    L_0x006d:
        r1 = r9.getType();
        r1 = com.sendbird.android.shadow.com.google.gson.internal.Excluder.m31161a(r1);
        if (r1 == 0) goto L_0x0078;
    L_0x0077:
        goto L_0x0017;
    L_0x0078:
        if (r10 == 0) goto L_0x007d;
    L_0x007a:
        r10 = r0.f30273f;
        goto L_0x007f;
    L_0x007d:
        r10 = r0.f30274g;
    L_0x007f:
        r0 = r10.isEmpty();
        if (r0 != 0) goto L_0x00a2;
    L_0x0085:
        r0 = new com.sendbird.android.shadow.com.google.gson.FieldAttributes;
        r0.<init>(r9);
        r9 = r10.iterator();
    L_0x008e:
        r10 = r9.hasNext();
        if (r10 == 0) goto L_0x00a2;
    L_0x0094:
        r10 = r9.next();
        r10 = (com.sendbird.android.shadow.com.google.gson.ExclusionStrategy) r10;
        r10 = r10.m25057a();
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
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.a(java.lang.reflect.Field, boolean):boolean");
    }

    private List<String> m31227a(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            return Collections.singletonList(this.f30321b.mo6544a(field));
        }
        field = serializedName.m25089a();
        String[] b = serializedName.m25090b();
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

    private Map<String, BoundField> m31228a(Gson gson, TypeToken<?> typeToken, Class<?> cls) {
        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory = this;
        Gson gson2 = gson;
        Map<String, BoundField> linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        TypeToken<?> typeToken2 = typeToken;
        Type type = typeToken2.f22997b;
        Class cls2 = cls;
        TypeToken typeToken3 = typeToken2;
        while (cls2 != Object.class) {
            Type type2;
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
                Type type3;
                Field field = declaredFields[i];
                boolean a = reflectiveTypeAdapterFactory.m31229a(field, true);
                boolean a2 = reflectiveTypeAdapterFactory.m31229a(field, z);
                if (!a) {
                    if (!a2) {
                        i2 = i;
                        i3 = length;
                        z2 = z;
                        fieldArr = declaredFields;
                        typeToken4 = typeToken3;
                        type2 = type;
                        cls3 = cls2;
                        i = i2 + 1;
                        type = type2;
                        typeToken3 = typeToken4;
                        cls2 = cls3;
                        declaredFields = fieldArr;
                        z = z2;
                        length = i3;
                        reflectiveTypeAdapterFactory = this;
                        gson2 = gson;
                    }
                }
                field.setAccessible(true);
                Type a3 = C$Gson$Types.m25099a(typeToken3.f22997b, cls2, field.getGenericType());
                List a4 = reflectiveTypeAdapterFactory.m31227a(field);
                int size = a4.size();
                boolean z3 = a;
                int i4 = z;
                cls3 = cls2;
                BoundField boundField = null;
                while (i4 < size) {
                    type3 = type;
                    String str = (String) a4.get(i4);
                    if (i4 != 0) {
                        z3 = z;
                    }
                    fieldArr = declaredFields;
                    final TypeToken a5 = TypeToken.m25142a(a3);
                    boolean a6 = Primitives.m25124a(a5.f22996a);
                    JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
                    TypeAdapter a7 = jsonAdapter != null ? JsonAdapterAnnotationTypeAdapterFactory.m31181a(reflectiveTypeAdapterFactory.f30320a, gson2, a5, jsonAdapter) : null;
                    z = a7 != null;
                    if (a7 == null) {
                        a7 = gson2.m25062a(a5);
                    }
                    int i5 = i4;
                    int i6 = size;
                    List list = a4;
                    Type type4 = a3;
                    C24461 c24461 = r0;
                    Field field2 = field;
                    i2 = i;
                    final boolean z4 = z;
                    i3 = length;
                    final TypeAdapter typeAdapter = a7;
                    final Gson gson3 = gson2;
                    typeToken4 = typeToken3;
                    final boolean z5 = a6;
                    C24461 c244612 = new BoundField(reflectiveTypeAdapterFactory, str, z3, a2) {
                        final /* synthetic */ ReflectiveTypeAdapterFactory f30317g;

                        final void mo5284a(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException {
                            TypeAdapter typeAdapter;
                            obj = field.get(obj);
                            if (z4) {
                                typeAdapter = typeAdapter;
                            } else {
                                typeAdapter = new TypeAdapterRuntimeTypeWrapper(gson3, typeAdapter, a5.f22997b);
                            }
                            typeAdapter.mo5242a(jsonWriter, obj);
                        }

                        final void mo5283a(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
                            jsonReader = typeAdapter.mo5241a(jsonReader);
                            if (jsonReader != null || !z5) {
                                field.set(obj, jsonReader);
                            }
                        }

                        public final boolean mo5285a(Object obj) throws IOException, IllegalAccessException {
                            if (this.i && field.get(obj) != obj) {
                                return true;
                            }
                            return false;
                        }
                    };
                    BoundField boundField2 = (BoundField) linkedHashMap.put(str, c24461);
                    if (boundField == null) {
                        boundField = boundField2;
                    }
                    i4 = i5 + 1;
                    typeToken3 = typeToken4;
                    type = type3;
                    declaredFields = fieldArr;
                    int i7 = 1;
                    z = false;
                    size = i6;
                    a4 = list;
                    a3 = type4;
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
                type3 = type;
                if (boundField != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(type3);
                    stringBuilder.append(" declares multiple JSON fields named ");
                    stringBuilder.append(boundField.f22938h);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                type2 = type3;
                i = i2 + 1;
                type = type2;
                typeToken3 = typeToken4;
                cls2 = cls3;
                declaredFields = fieldArr;
                z = z2;
                length = i3;
                reflectiveTypeAdapterFactory = this;
                gson2 = gson;
            }
            type2 = type;
            Class cls4 = cls2;
            typeToken3 = TypeToken.m25142a(C$Gson$Types.m25099a(typeToken3.f22997b, cls4, cls4.getGenericSuperclass()));
            cls2 = typeToken3.f22996a;
            reflectiveTypeAdapterFactory = this;
            gson2 = gson;
        }
        return linkedHashMap;
    }

    public final <T> TypeAdapter<T> mo5250a(Gson gson, TypeToken<T> typeToken) {
        Class cls = typeToken.f22996a;
        if (Object.class.isAssignableFrom(cls)) {
            return new Adapter(this.f30320a.m25110a((TypeToken) typeToken), m31228a(gson, typeToken, cls));
        }
        return null;
    }
}
