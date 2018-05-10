package com.google.android.exoplayer2.text.cea;

import android.graphics.Color;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.jcodec.codecs.mjpeg.JpegConst;

public final class Cea708Decoder extends CeaDecoder {
    private final ParsableByteArray f19024b = new ParsableByteArray();
    private final ParsableBitArray f19025c = new ParsableBitArray();
    private final int f19026d;
    private final CueBuilder[] f19027e;
    private CueBuilder f19028f;
    private List<Cue> f19029g;
    private List<Cue> f19030h;
    private DtvCcPacket f19031i;
    private int f19032j;

    private static final class CueBuilder {
        public static final int f4954a = m4053a(2, 2, 2, 0);
        public static final int f4955b = m4053a(0, 0, 0, 0);
        public static final int f4956c = m4053a(0, 0, 0, 3);
        static final int[] f4957d = new int[]{0, 0, 0, 0, 0, 2, 0};
        static final int[] f4958e = new int[]{f4955b, f4956c, f4955b, f4955b, f4956c, f4955b, f4955b};
        static final int[] f4959f = new int[]{f4955b, f4955b, f4955b, f4955b, f4955b, f4956c, f4956c};
        private static final int[] f4960u = new int[]{0, 0, 0, 0, 0, 0, 2};
        private static final int[] f4961v = new int[]{3, 3, 3, 3, 3, 3, 1};
        private static final boolean[] f4962w = new boolean[]{false, false, false, true, true, true, false};
        private static final int[] f4963x = new int[]{0, 1, 2, 3, 4, 3, 4};
        private static final int[] f4964y = new int[]{0, 0, 0, 0, 0, 3, 3};
        private int f4965A;
        private int f4966B;
        private int f4967C;
        private int f4968D;
        private int f4969E;
        private int f4970F;
        private int f4971G;
        final List<SpannableString> f4972g = new LinkedList();
        final SpannableStringBuilder f4973h = new SpannableStringBuilder();
        boolean f4974i;
        boolean f4975j;
        int f4976k;
        boolean f4977l;
        int f4978m;
        int f4979n;
        int f4980o;
        int f4981p;
        boolean f4982q;
        int f4983r;
        int f4984s;
        int f4985t;
        private int f4986z;

        public CueBuilder() {
            m4059b();
        }

        public final void m4059b() {
            m4061c();
            this.f4974i = false;
            this.f4975j = false;
            this.f4976k = 4;
            this.f4977l = false;
            this.f4978m = 0;
            this.f4979n = 0;
            this.f4980o = 0;
            this.f4981p = 15;
            this.f4982q = true;
            this.f4986z = 0;
            this.f4983r = 0;
            this.f4984s = 0;
            this.f4965A = f4955b;
            this.f4969E = f4954a;
            this.f4971G = f4955b;
        }

        public final void m4061c() {
            this.f4972g.clear();
            this.f4973h.clear();
            this.f4966B = -1;
            this.f4967C = -1;
            this.f4968D = -1;
            this.f4970F = -1;
            this.f4985t = 0;
        }

        public final void m4056a(int i, int i2) {
            this.f4965A = i;
            this.f4986z = i2;
        }

        public final void m4057a(boolean z, boolean z2) {
            if (this.f4966B != -1) {
                if (!z) {
                    this.f4973h.setSpan(new StyleSpan(2), this.f4966B, this.f4973h.length(), 33);
                    this.f4966B = -1;
                }
            } else if (z) {
                this.f4966B = this.f4973h.length();
            }
            if (!this.f4967C) {
                if (!z2) {
                    this.f4973h.setSpan(new UnderlineSpan(), this.f4967C, this.f4973h.length(), 33);
                    this.f4967C = -1;
                }
            } else if (z2) {
                this.f4967C = this.f4973h.length();
            }
        }

        public final void m4060b(int i, int i2) {
            if (!(this.f4968D == -1 || this.f4969E == i)) {
                this.f4973h.setSpan(new ForegroundColorSpan(this.f4969E), this.f4968D, this.f4973h.length(), 33);
            }
            if (i != f4954a) {
                this.f4968D = this.f4973h.length();
                this.f4969E = i;
            }
            if (!(this.f4970F == -1 || this.f4971G == i2)) {
                this.f4973h.setSpan(new BackgroundColorSpan(this.f4971G), this.f4970F, this.f4973h.length(), 33);
            }
            if (i2 != f4955b) {
                this.f4970F = this.f4973h.length();
                this.f4971G = i2;
            }
        }

