package org.jcodec.movtool.streaming.tracks;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jcodec.codecs.h264.H264Encoder;
import org.jcodec.codecs.h264.encode.H264FixedRateControl;
import org.jcodec.codecs.mpeg12.MPEGDecoder;
import org.jcodec.codecs.mpeg12.MPEGUtil;
import org.jcodec.codecs.mpeg12.bitstream.PictureHeader;
import org.jcodec.common.model.Size;
import org.jcodec.movtool.streaming.CodecMeta;
import org.jcodec.movtool.streaming.VirtualPacket;
import org.jcodec.movtool.streaming.VirtualTrack;
import org.jcodec.movtool.streaming.VirtualTrack.VirtualEdit;

public class Mpeg2AVCTrack implements VirtualTrack {
    public static final int TARGET_RATE = 1024;
    private int frameSize;
    private GOP gop;
    int mbH;
    int mbW;
    private VirtualPacket nextPacket;
    private GOP prevGop;
    int scaleFactor;
    private CodecMeta se;
    protected VirtualTrack src;
    int thumbHeight;
    int thumbWidth;
    private ThreadLocal<MPEGToAVCTranscoder> transcoders = new ThreadLocal();

    private class GOP {
        List<VirtualPacket> f26841a = new ArrayList();
        ByteBuffer[] f26842b;
        GOP f26843c;
        GOP f26844d;
        final /* synthetic */ Mpeg2AVCTrack f26845e;
        private int f26846f;
        private List<ByteBuffer> f26847g;

