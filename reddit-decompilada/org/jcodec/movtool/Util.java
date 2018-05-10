package org.jcodec.movtool;

import com.coremedia.iso.boxes.ChunkOffset64BitBox;
import com.coremedia.iso.boxes.DataInformationBox;
import com.coremedia.iso.boxes.DataReferenceBox;
import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.StaticChunkOffsetBox;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.jcodec.common.ArrayUtil;
import org.jcodec.common.model.Rational;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsets64Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsetsBox;
import org.jcodec.containers.mp4.boxes.DataRefBox;
import org.jcodec.containers.mp4.boxes.Edit;
import org.jcodec.containers.mp4.boxes.MediaHeaderBox;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.MovieHeaderBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.SampleEntry;
import org.jcodec.containers.mp4.boxes.SampleSizesBox;
import org.jcodec.containers.mp4.boxes.SampleToChunkBox;
import org.jcodec.containers.mp4.boxes.SampleToChunkBox.SampleToChunkEntry;
import org.jcodec.containers.mp4.boxes.TimeToSampleBox;
import org.jcodec.containers.mp4.boxes.TimeToSampleBox.TimeToSampleEntry;
import org.jcodec.containers.mp4.boxes.TrakBox;

public class Util {

    public static class Pair<T> {
        private T f26833a;
        private T f26834b;

        public Pair(T t, T t2) {
            this.f26833a = t;
            this.f26834b = t2;
        }

        public T getA() {
            return this.f26833a;
        }

        public T getB() {
            return this.f26834b;
        }
    }

