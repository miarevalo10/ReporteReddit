package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder f15024a = new Excluder();
    public double f15025b = -1.0d;
    public int f15026c = 136;
    public boolean f15027d = true;
    public boolean f15028e;
    public List<ExclusionStrategy> f15029f = Collections.emptyList();
    public List<ExclusionStrategy> f15030g = Collections.emptyList();

    protected final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m14966a();
    }

    public final Excluder m14966a() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean m14968a(Class<?> cls, boolean z) {
        if (this.f15025b != -1.0d && !m14967a((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            return true;
        }
        if ((!this.f15027d && m14964b(cls)) || m14963a(cls) != null) {
            return true;
        }
        cls = (z ? this.f15029f : this.f15030g).iterator();
        while (cls.hasNext()) {
            cls.next();
        }
        return null;
    }

    public static boolean m14963a(Class<?> cls) {
        return (Enum.class.isAssignableFrom(cls) || (!cls.isAnonymousClass() && cls.isLocalClass() == null)) ? null : true;
    }

    public static boolean m14964b(Class<?> cls) {
        if (cls.isMemberClass()) {
            if (((cls.getModifiers() & 8) != null ? 1 : null) == null) {
                return true;
            }
        }
        return false;
    }

    public final <T> TypeAdapter<T> mo2467a(Gson gson, TypeToken<T> typeToken) {
        Class cls = typeToken.f8834a;
        final boolean a = m14968a(cls, true);
        final boolean a2 = m14968a(cls, false);
        if (!a && !a2) {
            return null;
        }
        final Gson gson2 = gson;
        final TypeToken<T> typeToken2 = typeToken;
        return new TypeAdapter<T>(this) {
            final /* synthetic */ Excluder f15022e;
            private TypeAdapter<T> f15023f;

            public final T mo2458a(JsonReader jsonReader) throws IOException {
                if (!a2) {
                    return m14960b().mo2458a(jsonReader);
                }
                jsonReader.mo2484o();
                return null;
            }

            public final void mo2459a(JsonWriter jsonWriter, T t) throws IOException {
                if (a) {
                    jsonWriter.mo2499f();
                } else {
                    m14960b().mo2459a(jsonWriter, t);
                }
            }

            private TypeAdapter<T> m14960b() {
                TypeAdapter<T> typeAdapter = this.f15023f;
                if (typeAdapter != null) {
                    return typeAdapter;
                }
                typeAdapter = gson2.m7474a(this.f15022e, typeToken2);
                this.f15023f = typeAdapter;
                return typeAdapter;
            }
        };
    }

    public final boolean m14967a(Since since, Until until) {
        since = (since == null || since.m7519a() <= this.f15025b) ? 1 : null;
        if (since != null) {
            since = (until == null || until.m7520a() > this.f15025b) ? 1 : null;
            if (since != null) {
                return true;
            }
        }
        return false;
    }
}
