package com.googlecode.mp4parser.authoring;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.ChunkOffsetBox;
import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.MovieBox;
import com.coremedia.iso.boxes.SchemeTypeBox;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.fragment.MovieExtendsBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.authoring.tracks.CencEncryptedTrack;
import com.googlecode.mp4parser.util.Path;
import com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox;
import com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox;
import com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat;
import com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair;
import com.mp4parser.iso23001.part7.TrackEncryptionBox;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class CencMp4TrackImplImpl extends Mp4TrackImpl implements CencEncryptedTrack {
    static final /* synthetic */ boolean f19275d = true;
    private List<CencSampleAuxiliaryDataFormat> f19276i;
    private UUID f19277j;

    private class FindSaioSaizPair {
        static final /* synthetic */ boolean f8877d = true;
        SampleAuxiliaryInformationSizesBox f8878a;
        SampleAuxiliaryInformationOffsetsBox f8879b;
        final /* synthetic */ CencMp4TrackImplImpl f8880c;
        private Container f8881e;

        static {
            Class cls = CencMp4TrackImplImpl.class;
        }

        public FindSaioSaizPair(CencMp4TrackImplImpl cencMp4TrackImplImpl, Container container) {
            this.f8880c = cencMp4TrackImplImpl;
            this.f8881e = container;
        }

        public final FindSaioSaizPair m7627a() {
            List boxes = this.f8881e.getBoxes(SampleAuxiliaryInformationSizesBox.class);
            List boxes2 = this.f8881e.getBoxes(SampleAuxiliaryInformationOffsetsBox.class);
            if (f8877d || boxes.size() == boxes2.size()) {
                this.f8878a = null;
                this.f8879b = null;
                int i = 0;
                while (i < boxes.size()) {
                    if ((this.f8878a == null && ((SampleAuxiliaryInformationSizesBox) boxes.get(i)).getAuxInfoType() == null) || "cenc".equals(((SampleAuxiliaryInformationSizesBox) boxes.get(i)).getAuxInfoType())) {
                        this.f8878a = (SampleAuxiliaryInformationSizesBox) boxes.get(i);
                    } else if (this.f8878a != null && this.f8878a.getAuxInfoType() == null && "cenc".equals(((SampleAuxiliaryInformationSizesBox) boxes.get(i)).getAuxInfoType())) {
                        this.f8878a = (SampleAuxiliaryInformationSizesBox) boxes.get(i);
                    } else {
                        throw new RuntimeException("Are there two cenc labeled saiz?");
                    }
                    if ((this.f8879b == null && ((SampleAuxiliaryInformationOffsetsBox) boxes2.get(i)).getAuxInfoType() == null) || "cenc".equals(((SampleAuxiliaryInformationOffsetsBox) boxes2.get(i)).getAuxInfoType())) {
                        this.f8879b = (SampleAuxiliaryInformationOffsetsBox) boxes2.get(i);
                    } else if (this.f8879b != null && this.f8879b.getAuxInfoType() == null && "cenc".equals(((SampleAuxiliaryInformationOffsetsBox) boxes2.get(i)).getAuxInfoType())) {
                        this.f8879b = (SampleAuxiliaryInformationOffsetsBox) boxes2.get(i);
                    } else {
                        throw new RuntimeException("Are there two cenc labeled saio?");
                    }
                    i++;
                }
                return this;
            }
            throw new AssertionError();
        }
    }

    public CencMp4TrackImplImpl(String str, TrackBox trackBox, IsoFile... isoFileArr) throws IOException {
        CencMp4TrackImplImpl cencMp4TrackImplImpl = this;
        AbstractContainerBox abstractContainerBox = trackBox;
        super(str, trackBox, isoFileArr);
        SchemeTypeBox schemeTypeBox = (SchemeTypeBox) Path.m7716a(abstractContainerBox, "mdia[0]/minf[0]/stbl[0]/stsd[0]/enc.[0]/sinf[0]/schm[0]");
        if (f19275d || (schemeTypeBox != null && (schemeTypeBox.getSchemeType().equals("cenc") || schemeTypeBox.getSchemeType().equals("cbc1")))) {
            cencMp4TrackImplImpl.f19276i = new ArrayList();
            long trackId = trackBox.getTrackHeaderBox().getTrackId();
            int i;
            int i2;
            if (trackBox.getParent().getBoxes(MovieExtendsBox.class).size() > 0) {
                Iterator it = ((Box) trackBox.getParent()).getParent().getBoxes(MovieFragmentBox.class).iterator();
                while (it.hasNext()) {
                    MovieFragmentBox movieFragmentBox = (MovieFragmentBox) it.next();
                    for (TrackFragmentBox trackFragmentBox : movieFragmentBox.getBoxes(TrackFragmentBox.class)) {
                        if (trackFragmentBox.getTrackFragmentHeaderBox().getTrackId() == trackId) {
                            Container parent;
                            long baseDataOffset;
                            TrackEncryptionBox trackEncryptionBox = (TrackEncryptionBox) Path.m7716a(abstractContainerBox, "mdia[0]/minf[0]/stbl[0]/stsd[0]/enc.[0]/sinf[0]/schi[0]/tenc[0]");
                            cencMp4TrackImplImpl.f19277j = trackEncryptionBox.getDefault_KID();
                            if (trackFragmentBox.getTrackFragmentHeaderBox().hasBaseDataOffset()) {
                                parent = ((Box) trackBox.getParent()).getParent();
                                baseDataOffset = trackFragmentBox.getTrackFragmentHeaderBox().getBaseDataOffset();
                            } else {
                                parent = movieFragmentBox;
                                baseDataOffset = 0;
                            }
                            FindSaioSaizPair a = new FindSaioSaizPair(cencMp4TrackImplImpl, trackFragmentBox).m7627a();
                            SampleAuxiliaryInformationOffsetsBox sampleAuxiliaryInformationOffsetsBox = a.f8879b;
                            SampleAuxiliaryInformationSizesBox sampleAuxiliaryInformationSizesBox = a.f8878a;
                            if (f19275d || sampleAuxiliaryInformationOffsetsBox != null) {
                                long[] offsets = sampleAuxiliaryInformationOffsetsBox.getOffsets();
                                if (!f19275d && offsets.length != trackFragmentBox.getBoxes(TrackRunBox.class).size()) {
                                    throw new AssertionError();
                                } else if (f19275d || sampleAuxiliaryInformationSizesBox != null) {
                                    List boxes = trackFragmentBox.getBoxes(TrackRunBox.class);
                                    long j = trackId;
                                    int i3 = 0;
                                    int i4 = 0;
                                    while (i3 < offsets.length) {
                                        int size = ((TrackRunBox) boxes.get(i3)).getEntries().size();
                                        long j2 = offsets[i3];
                                        Iterator it2 = it;
                                        long[] jArr = offsets;
                                        List list = boxes;
                                        i = i4;
                                        long j3 = 0;
                                        while (true) {
                                            i2 = i4 + size;
                                            if (i >= i2) {
                                                break;
                                            }
                                            j3 += (long) sampleAuxiliaryInformationSizesBox.getSize(i);
                                            i++;
                                            movieFragmentBox = movieFragmentBox;
                                        }
                                        ByteBuffer byteBuffer = parent.getByteBuffer(baseDataOffset + j2, j3);
                                        while (i4 < i2) {
                                            int i5 = i2;
                                            MovieFragmentBox movieFragmentBox2 = movieFragmentBox;
                                            cencMp4TrackImplImpl.f19276i.add(m20524a(trackEncryptionBox.getDefaultIvSize(), byteBuffer, (long) sampleAuxiliaryInformationSizesBox.getSize(i4)));
                                            i4++;
                                            movieFragmentBox = movieFragmentBox2;
                                            i2 = i5;
                                        }
                                        i3++;
                                        i4 = i2;
                                        it = it2;
                                        offsets = jArr;
                                        boxes = list;
                                    }
                                    trackId = j;
                                } else {
                                    throw new AssertionError();
                                }
                            }
                            throw new AssertionError();
                        }
                    }
                }
                return;
            }
            TrackEncryptionBox trackEncryptionBox2 = (TrackEncryptionBox) Path.m7716a(abstractContainerBox, "mdia[0]/minf[0]/stbl[0]/stsd[0]/enc.[0]/sinf[0]/schi[0]/tenc[0]");
            cencMp4TrackImplImpl.f19277j = trackEncryptionBox2.getDefault_KID();
            ChunkOffsetBox chunkOffsetBox = (ChunkOffsetBox) Path.m7716a(abstractContainerBox, "mdia[0]/minf[0]/stbl[0]/stco[0]");
            if (chunkOffsetBox == null) {
                chunkOffsetBox = (ChunkOffsetBox) Path.m7716a(abstractContainerBox, "mdia[0]/minf[0]/stbl[0]/co64[0]");
            }
            long[] blowup = trackBox.getSampleTableBox().getSampleToChunkBox().blowup(chunkOffsetBox.getChunkOffsets().length);
            FindSaioSaizPair a2 = new FindSaioSaizPair(cencMp4TrackImplImpl, (Container) Path.m7716a(abstractContainerBox, "mdia[0]/minf[0]/stbl[0]")).m7627a();
            SampleAuxiliaryInformationOffsetsBox a3 = a2.f8879b;
            SampleAuxiliaryInformationSizesBox b = a2.f8878a;
            Container parent2 = ((MovieBox) trackBox.getParent()).getParent();
            int i6;
            int i7;
            if (a3.getOffsets().length == 1) {
                i6 = 0;
                long j4 = a3.getOffsets()[0];
                if (b.getDefaultSampleInfoSize() > 0) {
                    i = (b.getSampleCount() * b.getDefaultSampleInfoSize()) + 0;
                } else {
                    i = 0;
                    i7 = i;
                    while (i < b.getSampleCount()) {
                        i7 += b.getSampleInfoSizes()[i];
                        i++;
                    }
                    i = i7;
                }
                ByteBuffer byteBuffer2 = parent2.getByteBuffer(j4, (long) i);
                while (i6 < b.getSampleCount()) {
                    cencMp4TrackImplImpl.f19276i.add(m20524a(trackEncryptionBox2.getDefaultIvSize(), byteBuffer2, (long) b.getSize(i6)));
                    i6++;
                }
                return;
            }
            i6 = 0;
            if (a3.getOffsets().length == blowup.length) {
                i2 = 0;
                int i8 = i2;
                while (i2 < blowup.length) {
                    long sampleCount;
                    SampleAuxiliaryInformationOffsetsBox sampleAuxiliaryInformationOffsetsBox2;
                    long j5 = a3.getOffsets()[i2];
                    if (b.getDefaultSampleInfoSize() > 0) {
                        sampleCount = (((long) b.getSampleCount()) * blowup[i2]) + 0;
                        sampleAuxiliaryInformationOffsetsBox2 = a3;
                    } else {
                        sampleAuxiliaryInformationOffsetsBox2 = a3;
                        sampleCount = 0;
                        for (int i9 = i6; ((long) i9) < blowup[i2]; i9++) {
                            sampleCount += (long) b.getSize(i8 + i9);
                        }
                    }
                    ByteBuffer byteBuffer3 = parent2.getByteBuffer(j5, sampleCount);
                    for (i7 = 0; ((long) i7) < blowup[i2]; i7++) {
                        cencMp4TrackImplImpl.f19276i.add(m20524a(trackEncryptionBox2.getDefaultIvSize(), byteBuffer3, (long) b.getSize(i8 + i7)));
                    }
                    i8 = (int) (((long) i8) + blowup[i2]);
                    i2++;
                    a3 = sampleAuxiliaryInformationOffsetsBox2;
                    i6 = 0;
                }
                return;
            }
            throw new RuntimeException("Number of saio offsets must be either 1 or number of chunks");
        }
        throw new AssertionError("Track must be CENC (cenc or cbc1) encrypted");
    }

    private static CencSampleAuxiliaryDataFormat m20524a(int i, ByteBuffer byteBuffer, long j) {
        CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat = new CencSampleAuxiliaryDataFormat();
        if (j > 0) {
            cencSampleAuxiliaryDataFormat.f10095a = new byte[i];
            byteBuffer.get(cencSampleAuxiliaryDataFormat.f10095a);
            if (j > ((long) i)) {
                cencSampleAuxiliaryDataFormat.f10096b = new Pair[IsoTypeReader.m3283c(byteBuffer)];
                for (i = 0; i < cencSampleAuxiliaryDataFormat.f10096b.length; i++) {
                    cencSampleAuxiliaryDataFormat.f10096b[i] = cencSampleAuxiliaryDataFormat.m8524a(IsoTypeReader.m3283c(byteBuffer), IsoTypeReader.m3280a(byteBuffer));
                }
            }
        }
        return cencSampleAuxiliaryDataFormat;
    }

    public final List<CencSampleAuxiliaryDataFormat> mo4059i() {
        return this.f19276i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("CencMp4TrackImpl{handler='");
        stringBuilder.append(this.f18486g);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final String mo2517f() {
        StringBuilder stringBuilder = new StringBuilder("enc(");
        stringBuilder.append(super.mo2517f());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
