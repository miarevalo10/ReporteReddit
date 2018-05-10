package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class TrackFragmentBaseMediaDecodeTimeBox extends FullBox {
    private long baseMediaDecodeTime;

    public static class Factory {
        private TrackFragmentBaseMediaDecodeTimeBox box;

        protected Factory(TrackFragmentBaseMediaDecodeTimeBox trackFragmentBaseMediaDecodeTimeBox) {
            this.box = new TrackFragmentBaseMediaDecodeTimeBox(trackFragmentBaseMediaDecodeTimeBox.baseMediaDecodeTime);
            this.box.version = trackFragmentBaseMediaDecodeTimeBox.version;
            this.box.flags = trackFragmentBaseMediaDecodeTimeBox.flags;
        }

        public Factory baseMediaDecodeTime(long j) {
            this.box.baseMediaDecodeTime = j;
            return this;
        }

        public TrackFragmentBaseMediaDecodeTimeBox create() {
            try {
                TrackFragmentBaseMediaDecodeTimeBox trackFragmentBaseMediaDecodeTimeBox = this.box;
                return trackFragmentBaseMediaDecodeTimeBox;
            } finally {
                this.box = null;
            }
        }
    }

    public static String fourcc() {
        return com.coremedia.iso.boxes.fragment.TrackFragmentBaseMediaDecodeTimeBox.TYPE;
    }

    public TrackFragmentBaseMediaDecodeTimeBox() {
        super(new Header(fourcc()));
    }

    public TrackFragmentBaseMediaDecodeTimeBox(long j) {
        this();
        this.baseMediaDecodeTime = j;
        if (this.baseMediaDecodeTime > 2147483647L) {
            this.version = 1;
        }
    }

    public void parse(ByteBuffer byteBuffer) {
        super.parse(byteBuffer);
        if (this.version == (byte) 0) {
            this.baseMediaDecodeTime = (long) byteBuffer.getInt();
        } else if (this.version == (byte) 1) {
            this.baseMediaDecodeTime = byteBuffer.getLong();
        } else {
            throw new RuntimeException("Unsupported tfdt version");
        }
    }

    protected void doWrite(ByteBuffer byteBuffer) {
        super.doWrite(byteBuffer);
        if (this.version == (byte) 0) {
            byteBuffer.putInt((int) this.baseMediaDecodeTime);
        } else if (this.version == (byte) 1) {
            byteBuffer.putLong(this.baseMediaDecodeTime);
        } else {
            throw new RuntimeException("Unsupported tfdt version");
        }
    }

    public long getBaseMediaDecodeTime() {
        return this.baseMediaDecodeTime;
    }

    public static Factory copy(TrackFragmentBaseMediaDecodeTimeBox trackFragmentBaseMediaDecodeTimeBox) {
        return new Factory(trackFragmentBaseMediaDecodeTimeBox);
    }
}
