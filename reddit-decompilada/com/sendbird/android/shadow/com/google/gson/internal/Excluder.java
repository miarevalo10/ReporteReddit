package com.sendbird.android.shadow.com.google.gson.internal;

import com.sendbird.android.shadow.com.google.gson.ExclusionStrategy;
import com.sendbird.android.shadow.com.google.gson.Gson;
import com.sendbird.android.shadow.com.google.gson.TypeAdapter;
import com.sendbird.android.shadow.com.google.gson.TypeAdapterFactory;
import com.sendbird.android.shadow.com.google.gson.annotations.Since;
import com.sendbird.android.shadow.com.google.gson.annotations.Until;
import com.sendbird.android.shadow.com.google.gson.reflect.TypeToken;
import com.sendbird.android.shadow.com.google.gson.stream.JsonReader;
import com.sendbird.android.shadow.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder f30268a = new Excluder();
    public double f30269b = -1.0d;
    public int f30270c = 136;
    public boolean f30271d = true;
    public boolean f30272e;
    public List<ExclusionStrategy> f30273f = Collections.emptyList();
    public List<ExclusionStrategy> f30274g = Collections.emptyList();

    protected final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m31160a();
    }

    private Excluder m31160a() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean m31165a(Class<?> cls, boolean z) {
        if (this.f30269b != -1.0d && !m31164a((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            return true;
        }
        if ((!this.f30271d && m31162b(cls)) || m31161a(cls) != null) {
            return true;
        }
        cls = (z ? this.f30273f : this.f30274g).iterator();
        while (cls.hasNext()) {
            if (((ExclusionStrategy) cls.next()).m25058b()) {
                return true;
            }
        }
        return null;
    }

    public static boolean m31161a(Class<?> cls) {
        return (Enum.class.isAssignableFrom(cls) || (!cls.isAnonymousClass() && cls.isLocalClass() == null)) ? null : true;
    }

    public static boolean m31162b(Class<?> cls) {
        if (cls.isMemberClass()) {
            if (((cls.getModifiers() & 8) != null ? 1 : null) == null) {
                return true;
            }
        }
        return false;
    }

    public final <T> TypeAdapter<T> mo5250a(Gson gson, TypeToken<T> typeToken) {
        Class cls = typeToken.f22996a;
        final boolean a = m31165a(cls, true);
        final boolean a2 = m31165a(cls, false);
        if (!a && !a2) {
            return null;
        }
        final Gson gson2 = gson;
        final TypeToken<T> typeToken2 = typeToken;
        return new TypeAdapter<T>(this) {
            final /* synthetic */ Excluder f30266e;
            private TypeAdapter<T> f30267f;

            public final T mo5241a(JsonReader jsonReader) throws IOException {
                if (!a2) {
                    return m31157b().mo5241a(jsonReader);
                }
                jsonReader.mo5267o();
                return null;
            }

            public final void mo5242a(JsonWriter jsonWriter, T t) throws IOException {
                if (a) {
                    jsonWriter.mo5281e();
                } else {
                    m31157b().mo5242a(jsonWriter, t);
                }
            }

            private TypeAdapter<T> m31157b() {
                TypeAdapter<T> typeAdapter = this.f30267f;
                if (typeAdapter != null) {
                    return typeAdapter;
                }
                typeAdapter = gson2.m25061a(this.f30266e, typeToken2);
                this.f30267f = typeAdapter;
                return typeAdapter;
            }
        };
    }

    public final boolean m31164a(Since since, Until until) {
        since = (since == null || since.m25091a() <= this.f30269b) ? 1 : null;
        if (since != null) {
            since = (until == null || until.m25092a() > this.f30269b) ? 1 : null;
            if (since != null) {
                return true;
            }
        }
        return false;
    }
}
