package org.jcodec.containers.mps;

import com.instabug.chat.model.Attachment;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.common.Assert;
import org.jcodec.common.IntArrayList;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.tools.MainUtils;
import org.jcodec.containers.mps.MPSDemuxer.PESPacket;
import org.jcodec.containers.mps.psi.PATSection;
import org.jcodec.containers.mps.psi.PMTSection;
import org.jcodec.containers.mps.psi.PMTSection.PMTStream;

public class MTSDump extends MPSDump {
    private static final String DUMP_FROM = "dump-from";
    private static final String STOP_AT = "stop-at";
    private ByteBuffer buf = ByteBuffer.allocate(192512);
    private int globalPayload;
    private int guid;
    private int[] nums;
    private int[] payloads;
    private int[] prevNums;
    private int[] prevPayloads;
    private ByteBuffer tsBuf = ByteBuffer.allocate(188);
    private int tsNo;

    static class C22111 extends HashMap<String, String> {
        C22111() {
            put(MTSDump.STOP_AT, "Stop reading at timestamp");
            put(MTSDump.DUMP_FROM, "Start dumping from timestamp");
        }
    }

    public MTSDump(ReadableByteChannel readableByteChannel, int i) {
        super(readableByteChannel);
        this.guid = i;
        this.buf.position(this.buf.limit());
        this.tsBuf.position(this.tsBuf.limit());
    }

    public static void main(String[] strArr) throws IOException {
        ReadableByteChannel readableByteChannel = null;
        try {
            strArr = MainUtils.parseArguments(strArr);
            if (strArr.args.length <= 0) {
                MainUtils.printHelp(new C22111(), "file name", "guid");
                NIOUtils.closeQuietly(null);
            } else if (strArr.args.length == 1) {
                System.out.println("MTS programs:");
                dumpProgramPids(NIOUtils.readableFileChannel(new File(strArr.args[0])));
                NIOUtils.closeQuietly(null);
            } else {
                ReadableByteChannel readableFileChannel = NIOUtils.readableFileChannel(new File(strArr.args[0]));
                try {
                    new MTSDump(readableFileChannel, Integer.parseInt(strArr.args[1])).dump(strArr.getLongFlag(DUMP_FROM), strArr.getLongFlag(STOP_AT));
                    NIOUtils.closeQuietly(readableFileChannel);
                } catch (Throwable th) {
                    strArr = th;
                    readableByteChannel = readableFileChannel;
                    NIOUtils.closeQuietly(readableByteChannel);
                    throw strArr;
                }
            }
        } catch (Throwable th2) {
            strArr = th2;
            NIOUtils.closeQuietly(readableByteChannel);
            throw strArr;
        }
    }

    private static void dumpProgramPids(ReadableByteChannel readableByteChannel) throws IOException {
        Set<Integer> hashSet = new HashSet();
        ByteBuffer allocate = ByteBuffer.allocate(192512);
        readableByteChannel.read(allocate);
        allocate.flip();
        allocate.limit(allocate.limit() - (allocate.limit() % 188));
        readableByteChannel = -1;
        while (allocate.hasRemaining()) {
            ByteBuffer read = NIOUtils.read(allocate, 188);
            Assert.assertEquals(71, read.get() & 255);
            int i = ((read.get() & 255) << 8) | (read.get() & 255);
            int i2 = i & 8191;
            if (i2 != 0) {
                hashSet.add(Integer.valueOf(i2));
            }
            if (i2 == 0 || i2 == readableByteChannel) {
                i = (i >> 14) & 1;
                if (((read.get() & 255) & 32) != 0) {
                    NIOUtils.skip(read, read.get() & 255);
                }
                if (i == 1) {
                    NIOUtils.skip(read, read.get() & 255);
                }
                if (i2 == 0) {
                    readableByteChannel = PATSection.parse(read).getPrograms().values()[0];
                } else if (i2 == readableByteChannel) {
                    printPmt(PMTSection.parse(read));
                    return;
                }
            }
        }
        for (Integer println : hashSet) {
            System.out.println(println);
        }
    }

