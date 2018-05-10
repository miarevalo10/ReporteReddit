package retrofit2;

import com.facebook.stetho.server.http.HttpStatus;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;

final class OkHttpCall<T> implements Call<T> {
    private final ServiceMethod<T, ?> f41592a;
    private final Object[] f41593b;
    private volatile boolean f41594c;
    private Call f41595d;
    private Throwable f41596e;
    private boolean f41597f;

    static final class ExceptionCatchingRequestBody extends ResponseBody {
        IOException f41588a;
        private final ResponseBody f41589b;

        ExceptionCatchingRequestBody(ResponseBody responseBody) {
            this.f41589b = responseBody;
        }

        public final MediaType contentType() {
            return this.f41589b.contentType();
        }

        public final long contentLength() {
            return this.f41589b.contentLength();
        }

        public final BufferedSource source() {
            return Okio.a(new ForwardingSource(this, this.f41589b.source()) {
                final /* synthetic */ ExceptionCatchingRequestBody f41857a;

                public long read(Buffer buffer, long j) throws IOException {
                    try {
                        return super.read(buffer, j);
                    } catch (Buffer buffer2) {
                        this.f41857a.f41588a = buffer2;
                        throw buffer2;
                    }
                }
            });
        }

        public final void close() {
            this.f41589b.close();
        }
    }

    static final class NoContentResponseBody extends ResponseBody {
        private final MediaType f41590a;
        private final long f41591b;

        NoContentResponseBody(MediaType mediaType, long j) {
            this.f41590a = mediaType;
            this.f41591b = j;
        }

        public final MediaType contentType() {
            return this.f41590a;
        }

        public final long contentLength() {
            return this.f41591b;
        }

        public final BufferedSource source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m43753e();
    }

    public final /* synthetic */ Call mo7887d() {
        return m43753e();
    }

    OkHttpCall(ServiceMethod<T, ?> serviceMethod, Object[] objArr) {
        this.f41592a = serviceMethod;
        this.f41593b = objArr;
    }

    private OkHttpCall<T> m43753e() {
        return new OkHttpCall(this.f41592a, this.f41593b);
    }

    public final void mo7884a(final Callback<T> callback) {
        Utils.m43343a((Object) callback, "callback == null");
        synchronized (this) {
            if (this.f41597f) {
                throw new IllegalStateException("Already executed.");
            }
            this.f41597f = true;
            Call call = this.f41595d;
            Throwable th = this.f41596e;
            if (call == null && th == null) {
                try {
                    Call f = m43754f();
                    this.f41595d = f;
                    call = f;
                } catch (Throwable th2) {
                    th = th2;
                    this.f41596e = th;
                }
            }
        }
        if (th != null) {
            callback.mo7881a((Call) this, th);
            return;
        }
        if (this.f41594c) {
            call.cancel();
        }
        call.enqueue(new Callback(this) {
            final /* synthetic */ OkHttpCall f41587b;

            public void onResponse(Call call, Response response) throws IOException {
                try {
                    try {
                        callback.mo7882a(this.f41587b, this.f41587b.m43756a(response));
                    } catch (Call call2) {
                        call2.printStackTrace();
                    }
                } catch (Call call22) {
                    call22.printStackTrace();
                }
            }

            public void onFailure(Call call, IOException iOException) {
                try {
                    callback.mo7881a(this.f41587b, (Throwable) iOException);
                } catch (Call call2) {
                    call2.printStackTrace();
                }
            }
        });
    }

    public final Response<T> mo7883a() throws IOException {
        Call call;
        synchronized (this) {
            if (this.f41597f) {
                throw new IllegalStateException("Already executed.");
            }
            this.f41597f = true;
            if (this.f41596e == null) {
                call = this.f41595d;
                if (call == null) {
                    try {
                        call = m43754f();
                        this.f41595d = call;
                    } catch (Throwable e) {
                        this.f41596e = e;
                        throw e;
                    }
                }
            } else if (this.f41596e instanceof IOException) {
                throw ((IOException) this.f41596e);
            } else {
                throw ((RuntimeException) this.f41596e);
            }
        }
        if (this.f41594c) {
            call.cancel();
        }
        return m43756a(call.execute());
    }

