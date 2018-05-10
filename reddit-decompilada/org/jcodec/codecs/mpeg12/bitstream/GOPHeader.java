package org.jcodec.codecs.mpeg12.bitstream;

import java.nio.ByteBuffer;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;
import org.jcodec.common.model.TapeTimecode;

public class GOPHeader implements MPEGHeader {
    private boolean brokenLink;
    private boolean closedGop;
    private TapeTimecode timeCode;

    public GOPHeader(TapeTimecode tapeTimecode, boolean z, boolean z2) {
        this.timeCode = tapeTimecode;
        this.closedGop = z;
        this.brokenLink = z2;
    }

    public static GOPHeader read(ByteBuffer byteBuffer) {
        BitReader bitReader = new BitReader(byteBuffer);
        boolean z = false;
        boolean z2 = bitReader.read1Bit() == 1;
        short readNBit = (short) bitReader.readNBit(5);
        byte readNBit2 = (byte) bitReader.readNBit(6);
        bitReader.skip(1);
        byte readNBit3 = (byte) bitReader.readNBit(6);
        byte readNBit4 = (byte) bitReader.readNBit(6);
        byteBuffer = bitReader.read1Bit() == 1 ? 1 : null;
        if (bitReader.read1Bit() == 1) {
            z = true;
        }
        return new GOPHeader(new TapeTimecode(readNBit, readNBit2, readNBit3, readNBit4, z2), byteBuffer, z);
    }

    public void write(ByteBuffer byteBuffer) {
        BitWriter bitWriter = new BitWriter(byteBuffer);
        if (this.timeCode == null) {
            bitWriter.writeNBit(null, 25);
        } else {
            bitWriter.write1Bit(this.timeCode.isDropFrame());
            bitWriter.writeNBit(this.timeCode.getHour(), 5);
            bitWriter.writeNBit(this.timeCode.getMinute(), 6);
            bitWriter.write1Bit(1);
            bitWriter.writeNBit(this.timeCode.getSecond(), 6);
            bitWriter.writeNBit(this.timeCode.getFrame(), 6);
        }
        bitWriter.write1Bit(this.closedGop);
        bitWriter.write1Bit(this.brokenLink);
        bitWriter.flush();
    }

    public TapeTimecode getTimeCode() {
        return this.timeCode;
    }

    public boolean isClosedGop() {
        return this.closedGop;
    }

    public boolean isBrokenLink() {
        return this.brokenLink;
    }
}
