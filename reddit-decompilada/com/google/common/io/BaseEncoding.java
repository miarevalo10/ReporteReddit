package com.google.common.io;

import com.google.android.gms.ads.AdRequest;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;

public abstract class BaseEncoding {
    private static final BaseEncoding f8513a = new Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", Character.valueOf('='));
    private static final BaseEncoding f8514b = new Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", Character.valueOf('='));
    private static final BaseEncoding f8515c = new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", Character.valueOf('='));
    private static final BaseEncoding f8516d = new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", Character.valueOf('='));
    private static final BaseEncoding f8517e = new Base16Encoding("base16()", "0123456789ABCDEF");

    private static final class Alphabet {
        final char[] f8505a;
        final int f8506b;
        final int f8507c;
        final int f8508d;
        final int f8509e;
        final byte[] f8510f;
        private final String f8511g;
        private final boolean[] f8512h;

        Alphabet(String str, char[] cArr) {
            StringBuilder stringBuilder;
            this.f8511g = (String) Preconditions.m6908a((Object) str);
            this.f8505a = (char[]) Preconditions.m6908a((Object) cArr);
            try {
                this.f8507c = IntMath.m7280a(cArr.length, RoundingMode.UNNECESSARY);
                str = Math.min(8, Integer.lowestOneBit(this.f8507c));
                try {
                    this.f8508d = 8 / str;
                    this.f8509e = this.f8507c / str;
                    int i = 0;
                    this.f8506b = cArr.length - 1;
                    byte[] bArr = new byte[128];
                    Arrays.fill(bArr, (byte) -1);
                    for (int i2 = 0; i2 < cArr.length; i2++) {
                        char c = cArr[i2];
                        Preconditions.m6915a(c < '', "Non-ASCII character: %s", c);
                        Preconditions.m6915a(bArr[c] == (byte) -1, "Duplicate character: %s", c);
                        bArr[c] = (byte) i2;
                    }
                    this.f8510f = bArr;
                    str = new boolean[this.f8508d];
                    while (i < this.f8509e) {
                        str[IntMath.m7279a(i * 8, this.f8507c, RoundingMode.CEILING)] = 1;
                        i++;
                    }
                    this.f8512h = str;
                } catch (String str2) {
                    stringBuilder = new StringBuilder("Illegal alphabet ");
                    stringBuilder.append(new String(cArr));
                    throw new IllegalArgumentException(stringBuilder.toString(), str2);
                }
            } catch (String str22) {
                stringBuilder = new StringBuilder("Illegal alphabet length ");
                stringBuilder.append(cArr.length);
                throw new IllegalArgumentException(stringBuilder.toString(), str22);
            }
        }

        public final String toString() {
            return this.f8511g;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Alphabet)) {
                return null;
            }
            return Arrays.equals(this.f8505a, ((Alphabet) obj).f8505a);
        }

        public final int hashCode() {
            return Arrays.hashCode(this.f8505a);
        }
    }

    public static final class DecodingException extends IOException {
    }

    static class StandardBaseEncoding extends BaseEncoding {
        final Alphabet f14941b;
        final Character f14942c;

        StandardBaseEncoding(String str, String str2, Character ch) {
            this(new Alphabet(str, str2.toCharArray()), ch);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        StandardBaseEncoding(com.google.common.io.BaseEncoding.Alphabet r5, java.lang.Character r6) {
            /*
            r4 = this;
            r4.<init>();
            r0 = com.google.common.base.Preconditions.m6908a(r5);
            r0 = (com.google.common.io.BaseEncoding.Alphabet) r0;
            r4.f14941b = r0;
            r0 = 0;
            r1 = 1;
            if (r6 == 0) goto L_0x0024;
        L_0x000f:
            r2 = r6.charValue();
            r3 = r5.f8510f;
            r3 = r3.length;
            if (r2 >= r3) goto L_0x0021;
        L_0x0018:
            r5 = r5.f8510f;
            r5 = r5[r2];
            r2 = -1;
            if (r5 == r2) goto L_0x0021;
        L_0x001f:
            r5 = r1;
            goto L_0x0022;
        L_0x0021:
            r5 = r0;
        L_0x0022:
            if (r5 != 0) goto L_0x0025;
        L_0x0024:
            r0 = r1;
        L_0x0025:
            r5 = "Padding character %s was already in alphabet";
            com.google.common.base.Preconditions.m6917a(r0, r5, r6);
            r4.f14942c = r6;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.BaseEncoding.StandardBaseEncoding.<init>(com.google.common.io.BaseEncoding$Alphabet, java.lang.Character):void");
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("BaseEncoding.");
            stringBuilder.append(this.f14941b.toString());
            if (8 % this.f14941b.f8507c != 0) {
                if (this.f14942c == null) {
                    stringBuilder.append(".omitPadding()");
                } else {
                    stringBuilder.append(".withPadChar('");
                    stringBuilder.append(this.f14942c);
                    stringBuilder.append("')");
                }
            }
            return stringBuilder.toString();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof StandardBaseEncoding)) {
                return false;
            }
            StandardBaseEncoding standardBaseEncoding = (StandardBaseEncoding) obj;
            if (!this.f14941b.equals(standardBaseEncoding.f14941b) || Objects.m14557a(this.f14942c, standardBaseEncoding.f14942c) == null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f14941b.hashCode() ^ Objects.m14556a(this.f14942c);
        }
    }

    static final class Base16Encoding extends StandardBaseEncoding {
        final char[] f18479a;

        Base16Encoding(String str, String str2) {
            this(new Alphabet(str, str2.toCharArray()));
        }

        private Base16Encoding(Alphabet alphabet) {
            super(alphabet, null);
            this.f18479a = new char[AdRequest.MAX_CONTENT_URL_LENGTH];
            int i = 0;
            Preconditions.m6913a(alphabet.f8505a.length == 16);
            while (i < 256) {
                this.f18479a[i] = alphabet.f8505a[i >>> 4];
                this.f18479a[i | 256] = alphabet.f8505a[i & 15];
                i++;
            }
        }
    }

    static final class Base64Encoding extends StandardBaseEncoding {
        Base64Encoding(String str, String str2, Character ch) {
            this(new Alphabet(str, str2.toCharArray()), ch);
        }

        private Base64Encoding(Alphabet alphabet, Character ch) {
            super(alphabet, ch);
            Preconditions.m6913a(alphabet.f8505a.length == 64 ? true : null);
        }
    }

    BaseEncoding() {
    }
}
