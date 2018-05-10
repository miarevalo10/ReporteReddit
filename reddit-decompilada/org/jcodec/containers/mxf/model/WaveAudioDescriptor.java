package org.jcodec.containers.mxf.model;

import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;

public class WaveAudioDescriptor extends GenericSoundEssenceDescriptor {
    private int avgBps;
    private short blockAlign;
    private UL channelAssignment;
    private int peakChannels;
    private int peakEnvelopeBlockSize;
    private ByteBuffer peakEnvelopeData;
    private int peakEnvelopeFormat;
    private ByteBuffer peakEnvelopeTimestamp;
    private int peakEnvelopeVersion;
    private int peakFrames;
    private ByteBuffer peakOfPeaksPosition;
    private int pointsPerPeakValue;
    private byte sequenceOffset;

    public WaveAudioDescriptor(UL ul) {
        super(ul);
    }

    protected void read(Map<Integer, ByteBuffer> map) {
        super.read(map);
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            ByteBuffer byteBuffer = (ByteBuffer) entry.getValue();
            int intValue = ((Integer) entry.getKey()).intValue();
            switch (intValue) {
                case 15625:
                    this.avgBps = byteBuffer.getInt();
                    break;
                case 15626:
                    this.blockAlign = byteBuffer.getShort();
                    break;
                case 15627:
                    this.sequenceOffset = byteBuffer.get();
                    break;
                default:
                    switch (intValue) {
                        case 15657:
                            this.peakEnvelopeVersion = byteBuffer.getInt();
                            break;
                        case 15658:
                            this.peakEnvelopeFormat = byteBuffer.getInt();
                            break;
                        case 15659:
                            this.pointsPerPeakValue = byteBuffer.getInt();
                            break;
                        case 15660:
                            this.peakEnvelopeBlockSize = byteBuffer.getInt();
                            break;
                        case 15661:
                            this.peakChannels = byteBuffer.getInt();
                            break;
                        case 15662:
                            this.peakFrames = byteBuffer.getInt();
                            break;
                        case 15663:
                            this.peakOfPeaksPosition = byteBuffer;
                            break;
                        case 15664:
                            this.peakEnvelopeTimestamp = byteBuffer;
                            break;
                        case 15665:
                            this.peakEnvelopeData = byteBuffer;
                            break;
                        case 15666:
                            this.channelAssignment = UL.read(byteBuffer);
                            break;
                        default:
                            PrintStream printStream = System.out;
                            StringBuilder stringBuilder = new StringBuilder("Unknown tag [ ");
                            stringBuilder.append(this.ul);
                            stringBuilder.append("]: %04x");
                            printStream.println(String.format(stringBuilder.toString(), new Object[]{entry.getKey()}));
                            continue;
                            continue;
                    }
            }
            map.remove();
        }
    }

    public short getBlockAlign() {
        return this.blockAlign;
    }

    public byte getSequenceOffset() {
        return this.sequenceOffset;
    }

    public int getAvgBps() {
        return this.avgBps;
    }

    public UL getChannelAssignment() {
        return this.channelAssignment;
    }

    public int getPeakEnvelopeVersion() {
        return this.peakEnvelopeVersion;
    }

    public int getPeakEnvelopeFormat() {
        return this.peakEnvelopeFormat;
    }

    public int getPointsPerPeakValue() {
        return this.pointsPerPeakValue;
    }

    public int getPeakEnvelopeBlockSize() {
        return this.peakEnvelopeBlockSize;
    }

    public int getPeakChannels() {
        return this.peakChannels;
    }

    public int getPeakFrames() {
        return this.peakFrames;
    }

    public ByteBuffer getPeakOfPeaksPosition() {
        return this.peakOfPeaksPosition;
    }

    public ByteBuffer getPeakEnvelopeTimestamp() {
        return this.peakEnvelopeTimestamp;
    }

    public ByteBuffer getPeakEnvelopeData() {
        return this.peakEnvelopeData;
    }
}
