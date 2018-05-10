package org.jcodec.containers.mps;

import com.instabug.chat.model.Attachment;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.codecs.mpeg12.MPEGUtil;
import org.jcodec.codecs.mpeg12.bitstream.CopyrightExtension;
import org.jcodec.codecs.mpeg12.bitstream.GOPHeader;
import org.jcodec.codecs.mpeg12.bitstream.PictureCodingExtension;
import org.jcodec.codecs.mpeg12.bitstream.PictureDisplayExtension;
import org.jcodec.codecs.mpeg12.bitstream.PictureHeader;
import org.jcodec.codecs.mpeg12.bitstream.PictureSpatialScalableExtension;
import org.jcodec.codecs.mpeg12.bitstream.PictureTemporalScalableExtension;
import org.jcodec.codecs.mpeg12.bitstream.QuantMatrixExtension;
import org.jcodec.codecs.mpeg12.bitstream.SequenceDisplayExtension;
import org.jcodec.codecs.mpeg12.bitstream.SequenceExtension;
import org.jcodec.codecs.mpeg12.bitstream.SequenceHeader;
import org.jcodec.codecs.mpeg12.bitstream.SequenceScalableExtension;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.tools.MainUtils;
import org.jcodec.common.tools.MainUtils.ANSIColor;
import org.jcodec.containers.mps.MPSDemuxer.PESPacket;

public class MPSDump {
    private static final String DUMP_FROM = "dump-from";
    private static final String STOP_AT = "stop-at";
    protected ReadableByteChannel ch;

    static class C22101 extends HashMap<String, String> {
        C22101() {
            put(MPSDump.STOP_AT, "Stop reading at timestamp");
            put(MPSDump.DUMP_FROM, "Start dumping from timestamp");
        }
    }

    private static class MPEGVideoAnalyzer {
        private int f26816a;
        private ByteBuffer f26817b;
        private int f26818c;
        private int f26819d;
        private int f26820e;
        private int f26821f;
        private int f26822g;
        private PictureHeader f26823h;
        private SequenceHeader f26824i;
        private PictureCodingExtension f26825j;
        private SequenceExtension f26826k;

        private MPEGVideoAnalyzer() {
            this.f26816a = -1;
            this.f26817b = ByteBuffer.allocate(1048576);
        }

        private java.lang.String m28383a(java.lang.Object r8) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r7 = this;
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r1 = "<";
            r0.append(r1);
            r1 = r8.getClass();
            r1 = r1.getFields();
            r2 = 0;
        L_0x0013:
            r3 = r1.length;
            if (r2 >= r3) goto L_0x0095;
        L_0x0016:
            r3 = r1[r2];
            r3 = r3.getModifiers();
            r3 = java.lang.reflect.Modifier.isPublic(r3);
            if (r3 == 0) goto L_0x0091;
        L_0x0022:
            r3 = r1[r2];
            r3 = r3.getModifiers();
            r3 = java.lang.reflect.Modifier.isStatic(r3);
            if (r3 != 0) goto L_0x0091;
        L_0x002e:
            r3 = new java.lang.StringBuilder;
            r3.<init>();
            r4 = r1[r2];
            r4 = r4.getName();
            r5 = "([A-Z])";
            r6 = " $1";
            r4 = r4.replaceAll(r5, r6);
            r5 = "^ ";
            r6 = "";
            r4 = r4.replaceFirst(r5, r6);
            r4 = r4.toLowerCase();
            r3.append(r4);
            r4 = ": ";
            r3.append(r4);
            r3 = r3.toString();
            r0.append(r3);
            r3 = r1[r2];
            r3 = r3.getType();
            r3 = r3.isPrimitive();
            if (r3 == 0) goto L_0x0072;
        L_0x0068:
            r3 = r1[r2];	 Catch:{ IllegalArgumentException -> 0x0087, IllegalArgumentException -> 0x0087 }
            r3 = r3.get(r8);	 Catch:{ IllegalArgumentException -> 0x0087, IllegalArgumentException -> 0x0087 }
            r0.append(r3);	 Catch:{ IllegalArgumentException -> 0x0087, IllegalArgumentException -> 0x0087 }
            goto L_0x0087;	 Catch:{ IllegalArgumentException -> 0x0087, IllegalArgumentException -> 0x0087 }
        L_0x0072:
            r3 = r1[r2];	 Catch:{ IllegalArgumentException -> 0x0087, IllegalArgumentException -> 0x0087 }
            r3 = r3.get(r8);	 Catch:{ IllegalArgumentException -> 0x0087, IllegalArgumentException -> 0x0087 }
            if (r3 == 0) goto L_0x0082;	 Catch:{ IllegalArgumentException -> 0x0087, IllegalArgumentException -> 0x0087 }
        L_0x007a:
            r3 = r7.m28383a(r3);	 Catch:{ IllegalArgumentException -> 0x0087, IllegalArgumentException -> 0x0087 }
            r0.append(r3);	 Catch:{ IllegalArgumentException -> 0x0087, IllegalArgumentException -> 0x0087 }
            goto L_0x0087;	 Catch:{ IllegalArgumentException -> 0x0087, IllegalArgumentException -> 0x0087 }
        L_0x0082:
            r3 = "N/A";	 Catch:{ IllegalArgumentException -> 0x0087, IllegalArgumentException -> 0x0087 }
            r0.append(r3);	 Catch:{ IllegalArgumentException -> 0x0087, IllegalArgumentException -> 0x0087 }
        L_0x0087:
            r3 = r1.length;
            r3 = r3 + -1;
            if (r2 >= r3) goto L_0x0091;
        L_0x008c:
            r3 = ",";
            r0.append(r3);
        L_0x0091:
            r2 = r2 + 1;
            goto L_0x0013;
        L_0x0095:
            r8 = ">";
            r0.append(r8);
            r8 = r0.toString();
            return r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jcodec.containers.mps.MPSDump.MPEGVideoAnalyzer.a(java.lang.Object):java.lang.String");
        }

