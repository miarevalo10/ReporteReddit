package retrofit2;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import okhttp3.Call.Factory;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public final class Retrofit {
    final Factory f41238a;
    final HttpUrl f41239b;
    final List<Converter.Factory> f41240c;
    final List<CallAdapter.Factory> f41241d;
    final Executor f41242e;
    final boolean f41243f;
    private final Map<Method, ServiceMethod<?, ?>> f41244g = new ConcurrentHashMap();

    public static final class Builder {
        private final Platform f41231a;
        private Factory f41232b;
        private HttpUrl f41233c;
        private final List<Converter.Factory> f41234d;
        private final List<CallAdapter.Factory> f41235e;
        private Executor f41236f;
        private boolean f41237g;

        private Builder(Platform platform) {
            this.f41234d = new ArrayList();
            this.f41235e = new ArrayList();
            this.f41231a = platform;
            this.f41234d.add(new BuiltInConverters());
        }

        public Builder() {
            this(Platform.m43306a());
        }

        public final Builder m43323a(OkHttpClient okHttpClient) {
            this.f41232b = (Factory) Utils.m43343a((Factory) Utils.m43343a((Object) okHttpClient, "client == null"), "factory == null");
            return this;
        }

        public final Builder m43322a(String str) {
            Utils.m43343a((Object) str, "baseUrl == null");
            Object parse = HttpUrl.parse(str);
            if (parse == null) {
                StringBuilder stringBuilder = new StringBuilder("Illegal URL: ");
                stringBuilder.append(str);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            Utils.m43343a(parse, "baseUrl == null");
            str = parse.pathSegments();
            if ("".equals(str.get(str.size() - 1)) == null) {
                stringBuilder = new StringBuilder("baseUrl must end in /: ");
                stringBuilder.append(parse);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            this.f41233c = parse;
            return this;
        }

        public final Builder m43325a(Converter.Factory factory) {
            this.f41234d.add(Utils.m43343a((Object) factory, "factory == null"));
            return this;
        }

        public final Builder m43324a(CallAdapter.Factory factory) {
            this.f41235e.add(Utils.m43343a((Object) factory, "factory == null"));
            return this;
        }

        public final Retrofit m43326a() {
            if (this.f41233c == null) {
                throw new IllegalStateException("Base URL required.");
            }
            Factory factory = this.f41232b;
            if (factory == null) {
                factory = new OkHttpClient();
            }
            Factory factory2 = factory;
            Executor executor = this.f41236f;
            if (executor == null) {
                executor = this.f41231a.mo7890b();
            }
            Executor executor2 = executor;
            List arrayList = new ArrayList(this.f41235e);
            arrayList.add(this.f41231a.mo7889a(executor2));
            return new Retrofit(factory2, this.f41233c, new ArrayList(this.f41234d), arrayList, executor2, this.f41237g);
        }
    }

    Retrofit(Factory factory, HttpUrl httpUrl, List<Converter.Factory> list, List<CallAdapter.Factory> list2, Executor executor, boolean z) {
        this.f41238a = factory;
        this.f41239b = httpUrl;
        this.f41240c = Collections.unmodifiableList(list);
        this.f41241d = Collections.unmodifiableList(list2);
        this.f41242e = executor;
        this.f41243f = z;
    }

    public final <T> T m43327a(final Class<T> cls) {
        Utils.m43348a((Class) cls);
        if (this.f41243f) {
            Platform a = Platform.m43306a();
            for (Method method : cls.getDeclaredMethods()) {
                if (!a.mo7892a(method)) {
                    m43330a(method);
                }
            }
        }
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler(this) {
            final /* synthetic */ Retrofit f41229b;
            private final Platform f41230c = Platform.m43306a();

            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, objArr);
                }
                if (this.f41230c.mo7892a(method)) {
                    return this.f41230c.mo7891a(method, cls, obj, objArr);
                }
                obj = this.f41229b.m43330a(method);
                return obj.f41271d.mo7878a(new OkHttpCall(obj, objArr));
            }
        });
    }

    final ServiceMethod<?, ?> m43330a(Method method) {
        ServiceMethod<?, ?> serviceMethod = (ServiceMethod) this.f41244g.get(method);
        if (serviceMethod != null) {
            return serviceMethod;
        }
        ServiceMethod<?, ?> serviceMethod2;
        synchronized (this.f41244g) {
            serviceMethod2 = (ServiceMethod) this.f41244g.get(method);
            if (serviceMethod2 == null) {
                Builder builder = new Builder(this, method);
                builder.f41267w = builder.m43335a();
                builder.f41250f = builder.f41267w.mo7879a();
                if (builder.f41250f != Response.class) {
                    if (builder.f41250f != Response.class) {
                        int i;
                        builder.f41266v = builder.m43338b();
                        for (Annotation annotation : builder.f41247c) {
                            if (annotation instanceof DELETE) {
                                builder.m43337a("DELETE", ((DELETE) annotation).m43358a(), false);
                            } else if (annotation instanceof GET) {
                                builder.m43337a(HttpRequest.METHOD_GET, ((GET) annotation).m43362a(), false);
                            } else if (annotation instanceof HEAD) {
                                builder.m43337a(HttpRequest.METHOD_HEAD, ((HEAD) annotation).m43363a(), false);
                                if (!Void.class.equals(builder.f41250f)) {
                                    throw builder.m43333a(null, "HEAD method must use Void as response type.", new Object[0]);
                                }
                            } else if (annotation instanceof PATCH) {
                                builder.m43337a("PATCH", ((PATCH) annotation).m43370a(), true);
                            } else if (annotation instanceof POST) {
                                builder.m43337a(HttpRequest.METHOD_POST, ((POST) annotation).m43371a(), true);
                            } else if (annotation instanceof PUT) {
                                builder.m43337a(HttpRequest.METHOD_PUT, ((PUT) annotation).m43372a(), true);
                            } else if (annotation instanceof OPTIONS) {
                                builder.m43337a(HttpRequest.METHOD_OPTIONS, ((OPTIONS) annotation).m43369a(), false);
                            } else if (annotation instanceof HTTP) {
                                HTTP http = (HTTP) annotation;
                                builder.m43337a(http.m43364a(), http.m43365b(), http.m43366c());
                            } else if (annotation instanceof Headers) {
                                String[] a = ((Headers) annotation).m43368a();
                                if (a.length == 0) {
                                    throw builder.m43333a(null, "@Headers annotation is empty.", new Object[0]);
                                }
                                builder.f41262r = builder.m43334a(a);
                            } else if (annotation instanceof Multipart) {
                                if (builder.f41259o) {
                                    throw builder.m43333a(null, "Only one encoding annotation is allowed.", new Object[0]);
                                }
                                builder.f41260p = true;
                            } else if (!(annotation instanceof FormUrlEncoded)) {
                                continue;
                            } else if (builder.f41260p) {
                                throw builder.m43333a(null, "Only one encoding annotation is allowed.", new Object[0]);
                            } else {
                                builder.f41259o = true;
                            }
                        }
                        if (builder.f41257m == null) {
                            throw builder.m43333a(null, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
                        }
                        if (!builder.f41258n) {
                            if (builder.f41260p) {
                                throw builder.m43333a(null, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                            } else if (builder.f41259o) {
                                throw builder.m43333a(null, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                            }
                        }
                        int length = builder.f41248d.length;
                        builder.f41265u = new ParameterHandler[length];
                        for (i = 0; i < length; i++) {
                            Type type = builder.f41249e[i];
                            if (Utils.m43354d(type)) {
                                throw builder.m43332a(i, "Parameter type must not include a type variable or wildcard: %s", type);
                            }
                            Annotation[] annotationArr = builder.f41248d[i];
                            if (annotationArr == null) {
                                throw builder.m43332a(i, "No Retrofit annotation found.", new Object[0]);
                            }
                            builder.f41265u[i] = builder.m43336a(i, type, annotationArr);
                        }
                        if (builder.f41261q == null && !builder.f41256l) {
                            throw builder.m43333a(null, "Missing either @%s URL or @Url parameter.", builder.f41257m);
                        } else if (!builder.f41259o && !builder.f41260p && !builder.f41258n && builder.f41253i) {
                            throw builder.m43333a(null, "Non-body HTTP method cannot contain @Body.", new Object[0]);
                        } else if (builder.f41259o && !builder.f41251g) {
                            throw builder.m43333a(null, "Form-encoded method must contain at least one @Field.", new Object[0]);
                        } else if (!builder.f41260p || builder.f41252h) {
                            ServiceMethod<?, ?> serviceMethod3 = new ServiceMethod(builder);
                            this.f41244g.put(method, serviceMethod3);
                            serviceMethod2 = serviceMethod3;
                        } else {
                            throw builder.m43333a(null, "Multipart method must contain at least one @Part.", new Object[0]);
                        }
                    }
                }
                method = new StringBuilder("'");
                method.append(Utils.m43342a(builder.f41250f).getName());
                method.append("' is not a valid response body type. Did you mean ResponseBody?");
                throw builder.m43333a(null, method.toString(), new Object[0]);
            }
        }
        return serviceMethod2;
    }

    public final <T> Converter<T, String> m43328a(Type type, Annotation[] annotationArr) {
        Utils.m43343a((Object) type, "type == null");
        Utils.m43343a((Object) annotationArr, "annotations == null");
        type = this.f41240c.size();
        for (annotationArr = null; annotationArr < type; annotationArr++) {
            this.f41240c.get(annotationArr);
        }
        return ToStringConverter.f41574a;
    }

    public final <T> Converter<T, RequestBody> m43329a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Utils.m43343a((Object) type, "type == null");
        Utils.m43343a((Object) annotationArr, "parameterAnnotations == null");
        Utils.m43343a((Object) annotationArr2, "methodAnnotations == null");
        annotationArr2 = this.f41240c.indexOf(null) + 1;
        int size = this.f41240c.size();
        for (int i = annotationArr2; i < size; i++) {
            Converter<T, RequestBody> b = ((Converter.Factory) this.f41240c.get(i)).mo7877b(type, annotationArr);
            if (b != null) {
                return b;
            }
        }
        annotationArr = new StringBuilder("Could not locate RequestBody converter for ");
        annotationArr.append(type);
        annotationArr.append(".\n");
        annotationArr.append("  Tried:");
        type = this.f41240c.size();
        while (annotationArr2 < type) {
            annotationArr.append("\n   * ");
            annotationArr.append(((Converter.Factory) this.f41240c.get(annotationArr2)).getClass().getName());
            annotationArr2++;
        }
        throw new IllegalArgumentException(annotationArr.toString());
    }
}
