package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;

final class OggPageHeader {
    private static final int f4499k = Util.m4326g("OggS");
    public int f4500a;
    public int f4501b;
    public long f4502c;
    public long f4503d;
    public long f4504e;
    public long f4505f;
    public int f4506g;
    public int f4507h;
    public int f4508i;
    public final int[] f4509j = new int[255];
    private final ParsableByteArray f4510l = new ParsableByteArray(255);

    OggPageHeader() {
    }

    public final void m3826a() {
        this.f4500a = 0;
        this.f4501b = 0;
        this.f4502c = 0;
        this.f4503d = 0;
        this.f4504e = 0;
        this.f4505f = 0;
        this.f4506g = 0;
        this.f4507h = 0;
        this.f4508i = 0;
    }

    public final boolean m3827a(ExtractorInput extractorInput, boolean z) throws IOException, InterruptedException {
        int i;
        this.f4510l.m4241a();
        m3826a();
        int i2 = 0;
        if (extractorInput.mo1341d() != -1) {
            if (extractorInput.mo1341d() - extractorInput.mo1334b() < 27) {
                i = 0;
                if (i != 0) {
                    if (!extractorInput.mo1337b(this.f4510l.f5256a, 0, 27, true)) {
                        if (this.f4510l.m4257h() != ((long) f4499k)) {
                            this.f4500a = this.f4510l.m4250d();
                            if (this.f4500a != 0) {
                                this.f4501b = this.f4510l.m4250d();
                                z = this.f4510l;
                                byte[] bArr = z.f5256a;
                                int i3 = z.f5257b;
                                z.f5257b = i3 + 1;
                                long j = ((long) bArr[i3]) & 255;
                                bArr = z.f5256a;
                                int i4 = z.f5257b;
                                z.f5257b = i4 + 1;
                                j |= (((long) bArr[i4]) & 255) << 8;
                                bArr = z.f5256a;
                                i4 = z.f5257b;
                                z.f5257b = i4 + 1;
                                j |= (((long) bArr[i4]) & 255) << 16;
                                bArr = z.f5256a;
                                i4 = z.f5257b;
                                z.f5257b = i4 + 1;
                                j |= (((long) bArr[i4]) & 255) << 24;
                                bArr = z.f5256a;
                                i4 = z.f5257b;
                                z.f5257b = i4 + 1;
                                j |= (((long) bArr[i4]) & 255) << 32;
                                bArr = z.f5256a;
                                i4 = z.f5257b;
                                z.f5257b = i4 + 1;
                                j |= (((long) bArr[i4]) & 255) << 40;
                                bArr = z.f5256a;
                                i4 = z.f5257b;
                                z.f5257b = i4 + 1;
                                j |= (((long) bArr[i4]) & 255) << 48;
                                bArr = z.f5256a;
                                i4 = z.f5257b;
                                z.f5257b = i4 + 1;
                                this.f4502c = j | ((255 & ((long) bArr[i4])) << true);
                                this.f4503d = this.f4510l.m4258i();
                                this.f4504e = this.f4510l.m4258i();
                                this.f4505f = this.f4510l.m4258i();
                                this.f4506g = this.f4510l.m4250d();
                                this.f4507h = 27 + this.f4506g;
                                this.f4510l.m4241a();
                                extractorInput.mo1340c(this.f4510l.f5256a, 0, this.f4506g);
                                while (i2 < this.f4506g) {
                                    this.f4509j[i2] = this.f4510l.m4250d();
                                    this.f4508i += this.f4509j[i2];
                                    i2++;
                                }
                                return true;
                            } else if (z) {
                                return false;
                            } else {
                                throw new ParserException("unsupported bit stream revision");
                            }
                        } else if (z) {
                            return false;
                        } else {
                            throw new ParserException("expected OggS capture pattern at begin of page");
                        }
                    }
                }
                if (z) {
                    return false;
                }
                throw new EOFException();
            }
        }
        i = true;
        if (i != 0) {
            if (!extractorInput.mo1337b(this.f4510l.f5256a, 0, 27, true)) {
                if (this.f4510l.m4257h() != ((long) f4499k)) {
                    this.f4500a = this.f4510l.m4250d();
                    if (this.f4500a != 0) {
                        this.f4501b = this.f4510l.m4250d();
                        z = this.f4510l;
                        byte[] bArr2 = z.f5256a;
                        int i32 = z.f5257b;
                        z.f5257b = i32 + 1;
                        long j2 = ((long) bArr2[i32]) & 255;
                        bArr2 = z.f5256a;
                        int i42 = z.f5257b;
                        z.f5257b = i42 + 1;
                        j2 |= (((long) bArr2[i42]) & 255) << 8;
                        bArr2 = z.f5256a;
                        i42 = z.f5257b;
                        z.f5257b = i42 + 1;
                        j2 |= (((long) bArr2[i42]) & 255) << 16;
                        bArr2 = z.f5256a;
                        i42 = z.f5257b;
                        z.f5257b = i42 + 1;
                        j2 |= (((long) bArr2[i42]) & 255) << 24;
                        bArr2 = z.f5256a;
                        i42 = z.f5257b;
                        z.f5257b = i42 + 1;
                        j2 |= (((long) bArr2[i42]) & 255) << 32;
                        bArr2 = z.f5256a;
                        i42 = z.f5257b;
                        z.f5257b = i42 + 1;
                        j2 |= (((long) bArr2[i42]) & 255) << 40;
                        bArr2 = z.f5256a;
                        i42 = z.f5257b;
                        z.f5257b = i42 + 1;
                        j2 |= (((long) bArr2[i42]) & 255) << 48;
                        bArr2 = z.f5256a;
                        i42 = z.f5257b;
                        z.f5257b = i42 + 1;
                        this.f4502c = j2 | ((255 & ((long) bArr2[i42])) << true);
                        this.f4503d = this.f4510l.m4258i();
                        this.f4504e = this.f4510l.m4258i();
                        this.f4505f = this.f4510l.m4258i();
                        this.f4506g = this.f4510l.m4250d();
                        this.f4507h = 27 + this.f4506g;
                        this.f4510l.m4241a();
                        extractorInput.mo1340c(this.f4510l.f5256a, 0, this.f4506g);
                        while (i2 < this.f4506g) {
                            this.f4509j[i2] = this.f4510l.m4250d();
                            this.f4508i += this.f4509j[i2];
                            i2++;
                        }
                        return true;
                    } else if (z) {
                        return false;
                    } else {
                        throw new ParserException("unsupported bit stream revision");
                    }
                } else if (z) {
                    return false;
                } else {
                    throw new ParserException("expected OggS capture pattern at begin of page");
                }
            }
        }
        if (z) {
            return false;
        }
        throw new EOFException();
    }
}
