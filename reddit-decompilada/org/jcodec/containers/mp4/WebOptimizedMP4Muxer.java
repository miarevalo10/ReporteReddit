package org.jcodec.containers.mp4;

import com.coremedia.iso.boxes.ChunkOffset64BitBox;
import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.StaticChunkOffsetBox;
import com.coremedia.iso.boxes.mdat.MediaDataBox;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsets64Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsetsBox;
import org.jcodec.containers.mp4.boxes.Header;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.SampleToChunkBox;
import org.jcodec.containers.mp4.muxer.MP4Muxer;

public class WebOptimizedMP4Muxer extends MP4Muxer {
    private ByteBuffer header;
    private long headerPos;

    public static WebOptimizedMP4Muxer withOldHeader(SeekableByteChannel seekableByteChannel, Brand brand, MovieBox movieBox) throws IOException {
        int size = (int) movieBox.getHeader().getSize();
        movieBox = movieBox.getVideoTrack();
        size = (size - (((SampleToChunkBox) Box.findFirst(movieBox, SampleToChunkBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, com.coremedia.iso.boxes.SampleToChunkBox.TYPE)).getSampleToChunk().length * 12)) + 12;
        ChunkOffsetsBox chunkOffsetsBox = (ChunkOffsetsBox) Box.findFirst(movieBox, ChunkOffsetsBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, StaticChunkOffsetBox.TYPE);
        if (chunkOffsetsBox != null) {
            size = (size - (chunkOffsetsBox.getChunkOffsets().length << 2)) + (movieBox.getFrameCount() << 3);
        } else {
            size = (size - (((ChunkOffsets64Box) Box.findFirst(movieBox, ChunkOffsets64Box.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, ChunkOffset64BitBox.TYPE)).getChunkOffsets().length << 3)) + (movieBox.getFrameCount() << 3);
        }
        return new WebOptimizedMP4Muxer(seekableByteChannel, brand, size + (size >> 1));
    }

    public WebOptimizedMP4Muxer(SeekableByteChannel seekableByteChannel, Brand brand, int i) throws IOException {
        super(seekableByteChannel, brand);
        this.headerPos = seekableByteChannel.position() - 24;
        seekableByteChannel.position(this.headerPos);
        this.header = ByteBuffer.allocate(i);
        seekableByteChannel.write(this.header);
        this.header.clear();
        new Header("wide", 8).write(seekableByteChannel);
        new Header(MediaDataBox.TYPE, 1).write(seekableByteChannel);
        this.mdatOffset = seekableByteChannel.position();
        NIOUtils.writeLong(seekableByteChannel, null);
    }

    public void storeHeader(org.jcodec.containers.mp4.boxes.MovieBox r8) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = r7.out;
        r0 = r0.position();
        r2 = r7.mdatOffset;
        r2 = r0 - r2;
        r4 = 8;
        r2 = r2 + r4;
        r4 = r7.out;
        r5 = r7.mdatOffset;
        r4.position(r5);
        r4 = r7.out;
        org.jcodec.common.NIOUtils.writeLong(r4, r2);
        r2 = r7.out;
        r3 = r7.headerPos;
        r2.position(r3);
        r2 = r7.header;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0061 }
        r8.write(r2);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0061 }
        r2 = r7.header;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0061 }
        r2.flip();	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0061 }
        r2 = r7.header;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0061 }
        r2 = r2.capacity();	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0061 }
        r3 = r7.header;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0061 }
        r3 = r3.limit();	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0061 }
        r2 = r2 - r3;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0061 }
        r3 = 8;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0061 }
        if (r2 >= r3) goto L_0x004a;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0061 }
    L_0x003b:
        r4 = r7.header;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0061 }
        r4 = r4.duplicate();	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0061 }
        r5 = r7.header;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0061 }
        r5 = r5.capacity();	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0061 }
        r4.putInt(r5);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0061 }
    L_0x004a:
        r4 = r7.out;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0061 }
        r5 = r7.header;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0061 }
        r4.write(r5);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0061 }
        if (r2 < r3) goto L_0x0060;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0061 }
    L_0x0053:
        r3 = new org.jcodec.containers.mp4.boxes.Header;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0061 }
        r4 = "free";	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0061 }
        r5 = (long) r2;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0061 }
        r3.<init>(r4, r5);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0061 }
        r2 = r7.out;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0061 }
        r3.write(r2);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0061 }
    L_0x0060:
        return;
    L_0x0061:
        r2 = "Could not web-optimize, header is bigger then allocated space.";
        org.jcodec.common.logging.Logger.warn(r2);
        r2 = new org.jcodec.containers.mp4.boxes.Header;
        r3 = "free";
        r4 = r7.header;
        r4 = r4.remaining();
        r4 = (long) r4;
        r2.<init>(r3, r4);
        r3 = r7.out;
        r2.write(r3);
        r2 = r7.out;
        r2.position(r0);
        r0 = r7.out;
        org.jcodec.containers.mp4.MP4Util.writeMovie(r0, r8);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.containers.mp4.WebOptimizedMP4Muxer.storeHeader(org.jcodec.containers.mp4.boxes.MovieBox):void");
    }
}
