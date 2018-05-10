package com.sendbird.android.shadow.okhttp3;

import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okhttp3.internal.tls.CertificateChainCleaner;
import com.sendbird.android.shadow.okio.ByteString;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class CertificatePinner {
    public static final CertificatePinner f23093a = new CertificatePinner(new LinkedHashSet(new Builder().f23088a), null);
    final Set<Pin> f23094b;
    final CertificateChainCleaner f23095c;

    public static final class Builder {
        final List<Pin> f23088a = new ArrayList();
    }

    static final class Pin {
        final String f23089a;
        final String f23090b;
        final String f23091c;
        final ByteString f23092d;

        public final boolean equals(Object obj) {
            if (obj instanceof Pin) {
                Pin pin = (Pin) obj;
                if (this.f23089a.equals(pin.f23089a) && this.f23091c.equals(pin.f23091c) && this.f23092d.equals(pin.f23092d) != null) {
                    return true;
                }
            }
            return null;
        }

        public final int hashCode() {
            return (31 * (((527 + this.f23089a.hashCode()) * 31) + this.f23091c.hashCode())) + this.f23092d.hashCode();
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f23091c);
            stringBuilder.append(this.f23092d.mo5398b());
            return stringBuilder.toString();
        }
    }

    CertificatePinner(Set<Pin> set, CertificateChainCleaner certificateChainCleaner) {
        this.f23094b = set;
        this.f23095c = certificateChainCleaner;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (Util.m25371a(this.f23095c, certificatePinner.f23095c) && this.f23094b.equals(certificatePinner.f23094b) != null) {
                return true;
            }
        }
        return null;
    }

    public final int hashCode() {
        return (31 * (this.f23095c != null ? this.f23095c.hashCode() : 0)) + this.f23094b.hashCode();
    }

    public static String m25208a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            StringBuilder stringBuilder = new StringBuilder("sha256/");
            stringBuilder.append(m25207a((X509Certificate) certificate).mo5398b());
            return stringBuilder.toString();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    private static ByteString m25207a(X509Certificate x509Certificate) {
        return ByteString.m25596a(x509Certificate.getPublicKey().getEncoded()).mo5401e();
    }

    public final void m25209a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        String str2 = str;
        List emptyList = Collections.emptyList();
        Iterator it = this.f23094b.iterator();
        List list2 = emptyList;
        while (true) {
            int i = 0;
            if (!it.hasNext()) {
                break;
            }
            int indexOf;
            Pin pin = (Pin) it.next();
            if (pin.f23089a.startsWith("*.")) {
                indexOf = str2.indexOf(46);
                if ((str.length() - indexOf) - 1 == pin.f23090b.length()) {
                    if (str2.regionMatches(false, indexOf + 1, pin.f23090b, 0, pin.f23090b.length())) {
                        i = 1;
                    }
                }
            } else {
                i = str2.equals(pin.f23090b);
            }
            if (i != 0) {
                if (list2.isEmpty()) {
                    list2 = new ArrayList();
                }
                list2.add(pin);
            }
        }
        if (!list2.isEmpty()) {
            int i2;
            StringBuilder stringBuilder;
            emptyList = r0.f23095c != null ? r0.f23095c.mo5365a(list, str2) : list;
            int size = emptyList.size();
            for (i2 = 0; i2 < size; i2++) {
                X509Certificate x509Certificate = (X509Certificate) emptyList.get(i2);
                int size2 = list2.size();
                Object obj = null;
                Object obj2 = obj;
                for (int i3 = 0; i3 < size2; i3++) {
                    Pin pin2 = (Pin) list2.get(i3);
                    if (pin2.f23091c.equals("sha256/")) {
                        if (obj == null) {
                            obj = m25207a(x509Certificate);
                        }
                        if (pin2.f23092d.equals(obj)) {
                            return;
                        }
                    } else if (pin2.f23091c.equals("sha1/")) {
                        if (obj2 == null) {
                            obj2 = ByteString.m25596a(x509Certificate.getPublicKey().getEncoded()).mo5400d();
                        }
                        if (pin2.f23092d.equals(obj2)) {
                            return;
                        }
                    } else {
                        stringBuilder = new StringBuilder("unsupported hashAlgorithm: ");
                        stringBuilder.append(pin2.f23091c);
                        throw new AssertionError(stringBuilder.toString());
                    }
                }
            }
            stringBuilder = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
            i2 = emptyList.size();
            for (int i4 = 0; i4 < i2; i4++) {
                Certificate certificate = (X509Certificate) emptyList.get(i4);
                stringBuilder.append("\n    ");
                stringBuilder.append(m25208a(certificate));
                stringBuilder.append(": ");
                stringBuilder.append(certificate.getSubjectDN().getName());
            }
            stringBuilder.append("\n  Pinned certificates for ");
            stringBuilder.append(str2);
            stringBuilder.append(":");
            indexOf = list2.size();
            while (i < indexOf) {
                Pin pin3 = (Pin) list2.get(i);
                stringBuilder.append("\n    ");
                stringBuilder.append(pin3);
                i++;
            }
            throw new SSLPeerUnverifiedException(stringBuilder.toString());
        }
    }
}
