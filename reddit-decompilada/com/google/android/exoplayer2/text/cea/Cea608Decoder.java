package com.google.android.exoplayer2.text.cea;

import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.facebook.stetho.server.http.HttpStatus;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.jcodec.codecs.mjpeg.JpegConst;

public final class Cea608Decoder extends CeaDecoder {
    private static final int[] f19005b = new int[]{11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] f19006c = new int[]{0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] f19007d = new int[]{-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    private static final int[] f19008e = new int[]{32, 33, 34, 35, 36, 37, 38, 39, 40, 41, JpegConst.APP1, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, JpegConst.APP9, 93, JpegConst.APPD, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, JpegConst.APP7, 247, JpegConst.RST1, 241, 9632};
    private static final int[] f19009f = new int[]{174, 176, 189, 191, 8482, 162, 163, 9834, JpegConst.APP0, 32, JpegConst.APP8, JpegConst.APP2, JpegConst.APPA, JpegConst.APPE, 244, 251};
    private static final int[] f19010g = new int[]{JpegConst.SOF1, 201, JpegConst.RST3, JpegConst.SOS, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, JpegConst.SOF0, JpegConst.SOF2, 199, HttpStatus.HTTP_OK, 202, 203, JpegConst.APPB, 206, 207, JpegConst.APPF, JpegConst.RST4, JpegConst.EOI, 249, JpegConst.DQT, 171, 187};
    private static final int[] f19011h = new int[]{JpegConst.SOF3, JpegConst.APP3, 205, 204, JpegConst.APPC, JpegConst.RST2, 242, JpegConst.RST5, 245, 123, 125, 92, 94, 95, 124, 126, JpegConst.DHT, JpegConst.APP4, JpegConst.RST6, 246, 223, 165, 164, 9474, 197, JpegConst.APP5, JpegConst.SOI, 248, 9484, 9488, 9492, 9496};
    private final ParsableByteArray f19012i = new ParsableByteArray();
    private final int f19013j;
    private final int f19014k;
    private final LinkedList<CueBuilder> f19015l = new LinkedList();
    private CueBuilder f19016m = new CueBuilder(0, 4);
    private List<Cue> f19017n;
    private List<Cue> f19018o;
    private int f19019p;
    private int f19020q;
    private boolean f19021r;
    private byte f19022s;
    private byte f19023t;

    private static class CueBuilder {
        final List<CharacterStyle> f4944a = new ArrayList();
        final List<CueStyle> f4945b = new ArrayList();
        final List<SpannableString> f4946c = new LinkedList();
        final SpannableStringBuilder f4947d = new SpannableStringBuilder();
        int f4948e;
        int f4949f;
        int f4950g;
        int f4951h;
        int f4952i;
        private int f4953j;

        private static class CueStyle {
            public final CharacterStyle f4941a;
            public final int f4942b;
            public final int f4943c;

            public CueStyle(CharacterStyle characterStyle, int i, int i2) {
                this.f4941a = characterStyle;
                this.f4942b = i;
                this.f4943c = i2;
            }
        }

        public CueBuilder(int i, int i2) {
            m4045a(i, i2);
        }

        public final void m4045a(int i, int i2) {
            this.f4944a.clear();
            this.f4945b.clear();
            this.f4946c.clear();
            this.f4947d.clear();
            this.f4948e = 15;
            this.f4949f = 0;
            this.f4950g = 0;
            this.f4953j = i;
            this.f4951h = i2;
            this.f4952i = -1;
        }

        public final boolean m4048a() {
            return this.f4944a.isEmpty() && this.f4945b.isEmpty() && this.f4946c.isEmpty() && this.f4947d.length() == 0;
        }

        public final void m4049b() {
            int length = this.f4947d.length();
            if (length > 0) {
                this.f4947d.delete(length - 1, length);
            }
        }

        public final void m4050c() {
            this.f4946c.add(m4043e());
            this.f4947d.clear();
            this.f4944a.clear();
            this.f4945b.clear();
            this.f4952i = -1;
            int min = Math.min(this.f4951h, this.f4948e);
            while (this.f4946c.size() >= min) {
                this.f4946c.remove(0);
            }
        }

        public final void m4046a(CharacterStyle characterStyle) {
            this.f4944a.add(characterStyle);
        }

        public final void m4047a(CharacterStyle characterStyle, int i) {
            this.f4945b.add(new CueStyle(characterStyle, this.f4947d.length(), i));
        }

        public final void m4044a(char c) {
            this.f4947d.append(c);
        }

        private SpannableString m4043e() {
            int length = this.f4947d.length();
            int i = 0;
            for (int i2 = 0; i2 < this.f4944a.size(); i2++) {
                this.f4947d.setSpan(this.f4944a.get(i2), 0, length, 33);
            }
            while (i < this.f4945b.size()) {
                CueStyle cueStyle = (CueStyle) this.f4945b.get(i);
                this.f4947d.setSpan(cueStyle.f4941a, cueStyle.f4942b, i < this.f4945b.size() - cueStyle.f4943c ? ((CueStyle) this.f4945b.get(cueStyle.f4943c + i)).f4942b : length, 33);
                i++;
            }
            if (this.f4952i != -1) {
                this.f4947d.setSpan(new UnderlineSpan(), this.f4952i, length, 33);
            }
            return new SpannableString(this.f4947d);
        }

        public final Cue m4051d() {
            int i;
            CharSequence spannableStringBuilder = new SpannableStringBuilder();
            for (i = 0; i < this.f4946c.size(); i++) {
                spannableStringBuilder.append((CharSequence) this.f4946c.get(i));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append(m4043e());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            float f;
            int i2;
            int i3;
            i = this.f4949f + this.f4950g;
            int length = (32 - i) - spannableStringBuilder.length();
            int i4 = i - length;
            if (this.f4953j == 2 && Math.abs(i4) < 3) {
                f = 0.5f;
                i2 = 1;
            } else if (this.f4953j != 2 || i4 <= 0) {
                i2 = 0;
                f = ((((float) i) / 32.0f) * 0.8f) + 0.1f;
            } else {
                f = ((((float) (32 - length)) / 32.0f) * 0.8f) + 0.1f;
                i2 = 2;
            }
            if (this.f4953j != 1) {
                if (this.f4948e <= 7) {
                    i = this.f4948e;
                    i3 = 0;
                    return new Cue(spannableStringBuilder, Alignment.ALIGN_NORMAL, (float) i, 1, i3, f, i2, Float.MIN_VALUE);
                }
            }
            i = (this.f4948e - 15) - 2;
            i3 = 2;
            return new Cue(spannableStringBuilder, Alignment.ALIGN_NORMAL, (float) i, 1, i3, f, i2, Float.MIN_VALUE);
        }

        public String toString() {
            return this.f4947d.toString();
        }
    }

    public final void mo1326d() {
    }

    public final /* bridge */ /* synthetic */ void mo3926b(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        super.mo3926b(subtitleInputBuffer);
    }

    public final /* bridge */ /* synthetic */ SubtitleOutputBuffer mo3929g() throws SubtitleDecoderException {
        return super.mo3929g();
    }

    public final /* bridge */ /* synthetic */ SubtitleInputBuffer mo3930h() throws SubtitleDecoderException {
        return super.mo3930h();
    }

    public Cea608Decoder(String str, int i) {
        this.f19013j = "application/x-mp4-cea-608".equals(str) != null ? 2 : 3;
        switch (i) {
            case 3:
            case 4:
                this.f19014k = 2;
                break;
            default:
                this.f19014k = 1;
                break;
        }
        m20068a(0);
        m20070j();
    }

    public final void mo1325c() {
        super.mo1325c();
        this.f19017n = null;
        this.f19018o = null;
        m20068a(0);
        m20070j();
        this.f19020q = 4;
        this.f19021r = false;
        this.f19022s = (byte) 0;
        this.f19023t = (byte) 0;
    }

    protected final boolean mo3927e() {
        return this.f19017n != this.f19018o;
    }

    protected final Subtitle mo3928f() {
        this.f19018o = this.f19017n;
        return new CeaSubtitle(this.f19017n);
    }

    protected final void mo3925a(SubtitleInputBuffer subtitleInputBuffer) {
        this.f19012i.m4244a(subtitleInputBuffer.c.array(), subtitleInputBuffer.c.limit());
        SubtitleInputBuffer subtitleInputBuffer2 = null;
        SubtitleInputBuffer subtitleInputBuffer3 = subtitleInputBuffer2;
        while (this.f19012i.m4246b() >= this.f19013j) {
            int i;
            if (this.f19013j == 2) {
                i = -4;
            } else {
                i = (byte) this.f19012i.m4250d();
            }
            byte d = (byte) (this.f19012i.m4250d() & 127);
            byte d2 = (byte) (this.f19012i.m4250d() & 127);
            if ((i & 6) == 4 && ((this.f19014k != 1 || (i & 1) == 0) && ((this.f19014k != 2 || (i & 1) == 1) && !(d == (byte) 0 && d2 == (byte) 0)))) {
                int i2 = d & 247;
                if (i2 == 17 && (d2 & 240) == 48) {
                    this.f19016m.m4044a((char) f19009f[d2 & 15]);
                } else if ((d & 246) == 18 && (d2 & JpegConst.APP0) == 32) {
                    this.f19016m.m4049b();
                    if ((d & 1) == 0) {
                        this.f19016m.m4044a((char) f19010g[d2 & 31]);
                    } else {
                        this.f19016m.m4044a((char) f19011h[d2 & 31]);
                    }
                } else if ((d & JpegConst.APP0) == 0) {
                    int i3 = d & 240;
                    boolean z = i3 == 16 ? true : null;
                    if (z) {
                        if (this.f19021r && this.f19022s == d && this.f19023t == d2) {
                            this.f19021r = false;
                            subtitleInputBuffer3 = true;
                        } else {
                            this.f19021r = true;
                            this.f19022s = d;
                            this.f19023t = d2;
                        }
                    }
                    boolean z2 = (i2 == 17 && (d2 & 240) == 32) ? true : null;
                    boolean z3;
                    if (z2) {
                        z3 = (d2 & 1) == 1 ? true : null;
                        CueBuilder cueBuilder = this.f19016m;
                        if (z3) {
                            cueBuilder.f4952i = cueBuilder.f4947d.length();
                        } else if (cueBuilder.f4952i != -1) {
                            cueBuilder.f4947d.setSpan(new UnderlineSpan(), cueBuilder.f4952i, cueBuilder.f4947d.length(), 33);
                            cueBuilder.f4952i = -1;
                        }
                        i2 = (d2 >> 1) & 15;
                        if (i2 == 7) {
                            this.f19016m.m4047a(new StyleSpan(2), 2);
                            this.f19016m.m4047a(new ForegroundColorSpan(-1), 1);
                        } else {
                            this.f19016m.m4047a(new ForegroundColorSpan(f19007d[i2]), 1);
                        }
                    } else {
                        boolean z4 = (i3 == 16 && (d2 & JpegConst.SOF0) == 64) ? true : null;
                        if (z4) {
                            i2 = f19005b[d & 7];
                            if ((d2 & 32) != 0 ? true : null) {
                                i2++;
                            }
                            if (i2 != this.f19016m.f4948e) {
                                if (!(this.f19019p == 1 || this.f19016m.m4048a())) {
                                    this.f19016m = new CueBuilder(this.f19019p, this.f19020q);
                                    this.f19015l.add(this.f19016m);
                                }
                                this.f19016m.f4948e = i2;
                            }
                            if ((d2 & 1) == 1) {
                                this.f19016m.m4046a(new UnderlineSpan());
                            }
                            i2 = (d2 >> 1) & 15;
                            if (i2 > 7) {
                                this.f19016m.f4949f = f19006c[i2 & 7];
                            } else if (i2 == 7) {
                                this.f19016m.m4046a(new StyleSpan(2));
                                this.f19016m.m4046a(new ForegroundColorSpan(-1));
                            } else {
                                this.f19016m.m4046a(new ForegroundColorSpan(f19007d[i2]));
                            }
                        } else {
                            z4 = (i2 != 23 || d2 < Framer.ENTER_FRAME_PREFIX || d2 > (byte) 35) ? null : true;
                            if (z4) {
                                this.f19016m.f4950g = d2 - 32;
                            } else {
                                z3 = (i2 == 20 && (d2 & 240) == 32) ? true : null;
                                if (z3) {
                                    if (d2 == (byte) 32) {
                                        m20068a(2);
                                    } else if (d2 != (byte) 41) {
                                        switch (d2) {
                                            case (byte) 37:
                                                this.f19020q = 2;
                                                m20068a(1);
                                                break;
                                            case (byte) 38:
                                                this.f19020q = 3;
                                                m20068a(1);
                                                break;
                                            case (byte) 39:
                                                this.f19020q = 4;
                                                m20068a(1);
                                                break;
                                            default:
                                                if (this.f19019p != 0) {
                                                    if (d2 == Framer.ENTER_FRAME_PREFIX) {
                                                        this.f19016m.m4049b();
                                                        break;
                                                    }
                                                    switch (d2) {
                                                        case (byte) 44:
                                                            this.f19017n = null;
                                                            if (this.f19019p == 1 || this.f19019p == 3) {
                                                                m20070j();
                                                                break;
                                                            }
                                                        case (byte) 45:
                                                            if (this.f19019p == 1 && !this.f19016m.m4048a()) {
                                                                this.f19016m.m4050c();
                                                                break;
                                                            }
                                                        case (byte) 46:
                                                            m20070j();
                                                            break;
                                                        case (byte) 47:
                                                            this.f19017n = m20069i();
                                                            m20070j();
                                                            break;
                                                        default:
                                                            break;
                                                    }
                                                }
                                                break;
                                        }
                                    } else {
                                        m20068a(3);
                                    }
                                }
                            }
                        }
                    }
                    subtitleInputBuffer3 = z;
                } else {
                    this.f19016m.m4044a(m20067a(d));
                    if ((d2 & JpegConst.APP0) != 0) {
                        this.f19016m.m4044a(m20067a(d2));
                    }
                }
                subtitleInputBuffer2 = true;
            }
        }
        if (subtitleInputBuffer2 != null) {
            if (subtitleInputBuffer3 == null) {
                this.f19021r = false;
            }
            if (this.f19019p == 1 || this.f19019p == 3) {
                this.f19017n = m20069i();
            }
        }
    }

    private List<Cue> m20069i() {
        List<Cue> arrayList = new ArrayList();
        for (int i = 0; i < this.f19015l.size(); i++) {
            Cue d = ((CueBuilder) this.f19015l.get(i)).m4051d();
            if (d != null) {
                arrayList.add(d);
            }
        }
        return arrayList;
    }

    private void m20068a(int i) {
        if (this.f19019p != i) {
            int i2 = this.f19019p;
            this.f19019p = i;
            m20070j();
            if (i2 == 3 || i == 1 || i == 0) {
                this.f19017n = 0;
            }
        }
    }

    private void m20070j() {
        this.f19016m.m4045a(this.f19019p, this.f19020q);
        this.f19015l.clear();
        this.f19015l.add(this.f19016m);
    }

    private static char m20067a(byte b) {
        return (char) f19008e[(b & 127) - 32];
    }
}
