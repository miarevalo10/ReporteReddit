package com.mp4parser.iso23001.part7;

import com.coremedia.iso.Hex;
import java.math.BigInteger;
import java.util.Arrays;

public class CencSampleAuxiliaryDataFormat {
    public byte[] f10095a = new byte[0];
    public Pair[] f10096b = null;

    public interface Pair {
        int mo3686a();

        long mo3687b();
    }

    private abstract class AbstractPair implements Pair {
        final /* synthetic */ CencSampleAuxiliaryDataFormat f15623a;

        private AbstractPair(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat) {
            this.f15623a = cencSampleAuxiliaryDataFormat;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    Pair pair = (Pair) obj;
                    return mo3686a() == pair.mo3686a() && mo3687b() == pair.mo3687b();
                }
            }
            return false;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("P(");
            stringBuilder.append(mo3686a());
            stringBuilder.append("|");
            stringBuilder.append(mo3687b());
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    private class ByteBytePair extends AbstractPair {
        final /* synthetic */ CencSampleAuxiliaryDataFormat f18597b;
        private byte f18598c;
        private byte f18599d;

        public ByteBytePair(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, int i, long j) {
            this.f18597b = cencSampleAuxiliaryDataFormat;
            super();
            this.f18598c = (byte) i;
            this.f18599d = (byte) ((int) j);
        }

        public final int mo3686a() {
            return this.f18598c;
        }

        public final long mo3687b() {
            return (long) this.f18599d;
        }
    }

    private class ByteIntPair extends AbstractPair {
        final /* synthetic */ CencSampleAuxiliaryDataFormat f18600b;
        private byte f18601c;
        private int f18602d;

        public ByteIntPair(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, int i, long j) {
            this.f18600b = cencSampleAuxiliaryDataFormat;
            super();
            this.f18601c = (byte) i;
            this.f18602d = (int) j;
        }

        public final int mo3686a() {
            return this.f18601c;
        }

        public final long mo3687b() {
            return (long) this.f18602d;
        }
    }

    private class ByteLongPair extends AbstractPair {
        final /* synthetic */ CencSampleAuxiliaryDataFormat f18603b;
        private byte f18604c;
        private long f18605d;

        public ByteLongPair(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, int i, long j) {
            this.f18603b = cencSampleAuxiliaryDataFormat;
            super();
            this.f18604c = (byte) i;
            this.f18605d = j;
        }

        public final int mo3686a() {
            return this.f18604c;
        }

        public final long mo3687b() {
            return this.f18605d;
        }
    }

    private class ByteShortPair extends AbstractPair {
        final /* synthetic */ CencSampleAuxiliaryDataFormat f18606b;
        private byte f18607c;
        private short f18608d;

        public ByteShortPair(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, int i, long j) {
            this.f18606b = cencSampleAuxiliaryDataFormat;
            super();
            this.f18607c = (byte) i;
            this.f18608d = (short) ((int) j);
        }

        public final int mo3686a() {
            return this.f18607c;
        }

        public final long mo3687b() {
            return (long) this.f18608d;
        }
    }

    private class IntBytePair extends AbstractPair {
        final /* synthetic */ CencSampleAuxiliaryDataFormat f18609b;
        private int f18610c;
        private byte f18611d;

        public IntBytePair(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, int i, long j) {
            this.f18609b = cencSampleAuxiliaryDataFormat;
            super();
            this.f18610c = i;
            this.f18611d = (byte) ((int) j);
        }

        public final int mo3686a() {
            return this.f18610c;
        }

        public final long mo3687b() {
            return (long) this.f18611d;
        }
    }

    private class IntIntPair extends AbstractPair {
        final /* synthetic */ CencSampleAuxiliaryDataFormat f18612b;
        private int f18613c;
        private int f18614d;

        public IntIntPair(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, int i, long j) {
            this.f18612b = cencSampleAuxiliaryDataFormat;
            super();
            this.f18613c = i;
            this.f18614d = (int) j;
        }

        public final int mo3686a() {
            return this.f18613c;
        }

        public final long mo3687b() {
            return (long) this.f18614d;
        }
    }

    private class IntLongPair extends AbstractPair {
        final /* synthetic */ CencSampleAuxiliaryDataFormat f18615b;
        private int f18616c;
        private long f18617d;

        public IntLongPair(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, int i, long j) {
            this.f18615b = cencSampleAuxiliaryDataFormat;
            super();
            this.f18616c = i;
            this.f18617d = j;
        }

        public final int mo3686a() {
            return this.f18616c;
        }

        public final long mo3687b() {
            return this.f18617d;
        }
    }

