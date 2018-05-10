package com.google.android.exoplayer2.source.hls;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.text.webvtt.WebvttParserUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class WebvttExtractor implements Extractor {
    private static final Pattern f13439a = Pattern.compile("LOCAL:([^,]+)");
    private static final Pattern f13440b = Pattern.compile("MPEGTS:(\\d+)");
    private final String f13441c;
    private final TimestampAdjuster f13442d;
    private final ParsableByteArray f13443e = new ParsableByteArray();
    private ExtractorOutput f13444f;
    private byte[] f13445g = new byte[1024];
    private int f13446h;

    public WebvttExtractor(String str, TimestampAdjuster timestampAdjuster) {
        this.f13441c = str;
        this.f13442d = timestampAdjuster;
    }

    public final boolean mo1353a(ExtractorInput extractorInput) throws IOException, InterruptedException {
        throw new IllegalStateException();
    }

    public final void mo1352a(ExtractorOutput extractorOutput) {
        this.f13444f = extractorOutput;
        extractorOutput.mo1417a(new Unseekable(-9223372036854775807L));
    }

    public final void mo1351a(long j, long j2) {
        throw new IllegalStateException();
    }

    public final int mo1350a(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        Object d = (int) extractorInput.mo1341d();
        if (this.f13446h == this.f13445g.length) {
            this.f13445g = Arrays.copyOf(this.f13445g, ((d != -1 ? d : this.f13445g.length) * 3) / 2);
        }
        extractorInput = extractorInput.mo1331a(this.f13445g, this.f13446h, this.f13445g.length - this.f13446h);
        if (extractorInput != -1) {
            this.f13446h += extractorInput;
            if (d == -1 || this.f13446h != d) {
                return null;
            }
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.f13445g);
        try {
            WebvttParserUtil.m4115a(parsableByteArray);
            long j = 0;
            long j2 = j;
            while (true) {
                positionHolder = parsableByteArray.m4267r();
                if (TextUtils.isEmpty(positionHolder)) {
                    break;
                } else if (positionHolder.startsWith("X-TIMESTAMP-MAP")) {
                    Matcher matcher = f13439a.matcher(positionHolder);
                    StringBuilder stringBuilder;
                    if (matcher.find()) {
                        Matcher matcher2 = f13440b.matcher(positionHolder);
                        if (matcher2.find()) {
                            j2 = WebvttParserUtil.m4114a(matcher.group(1));
                            j = TimestampAdjuster.m4282d(Long.parseLong(matcher2.group(1)));
                        } else {
                            stringBuilder = new StringBuilder("X-TIMESTAMP-MAP doesn't contain media timestamp: ");
                            stringBuilder.append(positionHolder);
                            throw new ParserException(stringBuilder.toString());
                        }
                    }
                    stringBuilder = new StringBuilder("X-TIMESTAMP-MAP doesn't contain local timestamp: ");
                    stringBuilder.append(positionHolder);
                    throw new ParserException(stringBuilder.toString());
                }
            }
            extractorInput = WebvttParserUtil.m4117b(parsableByteArray);
            if (extractorInput == null) {
                m12529a(0);
            } else {
                extractorInput = WebvttParserUtil.m4114a(extractorInput.group(1));
                long b = this.f13442d.m4286b(TimestampAdjuster.m4283e((j + extractorInput) - j2));
                TrackOutput a = m12529a(b - extractorInput);
                this.f13443e.m4244a(this.f13445g, this.f13446h);
                a.mo1346a(this.f13443e, this.f13446h);
                a.mo1344a(b, 1, this.f13446h, 0, null);
            }
            return -1;
        } catch (Throwable e) {
            throw new ParserException(e);
        }
    }

    private TrackOutput m12529a(long j) {
        TrackOutput a = this.f13444f.mo1415a(0, 3);
        a.mo1345a(Format.m3564a("text/vtt", this.f13441c, j));
        this.f13444f.mo1416a();
        return a;
    }
}
