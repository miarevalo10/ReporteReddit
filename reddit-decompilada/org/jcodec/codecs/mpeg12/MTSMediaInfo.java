package org.jcodec.codecs.mpeg12;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jcodec.codecs.mpeg12.MPSMediaInfo.MPEGTrackMetadata;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.containers.mps.MTSUtils.TSReader;

public class MTSMediaInfo {
    public static MTSMediaInfo extract(SeekableByteChannel seekableByteChannel) {
        return null;
    }

    public List<MPEGTrackMetadata> getAudioTracks() {
        return null;
    }

    public MPEGTrackMetadata getVideoTrack() {
        return null;
    }

    public List<MPEGTrackMetadata> getMediaInfo(File file) throws IOException {
        Throwable th;
        final List arrayList = new ArrayList();
        final Map hashMap = new HashMap();
        final List<MPEGTrackMetadata> arrayList2 = new ArrayList();
        ReadableByteChannel readableFileChannel;
        try {
            readableFileChannel = NIOUtils.readableFileChannel(file);
            try {
                new TSReader(this) {
                    final /* synthetic */ MTSMediaInfo f33276d;
                    private ByteBuffer f33277e;
                    private int f33278f = -1;
                    private boolean f33279g;

                    protected boolean onPkt(int r5, boolean r6, java.nio.ByteBuffer r7, long r8) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                        /*
                        r4 = this;
                        r6 = 1;
                        if (r5 != 0) goto L_0x000b;
                    L_0x0003:
                        r5 = org.jcodec.containers.mps.MTSUtils.parsePAT(r7);
                        r4.f33278f = r5;
                        goto L_0x00e3;
                    L_0x000b:
                        r0 = r4.f33278f;
                        r1 = 0;
                        if (r5 != r0) goto L_0x00a0;
                    L_0x0010:
                        r0 = r4.f33279g;
                        if (r0 != 0) goto L_0x00a0;
                    L_0x0014:
                        r5 = r4.f33277e;
                        if (r5 != 0) goto L_0x002d;
                    L_0x0018:
                        r5 = r7.duplicate();
                        r5 = r5.getInt();
                        r5 = r5 >> 8;
                        r5 = r5 & 1023;
                        r5 = r5 + 3;
                        r5 = java.nio.ByteBuffer.allocate(r5);
                        r4.f33277e = r5;
                        goto L_0x0048;
                    L_0x002d:
                        r5 = r4.f33277e;
                        r5 = r5.hasRemaining();
                        if (r5 == 0) goto L_0x0048;
                    L_0x0035:
                        r5 = r4.f33277e;
                        r8 = r4.f33277e;
                        r8 = r8.remaining();
                        r9 = r7.remaining();
                        r8 = java.lang.Math.min(r8, r9);
                        org.jcodec.common.NIOUtils.write(r5, r7, r8);
                    L_0x0048:
                        r5 = r4.f33277e;
                        r5 = r5.hasRemaining();
                        if (r5 != 0) goto L_0x00e3;
                    L_0x0050:
                        r5 = r4.f33277e;
                        r5.flip();
                        r5 = r4.f33277e;
                        r5 = org.jcodec.containers.mps.MTSUtils.parsePMT(r5);
                        r7 = r0;
                        r7.add(r5);
                        r7 = r5.getStreams();
                        r8 = r7.length;
                        r9 = r1;
                    L_0x0066:
                        if (r9 >= r8) goto L_0x008f;
                    L_0x0068:
                        r0 = r7[r9];
                        r2 = r1;
                        r3 = r0.getPid();
                        r3 = java.lang.Integer.valueOf(r3);
                        r2 = r2.containsKey(r3);
                        if (r2 != 0) goto L_0x008c;
                    L_0x007a:
                        r2 = r1;
                        r0 = r0.getPid();
                        r0 = java.lang.Integer.valueOf(r0);
                        r3 = new org.jcodec.codecs.mpeg12.MPSMediaInfo;
                        r3.<init>();
                        r2.put(r0, r3);
                    L_0x008c:
                        r9 = r9 + 1;
                        goto L_0x0066;
                    L_0x008f:
                        r7 = r5.getSectionNumber();
                        r5 = r5.getLastSectionNumber();
                        if (r7 != r5) goto L_0x009a;
                    L_0x0099:
                        r1 = r6;
                    L_0x009a:
                        r4.f33279g = r1;
                        r5 = 0;
                        r4.f33277e = r5;
                        goto L_0x00e3;
                    L_0x00a0:
                        r0 = r1;
                        r2 = java.lang.Integer.valueOf(r5);
                        r0 = r0.containsKey(r2);
                        if (r0 == 0) goto L_0x00e3;
                    L_0x00ac:
                        r0 = r1;	 Catch:{ MediaInfoDone -> 0x00bc }
                        r2 = java.lang.Integer.valueOf(r5);	 Catch:{ MediaInfoDone -> 0x00bc }
                        r0 = r0.get(r2);	 Catch:{ MediaInfoDone -> 0x00bc }
                        r0 = (org.jcodec.codecs.mpeg12.MPSMediaInfo) r0;	 Catch:{ MediaInfoDone -> 0x00bc }
                        r0.analyseBuffer(r7, r8);	 Catch:{ MediaInfoDone -> 0x00bc }
                        goto L_0x00e3;
                    L_0x00bc:
                        r7 = r2;
                        r8 = r1;
                        r9 = java.lang.Integer.valueOf(r5);
                        r8 = r8.get(r9);
                        r8 = (org.jcodec.codecs.mpeg12.MPSMediaInfo) r8;
                        r8 = r8.getInfos();
                        r7.addAll(r8);
                        r7 = r1;
                        r5 = java.lang.Integer.valueOf(r5);
                        r7.remove(r5);
                        r5 = r1;
                        r5 = r5.size();
                        if (r5 != 0) goto L_0x00e3;
                    L_0x00e2:
                        return r1;
                    L_0x00e3:
                        return r6;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.mpeg12.MTSMediaInfo.1.onPkt(int, boolean, java.nio.ByteBuffer, long):boolean");
                    }
                }.readTsFile(readableFileChannel);
                NIOUtils.closeQuietly(readableFileChannel);
                return arrayList2;
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

    public static void main(String[] strArr) throws IOException {
        for (MPEGTrackMetadata mPEGTrackMetadata : new MTSMediaInfo().getMediaInfo(new File(strArr[0]))) {
            System.out.println(mPEGTrackMetadata.codec);
        }
    }
}
