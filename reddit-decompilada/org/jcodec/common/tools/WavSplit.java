package org.jcodec.common.tools;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import org.jcodec.codecs.wav.WavHeader;
import org.jcodec.common.Assert;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.AudioUtil;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.tools.MainUtils.Cmd;

public class WavSplit {

    static class C22061 extends HashMap<String, String> {
        C22061() {
            put("pattern", "Output file name pattern, i.e. out%02d.wav");
        }
    }

    public static void main(String[] strArr) throws Exception {
        Cmd parseArguments = MainUtils.parseArguments(strArr);
        if (parseArguments.argsLength() <= 0) {
            MainUtils.printHelp(new C22061(), "filename.wav");
            System.exit(-1);
        }
        int i = 0;
        File file = new File(strArr[0]);
        strArr = parseArguments.getStringFlag("pattern", "c%02d.wav");
        WavHeader read = WavHeader.read(file);
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder("WAV: ");
        stringBuilder.append(read.getFormat());
        printStream.println(stringBuilder.toString());
        Assert.assertEquals(2, read.fmt.numChannels);
        int i2 = read.dataOffset;
        ReadableByteChannel readableFileChannel = NIOUtils.readableFileChannel(file);
        readableFileChannel.position((long) i2);
        i2 = read.getFormat().getChannels();
        SeekableByteChannel[] seekableByteChannelArr = new SeekableByteChannel[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            seekableByteChannelArr[i3] = NIOUtils.writableFileChannel(new File(file.getParentFile(), String.format(strArr, new Object[]{Integer.valueOf(i3)})));
            WavHeader.copyWithChannels(read, 1).write(seekableByteChannelArr[i3]);
        }
        copy(read.getFormat(), readableFileChannel, seekableByteChannelArr);
        while (i < i2) {
            seekableByteChannelArr[i].close();
            i++;
        }
    }

    private static void copy(AudioFormat audioFormat, ReadableByteChannel readableByteChannel, SeekableByteChannel[] seekableByteChannelArr) throws IOException {
        ByteBuffer[] byteBufferArr = new ByteBuffer[seekableByteChannelArr.length];
        for (int i = 0; i < seekableByteChannelArr.length; i++) {
            byteBufferArr[i] = ByteBuffer.allocate(audioFormat.framesToBytes(4096));
        }
        ByteBuffer allocate = ByteBuffer.allocate(audioFormat.framesToBytes(4096) * seekableByteChannelArr.length);
        while (readableByteChannel.read(allocate) != -1) {
            allocate.flip();
            AudioUtil.deinterleave(audioFormat, allocate, byteBufferArr);
            allocate.clear();
            for (int i2 = 0; i2 < seekableByteChannelArr.length; i2++) {
                byteBufferArr[i2].flip();
                seekableByteChannelArr[i2].write(byteBufferArr[i2]);
                byteBufferArr[i2].clear();
            }
        }
    }
}
