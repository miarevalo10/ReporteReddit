package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.IntentFilter;
import java.util.Arrays;

@TargetApi(21)
public final class AudioCapabilities {
    public static final AudioCapabilities f4101a = new AudioCapabilities(new int[]{2}, 2);
    final int[] f4102b;
    private final int f4103c;

    public static AudioCapabilities m3646a(Context context) {
        context = context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
        if (context != null) {
            if (context.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 0) {
                return new AudioCapabilities(context.getIntArrayExtra("android.media.extra.ENCODINGS"), context.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
            }
        }
        return f4101a;
    }

    private AudioCapabilities(int[] iArr, int i) {
        if (iArr != null) {
            this.f4102b = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.f4102b);
        } else {
            this.f4102b = new int[null];
        }
        this.f4103c = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioCapabilities)) {
            return false;
        }
        AudioCapabilities audioCapabilities = (AudioCapabilities) obj;
        return Arrays.equals(this.f4102b, audioCapabilities.f4102b) && this.f4103c == audioCapabilities.f4103c;
    }

    public final int hashCode() {
        return this.f4103c + (31 * Arrays.hashCode(this.f4102b));
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("AudioCapabilities[maxChannelCount=");
        stringBuilder.append(this.f4103c);
        stringBuilder.append(", supportedEncodings=");
        stringBuilder.append(Arrays.toString(this.f4102b));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
