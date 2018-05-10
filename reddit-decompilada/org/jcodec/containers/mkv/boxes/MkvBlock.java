package org.jcodec.containers.mkv.boxes;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import org.jcodec.common.ByteArrayList;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.containers.mkv.MKVType;
import org.jcodec.containers.mkv.util.EbmlUtil;

public class MkvBlock extends EbmlBin {
    private static final String EBML = "EBML";
    private static final String FIXED = "Fixed";
    private static final int MAX_BLOCK_HEADER_SIZE = 512;
    private static final String XIPH = "Xiph";
    public long absoluteTimecode;
    public boolean discardable;
    public int[] frameOffsets;
    public int[] frameSizes;
    public ByteBuffer[] frames;
    public int headerSize;
    public boolean keyFrame;
    public String lacing;
    public boolean lacingPresent;
    public int timecode;
    public long trackNumber;

    public static MkvBlock copy(MkvBlock mkvBlock) {
        MkvBlock mkvBlock2 = new MkvBlock(mkvBlock.id);
        mkvBlock2.trackNumber = mkvBlock.trackNumber;
        mkvBlock2.timecode = mkvBlock.timecode;
        mkvBlock2.absoluteTimecode = mkvBlock.absoluteTimecode;
        mkvBlock2.keyFrame = mkvBlock.keyFrame;
        mkvBlock2.headerSize = mkvBlock.headerSize;
        mkvBlock2.lacing = mkvBlock.lacing;
        mkvBlock2.discardable = mkvBlock.discardable;
        mkvBlock2.lacingPresent = mkvBlock.lacingPresent;
        mkvBlock2.frameOffsets = new int[mkvBlock.frameOffsets.length];
        mkvBlock2.frameSizes = new int[mkvBlock.frameSizes.length];
        mkvBlock2.dataOffset = mkvBlock.dataOffset;
        mkvBlock2.offset = mkvBlock.offset;
        mkvBlock2.type = mkvBlock.type;
        System.arraycopy(mkvBlock.frameOffsets, 0, mkvBlock2.frameOffsets, 0, mkvBlock2.frameOffsets.length);
        System.arraycopy(mkvBlock.frameSizes, 0, mkvBlock2.frameSizes, 0, mkvBlock2.frameSizes.length);
        return mkvBlock2;
    }

    public static MkvBlock keyFrame(long j, int i, ByteBuffer byteBuffer) {
        MkvBlock mkvBlock = new MkvBlock(MKVType.SimpleBlock.id);
        mkvBlock.frames = new ByteBuffer[]{byteBuffer};
        mkvBlock.frameSizes = new int[]{byteBuffer.limit()};
        mkvBlock.keyFrame = true;
        mkvBlock.trackNumber = j;
        mkvBlock.timecode = i;
        return mkvBlock;
    }

    public MkvBlock(byte[] bArr) {
        super(bArr);
        if (!Arrays.equals(MKVType.SimpleBlock.id, bArr) && !Arrays.equals(MKVType.Block.id, bArr)) {
            StringBuilder stringBuilder = new StringBuilder("Block initiated with invalid id: ");
            stringBuilder.append(EbmlUtil.toHexString(bArr));
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public void read(SeekableByteChannel seekableByteChannel) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(100);
        seekableByteChannel.read(allocate);
        allocate.flip();
        read(allocate);
        seekableByteChannel.position(this.dataOffset + ((long) this.dataLen));
    }

    public void read(ByteBuffer byteBuffer) {
        byteBuffer = byteBuffer.slice();
        this.trackNumber = ebmlDecode(byteBuffer);
        this.timecode = (short) ((((short) (byteBuffer.get() & 255)) << 8) | ((short) (byteBuffer.get() & 255)));
        int i = byteBuffer.get() & 255;
        this.keyFrame = (i & 128) > 0;
        this.discardable = (i & 1) > 0;
        i &= 6;
        this.lacingPresent = i != 0;
        if (this.lacingPresent) {
            int i2 = (byteBuffer.get() & 255) + 1;
            this.frameSizes = new int[i2];
            if (i == 2) {
                this.lacing = XIPH;
                this.headerSize = readXiphLaceSizes(byteBuffer, this.frameSizes, this.dataLen, byteBuffer.position());
            } else if (i == 6) {
                this.lacing = EBML;
                this.headerSize = readEBMLLaceSizes(byteBuffer, this.frameSizes, this.dataLen, byteBuffer.position());
            } else if (i == 4) {
                this.lacing = FIXED;
                this.headerSize = byteBuffer.position();
                Arrays.fill(this.frameSizes, (this.dataLen - this.headerSize) / i2);
            } else {
                throw new RuntimeException("Unsupported lacing type flag.");
            }
            turnSizesToFrameOffsets(this.frameSizes);
            return;
        }
        this.lacing = "";
        i = byteBuffer.position();
        this.frameOffsets = new int[1];
        this.frameOffsets[0] = i;
        this.headerSize = byteBuffer.position();
        this.frameSizes = new int[1];
        this.frameSizes[0] = this.dataLen - this.headerSize;
    }

    private void turnSizesToFrameOffsets(int[] iArr) {
        this.frameOffsets = new int[iArr.length];
        this.frameOffsets[0] = this.headerSize;
        for (int i = 1; i < iArr.length; i++) {
            int i2 = i - 1;
            this.frameOffsets[i] = this.frameOffsets[i2] + iArr[i2];
        }
    }

    public static int readXiphLaceSizes(ByteBuffer byteBuffer, int[] iArr, int i, int i2) {
        int position = byteBuffer.position();
        int length = iArr.length - 1;
        iArr[length] = i;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = 255;
            while (i4 == 255) {
                i4 = byteBuffer.get() & 255;
                iArr[i3] = iArr[i3] + i4;
            }
            iArr[length] = iArr[length] - iArr[i3];
        }
        byteBuffer = (byteBuffer.position() - position) + i2;
        iArr[length] = iArr[length] - byteBuffer;
        return byteBuffer;
    }

