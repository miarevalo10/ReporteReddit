package org.jcodec.containers.mp4.boxes;

import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import java.nio.ByteBuffer;

public class LoadSettingsBox extends Box {
    private int defaultHints;
    private int preloadDuration;
    private int preloadFlags;
    private int preloadStartTime;

    public static String fourcc() {
        return TrackLoadSettingsAtom.TYPE;
    }

    public LoadSettingsBox(Header header) {
        super(header);
    }

    public LoadSettingsBox() {
        super(new Header(fourcc()));
    }

    public void parse(ByteBuffer byteBuffer) {
        this.preloadStartTime = byteBuffer.getInt();
        this.preloadDuration = byteBuffer.getInt();
        this.preloadFlags = byteBuffer.getInt();
        this.defaultHints = byteBuffer.getInt();
    }

    protected void doWrite(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.preloadStartTime);
        byteBuffer.putInt(this.preloadDuration);
        byteBuffer.putInt(this.preloadFlags);
        byteBuffer.putInt(this.defaultHints);
    }

    public int getPreloadStartTime() {
        return this.preloadStartTime;
    }

    public int getPreloadDuration() {
        return this.preloadDuration;
    }

    public int getPreloadFlags() {
        return this.preloadFlags;
    }

    public int getDefaultHints() {
        return this.defaultHints;
    }
}