    public static Pair<List<Edit>> split(List<Edit> list, Rational rational, long j) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        ListIterator listIterator = list.listIterator();
        long j2 = 0;
        while (listIterator.hasNext()) {
            Edit edit = (Edit) listIterator.next();
            if (edit.getDuration() + j2 > j) {
                int i = (int) (j - j2);
                int multiplyS = rational.multiplyS(i);
                long j3 = (long) i;
                long j4 = j3;
                Edit edit2 = new Edit(j3, edit.getMediaTime(), 1.0f);
                Edit edit3 = new Edit(edit.getDuration() - j4, ((long) multiplyS) + edit.getMediaTime(), 1.0f);
                listIterator.remove();
                if (edit2.getDuration() > 0) {
                    listIterator.add(edit2);
                    arrayList.add(edit2);
                }
                if (edit3.getDuration() > 0) {
                    listIterator.add(edit3);
                    arrayList2.add(edit3);
                }
                while (listIterator.hasNext()) {
                    arrayList2.add(listIterator.next());
                }
                return new Pair(arrayList, arrayList2);
            }
            Rational rational2 = rational;
            arrayList.add(edit);
            j2 += edit.getDuration();
        }
        while (listIterator.hasNext()) {
            arrayList2.add(listIterator.next());
        }
        return new Pair(arrayList, arrayList2);
    }

    public static Pair<List<Edit>> split(MovieBox movieBox, TrakBox trakBox, long j) {
        return split(trakBox.getEdits(), new Rational(trakBox.getTimescale(), movieBox.getTimescale()), j);
    }

    public static void spread(MovieBox movieBox, TrakBox trakBox, long j, long j2) {
        trakBox.getEdits().add(((List) split(movieBox, trakBox, j).getA()).size(), new Edit(j2, -1, 1.0f));
    }

    public static void shift(MovieBox movieBox, TrakBox trakBox, long j) {
        trakBox.getEdits().add(0, new Edit(j, -1, 1.0f));
    }

    public static long[] getTimevalues(TrakBox trakBox) {
        trakBox = ((TimeToSampleBox) Box.findFirst(trakBox, TimeToSampleBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, com.coremedia.iso.boxes.TimeToSampleBox.TYPE)).getEntries();
        int i = 0;
        int i2 = i;
        while (i < trakBox.length) {
            i2 += trakBox[i].getSampleCount();
            i++;
        }
        long[] jArr = new long[(i2 + 1)];
        i2 = 0;
        int i3 = i2;
        while (i2 < trakBox.length) {
            int i4 = i3;
            i3 = 0;
            while (i3 < trakBox[i2].getSampleCount()) {
                int i5 = i4 + 1;
                jArr[i5] = jArr[i4] + ((long) trakBox[i2].getSampleDuration());
                i3++;
                i4 = i5;
            }
            i2++;
            i3 = i4;
        }
        return jArr;
    }

    private static void appendToInternal(MovieBox movieBox, TrakBox trakBox, TrakBox trakBox2) {
        movieBox = appendEntries(trakBox, trakBox2);
        appendChunkOffsets(trakBox, trakBox2);
        appendTimeToSamples(trakBox, trakBox2);
        appendSampleToChunk(trakBox, trakBox2, movieBox);
        appendSampleSizes(trakBox, trakBox2);
    }

    private static void updateDuration(TrakBox trakBox, TrakBox trakBox2) {
        MediaHeaderBox mediaHeaderBox = (MediaHeaderBox) Box.findFirst(trakBox, MediaHeaderBox.class, MediaBox.TYPE, com.coremedia.iso.boxes.MediaHeaderBox.TYPE);
        mediaHeaderBox.setDuration(mediaHeaderBox.getDuration() + ((MediaHeaderBox) Box.findFirst(trakBox2, MediaHeaderBox.class, MediaBox.TYPE, com.coremedia.iso.boxes.MediaHeaderBox.TYPE)).getDuration());
    }

    public static void appendTo(MovieBox movieBox, TrakBox trakBox, TrakBox trakBox2) {
        appendToInternal(movieBox, trakBox, trakBox2);
        appendEdits(trakBox, trakBox2, trakBox.getEdits().size());
        updateDuration(trakBox, trakBox2);
    }

    public static void insertTo(MovieBox movieBox, TrakBox trakBox, TrakBox trakBox2, long j) {
        appendToInternal(movieBox, trakBox, trakBox2);
        insertEdits(movieBox, trakBox, trakBox2, j);
        updateDuration(trakBox, trakBox2);
    }

    private static void insertEdits(MovieBox movieBox, TrakBox trakBox, TrakBox trakBox2, long j) {
        appendEdits(trakBox, trakBox2, ((List) split(movieBox, trakBox, j).getA()).size());
    }

    private static void appendEdits(TrakBox trakBox, TrakBox trakBox2, int i) {
        for (Edit shift : trakBox2.getEdits()) {
            shift.shift(trakBox.getMediaDuration());
        }
        trakBox.getEdits().addAll(i, trakBox2.getEdits());
        trakBox.setEdits(trakBox.getEdits());
    }

    private static void appendSampleSizes(TrakBox trakBox, TrakBox trakBox2) {
        SampleSizesBox sampleSizesBox = (SampleSizesBox) Box.findFirst(trakBox, SampleSizesBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, SampleSizeBox.TYPE);
        SampleSizesBox sampleSizesBox2 = (SampleSizesBox) Box.findFirst(trakBox2, SampleSizesBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, SampleSizeBox.TYPE);
        if (sampleSizesBox.getDefaultSize() != sampleSizesBox2.getDefaultSize()) {
            throw new IllegalArgumentException("Can't append to track that has different default sample size");
        }
        Box sampleSizesBox3;
        if (sampleSizesBox.getDefaultSize() > 0) {
            sampleSizesBox3 = new SampleSizesBox(sampleSizesBox.getDefaultSize(), sampleSizesBox.getCount() + sampleSizesBox2.getCount());
        } else {
            sampleSizesBox3 = new SampleSizesBox(ArrayUtil.addAll(sampleSizesBox.getSizes(), sampleSizesBox2.getSizes()));
        }
        ((NodeBox) Box.findFirst(trakBox, NodeBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE)).replace(SampleSizeBox.TYPE, sampleSizesBox3);
    }

    private static void appendSampleToChunk(TrakBox trakBox, TrakBox trakBox2, int i) {
        SampleToChunkBox sampleToChunkBox = (SampleToChunkBox) Box.findFirst(trakBox, SampleToChunkBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, com.coremedia.iso.boxes.SampleToChunkBox.TYPE);
        trakBox2 = ((SampleToChunkBox) Box.findFirst(trakBox2, SampleToChunkBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, com.coremedia.iso.boxes.SampleToChunkBox.TYPE)).getSampleToChunk();
        Object[] objArr = new SampleToChunkEntry[trakBox2.length];
        for (int i2 = 0; i2 < trakBox2.length; i2++) {
            objArr[i2] = new SampleToChunkEntry(trakBox2[i2].getFirst() + ((long) sampleToChunkBox.getSampleToChunk().length), trakBox2[i2].getCount(), trakBox2[i2].getEntry() + i);
        }
        ((NodeBox) Box.findFirst(trakBox, NodeBox.class, new String[]{MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE})).replace(com.coremedia.iso.boxes.SampleToChunkBox.TYPE, new SampleToChunkBox((SampleToChunkEntry[]) ArrayUtil.addAll(sampleToChunkBox.getSampleToChunk(), objArr)));
    }

    private static int appendEntries(TrakBox trakBox, TrakBox trakBox2) {
        appendDrefs(trakBox, trakBox2);
        SampleEntry[] sampleEntryArr = (SampleEntry[]) Box.findAll(trakBox, SampleEntry.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, SampleDescriptionBox.TYPE, null);
        SampleEntry[] sampleEntryArr2 = (SampleEntry[]) Box.findAll(trakBox2, SampleEntry.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, SampleDescriptionBox.TYPE, null);
        Box sampleDescriptionBox = new org.jcodec.containers.mp4.boxes.SampleDescriptionBox(sampleEntryArr);
        for (Box box : sampleEntryArr2) {
            box.setDrefInd((short) (box.getDrefInd() + sampleEntryArr.length));
            sampleDescriptionBox.add(box);
        }
        ((NodeBox) Box.findFirst(trakBox, NodeBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE)).replace(SampleDescriptionBox.TYPE, sampleDescriptionBox);
        return sampleEntryArr.length;
    }

    private static void appendDrefs(TrakBox trakBox, TrakBox trakBox2) {
        ((DataRefBox) Box.findFirst(trakBox, DataRefBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, DataInformationBox.TYPE, DataReferenceBox.TYPE)).getBoxes().addAll(((DataRefBox) Box.findFirst(trakBox2, DataRefBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, DataInformationBox.TYPE, DataReferenceBox.TYPE)).getBoxes());
    }

    private static void appendTimeToSamples(TrakBox trakBox, TrakBox trakBox2) {
        ((NodeBox) Box.findFirst(trakBox, NodeBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE)).replace(com.coremedia.iso.boxes.TimeToSampleBox.TYPE, new TimeToSampleBox((TimeToSampleEntry[]) ArrayUtil.addAll(((TimeToSampleBox) Box.findFirst(trakBox, TimeToSampleBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, com.coremedia.iso.boxes.TimeToSampleBox.TYPE)).getEntries(), ((TimeToSampleBox) Box.findFirst(trakBox2, TimeToSampleBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, com.coremedia.iso.boxes.TimeToSampleBox.TYPE)).getEntries())));
    }

    private static void appendChunkOffsets(TrakBox trakBox, TrakBox trakBox2) {
        ChunkOffsetsBox chunkOffsetsBox = (ChunkOffsetsBox) Box.findFirst(trakBox, ChunkOffsetsBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, StaticChunkOffsetBox.TYPE);
        ChunkOffsets64Box chunkOffsets64Box = (ChunkOffsets64Box) Box.findFirst(trakBox, ChunkOffsets64Box.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, ChunkOffset64BitBox.TYPE);
        ChunkOffsetsBox chunkOffsetsBox2 = (ChunkOffsetsBox) Box.findFirst(trakBox2, ChunkOffsetsBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, StaticChunkOffsetBox.TYPE);
        ChunkOffsets64Box chunkOffsets64Box2 = (ChunkOffsets64Box) Box.findFirst(trakBox2, ChunkOffsets64Box.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, ChunkOffset64BitBox.TYPE);
        long[] chunkOffsets = chunkOffsetsBox == null ? chunkOffsets64Box.getChunkOffsets() : chunkOffsetsBox.getChunkOffsets();
        long[] chunkOffsets2 = chunkOffsetsBox2 == null ? chunkOffsets64Box2.getChunkOffsets() : chunkOffsetsBox2.getChunkOffsets();
        NodeBox nodeBox = (NodeBox) Box.findFirst(trakBox, NodeBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE);
        nodeBox.removeChildren(StaticChunkOffsetBox.TYPE, ChunkOffset64BitBox.TYPE);
        trakBox2 = (chunkOffsets64Box == null && chunkOffsets64Box2 == null) ? new ChunkOffsetsBox(ArrayUtil.addAll(chunkOffsets, chunkOffsets2)) : new ChunkOffsets64Box(ArrayUtil.addAll(chunkOffsets, chunkOffsets2));
        nodeBox.add(trakBox2);
    }

    public static void forceEditList(MovieBox movieBox, TrakBox trakBox) {
        List edits = trakBox.getEdits();
        if (edits == null || edits.size() == 0) {
            MovieHeaderBox movieHeaderBox = (MovieHeaderBox) Box.findFirst(movieBox, MovieHeaderBox.class, com.coremedia.iso.boxes.MovieHeaderBox.TYPE);
            edits = new ArrayList();
            trakBox.setEdits(edits);
            edits.add(new Edit((long) ((int) movieHeaderBox.getDuration()), 0, 1.0f));
            trakBox.setEdits(edits);
        }
    }

    public static void forceEditList(MovieBox movieBox) {
        for (TrakBox forceEditList : movieBox.getTracks()) {
            forceEditList(movieBox, forceEditList);
        }
    }

    public static List<Edit> editsOnEdits(Rational rational, List<Edit> list, List<Edit> list2) {
        List<Edit> arrayList = new ArrayList();
        List arrayList2 = new ArrayList(list);
        for (Edit edit : list2) {
            long multiply = rational.multiply(edit.getMediaTime());
            list2 = split((List) split(arrayList2, rational.flip(), multiply).getB(), rational.flip(), multiply + edit.getDuration());
            arrayList.addAll((Collection) list2.getA());
            arrayList2 = (List) list2.getB();
        }
        return arrayList;
    }
}
