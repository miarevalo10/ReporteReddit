package org.jcodec.containers.mp4.boxes;

import com.googlecode.mp4parser.boxes.apple.TimeCodeBox;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.jcodec.common.NIOUtils;

public class TimecodeSampleEntry extends SampleEntry {
    private static final MyFactory FACTORY = new MyFactory();
    public static final int FLAG_24HOURMAX = 2;
    public static final int FLAG_COUNTER = 8;
    public static final int FLAG_DROPFRAME = 1;
    public static final int FLAG_NEGATIVETIMEOK = 4;
    private int flags;
    private int frameDuration;
    private byte numFrames;
    private int timescale;

    public static class MyFactory extends BoxFactory {
        private Map<String, Class<? extends Box>> mappings = new HashMap();

        public Class<? extends Box> toClass(String str) {
            return (Class) this.mappings.get(str);
        }
    }

    public TimecodeSampleEntry(Header header) {
        super(header);
        this.factory = FACTORY;
    }

    public TimecodeSampleEntry() {
        super(new Header(TimeCodeBox.TYPE));
        this.factory = FACTORY;
    }

    public TimecodeSampleEntry(int i, int i2, int i3, int i4) {
        super(new Header(TimeCodeBox.TYPE));
        this.flags = i;
        this.timescale = i2;
        this.frameDuration = i3;
        this.numFrames = (byte) i4;
    }

    public void parse(ByteBuffer byteBuffer) {
        super.parse(byteBuffer);
        NIOUtils.skip(byteBuffer, 4);
        this.flags = byteBuffer.getInt();
        this.timescale = byteBuffer.getInt();
        this.frameDuration = byteBuffer.getInt();
        this.numFrames = byteBuffer.get();
        NIOUtils.skip(byteBuffer, 1);
    }

    protected void doWrite(ByteBuffer byteBuffer) {
        super.doWrite(byteBuffer);
        byteBuffer.putInt(0);
        byteBuffer.putInt(this.flags);
        byteBuffer.putInt(this.timescale);
        byteBuffer.putInt(this.frameDuration);
        byteBuffer.put(this.numFrames);
        byteBuffer.put((byte) -49);
    }

    public int getFlags() {
        return this.flags;
    }

    public int getTimescale() {
        return this.timescale;
    }

    public int getFrameDuration() {
        return this.frameDuration;
    }

    public byte getNumFrames() {
        return this.numFrames;
    }

    public boolean isDropFrame() {
        return (this.flags & 1) != 0;
    }
}
