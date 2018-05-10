package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.Stack;

final class DefaultEbmlReader implements EbmlReader {
    private final byte[] f12865a = new byte[8];
    private final Stack<MasterElement> f12866b = new Stack();
    private final VarintReader f12867c = new VarintReader();
    private EbmlReaderOutput f12868d;
    private int f12869e;
    private int f12870f;
    private long f12871g;

    private static final class MasterElement {
        private final int f4274a;
        private final long f4275b;

        private MasterElement(int i, long j) {
            this.f4274a = i;
            this.f4275b = j;
        }
    }

    DefaultEbmlReader() {
    }

    public final void mo1355a(EbmlReaderOutput ebmlReaderOutput) {
        this.f12868d = ebmlReaderOutput;
    }

    public final void mo1354a() {
        this.f12869e = 0;
        this.f12866b.clear();
        this.f12867c.m3786a();
    }

    public final boolean mo1356a(ExtractorInput extractorInput) throws IOException, InterruptedException {
        Assertions.m4186b(this.f12868d != null);
        while (true) {
            if (this.f12866b.isEmpty() || extractorInput.mo1338c() < ((MasterElement) this.f12866b.peek()).f4275b) {
                int a;
                int a2;
                if (this.f12869e == 0) {
                    long a3 = this.f12867c.m3785a(extractorInput, true, false, 4);
                    if (a3 == -2) {
                        extractorInput.mo1332a();
                        while (true) {
                            extractorInput.mo1340c(this.f12865a, 0, 4);
                            a = VarintReader.m3783a(this.f12865a[0]);
                            if (a != -1 && a <= 4) {
                                a2 = (int) VarintReader.m3784a(this.f12865a, a, false);
                                if (this.f12868d.mo1363b(a2)) {
                                    extractorInput.mo1335b(a);
                                    a3 = (long) a2;
                                }
                            }
                            extractorInput.mo1335b(1);
                        }
                    }
                    if (a3 == -1) {
                        return false;
                    }
                    this.f12870f = (int) a3;
                    this.f12869e = 1;
                }
                if (this.f12869e == 1) {
                    this.f12871g = this.f12867c.m3785a(extractorInput, false, true, 8);
                    this.f12869e = 2;
                }
                a = this.f12868d.mo1357a(this.f12870f);
                StringBuilder stringBuilder;
                EbmlReaderOutput ebmlReaderOutput;
                switch (a) {
                    case 0:
                        extractorInput.mo1335b((int) this.f12871g);
                        this.f12869e = 0;
                    case 1:
                        long c = extractorInput.mo1338c();
                        this.f12866b.add(new MasterElement(this.f12870f, this.f12871g + c));
                        this.f12868d.mo1361a(this.f12870f, c, this.f12871g);
                        this.f12869e = 0;
                        return true;
                    case 2:
                        if (this.f12871g > 8) {
                            stringBuilder = new StringBuilder("Invalid integer size: ");
                            stringBuilder.append(this.f12871g);
                            throw new ParserException(stringBuilder.toString());
                        }
                        this.f12868d.mo1360a(this.f12870f, m12042a(extractorInput, (int) this.f12871g));
                        this.f12869e = 0;
                        return true;
                    case 3:
                        if (this.f12871g > 2147483647L) {
                            stringBuilder = new StringBuilder("String element size: ");
                            stringBuilder.append(this.f12871g);
                            throw new ParserException(stringBuilder.toString());
                        }
                        String str;
                        ebmlReaderOutput = this.f12868d;
                        int i = this.f12870f;
                        a2 = (int) this.f12871g;
                        if (a2 == 0) {
                            str = "";
                        } else {
                            byte[] bArr = new byte[a2];
                            extractorInput.mo1336b(bArr, 0, a2);
                            str = new String(bArr);
                        }
                        ebmlReaderOutput.mo1362a(i, str);
                        this.f12869e = 0;
                        return true;
                    case 4:
                        this.f12868d.mo1359a(this.f12870f, (int) this.f12871g, extractorInput);
                        this.f12869e = 0;
                        return true;
                    case 5:
                        if (this.f12871g == 4 || this.f12871g == 8) {
                            double intBitsToFloat;
                            ebmlReaderOutput = this.f12868d;
                            a2 = this.f12870f;
                            int i2 = (int) this.f12871g;
                            long a4 = m12042a(extractorInput, i2);
                            if (i2 == 4) {
                                intBitsToFloat = (double) Float.intBitsToFloat((int) a4);
                            } else {
                                intBitsToFloat = Double.longBitsToDouble(a4);
                            }
                            ebmlReaderOutput.mo1358a(a2, intBitsToFloat);
                            this.f12869e = 0;
                            return true;
                        }
                        stringBuilder = new StringBuilder("Invalid float size: ");
                        stringBuilder.append(this.f12871g);
                        throw new ParserException(stringBuilder.toString());
                    default:
                        StringBuilder stringBuilder2 = new StringBuilder("Invalid element type ");
                        stringBuilder2.append(a);
                        throw new ParserException(stringBuilder2.toString());
                }
            }
            this.f12868d.mo1364c(((MasterElement) this.f12866b.pop()).f4274a);
            return true;
        }
    }

    private long m12042a(ExtractorInput extractorInput, int i) throws IOException, InterruptedException {
        int i2 = 0;
        extractorInput.mo1336b(this.f12865a, 0, i);
        long j = 0;
        while (i2 < i) {
            j = (j << 8) | ((long) (this.f12865a[i2] & 255));
            i2++;
        }
        return j;
    }
}
