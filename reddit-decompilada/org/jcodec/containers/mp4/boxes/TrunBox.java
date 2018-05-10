package org.jcodec.containers.mp4.boxes;

import com.coremedia.iso.boxes.fragment.TrackRunBox;
import java.nio.ByteBuffer;
import java.util.List;

public class TrunBox extends FullBox {
    private static final int DATA_OFFSET_AVAILABLE = 1;
    private static final int FIRST_SAMPLE_FLAGS_AVAILABLE = 4;
    private static final int SAMPLE_COMPOSITION_OFFSET_AVAILABLE = 2048;
    private static final int SAMPLE_DURATION_AVAILABLE = 256;
    private static final int SAMPLE_FLAGS_AVAILABLE = 1024;
    private static final int SAMPLE_SIZE_AVAILABLE = 512;
    private int dataOffset;
    private int firstSampleFlags;
    private int[] sampleCompositionOffset;
    private int sampleCount;
    private int[] sampleDuration;
    private int[] sampleFlags;
    private int[] sampleSize;

    public static class Factory {
        private TrunBox box;

        protected Factory(int i) {
            this.box = new TrunBox(i);
        }

        public Factory(TrunBox trunBox) {
            this.box = new TrunBox(trunBox.sampleCount, trunBox.dataOffset, trunBox.firstSampleFlags, trunBox.sampleDuration, trunBox.sampleSize, trunBox.sampleFlags, trunBox.sampleCompositionOffset);
            this.box.setFlags(trunBox.getFlags());
            this.box.setVersion(trunBox.getVersion());
        }

        public Factory dataOffset(long j) {
            TrunBox trunBox = this.box;
            trunBox.flags |= 1;
            this.box.dataOffset = (int) j;
            return this;
        }

        public Factory firstSampleFlags(int i) {
            if (this.box.isSampleFlagsAvailable()) {
                throw new IllegalStateException("Sample flags already set on this object");
            }
            TrunBox trunBox = this.box;
            trunBox.flags |= 4;
            this.box.firstSampleFlags = i;
            return this;
        }

        public Factory sampleDuration(int[] iArr) {
            if (iArr.length != this.box.sampleCount) {
                throw new IllegalArgumentException("Argument array length not equal to sampleCount");
            }
            TrunBox trunBox = this.box;
            trunBox.flags |= TrunBox.SAMPLE_DURATION_AVAILABLE;
            this.box.sampleDuration = iArr;
            return this;
        }

        public Factory sampleSize(int[] iArr) {
            if (iArr.length != this.box.sampleCount) {
                throw new IllegalArgumentException("Argument array length not equal to sampleCount");
            }
            TrunBox trunBox = this.box;
            trunBox.flags |= 512;
            this.box.sampleSize = iArr;
            return this;
        }

        public Factory sampleFlags(int[] iArr) {
            if (iArr.length != this.box.sampleCount) {
                throw new IllegalArgumentException("Argument array length not equal to sampleCount");
            } else if (this.box.isFirstSampleFlagsAvailable()) {
                throw new IllegalStateException("First sample flags already set on this object");
            } else {
                TrunBox trunBox = this.box;
                trunBox.flags |= 1024;
                this.box.sampleFlags = iArr;
                return this;
            }
        }

        public Factory sampleCompositionOffset(int[] iArr) {
            if (iArr.length != this.box.sampleCount) {
                throw new IllegalArgumentException("Argument array length not equal to sampleCount");
            }
            TrunBox trunBox = this.box;
            trunBox.flags |= 2048;
            this.box.sampleCompositionOffset = iArr;
            return this;
        }

        public TrunBox create() {
            try {
                TrunBox trunBox = this.box;
                return trunBox;
            } finally {
                this.box = null;
            }
        }
    }

    public static int flagsGetSampleDegradationPriority(int i) {
        return (i >> 16) & 65535;
    }

    public static int flagsGetSampleDependsOn(int i) {
        return (i >> 6) & 3;
    }

    public static int flagsGetSampleHasRedundancy(int i) {
        return (i >> 10) & 3;
    }

    public static int flagsGetSampleIsDependedOn(int i) {
        return (i >> 8) & 3;
    }

    public static int flagsGetSampleIsDifferentSample(int i) {
        return (i >> 15) & 1;
    }

    public static int flagsGetSamplePaddingValue(int i) {
        return (i >> 12) & 7;
    }

    public static String fourcc() {
        return TrackRunBox.TYPE;
    }

    public void setDataOffset(int i) {
        this.dataOffset = i;
    }

    public static Factory create(int i) {
        return new Factory(i);
    }

    public static Factory copy(TrunBox trunBox) {
        return new Factory(trunBox);
    }

    public TrunBox() {
        super(new Header(fourcc()));
    }

    protected TrunBox(int i, int i2, int i3, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        this();
        this.sampleCount = i;
        this.dataOffset = i2;
        this.firstSampleFlags = i3;
        this.sampleDuration = iArr;
        this.sampleSize = iArr2;
        this.sampleFlags = iArr3;
        this.sampleCompositionOffset = iArr4;
    }

