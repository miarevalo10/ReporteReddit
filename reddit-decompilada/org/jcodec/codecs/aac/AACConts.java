package org.jcodec.codecs.aac;

import io.fabric.sdk.android.services.events.EventsFilesManager;

public class AACConts {
    public static final short[] AAC_CHANNEL_COUNT = new short[]{(short) 0, (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 8};
    public static int[] AAC_SAMPLE_RATES = new int[]{96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, EventsFilesManager.MAX_BYTE_SIZE_PER_FILE, 7350};
}
