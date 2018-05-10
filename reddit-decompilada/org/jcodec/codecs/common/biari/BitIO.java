package org.jcodec.codecs.common.biari;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BitIO {

    public interface InputBits {
        int getBit() throws IOException;
    }

    public interface OutputBits {
        void flush() throws IOException;

        void putBit(int i) throws IOException;
    }

    public static class StreamInputBits implements InputBits {
        private int bit = 8;
        private int cur;
        private InputStream in;

        public StreamInputBits(InputStream inputStream) {
            this.in = inputStream;
        }

        public int getBit() throws IOException {
            if (this.bit > 7) {
                this.cur = this.in.read();
                if (this.cur == -1) {
                    return -1;
                }
                this.bit = 0;
            }
            int i = this.cur;
            int i2 = this.bit;
            this.bit = i2 + 1;
            return (i >> (7 - i2)) & 1;
        }
    }

    public static class StreamOutputBits implements OutputBits {
        private int bit;
        private int cur;
        private OutputStream out;

        public StreamOutputBits(OutputStream outputStream) {
            this.out = outputStream;
        }

        public void putBit(int i) throws IOException {
            if (this.bit > 7) {
                this.out.write(this.cur);
                this.cur = 0;
                this.bit = 0;
            }
            int i2 = this.cur;
            i &= 1;
            int i3 = this.bit;
            this.bit = i3 + 1;
            this.cur = (i << (7 - i3)) | i2;
        }

        public void flush() throws IOException {
            if (this.bit > 0) {
                this.out.write(this.cur);
            }
        }
    }

    public static InputBits inputFromStream(InputStream inputStream) {
        return new StreamInputBits(inputStream);
    }

    public static OutputBits outputFromStream(OutputStream outputStream) {
        return new StreamOutputBits(outputStream);
    }

    public static InputBits inputFromArray(byte[] bArr) {
        return new StreamInputBits(new ByteArrayInputStream(bArr));
    }

    public static OutputBits outputFromArray(final byte[] bArr) {
        return new StreamOutputBits(new OutputStream() {
            int f26783a;

            public final void write(int i) throws IOException {
                if (this.f26783a >= bArr.length) {
                    throw new IOException("Buffer is full");
                }
                byte[] bArr = bArr;
                int i2 = this.f26783a;
                this.f26783a = i2 + 1;
                bArr[i2] = (byte) i;
            }
        });
    }

    public static byte[] compressBits(int[] r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r5.length;
        r0 = r0 >> 3;
        r0 = r0 + 1;
        r0 = new byte[r0];
        r1 = outputFromArray(r0);
        r2 = r5.length;	 Catch:{ IOException -> 0x0017 }
        r3 = 0;	 Catch:{ IOException -> 0x0017 }
    L_0x000d:
        if (r3 >= r2) goto L_0x0017;	 Catch:{ IOException -> 0x0017 }
    L_0x000f:
        r4 = r5[r3];	 Catch:{ IOException -> 0x0017 }
        r1.putBit(r4);	 Catch:{ IOException -> 0x0017 }
        r3 = r3 + 1;
        goto L_0x000d;
    L_0x0017:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.common.biari.BitIO.compressBits(int[]):byte[]");
    }

    public static int[] decompressBits(byte[] r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r4.length;
        r0 = r0 << 3;
        r0 = new int[r0];
        r4 = inputFromArray(r4);
        r1 = 0;
    L_0x000a:
        r2 = r4.getBit();	 Catch:{ IOException -> 0x0016 }
        r3 = -1;	 Catch:{ IOException -> 0x0016 }
        if (r2 == r3) goto L_0x0016;	 Catch:{ IOException -> 0x0016 }
    L_0x0011:
        r0[r1] = r2;	 Catch:{ IOException -> 0x0016 }
        r1 = r1 + 1;
        goto L_0x000a;
    L_0x0016:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.common.biari.BitIO.decompressBits(byte[]):int[]");
    }
}
