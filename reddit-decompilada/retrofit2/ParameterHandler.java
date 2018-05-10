package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Map;
import java.util.Map.Entry;
import okhttp3.Headers;
import okhttp3.RequestBody;

abstract class ParameterHandler<T> {

    class C31031 extends ParameterHandler<Iterable<T>> {
        final /* synthetic */ ParameterHandler f41598a;

        C31031(ParameterHandler parameterHandler) {
            this.f41598a = parameterHandler;
        }

        final /* synthetic */ void mo7888a(RequestBuilder requestBuilder, Object obj) throws IOException {
            Iterable<Object> iterable = (Iterable) obj;
            if (iterable != null) {
                for (Object a : iterable) {
                    this.f41598a.mo7888a(requestBuilder, a);
                }
            }
        }
    }

    class C31042 extends ParameterHandler<Object> {
        final /* synthetic */ ParameterHandler f41599a;

        C31042(ParameterHandler parameterHandler) {
            this.f41599a = parameterHandler;
        }

        final void mo7888a(RequestBuilder requestBuilder, Object obj) throws IOException {
            if (obj != null) {
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    this.f41599a.mo7888a(requestBuilder, Array.get(obj, i));
                }
            }
        }
    }

    static final class Body<T> extends ParameterHandler<T> {
        private final Converter<T, RequestBody> f41600a;

        Body(Converter<T, RequestBody> converter) {
            this.f41600a = converter;
        }

        final void mo7888a(RequestBuilder requestBuilder, T t) {
            if (t == null) {
                throw new IllegalArgumentException("Body parameter value must not be null.");
            }
            try {
                requestBuilder.f41224j = (RequestBody) this.f41600a.mo7875a(t);
            } catch (RequestBuilder requestBuilder2) {
                StringBuilder stringBuilder = new StringBuilder("Unable to convert ");
                stringBuilder.append(t);
                stringBuilder.append(" to RequestBody");
                throw new RuntimeException(stringBuilder.toString(), requestBuilder2);
            }
        }
    }

    static final class Field<T> extends ParameterHandler<T> {
        private final String f41601a;
        private final Converter<T, String> f41602b;
        private final boolean f41603c;

        Field(String str, Converter<T, String> converter, boolean z) {
            this.f41601a = (String) Utils.m43343a((Object) str, "name == null");
            this.f41602b = converter;
            this.f41603c = z;
        }

        final void mo7888a(RequestBuilder requestBuilder, T t) throws IOException {
            if (t != null) {
                String str = (String) this.f41602b.mo7875a(t);
                if (str != null) {
                    requestBuilder.m43316b(this.f41601a, str, this.f41603c);
                }
            }
        }
    }

    static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {
        private final Converter<T, String> f41604a;
        private final boolean f41605b;

        final /* synthetic */ void mo7888a(RequestBuilder requestBuilder, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                throw new IllegalArgumentException("Field map was null.");
            }
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw new IllegalArgumentException("Field map contained null key.");
                }
                Object value = entry.getValue();
                if (value == null) {
                    obj = new StringBuilder("Field map contained null value for key '");
                    obj.append(str);
                    obj.append("'.");
                    throw new IllegalArgumentException(obj.toString());
                }
                String str2 = (String) this.f41604a.mo7875a(value);
                if (str2 == null) {
                    obj = new StringBuilder("Field map value '");
                    obj.append(value);
                    obj.append("' converted to null by ");
                    obj.append(this.f41604a.getClass().getName());
                    obj.append(" for key '");
                    obj.append(str);
                    obj.append("'.");
                    throw new IllegalArgumentException(obj.toString());
                }
                requestBuilder.m43316b(str, str2, this.f41605b);
            }
        }

        FieldMap(Converter<T, String> converter, boolean z) {
            this.f41604a = converter;
            this.f41605b = z;
        }
    }

    static final class Header<T> extends ParameterHandler<T> {
        private final String f41606a;
        private final Converter<T, String> f41607b;

        Header(String str, Converter<T, String> converter) {
            this.f41606a = (String) Utils.m43343a((Object) str, "name == null");
            this.f41607b = converter;
        }

        final void mo7888a(RequestBuilder requestBuilder, T t) throws IOException {
            if (t != null) {
                String str = (String) this.f41607b.mo7875a(t);
                if (str != null) {
                    requestBuilder.m43313a(this.f41606a, str);
                }
            }
        }
    }

    static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {
        private final Converter<T, String> f41608a;

        final /* synthetic */ void mo7888a(RequestBuilder requestBuilder, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                throw new IllegalArgumentException("Header map was null.");
            }
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw new IllegalArgumentException("Header map contained null key.");
                }
                Object value = entry.getValue();
                if (value == null) {
                    obj = new StringBuilder("Header map contained null value for key '");
                    obj.append(str);
                    obj.append("'.");
                    throw new IllegalArgumentException(obj.toString());
                }
                requestBuilder.m43313a(str, (String) this.f41608a.mo7875a(value));
            }
        }

        HeaderMap(Converter<T, String> converter) {
            this.f41608a = converter;
        }
    }

    static final class Part<T> extends ParameterHandler<T> {
        private final Headers f41609a;
        private final Converter<T, RequestBody> f41610b;

        Part(Headers headers, Converter<T, RequestBody> converter) {
            this.f41609a = headers;
            this.f41610b = converter;
        }

        final void mo7888a(RequestBuilder requestBuilder, T t) {
            if (t != null) {
                try {
                    requestBuilder.m43315a(this.f41609a, (RequestBody) this.f41610b.mo7875a(t));
                } catch (RequestBuilder requestBuilder2) {
                    StringBuilder stringBuilder = new StringBuilder("Unable to convert ");
                    stringBuilder.append(t);
                    stringBuilder.append(" to RequestBody");
                    throw new RuntimeException(stringBuilder.toString(), requestBuilder2);
                }
            }
        }
    }

    static final class PartMap<T> extends ParameterHandler<Map<String, T>> {
        private final Converter<T, RequestBody> f41611a;
        private final String f41612b;

        final /* synthetic */ void mo7888a(RequestBuilder requestBuilder, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                throw new IllegalArgumentException("Part map was null.");
            }
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw new IllegalArgumentException("Part map contained null key.");
                }
                Object value = entry.getValue();
                if (value == null) {
                    obj = new StringBuilder("Part map contained null value for key '");
                    obj.append(str);
                    obj.append("'.");
                    throw new IllegalArgumentException(obj.toString());
                }
                String[] strArr = new String[4];
                strArr[0] = "Content-Disposition";
                StringBuilder stringBuilder = new StringBuilder("form-data; name=\"");
                stringBuilder.append(str);
                stringBuilder.append("\"");
                strArr[1] = stringBuilder.toString();
                strArr[2] = "Content-Transfer-Encoding";
                strArr[3] = this.f41612b;
                requestBuilder.m43315a(Headers.of(strArr), (RequestBody) this.f41611a.mo7875a(value));
            }
        }

        PartMap(Converter<T, RequestBody> converter, String str) {
            this.f41611a = converter;
            this.f41612b = str;
        }
    }

    static final class Path<T> extends ParameterHandler<T> {
        private final String f41613a;
        private final Converter<T, String> f41614b;
        private final boolean f41615c;

        Path(String str, Converter<T, String> converter, boolean z) {
            this.f41613a = (String) Utils.m43343a((Object) str, "name == null");
            this.f41614b = converter;
            this.f41615c = z;
        }

        final void mo7888a(RequestBuilder requestBuilder, T t) throws IOException {
            if (t == null) {
                t = new StringBuilder("Path parameter \"");
                t.append(this.f41613a);
                t.append("\" value must not be null.");
                throw new IllegalArgumentException(t.toString());
            }
            String str = this.f41613a;
            String str2 = (String) this.f41614b.mo7875a(t);
            boolean z = this.f41615c;
            if (requestBuilder.f41217c == null) {
                throw new AssertionError();
            }
            String str3 = requestBuilder.f41217c;
            StringBuilder stringBuilder = new StringBuilder("{");
            stringBuilder.append(str);
            stringBuilder.append("}");
            requestBuilder.f41217c = str3.replace(stringBuilder.toString(), RequestBuilder.m43312a(str2, z));
        }
    }

    static final class Query<T> extends ParameterHandler<T> {
        private final String f41616a;
        private final Converter<T, String> f41617b;
        private final boolean f41618c;

        Query(String str, Converter<T, String> converter, boolean z) {
            this.f41616a = (String) Utils.m43343a((Object) str, "name == null");
            this.f41617b = converter;
            this.f41618c = z;
        }

        final void mo7888a(RequestBuilder requestBuilder, T t) throws IOException {
            if (t != null) {
                String str = (String) this.f41617b.mo7875a(t);
                if (str != null) {
                    requestBuilder.m43314a(this.f41616a, str, this.f41618c);
                }
            }
        }
    }

    static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {
        private final Converter<T, String> f41619a;
        private final boolean f41620b;

        final /* synthetic */ void mo7888a(RequestBuilder requestBuilder, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                throw new IllegalArgumentException("Query map was null.");
            }
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw new IllegalArgumentException("Query map contained null key.");
                }
                Object value = entry.getValue();
                if (value == null) {
                    obj = new StringBuilder("Query map contained null value for key '");
                    obj.append(str);
                    obj.append("'.");
                    throw new IllegalArgumentException(obj.toString());
                }
                String str2 = (String) this.f41619a.mo7875a(value);
                if (str2 == null) {
                    obj = new StringBuilder("Query map value '");
                    obj.append(value);
                    obj.append("' converted to null by ");
                    obj.append(this.f41619a.getClass().getName());
                    obj.append(" for key '");
                    obj.append(str);
                    obj.append("'.");
                    throw new IllegalArgumentException(obj.toString());
                }
                requestBuilder.m43314a(str, str2, this.f41620b);
            }
        }

        QueryMap(Converter<T, String> converter, boolean z) {
            this.f41619a = converter;
            this.f41620b = z;
        }
    }

    static final class QueryName<T> extends ParameterHandler<T> {
        private final Converter<T, String> f41621a;
        private final boolean f41622b;

        QueryName(Converter<T, String> converter, boolean z) {
            this.f41621a = converter;
            this.f41622b = z;
        }

        final void mo7888a(RequestBuilder requestBuilder, T t) throws IOException {
            if (t != null) {
                requestBuilder.m43314a((String) this.f41621a.mo7875a(t), null, this.f41622b);
            }
        }
    }

    static final class RawPart extends ParameterHandler<okhttp3.MultipartBody.Part> {
        static final RawPart f41623a = new RawPart();

        final /* synthetic */ void mo7888a(RequestBuilder requestBuilder, Object obj) throws IOException {
            okhttp3.MultipartBody.Part part = (okhttp3.MultipartBody.Part) obj;
            if (part != null) {
                requestBuilder.f41222h.addPart(part);
            }
        }

        private RawPart() {
        }
    }

    static final class RelativeUrl extends ParameterHandler<Object> {
        RelativeUrl() {
        }

        final void mo7888a(RequestBuilder requestBuilder, Object obj) {
            Utils.m43343a(obj, "@Url parameter is null.");
            requestBuilder.f41217c = obj.toString();
        }
    }

    abstract void mo7888a(RequestBuilder requestBuilder, T t) throws IOException;

    ParameterHandler() {
    }

    final ParameterHandler<Iterable<T>> m43303a() {
        return new C31031(this);
    }

    final ParameterHandler<Object> m43305b() {
        return new C31042(this);
    }
}
