package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.os.ConditionVariable;
import android.os.SystemClock;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedList;

public final class AudioTrack {
    public static boolean f4141a = false;
    public static boolean f4142b = false;
    int f4143A;
    int f4144B;
    long f4145C;
    float f4146D;
    ByteBuffer f4147E;
    boolean f4148F;
    boolean f4149G;
    int f4150H;
    boolean f4151I;
    boolean f4152J;
    long f4153K;
    private final SonicAudioProcessor f4154L;
    private final long[] f4155M;
    private long f4156N;
    private long f4157O;
    private ByteBuffer f4158P;
    private int f4159Q;
    private int f4160R;
    private long f4161S;
    private long f4162T;
    private boolean f4163U;
    private long f4164V;
    private Method f4165W;
    private long f4166X;
    private long f4167Y;
    private long f4168Z;
    private long aa;
    private AudioProcessor[] ab;
    private ByteBuffer[] ac;
    private ByteBuffer ad;
    private byte[] ae;
    private int af;
    private int ag;
    final AudioCapabilities f4169c;
    final ChannelMappingAudioProcessor f4170d;
    final AudioProcessor[] f4171e;
    final Listener f4172f;
    final ConditionVariable f4173g = new ConditionVariable(true);
    final AudioTrackUtil f4174h;
    final LinkedList<PlaybackParametersCheckpoint> f4175i;
    android.media.AudioTrack f4176j;
    android.media.AudioTrack f4177k;
    int f4178l;
    int f4179m;
    int f4180n;
    int f4181o;
    AudioAttributes f4182p;
    boolean f4183q;
    int f4184r;
    long f4185s;
    PlaybackParameters f4186t;
    PlaybackParameters f4187u;
    int f4188v;
    int f4189w;
    long f4190x;
    long f4191y;
    int f4192z;

    private static class AudioTrackUtil {
        protected android.media.AudioTrack f4127a;
        private boolean f4128b;
        private int f4129c;
        private long f4130d;
        private long f4131e;
        private long f4132f;
        private long f4133g;
        private long f4134h;
        private long f4135i;

        public boolean mo1305d() {
            return false;
        }

        private AudioTrackUtil() {
        }

        public void mo1304a(android.media.AudioTrack audioTrack, boolean z) {
            this.f4127a = audioTrack;
            this.f4128b = z;
            this.f4133g = -9223372036854775807L;
            this.f4130d = 0;
            this.f4131e = 0;
            this.f4132f = 0;
            if (audioTrack != null) {
                this.f4129c = audioTrack.getSampleRate();
            }
        }

        public final void m3666a(long j) {
            this.f4134h = m3668b();
            this.f4133g = SystemClock.elapsedRealtime() * 1000;
            this.f4135i = j;
            this.f4127a.stop();
        }

        public final void m3665a() {
            if (this.f4133g == -9223372036854775807L) {
                this.f4127a.pause();
            }
        }