        final synchronized void m28387a() throws java.io.IOException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r17 = this;
            r1 = r17;
            monitor-enter(r17);
            r2 = r1.f26842b;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            if (r2 == 0) goto L_0x0009;
        L_0x0007:
            monitor-exit(r17);
            return;
        L_0x0009:
            r2 = r1.f26841a;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r2 = r2.size();	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r2 = new java.nio.ByteBuffer[r2];	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r1.f26842b = r2;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r2 = 0;
            r3 = r2;
        L_0x0015:
            r4 = 2;
            if (r3 >= r4) goto L_0x010f;
        L_0x0018:
            r5 = r1.f26845e;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r5 = r5.transcoders;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r5 = r5.get();	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r5 = (org.jcodec.movtool.streaming.tracks.MPEGToAVCTranscoder) r5;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            if (r5 != 0) goto L_0x0039;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
        L_0x0026:
            r5 = r1.f26845e;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r6 = r1.f26845e;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r6 = r6.scaleFactor;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r5 = r5.createTranscoder(r6);	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r6 = r1.f26845e;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r6 = r6.transcoders;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r6.set(r5);	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
        L_0x0039:
            r17.m28388b();	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r6 = r1.f26841a;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r6 = m28386a(r6);	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r7 = r2;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r8 = r7;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
        L_0x0044:
            r9 = r1.f26841a;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r9 = r9.size();	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r10 = 3;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            if (r7 >= r9) goto L_0x008a;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
        L_0x004d:
            r9 = r1.f26841a;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r9 = r9.get(r7);	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r9 = (org.jcodec.movtool.streaming.VirtualPacket) r9;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r12 = r9.getData();	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r13 = r12.duplicate();	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r13 = org.jcodec.movtool.streaming.tracks.Mpeg2AVCTrack.getPicType(r13);	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            if (r13 == r10) goto L_0x0066;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
        L_0x0063:
            r8 = r8 + 1;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            goto L_0x0068;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
        L_0x0066:
            if (r8 < r4) goto L_0x0087;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
        L_0x0068:
            r10 = r1.f26845e;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r10 = r10.frameSize;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r10 = java.nio.ByteBuffer.allocate(r10);	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r13 = r1.f26842b;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            if (r7 != 0) goto L_0x0078;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
        L_0x0076:
            r11 = 1;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            goto L_0x0079;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
        L_0x0078:
            r11 = r2;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
        L_0x0079:
            r14 = r9.getPts();	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r9 = java.util.Arrays.binarySearch(r6, r14);	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r9 = r5.transcodeFrame(r12, r10, r11, r9);	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r13[r7] = r9;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
        L_0x0087:
            r7 = r7 + 1;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            goto L_0x0044;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
        L_0x008a:
            r6 = r1.f26843c;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            if (r6 == 0) goto L_0x00ed;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
        L_0x008e:
            r6 = r1.f26843c;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r7 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r7.<init>();	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r6.f26847g = r7;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r6 = r1.f26843c;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r6 = r6.f26841a;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r6 = m28386a(r6);	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r7 = r2;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r8 = r7;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
        L_0x00a1:
            r9 = r1.f26843c;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r9 = r9.f26841a;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r9 = r9.size();	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            if (r7 >= r9) goto L_0x00ed;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
        L_0x00ab:
            r9 = r1.f26843c;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r9 = r9.f26841a;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r9 = r9.get(r7);	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r9 = (org.jcodec.movtool.streaming.VirtualPacket) r9;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r12 = r9.getData();	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r13 = r12.duplicate();	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r13 = org.jcodec.movtool.streaming.tracks.Mpeg2AVCTrack.getPicType(r13);	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            if (r13 == r10) goto L_0x00c5;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
        L_0x00c3:
            r8 = r8 + 1;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
        L_0x00c5:
            if (r8 >= r4) goto L_0x00ed;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
        L_0x00c7:
            r13 = r1.f26845e;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r13 = r13.frameSize;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r13 = java.nio.ByteBuffer.allocate(r13);	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r14 = r1.f26843c;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r14 = r14.f26847g;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            if (r7 != 0) goto L_0x00d9;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
        L_0x00d7:
            r15 = 1;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            goto L_0x00da;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
        L_0x00d9:
            r15 = r2;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
        L_0x00da:
            r10 = r9.getPts();	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r9 = java.util.Arrays.binarySearch(r6, r10);	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r9 = r5.transcodeFrame(r12, r13, r15, r9);	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r14.add(r9);	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r7 = r7 + 1;
            r10 = 3;
            goto L_0x00a1;
        L_0x00ed:
            monitor-exit(r17);
            return;
        L_0x00ef:
            r0 = move-exception;
            r4 = r0;
            r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r6 = "Error transcoding gop: ";	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r5.<init>(r6);	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r4 = r4.getMessage();	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r5.append(r4);	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r4 = ", retrying.";	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r5.append(r4);	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r4 = r5.toString();	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            org.jcodec.common.logging.Logger.error(r4);	 Catch:{ Throwable -> 0x00ef, all -> 0x0111 }
            r3 = r3 + 1;
            goto L_0x0015;
        L_0x010f:
            monitor-exit(r17);
            return;
        L_0x0111:
            r0 = move-exception;
            r2 = r0;
            monitor-exit(r17);
            throw r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jcodec.movtool.streaming.tracks.Mpeg2AVCTrack.GOP.a():void");
        }

        public GOP(Mpeg2AVCTrack mpeg2AVCTrack, int i, GOP gop) {
            this.f26845e = mpeg2AVCTrack;
            this.f26846f = i;
            this.f26844d = gop;
        }

        private static double[] m28386a(List<VirtualPacket> list) {
            double[] dArr = new double[list.size()];
            for (int i = 0; i < dArr.length; i++) {
                dArr[i] = ((VirtualPacket) list.get(i)).getPts();
            }
            Arrays.sort(dArr);
            return dArr;
        }

