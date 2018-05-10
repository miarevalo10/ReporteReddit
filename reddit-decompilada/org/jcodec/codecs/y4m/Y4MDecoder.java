package org.jcodec.codecs.y4m;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.channels.ReadableByteChannel;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.StringUtils;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Rational;
import org.jcodec.common.model.Size;

public class Y4MDecoder {
    private int bufSize;
    private Rational fps;
    private int height;
    private String invalidFormat;
    private FileChannel is;
    private int width;

    public Y4MDecoder(SeekableByteChannel seekableByteChannel) throws IOException {
        ByteBuffer fetchFrom = NIOUtils.fetchFrom((ReadableByteChannel) seekableByteChannel, (int) MPEGConst.CODE_END);
        String[] split = StringUtils.split(readLine(fetchFrom), ' ');
        if ("YUV4MPEG2".equals(split[0])) {
            String find = find(split, 'C');
            if (find == null || find.startsWith("420")) {
                this.width = Integer.parseInt(find(split, 'W'));
                this.height = Integer.parseInt(find(split, 'H'));
                String find2 = find(split, 'F');
                if (find2 != null) {
                    split = StringUtils.split(find2, ':');
                    this.fps = new Rational(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                }
                seekableByteChannel.position((long) fetchFrom.position());
                this.bufSize = (this.width * this.height) * 2;
                return;
            }
            this.invalidFormat = "Only yuv420p is supported";
            return;
        }
        this.invalidFormat = "Not yuv4mpeg stream";
    }

    public Picture nextFrame(int[][] iArr) throws IOException {
        if (this.invalidFormat != null) {
            StringBuilder stringBuilder = new StringBuilder("Invalid input: ");
            stringBuilder.append(this.invalidFormat);
            throw new RuntimeException(stringBuilder.toString());
        }
        long position = this.is.position();
        iArr = NIOUtils.fetchFrom(this.is, (int) MPEGConst.CODE_END);
        String readLine = readLine(iArr);
        if (readLine != null) {
            if (readLine.startsWith("FRAME")) {
                ByteBuffer map = this.is.map(MapMode.READ_ONLY, ((long) iArr.position()) + position, (long) this.bufSize);
                this.is.position((position + ((long) iArr.position())) + ((long) this.bufSize));
                iArr = Picture.create(this.width, this.height, ColorSpace.YUV420);
                copy(map, iArr.getPlaneData(0));
                copy(map, iArr.getPlaneData(1));
                copy(map, iArr.getPlaneData(2));
                return iArr;
            }
        }
        return null;
    }

    void copy(ByteBuffer byteBuffer, int[] iArr) {
        int i = 0;
        while (byteBuffer.hasRemaining()) {
            iArr[i] = byteBuffer.get() & 255;
            i++;
        }
    }

    private static String find(String[] strArr, char c) {
        for (String str : strArr) {
            if (str.charAt(0) == c) {
                return str.substring(1);
            }
        }
        return null;
    }

    private static String readLine(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        while (byteBuffer.hasRemaining()) {
            if (byteBuffer.get() == (byte) 10) {
                break;
            }
        }
        if (byteBuffer.hasRemaining()) {
            duplicate.limit(byteBuffer.position() - 1);
        }
        return new String(NIOUtils.toArray(duplicate));
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Rational getFps() {
        return this.fps;
    }

    public Size getSize() {
        return new Size(this.width, this.height);
    }
}
