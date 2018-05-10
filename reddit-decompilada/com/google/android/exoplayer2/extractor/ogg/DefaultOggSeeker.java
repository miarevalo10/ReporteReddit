package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import java.io.EOFException;
import java.io.IOException;
import org.jcodec.codecs.mpeg12.MPEGConst;

final class DefaultOggSeeker implements OggSeeker {
    private final OggPageHeader f13002a = new OggPageHeader();
    private final long f13003b;
    private final long f13004c;
    private final StreamReader f13005d;
    private int f13006e;
    private long f13007f;
    private long f13008g;
    private long f13009h;
    private long f13010i;
    private long f13011j;
    private long f13012k;
    private long f13013l;

    private class OggSeekMap implements SeekMap {
        final /* synthetic */ DefaultOggSeeker f13001a;

        public final boolean a_() {
            return true;
        }

        private OggSeekMap(DefaultOggSeeker defaultOggSeeker) {
            this.f13001a = defaultOggSeeker;
        }

        public final long mo1329b(long j) {
            if (j == 0) {
                return this.f13001a.f13003b;
            }
            return DefaultOggSeeker.m12114a(this.f13001a, this.f13001a.f13003b, this.f13001a.f13005d.m3838b(j));
        }

        public final long mo1328b() {
            return this.f13001a.f13005d.m3833a(this.f13001a.f13007f);
        }
    }

    public DefaultOggSeeker(long j, long j2, StreamReader streamReader, int i, long j3) {
        boolean z = j >= 0 && j2 > j;
        Assertions.m4184a(z);
        this.f13005d = streamReader;
        this.f13003b = j;
        this.f13004c = j2;
        if (((long) i) == j2 - j) {
            this.f13007f = j3;
            this.f13006e = 3;
            return;
        }
        this.f13006e = 0;
    }

    public final long mo1370a(ExtractorInput extractorInput) throws IOException, InterruptedException {
        ExtractorInput extractorInput2 = extractorInput;
        long j;
        switch (this.f13006e) {
            case 0:
                r6.f13008g = extractorInput.mo1338c();
                r6.f13006e = 1;
                j = r6.f13004c - 65307;
                if (j > r6.f13008g) {
                    return j;
                }
                break;
            case 1:
                break;
            case 2:
                long j2 = 0;
                if (r6.f13009h != 0) {
                    long j3;
                    j = r6.f13009h;
                    if (r6.f13010i == r6.f13011j) {
                        j3 = -(r6.f13012k + 2);
                    } else {
                        long c = extractorInput.mo1338c();
                        if (m12115a(extractorInput2, r6.f13011j)) {
                            r6.f13002a.m3827a(extractorInput2, false);
                            extractorInput.mo1332a();
                            j -= r6.f13002a.f4502c;
                            int i = r6.f13002a.f4507h + r6.f13002a.f4508i;
                            int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                            if (i2 >= 0) {
                                if (j <= 72000) {
                                    extractorInput2.mo1335b(i);
                                    j3 = -(r6.f13002a.f4502c + 2);
                                }
                            }
                            int i3;
                            if (i2 < 0) {
                                r6.f13011j = c;
                                r6.f13013l = r6.f13002a.f4502c;
                                i3 = i2;
                                if (r6.f13011j - r6.f13010i >= 100000) {
                                    r6.f13011j = r6.f13010i;
                                    j3 = r6.f13010i;
                                } else {
                                    j3 = Math.min(Math.max((extractorInput.mo1338c() - ((long) (i * (i3 > 0 ? 2 : 1)))) + ((j * (r6.f13011j - r6.f13010i)) / (r6.f13013l - r6.f13012k)), r6.f13010i), r6.f13011j - 1);
                                }
                            } else {
                                long j4 = (long) i;
                                r6.f13010i = extractorInput.mo1338c() + j4;
                                r6.f13012k = r6.f13002a.f4502c;
                                i3 = i2;
                                if ((r6.f13011j - r6.f13010i) + j4 < 100000) {
                                    extractorInput2.mo1335b(i);
                                    j3 = -(r6.f13012k + 2);
                                }
                                if (r6.f13011j - r6.f13010i >= 100000) {
                                    if (i3 > 0) {
                                    }
                                    j3 = Math.min(Math.max((extractorInput.mo1338c() - ((long) (i * (i3 > 0 ? 2 : 1)))) + ((j * (r6.f13011j - r6.f13010i)) / (r6.f13013l - r6.f13012k)), r6.f13010i), r6.f13011j - 1);
                                } else {
                                    r6.f13011j = r6.f13010i;
                                    j3 = r6.f13010i;
                                }
                            }
                            j = 0;
                            if (j3 >= j) {
                                return j3;
                            }
                            j2 = m12112a(extractorInput2, r6.f13009h, -(j3 + 2));
                        } else if (r6.f13010i == c) {
                            throw new IOException("No ogg page can be found.");
                        } else {
                            j3 = r6.f13010i;
                        }
                    }
                    j = 0;
                    if (j3 >= j) {
                        return j3;
                    }
                    j2 = m12112a(extractorInput2, r6.f13009h, -(j3 + 2));
                }
                r6.f13006e = 3;
                return -(j2 + 2);
            case 3:
                return -1;
            default:
                throw new IllegalStateException();
        }
        if (m12115a(extractorInput2, r6.f13004c)) {
            r6.f13002a.m3826a();
            while ((r6.f13002a.f4501b & 4) != 4 && extractorInput.mo1338c() < r6.f13004c) {
                r6.f13002a.m3827a(extractorInput2, false);
                extractorInput2.mo1335b(r6.f13002a.f4507h + r6.f13002a.f4508i);
            }
            r6.f13007f = r6.f13002a.f4502c;
            r6.f13006e = 3;
            return r6.f13008g;
        }
        throw new EOFException();
    }

