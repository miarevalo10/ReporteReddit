package com.google.android.exoplayer2.text;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;

public final class TextRenderer extends BaseRenderer implements Callback {
    private final Handler f18992h;
    private final Output f18993i;
    private final SubtitleDecoderFactory f18994j;
    private final FormatHolder f18995k;
    private boolean f18996l;
    private boolean f18997m;
    private int f18998n;
    private Format f18999o;
    private SubtitleDecoder f19000p;
    private SubtitleInputBuffer f19001q;
    private SubtitleOutputBuffer f19002r;
    private SubtitleOutputBuffer f19003s;
    private int f19004t;

    public interface Output {
        void mo1293a(List<Cue> list);
    }

    public final boolean mo3919q() {
        return true;
    }

    public TextRenderer(Output output, Looper looper) {
        this(output, looper, SubtitleDecoderFactory.f4940a);
    }

    private TextRenderer(Output output, Looper looper, SubtitleDecoderFactory subtitleDecoderFactory) {
        super(3);
        this.f18993i = (Output) Assertions.m4182a((Object) output);
        if (looper == null) {
            output = null;
        } else {
            output = new Handler(looper, this);
        }
        this.f18992h = output;
        this.f18994j = subtitleDecoderFactory;
        this.f18995k = new FormatHolder();
    }

    public final int mo3912a(Format format) {
        if (this.f18994j.mo1448a(format)) {
            return 4;
        }
        return MimeTypes.m4214c(format.f4018f) != null ? 1 : null;
    }

    protected final void mo3921a(Format[] formatArr, long j) throws ExoPlaybackException {
        this.f18999o = formatArr[0];
        if (this.f19000p != null) {
            this.f18998n = 1;
        } else {
            this.f19000p = this.f18994j.mo1449b(this.f18999o);
        }
    }

    public final void mo3913a(long j, long j2) throws ExoPlaybackException {
        if (this.f18997m == null) {
            if (this.f19003s == null) {
                this.f19000p.mo3378a(j);
                try {
                    this.f19003s = (SubtitleOutputBuffer) this.f19000p.mo1324b();
                } catch (long j3) {
                    throw ExoPlaybackException.m3542a(j3, this.f16763b);
                }
            }
            if (this.f16764c == 2) {
                if (this.f19002r != null) {
                    long v = m20059v();
                    j2 = 0;
                    while (v <= j3) {
                        this.f19004t++;
                        v = m20059v();
                        j2 = 1;
                    }
                } else {
                    j2 = 0;
                }
                if (this.f19003s != null) {
                    if (this.f19003s.m3715c()) {
                        if (j2 == null && m20059v() == Long.MAX_VALUE) {
                            if (this.f18998n == 2) {
                                m20058u();
                            } else {
                                m20056s();
                                this.f18997m = true;
                            }
                        }
                    } else if (this.f19003s.b <= j3) {
                        if (this.f19002r != null) {
                            this.f19002r.mo3924e();
                        }
                        this.f19002r = this.f19003s;
                        this.f19003s = null;
                        this.f19004t = this.f19002r.mo1450a(j3);
                        j2 = 1;
                    }
                }
                if (j2 != null) {
                    m20054a(this.f19002r.mo1453b(j3));
                }
                if (this.f18998n != 2) {
                    while (this.f18996l == null) {
                        try {
                            if (this.f19001q == null) {
                                this.f19001q = (SubtitleInputBuffer) this.f19000p.mo1322a();
                                if (this.f19001q == null) {
                                    return;
                                }
                            }
                            if (this.f18998n == 1) {
                                this.f19001q.f4220a = 4;
                                this.f19000p.mo1323a(this.f19001q);
                                this.f19001q = null;
                                this.f18998n = 2;
                                return;
                            }
                            j3 = m17066a((FormatHolder) this.f18995k, this.f19001q, false);
                            if (j3 == -4) {
                                if (this.f19001q.m3715c() != null) {
                                    this.f18996l = true;
                                } else {
                                    this.f19001q.f17031f = this.f18995k.f4039a.f4035w;
                                    this.f19001q.m11975g();
                                }
                                this.f19000p.mo1323a(this.f19001q);
                                this.f19001q = null;
                            } else if (j3 == -3) {
                                return;
                            }
                        } catch (long j32) {
                            throw ExoPlaybackException.m3542a(j32, this.f16763b);
                        }
                    }
                }
            }
        }
    }

    protected final void mo3918p() {
        this.f18999o = null;
        m20054a(Collections.emptyList());
        m20057t();
    }

    public final boolean mo3920r() {
        return this.f18997m;
    }

    private void m20056s() {
        this.f19001q = null;
        this.f19004t = -1;
        if (this.f19002r != null) {
            this.f19002r.mo3924e();
            this.f19002r = null;
        }
        if (this.f19003s != null) {
            this.f19003s.mo3924e();
            this.f19003s = null;
        }
    }

    private void m20057t() {
        m20056s();
        this.f19000p.mo1326d();
        this.f19000p = null;
        this.f18998n = 0;
    }

    private void m20058u() {
        m20057t();
        this.f19000p = this.f18994j.mo1449b(this.f18999o);
    }

    private long m20059v() {
        if (this.f19004t != -1) {
            if (this.f19004t < this.f19002r.mo1452b()) {
                return this.f19002r.a_(this.f19004t);
            }
        }
        return Long.MAX_VALUE;
    }

    private void m20054a(List<Cue> list) {
        if (this.f18992h != null) {
            this.f18992h.obtainMessage(0, list).sendToTarget();
        } else {
            m20055b(list);
        }
    }

    public final boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        m20055b((List) message.obj);
        return true;
    }

    private void m20055b(List<Cue> list) {
        this.f18993i.mo1293a(list);
    }

    protected final void mo3914a(long j, boolean z) {
        m20054a(Collections.emptyList());
        this.f18996l = false;
        this.f18997m = false;
        if (this.f18998n != null) {
            m20058u();
            return;
        }
        m20056s();
        this.f19000p.mo1325c();
    }
}
