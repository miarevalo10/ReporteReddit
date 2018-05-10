package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import okhttp3.Call.Factory;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import retrofit2.http.Url;

final class ServiceMethod<R, T> {
    static final Pattern f41268a = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
    static final Pattern f41269b = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
    final Factory f41270c;
    final CallAdapter<R, T> f41271d;
    final HttpUrl f41272e;
    final Converter<ResponseBody, R> f41273f;
    final String f41274g;
    final String f41275h;
    final Headers f41276i;
    final MediaType f41277j;
    final boolean f41278k;
    final boolean f41279l;
    final boolean f41280m;
    final ParameterHandler<?>[] f41281n;

    static final class Builder<T, R> {
        final Retrofit f41245a;
        final Method f41246b;
        final Annotation[] f41247c;
        final Annotation[][] f41248d;
        final Type[] f41249e;
        Type f41250f;
        boolean f41251g;
        boolean f41252h;
        boolean f41253i;
        boolean f41254j;
        boolean f41255k;
        boolean f41256l;
        String f41257m;
        boolean f41258n;
        boolean f41259o;
        boolean f41260p;
        String f41261q;
        Headers f41262r;
        MediaType f41263s;
        Set<String> f41264t;
        ParameterHandler<?>[] f41265u;
        Converter<ResponseBody, T> f41266v;
        CallAdapter<T, R> f41267w;

        Builder(Retrofit retrofit, Method method) {
            this.f41245a = retrofit;
            this.f41246b = method;
            this.f41247c = method.getAnnotations();
            this.f41249e = method.getGenericParameterTypes();
            this.f41248d = method.getParameterAnnotations();
        }

