package org.jcodec.containers.mkv.boxes;

import java.nio.ByteBuffer;
import java.util.Date;

public class EbmlDate extends EbmlSint {
    private static final int MILISECONDS_IN_A_SECOND = 1000;
    public static long MILISECONDS_SINCE_UNIX_EPOCH_START = 978307200;
    private static final int NANOSECONDS_IN_A_MILISECOND = 1000000;
    private static final int NANOSECONDS_IN_A_SECOND = 1000000000;

    public EbmlDate(byte[] bArr) {
        super(bArr);
    }

    public void setDate(Date date) {
        setMiliseconds(date.getTime());
    }

    public Date getDate() {
        return new Date((get() / 1000000) + MILISECONDS_SINCE_UNIX_EPOCH_START);
    }

    private void setMiliseconds(long j) {
        set((j - MILISECONDS_SINCE_UNIX_EPOCH_START) * 1000000);
    }

    public void set(long j) {
        this.data = ByteBuffer.allocate(8);
        this.data.putLong(j);
        this.data.flip();
    }
}
