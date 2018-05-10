package com.google.android.exoplayer2.text.ssa;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class SsaDecoder extends SimpleSubtitleDecoder {
    private static final Pattern f19035c = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");
    private final boolean f19036d;
    private int f19037e;
    private int f19038f;
    private int f19039g;
    private int f19040h;

    public SsaDecoder() {
        this(null);
    }

    public SsaDecoder(List<byte[]> list) {
        super("SsaDecoder");
        if (list != null) {
            this.f19036d = true;
            String str = new String((byte[]) list.get(0));
            Assertions.m4184a(str.startsWith("Format: "));
            m20097a(str);
            m20095a(new ParsableByteArray((byte[]) list.get(1)));
            return;
        }
        this.f19036d = false;
    }

    private static void m20095a(ParsableByteArray parsableByteArray) {
        String r;
        do {
            r = parsableByteArray.m4267r();
            if (r == null) {
                return;
            }
        } while (!r.startsWith("[Events]"));
    }

    private void m20096a(ParsableByteArray parsableByteArray, List<Cue> list, LongArray longArray) {
        while (true) {
            String r = parsableByteArray.m4267r();
            if (r == null) {
                return;
            }
            if (!this.f19036d && r.startsWith("Format: ")) {
                m20097a(r);
            } else if (r.startsWith("Dialogue: ")) {
                StringBuilder stringBuilder;
                if (this.f19037e == 0) {
                    stringBuilder = new StringBuilder("Skipping dialogue line before format: ");
                    stringBuilder.append(r);
                    Log.w("SsaDecoder", stringBuilder.toString());
                } else {
                    String[] split = r.substring(10).split(",", this.f19037e);
                    long b = m20098b(split[this.f19038f]);
                    if (b == -9223372036854775807L) {
                        stringBuilder = new StringBuilder("Skipping invalid timing: ");
                        stringBuilder.append(r);
                        Log.w("SsaDecoder", stringBuilder.toString());
                    } else {
                        long j;
                        String str = split[this.f19039g];
                        if (str.trim().isEmpty()) {
                            j = -9223372036854775807L;
                        } else {
                            j = m20098b(str);
                            if (j == -9223372036854775807L) {
                                stringBuilder = new StringBuilder("Skipping invalid timing: ");
                                stringBuilder.append(r);
                                Log.w("SsaDecoder", stringBuilder.toString());
                            }
                        }
                        list.add(new Cue(split[this.f19040h].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", "\n").replaceAll("\\\\n", "\n")));
                        longArray.m4207a(b);
                        if (j != -9223372036854775807L) {
                            list.add(null);
                            longArray.m4207a(j);
                        }
                    }
                }
            }
        }
    }

    private void m20097a(String str) {
        str = TextUtils.split(str.substring(8), ",");
        this.f19037e = str.length;
        this.f19038f = -1;
        this.f19039g = -1;
        this.f19040h = -1;
        for (int i = 0; i < this.f19037e; i++) {
            int i2;
            String d = Util.m4323d(str[i].trim());
            int hashCode = d.hashCode();
            if (hashCode != 100571) {
                if (hashCode != 3556653) {
                    if (hashCode == 109757538) {
                        if (d.equals("start")) {
                            i2 = 0;
                            switch (i2) {
                                case 0:
                                    this.f19038f = i;
                                    break;
                                case 1:
                                    this.f19039g = i;
                                    break;
                                case 2:
                                    this.f19040h = i;
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                } else if (d.equals("text")) {
                    i2 = 2;
                    switch (i2) {
                        case 0:
                            this.f19038f = i;
                            break;
                        case 1:
                            this.f19039g = i;
                            break;
                        case 2:
                            this.f19040h = i;
                            break;
                        default:
                            break;
                    }
                }
            } else if (d.equals("end")) {
                i2 = 1;
                switch (i2) {
                    case 0:
                        this.f19038f = i;
                        break;
                    case 1:
                        this.f19039g = i;
                        break;
                    case 2:
                        this.f19040h = i;
                        break;
                    default:
                        break;
                }
            }
            i2 = -1;
            switch (i2) {
                case 0:
                    this.f19038f = i;
                    break;
                case 1:
                    this.f19039g = i;
                    break;
                case 2:
                    this.f19040h = i;
                    break;
                default:
                    break;
            }
        }
    }

    private static long m20098b(String str) {
        str = f19035c.matcher(str);
        if (str.matches()) {
            return (((((Long.parseLong(str.group(1)) * 60) * 60) * 1000000) + ((Long.parseLong(str.group(2)) * 60) * 1000000)) + (Long.parseLong(str.group(3)) * 1000000)) + (Long.parseLong(str.group(4)) * 10000);
        }
        return -9223372036854775807L;
    }

    protected final /* synthetic */ Subtitle mo3931a(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        List arrayList = new ArrayList();
        LongArray longArray = new LongArray();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i);
        if (this.f19036d == null) {
            m20095a(parsableByteArray);
        }
        m20096a(parsableByteArray, arrayList, longArray);
        bArr = new Cue[arrayList.size()];
        arrayList.toArray(bArr);
        return new SsaSubtitle(bArr, longArray.m4208a());
    }
}
