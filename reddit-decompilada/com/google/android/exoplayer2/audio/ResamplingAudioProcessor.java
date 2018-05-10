package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor.UnhandledFormatException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class ResamplingAudioProcessor implements AudioProcessor {
    private int f12782b = -1;
    private int f12783c = -1;
    private int f12784d = 0;
    private ByteBuffer f12785e = a;
    private ByteBuffer f12786f = a;
    private boolean f12787g;

    public final int mo1312c() {
        return 2;
    }

    public final boolean mo1310a(int i, int i2, int i3) throws UnhandledFormatException {
        if (i3 != 3 && i3 != 2 && i3 != Integer.MIN_VALUE && i3 != 1073741824) {
            throw new UnhandledFormatException(i, i2, i3);
        } else if (this.f12782b == i && this.f12783c == i2 && this.f12784d == i3) {
            return false;
        } else {
            this.f12782b = i;
            this.f12783c = i2;
            this.f12784d = i3;
            if (i3 == 2) {
                this.f12785e = a;
            }
            return true;
        }
    }

    public final boolean mo1309a() {
        return (this.f12784d == 0 || this.f12784d == 2) ? false : true;
    }

    public final int mo1311b() {
        return this.f12783c;
    }

    public final void mo1308a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int i2 = this.f12784d;
        if (i2 == Integer.MIN_VALUE) {
            i = (i / 3) * 2;
        } else if (i2 == 3) {
            i *= 2;
        } else if (i2 != 1073741824) {
            throw new IllegalStateException();
        } else {
            i /= 2;
        }
        if (this.f12785e.capacity() < i) {
            this.f12785e = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.f12785e.clear();
        }
        i = this.f12784d;
        if (i == Integer.MIN_VALUE) {
            while (position < limit) {
                this.f12785e.put(byteBuffer.get(position + 1));
                this.f12785e.put(byteBuffer.get(position + 2));
                position += 3;
            }
        } else if (i == 3) {
            while (position < limit) {
                this.f12785e.put((byte) 0);
                this.f12785e.put((byte) ((byteBuffer.get(position) & 255) - 128));
                position++;
            }
        } else if (i != 1073741824) {
            throw new IllegalStateException();
        } else {
            while (position < limit) {
                this.f12785e.put(byteBuffer.get(position + 2));
                this.f12785e.put(byteBuffer.get(position + 3));
                position += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        this.f12785e.flip();
        this.f12786f = this.f12785e;
    }

    public final void mo1313d() {
        this.f12787g = true;
    }

    public final ByteBuffer mo1314e() {
        ByteBuffer byteBuffer = this.f12786f;
        this.f12786f = a;
        return byteBuffer;
    }

    public final boolean mo1315f() {
        return this.f12787g && this.f12786f == a;
    }

    public final void mo1316g() {
        this.f12786f = a;
        this.f12787g = false;
    }

    public final void mo1317h() {
        mo1316g();
        this.f12785e = a;
        this.f12782b = -1;
        this.f12783c = -1;
        this.f12784d = 0;
    }
}
