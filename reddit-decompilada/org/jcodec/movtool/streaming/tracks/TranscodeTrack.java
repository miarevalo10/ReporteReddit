package org.jcodec.movtool.streaming.tracks;

import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.VideoDecoder;
import org.jcodec.common.VideoEncoder;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Size;
import org.jcodec.movtool.streaming.CodecMeta;
import org.jcodec.movtool.streaming.VideoCodecMeta;
import org.jcodec.movtool.streaming.VirtualPacket;
import org.jcodec.movtool.streaming.VirtualTrack;
import org.jcodec.movtool.streaming.VirtualTrack.VirtualEdit;
import org.jcodec.scale.Transform;

public abstract class TranscodeTrack implements VirtualTrack {
    private static final int TARGET_RATE = 1024;
    private int frameSize;
    private int mbH;
    private int mbW;
    private int scaleFactor;
    private CodecMeta se;
    private VirtualTrack src;
    private int thumbHeight;
    private int thumbWidth;
    private ThreadLocal<Transcoder> transcoders = new ThreadLocal();

    class Transcoder {
        final /* synthetic */ TranscodeTrack f26855a;
        private VideoDecoder f26856b;
        private VideoEncoder[] f26857c = new VideoEncoder[3];
        private Picture f26858d;
        private Picture f26859e;
        private Transform f26860f;

        public Transcoder(TranscodeTrack transcodeTrack) {
            this.f26855a = transcodeTrack;
            this.f26856b = transcodeTrack.getDecoder(transcodeTrack.scaleFactor);
            this.f26857c[0] = transcodeTrack.getEncoder(1024);
            this.f26857c[1] = transcodeTrack.getEncoder(921);
            this.f26857c[2] = transcodeTrack.getEncoder(819);
            this.f26858d = Picture.create(transcodeTrack.mbW << 4, transcodeTrack.mbH << 4, ColorSpace.YUV444);
        }

        public final java.nio.ByteBuffer m28390a(java.nio.ByteBuffer r5, java.nio.ByteBuffer r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r0 = r4.f26856b;
            r1 = r4.f26858d;
            r1 = r1.getData();
            r5 = r0.decodeFrame(r5, r1);
            r0 = r4.f26859e;
            if (r0 != 0) goto L_0x002c;
        L_0x0010:
            r0 = r5.getWidth();
            r1 = r5.getHeight();
            r2 = org.jcodec.common.model.ColorSpace.YUV420;
            r0 = org.jcodec.common.model.Picture.create(r0, r1, r2);
            r4.f26859e = r0;
            r0 = r5.getColor();
            r1 = org.jcodec.common.model.ColorSpace.YUV420;
            r0 = org.jcodec.scale.ColorUtil.getTransform(r0, r1);
            r4.f26860f = r0;
        L_0x002c:
            r0 = r4.f26860f;
            r1 = r4.f26859e;
            r0.transform(r5, r1);
            r5 = r4.f26859e;
            r0 = new org.jcodec.common.model.Rect;
            r1 = r4.f26855a;
            r1 = r1.thumbWidth;
            r2 = r4.f26855a;
            r2 = r2.thumbHeight;
            r3 = 0;
            r0.<init>(r3, r3, r1, r2);
            r5.setCrop(r0);
        L_0x004a:
            r5 = r4.f26857c;
            r5 = r5.length;
            if (r3 >= r5) goto L_0x0066;
        L_0x004f:
            r6.clear();	 Catch:{ BufferOverflowException -> 0x005c }
            r5 = r4.f26857c;	 Catch:{ BufferOverflowException -> 0x005c }
            r5 = r5[r3];	 Catch:{ BufferOverflowException -> 0x005c }
            r0 = r4.f26859e;	 Catch:{ BufferOverflowException -> 0x005c }
            r5.encodeFrame(r0, r6);	 Catch:{ BufferOverflowException -> 0x005c }
            goto L_0x0066;
        L_0x005c:
            r5 = java.lang.System.out;
            r0 = "Abandon frame!!!";
            r5.println(r0);
            r3 = r3 + 1;
            goto L_0x004a;
        L_0x0066:
            return r6;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jcodec.movtool.streaming.tracks.TranscodeTrack.Transcoder.a(java.nio.ByteBuffer, java.nio.ByteBuffer):java.nio.ByteBuffer");
        }
    }

    private class TranscodePacket extends VirtualPacketWrapper {
        final /* synthetic */ TranscodeTrack f36217a;

        public TranscodePacket(TranscodeTrack transcodeTrack, VirtualPacket virtualPacket) {
            this.f36217a = transcodeTrack;
            super(virtualPacket);
        }

        public int getDataLen() {
            return this.f36217a.frameSize;
        }

        public ByteBuffer getData() throws IOException {
            Transcoder transcoder = (Transcoder) this.f36217a.transcoders.get();
            if (transcoder == null) {
                transcoder = new Transcoder(this.f36217a);
                this.f36217a.transcoders.set(transcoder);
            }
            return transcoder.m28390a(this.src.getData(), ByteBuffer.allocate(this.f36217a.frameSize));
        }
    }

    protected abstract void getCodecPrivate(ByteBuffer byteBuffer, Size size);

    protected abstract VideoDecoder getDecoder(int i);

    protected abstract VideoEncoder getEncoder(int i);

    protected abstract int getFrameSize(int i, int i2);

    public TranscodeTrack(VirtualTrack virtualTrack, Size size) {
        this.src = virtualTrack;
        this.scaleFactor = size.getWidth() >= 960 ? 2 : 1;
        this.thumbWidth = size.getWidth() >> this.scaleFactor;
        this.thumbHeight = (size.getHeight() >> this.scaleFactor) & -2;
        this.mbW = (this.thumbWidth + 15) >> 4;
        this.mbH = (this.thumbHeight + 15) >> 4;
        size = new Size(this.thumbWidth, this.thumbHeight);
        virtualTrack = ((VideoCodecMeta) virtualTrack.getCodecMeta()).getPasp();
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        getCodecPrivate(allocate, size);
        this.se = new VideoCodecMeta(VisualSampleEntry.TYPE3, allocate, size, virtualTrack);
        this.frameSize = getFrameSize(this.mbW * this.mbH, 1024);
        this.frameSize += this.frameSize >> 4;
    }

    public CodecMeta getCodecMeta() {
        return this.se;
    }

    public VirtualPacket nextPacket() throws IOException {
        VirtualPacket nextPacket = this.src.nextPacket();
        if (nextPacket == null) {
            return null;
        }
        return new TranscodePacket(this, nextPacket);
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
