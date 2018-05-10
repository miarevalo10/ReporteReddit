package org.jcodec.testing;

import com.mp4parser.iso14496.part15.AvcConfigurationBox;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.codecs.h264.H264Decoder;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.h264.mp4.AvcCBox;
import org.jcodec.common.FileChannelWrapper;
import org.jcodec.common.IOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.Picture;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.LeafBox;
import org.jcodec.containers.mp4.boxes.VideoSampleEntry;
import org.jcodec.containers.mp4.demuxer.MP4Demuxer;

public class TestTool {
    private File coded = File.createTempFile("seq", ".264");
    private File decoded = File.createTempFile("seq_dec", ".yuv");
    private File errs;
    private String jm;
    private File jmconf = File.createTempFile("ldecod", ".conf");

    public TestTool(String str, String str2) throws IOException {
        this.jm = str;
        this.errs = new File(str2);
        prepareJMConf();
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length != 3) {
            System.out.println("JCodec h.264 test tool");
            System.out.println("Syntax: <path to ldecod> <movie file> <foder for errors>");
            return;
        }
        new TestTool(strArr[0], strArr[2]).doIt(strArr[1]);
    }

    private void doIt(String str) throws Exception {
        SeekableByteChannel seekableByteChannel = null;
        SeekableByteChannel fileChannelWrapper;
        try {
            fileChannelWrapper = new FileChannelWrapper(new FileInputStream(str).getChannel());
            try {
                Packet nextFrame;
                str = new MP4Demuxer(fileChannelWrapper);
                H264Decoder h264Decoder = new H264Decoder();
                str = str.getVideoTrack();
                int i = 0;
                VideoSampleEntry videoSampleEntry = (VideoSampleEntry) str.getSampleEntries()[0];
                AvcCBox avcCBox = (AvcCBox) Box.as(AvcCBox.class, (LeafBox) Box.findFirst(videoSampleEntry, LeafBox.class, AvcConfigurationBox.TYPE));
                ByteBuffer allocate = ByteBuffer.allocate(12533760);
                h264Decoder.addSps(avcCBox.getSpsList());
                h264Decoder.addPps(avcCBox.getPpsList());
                str.gotoFrame(2600);
                do {
                    nextFrame = str.nextFrame();
                    if (nextFrame == null) {
                        break;
                    }
                } while (!nextFrame.isKeyFrame());
                str.gotoFrame(nextFrame.getFrameNo());
                List arrayList = new ArrayList();
                int frameCount = (int) str.getFrameCount();
                int i2 = 2600;
                while (true) {
                    Packet nextFrame2 = str.nextFrame();
                    if (nextFrame2 == null) {
                        break;
                    }
                    List splitMOVPacket = H264Utils.splitMOVPacket(nextFrame2.getData(), avcCBox);
                    allocate.clear();
                    H264Utils.joinNALUnits(splitMOVPacket, allocate);
                    allocate.flip();
                    if (H264Utils.idrSlice(allocate)) {
                        if (seekableByteChannel != null) {
                            seekableByteChannel.close();
                            runJMCompareResults(arrayList, i);
                            arrayList = new ArrayList();
                            i = i2;
                        }
                        SeekableByteChannel fileChannelWrapper2 = new FileChannelWrapper(new FileOutputStream(this.coded).getChannel());
                        try {
                            H264Utils.saveStreamParams(avcCBox, fileChannelWrapper2);
                            seekableByteChannel = fileChannelWrapper2;
                        } catch (Throwable th) {
                            str = th;
                            seekableByteChannel = fileChannelWrapper2;
                        }
                    }
                    seekableByteChannel.write(allocate);
                    arrayList.add(h264Decoder.decodeFrame(splitMOVPacket, Picture.create((videoSampleEntry.getWidth() + 15) & -16, (videoSampleEntry.getHeight() + 15) & -16, ColorSpace.YUV420).getData()));
                    if (i2 % 500 == 0) {
                        PrintStream printStream = System.out;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append((i2 * 100) / frameCount);
                        stringBuilder.append(Operation.MOD);
                        printStream.println(stringBuilder.toString());
                    }
                    i2++;
                }
                if (arrayList.size() > null) {
                    runJMCompareResults(arrayList, i);
                }
                fileChannelWrapper.close();
                if (seekableByteChannel != null) {
                    seekableByteChannel.close();
                }
            } catch (Throwable th2) {
                str = th2;
            }
        } catch (Throwable th3) {
            str = th3;
            fileChannelWrapper = null;
            if (fileChannelWrapper != null) {
                fileChannelWrapper.close();
            }
            if (seekableByteChannel != null) {
                seekableByteChannel.close();
            }
            throw str;
        }
    }

    private void runJMCompareResults(java.util.List<org.jcodec.common.model.Picture> r7, int r8) throws java.lang.Exception {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = java.lang.Runtime.getRuntime();	 Catch:{ Exception -> 0x008c }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x008c }
        r1.<init>();	 Catch:{ Exception -> 0x008c }
        r2 = r6.jm;	 Catch:{ Exception -> 0x008c }
        r1.append(r2);	 Catch:{ Exception -> 0x008c }
        r2 = " -d ";	 Catch:{ Exception -> 0x008c }
        r1.append(r2);	 Catch:{ Exception -> 0x008c }
        r2 = r6.jmconf;	 Catch:{ Exception -> 0x008c }
        r2 = r2.getAbsolutePath();	 Catch:{ Exception -> 0x008c }
        r1.append(r2);	 Catch:{ Exception -> 0x008c }
        r1 = r1.toString();	 Catch:{ Exception -> 0x008c }
        r0 = r0.exec(r1);	 Catch:{ Exception -> 0x008c }
        r0.waitFor();	 Catch:{ Exception -> 0x008c }
        r0 = r6.decoded;	 Catch:{ Exception -> 0x008c }
        r0 = org.jcodec.common.NIOUtils.fetchFrom(r0);	 Catch:{ Exception -> 0x008c }
        r7 = r7.iterator();	 Catch:{ Exception -> 0x008c }
    L_0x0031:
        r1 = r7.hasNext();	 Catch:{ Exception -> 0x008c }
        if (r1 == 0) goto L_0x008b;	 Catch:{ Exception -> 0x008c }
    L_0x0037:
        r1 = r7.next();	 Catch:{ Exception -> 0x008c }
        r1 = (org.jcodec.common.model.Picture) r1;	 Catch:{ Exception -> 0x008c }
        r1 = r1.cropped();	 Catch:{ Exception -> 0x008c }
        r2 = 0;	 Catch:{ Exception -> 0x008c }
        r3 = r1.getPlaneWidth(r2);	 Catch:{ Exception -> 0x008c }
        r4 = r1.getPlaneHeight(r2);	 Catch:{ Exception -> 0x008c }
        r3 = r3 * r4;	 Catch:{ Exception -> 0x008c }
        r3 = org.jcodec.common.JCodecUtil.getAsIntArray(r0, r3);	 Catch:{ Exception -> 0x008c }
        r2 = r1.getPlaneData(r2);	 Catch:{ Exception -> 0x008c }
        r2 = java.util.Arrays.equals(r3, r2);	 Catch:{ Exception -> 0x008c }
        r3 = 1;	 Catch:{ Exception -> 0x008c }
        r4 = r1.getPlaneWidth(r3);	 Catch:{ Exception -> 0x008c }
        r5 = r1.getPlaneHeight(r3);	 Catch:{ Exception -> 0x008c }
        r4 = r4 * r5;	 Catch:{ Exception -> 0x008c }
        r4 = org.jcodec.common.JCodecUtil.getAsIntArray(r0, r4);	 Catch:{ Exception -> 0x008c }
        r3 = r1.getPlaneData(r3);	 Catch:{ Exception -> 0x008c }
        r3 = java.util.Arrays.equals(r4, r3);	 Catch:{ Exception -> 0x008c }
        r2 = r2 & r3;	 Catch:{ Exception -> 0x008c }
        r3 = 2;	 Catch:{ Exception -> 0x008c }
        r4 = r1.getPlaneWidth(r3);	 Catch:{ Exception -> 0x008c }
        r5 = r1.getPlaneHeight(r3);	 Catch:{ Exception -> 0x008c }
        r4 = r4 * r5;	 Catch:{ Exception -> 0x008c }
        r4 = org.jcodec.common.JCodecUtil.getAsIntArray(r0, r4);	 Catch:{ Exception -> 0x008c }
        r1 = r1.getPlaneData(r3);	 Catch:{ Exception -> 0x008c }
        r1 = java.util.Arrays.equals(r4, r1);	 Catch:{ Exception -> 0x008c }
        r1 = r1 & r2;	 Catch:{ Exception -> 0x008c }
        if (r1 != 0) goto L_0x0031;	 Catch:{ Exception -> 0x008c }
    L_0x0087:
        r6.diff(r8);	 Catch:{ Exception -> 0x008c }
        goto L_0x0031;
    L_0x008b:
        return;
    L_0x008c:
        r6.diff(r8);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.testing.TestTool.runJMCompareResults(java.util.List, int):void");
    }

    private void diff(int i) {
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append(": DIFF!!!");
        printStream.println(stringBuilder.toString());
        this.coded.renameTo(new File(this.errs, String.format("seq%08d.264", new Object[]{Integer.valueOf(i)})));
        this.decoded.renameTo(new File(this.errs, String.format("seq%08d_dec.yuv", new Object[]{Integer.valueOf(i)})));
    }

    private void prepareJMConf() throws IOException {
        Closeable resourceAsStream;
        Throwable th;
        try {
            resourceAsStream = getClass().getClassLoader().getResourceAsStream("org/jcodec/testing/jm.conf");
            try {
                IOUtils.writeStringToFile(this.jmconf, IOUtils.toString(resourceAsStream).replace("%input_file%", this.coded.getAbsolutePath()).replace("%output_file%", this.decoded.getAbsolutePath()));
                IOUtils.closeQuietly(resourceAsStream);
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeQuietly(resourceAsStream);
                throw th;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            resourceAsStream = null;
            th = th4;
            IOUtils.closeQuietly(resourceAsStream);
            throw th;
        }
    }
}
