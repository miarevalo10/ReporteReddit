package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Calendar;
import java.util.Date;

public abstract class MXFMetadata {
    protected UL uid;
    protected UL ul;

    public abstract void read(ByteBuffer byteBuffer);

    public MXFMetadata(UL ul) {
        this.ul = ul;
    }

    protected static UL[] readULBatch(ByteBuffer byteBuffer) {
        int i = byteBuffer.getInt();
        byteBuffer.getInt();
        UL[] ulArr = new UL[i];
        for (int i2 = 0; i2 < i; i2++) {
            ulArr[i2] = UL.read(byteBuffer);
        }
        return ulArr;
    }

    protected static int[] readInt32Batch(ByteBuffer byteBuffer) {
        int i = byteBuffer.getInt();
        byteBuffer.getInt();
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = byteBuffer.getInt();
        }
        return iArr;
    }

    protected static Date readDate(ByteBuffer byteBuffer) {
        Calendar instance = Calendar.getInstance();
        instance.set(1, byteBuffer.getShort());
        instance.set(2, byteBuffer.get());
        instance.set(5, byteBuffer.get());
        instance.set(10, byteBuffer.get());
        instance.set(12, byteBuffer.get());
        instance.set(13, byteBuffer.get());
        instance.set(14, (byteBuffer.get() & 255) << 2);
        return instance.getTime();
    }

    protected java.lang.String readUtf16String(java.nio.ByteBuffer r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x000d }
        r3 = org.jcodec.common.NIOUtils.toArray(r3);	 Catch:{ UnsupportedEncodingException -> 0x000d }
        r1 = "utf-16";	 Catch:{ UnsupportedEncodingException -> 0x000d }
        r0.<init>(r3, r1);	 Catch:{ UnsupportedEncodingException -> 0x000d }
        return r0;
    L_0x000d:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.containers.mxf.model.MXFMetadata.readUtf16String(java.nio.ByteBuffer):java.lang.String");
    }

    public UL getUl() {
        return this.ul;
    }

    public UL getUid() {
        return this.uid;
    }
}
