package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.FlacStreamInfo;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.containers.mxf.model.BER;

final class FlacReader extends StreamReader {
    private FlacStreamInfo f13019c;
    private FlacOggSeeker f13020d;

    private class FlacOggSeeker implements SeekMap, OggSeeker {
        long[] f13014a;
        long[] f13015b;
        long f13016c = -1;
        final /* synthetic */ FlacReader f13017d;
        private long f13018e = -1;

        public final SeekMap mo1371a() {
            return this;
        }

        public final boolean a_() {
            return true;
        }

        public FlacOggSeeker(FlacReader flacReader) {
            this.f13017d = flacReader;
        }

        public final long mo1370a(ExtractorInput extractorInput) throws IOException, InterruptedException {
            if (this.f13018e < 0) {
                return -1;
            }
            long j = -(this.f13018e + 2);
            this.f13018e = -1;
            return j;
        }

        public final long mo1369a(long j) {
            j = this.f13017d.m3838b(j);
            this.f13018e = this.f13014a[Util.m4300a(this.f13014a, j, true)];
            return j;
        }

        public final long mo1329b(long j) {
            return this.f13016c + this.f13015b[Util.m4300a(this.f13014a, this.f13017d.m3838b(j), true)];
        }

        public final long mo1328b() {
            FlacStreamInfo a = this.f13017d.f13019c;
            return (a.f5232h * 1000000) / ((long) a.f5229e);
        }
    }

    FlacReader() {
    }

    public static boolean m12127a(ParsableByteArray parsableByteArray) {
        return (parsableByteArray.m4246b() >= 5 && parsableByteArray.m4250d() == 127 && parsableByteArray.m4257h() == 1179402563) ? true : null;
    }

    protected final void mo1372a(boolean z) {
        super.mo1372a(z);
        if (z) {
            this.f13019c = null;
            this.f13020d = null;
        }
    }

    private static boolean m12128a(byte[] bArr) {
        return bArr[0] == -1 ? 1 : false;
    }

    protected final long mo1374b(ParsableByteArray parsableByteArray) {
        if (!m12128a(parsableByteArray.f5256a)) {
            return -1;
        }
        int i = (parsableByteArray.f5256a[2] & 255) >> 4;
        switch (i) {
            case 1:
                parsableByteArray = JpegConst.SOF0;
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                parsableByteArray = 576 << (i - 2);
                break;
            case 6:
            case 7:
                int i2;
                long j;
                int i3;
                byte b;
                StringBuilder stringBuilder;
                parsableByteArray.m4251d(4);
                long j2 = (long) parsableByteArray.f5256a[parsableByteArray.f5257b];
                for (int i4 = 7; i4 >= 0; i4--) {
                    int i5 = 1 << i4;
                    if ((((long) i5) & j2) == 0) {
                        if (i4 < 6) {
                            j2 &= (long) (i5 - 1);
                            i2 = 7 - i4;
                        } else {
                            if (i4 == 7) {
                                i2 = 1;
                            }
                            i2 = 0;
                        }
                        if (i2 == 0) {
                            j = j2;
                            for (i3 = 1; i3 < i2; i3++) {
                                b = parsableByteArray.f5256a[parsableByteArray.f5257b + i3];
                                if ((b & JpegConst.SOF0) == 128) {
                                    stringBuilder = new StringBuilder("Invalid UTF-8 sequence continuation byte: ");
                                    stringBuilder.append(j);
                                    throw new NumberFormatException(stringBuilder.toString());
                                }
                                j = (j << 6) | ((long) (b & 63));
                            }
                            parsableByteArray.f5257b += i2;
                            i = i != 6 ? parsableByteArray.m4250d() : parsableByteArray.m4252e();
                            parsableByteArray.m4249c(0);
                            parsableByteArray = i + 1;
                            break;
                        }
                        stringBuilder = new StringBuilder("Invalid UTF-8 sequence first byte: ");
                        stringBuilder.append(j2);
                        throw new NumberFormatException(stringBuilder.toString());
                    }
                }
                i2 = 0;
                if (i2 == 0) {
                    j = j2;
                    while (i3 < i2) {
                        b = parsableByteArray.f5256a[parsableByteArray.f5257b + i3];
                        if ((b & JpegConst.SOF0) == 128) {
                            j = (j << 6) | ((long) (b & 63));
                        } else {
                            stringBuilder = new StringBuilder("Invalid UTF-8 sequence continuation byte: ");
                            stringBuilder.append(j);
                            throw new NumberFormatException(stringBuilder.toString());
                        }
                    }
                    parsableByteArray.f5257b += i2;
                    if (i != 6) {
                    }
                    parsableByteArray.m4249c(0);
                    parsableByteArray = i + 1;
                } else {
                    stringBuilder = new StringBuilder("Invalid UTF-8 sequence first byte: ");
                    stringBuilder.append(j2);
                    throw new NumberFormatException(stringBuilder.toString());
                }
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                parsableByteArray = 256 << (i - 8);
                break;
            default:
                parsableByteArray = -1;
                break;
        }
        return (long) parsableByteArray;
    }

    protected final boolean mo1373a(ParsableByteArray parsableByteArray, long j, SetupData setupData) throws IOException, InterruptedException {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        SetupData setupData2 = setupData;
        byte[] bArr = parsableByteArray2.f5256a;
        if (this.f13019c == null) {
            r0.f13019c = new FlacStreamInfo(bArr);
            Object copyOfRange = Arrays.copyOfRange(bArr, 9, parsableByteArray2.f5258c);
            copyOfRange[4] = BER.ASN_LONG_LEN;
            List singletonList = Collections.singletonList(copyOfRange);
            FlacStreamInfo flacStreamInfo = r0.f13019c;
            setupData2.f4511a = Format.m3558a(null, "audio/flac", -1, flacStreamInfo.f5231g * flacStreamInfo.f5229e, r0.f13019c.f5230f, r0.f13019c.f5229e, singletonList, null, null);
        } else {
            int i = 0;
            if ((bArr[0] & 127) == 3) {
                r0.f13020d = new FlacOggSeeker(r0);
                FlacOggSeeker flacOggSeeker = r0.f13020d;
                parsableByteArray2.m4251d(1);
                int g = parsableByteArray.m4256g() / 18;
                flacOggSeeker.f13014a = new long[g];
                flacOggSeeker.f13015b = new long[g];
                while (i < g) {
                    flacOggSeeker.f13014a[i] = parsableByteArray.m4261l();
                    flacOggSeeker.f13015b[i] = parsableByteArray.m4261l();
                    parsableByteArray2.m4251d(2);
                    i++;
                }
            } else if (m12128a(bArr)) {
                if (r0.f13020d != null) {
                    r0.f13020d.f13016c = j;
                    setupData2.f4512b = r0.f13020d;
                }
                return false;
            }
        }
        return true;
    }
}
