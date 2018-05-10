package com.google.android.exoplayer2.metadata.emsg;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;

public final class EventMessageDecoder implements MetadataDecoder {
    public final Metadata mo1396a(MetadataInputBuffer metadataInputBuffer) {
        metadataInputBuffer = metadataInputBuffer.c;
        byte[] array = metadataInputBuffer.array();
        metadataInputBuffer = metadataInputBuffer.limit();
        ParsableByteArray parsableByteArray = new ParsableByteArray(array, metadataInputBuffer);
        String q = parsableByteArray.m4266q();
        String q2 = parsableByteArray.m4266q();
        long h = parsableByteArray.m4257h();
        parsableByteArray.m4251d(4);
        h = (parsableByteArray.m4257h() * 1000) / h;
        long h2 = parsableByteArray.m4257h();
        byte[] copyOfRange = Arrays.copyOfRange(array, parsableByteArray.f5257b, metadataInputBuffer);
        return new Metadata(new EventMessage(q, q2, h, h2, copyOfRange));
    }
}