    private Call m43754f() throws IOException {
        ServiceMethod serviceMethod = this.f41592a;
        Object[] objArr = this.f41593b;
        RequestBuilder requestBuilder = new RequestBuilder(serviceMethod.f41274g, serviceMethod.f41272e, serviceMethod.f41275h, serviceMethod.f41276i, serviceMethod.f41277j, serviceMethod.f41278k, serviceMethod.f41279l, serviceMethod.f41280m);
        ParameterHandler[] parameterHandlerArr = serviceMethod.f41281n;
        int length = objArr != null ? objArr.length : 0;
        if (length != parameterHandlerArr.length) {
            StringBuilder stringBuilder = new StringBuilder("Argument count (");
            stringBuilder.append(length);
            stringBuilder.append(") doesn't match expected count (");
            stringBuilder.append(parameterHandlerArr.length);
            stringBuilder.append(")");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        HttpUrl build;
        for (int i = 0; i < length; i++) {
            parameterHandlerArr[i].mo7888a(requestBuilder, objArr[i]);
        }
        Builder builder = requestBuilder.f41218d;
        if (builder != null) {
            build = builder.build();
        } else {
            build = requestBuilder.f41216b.resolve(requestBuilder.f41217c);
            if (build == null) {
                StringBuilder stringBuilder2 = new StringBuilder("Malformed URL. Base: ");
                stringBuilder2.append(requestBuilder.f41216b);
                stringBuilder2.append(", Relative: ");
                stringBuilder2.append(requestBuilder.f41217c);
                throw new IllegalArgumentException(stringBuilder2.toString());
            }
        }
        RequestBody requestBody = requestBuilder.f41224j;
        if (requestBody == null) {
            if (requestBuilder.f41223i != null) {
                requestBody = requestBuilder.f41223i.build();
            } else if (requestBuilder.f41222h != null) {
                requestBody = requestBuilder.f41222h.build();
            } else if (requestBuilder.f41221g) {
                requestBody = RequestBody.create(null, new byte[0]);
            }
        }
        MediaType mediaType = requestBuilder.f41220f;
        if (mediaType != null) {
            if (requestBody != null) {
                requestBody = new ContentTypeOverridingRequestBody(requestBody, mediaType);
            } else {
                requestBuilder.f41219e.addHeader("Content-Type", mediaType.toString());
            }
        }
        Call newCall = this.f41592a.f41270c.newCall(requestBuilder.f41219e.url(build).method(requestBuilder.f41215a, requestBody).build());
        if (newCall != null) {
            return newCall;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    final Response<T> m43756a(Response response) throws IOException {
        ResponseBody body = response.body();
        response = response.newBuilder().body(new NoContentResponseBody(body.contentType(), body.contentLength())).build();
        int code = response.code();
        if (code >= HttpStatus.HTTP_OK) {
            if (code < 300) {
                if (code != 204) {
                    if (code != 205) {
                        ExceptionCatchingRequestBody exceptionCatchingRequestBody = new ExceptionCatchingRequestBody(body);
                        try {
                            return Response.m43317a(this.f41592a.f41273f.mo7875a(exceptionCatchingRequestBody), response);
                        } catch (Response response2) {
                            if (exceptionCatchingRequestBody.f41588a != null) {
                                throw exceptionCatchingRequestBody.f41588a;
                            }
                            throw response2;
                        }
                    }
                }
                body.close();
                return Response.m43317a(null, response2);
            }
        }
        try {
            response2 = Response.m43318a(Utils.m43347a(body), response2);
            return response2;
        } finally {
            body.close();
        }
    }

    public final void mo7885b() {
        this.f41594c = true;
        synchronized (this) {
            Call call = this.f41595d;
        }
        if (call != null) {
            call.cancel();
        }
    }

    public final boolean mo7886c() {
        boolean z = true;
        if (this.f41594c) {
            return true;
        }
        synchronized (this) {
            if (this.f41595d == null || !this.f41595d.isCanceled()) {
                z = false;
            }
        }
        return z;
    }
}
