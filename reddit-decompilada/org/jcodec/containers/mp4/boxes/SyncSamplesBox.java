package org.jcodec.containers.mp4.boxes;

import com.coremedia.iso.boxes.SyncSampleBox;
import java.nio.ByteBuffer;

public class SyncSamplesBox extends FullBox {
    private int[] syncSamples;

    public static String fourcc() {
        return SyncSampleBox.TYPE;
    }

    public SyncSamplesBox() {
        super(new Header(fourcc()));
    }

    public SyncSamplesBox(int[] iArr) {
        this();
        this.syncSamples = iArr;
    }

    public SyncSamplesBox(Header header) {
        super(header);
    }

    public void parse(ByteBuffer byteBuffer) {
        super.parse(byteBuffer);
        int i = byteBuffer.getInt();
        this.syncSamples = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.syncSamples[i2] = byteBuffer.getInt();
        }
    }

    protected void doWrite(ByteBuffer byteBuffer) {
        super.doWrite(byteBuffer);
        byteBuffer.putInt(this.syncSamples.length);
        for (int putInt : this.syncSamples) {
            byteBuffer.putInt(putInt);
        }
    }

    public int[] getSyncSamples() {
        return this.syncSamples;
    }
}
