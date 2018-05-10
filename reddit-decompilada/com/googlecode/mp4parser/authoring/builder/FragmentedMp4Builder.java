package com.googlecode.mp4parser.authoring.builder;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.mdat.MediaDataBox;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.util.CastUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.List;
import java.util.logging.Logger;

public class FragmentedMp4Builder {
    static final /* synthetic */ boolean f8908a = true;
    private static final Logger f8909b = Logger.getLogger(FragmentedMp4Builder.class.getName());

    class AnonymousClass1Mdat implements Box {
        Container parent;
        long size_ = -1;
        private final /* synthetic */ long val$endSample;
        private final /* synthetic */ long val$startSample;
        private final /* synthetic */ Track val$track;

        public String getType() {
            return MediaDataBox.TYPE;
        }

        public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        }

        AnonymousClass1Mdat(long j, long j2, Track track) {
            this.val$startSample = j;
            this.val$endSample = j2;
            this.val$track = track;
        }

        public Container getParent() {
            return this.parent;
        }

        public void setParent(Container container) {
            this.parent = container;
        }

        public long getOffset() {
            throw new RuntimeException("Doesn't have any meaning for programmatically created boxes");
        }

        public long getSize() {
            if (this.size_ != -1) {
                return this.size_;
            }
            long j = 8;
            for (Sample a : FragmentedMp4Builder.m7657a(this.val$startSample, this.val$endSample, this.val$track)) {
                j += a.mo2521a();
            }
            this.size_ = j;
            return j;
        }

        public void getBox(WritableByteChannel writableByteChannel) throws IOException {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            IsoTypeWriter.m3300b(allocate, (long) CastUtils.m7705a(getSize()));
            allocate.put(IsoFile.m17057a(getType()));
            allocate.rewind();
            writableByteChannel.write(allocate);
            for (Sample a : FragmentedMp4Builder.m7657a(this.val$startSample, this.val$endSample, this.val$track)) {
                a.mo2522a(writableByteChannel);
            }
        }
    }

    protected static List<Sample> m7657a(long j, long j2, Track track) {
        return track.mo3623j().subList(CastUtils.m7705a(j) - 1, CastUtils.m7705a(j2) - 1);
    }
}