        public final long m3668b() {
            if (this.f4133g != -9223372036854775807L) {
                return Math.min(this.f4135i, this.f4134h + ((((SystemClock.elapsedRealtime() * 1000) - this.f4133g) * ((long) this.f4129c)) / 1000000));
            }
            int playState = this.f4127a.getPlayState();
            if (playState == 1) {
                return 0;
            }
            long playbackHeadPosition = 4294967295L & ((long) this.f4127a.getPlaybackHeadPosition());
            if (this.f4128b) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.f4132f = this.f4130d;
                }
                playbackHeadPosition += this.f4132f;
            }
            if (this.f4130d > playbackHeadPosition) {
                this.f4131e++;
            }
            this.f4130d = playbackHeadPosition;
            return playbackHeadPosition + (this.f4131e << 32);
        }

        public final long m3669c() {
            return (m3668b() * 1000000) / ((long) this.f4129c);
        }

        public long mo1306e() {
            throw new UnsupportedOperationException();
        }

        public long mo1307f() {
            throw new UnsupportedOperationException();
        }
    }

    public static final class ConfigurationException extends Exception {
        public ConfigurationException(Throwable th) {
            super(th);
        }

        public ConfigurationException(String str) {
            super(str);
        }
    }

    public static final class InitializationException extends Exception {
        public final int f4136a;

        public InitializationException(int i, int i2, int i3, int i4) {
            StringBuilder stringBuilder = new StringBuilder("AudioTrack init failed: ");
            stringBuilder.append(i);
            stringBuilder.append(", Config(");
            stringBuilder.append(i2);
            stringBuilder.append(", ");
            stringBuilder.append(i3);
            stringBuilder.append(", ");
            stringBuilder.append(i4);
            stringBuilder.append(")");
            super(stringBuilder.toString());
            this.f4136a = i;
        }
    }

    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        public InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    public interface Listener {
        void mo1318a();

        void mo1319a(int i);

        void mo1320a(int i, long j, long j2);
    }

    private static final class PlaybackParametersCheckpoint {
        private final PlaybackParameters f4137a;
        private final long f4138b;
        private final long f4139c;

        private PlaybackParametersCheckpoint(PlaybackParameters playbackParameters, long j, long j2) {
            this.f4137a = playbackParameters;
            this.f4138b = j;
            this.f4139c = j2;
        }
    }

    public static final class WriteException extends Exception {
        public final int f4140a;

        public WriteException(int i) {
            StringBuilder stringBuilder = new StringBuilder("AudioTrack write failed: ");
            stringBuilder.append(i);
            super(stringBuilder.toString());
            this.f4140a = i;
        }
    }

    @TargetApi(19)
    private static class AudioTrackUtilV19 extends AudioTrackUtil {
        private final AudioTimestamp f12769b = new AudioTimestamp();
        private long f12770c;
        private long f12771d;
        private long f12772e;

        public AudioTrackUtilV19() {
            super();
        }

        public final void mo1304a(android.media.AudioTrack audioTrack, boolean z) {
            super.mo1304a(audioTrack, z);
            this.f12770c = 0;
            this.f12771d = 0;
            this.f12772e = 0;
        }

        public final boolean mo1305d() {
            boolean timestamp = this.a.getTimestamp(this.f12769b);
            if (timestamp) {
                long j = this.f12769b.framePosition;
                if (this.f12771d > j) {
                    this.f12770c++;
                }
                this.f12771d = j;
                this.f12772e = j + (this.f12770c << 32);
            }
            return timestamp;
        }

        public final long mo1306e() {
            return this.f12769b.nanoTime;
        }

        public final long mo1307f() {
            return this.f12772e;
        }
    }

    public AudioTrack(com.google.android.exoplayer2.audio.AudioCapabilities r4, com.google.android.exoplayer2.audio.AudioProcessor[] r5, com.google.android.exoplayer2.audio.AudioTrack.Listener r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r3.<init>();
        r3.f4169c = r4;
        r3.f4172f = r6;
        r4 = new android.os.ConditionVariable;
        r6 = 1;
        r4.<init>(r6);
        r3.f4173g = r4;
        r4 = com.google.android.exoplayer2.util.Util.f5283a;
        r0 = 18;
        if (r4 < r0) goto L_0x0020;
    L_0x0015:
        r4 = android.media.AudioTrack.class;	 Catch:{ NoSuchMethodException -> 0x0020 }
        r0 = "getLatency";	 Catch:{ NoSuchMethodException -> 0x0020 }
        r1 = 0;	 Catch:{ NoSuchMethodException -> 0x0020 }
        r4 = r4.getMethod(r0, r1);	 Catch:{ NoSuchMethodException -> 0x0020 }
        r3.f4165W = r4;	 Catch:{ NoSuchMethodException -> 0x0020 }
    L_0x0020:
        r4 = com.google.android.exoplayer2.util.Util.f5283a;
        r0 = 19;
        r1 = 0;
        if (r4 < r0) goto L_0x002f;
    L_0x0027:
        r4 = new com.google.android.exoplayer2.audio.AudioTrack$AudioTrackUtilV19;
        r4.<init>();
        r3.f4174h = r4;
        goto L_0x0036;
    L_0x002f:
        r4 = new com.google.android.exoplayer2.audio.AudioTrack$AudioTrackUtil;
        r4.<init>();
        r3.f4174h = r4;
    L_0x0036:
        r4 = new com.google.android.exoplayer2.audio.ChannelMappingAudioProcessor;
        r4.<init>();
        r3.f4170d = r4;
        r4 = new com.google.android.exoplayer2.audio.SonicAudioProcessor;
        r4.<init>();
        r3.f4154L = r4;
        r4 = 3;
        r0 = 2;
        r2 = r5.length;
        r4 = r4 + r2;
        r4 = new com.google.android.exoplayer2.audio.AudioProcessor[r4];
        r3.f4171e = r4;
        r4 = r3.f4171e;
        r2 = new com.google.android.exoplayer2.audio.ResamplingAudioProcessor;
        r2.<init>();
        r4[r1] = r2;
        r4 = r3.f4171e;
        r2 = r3.f4170d;
        r4[r6] = r2;
        r4 = r3.f4171e;
        r6 = r5.length;
        java.lang.System.arraycopy(r5, r1, r4, r0, r6);
        r4 = r3.f4171e;
        r5 = r5.length;
        r0 = r0 + r5;
        r5 = r3.f4154L;
        r4[r0] = r5;
        r4 = 10;
        r4 = new long[r4];
        r3.f4155M = r4;
        r4 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r3.f4146D = r4;
        r3.f4144B = r1;
        r4 = com.google.android.exoplayer2.audio.AudioAttributes.f4096a;
        r3.f4182p = r4;
        r3.f4150H = r1;
        r4 = com.google.android.exoplayer2.PlaybackParameters.f4054a;
        r3.f4187u = r4;
        r4 = -1;
        r3.ag = r4;
        r4 = new com.google.android.exoplayer2.audio.AudioProcessor[r1];
        r3.ab = r4;
        r4 = new java.nio.ByteBuffer[r1];
        r3.ac = r4;
        r4 = new java.util.LinkedList;
        r4.<init>();
        r3.f4175i = r4;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.AudioTrack.<init>(com.google.android.exoplayer2.audio.AudioCapabilities, com.google.android.exoplayer2.audio.AudioProcessor[], com.google.android.exoplayer2.audio.AudioTrack$Listener):void");
    }

    final void m3684a() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (AudioProcessor audioProcessor : this.f4171e) {
            if (audioProcessor.mo1309a()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.mo1316g();
            }
        }
        int size = arrayList.size();
        this.ab = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.ac = new ByteBuffer[size];
        while (i < size) {
            AudioProcessor audioProcessor2 = this.ab[i];
            audioProcessor2.mo1316g();
            this.ac[i] = audioProcessor2.mo1314e();
            i++;
        }
    }

    public final void m3688b() {
        this.f4149G = true;
        if (m3695h()) {
            this.f4168Z = System.nanoTime() / 1000;
            this.f4177k.play();
        }
    }

    final void m3685a(long j) throws WriteException {
        int length = this.ab.length;
        int i = length;
        while (i >= 0) {
            ByteBuffer byteBuffer = i > 0 ? this.ac[i - 1] : this.f4147E != null ? this.f4147E : AudioProcessor.f4104a;
            if (i == length) {
                m3686a(byteBuffer, j);
            } else {
                AudioProcessor audioProcessor = this.ab[i];
                audioProcessor.mo1308a(byteBuffer);
                ByteBuffer e = audioProcessor.mo1314e();
                this.ac[i] = e;
                if (e.hasRemaining()) {
                    i++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i--;
            } else {
                return;
            }
        }
    }

    final boolean m3686a(ByteBuffer byteBuffer, long j) throws WriteException {
        if (!byteBuffer.hasRemaining()) {
            return true;
        }
        int remaining;
        if (this.ad != null) {
            Assertions.m4184a(this.ad == byteBuffer);
        } else {
            this.ad = byteBuffer;
            if (Util.f5283a < 21) {
                remaining = byteBuffer.remaining();
                if (this.ae == null || this.ae.length < remaining) {
                    this.ae = new byte[remaining];
                }
                int position = byteBuffer.position();
                byteBuffer.get(this.ae, 0, remaining);
                byteBuffer.position(position);
                this.af = 0;
            }
        }
        remaining = byteBuffer.remaining();
        int b;
        if (Util.f5283a < 21) {
            b = this.f4184r - ((int) (this.f4166X - (this.f4174h.m3668b() * ((long) this.f4192z))));
            if (b > 0) {
                j = this.f4177k.write(this.ae, this.af, Math.min(remaining, b));
                if (j > null) {
                    this.af += j;
                    byteBuffer.position(byteBuffer.position() + j);
                }
                this.f4153K = SystemClock.elapsedRealtime();
                if (j < null) {
                    throw new WriteException(j);
                }
                if (this.f4183q == null) {
                    this.f4166X += (long) j;
                }
                if (j == remaining) {
                    return false;
                }
                if (this.f4183q != null) {
                    this.f4167Y += (long) this.f4143A;
                }
                this.ad = null;
                return true;
            }
        }
        if (this.f4151I) {
            Assertions.m4186b(j != -9223372036854775807L);
            android.media.AudioTrack audioTrack = this.f4177k;
            if (this.f4158P == null) {
                this.f4158P = ByteBuffer.allocate(16);
                this.f4158P.order(ByteOrder.BIG_ENDIAN);
                this.f4158P.putInt(1431633921);
            }
            if (this.f4188v == 0) {
                this.f4158P.putInt(4, remaining);
                this.f4158P.putLong(8, j * 1000);
                this.f4158P.position(0);
                this.f4188v = remaining;
            }
            j = this.f4158P.remaining();
            if (j > null) {
                b = audioTrack.write(this.f4158P, j, 1);
                if (b < 0) {
                    this.f4188v = 0;
                    j = b;
                } else if (b < j) {
                }
            }
            byteBuffer = audioTrack.write(byteBuffer, remaining, 1);
            if (byteBuffer < null) {
                this.f4188v = 0;
            } else {
                this.f4188v -= byteBuffer;
            }
            j = byteBuffer;
        } else {
            j = this.f4177k.write(byteBuffer, remaining, 1);
        }
        this.f4153K = SystemClock.elapsedRealtime();
        if (j < null) {
            if (this.f4183q == null) {
                this.f4166X += (long) j;
            }
            if (j == remaining) {
                return false;
            }
            if (this.f4183q != null) {
                this.f4167Y += (long) this.f4143A;
            }
            this.ad = null;
            return true;
        }
        throw new WriteException(j);
        j = 0;
        this.f4153K = SystemClock.elapsedRealtime();
        if (j < null) {
            throw new WriteException(j);
        }
        if (this.f4183q == null) {
            this.f4166X += (long) j;
        }
        if (j == remaining) {
            return false;
        }
        if (this.f4183q != null) {
            this.f4167Y += (long) this.f4143A;
        }
        this.ad = null;
        return true;
    }

    final boolean m3690c() throws com.google.android.exoplayer2.audio.AudioTrack.WriteException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r0 = r8.ag;
        r1 = -1;
        r2 = 1;
        r3 = 0;
        if (r0 != r1) goto L_0x0014;
    L_0x0007:
        r0 = r8.f4183q;
        if (r0 == 0) goto L_0x000f;
    L_0x000b:
        r0 = r8.ab;
        r0 = r0.length;
        goto L_0x0010;
    L_0x000f:
        r0 = r3;
    L_0x0010:
        r8.ag = r0;
    L_0x0012:
        r0 = r2;
        goto L_0x0015;
    L_0x0014:
        r0 = r3;
    L_0x0015:
        r4 = r8.ag;
        r5 = r8.ab;
        r6 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r5 = r5.length;
        if (r4 >= r5) goto L_0x003c;
    L_0x0021:
        r4 = r8.ab;
        r5 = r8.ag;
        r4 = r4[r5];
        if (r0 == 0) goto L_0x002c;
    L_0x0029:
        r4.mo1313d();
    L_0x002c:
        r8.m3685a(r6);
        r0 = r4.mo1315f();
        if (r0 != 0) goto L_0x0036;
    L_0x0035:
        return r3;
    L_0x0036:
        r0 = r8.ag;
        r0 = r0 + r2;
        r8.ag = r0;
        goto L_0x0012;
    L_0x003c:
        r0 = r8.ad;
        if (r0 == 0) goto L_0x004a;
    L_0x0040:
        r0 = r8.ad;
        r8.m3686a(r0, r6);
        r0 = r8.ad;
        if (r0 == 0) goto L_0x004a;
    L_0x0049:
        return r3;
    L_0x004a:
        r8.ag = r1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.AudioTrack.c():boolean");
    }

    public final boolean m3691d() {
        if (m3695h()) {
            if (m3697j() <= this.f4174h.m3668b()) {
                boolean z = m3699l() && this.f4177k.getPlayState() == 2 && this.f4177k.getPlaybackHeadPosition() == 0;
                if (z) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    public final PlaybackParameters m3683a(PlaybackParameters playbackParameters) {
        if (this.f4183q) {
            this.f4187u = PlaybackParameters.f4054a;
            return this.f4187u;
        }
        SonicAudioProcessor sonicAudioProcessor = this.f4154L;
        sonicAudioProcessor.f12788b = Util.m4295a(playbackParameters.f4055b, 0.1f, 8.0f);
        float f = sonicAudioProcessor.f12788b;
        SonicAudioProcessor sonicAudioProcessor2 = this.f4154L;
        float f2 = playbackParameters.f4056c;
        sonicAudioProcessor2.f12789c = Util.m4295a(f2, 0.1f, 8.0f);
        PlaybackParameters playbackParameters2 = new PlaybackParameters(f, f2);
        playbackParameters = this.f4186t != null ? this.f4186t : this.f4175i.isEmpty() == null ? ((PlaybackParametersCheckpoint) this.f4175i.getLast()).f4137a : this.f4187u;
        if (playbackParameters2.equals(playbackParameters) == null) {
            if (m3695h() != null) {
                this.f4186t = playbackParameters2;
            } else {
                this.f4187u = playbackParameters2;
            }
        }
        return this.f4187u;
    }

    final void m3692e() {
        if (m3695h()) {
            if (Util.f5283a >= 21) {
                this.f4177k.setVolume(this.f4146D);
                return;
            }
            android.media.AudioTrack audioTrack = this.f4177k;
            float f = this.f4146D;
            audioTrack.setStereoVolume(f, f);
        }
    }

    public final void m3693f() {
        if (m3695h()) {
            this.f4190x = 0;
            this.f4191y = 0;
            this.f4166X = 0;
            this.f4167Y = 0;
            this.f4143A = 0;
            if (this.f4186t != null) {
                this.f4187u = this.f4186t;
                this.f4186t = null;
            } else if (!this.f4175i.isEmpty()) {
                this.f4187u = ((PlaybackParametersCheckpoint) this.f4175i.getLast()).f4137a;
            }
            this.f4175i.clear();
            this.f4156N = 0;
            this.f4157O = 0;
            this.f4147E = null;
            this.ad = null;
            for (int i = 0; i < this.ab.length; i++) {
                AudioProcessor audioProcessor = this.ab[i];
                audioProcessor.mo1316g();
                this.ac[i] = audioProcessor.mo1314e();
            }
            this.f4148F = false;
            this.ag = -1;
            this.f4158P = null;
            this.f4188v = 0;
            this.f4144B = 0;
            this.aa = 0;
            m3698k();
            if (this.f4177k.getPlayState() == 3) {
                this.f4177k.pause();
            }
            final android.media.AudioTrack audioTrack = this.f4177k;
            this.f4177k = null;
            this.f4174h.mo1304a(null, false);
            this.f4173g.close();
            new Thread(this) {
                final /* synthetic */ AudioTrack f4124b;

                public void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        this.f4124b.f4173g.open();
                    }
                }
            }.start();
        }
    }

    final void m3694g() {
        if (this.f4176j != null) {
            final android.media.AudioTrack audioTrack = this.f4176j;
            this.f4176j = null;
            new Thread(this) {
                final /* synthetic */ AudioTrack f4126b;

                public void run() {
                    audioTrack.release();
                }
            }.start();
        }
    }

    private long m3681d(long j) {
        while (!this.f4175i.isEmpty() && j >= ((PlaybackParametersCheckpoint) this.f4175i.getFirst()).f4139c) {
            PlaybackParametersCheckpoint playbackParametersCheckpoint = (PlaybackParametersCheckpoint) this.f4175i.remove();
            this.f4187u = playbackParametersCheckpoint.f4137a;
            this.f4157O = playbackParametersCheckpoint.f4139c;
            this.f4156N = playbackParametersCheckpoint.f4138b - this.f4145C;
        }
        if (this.f4187u.f4055b == 1.0f) {
            return (j + this.f4156N) - this.f4157O;
        }
        if (!this.f4175i.isEmpty() || this.f4154L.f12791e < 1024) {
            return this.f4156N + ((long) (((double) this.f4187u.f4055b) * ((double) (j - this.f4157O))));
        }
        return this.f4156N + Util.m4303a(j - this.f4157O, this.f4154L.f12790d, this.f4154L.f12791e);
    }

    final boolean m3695h() {
        return this.f4177k != null;
    }

    final long m3687b(long j) {
        return (j * 1000000) / ((long) this.f4178l);
    }

    final long m3689c(long j) {
        return (j * ((long) this.f4178l)) / 1000000;
    }

    final long m3696i() {
        return this.f4183q ? this.f4191y : this.f4190x / ((long) this.f4189w);
    }

    final long m3697j() {
        return this.f4183q ? this.f4167Y : this.f4166X / ((long) this.f4192z);
    }

    final void m3698k() {
        this.f4161S = 0;
        this.f4160R = 0;
        this.f4159Q = 0;
        this.f4162T = 0;
        this.f4163U = false;
        this.f4164V = 0;
    }

    final boolean m3699l() {
        return Util.f5283a < 23 && (this.f4181o == 5 || this.f4181o == 6);
    }

    final android.media.AudioTrack m3700m() throws com.google.android.exoplayer2.audio.AudioTrack.InitializationException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r10 = this;
        r0 = com.google.android.exoplayer2.util.Util.f5283a;
        r1 = 1;
        r2 = 21;
        if (r0 < r2) goto L_0x007a;
    L_0x0007:
        r0 = r10.f4151I;
        if (r0 == 0) goto L_0x0025;
    L_0x000b:
        r0 = new android.media.AudioAttributes$Builder;
        r0.<init>();
        r2 = 3;
        r0 = r0.setContentType(r2);
        r2 = 16;
        r0 = r0.setFlags(r2);
        r0 = r0.setUsage(r1);
        r0 = r0.build();
    L_0x0023:
        r3 = r0;
        goto L_0x004b;
    L_0x0025:
        r0 = r10.f4182p;
        r2 = r0.f4100e;
        if (r2 != 0) goto L_0x0048;
    L_0x002b:
        r2 = new android.media.AudioAttributes$Builder;
        r2.<init>();
        r3 = r0.f4097b;
        r2 = r2.setContentType(r3);
        r3 = r0.f4098c;
        r2 = r2.setFlags(r3);
        r3 = r0.f4099d;
        r2 = r2.setUsage(r3);
        r2 = r2.build();
        r0.f4100e = r2;
    L_0x0048:
        r0 = r0.f4100e;
        goto L_0x0023;
    L_0x004b:
        r0 = new android.media.AudioFormat$Builder;
        r0.<init>();
        r2 = r10.f4179m;
        r0 = r0.setChannelMask(r2);
        r2 = r10.f4181o;
        r0 = r0.setEncoding(r2);
        r2 = r10.f4178l;
        r0 = r0.setSampleRate(r2);
        r4 = r0.build();
        r0 = r10.f4150H;
        if (r0 == 0) goto L_0x006e;
    L_0x006a:
        r0 = r10.f4150H;
    L_0x006c:
        r7 = r0;
        goto L_0x0070;
    L_0x006e:
        r0 = 0;
        goto L_0x006c;
    L_0x0070:
        r0 = new android.media.AudioTrack;
        r5 = r10.f4184r;
        r6 = 1;
        r2 = r0;
        r2.<init>(r3, r4, r5, r6, r7);
        goto L_0x00a7;
    L_0x007a:
        r0 = r10.f4182p;
        r0 = r0.f4099d;
        r3 = com.google.android.exoplayer2.util.Util.m4320c(r0);
        r0 = r10.f4150H;
        if (r0 != 0) goto L_0x0096;
    L_0x0086:
        r0 = new android.media.AudioTrack;
        r4 = r10.f4178l;
        r5 = r10.f4179m;
        r6 = r10.f4181o;
        r7 = r10.f4184r;
        r8 = 1;
        r2 = r0;
        r2.<init>(r3, r4, r5, r6, r7, r8);
        goto L_0x00a7;
    L_0x0096:
        r0 = new android.media.AudioTrack;
        r4 = r10.f4178l;
        r5 = r10.f4179m;
        r6 = r10.f4181o;
        r7 = r10.f4184r;
        r8 = 1;
        r9 = r10.f4150H;
        r2 = r0;
        r2.<init>(r3, r4, r5, r6, r7, r8, r9);
    L_0x00a7:
        r2 = r0.getState();
        if (r2 == r1) goto L_0x00bc;
    L_0x00ad:
        r0.release();	 Catch:{ Exception -> 0x00b0 }
    L_0x00b0:
        r0 = new com.google.android.exoplayer2.audio.AudioTrack$InitializationException;
        r1 = r10.f4178l;
        r3 = r10.f4179m;
        r4 = r10.f4184r;
        r0.<init>(r2, r1, r3, r4);
        throw r0;
    L_0x00bc:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.AudioTrack.m():android.media.AudioTrack");
    }

    static int m3679a(String str) {
        int hashCode = str.hashCode();
        if (hashCode != -1095064472) {
            if (hashCode != 187078296) {
                if (hashCode != 1504578661) {
                    if (hashCode == 1505942594) {
                        if (str.equals("audio/vnd.dts.hd") != null) {
                            str = 3;
                            switch (str) {
                                case null:
                                    return 5;
                                case 1:
                                    return 6;
                                case 2:
                                    return 7;
                                case 3:
                                    return 8;
                                default:
                                    return 0;
                            }
                        }
                    }
                } else if (str.equals("audio/eac3") != null) {
                    str = true;
                    switch (str) {
                        case null:
                            return 5;
                        case 1:
                            return 6;
                        case 2:
                            return 7;
                        case 3:
                            return 8;
                        default:
                            return 0;
                    }
                }
            } else if (str.equals("audio/ac3") != null) {
                str = null;
                switch (str) {
                    case null:
                        return 5;
                    case 1:
                        return 6;
                    case 2:
                        return 7;
                    case 3:
                        return 8;
                    default:
                        return 0;
                }
            }
        } else if (str.equals("audio/vnd.dts") != null) {
            str = 2;
            switch (str) {
                case null:
                    return 5;
                case 1:
                    return 6;
                case 2:
                    return 7;
                case 3:
                    return 8;
                default:
                    return 0;
            }
        }
        str = -1;
        switch (str) {
            case null:
                return 5;
            case 1:
                return 6;
            case 2:
                return 7;
            case 3:
                return 8;
            default:
                return 0;
        }
    }

    public final long m3682a(boolean r19) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r18 = this;
        r0 = r18;
        r1 = r18.m3695h();
        r2 = 1;
        r3 = 0;
        if (r1 == 0) goto L_0x0010;
    L_0x000a:
        r1 = r0.f4144B;
        if (r1 == 0) goto L_0x0010;
    L_0x000e:
        r1 = r2;
        goto L_0x0011;
    L_0x0010:
        r1 = r3;
    L_0x0011:
        if (r1 != 0) goto L_0x0016;
    L_0x0013:
        r1 = -9223372036854775808;
        return r1;
    L_0x0016:
        r1 = r0.f4177k;
        r1 = r1.getPlayState();
        r4 = 3;
        r5 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r1 != r4) goto L_0x01ab;
    L_0x0021:
        r1 = r0.f4174h;
        r7 = r1.m3669c();
        r9 = 0;
        r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));
        if (r1 == 0) goto L_0x01ab;
    L_0x002d:
        r11 = java.lang.System.nanoTime();
        r11 = r11 / r5;
        r13 = r0.f4162T;
        r13 = r11 - r13;
        r15 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r1 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1));
        if (r1 < 0) goto L_0x0070;
    L_0x003c:
        r1 = r0.f4155M;
        r4 = r0.f4159Q;
        r13 = r7 - r11;
        r1[r4] = r13;
        r1 = r0.f4159Q;
        r1 = r1 + r2;
        r4 = 10;
        r1 = r1 % r4;
        r0.f4159Q = r1;
        r1 = r0.f4160R;
        if (r1 >= r4) goto L_0x0055;
    L_0x0050:
        r1 = r0.f4160R;
        r1 = r1 + r2;
        r0.f4160R = r1;
    L_0x0055:
        r0.f4162T = r11;
        r0.f4161S = r9;
        r1 = r3;
    L_0x005a:
        r2 = r0.f4160R;
        if (r1 >= r2) goto L_0x0070;
    L_0x005e:
        r13 = r0.f4161S;
        r2 = r0.f4155M;
        r15 = r2[r1];
        r2 = r0.f4160R;
        r9 = (long) r2;
        r15 = r15 / r9;
        r13 = r13 + r15;
        r0.f4161S = r13;
        r1 = r1 + 1;
        r9 = 0;
        goto L_0x005a;
    L_0x0070:
        r1 = r18.m3699l();
        if (r1 != 0) goto L_0x01ab;
    L_0x0076:
        r1 = r0.f4164V;
        r1 = r11 - r1;
        r9 = 500000; // 0x7a120 float:7.00649E-40 double:2.47033E-318;
        r1 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1));
        if (r1 < 0) goto L_0x01ab;
    L_0x0081:
        r1 = r0.f4174h;
        r1 = r1.mo1305d();
        r0.f4163U = r1;
        r1 = r0.f4163U;
        r9 = 5000000; // 0x4c4b40 float:7.006492E-39 double:2.470328E-317;
        if (r1 == 0) goto L_0x015d;
    L_0x0090:
        r1 = r0.f4174h;
        r1 = r1.mo1306e();
        r1 = r1 / r5;
        r4 = r0.f4174h;
        r13 = r4.mo1307f();
        r5 = r0.f4168Z;
        r4 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1));
        if (r4 >= 0) goto L_0x00a7;
    L_0x00a3:
        r0.f4163U = r3;
        goto L_0x015d;
    L_0x00a7:
        r4 = r1 - r11;
        r4 = java.lang.Math.abs(r4);
        r4 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1));
        if (r4 <= 0) goto L_0x0101;
    L_0x00b1:
        r4 = new java.lang.StringBuilder;
        r5 = "Spurious audio timestamp (system clock mismatch): ";
        r4.<init>(r5);
        r4.append(r13);
        r5 = ", ";
        r4.append(r5);
        r4.append(r1);
        r1 = ", ";
        r4.append(r1);
        r4.append(r11);
        r1 = ", ";
        r4.append(r1);
        r4.append(r7);
        r1 = ", ";
        r4.append(r1);
        r1 = r18.m3696i();
        r4.append(r1);
        r1 = ", ";
        r4.append(r1);
        r1 = r18.m3697j();
        r4.append(r1);
        r1 = r4.toString();
        r2 = f4142b;
        if (r2 == 0) goto L_0x00f9;
    L_0x00f3:
        r2 = new com.google.android.exoplayer2.audio.AudioTrack$InvalidAudioTrackTimestampException;
        r2.<init>(r1);
        throw r2;
    L_0x00f9:
        r2 = "AudioTrack";
        android.util.Log.w(r2, r1);
        r0.f4163U = r3;
        goto L_0x015d;
    L_0x0101:
        r4 = r0.m3687b(r13);
        r4 = r4 - r7;
        r4 = java.lang.Math.abs(r4);
        r4 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1));
        if (r4 <= 0) goto L_0x015d;
    L_0x010e:
        r4 = new java.lang.StringBuilder;
        r5 = "Spurious audio timestamp (frame position mismatch): ";
        r4.<init>(r5);
        r4.append(r13);
        r5 = ", ";
        r4.append(r5);
        r4.append(r1);
        r1 = ", ";
        r4.append(r1);
        r4.append(r11);
        r1 = ", ";
        r4.append(r1);
        r4.append(r7);
        r1 = ", ";
        r4.append(r1);
        r1 = r18.m3696i();
        r4.append(r1);
        r1 = ", ";
        r4.append(r1);
        r1 = r18.m3697j();
        r4.append(r1);
        r1 = r4.toString();
        r2 = f4142b;
        if (r2 == 0) goto L_0x0156;
    L_0x0150:
        r2 = new com.google.android.exoplayer2.audio.AudioTrack$InvalidAudioTrackTimestampException;
        r2.<init>(r1);
        throw r2;
    L_0x0156:
        r2 = "AudioTrack";
        android.util.Log.w(r2, r1);
        r0.f4163U = r3;
    L_0x015d:
        r1 = r0.f4165W;
        if (r1 == 0) goto L_0x01a9;
    L_0x0161:
        r1 = r0.f4183q;
        if (r1 != 0) goto L_0x01a9;
    L_0x0165:
        r1 = 0;
        r2 = r0.f4165W;	 Catch:{ Exception -> 0x01a7 }
        r3 = r0.f4177k;	 Catch:{ Exception -> 0x01a7 }
        r2 = r2.invoke(r3, r1);	 Catch:{ Exception -> 0x01a7 }
        r2 = (java.lang.Integer) r2;	 Catch:{ Exception -> 0x01a7 }
        r2 = r2.intValue();	 Catch:{ Exception -> 0x01a7 }
        r2 = (long) r2;	 Catch:{ Exception -> 0x01a7 }
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ Exception -> 0x01a7 }
        r2 = r2 * r4;	 Catch:{ Exception -> 0x01a7 }
        r4 = r0.f4185s;	 Catch:{ Exception -> 0x01a7 }
        r2 = r2 - r4;	 Catch:{ Exception -> 0x01a7 }
        r0.aa = r2;	 Catch:{ Exception -> 0x01a7 }
        r2 = r0.aa;	 Catch:{ Exception -> 0x01a7 }
        r4 = 0;	 Catch:{ Exception -> 0x01a7 }
        r2 = java.lang.Math.max(r2, r4);	 Catch:{ Exception -> 0x01a7 }
        r0.aa = r2;	 Catch:{ Exception -> 0x01a7 }
        r2 = r0.aa;	 Catch:{ Exception -> 0x01a7 }
        r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1));	 Catch:{ Exception -> 0x01a7 }
        if (r2 <= 0) goto L_0x01a9;	 Catch:{ Exception -> 0x01a7 }
    L_0x018d:
        r2 = "AudioTrack";	 Catch:{ Exception -> 0x01a7 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01a7 }
        r4 = "Ignoring impossibly large audio latency: ";	 Catch:{ Exception -> 0x01a7 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x01a7 }
        r4 = r0.aa;	 Catch:{ Exception -> 0x01a7 }
        r3.append(r4);	 Catch:{ Exception -> 0x01a7 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x01a7 }
        android.util.Log.w(r2, r3);	 Catch:{ Exception -> 0x01a7 }
        r2 = 0;	 Catch:{ Exception -> 0x01a7 }
        r0.aa = r2;	 Catch:{ Exception -> 0x01a7 }
        goto L_0x01a9;
    L_0x01a7:
        r0.f4165W = r1;
    L_0x01a9:
        r0.f4164V = r11;
    L_0x01ab:
        r1 = java.lang.System.nanoTime();
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r1 = r1 / r3;
        r5 = r0.f4163U;
        if (r5 == 0) goto L_0x01ce;
    L_0x01b6:
        r5 = r0.f4174h;
        r5 = r5.mo1306e();
        r5 = r5 / r3;
        r1 = r1 - r5;
        r1 = r0.m3689c(r1);
        r3 = r0.f4174h;
        r3 = r3.mo1307f();
        r3 = r3 + r1;
        r1 = r0.m3687b(r3);
        goto L_0x01e6;
    L_0x01ce:
        r3 = r0.f4160R;
        if (r3 != 0) goto L_0x01da;
    L_0x01d2:
        r1 = r0.f4174h;
        r1 = r1.m3669c();
    L_0x01d8:
        r2 = r1;
        goto L_0x01de;
    L_0x01da:
        r3 = r0.f4161S;
        r1 = r1 + r3;
        goto L_0x01d8;
    L_0x01de:
        if (r19 != 0) goto L_0x01e5;
    L_0x01e0:
        r4 = r0.aa;
        r1 = r2 - r4;
        goto L_0x01e6;
    L_0x01e5:
        r1 = r2;
    L_0x01e6:
        r3 = r0.f4145C;
        r1 = r0.m3681d(r1);
        r3 = r3 + r1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.AudioTrack.a(boolean):long");
    }
}
