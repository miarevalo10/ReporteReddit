package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdth.zzb;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class zzdqe {
    private static final Logger f7250a = Logger.getLogger(zzdqe.class.getName());
    private static final ConcurrentMap<String, zzdpw> f7251b = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Boolean> f7252c = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zzdpq> f7253d = new ConcurrentHashMap();

    public static zzdpq m5868a(String str) throws GeneralSecurityException {
        if (str == null) {
            throw new IllegalArgumentException("catalogueName must be non-null.");
        }
        zzdpq com_google_android_gms_internal_zzdpq = (zzdpq) f7253d.get(str.toLowerCase());
        if (com_google_android_gms_internal_zzdpq != null) {
            return com_google_android_gms_internal_zzdpq;
        }
        String format = String.format("no catalogue found for %s. ", new Object[]{str});
        if (str.toLowerCase().startsWith("tinkaead")) {
            str = String.valueOf(format);
            format = "Maybe call AeadConfig.init().";
        } else if (str.toLowerCase().startsWith("tinkhybrid")) {
            str = String.valueOf(format);
            format = "Maybe call HybridConfig.init().";
        } else if (str.toLowerCase().startsWith("tinkmac")) {
            str = String.valueOf(format);
            format = "Maybe call MacConfig.init().";
        } else if (str.toLowerCase().startsWith("tinksignature")) {
            str = String.valueOf(format);
            format = "Maybe call SignatureConfig.init().";
        } else {
            if (str.toLowerCase().startsWith("tink")) {
                str = String.valueOf(format);
                format = "Maybe call TinkConfig.init().";
            }
            throw new GeneralSecurityException(format);
        }
        format = str.concat(format);
        throw new GeneralSecurityException(format);
    }

    public static <P> zzfhe m5871a(String str, zzfhe com_google_android_gms_internal_zzfhe) throws GeneralSecurityException {
        zzdpw b = m5877b(str);
        if (((Boolean) f7252c.get(str)).booleanValue()) {
            return b.mo1859b(com_google_android_gms_internal_zzfhe);
        }
        String str2 = "newKey-operation not permitted for key type ";
        str = String.valueOf(str);
        throw new GeneralSecurityException(str.length() != 0 ? str2.concat(str) : new String(str2));
    }

    private static <P> P m5872a(String str, zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        return m5877b(str).mo1856a(com_google_android_gms_internal_zzfes);
    }

    public static <P> P m5873a(String str, byte[] bArr) throws GeneralSecurityException {
        return m5872a(str, zzfes.m5948a(bArr));
    }

    public static synchronized void m5874a(String str, zzdpq com_google_android_gms_internal_zzdpq) throws GeneralSecurityException {
        synchronized (zzdqe.class) {
            if (f7253d.containsKey(str.toLowerCase())) {
                if (!com_google_android_gms_internal_zzdpq.getClass().equals(((zzdpq) f7253d.get(str.toLowerCase())).getClass())) {
                    Logger logger = f7250a;
                    Level level = Level.WARNING;
                    String str2 = "com.google.crypto.tink.Registry";
                    String str3 = "addCatalogue";
                    String str4 = "Attempted overwrite of a catalogueName catalogue for name ";
                    String valueOf = String.valueOf(str);
                    logger.logp(level, str2, str3, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
                    StringBuilder stringBuilder = new StringBuilder(47 + String.valueOf(str).length());
                    stringBuilder.append("catalogue for name ");
                    stringBuilder.append(str);
                    stringBuilder.append(" has been already registered");
                    throw new GeneralSecurityException(stringBuilder.toString());
                }
            }
            f7253d.put(str.toLowerCase(), com_google_android_gms_internal_zzdpq);
        }
    }

    public static <P> void m5875a(String str, zzdpw<P> com_google_android_gms_internal_zzdpw_P) throws GeneralSecurityException {
        m5876a(str, com_google_android_gms_internal_zzdpw_P, true);
    }

    public static synchronized <P> void m5876a(String str, zzdpw<P> com_google_android_gms_internal_zzdpw_P, boolean z) throws GeneralSecurityException {
        synchronized (zzdqe.class) {
            if (com_google_android_gms_internal_zzdpw_P == null) {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
            if (f7251b.containsKey(str)) {
                zzdpw b = m5877b(str);
                boolean booleanValue = ((Boolean) f7252c.get(str)).booleanValue();
                if (!com_google_android_gms_internal_zzdpw_P.getClass().equals(b.getClass()) || (!booleanValue && z)) {
                    Logger logger = f7250a;
                    Level level = Level.WARNING;
                    String str2 = "com.google.crypto.tink.Registry";
                    String str3 = "registerKeyManager";
                    String str4 = "Attempted overwrite of a registered key manager for key type ";
                    String valueOf = String.valueOf(str);
                    logger.logp(level, str2, str3, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
                    throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", new Object[]{str, b.getClass().getName(), com_google_android_gms_internal_zzdpw_P.getClass().getName()}));
                }
            }
            f7251b.put(str, com_google_android_gms_internal_zzdpw_P);
            f7252c.put(str, Boolean.valueOf(z));
        }
    }

    private static <P> zzdpw<P> m5877b(String str) throws GeneralSecurityException {
        zzdpw<P> com_google_android_gms_internal_zzdpw_P = (zzdpw) f7251b.get(str);
        if (com_google_android_gms_internal_zzdpw_P != null) {
            return com_google_android_gms_internal_zzdpw_P;
        }
        StringBuilder stringBuilder = new StringBuilder(78 + String.valueOf(str).length());
        stringBuilder.append("No key manager found for key type: ");
        stringBuilder.append(str);
        stringBuilder.append(".  Check the configuration of the registry.");
        throw new GeneralSecurityException(stringBuilder.toString());
    }

    public static <P> P m5879b(String str, zzfhe com_google_android_gms_internal_zzfhe) throws GeneralSecurityException {
        return m5877b(str).mo1857a(com_google_android_gms_internal_zzfhe);
    }

    public static <P> zzdsy m5870a(zzdtd com_google_android_gms_internal_zzdtd) throws GeneralSecurityException {
        zzdpw b = m5877b(com_google_android_gms_internal_zzdtd.f19666a);
        if (((Boolean) f7252c.get(com_google_android_gms_internal_zzdtd.f19666a)).booleanValue()) {
            return b.mo1860c(com_google_android_gms_internal_zzdtd.f19667b);
        }
        String str = "newKey-operation not permitted for key type ";
        com_google_android_gms_internal_zzdtd = String.valueOf(com_google_android_gms_internal_zzdtd.f19666a);
        throw new GeneralSecurityException(com_google_android_gms_internal_zzdtd.length() != 0 ? str.concat(com_google_android_gms_internal_zzdtd) : new String(str));
    }

    public static <P> zzfhe m5878b(zzdtd com_google_android_gms_internal_zzdtd) throws GeneralSecurityException {
        zzdpw b = m5877b(com_google_android_gms_internal_zzdtd.f19666a);
        if (((Boolean) f7252c.get(com_google_android_gms_internal_zzdtd.f19666a)).booleanValue()) {
            return b.mo1858b(com_google_android_gms_internal_zzdtd.f19667b);
        }
        String str = "newKey-operation not permitted for key type ";
        com_google_android_gms_internal_zzdtd = String.valueOf(com_google_android_gms_internal_zzdtd.f19666a);
        throw new GeneralSecurityException(com_google_android_gms_internal_zzdtd.length() != 0 ? str.concat(com_google_android_gms_internal_zzdtd) : new String(str));
    }

    public static <P> zzdqc<P> m5869a(zzdpx com_google_android_gms_internal_zzdpx) throws GeneralSecurityException {
        zzdth com_google_android_gms_internal_zzdth = com_google_android_gms_internal_zzdpx.f7241a;
        if (com_google_android_gms_internal_zzdth.m21206a() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        int i = com_google_android_gms_internal_zzdth.f19684a;
        byte b = (byte) 1;
        byte b2 = (byte) 0;
        for (zzb com_google_android_gms_internal_zzdth_zzb : com_google_android_gms_internal_zzdth.f19685b) {
            if ((com_google_android_gms_internal_zzdth_zzb.f19678a != null ? (byte) 1 : (byte) 0) == (byte) 0) {
                throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(com_google_android_gms_internal_zzdth_zzb.f19679b)}));
            } else if (com_google_android_gms_internal_zzdth_zzb.m21203d() == zzdtt.UNKNOWN_PREFIX) {
                throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(com_google_android_gms_internal_zzdth_zzb.f19679b)}));
            } else if (com_google_android_gms_internal_zzdth_zzb.m21201b() == zzdtb.UNKNOWN_STATUS) {
                throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(com_google_android_gms_internal_zzdth_zzb.f19679b)}));
            } else {
                if (com_google_android_gms_internal_zzdth_zzb.m21201b() == zzdtb.ENABLED && com_google_android_gms_internal_zzdth_zzb.f19679b == i) {
                    if (b2 != (byte) 0) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    b2 = (byte) 1;
                }
                if (com_google_android_gms_internal_zzdth_zzb.m21198a().m21171a() != zzdsy.zzb.ASYMMETRIC_PUBLIC) {
                    b = (byte) 0;
                }
            }
        }
        if (b2 == (byte) 0 && r5 == (byte) 0) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
        zzdqc<P> com_google_android_gms_internal_zzdqc = new zzdqc();
        for (zzb com_google_android_gms_internal_zzdth_zzb2 : com_google_android_gms_internal_zzdpx.f7241a.f19685b) {
            if (com_google_android_gms_internal_zzdth_zzb2.m21201b() == zzdtb.ENABLED) {
                ByteBuffer put;
                int i2;
                byte[] bArr;
                Object a = m5872a(com_google_android_gms_internal_zzdth_zzb2.m21198a().f19661a, com_google_android_gms_internal_zzdth_zzb2.m21198a().f19662b);
                switch (zzdpt.f7240a[com_google_android_gms_internal_zzdth_zzb2.m21203d().ordinal()]) {
                    case 1:
                    case 2:
                        put = ByteBuffer.allocate(5).put((byte) 0);
                        i2 = com_google_android_gms_internal_zzdth_zzb2.f19679b;
                        break;
                    case 3:
                        put = ByteBuffer.allocate(5).put((byte) 1);
                        i2 = com_google_android_gms_internal_zzdth_zzb2.f19679b;
                        break;
                    case 4:
                        bArr = zzdps.f7239a;
                        break;
                    default:
                        throw new GeneralSecurityException("unknown output prefix type");
                }
                bArr = put.putInt(i2).array();
                zzdqd com_google_android_gms_internal_zzdqd = new zzdqd(a, bArr, com_google_android_gms_internal_zzdth_zzb2.m21201b(), com_google_android_gms_internal_zzdth_zzb2.m21203d());
                List arrayList = new ArrayList();
                arrayList.add(com_google_android_gms_internal_zzdqd);
                String str = new String(com_google_android_gms_internal_zzdqd.m5867a(), zzdqc.f7243a);
                arrayList = (List) com_google_android_gms_internal_zzdqc.f7244b.put(str, Collections.unmodifiableList(arrayList));
                if (arrayList != null) {
                    List arrayList2 = new ArrayList();
                    arrayList2.addAll(arrayList);
                    arrayList2.add(com_google_android_gms_internal_zzdqd);
                    com_google_android_gms_internal_zzdqc.f7244b.put(str, Collections.unmodifiableList(arrayList2));
                }
                if (com_google_android_gms_internal_zzdth_zzb2.f19679b == com_google_android_gms_internal_zzdpx.f7241a.f19684a) {
                    com_google_android_gms_internal_zzdqc.f7245c = com_google_android_gms_internal_zzdqd;
                }
            }
        }
        return com_google_android_gms_internal_zzdqc;
    }
}
