package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import javax.crypto.KeyAgreement;

public final class zzdul implements zzdpv {
    private static final byte[] f14387a = new byte[0];
    private final zzdun f14388b;
    private final String f14389c;
    private final byte[] f14390d;
    private final zzdus f14391e;
    private final zzduj f14392f;

    public zzdul(ECPublicKey eCPublicKey, byte[] bArr, String str, zzdus com_google_android_gms_internal_zzdus, zzduj com_google_android_gms_internal_zzduj) throws GeneralSecurityException {
        zzdup.m5908a(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.f14388b = new zzdun(eCPublicKey);
        this.f14390d = bArr;
        this.f14389c = str;
        this.f14391e = com_google_android_gms_internal_zzdus;
        this.f14392f = com_google_android_gms_internal_zzduj;
    }

    public final byte[] mo1862a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3;
        zzdun com_google_android_gms_internal_zzdun = this.f14388b;
        String str = this.f14389c;
        byte[] bArr4 = this.f14390d;
        int a = this.f14392f.mo1863a();
        zzdus com_google_android_gms_internal_zzdus = this.f14391e;
        KeyPairGenerator keyPairGenerator = (KeyPairGenerator) zzduu.f7330d.m5911a("EC");
        keyPairGenerator.initialize(com_google_android_gms_internal_zzdun.f7315a.getParams());
        KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
        ECPublicKey eCPublicKey = (ECPublicKey) generateKeyPair.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) generateKeyPair.getPrivate();
        zzdup.m5908a(com_google_android_gms_internal_zzdun.f7315a.getW(), com_google_android_gms_internal_zzdun.f7315a.getParams().getCurve());
        KeyAgreement keyAgreement = (KeyAgreement) zzduu.f7329c.m5911a("ECDH");
        keyAgreement.init(eCPrivateKey);
        keyAgreement.doPhase(com_google_android_gms_internal_zzdun.f7315a, true);
        byte[] generateSecret = keyAgreement.generateSecret();
        EllipticCurve curve = eCPublicKey.getParams().getCurve();
        ECPoint w = eCPublicKey.getW();
        zzdup.m5908a(w, curve);
        int a2 = zzdup.m5905a(curve);
        Object obj;
        switch (zzduq.f7318a[com_google_android_gms_internal_zzdus.ordinal()]) {
            case 1:
                int i = (2 * a2) + 1;
                obj = new byte[i];
                Object toByteArray = w.getAffineX().toByteArray();
                Object toByteArray2 = w.getAffineY().toByteArray();
                System.arraycopy(toByteArray2, 0, obj, i - toByteArray2.length, toByteArray2.length);
                System.arraycopy(toByteArray, 0, obj, (a2 + 1) - toByteArray.length, toByteArray.length);
                obj[0] = (byte) 4;
                bArr3 = obj;
                break;
            case 2:
                a2++;
                bArr3 = new byte[a2];
                obj = w.getAffineX().toByteArray();
                System.arraycopy(obj, 0, bArr3, a2 - obj.length, obj.length);
                bArr3[0] = (byte) (w.getAffineY().testBit(0) ? 3 : 2);
                break;
            default:
                bArr2 = String.valueOf(com_google_android_gms_internal_zzdus);
                StringBuilder stringBuilder = new StringBuilder(15 + String.valueOf(bArr2).length());
                stringBuilder.append("invalid format:");
                stringBuilder.append(bArr2);
                throw new GeneralSecurityException(stringBuilder.toString());
        }
        zzduo com_google_android_gms_internal_zzduo = new zzduo(bArr3, zzdvd.m5913a(str, zzdua.m5902a(bArr3, generateSecret), bArr4, bArr2, a));
        bArr4 = null;
        bArr = this.f14392f.mo1864a(com_google_android_gms_internal_zzduo.f7317b == null ? null : com_google_android_gms_internal_zzduo.f7317b.m5915a()).mo1861a(bArr, f14387a);
        if (com_google_android_gms_internal_zzduo.f7316a != null) {
            bArr4 = com_google_android_gms_internal_zzduo.f7316a.m5915a();
        }
        return ByteBuffer.allocate(bArr4.length + bArr.length).put(bArr4).put(bArr).array();
    }
}
