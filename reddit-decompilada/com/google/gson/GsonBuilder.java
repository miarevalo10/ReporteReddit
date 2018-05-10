package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class GsonBuilder {
    public Excluder f8722a = Excluder.f15024a;
    public FieldNamingStrategy f8723b = FieldNamingPolicy.f14978a;
    public boolean f8724c = false;
    private LongSerializationPolicy f8725d = LongSerializationPolicy.f8738a;
    private final Map<Type, InstanceCreator<?>> f8726e = new HashMap();
    private final List<TypeAdapterFactory> f8727f = new ArrayList();
    private final List<TypeAdapterFactory> f8728g = new ArrayList();
    private boolean f8729h = false;
    private String f8730i;
    private int f8731j = 2;
    private int f8732k = 2;
    private boolean f8733l = false;
    private boolean f8734m = false;
    private boolean f8735n = true;
    private boolean f8736o = false;
    private boolean f8737p = false;

    public final GsonBuilder m7490a(Type type, Object obj) {
        boolean z;
        boolean z2 = obj instanceof JsonSerializer;
        if (!(z2 || (obj instanceof JsonDeserializer) || (obj instanceof InstanceCreator))) {
            if (!(obj instanceof TypeAdapter)) {
                z = false;
                C$Gson$Preconditions.m7522a(z);
                if (obj instanceof InstanceCreator) {
                    this.f8726e.put(type, (InstanceCreator) obj);
                }
                if (z2 || (obj instanceof JsonDeserializer)) {
                    this.f8727f.add(TreeTypeAdapter.m15050b(TypeToken.m7571a(type), obj));
                }
                if (obj instanceof TypeAdapter) {
                    this.f8727f.add(TypeAdapters.m7562a(TypeToken.m7571a(type), (TypeAdapter) obj));
                }
                return this;
            }
        }
        z = true;
        C$Gson$Preconditions.m7522a(z);
        if (obj instanceof InstanceCreator) {
            this.f8726e.put(type, (InstanceCreator) obj);
        }
        this.f8727f.add(TreeTypeAdapter.m15050b(TypeToken.m7571a(type), obj));
        if (obj instanceof TypeAdapter) {
            this.f8727f.add(TypeAdapters.m7562a(TypeToken.m7571a(type), (TypeAdapter) obj));
        }
        return this;
    }

    public final GsonBuilder m7489a(TypeAdapterFactory typeAdapterFactory) {
        this.f8727f.add(typeAdapterFactory);
        return this;
    }

    public final Gson m7488a() {
        Object defaultDateTypeAdapter;
        List arrayList = new ArrayList();
        arrayList.addAll(this.f8727f);
        Collections.reverse(arrayList);
        arrayList.addAll(this.f8728g);
        String str = this.f8730i;
        int i = this.f8731j;
        int i2 = this.f8732k;
        if (str == null || "".equals(str.trim())) {
            if (!(i == 2 || i2 == 2)) {
                defaultDateTypeAdapter = new DefaultDateTypeAdapter(i, i2);
            }
            return new Gson(this.f8722a, this.f8723b, this.f8726e, this.f8729h, this.f8733l, this.f8736o, this.f8735n, this.f8724c, this.f8737p, this.f8734m, this.f8725d, arrayList);
        }
        defaultDateTypeAdapter = new DefaultDateTypeAdapter(str);
        arrayList.add(TreeTypeAdapter.m15048a(TypeToken.m7570a(Date.class), defaultDateTypeAdapter));
        arrayList.add(TreeTypeAdapter.m15048a(TypeToken.m7570a(Timestamp.class), defaultDateTypeAdapter));
        arrayList.add(TreeTypeAdapter.m15048a(TypeToken.m7570a(java.sql.Date.class), defaultDateTypeAdapter));
        return new Gson(this.f8722a, this.f8723b, this.f8726e, this.f8729h, this.f8733l, this.f8736o, this.f8735n, this.f8724c, this.f8737p, this.f8734m, this.f8725d, arrayList);
    }
}
