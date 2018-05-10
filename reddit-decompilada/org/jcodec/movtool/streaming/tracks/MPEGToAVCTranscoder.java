package org.jcodec.movtool.streaming.tracks;

import org.jcodec.codecs.h264.H264Encoder;
import org.jcodec.codecs.h264.encode.H264FixedRateControl;
import org.jcodec.codecs.mpeg12.MPEGDecoder;
import org.jcodec.codecs.mpeg12.Mpeg2Thumb2x2;
import org.jcodec.codecs.mpeg12.Mpeg2Thumb4x4;
import org.jcodec.common.VideoDecoder;
import org.jcodec.common.model.Picture;
import org.jcodec.scale.Transform;

public class MPEGToAVCTranscoder {
    private VideoDecoder decoder;
    private H264Encoder encoder;
    private Picture pic0;
    private Picture pic1;
    private H264FixedRateControl rc = new H264FixedRateControl(1024);
    private int scaleFactor;
    private int thumbHeight;
    private int thumbWidth;
    private Transform transform;

    public MPEGToAVCTranscoder(int i) {
        this.scaleFactor = i;
        this.decoder = getDecoder(i);
        this.encoder = new H264Encoder(this.rc);
    }

    protected VideoDecoder getDecoder(int i) {
        switch (i) {
            case 0:
                return new MPEGDecoder();
            case 1:
                return new Mpeg2Thumb4x4();
            case 2:
                return new Mpeg2Thumb2x2();
            default:
                StringBuilder stringBuilder = new StringBuilder("Unsupported scale factor: ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public java.nio.ByteBuffer transcodeFrame(java.nio.ByteBuffer r6, java.nio.ByteBuffer r7, boolean r8, int r9) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        if (r6 != 0) goto L_0x0004;
    L_0x0002:
        r6 = 0;
        return r6;
    L_0x0004:
        r0 = r5.pic0;
        if (r0 != 0) goto L_0x003c;
    L_0x0008:
        r0 = r6.duplicate();
        r0 = org.jcodec.codecs.mpeg12.MPEGDecoder.getSize(r0);
        r1 = r0.getWidth();
        r2 = r5.scaleFactor;
        r1 = r1 >> r2;
        r5.thumbWidth = r1;
        r0 = r0.getHeight();
        r1 = r5.scaleFactor;
        r0 = r0 >> r1;
        r5.thumbHeight = r0;
        r0 = r5.thumbWidth;
        r0 = r0 + 8;
        r0 = r0 >> 4;
        r1 = r5.thumbHeight;
        r1 = r1 + 8;
        r1 = r1 >> 4;
        r0 = r0 << 4;
        r1 = r1 + 1;
        r1 = r1 << 4;
        r2 = org.jcodec.common.model.ColorSpace.YUV444;
        r0 = org.jcodec.common.model.Picture.create(r0, r1, r2);
        r5.pic0 = r0;
    L_0x003c:
        r0 = r5.decoder;
        r1 = r5.pic0;
        r1 = r1.getData();
        r6 = r0.decodeFrame(r6, r1);
        r0 = r5.pic1;
        r1 = 0;
        if (r0 != 0) goto L_0x0075;
    L_0x004d:
        r0 = r6.getWidth();
        r2 = r6.getHeight();
        r3 = r5.encoder;
        r3 = r3.getSupportedColorSpaces();
        r3 = r3[r1];
        r0 = org.jcodec.common.model.Picture.create(r0, r2, r3);
        r5.pic1 = r0;
        r0 = r6.getColor();
        r2 = r5.encoder;
        r2 = r2.getSupportedColorSpaces();
        r2 = r2[r1];
        r0 = org.jcodec.scale.ColorUtil.getTransform(r0, r2);
        r5.transform = r0;
    L_0x0075:
        r0 = r5.transform;
        if (r0 == 0) goto L_0x0082;
    L_0x0079:
        r0 = r5.transform;
        r2 = r5.pic1;
        r0.transform(r6, r2);
        r6 = r5.pic1;
    L_0x0082:
        r0 = r5.pic1;
        r2 = new org.jcodec.common.model.Rect;
        r3 = r5.thumbWidth;
        r4 = r5.thumbHeight;
        r2.<init>(r1, r1, r3, r4);
        r0.setCrop(r2);
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r1 = r0;
    L_0x0093:
        r2 = r5.encoder;	 Catch:{ BufferOverflowException -> 0x0099 }
        r2.encodeFrame(r6, r7, r8, r9);	 Catch:{ BufferOverflowException -> 0x0099 }
        goto L_0x00b9;
    L_0x0099:
        r2 = new java.lang.StringBuilder;
        r3 = "Abandon frame, buffer too small: ";
        r2.<init>(r3);
        r3 = r7.capacity();
        r2.append(r3);
        r2 = r2.toString();
        org.jcodec.common.logging.Logger.warn(r2);
        r1 = r1 + -10;
        r2 = r5.rc;
        r2.setRate(r1);
        r2 = 10;
        if (r1 > r2) goto L_0x0093;
    L_0x00b9:
        r6 = r5.rc;
        r6.setRate(r0);
        org.jcodec.codecs.h264.H264Utils.encodeMOVPacket(r7);
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.movtool.streaming.tracks.MPEGToAVCTranscoder.transcodeFrame(java.nio.ByteBuffer, java.nio.ByteBuffer, boolean, int):java.nio.ByteBuffer");
    }
}
