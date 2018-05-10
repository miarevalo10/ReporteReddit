package com.instabug.library.internal.video;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import com.instabug.library.Instabug;
import com.instabug.library.internal.storage.AttachmentManager;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class InstabugVideoUtils {
    private static final String TAG = "InstabugVideoUtils";

    public static boolean isDurationMoreThanAutoRecMaxDuration(int i, int i2) {
        return i > i2;
    }

    @TargetApi(18)
    public String mux(String str, String str2) throws IOException {
        File videoFile = AttachmentManager.getVideoFile(Instabug.getApplicationContext());
        String absolutePath = videoFile.getAbsolutePath();
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str2);
        MediaExtractor mediaExtractor2 = new MediaExtractor();
        mediaExtractor2.setDataSource(str);
        StringBuilder stringBuilder = new StringBuilder("Video Extractor Track Count ");
        stringBuilder.append(mediaExtractor.getTrackCount());
        InstabugSDKLogger.m8359i(this, stringBuilder.toString());
        stringBuilder = new StringBuilder("Audio Extractor Track Count ");
        stringBuilder.append(mediaExtractor2.getTrackCount());
        InstabugSDKLogger.m8359i(this, stringBuilder.toString());
        stringBuilder = new StringBuilder("Video Extractor Track duration ");
        stringBuilder.append(mediaExtractor.getCachedDuration());
        InstabugSDKLogger.m8359i(this, stringBuilder.toString());
        stringBuilder = new StringBuilder("Audio Extractor Track duration ");
        stringBuilder.append(mediaExtractor2.getCachedDuration());
        InstabugSDKLogger.m8359i(this, stringBuilder.toString());
        MediaMuxer mediaMuxer = new MediaMuxer(absolutePath, 0);
        mediaExtractor.selectTrack(0);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(0);
        int addTrack = mediaMuxer.addTrack(trackFormat);
        mediaExtractor2.selectTrack(0);
        MediaFormat trackFormat2 = mediaExtractor2.getTrackFormat(0);
        int addTrack2 = mediaMuxer.addTrack(trackFormat2);
        StringBuilder stringBuilder2 = new StringBuilder("Video Format ");
        stringBuilder2.append(trackFormat.toString());
        InstabugSDKLogger.m8359i(this, stringBuilder2.toString());
        StringBuilder stringBuilder3 = new StringBuilder("Audio Format ");
        stringBuilder3.append(trackFormat2.toString());
        InstabugSDKLogger.m8359i(this, stringBuilder3.toString());
        ByteBuffer allocate = ByteBuffer.allocate(262144);
        ByteBuffer allocate2 = ByteBuffer.allocate(262144);
        BufferInfo bufferInfo = new BufferInfo();
        BufferInfo bufferInfo2 = new BufferInfo();
        mediaExtractor.seekTo(0, 0);
        mediaExtractor2.seekTo(0, 1);
        mediaMuxer.start();
        int i = 0;
        int i2 = i;
        while (i == 0) {
            int i3;
            bufferInfo.offset = 100;
            bufferInfo.size = mediaExtractor.readSampleData(allocate, 100);
            if (bufferInfo.size >= 0) {
                if (bufferInfo2.size >= 0) {
                    bufferInfo.presentationTimeUs = mediaExtractor.getSampleTime();
                    bufferInfo.flags = mediaExtractor.getSampleFlags();
                    mediaMuxer.writeSampleData(addTrack, allocate, bufferInfo);
                    mediaExtractor.advance();
                    i2++;
                    StringBuilder stringBuilder4 = new StringBuilder("Frame (");
                    stringBuilder4.append(i2);
                    stringBuilder4.append(") Video PresentationTimeUs:");
                    i3 = addTrack;
                    stringBuilder4.append(bufferInfo.presentationTimeUs);
                    stringBuilder4.append(" Flags:");
                    stringBuilder4.append(bufferInfo.flags);
                    stringBuilder4.append(" Size(KB) ");
                    stringBuilder4.append(bufferInfo.size / 1024);
                    InstabugSDKLogger.m8359i("ContentValues", stringBuilder4.toString());
                    StringBuilder stringBuilder5 = new StringBuilder("Frame (");
                    stringBuilder5.append(i2);
                    stringBuilder5.append(") Audio PresentationTimeUs:");
                    stringBuilder5.append(bufferInfo2.presentationTimeUs);
                    stringBuilder5.append(" Flags:");
                    stringBuilder5.append(bufferInfo2.flags);
                    stringBuilder5.append(" Size(KB) ");
                    stringBuilder5.append(bufferInfo2.size / 1024);
                    InstabugSDKLogger.m8359i(r0, stringBuilder5.toString());
                    addTrack = i3;
                }
            }
            i3 = addTrack;
            InstabugSDKLogger.m8359i(r0, "saw input EOS.");
            bufferInfo.size = 0;
            addTrack = i3;
            i = 1;
        }
        Object obj = null;
        while (obj == null) {
            bufferInfo2.offset = 100;
            bufferInfo2.size = mediaExtractor2.readSampleData(allocate2, 100);
            if (bufferInfo.size >= 0) {
                if (bufferInfo2.size >= 0) {
                    bufferInfo2.presentationTimeUs = mediaExtractor2.getSampleTime();
                    bufferInfo2.flags = mediaExtractor2.getSampleFlags();
                    mediaMuxer.writeSampleData(addTrack2, allocate2, bufferInfo2);
                    mediaExtractor2.advance();
                    StringBuilder stringBuilder6 = new StringBuilder("Frame (");
                    stringBuilder6.append(i2);
                    stringBuilder6.append(") Video PresentationTimeUs:");
                    stringBuilder6.append(bufferInfo.presentationTimeUs);
                    stringBuilder6.append(" Flags:");
                    stringBuilder6.append(bufferInfo.flags);
                    stringBuilder6.append(" Size(KB) ");
                    stringBuilder6.append(bufferInfo.size / 1024);
                    InstabugSDKLogger.m8359i(r0, stringBuilder6.toString());
                    stringBuilder6 = new StringBuilder("Frame (");
                    stringBuilder6.append(i2);
                    stringBuilder6.append(") Audio PresentationTimeUs:");
                    stringBuilder6.append(bufferInfo2.presentationTimeUs);
                    stringBuilder6.append(" Flags:");
                    stringBuilder6.append(bufferInfo2.flags);
                    stringBuilder6.append(" Size(KB) ");
                    stringBuilder6.append(bufferInfo2.size / 1024);
                    InstabugSDKLogger.m8359i(r0, stringBuilder6.toString());
                }
            }
            InstabugSDKLogger.m8359i(r0, "saw input EOS.");
            bufferInfo2.size = 0;
            obj = 1;
        }
        mediaMuxer.stop();
        mediaMuxer.release();
        return videoFile.getAbsolutePath();
    }

    public static int getVideoDuration(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        return Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
    }

    public static File startTrim(File file, File file2, int i) throws IOException {
        if (!isDurationMoreThanAutoRecMaxDuration(getVideoDuration(file.getPath()), i)) {
            return file;
        }
        int videoDuration = getVideoDuration(file.getPath());
        genVideoUsingMuxer(file.getPath(), file2.getPath(), videoDuration - i, videoDuration, false, true);
        return file2;
    }

    @android.annotation.TargetApi(21)
    private static void genVideoUsingMuxer(java.lang.String r10, java.lang.String r11, int r12, int r13, boolean r14, boolean r15) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = new android.media.MediaExtractor;
        r0.<init>();
        r0.setDataSource(r10);
        r1 = r0.getTrackCount();
        r2 = new android.media.MediaMuxer;
        r3 = 0;
        r2.<init>(r11, r3);
        r11 = new java.util.HashMap;
        r11.<init>(r1);
        r4 = -1;
        r5 = r4;
        r4 = r3;
    L_0x001a:
        if (r4 >= r1) goto L_0x0066;
    L_0x001c:
        r6 = r0.getTrackFormat(r4);
        r7 = "mime";
        r7 = r6.getString(r7);
        r8 = "audio/";
        r8 = r7.startsWith(r8);
        r9 = 1;
        if (r8 == 0) goto L_0x0032;
    L_0x002f:
        if (r14 == 0) goto L_0x0032;
    L_0x0031:
        goto L_0x003e;
    L_0x0032:
        r8 = "video/";
        r7 = r7.startsWith(r8);
        if (r7 == 0) goto L_0x003d;
    L_0x003a:
        if (r15 == 0) goto L_0x003d;
    L_0x003c:
        goto L_0x003e;
    L_0x003d:
        r9 = r3;
    L_0x003e:
        if (r9 == 0) goto L_0x0063;
    L_0x0040:
        r0.selectTrack(r4);
        r7 = r2.addTrack(r6);
        r8 = java.lang.Integer.valueOf(r4);
        r7 = java.lang.Integer.valueOf(r7);
        r11.put(r8, r7);
        r7 = "max-input-size";
        r7 = r6.containsKey(r7);
        if (r7 == 0) goto L_0x0063;
    L_0x005a:
        r7 = "max-input-size";
        r6 = r6.getInteger(r7);
        if (r6 <= r5) goto L_0x0063;
    L_0x0062:
        r5 = r6;
    L_0x0063:
        r4 = r4 + 1;
        goto L_0x001a;
    L_0x0066:
        if (r5 >= 0) goto L_0x006a;
    L_0x0068:
        r5 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
    L_0x006a:
        r14 = new android.media.MediaMetadataRetriever;
        r14.<init>();
        r14.setDataSource(r10);
        r15 = 24;
        r14 = r14.extractMetadata(r15);
        if (r14 == 0) goto L_0x0083;
    L_0x007a:
        r14 = java.lang.Integer.parseInt(r14);
        if (r14 < 0) goto L_0x0083;
    L_0x0080:
        r2.setOrientationHint(r14);
    L_0x0083:
        if (r12 <= 0) goto L_0x008c;
    L_0x0085:
        r12 = r12 * 1000;
        r14 = (long) r12;
        r12 = 2;
        r0.seekTo(r14, r12);
    L_0x008c:
        r12 = java.nio.ByteBuffer.allocate(r5);
        r14 = new android.media.MediaCodec$BufferInfo;
        r14.<init>();
        r2.start();	 Catch:{ IllegalStateException -> 0x00f6 }
    L_0x0098:
        r14.offset = r3;	 Catch:{ IllegalStateException -> 0x00f6 }
        r15 = r0.readSampleData(r12, r3);	 Catch:{ IllegalStateException -> 0x00f6 }
        r14.size = r15;	 Catch:{ IllegalStateException -> 0x00f6 }
        r15 = r14.size;	 Catch:{ IllegalStateException -> 0x00f6 }
        if (r15 >= 0) goto L_0x00ae;	 Catch:{ IllegalStateException -> 0x00f6 }
    L_0x00a4:
        r11 = "InstabugVideoUtils";	 Catch:{ IllegalStateException -> 0x00f6 }
        r12 = "Saw input EOS.";	 Catch:{ IllegalStateException -> 0x00f6 }
        com.instabug.library.util.InstabugSDKLogger.m8356d(r11, r12);	 Catch:{ IllegalStateException -> 0x00f6 }
        r14.size = r3;	 Catch:{ IllegalStateException -> 0x00f6 }
        goto L_0x00c6;	 Catch:{ IllegalStateException -> 0x00f6 }
    L_0x00ae:
        r4 = r0.getSampleTime();	 Catch:{ IllegalStateException -> 0x00f6 }
        r14.presentationTimeUs = r4;	 Catch:{ IllegalStateException -> 0x00f6 }
        if (r13 <= 0) goto L_0x00d5;	 Catch:{ IllegalStateException -> 0x00f6 }
    L_0x00b6:
        r4 = r14.presentationTimeUs;	 Catch:{ IllegalStateException -> 0x00f6 }
        r15 = r13 * 1000;	 Catch:{ IllegalStateException -> 0x00f6 }
        r6 = (long) r15;	 Catch:{ IllegalStateException -> 0x00f6 }
        r15 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));	 Catch:{ IllegalStateException -> 0x00f6 }
        if (r15 <= 0) goto L_0x00d5;	 Catch:{ IllegalStateException -> 0x00f6 }
    L_0x00bf:
        r11 = "InstabugVideoUtils";	 Catch:{ IllegalStateException -> 0x00f6 }
        r12 = "The current sample is over the trim end time.";	 Catch:{ IllegalStateException -> 0x00f6 }
        com.instabug.library.util.InstabugSDKLogger.m8356d(r11, r12);	 Catch:{ IllegalStateException -> 0x00f6 }
    L_0x00c6:
        r2.stop();	 Catch:{ IllegalStateException -> 0x00f6 }
        r11 = new java.io.File;	 Catch:{ IllegalStateException -> 0x00f6 }
        r11.<init>(r10);	 Catch:{ IllegalStateException -> 0x00f6 }
        r11.delete();	 Catch:{ IllegalStateException -> 0x00f6 }
        r2.release();
        return;
    L_0x00d5:
        r15 = r0.getSampleFlags();	 Catch:{ IllegalStateException -> 0x00f6 }
        r14.flags = r15;	 Catch:{ IllegalStateException -> 0x00f6 }
        r15 = r0.getSampleTrackIndex();	 Catch:{ IllegalStateException -> 0x00f6 }
        r15 = java.lang.Integer.valueOf(r15);	 Catch:{ IllegalStateException -> 0x00f6 }
        r15 = r11.get(r15);	 Catch:{ IllegalStateException -> 0x00f6 }
        r15 = (java.lang.Integer) r15;	 Catch:{ IllegalStateException -> 0x00f6 }
        r15 = r15.intValue();	 Catch:{ IllegalStateException -> 0x00f6 }
        r2.writeSampleData(r15, r12, r14);	 Catch:{ IllegalStateException -> 0x00f6 }
        r0.advance();	 Catch:{ IllegalStateException -> 0x00f6 }
        goto L_0x0098;
    L_0x00f4:
        r10 = move-exception;
        goto L_0x0101;
    L_0x00f6:
        r10 = "InstabugVideoUtils";	 Catch:{ all -> 0x00f4 }
        r11 = "The source video file is malformed";	 Catch:{ all -> 0x00f4 }
        com.instabug.library.util.InstabugSDKLogger.m8361w(r10, r11);	 Catch:{ all -> 0x00f4 }
        r2.release();
        return;
    L_0x0101:
        r2.release();
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.video.InstabugVideoUtils.genVideoUsingMuxer(java.lang.String, java.lang.String, int, int, boolean, boolean):void");
    }
}