    public final long mo1369a(long j) {
        boolean z;
        if (this.f13006e != 3) {
            if (this.f13006e != 2) {
                z = false;
                Assertions.m4184a(z);
                if (j != 0) {
                    j = 0;
                } else {
                    j = this.f13005d.m3838b(j);
                }
                this.f13009h = j;
                this.f13006e = 2;
                this.f13010i = this.f13003b;
                this.f13011j = this.f13004c;
                this.f13012k = 0;
                this.f13013l = this.f13007f;
                return this.f13009h;
            }
        }
        z = true;
        Assertions.m4184a(z);
        if (j != 0) {
            j = this.f13005d.m3838b(j);
        } else {
            j = 0;
        }
        this.f13009h = j;
        this.f13006e = 2;
        this.f13010i = this.f13003b;
        this.f13011j = this.f13004c;
        this.f13012k = 0;
        this.f13013l = this.f13007f;
        return this.f13009h;
    }

    private boolean m12115a(ExtractorInput extractorInput, long j) throws IOException, InterruptedException {
        j = Math.min(j + 3, this.f13004c);
        int i = MPEGConst.CODE_END;
        byte[] bArr = new byte[MPEGConst.CODE_END];
        while (true) {
            int i2;
            int i3 = 0;
            if (extractorInput.mo1338c() + ((long) i) > j) {
                i = (int) (j - extractorInput.mo1338c());
                if (i < 4) {
                    return false;
                }
            }
            extractorInput.mo1337b(bArr, 0, i, false);
            while (true) {
                i2 = i - 3;
                if (i3 >= i2) {
                    break;
                } else if (bArr[i3] == (byte) 79 && bArr[i3 + 1] == (byte) 103 && bArr[i3 + 2] == (byte) 103 && bArr[i3 + 3] == (byte) 83) {
                    extractorInput.mo1335b(i3);
                    return true;
                } else {
                    i3++;
                }
            }
            extractorInput.mo1335b(i2);
        }
    }

    private long m12112a(ExtractorInput extractorInput, long j, long j2) throws IOException, InterruptedException {
        this.f13002a.m3827a(extractorInput, false);
        while (this.f13002a.f4502c < j) {
            extractorInput.mo1335b(this.f13002a.f4507h + this.f13002a.f4508i);
            j2 = this.f13002a.f4502c;
            this.f13002a.m3827a(extractorInput, false);
        }
        extractorInput.mo1332a();
        return j2;
    }

    public final /* synthetic */ SeekMap mo1371a() {
        return this.f13007f != 0 ? new OggSeekMap() : null;
    }

    static /* synthetic */ long m12114a(DefaultOggSeeker defaultOggSeeker, long j, long j2) {
        j += ((j2 * (defaultOggSeeker.f13004c - defaultOggSeeker.f13003b)) / defaultOggSeeker.f13007f) - 30000;
        if (j < defaultOggSeeker.f13003b) {
            j = defaultOggSeeker.f13003b;
        }
        return j >= defaultOggSeeker.f13004c ? defaultOggSeeker.f13004c - 1 : j;
    }
}
