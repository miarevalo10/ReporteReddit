package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

final class Sonic {
    final int f4196a;
    final int f4197b = (2 * this.f4208m);
    short[] f4198c;
    short[] f4199d;
    float f4200e;
    float f4201f;
    int f4202g;
    int f4203h;
    int f4204i;
    int f4205j;
    private final int f4206k;
    private final int f4207l;
    private final int f4208m;
    private final short[] f4209n = new short[this.f4197b];
    private int f4210o = this.f4197b;
    private int f4211p;
    private int f4212q;
    private short[] f4213r;
    private int f4214s;
    private int f4215t;
    private int f4216u;
    private int f4217v;
    private int f4218w;
    private int f4219x;

    public Sonic(int i, int i2) {
        this.f4206k = i;
        this.f4196a = i2;
        this.f4207l = i / 400;
        this.f4208m = i / 65;
        this.f4198c = new short[(this.f4197b * i2)];
        this.f4211p = this.f4197b;
        this.f4199d = new short[(this.f4197b * i2)];
        this.f4212q = this.f4197b;
        this.f4213r = new short[(this.f4197b * i2)];
        this.f4214s = 0;
        this.f4215t = 0;
        this.f4216u = 0;
        this.f4200e = 1.0f;
        this.f4201f = 1.0f;
    }

    private void m3708b(int i) {
        if (this.f4203h + i > this.f4211p) {
            this.f4211p += (this.f4211p / 2) + i;
            this.f4199d = Arrays.copyOf(this.f4199d, this.f4211p * this.f4196a);
        }
    }

    final void m3711a(int i) {
        if (this.f4202g + i > this.f4210o) {
            this.f4210o += (this.f4210o / 2) + i;
            this.f4198c = Arrays.copyOf(this.f4198c, this.f4210o * this.f4196a);
        }
    }

    private void m3707a(short[] sArr, int i, int i2) {
        m3708b(i2);
        System.arraycopy(sArr, i * this.f4196a, this.f4199d, this.f4203h * this.f4196a, this.f4196a * i2);
        this.f4203h += i2;
    }

