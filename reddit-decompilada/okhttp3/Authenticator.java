package okhttp3;

import java.io.IOException;

public interface Authenticator {
    public static final Authenticator NONE = new C26001();

    class C26001 implements Authenticator {
        public final Request authenticate(Route route, Response response) {
            return null;
        }

        C26001() {
        }
    }

    Request authenticate(Route route, Response response) throws IOException;
}
