package com.sendbird.android.shadow.okhttp3.internal.platform;

import com.sendbird.android.shadow.okhttp3.OkHttpClient;
import com.sendbird.android.shadow.okhttp3.Protocol;
import com.sendbird.android.shadow.okhttp3.internal.tls.BasicCertificateChainCleaner;
import com.sendbird.android.shadow.okhttp3.internal.tls.BasicTrustRootIndex;
import com.sendbird.android.shadow.okhttp3.internal.tls.CertificateChainCleaner;
import com.sendbird.android.shadow.okhttp3.internal.tls.TrustRootIndex;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

public class Platform {
    private static final Logger f23548a = Logger.getLogger(OkHttpClient.class.getName());
    static final Platform f23549c;

    public static String m25550c() {
        return "OkHttp";
    }

    public String mo5369a(SSLSocket sSLSocket) {
        return null;
    }

    public void mo5373a(SSLSocket sSLSocket, String str, List<Protocol> list) {
    }

    public void mo5376b(SSLSocket sSLSocket) {
    }

    public boolean mo5375b(String str) {
        return true;
    }

    public static Platform m25549b() {
        return f23549c;
    }

    public void mo5372a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void mo5370a(int i, String str, Throwable th) {
        f23548a.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object mo5368a(String str) {
        return f23548a.isLoggable(Level.FINE) ? new Throwable(str) : null;
    }

    public void mo5371a(String str, Object obj) {
        if (obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
            str = stringBuilder.toString();
        }
        mo5370a(5, str, (Throwable) obj);
    }

    public static List<String> m25548a(List<Protocol> list) {
        List<String> arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = (Protocol) list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    public CertificateChainCleaner mo5367a(X509TrustManager x509TrustManager) {
        return new BasicCertificateChainCleaner(mo5374b(x509TrustManager));
    }

    public TrustRootIndex mo5374b(X509TrustManager x509TrustManager) {
        return new BasicTrustRootIndex(x509TrustManager.getAcceptedIssuers());
    }

    static {
        Platform a = AndroidPlatform.m31450a();
        if (a == null) {
            a = Jdk9Platform.m31463a();
            if (a == null) {
                a = JdkWithJettyBootPlatform.m31466a();
                if (a == null) {
                    a = new Platform();
                }
            }
        }
        f23549c = a;
    }
}
