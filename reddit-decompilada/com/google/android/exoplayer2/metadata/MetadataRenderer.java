package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

public final class MetadataRenderer extends BaseRenderer implements Callback {
    private final MetadataDecoderFactory f18952h;
    private final Output f18953i;
    private final Handler f18954j;
    private final FormatHolder f18955k;
    private final MetadataInputBuffer f18956l;
    private final Metadata[] f18957m;
    private final long[] f18958n;
    private int f18959o;
    private int f18960p;
    private MetadataDecoder f18961q;
    private boolean f18962r;

    public interface Output {
        void mo1291a(Metadata metadata);
    }

    public final boolean mo3919q() {
        return true;
    }

    public MetadataRenderer(Output output, Looper looper) {
        this(output, looper, MetadataDecoderFactory.f4667a);
    }

    private MetadataRenderer(Output output, Looper looper, MetadataDecoderFactory metadataDecoderFactory) {
        super(4);
        this.f18953i = (Output) Assertions.m4182a((Object) output);
        if (looper == null) {
            output = null;
        } else {
            output = new Handler(looper, this);
        }
        this.f18954j = output;
        this.f18952h = (MetadataDecoderFactory) Assertions.m4182a((Object) metadataDecoderFactory);
        this.f18955k = new FormatHolder();
        this.f18956l = new MetadataInputBuffer();
        this.f18957m = new Metadata[5];
        this.f18958n = new long[5];
    }

    public final int mo3912a(Format format) {
        return this.f18952h.mo1394a(format) != null ? 4 : null;
    }

    protected final void mo3921a(Format[] formatArr, long j) throws ExoPlaybackException {
        this.f18961q = this.f18952h.mo1395b(formatArr[0]);
    }

    protected final void mo3914a(long j, boolean z) {
        m20039s();
        this.f18962r = 0;
    }

    public final void mo3913a(long j, long j2) throws ExoPlaybackException {
        if (this.f18962r == null && this.f18960p < 5) {
            this.f18956l.mo1321a();
            if (m17066a((FormatHolder) this.f18955k, this.f18956l, false) == -4) {
                if (this.f18956l.m3715c() != null) {
                    this.f18962r = true;
                } else if (this.f18956l.c_() == null) {
                    this.f18956l.f16862f = this.f18955k.f4039a.f4035w;
                    this.f18956l.m11975g();
                    try {
                        j2 = (this.f18959o + this.f18960p) % 5;
                        this.f18957m[j2] = this.f18961q.mo1396a(this.f18956l);
                        this.f18958n[j2] = this.f18956l.d;
                        this.f18960p++;
                    } catch (long j3) {
                        throw ExoPlaybackException.m3542a(j3, this.f16763b);
                    }
                }
            }
        }
        if (this.f18960p > null && this.f18958n[this.f18959o] <= j3) {
            Metadata metadata = this.f18957m[this.f18959o];
            if (this.f18954j != null) {
                this.f18954j.obtainMessage(0, metadata).sendToTarget();
            } else {
                m20038a(metadata);
            }
            this.f18957m[this.f18959o] = 0;
            this.f18959o = (this.f18959o + 1) % 5;
            this.f18960p--;
        }
    }

    protected final void mo3918p() {
        m20039s();
        this.f18961q = null;
    }

    public final boolean mo3920r() {
        return this.f18962r;
    }

    private void m20039s() {
        Arrays.fill(this.f18957m, null);
        this.f18959o = 0;
        this.f18960p = 0;
    }

    public final boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        m20038a((Metadata) message.obj);
        return true;
    }

    private void m20038a(Metadata metadata) {
        this.f18953i.mo1291a(metadata);
    }
}