    private void m3709b(short[] sArr, int i, int i2) {
        int i3 = this.f4197b / i2;
        int i4 = this.f4196a * i2;
        i *= this.f4196a;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = 0;
            int i7 = i6;
            while (i6 < i4) {
                i7 += sArr[((i5 * i4) + i) + i6];
                i6++;
            }
            this.f4209n[i5] = (short) (i7 / i4);
        }
    }

    private int m3705a(short[] sArr, int i, int i2, int i3) {
        i *= this.f4196a;
        int i4 = 1;
        int i5 = 0;
        int i6 = 255;
        int i7 = i5;
        while (i2 <= i3) {
            int i8 = 0;
            int i9 = i8;
            while (i8 < i2) {
                i9 += Math.abs(sArr[i + i8] - sArr[(i + i2) + i8]);
                i8++;
            }
            if (i9 * i7 < i4 * i2) {
                i7 = i2;
                i4 = i9;
            }
            if (i9 * i6 > i5 * i2) {
                i6 = i2;
                i5 = i9;
            }
            i2++;
        }
        this.f4218w = i4 / i7;
        this.f4219x = i5 / i6;
        return i7;
    }

    final void m3710a() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = this.f4203h;
        float f = this.f4200e / this.f4201f;
        double d = (double) f;
        int i6 = 1;
        if (d <= 1.00001d) {
            if (d >= 0.99999d) {
                m3707a(r0.f4198c, 0, r0.f4202g);
                r0.f4202g = 0;
                if (r0.f4201f != 1.0f) {
                    f = r0.f4201f;
                    if (r0.f4203h != i5) {
                        i = (int) (((float) r0.f4206k) / f);
                        i2 = r0.f4206k;
                        while (true) {
                            if (i > 16384) {
                                if (i2 > 16384) {
                                    break;
                                }
                            }
                            i /= 2;
                            i2 /= 2;
                        }
                        i3 = r0.f4203h - i5;
                        if (r0.f4204i + i3 > r0.f4212q) {
                            r0.f4212q += (r0.f4212q / 2) + i3;
                            r0.f4213r = Arrays.copyOf(r0.f4213r, r0.f4212q * r0.f4196a);
                        }
                        System.arraycopy(r0.f4199d, r0.f4196a * i5, r0.f4213r, r0.f4204i * r0.f4196a, r0.f4196a * i3);
                        r0.f4203h = i5;
                        r0.f4204i += i3;
                        i5 = 0;
                        while (true) {
                            i4 = 1;
                            if (i5 < r0.f4204i - 1) {
                                break;
                            }
                            while ((r0.f4214s + i4) * i > r0.f4215t * i2) {
                                m3708b(i4);
                                for (i3 = 0; i3 < r0.f4196a; i3++) {
                                    short[] sArr = r0.f4199d;
                                    int i7 = (r0.f4203h * r0.f4196a) + i3;
                                    short[] sArr2 = r0.f4213r;
                                    int i8 = (r0.f4196a * i5) + i3;
                                    short s = sArr2[i8];
                                    short s2 = sArr2[i8 + r0.f4196a];
                                    int i9 = (r0.f4214s + 1) * i;
                                    i8 = i9 - (r0.f4215t * i2);
                                    i9 -= r0.f4214s * i;
                                    sArr[i7] = (short) (((s * i8) + ((i9 - i8) * s2)) / i9);
                                }
                                i4 = 1;
                                r0.f4215t++;
                                r0.f4203h++;
                            }
                            r0.f4214s += i4;
                            if (r0.f4214s == i2) {
                                r0.f4214s = 0;
                                Assertions.m4186b(r0.f4215t != i);
                                r0.f4215t = 0;
                            }
                            i5++;
                        }
                        i5 = r0.f4204i - 1;
                        if (i5 != 0) {
                            System.arraycopy(r0.f4213r, r0.f4196a * i5, r0.f4213r, 0, (r0.f4204i - i5) * r0.f4196a);
                            r0.f4204i -= i5;
                        }
                    }
                }
            }
        }
        if (r0.f4202g >= r0.f4197b) {
            i4 = r0.f4202g;
            int i10 = 0;
            while (true) {
                if (r0.f4205j > 0) {
                    i8 = Math.min(r0.f4197b, r0.f4205j);
                    m3707a(r0.f4198c, i10, i8);
                    r0.f4205j -= i8;
                    i10 += i8;
                } else {
                    int a;
                    int i11;
                    short[] sArr3;
                    int i12;
                    int i13;
                    Object obj;
                    int i14;
                    short[] sArr4 = r0.f4198c;
                    int i15 = r0.f4206k > 4000 ? r0.f4206k / 4000 : i6;
                    if (r0.f4196a == i6 && i15 == i6) {
                        i8 = m3705a(sArr4, i10, r0.f4207l, r0.f4208m);
                    } else {
                        m3709b(sArr4, i10, i15);
                        a = m3705a(r0.f4209n, 0, r0.f4207l / i15, r0.f4208m / i15);
                        if (i15 != i6) {
                            a *= i15;
                            i15 *= 4;
                            i9 = a - i15;
                            a += i15;
                            if (i9 < r0.f4207l) {
                                i9 = r0.f4207l;
                            }
                            if (a > r0.f4208m) {
                                a = r0.f4208m;
                            }
                            if (r0.f4196a == i6) {
                                i8 = m3705a(sArr4, i10, i9, a);
                            } else {
                                m3709b(sArr4, i10, i6);
                                i8 = m3705a(r0.f4209n, 0, i9, a);
                            }
                        } else {
                            i8 = a;
                        }
                    }
                    i15 = r0.f4218w;
                    a = r0.f4219x;
                    if (i15 != 0) {
                        if (r0.f4216u != 0) {
                            if (a <= i15 * 3) {
                                if (i15 * 2 > r0.f4217v * 3) {
                                    i15 = i6;
                                    i11 = i15 == 0 ? r0.f4216u : i8;
                                    r0.f4217v = r0.f4218w;
                                    r0.f4216u = i8;
                                    if (d <= 1.0d) {
                                        sArr3 = r0.f4198c;
                                        if (f < 2.0f) {
                                            i9 = (int) (((float) i11) / (f - 1.0f));
                                        } else {
                                            r0.f4205j = (int) ((((float) i11) * (2.0f - f)) / (f - 1.0f));
                                            i9 = i11;
                                        }
                                        m3708b(i9);
                                        i12 = i9;
                                        i6 = i11;
                                        i13 = i10;
                                        m3706a(i9, r0.f4196a, r0.f4199d, r0.f4203h, sArr3, i10, sArr3, i10 + i11);
                                        r0.f4203h += i12;
                                        i10 = i13 + (i6 + i12);
                                    } else {
                                        i6 = i11;
                                        i13 = i10;
                                        obj = r0.f4198c;
                                        if (f >= 0.5f) {
                                            i14 = (int) ((((float) i6) * f) / (1.0f - f));
                                        } else {
                                            r0.f4205j = (int) ((((float) i6) * ((2.0f * f) - 1.0f)) / (1.0f - f));
                                            i14 = i6;
                                        }
                                        i11 = i6 + i14;
                                        m3708b(i11);
                                        System.arraycopy(obj, r0.f4196a * i13, r0.f4199d, r0.f4203h * r0.f4196a, r0.f4196a * i6);
                                        i12 = i11;
                                        m3706a(i14, r0.f4196a, r0.f4199d, r0.f4203h + i6, obj, i13 + i6, obj, i13);
                                        r0.f4203h += i12;
                                        i10 = i13 + i14;
                                    }
                                }
                            }
                        }
                    }
                    i15 = 0;
                    if (i15 == 0) {
                    }
                    r0.f4217v = r0.f4218w;
                    r0.f4216u = i8;
                    if (d <= 1.0d) {
                        i6 = i11;
                        i13 = i10;
                        obj = r0.f4198c;
                        if (f >= 0.5f) {
                            r0.f4205j = (int) ((((float) i6) * ((2.0f * f) - 1.0f)) / (1.0f - f));
                            i14 = i6;
                        } else {
                            i14 = (int) ((((float) i6) * f) / (1.0f - f));
                        }
                        i11 = i6 + i14;
                        m3708b(i11);
                        System.arraycopy(obj, r0.f4196a * i13, r0.f4199d, r0.f4203h * r0.f4196a, r0.f4196a * i6);
                        i12 = i11;
                        m3706a(i14, r0.f4196a, r0.f4199d, r0.f4203h + i6, obj, i13 + i6, obj, i13);
                        r0.f4203h += i12;
                        i10 = i13 + i14;
                    } else {
                        sArr3 = r0.f4198c;
                        if (f < 2.0f) {
                            r0.f4205j = (int) ((((float) i11) * (2.0f - f)) / (f - 1.0f));
                            i9 = i11;
                        } else {
                            i9 = (int) (((float) i11) / (f - 1.0f));
                        }
                        m3708b(i9);
                        i12 = i9;
                        i6 = i11;
                        i13 = i10;
                        m3706a(i9, r0.f4196a, r0.f4199d, r0.f4203h, sArr3, i10, sArr3, i10 + i11);
                        r0.f4203h += i12;
                        i10 = i13 + (i6 + i12);
                    }
                }
                if (r0.f4197b + i10 > i4) {
                    break;
                }
                i6 = 1;
            }
            i = r0.f4202g - i10;
            System.arraycopy(r0.f4198c, i10 * r0.f4196a, r0.f4198c, 0, r0.f4196a * i);
            r0.f4202g = i;
        }
        if (r0.f4201f != 1.0f) {
            f = r0.f4201f;
            if (r0.f4203h != i5) {
                i = (int) (((float) r0.f4206k) / f);
                i2 = r0.f4206k;
                while (true) {
                    if (i > 16384) {
                        if (i2 > 16384) {
                            break;
                        }
                    }
                    i /= 2;
                    i2 /= 2;
                }
                i3 = r0.f4203h - i5;
                if (r0.f4204i + i3 > r0.f4212q) {
                    r0.f4212q += (r0.f4212q / 2) + i3;
                    r0.f4213r = Arrays.copyOf(r0.f4213r, r0.f4212q * r0.f4196a);
                }
                System.arraycopy(r0.f4199d, r0.f4196a * i5, r0.f4213r, r0.f4204i * r0.f4196a, r0.f4196a * i3);
                r0.f4203h = i5;
                r0.f4204i += i3;
                i5 = 0;
                while (true) {
                    i4 = 1;
                    if (i5 < r0.f4204i - 1) {
                        break;
                    }
                    while ((r0.f4214s + i4) * i > r0.f4215t * i2) {
                        m3708b(i4);
                        for (i3 = 0; i3 < r0.f4196a; i3++) {
                            short[] sArr5 = r0.f4199d;
                            int i72 = (r0.f4203h * r0.f4196a) + i3;
                            short[] sArr22 = r0.f4213r;
                            int i82 = (r0.f4196a * i5) + i3;
                            short s3 = sArr22[i82];
                            short s22 = sArr22[i82 + r0.f4196a];
                            int i92 = (r0.f4214s + 1) * i;
                            i82 = i92 - (r0.f4215t * i2);
                            i92 -= r0.f4214s * i;
                            sArr5[i72] = (short) (((s3 * i82) + ((i92 - i82) * s22)) / i92);
                        }
                        i4 = 1;
                        r0.f4215t++;
                        r0.f4203h++;
                    }
                    r0.f4214s += i4;
                    if (r0.f4214s == i2) {
                        r0.f4214s = 0;
                        if (r0.f4215t != i) {
                        }
                        Assertions.m4186b(r0.f4215t != i);
                        r0.f4215t = 0;
                    }
                    i5++;
                }
                i5 = r0.f4204i - 1;
                if (i5 != 0) {
                    System.arraycopy(r0.f4213r, r0.f4196a * i5, r0.f4213r, 0, (r0.f4204i - i5) * r0.f4196a);
                    r0.f4204i -= i5;
                }
            }
        }
    }

    private static void m3706a(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i4 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i3 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i9] = (short) (((sArr2[i7] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i9 += i2;
                i7 += i2;
                i8 += i2;
            }
        }
    }
}
