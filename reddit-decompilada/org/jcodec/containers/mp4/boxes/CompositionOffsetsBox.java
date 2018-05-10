package org.jcodec.containers.mp4.boxes;

import com.coremedia.iso.boxes.CompositionTimeToSample;
import java.nio.ByteBuffer;

public class CompositionOffsetsBox extends FullBox {
    private Entry[] entries;

    public static class Entry {
        public int count;
        public int offset;

        public Entry(int i, int i2) {
            this.count = i;
            this.offset = i2;
        }

        public int getCount() {
            return this.count;
        }

        public int getOffset() {
            return this.offset;
        }
    }

    public static String fourcc() {
        return CompositionTimeToSample.TYPE;
    }

    public CompositionOffsetsBox() {
        super(new Header(fourcc()));
    }

    public CompositionOffsetsBox(Entry[] entryArr) {
        super(new Header(fourcc()));
        this.entries = entryArr;
    }

    public void parse(ByteBuffer byteBuffer) {
        super.parse(byteBuffer);
        int i = byteBuffer.getInt();
        this.entries = new Entry[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.entries[i2] = new Entry(byteBuffer.getInt(), byteBuffer.getInt());
        }
    }

    protected void doWrite(ByteBuffer byteBuffer) {
        super.doWrite(byteBuffer);
        byteBuffer.putInt(this.entries.length);
        for (int i = 0; i < this.entries.length; i++) {
            byteBuffer.putInt(this.entries[i].count);
            byteBuffer.putInt(this.entries[i].offset);
        }
    }

    public Entry[] getEntries() {
        return this.entries;
    }
}
