package org.jcodec.containers.mps.index;

import java.nio.ByteBuffer;
import org.jcodec.common.RunLength.Integer;

public class MPSIndex {
    private Integer pesStreamIds;
    private long[] pesTokens;
    private MPSStreamIndex[] streams;

    public static class MPSStreamIndex {
        protected int[] fdur;
        protected int[] fpts;
        protected int[] fsizes;
        protected int streamId;
        protected int[] sync;

        public MPSStreamIndex(int i, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
            this.streamId = i;
            this.fsizes = iArr;
            this.fpts = iArr2;
            this.fdur = iArr3;
            this.sync = iArr4;
        }

        public MPSStreamIndex(MPSStreamIndex mPSStreamIndex) {
            this(mPSStreamIndex.streamId, mPSStreamIndex.fsizes, mPSStreamIndex.fpts, mPSStreamIndex.fdur, mPSStreamIndex.sync);
        }

        public int getStreamId() {
            return this.streamId;
        }

        public int[] getFsizes() {
            return this.fsizes;
        }

        public int[] getFpts() {
            return this.fpts;
        }

        public int[] getFdur() {
            return this.fdur;
        }

        public int[] getSync() {
            return this.sync;
        }

        public static MPSStreamIndex parseIndex(ByteBuffer byteBuffer) {
            int i = byteBuffer.get() & 255;
            int i2 = byteBuffer.getInt();
            int[] iArr = new int[i2];
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                iArr[i4] = byteBuffer.getInt();
            }
            i2 = byteBuffer.getInt();
            int[] iArr2 = new int[i2];
            for (int i5 = 0; i5 < i2; i5++) {
                iArr2[i5] = byteBuffer.getInt();
            }
            i2 = byteBuffer.getInt();
            int[] iArr3 = new int[i2];
            for (int i6 = 0; i6 < i2; i6++) {
                iArr3[i6] = byteBuffer.getInt();
            }
            i2 = byteBuffer.getInt();
            int[] iArr4 = new int[i2];
            while (i3 < i2) {
                iArr4[i3] = byteBuffer.getInt();
                i3++;
            }
            return new MPSStreamIndex(i, iArr, iArr2, iArr3, iArr4);
        }

        public void serialize(ByteBuffer byteBuffer) {
            byteBuffer.put((byte) this.streamId);
            int i = 0;
            byteBuffer.putInt(this.fsizes.length);
            for (int putInt : this.fsizes) {
                byteBuffer.putInt(putInt);
            }
            byteBuffer.putInt(this.fpts.length);
            for (int putInt2 : this.fpts) {
                byteBuffer.putInt(putInt2);
            }
            byteBuffer.putInt(this.fdur.length);
            for (int putInt22 : this.fdur) {
                byteBuffer.putInt(putInt22);
            }
            byteBuffer.putInt(this.sync.length);
            while (i < this.sync.length) {
                byteBuffer.putInt(this.sync[i]);
                i++;
            }
        }

        public int estimateSize() {
            return ((((this.fpts.length << 2) + (this.fdur.length << 2)) + (this.sync.length << 2)) + (this.fsizes.length << 2)) + 64;
        }
    }

    public static int leadingSize(long j) {
        return ((int) (j >> 48)) & 65535;
    }

    public static long makePESToken(long j, long j2, long j3) {
        return ((j << 48) | (j2 << 24)) | j3;
    }

    public static int payLoadSize(long j) {
        return ((int) j) & 16777215;
    }

    public static int pesLen(long j) {
        return ((int) (j >> 24)) & 16777215;
    }

    public MPSIndex(long[] jArr, Integer integer, MPSStreamIndex[] mPSStreamIndexArr) {
        this.pesTokens = jArr;
        this.pesStreamIds = integer;
        this.streams = mPSStreamIndexArr;
    }

    public MPSIndex(MPSIndex mPSIndex) {
        this(mPSIndex.pesTokens, mPSIndex.pesStreamIds, mPSIndex.streams);
    }

    public long[] getPesTokens() {
        return this.pesTokens;
    }

    public Integer getPesStreamIds() {
        return this.pesStreamIds;
    }

    public MPSStreamIndex[] getStreams() {
        return this.streams;
    }

    public static MPSIndex parseIndex(ByteBuffer byteBuffer) {
        int i;
        int i2 = byteBuffer.getInt();
        long[] jArr = new long[i2];
        int i3 = 0;
        for (i = 0; i < i2; i++) {
            jArr[i] = byteBuffer.getLong();
        }
        Integer parse = Integer.parse(byteBuffer);
        i = byteBuffer.getInt();
        MPSStreamIndex[] mPSStreamIndexArr = new MPSStreamIndex[i];
        while (i3 < i) {
            mPSStreamIndexArr[i3] = MPSStreamIndex.parseIndex(byteBuffer);
            i3++;
        }
        return new MPSIndex(jArr, parse, mPSStreamIndexArr);
    }

    public void serializeTo(ByteBuffer byteBuffer) {
        int i = 0;
        byteBuffer.putInt(this.pesTokens.length);
        for (long putLong : this.pesTokens) {
            byteBuffer.putLong(putLong);
        }
        this.pesStreamIds.serialize(byteBuffer);
        byteBuffer.putInt(this.streams.length);
        MPSStreamIndex[] mPSStreamIndexArr = this.streams;
        int length = mPSStreamIndexArr.length;
        while (i < length) {
            mPSStreamIndexArr[i].serialize(byteBuffer);
            i++;
        }
    }

    public int estimateSize() {
        int length = (this.pesTokens.length << 3) + this.pesStreamIds.estimateSize();
        for (MPSStreamIndex estimateSize : this.streams) {
            length += estimateSize.estimateSize();
        }
        return length + 64;
    }
}
