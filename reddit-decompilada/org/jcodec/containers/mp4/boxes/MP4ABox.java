package org.jcodec.containers.mp4.boxes;

import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import java.nio.ByteBuffer;

public class MP4ABox extends Box {
    private int val;

    public MP4ABox(int i) {
        super(new Header(AudioSampleEntry.TYPE3));
    }

    protected void doWrite(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.val);
    }

    public void parse(ByteBuffer byteBuffer) {
        this.val = byteBuffer.getInt();
    }
}
