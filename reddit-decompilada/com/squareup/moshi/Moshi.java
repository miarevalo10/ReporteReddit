package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter.Factory;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Moshi {
    static final List<Factory> f23690a;
    private final List<Factory> f23691b;
    private final ThreadLocal<List<DeferredAdapter<?>>> f23692c = new ThreadLocal();
    private final Map<Object, JsonAdapter<?>> f23693d = new LinkedHashMap();

    public static final class Builder {
        final List<Factory> f23689a = new ArrayList();

        public final Builder m25712a(Factory factory) {
            if (factory == null) {
                throw new IllegalArgumentException("factory == null");
            }
            this.f23689a.add(factory);
            return this;
        }

        public final Builder m25713a(Object obj) {
            if (obj != null) {
                return m25712a(AdapterMethodsFactory.m31580a(obj));
            }
            throw new IllegalArgumentException("adapter == null");
        }

        public final Moshi m25714a() {
            return new Moshi(this);
        }
    }

    private static class DeferredAdapter<T> extends JsonAdapter<T> {
        Object f30655a;
        JsonAdapter<T> f30656b;

        DeferredAdapter(Object obj) {
            this.f30655a = obj;
        }

        public T fromJson(JsonReader jsonReader) throws IOException {
            if (this.f30656b != null) {
                return this.f30656b.fromJson(jsonReader);
            }
            throw new IllegalStateException("Type adapter isn't ready");
        }

        public void toJson(JsonWriter jsonWriter, T t) throws IOException {
            if (this.f30656b == null) {
                throw new IllegalStateException("Type adapter isn't ready");
            }
            this.f30656b.toJson(jsonWriter, (Object) t);
        }
    }

    static {
        List arrayList = new ArrayList(5);
        f23690a = arrayList;
        arrayList.add(StandardJsonAdapters.f23694a);
        f23690a.add(CollectionJsonAdapter.f30619a);
        f23690a.add(MapJsonAdapter.f30652a);
        f23690a.add(ArrayJsonAdapter.f30602a);
        f23690a.add(ClassJsonAdapter.f30615a);
    }

    Moshi(Builder builder) {
        List arrayList = new ArrayList(builder.f23689a.size() + f23690a.size());
        arrayList.addAll(builder.f23689a);
        arrayList.addAll(f23690a);
        this.f23691b = Collections.unmodifiableList(arrayList);
    }

    public final <T> JsonAdapter<T> m25717a(Type type) {
        return m25718a(type, Util.f23711a);
    }

    public final <T> JsonAdapter<T> m25716a(Class<T> cls) {
        return m25718a(cls, Util.f23711a);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> com.squareup.moshi.JsonAdapter<T> m25718a(java.lang.reflect.Type r9, java.util.Set<? extends java.lang.annotation.Annotation> r10) {
        /*
        r8 = this;
        r9 = com.squareup.moshi.Types.m25722a(r9);
        r0 = r10.isEmpty();
        r1 = 0;
        r2 = 1;
        if (r0 == 0) goto L_0x000e;
    L_0x000c:
        r0 = r9;
        goto L_0x0019;
    L_0x000e:
        r0 = 2;
        r0 = new java.lang.Object[r0];
        r0[r1] = r9;
        r0[r2] = r10;
        r0 = java.util.Arrays.asList(r0);
    L_0x0019:
        r3 = r8.f23693d;
        monitor-enter(r3);
        r4 = r8.f23693d;	 Catch:{ all -> 0x00e0 }
        r4 = r4.get(r0);	 Catch:{ all -> 0x00e0 }
        r4 = (com.squareup.moshi.JsonAdapter) r4;	 Catch:{ all -> 0x00e0 }
        if (r4 == 0) goto L_0x0028;
    L_0x0026:
        monitor-exit(r3);	 Catch:{ all -> 0x00e0 }
        return r4;
    L_0x0028:
        monitor-exit(r3);	 Catch:{ all -> 0x00e0 }
        r3 = r8.f23692c;
        r3 = r3.get();
        r3 = (java.util.List) r3;
        if (r3 == 0) goto L_0x004c;
    L_0x0033:
        r4 = r3.size();
        r5 = r1;
    L_0x0038:
        if (r5 >= r4) goto L_0x0056;
    L_0x003a:
        r6 = r3.get(r5);
        r6 = (com.squareup.moshi.Moshi.DeferredAdapter) r6;
        r7 = r6.f30655a;
        r7 = r7.equals(r0);
        if (r7 == 0) goto L_0x0049;
    L_0x0048:
        return r6;
    L_0x0049:
        r5 = r5 + 1;
        goto L_0x0038;
    L_0x004c:
        r3 = new java.util.ArrayList;
        r3.<init>();
        r4 = r8.f23692c;
        r4.set(r3);
    L_0x0056:
        r4 = new com.squareup.moshi.Moshi$DeferredAdapter;
        r4.<init>(r0);
        r3.add(r4);
        r5 = r8.f23691b;	 Catch:{ all -> 0x00cb }
        r5 = r5.size();	 Catch:{ all -> 0x00cb }
    L_0x0064:
        if (r1 >= r5) goto L_0x009c;
    L_0x0066:
        r6 = r8.f23691b;	 Catch:{ all -> 0x00cb }
        r6 = r6.get(r1);	 Catch:{ all -> 0x00cb }
        r6 = (com.squareup.moshi.JsonAdapter.Factory) r6;	 Catch:{ all -> 0x00cb }
        r6 = r6.create(r9, r10, r8);	 Catch:{ all -> 0x00cb }
        if (r6 == 0) goto L_0x0099;
    L_0x0074:
        r4.f30656b = r6;	 Catch:{ all -> 0x00cb }
        r9 = 0;
        r4.f30655a = r9;	 Catch:{ all -> 0x00cb }
        r9 = r8.f23693d;	 Catch:{ all -> 0x00cb }
        monitor-enter(r9);	 Catch:{ all -> 0x00cb }
        r10 = r8.f23693d;	 Catch:{ all -> 0x0096 }
        r10.put(r0, r6);	 Catch:{ all -> 0x0096 }
        monitor-exit(r9);	 Catch:{ all -> 0x0096 }
        r9 = r3.size();
        r9 = r9 - r2;
        r3.remove(r9);
        r9 = r3.isEmpty();
        if (r9 == 0) goto L_0x0095;
    L_0x0090:
        r9 = r8.f23692c;
        r9.remove();
    L_0x0095:
        return r6;
    L_0x0096:
        r10 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x0096 }
        throw r10;	 Catch:{ all -> 0x00cb }
    L_0x0099:
        r1 = r1 + 1;
        goto L_0x0064;
    L_0x009c:
        r0 = r3.size();
        r0 = r0 - r2;
        r3.remove(r0);
        r0 = r3.isEmpty();
        if (r0 == 0) goto L_0x00af;
    L_0x00aa:
        r0 = r8.f23692c;
        r0.remove();
    L_0x00af:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r2 = "No JsonAdapter for ";
        r1.<init>(r2);
        r1.append(r9);
        r9 = " annotated ";
        r1.append(r9);
        r1.append(r10);
        r9 = r1.toString();
        r0.<init>(r9);
        throw r0;
    L_0x00cb:
        r9 = move-exception;
        r10 = r3.size();
        r10 = r10 - r2;
        r3.remove(r10);
        r10 = r3.isEmpty();
        if (r10 == 0) goto L_0x00df;
    L_0x00da:
        r10 = r8.f23692c;
        r10.remove();
    L_0x00df:
        throw r9;
    L_0x00e0:
        r9 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x00e0 }
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.Moshi.a(java.lang.reflect.Type, java.util.Set):com.squareup.moshi.JsonAdapter<T>");
    }

    public final <T> JsonAdapter<T> m25715a(Factory factory, Type type, Set<? extends Annotation> set) {
        type = Types.m25722a(type);
        int indexOf = this.f23691b.indexOf(factory);
        if (indexOf == -1) {
            set = new StringBuilder("Unable to skip past unknown factory ");
            set.append(factory);
            throw new IllegalArgumentException(set.toString());
        }
        factory = this.f23691b.size();
        for (indexOf++; indexOf < factory; indexOf++) {
            JsonAdapter<T> create = ((Factory) this.f23691b.get(indexOf)).create(type, set, this);
            if (create != null) {
                return create;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("No next JsonAdapter for ");
        stringBuilder.append(type);
        stringBuilder.append(" annotated ");
        stringBuilder.append(set);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
