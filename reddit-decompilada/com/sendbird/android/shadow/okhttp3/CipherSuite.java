package com.sendbird.android.shadow.okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class CipherSuite {
    public static final CipherSuite f23096A = m25210a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA");
    public static final CipherSuite f23097B = m25210a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA");
    public static final CipherSuite f23098C = m25210a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5");
    public static final CipherSuite f23099D = m25210a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5");
    public static final CipherSuite f23100E = m25210a("TLS_RSA_WITH_AES_128_CBC_SHA");
    public static final CipherSuite f23101F = m25210a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA");
    public static final CipherSuite f23102G = m25210a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA");
    public static final CipherSuite f23103H = m25210a("TLS_DH_anon_WITH_AES_128_CBC_SHA");
    public static final CipherSuite f23104I = m25210a("TLS_RSA_WITH_AES_256_CBC_SHA");
    public static final CipherSuite f23105J = m25210a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA");
    public static final CipherSuite f23106K = m25210a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA");
    public static final CipherSuite f23107L = m25210a("TLS_DH_anon_WITH_AES_256_CBC_SHA");
    public static final CipherSuite f23108M = m25210a("TLS_RSA_WITH_NULL_SHA256");
    public static final CipherSuite f23109N = m25210a("TLS_RSA_WITH_AES_128_CBC_SHA256");
    public static final CipherSuite f23110O = m25210a("TLS_RSA_WITH_AES_256_CBC_SHA256");
    public static final CipherSuite f23111P = m25210a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256");
    public static final CipherSuite f23112Q = m25210a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA");
    public static final CipherSuite f23113R = m25210a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA");
    public static final CipherSuite f23114S = m25210a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA");
    public static final CipherSuite f23115T = m25210a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256");
    public static final CipherSuite f23116U = m25210a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256");
    public static final CipherSuite f23117V = m25210a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256");
    public static final CipherSuite f23118W = m25210a("TLS_DH_anon_WITH_AES_128_CBC_SHA256");
    public static final CipherSuite f23119X = m25210a("TLS_DH_anon_WITH_AES_256_CBC_SHA256");
    public static final CipherSuite f23120Y = m25210a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA");
    public static final CipherSuite f23121Z = m25210a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA");
    static final Comparator<String> f23122a = new C20361();
    public static final CipherSuite aA = m25210a("TLS_ECDH_RSA_WITH_NULL_SHA");
    public static final CipherSuite aB = m25210a("TLS_ECDH_RSA_WITH_RC4_128_SHA");
    public static final CipherSuite aC = m25210a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA");
    public static final CipherSuite aD = m25210a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA");
    public static final CipherSuite aE = m25210a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA");
    public static final CipherSuite aF = m25210a("TLS_ECDHE_RSA_WITH_NULL_SHA");
    public static final CipherSuite aG = m25210a("TLS_ECDHE_RSA_WITH_RC4_128_SHA");
    public static final CipherSuite aH = m25210a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA");
    public static final CipherSuite aI = m25210a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");
    public static final CipherSuite aJ = m25210a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA");
    public static final CipherSuite aK = m25210a("TLS_ECDH_anon_WITH_NULL_SHA");
    public static final CipherSuite aL = m25210a("TLS_ECDH_anon_WITH_RC4_128_SHA");
    public static final CipherSuite aM = m25210a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA");
    public static final CipherSuite aN = m25210a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA");
    public static final CipherSuite aO = m25210a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA");
    public static final CipherSuite aP = m25210a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256");
    public static final CipherSuite aQ = m25210a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384");
    public static final CipherSuite aR = m25210a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256");
    public static final CipherSuite aS = m25210a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384");
    public static final CipherSuite aT = m25210a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");
    public static final CipherSuite aU = m25210a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");
    public static final CipherSuite aV = m25210a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256");
    public static final CipherSuite aW = m25210a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384");
    public static final CipherSuite aX = m25210a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");
    public static final CipherSuite aY = m25210a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384");
    public static final CipherSuite aZ = m25210a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256");
    public static final CipherSuite aa = m25210a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA");
    public static final CipherSuite ab = m25210a("TLS_PSK_WITH_RC4_128_SHA");
    public static final CipherSuite ac = m25210a("TLS_PSK_WITH_3DES_EDE_CBC_SHA");
    public static final CipherSuite ad = m25210a("TLS_PSK_WITH_AES_128_CBC_SHA");
    public static final CipherSuite ae = m25210a("TLS_PSK_WITH_AES_256_CBC_SHA");
    public static final CipherSuite af = m25210a("TLS_RSA_WITH_SEED_CBC_SHA");
    public static final CipherSuite ag = m25210a("TLS_RSA_WITH_AES_128_GCM_SHA256");
    public static final CipherSuite ah = m25210a("TLS_RSA_WITH_AES_256_GCM_SHA384");
    public static final CipherSuite ai = m25210a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256");
    public static final CipherSuite aj = m25210a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384");
    public static final CipherSuite ak = m25210a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256");
    public static final CipherSuite al = m25210a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384");
    public static final CipherSuite am = m25210a("TLS_DH_anon_WITH_AES_128_GCM_SHA256");
    public static final CipherSuite an = m25210a("TLS_DH_anon_WITH_AES_256_GCM_SHA384");
    public static final CipherSuite ao = m25210a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV");
    public static final CipherSuite ap = m25210a("TLS_FALLBACK_SCSV");
    public static final CipherSuite aq = m25210a("TLS_ECDH_ECDSA_WITH_NULL_SHA");
    public static final CipherSuite ar = m25210a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA");
    public static final CipherSuite as = m25210a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA");
    public static final CipherSuite at = m25210a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA");
    public static final CipherSuite au = m25210a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA");
    public static final CipherSuite av = m25210a("TLS_ECDHE_ECDSA_WITH_NULL_SHA");
    public static final CipherSuite aw = m25210a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA");
    public static final CipherSuite ax = m25210a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA");
    public static final CipherSuite ay = m25210a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA");
    public static final CipherSuite az = m25210a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA");
    public static final CipherSuite f23123b = m25210a("SSL_RSA_WITH_NULL_MD5");
    public static final CipherSuite ba = m25210a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384");
    public static final CipherSuite bb = m25210a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
    public static final CipherSuite bc = m25210a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384");
    public static final CipherSuite bd = m25210a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256");
    public static final CipherSuite be = m25210a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384");
    public static final CipherSuite bf = m25210a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA");
    public static final CipherSuite bg = m25210a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA");
    public static final CipherSuite bh = m25210a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
    public static final CipherSuite bi = m25210a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256");
    private static final Map<String, CipherSuite> bk = new TreeMap(f23122a);
    public static final CipherSuite f23124c = m25210a("SSL_RSA_WITH_NULL_SHA");
    public static final CipherSuite f23125d = m25210a("SSL_RSA_EXPORT_WITH_RC4_40_MD5");
    public static final CipherSuite f23126e = m25210a("SSL_RSA_WITH_RC4_128_MD5");
    public static final CipherSuite f23127f = m25210a("SSL_RSA_WITH_RC4_128_SHA");
    public static final CipherSuite f23128g = m25210a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA");
    public static final CipherSuite f23129h = m25210a("SSL_RSA_WITH_DES_CBC_SHA");
    public static final CipherSuite f23130i = m25210a("SSL_RSA_WITH_3DES_EDE_CBC_SHA");
    public static final CipherSuite f23131j = m25210a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA");
    public static final CipherSuite f23132k = m25210a("SSL_DHE_DSS_WITH_DES_CBC_SHA");
    public static final CipherSuite f23133l = m25210a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA");
    public static final CipherSuite f23134m = m25210a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA");
    public static final CipherSuite f23135n = m25210a("SSL_DHE_RSA_WITH_DES_CBC_SHA");
    public static final CipherSuite f23136o = m25210a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA");
    public static final CipherSuite f23137p = m25210a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5");
    public static final CipherSuite f23138q = m25210a("SSL_DH_anon_WITH_RC4_128_MD5");
    public static final CipherSuite f23139r = m25210a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA");
    public static final CipherSuite f23140s = m25210a("SSL_DH_anon_WITH_DES_CBC_SHA");
    public static final CipherSuite f23141t = m25210a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA");
    public static final CipherSuite f23142u = m25210a("TLS_KRB5_WITH_DES_CBC_SHA");
    public static final CipherSuite f23143v = m25210a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA");
    public static final CipherSuite f23144w = m25210a("TLS_KRB5_WITH_RC4_128_SHA");
    public static final CipherSuite f23145x = m25210a("TLS_KRB5_WITH_DES_CBC_MD5");
    public static final CipherSuite f23146y = m25210a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5");
    public static final CipherSuite f23147z = m25210a("TLS_KRB5_WITH_RC4_128_MD5");
    final String bj;

    class C20361 implements Comparator<String> {
        C20361() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            String str = (String) obj;
            String str2 = (String) obj2;
            int min = Math.min(str.length(), str2.length());
            int i = 4;
            while (i < min) {
                char charAt = str.charAt(i);
                char charAt2 = str2.charAt(i);
                if (charAt != charAt2) {
                    return charAt < charAt2 ? -1 : 1;
                } else {
                    i++;
                }
            }
            obj = str.length();
            obj2 = str2.length();
            if (obj != obj2) {
                return obj < obj2 ? -1 : 1;
            } else {
                return null;
            }
        }
    }

    public static synchronized CipherSuite m25210a(String str) {
        CipherSuite cipherSuite;
        synchronized (CipherSuite.class) {
            cipherSuite = (CipherSuite) bk.get(str);
            if (cipherSuite == null) {
                cipherSuite = new CipherSuite(str);
                bk.put(str, cipherSuite);
            }
        }
        return cipherSuite;
    }

    static List<CipherSuite> m25211a(String... strArr) {
        List arrayList = new ArrayList(strArr.length);
        for (String a : strArr) {
            arrayList.add(m25210a(a));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private CipherSuite(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.bj = str;
    }

    public final String toString() {
        return this.bj;
    }
}
