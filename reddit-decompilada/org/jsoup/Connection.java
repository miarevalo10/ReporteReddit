package org.jsoup;

import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

public interface Connection {

    public interface Base<T extends Base> {
        T cookie(String str, String str2);

        Map<String, String> cookies();

        boolean hasHeader(String str);

        T header(String str, String str2);

        Map<String, String> headers();

        T method(Method method);

        Method method();

        URL url();

        T url(URL url);
    }

    public interface KeyVal {
        String m28427a();

        String m28428b();

        InputStream m28429c();

        boolean m28430d();
    }

    public enum Method {
        GET(false),
        POST(true),
        PUT(true),
        DELETE(false),
        PATCH(true),
        HEAD(false),
        OPTIONS(false),
        TRACE(false);
        
        public final boolean f26955i;

        private Method(boolean z) {
            this.f26955i = z;
        }
    }

    public interface Request extends Base<Request> {
        Collection<KeyVal> data();

        Request data(KeyVal keyVal);

        Request followRedirects(boolean z);

        boolean followRedirects();

        Request ignoreContentType(boolean z);

        boolean ignoreContentType();

        Request ignoreHttpErrors(boolean z);

        boolean ignoreHttpErrors();

        int maxBodySize();

        Request maxBodySize(int i);

        Request parser(Parser parser);

        Parser parser();

        String postDataCharset();

        Request postDataCharset(String str);

        Proxy proxy();

        Request proxy(String str, int i);

        Request proxy(Proxy proxy);

        String requestBody();

        Request requestBody(String str);

        int timeout();

        Request timeout(int i);

        void validateTLSCertificates(boolean z);

        boolean validateTLSCertificates();
    }

    public interface Response extends Base<Response> {
        Document mo6854a() throws IOException;
    }

    Connection mo6325a(String str);

    Document mo6326a() throws IOException;
}
