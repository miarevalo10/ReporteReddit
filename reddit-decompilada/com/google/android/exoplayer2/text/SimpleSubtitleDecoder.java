package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.decoder.SimpleDecoder;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;

public abstract class SimpleSubtitleDecoder extends SimpleDecoder<SubtitleInputBuffer, SubtitleOutputBuffer, SubtitleDecoderException> implements SubtitleDecoder {
    private final String f17030c;

    public abstract Subtitle mo3931a(byte[] bArr, int i, boolean z) throws SubtitleDecoderException;

    public final void mo3378a(long j) {
    }

    protected SimpleSubtitleDecoder(String str) {
        super(new SubtitleInputBuffer[2], new SubtitleOutputBuffer[2]);
        this.f17030c = str;
        int i = 0;
        Assertions.m4186b(this.f12806b == this.f12805a.length ? true : null);
        str = this.f12805a;
        int length = str.length;
        while (i < length) {
            str[i].m11973c(1024);
            i++;
        }
    }

    protected final void m17328a(SubtitleOutputBuffer subtitleOutputBuffer) {
        super.mo3379a((OutputBuffer) subtitleOutputBuffer);
    }

    private SubtitleDecoderException m17323a(SubtitleInputBuffer subtitleInputBuffer, SubtitleOutputBuffer subtitleOutputBuffer, boolean z) {
        try {
            ByteBuffer byteBuffer = subtitleInputBuffer.c;
            SubtitleOutputBuffer subtitleOutputBuffer2 = subtitleOutputBuffer;
            subtitleOutputBuffer2.m17333a(subtitleInputBuffer.d, mo3931a(byteBuffer.array(), byteBuffer.limit(), z), subtitleInputBuffer.f17031f);
            subtitleOutputBuffer.f4220a &= true;
            return null;
        } catch (SubtitleInputBuffer subtitleInputBuffer2) {
            return subtitleInputBuffer2;
        }
    }

    protected final /* synthetic */ OutputBuffer mo3381f() {
        return new SimpleSubtitleOutputBuffer(this);
    }

    protected final /* synthetic */ DecoderInputBuffer mo3380e() {
        return new SubtitleInputBuffer();
    }
}
