package okhttp3;

import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import okhttp3.internal.URLFilter;
import okhttp3.internal.huc.OkHttpURLConnection;
import okhttp3.internal.huc.OkHttpsURLConnection;
import org.jcodec.containers.mps.MPSUtils;

public final class OkUrlFactory implements Cloneable, URLStreamHandlerFactory {
    private OkHttpClient client;
    private URLFilter urlFilter;

    public OkUrlFactory(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    public final OkHttpClient client() {
        return this.client;
    }

    public final OkUrlFactory setClient(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
        return this;
    }

    final void setUrlFilter(URLFilter uRLFilter) {
        this.urlFilter = uRLFilter;
    }

    public final OkUrlFactory clone() {
        return new OkUrlFactory(this.client);
    }

    public final HttpURLConnection open(URL url) {
        return open(url, this.client.proxy());
    }

    final HttpURLConnection open(URL url, Proxy proxy) {
        String protocol = url.getProtocol();
        proxy = this.client.newBuilder().proxy(proxy).build();
        if (protocol.equals("http")) {
            return new OkHttpURLConnection(url, proxy, this.urlFilter);
        }
        if (protocol.equals("https")) {
            return new OkHttpsURLConnection(url, proxy, this.urlFilter);
        }
        proxy = new StringBuilder("Unexpected protocol: ");
        proxy.append(protocol);
        throw new IllegalArgumentException(proxy.toString());
    }

    public final URLStreamHandler createURLStreamHandler(final String str) {
        if (str.equals("http") || str.equals("https")) {
            return new URLStreamHandler() {
                protected URLConnection openConnection(URL url) {
                    return OkUrlFactory.this.open(url);
                }

                protected URLConnection openConnection(URL url, Proxy proxy) {
                    return OkUrlFactory.this.open(url, proxy);
                }

                protected int getDefaultPort() {
                    if (str.equals("http")) {
                        return 80;
                    }
                    if (str.equals("https")) {
                        return MPSUtils.SYSTEM;
                    }
                    throw new AssertionError();
                }
            };
        }
        return null;
    }
}
