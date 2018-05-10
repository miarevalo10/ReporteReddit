package io.fabric.sdk.android.services.network;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.Principal;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashMap;

class SystemKeyStore {
    final KeyStore f24858a;
    private final HashMap<Principal, X509Certificate> f24859b;

    public SystemKeyStore(InputStream inputStream, String str) {
        KeyStore a = m26417a(inputStream, str);
        this.f24859b = m26418a(a);
        this.f24858a = a;
    }

    public final boolean m26419a(X509Certificate x509Certificate) {
        X509Certificate x509Certificate2 = (X509Certificate) this.f24859b.get(x509Certificate.getSubjectX500Principal());
        return (x509Certificate2 == null || x509Certificate2.getPublicKey().equals(x509Certificate.getPublicKey()) == null) ? null : true;
    }

    public final java.security.cert.X509Certificate m26420b(java.security.cert.X509Certificate r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r0 = r4.f24859b;
        r1 = r5.getIssuerX500Principal();
        r0 = r0.get(r1);
        r0 = (java.security.cert.X509Certificate) r0;
        r1 = 0;
        if (r0 != 0) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r2 = r0.getSubjectX500Principal();
        r3 = r5.getSubjectX500Principal();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x001f;
    L_0x001e:
        return r1;
    L_0x001f:
        r2 = r0.getPublicKey();	 Catch:{ GeneralSecurityException -> 0x0027 }
        r5.verify(r2);	 Catch:{ GeneralSecurityException -> 0x0027 }
        return r0;
    L_0x0027:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.network.SystemKeyStore.b(java.security.cert.X509Certificate):java.security.cert.X509Certificate");
    }

    private static HashMap<Principal, X509Certificate> m26418a(KeyStore keyStore) {
        try {
            HashMap<Principal, X509Certificate> hashMap = new HashMap();
            Enumeration aliases = keyStore.aliases();
            while (aliases.hasMoreElements()) {
                X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate((String) aliases.nextElement());
                if (x509Certificate != null) {
                    hashMap.put(x509Certificate.getSubjectX500Principal(), x509Certificate);
                }
            }
            return hashMap;
        } catch (KeyStore keyStore2) {
            throw new AssertionError(keyStore2);
        }
    }

    private static KeyStore m26417a(InputStream inputStream, String str) {
        InputStream bufferedInputStream;
        try {
            KeyStore instance = KeyStore.getInstance("BKS");
            bufferedInputStream = new BufferedInputStream(inputStream);
            instance.load(bufferedInputStream, str.toCharArray());
            bufferedInputStream.close();
            return instance;
        } catch (InputStream inputStream2) {
            throw new AssertionError(inputStream2);
        } catch (InputStream inputStream22) {
            throw new AssertionError(inputStream22);
        } catch (InputStream inputStream222) {
            throw new AssertionError(inputStream222);
        } catch (InputStream inputStream2222) {
            throw new AssertionError(inputStream2222);
        } catch (Throwable th) {
            bufferedInputStream.close();
        }
    }
}
