package org.jcodec.codecs.wav;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.channels.ReadableByteChannel;
import org.jcodec.audio.AudioSource;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.AudioUtil;
import org.jcodec.common.NIOUtils;

public class WavInput implements Closeable {
    protected AudioFormat format = this.header.getFormat();
    protected WavHeader header;
    protected ReadableByteChannel in;
    protected byte[] prevBuf;

    public static class File extends WavInput {
        public File(java.io.File file) throws IOException {
            super(NIOUtils.readableFileChannel(file));
        }

        public void close() throws IOException {
            super.close();
            this.in.close();
        }
    }

    public static class Source implements Closeable, AudioSource {
        private AudioFormat format;
        private int pos;
        private WavInput src;

        public Source(WavInput wavInput) {
            this.src = wavInput;
            this.format = wavInput.getFormat();
        }

        public Source(ReadableByteChannel readableByteChannel) throws IOException {
            this(new WavInput(readableByteChannel));
        }

        public Source(java.io.File file) throws IOException {
            this(new File(file));
        }

        public AudioFormat getFormat() {
            return this.src.getFormat();
        }

        public void close() throws IOException {
            this.src.close();
        }

        public int read(int[] iArr, int i) throws IOException {
            i = ByteBuffer.allocate(this.format.samplesToBytes(Math.min(i, iArr.length)));
            int read = this.src.read(i);
            i.flip();
            AudioUtil.toInt(this.format, i, iArr);
            return this.format.bytesToFrames(read);
        }

        public int read(FloatBuffer floatBuffer) throws IOException {
            ByteBuffer allocate = ByteBuffer.allocate(this.format.samplesToBytes(floatBuffer.remaining()));
            int read = this.src.read(allocate);
            if (read == -1) {
                return -1;
            }
            allocate.flip();
            AudioUtil.toFloat(this.format, allocate, floatBuffer);
            floatBuffer = this.format.bytesToFrames(read);
            this.pos += floatBuffer;
            return floatBuffer;
        }
    }

    public WavInput(ReadableByteChannel readableByteChannel) throws IOException {
        this.header = WavHeader.read(readableByteChannel);
        this.in = readableByteChannel;
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        return NIOUtils.read(this.in, byteBuffer, this.format.framesToBytes(this.format.bytesToFrames(byteBuffer.remaining())));
    }

    public void close() throws IOException {
        this.in.close();
    }

    public WavHeader getHeader() {
        return this.header;
    }

    public AudioFormat getFormat() {
        return this.format;
    }
}
