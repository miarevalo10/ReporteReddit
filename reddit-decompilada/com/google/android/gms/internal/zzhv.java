package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

@zzzv
public final class zzhv extends zzhq {
    private MessageDigest f14506b;

    public final byte[] mo1953a(String str) {
        byte[] array;
        String[] split = str.split(" ");
        int i = 4;
        if (split.length == 1) {
            int a = zzhu.m6301a(split[0]);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(a);
            array = allocate.array();
        } else if (split.length < 5) {
            byte[] bArr = new byte[(split.length << 1)];
            for (r4 = 0; r4 < split.length; r4++) {
                int a2 = zzhu.m6301a(split[r4]);
                a2 = (a2 >> 16) ^ (65535 & a2);
                byte[] bArr2 = new byte[]{(byte) a2, (byte) (a2 >> 8)};
                a2 = r4 << 1;
                bArr[a2] = bArr2[0];
                bArr[a2 + 1] = bArr2[1];
            }
            array = bArr;
        } else {
            byte[] bArr3 = new byte[split.length];
            for (int i2 = 0; i2 < split.length; i2++) {
                r4 = zzhu.m6301a(split[i2]);
                bArr3[i2] = (byte) ((r4 >> 24) ^ (((r4 & 255) ^ ((r4 >> 8) & 255)) ^ ((r4 >> 16) & 255)));
            }
            array = bArr3;
        }
        this.f14506b = m6296a();
        synchronized (this.a) {
            if (this.f14506b == null) {
                array = new byte[0];
                return array;
            }
            this.f14506b.reset();
            this.f14506b.update(array);
            Object digest = this.f14506b.digest();
            if (digest.length <= 4) {
                i = digest.length;
            }
            Object obj = new byte[i];
            System.arraycopy(digest, 0, obj, 0, obj.length);
            return obj;
        }
    }
}