    protected TrunBox(int i) {
        this();
        this.sampleCount = i;
    }

    public long getSampleCount() {
        return ((long) this.sampleCount) & 4294967295L;
    }

    public int getDataOffset() {
        return this.dataOffset;
    }

    public int getFirstSampleFlags() {
        return this.firstSampleFlags;
    }

    public int[] getSampleDuration() {
        return this.sampleDuration;
    }

    public int[] getSampleSize() {
        return this.sampleSize;
    }

    public int[] getSampleFlags() {
        return this.sampleFlags;
    }

    public int[] getSampleCompositionOffset() {
        return this.sampleCompositionOffset;
    }

    public long getSampleDuration(int i) {
        return ((long) this.sampleDuration[i]) & 4294967295L;
    }

    public long getSampleSize(int i) {
        return ((long) this.sampleSize[i]) & 4294967295L;
    }

    public int getSampleFlags(int i) {
        return this.sampleFlags[i];
    }

    public long getSampleCompositionOffset(int i) {
        return ((long) this.sampleCompositionOffset[i]) & 4294967295L;
    }

    public boolean isDataOffsetAvailable() {
        return (this.flags & 1) != 0;
    }

    public boolean isSampleCompositionOffsetAvailable() {
        return (this.flags & 2048) != 0;
    }

    public boolean isSampleFlagsAvailable() {
        return (this.flags & 1024) != 0;
    }

    public boolean isSampleSizeAvailable() {
        return (this.flags & 512) != 0;
    }

    public boolean isSampleDurationAvailable() {
        return (this.flags & SAMPLE_DURATION_AVAILABLE) != 0;
    }

    public boolean isFirstSampleFlagsAvailable() {
        return (this.flags & 4) != 0;
    }

    public void parse(ByteBuffer byteBuffer) {
        super.parse(byteBuffer);
        if (isSampleFlagsAvailable() && isFirstSampleFlagsAvailable()) {
            throw new RuntimeException("Broken stream");
        }
        this.sampleCount = byteBuffer.getInt();
        if (isDataOffsetAvailable()) {
            this.dataOffset = byteBuffer.getInt();
        }
        if (isFirstSampleFlagsAvailable()) {
            this.firstSampleFlags = byteBuffer.getInt();
        }
        if (isSampleDurationAvailable()) {
            this.sampleDuration = new int[this.sampleCount];
        }
        if (isSampleSizeAvailable()) {
            this.sampleSize = new int[this.sampleCount];
        }
        if (isSampleFlagsAvailable()) {
            this.sampleFlags = new int[this.sampleCount];
        }
        if (isSampleCompositionOffsetAvailable()) {
            this.sampleCompositionOffset = new int[this.sampleCount];
        }
        for (int i = 0; i < this.sampleCount; i++) {
            if (isSampleDurationAvailable()) {
                this.sampleDuration[i] = byteBuffer.getInt();
            }
            if (isSampleSizeAvailable()) {
                this.sampleSize[i] = byteBuffer.getInt();
            }
            if (isSampleFlagsAvailable()) {
                this.sampleFlags[i] = byteBuffer.getInt();
            }
            if (isSampleCompositionOffsetAvailable()) {
                this.sampleCompositionOffset[i] = byteBuffer.getInt();
            }
        }
    }

    public void doWrite(ByteBuffer byteBuffer) {
        super.doWrite(byteBuffer);
        byteBuffer.putInt(this.sampleCount);
        if (isDataOffsetAvailable()) {
            byteBuffer.putInt(this.dataOffset);
        }
        if (isFirstSampleFlagsAvailable()) {
            byteBuffer.putInt(this.firstSampleFlags);
        }
        for (int i = 0; i < this.sampleCount; i++) {
            if (isSampleDurationAvailable()) {
                byteBuffer.putInt(this.sampleDuration[i]);
            }
            if (isSampleSizeAvailable()) {
                byteBuffer.putInt(this.sampleSize[i]);
            }
            if (isSampleFlagsAvailable()) {
                byteBuffer.putInt(this.sampleFlags[i]);
            }
            if (isSampleCompositionOffsetAvailable()) {
                byteBuffer.putInt(this.sampleCompositionOffset[i]);
            }
        }
    }

    protected void getModelFields(List<String> list) {
        list.add("sampleCount");
        if (isDataOffsetAvailable()) {
            list.add("dataOffset");
        }
        if (isFirstSampleFlagsAvailable()) {
            list.add("firstSampleFlags");
        }
        if (isSampleDurationAvailable()) {
            list.add("sampleDuration");
        }
        if (isSampleSizeAvailable()) {
            list.add("sampleSize");
        }
        if (isSampleFlagsAvailable()) {
            list.add("sampleFlags");
        }
        if (isSampleCompositionOffsetAvailable()) {
            list.add("sampleCompositionOffset");
        }
    }
}
