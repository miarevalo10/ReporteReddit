package net.hockeyapp.android.utils;

import com.facebook.stetho.dumpapp.Framer;

public class Base64 {

    static abstract class Coder {
        public byte[] f26600a;
        public int f26601b;

        Coder() {
        }
    }

    static class Encoder extends Coder {
        private static final byte[] f33172j = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, Framer.EXIT_FRAME_PREFIX, (byte) 121, (byte) 122, (byte) 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
        private static final byte[] f33173k = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, Framer.EXIT_FRAME_PREFIX, (byte) 121, (byte) 122, (byte) 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, Framer.STDIN_FRAME_PREFIX, Framer.STDIN_REQUEST_FRAME_PREFIX};
        final byte[] f33174c;
        int f33175d;
        int f33176e;
        public final boolean f33177f;
        public final boolean f33178g;
        public final boolean f33179h;
        final byte[] f33180i;

        public Encoder() {
            this.a = null;
            this.f33177f = true;
            this.f33178g = false;
            this.f33179h = false;
            this.f33180i = f33172j;
            this.f33174c = new byte[2];
            this.f33175d = 0;
            this.f33176e = this.f33178g ? 19 : -1;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean m33748a(byte[] r19, int r20) {
            /*
            r18 = this;
            r0 = r18;
            r2 = r0.f33180i;
            r3 = r0.a;
            r4 = r0.f33176e;
            r5 = 0;
            r6 = r20 + 0;
            r7 = r0.f33175d;
            r8 = -1;
            r9 = 2;
            r10 = 1;
            switch(r7) {
                case 0: goto L_0x004a;
                case 1: goto L_0x0030;
                case 2: goto L_0x0014;
                default: goto L_0x0013;
            };
        L_0x0013:
            goto L_0x004a;
        L_0x0014:
            if (r6 <= 0) goto L_0x004a;
        L_0x0016:
            r7 = r0.f33174c;
            r7 = r7[r5];
            r7 = r7 & 255;
            r7 = r7 << 16;
            r11 = r0.f33174c;
            r11 = r11[r10];
            r11 = r11 & 255;
            r11 = r11 << 8;
            r7 = r7 | r11;
            r11 = r19[r5];
            r11 = r11 & 255;
            r7 = r7 | r11;
            r0.f33175d = r5;
            r11 = r10;
            goto L_0x004c;
        L_0x0030:
            if (r9 > r6) goto L_0x004a;
        L_0x0032:
            r7 = r0.f33174c;
            r7 = r7[r5];
            r7 = r7 & 255;
            r7 = r7 << 16;
            r11 = r19[r5];
            r11 = r11 & 255;
            r11 = r11 << 8;
            r7 = r7 | r11;
            r11 = r19[r10];
            r11 = r11 & 255;
            r7 = r7 | r11;
            r0.f33175d = r5;
            r11 = r9;
            goto L_0x004c;
        L_0x004a:
            r11 = r5;
            r7 = r8;
        L_0x004c:
            r13 = 4;
            r14 = 13;
            r15 = 10;
            if (r7 == r8) goto L_0x0088;
        L_0x0053:
            r8 = r7 >> 18;
            r8 = r8 & 63;
            r8 = r2[r8];
            r3[r5] = r8;
            r8 = r7 >> 12;
            r8 = r8 & 63;
            r8 = r2[r8];
            r3[r10] = r8;
            r8 = r7 >> 6;
            r8 = r8 & 63;
            r8 = r2[r8];
            r3[r9] = r8;
            r7 = r7 & 63;
            r7 = r2[r7];
            r8 = 3;
            r3[r8] = r7;
            r4 = r4 + -1;
            if (r4 != 0) goto L_0x0086;
        L_0x0076:
            r4 = r0.f33179h;
            if (r4 == 0) goto L_0x007e;
        L_0x007a:
            r4 = 5;
            r3[r13] = r14;
            goto L_0x007f;
        L_0x007e:
            r4 = r13;
        L_0x007f:
            r7 = r4 + 1;
            r3[r4] = r15;
            r4 = 19;
            goto L_0x0089;
        L_0x0086:
            r7 = r13;
            goto L_0x0089;
        L_0x0088:
            r7 = r5;
        L_0x0089:
            r8 = r11 + 3;
            if (r8 > r6) goto L_0x00e2;
        L_0x008d:
            r12 = r19[r11];
            r12 = r12 & 255;
            r12 = r12 << 16;
            r16 = r11 + 1;
            r9 = r19[r16];
            r9 = r9 & 255;
            r9 = r9 << 8;
            r9 = r9 | r12;
            r11 = r11 + 2;
            r11 = r19[r11];
            r11 = r11 & 255;
            r9 = r9 | r11;
            r11 = r9 >> 18;
            r11 = r11 & 63;
            r11 = r2[r11];
            r3[r7] = r11;
            r11 = r7 + 1;
            r12 = r9 >> 12;
            r12 = r12 & 63;
            r12 = r2[r12];
            r3[r11] = r12;
            r11 = r7 + 2;
            r12 = r9 >> 6;
            r12 = r12 & 63;
            r12 = r2[r12];
            r3[r11] = r12;
            r11 = r7 + 3;
            r9 = r9 & 63;
            r9 = r2[r9];
            r3[r11] = r9;
            r7 = r7 + 4;
            r4 = r4 + -1;
            if (r4 != 0) goto L_0x00df;
        L_0x00cd:
            r4 = r0.f33179h;
            if (r4 == 0) goto L_0x00d6;
        L_0x00d1:
            r4 = r7 + 1;
            r3[r7] = r14;
            goto L_0x00d7;
        L_0x00d6:
            r4 = r7;
        L_0x00d7:
            r7 = r4 + 1;
            r3[r4] = r15;
            r11 = r8;
            r4 = 19;
            goto L_0x00e0;
        L_0x00df:
            r11 = r8;
        L_0x00e0:
            r9 = 2;
            goto L_0x0089;
        L_0x00e2:
            r8 = r0.f33175d;
            r8 = r11 - r8;
            r9 = r6 + -1;
            if (r8 != r9) goto L_0x0136;
        L_0x00ea:
            r8 = r0.f33175d;
            if (r8 <= 0) goto L_0x00f4;
        L_0x00ee:
            r1 = r0.f33174c;
            r1 = r1[r5];
            r5 = r10;
            goto L_0x00f9;
        L_0x00f4:
            r8 = r11 + 1;
            r1 = r19[r11];
            r11 = r8;
        L_0x00f9:
            r1 = r1 & 255;
            r1 = r1 << r13;
            r8 = r0.f33175d;
            r8 = r8 - r5;
            r0.f33175d = r8;
            r5 = r7 + 1;
            r8 = r1 >> 6;
            r8 = r8 & 63;
            r8 = r2[r8];
            r3[r7] = r8;
            r7 = r5 + 1;
            r1 = r1 & 63;
            r1 = r2[r1];
            r3[r5] = r1;
            r1 = r0.f33177f;
            if (r1 == 0) goto L_0x0121;
        L_0x0117:
            r1 = r7 + 1;
            r2 = 61;
            r3[r7] = r2;
            r7 = r1 + 1;
            r3[r1] = r2;
        L_0x0121:
            r1 = r0.f33178g;
            if (r1 == 0) goto L_0x01c1;
        L_0x0125:
            r1 = r0.f33179h;
            if (r1 == 0) goto L_0x012e;
        L_0x0129:
            r1 = r7 + 1;
            r3[r7] = r14;
            goto L_0x012f;
        L_0x012e:
            r1 = r7;
        L_0x012f:
            r2 = r1 + 1;
            r3[r1] = r15;
        L_0x0133:
            r7 = r2;
            goto L_0x01c1;
        L_0x0136:
            r8 = r0.f33175d;
            r8 = r11 - r8;
            r9 = r6 + -2;
            if (r8 != r9) goto L_0x01a9;
        L_0x013e:
            r8 = r0.f33175d;
            if (r8 <= r10) goto L_0x0148;
        L_0x0142:
            r8 = r0.f33174c;
            r5 = r8[r5];
            r8 = r10;
            goto L_0x014f;
        L_0x0148:
            r8 = r11 + 1;
            r9 = r19[r11];
            r11 = r8;
            r8 = r5;
            r5 = r9;
        L_0x014f:
            r5 = r5 & 255;
            r5 = r5 << r15;
            r9 = r0.f33175d;
            if (r9 <= 0) goto L_0x015e;
        L_0x0156:
            r1 = r0.f33174c;
            r9 = r8 + 1;
            r1 = r1[r8];
            r8 = r9;
            goto L_0x0163;
        L_0x015e:
            r9 = r11 + 1;
            r1 = r19[r11];
            r11 = r9;
        L_0x0163:
            r1 = r1 & 255;
            r9 = 2;
            r1 = r1 << r9;
            r1 = r1 | r5;
            r5 = r0.f33175d;
            r5 = r5 - r8;
            r0.f33175d = r5;
            r5 = r7 + 1;
            r8 = r1 >> 12;
            r8 = r8 & 63;
            r8 = r2[r8];
            r3[r7] = r8;
            r7 = r5 + 1;
            r8 = r1 >> 6;
            r8 = r8 & 63;
            r8 = r2[r8];
            r3[r5] = r8;
            r5 = r7 + 1;
            r1 = r1 & 63;
            r1 = r2[r1];
            r3[r7] = r1;
            r1 = r0.f33177f;
            if (r1 == 0) goto L_0x0194;
        L_0x018d:
            r1 = r5 + 1;
            r2 = 61;
            r3[r5] = r2;
            goto L_0x0195;
        L_0x0194:
            r1 = r5;
        L_0x0195:
            r2 = r0.f33178g;
            if (r2 == 0) goto L_0x01a7;
        L_0x0199:
            r2 = r0.f33179h;
            if (r2 == 0) goto L_0x01a2;
        L_0x019d:
            r2 = r1 + 1;
            r3[r1] = r14;
            r1 = r2;
        L_0x01a2:
            r2 = r1 + 1;
            r3[r1] = r15;
            goto L_0x0133;
        L_0x01a7:
            r7 = r1;
            goto L_0x01c1;
        L_0x01a9:
            r1 = r0.f33178g;
            if (r1 == 0) goto L_0x01c1;
        L_0x01ad:
            if (r7 <= 0) goto L_0x01c1;
        L_0x01af:
            r1 = 19;
            if (r4 == r1) goto L_0x01c1;
        L_0x01b3:
            r1 = r0.f33179h;
            if (r1 == 0) goto L_0x01bc;
        L_0x01b7:
            r1 = r7 + 1;
            r3[r7] = r14;
            goto L_0x01bd;
        L_0x01bc:
            r1 = r7;
        L_0x01bd:
            r7 = r1 + 1;
            r3[r1] = r15;
        L_0x01c1:
            r1 = r0.f33175d;
            if (r1 == 0) goto L_0x01cc;
        L_0x01c5:
            r1 = "BASE64";
            r2 = "Error during encoding";
            net.hockeyapp.android.utils.HockeyLog.m28208b(r1, r2);
        L_0x01cc:
            if (r11 == r6) goto L_0x01d5;
        L_0x01ce:
            r1 = "BASE64";
            r2 = "Error during encoding";
            net.hockeyapp.android.utils.HockeyLog.m28208b(r1, r2);
        L_0x01d5:
            r0.b = r7;
            r0.f33176e = r4;
            return r10;
            */
            throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.utils.Base64.Encoder.a(byte[], int):boolean");
        }
    }

    public static String m28201a(byte[] bArr) {
        try {
            int length = bArr.length;
            Encoder encoder = new Encoder();
            int i = (length / 3) * 4;
            if (!encoder.f33177f) {
                switch (length % 3) {
                    case 0:
                        break;
                    case 1:
                        i += 2;
                        break;
                    case 2:
                        i += 3;
                        break;
                    default:
                        break;
                }
            } else if (length % 3 > 0) {
                i += 4;
            }
            if (encoder.f33178g && length > 0) {
                int i2 = 1;
                int i3 = ((length - 1) / 57) + 1;
                if (encoder.f33179h) {
                    i2 = 2;
                }
                i += i3 * i2;
            }
            encoder.a = new byte[i];
            encoder.m33748a(bArr, length);
            if (encoder.b == i) {
                return new String(encoder.a, "US-ASCII");
            }
            throw new AssertionError();
        } catch (byte[] bArr2) {
            throw new AssertionError(bArr2);
        }
    }
}
