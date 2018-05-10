package com.googlecode.mp4parser.authoring;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.CompositionTimeToSample.Entry;
import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.EditListBox;
import com.coremedia.iso.boxes.MediaHeaderBox;
import com.coremedia.iso.boxes.MovieHeaderBox;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.coremedia.iso.boxes.SubSampleInformationBox.SubSampleEntry;
import com.coremedia.iso.boxes.TimeToSampleBox;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.coremedia.iso.boxes.fragment.MovieExtendsBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentBox;
import com.coremedia.iso.boxes.fragment.SampleFlags;
import com.coremedia.iso.boxes.fragment.TrackExtendsBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox;
import com.coremedia.iso.boxes.mdat.SampleList;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.Mp4Arrays;
import com.googlecode.mp4parser.util.Path;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Mp4TrackImpl extends AbstractTrack {
    static final /* synthetic */ boolean f18482h = true;
    private List<Sample> f18483d;
    TrackBox f18484e;
    IsoFile[] f18485f;
    String f18486g;
    private SampleDescriptionBox f18487i;
    private long[] f18488j;
    private List<Entry> f18489k;
    private long[] f18490l = null;
    private List<SampleDependencyTypeBox.Entry> f18491m;
    private TrackMetaData f18492n = new TrackMetaData();
    private SubSampleInformationBox f18493o = null;

    public Mp4TrackImpl(String str, TrackBox trackBox, IsoFile... isoFileArr) {
        AbstractContainerBox abstractContainerBox = trackBox;
        IsoFile[] isoFileArr2 = isoFileArr;
        super(str);
        this.f18484e = abstractContainerBox;
        long trackId = trackBox.getTrackHeaderBox().getTrackId();
        this.f18483d = new SampleList(abstractContainerBox, isoFileArr2);
        AbstractContainerBox sampleTableBox = trackBox.getMediaBox().getMediaInformationBox().getSampleTableBox();
        this.f18486g = trackBox.getMediaBox().getHandlerBox().getHandlerType();
        List arrayList = new ArrayList();
        this.f18489k = new ArrayList();
        this.f18491m = new ArrayList();
        arrayList.addAll(sampleTableBox.getTimeToSampleBox().getEntries());
        if (sampleTableBox.getCompositionTimeToSample() != null) {
            r0.f18489k.addAll(sampleTableBox.getCompositionTimeToSample().getEntries());
        }
        if (sampleTableBox.getSampleDependencyTypeBox() != null) {
            r0.f18491m.addAll(sampleTableBox.getSampleDependencyTypeBox().getEntries());
        }
        if (sampleTableBox.getSyncSampleBox() != null) {
            r0.f18490l = sampleTableBox.getSyncSampleBox().getSampleNumber();
        }
        r0.f18493o = (SubSampleInformationBox) Path.m7716a(sampleTableBox, SubSampleInformationBox.TYPE);
        List arrayList2 = new ArrayList();
        arrayList2.addAll(((Box) trackBox.getParent()).getParent().getBoxes(MovieFragmentBox.class));
        int length = isoFileArr2.length;
        int i = 0;
        while (i < length) {
            long j = trackId;
            List list = arrayList2;
            List list2 = list;
            list2.addAll(isoFileArr2[i].getBoxes(MovieFragmentBox.class));
            i++;
            arrayList2 = list2;
            trackId = j;
        }
        r0.f18487i = sampleTableBox.getSampleDescriptionBox();
        List boxes = trackBox.getParent().getBoxes(MovieExtendsBox.class);
        if (boxes.size() > 0) {
            Iterator it = boxes.iterator();
            while (it.hasNext()) {
                Iterator it2 = ((MovieExtendsBox) it.next()).getBoxes(TrackExtendsBox.class).iterator();
                while (it2.hasNext()) {
                    TrackExtendsBox trackExtendsBox = (TrackExtendsBox) it2.next();
                    if (trackExtendsBox.getTrackId() == trackId) {
                        if (Path.m7720a(((Box) trackBox.getParent()).getParent(), "/moof/traf/subs").size() > 0) {
                            r0.f18493o = new SubSampleInformationBox();
                        }
                        long j2 = 1;
                        for (MovieFragmentBox boxes2 : r7) {
                            Iterator it3 = boxes2.getBoxes(TrackFragmentBox.class).iterator();
                            while (it3.hasNext()) {
                                AbstractContainerBox abstractContainerBox2 = (TrackFragmentBox) it3.next();
                                Iterator it4;
                                TrackExtendsBox trackExtendsBox2;
                                if (abstractContainerBox2.getTrackFragmentHeaderBox().getTrackId() == trackId) {
                                    Iterator it5;
                                    Iterator it6;
                                    r0.c = m19329a(sampleTableBox.getBoxes(SampleGroupDescriptionBox.class), Path.m7720a((Container) abstractContainerBox2, SampleGroupDescriptionBox.TYPE), Path.m7720a((Container) abstractContainerBox2, SampleToGroupBox.TYPE), r0.c, j2 - 1);
                                    SubSampleInformationBox subSampleInformationBox = (SubSampleInformationBox) Path.m7716a(abstractContainerBox2, SubSampleInformationBox.TYPE);
                                    if (subSampleInformationBox != null) {
                                        long j3 = (j2 - 0) - 1;
                                        for (SubSampleEntry subSampleEntry : subSampleInformationBox.getEntries()) {
                                            it5 = it;
                                            j = trackId;
                                            SubSampleEntry subSampleEntry2 = new SubSampleEntry();
                                            it6 = it3;
                                            subSampleEntry2.getSubsampleEntries().addAll(subSampleEntry.getSubsampleEntries());
                                            if (j3 != 0) {
                                                it4 = it2;
                                                subSampleEntry2.setSampleDelta(j3 + subSampleEntry.getSampleDelta());
                                                j3 = 0;
                                            } else {
                                                it4 = it2;
                                                subSampleEntry2.setSampleDelta(subSampleEntry.getSampleDelta());
                                            }
                                            r0.f18493o.getEntries().add(subSampleEntry2);
                                            it = it5;
                                            trackId = j;
                                            it3 = it6;
                                            it2 = it4;
                                        }
                                    }
                                    it5 = it;
                                    j = trackId;
                                    it6 = it3;
                                    it4 = it2;
                                    it = abstractContainerBox2.getBoxes(TrackRunBox.class).iterator();
                                    while (it.hasNext()) {
                                        TrackRunBox trackRunBox = (TrackRunBox) it.next();
                                        TrackFragmentHeaderBox trackFragmentHeaderBox = ((TrackFragmentBox) trackRunBox.getParent()).getTrackFragmentHeaderBox();
                                        length = 1;
                                        int i2 = 1;
                                        Iterator it7;
                                        for (it3 = trackRunBox.getEntries().iterator(); it3.hasNext(); it3 = it7) {
                                            Iterator it8;
                                            TrackExtendsBox trackExtendsBox3;
                                            long j4;
                                            Entry entry;
                                            SampleFlags sampleFlags;
                                            int i3;
                                            TrackRunBox.Entry entry2 = (TrackRunBox.Entry) it3.next();
                                            if (trackRunBox.isSampleDurationPresent()) {
                                                if (arrayList.size() != 0) {
                                                    it8 = it;
                                                    if (((TimeToSampleBox.Entry) arrayList.get(arrayList.size() - 1)).getDelta() == entry2.getSampleDuration()) {
                                                        TimeToSampleBox.Entry entry3 = (TimeToSampleBox.Entry) arrayList.get(arrayList.size() - length);
                                                        list = arrayList2;
                                                        it7 = it3;
                                                        trackExtendsBox3 = trackExtendsBox;
                                                        entry3.setCount(entry3.getCount() + 1);
                                                    }
                                                } else {
                                                    it8 = it;
                                                }
                                                list = arrayList2;
                                                it7 = it3;
                                                trackExtendsBox3 = trackExtendsBox;
                                                arrayList.add(new TimeToSampleBox.Entry(1, entry2.getSampleDuration()));
                                            } else {
                                                it8 = it;
                                                list = arrayList2;
                                                it7 = it3;
                                                trackExtendsBox3 = trackExtendsBox;
                                                if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                                                    arrayList.add(new TimeToSampleBox.Entry(1, trackFragmentHeaderBox.getDefaultSampleDuration()));
                                                } else {
                                                    j4 = j2;
                                                    trackExtendsBox2 = trackExtendsBox3;
                                                    arrayList.add(new TimeToSampleBox.Entry(1, trackExtendsBox2.getDefaultSampleDuration()));
                                                    if (trackRunBox.isSampleCompositionTimeOffsetPresent()) {
                                                        if (r0.f18489k.size() != 0) {
                                                            if (((long) ((Entry) r0.f18489k.get(r0.f18489k.size() - 1)).getOffset()) != entry2.getSampleCompositionTimeOffset()) {
                                                                entry = (Entry) r0.f18489k.get(r0.f18489k.size() - 1);
                                                                entry.setCount(entry.getCount() + 1);
                                                            }
                                                        }
                                                        r0.f18489k.add(new Entry(1, CastUtils.m7705a(entry2.getSampleCompositionTimeOffset())));
                                                    }
                                                    if (trackRunBox.isSampleFlagsPresent()) {
                                                        sampleFlags = entry2.getSampleFlags();
                                                    } else if (i2 == 0 && trackRunBox.isFirstSampleFlagsPresent()) {
                                                        sampleFlags = trackRunBox.getFirstSampleFlags();
                                                    } else if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                                                        sampleFlags = trackExtendsBox2.getDefaultSampleFlags();
                                                    } else {
                                                        sampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                                                    }
                                                    if (sampleFlags != null || sampleFlags.isSampleIsDifferenceSample()) {
                                                        i3 = 1;
                                                        i2 = 0;
                                                    } else {
                                                        long[] jArr = r0.f18490l;
                                                        i3 = 1;
                                                        long[] jArr2 = new long[1];
                                                        i2 = 0;
                                                        jArr2[0] = j4;
                                                        r0.f18490l = Mp4Arrays.m7715a(jArr, jArr2);
                                                    }
                                                    j2 = j4 + 1;
                                                    trackExtendsBox = trackExtendsBox2;
                                                    length = i3;
                                                    it = it8;
                                                    arrayList2 = list;
                                                }
                                            }
                                            j4 = j2;
                                            trackExtendsBox2 = trackExtendsBox3;
                                            if (trackRunBox.isSampleCompositionTimeOffsetPresent()) {
                                                if (r0.f18489k.size() != 0) {
                                                    if (((long) ((Entry) r0.f18489k.get(r0.f18489k.size() - 1)).getOffset()) != entry2.getSampleCompositionTimeOffset()) {
                                                        entry = (Entry) r0.f18489k.get(r0.f18489k.size() - 1);
                                                        entry.setCount(entry.getCount() + 1);
                                                    }
                                                }
                                                r0.f18489k.add(new Entry(1, CastUtils.m7705a(entry2.getSampleCompositionTimeOffset())));
                                            }
                                            if (trackRunBox.isSampleFlagsPresent()) {
                                                sampleFlags = entry2.getSampleFlags();
                                            } else {
                                                if (i2 == 0) {
                                                }
                                                if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                                                    sampleFlags = trackExtendsBox2.getDefaultSampleFlags();
                                                } else {
                                                    sampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                                                }
                                            }
                                            if (sampleFlags != null) {
                                            }
                                            i3 = 1;
                                            i2 = 0;
                                            j2 = j4 + 1;
                                            trackExtendsBox = trackExtendsBox2;
                                            length = i3;
                                            it = it8;
                                            arrayList2 = list;
                                        }
                                    }
                                    it = it5;
                                    trackId = j;
                                    it3 = it6;
                                    it2 = it4;
                                } else {
                                    list = arrayList2;
                                    it4 = it2;
                                    trackExtendsBox2 = trackExtendsBox;
                                    arrayList2 = list;
                                }
                            }
                        }
                    }
                }
            }
        } else {
            r0.c = m19329a(sampleTableBox.getBoxes(SampleGroupDescriptionBox.class), null, sampleTableBox.getBoxes(SampleToGroupBox.class), r0.c, 0);
        }
        r0.f18488j = TimeToSampleBox.blowupTimeToSamples(arrayList);
        MediaHeaderBox mediaHeaderBox = trackBox.getMediaBox().getMediaHeaderBox();
        TrackHeaderBox trackHeaderBox = trackBox.getTrackHeaderBox();
        r0.f18492n.f8896i = trackHeaderBox.getTrackId();
        r0.f18492n.f8891d = mediaHeaderBox.getCreationTime();
        r0.f18492n.f8888a = mediaHeaderBox.getLanguage();
        r0.f18492n.f8890c = mediaHeaderBox.getModificationTime();
        r0.f18492n.f8889b = mediaHeaderBox.getTimescale();
        r0.f18492n.f8894g = trackHeaderBox.getHeight();
        r0.f18492n.f8893f = trackHeaderBox.getWidth();
        r0.f18492n.f8898k = trackHeaderBox.getLayer();
        r0.f18492n.f8892e = trackHeaderBox.getMatrix();
        r0.f18492n.f8895h = trackHeaderBox.getVolume();
        EditListBox editListBox = (EditListBox) Path.m7716a(abstractContainerBox, "edts/elst");
        MovieHeaderBox movieHeaderBox = (MovieHeaderBox) Path.m7716a(abstractContainerBox, "../mvhd");
        if (editListBox != null) {
            Iterator it9 = editListBox.getEntries().iterator();
            while (it9.hasNext()) {
                EditListBox.Entry entry4 = (EditListBox.Entry) it9.next();
                MediaHeaderBox mediaHeaderBox2 = mediaHeaderBox;
                Iterator it10 = it9;
                r0.b.add(new Edit(entry4.getMediaTime(), mediaHeaderBox.getTimescale(), entry4.getMediaRate(), ((double) entry4.getSegmentDuration()) / ((double) movieHeaderBox.getTimescale())));
                mediaHeaderBox = mediaHeaderBox2;
                it9 = it10;
            }
        }
    }

    private static Map<GroupEntry, long[]> m19329a(List<SampleGroupDescriptionBox> list, List<SampleGroupDescriptionBox> list2, List<SampleToGroupBox> list3, Map<GroupEntry, long[]> map, long j) {
        Map<GroupEntry, long[]> map2 = map;
        for (SampleToGroupBox sampleToGroupBox : list3) {
            int i = 0;
            for (SampleToGroupBox.Entry entry : sampleToGroupBox.getEntries()) {
                if (entry.f8985b > 0) {
                    GroupEntry groupEntry = null;
                    if (entry.f8985b > 65535) {
                        for (SampleGroupDescriptionBox sampleGroupDescriptionBox : list2) {
                            if (sampleGroupDescriptionBox.getGroupingType().equals(sampleToGroupBox.getGroupingType())) {
                                groupEntry = (GroupEntry) sampleGroupDescriptionBox.getGroupEntries().get((entry.f8985b - 1) & 65535);
                            }
                        }
                    } else {
                        for (SampleGroupDescriptionBox sampleGroupDescriptionBox2 : list) {
                            if (sampleGroupDescriptionBox2.getGroupingType().equals(sampleToGroupBox.getGroupingType())) {
                                groupEntry = (GroupEntry) sampleGroupDescriptionBox2.getGroupEntries().get(entry.f8985b - 1);
                            }
                        }
                    }
                    GroupEntry groupEntry2 = groupEntry;
                    if (f18482h || groupEntry2 != null) {
                        Object obj = (long[]) map2.get(groupEntry2);
                        if (obj == null) {
                            obj = new long[0];
                        }
                        Object obj2 = obj;
                        Object obj3 = new long[(CastUtils.m7705a(entry.f8984a) + obj2.length)];
                        System.arraycopy(obj2, 0, obj3, 0, obj2.length);
                        int i2 = 0;
                        while (true) {
                            long j2 = (long) i2;
                            if (j2 >= entry.f8984a) {
                                break;
                            }
                            obj3[obj2.length + i2] = (j + ((long) i)) + j2;
                            i2++;
                        }
                        map2.put(groupEntry2, obj3);
                    } else {
                        throw new AssertionError();
                    }
                }
                i = (int) (((long) i) + entry.f8984a);
            }
        }
        return map2;
    }

    public void close() throws IOException {
        Container parent = this.f18484e.getParent();
        if (parent instanceof BasicContainer) {
            ((BasicContainer) parent).close();
        }
        if (this.f18485f != null) {
            for (IsoFile close : this.f18485f) {
                close.close();
            }
        }
    }

    public final List<Sample> mo3623j() {
        return this.f18483d;
    }

    public final synchronized long[] mo3624k() {
        return this.f18488j;
    }

    public final SampleDescriptionBox mo3625l() {
        return this.f18487i;
    }

    public final List<Entry> mo2512a() {
        return this.f18489k;
    }

    public final long[] mo2513b() {
        if (this.f18490l != null) {
            if (this.f18490l.length != this.f18483d.size()) {
                return this.f18490l;
            }
        }
        return null;
    }

    public final List<SampleDependencyTypeBox.Entry> mo2514c() {
        return this.f18491m;
    }

    public final TrackMetaData mo3626m() {
        return this.f18492n;
    }

    public final String mo3627n() {
        return this.f18486g;
    }

    public final SubSampleInformationBox mo2515d() {
        return this.f18493o;
    }
}
