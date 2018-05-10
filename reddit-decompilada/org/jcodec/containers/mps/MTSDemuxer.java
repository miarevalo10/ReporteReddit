package org.jcodec.containers.mps;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.jcodec.common.Assert;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.containers.mps.MPEGDemuxer.MPEGDemuxerTrack;

public class MTSDemuxer implements MPEGDemuxer {
    private MPSDemuxer psDemuxer = new MPSDemuxer(this.tsChannel);
    private SeekableByteChannel tsChannel;

    public static class MTSPacket {
        public ByteBuffer payload;
        public boolean payloadStart;
        public int pid;

        public MTSPacket(int i, boolean z, ByteBuffer byteBuffer) {
            this.pid = i;
            this.payloadStart = z;
            this.payload = byteBuffer;
        }
    }

    private static class TSChannel implements SeekableByteChannel {
        private SeekableByteChannel f33284a;
        private ByteBuffer f33285b;
        private int f33286c;

        public TSChannel(SeekableByteChannel seekableByteChannel, int i) {
            this.f33284a = seekableByteChannel;
            this.f33286c = i;
        }

        public boolean isOpen() {
            return this.f33284a.isOpen();
        }

        public void close() throws IOException {
            this.f33284a.close();
        }

        public int read(ByteBuffer byteBuffer) throws IOException {
            while (true) {
                MTSPacket readPacket;
                MTSPacket mTSPacket;
                if (this.f33285b != null) {
                    if (this.f33285b.hasRemaining()) {
                        int min = Math.min(byteBuffer.remaining(), this.f33285b.remaining());
                        byteBuffer.put(NIOUtils.read(this.f33285b, min));
                        return min;
                    }
                }
                ReadableByteChannel readableByteChannel = this.f33284a;
                while (true) {
                    readPacket = MTSDemuxer.readPacket(readableByteChannel);
                    mTSPacket = null;
                    if (readPacket != null) {
                        if (readPacket.pid > 15 && readPacket.pid != 8191 && readPacket.payload != null) {
                            break;
                        }
                    } else {
                        break;
                    }
                    if (mTSPacket == null) {
                        return -1;
                    }
                    this.f33285b = mTSPacket.payload;
                }
                while (readPacket.pid != this.f33286c) {
                    readPacket = MTSDemuxer.readPacket(readableByteChannel);
                    if (readPacket == null) {
                        break;
                    }
                }
                mTSPacket = readPacket;
                if (mTSPacket == null) {
                    return -1;
                }
                this.f33285b = mTSPacket.payload;
            }
        }

        public int write(ByteBuffer byteBuffer) throws IOException {
            throw new UnsupportedOperationException();
        }

        public long position() throws IOException {
            return this.f33284a.position();
        }

        public SeekableByteChannel position(long j) throws IOException {
            this.f33284a.position(j);
            this.f33285b = 0;
            return this;
        }

        public long size() throws IOException {
            return this.f33284a.size();
        }

        public SeekableByteChannel truncate(long j) throws IOException {
            return this.f33284a.truncate(j);
        }
    }

    public static Set<Integer> getPrograms(SeekableByteChannel seekableByteChannel) throws IOException {
        long position = seekableByteChannel.position();
        Set<Integer> hashSet = new HashSet();
        int i = 0;
        while (true) {
            if (hashSet.size() != 0 && i >= hashSet.size() * 500) {
                break;
            }
            MTSPacket readPacket = readPacket(seekableByteChannel);
            if (readPacket == null) {
                break;
            }
            if (readPacket.payload != null) {
                ByteBuffer byteBuffer = readPacket.payload;
                if (!hashSet.contains(Integer.valueOf(readPacket.pid)) && (byteBuffer.duplicate().getInt() & -256) == 256) {
                    hashSet.add(Integer.valueOf(readPacket.pid));
                }
            }
            i++;
        }
        seekableByteChannel.position(position);
        return hashSet;
    }

