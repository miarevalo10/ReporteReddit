package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.google.android.exoplayer2.C0377C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher;
import com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher.C03811;
import com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher.C03822;
import com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher.C03833;
import com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher.C03844;
import com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher.C03866;
import com.google.android.exoplayer2.audio.AudioTrack.ConfigurationException;
import com.google.android.exoplayer2.audio.AudioTrack.Listener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

@TargetApi(16)
public class MediaCodecAudioRenderer extends MediaCodecRenderer implements MediaClock {
    private final EventDispatcher f19490k;
    private final AudioTrack f19491l;
    private boolean f19492m;
    private boolean f19493n;
    private MediaFormat f19494o;
    private int f19495p;
    private int f19496q;
    private long f19497r;
    private boolean f19498s;

    private final class AudioTrackListener implements Listener {
        final /* synthetic */ MediaCodecAudioRenderer f12781a;

        private AudioTrackListener(MediaCodecAudioRenderer mediaCodecAudioRenderer) {
            this.f12781a = mediaCodecAudioRenderer;
        }

        public final void mo1319a(int i) {
            EventDispatcher a = this.f12781a.f19490k;
            if (a.f4122b != null) {
                a.f4121a.post(new C03866(a, i));
            }
            MediaCodecAudioRenderer.m20786s();
        }

        public final void mo1318a() {
            MediaCodecAudioRenderer.m20787t();
            this.f12781a.f19498s = true;
        }

        public final void mo1320a(int i, long j, long j2) {
            EventDispatcher a = this.f12781a.f19490k;
            if (a.f4122b != null) {
                a.f4121a.post(new C03844(a, i, j, j2));
            }
            MediaCodecAudioRenderer.m20788u();
        }
    }

    protected static void m20786s() {
    }

    protected static void m20787t() {
    }

    protected static void m20788u() {
    }

    public final MediaClock mo3317c() {
        return this;
    }

