package com.mp4parser.streaming;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MultiTrackFragmentedMp4Writer implements StreamingMp4Writer {
    static final /* synthetic */ boolean f15624b = true;
    Map<StreamingTrack, List<StreamingSample>> f15625a;

    class C16801 extends WriteOnlyBox {
        private final /* synthetic */ StreamingTrack val$streamingTrack;

        C16801(String str, StreamingTrack streamingTrack) {
            this.val$streamingTrack = streamingTrack;
            super(str);
        }

        public long getSize() {
            long j = 8;
            for (StreamingSample a : (List) MultiTrackFragmentedMp4Writer.this.f15625a.get(this.val$streamingTrack)) {
                j += (long) a.m8525a().remaining();
            }
            return j;
        }

        public void getBox(WritableByteChannel writableByteChannel) throws IOException {
            ArrayList arrayList = new ArrayList();
            long j = 8;
            for (StreamingSample a : (List) MultiTrackFragmentedMp4Writer.this.f15625a.get(this.val$streamingTrack)) {
                ByteBuffer a2 = a.m8525a();
                arrayList.add(a2);
                j += (long) a2.remaining();
            }
            ByteBuffer allocate = ByteBuffer.allocate(8);
            IsoTypeWriter.m3300b(allocate, j);
            allocate.put(IsoFile.m17057a(getType()));
            writableByteChannel.write((ByteBuffer) allocate.rewind());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                writableByteChannel.write((ByteBuffer) it.next());
            }
        }
    }

    public void close() {
    }
}
