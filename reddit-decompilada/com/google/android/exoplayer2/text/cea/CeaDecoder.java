package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.util.LinkedList;
import java.util.PriorityQueue;

abstract class CeaDecoder implements SubtitleDecoder {
    final LinkedList<SubtitleOutputBuffer> f17034a;
    private final LinkedList<SubtitleInputBuffer> f17035b = new LinkedList();
    private final PriorityQueue<SubtitleInputBuffer> f17036c;
    private SubtitleInputBuffer f17037d;
    private long f17038e;

    protected abstract void mo3925a(SubtitleInputBuffer subtitleInputBuffer);

    public void mo1326d() {
    }

    protected abstract boolean mo3927e();

    protected abstract Subtitle mo3928f();

    public final /* synthetic */ Object mo1322a() throws Exception {
        return mo3930h();
    }

    public final /* synthetic */ void mo1323a(Object obj) throws Exception {
        mo3926b((SubtitleInputBuffer) obj);
    }

    public final /* synthetic */ Object mo1324b() throws Exception {
        return mo3929g();
    }

    public CeaDecoder() {
        int i = 0;
        for (int i2 = 0; i2 < 10; i2++) {
            this.f17035b.add(new SubtitleInputBuffer());
        }
        this.f17034a = new LinkedList();
        while (i < 2) {
            this.f17034a.add(new CeaOutputBuffer(this));
            i++;
        }
        this.f17036c = new PriorityQueue();
    }

    public void mo3378a(long j) {
        this.f17038e = j;
    }

    public SubtitleInputBuffer mo3930h() throws SubtitleDecoderException {
        Assertions.m4186b(this.f17037d == null);
        if (this.f17035b.isEmpty()) {
            return null;
        }
        this.f17037d = (SubtitleInputBuffer) this.f17035b.pollFirst();
        return this.f17037d;
    }

    public void mo3926b(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        Assertions.m4184a(subtitleInputBuffer == this.f17037d);
        if (subtitleInputBuffer.c_()) {
            m17337c(subtitleInputBuffer);
        } else {
            this.f17036c.add(subtitleInputBuffer);
        }
        this.f17037d = null;
    }

    public SubtitleOutputBuffer mo3929g() throws SubtitleDecoderException {
        if (this.f17034a.isEmpty()) {
            return null;
        }
        while (!this.f17036c.isEmpty() && ((SubtitleInputBuffer) this.f17036c.peek()).d <= this.f17038e) {
            SubtitleInputBuffer subtitleInputBuffer = (SubtitleInputBuffer) this.f17036c.poll();
            if (subtitleInputBuffer.m3715c()) {
                SubtitleOutputBuffer subtitleOutputBuffer = (SubtitleOutputBuffer) this.f17034a.pollFirst();
                subtitleOutputBuffer.m3713a(4);
                m17337c(subtitleInputBuffer);
                return subtitleOutputBuffer;
            }
            mo3925a(subtitleInputBuffer);
            if (mo3927e()) {
                Subtitle f = mo3928f();
                if (!subtitleInputBuffer.c_()) {
                    subtitleOutputBuffer = (SubtitleOutputBuffer) this.f17034a.pollFirst();
                    subtitleOutputBuffer.m17333a(subtitleInputBuffer.d, f, Long.MAX_VALUE);
                    m17337c(subtitleInputBuffer);
                    return subtitleOutputBuffer;
                }
            }
            m17337c(subtitleInputBuffer);
        }
        return null;
    }

    private void m17337c(SubtitleInputBuffer subtitleInputBuffer) {
        subtitleInputBuffer.mo1321a();
        this.f17035b.add(subtitleInputBuffer);
    }

    public void mo1325c() {
        this.f17038e = 0;
        while (!this.f17036c.isEmpty()) {
            m17337c((SubtitleInputBuffer) this.f17036c.poll());
        }
        if (this.f17037d != null) {
            m17337c(this.f17037d);
            this.f17037d = null;
        }
    }
}
