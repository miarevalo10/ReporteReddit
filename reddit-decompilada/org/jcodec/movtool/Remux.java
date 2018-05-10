package org.jcodec.movtool;

import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.model.Rational;
import org.jcodec.containers.mp4.Brand;
import org.jcodec.containers.mp4.MP4Packet;
import org.jcodec.containers.mp4.TrackType;
import org.jcodec.containers.mp4.WebOptimizedMP4Muxer;
import org.jcodec.containers.mp4.boxes.AudioSampleEntry;
import org.jcodec.containers.mp4.boxes.Edit;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.demuxer.AbstractMP4DemuxerTrack;
import org.jcodec.containers.mp4.demuxer.MP4Demuxer;
import org.jcodec.containers.mp4.demuxer.TimecodeMP4DemuxerTrack;
import org.jcodec.containers.mp4.muxer.AbstractMP4MuxerTrack;
import org.jcodec.containers.mp4.muxer.MP4Muxer;
import org.jcodec.containers.mp4.muxer.PCMMP4MuxerTrack;

public class Remux {

    public interface Handler {
        void handle(MovieBox movieBox) throws IOException;
    }

    protected MP4Packet processFrame(MP4Packet mP4Packet) {
        return mP4Packet;
    }

    public static void main1(java.lang.String[] r5) throws java.lang.Exception {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r5.length;
        if (r0 > 0) goto L_0x000b;
    L_0x0003:
        r5 = java.lang.System.out;
        r0 = "remux <movie>";
        r5.println(r0);
        return;
    L_0x000b:
        r0 = new java.io.File;
        r1 = 0;
        r5 = r5[r1];
        r0.<init>(r5);
        r5 = hidFile(r0);
        r0.renameTo(r5);
        r1 = new org.jcodec.movtool.Remux;	 Catch:{ Throwable -> 0x0024 }
        r1.<init>();	 Catch:{ Throwable -> 0x0024 }
        r2 = 0;	 Catch:{ Throwable -> 0x0024 }
        r1.remux(r0, r5, r2, r2);	 Catch:{ Throwable -> 0x0024 }
        return;
    L_0x0024:
        r1 = new java.io.File;
        r2 = r0.getParentFile();
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = r0.getName();
        r3.append(r4);
        r4 = ".error";
        r3.append(r4);
        r3 = r3.toString();
        r1.<init>(r2, r3);
        r0.renameTo(r1);
        r5.renameTo(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.movtool.Remux.main1(java.lang.String[]):void");
    }

    public void remux(File file, File file2, File file3, Handler handler) throws IOException {
        ReadableByteChannel readableFileChannel;
        ReadableByteChannel writableFileChannel;
        Throwable th;
        Remux remux = this;
        Handler handler2 = handler;
        ReadableByteChannel readableByteChannel = null;
        try {
            readableFileChannel = NIOUtils.readableFileChannel(file2);
            try {
                writableFileChannel = NIOUtils.writableFileChannel(file);
                try {
                    TimecodeMP4DemuxerTrack timecodeTrack;
                    MP4Demuxer mP4Demuxer = new MP4Demuxer(readableFileChannel);
                    if (file3 != null) {
                        SeekableByteChannel readableFileChannel2 = NIOUtils.readableFileChannel(file2);
                        try {
                            SeekableByteChannel seekableByteChannel = readableFileChannel2;
                            timecodeTrack = new MP4Demuxer(readableFileChannel2).getTimecodeTrack();
                            readableByteChannel = seekableByteChannel;
                        } catch (Throwable th2) {
                            th = th2;
                            readableByteChannel = readableFileChannel2;
                            NIOUtils.closeQuietly(readableFileChannel);
                            NIOUtils.closeQuietly(writableFileChannel);
                            NIOUtils.closeQuietly(readableByteChannel);
                            throw th;
                        }
                    }
                    timecodeTrack = null;
                    MP4Muxer withOldHeader = WebOptimizedMP4Muxer.withOldHeader(writableFileChannel, Brand.MOV, mP4Demuxer.getMovie());
                    List<AbstractMP4DemuxerTrack> audioTracks = mP4Demuxer.getAudioTracks();
                    List arrayList = new ArrayList();
                    for (AbstractMP4DemuxerTrack abstractMP4DemuxerTrack : audioTracks) {
                        PCMMP4MuxerTrack addPCMAudioTrack = withOldHeader.addPCMAudioTrack(((AudioSampleEntry) abstractMP4DemuxerTrack.getSampleEntries()[0]).getFormat());
                        arrayList.add(addPCMAudioTrack);
                        addPCMAudioTrack.setEdits(abstractMP4DemuxerTrack.getEdits());
                        addPCMAudioTrack.setName(abstractMP4DemuxerTrack.getName());
                    }
                    AbstractMP4DemuxerTrack videoTrack = mP4Demuxer.getVideoTrack();
                    AbstractMP4MuxerTrack addTrack = withOldHeader.addTrack(TrackType.VIDEO, (int) videoTrack.getTimescale());
                    addTrack.setTimecode(withOldHeader.addTimecodeTrack((int) videoTrack.getTimescale()));
                    copyEdits(videoTrack, addTrack, new Rational((int) videoTrack.getTimescale(), mP4Demuxer.getMovie().getTimescale()));
                    addTrack.addSampleEntries(videoTrack.getSampleEntries());
                    while (true) {
                        MP4Packet mP4Packet = (MP4Packet) videoTrack.nextFrame();
                        if (mP4Packet == null) {
                            break;
                        }
                        if (timecodeTrack != null) {
                            mP4Packet = timecodeTrack.getTimecode(mP4Packet);
                        }
                        mP4Packet = processFrame(mP4Packet);
                        addTrack.addFrame(mP4Packet);
                        for (int i = 0; i < audioTracks.size(); i++) {
                            ((AudioSampleEntry) ((AbstractMP4DemuxerTrack) audioTracks.get(i)).getSampleEntries()[0]).getSampleRate();
                            mP4Packet.getDuration();
                            videoTrack.getTimescale();
                            ((PCMMP4MuxerTrack) arrayList.get(i)).addSamples(((MP4Packet) ((AbstractMP4DemuxerTrack) audioTracks.get(i)).nextFrame()).getData());
                        }
                    }
                    MovieBox finalizeHeader = withOldHeader.finalizeHeader();
                    if (handler2 != null) {
                        handler2.handle(finalizeHeader);
                    }
                    withOldHeader.storeHeader(finalizeHeader);
                    NIOUtils.closeQuietly(readableFileChannel);
                    NIOUtils.closeQuietly(writableFileChannel);
                    NIOUtils.closeQuietly(readableByteChannel);
                } catch (Throwable th22) {
                    th = th22;
                    NIOUtils.closeQuietly(readableFileChannel);
                    NIOUtils.closeQuietly(writableFileChannel);
                    NIOUtils.closeQuietly(readableByteChannel);
                    throw th;
                }
            } catch (Throwable th222) {
                th = th222;
                writableFileChannel = null;
                NIOUtils.closeQuietly(readableFileChannel);
                NIOUtils.closeQuietly(writableFileChannel);
                NIOUtils.closeQuietly(readableByteChannel);
                throw th;
            }
        } catch (Throwable th2222) {
            th = th2222;
            readableFileChannel = null;
            writableFileChannel = readableFileChannel;
            NIOUtils.closeQuietly(readableFileChannel);
            NIOUtils.closeQuietly(writableFileChannel);
            NIOUtils.closeQuietly(readableByteChannel);
            throw th;
        }
    }

    private void copyEdits(AbstractMP4DemuxerTrack abstractMP4DemuxerTrack, AbstractMP4MuxerTrack abstractMP4MuxerTrack, Rational rational) {
        AbstractMP4DemuxerTrack<Edit> edits = abstractMP4DemuxerTrack.getEdits();
        List arrayList = new ArrayList();
        if (edits != null) {
            for (Edit edit : edits) {
                arrayList.add(new Edit(rational.multiply(edit.getDuration()), edit.getMediaTime(), edit.getRate()));
            }
            abstractMP4MuxerTrack.setEdits(arrayList);
        }
    }

    public static File hidFile(File file) {
        File parentFile = file.getParentFile();
        StringBuilder stringBuilder = new StringBuilder(".");
        stringBuilder.append(file.getName());
        File file2 = new File(parentFile, stringBuilder.toString());
        if (!file2.exists()) {
            return file2;
        }
        int i = 1;
        while (true) {
            File parentFile2 = file.getParentFile();
            StringBuilder stringBuilder2 = new StringBuilder(".");
            stringBuilder2.append(file.getName());
            stringBuilder2.append(".");
            int i2 = i + 1;
            stringBuilder2.append(i);
            parentFile = new File(parentFile2, stringBuilder2.toString());
            if (!parentFile.exists()) {
                return parentFile;
            }
            i = i2;
        }
    }
}
