package retrofit2;

import okhttp3.ResponseBody;

public final class Response<T> {
    public final okhttp3.Response f41225a;
    public final T f41226b;
    public final ResponseBody f41227c;

    public static <T> Response<T> m43317a(T t, okhttp3.Response response) {
        Utils.m43343a((Object) response, "rawResponse == null");
        if (response.isSuccessful()) {
            return new Response(response, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public static <T> Response<T> m43318a(ResponseBody responseBody, okhttp3.Response response) {
        Utils.m43343a((Object) responseBody, "body == null");
        Utils.m43343a((Object) response, "rawResponse == null");
        if (!response.isSuccessful()) {
            return new Response(response, null, responseBody);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    private Response(okhttp3.Response response, T t, ResponseBody responseBody) {
        this.f41225a = response;
        this.f41226b = t;
        this.f41227c = responseBody;
    }

    public final int m43319a() {
        return this.f41225a.code();
    }

    public final boolean m43320b() {
        return this.f41225a.isSuccessful();
    }

    public final ResponseBody m43321c() {
        return this.f41227c;
    }

    public final String toString() {
        return this.f41225a.toString();
    }
}
