package org.jcodec.common.model;

public class TapeTimecode {
    private boolean dropFrame;
    private byte frame;
    private short hour;
    private byte minute;
    private byte second;

    public TapeTimecode(short s, byte b, byte b2, byte b3, boolean z) {
        this.hour = s;
        this.minute = b;
        this.second = b2;
        this.frame = b3;
        this.dropFrame = z;
    }

    public short getHour() {
        return this.hour;
    }

    public byte getMinute() {
        return this.minute;
    }

    public byte getSecond() {
        return this.second;
    }

    public byte getFrame() {
        return this.frame;
    }

    public boolean isDropFrame() {
        return this.dropFrame;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%02d:%02d:%02d", new Object[]{Short.valueOf(this.hour), Byte.valueOf(this.minute), Byte.valueOf(this.second)}));
        stringBuilder.append(this.dropFrame ? ";" : ":");
        stringBuilder.append(String.format("%02d", new Object[]{Byte.valueOf(this.frame)}));
        return stringBuilder.toString();
    }
}
