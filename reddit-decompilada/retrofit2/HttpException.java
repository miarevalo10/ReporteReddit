package retrofit2;

public class HttpException extends RuntimeException {
    private final int f41209a;
    private final String f41210b;
    private final transient Response<?> f41211c;

    public final Response<?> m43302a() {
        return this.f41211c;
    }

    public HttpException(Response<?> response) {
        Utils.m43343a((Object) response, "response == null");
        StringBuilder stringBuilder = new StringBuilder("HTTP ");
        stringBuilder.append(response.f41225a.code());
        stringBuilder.append(" ");
        stringBuilder.append(response.f41225a.message());
        super(stringBuilder.toString());
        this.f41209a = response.f41225a.code();
        this.f41210b = response.f41225a.message();
        this.f41211c = response;
    }
}
