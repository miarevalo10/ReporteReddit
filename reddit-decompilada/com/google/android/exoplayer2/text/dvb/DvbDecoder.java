package com.google.android.exoplayer2.text.dvb;

import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.List;

public final class DvbDecoder extends SimpleSubtitleDecoder {
    private final DvbParser f19034c;

    public DvbDecoder(List<byte[]> list) {
        super("DvbDecoder");
        ParsableByteArray parsableByteArray = new ParsableByteArray((byte[]) list.get(0));
        this.f19034c = new DvbParser(parsableByteArray.m4252e(), parsableByteArray.m4252e());
    }

    protected final /* synthetic */ Subtitle mo3931a(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        if (z) {
            z = this.f19034c.f5040a;
            z.f5030c.clear();
            z.f5031d.clear();
            z.f5032e.clear();
            z.f5033f.clear();
            z.f5034g.clear();
            z.f5035h = null;
            z.f5036i = null;
        }
        return new DvbSubtitle(this.f19034c.m4075a(bArr, i));
    }
}
