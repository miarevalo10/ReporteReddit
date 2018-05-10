package okhttp3;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.net.Authenticator;
import java.net.Authenticator.RequestorType;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.List;

public final class JavaNetAuthenticator implements Authenticator {
    public final Request authenticate(Route route, Response response) throws IOException {
        JavaNetAuthenticator javaNetAuthenticator = this;
        List challenges = response.challenges();
        Request request = response.request();
        HttpUrl url = request.url();
        int i = 0;
        int i2 = response.code() == 407 ? 1 : 0;
        Proxy proxy = route.proxy();
        int size = challenges.size();
        while (i < size) {
            Challenge challenge = (Challenge) challenges.get(i);
            if ("Basic".equalsIgnoreCase(challenge.scheme())) {
                PasswordAuthentication requestPasswordAuthentication;
                if (i2 != 0) {
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) proxy.address();
                    requestPasswordAuthentication = Authenticator.requestPasswordAuthentication(inetSocketAddress.getHostName(), getConnectToInetAddress(proxy, url), inetSocketAddress.getPort(), url.scheme(), challenge.realm(), challenge.scheme(), url.url(), RequestorType.PROXY);
                } else {
                    requestPasswordAuthentication = Authenticator.requestPasswordAuthentication(url.host(), getConnectToInetAddress(proxy, url), url.port(), url.scheme(), challenge.realm(), challenge.scheme(), url.url(), RequestorType.SERVER);
                }
                if (requestPasswordAuthentication != null) {
                    return request.newBuilder().header(i2 != 0 ? HttpRequest.HEADER_PROXY_AUTHORIZATION : HttpRequest.HEADER_AUTHORIZATION, Credentials.basic(requestPasswordAuthentication.getUserName(), new String(requestPasswordAuthentication.getPassword()), challenge.charset())).build();
                }
            }
            i++;
        }
        return null;
    }

    private InetAddress getConnectToInetAddress(Proxy proxy, HttpUrl httpUrl) throws IOException {
        if (proxy == null || proxy.type() == Type.DIRECT) {
            return InetAddress.getByName(httpUrl.host());
        }
        return ((InetSocketAddress) proxy.address()).getAddress();
    }
}
