package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;

public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<Pin> pins;

    public static final class Builder {
        private final List<Pin> pins = new ArrayList();

        public final Builder add(String str, String... strArr) {
            if (str == null) {
                throw new NullPointerException("pattern == null");
            }
            for (String pin : strArr) {
                this.pins.add(new Pin(str, pin));
            }
            return this;
        }

        public final CertificatePinner build() {
            return new CertificatePinner(new LinkedHashSet(this.pins), null);
        }
    }

    static final class Pin {
        private static final String WILDCARD = "*.";
        final String canonicalHostname;
        final ByteString hash;
        final String hashAlgorithm;
        final String pattern;

        Pin(String str, String str2) {
            StringBuilder stringBuilder;
            this.pattern = str;
            if (str.startsWith(WILDCARD)) {
                stringBuilder = new StringBuilder("http://");
                stringBuilder.append(str.substring(2));
                str = HttpUrl.parse(stringBuilder.toString()).host();
            } else {
                stringBuilder = new StringBuilder("http://");
                stringBuilder.append(str);
                str = HttpUrl.parse(stringBuilder.toString()).host();
            }
            this.canonicalHostname = str;
            if (str2.startsWith("sha1/") != null) {
                this.hashAlgorithm = "sha1/";
                this.hash = ByteString.m28270b(str2.substring(5));
            } else if (str2.startsWith("sha256/") != null) {
                this.hashAlgorithm = "sha256/";
                this.hash = ByteString.m28270b(str2.substring(7));
            } else {
                stringBuilder = new StringBuilder("pins must start with 'sha256/' or 'sha1/': ");
                stringBuilder.append(str2);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            if (this.hash == null) {
                stringBuilder = new StringBuilder("pins must be base64: ");
                stringBuilder.append(str2);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }

        final boolean matches(String str) {
            if (!this.pattern.startsWith(WILDCARD)) {
                return str.equals(this.canonicalHostname);
            }
            int indexOf = str.indexOf(46);
            if ((str.length() - indexOf) - 1 == this.canonicalHostname.length()) {
                if (str.regionMatches(false, indexOf + 1, this.canonicalHostname, 0, this.canonicalHostname.length()) != null) {
                    return true;
                }
            }
            return null;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Pin) {
                Pin pin = (Pin) obj;
                if (this.pattern.equals(pin.pattern) && this.hashAlgorithm.equals(pin.hashAlgorithm) && this.hash.equals(pin.hash) != null) {
                    return true;
                }
            }
            return null;
        }

        public final int hashCode() {
            return (31 * (((527 + this.pattern.hashCode()) * 31) + this.hashAlgorithm.hashCode())) + this.hash.hashCode();
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.hashAlgorithm);
            stringBuilder.append(this.hash.mo6159b());
            return stringBuilder.toString();
        }
    }

    CertificatePinner(Set<Pin> set, CertificateChainCleaner certificateChainCleaner) {
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (Util.equal(this.certificateChainCleaner, certificatePinner.certificateChainCleaner) && this.pins.equals(certificatePinner.pins) != null) {
                return true;
            }
        }
        return null;
    }

    public final int hashCode() {
        return (31 * (this.certificateChainCleaner != null ? this.certificateChainCleaner.hashCode() : 0)) + this.pins.hashCode();
    }

    public final void check(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List findMatchingPins = findMatchingPins(str);
        if (!findMatchingPins.isEmpty()) {
            int i;
            if (this.certificateChainCleaner != null) {
                list = this.certificateChainCleaner.clean(list, str);
            }
            int size = list.size();
            int i2 = 0;
            for (i = 0; i < size; i++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i);
                int size2 = findMatchingPins.size();
                Object obj = null;
                Object obj2 = obj;
                for (int i3 = 0; i3 < size2; i3++) {
                    Pin pin = (Pin) findMatchingPins.get(i3);
                    if (pin.hashAlgorithm.equals("sha256/")) {
                        if (obj == null) {
                            obj = sha256(x509Certificate);
                        }
                        if (pin.hash.equals(obj)) {
                            return;
                        }
                    } else if (pin.hashAlgorithm.equals("sha1/")) {
                        if (obj2 == null) {
                            obj2 = sha1(x509Certificate);
                        }
                        if (pin.hash.equals(obj2)) {
                            return;
                        }
                    } else {
                        list = new StringBuilder("unsupported hashAlgorithm: ");
                        list.append(pin.hashAlgorithm);
                        throw new AssertionError(list.toString());
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
            i = list.size();
            for (int i4 = 0; i4 < i; i4++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i4);
                stringBuilder.append("\n    ");
                stringBuilder.append(pin(x509Certificate2));
                stringBuilder.append(": ");
                stringBuilder.append(x509Certificate2.getSubjectDN().getName());
            }
            stringBuilder.append("\n  Pinned certificates for ");
            stringBuilder.append(str);
            stringBuilder.append(":");
            str = findMatchingPins.size();
            while (i2 < str) {
                Pin pin2 = (Pin) findMatchingPins.get(i2);
                stringBuilder.append("\n    ");
                stringBuilder.append(pin2);
                i2++;
            }
            throw new SSLPeerUnverifiedException(stringBuilder.toString());
        }
    }

    public final void check(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        check(str, Arrays.asList(certificateArr));
    }

    final List<Pin> findMatchingPins(String str) {
        List<Pin> emptyList = Collections.emptyList();
        for (Pin pin : this.pins) {
            if (pin.matches(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList();
                }
                emptyList.add(pin);
            }
        }
        return emptyList;
    }

    final CertificatePinner withCertificateChainCleaner(CertificateChainCleaner certificateChainCleaner) {
        if (Util.equal(this.certificateChainCleaner, certificateChainCleaner)) {
            return this;
        }
        return new CertificatePinner(this.pins, certificateChainCleaner);
    }

    public static String pin(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            StringBuilder stringBuilder = new StringBuilder("sha256/");
            stringBuilder.append(sha256((X509Certificate) certificate).mo6159b());
            return stringBuilder.toString();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static ByteString sha1(X509Certificate x509Certificate) {
        return ByteString.m28269a(x509Certificate.getPublicKey().getEncoded()).mo6161d();
    }

    static ByteString sha256(X509Certificate x509Certificate) {
        return ByteString.m28269a(x509Certificate.getPublicKey().getEncoded()).mo6162e();
    }
}
