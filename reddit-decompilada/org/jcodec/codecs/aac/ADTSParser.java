package org.jcodec.codecs.aac;

import java.nio.ByteBuffer;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;

public class ADTSParser {

    public static class Header {
        private int chanConfig;
        private int crcAbsent;
        private int numAACFrames;
        private int objectType;
        private int samples;
        private int samplingIndex;

        public Header(int i, int i2, int i3, int i4, int i5) {
            this.objectType = i;
            this.chanConfig = i2;
            this.crcAbsent = i3;
            this.numAACFrames = i4;
            this.samplingIndex = i5;
        }

        public int getObjectType() {
            return this.objectType;
        }

        public int getChanConfig() {
            return this.chanConfig;
        }

        public int getCrcAbsent() {
            return this.crcAbsent;
        }

        public int getNumAACFrames() {
            return this.numAACFrames;
        }

        public int getSamplingIndex() {
            return this.samplingIndex;
        }

        public int getSamples() {
            return this.samples;
        }
    }

    public static Header read(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        BitReader bitReader = new BitReader(duplicate);
        if (bitReader.readNBit(12) != 4095) {
            return null;
        }
        bitReader.read1Bit();
        bitReader.readNBit(2);
        int read1Bit = bitReader.read1Bit();
        int readNBit = bitReader.readNBit(2);
        int readNBit2 = bitReader.readNBit(4);
        bitReader.read1Bit();
        int readNBit3 = bitReader.readNBit(3);
        bitReader.read1Bit();
        bitReader.read1Bit();
        bitReader.read1Bit();
        bitReader.read1Bit();
        if (bitReader.readNBit(13) < 7) {
            return null;
        }
        bitReader.readNBit(11);
        int readNBit4 = bitReader.readNBit(2);
        bitReader.stop();
        byteBuffer.position(duplicate.position());
        return new Header(readNBit + 1, readNBit3, read1Bit, readNBit4 + 1, readNBit2);
    }

    public static ByteBuffer write(Header header, ByteBuffer byteBuffer, int i) {
        byteBuffer = byteBuffer.duplicate();
        BitWriter bitWriter = new BitWriter(byteBuffer);
        bitWriter.writeNBit(4095, 12);
        bitWriter.write1Bit(1);
        bitWriter.writeNBit(0, 2);
        bitWriter.write1Bit(header.getCrcAbsent());
        bitWriter.writeNBit(header.getObjectType(), 2);
        bitWriter.writeNBit(header.getSamplingIndex(), 4);
        bitWriter.write1Bit(0);
        bitWriter.writeNBit(header.getChanConfig(), 3);
        bitWriter.write1Bit(0);
        bitWriter.write1Bit(0);
        bitWriter.write1Bit(0);
        bitWriter.write1Bit(0);
        bitWriter.writeNBit(i + 7, 13);
        bitWriter.writeNBit(0, 11);
        bitWriter.writeNBit(header.getNumAACFrames(), 2);
        bitWriter.flush();
        byteBuffer.flip();
        return byteBuffer;
    }
}
