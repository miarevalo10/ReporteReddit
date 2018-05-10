package com.google.android.exoplayer2.text.webvtt;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;

public final class WebvttDecoder extends SimpleSubtitleDecoder {
    private final WebvttCueParser f19063c = new WebvttCueParser();
    private final ParsableByteArray f19064d = new ParsableByteArray();
    private final Builder f19065e = new Builder();
    private final CssParser f19066f = new CssParser();
    private final List<WebvttCssStyle> f19067g = new ArrayList();

    public WebvttDecoder() {
        super("WebvttDecoder");
    }

    private static void m20118b(ParsableByteArray parsableByteArray) {
        do {
        } while (!TextUtils.isEmpty(parsableByteArray.m4267r()));
    }

    private static int m20117a(ParsableByteArray parsableByteArray) {
        int i = 0;
        int i2 = -1;
        while (i2 == -1) {
            i = parsableByteArray.f5257b;
            String r = parsableByteArray.m4267r();
            i2 = r == null ? 0 : "STYLE".equals(r) ? 2 : "NOTE".startsWith(r) ? 1 : 3;
        }
        parsableByteArray.m4249c(i);
        return i2;
    }

    protected final /* synthetic */ Subtitle mo3931a(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        this.f19064d.m4244a(bArr, i);
        this.f19065e.m4103a();
        this.f19067g.clear();
        WebvttParserUtil.m4115a(this.f19064d);
        do {
        } while (TextUtils.isEmpty(this.f19064d.m4267r()) == null);
        bArr = new ArrayList();
        while (true) {
            boolean a = m20117a(this.f19064d);
            if (!a) {
                return new WebvttSubtitle(bArr);
            }
            if (a) {
                m20118b(this.f19064d);
            } else if (a) {
                if (bArr.isEmpty() == 0) {
                    throw new SubtitleDecoderException("A style block was found after the first cue.");
                }
                this.f19064d.m4267r();
                i = this.f19066f.m4100a(this.f19064d);
                if (i != 0) {
                    this.f19067g.add(i);
                }
            } else if (a && this.f19063c.m4113a(this.f19064d, this.f19065e, this.f19067g) != 0) {
                bArr.add(this.f19065e.m4104b());
                this.f19065e.m4103a();
            }
        }
    }
}
