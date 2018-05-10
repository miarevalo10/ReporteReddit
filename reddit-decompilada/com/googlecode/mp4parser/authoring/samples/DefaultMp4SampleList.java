package com.googlecode.mp4parser.authoring.samples;

import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.MovieBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleToChunkBox.Entry;
import com.coremedia.iso.boxes.TrackBox;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.Logger;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

public class DefaultMp4SampleList extends AbstractList<Sample> {
    private static final Logger f8910j = Logger.m7708a(DefaultMp4SampleList.class);
    Container f8911a;
    TrackBox f8912b = null;
    SoftReference<ByteBuffer>[] f8913c = null;
    int[] f8914d;
    long[] f8915e;
    long[] f8916f;
    long[][] f8917g;
    SampleSizeBox f8918h;
    int f8919i;

    class SampleImpl implements Sample {
        final /* synthetic */ DefaultMp4SampleList f15126a;
        private int f15127b;

        public SampleImpl(DefaultMp4SampleList defaultMp4SampleList, int i) {
            this.f15126a = defaultMp4SampleList;
            this.f15127b = i;
        }

        public final void mo2522a(WritableByteChannel writableByteChannel) throws IOException {
            writableByteChannel.write(m15146b());
        }

        public final long mo2521a() {
            return this.f15126a.f8918h.getSampleSizeAtIndex(this.f15127b);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private synchronized java.nio.ByteBuffer m15146b() {
            /*
            r11 = this;
            monitor-enter(r11);
            r0 = r11.f15126a;	 Catch:{ all -> 0x00ab }
            r1 = r11.f15127b;	 Catch:{ all -> 0x00ab }
            r0 = r0.m7661a(r1);	 Catch:{ all -> 0x00ab }
            r1 = r11.f15126a;	 Catch:{ all -> 0x00ab }
            r1 = r1.f8913c;	 Catch:{ all -> 0x00ab }
            r1 = r1[r0];	 Catch:{ all -> 0x00ab }
            r2 = r11.f15126a;	 Catch:{ all -> 0x00ab }
            r2 = r2.f8914d;	 Catch:{ all -> 0x00ab }
            r2 = r2[r0];	 Catch:{ all -> 0x00ab }
            r2 = r2 + -1;
            r3 = r11.f15127b;	 Catch:{ all -> 0x00ab }
            r3 = r3 - r2;
            r4 = r11.f15126a;	 Catch:{ all -> 0x00ab }
            r4 = r4.f8917g;	 Catch:{ all -> 0x00ab }
            r5 = (long) r0;	 Catch:{ all -> 0x00ab }
            r7 = com.googlecode.mp4parser.util.CastUtils.m7705a(r5);	 Catch:{ all -> 0x00ab }
            r4 = r4[r7];	 Catch:{ all -> 0x00ab }
            r7 = r4[r3];	 Catch:{ all -> 0x00ab }
            if (r1 == 0) goto L_0x0031;
        L_0x0029:
            r1 = r1.get();	 Catch:{ all -> 0x00ab }
            r1 = (java.nio.ByteBuffer) r1;	 Catch:{ all -> 0x00ab }
            if (r1 != 0) goto L_0x0060;
        L_0x0031:
            r1 = r11.f15126a;	 Catch:{ IOException -> 0x0088 }
            r1 = r1.f8911a;	 Catch:{ IOException -> 0x0088 }
            r3 = r11.f15126a;	 Catch:{ IOException -> 0x0088 }
            r3 = r3.f8915e;	 Catch:{ IOException -> 0x0088 }
            r5 = com.googlecode.mp4parser.util.CastUtils.m7705a(r5);	 Catch:{ IOException -> 0x0088 }
            r5 = r3[r5];	 Catch:{ IOException -> 0x0088 }
            r3 = r4.length;	 Catch:{ IOException -> 0x0088 }
            r3 = r3 + -1;
            r9 = r4[r3];	 Catch:{ IOException -> 0x0088 }
            r3 = r11.f15126a;	 Catch:{ IOException -> 0x0088 }
            r3 = r3.f8918h;	 Catch:{ IOException -> 0x0088 }
            r4 = r4.length;	 Catch:{ IOException -> 0x0088 }
            r2 = r2 + r4;
            r2 = r2 + -1;
            r2 = r3.getSampleSizeAtIndex(r2);	 Catch:{ IOException -> 0x0088 }
            r9 = r9 + r2;
            r1 = r1.getByteBuffer(r5, r9);	 Catch:{ IOException -> 0x0088 }
            r2 = r11.f15126a;	 Catch:{ IOException -> 0x0088 }
            r2 = r2.f8913c;	 Catch:{ IOException -> 0x0088 }
            r3 = new java.lang.ref.SoftReference;	 Catch:{ IOException -> 0x0088 }
            r3.<init>(r1);	 Catch:{ IOException -> 0x0088 }
            r2[r0] = r3;	 Catch:{ IOException -> 0x0088 }
        L_0x0060:
            r0 = r1.duplicate();	 Catch:{ all -> 0x00ab }
            r1 = com.googlecode.mp4parser.util.CastUtils.m7705a(r7);	 Catch:{ all -> 0x00ab }
            r0 = r0.position(r1);	 Catch:{ all -> 0x00ab }
            r0 = (java.nio.ByteBuffer) r0;	 Catch:{ all -> 0x00ab }
            r0 = r0.slice();	 Catch:{ all -> 0x00ab }
            r1 = r11.f15126a;	 Catch:{ all -> 0x00ab }
            r1 = r1.f8918h;	 Catch:{ all -> 0x00ab }
            r2 = r11.f15127b;	 Catch:{ all -> 0x00ab }
            r1 = r1.getSampleSizeAtIndex(r2);	 Catch:{ all -> 0x00ab }
            r1 = com.googlecode.mp4parser.util.CastUtils.m7705a(r1);	 Catch:{ all -> 0x00ab }
            r0 = r0.limit(r1);	 Catch:{ all -> 0x00ab }
            r0 = (java.nio.ByteBuffer) r0;	 Catch:{ all -> 0x00ab }
            monitor-exit(r11);
            return r0;
        L_0x0088:
            r0 = move-exception;
            r1 = new java.io.StringWriter;	 Catch:{ all -> 0x00ab }
            r1.<init>();	 Catch:{ all -> 0x00ab }
            r2 = new java.io.PrintWriter;	 Catch:{ all -> 0x00ab }
            r2.<init>(r1);	 Catch:{ all -> 0x00ab }
            r0.printStackTrace(r2);	 Catch:{ all -> 0x00ab }
            r2 = com.googlecode.mp4parser.authoring.samples.DefaultMp4SampleList.f8910j;	 Catch:{ all -> 0x00ab }
            r1 = r1.toString();	 Catch:{ all -> 0x00ab }
            r2.mo2533c(r1);	 Catch:{ all -> 0x00ab }
            r1 = new java.lang.IndexOutOfBoundsException;	 Catch:{ all -> 0x00ab }
            r0 = r0.getMessage();	 Catch:{ all -> 0x00ab }
            r1.<init>(r0);	 Catch:{ all -> 0x00ab }
            throw r1;	 Catch:{ all -> 0x00ab }
        L_0x00ab:
            r0 = move-exception;
            monitor-exit(r11);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.googlecode.mp4parser.authoring.samples.DefaultMp4SampleList.SampleImpl.b():java.nio.ByteBuffer");
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Sample(index: ");
            stringBuilder.append(this.f15127b);
            stringBuilder.append(" size: ");
            stringBuilder.append(this.f15126a.f8918h.getSampleSizeAtIndex(this.f15127b));
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    public DefaultMp4SampleList(long j, Container container) {
        long j2 = j;
        Container container2 = container;
        int i = 0;
        this.f8919i = 0;
        this.f8911a = container2;
        for (TrackBox trackBox : ((MovieBox) container2.getBoxes(MovieBox.class).get(0)).getBoxes(TrackBox.class)) {
            if (trackBox.getTrackHeaderBox().getTrackId() == j2) {
                r0.f8912b = trackBox;
            }
            i = 0;
        }
        if (r0.f8912b == null) {
            StringBuilder stringBuilder = new StringBuilder("This MP4 does not contain track ");
            stringBuilder.append(j2);
            throw new RuntimeException(stringBuilder.toString());
        }
        int i2;
        r0.f8915e = r0.f8912b.getSampleTableBox().getChunkOffsetBox().getChunkOffsets();
        r0.f8916f = new long[r0.f8915e.length];
        r0.f8913c = new SoftReference[r0.f8915e.length];
        Arrays.fill(r0.f8913c, new SoftReference(null));
        r0.f8917g = new long[r0.f8915e.length][];
        r0.f8918h = r0.f8912b.getSampleTableBox().getSampleSizeBox();
        List entries = r0.f8912b.getSampleTableBox().getSampleToChunkBox().getEntries();
        Entry[] entryArr = (Entry[]) entries.toArray(new Entry[entries.size()]);
        Entry entry = entryArr[i];
        long firstChunk = entry.getFirstChunk();
        int a = CastUtils.m7705a(entry.getSamplesPerChunk());
        int size = size();
        int i3 = a;
        a = i;
        int i4 = a;
        int i5 = 1;
        int i6 = i5;
        do {
            a++;
            if (((long) a) == firstChunk) {
                if (entryArr.length > i5) {
                    i2 = i5 + 1;
                    Entry entry2 = entryArr[i5];
                    i4 = i3;
                    i3 = CastUtils.m7705a(entry2.getSamplesPerChunk());
                    i5 = i2;
                    firstChunk = entry2.getFirstChunk();
                } else {
                    i4 = i3;
                    i3 = -1;
                    firstChunk = Long.MAX_VALUE;
                }
            }
            r0.f8917g[a - 1] = new long[i4];
            i6 += i4;
        } while (i6 <= size);
        r0.f8914d = new int[(a + 1)];
        entry = entryArr[i];
        firstChunk = entry.getFirstChunk();
        long j3 = firstChunk;
        i5 = i;
        i2 = 1;
        i3 = i2;
        int a2 = CastUtils.m7705a(entry.getSamplesPerChunk());
        a = i5;
        while (true) {
            i6 = a + 1;
            r0.f8914d[a] = i2;
            if (((long) i6) == j3) {
                if (entryArr.length > i3) {
                    a = i3 + 1;
                    Entry entry3 = entryArr[i3];
                    i = CastUtils.m7705a(entry3.getSamplesPerChunk());
                    j3 = entry3.getFirstChunk();
                    i3 = a;
                    i5 = a2;
                    a2 = i;
                } else {
                    i5 = a2;
                    a2 = -1;
                    j3 = Long.MAX_VALUE;
                }
            }
            i2 += i5;
            if (i2 > size) {
                break;
            }
            a = i6;
        }
        r0.f8914d[i6] = RedditJobManager.f10810d;
        long j4 = 0;
        int i7 = 0;
        for (i = 1; ((long) i) <= r0.f8918h.getSampleCount(); i++) {
            while (i == r0.f8914d[i7]) {
                i7++;
                j4 = 0;
            }
            long[] jArr = r0.f8916f;
            int i8 = i7 - 1;
            i6 = i - 1;
            jArr[i8] = jArr[i8] + r0.f8918h.getSampleSizeAtIndex(i6);
            r0.f8917g[i8][i - r0.f8914d[i8]] = j4;
            j4 += r0.f8918h.getSampleSizeAtIndex(i6);
        }
    }

    final synchronized int m7661a(int i) {
        i++;
        if (i >= this.f8914d[this.f8919i] && i < this.f8914d[this.f8919i + 1]) {
            return this.f8919i;
        } else if (i < this.f8914d[this.f8919i]) {
            this.f8919i = 0;
            while (this.f8914d[this.f8919i + 1] <= i) {
                this.f8919i++;
            }
            return this.f8919i;
        } else {
            this.f8919i++;
            while (this.f8914d[this.f8919i + 1] <= i) {
                this.f8919i++;
            }
            return this.f8919i;
        }
    }

    public int size() {
        return CastUtils.m7705a(this.f8912b.getSampleTableBox().getSampleSizeBox().getSampleCount());
    }

    public /* synthetic */ Object get(int i) {
        if (((long) i) < this.f8918h.getSampleCount()) {
            return new SampleImpl(this, i);
        }
        throw new IndexOutOfBoundsException();
    }
}
