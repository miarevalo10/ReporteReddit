package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzcx {
    private static Cipher f7192b;
    private static final Object f7193c = new Object();
    private static final Object f7194d = new Object();
    private final SecureRandom f7195a = null;

    public static String m5822a(byte[] bArr, byte[] bArr2) throws zzcy {
        if (bArr.length != 16) {
            throw new zzcy();
        }
        try {
            byte[] iv;
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (f7193c) {
                m5823a().init(1, secretKeySpec, null);
                bArr2 = m5823a().doFinal(bArr2);
                iv = m5823a().getIV();
            }
            int length = bArr2.length + iv.length;
            ByteBuffer allocate = ByteBuffer.allocate(length);
            allocate.put(iv).put(bArr2);
            allocate.flip();
            bArr = new byte[length];
            allocate.get(bArr);
            return zzbu.m5579a(bArr, false);
        } catch (Throwable e) {
            throw new zzcy(e);
        } catch (Throwable e2) {
            throw new zzcy(e2);
        } catch (Throwable e22) {
            throw new zzcy(e22);
        } catch (Throwable e222) {
            throw new zzcy(e222);
        } catch (Throwable e2222) {
            throw new zzcy(e2222);
        }
    }

    private static Cipher m5823a() throws NoSuchAlgorithmException, NoSuchPaddingException {
        Cipher cipher;
        synchronized (f7194d) {
            if (f7192b == null) {
                f7192b = Cipher.getInstance("AES/CBC/PKCS5Padding");
            }
            cipher = f7192b;
        }
        return cipher;
    }

    public static byte[] m5824a(String str) throws zzcy {
        int i = 0;
        try {
            byte[] a = zzbu.m5580a(str, false);
            if (a.length != 32) {
                throw new zzcy();
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(a, 4, 16).get(bArr);
            while (i < 16) {
                bArr[i] = (byte) (bArr[i] ^ 68);
                i++;
            }
            return bArr;
        } catch (Throwable e) {
            throw new zzcy(e);
        }
    }

    public static byte[] m5825a(byte[] bArr, String str) throws zzcy {
        if (bArr.length != 16) {
            throw new zzcy();
        }
        try {
            byte[] a = zzbu.m5580a(str, false);
            if (a.length <= 16) {
                throw new zzcy();
            }
            ByteBuffer allocate = ByteBuffer.allocate(a.length);
            allocate.put(a);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            a = new byte[(a.length - 16)];
            allocate.get(bArr2);
            allocate.get(a);
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (f7193c) {
                m5823a().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                a = m5823a().doFinal(a);
            }
            return a;
        } catch (Throwable e) {
            throw new zzcy(e);
        } catch (Throwable e2) {
            throw new zzcy(e2);
        } catch (Throwable e22) {
            throw new zzcy(e22);
        } catch (Throwable e222) {
            throw new zzcy(e222);
        } catch (Throwable e2222) {
            throw new zzcy(e2222);
        } catch (Throwable e22222) {
            throw new zzcy(e22222);
        } catch (Throwable e222222) {
            throw new zzcy(e222222);
        }
    }
}