    public MediaCodecAudioRenderer(MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, Handler handler, AudioRendererEventListener audioRendererEventListener, AudioCapabilities audioCapabilities, AudioProcessor... audioProcessorArr) {
        super(1, mediaCodecSelector, drmSessionManager, true);
        this.f19491l = new AudioTrack(audioCapabilities, audioProcessorArr, new AudioTrackListener());
        this.f19490k = new EventDispatcher(handler, audioRendererEventListener);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final int mo4248a(com.google.android.exoplayer2.mediacodec.MediaCodecSelector r10, com.google.android.exoplayer2.Format r11) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        /*
        r9 = this;
        r0 = r11.f4018f;
        r1 = com.google.android.exoplayer2.util.MimeTypes.m4212a(r0);
        r2 = 0;
        if (r1 != 0) goto L_0x000a;
    L_0x0009:
        return r2;
    L_0x000a:
        r1 = com.google.android.exoplayer2.util.Util.f5283a;
        r3 = 21;
        if (r1 < r3) goto L_0x0013;
    L_0x0010:
        r1 = 32;
        goto L_0x0014;
    L_0x0013:
        r1 = r2;
    L_0x0014:
        r4 = r9.m20784a(r0);
        r5 = 4;
        r6 = 8;
        if (r4 == 0) goto L_0x0027;
    L_0x001d:
        r4 = r10.mo1388a();
        if (r4 == 0) goto L_0x0027;
    L_0x0023:
        r10 = r6 | r1;
        r10 = r10 | r5;
        return r10;
    L_0x0027:
        r10 = r10.mo1389a(r0, r2);
        r0 = 1;
        if (r10 != 0) goto L_0x002f;
    L_0x002e:
        return r0;
    L_0x002f:
        r4 = com.google.android.exoplayer2.util.Util.f5283a;
        if (r4 < r3) goto L_0x00b2;
    L_0x0033:
        r3 = r11.f4031s;
        r4 = -1;
        if (r3 == r4) goto L_0x006e;
    L_0x0038:
        r3 = r11.f4031s;
        r7 = r10.f4651f;
        if (r7 != 0) goto L_0x0045;
    L_0x003e:
        r3 = "sampleRate.caps";
        r10.m3891b(r3);
    L_0x0043:
        r3 = r2;
        goto L_0x006c;
    L_0x0045:
        r7 = r10.f4651f;
        r7 = r7.getAudioCapabilities();
        if (r7 != 0) goto L_0x0053;
    L_0x004d:
        r3 = "sampleRate.aCaps";
        r10.m3891b(r3);
        goto L_0x0043;
    L_0x0053:
        r7 = r7.isSampleRateSupported(r3);
        if (r7 != 0) goto L_0x006b;
    L_0x0059:
        r7 = new java.lang.StringBuilder;
        r8 = "sampleRate.support, ";
        r7.<init>(r8);
        r7.append(r3);
        r3 = r7.toString();
        r10.m3891b(r3);
        goto L_0x0043;
    L_0x006b:
        r3 = r0;
    L_0x006c:
        if (r3 == 0) goto L_0x00b1;
    L_0x006e:
        r3 = r11.f4030r;
        if (r3 == r4) goto L_0x00b2;
    L_0x0072:
        r11 = r11.f4030r;
        r3 = r10.f4651f;
        if (r3 != 0) goto L_0x007f;
    L_0x0078:
        r11 = "channelCount.caps";
        r10.m3891b(r11);
    L_0x007d:
        r10 = r2;
        goto L_0x00ae;
    L_0x007f:
        r3 = r10.f4651f;
        r3 = r3.getAudioCapabilities();
        if (r3 != 0) goto L_0x008d;
    L_0x0087:
        r11 = "channelCount.aCaps";
        r10.m3891b(r11);
        goto L_0x007d;
    L_0x008d:
        r4 = r10.f4646a;
        r7 = r10.f4650e;
        r3 = r3.getMaxInputChannelCount();
        r3 = com.google.android.exoplayer2.mediacodec.MediaCodecInfo.m3885a(r4, r7, r3);
        if (r3 >= r11) goto L_0x00ad;
    L_0x009b:
        r3 = new java.lang.StringBuilder;
        r4 = "channelCount.support, ";
        r3.<init>(r4);
        r3.append(r11);
        r11 = r3.toString();
        r10.m3891b(r11);
        goto L_0x007d;
    L_0x00ad:
        r10 = r0;
    L_0x00ae:
        if (r10 == 0) goto L_0x00b1;
    L_0x00b0:
        goto L_0x00b2;
    L_0x00b1:
        r0 = r2;
    L_0x00b2:
        if (r0 == 0) goto L_0x00b5;
    L_0x00b4:
        goto L_0x00b6;
    L_0x00b5:
        r5 = 3;
    L_0x00b6:
        r10 = r6 | r1;
        r10 = r10 | r5;
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.a(com.google.android.exoplayer2.mediacodec.MediaCodecSelector, com.google.android.exoplayer2.Format):int");
    }

    protected final MediaCodecInfo mo4249a(MediaCodecSelector mediaCodecSelector, Format format, boolean z) throws DecoderQueryException {
        if (m20784a(format.f4018f)) {
            MediaCodecInfo a = mediaCodecSelector.mo1388a();
            if (a != null) {
                this.f19492m = true;
                return a;
            }
        }
        this.f19492m = false;
        return super.mo4249a(mediaCodecSelector, format, z);
    }

    private boolean m20784a(String str) {
        AudioTrack audioTrack = this.f19491l;
        if (audioTrack.f4169c != null) {
            if ((Arrays.binarySearch(audioTrack.f4169c.f4102b, AudioTrack.m3679a(str)) >= null ? 1 : null) != null) {
                return true;
            }
        }
        return false;
    }

    protected final void mo4251a(MediaCodecInfo mediaCodecInfo, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        mediaCodecInfo = (Util.f5283a >= 24 || "OMX.SEC.aac.dec".equals(mediaCodecInfo.f4646a) == null || "samsung".equals(Util.f5285c) == null || (Util.f5284b.startsWith("zeroflte") == null && Util.f5284b.startsWith("herolte") == null && Util.f5284b.startsWith("heroqlte") == null)) ? null : true;
        this.f19493n = mediaCodecInfo;
        if (this.f19492m != null) {
            this.f19494o = format.m3577b();
            this.f19494o.setString("mime", "audio/raw");
            mediaCodec.configure(this.f19494o, null, mediaCrypto, 0);
            this.f19494o.setString("mime", format.f4018f);
            return;
        }
        mediaCodec.configure(format.m3577b(), null, mediaCrypto, 0);
        this.f19494o = null;
    }

    protected final void mo4252a(String str, long j, long j2) {
        EventDispatcher eventDispatcher = this.f19490k;
        if (eventDispatcher.f4122b != null) {
            eventDispatcher.f4121a.post(new C03822(eventDispatcher, str, j, j2));
        }
    }

    protected final void mo4254b(Format format) throws ExoPlaybackException {
        super.mo4254b(format);
        EventDispatcher eventDispatcher = this.f19490k;
        if (eventDispatcher.f4122b != null) {
            eventDispatcher.f4121a.post(new C03833(eventDispatcher, format));
        }
        this.f19495p = "audio/raw".equals(format.f4018f) ? format.f4032t : 2;
        this.f19496q = format.f4030r;
    }

    protected final void mo4250a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException {
        int[] iArr;
        boolean z = false;
        mediaCodec = this.f19494o != null ? 1 : null;
        String string = mediaCodec != null ? this.f19494o.getString("mime") : "audio/raw";
        if (mediaCodec != null) {
            mediaFormat = this.f19494o;
        }
        int integer = mediaFormat.getInteger("channel-count");
        mediaFormat = mediaFormat.getInteger("sample-rate");
        if (this.f19493n && integer == 6 && this.f19496q < 6) {
            iArr = new int[this.f19496q];
            for (int i = 0; i < this.f19496q; i++) {
                iArr[i] = i;
            }
        } else {
            iArr = null;
        }
        try {
            int i2;
            int i3;
            int c;
            AudioTrack audioTrack = this.f19491l;
            int i4 = this.f19495p;
            boolean equals = "audio/raw".equals(string) ^ true;
            int a = equals ? AudioTrack.m3679a(string) : i4;
            if (equals) {
                i2 = a;
                a = 0;
            } else {
                audioTrack.f4189w = Util.m4317b(i4, integer);
                audioTrack.f4170d.f12773b = iArr;
                AudioProcessor[] audioProcessorArr = audioTrack.f4171e;
                i4 = audioProcessorArr.length;
                i3 = integer;
                mediaCodec = null;
                i2 = a;
                a = mediaCodec;
                while (mediaCodec < i4) {
                    AudioProcessor audioProcessor = audioProcessorArr[mediaCodec];
                    a |= audioProcessor.mo1310a(mediaFormat, i3, i2);
                    if (audioProcessor.mo1309a()) {
                        i3 = audioProcessor.mo1311b();
                        i2 = audioProcessor.mo1312c();
                    }
                    mediaCodec++;
                }
                if (a != 0) {
                    audioTrack.m3684a();
                }
                integer = i3;
            }
            int i5 = 12;
            i4 = 252;
            switch (integer) {
                case 1:
                    i3 = 4;
                    break;
                case 2:
                    i3 = 12;
                    break;
                case 3:
                    i3 = 28;
                    break;
                case 4:
                    i3 = 204;
                    break;
                case 5:
                    i3 = 220;
                    break;
                case 6:
                    i3 = 252;
                    break;
                case 7:
                    i3 = 1276;
                    break;
                case 8:
                    i3 = C0377C.f3970a;
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder("Unsupported channel count: ");
                    stringBuilder.append(integer);
                    throw new ConfigurationException(stringBuilder.toString());
            }
            if (Util.f5283a <= 23 && "foster".equals(Util.f5284b) && "NVIDIA".equals(Util.f5285c)) {
                if (!(integer == 3 || integer == 5)) {
                    if (integer == 7) {
                        i4 = C0377C.f3970a;
                    }
                }
                if (Util.f5283a <= 25 || !"fugu".equals(Util.f5284b) || !equals || integer != 1) {
                    i5 = i4;
                }
                if (a == 0 || !audioTrack.m3695h() || audioTrack.f4180n != i2 || audioTrack.f4178l != mediaFormat || audioTrack.f4179m != i5) {
                    audioTrack.m3693f();
                    audioTrack.f4180n = i2;
                    audioTrack.f4183q = equals;
                    audioTrack.f4178l = mediaFormat;
                    audioTrack.f4179m = i5;
                    if (equals) {
                        i2 = 2;
                    }
                    audioTrack.f4181o = i2;
                    audioTrack.f4192z = Util.m4317b(2, integer);
                    if (equals) {
                        mediaCodec = AudioTrack.getMinBufferSize(mediaFormat, i5, audioTrack.f4181o);
                        if (mediaCodec != -2) {
                            z = true;
                        }
                        Assertions.m4186b(z);
                        mediaFormat = mediaCodec * 4;
                        c = ((int) audioTrack.m3689c(250000)) * audioTrack.f4192z;
                        mediaCodec = (int) Math.max((long) mediaCodec, audioTrack.m3689c(750000) * ((long) audioTrack.f4192z));
                        if (mediaFormat < c) {
                            mediaCodec = c;
                        } else if (mediaFormat > mediaCodec) {
                            mediaCodec = mediaFormat;
                        }
                    } else {
                        if (audioTrack.f4181o != 5) {
                            if (audioTrack.f4181o == 6) {
                                mediaCodec = 49152;
                            }
                        }
                        mediaCodec = 20480;
                    }
                    audioTrack.f4184r = mediaCodec;
                    if (equals) {
                        mediaCodec = audioTrack.m3687b((long) (audioTrack.f4184r / audioTrack.f4192z));
                    } else {
                        mediaCodec = 1;
                    }
                    audioTrack.f4185s = mediaCodec;
                    audioTrack.m3683a(audioTrack.f4187u);
                }
                return;
            }
            i4 = i3;
            if (Util.f5283a <= 25) {
            }
            i5 = i4;
            if (a == 0) {
            }
            audioTrack.m3693f();
            audioTrack.f4180n = i2;
            audioTrack.f4183q = equals;
            audioTrack.f4178l = mediaFormat;
            audioTrack.f4179m = i5;
            if (equals) {
                i2 = 2;
            }
            audioTrack.f4181o = i2;
            audioTrack.f4192z = Util.m4317b(2, integer);
            if (equals) {
                mediaCodec = AudioTrack.getMinBufferSize(mediaFormat, i5, audioTrack.f4181o);
                if (mediaCodec != -2) {
                    z = true;
                }
                Assertions.m4186b(z);
                mediaFormat = mediaCodec * 4;
                c = ((int) audioTrack.m3689c(250000)) * audioTrack.f4192z;
                mediaCodec = (int) Math.max((long) mediaCodec, audioTrack.m3689c(750000) * ((long) audioTrack.f4192z));
                if (mediaFormat < c) {
                    mediaCodec = c;
                } else if (mediaFormat > mediaCodec) {
                    mediaCodec = mediaFormat;
                }
            } else {
                if (audioTrack.f4181o != 5) {
                    if (audioTrack.f4181o == 6) {
                        mediaCodec = 49152;
                    }
                }
                mediaCodec = 20480;
            }
            audioTrack.f4184r = mediaCodec;
            if (equals) {
                mediaCodec = audioTrack.m3687b((long) (audioTrack.f4184r / audioTrack.f4192z));
            } else {
                mediaCodec = 1;
            }
            audioTrack.f4185s = mediaCodec;
            audioTrack.m3683a(audioTrack.f4187u);
        } catch (Throwable e) {
            throw new ConfigurationException(e);
        } catch (MediaCodec mediaCodec2) {
            throw ExoPlaybackException.m3542a(mediaCodec2, this.f16763b);
        }
    }

    protected final void mo3915a(boolean z) throws ExoPlaybackException {
        super.mo3915a(z);
        z = this.f19490k;
        DecoderCounters decoderCounters = this.j;
        if (z.f4122b != null) {
            z.f4121a.post(new C03811(z, decoderCounters));
        }
        z = this.f16762a.f4059b;
        boolean z2 = false;
        if (z) {
            AudioTrack audioTrack = this.f19491l;
            if (Util.f5283a >= 21) {
                z2 = true;
            }
            Assertions.m4186b(z2);
            if (!(audioTrack.f4151I && audioTrack.f4150H == z)) {
                audioTrack.f4151I = true;
                audioTrack.f4150H = z;
                audioTrack.m3693f();
            }
            return;
        }
        z = this.f19491l;
        if (z.f4151I) {
            z.f4151I = false;
            z.f4150H = 0;
            z.m3693f();
        }
    }

    protected final void mo3914a(long j, boolean z) throws ExoPlaybackException {
        super.mo3914a(j, z);
        this.f19491l.m3693f();
        this.f19497r = j;
        this.f19498s = 1;
    }

    protected final void mo3916n() {
        super.mo3916n();
        this.f19491l.m3688b();
    }

    protected final void mo3917o() {
        AudioTrack audioTrack = this.f19491l;
        audioTrack.f4149G = false;
        if (audioTrack.m3695h()) {
            audioTrack.m3698k();
            audioTrack.f4174h.m3665a();
        }
        super.mo3917o();
    }

    protected final void mo3918p() {
        try {
            AudioTrack audioTrack = this.f19491l;
            audioTrack.m3693f();
            audioTrack.m3694g();
            for (AudioProcessor h : audioTrack.f4171e) {
                h.mo1317h();
            }
            audioTrack.f4150H = 0;
            audioTrack.f4149G = false;
            try {
                super.mo3918p();
            } finally {
                this.j.m3723a();
                this.f19490k.m3658a(this.j);
            }
        } catch (Throwable th) {
            super.mo3918p();
        } finally {
            this.j.m3723a();
            this.f19490k.m3658a(this.j);
        }
    }

    public final boolean mo3920r() {
        if (super.mo3920r()) {
            boolean z;
            AudioTrack audioTrack = this.f19491l;
            if (audioTrack.m3695h()) {
                if (!audioTrack.f4148F || audioTrack.m3691d()) {
                    z = false;
                    if (z) {
                    }
                }
            }
            z = true;
            return z;
        }
    }

    public final boolean mo3919q() {
        if (!this.f19491l.m3691d()) {
            if (!super.mo3919q()) {
                return false;
            }
        }
        return true;
    }

    public final long mo1494v() {
        long a = this.f19491l.m3682a(mo3920r());
        if (a != Long.MIN_VALUE) {
            if (!this.f19498s) {
                a = Math.max(this.f19497r, a);
            }
            this.f19497r = a;
            this.f19498s = false;
        }
        return this.f19497r;
    }

    public final PlaybackParameters mo1493a(PlaybackParameters playbackParameters) {
        return this.f19491l.m3683a(playbackParameters);
    }

    public final PlaybackParameters mo1495w() {
        return this.f19491l.f4187u;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final boolean mo4253a(long r28, long r30, android.media.MediaCodec r32, java.nio.ByteBuffer r33, int r34, int r35, long r36, boolean r38) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
        r27 = this;
        r1 = r27;
        r2 = r32;
        r3 = r33;
        r4 = r34;
        r5 = r36;
        r7 = r1.f19492m;
        r8 = 2;
        r9 = 0;
        r10 = 1;
        if (r7 == 0) goto L_0x0019;
    L_0x0011:
        r7 = r35 & 2;
        if (r7 == 0) goto L_0x0019;
    L_0x0015:
        r2.releaseOutputBuffer(r4, r9);
        return r10;
    L_0x0019:
        if (r38 == 0) goto L_0x002e;
    L_0x001b:
        r2.releaseOutputBuffer(r4, r9);
        r2 = r1.j;
        r3 = r2.f4237e;
        r3 = r3 + r10;
        r2.f4237e = r3;
        r2 = r1.f19491l;
        r3 = r2.f4144B;
        if (r3 != r10) goto L_0x002d;
    L_0x002b:
        r2.f4144B = r8;
    L_0x002d:
        return r10;
    L_0x002e:
        r7 = r1.f19491l;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r11 = r7.f4147E;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        if (r11 == 0) goto L_0x003b;
    L_0x0034:
        r11 = r7.f4147E;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        if (r3 != r11) goto L_0x0039;
    L_0x0038:
        goto L_0x003b;
    L_0x0039:
        r11 = r9;
        goto L_0x003c;
    L_0x003b:
        r11 = r10;
    L_0x003c:
        com.google.android.exoplayer2.util.Assertions.m4184a(r11);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r11 = r7.m3695h();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        if (r11 != 0) goto L_0x00b3;
    L_0x0045:
        r11 = r7.f4173g;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r11.block();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r11 = r7.m3700m();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r7.f4177k = r11;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r11 = r7.f4177k;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r11 = r11.getAudioSessionId();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r12 = com.google.android.exoplayer2.audio.AudioTrack.f4141a;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        if (r12 == 0) goto L_0x0091;
    L_0x005a:
        r12 = com.google.android.exoplayer2.util.Util.f5283a;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r13 = 21;
        if (r12 >= r13) goto L_0x0091;
    L_0x0060:
        r12 = r7.f4176j;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        if (r12 == 0) goto L_0x006f;
    L_0x0064:
        r12 = r7.f4176j;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r12 = r12.getAudioSessionId();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        if (r11 == r12) goto L_0x006f;
    L_0x006c:
        r7.m3694g();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
    L_0x006f:
        r12 = r7.f4176j;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        if (r12 != 0) goto L_0x0091;
    L_0x0073:
        r15 = new android.media.AudioTrack;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r13 = 3;
        r14 = 4000; // 0xfa0 float:5.605E-42 double:1.9763E-320;
        r16 = 4;
        r17 = 2;
        r18 = 2;
        r19 = 0;
        r12 = r15;
        r10 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r18 = r19;
        r19 = r11;
        r12.<init>(r13, r14, r15, r16, r17, r18, r19);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r7.f4176j = r10;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
    L_0x0091:
        r10 = r7.f4150H;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        if (r10 == r11) goto L_0x009c;
    L_0x0095:
        r7.f4150H = r11;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r10 = r7.f4172f;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r10.mo1319a(r11);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
    L_0x009c:
        r10 = r7.f4174h;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r11 = r7.f4177k;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r12 = r7.m3699l();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r10.mo1304a(r11, r12);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r7.m3692e();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r7.f4152J = r9;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r10 = r7.f4149G;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        if (r10 == 0) goto L_0x00b3;
    L_0x00b0:
        r7.m3688b();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
    L_0x00b3:
        r10 = r7.m3699l();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r11 = 0;
        if (r10 == 0) goto L_0x00da;
    L_0x00bb:
        r10 = r7.f4177k;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r10 = r10.getPlayState();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        if (r10 != r8) goto L_0x00c7;
    L_0x00c3:
        r7.f4152J = r9;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        goto L_0x0219;
    L_0x00c7:
        r10 = r7.f4177k;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r10 = r10.getPlayState();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r13 = 1;
        if (r10 != r13) goto L_0x00da;
    L_0x00d0:
        r10 = r7.f4174h;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r13 = r10.m3668b();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r10 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1));
        if (r10 != 0) goto L_0x0219;
    L_0x00da:
        r10 = r7.f4152J;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r13 = r7.m3691d();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r7.f4152J = r13;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        if (r10 == 0) goto L_0x010a;
    L_0x00e4:
        r10 = r7.f4152J;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        if (r10 != 0) goto L_0x010a;
    L_0x00e8:
        r10 = r7.f4177k;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r10 = r10.getPlayState();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r13 = 1;
        if (r10 == r13) goto L_0x010a;
    L_0x00f1:
        r13 = android.os.SystemClock.elapsedRealtime();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r9 = r7.f4153K;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r24 = r13 - r9;
        r9 = r7.f4172f;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r10 = r7.f4184r;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r13 = r7.f4185s;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r22 = com.google.android.exoplayer2.C0377C.m3539a(r13);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r20 = r9;
        r21 = r10;
        r20.mo1320a(r21, r22, r24);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
    L_0x010a:
        r9 = r7.f4147E;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r10 = 0;
        if (r9 != 0) goto L_0x0200;
    L_0x010f:
        r9 = r33.hasRemaining();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        if (r9 != 0) goto L_0x0118;
    L_0x0115:
        r3 = 1;
        goto L_0x021a;
    L_0x0118:
        r9 = r7.f4183q;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        if (r9 == 0) goto L_0x0154;
    L_0x011c:
        r9 = r7.f4143A;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        if (r9 != 0) goto L_0x0154;
    L_0x0120:
        r9 = r7.f4181o;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r13 = 7;
        if (r9 == r13) goto L_0x014e;
    L_0x0125:
        r13 = 8;
        if (r9 != r13) goto L_0x012a;
    L_0x0129:
        goto L_0x014e;
    L_0x012a:
        r13 = 5;
        if (r9 != r13) goto L_0x0132;
    L_0x012d:
        r9 = com.google.android.exoplayer2.audio.Ac3Util.m3639a();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        goto L_0x0152;
    L_0x0132:
        r13 = 6;
        if (r9 != r13) goto L_0x013a;
    L_0x0135:
        r9 = com.google.android.exoplayer2.audio.Ac3Util.m3641a(r33);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        goto L_0x0152;
    L_0x013a:
        r2 = new java.lang.IllegalStateException;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r3 = new java.lang.StringBuilder;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r4 = "Unexpected audio encoding: ";
        r3.<init>(r4);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r3.append(r9);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r3 = r3.toString();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r2.<init>(r3);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        throw r2;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
    L_0x014e:
        r9 = com.google.android.exoplayer2.audio.DtsUtil.m3701a(r33);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
    L_0x0152:
        r7.f4143A = r9;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
    L_0x0154:
        r9 = r7.f4186t;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        if (r9 == 0) goto L_0x0183;
    L_0x0158:
        r9 = r7.m3690c();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        if (r9 == 0) goto L_0x0219;
    L_0x015e:
        r9 = r7.f4175i;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r15 = new com.google.android.exoplayer2.audio.AudioTrack$PlaybackParametersCheckpoint;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r14 = r7.f4186t;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r16 = java.lang.Math.max(r11, r5);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r11 = r7.m3697j();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r11 = r7.m3687b(r11);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r19 = 0;
        r13 = r15;
        r8 = r15;
        r15 = r16;
        r17 = r11;
        r13.<init>(r14, r15, r17);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r9.add(r8);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r7.f4186t = r10;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r7.m3684a();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
    L_0x0183:
        r8 = r7.f4144B;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        if (r8 != 0) goto L_0x0193;
    L_0x0187:
        r8 = 0;
        r8 = java.lang.Math.max(r8, r5);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r7.f4145C = r8;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r8 = 1;
        r7.f4144B = r8;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        goto L_0x01e7;
    L_0x0193:
        r8 = r7.f4145C;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r11 = r7.m3696i();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r11 = r7.m3687b(r11);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r8 = r8 + r11;
        r11 = r7.f4144B;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r12 = 1;
        if (r11 != r12) goto L_0x01d3;
    L_0x01a3:
        r11 = r8 - r5;
        r11 = java.lang.Math.abs(r11);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r13 = 200000; // 0x30d40 float:2.8026E-40 double:9.8813E-319;
        r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1));
        if (r11 <= 0) goto L_0x01d3;
    L_0x01b0:
        r11 = "AudioTrack";
        r12 = new java.lang.StringBuilder;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r13 = "Discontinuity detected [expected ";
        r12.<init>(r13);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r12.append(r8);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r13 = ", got ";
        r12.append(r13);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r12.append(r5);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r13 = "]";
        r12.append(r13);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r12 = r12.toString();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        android.util.Log.e(r11, r12);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r11 = 2;
        r7.f4144B = r11;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
    L_0x01d3:
        r11 = r7.f4144B;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r12 = 2;
        if (r11 != r12) goto L_0x01e7;
    L_0x01d8:
        r11 = r7.f4145C;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r8 = r5 - r8;
        r11 = r11 + r8;
        r7.f4145C = r11;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r8 = 1;
        r7.f4144B = r8;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r8 = r7.f4172f;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r8.mo1318a();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
    L_0x01e7:
        r8 = r7.f4183q;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        if (r8 == 0) goto L_0x01f4;
    L_0x01eb:
        r8 = r7.f4191y;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r11 = r7.f4143A;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r11 = (long) r11;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r8 = r8 + r11;
        r7.f4191y = r8;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        goto L_0x01fe;
    L_0x01f4:
        r8 = r7.f4190x;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r11 = r33.remaining();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r11 = (long) r11;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r8 = r8 + r11;
        r7.f4190x = r8;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
    L_0x01fe:
        r7.f4147E = r3;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
    L_0x0200:
        r3 = r7.f4183q;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        if (r3 == 0) goto L_0x020a;
    L_0x0204:
        r3 = r7.f4147E;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r7.m3686a(r3, r5);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        goto L_0x020d;
    L_0x020a:
        r7.m3685a(r5);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
    L_0x020d:
        r3 = r7.f4147E;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r3 = r3.hasRemaining();	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        if (r3 != 0) goto L_0x0219;
    L_0x0215:
        r7.f4147E = r10;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        goto L_0x0115;
    L_0x0219:
        r3 = 0;
    L_0x021a:
        if (r3 == 0) goto L_0x0229;
    L_0x021c:
        r3 = 0;
        r2.releaseOutputBuffer(r4, r3);	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r2 = r1.j;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r3 = r2.f4236d;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        r4 = 1;
        r3 = r3 + r4;
        r2.f4236d = r3;	 Catch:{ InitializationException -> 0x022b, InitializationException -> 0x022b }
        return r4;
    L_0x0229:
        r2 = 0;
        return r2;
    L_0x022b:
        r0 = move-exception;
        r2 = r0;
        r3 = r1.f16763b;
        r2 = com.google.android.exoplayer2.ExoPlaybackException.m3542a(r2, r3);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.a(long, long, android.media.MediaCodec, java.nio.ByteBuffer, int, int, long, boolean):boolean");
    }

    protected final void mo4255x() throws ExoPlaybackException {
        try {
            AudioTrack audioTrack = this.f19491l;
            if (!audioTrack.f4148F) {
                if (audioTrack.m3695h()) {
                    if (audioTrack.m3690c()) {
                        audioTrack.f4174h.m3666a(audioTrack.m3697j());
                        audioTrack.f4188v = 0;
                        audioTrack.f4148F = true;
                    }
                }
            }
        } catch (Exception e) {
            throw ExoPlaybackException.m3542a(e, this.f16763b);
        }
    }

    public final void mo3312a(int i, Object obj) throws ExoPlaybackException {
        switch (i) {
            case 2:
                i = this.f19491l;
                obj = ((Float) obj).floatValue();
                if (i.f4146D != obj) {
                    i.f4146D = obj;
                    i.m3692e();
                }
                return;
            case 3:
                AudioAttributes audioAttributes = (AudioAttributes) obj;
                i = this.f19491l;
                if (!i.f4182p.equals(audioAttributes)) {
                    i.f4182p = audioAttributes;
                    if (i.f4151I == null) {
                        i.m3693f();
                        i.f4150H = null;
                    }
                }
                return;
            default:
                super.mo3312a(i, obj);
                return;
        }
    }
}