    private static void printPmt(PMTSection pMTSection) {
        for (PMTStream pMTStream : pMTSection.getStreams()) {
            PrintStream printStream = System.out;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(pMTStream.getPid());
            stringBuilder.append(": ");
            stringBuilder.append(pMTStream.getStreamTypeTag());
            printStream.println(stringBuilder.toString());
        }
    }

    protected void logPes(PESPacket pESPacket, int i, ByteBuffer byteBuffer) {
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(pESPacket.streamId);
        stringBuilder.append("(");
        stringBuilder.append(pESPacket.streamId >= JpegConst.APP0 ? Attachment.TYPE_VIDEO : Attachment.TYPE_AUDIO);
        stringBuilder.append(") [ts#");
        stringBuilder.append(mapPos(pESPacket.pos));
        stringBuilder.append(", ");
        stringBuilder.append(byteBuffer.remaining() + i);
        stringBuilder.append("b], pts: ");
        stringBuilder.append(pESPacket.pts);
        stringBuilder.append(", dts: ");
        stringBuilder.append(pESPacket.dts);
        printStream.println(stringBuilder.toString());
    }

    private int mapPos(long j) {
        int length;
        int i = this.globalPayload;
        for (length = this.payloads.length - 1; length >= 0; length--) {
            i -= this.payloads[length];
            if (((long) i) <= j) {
                return this.nums[length];
            }
        }
        if (this.prevPayloads != null) {
            for (length = this.prevPayloads.length - 1; length >= 0; length--) {
                i -= this.prevPayloads[length];
                if (((long) i) <= j) {
                    return this.prevNums[length];
                }
            }
        }
        return -1;
    }

    public int fillBuffer(ByteBuffer byteBuffer) throws IOException {
        IntArrayList intArrayList = new IntArrayList();
        IntArrayList intArrayList2 = new IntArrayList();
        int remaining = byteBuffer.remaining();
        try {
            byteBuffer.put(NIOUtils.read(this.tsBuf, Math.min(byteBuffer.remaining(), this.tsBuf.remaining())));
            while (byteBuffer.hasRemaining()) {
                if (!this.buf.hasRemaining()) {
                    ByteBuffer duplicate = this.buf.duplicate();
                    duplicate.clear();
                    int i = -1;
                    if (this.ch.read(duplicate) == -1) {
                        if (byteBuffer.remaining() != remaining) {
                            i = remaining - byteBuffer.remaining();
                        }
                        this.prevPayloads = this.payloads;
                        this.payloads = intArrayList.toArray();
                        this.prevNums = this.nums;
                        this.nums = intArrayList2.toArray();
                        return i;
                    }
                    duplicate.flip();
                    duplicate.limit(duplicate.limit() - (duplicate.limit() % 188));
                    this.buf = duplicate;
                }
                this.tsBuf = NIOUtils.read(this.buf, 188);
                Assert.assertEquals(71, this.tsBuf.get() & 255);
                this.tsNo++;
                if (((((this.tsBuf.get() & 255) << 8) | (this.tsBuf.get() & 255)) & 8191) == this.guid) {
                    if (((this.tsBuf.get() & 255) & 32) != 0) {
                        NIOUtils.skip(this.tsBuf, this.tsBuf.get() & 255);
                    }
                    this.globalPayload += this.tsBuf.remaining();
                    intArrayList.add(this.tsBuf.remaining());
                    intArrayList2.add(this.tsNo - 1);
                    byteBuffer.put(NIOUtils.read(this.tsBuf, Math.min(byteBuffer.remaining(), this.tsBuf.remaining())));
                }
            }
            return remaining - byteBuffer.remaining();
        } finally {
            remaining = this.payloads;
            this.prevPayloads = remaining;
            this.payloads = intArrayList.toArray();
            this.prevNums = this.nums;
            this.nums = intArrayList2.toArray();
        }
    }
}