        final synchronized void m28388b() {
            if (this.f26847g != null) {
                for (int i = 0; i < this.f26847g.size(); i++) {
                    this.f26842b[i] = (ByteBuffer) this.f26847g.get(i);
                }
            }
        }
    }

    private class TranscodePacket extends VirtualPacketWrapper {
        final /* synthetic */ Mpeg2AVCTrack f36212a;
        private GOP f36213b;
        private int f36214c;

        public TranscodePacket(Mpeg2AVCTrack mpeg2AVCTrack, VirtualPacket virtualPacket, GOP gop, int i) {
            this.f36212a = mpeg2AVCTrack;
            super(virtualPacket);
            this.f36213b = gop;
            this.f36214c = i;
        }

        public int getDataLen() {
            return this.f36212a.frameSize;
        }

        public ByteBuffer getData() throws IOException {
            GOP gop = this.f36213b;
            int i = this.f36214c;
            gop.m28387a();
            if (gop.f26842b[i] == null && gop.f26844d != null) {
                gop.f26844d.m28387a();
                gop.m28388b();
            }
            return gop.f26842b[i];
        }
    }

    protected void checkFourCC(VirtualTrack virtualTrack) {
        if ("m2v1".equals(virtualTrack.getCodecMeta().getFourcc()) == null) {
            throw new IllegalArgumentException("Input track is not ProRes");
        }
    }

    protected int selectScaleFactor(Size size) {
        if (size.getWidth() >= 960) {
            return 2;
        }
        return size.getWidth() > 480 ? 1 : null;
    }

    public Mpeg2AVCTrack(VirtualTrack virtualTrack) throws IOException {
        checkFourCC(virtualTrack);
        this.src = virtualTrack;
        Object h264FixedRateControl = new H264FixedRateControl(1024);
        H264Encoder h264Encoder = new H264Encoder(h264FixedRateControl);
        this.nextPacket = virtualTrack.nextPacket();
        Size size = MPEGDecoder.getSize(this.nextPacket.getData());
        this.scaleFactor = selectScaleFactor(size);
        this.thumbWidth = size.getWidth() >> this.scaleFactor;
        this.thumbHeight = (size.getHeight() >> this.scaleFactor) & -2;
        this.mbW = (this.thumbWidth + 15) >> 4;
        this.mbH = (this.thumbHeight + 15) >> 4;
        this.se = Transcode2AVCTrack.createCodecMeta(virtualTrack, h264Encoder, this.thumbWidth, this.thumbHeight);
        this.frameSize = h264FixedRateControl.calcFrameSize(this.mbW * this.mbH);
        this.frameSize += this.frameSize >> 4;
    }

    public CodecMeta getCodecMeta() {
        return this.se;
    }

    public VirtualPacket nextPacket() throws IOException {
        if (this.nextPacket == null) {
            return null;
        }
        if (this.nextPacket.isKeyframe()) {
            this.prevGop = this.gop;
            this.gop = new GOP(this, this.nextPacket.getFrameNo(), this.prevGop);
            if (this.prevGop != null) {
                this.prevGop.f26843c = this.gop;
            }
        }
        GOP gop = this.gop;
        VirtualPacket virtualPacket = this.nextPacket;
        gop.f26841a.add(virtualPacket);
        VirtualPacket transcodePacket = new TranscodePacket(gop.f26845e, virtualPacket, gop, gop.f26841a.size() - 1);
        this.nextPacket = this.src.nextPacket();
        return transcodePacket;
    }

    protected MPEGToAVCTranscoder createTranscoder(int i) {
        return new MPEGToAVCTranscoder(i);
    }

    public static int getPicType(ByteBuffer byteBuffer) {
        ByteBuffer nextSegment;
        do {
            nextSegment = MPEGUtil.nextSegment(byteBuffer);
            if (nextSegment == null) {
                return -1;
            }
        } while ((nextSegment.getInt() & 255) != 0);
        return PictureHeader.read(nextSegment).picture_coding_type;
    }

    public void close() throws IOException {
        this.src.close();
    }

    public VirtualEdit[] getEdits() {
        return this.src.getEdits();
    }

    public int getPreferredTimescale() {
        return this.src.getPreferredTimescale();
    }
}
