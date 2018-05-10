package retrofit2.adapter.rxjava2;

import retrofit2.Response;

public final class Result<T> {
    private final Response<T> f41289a;
    private final Throwable f41290b;

    public static <T> Result<T> m43356a(Throwable th) {
        if (th != null) {
            return new Result(null, th);
        }
        throw new NullPointerException("error == null");
    }

    public static <T> Result<T> m43357a(Response<T> response) {
        if (response != null) {
            return new Result(response, null);
        }
        throw new NullPointerException("response == null");
    }

    private Result(Response<T> response, Throwable th) {
        this.f41289a = response;
        this.f41290b = th;
    }
}
