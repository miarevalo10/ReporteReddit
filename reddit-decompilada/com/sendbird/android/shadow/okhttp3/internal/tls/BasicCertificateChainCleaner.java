package com.sendbird.android.shadow.okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class BasicCertificateChainCleaner extends CertificateChainCleaner {
    private final TrustRootIndex f30527a;

    public BasicCertificateChainCleaner(TrustRootIndex trustRootIndex) {
        this.f30527a = trustRootIndex;
    }

    public final List<Certificate> mo5365a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
        str = new ArrayDeque(list);
        list = new ArrayList();
        list.add(str.removeFirst());
        int i = 0;
        int i2 = 0;
        while (i < 9) {
            X509Certificate x509Certificate = (X509Certificate) list.get(list.size() - 1);
            X509Certificate a = this.f30527a.mo5366a(x509Certificate);
            if (a != null) {
                if (list.size() > 1 || !x509Certificate.equals(a)) {
                    list.add(a);
                }
                if (m31470a(a, a)) {
                    return list;
                }
                i2 = 1;
            } else {
                Iterator it = str.iterator();
                while (it.hasNext()) {
                    a = (X509Certificate) it.next();
                    if (m31470a(x509Certificate, a)) {
                        it.remove();
                        list.add(a);
                    }
                }
                if (i2 != 0) {
                    return list;
                }
                str = new StringBuilder("Failed to find a trusted cert that signed ");
                str.append(x509Certificate);
                throw new SSLPeerUnverifiedException(str.toString());
            }
            i++;
        }
        StringBuilder stringBuilder = new StringBuilder("Certificate chain too long: ");
        stringBuilder.append(list);
        throw new SSLPeerUnverifiedException(stringBuilder.toString());
    }

    private static boolean m31470a(java.security.cert.X509Certificate r2, java.security.cert.X509Certificate r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r2.getIssuerDN();
        r1 = r3.getSubjectDN();
        r0 = r0.equals(r1);
        r1 = 0;
        if (r0 != 0) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r3 = r3.getPublicKey();	 Catch:{ GeneralSecurityException -> 0x0019 }
        r2.verify(r3);	 Catch:{ GeneralSecurityException -> 0x0019 }
        r2 = 1;
        return r2;
    L_0x0019:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.tls.BasicCertificateChainCleaner.a(java.security.cert.X509Certificate, java.security.cert.X509Certificate):boolean");
    }

    public final int hashCode() {
        return this.f30527a.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BasicCertificateChainCleaner) || ((BasicCertificateChainCleaner) obj).f30527a.equals(this.f30527a) == null) {
            return null;
        }
        return true;
    }
}