    private class IntShortPair extends AbstractPair {
        final /* synthetic */ CencSampleAuxiliaryDataFormat f18618b;
        private int f18619c;
        private short f18620d;

        public IntShortPair(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, int i, long j) {
            this.f18618b = cencSampleAuxiliaryDataFormat;
            super();
            this.f18619c = i;
            this.f18620d = (short) ((int) j);
        }

        public final int mo3686a() {
            return this.f18619c;
        }

        public final long mo3687b() {
            return (long) this.f18620d;
        }
    }

    private class ShortBytePair extends AbstractPair {
        final /* synthetic */ CencSampleAuxiliaryDataFormat f18621b;
        private short f18622c;
        private byte f18623d;

        public ShortBytePair(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, int i, long j) {
            this.f18621b = cencSampleAuxiliaryDataFormat;
            super();
            this.f18622c = (short) i;
            this.f18623d = (byte) ((int) j);
        }

        public final int mo3686a() {
            return this.f18622c;
        }

        public final long mo3687b() {
            return (long) this.f18623d;
        }
    }

    private class ShortIntPair extends AbstractPair {
        final /* synthetic */ CencSampleAuxiliaryDataFormat f18624b;
        private short f18625c;
        private int f18626d;

        public ShortIntPair(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, int i, long j) {
            this.f18624b = cencSampleAuxiliaryDataFormat;
            super();
            this.f18625c = (short) i;
            this.f18626d = (int) j;
        }

        public final int mo3686a() {
            return this.f18625c;
        }

        public final long mo3687b() {
            return (long) this.f18626d;
        }
    }

    private class ShortLongPair extends AbstractPair {
        final /* synthetic */ CencSampleAuxiliaryDataFormat f18627b;
        private short f18628c;
        private long f18629d;

        public ShortLongPair(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, int i, long j) {
            this.f18627b = cencSampleAuxiliaryDataFormat;
            super();
            this.f18628c = (short) i;
            this.f18629d = j;
        }

        public final int mo3686a() {
            return this.f18628c;
        }

        public final long mo3687b() {
            return this.f18629d;
        }
    }

    private class ShortShortPair extends AbstractPair {
        final /* synthetic */ CencSampleAuxiliaryDataFormat f18630b;
        private short f18631c;
        private short f18632d;

        public ShortShortPair(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, int i, long j) {
            this.f18630b = cencSampleAuxiliaryDataFormat;
            super();
            this.f18631c = (short) i;
            this.f18632d = (short) ((int) j);
        }

        public final int mo3686a() {
            return this.f18631c;
        }

        public final long mo3687b() {
            return (long) this.f18632d;
        }
    }

    public final int m8523a() {
        int length = this.f10095a.length;
        return (this.f10096b == null || this.f10096b.length <= 0) ? length : (length + 2) + (this.f10096b.length * 6);
    }

    public final Pair m8524a(int i, long j) {
        if (i <= 127) {
            if (j <= 127) {
                return new ByteBytePair(this, i, j);
            }
            if (j <= 32767) {
                return new ByteShortPair(this, i, j);
            }
            if (j <= 2147483647L) {
                return new ByteIntPair(this, i, j);
            }
            return new ByteLongPair(this, i, j);
        } else if (i <= 32767) {
            if (j <= 127) {
                return new ShortBytePair(this, i, j);
            }
            if (j <= 32767) {
                return new ShortShortPair(this, i, j);
            }
            if (j <= 2147483647L) {
                return new ShortIntPair(this, i, j);
            }
            return new ShortLongPair(this, i, j);
        } else if (j <= 127) {
            return new IntBytePair(this, i, j);
        } else {
            if (j <= 32767) {
                return new IntShortPair(this, i, j);
            }
            if (j <= 2147483647L) {
                return new IntIntPair(this, i, j);
            }
            return new IntLongPair(this, i, j);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat = (CencSampleAuxiliaryDataFormat) obj;
                if (!new BigInteger(this.f10095a).equals(new BigInteger(cencSampleAuxiliaryDataFormat.f10095a))) {
                    return false;
                }
                if (this.f10096b == null) {
                    return cencSampleAuxiliaryDataFormat.f10096b == null;
                } else {
                    if (Arrays.equals(this.f10096b, cencSampleAuxiliaryDataFormat.f10096b) == null) {
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = 31 * (this.f10095a != null ? Arrays.hashCode(this.f10095a) : 0);
        if (this.f10096b != null) {
            i = Arrays.hashCode(this.f10096b);
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Entry{iv=");
        stringBuilder.append(Hex.m3277a(this.f10095a));
        stringBuilder.append(", pairs=");
        stringBuilder.append(Arrays.toString(this.f10096b));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
