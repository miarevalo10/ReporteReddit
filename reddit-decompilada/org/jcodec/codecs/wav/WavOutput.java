package org.jcodec.codecs.wav;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import org.jcodec.audio.AudioSink;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.AudioUtil;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;

public class WavOutput implements Closeable {
    protected AudioFormat format;
    protected WavHeader header;
    protected SeekableByteChannel out;
    protected int written;

    public static class File extends WavOutput {
        public File(java.io.File file, AudioFormat audioFormat) throws IOException {
            super(NIOUtils.writableFileChannel(file), audioFormat);
        }

        public void close() throws IOException {
            super.close();
            NIOUtils.closeQuietly(this.out);
        }
    }

    public static class Sink implements Closeable, AudioSink {
        private WavOutput out;

        public Sink(WavOutput wavOutput) {
            this.out = wavOutput;
        }

        public Sink(java.io.File file, AudioFormat audioFormat) throws IOException {
            this(new File(file, audioFormat));
        }

        public Sink(SeekableByteChannel seekableByteChannel, AudioFormat audioFormat) throws IOException {
            this(new WavOutput(seekableByteChannel, audioFormat));
        }

        public void write(FloatBuffer floatBuffer) throws IOException {
            ByteBuffer allocate = ByteBuffer.allocate(this.out.format.samplesToBytes(floatBuffer.remaining()));
            AudioUtil.fromFloat(floatBuffer, this.out.format, allocate);
            allocate.flip();
            this.out.write(allocate);
        }

        public void write(int[] iArr, int i) throws IOException {
            i = Math.min(iArr.length, i);
            ByteBuffer allocate = ByteBuffer.allocate(this.out.format.samplesToBytes(i));
            AudioUtil.fromInt(iArr, i, this.out.format, allocate);
            allocate.flip();
            this.out.write(allocate);
        }

        public void close() throws IOException {
            this.out.close();
        }
    }

    public WavOutput(SeekableByteChannel seekableByteChannel, AudioFormat audioFormat) throws IOException {
        this.out = seekableByteChannel;
        this.format = audioFormat;
        this.header = new WavHeader(audioFormat, 0);
        this.header.write(seekableByteChannel);
    }

    public void write(ByteBuffer byteBuffer) throws IOException {
        this.written += this.out.write(byteBuffer);
    }

    public void close() throws IOException {
        this.out.position(0);
        new WavHeader(this.format, this.format.bytesToFrames(this.written)).write(this.out);
        NIOUtils.closeQuietly(this.out);
    }
}
