package org.jcodec.testing;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.jcodec.codecs.h264.H264Decoder;
import org.jcodec.codecs.h264.MappedH264ES;
import org.jcodec.common.JCodecUtil;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.Picture;

public class VerifyTool {

    class C22181 implements FilenameFilter {
        final /* synthetic */ VerifyTool f26861a;

        C22181(VerifyTool verifyTool) {
            this.f26861a = verifyTool;
        }

        public boolean accept(File file, String str) {
            return str.endsWith(".264");
        }
    }

    public static void main(String[] strArr) throws IOException {
        if (strArr.length != 1) {
            System.out.println("Syntax: <error folder location>");
        } else {
            new VerifyTool().doIt(strArr[0]);
        }
    }

    private void doIt(String str) throws IOException {
        PrintStream printStream;
        StringBuilder stringBuilder;
        str = new File(str).listFiles(new C22181(this));
        for (File file : str) {
            File file2 = new File(file.getParentFile(), file.getName().replaceAll(".264$", "_dec.yuv"));
            if (file.exists() && file2.exists()) {
                try {
                    if (test(file, file2)) {
                        printStream = System.out;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(file.getAbsolutePath());
                        stringBuilder.append(" -- FIXED");
                        printStream.println(stringBuilder.toString());
                        file.delete();
                        file2.delete();
                    } else {
                        PrintStream printStream2 = System.out;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(file.getAbsolutePath());
                        stringBuilder2.append(" -- NOT FIXED!!!!");
                        printStream2.println(stringBuilder2.toString());
                    }
                } catch (Throwable th) {
                    printStream = System.out;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(file.getAbsolutePath());
                    stringBuilder.append(" -- ERROR: ");
                    stringBuilder.append(th.getMessage());
                    printStream.println(stringBuilder.toString());
                }
            }
        }
    }

    private boolean test(File file, File file2) throws IOException {
        MappedH264ES mappedH264ES = new MappedH264ES(NIOUtils.fetchFrom(file));
        file = Picture.create(1920, 1088, ColorSpace.YUV420);
        H264Decoder h264Decoder = new H264Decoder();
        ByteBuffer fetchFrom = NIOUtils.fetchFrom(file2);
        ByteBuffer read;
        int i;
        Picture createCompatible;
        do {
            Packet nextFrame = mappedH264ES.nextFrame();
            if (nextFrame == null) {
                return true;
            }
            Picture cropped = h264Decoder.decodeFrame(nextFrame.getData(), file.getData()).cropped();
            createCompatible = cropped.createCompatible();
            createCompatible.copyFrom(cropped);
            int width = createCompatible.getWidth() * createCompatible.getHeight();
            i = width >> 2;
            read = NIOUtils.read(fetchFrom, (width + i) + i);
            if (!Arrays.equals(JCodecUtil.getAsIntArray(read, width), createCompatible.getPlaneData(0)) || !Arrays.equals(JCodecUtil.getAsIntArray(read, i), createCompatible.getPlaneData(1))) {
                return false;
            }
        } while (Arrays.equals(JCodecUtil.getAsIntArray(read, i), createCompatible.getPlaneData(2)));
        return false;
    }
}
