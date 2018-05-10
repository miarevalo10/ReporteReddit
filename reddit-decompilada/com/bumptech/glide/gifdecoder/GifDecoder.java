package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.nio.ByteBuffer;

public interface GifDecoder {

    public interface BitmapProvider {
        Bitmap mo995a(int i, int i2, Config config);

        void mo996a(Bitmap bitmap);

        void mo997a(byte[] bArr);

        void mo998a(int[] iArr);

        byte[] mo999a(int i);

        int[] mo1000b(int i);
    }

    ByteBuffer mo874a();

    void mo875a(Config config);

    void mo876b();

    int mo877c();

    int mo878d();

    int mo879e();

    void mo880f();

    int mo881g();

    Bitmap mo882h();

    void mo883i();
}
