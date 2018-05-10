package org.jcodec.movtool.streaming;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import org.jcodec.common.NIOUtils;

public class MovieRange extends InputStream {
    private ByteBuffer chunkData;
    private int chunkNo;
    private VirtualMovie movie;
    private long remaining;

    public MovieRange(VirtualMovie virtualMovie, long j, long j2) throws IOException {
        if (j2 < j) {
            throw new IllegalArgumentException("from < to");
        }
        this.movie = virtualMovie;
        virtualMovie = virtualMovie.getPacketAt(j);
        this.remaining = (j2 - j) + 1;
        if (virtualMovie != null) {
            this.chunkData = checkDataLen(virtualMovie.getData(), virtualMovie.getDataLen());
            this.chunkNo = virtualMovie.getNo();
            NIOUtils.skip(this.chunkData, (int) (j - virtualMovie.getPos()));
        }
    }

    static ByteBuffer checkDataLen(ByteBuffer byteBuffer, int i) throws IOException {
        if (byteBuffer == null) {
            byteBuffer = System.err;
            StringBuilder stringBuilder = new StringBuilder("WARN: packet expected data len != actual data len ");
            stringBuilder.append(i);
            stringBuilder.append(" != 0");
            byteBuffer.println(stringBuilder.toString());
            return ByteBuffer.allocate(i);
        }
        if (byteBuffer.remaining() != i) {
            PrintStream printStream = System.err;
            StringBuilder stringBuilder2 = new StringBuilder("WARN: packet expected data len != actual data len ");
            stringBuilder2.append(i);
            stringBuilder2.append(" != ");
            stringBuilder2.append(byteBuffer.remaining());
            printStream.println(stringBuilder2.toString());
            i = Math.max(0, i);
            if (i >= byteBuffer.remaining()) {
                if (byteBuffer.capacity() - byteBuffer.position() < i) {
                    i = ByteBuffer.allocate(i);
                    i.put(byteBuffer);
                    i.clear();
                    return i;
                }
            }
            byteBuffer.limit(byteBuffer.position() + i);
        }
        return byteBuffer;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        tryFetch();
        if (this.chunkData != null) {
            if (this.remaining != 0) {
                i2 = (int) Math.min(this.remaining, (long) i2);
                int i3 = 0;
                while (i2 > 0) {
                    int min = Math.min(this.chunkData.remaining(), i2);
                    this.chunkData.get(bArr, i, min);
                    i3 += min;
                    i2 -= min;
                    i += min;
                    tryFetch();
                    if (this.chunkData == null) {
                        break;
                    }
                }
                this.remaining -= (long) i3;
                return i3;
            }
        }
        return -1;
    }

    private void tryFetch() throws IOException {
        if (this.chunkData == null || !this.chunkData.hasRemaining()) {
            MovieSegment packetByNo = this.movie.getPacketByNo(this.chunkNo + 1);
            if (packetByNo != null) {
                this.chunkData = checkDataLen(packetByNo.getData(), packetByNo.getDataLen());
                this.chunkNo = packetByNo.getNo();
                return;
            }
            this.chunkData = null;
        }
    }

    public int read() throws IOException {
        tryFetch();
        if (this.chunkData != null) {
            if (this.remaining != 0) {
                this.remaining--;
                return this.chunkData.get() & 255;
            }
        }
        return -1;
    }
}
