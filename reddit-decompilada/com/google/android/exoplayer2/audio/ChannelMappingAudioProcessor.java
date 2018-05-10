package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor.UnhandledFormatException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

final class ChannelMappingAudioProcessor implements AudioProcessor {
    int[] f12773b;
    private int f12774c = -1;
    private int f12775d = -1;
    private boolean f12776e;
    private int[] f12777f;
    private ByteBuffer f12778g = a;
    private ByteBuffer f12779h = a;
    private boolean f12780i;

    public final int mo1312c() {
        return 2;
    }

    public final boolean mo1310a(int i, int i2, int i3) throws UnhandledFormatException {
        boolean equals = Arrays.equals(this.f12773b, this.f12777f) ^ true;
        this.f12777f = this.f12773b;
        if (this.f12777f == null) {
            this.f12776e = false;
            return equals;
        } else if (i3 != 2) {
            throw new UnhandledFormatException(i, i2, i3);
        } else if (!equals && this.f12775d == i && this.f12774c == i2) {
            return false;
        } else {
            this.f12775d = i;
            this.f12774c = i2;
            this.f12776e = i2 != this.f12777f.length;
            int i4 = 0;
            while (i4 < this.f12777f.length) {
                int i5 = this.f12777f[i4];
                if (i5 >= i2) {
                    throw new UnhandledFormatException(i, i2, i3);
                }
                this.f12776e = (i5 != i4 ? 1 : 0) | this.f12776e;
                i4++;
            }
            return true;
        }
    }

    public final boolean mo1309a() {
        return this.f12776e;
    }

    public final int mo1311b() {
        return this.f12777f == null ? this.f12774c : this.f12777f.length;
    }

    public final void mo1308a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = (((limit - position) / (this.f12774c * 2)) * this.f12777f.length) * 2;
        if (this.f12778g.capacity() < length) {
            this.f12778g = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.f12778g.clear();
        }
        while (position < limit) {
            for (int i : this.f12777f) {
                this.f12778g.putShort(byteBuffer.getShort((i * 2) + position));
            }
            position += this.f12774c * 2;
        }
        byteBuffer.position(limit);
        this.f12778g.flip();
        this.f12779h = this.f12778g;
    }

    public final void mo1313d() {
        this.f12780i = true;
    }

    public final ByteBuffer mo1314e() {
        ByteBuffer byteBuffer = this.f12779h;
        this.f12779h = a;
        return byteBuffer;
    }

    public final boolean mo1315f() {
        return this.f12780i && this.f12779h == a;
    }

    public final void mo1316g() {
        this.f12779h = a;
        this.f12780i = false;
    }

    public final void mo1317h() {
        mo1316g();
        this.f12778g = a;
        this.f12774c = -1;
        this.f12775d = -1;
        this.f12777f = null;
        this.f12776e = false;
    }
}
