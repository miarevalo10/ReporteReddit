package com.squareup.moshi;

import com.squareup.moshi.JsonReader.Token;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;

public abstract class JsonAdapter<T> {

    public interface Factory {
        JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi);
    }

    public abstract T fromJson(JsonReader jsonReader) throws IOException;

    public abstract void toJson(JsonWriter jsonWriter, T t) throws IOException;

    public final T fromJson(BufferedSource bufferedSource) throws IOException {
        return fromJson(JsonReader.m25655a(bufferedSource));
    }

    public final T fromJson(String str) throws IOException {
        return fromJson(new Buffer().m36482a(str));
    }

    public final void toJson(BufferedSink bufferedSink, T t) throws IOException {
        toJson(JsonWriter.m25679a(bufferedSink), (Object) t);
    }

    public final String toJson(T t) {
        BufferedSink buffer = new Buffer();
        try {
            toJson(buffer, (Object) t);
            return buffer.m36535p();
        } catch (T t2) {
            throw new AssertionError(t2);
        }
    }

    public final Object toJsonValue(T t) {
        JsonWriter jsonValueWriter = new JsonValueWriter();
        try {
            toJson(jsonValueWriter, (Object) t);
            t = jsonValueWriter.b;
            if (t <= 1) {
                if (t != 1 || jsonValueWriter.c[t - 1] == 7) {
                    return jsonValueWriter.f30648a[0];
                }
            }
            throw new IllegalStateException("Incomplete document");
        } catch (T t2) {
            throw new AssertionError(t2);
        }
    }

    public final T fromJsonValue(Object obj) {
        try {
            return fromJson(new JsonValueReader(obj));
        } catch (Object obj2) {
            throw new AssertionError(obj2);
        }
    }

    public final JsonAdapter<T> serializeNulls() {
        return new JsonAdapter<T>(this) {
            final /* synthetic */ JsonAdapter f30622b;

            public T fromJson(JsonReader jsonReader) throws IOException {
                return this.fromJson(jsonReader);
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this);
                stringBuilder.append(".serializeNulls()");
                return stringBuilder.toString();
            }

            public void toJson(JsonWriter jsonWriter, T t) throws IOException {
                boolean z = jsonWriter.f23657h;
                jsonWriter.f23657h = true;
                try {
                    this.toJson(jsonWriter, (Object) t);
                } finally {
                    jsonWriter.f23657h = z;
                }
            }
        };
    }

    public final JsonAdapter<T> nullSafe() {
        return new JsonAdapter<T>(this) {
            final /* synthetic */ JsonAdapter f30624b;

            public T fromJson(JsonReader jsonReader) throws IOException {
                if (jsonReader.mo5423f() == Token.NULL) {
                    return jsonReader.mo5427j();
                }
                return this.fromJson(jsonReader);
            }

            public void toJson(JsonWriter jsonWriter, T t) throws IOException {
                if (t == null) {
                    jsonWriter.mo5444e();
                } else {
                    this.toJson(jsonWriter, (Object) t);
                }
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this);
                stringBuilder.append(".nullSafe()");
                return stringBuilder.toString();
            }
        };
    }

    public final JsonAdapter<T> lenient() {
        return new JsonAdapter<T>(this) {
            final /* synthetic */ JsonAdapter f30626b;

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this);
                stringBuilder.append(".lenient()");
                return stringBuilder.toString();
            }

            public T fromJson(JsonReader jsonReader) throws IOException {
                boolean z = jsonReader.f23649e;
                jsonReader.f23649e = true;
                try {
                    T fromJson = this.fromJson(jsonReader);
                    return fromJson;
                } finally {
                    jsonReader.f23649e = z;
                }
            }

            public void toJson(JsonWriter jsonWriter, T t) throws IOException {
                boolean z = jsonWriter.f23656g;
                jsonWriter.f23656g = true;
                try {
                    this.toJson(jsonWriter, (Object) t);
                } finally {
                    jsonWriter.f23656g = z;
                }
            }
        };
    }

    public final JsonAdapter<T> failOnUnknown() {
        return new JsonAdapter<T>(this) {
            final /* synthetic */ JsonAdapter f30628b;

            public void toJson(JsonWriter jsonWriter, T t) throws IOException {
                this.toJson(jsonWriter, (Object) t);
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this);
                stringBuilder.append(".failOnUnknown()");
                return stringBuilder.toString();
            }

            public T fromJson(JsonReader jsonReader) throws IOException {
                boolean z = jsonReader.f23650f;
                jsonReader.f23650f = true;
                try {
                    T fromJson = this.fromJson(jsonReader);
                    return fromJson;
                } finally {
                    jsonReader.f23650f = z;
                }
            }
        };
    }

    public JsonAdapter<T> indent(final String str) {
        if (str != null) {
            return new JsonAdapter<T>(this) {
                final /* synthetic */ JsonAdapter f30631c;

                public T fromJson(JsonReader jsonReader) throws IOException {
                    return this.fromJson(jsonReader);
                }

                public String toString() {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(this);
                    stringBuilder.append(".indent(\"");
                    stringBuilder.append(str);
                    stringBuilder.append("\")");
                    return stringBuilder.toString();
                }

                public void toJson(JsonWriter jsonWriter, T t) throws IOException {
                    String str = jsonWriter.f23655f != null ? jsonWriter.f23655f : "";
                    jsonWriter.mo5438a(str);
                    try {
                        this.toJson(jsonWriter, (Object) t);
                    } finally {
                        jsonWriter.mo5438a(str);
                    }
                }
            };
        }
        throw new NullPointerException("indent == null");
    }
}
