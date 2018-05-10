package com.google.android.exoplayer2.text.cea;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.text.Cue;

final class Cea708Cue extends Cue implements Comparable<Cea708Cue> {
    public final int f13557m;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        Cea708Cue cea708Cue = (Cea708Cue) obj;
        if (cea708Cue.f13557m < this.f13557m) {
            return -1;
        }
        return cea708Cue.f13557m > this.f13557m ? 1 : null;
    }

    public Cea708Cue(CharSequence charSequence, Alignment alignment, float f, int i, float f2, int i2, boolean z, int i3, int i4) {
        super(charSequence, alignment, f, 0, i, f2, i2, Float.MIN_VALUE, z, i3);
        this.f13557m = i4;
    }
}
