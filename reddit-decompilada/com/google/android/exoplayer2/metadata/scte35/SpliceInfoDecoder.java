package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataDecoderException;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public final class SpliceInfoDecoder implements MetadataDecoder {
    private final ParsableByteArray f13231a = new ParsableByteArray();
    private final ParsableBitArray f13232b = new ParsableBitArray();
    private TimestampAdjuster f13233c;

    public final Metadata mo1396a(MetadataInputBuffer metadataInputBuffer) throws MetadataDecoderException {
        if (this.f13233c == null || metadataInputBuffer.f16862f != this.f13233c.m4284a()) {
            this.f13233c = new TimestampAdjuster(metadataInputBuffer.d);
            this.f13233c.m4288c(metadataInputBuffer.d - metadataInputBuffer.f16862f);
        }
        metadataInputBuffer = metadataInputBuffer.c;
        byte[] array = metadataInputBuffer.array();
        int limit = metadataInputBuffer.limit();
        this.f13231a.m4244a(array, limit);
        this.f13232b.m4232a(array, limit);
        this.f13232b.m4234b(39);
        long c = (((long) this.f13232b.m4236c(1)) << 32) | ((long) this.f13232b.m4236c(32));
        this.f13232b.m4234b(20);
        metadataInputBuffer = this.f13232b.m4236c(12);
        int c2 = this.f13232b.m4236c(8);
        TimeSignalCommand timeSignalCommand = null;
        this.f13231a.m4251d(14);
        if (c2 == 0) {
            timeSignalCommand = new SpliceNullCommand();
        } else if (c2 != 255) {
            switch (c2) {
                case 4:
                    timeSignalCommand = SpliceScheduleCommand.m17191a(this.f13231a);
                    break;
                case 5:
                    timeSignalCommand = SpliceInsertCommand.m17190a(this.f13231a, c, this.f13233c);
                    break;
                case 6:
                    timeSignalCommand = TimeSignalCommand.m17193a(this.f13231a, c, this.f13233c);
                    break;
                default:
                    break;
            }
        } else {
            timeSignalCommand = PrivateCommand.m17189a(this.f13231a, metadataInputBuffer, c);
        }
        if (timeSignalCommand == null) {
            return new Metadata(new Entry[0]);
        }
        return new Metadata(timeSignalCommand);
    }
}
