package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

public class BytesResource implements Resource<byte[]> {
    private final byte[] f12616a;

    public final void mo928d() {
    }

    public BytesResource(byte[] bArr) {
        this.f12616a = (byte[]) Preconditions.m3217a((Object) bArr);
    }

    public final Class<byte[]> mo925a() {
        return byte[].class;
    }

    public final int mo927c() {
        return this.f12616a.length;
    }

    public final /* bridge */ /* synthetic */ Object mo926b() {
        return this.f12616a;
    }
}