        static /* synthetic */ void m28384a(MPEGVideoAnalyzer mPEGVideoAnalyzer, ByteBuffer byteBuffer) {
            MPEGVideoAnalyzer mPEGVideoAnalyzer2 = mPEGVideoAnalyzer;
            int position = byteBuffer.position();
            int remaining = byteBuffer.remaining();
            while (byteBuffer.hasRemaining()) {
                mPEGVideoAnalyzer2.f26817b.put((byte) (mPEGVideoAnalyzer2.f26816a >> 24));
                mPEGVideoAnalyzer2.f26816a = (mPEGVideoAnalyzer2.f26816a << 8) | (byteBuffer.get() & 255);
                if (mPEGVideoAnalyzer2.f26816a >= 256 && mPEGVideoAnalyzer2.f26816a <= 440) {
                    mPEGVideoAnalyzer2.f26817b.flip();
                    mPEGVideoAnalyzer2.f26817b.getInt();
                    if (mPEGVideoAnalyzer2.f26818c != 0) {
                        if (mPEGVideoAnalyzer2.f26820e != mPEGVideoAnalyzer2.f26822g) {
                            mPEGVideoAnalyzer2.f26819d -= mPEGVideoAnalyzer2.f26821f;
                        }
                        int i = mPEGVideoAnalyzer2.f26818c;
                        int i2 = mPEGVideoAnalyzer2.f26819d;
                        ByteBuffer byteBuffer2 = mPEGVideoAnalyzer2.f26817b;
                        System.out.print(String.format("marker: 0x%02x [@%d] ( ", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
                        PrintStream printStream;
                        if (i == 256) {
                            mPEGVideoAnalyzer2.f26823h = PictureHeader.read(byteBuffer2);
                            mPEGVideoAnalyzer2.f26825j = null;
                            printStream = System.out;
                            StringBuilder stringBuilder = new StringBuilder("picture header <type:");
                            String str = mPEGVideoAnalyzer2.f26823h.picture_coding_type == 1 ? "I" : mPEGVideoAnalyzer2.f26823h.picture_coding_type == 2 ? "P" : "B";
                            stringBuilder.append(str);
                            stringBuilder.append(", temp_ref:");
                            stringBuilder.append(mPEGVideoAnalyzer2.f26823h.temporal_reference);
                            stringBuilder.append(Operation.GREATER_THAN);
                            printStream.print(MainUtils.color(stringBuilder.toString(), ANSIColor.BROWN, true));
                        } else if (i <= 431) {
                            System.out.print(MainUtils.color(String.format("slice @0x%02x", new Object[]{Integer.valueOf(i - 257)}), ANSIColor.BLACK, true));
                        } else if (i == 435) {
                            mPEGVideoAnalyzer2.f26823h = null;
                            mPEGVideoAnalyzer2.f26825j = null;
                            mPEGVideoAnalyzer2.f26826k = null;
                            mPEGVideoAnalyzer2.f26824i = SequenceHeader.read(byteBuffer2);
                            System.out.print(MainUtils.color("sequence header", ANSIColor.BLUE, true));
                        } else if (i == 437) {
                            BitReader bitReader = new BitReader(byteBuffer2);
                            int readNBit = bitReader.readNBit(4);
                            if (mPEGVideoAnalyzer2.f26823h == null) {
                                if (mPEGVideoAnalyzer2.f26824i == null) {
                                    printStream = System.out;
                                    r6 = new StringBuilder("dangling extension ");
                                    r6.append(readNBit);
                                    printStream.print(MainUtils.color(r6.toString(), ANSIColor.GREEN, true));
                                } else if (readNBit != 5) {
                                    switch (readNBit) {
                                        case 1:
                                            mPEGVideoAnalyzer2.f26826k = SequenceExtension.read(bitReader);
                                            SequenceExtension sequenceExtension = mPEGVideoAnalyzer2.f26826k;
                                            r5 = System.out;
                                            r6 = new StringBuilder("sequence extension ");
                                            r6.append(mPEGVideoAnalyzer2.m28383a(sequenceExtension));
                                            r5.print(MainUtils.color(r6.toString(), ANSIColor.GREEN, true));
                                            break;
                                        case 2:
                                            SequenceDisplayExtension read = SequenceDisplayExtension.read(bitReader);
                                            r5 = System.out;
                                            r6 = new StringBuilder("sequence display extension ");
                                            r6.append(mPEGVideoAnalyzer2.m28383a(read));
                                            r5.print(MainUtils.color(r6.toString(), ANSIColor.GREEN, true));
                                            break;
                                        default:
                                            printStream = System.out;
                                            r6 = new StringBuilder("extension ");
                                            r6.append(readNBit);
                                            printStream.print(MainUtils.color(r6.toString(), ANSIColor.GREEN, true));
                                            break;
                                    }
                                } else {
                                    SequenceScalableExtension read2 = SequenceScalableExtension.read(bitReader);
                                    r5 = System.out;
                                    r6 = new StringBuilder("sequence scalable extension ");
                                    r6.append(mPEGVideoAnalyzer2.m28383a(read2));
                                    r5.print(MainUtils.color(r6.toString(), ANSIColor.GREEN, true));
                                }
                            } else if (readNBit != 16) {
                                switch (readNBit) {
                                    case 3:
                                        QuantMatrixExtension read3 = QuantMatrixExtension.read(bitReader);
                                        r5 = System.out;
                                        r6 = new StringBuilder("quant matrix extension ");
                                        r6.append(mPEGVideoAnalyzer2.m28383a(read3));
                                        r5.print(MainUtils.color(r6.toString(), ANSIColor.GREEN, true));
                                        break;
                                    case 4:
                                        CopyrightExtension read4 = CopyrightExtension.read(bitReader);
                                        r5 = System.out;
                                        r6 = new StringBuilder("copyright extension ");
                                        r6.append(mPEGVideoAnalyzer2.m28383a(read4));
                                        r5.print(MainUtils.color(r6.toString(), ANSIColor.GREEN, true));
                                        break;
                                    default:
                                        switch (readNBit) {
                                            case 7:
                                                if (!(mPEGVideoAnalyzer2.f26824i == null || mPEGVideoAnalyzer2.f26825j == null)) {
                                                    PictureDisplayExtension read5 = PictureDisplayExtension.read(bitReader, mPEGVideoAnalyzer2.f26826k, mPEGVideoAnalyzer2.f26825j);
                                                    r5 = System.out;
                                                    r6 = new StringBuilder("picture display extension ");
                                                    r6.append(mPEGVideoAnalyzer2.m28383a(read5));
                                                    r5.print(MainUtils.color(r6.toString(), ANSIColor.GREEN, true));
                                                    break;
                                                }
                                            case 8:
                                                mPEGVideoAnalyzer2.f26825j = PictureCodingExtension.read(bitReader);
                                                PictureCodingExtension pictureCodingExtension = mPEGVideoAnalyzer2.f26825j;
                                                r5 = System.out;
                                                r6 = new StringBuilder("picture coding extension ");
                                                r6.append(mPEGVideoAnalyzer2.m28383a(pictureCodingExtension));
                                                r5.print(MainUtils.color(r6.toString(), ANSIColor.GREEN, true));
                                                break;
                                            case 9:
                                                PictureSpatialScalableExtension read6 = PictureSpatialScalableExtension.read(bitReader);
                                                r5 = System.out;
                                                r6 = new StringBuilder("picture spatial scalable extension ");
                                                r6.append(mPEGVideoAnalyzer2.m28383a(read6));
                                                r5.print(MainUtils.color(r6.toString(), ANSIColor.GREEN, true));
                                                break;
                                            default:
                                                printStream = System.out;
                                                r6 = new StringBuilder("extension ");
                                                r6.append(readNBit);
                                                printStream.print(MainUtils.color(r6.toString(), ANSIColor.GREEN, true));
                                                break;
                                        }
                                }
                            } else {
                                PictureTemporalScalableExtension read7 = PictureTemporalScalableExtension.read(bitReader);
                                r5 = System.out;
                                r6 = new StringBuilder("picture temporal scalable extension ");
                                r6.append(mPEGVideoAnalyzer2.m28383a(read7));
                                r5.print(MainUtils.color(r6.toString(), ANSIColor.GREEN, true));
                            }
                        } else if (i == 440) {
                            String stringBuilder2;
                            GOPHeader read8 = GOPHeader.read(byteBuffer2);
                            r5 = System.out;
                            r6 = new StringBuilder("group header <closed:");
                            r6.append(read8.isClosedGop());
                            r6.append(",broken link:");
                            r6.append(read8.isBrokenLink());
                            if (read8.getTimeCode() != null) {
                                StringBuilder stringBuilder3 = new StringBuilder(",timecode:");
                                stringBuilder3.append(read8.getTimeCode().toString());
                                stringBuilder2 = stringBuilder3.toString();
                            } else {
                                stringBuilder2 = "";
                            }
                            r6.append(stringBuilder2);
                            r6.append(Operation.GREATER_THAN);
                            r5.print(MainUtils.color(r6.toString(), ANSIColor.MAGENTA, true));
                        } else {
                            System.out.print("--");
                        }
                        System.out.println(" )");
                    }
                    mPEGVideoAnalyzer2.f26817b.clear();
                    mPEGVideoAnalyzer2.f26818c = mPEGVideoAnalyzer2.f26816a;
                    mPEGVideoAnalyzer2.f26819d = (byteBuffer.position() - 4) - position;
                    mPEGVideoAnalyzer2.f26820e = mPEGVideoAnalyzer2.f26822g;
                }
            }
            mPEGVideoAnalyzer2.f26822g++;
            mPEGVideoAnalyzer2.f26821f = remaining;
        }
    }

    public MPSDump(ReadableByteChannel readableByteChannel) {
        this.ch = readableByteChannel;
    }

    public static void main(String[] strArr) throws IOException {
        ReadableByteChannel readableByteChannel = null;
        try {
            strArr = MainUtils.parseArguments(strArr);
            if (strArr.args.length <= 0) {
                MainUtils.printHelp(new C22101(), "file name");
                NIOUtils.closeQuietly(null);
                return;
            }
            ReadableByteChannel readableFileChannel = NIOUtils.readableFileChannel(new File(strArr.args[0]));
            try {
                new MPSDump(readableFileChannel).dump(strArr.getLongFlag(DUMP_FROM), strArr.getLongFlag(STOP_AT));
                NIOUtils.closeQuietly(readableFileChannel);
            } catch (Throwable th) {
                strArr = th;
                readableByteChannel = readableFileChannel;
                NIOUtils.closeQuietly(readableByteChannel);
                throw strArr;
            }
        } catch (Throwable th2) {
            strArr = th2;
            NIOUtils.closeQuietly(readableByteChannel);
            throw strArr;
        }
    }

    public void dump(Long l, Long l2) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(1048576);
        long j = 0;
        int i = 0;
        MPEGVideoAnalyzer mPEGVideoAnalyzer = null;
        PESPacket pESPacket = mPEGVideoAnalyzer;
        while (true) {
            j -= (long) allocate.position();
            fillBuffer(allocate);
            allocate.flip();
            if (allocate.remaining() >= 4) {
                j += (long) allocate.remaining();
                while (true) {
                    ByteBuffer pesPayload;
                    if (pESPacket == null || pESPacket.length <= 0) {
                        pesPayload = getPesPayload(allocate);
                    } else {
                        int i2 = (pESPacket.length - i) + 6;
                        pesPayload = i2 <= allocate.remaining() ? NIOUtils.read(allocate, i2) : null;
                    }
                    if (pesPayload == null) {
                        break;
                    }
                    if (pESPacket != null) {
                        logPes(pESPacket, i, pesPayload);
                    }
                    if (mPEGVideoAnalyzer != null && pESPacket != null && pESPacket.streamId >= JpegConst.APP0 && pESPacket.streamId <= JpegConst.APPF) {
                        MPEGVideoAnalyzer.m28384a(mPEGVideoAnalyzer, pesPayload);
                    }
                    if (allocate.remaining() < 32) {
                        break;
                    }
                    skipToNextPES(allocate);
                    if (allocate.remaining() < 32) {
                        break;
                    }
                    i = allocate.position();
                    pESPacket = MPSUtils.readPESHeader(allocate, j - ((long) allocate.remaining()));
                    i = allocate.position() - i;
                    if (l != null && pESPacket.pts >= l.longValue()) {
                        mPEGVideoAnalyzer = new MPEGVideoAnalyzer();
                    }
                    if (l2 != null && pESPacket.pts >= l2.longValue()) {
                        return;
                    }
                }
                pESPacket = null;
                allocate = transferRemainder(allocate);
            } else {
                return;
            }
        }
    }

