package io.branch.referral;

import com.facebook.stetho.dumpapp.Framer;

class Base64 {

    static abstract class Coder {
        public byte[] f24477a;
        public int f24478b;

        Coder() {
        }
    }

    static class Decoder extends Coder {
        private static final int[] f30893f = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] f30894g = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        int f30895c = 0;
        int f30896d = 0;
        final int[] f30897e = f30893f;

        public Decoder(byte[] bArr) {
            this.a = bArr;
        }
    }

    static class Encoder extends Coder {
        private static final byte[] f30898j = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, Framer.EXIT_FRAME_PREFIX, (byte) 121, (byte) 122, (byte) 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
        private static final byte[] f30899k = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, Framer.EXIT_FRAME_PREFIX, (byte) 121, (byte) 122, (byte) 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, Framer.STDIN_FRAME_PREFIX, Framer.STDIN_REQUEST_FRAME_PREFIX};
        final byte[] f30900c;
        int f30901d;
        int f30902e;
        public final boolean f30903f;
        public final boolean f30904g;
        public final boolean f30905h;
        final byte[] f30906i;

        public Encoder() {
            this.a = null;
            this.f30903f = true;
            this.f30904g = false;
            this.f30905h = false;
            this.f30906i = f30898j;
            this.f30900c = new byte[2];
            this.f30901d = 0;
            this.f30902e = this.f30904g ? 19 : -1;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean m31866a(byte[] r19, int r20) {
            /*
            r18 = this;
            r0 = r18;
            r2 = r0.f30906i;
            r3 = r0.a;
            r4 = r0.f30902e;
            r5 = 0;
            r6 = r20 + 0;
            r7 = r0.f30901d;
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
            r7 = r0.f30900c;
            r7 = r7[r5];
            r7 = r7 & 255;
            r7 = r7 << 16;
            r11 = r0.f30900c;
            r11 = r11[r10];
            r11 = r11 & 255;
            r11 = r11 << 8;
            r7 = r7 | r11;
            r11 = r19[r5];
            r11 = r11 & 255;
            r7 = r7 | r11;
            r0.f30901d = r5;
            r11 = r10;
            goto L_0x004c;
        L_0x0030:
            if (r9 > r6) goto L_0x004a;
        L_0x0032:
            r7 = r0.f30900c;
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
            r0.f30901d = r5;
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
            r4 = r0.f30905h;
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
            r10 = r19[r16];
            r10 = r10 & 255;
            r10 = r10 << 8;
            r10 = r10 | r12;
            r11 = r11 + 2;
            r11 = r19[r11];
            r11 = r11 & 255;
            r10 = r10 | r11;
            r11 = r10 >> 18;
            r11 = r11 & 63;
            r11 = r2[r11];
            r3[r7] = r11;
            r11 = r7 + 1;
            r12 = r10 >> 12;
            r12 = r12 & 63;
            r12 = r2[r12];
            r3[r11] = r12;
            r11 = r7 + 2;
            r12 = r10 >> 6;
            r12 = r12 & 63;
            r12 = r2[r12];
            r3[r11] = r12;
            r11 = r7 + 3;
            r10 = r10 & 63;
            r10 = r2[r10];
            r3[r11] = r10;
            r7 = r7 + 4;
            r4 = r4 + -1;
            if (r4 != 0) goto L_0x00df;
        L_0x00cd:
            r4 = r0.f30905h;
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
            r10 = 1;
            goto L_0x0089;
        L_0x00e2:
            r8 = r0.f30901d;
            r8 = r11 - r8;
            r10 = r6 + -1;
            if (r8 != r10) goto L_0x0136;
        L_0x00ea:
            r6 = r0.f30901d;
            if (r6 <= 0) goto L_0x00f4;
        L_0x00ee:
            r1 = r0.f30900c;
            r1 = r1[r5];
            r5 = 1;
            goto L_0x00f6;
        L_0x00f4:
            r1 = r19[r11];
        L_0x00f6:
            r1 = r1 & 255;
            r1 = r1 << r13;
            r6 = r0.f30901d;
            r6 = r6 - r5;
            r0.f30901d = r6;
            r5 = r7 + 1;
            r6 = r1 >> 6;
            r6 = r6 & 63;
            r6 = r2[r6];
            r3[r7] = r6;
            r6 = r5 + 1;
            r1 = r1 & 63;
            r1 = r2[r1];
            r3[r5] = r1;
            r1 = r0.f30903f;
            if (r1 == 0) goto L_0x011e;
        L_0x0114:
            r1 = r6 + 1;
            r2 = 61;
            r3[r6] = r2;
            r6 = r1 + 1;
            r3[r1] = r2;
        L_0x011e:
            r1 = r0.f30904g;
            if (r1 == 0) goto L_0x0133;
        L_0x0122:
            r1 = r0.f30905h;
            if (r1 == 0) goto L_0x012b;
        L_0x0126:
            r1 = r6 + 1;
            r3[r6] = r14;
            goto L_0x012c;
        L_0x012b:
            r1 = r6;
        L_0x012c:
            r2 = r1 + 1;
            r3[r1] = r15;
        L_0x0130:
            r7 = r2;
            goto L_0x01bd;
        L_0x0133:
            r7 = r6;
            goto L_0x01bd;
        L_0x0136:
            r8 = r0.f30901d;
            r8 = r11 - r8;
            r6 = r6 - r9;
            if (r8 != r6) goto L_0x01a5;
        L_0x013d:
            r6 = r0.f30901d;
            r8 = 1;
            if (r6 <= r8) goto L_0x0148;
        L_0x0142:
            r6 = r0.f30900c;
            r5 = r6[r5];
            r6 = 1;
            goto L_0x014f;
        L_0x0148:
            r6 = r11 + 1;
            r8 = r19[r11];
            r11 = r6;
            r6 = r5;
            r5 = r8;
        L_0x014f:
            r5 = r5 & 255;
            r5 = r5 << r15;
            r8 = r0.f30901d;
            if (r8 <= 0) goto L_0x015e;
        L_0x0156:
            r1 = r0.f30900c;
            r8 = r6 + 1;
            r1 = r1[r6];
            r6 = r8;
            goto L_0x0160;
        L_0x015e:
            r1 = r19[r11];
        L_0x0160:
            r1 = r1 & 255;
            r1 = r1 << r9;
            r1 = r1 | r5;
            r5 = r0.f30901d;
            r5 = r5 - r6;
            r0.f30901d = r5;
            r5 = r7 + 1;
            r6 = r1 >> 12;
            r6 = r6 & 63;
            r6 = r2[r6];
            r3[r7] = r6;
            r6 = r5 + 1;
            r7 = r1 >> 6;
            r7 = r7 & 63;
            r7 = r2[r7];
            r3[r5] = r7;
            r5 = r6 + 1;
            r1 = r1 & 63;
            r1 = r2[r1];
            r3[r6] = r1;
            r1 = r0.f30903f;
            if (r1 == 0) goto L_0x0190;
        L_0x0189:
            r1 = r5 + 1;
            r2 = 61;
            r3[r5] = r2;
            goto L_0x0191;
        L_0x0190:
            r1 = r5;
        L_0x0191:
            r2 = r0.f30904g;
            if (r2 == 0) goto L_0x01a3;
        L_0x0195:
            r2 = r0.f30905h;
            if (r2 == 0) goto L_0x019e;
        L_0x0199:
            r2 = r1 + 1;
            r3[r1] = r14;
            r1 = r2;
        L_0x019e:
            r2 = r1 + 1;
            r3[r1] = r15;
            goto L_0x0130;
        L_0x01a3:
            r7 = r1;
            goto L_0x01bd;
        L_0x01a5:
            r1 = r0.f30904g;
            if (r1 == 0) goto L_0x01bd;
        L_0x01a9:
            if (r7 <= 0) goto L_0x01bd;
        L_0x01ab:
            r1 = 19;
            if (r4 == r1) goto L_0x01bd;
        L_0x01af:
            r1 = r0.f30905h;
            if (r1 == 0) goto L_0x01b8;
        L_0x01b3:
            r1 = r7 + 1;
            r3[r7] = r14;
            goto L_0x01b9;
        L_0x01b8:
            r1 = r7;
        L_0x01b9:
            r7 = r1 + 1;
            r3[r1] = r15;
        L_0x01bd:
            r0.b = r7;
            r0.f30902e = r4;
            r1 = 1;
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.Base64.Encoder.a(byte[], int):boolean");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] m26095a(byte[] r14) {
        /*
        r0 = 4;
        r1 = 6;
        r2 = 0;
        r3 = r14.length;
        r4 = new io.branch.referral.Base64$Decoder;
        r5 = r3 * 3;
        r5 = r5 / r0;
        r5 = new byte[r5];
        r4.<init>(r5);
        r5 = r4.f30895c;
        if (r5 != r1) goto L_0x0015;
    L_0x0012:
        r14 = r2;
        goto L_0x011b;
    L_0x0015:
        r3 = r3 + r2;
        r5 = r4.f30895c;
        r6 = r4.f30896d;
        r7 = r4.a;
        r8 = r4.f30897e;
        r10 = r2;
        r9 = r6;
        r6 = r5;
        r5 = r10;
    L_0x0022:
        if (r5 >= r3) goto L_0x00f2;
    L_0x0024:
        if (r6 != 0) goto L_0x0069;
    L_0x0026:
        r11 = r5 + 4;
        if (r11 > r3) goto L_0x0067;
    L_0x002a:
        r9 = r14[r5];
        r9 = r9 & 255;
        r9 = r8[r9];
        r9 = r9 << 18;
        r12 = r5 + 1;
        r12 = r14[r12];
        r12 = r12 & 255;
        r12 = r8[r12];
        r12 = r12 << 12;
        r9 = r9 | r12;
        r12 = r5 + 2;
        r12 = r14[r12];
        r12 = r12 & 255;
        r12 = r8[r12];
        r12 = r12 << r1;
        r9 = r9 | r12;
        r12 = r5 + 3;
        r12 = r14[r12];
        r12 = r12 & 255;
        r12 = r8[r12];
        r9 = r9 | r12;
        if (r9 < 0) goto L_0x0067;
    L_0x0052:
        r5 = r10 + 2;
        r12 = (byte) r9;
        r7[r5] = r12;
        r5 = r10 + 1;
        r12 = r9 >> 8;
        r12 = (byte) r12;
        r7[r5] = r12;
        r5 = r9 >> 16;
        r5 = (byte) r5;
        r7[r10] = r5;
        r10 = r10 + 3;
        r5 = r11;
        goto L_0x0026;
    L_0x0067:
        if (r5 >= r3) goto L_0x00f2;
    L_0x0069:
        r11 = r5 + 1;
        r5 = r14[r5];
        r5 = r5 & 255;
        r5 = r8[r5];
        r12 = -2;
        r13 = -1;
        switch(r6) {
            case 0: goto L_0x00e3;
            case 1: goto L_0x00d5;
            case 2: goto L_0x00bb;
            case 3: goto L_0x0088;
            case 4: goto L_0x007d;
            case 5: goto L_0x0078;
            default: goto L_0x0076;
        };
    L_0x0076:
        goto L_0x00ef;
    L_0x0078:
        if (r5 == r13) goto L_0x00ef;
    L_0x007a:
        r4.f30895c = r1;
        goto L_0x0012;
    L_0x007d:
        if (r5 != r12) goto L_0x0083;
    L_0x007f:
        r6 = r6 + 1;
        goto L_0x00ef;
    L_0x0083:
        if (r5 == r13) goto L_0x00ef;
    L_0x0085:
        r4.f30895c = r1;
        goto L_0x0012;
    L_0x0088:
        if (r5 < 0) goto L_0x00a3;
    L_0x008a:
        r6 = r9 << 6;
        r9 = r6 | r5;
        r5 = r10 + 2;
        r6 = (byte) r9;
        r7[r5] = r6;
        r5 = r10 + 1;
        r6 = r9 >> 8;
        r6 = (byte) r6;
        r7[r5] = r6;
        r5 = r9 >> 16;
        r5 = (byte) r5;
        r7[r10] = r5;
        r10 = r10 + 3;
        r6 = r2;
        goto L_0x00ef;
    L_0x00a3:
        if (r5 != r12) goto L_0x00b5;
    L_0x00a5:
        r5 = r10 + 1;
        r6 = r9 >> 2;
        r6 = (byte) r6;
        r7[r5] = r6;
        r5 = r9 >> 10;
        r5 = (byte) r5;
        r7[r10] = r5;
        r10 = r10 + 2;
        r6 = 5;
        goto L_0x00ef;
    L_0x00b5:
        if (r5 == r13) goto L_0x00ef;
    L_0x00b7:
        r4.f30895c = r1;
        goto L_0x0012;
    L_0x00bb:
        if (r5 < 0) goto L_0x00c3;
    L_0x00bd:
        r9 = r9 << 6;
        r9 = r9 | r5;
        r6 = r6 + 1;
        goto L_0x00ef;
    L_0x00c3:
        if (r5 != r12) goto L_0x00cf;
    L_0x00c5:
        r5 = r10 + 1;
        r6 = r9 >> 4;
        r6 = (byte) r6;
        r7[r10] = r6;
        r6 = r0;
        r10 = r5;
        goto L_0x00ef;
    L_0x00cf:
        if (r5 == r13) goto L_0x00ef;
    L_0x00d1:
        r4.f30895c = r1;
        goto L_0x0012;
    L_0x00d5:
        if (r5 < 0) goto L_0x00dd;
    L_0x00d7:
        r9 = r9 << 6;
        r9 = r9 | r5;
        r6 = r6 + 1;
        goto L_0x00ef;
    L_0x00dd:
        if (r5 == r13) goto L_0x00ef;
    L_0x00df:
        r4.f30895c = r1;
        goto L_0x0012;
    L_0x00e3:
        if (r5 < 0) goto L_0x00e9;
    L_0x00e5:
        r6 = r6 + 1;
        r9 = r5;
        goto L_0x00ef;
    L_0x00e9:
        if (r5 == r13) goto L_0x00ef;
    L_0x00eb:
        r4.f30895c = r1;
        goto L_0x0012;
    L_0x00ef:
        r5 = r11;
        goto L_0x0022;
    L_0x00f2:
        switch(r6) {
            case 0: goto L_0x0116;
            case 1: goto L_0x0112;
            case 2: goto L_0x0109;
            case 3: goto L_0x00fa;
            case 4: goto L_0x00f6;
            default: goto L_0x00f5;
        };
    L_0x00f5:
        goto L_0x0116;
    L_0x00f6:
        r4.f30895c = r1;
        goto L_0x0012;
    L_0x00fa:
        r14 = r10 + 1;
        r0 = r9 >> 10;
        r0 = (byte) r0;
        r7[r10] = r0;
        r10 = r14 + 1;
        r0 = r9 >> 2;
        r0 = (byte) r0;
        r7[r14] = r0;
        goto L_0x0116;
    L_0x0109:
        r14 = r10 + 1;
        r0 = r9 >> 4;
        r0 = (byte) r0;
        r7[r10] = r0;
        r10 = r14;
        goto L_0x0116;
    L_0x0112:
        r4.f30895c = r1;
        goto L_0x0012;
    L_0x0116:
        r4.f30895c = r6;
        r4.b = r10;
        r14 = 1;
    L_0x011b:
        if (r14 != 0) goto L_0x0125;
    L_0x011d:
        r14 = new java.lang.IllegalArgumentException;
        r0 = "bad base-64";
        r14.<init>(r0);
        throw r14;
    L_0x0125:
        r14 = r4.b;
        r0 = r4.a;
        r0 = r0.length;
        if (r14 != r0) goto L_0x012f;
    L_0x012c:
        r14 = r4.a;
        return r14;
    L_0x012f:
        r14 = r4.b;
        r14 = new byte[r14];
        r0 = r4.a;
        r1 = r4.b;
        java.lang.System.arraycopy(r0, r2, r14, r2, r1);
        return r14;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.Base64.a(byte[]):byte[]");
    }

    public static String m26096b(byte[] bArr) {
        try {
            int length = bArr.length;
            Encoder encoder = new Encoder();
            int i = (length / 3) * 4;
            if (!encoder.f30903f) {
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
            if (encoder.f30904g && length > 0) {
                int i2 = 1;
                int i3 = ((length - 1) / 57) + 1;
                if (encoder.f30905h) {
                    i2 = 2;
                }
                i += i3 * i2;
            }
            encoder.a = new byte[i];
            encoder.m31866a(bArr, length);
            return new String(encoder.a, "US-ASCII");
        } catch (byte[] bArr2) {
            throw new AssertionError(bArr2);
        }
    }
}