    public static int readEBMLLaceSizes(ByteBuffer byteBuffer, int[] iArr, int i, int i2) {
        int i3 = 1;
        int length = iArr.length - 1;
        iArr[length] = i;
        i = byteBuffer.position();
        iArr[0] = (int) ebmlDecode(byteBuffer);
        iArr[length] = iArr[length] - iArr[0];
        int i4 = iArr[0];
        while (i3 < length) {
            i4 = (int) (((long) i4) + ebmlDecodeSigned(byteBuffer));
            iArr[i3] = i4;
            iArr[length] = iArr[length] - iArr[i3];
            i3++;
        }
        byteBuffer = (byteBuffer.position() - i) + i2;
        iArr[length] = iArr[length] - byteBuffer;
        return byteBuffer;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{dataOffset: ");
        stringBuilder.append(this.dataOffset);
        stringBuilder.append(", trackNumber: ");
        stringBuilder.append(this.trackNumber);
        stringBuilder.append(", timecode: ");
        stringBuilder.append(this.timecode);
        stringBuilder.append(", keyFrame: ");
        stringBuilder.append(this.keyFrame);
        stringBuilder.append(", headerSize: ");
        stringBuilder.append(this.headerSize);
        stringBuilder.append(", lacing: ");
        stringBuilder.append(this.lacing);
        for (int i = 0; i < this.frameSizes.length; i++) {
            stringBuilder.append(", frame[");
            stringBuilder.append(i);
            stringBuilder.append("]  offset ");
            stringBuilder.append(this.frameOffsets[i]);
            stringBuilder.append(" size ");
            stringBuilder.append(this.frameSizes[i]);
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public ByteBuffer[] getFrames(ByteBuffer byteBuffer) throws IOException {
        ByteBuffer[] byteBufferArr = new ByteBuffer[this.frameSizes.length];
        for (int i = 0; i < this.frameSizes.length; i++) {
            if (this.frameOffsets[i] > byteBuffer.limit()) {
                PrintStream printStream = System.err;
                StringBuilder stringBuilder = new StringBuilder("frame offset: ");
                stringBuilder.append(this.frameOffsets[i]);
                stringBuilder.append(" limit: ");
                stringBuilder.append(byteBuffer.limit());
                printStream.println(stringBuilder.toString());
            }
            byteBuffer.position(this.frameOffsets[i]);
            ByteBuffer slice = byteBuffer.slice();
            slice.limit(this.frameSizes[i]);
            byteBufferArr[i] = slice;
        }
        return byteBufferArr;
    }

    public void readFrames(ByteBuffer byteBuffer) throws IOException {
        this.frames = getFrames(byteBuffer);
    }

    public ByteBuffer getData() {
        int dataSize = getDataSize();
        long j = (long) dataSize;
        int i = 0;
        ByteBuffer allocate = ByteBuffer.allocate((dataSize + EbmlUtil.ebmlLength(j)) + this.id.length);
        allocate.put(this.id);
        allocate.put(EbmlUtil.ebmlEncode(j));
        allocate.put(EbmlUtil.ebmlEncode(this.trackNumber));
        allocate.put((byte) ((this.timecode >>> 8) & 255));
        allocate.put((byte) (this.timecode & 255));
        byte b = XIPH.equals(this.lacing) ? (byte) 2 : EBML.equals(this.lacing) ? (byte) 6 : FIXED.equals(this.lacing) ? (byte) 4 : (byte) 0;
        if (this.discardable) {
            b = (byte) (b | 1);
        }
        if (this.keyFrame) {
            b = (byte) (b | 128);
        }
        allocate.put(b);
        if ((b & 6) != 0) {
            allocate.put((byte) ((this.frames.length - 1) & 255));
            allocate.put(muxLacingInfo());
        }
        ByteBuffer[] byteBufferArr = this.frames;
        int length = byteBufferArr.length;
        while (i < length) {
            allocate.put(byteBufferArr[i]);
            i++;
        }
        allocate.flip();
        return allocate;
    }

    public void seekAndReadContent(FileChannel fileChannel) throws IOException {
        this.data = ByteBuffer.allocate(this.dataLen);
        fileChannel.position(this.dataOffset);
        fileChannel.read(this.data);
        this.data.flip();
    }

    public long size() {
        long dataSize = (long) getDataSize();
        return (dataSize + ((long) EbmlUtil.ebmlLength(dataSize))) + ((long) this.id.length);
    }

    public int getDataSize() {
        int[] iArr = this.frameSizes;
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            i2 = (int) (((long) i2) + ((long) iArr[i]));
            i++;
        }
        if (this.lacingPresent) {
            i2 = (i2 + muxLacingInfo().length) + 1;
        }
        return (i2 + 3) + EbmlUtil.ebmlLength(this.trackNumber);
    }

    private byte[] muxLacingInfo() {
        if (EBML.equals(this.lacing)) {
            return muxEbmlLacing(this.frameSizes);
        }
        if (XIPH.equals(this.lacing)) {
            return muxXiphLacing(this.frameSizes);
        }
        return FIXED.equals(this.lacing) ? new byte[0] : null;
    }

    public static long ebmlDecode(ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        int computeLength = EbmlUtil.computeLength(b);
        if (computeLength == 0) {
            throw new RuntimeException("Invalid ebml integer size.");
        }
        long j = (long) (b & (255 >>> computeLength));
        for (computeLength--; computeLength > 0; computeLength--) {
            j = (j << 8) | ((long) (byteBuffer.get() & 255));
        }
        return j;
    }

    public static long ebmlDecodeSigned(ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        int computeLength = EbmlUtil.computeLength(b);
        if (computeLength == 0) {
            throw new RuntimeException("Invalid ebml integer size.");
        }
        long j = (long) (b & (255 >>> computeLength));
        for (int i = computeLength - 1; i > 0; i--) {
            j = (j << 8) | ((long) (byteBuffer.get() & 255));
        }
        return j - EbmlSint.signedComplement[computeLength];
    }

    public static long[] calcEbmlLacingDiffs(int[] iArr) {
        int i = 1;
        int length = iArr.length - 1;
        long[] jArr = new long[length];
        jArr[0] = (long) iArr[0];
        while (i < length) {
            jArr[i] = (long) (iArr[i] - iArr[i - 1]);
            i++;
        }
        return jArr;
    }

    public static byte[] muxEbmlLacing(int[] iArr) {
        ByteArrayList byteArrayList = new ByteArrayList();
        iArr = calcEbmlLacingDiffs(iArr);
        byteArrayList.addAll(EbmlUtil.ebmlEncode(iArr[0]));
        for (int i = 1; i < iArr.length; i++) {
            byteArrayList.addAll(EbmlSint.convertToBytes(iArr[i]));
        }
        return byteArrayList.toArray();
    }

    public static byte[] muxXiphLacing(int[] iArr) {
        ByteArrayList byteArrayList = new ByteArrayList();
        for (int i = 0; i < iArr.length - 1; i++) {
            long j = (long) iArr[i];
            while (j >= 255) {
                byteArrayList.add((byte) -1);
                j -= 255;
            }
            byteArrayList.add((byte) ((int) j));
        }
        return byteArrayList.toArray();
    }
}
