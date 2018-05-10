package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor.UnhandledFormatException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class SonicAudioProcessor implements AudioProcessor {
    float f12788b = 1.0f;
    float f12789c = 1.0f;
    long f12790d;
    long f12791e;
    private int f12792f = -1;
    private int f12793g = -1;
    private Sonic f12794h;
    private ByteBuffer f12795i = a;
    private ShortBuffer f12796j = this.f12795i.asShortBuffer();
    private ByteBuffer f12797k = a;
    private boolean f12798l;

    public final int mo1312c() {
        return 2;
    }

    public final boolean mo1310a(int i, int i2, int i3) throws UnhandledFormatException {
        if (i3 != 2) {
            throw new UnhandledFormatException(i, i2, i3);
        } else if (this.f12793g == i && this.f12792f == i2) {
            return false;
        } else {
            this.f12793g = i;
            this.f12792f = i2;
            return true;
        }
    }

    public final boolean mo1309a() {
        if (Math.abs(this.f12788b - 1.0f) < 0.01f) {
            if (Math.abs(this.f12789c - 1.0f) < 0.01f) {
                return false;
            }
        }
        return true;
    }

    public final int mo1311b() {
        return this.f12792f;
    }

    public final void mo1308a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.f12790d += (long) remaining;
            Sonic sonic = this.f12794h;
            int remaining2 = asShortBuffer.remaining() / sonic.f4196a;
            int i = (sonic.f4196a * remaining2) * 2;
            sonic.m3711a(remaining2);
            asShortBuffer.get(sonic.f4198c, sonic.f4202g * sonic.f4196a, i / 2);
            sonic.f4202g += remaining2;
            sonic.m3710a();
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        byteBuffer = (this.f12794h.f4203h * this.f12792f) * 2;
        if (byteBuffer > null) {
            if (this.f12795i.capacity() < byteBuffer) {
                this.f12795i = ByteBuffer.allocateDirect(byteBuffer).order(ByteOrder.nativeOrder());
                this.f12796j = this.f12795i.asShortBuffer();
            } else {
                this.f12795i.clear();
                this.f12796j.clear();
            }
            Sonic sonic2 = this.f12794h;
            ShortBuffer shortBuffer = this.f12796j;
            int min = Math.min(shortBuffer.remaining() / sonic2.f4196a, sonic2.f4203h);
            shortBuffer.put(sonic2.f4199d, 0, sonic2.f4196a * min);
            sonic2.f4203h -= min;
            System.arraycopy(sonic2.f4199d, min * sonic2.f4196a, sonic2.f4199d, 0, sonic2.f4203h * sonic2.f4196a);
            this.f12791e += (long) byteBuffer;
            this.f12795i.limit(byteBuffer);
            this.f12797k = this.f12795i;
        }
    }

    public final void mo1313d() {
        Sonic sonic = this.f12794h;
        int i = sonic.f4202g;
        int i2 = sonic.f4203h + ((int) ((((((float) i) / (sonic.f4200e / sonic.f4201f)) + ((float) sonic.f4204i)) / sonic.f4201f) + 0.5f));
        sonic.m3711a((sonic.f4197b * 2) + i);
        for (int i3 = 0; i3 < (sonic.f4197b * 2) * sonic.f4196a; i3++) {
            sonic.f4198c[(sonic.f4196a * i) + i3] = (short) 0;
        }
        sonic.f4202g += 2 * sonic.f4197b;
        sonic.m3710a();
        if (sonic.f4203h > i2) {
            sonic.f4203h = i2;
        }
        sonic.f4202g = 0;
        sonic.f4205j = 0;
        sonic.f4204i = 0;
        this.f12798l = true;
    }

    public final ByteBuffer mo1314e() {
        ByteBuffer byteBuffer = this.f12797k;
        this.f12797k = a;
        return byteBuffer;
    }

    public final boolean mo1315f() {
        return this.f12798l && (this.f12794h == null || this.f12794h.f4203h == 0);
    }

    public final void mo1316g() {
        this.f12794h = new Sonic(this.f12793g, this.f12792f);
        this.f12794h.f4200e = this.f12788b;
        this.f12794h.f4201f = this.f12789c;
        this.f12797k = a;
        this.f12790d = 0;
        this.f12791e = 0;
        this.f12798l = false;
    }

    public final void mo1317h() {
        this.f12794h = null;
        this.f12795i = a;
        this.f12796j = this.f12795i.asShortBuffer();
        this.f12797k = a;
        this.f12792f = -1;
        this.f12793g = -1;
        this.f12790d = 0;
        this.f12791e = 0;
        this.f12798l = false;
    }
}
