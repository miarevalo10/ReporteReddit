package org.jcodec.containers.mp4.boxes;

import com.coremedia.iso.boxes.SampleSizeBox;
import java.nio.ByteBuffer;

public class SampleSizesBox extends FullBox {
    private int count;
    private int defaultSize;
    private int[] sizes;

    public static String fourcc() {
        return SampleSizeBox.TYPE;
    }

    public SampleSizesBox(int i, int i2) {
        this();
        this.defaultSize = i;
        this.count = i2;
    }

    public SampleSizesBox(int[] iArr) {
        this();
        this.sizes = iArr;
    }

    public SampleSizesBox() {
        super(new Header(fourcc()));
    }

    public void parse(ByteBuffer byteBuffer) {
        super.parse(byteBuffer);
        this.defaultSize = byteBuffer.getInt();
        this.count = byteBuffer.getInt();
        if (this.defaultSize == 0) {
            this.sizes = new int[this.count];
            for (int i = 0; i < this.count; i++) {
                this.sizes[i] = byteBuffer.getInt();
            }
        }
    }

    public int getDefaultSize() {
        return this.defaultSize;
    }

    public int[] getSizes() {
        return this.sizes;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void doWrite(ByteBuffer byteBuffer) {
        super.doWrite(byteBuffer);
        byteBuffer.putInt(this.defaultSize);
        if (this.defaultSize == 0) {
            byteBuffer.putInt(this.sizes.length);
            for (int i : this.sizes) {
                byteBuffer.putInt((int) ((long) i));
            }
            return;
        }
        byteBuffer.putInt(this.count);
    }
}