    protected int fillBuffer(ByteBuffer byteBuffer) throws IOException {
        return this.ch.read(byteBuffer);
    }

    protected void logPes(PESPacket pESPacket, int i, ByteBuffer byteBuffer) {
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(pESPacket.streamId);
        stringBuilder.append("(");
        stringBuilder.append(pESPacket.streamId >= JpegConst.APP0 ? Attachment.TYPE_VIDEO : Attachment.TYPE_AUDIO);
        stringBuilder.append(") [");
        stringBuilder.append(pESPacket.pos);
        stringBuilder.append(", ");
        stringBuilder.append(byteBuffer.remaining() + i);
        stringBuilder.append("], pts: ");
        stringBuilder.append(pESPacket.pts);
        stringBuilder.append(", dts: ");
        stringBuilder.append(pESPacket.dts);
        printStream.println(stringBuilder.toString());
    }

    private ByteBuffer transferRemainder(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.clear();
        while (byteBuffer.hasRemaining()) {
            duplicate.put(byteBuffer.get());
        }
        return duplicate;
    }

    private static void skipToNextPES(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining()) {
            int i = byteBuffer.duplicate().getInt();
            if (i < MPSUtils.PRIVATE_1 || i > 511 || i == 446) {
                byteBuffer.getInt();
                MPEGUtil.gotoNextMarker(byteBuffer);
            } else {
                return;
            }
        }
    }

    private static ByteBuffer getPesPayload(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        ByteBuffer duplicate2 = byteBuffer.duplicate();
        while (duplicate.hasRemaining()) {
            if (duplicate.duplicate().getInt() >= 441) {
                duplicate2.limit(duplicate.position());
                byteBuffer.position(duplicate.position());
                return duplicate2;
            }
            duplicate.getInt();
            MPEGUtil.gotoNextMarker(duplicate);
        }
        return null;
    }
}
