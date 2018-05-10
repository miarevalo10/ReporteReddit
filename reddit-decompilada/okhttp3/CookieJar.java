package okhttp3;

import java.util.Collections;
import java.util.List;

public interface CookieJar {
    public static final CookieJar NO_COOKIES = new C26021();

    class C26021 implements CookieJar {
        public final void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        }

        C26021() {
        }

        public final List<Cookie> loadForRequest(HttpUrl httpUrl) {
            return Collections.emptyList();
        }
    }

    List<Cookie> loadForRequest(HttpUrl httpUrl);

    void saveFromResponse(HttpUrl httpUrl, List<Cookie> list);
}
