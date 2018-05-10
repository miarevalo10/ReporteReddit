package com.google.android.exoplayer2.text.webvtt;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class WebvttSubtitle implements Subtitle {
    private final List<WebvttCue> f13573a;
    private final int f13574b;
    private final long[] f13575c = new long[(2 * this.f13574b)];
    private final long[] f13576d;

    public WebvttSubtitle(List<WebvttCue> list) {
        this.f13573a = list;
        this.f13574b = list.size();
        for (int i = 0; i < this.f13574b; i++) {
            WebvttCue webvttCue = (WebvttCue) list.get(i);
            int i2 = i * 2;
            this.f13575c[i2] = webvttCue.f13571m;
            this.f13575c[i2 + 1] = webvttCue.f13572n;
        }
        this.f13576d = Arrays.copyOf(this.f13575c, this.f13575c.length);
        Arrays.sort(this.f13576d);
    }

    public final int mo1450a(long j) {
        j = Util.m4301a(this.f13576d, j, false, false);
        return j < this.f13576d.length ? j : -1;
    }

    public final int mo1452b() {
        return this.f13576d.length;
    }

    public final long a_(int i) {
        boolean z = false;
        Assertions.m4184a(i >= 0);
        if (i < this.f13576d.length) {
            z = true;
        }
        Assertions.m4184a(z);
        return this.f13576d[i];
    }

    public final List<Cue> mo1453b(long j) {
        CharSequence charSequence = null;
        List list = charSequence;
        WebvttCue webvttCue = list;
        for (int i = 0; i < this.f13574b; i++) {
            int i2 = i * 2;
            if (this.f13575c[i2] <= j && j < this.f13575c[i2 + 1]) {
                if (list == null) {
                    list = new ArrayList();
                }
                WebvttCue webvttCue2 = (WebvttCue) this.f13573a.get(i);
                Object obj = (webvttCue2.d == Float.MIN_VALUE && webvttCue2.g == Float.MIN_VALUE) ? 1 : null;
                if (obj == null) {
                    list.add(webvttCue2);
                } else if (webvttCue == null) {
                    webvttCue = webvttCue2;
                } else if (charSequence == null) {
                    charSequence = new SpannableStringBuilder();
                    charSequence.append(webvttCue.a).append("\n").append(webvttCue2.a);
                } else {
                    charSequence.append("\n").append(webvttCue2.a);
                }
            }
        }
        if (charSequence != null) {
            list.add(new WebvttCue(charSequence));
        } else if (webvttCue != null) {
            list.add(webvttCue);
        }
        if (list != null) {
            return list;
        }
        return Collections.emptyList();
    }
}
