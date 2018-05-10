package com.google.android.exoplayer2;

import android.content.Context;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;

public class DefaultRenderersFactory implements RenderersFactory {
    private final Context f12764a;
    private final DrmSessionManager<FrameworkMediaCrypto> f12765b;
    private final int f12766c;
    private final long f12767d;

    public DefaultRenderersFactory(Context context) {
        this(context, (byte) 0);
    }

    private DefaultRenderersFactory(Context context, byte b) {
        this(context, (char) (byte) 0);
    }

    private DefaultRenderersFactory(Context context, char c) {
        this(context, (short) '\u0000');
    }

    private DefaultRenderersFactory(Context context, short s) {
        this.f12764a = context;
        this.f12765b = null;
        this.f12766c = null;
        this.f12767d = 5000;
    }

    public final com.google.android.exoplayer2.Renderer[] mo1283a(android.os.Handler r19, com.google.android.exoplayer2.video.VideoRendererEventListener r20, com.google.android.exoplayer2.audio.AudioRendererEventListener r21, com.google.android.exoplayer2.text.TextRenderer.Output r22, com.google.android.exoplayer2.metadata.MetadataRenderer.Output r23) {
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
        r1 = r18;
        r11 = new java.util.ArrayList;
        r11.<init>();
        r3 = r1.f12764a;
        r7 = r1.f12765b;
        r12 = r1.f12767d;
        r14 = r1.f12766c;
        r9 = new com.google.android.exoplayer2.video.MediaCodecVideoRenderer;
        r4 = com.google.android.exoplayer2.mediacodec.MediaCodecSelector.f4656a;
        r2 = r9;
        r5 = r12;
        r8 = r19;
        r10 = r9;
        r9 = r20;
        r2.<init>(r3, r4, r5, r7, r8, r9);
        r11.add(r10);
        r9 = 3;
        r10 = 0;
        r8 = 2;
        r7 = 1;
        if (r14 == 0) goto L_0x0083;
    L_0x0026:
        r2 = r11.size();
        if (r14 != r8) goto L_0x002e;
    L_0x002c:
        r2 = r2 + -1;
    L_0x002e:
        r3 = "com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer";	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r3 = java.lang.Class.forName(r3);	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r4 = 5;	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r5 = new java.lang.Class[r4];	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r6 = java.lang.Boolean.TYPE;	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r5[r10] = r6;	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r6 = java.lang.Long.TYPE;	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r5[r7] = r6;	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r6 = android.os.Handler.class;	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r5[r8] = r6;	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r6 = com.google.android.exoplayer2.video.VideoRendererEventListener.class;	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r5[r9] = r6;	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r6 = java.lang.Integer.TYPE;	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r14 = 4;	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r5[r14] = r6;	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r3 = r3.getConstructor(r5);	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r4 = new java.lang.Object[r4];	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r5 = java.lang.Boolean.valueOf(r7);	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r4[r10] = r5;	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r5 = java.lang.Long.valueOf(r12);	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r4[r7] = r5;	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r4[r8] = r19;	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r4[r9] = r20;	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r5 = 50;	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r4[r14] = r5;	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r3 = r3.newInstance(r4);	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r3 = (com.google.android.exoplayer2.Renderer) r3;	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r11.add(r2, r3);	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r2 = "DefaultRenderersFactory";	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        r3 = "Loaded LibvpxVideoRenderer.";	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        android.util.Log.i(r2, r3);	 Catch:{ ClassNotFoundException -> 0x0083, Exception -> 0x007b }
        goto L_0x0083;
    L_0x007b:
        r0 = move-exception;
        r2 = r0;
        r3 = new java.lang.RuntimeException;
        r3.<init>(r2);
        throw r3;
    L_0x0083:
        r2 = r1.f12764a;
        r4 = r1.f12765b;
        r12 = new com.google.android.exoplayer2.audio.AudioProcessor[r10];
        r13 = r1.f12766c;
        r14 = new com.google.android.exoplayer2.audio.MediaCodecAudioRenderer;
        r3 = com.google.android.exoplayer2.mediacodec.MediaCodecSelector.f4656a;
        r15 = com.google.android.exoplayer2.audio.AudioCapabilities.m3646a(r2);
        r2 = r14;
        r5 = r19;
        r6 = r21;
        r16 = r7;
        r7 = r15;
        r10 = r8;
        r8 = r12;
        r2.<init>(r3, r4, r5, r6, r7, r8);
        r11.add(r14);
        if (r13 == 0) goto L_0x0164;
    L_0x00a5:
        r2 = r11.size();
        if (r13 != r10) goto L_0x00ad;
    L_0x00ab:
        r2 = r2 + -1;
    L_0x00ad:
        r3 = "com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer";	 Catch:{ ClassNotFoundException -> 0x00ea, Exception -> 0x00e2 }
        r3 = java.lang.Class.forName(r3);	 Catch:{ ClassNotFoundException -> 0x00ea, Exception -> 0x00e2 }
        r4 = new java.lang.Class[r9];	 Catch:{ ClassNotFoundException -> 0x00ea, Exception -> 0x00e2 }
        r5 = android.os.Handler.class;	 Catch:{ ClassNotFoundException -> 0x00ea, Exception -> 0x00e2 }
        r6 = 0;	 Catch:{ ClassNotFoundException -> 0x00ea, Exception -> 0x00e2 }
        r4[r6] = r5;	 Catch:{ ClassNotFoundException -> 0x00ea, Exception -> 0x00e2 }
        r5 = com.google.android.exoplayer2.audio.AudioRendererEventListener.class;	 Catch:{ ClassNotFoundException -> 0x00ea, Exception -> 0x00e2 }
        r4[r16] = r5;	 Catch:{ ClassNotFoundException -> 0x00ea, Exception -> 0x00e2 }
        r5 = com.google.android.exoplayer2.audio.AudioProcessor[].class;	 Catch:{ ClassNotFoundException -> 0x00ea, Exception -> 0x00e2 }
        r4[r10] = r5;	 Catch:{ ClassNotFoundException -> 0x00ea, Exception -> 0x00e2 }
        r3 = r3.getConstructor(r4);	 Catch:{ ClassNotFoundException -> 0x00ea, Exception -> 0x00e2 }
        r4 = new java.lang.Object[r9];	 Catch:{ ClassNotFoundException -> 0x00ea, Exception -> 0x00e2 }
        r5 = 0;	 Catch:{ ClassNotFoundException -> 0x00ea, Exception -> 0x00e2 }
        r4[r5] = r19;	 Catch:{ ClassNotFoundException -> 0x00ea, Exception -> 0x00e2 }
        r4[r16] = r21;	 Catch:{ ClassNotFoundException -> 0x00ea, Exception -> 0x00e2 }
        r4[r10] = r12;	 Catch:{ ClassNotFoundException -> 0x00ea, Exception -> 0x00e2 }
        r3 = r3.newInstance(r4);	 Catch:{ ClassNotFoundException -> 0x00ea, Exception -> 0x00e2 }
        r3 = (com.google.android.exoplayer2.Renderer) r3;	 Catch:{ ClassNotFoundException -> 0x00ea, Exception -> 0x00e2 }
        r4 = r2 + 1;
        r11.add(r2, r3);	 Catch:{ ClassNotFoundException -> 0x00eb, Exception -> 0x00e2 }
        r2 = "DefaultRenderersFactory";	 Catch:{ ClassNotFoundException -> 0x00eb, Exception -> 0x00e2 }
        r3 = "Loaded LibopusAudioRenderer.";	 Catch:{ ClassNotFoundException -> 0x00eb, Exception -> 0x00e2 }
        android.util.Log.i(r2, r3);	 Catch:{ ClassNotFoundException -> 0x00eb, Exception -> 0x00e2 }
        goto L_0x00eb;
    L_0x00e2:
        r0 = move-exception;
        r2 = r0;
        r3 = new java.lang.RuntimeException;
        r3.<init>(r2);
        throw r3;
    L_0x00ea:
        r4 = r2;
    L_0x00eb:
        r2 = "com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer";	 Catch:{ ClassNotFoundException -> 0x0128, Exception -> 0x0120 }
        r2 = java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x0128, Exception -> 0x0120 }
        r3 = new java.lang.Class[r9];	 Catch:{ ClassNotFoundException -> 0x0128, Exception -> 0x0120 }
        r5 = android.os.Handler.class;	 Catch:{ ClassNotFoundException -> 0x0128, Exception -> 0x0120 }
        r6 = 0;	 Catch:{ ClassNotFoundException -> 0x0128, Exception -> 0x0120 }
        r3[r6] = r5;	 Catch:{ ClassNotFoundException -> 0x0128, Exception -> 0x0120 }
        r5 = com.google.android.exoplayer2.audio.AudioRendererEventListener.class;	 Catch:{ ClassNotFoundException -> 0x0128, Exception -> 0x0120 }
        r3[r16] = r5;	 Catch:{ ClassNotFoundException -> 0x0128, Exception -> 0x0120 }
        r5 = com.google.android.exoplayer2.audio.AudioProcessor[].class;	 Catch:{ ClassNotFoundException -> 0x0128, Exception -> 0x0120 }
        r3[r10] = r5;	 Catch:{ ClassNotFoundException -> 0x0128, Exception -> 0x0120 }
        r2 = r2.getConstructor(r3);	 Catch:{ ClassNotFoundException -> 0x0128, Exception -> 0x0120 }
        r3 = new java.lang.Object[r9];	 Catch:{ ClassNotFoundException -> 0x0128, Exception -> 0x0120 }
        r5 = 0;	 Catch:{ ClassNotFoundException -> 0x0128, Exception -> 0x0120 }
        r3[r5] = r19;	 Catch:{ ClassNotFoundException -> 0x0128, Exception -> 0x0120 }
        r3[r16] = r21;	 Catch:{ ClassNotFoundException -> 0x0128, Exception -> 0x0120 }
        r3[r10] = r12;	 Catch:{ ClassNotFoundException -> 0x0128, Exception -> 0x0120 }
        r2 = r2.newInstance(r3);	 Catch:{ ClassNotFoundException -> 0x0128, Exception -> 0x0120 }
        r2 = (com.google.android.exoplayer2.Renderer) r2;	 Catch:{ ClassNotFoundException -> 0x0128, Exception -> 0x0120 }
        r3 = r4 + 1;
        r11.add(r4, r2);	 Catch:{ ClassNotFoundException -> 0x0129, Exception -> 0x0120 }
        r2 = "DefaultRenderersFactory";	 Catch:{ ClassNotFoundException -> 0x0129, Exception -> 0x0120 }
        r4 = "Loaded LibflacAudioRenderer.";	 Catch:{ ClassNotFoundException -> 0x0129, Exception -> 0x0120 }
        android.util.Log.i(r2, r4);	 Catch:{ ClassNotFoundException -> 0x0129, Exception -> 0x0120 }
        goto L_0x0129;
    L_0x0120:
        r0 = move-exception;
        r2 = r0;
        r3 = new java.lang.RuntimeException;
        r3.<init>(r2);
        throw r3;
    L_0x0128:
        r3 = r4;
    L_0x0129:
        r2 = "com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer";	 Catch:{ ClassNotFoundException -> 0x0164, Exception -> 0x015c }
        r2 = java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x0164, Exception -> 0x015c }
        r4 = new java.lang.Class[r9];	 Catch:{ ClassNotFoundException -> 0x0164, Exception -> 0x015c }
        r5 = android.os.Handler.class;	 Catch:{ ClassNotFoundException -> 0x0164, Exception -> 0x015c }
        r6 = 0;	 Catch:{ ClassNotFoundException -> 0x0164, Exception -> 0x015c }
        r4[r6] = r5;	 Catch:{ ClassNotFoundException -> 0x0164, Exception -> 0x015c }
        r5 = com.google.android.exoplayer2.audio.AudioRendererEventListener.class;	 Catch:{ ClassNotFoundException -> 0x0164, Exception -> 0x015c }
        r4[r16] = r5;	 Catch:{ ClassNotFoundException -> 0x0164, Exception -> 0x015c }
        r5 = com.google.android.exoplayer2.audio.AudioProcessor[].class;	 Catch:{ ClassNotFoundException -> 0x0164, Exception -> 0x015c }
        r4[r10] = r5;	 Catch:{ ClassNotFoundException -> 0x0164, Exception -> 0x015c }
        r2 = r2.getConstructor(r4);	 Catch:{ ClassNotFoundException -> 0x0164, Exception -> 0x015c }
        r4 = new java.lang.Object[r9];	 Catch:{ ClassNotFoundException -> 0x0164, Exception -> 0x015c }
        r5 = 0;	 Catch:{ ClassNotFoundException -> 0x0164, Exception -> 0x015c }
        r4[r5] = r19;	 Catch:{ ClassNotFoundException -> 0x0164, Exception -> 0x015c }
        r4[r16] = r21;	 Catch:{ ClassNotFoundException -> 0x0164, Exception -> 0x015c }
        r4[r10] = r12;	 Catch:{ ClassNotFoundException -> 0x0164, Exception -> 0x015c }
        r2 = r2.newInstance(r4);	 Catch:{ ClassNotFoundException -> 0x0164, Exception -> 0x015c }
        r2 = (com.google.android.exoplayer2.Renderer) r2;	 Catch:{ ClassNotFoundException -> 0x0164, Exception -> 0x015c }
        r11.add(r3, r2);	 Catch:{ ClassNotFoundException -> 0x0164, Exception -> 0x015c }
        r2 = "DefaultRenderersFactory";	 Catch:{ ClassNotFoundException -> 0x0164, Exception -> 0x015c }
        r3 = "Loaded FfmpegAudioRenderer.";	 Catch:{ ClassNotFoundException -> 0x0164, Exception -> 0x015c }
        android.util.Log.i(r2, r3);	 Catch:{ ClassNotFoundException -> 0x0164, Exception -> 0x015c }
        goto L_0x0164;
    L_0x015c:
        r0 = move-exception;
        r2 = r0;
        r3 = new java.lang.RuntimeException;
        r3.<init>(r2);
        throw r3;
    L_0x0164:
        r2 = r19.getLooper();
        r3 = new com.google.android.exoplayer2.text.TextRenderer;
        r4 = r22;
        r3.<init>(r4, r2);
        r11.add(r3);
        r2 = r19.getLooper();
        r3 = new com.google.android.exoplayer2.metadata.MetadataRenderer;
        r4 = r23;
        r3.<init>(r4, r2);
        r11.add(r3);
        r2 = r11.size();
        r2 = new com.google.android.exoplayer2.Renderer[r2];
        r2 = r11.toArray(r2);
        r2 = (com.google.android.exoplayer2.Renderer[]) r2;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.DefaultRenderersFactory.a(android.os.Handler, com.google.android.exoplayer2.video.VideoRendererEventListener, com.google.android.exoplayer2.audio.AudioRendererEventListener, com.google.android.exoplayer2.text.TextRenderer$Output, com.google.android.exoplayer2.metadata.MetadataRenderer$Output):com.google.android.exoplayer2.Renderer[]");
    }
}
