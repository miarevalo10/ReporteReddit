package org.jcodec.containers.mp4.boxes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.jcodec.codecs.wav.StringReader;
import org.jcodec.common.JCodecUtil;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.logging.Logger;

public class Header {
    private static final long MAX_UNSIGNED_INT = 4294967296L;
    private String fourcc;
    private boolean lng;
    private long size;

    public Header(String str) {
        this.fourcc = str;
    }

    public Header(String str, long j) {
        this.size = j;
        this.fourcc = str;
    }

    public Header(Header header) {
        this.fourcc = header.fourcc;
        this.size = header.size;
    }

    public Header(String str, long j, boolean z) {
        this(str, j);
        this.lng = z;
    }

    public static Header read(ByteBuffer byteBuffer) {
        long j = 0;
        while (byteBuffer.remaining() >= 4) {
            j = ((long) byteBuffer.getInt()) & 4294967295L;
            if (j != 0) {
                break;
            }
        }
        if (byteBuffer.remaining() >= 4) {
            if (j >= 8 || j == 1) {
                String readString = NIOUtils.readString(byteBuffer, 4);
                boolean z = false;
                if (j == 1) {
                    if (byteBuffer.remaining() >= 8) {
                        z = true;
                        j = byteBuffer.getLong();
                    } else {
                        byteBuffer = new StringBuilder("Broken atom of size ");
                        byteBuffer.append(j);
                        Logger.error(byteBuffer.toString());
                        return null;
                    }
                }
                return new Header(readString, j, z);
            }
        }
        byteBuffer = new StringBuilder("Broken atom of size ");
        byteBuffer.append(j);
        Logger.error(byteBuffer.toString());
        return null;
    }

    public void skip(InputStream inputStream) throws IOException {
        StringReader.sureSkip(inputStream, this.size - headerSize());
    }

    public long headerSize() {
        if (!this.lng) {
            if (this.size <= MAX_UNSIGNED_INT) {
                return 8;
            }
        }
        return 16;
    }

    public byte[] readContents(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; ((long) i) < this.size - headerSize(); i++) {
            byteArrayOutputStream.write(inputStream.read());
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String getFourcc() {
        return this.fourcc;
    }

    public long getBodySize() {
        return this.size - headerSize();
    }

    public void setBodySize(int i) {
        this.size = ((long) i) + headerSize();
    }

    public void write(ByteBuffer byteBuffer) {
        if (this.size > MAX_UNSIGNED_INT) {
            byteBuffer.putInt(1);
        } else {
            byteBuffer.putInt((int) this.size);
        }
        byteBuffer.put(JCodecUtil.asciiString(this.fourcc));
        if (this.size > MAX_UNSIGNED_INT) {
            byteBuffer.putLong(this.size);
        }
    }

    public void write(SeekableByteChannel seekableByteChannel) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(16);
        write(allocate);
        allocate.flip();
        seekableByteChannel.write(allocate);
    }

    public long getSize() {
        return this.size;
    }

    public int hashCode() {
        return 31 + (this.fourcc == null ? 0 : this.fourcc.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Header header = (Header) obj;
        if (this.fourcc == null) {
            if (header.fourcc != null) {
                return false;
            }
        } else if (this.fourcc.equals(header.fourcc) == null) {
            return false;
        }
        return true;
    }
}
