package com.googlecode.mp4parser.authoring.builder;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.ChunkOffsetBox;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.DataEntryUrlBox;
import com.coremedia.iso.boxes.DataInformationBox;
import com.coremedia.iso.boxes.DataReferenceBox;
import com.coremedia.iso.boxes.EditBox;
import com.coremedia.iso.boxes.EditListBox;
import com.coremedia.iso.boxes.EditListBox.Entry;
import com.coremedia.iso.boxes.FileTypeBox;
import com.coremedia.iso.boxes.HandlerBox;
import com.coremedia.iso.boxes.HintMediaHeaderBox;
import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaHeaderBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.MovieBox;
import com.coremedia.iso.boxes.MovieHeaderBox;
import com.coremedia.iso.boxes.NullMediaHeaderBox;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.SampleToChunkBox;
import com.coremedia.iso.boxes.SoundMediaHeaderBox;
import com.coremedia.iso.boxes.StaticChunkOffsetBox;
import com.coremedia.iso.boxes.SubtitleMediaHeaderBox;
import com.coremedia.iso.boxes.SyncSampleBox;
import com.coremedia.iso.boxes.TimeToSampleBox;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.coremedia.iso.boxes.VideoMediaHeaderBox;
import com.coremedia.iso.boxes.mdat.MediaDataBox;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.authoring.Edit;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.tracks.CencEncryptedTrack;
import com.googlecode.mp4parser.boxes.dece.SampleEncryptionBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.Logger;
import com.googlecode.mp4parser.util.Math;
import com.googlecode.mp4parser.util.Mp4Arrays;
import com.googlecode.mp4parser.util.Path;
import com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox;
import com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox;
import com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DefaultMp4Builder {
    static final /* synthetic */ boolean f8901e = true;
    private static Logger f8902f = Logger.m7708a(DefaultMp4Builder.class);
    Map<Track, StaticChunkOffsetBox> f8903a = new HashMap();
    Set<SampleAuxiliaryInformationOffsetsBox> f8904b = new HashSet();
    HashMap<Track, List<Sample>> f8905c = new HashMap();
    HashMap<Track, long[]> f8906d = new HashMap();
    private Fragmenter f8907g;

    class C04601 implements Comparator<Track> {
        final /* synthetic */ DefaultMp4Builder f8899a;

        C04601(DefaultMp4Builder defaultMp4Builder) {
            this.f8899a = defaultMp4Builder;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return CastUtils.m7705a(((Track) obj).mo3626m().f8896i - ((Track) obj2).mo3626m().f8896i);
        }
    }

    private class InterleaveChunkMdat implements Box {
        List<List<Sample>> chunkList;
        long contentSize;
        Container parent;
        final /* synthetic */ DefaultMp4Builder this$0;
        List<Track> tracks;

        class C04611 implements Comparator<Track> {
            final /* synthetic */ InterleaveChunkMdat f8900a;

            C04611(InterleaveChunkMdat interleaveChunkMdat) {
                this.f8900a = interleaveChunkMdat;
            }

            public /* synthetic */ int compare(Object obj, Object obj2) {
                return CastUtils.m7705a(((Track) obj).mo3626m().f8896i - ((Track) obj2).mo3626m().f8896i);
            }
        }

        private boolean isSmallBox(long j) {
            return j + 8 < 4294967296L;
        }

        public String getType() {
            return MediaDataBox.TYPE;
        }

        public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        }

        private InterleaveChunkMdat(DefaultMp4Builder defaultMp4Builder, Movie movie, Map<Track, int[]> map, long j) {
            Map<Track, int[]> map2 = map;
            this.this$0 = defaultMp4Builder;
            this.chunkList = new ArrayList();
            this.contentSize = j;
            this.tracks = movie.f8887b;
            List<Track> arrayList = new ArrayList(map.keySet());
            Collections.sort(arrayList, new C04611(this));
            Map hashMap = new HashMap();
            Map hashMap2 = new HashMap();
            Map hashMap3 = new HashMap();
            for (Track track : arrayList) {
                hashMap.put(track, Integer.valueOf(0));
                hashMap2.put(track, Integer.valueOf(0));
                hashMap3.put(track, Double.valueOf(0.0d));
            }
            while (true) {
                Track track2 = null;
                for (Track track3 : arrayList) {
                    if ((track2 == null || ((Double) hashMap3.get(track3)).doubleValue() < ((Double) hashMap3.get(track2)).doubleValue()) && ((Integer) hashMap.get(track3)).intValue() < ((int[]) map2.get(track3)).length) {
                        track2 = track3;
                    }
                }
                if (track2 != null) {
                    int i;
                    int intValue = ((Integer) hashMap.get(track2)).intValue();
                    int i2 = ((int[]) map2.get(track2))[intValue];
                    int intValue2 = ((Integer) hashMap2.get(track2)).intValue();
                    double doubleValue = ((Double) hashMap3.get(track2)).doubleValue();
                    int i3 = intValue2;
                    while (true) {
                        i = intValue2 + i2;
                        if (i3 >= i) {
                            break;
                        }
                        doubleValue += ((double) track2.mo3624k()[i3]) / ((double) track2.mo3626m().f8889b);
                        i3++;
                        i2 = i2;
                        intValue = intValue;
                    }
                    r0.chunkList.add(track2.mo3623j().subList(intValue2, i));
                    hashMap.put(track2, Integer.valueOf(intValue + 1));
                    hashMap2.put(track2, Integer.valueOf(i));
                    hashMap3.put(track2, Double.valueOf(doubleValue));
                } else {
                    return;
                }
            }
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

        public long getDataOffset() {
            long j = 16;
            Container container = this;
            while (container instanceof Box) {
                Box box = (Box) container;
                for (Object obj : box.getParent().getBoxes()) {
                    if (container == obj) {
                        break;
                    }
                    j += obj.getSize();
                }
                container = box.getParent();
            }
            return j;
        }

        public long getSize() {
            return 16 + this.contentSize;
        }

        public void getBox(WritableByteChannel writableByteChannel) throws IOException {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            long size = getSize();
            if (isSmallBox(size)) {
                IsoTypeWriter.m3300b(allocate, size);
            } else {
                IsoTypeWriter.m3300b(allocate, 1);
            }
            allocate.put(IsoFile.m17057a(MediaDataBox.TYPE));
            if (isSmallBox(size)) {
                allocate.put(new byte[8]);
            } else {
                IsoTypeWriter.m3296a(allocate, size);
            }
            allocate.rewind();
            writableByteChannel.write(allocate);
            Logger a = DefaultMp4Builder.f8902f;
            StringBuilder stringBuilder = new StringBuilder("About to write ");
            stringBuilder.append(this.contentSize);
            a.mo2531a(stringBuilder.toString());
            size = 0;
            long j = 0;
            for (List<Sample> it : this.chunkList) {
                for (Sample sample : it) {
                    sample.mo2522a(writableByteChannel);
                    size += sample.mo2521a();
                    if (size > 1048576) {
                        size -= 1048576;
                        j++;
                        Logger a2 = DefaultMp4Builder.f8902f;
                        StringBuilder stringBuilder2 = new StringBuilder("Written ");
                        stringBuilder2.append(j);
                        stringBuilder2.append("MB");
                        a2.mo2531a(stringBuilder2.toString());
                    }
                }
            }
        }
    }

    private static long m7645a(long[] jArr) {
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        return j;
    }

    public final Container m7656a(Movie movie) {
        if (this.f8907g == null) {
            this.f8907g = new BetterFragmenter();
        }
        Logger logger = f8902f;
        StringBuilder stringBuilder = new StringBuilder("Creating movie ");
        stringBuilder.append(movie);
        logger.mo2531a(stringBuilder.toString());
        Iterator it = movie.f8887b.iterator();
        while (true) {
            int i = 0;
            if (!it.hasNext()) {
                break;
            }
            Track track = (Track) it.next();
            List j = track.mo3623j();
            this.f8905c.put(track, j);
            Object obj = new long[j.size()];
            while (i < obj.length) {
                obj[i] = ((Sample) j.get(i)).mo2521a();
                i++;
            }
            this.f8906d.put(track, obj);
        }
        Container basicContainer = new BasicContainer();
        List linkedList = new LinkedList();
        linkedList.add("mp42");
        linkedList.add("iso6");
        linkedList.add(VisualSampleEntry.TYPE3);
        linkedList.add("isom");
        basicContainer.addBox(new FileTypeBox("iso6", 1, linkedList));
        Map hashMap = new HashMap();
        for (Track track2 : movie.f8887b) {
            hashMap.put(track2, m7653a(track2));
        }
        Box a = m7648a(movie, hashMap);
        basicContainer.addBox(a);
        long j2 = 0;
        for (SampleSizeBox sampleSizes : Path.m7718a(a, "trak/mdia/minf/stbl/stsz")) {
            j2 += m7645a(sampleSizes.getSampleSizes());
        }
        f8902f.mo2531a("About to create mdat");
        InterleaveChunkMdat interleaveChunkMdat = new InterleaveChunkMdat(movie, hashMap, j2);
        basicContainer.addBox(interleaveChunkMdat);
        f8902f.mo2531a("mdat crated");
        long dataOffset = interleaveChunkMdat.getDataOffset();
        for (StaticChunkOffsetBox chunkOffsets : this.f8903a.values()) {
            long[] chunkOffsets2 = chunkOffsets.getChunkOffsets();
            for (movie = null; movie < chunkOffsets2.length; movie++) {
                chunkOffsets2[movie] = chunkOffsets2[movie] + dataOffset;
            }
        }
        for (SampleAuxiliaryInformationOffsetsBox sampleAuxiliaryInformationOffsetsBox : this.f8904b) {
            long size = sampleAuxiliaryInformationOffsetsBox.getSize() + 44;
            Box box = sampleAuxiliaryInformationOffsetsBox;
            while (true) {
                Container parent = box.getParent();
                for (Box box2 : parent.getBoxes()) {
                    if (box2 == box) {
                        break;
                    }
                    size += box2.getSize();
                }
                if (!(parent instanceof Box)) {
                    break;
                }
                Object obj2 = parent;
            }
            long[] offsets = sampleAuxiliaryInformationOffsetsBox.getOffsets();
            for (int i2 = 0; i2 < offsets.length; i2++) {
                offsets[i2] = offsets[i2] + size;
            }
            sampleAuxiliaryInformationOffsetsBox.setOffsets(offsets);
        }
        return basicContainer;
    }

    private MovieBox m7648a(Movie movie, Map<Track, int[]> map) {
        long j;
        Movie movie2 = movie;
        MovieBox movieBox = new MovieBox();
        Box movieHeaderBox = new MovieHeaderBox();
        movieHeaderBox.setCreationTime(new Date());
        movieHeaderBox.setModificationTime(new Date());
        movieHeaderBox.setMatrix(movie2.f8886a);
        long b = m7654b(movie);
        long j2 = 0;
        for (Track track : movie2.f8887b) {
            DefaultMp4Builder defaultMp4Builder = this;
            Map<Track, int[]> map2 = map;
            if (track.mo2518g() != null) {
                if (!track.mo2518g().isEmpty()) {
                    double d = 0.0d;
                    for (Edit edit : track.mo2518g()) {
                        d += (double) ((long) edit.f8883b);
                    }
                    j = (long) (d * ((double) b));
                    if (j > j2) {
                        j2 = j;
                    }
                }
            }
            j = (track.mo2516e() * b) / track.mo3626m().f8889b;
            if (j > j2) {
                j2 = j;
            }
        }
        movieHeaderBox.setDuration(j2);
        movieHeaderBox.setTimescale(b);
        j = 0;
        for (Track track2 : movie2.f8887b) {
            defaultMp4Builder = this;
            map2 = map;
            if (j < track2.mo3626m().f8896i) {
                j = track2.mo3626m().f8896i;
            }
        }
        movieHeaderBox.setNextTrackId(j + 1);
        movieBox.addBox(movieHeaderBox);
        for (Track a : movie2.f8887b) {
            movieBox.addBox(m7649a(a, movie2, (Map) map));
        }
        return movieBox;
    }

    private TrackBox m7649a(Track track, Movie movie, Map<Track, int[]> map) {
        Object handlerBox;
        Box dataInformationBox;
        Object dataReferenceBox;
        Box dataEntryUrlBox;
        TrackBox trackBox = new TrackBox();
        Box trackHeaderBox = new TrackHeaderBox();
        trackHeaderBox.setEnabled(true);
        trackHeaderBox.setInMovie(true);
        trackHeaderBox.setMatrix(track.mo3626m().f8892e);
        trackHeaderBox.setAlternateGroup(track.mo3626m().f8897j);
        trackHeaderBox.setCreationTime(track.mo3626m().f8891d);
        if (track.mo2518g() != null) {
            if (!track.mo2518g().isEmpty()) {
                long j = 0;
                for (Edit edit : track.mo2518g()) {
                    j += (long) edit.f8883b;
                }
                trackHeaderBox.setDuration(j * track.mo3626m().f8889b);
                trackHeaderBox.setHeight(track.mo3626m().f8894g);
                trackHeaderBox.setWidth(track.mo3626m().f8893f);
                trackHeaderBox.setLayer(track.mo3626m().f8898k);
                trackHeaderBox.setModificationTime(new Date());
                trackHeaderBox.setTrackId(track.mo3626m().f8896i);
                trackHeaderBox.setVolume(track.mo3626m().f8895h);
                trackBox.addBox(trackHeaderBox);
                trackBox.addBox(m7646a(track, movie));
                movie = new MediaBox();
                trackBox.addBox(movie);
                trackHeaderBox = new MediaHeaderBox();
                trackHeaderBox.setCreationTime(track.mo3626m().f8891d);
                trackHeaderBox.setDuration(track.mo2516e());
                trackHeaderBox.setTimescale(track.mo3626m().f8889b);
                trackHeaderBox.setLanguage(track.mo3626m().f8888a);
                movie.addBox(trackHeaderBox);
                handlerBox = new HandlerBox();
                movie.addBox(handlerBox);
                handlerBox.setHandlerType(track.mo3627n());
                trackHeaderBox = new MediaInformationBox();
                if (track.mo3627n().equals("vide")) {
                    trackHeaderBox.addBox(new VideoMediaHeaderBox());
                } else if (track.mo3627n().equals("soun")) {
                    trackHeaderBox.addBox(new SoundMediaHeaderBox());
                } else if (track.mo3627n().equals("text")) {
                    trackHeaderBox.addBox(new NullMediaHeaderBox());
                } else if (track.mo3627n().equals("subt")) {
                    trackHeaderBox.addBox(new SubtitleMediaHeaderBox());
                } else if (track.mo3627n().equals("hint")) {
                    trackHeaderBox.addBox(new HintMediaHeaderBox());
                } else if (track.mo3627n().equals("sbtl")) {
                    trackHeaderBox.addBox(new NullMediaHeaderBox());
                }
                dataInformationBox = new DataInformationBox();
                dataReferenceBox = new DataReferenceBox();
                dataInformationBox.addBox(dataReferenceBox);
                dataEntryUrlBox = new DataEntryUrlBox();
                dataEntryUrlBox.setFlags(1);
                dataReferenceBox.addBox(dataEntryUrlBox);
                trackHeaderBox.addBox(dataInformationBox);
                trackHeaderBox.addBox(m7647a(track, (Map) map));
                movie.addBox(trackHeaderBox);
                movie = f8902f;
                map = new StringBuilder("done with trak for track_");
                map.append(track.mo3626m().f8896i);
                movie.mo2531a(map.toString());
                return trackBox;
            }
        }
        trackHeaderBox.setDuration((track.mo2516e() * m7654b(movie)) / track.mo3626m().f8889b);
        trackHeaderBox.setHeight(track.mo3626m().f8894g);
        trackHeaderBox.setWidth(track.mo3626m().f8893f);
        trackHeaderBox.setLayer(track.mo3626m().f8898k);
        trackHeaderBox.setModificationTime(new Date());
        trackHeaderBox.setTrackId(track.mo3626m().f8896i);
        trackHeaderBox.setVolume(track.mo3626m().f8895h);
        trackBox.addBox(trackHeaderBox);
        trackBox.addBox(m7646a(track, movie));
        movie = new MediaBox();
        trackBox.addBox(movie);
        trackHeaderBox = new MediaHeaderBox();
        trackHeaderBox.setCreationTime(track.mo3626m().f8891d);
        trackHeaderBox.setDuration(track.mo2516e());
        trackHeaderBox.setTimescale(track.mo3626m().f8889b);
        trackHeaderBox.setLanguage(track.mo3626m().f8888a);
        movie.addBox(trackHeaderBox);
        handlerBox = new HandlerBox();
        movie.addBox(handlerBox);
        handlerBox.setHandlerType(track.mo3627n());
        trackHeaderBox = new MediaInformationBox();
        if (track.mo3627n().equals("vide")) {
            trackHeaderBox.addBox(new VideoMediaHeaderBox());
        } else if (track.mo3627n().equals("soun")) {
            trackHeaderBox.addBox(new SoundMediaHeaderBox());
        } else if (track.mo3627n().equals("text")) {
            trackHeaderBox.addBox(new NullMediaHeaderBox());
        } else if (track.mo3627n().equals("subt")) {
            trackHeaderBox.addBox(new SubtitleMediaHeaderBox());
        } else if (track.mo3627n().equals("hint")) {
            trackHeaderBox.addBox(new HintMediaHeaderBox());
        } else if (track.mo3627n().equals("sbtl")) {
            trackHeaderBox.addBox(new NullMediaHeaderBox());
        }
        dataInformationBox = new DataInformationBox();
        dataReferenceBox = new DataReferenceBox();
        dataInformationBox.addBox(dataReferenceBox);
        dataEntryUrlBox = new DataEntryUrlBox();
        dataEntryUrlBox.setFlags(1);
        dataReferenceBox.addBox(dataEntryUrlBox);
        trackHeaderBox.addBox(dataInformationBox);
        trackHeaderBox.addBox(m7647a(track, (Map) map));
        movie.addBox(trackHeaderBox);
        movie = f8902f;
        map = new StringBuilder("done with trak for track_");
        map.append(track.mo3626m().f8896i);
        movie.mo2531a(map.toString());
        return trackBox;
    }

    private static Box m7646a(Track track, Movie movie) {
        if (track.mo2518g() == null || track.mo2518g().size() <= 0) {
            return null;
        }
        Box editListBox = new EditListBox();
        editListBox.setVersion(0);
        List arrayList = new ArrayList();
        for (Edit edit : track.mo2518g()) {
            arrayList.add(new Entry(editListBox, Math.round(edit.f8883b * ((double) movie.m7628a())), (edit.f8884c * track.mo3626m().f8889b) / edit.f8882a, edit.f8885d));
        }
        editListBox.setEntries(arrayList);
        track = new EditBox();
        track.addBox(editListBox);
        return track;
    }

    private Box m7647a(Track track, Map<Track, int[]> map) {
        Box sampleDependencyTypeBox;
        DefaultMp4Builder defaultMp4Builder = this;
        Track track2 = track;
        Map map2 = map;
        SampleTableBox sampleTableBox = new SampleTableBox();
        sampleTableBox.addBox(track.mo3625l());
        List arrayList = new ArrayList();
        long[] k = track.mo3624k();
        int length = k.length;
        int i = 0;
        TimeToSampleBox.Entry entry = null;
        while (true) {
            long j = 1;
            if (i >= length) {
                break;
            }
            long j2 = k[i];
            if (entry == null || entry.getDelta() != j2) {
                entry = new TimeToSampleBox.Entry(1, j2);
                arrayList.add(entry);
            } else {
                entry.setCount(entry.getCount() + 1);
            }
            i++;
        }
        Box timeToSampleBox = new TimeToSampleBox();
        timeToSampleBox.setEntries(arrayList);
        sampleTableBox.addBox(timeToSampleBox);
        arrayList = track.mo2512a();
        if (!(arrayList == null || arrayList.isEmpty())) {
            timeToSampleBox = new CompositionTimeToSample();
            timeToSampleBox.setEntries(arrayList);
            sampleTableBox.addBox(timeToSampleBox);
        }
        long[] b = track.mo2513b();
        if (b != null && b.length > 0) {
            timeToSampleBox = new SyncSampleBox();
            timeToSampleBox.setSampleNumber(b);
            sampleTableBox.addBox(timeToSampleBox);
        }
        if (!(track.mo2514c() == null || track.mo2514c().isEmpty())) {
            sampleDependencyTypeBox = new SampleDependencyTypeBox();
            sampleDependencyTypeBox.setEntries(track.mo2514c());
            sampleTableBox.addBox(sampleDependencyTypeBox);
        }
        m7655b(track2, map2, sampleTableBox);
        sampleDependencyTypeBox = new SampleSizeBox();
        sampleDependencyTypeBox.setSampleSizes((long[]) defaultMp4Builder.f8906d.get(track2));
        sampleTableBox.addBox(sampleDependencyTypeBox);
        m7651a(track2, map2, sampleTableBox);
        Map hashMap = new HashMap();
        for (Map.Entry entry2 : track.mo2519h().entrySet()) {
            String a = ((GroupEntry) entry2.getKey()).mo2526a();
            List list = (List) hashMap.get(a);
            if (list == null) {
                list = new ArrayList();
                hashMap.put(a, list);
            }
            list.add((GroupEntry) entry2.getKey());
            j = 1;
        }
        for (Map.Entry entry3 : hashMap.entrySet()) {
            Box sampleGroupDescriptionBox = new SampleGroupDescriptionBox();
            String str = (String) entry3.getKey();
            sampleGroupDescriptionBox.setGroupingType(str);
            sampleGroupDescriptionBox.setGroupEntries((List) entry3.getValue());
            Box sampleToGroupBox = new SampleToGroupBox();
            sampleToGroupBox.setGroupingType(str);
            SampleToGroupBox.Entry entry4 = null;
            for (i = 0; i < track.mo3623j().size(); i++) {
                int i2 = 0;
                int i3 = 0;
                while (i2 < ((List) entry3.getValue()).size()) {
                    if (Arrays.binarySearch((long[]) track.mo2519h().get((GroupEntry) ((List) entry3.getValue()).get(i2)), (long) i) >= 0) {
                        i3 = i2 + 1;
                    }
                    i2++;
                    j = 1;
                }
                if (entry4 != null) {
                    if (entry4.f8985b == i3) {
                        entry4.f8984a += j;
                    }
                }
                SampleToGroupBox.Entry entry5 = new SampleToGroupBox.Entry(j, i3);
                sampleToGroupBox.getEntries().add(entry5);
                entry4 = entry5;
            }
            sampleTableBox.addBox(sampleGroupDescriptionBox);
            sampleTableBox.addBox(sampleToGroupBox);
        }
        if (track2 instanceof CencEncryptedTrack) {
            m7652a((CencEncryptedTrack) track2, sampleTableBox, (int[]) map2.get(track2));
        }
        if (track.mo2515d() != null) {
            sampleTableBox.addBox(track.mo2515d());
        }
        Logger logger = f8902f;
        StringBuilder stringBuilder = new StringBuilder("done with stbl for track_");
        stringBuilder.append(track.mo3626m().f8896i);
        logger.mo2531a(stringBuilder.toString());
        return sampleTableBox;
    }

    private void m7652a(CencEncryptedTrack cencEncryptedTrack, SampleTableBox sampleTableBox, int[] iArr) {
        SampleTableBox sampleTableBox2 = sampleTableBox;
        int[] iArr2 = iArr;
        Box sampleAuxiliaryInformationSizesBox = new SampleAuxiliaryInformationSizesBox();
        sampleAuxiliaryInformationSizesBox.setAuxInfoType("cenc");
        sampleAuxiliaryInformationSizesBox.setFlags(1);
        List i = cencEncryptedTrack.mo4059i();
        sampleAuxiliaryInformationSizesBox.setDefaultSampleInfoSize(8);
        sampleAuxiliaryInformationSizesBox.setSampleCount(cencEncryptedTrack.mo3623j().size());
        Box sampleAuxiliaryInformationOffsetsBox = new SampleAuxiliaryInformationOffsetsBox();
        Box sampleEncryptionBox = new SampleEncryptionBox();
        boolean z = false;
        sampleEncryptionBox.setSubSampleEncryption(false);
        sampleEncryptionBox.setEntries(i);
        long[] jArr = new long[iArr2.length];
        long offsetToFirstIV = (long) sampleEncryptionBox.getOffsetToFirstIV();
        int i2 = 0;
        int i3 = i2;
        while (i2 < iArr2.length) {
            DefaultMp4Builder defaultMp4Builder = this;
            jArr[i2] = offsetToFirstIV;
            int i4 = i3;
            i3 = z;
            while (i3 < iArr2[i2]) {
                offsetToFirstIV += (long) ((CencSampleAuxiliaryDataFormat) i.get(i4)).m8523a();
                i3++;
                i4++;
                i2 = i2;
                z = false;
            }
            i2++;
            i3 = i4;
        }
        sampleAuxiliaryInformationOffsetsBox.setOffsets(jArr);
        sampleTableBox2.addBox(sampleAuxiliaryInformationSizesBox);
        sampleTableBox2.addBox(sampleAuxiliaryInformationOffsetsBox);
        sampleTableBox2.addBox(sampleEncryptionBox);
        this.f8904b.add(sampleAuxiliaryInformationOffsetsBox);
    }

    private void m7651a(Track track, Map<Track, int[]> map, SampleTableBox sampleTableBox) {
        Track track2 = track;
        Map<Track, int[]> map2 = map;
        if (this.f8903a.get(track2) == null) {
            int i;
            List list;
            Logger logger = f8902f;
            StringBuilder stringBuilder = new StringBuilder("Calculating chunk offsets for track_");
            stringBuilder.append(track.mo3626m().f8896i);
            logger.mo2531a(stringBuilder.toString());
            List arrayList = new ArrayList(map.keySet());
            Collections.sort(arrayList, new C04601(r0));
            Map hashMap = new HashMap();
            Map hashMap2 = new HashMap();
            Map hashMap3 = new HashMap();
            Iterator it = arrayList.iterator();
            while (true) {
                i = 0;
                if (!it.hasNext()) {
                    break;
                }
                list = arrayList;
                Track track3 = (Track) it.next();
                hashMap.put(track3, Integer.valueOf(0));
                hashMap2.put(track3, Integer.valueOf(0));
                hashMap3.put(track3, Double.valueOf(0.0d));
                r0.f8903a.put(track3, new StaticChunkOffsetBox());
                arrayList = list;
            }
            long j = 0;
            while (true) {
                Track track4 = null;
                for (Track track5 : r5) {
                    list = arrayList;
                    if ((track4 == null || ((Double) hashMap3.get(track5)).doubleValue() < ((Double) hashMap3.get(track4)).doubleValue()) && ((Integer) hashMap.get(track5)).intValue() < ((int[]) map2.get(track5)).length) {
                        track4 = track5;
                    }
                    arrayList = list;
                    i = 0;
                }
                if (track4 == null) {
                    break;
                }
                int i2;
                ChunkOffsetBox chunkOffsetBox = (ChunkOffsetBox) r0.f8903a.get(track4);
                chunkOffsetBox.setChunkOffsets(Mp4Arrays.m7715a(chunkOffsetBox.getChunkOffsets(), j));
                int intValue = ((Integer) hashMap.get(track4)).intValue();
                int i3 = ((int[]) map2.get(track4))[intValue];
                int intValue2 = ((Integer) hashMap2.get(track4)).intValue();
                double doubleValue = ((Double) hashMap3.get(track4)).doubleValue();
                long[] k = track4.mo3624k();
                long j2 = j;
                int i4 = intValue2;
                while (true) {
                    i2 = intValue2 + i3;
                    if (i4 >= i2) {
                        break;
                    }
                    j2 += ((long[]) r0.f8906d.get(track4))[i4];
                    doubleValue += ((double) k[i4]) / ((double) track4.mo3626m().f8889b);
                    i4++;
                    arrayList = arrayList;
                    intValue = intValue;
                    i = 0;
                }
                hashMap.put(track4, Integer.valueOf(intValue + 1));
                hashMap2.put(track4, Integer.valueOf(i2));
                hashMap3.put(track4, Double.valueOf(doubleValue));
                j = j2;
            }
        }
        sampleTableBox.addBox((Box) r0.f8903a.get(track2));
    }

    private static void m7655b(Track track, Map<Track, int[]> map, SampleTableBox sampleTableBox) {
        int[] iArr = (int[]) map.get(track);
        map = new SampleToChunkBox();
        map.setEntries(new LinkedList());
        long j = -2147483648L;
        for (int i = 0; i < iArr.length; i++) {
            if (j != ((long) iArr[i])) {
                map.getEntries().add(new SampleToChunkBox.Entry((long) (i + 1), (long) iArr[i], 1));
                j = (long) iArr[i];
            }
        }
        sampleTableBox.addBox(map);
    }

    private int[] m7653a(Track track) {
        long[] a = this.f8907g.mo2520a(track);
        int i = 0;
        int[] iArr = new int[a.length];
        int i2 = 0;
        while (i2 < a.length) {
            long size;
            long j = a[i2] - 1;
            int i3 = i2 + 1;
            if (a.length == i3) {
                size = (long) track.mo3623j().size();
            } else {
                size = a[i3] - 1;
            }
            iArr[i2] = CastUtils.m7705a(size - j);
            i2 = i3;
        }
        if (!f8901e) {
            long size2 = (long) ((List) this.f8905c.get(track)).size();
            long j2 = 0;
            while (i < iArr.length) {
                j2 += (long) iArr[i];
                i++;
            }
            if (size2 != j2) {
                throw new AssertionError("The number of samples and the sum of all chunk lengths must be equal");
            }
        }
        return iArr;
    }

    private static long m7654b(Movie movie) {
        long j = ((Track) movie.f8887b.iterator().next()).mo3626m().f8889b;
        for (Track m : movie.f8887b) {
            j = Math.m7712a(j, m.mo3626m().f8889b);
        }
        return j;
    }
}