        public final void m4055a(char c) {
            if (c == '\n') {
                this.f4972g.add(m4054e());
                this.f4973h.clear();
                if (this.f4966B != '￿') {
                    this.f4966B = 0;
                }
                if (this.f4967C != '￿') {
                    this.f4967C = 0;
                }
                if (this.f4968D != '￿') {
                    this.f4968D = 0;
                }
                if (this.f4970F != '￿') {
                    this.f4970F = 0;
                }
                while (true) {
                    if ((this.f4982q != '\u0000' && this.f4972g.size() >= this.f4981p) || this.f4972g.size() >= '\u000f') {
                        this.f4972g.remove(0);
                    } else {
                        return;
                    }
                }
            }
            this.f4973h.append(c);
        }

        private SpannableString m4054e() {
            CharSequence spannableStringBuilder = new SpannableStringBuilder(this.f4973h);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.f4966B != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.f4966B, length, 33);
                }
                if (this.f4967C != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.f4967C, length, 33);
                }
                if (this.f4968D != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f4969E), this.f4968D, length, 33);
                }
                if (this.f4970F != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f4971G), this.f4970F, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public final Cea708Cue m4062d() {
            if (m4058a()) {
                return null;
            }
            Alignment alignment;
            float f;
            float f2;
            CharSequence spannableStringBuilder = new SpannableStringBuilder();
            boolean z = false;
            for (int i = 0; i < this.f4972g.size(); i++) {
                spannableStringBuilder.append((CharSequence) this.f4972g.get(i));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append(m4054e());
            switch (this.f4986z) {
                case 0:
                case 3:
                    alignment = Alignment.ALIGN_NORMAL;
                    break;
                case 1:
                    alignment = Alignment.ALIGN_OPPOSITE;
                    break;
                case 2:
                    alignment = Alignment.ALIGN_CENTER;
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder("Unexpected justification value: ");
                    stringBuilder.append(this.f4986z);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
            Alignment alignment2 = alignment;
            if (this.f4977l) {
                f = ((float) this.f4979n) / 99.0f;
                f2 = ((float) this.f4978m) / 99.0f;
            } else {
                f = ((float) this.f4979n) / 209.0f;
                f2 = ((float) this.f4978m) / 74.0f;
            }
            float f3 = (f * 0.9f) + 0.05f;
            float f4 = (f2 * 0.9f) + 0.05f;
            int i2 = this.f4980o % 3 == 0 ? 0 : this.f4980o % 3 == 1 ? 1 : 2;
            int i3 = this.f4980o / 3 == 0 ? 0 : this.f4980o / 3 == 1 ? 1 : 2;
            if (this.f4965A != f4955b) {
                z = true;
            }
            return new Cea708Cue(spannableStringBuilder, alignment2, f4, i2, f3, i3, z, this.f4965A, this.f4976k);
        }

        public static int m4052a(int i, int i2, int i3) {
            return m4053a(i, i2, i3, 0);
        }

        public static int m4053a(int i, int i2, int i3, int i4) {
            Assertions.m4181a(i, 4);
            Assertions.m4181a(i2, 4);
            Assertions.m4181a(i3, 4);
            Assertions.m4181a(i4, 4);
            int i5 = 0;
            switch (i4) {
                case 2:
                    i4 = 127;
                    break;
                case 3:
                    i4 = 0;
                    break;
                default:
                    i4 = 255;
                    break;
            }
            i = i > 1 ? 255 : 0;
            i2 = i2 > 1 ? 255 : 0;
            if (i3 > 1) {
                i5 = 255;
            }
            return Color.argb(i4, i, i2, i5);
        }

        public final boolean m4058a() {
            if (this.f4974i) {
                if (!this.f4972g.isEmpty() || this.f4973h.length() != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    private static final class DtvCcPacket {
        public final int f4987a;
        public final int f4988b;
        public final byte[] f4989c;
        int f4990d = 0;

        public DtvCcPacket(int i, int i2) {
            this.f4987a = i;
            this.f4988b = i2;
            this.f4989c = new byte[((2 * i2) - 1)];
        }
    }

    public final /* bridge */ /* synthetic */ void mo3926b(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        super.mo3926b(subtitleInputBuffer);
    }

    public final /* bridge */ /* synthetic */ void mo1326d() {
        super.mo1326d();
    }

    public final /* bridge */ /* synthetic */ SubtitleOutputBuffer mo3929g() throws SubtitleDecoderException {
        return super.mo3929g();
    }

    public final /* bridge */ /* synthetic */ SubtitleInputBuffer mo3930h() throws SubtitleDecoderException {
        return super.mo3930h();
    }

    public Cea708Decoder(int i) {
        if (i == -1) {
            i = 1;
        }
        this.f19026d = i;
        this.f19027e = new CueBuilder[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.f19027e[i2] = new CueBuilder();
        }
        this.f19028f = this.f19027e[0];
        m20083k();
    }

    public final void mo1325c() {
        super.mo1325c();
        this.f19029g = null;
        this.f19030h = null;
        this.f19032j = 0;
        this.f19028f = this.f19027e[this.f19032j];
        m20083k();
        this.f19031i = null;
    }

    protected final boolean mo3927e() {
        return this.f19029g != this.f19030h;
    }

    protected final Subtitle mo3928f() {
        this.f19030h = this.f19029g;
        return new CeaSubtitle(this.f19029g);
    }

    protected final void mo3925a(SubtitleInputBuffer subtitleInputBuffer) {
        this.f19024b.m4244a(subtitleInputBuffer.c.array(), subtitleInputBuffer.c.limit());
        while (this.f19024b.m4246b() >= 3) {
            subtitleInputBuffer = this.f19024b.m4250d() & 7;
            int i = subtitleInputBuffer & 3;
            boolean z = false;
            subtitleInputBuffer = (subtitleInputBuffer & 4) == 4 ? 1 : null;
            byte d = (byte) this.f19024b.m4250d();
            byte d2 = (byte) this.f19024b.m4250d();
            if ((i == 2 || i == 3) && subtitleInputBuffer != null) {
                DtvCcPacket dtvCcPacket;
                if (i == 3) {
                    m20081i();
                    subtitleInputBuffer = (d & JpegConst.SOF0) >> 6;
                    int i2 = d & 63;
                    if (i2 == 0) {
                        i2 = 64;
                    }
                    this.f19031i = new DtvCcPacket(subtitleInputBuffer, i2);
                    subtitleInputBuffer = this.f19031i.f4989c;
                    dtvCcPacket = this.f19031i;
                    i = dtvCcPacket.f4990d;
                    dtvCcPacket.f4990d = i + 1;
                    subtitleInputBuffer[i] = d2;
                } else {
                    if (i == 2) {
                        z = true;
                    }
                    Assertions.m4184a(z);
                    if (this.f19031i == null) {
                        Log.e("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                    } else {
                        subtitleInputBuffer = this.f19031i.f4989c;
                        dtvCcPacket = this.f19031i;
                        i = dtvCcPacket.f4990d;
                        dtvCcPacket.f4990d = i + 1;
                        subtitleInputBuffer[i] = d;
                        subtitleInputBuffer = this.f19031i.f4989c;
                        dtvCcPacket = this.f19031i;
                        i = dtvCcPacket.f4990d;
                        dtvCcPacket.f4990d = i + 1;
                        subtitleInputBuffer[i] = d2;
                    }
                }
                if (this.f19031i.f4990d == (this.f19031i.f4988b * 2) - 1) {
                    m20081i();
                }
            }
        }
    }

    private void m20081i() {
        if (this.f19031i != null) {
            if (this.f19031i.f4990d != (this.f19031i.f4988b * 2) - 1) {
                StringBuilder stringBuilder = new StringBuilder("DtvCcPacket ended prematurely; size is ");
                stringBuilder.append((this.f19031i.f4988b * 2) - 1);
                stringBuilder.append(", but current index is ");
                stringBuilder.append(this.f19031i.f4990d);
                stringBuilder.append(" (sequence number ");
                stringBuilder.append(this.f19031i.f4987a);
                stringBuilder.append("); ignoring packet");
                Log.w("Cea708Decoder", stringBuilder.toString());
            } else {
                this.f19025c.m4232a(this.f19031i.f4989c, this.f19031i.f4990d);
                int c = this.f19025c.m4236c(3);
                int c2 = this.f19025c.m4236c(5);
                if (c == 7) {
                    this.f19025c.m4234b(2);
                    c += this.f19025c.m4236c(6);
                }
                if (c2 == 0) {
                    if (c != 0) {
                        StringBuilder stringBuilder2 = new StringBuilder("serviceNumber is non-zero (");
                        stringBuilder2.append(c);
                        stringBuilder2.append(") when blockSize is 0");
                        Log.w("Cea708Decoder", stringBuilder2.toString());
                    }
                } else if (c == this.f19026d) {
                    c = 0;
                    while (this.f19025c.m4230a() > 0) {
                        c2 = this.f19025c.m4236c(8);
                        StringBuilder stringBuilder3;
                        if (c2 == 16) {
                            c2 = this.f19025c.m4236c(8);
                            if (c2 <= 31) {
                                if (c2 > 7) {
                                    if (c2 <= 15) {
                                        this.f19025c.m4234b(8);
                                    } else if (c2 <= 23) {
                                        this.f19025c.m4234b(16);
                                    } else if (c2 <= 31) {
                                        this.f19025c.m4234b(24);
                                    }
                                }
                            } else if (c2 <= 127) {
                                if (c2 == 37) {
                                    this.f19028f.m4055a('…');
                                } else if (c2 == 42) {
                                    this.f19028f.m4055a('Š');
                                } else if (c2 == 44) {
                                    this.f19028f.m4055a('Œ');
                                } else if (c2 != 63) {
                                    switch (c2) {
                                        case 32:
                                            this.f19028f.m4055a(' ');
                                            break;
                                        case 33:
                                            this.f19028f.m4055a(' ');
                                            break;
                                        default:
                                            switch (c2) {
                                                case 48:
                                                    this.f19028f.m4055a('█');
                                                    break;
                                                case 49:
                                                    this.f19028f.m4055a('‘');
                                                    break;
                                                case 50:
                                                    this.f19028f.m4055a('’');
                                                    break;
                                                case 51:
                                                    this.f19028f.m4055a('“');
                                                    break;
                                                case 52:
                                                    this.f19028f.m4055a('”');
                                                    break;
                                                case 53:
                                                    this.f19028f.m4055a('•');
                                                    break;
                                                default:
                                                    switch (c2) {
                                                        case 57:
                                                            this.f19028f.m4055a('™');
                                                            break;
                                                        case 58:
                                                            this.f19028f.m4055a('š');
                                                            break;
                                                        default:
                                                            switch (c2) {
                                                                case 60:
                                                                    this.f19028f.m4055a('œ');
                                                                    break;
                                                                case 61:
                                                                    this.f19028f.m4055a('℠');
                                                                    break;
                                                                default:
                                                                    switch (c2) {
                                                                        case 118:
                                                                            this.f19028f.m4055a('⅛');
                                                                            break;
                                                                        case 119:
                                                                            this.f19028f.m4055a('⅜');
                                                                            break;
                                                                        case 120:
                                                                            this.f19028f.m4055a('⅝');
                                                                            break;
                                                                        case 121:
                                                                            this.f19028f.m4055a('⅞');
                                                                            break;
                                                                        case 122:
                                                                            this.f19028f.m4055a('│');
                                                                            break;
                                                                        case 123:
                                                                            this.f19028f.m4055a('┐');
                                                                            break;
                                                                        case 124:
                                                                            this.f19028f.m4055a('└');
                                                                            break;
                                                                        case 125:
                                                                            this.f19028f.m4055a('─');
                                                                            break;
                                                                        case 126:
                                                                            this.f19028f.m4055a('┘');
                                                                            break;
                                                                        case 127:
                                                                            this.f19028f.m4055a('┌');
                                                                            break;
                                                                        default:
                                                                            r7 = new StringBuilder("Invalid G2 character: ");
                                                                            r7.append(c2);
                                                                            Log.w("Cea708Decoder", r7.toString());
                                                                            break;
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                                } else {
                                    this.f19028f.m4055a('Ÿ');
                                }
                            } else if (c2 <= 159) {
                                if (c2 <= 135) {
                                    this.f19025c.m4234b(32);
                                } else if (c2 <= 143) {
                                    this.f19025c.m4234b(40);
                                } else if (c2 <= 159) {
                                    this.f19025c.m4234b(2);
                                    this.f19025c.m4234b(8 * this.f19025c.m4236c(6));
                                }
                            } else if (c2 > 255) {
                                stringBuilder3 = new StringBuilder("Invalid extended command: ");
                                stringBuilder3.append(c2);
                                Log.w("Cea708Decoder", stringBuilder3.toString());
                            } else if (c2 == 160) {
                                this.f19028f.m4055a('㏄');
                            } else {
                                r7 = new StringBuilder("Invalid G3 character: ");
                                r7.append(c2);
                                Log.w("Cea708Decoder", r7.toString());
                                this.f19028f.m4055a('_');
                            }
                        } else if (c2 <= 31) {
                            if (c2 != 0) {
                                if (c2 == 3) {
                                    this.f19029g = m20082j();
                                } else if (c2 != 8) {
                                    switch (c2) {
                                        case 12:
                                            m20083k();
                                            break;
                                        case 13:
                                            this.f19028f.m4055a('\n');
                                            break;
                                        case 14:
                                            break;
                                        default:
                                            if (c2 < 17 || c2 > 23) {
                                                if (c2 >= 24 && c2 <= 31) {
                                                    stringBuilder3 = new StringBuilder("Currently unsupported COMMAND_P16 Command: ");
                                                    stringBuilder3.append(c2);
                                                    Log.w("Cea708Decoder", stringBuilder3.toString());
                                                    this.f19025c.m4234b(16);
                                                    break;
                                                }
                                                stringBuilder3 = new StringBuilder("Invalid C0 command: ");
                                                stringBuilder3.append(c2);
                                                Log.w("Cea708Decoder", stringBuilder3.toString());
                                                break;
                                            }
                                            StringBuilder stringBuilder4 = new StringBuilder("Currently unsupported COMMAND_EXT1 Command: ");
                                            stringBuilder4.append(c2);
                                            Log.w("Cea708Decoder", stringBuilder4.toString());
                                            this.f19025c.m4234b(8);
                                            break;
                                            break;
                                    }
                                } else {
                                    CueBuilder cueBuilder = this.f19028f;
                                    int length = cueBuilder.f4973h.length();
                                    if (length > 0) {
                                        cueBuilder.f4973h.delete(length - 1, length);
                                    }
                                }
                            }
                        } else if (c2 <= 127) {
                            if (c2 == 127) {
                                this.f19028f.m4055a('♫');
                            } else {
                                this.f19028f.m4055a((char) (c2 & 255));
                            }
                        } else if (c2 <= 159) {
                            m20080a(c2);
                        } else if (c2 <= 255) {
                            this.f19028f.m4055a((char) (c2 & 255));
                        } else {
                            stringBuilder3 = new StringBuilder("Invalid base command: ");
                            stringBuilder3.append(c2);
                            Log.w("Cea708Decoder", stringBuilder3.toString());
                        }
                        c = 1;
                    }
                    if (c != 0) {
                        this.f19029g = m20082j();
                    }
                }
            }
            this.f19031i = null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m20080a(int r18) {
        /*
        r17 = this;
        r0 = r17;
        r1 = r18;
        r2 = 16;
        r3 = 6;
        r5 = 4;
        r6 = 3;
        r7 = 8;
        r8 = 1;
        r9 = 2;
        switch(r1) {
            case 128: goto L_0x02a7;
            case 129: goto L_0x02a7;
            case 130: goto L_0x02a7;
            case 131: goto L_0x02a7;
            case 132: goto L_0x02a7;
            case 133: goto L_0x02a7;
            case 134: goto L_0x02a7;
            case 135: goto L_0x02a7;
            case 136: goto L_0x0290;
            case 137: goto L_0x0279;
            case 138: goto L_0x0260;
            case 139: goto L_0x0246;
            case 140: goto L_0x022f;
            case 141: goto L_0x0229;
            case 142: goto L_0x0228;
            case 143: goto L_0x0224;
            case 144: goto L_0x01ed;
            case 145: goto L_0x0187;
            case 146: goto L_0x0158;
            default: goto L_0x0010;
        };
    L_0x0010:
        switch(r1) {
            case 151: goto L_0x00ef;
            case 152: goto L_0x0028;
            case 153: goto L_0x0028;
            case 154: goto L_0x0028;
            case 155: goto L_0x0028;
            case 156: goto L_0x0028;
            case 157: goto L_0x0028;
            case 158: goto L_0x0028;
            case 159: goto L_0x0028;
            default: goto L_0x0013;
        };
    L_0x0013:
        r2 = "Cea708Decoder";
        r3 = new java.lang.StringBuilder;
        r4 = "Invalid C1 command: ";
        r3.<init>(r4);
        r3.append(r1);
        r1 = r3.toString();
        android.util.Log.w(r2, r1);
        goto L_0x02b6;
    L_0x0028:
        r1 = r1 + -152;
        r2 = r0.f19027e;
        r2 = r2[r1];
        r10 = r0.f19025c;
        r10.m4234b(r9);
        r10 = r0.f19025c;
        r10 = r10.m4237c();
        r11 = r0.f19025c;
        r11 = r11.m4237c();
        r12 = r0.f19025c;
        r12.m4237c();
        r12 = r0.f19025c;
        r12 = r12.m4236c(r6);
        r13 = r0.f19025c;
        r13 = r13.m4237c();
        r14 = r0.f19025c;
        r15 = 7;
        r14 = r14.m4236c(r15);
        r15 = r0.f19025c;
        r7 = r15.m4236c(r7);
        r15 = r0.f19025c;
        r15 = r15.m4236c(r5);
        r4 = r0.f19025c;
        r4 = r4.m4236c(r5);
        r5 = r0.f19025c;
        r5.m4234b(r9);
        r5 = r0.f19025c;
        r5.m4236c(r3);
        r3 = r0.f19025c;
        r3.m4234b(r9);
        r3 = r0.f19025c;
        r3 = r3.m4236c(r6);
        r5 = r0.f19025c;
        r5 = r5.m4236c(r6);
        r2.f4974i = r8;
        r2.f4975j = r10;
        r2.f4982q = r11;
        r2.f4976k = r12;
        r2.f4977l = r13;
        r2.f4978m = r14;
        r2.f4979n = r7;
        r2.f4980o = r15;
        r6 = r2.f4981p;
        r4 = r4 + r8;
        if (r6 == r4) goto L_0x00b8;
    L_0x0099:
        r2.f4981p = r4;
    L_0x009b:
        if (r11 == 0) goto L_0x00a7;
    L_0x009d:
        r4 = r2.f4972g;
        r4 = r4.size();
        r6 = r2.f4981p;
        if (r4 >= r6) goto L_0x00b1;
    L_0x00a7:
        r4 = r2.f4972g;
        r4 = r4.size();
        r6 = 15;
        if (r4 < r6) goto L_0x00b8;
    L_0x00b1:
        r4 = r2.f4972g;
        r6 = 0;
        r4.remove(r6);
        goto L_0x009b;
    L_0x00b8:
        if (r3 == 0) goto L_0x00cc;
    L_0x00ba:
        r4 = r2.f4983r;
        if (r4 == r3) goto L_0x00cc;
    L_0x00be:
        r2.f4983r = r3;
        r3 = r3 - r8;
        r4 = com.google.android.exoplayer2.text.cea.Cea708Decoder.CueBuilder.f4958e;
        r4 = r4[r3];
        r6 = com.google.android.exoplayer2.text.cea.Cea708Decoder.CueBuilder.f4957d;
        r3 = r6[r3];
        r2.m4056a(r4, r3);
    L_0x00cc:
        if (r5 == 0) goto L_0x00e2;
    L_0x00ce:
        r3 = r2.f4984s;
        if (r3 == r5) goto L_0x00e2;
    L_0x00d2:
        r2.f4984s = r5;
        r5 = r5 - r8;
        r3 = 0;
        r2.m4057a(r3, r3);
        r3 = com.google.android.exoplayer2.text.cea.Cea708Decoder.CueBuilder.f4954a;
        r4 = com.google.android.exoplayer2.text.cea.Cea708Decoder.CueBuilder.f4959f;
        r4 = r4[r5];
        r2.m4060b(r3, r4);
    L_0x00e2:
        r2 = r0.f19032j;
        if (r2 == r1) goto L_0x02b6;
    L_0x00e6:
        r0.f19032j = r1;
        r2 = r0.f19027e;
        r1 = r2[r1];
        r0.f19028f = r1;
        return;
    L_0x00ef:
        r1 = r0.f19028f;
        r1 = r1.f4974i;
        if (r1 != 0) goto L_0x00fd;
    L_0x00f5:
        r1 = r0.f19025c;
        r2 = 32;
        r1.m4234b(r2);
        return;
    L_0x00fd:
        r1 = r0.f19025c;
        r1 = r1.m4236c(r9);
        r2 = r0.f19025c;
        r2 = r2.m4236c(r9);
        r3 = r0.f19025c;
        r3 = r3.m4236c(r9);
        r4 = r0.f19025c;
        r4 = r4.m4236c(r9);
        r1 = com.google.android.exoplayer2.text.cea.Cea708Decoder.CueBuilder.m4053a(r2, r3, r4, r1);
        r2 = r0.f19025c;
        r2.m4236c(r9);
        r2 = r0.f19025c;
        r2 = r2.m4236c(r9);
        r3 = r0.f19025c;
        r3 = r3.m4236c(r9);
        r4 = r0.f19025c;
        r4 = r4.m4236c(r9);
        com.google.android.exoplayer2.text.cea.Cea708Decoder.CueBuilder.m4052a(r2, r3, r4);
        r2 = r0.f19025c;
        r2.m4237c();
        r2 = r0.f19025c;
        r2.m4237c();
        r2 = r0.f19025c;
        r2.m4236c(r9);
        r2 = r0.f19025c;
        r2.m4236c(r9);
        r2 = r0.f19025c;
        r2 = r2.m4236c(r9);
        r3 = r0.f19025c;
        r3.m4234b(r7);
        r3 = r0.f19028f;
        r3.m4056a(r1, r2);
        return;
    L_0x0158:
        r1 = r0.f19028f;
        r1 = r1.f4974i;
        if (r1 != 0) goto L_0x0164;
    L_0x015e:
        r1 = r0.f19025c;
        r1.m4234b(r2);
        return;
    L_0x0164:
        r1 = r0.f19025c;
        r1.m4234b(r5);
        r1 = r0.f19025c;
        r1 = r1.m4236c(r5);
        r2 = r0.f19025c;
        r2.m4234b(r9);
        r2 = r0.f19025c;
        r2.m4236c(r3);
        r2 = r0.f19028f;
        r3 = r2.f4985t;
        if (r3 == r1) goto L_0x0184;
    L_0x017f:
        r3 = 10;
        r2.m4055a(r3);
    L_0x0184:
        r2.f4985t = r1;
        return;
    L_0x0187:
        r1 = r0.f19028f;
        r1 = r1.f4974i;
        if (r1 != 0) goto L_0x0195;
    L_0x018d:
        r1 = r0.f19025c;
        r2 = 24;
        r1.m4234b(r2);
        return;
    L_0x0195:
        r1 = r0.f19025c;
        r1 = r1.m4236c(r9);
        r2 = r0.f19025c;
        r2 = r2.m4236c(r9);
        r3 = r0.f19025c;
        r3 = r3.m4236c(r9);
        r4 = r0.f19025c;
        r4 = r4.m4236c(r9);
        r1 = com.google.android.exoplayer2.text.cea.Cea708Decoder.CueBuilder.m4053a(r2, r3, r4, r1);
        r2 = r0.f19025c;
        r2 = r2.m4236c(r9);
        r3 = r0.f19025c;
        r3 = r3.m4236c(r9);
        r4 = r0.f19025c;
        r4 = r4.m4236c(r9);
        r5 = r0.f19025c;
        r5 = r5.m4236c(r9);
        r2 = com.google.android.exoplayer2.text.cea.Cea708Decoder.CueBuilder.m4053a(r3, r4, r5, r2);
        r3 = r0.f19025c;
        r3.m4234b(r9);
        r3 = r0.f19025c;
        r3 = r3.m4236c(r9);
        r4 = r0.f19025c;
        r4 = r4.m4236c(r9);
        r5 = r0.f19025c;
        r5 = r5.m4236c(r9);
        com.google.android.exoplayer2.text.cea.Cea708Decoder.CueBuilder.m4052a(r3, r4, r5);
        r3 = r0.f19028f;
        r3.m4060b(r1, r2);
        return;
    L_0x01ed:
        r1 = r0.f19028f;
        r1 = r1.f4974i;
        if (r1 != 0) goto L_0x01f9;
    L_0x01f3:
        r1 = r0.f19025c;
        r1.m4234b(r2);
        return;
    L_0x01f9:
        r1 = r0.f19025c;
        r1.m4236c(r5);
        r1 = r0.f19025c;
        r1.m4236c(r9);
        r1 = r0.f19025c;
        r1.m4236c(r9);
        r1 = r0.f19025c;
        r1 = r1.m4237c();
        r2 = r0.f19025c;
        r2 = r2.m4237c();
        r3 = r0.f19025c;
        r3.m4236c(r6);
        r3 = r0.f19025c;
        r3.m4236c(r6);
        r3 = r0.f19028f;
        r3.m4057a(r1, r2);
        return;
    L_0x0224:
        r17.m20083k();
        return;
    L_0x0228:
        return;
    L_0x0229:
        r1 = r0.f19025c;
        r1.m4234b(r7);
        return;
    L_0x022f:
        if (r8 > r7) goto L_0x0245;
    L_0x0231:
        r1 = r0.f19025c;
        r1 = r1.m4237c();
        if (r1 == 0) goto L_0x0242;
    L_0x0239:
        r1 = r0.f19027e;
        r2 = 8 - r8;
        r1 = r1[r2];
        r1.m4059b();
    L_0x0242:
        r8 = r8 + 1;
        goto L_0x022f;
    L_0x0245:
        return;
    L_0x0246:
        r1 = r8;
    L_0x0247:
        if (r1 > r7) goto L_0x025f;
    L_0x0249:
        r2 = r0.f19025c;
        r2 = r2.m4237c();
        if (r2 == 0) goto L_0x025c;
    L_0x0251:
        r2 = r0.f19027e;
        r3 = 8 - r1;
        r2 = r2[r3];
        r3 = r2.f4975j;
        r3 = r3 ^ r8;
        r2.f4975j = r3;
    L_0x025c:
        r1 = r1 + 1;
        goto L_0x0247;
    L_0x025f:
        return;
    L_0x0260:
        if (r8 > r7) goto L_0x0278;
    L_0x0262:
        r1 = r0.f19025c;
        r1 = r1.m4237c();
        if (r1 == 0) goto L_0x0274;
    L_0x026a:
        r1 = r0.f19027e;
        r2 = 8 - r8;
        r1 = r1[r2];
        r2 = 0;
        r1.f4975j = r2;
        goto L_0x0275;
    L_0x0274:
        r2 = 0;
    L_0x0275:
        r8 = r8 + 1;
        goto L_0x0260;
    L_0x0278:
        return;
    L_0x0279:
        r1 = r8;
    L_0x027a:
        if (r1 > r7) goto L_0x028f;
    L_0x027c:
        r2 = r0.f19025c;
        r2 = r2.m4237c();
        if (r2 == 0) goto L_0x028c;
    L_0x0284:
        r2 = r0.f19027e;
        r3 = 8 - r1;
        r2 = r2[r3];
        r2.f4975j = r8;
    L_0x028c:
        r1 = r1 + 1;
        goto L_0x027a;
    L_0x028f:
        return;
    L_0x0290:
        if (r8 > r7) goto L_0x02a6;
    L_0x0292:
        r1 = r0.f19025c;
        r1 = r1.m4237c();
        if (r1 == 0) goto L_0x02a3;
    L_0x029a:
        r1 = r0.f19027e;
        r2 = 8 - r8;
        r1 = r1[r2];
        r1.m4061c();
    L_0x02a3:
        r8 = r8 + 1;
        goto L_0x0290;
    L_0x02a6:
        return;
    L_0x02a7:
        r1 = r1 + -128;
        r2 = r0.f19032j;
        if (r2 == r1) goto L_0x02b6;
    L_0x02ad:
        r0.f19032j = r1;
        r2 = r0.f19027e;
        r1 = r2[r1];
        r0.f19028f = r1;
        return;
    L_0x02b6:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.cea.Cea708Decoder.a(int):void");
    }

    private List<Cue> m20082j() {
        List arrayList = new ArrayList();
        int i = 0;
        while (i < 8) {
            if (!this.f19027e[i].m4058a() && this.f19027e[i].f4975j) {
                arrayList.add(this.f19027e[i].m4062d());
            }
            i++;
        }
        Collections.sort(arrayList);
        return Collections.unmodifiableList(arrayList);
    }

    private void m20083k() {
        for (int i = 0; i < 8; i++) {
            this.f19027e[i].m4059b();
        }
    }
}
