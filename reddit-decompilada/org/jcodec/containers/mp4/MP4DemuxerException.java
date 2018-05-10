package org.jcodec.containers.mp4;

public class MP4DemuxerException extends Exception {
    public MP4DemuxerException(String str, Throwable th) {
        super(str, th);
    }

    public MP4DemuxerException(String str) {
        super(str);
    }

    public MP4DemuxerException(Throwable th) {
        super(th);
    }
}
