package com.googlecode.mp4parser.authoring.samples;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackExtendsBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox.Entry;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.Path;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FragmentedMp4SampleList extends AbstractList<Sample> {
    Container f8920a;
    IsoFile[] f8921b;
    TrackBox f8922c = null;
    TrackExtendsBox f8923d = null;
    private SoftReference<Sample>[] f8924e;
    private List<TrackFragmentBox> f8925f;
    private Map<TrackRunBox, SoftReference<ByteBuffer>> f8926g = new HashMap();
    private int[] f8927h;
    private int f8928i = -1;

    public /* synthetic */ Object get(int i) {
        return m7663a(i);
    }

    public FragmentedMp4SampleList(long j, Container container, IsoFile... isoFileArr) {
        this.f8920a = container;
        this.f8921b = isoFileArr;
        for (TrackBox trackBox : Path.m7720a(container, "moov[0]/trak")) {
            if (trackBox.getTrackHeaderBox().getTrackId() == j) {
                this.f8922c = trackBox;
            }
        }
        if (this.f8922c == null) {
            isoFileArr = new StringBuilder("This MP4 does not contain track ");
            isoFileArr.append(j);
            throw new RuntimeException(isoFileArr.toString());
        }
        for (TrackExtendsBox trackExtendsBox : Path.m7720a(container, "moov[0]/mvex[0]/trex")) {
            if (trackExtendsBox.getTrackId() == this.f8922c.getTrackHeaderBox().getTrackId()) {
                this.f8923d = trackExtendsBox;
            }
        }
        this.f8924e = (SoftReference[]) Array.newInstance(SoftReference.class, size());
        m7664a();
    }

    private List<TrackFragmentBox> m7664a() {
        if (this.f8925f != null) {
            return this.f8925f;
        }
        List<TrackFragmentBox> arrayList = new ArrayList();
        for (MovieFragmentBox boxes : this.f8920a.getBoxes(MovieFragmentBox.class)) {
            for (TrackFragmentBox trackFragmentBox : boxes.getBoxes(TrackFragmentBox.class)) {
                if (trackFragmentBox.getTrackFragmentHeaderBox().getTrackId() == this.f8922c.getTrackHeaderBox().getTrackId()) {
                    arrayList.add(trackFragmentBox);
                }
            }
        }
        int i = 0;
        if (this.f8921b != null) {
            for (IsoFile boxes2 : this.f8921b) {
                for (MovieFragmentBox boxes3 : boxes2.getBoxes(MovieFragmentBox.class)) {
                    for (TrackFragmentBox trackFragmentBox2 : boxes3.getBoxes(TrackFragmentBox.class)) {
                        if (trackFragmentBox2.getTrackFragmentHeaderBox().getTrackId() == this.f8922c.getTrackHeaderBox().getTrackId()) {
                            arrayList.add(trackFragmentBox2);
                        }
                    }
                }
            }
        }
        this.f8925f = arrayList;
        this.f8927h = new int[this.f8925f.size()];
        int i2 = 1;
        while (i < this.f8925f.size()) {
            this.f8927h[i] = i2;
            i2 += m7662a((TrackFragmentBox) this.f8925f.get(i));
            i++;
        }
        return arrayList;
    }

    private static int m7662a(TrackFragmentBox trackFragmentBox) {
        trackFragmentBox = trackFragmentBox.getBoxes();
        int i = 0;
        int i2 = 0;
        while (i < trackFragmentBox.size()) {
            Box box = (Box) trackFragmentBox.get(i);
            if (box instanceof TrackRunBox) {
                i2 += CastUtils.m7705a(((TrackRunBox) box).getSampleCount());
            }
            i++;
        }
        return i2;
    }

    private Sample m7663a(int i) {
        Sample sample;
        if (this.f8924e[i] != null) {
            sample = (Sample) r7.f8924e[i].get();
            if (sample != null) {
                return sample;
            }
        }
        int i2 = i + 1;
        int length = r7.f8927h.length - 1;
        while (i2 - r7.f8927h[length] < 0) {
            length--;
        }
        TrackFragmentBox trackFragmentBox = (TrackFragmentBox) r7.f8925f.get(length);
        int i3 = i2 - r7.f8927h[length];
        Container container = (MovieFragmentBox) trackFragmentBox.getParent();
        i2 = 0;
        for (Box box : trackFragmentBox.getBoxes()) {
            if (box instanceof TrackRunBox) {
                TrackRunBox trackRunBox = (TrackRunBox) box;
                int i4 = i3 - i2;
                if (trackRunBox.getEntries().size() <= i4) {
                    i2 += trackRunBox.getEntries().size();
                } else {
                    long j;
                    long defaultSampleSize;
                    List list;
                    ByteBuffer byteBuffer;
                    List<Entry> entries = trackRunBox.getEntries();
                    TrackFragmentHeaderBox trackFragmentHeaderBox = trackFragmentBox.getTrackFragmentHeaderBox();
                    boolean isSampleSizePresent = trackRunBox.isSampleSizePresent();
                    boolean hasDefaultSampleSize = trackFragmentHeaderBox.hasDefaultSampleSize();
                    long j2 = 0;
                    if (isSampleSizePresent) {
                        j = 0;
                    } else {
                        if (hasDefaultSampleSize) {
                            defaultSampleSize = trackFragmentHeaderBox.getDefaultSampleSize();
                        } else if (r7.f8923d == null) {
                            throw new RuntimeException("File doesn't contain trex box but track fragments aren't fully self contained. Cannot determine sample size.");
                        } else {
                            defaultSampleSize = r7.f8923d.getDefaultSampleSize();
                        }
                        j = defaultSampleSize;
                    }
                    SoftReference softReference = (SoftReference) r7.f8926g.get(trackRunBox);
                    ByteBuffer byteBuffer2 = softReference != null ? (ByteBuffer) softReference.get() : null;
                    if (byteBuffer2 == null) {
                        List list2;
                        if (trackFragmentHeaderBox.hasBaseDataOffset()) {
                            j2 = 0 + trackFragmentHeaderBox.getBaseDataOffset();
                            container = container.getParent();
                        }
                        if (trackRunBox.isDataOffsetPresent()) {
                            j2 += (long) trackRunBox.getDataOffset();
                        }
                        int i5 = 0;
                        for (Entry entry : entries) {
                            if (isSampleSizePresent) {
                                i5 = (int) (((long) i5) + entry.getSampleSize());
                                list2 = list2;
                            } else {
                                list = list2;
                                i5 = (int) (((long) i5) + j);
                            }
                        }
                        try {
                            ByteBuffer byteBuffer3 = container.getByteBuffer(j2, (long) i5);
                            r7.f8926g.put(trackRunBox, new SoftReference(byteBuffer3));
                            byteBuffer = byteBuffer3;
                            list = list2;
                        } catch (Throwable e) {
                            throw new RuntimeException(e);
                        }
                    }
                    list = entries;
                    byteBuffer = byteBuffer2;
                    i2 = 0;
                    int i6 = 0;
                    while (i2 < i4) {
                        List list3 = list;
                        i6 = isSampleSizePresent ? (int) (((long) i6) + ((Entry) list3.get(i2)).getSampleSize()) : (int) (((long) i6) + j);
                        i2++;
                        list = list3;
                    }
                    defaultSampleSize = isSampleSizePresent ? ((Entry) list.get(i4)).getSampleSize() : j;
                    final ByteBuffer byteBuffer4 = byteBuffer;
                    sample = new Sample(r7) {
                        final /* synthetic */ FragmentedMp4SampleList f15128a;

                        public final long mo2521a() {
                            return defaultSampleSize;
                        }

                        public final void mo2522a(WritableByteChannel writableByteChannel) throws IOException {
                            writableByteChannel.write((ByteBuffer) ((ByteBuffer) byteBuffer4.position(i6)).slice().limit(CastUtils.m7705a(defaultSampleSize)));
                        }
                    };
                    r7.f8924e[i] = new SoftReference(sample);
                    return sample;
                }
            }
        }
        throw new RuntimeException("Couldn't find sample in the traf I was looking");
    }

    public int size() {
        if (this.f8928i != -1) {
            return this.f8928i;
        }
        int i = 0;
        for (MovieFragmentBox boxes : this.f8920a.getBoxes(MovieFragmentBox.class)) {
            for (TrackFragmentBox trackFragmentBox : boxes.getBoxes(TrackFragmentBox.class)) {
                if (trackFragmentBox.getTrackFragmentHeaderBox().getTrackId() == this.f8922c.getTrackHeaderBox().getTrackId()) {
                    for (TrackRunBox sampleCount : trackFragmentBox.getBoxes(TrackRunBox.class)) {
                        i = (int) (((long) i) + sampleCount.getSampleCount());
                    }
                }
            }
        }
        for (IsoFile boxes2 : this.f8921b) {
            for (MovieFragmentBox boxes3 : boxes2.getBoxes(MovieFragmentBox.class)) {
                for (TrackFragmentBox trackFragmentBox2 : boxes3.getBoxes(TrackFragmentBox.class)) {
                    if (trackFragmentBox2.getTrackFragmentHeaderBox().getTrackId() == this.f8922c.getTrackHeaderBox().getTrackId()) {
                        for (TrackRunBox sampleCount2 : trackFragmentBox2.getBoxes(TrackRunBox.class)) {
                            i = (int) (((long) i) + sampleCount2.getSampleCount());
                        }
                    }
                }
            }
        }
        this.f8928i = i;
        return i;
    }
}
