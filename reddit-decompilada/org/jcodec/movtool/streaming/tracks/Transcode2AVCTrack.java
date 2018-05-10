package org.jcodec.movtool.streaming.tracks;

import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.codecs.h264.H264Encoder;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.h264.encode.H264FixedRateControl;
import org.jcodec.common.VideoDecoder;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Size;
import org.jcodec.movtool.streaming.CodecMeta;
import org.jcodec.movtool.streaming.VideoCodecMeta;
import org.jcodec.movtool.streaming.VirtualPacket;
import org.jcodec.movtool.streaming.VirtualTrack;
import org.jcodec.movtool.streaming.VirtualTrack.VirtualEdit;
import org.jcodec.scale.Transform;

public abstract class Transcode2AVCTrack implements VirtualTrack {
    private static final int TARGET_RATE = 1024;
    private int frameSize;
    private int mbH;
    private int mbW;
    private int scaleFactor;
    private CodecMeta se;
    protected VirtualTrack src;
    private int thumbHeight;
    private int thumbWidth;
    private ThreadLocal<Transcoder> transcoders = new ThreadLocal();

    class Transcoder {
        final /* synthetic */ Transcode2AVCTrack f26848a;
        private VideoDecoder f26849b;
        private H264Encoder f26850c;
        private Picture f26851d;
        private Picture f26852e;
        private Transform f26853f;
        private H264FixedRateControl f26854g = new H264FixedRateControl(1024);

        public Transcoder(Transcode2AVCTrack transcode2AVCTrack) {
            this.f26848a = transcode2AVCTrack;
            this.f26849b = transcode2AVCTrack.getDecoder(transcode2AVCTrack.scaleFactor);
            this.f26850c = new H264Encoder(this.f26854g);
            this.f26851d = Picture.create(transcode2AVCTrack.mbW << 4, (transcode2AVCTrack.mbH + 1) << 4, ColorSpace.YUV444);
        }

        public final java.nio.ByteBuffer m28389a(java.nio.ByteBuffer r5, java.nio.ByteBuffer r6) throws java.io.IOException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            if (r5 != 0) goto L_0x0004;
        L_0x0002:
            r5 = 0;
            return r5;
        L_0x0004:
            r0 = r4.f26849b;
            r1 = r4.f26851d;
            r1 = r1.getData();
            r5 = r0.decodeFrame(r5, r1);
            r0 = r4.f26852e;
            r1 = 0;
            if (r0 != 0) goto L_0x003d;
        L_0x0015:
            r0 = r5.getWidth();
            r2 = r5.getHeight();
            r3 = r4.f26850c;
            r3 = r3.getSupportedColorSpaces();
            r3 = r3[r1];
            r0 = org.jcodec.common.model.Picture.create(r0, r2, r3);
            r4.f26852e = r0;
            r0 = r5.getColor();
            r2 = r4.f26850c;
            r2 = r2.getSupportedColorSpaces();
            r2 = r2[r1];
            r0 = org.jcodec.scale.ColorUtil.getTransform(r0, r2);
            r4.f26853f = r0;
        L_0x003d:
            r0 = r4.f26853f;
            r2 = r4.f26852e;
            r0.transform(r5, r2);
            r5 = r4.f26852e;
            r0 = new org.jcodec.common.model.Rect;
            r2 = r4.f26848a;
            r2 = r2.thumbWidth;
            r3 = r4.f26848a;
            r3 = r3.thumbHeight;
            r0.<init>(r1, r1, r2, r3);
            r5.setCrop(r0);
            r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
            r0 = r5;
        L_0x005d:
            r1 = r4.f26850c;	 Catch:{ BufferOverflowException -> 0x0065 }
            r2 = r4.f26852e;	 Catch:{ BufferOverflowException -> 0x0065 }
            r1.encodeFrame(r2, r6);	 Catch:{ BufferOverflowException -> 0x0065 }
            goto L_0x0085;
        L_0x0065:
            r1 = new java.lang.StringBuilder;
            r2 = "Abandon frame, buffer too small: ";
            r1.<init>(r2);
            r2 = r6.capacity();
            r1.append(r2);
            r1 = r1.toString();
            org.jcodec.common.logging.Logger.warn(r1);
            r0 = r0 + -10;
            r1 = r4.f26854g;
            r1.setRate(r0);
            r1 = 10;
            if (r0 > r1) goto L_0x005d;
        L_0x0085:
            r0 = r4.f26854g;
            r0.setRate(r5);
            org.jcodec.codecs.h264.H264Utils.encodeMOVPacket(r6);
            return r6;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jcodec.movtool.streaming.tracks.Transcode2AVCTrack.Transcoder.a(java.nio.ByteBuffer, java.nio.ByteBuffer):java.nio.ByteBuffer");
        }
    }

    private class TranscodePacket extends VirtualPacketWrapper {
        final /* synthetic */ Transcode2AVCTrack f36216a;

        public TranscodePacket(Transcode2AVCTrack transcode2AVCTrack, VirtualPacket virtualPacket) {
            this.f36216a = transcode2AVCTrack;
            super(virtualPacket);
        }

        public int getDataLen() {
            return this.f36216a.frameSize;
        }

        public ByteBuffer getData() throws IOException {
            Transcoder transcoder = (Transcoder) this.f36216a.transcoders.get();
            if (transcoder == null) {
                transcoder = new Transcoder(this.f36216a);
                this.f36216a.transcoders.set(transcoder);
            }
            return transcoder.m28389a(this.src.getData(), ByteBuffer.allocate(this.f36216a.frameSize));
        }
    }

    protected abstract void checkFourCC(VirtualTrack virtualTrack);

    protected abstract VideoDecoder getDecoder(int i);

    protected abstract int selectScaleFactor(Size size);

    public Transcode2AVCTrack(VirtualTrack virtualTrack, Size size) {
        checkFourCC(virtualTrack);
        this.src = virtualTrack;
        Object h264FixedRateControl = new H264FixedRateControl(1024);
        H264Encoder h264Encoder = new H264Encoder(h264FixedRateControl);
        this.scaleFactor = selectScaleFactor(size);
        this.thumbWidth = size.getWidth() >> this.scaleFactor;
        this.thumbHeight = (size.getHeight() >> this.scaleFactor) & -2;
        this.mbW = (this.thumbWidth + 15) >> 4;
        this.mbH = (this.thumbHeight + 15) >> 4;
        this.se = createCodecMeta(virtualTrack, h264Encoder, this.thumbWidth, this.thumbHeight);
        this.frameSize = h264FixedRateControl.calcFrameSize(this.mbW * this.mbH);
        this.frameSize += this.frameSize >> 4;
    }

    public static VideoCodecMeta createCodecMeta(VirtualTrack virtualTrack, H264Encoder h264Encoder, int i, int i2) {
        VideoCodecMeta videoCodecMeta = (VideoCodecMeta) virtualTrack.getCodecMeta();
        return new VideoCodecMeta(VisualSampleEntry.TYPE3, H264Utils.getAvcCData(H264Utils.createAvcC(h264Encoder.initSPS(new Size(i, i2)), h264Encoder.initPPS(), 4)), new Size(i, i2), videoCodecMeta.getPasp());
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