        final CallAdapter<T, R> m43335a() {
            Object genericReturnType = this.f41246b.getGenericReturnType();
            if (Utils.m43354d(genericReturnType)) {
                throw m43333a(null, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
            } else if (genericReturnType == Void.TYPE) {
                throw m43333a(null, "Service methods cannot return void.", new Object[0]);
            } else {
                Object annotations = this.f41246b.getAnnotations();
                try {
                    int i;
                    Retrofit retrofit = this.f41245a;
                    Utils.m43343a(genericReturnType, "returnType == null");
                    Utils.m43343a(annotations, "annotations == null");
                    int indexOf = retrofit.f41241d.indexOf(null) + 1;
                    int size = retrofit.f41241d.size();
                    for (i = indexOf; i < size; i++) {
                        CallAdapter<T, R> a = ((CallAdapter.Factory) retrofit.f41241d.get(i)).mo7880a(genericReturnType);
                        if (a != null) {
                            return a;
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder("Could not locate call adapter for ");
                    stringBuilder.append(genericReturnType);
                    stringBuilder.append(".\n");
                    stringBuilder.append("  Tried:");
                    i = retrofit.f41241d.size();
                    while (indexOf < i) {
                        stringBuilder.append("\n   * ");
                        stringBuilder.append(((CallAdapter.Factory) retrofit.f41241d.get(indexOf)).getClass().getName());
                        indexOf++;
                    }
                    throw new IllegalArgumentException(stringBuilder.toString());
                } catch (Throwable e) {
                    throw m43333a(e, "Unable to create call adapter for %s", genericReturnType);
                }
            }
        }

        final void m43337a(String str, String str2, boolean z) {
            if (this.f41257m != null) {
                throw m43333a(null, "Only one HTTP method is allowed. Found: %s and %s.", this.f41257m, str);
            }
            this.f41257m = str;
            this.f41258n = z;
            if (str2.isEmpty() == null) {
                str = str2.indexOf(63);
                if (str != true && str < str2.length() - true) {
                    if (ServiceMethod.f41268a.matcher(str2.substring(str + 1)).find()) {
                        throw m43333a(null, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", str2.substring(str + 1));
                    }
                }
                this.f41261q = str2;
                this.f41264t = ServiceMethod.m43340a(str2);
            }
        }

        final Headers m43334a(String[] strArr) {
            okhttp3.Headers.Builder builder = new okhttp3.Headers.Builder();
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str = strArr[i];
                int indexOf = str.indexOf(58);
                if (!(indexOf == -1 || indexOf == 0)) {
                    if (indexOf != str.length() - 1) {
                        String substring = str.substring(0, indexOf);
                        str = str.substring(indexOf + 1).trim();
                        if ("Content-Type".equalsIgnoreCase(substring)) {
                            MediaType parse = MediaType.parse(str);
                            if (parse == null) {
                                throw m43333a(null, "Malformed content type: %s", str);
                            }
                            this.f41263s = parse;
                        } else {
                            builder.add(substring, str);
                        }
                        i++;
                    }
                }
                throw m43333a(null, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
            }
            return builder.build();
        }

        final ParameterHandler<?> m43336a(int i, Type type, Annotation[] annotationArr) {
            ParameterHandler<?> parameterHandler = null;
            for (Annotation a : annotationArr) {
                ParameterHandler<?> a2 = m43331a(i, type, annotationArr, a);
                if (a2 != null) {
                    if (parameterHandler != null) {
                        throw m43332a(i, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                    }
                    parameterHandler = a2;
                }
            }
            if (parameterHandler != null) {
                return parameterHandler;
            }
            throw m43332a(i, "No Retrofit annotation found.", new Object[0]);
        }

        private ParameterHandler<?> m43331a(int i, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof Url) {
                if (this.f41256l != null) {
                    throw m43332a(i, "Multiple @Url method annotations found.", new Object[0]);
                } else if (this.f41254j != null) {
                    throw m43332a(i, "@Path parameters may not be used with @Url.", new Object[0]);
                } else if (this.f41255k != null) {
                    throw m43332a(i, "A @Url parameter must not come after a @Query", new Object[0]);
                } else if (this.f41261q != null) {
                    throw m43332a(i, "@Url cannot be used with @%s URL", this.f41257m);
                } else {
                    this.f41256l = true;
                    if (!(type == HttpUrl.class || type == String.class || type == URI.class)) {
                        if ((type instanceof Class) == null || "android.net.Uri".equals(((Class) type).getName()) == null) {
                            throw m43332a(i, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                        }
                    }
                    return new RelativeUrl();
                }
            } else if (annotation instanceof Path) {
                if (this.f41255k) {
                    throw m43332a(i, "A @Path parameter must not come after a @Query.", new Object[0]);
                } else if (this.f41256l) {
                    throw m43332a(i, "@Path parameters may not be used with @Url.", new Object[0]);
                } else if (this.f41261q == null) {
                    throw m43332a(i, "@Path can only be used with relative url on @%s", this.f41257m);
                } else {
                    this.f41254j = true;
                    Path path = (Path) annotation;
                    Object a = path.m43376a();
                    if (!ServiceMethod.f41269b.matcher(a).matches()) {
                        throw m43332a(i, "@Path parameter name must match %s. Found: %s", ServiceMethod.f41268a.pattern(), a);
                    } else if (this.f41264t.contains(a)) {
                        return new Path(a, this.f41245a.m43328a(type, annotationArr), path.m43377b());
                    } else {
                        throw m43332a(i, "URL \"%s\" does not contain \"{%s}\".", this.f41261q, a);
                    }
                }
            } else if (annotation instanceof Query) {
                Query query = (Query) annotation;
                r0 = query.m43378a();
                annotation = query.m43379b();
                Class a2 = Utils.m43342a(type);
                this.f41255k = true;
                if (Iterable.class.isAssignableFrom(a2)) {
                    if (type instanceof ParameterizedType) {
                        return new Query(r0, this.f41245a.m43328a(Utils.m43344a(0, (ParameterizedType) type), annotationArr), annotation).m43303a();
                    }
                    type = new StringBuilder();
                    type.append(a2.getSimpleName());
                    type.append(" must include generic type (e.g., ");
                    type.append(a2.getSimpleName());
                    type.append("<String>)");
                    throw m43332a(i, type.toString(), new Object[0]);
                } else if (a2.isArray() == 0) {
                    return new Query(r0, this.f41245a.m43328a(type, annotationArr), annotation);
                } else {
                    return new Query(r0, this.f41245a.m43328a(ServiceMethod.m43339a(a2.getComponentType()), annotationArr), annotation).m43305b();
                }
            } else if (annotation instanceof QueryName) {
                annotation = ((QueryName) annotation).m43381a();
                r0 = Utils.m43342a(type);
                this.f41255k = true;
                if (Iterable.class.isAssignableFrom(r0)) {
                    if (type instanceof ParameterizedType) {
                        return new QueryName(this.f41245a.m43328a(Utils.m43344a(0, (ParameterizedType) type), annotationArr), annotation).m43303a();
                    }
                    type = new StringBuilder();
                    type.append(r0.getSimpleName());
                    type.append(" must include generic type (e.g., ");
                    type.append(r0.getSimpleName());
                    type.append("<String>)");
                    throw m43332a(i, type.toString(), new Object[0]);
                } else if (r0.isArray() == 0) {
                    return new QueryName(this.f41245a.m43328a(type, annotationArr), annotation);
                } else {
                    return new QueryName(this.f41245a.m43328a(ServiceMethod.m43339a(r0.getComponentType()), annotationArr), annotation).m43305b();
                }
            } else if (annotation instanceof QueryMap) {
                r0 = Utils.m43342a(type);
                if (Map.class.isAssignableFrom(r0)) {
                    type = Utils.m43345a(type, r0, Map.class);
                    if (type instanceof ParameterizedType) {
                        r10 = (ParameterizedType) type;
                        r0 = Utils.m43344a(0, r10);
                        if (String.class != r0) {
                            type = new StringBuilder("@QueryMap keys must be of type String: ");
                            type.append(r0);
                            throw m43332a(i, type.toString(), new Object[0]);
                        }
                        return new QueryMap(this.f41245a.m43328a(Utils.m43344a(1, r10), annotationArr), ((QueryMap) annotation).m43380a());
                    }
                    throw m43332a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw m43332a(i, "@QueryMap parameter type must be Map.", new Object[0]);
            } else if (annotation instanceof Header) {
                annotation = ((Header) annotation).m43367a();
                r0 = Utils.m43342a(type);
                if (Iterable.class.isAssignableFrom(r0)) {
                    if (type instanceof ParameterizedType) {
                        return new Header(annotation, this.f41245a.m43328a(Utils.m43344a(0, (ParameterizedType) type), annotationArr)).m43303a();
                    }
                    type = new StringBuilder();
                    type.append(r0.getSimpleName());
                    type.append(" must include generic type (e.g., ");
                    type.append(r0.getSimpleName());
                    type.append("<String>)");
                    throw m43332a(i, type.toString(), new Object[0]);
                } else if (r0.isArray() == 0) {
                    return new Header(annotation, this.f41245a.m43328a(type, annotationArr));
                } else {
                    return new Header(annotation, this.f41245a.m43328a(ServiceMethod.m43339a(r0.getComponentType()), annotationArr)).m43305b();
                }
            } else if (annotation instanceof HeaderMap) {
                Class a3 = Utils.m43342a(type);
                if (Map.class.isAssignableFrom(a3)) {
                    type = Utils.m43345a(type, a3, Map.class);
                    if ((type instanceof ParameterizedType) == null) {
                        throw m43332a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    r10 = (ParameterizedType) type;
                    a3 = Utils.m43344a(0, r10);
                    if (String.class != a3) {
                        type = new StringBuilder("@HeaderMap keys must be of type String: ");
                        type.append(a3);
                        throw m43332a(i, type.toString(), new Object[0]);
                    }
                    return new HeaderMap(this.f41245a.m43328a(Utils.m43344a(1, r10), annotationArr));
                }
                throw m43332a(i, "@HeaderMap parameter type must be Map.", new Object[0]);
            } else if (annotation instanceof Field) {
                if (this.f41259o) {
                    Field field = (Field) annotation;
                    r0 = field.m43359a();
                    annotation = field.m43360b();
                    this.f41251g = true;
                    Class a4 = Utils.m43342a(type);
                    if (Iterable.class.isAssignableFrom(a4)) {
                        if (type instanceof ParameterizedType) {
                            return new Field(r0, this.f41245a.m43328a(Utils.m43344a(0, (ParameterizedType) type), annotationArr), annotation).m43303a();
                        }
                        type = new StringBuilder();
                        type.append(a4.getSimpleName());
                        type.append(" must include generic type (e.g., ");
                        type.append(a4.getSimpleName());
                        type.append("<String>)");
                        throw m43332a(i, type.toString(), new Object[0]);
                    } else if (a4.isArray() == 0) {
                        return new Field(r0, this.f41245a.m43328a(type, annotationArr), annotation);
                    } else {
                        return new Field(r0, this.f41245a.m43328a(ServiceMethod.m43339a(a4.getComponentType()), annotationArr), annotation).m43305b();
                    }
                }
                throw m43332a(i, "@Field parameters can only be used with form encoding.", new Object[0]);
            } else if (annotation instanceof FieldMap) {
                if (this.f41259o) {
                    r0 = Utils.m43342a(type);
                    if (Map.class.isAssignableFrom(r0)) {
                        type = Utils.m43345a(type, r0, Map.class);
                        if (type instanceof ParameterizedType) {
                            r10 = (ParameterizedType) type;
                            r0 = Utils.m43344a(0, r10);
                            if (String.class != r0) {
                                type = new StringBuilder("@FieldMap keys must be of type String: ");
                                type.append(r0);
                                throw m43332a(i, type.toString(), new Object[0]);
                            }
                            i = this.f41245a.m43328a(Utils.m43344a(1, r10), annotationArr);
                            this.f41251g = true;
                            return new FieldMap(i, ((FieldMap) annotation).m43361a());
                        }
                        throw m43332a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw m43332a(i, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                throw m43332a(i, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
            } else if (annotation instanceof Part) {
                if (this.f41260p) {
                    Part part = (Part) annotation;
                    this.f41252h = true;
                    r0 = part.m43373a();
                    Class a5 = Utils.m43342a(type);
                    if (!r0.isEmpty()) {
                        String[] strArr = new String[4];
                        strArr[0] = "Content-Disposition";
                        StringBuilder stringBuilder = new StringBuilder("form-data; name=\"");
                        stringBuilder.append(r0);
                        stringBuilder.append("\"");
                        strArr[1] = stringBuilder.toString();
                        strArr[2] = "Content-Transfer-Encoding";
                        strArr[3] = part.m43374b();
                        annotation = Headers.of(strArr);
                        if (Iterable.class.isAssignableFrom(a5)) {
                            if (type instanceof ParameterizedType) {
                                type = Utils.m43344a(0, (ParameterizedType) type);
                                if (!MultipartBody.Part.class.isAssignableFrom(Utils.m43342a(type))) {
                                    return new Part(annotation, this.f41245a.m43329a(type, annotationArr, this.f41247c)).m43303a();
                                }
                                throw m43332a(i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                            }
                            type = new StringBuilder();
                            type.append(a5.getSimpleName());
                            type.append(" must include generic type (e.g., ");
                            type.append(a5.getSimpleName());
                            type.append("<String>)");
                            throw m43332a(i, type.toString(), new Object[0]);
                        } else if (a5.isArray()) {
                            type = ServiceMethod.m43339a(a5.getComponentType());
                            if (!MultipartBody.Part.class.isAssignableFrom(type)) {
                                return new Part(annotation, this.f41245a.m43329a(type, annotationArr, this.f41247c)).m43305b();
                            }
                            throw m43332a(i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        } else if (!MultipartBody.Part.class.isAssignableFrom(a5)) {
                            return new Part(annotation, this.f41245a.m43329a(type, annotationArr, this.f41247c));
                        } else {
                            throw m43332a(i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                    } else if (Iterable.class.isAssignableFrom(a5) != null) {
                        if ((type instanceof ParameterizedType) == null) {
                            type = new StringBuilder();
                            type.append(a5.getSimpleName());
                            type.append(" must include generic type (e.g., ");
                            type.append(a5.getSimpleName());
                            type.append("<String>)");
                            throw m43332a(i, type.toString(), new Object[0]);
                        } else if (MultipartBody.Part.class.isAssignableFrom(Utils.m43342a(Utils.m43344a(0, (ParameterizedType) type))) != null) {
                            return RawPart.f41623a.m43303a();
                        } else {
                            throw m43332a(i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                    } else if (a5.isArray() != null) {
                        if (MultipartBody.Part.class.isAssignableFrom(a5.getComponentType()) != null) {
                            return RawPart.f41623a.m43305b();
                        }
                        throw m43332a(i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    } else if (MultipartBody.Part.class.isAssignableFrom(a5) != null) {
                        return RawPart.f41623a;
                    } else {
                        throw m43332a(i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                }
                throw m43332a(i, "@Part parameters can only be used with multipart encoding.", new Object[0]);
            } else if (annotation instanceof PartMap) {
                if (this.f41260p) {
                    this.f41252h = true;
                    r0 = Utils.m43342a(type);
                    if (Map.class.isAssignableFrom(r0)) {
                        type = Utils.m43345a(type, r0, Map.class);
                        if (type instanceof ParameterizedType) {
                            r10 = (ParameterizedType) type;
                            r0 = Utils.m43344a(0, r10);
                            if (String.class != r0) {
                                type = new StringBuilder("@PartMap keys must be of type String: ");
                                type.append(r0);
                                throw m43332a(i, type.toString(), new Object[0]);
                            }
                            type = Utils.m43344a(1, r10);
                            if (!MultipartBody.Part.class.isAssignableFrom(Utils.m43342a(type))) {
                                return new PartMap(this.f41245a.m43329a(type, annotationArr, this.f41247c), ((PartMap) annotation).m43375a());
                            }
                            throw m43332a(i, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                        }
                        throw m43332a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw m43332a(i, "@PartMap parameter type must be Map.", new Object[0]);
                }
                throw m43332a(i, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
            } else if ((annotation instanceof Body) == null) {
                return 0;
            } else {
                if (this.f41259o == null) {
                    if (this.f41260p == null) {
                        if (this.f41253i != null) {
                            throw m43332a(i, "Multiple @Body method annotations found.", new Object[0]);
                        }
                        try {
                            annotationArr = this.f41245a.m43329a(type, annotationArr, this.f41247c);
                            this.f41253i = true;
                            return new Body(annotationArr);
                        } catch (Throwable e) {
                            Object[] objArr = new Object[]{type};
                            type = new StringBuilder();
                            type.append("Unable to create @Body converter for %s");
                            type.append(" (parameter #");
                            type.append(i + 1);
                            type.append(")");
                            throw m43333a(e, type.toString(), objArr);
                        }
                    }
                }
                throw m43332a(i, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
            }
        }

        final Converter<ResponseBody, T> m43338b() {
            Object annotations = this.f41246b.getAnnotations();
            try {
                Retrofit retrofit = this.f41245a;
                Object obj = this.f41250f;
                Utils.m43343a(obj, "type == null");
                Utils.m43343a(annotations, "annotations == null");
                int indexOf = retrofit.f41240c.indexOf(null) + 1;
                int size = retrofit.f41240c.size();
                for (int i = indexOf; i < size; i++) {
                    Converter<ResponseBody, T> a = ((Converter.Factory) retrofit.f41240c.get(i)).mo7876a(obj, annotations);
                    if (a != null) {
                        return a;
                    }
                }
                StringBuilder stringBuilder = new StringBuilder("Could not locate ResponseBody converter for ");
                stringBuilder.append(obj);
                stringBuilder.append(".\n");
                stringBuilder.append("  Tried:");
                int size2 = retrofit.f41240c.size();
                while (indexOf < size2) {
                    stringBuilder.append("\n   * ");
                    stringBuilder.append(((Converter.Factory) retrofit.f41240c.get(indexOf)).getClass().getName());
                    indexOf++;
                }
                throw new IllegalArgumentException(stringBuilder.toString());
            } catch (Throwable e) {
                throw m43333a(e, "Unable to create converter for %s", this.f41250f);
            }
        }

        final RuntimeException m43333a(Throwable th, String str, Object... objArr) {
            str = String.format(str, objArr);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("\n    for method ");
            stringBuilder.append(this.f41246b.getDeclaringClass().getSimpleName());
            stringBuilder.append(".");
            stringBuilder.append(this.f41246b.getName());
            return new IllegalArgumentException(stringBuilder.toString(), th);
        }

        final RuntimeException m43332a(int i, String str, Object... objArr) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" (parameter #");
            stringBuilder.append(i + 1);
            stringBuilder.append(")");
            return m43333a((Throwable) null, stringBuilder.toString(), objArr);
        }
    }

    ServiceMethod(Builder<R, T> builder) {
        this.f41270c = builder.f41245a.f41238a;
        this.f41271d = builder.f41267w;
        this.f41272e = builder.f41245a.f41239b;
        this.f41273f = builder.f41266v;
        this.f41274g = builder.f41257m;
        this.f41275h = builder.f41261q;
        this.f41276i = builder.f41262r;
        this.f41277j = builder.f41263s;
        this.f41278k = builder.f41258n;
        this.f41279l = builder.f41259o;
        this.f41280m = builder.f41260p;
        this.f41281n = builder.f41265u;
    }

    static Set<String> m43340a(String str) {
        str = f41268a.matcher(str);
        Set<String> linkedHashSet = new LinkedHashSet();
        while (str.find()) {
            linkedHashSet.add(str.group(1));
        }
        return linkedHashSet;
    }

    static Class<?> m43339a(Class<?> cls) {
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        return Short.TYPE == cls ? Short.class : cls;
    }
}
