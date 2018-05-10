package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.Fabric;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

class PinningTrustManager implements X509TrustManager {
    private static final X509Certificate[] f24852a = new X509Certificate[0];
    private final TrustManager[] f24853b;
    private final SystemKeyStore f24854c;
    private final long f24855d;
    private final List<byte[]> f24856e = new LinkedList();
    private final Set<X509Certificate> f24857f = Collections.synchronizedSet(new HashSet());

    public PinningTrustManager(SystemKeyStore systemKeyStore, PinningInfoProvider pinningInfoProvider) {
        this.f24853b = m26416a(systemKeyStore);
        this.f24854c = systemKeyStore;
        this.f24855d = pinningInfoProvider.getPinCreationTimeInMillis();
        systemKeyStore = pinningInfoProvider.getPins();
        for (String a : systemKeyStore) {
            this.f24856e.add(m26415a(a));
        }
    }

    private static TrustManager[] m26416a(SystemKeyStore systemKeyStore) {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            instance.init(systemKeyStore.f24858a);
            return instance.getTrustManagers();
        } catch (SystemKeyStore systemKeyStore2) {
            throw new AssertionError(systemKeyStore2);
        } catch (SystemKeyStore systemKeyStore22) {
            throw new AssertionError(systemKeyStore22);
        }
    }

    private boolean m26414a(X509Certificate x509Certificate) throws CertificateException {
        try {
            x509Certificate = MessageDigest.getInstance("SHA1").digest(x509Certificate.getPublicKey().getEncoded());
            for (byte[] equals : this.f24856e) {
                if (Arrays.equals(equals, x509Certificate)) {
                    return true;
                }
            }
            return null;
        } catch (X509Certificate x509Certificate2) {
            throw new CertificateException(x509Certificate2);
        }
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        throw new CertificateException("Client certificates not supported!");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (!this.f24857f.contains(x509CertificateArr[0])) {
            int i;
            for (TrustManager trustManager : this.f24853b) {
                ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
            }
            if (this.f24855d == -1 || System.currentTimeMillis() - this.f24855d <= 15552000000L) {
                str = CertificateChainCleaner.m26399a(x509CertificateArr, this.f24854c);
                int length = str.length;
                i = 0;
                while (i < length) {
                    if (!m26414a(str[i])) {
                        i++;
                    }
                }
                throw new CertificateException("No valid pins found in chain!");
            }
            StringBuilder stringBuilder = new StringBuilder("Certificate pins are stale, (");
            stringBuilder.append(System.currentTimeMillis() - this.f24855d);
            stringBuilder.append(" millis vs 15552000000 millis) falling back to system trust.");
            Fabric.m26243b().mo5569d("Fabric", stringBuilder.toString());
            this.f24857f.add(x509CertificateArr[0]);
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return f24852a;
    }

    private static byte[] m26415a(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
