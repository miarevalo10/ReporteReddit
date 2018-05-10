package org.jcodec.common;

public class AudioFormat {
    public static AudioFormat MONO_44K_S16_BE = new AudioFormat(44100, 16, 1, true, true);
    public static AudioFormat MONO_44K_S16_LE = new AudioFormat(44100, 16, 1, true, false);
    public static AudioFormat MONO_44K_S24_BE = new AudioFormat(44100, 24, 1, true, true);
    public static AudioFormat MONO_44K_S24_LE = new AudioFormat(44100, 24, 1, true, false);
    public static AudioFormat MONO_48K_S16_BE = new AudioFormat(48000, 16, 1, true, true);
    public static AudioFormat MONO_48K_S16_LE = new AudioFormat(48000, 16, 1, true, false);
    public static AudioFormat MONO_48K_S24_BE = new AudioFormat(48000, 24, 1, true, true);
    public static AudioFormat MONO_48K_S24_LE = new AudioFormat(48000, 24, 1, true, false);
    public static AudioFormat STEREO_44K_S16_BE = new AudioFormat(44100, 16, 2, true, true);
    public static AudioFormat STEREO_44K_S16_LE = new AudioFormat(44100, 16, 2, true, false);
    public static AudioFormat STEREO_44K_S24_BE = new AudioFormat(44100, 24, 2, true, true);
    public static AudioFormat STEREO_44K_S24_LE = new AudioFormat(44100, 24, 2, true, false);
    public static AudioFormat STEREO_48K_S16_BE = new AudioFormat(48000, 16, 2, true, true);
    public static AudioFormat STEREO_48K_S16_LE = new AudioFormat(48000, 16, 2, true, false);
    public static AudioFormat STEREO_48K_S24_BE = new AudioFormat(48000, 24, 2, true, true);
    public static AudioFormat STEREO_48K_S24_LE = new AudioFormat(48000, 24, 2, true, false);
    private boolean bigEndian;
    private int channelCount;
    private int sampleRate;
    private int sampleSizeInBits;
    private boolean signed;

    public static AudioFormat STEREO_S16_BE(int i) {
        return new AudioFormat(i, 16, 2, true, true);
    }

    public static AudioFormat STEREO_S16_LE(int i) {
        return new AudioFormat(i, 16, 2, true, false);
    }

    public static AudioFormat STEREO_S24_BE(int i) {
        return new AudioFormat(i, 24, 2, true, true);
    }

    public static AudioFormat STEREO_S24_LE(int i) {
        return new AudioFormat(i, 24, 2, true, false);
    }

    public static AudioFormat MONO_S16_BE(int i) {
        return new AudioFormat(i, 16, 1, true, true);
    }

    public static AudioFormat MONO_S16_LE(int i) {
        return new AudioFormat(i, 16, 1, true, false);
    }

    public static AudioFormat MONO_S24_BE(int i) {
        return new AudioFormat(i, 24, 1, true, true);
    }

    public static AudioFormat MONO_S24_LE(int i) {
        return new AudioFormat(i, 24, 1, true, false);
    }

    public static AudioFormat NCH_48K_S16_BE(int i) {
        return new AudioFormat(48000, 16, i, true, true);
    }

    public static AudioFormat NCH_48K_S16_LE(int i) {
        return new AudioFormat(48000, 16, i, true, false);
    }

    public static AudioFormat NCH_48K_S24_BE(int i) {
        return new AudioFormat(48000, 24, i, true, true);
    }

    public static AudioFormat NCH_48K_S24_LE(int i) {
        return new AudioFormat(48000, 24, i, true, false);
    }

    public static AudioFormat NCH_44K_S16_BE(int i) {
        return new AudioFormat(44100, 16, i, true, true);
    }

    public static AudioFormat NCH_44K_S16_LE(int i) {
        return new AudioFormat(44100, 16, i, true, false);
    }

    public static AudioFormat NCH_44K_S24_BE(int i) {
        return new AudioFormat(44100, 24, i, true, true);
    }

    public static AudioFormat NCH_44K_S24_LE(int i) {
        return new AudioFormat(44100, 24, i, true, false);
    }

    public AudioFormat(int i, int i2, int i3, boolean z, boolean z2) {
        this.sampleRate = i;
        this.sampleSizeInBits = i2;
        this.channelCount = i3;
        this.signed = z;
        this.bigEndian = z2;
    }

    public AudioFormat(AudioFormat audioFormat, int i) {
        this(audioFormat);
        this.sampleRate = i;
    }

    public AudioFormat(AudioFormat audioFormat) {
        this(audioFormat.sampleRate, audioFormat.sampleSizeInBits, audioFormat.channelCount, audioFormat.signed, audioFormat.bigEndian);
    }

    public int getChannels() {
        return this.channelCount;
    }

    public int getSampleSizeInBits() {
        return this.sampleSizeInBits;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public short getFrameSize() {
        return (short) ((this.sampleSizeInBits >> 3) * this.channelCount);
    }

    public int getFrameRate() {
        return this.sampleRate;
    }

    public boolean isBigEndian() {
        return this.bigEndian;
    }

    public boolean isSigned() {
        return this.signed;
    }

    public int bytesToFrames(int i) {
        return i / ((this.channelCount * this.sampleSizeInBits) >> 3);
    }

    public int framesToBytes(int i) {
        return i * ((this.channelCount * this.sampleSizeInBits) >> 3);
    }

    public int bytesToSamples(int i) {
        return i / (this.sampleSizeInBits >> 3);
    }

    public int samplesToBytes(int i) {
        return i * (this.sampleSizeInBits >> 3);
    }
}