    public static Set<Integer> getPrograms(File file) throws IOException {
        ReadableByteChannel readableFileChannel;
        Throwable th;
        try {
            readableFileChannel = NIOUtils.readableFileChannel(file);
            try {
                Set<Integer> programs = getPrograms((SeekableByteChannel) readableFileChannel);
                NIOUtils.closeQuietly(readableFileChannel);
                return programs;
            } catch (Throwable th2) {
                th = th2;
                NIOUtils.closeQuietly(readableFileChannel);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            readableFileChannel = null;
            NIOUtils.closeQuietly(readableFileChannel);
            throw th;
        }
    }

    public MTSDemuxer(SeekableByteChannel seekableByteChannel, int i) throws IOException {
        this.tsChannel = new TSChannel(seekableByteChannel, i);
    }

    public List<? extends MPEGDemuxerTrack> getTracks() {
        return this.psDemuxer.getTracks();
    }

    public List<? extends MPEGDemuxerTrack> getVideoTracks() {
        return this.psDemuxer.getVideoTracks();
    }

    public List<? extends MPEGDemuxerTrack> getAudioTracks() {
        return this.psDemuxer.getAudioTracks();
    }

    public static MTSPacket readPacket(ReadableByteChannel readableByteChannel) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(188);
        if (NIOUtils.read(readableByteChannel, allocate) != 188) {
            return null;
        }
        allocate.flip();
        return parsePacket(allocate);
    }

    public static MTSPacket parsePacket(ByteBuffer byteBuffer) {
        Assert.assertEquals(71, byteBuffer.get() & 255);
        short s = byteBuffer.getShort();
        int i = s & 8191;
        boolean z = true;
        int i2 = (s >> 14) & 1;
        int i3 = byteBuffer.get() & 255;
        if ((i3 & 32) != 0) {
            NIOUtils.skip(byteBuffer, ((byteBuffer.get() & 255) + 1) - 1);
        }
        if (i2 != 1) {
            z = false;
        }
        if ((i3 & 16) == 0) {
            byteBuffer = null;
        }
        return new MTSPacket(i, z, byteBuffer);
    }

    public static int probe(java.nio.ByteBuffer r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new org.jcodec.common.IntObjectMap;
        r0.<init>();
    L_0x0005:
        r1 = 188; // 0xbc float:2.63E-43 double:9.3E-322;
        r2 = org.jcodec.common.NIOUtils.read(r5, r1);	 Catch:{ Throwable -> 0x0037 }
        r3 = r2.remaining();	 Catch:{ Throwable -> 0x0037 }
        if (r3 >= r1) goto L_0x0012;	 Catch:{ Throwable -> 0x0037 }
    L_0x0011:
        goto L_0x0037;	 Catch:{ Throwable -> 0x0037 }
    L_0x0012:
        r1 = parsePacket(r2);	 Catch:{ Throwable -> 0x0037 }
        if (r1 != 0) goto L_0x0019;	 Catch:{ Throwable -> 0x0037 }
    L_0x0018:
        goto L_0x0037;	 Catch:{ Throwable -> 0x0037 }
    L_0x0019:
        r2 = r1.pid;	 Catch:{ Throwable -> 0x0037 }
        r2 = r0.get(r2);	 Catch:{ Throwable -> 0x0037 }
        r2 = (java.util.List) r2;	 Catch:{ Throwable -> 0x0037 }
        if (r2 != 0) goto L_0x002d;	 Catch:{ Throwable -> 0x0037 }
    L_0x0023:
        r2 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x0037 }
        r2.<init>();	 Catch:{ Throwable -> 0x0037 }
        r3 = r1.pid;	 Catch:{ Throwable -> 0x0037 }
        r0.put(r3, r2);	 Catch:{ Throwable -> 0x0037 }
    L_0x002d:
        r3 = r1.payload;	 Catch:{ Throwable -> 0x0037 }
        if (r3 == 0) goto L_0x0005;	 Catch:{ Throwable -> 0x0037 }
    L_0x0031:
        r1 = r1.payload;	 Catch:{ Throwable -> 0x0037 }
        r2.add(r1);	 Catch:{ Throwable -> 0x0037 }
        goto L_0x0005;
    L_0x0037:
        r5 = r0.keys();
        r1 = 0;
        r2 = r5.length;
        r3 = r1;
    L_0x003e:
        if (r1 >= r2) goto L_0x0056;
    L_0x0040:
        r4 = r5[r1];
        r4 = r0.get(r4);
        r4 = (java.lang.Iterable) r4;
        r4 = org.jcodec.common.NIOUtils.combine(r4);
        r4 = org.jcodec.containers.mps.MPSDemuxer.probe(r4);
        if (r4 <= r3) goto L_0x0053;
    L_0x0052:
        r3 = r4;
    L_0x0053:
        r1 = r1 + 1;
        goto L_0x003e;
    L_0x0056:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.containers.mps.MTSDemuxer.probe(java.nio.ByteBuffer):int");
    }

    public void seekByte(long j) throws IOException {
        this.tsChannel.position(j - (j % 188));
        this.psDemuxer.reset();
    }
}
