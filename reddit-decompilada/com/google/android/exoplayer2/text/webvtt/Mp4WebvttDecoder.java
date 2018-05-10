package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;

public final class Mp4WebvttDecoder extends SimpleSubtitleDecoder {
    private static final int f19058c = Util.m4326g("payl");
    private static final int f19059d = Util.m4326g("sttg");
    private static final int f19060e = Util.m4326g("vttc");
    private final ParsableByteArray f19061f = new ParsableByteArray();
    private final Builder f19062g = new Builder();

    public Mp4WebvttDecoder() {
        super("Mp4WebvttDecoder");
    }

    private static Cue m20115a(ParsableByteArray parsableByteArray, Builder builder, int i) throws SubtitleDecoderException {
        builder.m4103a();
        while (i > 0) {
            if (i < 8) {
                throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
            }
            int j = parsableByteArray.m4259j();
            int j2 = parsableByteArray.m4259j();
            i -= 8;
            j -= 8;
            String str = new String(parsableByteArray.f5256a, parsableByteArray.f5257b, j);
            parsableByteArray.m4251d(j);
            i -= j;
            if (j2 == f19059d) {
                WebvttCueParser.m4108a(str, builder);
            } else if (j2 == f19058c) {
                WebvttCueParser.m4110a(null, str.trim(), builder, Collections.emptyList());
            }
        }
        return builder.m4104b();
    }

    protected final /* synthetic */ Subtitle mo3931a(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        this.f19061f.m4244a(bArr, i);
        bArr = new ArrayList();
        while (this.f19061f.m4246b() > 0) {
            if (this.f19061f.m4246b() < true) {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
            i = this.f19061f.m4259j();
            if (this.f19061f.m4259j() == f19060e) {
                bArr.add(m20115a(this.f19061f, this.f19062g, i - 8));
            } else {
                this.f19061f.m4251d(i - 8);
            }
        }
        return new Mp4WebvttSubtitle(bArr);
    }
}
