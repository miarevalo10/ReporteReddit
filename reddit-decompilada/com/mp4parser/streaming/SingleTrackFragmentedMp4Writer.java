package com.mp4parser.streaming;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SingleTrackFragmentedMp4Writer implements StreamingMp4Writer {
    static final /* synthetic */ boolean f15626b = true;
    List<StreamingSample> f15627a;

    class C16811 extends WriteOnlyBox {
        C16811(String str) {
            super(str);
        }

        public long getSize() {
            long j = 8;
            for (StreamingSample a : SingleTrackFragmentedMp4Writer.this.f15627a) {
                j += (long) a.m8525a().remaining();
            }
            return j;
        }

        public void getBox(WritableByteChannel writableByteChannel) throws IOException {
            ArrayList arrayList = new ArrayList();
            long j = 8;
            for (StreamingSample a : SingleTrackFragmentedMp4Writer.this.f15627a) {
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
