package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener.EventDispatcher;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader.Callback;
import com.google.android.exoplayer2.upstream.Loader.Loadable;
import com.google.android.exoplayer2.upstream.Loader.ReleaseCallback;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ChunkSampleStream<T extends ChunkSource> implements SampleStream, SequenceableLoader, Callback<Chunk>, ReleaseCallback {
    public final boolean[] f13326a;
    public final T f13327b;
    public final SampleQueue[] f13328c;
    long f13329d;
    boolean f13330e;
    private final int f13331f;
    private final int[] f13332g;
    private final SequenceableLoader.Callback<ChunkSampleStream<T>> f13333h;
    private final EventDispatcher f13334i;
    private final int f13335j;
    private final Loader f13336k = new Loader("Loader:ChunkSampleStream");
    private final ChunkHolder f13337l = new ChunkHolder();
    private final LinkedList<BaseMediaChunk> f13338m = new LinkedList();
    private final List<BaseMediaChunk> f13339n = Collections.unmodifiableList(this.f13338m);
    private final SampleQueue f13340o;
    private final BaseMediaChunkOutput f13341p;
    private Format f13342q;
    private long f13343r;

    public final class EmbeddedSampleStream implements SampleStream {
        public final ChunkSampleStream<T> f13322a;
        public final int f13323b;
        public final /* synthetic */ ChunkSampleStream f13324c;
        private final SampleQueue f13325d;

        public final void mo1400b() throws IOException {
        }

        public EmbeddedSampleStream(ChunkSampleStream chunkSampleStream, ChunkSampleStream<T> chunkSampleStream2, SampleQueue sampleQueue, int i) {
            this.f13324c = chunkSampleStream;
            this.f13322a = chunkSampleStream2;
            this.f13325d = sampleQueue;
            this.f13323b = i;
        }

        public final boolean mo1399a() {
            if (!this.f13324c.f13330e) {
                if (this.f13324c.m12399g() || !this.f13325d.f13275a.m3956b()) {
                    return false;
                }
            }
            return true;
        }

        public final void mo1398a(long j) {
            if (!this.f13324c.f13330e || j <= this.f13325d.f13275a.m3958d()) {
                this.f13325d.m12358a(j, true);
            } else {
                this.f13325d.f13275a.m3960f();
            }
        }

        public final int mo1397a(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
            if (this.f13324c.m12399g()) {
                return -3;
            }
            return this.f13325d.m12350a(formatHolder, decoderInputBuffer, z, this.f13324c.f13330e, this.f13324c.f13329d);
        }
    }

    public final /* synthetic */ int mo1418a(Loadable loadable, long j, long j2, IOException iOException) {
        boolean z;
        boolean z2;
        Chunk chunk;
        int i;
        ChunkSampleStream chunkSampleStream = this;
        Chunk chunk2 = (Chunk) loadable;
        long d = chunk2.mo3358d();
        boolean z3 = chunk2 instanceof BaseMediaChunk;
        if (z3 && d != 0) {
            if (chunkSampleStream.f13338m.size() <= 1) {
                z = false;
                if (chunkSampleStream.f13327b.mo3363a(chunk2, z, (Exception) iOException)) {
                    z2 = false;
                } else {
                    if (z3) {
                        chunk = (BaseMediaChunk) chunkSampleStream.f13338m.removeLast();
                        Assertions.m4186b(chunk != chunk2);
                        chunkSampleStream.f13340o.m12352a(chunk.f18964b[0]);
                        i = 0;
                        while (i < chunkSampleStream.f13328c.length) {
                            SampleQueue sampleQueue = chunkSampleStream.f13328c[i];
                            i++;
                            sampleQueue.m12352a(chunk.f18964b[i]);
                        }
                        if (chunkSampleStream.f13338m.isEmpty()) {
                            chunkSampleStream.f13343r = chunkSampleStream.f13329d;
                        }
                    }
                    z2 = true;
                }
                chunkSampleStream.f13334i.m3925a(chunk2.f13302c, chunk2.f13303d, chunkSampleStream.f13331f, chunk2.f13304e, chunk2.f13305f, chunk2.f13306g, chunk2.f13307h, chunk2.f13308i, j, j2, d, iOException, z2);
                if (z2) {
                    return 0;
                }
                chunkSampleStream.f13333h.mo3348a(chunkSampleStream);
                return 2;
            }
        }
        z = true;
        if (chunkSampleStream.f13327b.mo3363a(chunk2, z, (Exception) iOException)) {
            z2 = false;
        } else {
            if (z3) {
                chunk = (BaseMediaChunk) chunkSampleStream.f13338m.removeLast();
                if (chunk != chunk2) {
                }
                Assertions.m4186b(chunk != chunk2);
                chunkSampleStream.f13340o.m12352a(chunk.f18964b[0]);
                i = 0;
                while (i < chunkSampleStream.f13328c.length) {
                    SampleQueue sampleQueue2 = chunkSampleStream.f13328c[i];
                    i++;
                    sampleQueue2.m12352a(chunk.f18964b[i]);
                }
                if (chunkSampleStream.f13338m.isEmpty()) {
                    chunkSampleStream.f13343r = chunkSampleStream.f13329d;
                }
            }
            z2 = true;
        }
        chunkSampleStream.f13334i.m3925a(chunk2.f13302c, chunk2.f13303d, chunkSampleStream.f13331f, chunk2.f13304e, chunk2.f13305f, chunk2.f13306g, chunk2.f13307h, chunk2.f13308i, j, j2, d, iOException, z2);
        if (z2) {
            return 0;
        }
        chunkSampleStream.f13333h.mo3348a(chunkSampleStream);
        return 2;
    }

    public final /* synthetic */ void mo1419a(Loadable loadable, long j, long j2) {
        Chunk chunk = (Chunk) loadable;
        this.f13327b.mo3360a(chunk);
        this.f13334i.m3924a(chunk.f13302c, chunk.f13303d, this.f13331f, chunk.f13304e, chunk.f13305f, chunk.f13306g, chunk.f13307h, chunk.f13308i, j, j2, chunk.mo3358d());
        this.f13333h.mo3348a(this);
    }

    public final /* synthetic */ void mo1420a(Loadable loadable, long j, long j2, boolean z) {
        Chunk chunk = (Chunk) loadable;
        this.f13334i.m3929b(chunk.f13302c, chunk.f13303d, this.f13331f, chunk.f13304e, chunk.f13305f, chunk.f13306g, chunk.f13307h, chunk.f13308i, j, j2, chunk.mo3358d());
        if (!z) {
            r0.f13340o.m12357a(false);
            for (SampleQueue a : r0.f13328c) {
                a.m12357a(false);
            }
            r0.f13333h.mo3348a(r0);
        }
    }

    public ChunkSampleStream(int i, int[] iArr, T t, SequenceableLoader.Callback<ChunkSampleStream<T>> callback, Allocator allocator, long j, int i2, EventDispatcher eventDispatcher) {
        T t2;
        this.f13331f = i;
        this.f13332g = iArr;
        this.f13327b = t;
        this.f13333h = callback;
        this.f13334i = eventDispatcher;
        this.f13335j = i2;
        t = null;
        if (iArr == null) {
            t2 = null;
        } else {
            t2 = iArr.length;
        }
        this.f13328c = new SampleQueue[t2];
        this.f13326a = new boolean[t2];
        i2 = 1 + t2;
        eventDispatcher = new int[i2];
        i2 = new SampleQueue[i2];
        this.f13340o = new SampleQueue(allocator);
        eventDispatcher[0] = i;
        i2[0] = this.f13340o;
        while (t < t2) {
            i = new SampleQueue(allocator);
            this.f13328c[t] = i;
            T t3 = t + 1;
            i2[t3] = i;
            eventDispatcher[t3] = iArr[t];
            t = t3;
        }
        this.f13341p = new BaseMediaChunkOutput(eventDispatcher, i2);
        this.f13343r = j;
        this.f13329d = j;
    }

    public final EmbeddedSampleStream m12387a(long j, int i) {
        for (int i2 = 0; i2 < this.f13328c.length; i2++) {
            if (this.f13332g[i2] == i) {
                Assertions.m4186b(this.f13326a[i2] ^ 1);
                this.f13326a[i2] = 1;
                this.f13328c[i2].m12359b();
                this.f13328c[i2].m12358a(j, true);
                return new EmbeddedSampleStream(this, this, this.f13328c[i2], i2);
            }
        }
        throw new IllegalStateException();
    }

    public final long mo1402d() {
        if (this.f13330e) {
            return Long.MIN_VALUE;
        }
        if (m12399g()) {
            return this.f13343r;
        }
        long j = this.f13329d;
        BaseMediaChunk baseMediaChunk = (BaseMediaChunk) this.f13338m.getLast();
        if (!baseMediaChunk.mo3923f()) {
            baseMediaChunk = this.f13338m.size() > 1 ? (BaseMediaChunk) this.f13338m.get(this.f13338m.size() - 2) : null;
        }
        if (baseMediaChunk != null) {
            j = Math.max(j, baseMediaChunk.i);
        }
        return Math.max(j, this.f13340o.f13275a.m3958d());
    }

    public final void m12393b(long j) {
        boolean z;
        int i;
        this.f13329d = j;
        if (!m12399g()) {
            if (this.f13340o.m12358a(j, j < mo1403e())) {
                z = true;
                if (z) {
                    this.f13343r = j;
                    this.f13330e = false;
                    this.f13338m.clear();
                    if (this.f13336k.m12693a() == null) {
                        this.f13336k.m12695b();
                        return;
                    }
                    this.f13340o.m12357a(false);
                    for (SampleQueue a : this.f13328c) {
                        a.m12357a(false);
                    }
                    return;
                }
                m12383a(this.f13340o.m12349a());
                this.f13340o.m12360c();
                for (SampleQueue sampleQueue : this.f13328c) {
                    sampleQueue.m12359b();
                    sampleQueue.m12354a(j, true, false);
                }
            }
        }
        z = false;
        if (z) {
            this.f13343r = j;
            this.f13330e = false;
            this.f13338m.clear();
            if (this.f13336k.m12693a() == null) {
                this.f13340o.m12357a(false);
                while (r0 < r8) {
                    a.m12357a(false);
                }
                return;
            }
            this.f13336k.m12695b();
            return;
        }
        m12383a(this.f13340o.m12349a());
        this.f13340o.m12360c();
        for (i = 0; i < r3; i++) {
            sampleQueue.m12359b();
            sampleQueue.m12354a(j, true, false);
        }
    }

    public final void m12394c() {
        if (!this.f13336k.m12694a((ReleaseCallback) this)) {
            this.f13340o.m12361d();
            for (SampleQueue d : this.f13328c) {
                d.m12361d();
            }
        }
    }

    public final void mo1421f() {
        this.f13340o.m12357a(false);
        for (SampleQueue a : this.f13328c) {
            a.m12357a(false);
        }
    }

    public final boolean mo1399a() {
        if (!this.f13330e) {
            if (m12399g() || !this.f13340o.f13275a.m3956b()) {
                return false;
            }
        }
        return true;
    }

    public final void mo1400b() throws IOException {
        this.f13336k.mo1477c();
        if (!this.f13336k.m12693a()) {
            this.f13327b.mo3359a();
        }
    }

    public final int mo1397a(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
        if (m12399g()) {
            return -3;
        }
        m12383a(this.f13340o.m12349a());
        formatHolder = this.f13340o.m12350a(formatHolder, decoderInputBuffer, z, this.f13330e, this.f13329d);
        if (formatHolder == -4) {
            this.f13340o.m12360c();
        }
        return formatHolder;
    }

    public final void mo1398a(long j) {
        if (!this.f13330e || j <= this.f13340o.f13275a.m3958d()) {
            this.f13340o.m12358a(j, true);
        } else {
            this.f13340o.f13275a.m3960f();
        }
        this.f13340o.m12360c();
    }

    public final boolean mo1401c(long j) {
        int i = 0;
        if (!this.f13330e) {
            if (!r0.f13336k.m12693a()) {
                r0.f13327b.mo3361a(r0.f13338m.isEmpty() ? null : (BaseMediaChunk) r0.f13338m.getLast(), r0.f13343r != -9223372036854775807L ? r0.f13343r : j, r0.f13337l);
                boolean z = r0.f13337l.f4790b;
                Chunk chunk = r0.f13337l.f4789a;
                ChunkHolder chunkHolder = r0.f13337l;
                chunkHolder.f4789a = null;
                chunkHolder.f4790b = false;
                if (z) {
                    r0.f13343r = -9223372036854775807L;
                    r0.f13330e = true;
                    return true;
                } else if (chunk == null) {
                    return false;
                } else {
                    if (chunk instanceof BaseMediaChunk) {
                        r0.f13343r = -9223372036854775807L;
                        BaseMediaChunk baseMediaChunk = (BaseMediaChunk) chunk;
                        BaseMediaChunkOutput baseMediaChunkOutput = r0.f13341p;
                        baseMediaChunk.f18963a = baseMediaChunkOutput;
                        int[] iArr = new int[baseMediaChunkOutput.f13300a.length];
                        while (i < baseMediaChunkOutput.f13300a.length) {
                            if (baseMediaChunkOutput.f13300a[i] != null) {
                                iArr[i] = baseMediaChunkOutput.f13300a[i].f13275a.m3947a();
                            }
                            i++;
                        }
                        baseMediaChunk.f18964b = iArr;
                        r0.f13338m.add(baseMediaChunk);
                    }
                    r0.f13334i.m3923a(chunk.f13302c, chunk.f13303d, r0.f13331f, chunk.f13304e, chunk.f13305f, chunk.f13306g, chunk.f13307h, chunk.f13308i, r0.f13336k.m12692a(chunk, r0, r0.f13335j));
                    return true;
                }
            }
        }
        return false;
    }

    public final long mo1403e() {
        if (m12399g()) {
            return this.f13343r;
        }
        return this.f13330e ? Long.MIN_VALUE : ((BaseMediaChunk) this.f13338m.getLast()).i;
    }

    final boolean m12399g() {
        return this.f13343r != -9223372036854775807L;
    }

    private void m12383a(int i) {
        if (!this.f13338m.isEmpty()) {
            while (this.f13338m.size() > 1 && ((BaseMediaChunk) this.f13338m.get(1)).f18964b[0] <= i) {
                this.f13338m.removeFirst();
            }
            BaseMediaChunk baseMediaChunk = (BaseMediaChunk) this.f13338m.getFirst();
            Format format = baseMediaChunk.e;
            if (!format.equals(this.f13342q)) {
                this.f13334i.m3922a(this.f13331f, format, baseMediaChunk.f, baseMediaChunk.g, baseMediaChunk.h);
            }
            this.f13342q = format;
        }
    }
}
