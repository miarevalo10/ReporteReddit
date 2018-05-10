package com.google.android.exoplayer2.trackselection;

import android.graphics.Point;
import android.text.TextUtils;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection.Factory;
import com.google.android.exoplayer2.util.Util;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class DefaultTrackSelector extends MappingTrackSelector {
    private static final int[] f17047c = new int[0];
    private final Factory f17048d;
    private final AtomicReference<Parameters> f17049e;

    private static final class AudioConfigurationTuple {
        public final int f5123a;
        public final int f5124b;
        public final String f5125c;

        public AudioConfigurationTuple(int i, int i2, String str) {
            this.f5123a = i;
            this.f5124b = i2;
            this.f5125c = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    AudioConfigurationTuple audioConfigurationTuple = (AudioConfigurationTuple) obj;
                    return this.f5123a == audioConfigurationTuple.f5123a && this.f5124b == audioConfigurationTuple.f5124b && TextUtils.equals(this.f5125c, audioConfigurationTuple.f5125c) != null;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (31 * ((this.f5123a * 31) + this.f5124b)) + (this.f5125c != null ? this.f5125c.hashCode() : 0);
        }
    }

    public static final class Parameters {
        public final String f5126a;
        public final String f5127b;
        public final int f5128c;
        public final int f5129d;
        public final int f5130e;
        public final boolean f5131f;
        public final int f5132g;
        public final int f5133h;
        public final boolean f5134i;
        public final boolean f5135j;
        public final boolean f5136k;
        public final boolean f5137l;

        public Parameters() {
            this((byte) 0);
        }

        private Parameters(byte b) {
            this.f5126a = null;
            this.f5127b = null;
            this.f5135j = false;
            this.f5136k = true;
            this.f5128c = RedditJobManager.f10810d;
            this.f5129d = RedditJobManager.f10810d;
            this.f5130e = RedditJobManager.f10810d;
            this.f5131f = true;
            this.f5137l = true;
            this.f5132g = RedditJobManager.f10810d;
            this.f5133h = RedditJobManager.f10810d;
            this.f5134i = true;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    Parameters parameters = (Parameters) obj;
                    return this.f5135j == parameters.f5135j && this.f5136k == parameters.f5136k && this.f5128c == parameters.f5128c && this.f5129d == parameters.f5129d && this.f5131f == parameters.f5131f && this.f5137l == parameters.f5137l && this.f5134i == parameters.f5134i && this.f5132g == parameters.f5132g && this.f5133h == parameters.f5133h && this.f5130e == parameters.f5130e && TextUtils.equals(this.f5126a, parameters.f5126a) && TextUtils.equals(this.f5127b, parameters.f5127b) != null;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (31 * ((((((((((((((((((((this.f5126a.hashCode() * 31) + this.f5127b.hashCode()) * 31) + this.f5135j) * 31) + this.f5136k) * 31) + this.f5128c) * 31) + this.f5129d) * 31) + this.f5130e) * 31) + this.f5131f) * 31) + this.f5137l) * 31) + this.f5134i) * 31) + this.f5132g)) + this.f5133h;
        }
    }

    private static int m17355a(int i, int i2) {
        return i == -1 ? i2 == -1 ? 0 : -1 : i2 == -1 ? 1 : i - i2;
    }

    private static boolean m17361a(int i, boolean z) {
        i &= 7;
        if (i != 4) {
            if (!z || i != 3) {
                return false;
            }
        }
        return true;
    }

    public DefaultTrackSelector() {
        this(null);
    }

    public DefaultTrackSelector(Factory factory) {
        this.f17048d = factory;
        this.f17049e = new AtomicReference(new Parameters());
    }

    protected final TrackSelection[] mo3382a(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray[] trackGroupArrayArr, int[][][] iArr) throws ExoPlaybackException {
        int i;
        int i2;
        TrackSelection[] trackSelectionArr;
        DefaultTrackSelector defaultTrackSelector;
        RendererCapabilities[] rendererCapabilitiesArr2 = rendererCapabilitiesArr;
        int length = rendererCapabilitiesArr2.length;
        TrackSelection[] trackSelectionArr2 = new TrackSelection[length];
        Parameters parameters = (Parameters) this.f17049e.get();
        int i3 = 0;
        Object obj = null;
        int i4 = 0;
        while (i3 < length) {
            DefaultTrackSelector defaultTrackSelector2;
            int i5;
            int i6;
            if (2 == rendererCapabilitiesArr2[i3].mo3310a()) {
                if (obj == null) {
                    TrackSelection a;
                    RendererCapabilities rendererCapabilities = rendererCapabilitiesArr2[i3];
                    TrackGroupArray trackGroupArray = trackGroupArrayArr[i3];
                    int[][] iArr2 = iArr[i3];
                    Factory factory = defaultTrackSelector2.f17048d;
                    if (factory != null) {
                        int i7 = parameters.f5136k ? 24 : 16;
                        obj = (!parameters.f5135j || (rendererCapabilities.mo3327m() & i7) == 0) ? null : 1;
                        int i8 = 0;
                        while (i8 < trackGroupArray.f4786b) {
                            int[] iArr3;
                            Object obj2;
                            TrackGroup trackGroup = trackGroupArray.f4787c[i8];
                            int[] iArr4 = iArr2[i8];
                            int i9 = parameters.f5128c;
                            int i10 = parameters.f5129d;
                            i = parameters.f5130e;
                            i5 = length;
                            length = parameters.f5132g;
                            i2 = i4;
                            i4 = parameters.f5133h;
                            boolean z = parameters.f5134i;
                            trackSelectionArr = trackSelectionArr2;
                            i6 = i3;
                            if (trackGroup.f4782a < 2) {
                                iArr3 = f17047c;
                                i = 2;
                                obj2 = obj;
                            } else {
                                List a2 = m17360a(trackGroup, length, i4, z);
                                if (a2.size() < 2) {
                                    iArr3 = f17047c;
                                    obj2 = obj;
                                } else {
                                    String str;
                                    if (obj == null) {
                                        HashSet hashSet = new HashSet();
                                        int i11 = 0;
                                        i4 = 0;
                                        String str2 = null;
                                        while (i11 < a2.size()) {
                                            obj2 = obj;
                                            String str3 = trackGroup.f4783b[((Integer) a2.get(i11)).intValue()].f4018f;
                                            if (hashSet.add(str3)) {
                                                int a3 = m17356a(trackGroup, iArr4, i7, str3, i9, i10, i, a2);
                                                if (a3 > i4) {
                                                    str2 = str3;
                                                    i4 = a3;
                                                }
                                            }
                                            i11++;
                                            obj = obj2;
                                        }
                                        obj2 = obj;
                                        str = str2;
                                    } else {
                                        obj2 = obj;
                                        str = null;
                                    }
                                    m17366b(trackGroup, iArr4, i7, str, i9, i10, i, a2);
                                    iArr3 = a2.size() < 2 ? f17047c : Util.m4314a(a2);
                                }
                            }
                            if (iArr3.length > 0) {
                                a = factory.mo1454a(trackGroup, iArr3);
                                break;
                            }
                            i8++;
                            length = i5;
                            i4 = i2;
                            trackSelectionArr2 = trackSelectionArr;
                            i3 = i6;
                            obj = obj2;
                            defaultTrackSelector2 = this;
                            rendererCapabilitiesArr2 = rendererCapabilitiesArr;
                        }
                    }
                    i5 = length;
                    trackSelectionArr = trackSelectionArr2;
                    i6 = i3;
                    i2 = i4;
                    a = null;
                    if (a == null) {
                        a = m17358a(trackGroupArray, iArr2, parameters);
                    }
                    trackSelectionArr[i6] = a;
                    obj = trackSelectionArr[i6] != null ? 1 : null;
                } else {
                    i5 = length;
                    trackSelectionArr = trackSelectionArr2;
                    i6 = i3;
                    i2 = i4;
                }
                i4 = i2 | (trackGroupArrayArr[i6].f4786b > 0 ? 1 : 0);
            } else {
                i5 = length;
                trackSelectionArr = trackSelectionArr2;
                i6 = i3;
                i2 = i4;
            }
            i3 = i6 + 1;
            length = i5;
            trackSelectionArr2 = trackSelectionArr;
            defaultTrackSelector2 = this;
            rendererCapabilitiesArr2 = rendererCapabilitiesArr;
        }
        trackSelectionArr = trackSelectionArr2;
        i2 = i4;
        i = length;
        Object obj3 = null;
        Object obj4 = null;
        for (int i12 = 0; i12 < i; i12++) {
            switch (rendererCapabilitiesArr[i12].mo3310a()) {
                case 1:
                    if (obj3 == null) {
                        Factory factory2;
                        TrackGroupArray trackGroupArray2 = trackGroupArrayArr[i12];
                        int[][] iArr5 = iArr[i12];
                        if (i2 != 0) {
                            defaultTrackSelector = this;
                            factory2 = null;
                        } else {
                            factory2 = this.f17048d;
                        }
                        trackSelectionArr[i12] = m17359a(trackGroupArray2, iArr5, parameters, factory2);
                        if (trackSelectionArr[i12] != null) {
                            obj3 = 1;
                            break;
                        }
                        obj3 = null;
                        continue;
                    }
                case 2:
                    defaultTrackSelector = this;
                    break;
                case 3:
                    if (obj4 == null) {
                        trackSelectionArr[i12] = m17365b(trackGroupArrayArr[i12], iArr[i12], parameters);
                        obj4 = trackSelectionArr[i12] != null ? 1 : null;
                    }
                    defaultTrackSelector = this;
                    break;
                default:
                    defaultTrackSelector = this;
                    trackSelectionArr[i12] = m17367c(trackGroupArrayArr[i12], iArr[i12], parameters);
                    continue;
            }
            defaultTrackSelector = this;
        }
        defaultTrackSelector = this;
        return trackSelectionArr;
    }

    private static int m17356a(TrackGroup trackGroup, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        int i5 = 0;
        int i6 = 0;
        while (i5 < list.size()) {
            int intValue = ((Integer) list.get(i5)).intValue();
            if (m17364a(trackGroup.f4783b[intValue], str, iArr[intValue], i, i2, i3, i4)) {
                i6++;
            }
            i5++;
        }
        return i6;
    }

    private static void m17366b(TrackGroup trackGroup, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        List<Integer> list2 = list;
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = ((Integer) list2.get(size)).intValue();
            if (!m17364a(trackGroup.f4783b[intValue], str, iArr[intValue], i, i2, i3, i4)) {
                list2.remove(size);
            }
        }
    }

    private static boolean m17364a(Format format, String str, int i, int i2, int i3, int i4, int i5) {
        if (!m17361a(i, false) || (i & i2) == 0 || ((str != null && Util.m4313a(format.f4018f, (Object) str) == null) || ((format.f4022j != -1 && format.f4022j > i3) || ((format.f4023k != -1 && format.f4023k > i4) || (format.f4014b != -1 && format.f4014b > i5))))) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.trackselection.TrackSelection m17358a(com.google.android.exoplayer2.source.TrackGroupArray r19, int[][] r20, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters r21) {
        /*
        r0 = r19;
        r1 = r21;
        r3 = -1;
        r9 = r3;
        r10 = r9;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
    L_0x000b:
        r11 = r0.f4786b;
        if (r5 >= r11) goto L_0x00cc;
    L_0x000f:
        r11 = r0.f4787c;
        r11 = r11[r5];
        r12 = r1.f5132g;
        r13 = r1.f5133h;
        r14 = r1.f5134i;
        r12 = m17360a(r11, r12, r13, r14);
        r14 = r20[r5];
        r15 = r10;
        r10 = r9;
        r9 = r8;
        r8 = r7;
        r7 = r6;
        r6 = 0;
    L_0x0025:
        r2 = r11.f4782a;
        if (r6 >= r2) goto L_0x00be;
    L_0x0029:
        r2 = r14[r6];
        r4 = r1.f5137l;
        r2 = m17361a(r2, r4);
        if (r2 == 0) goto L_0x00b5;
    L_0x0033:
        r2 = r11.f4783b;
        r2 = r2[r6];
        r4 = java.lang.Integer.valueOf(r6);
        r4 = r12.contains(r4);
        r17 = 1;
        if (r4 == 0) goto L_0x0066;
    L_0x0043:
        r4 = r2.f4022j;
        if (r4 == r3) goto L_0x004d;
    L_0x0047:
        r4 = r2.f4022j;
        r3 = r1.f5128c;
        if (r4 > r3) goto L_0x0066;
    L_0x004d:
        r3 = r2.f4023k;
        r4 = -1;
        if (r3 == r4) goto L_0x0058;
    L_0x0052:
        r3 = r2.f4023k;
        r4 = r1.f5129d;
        if (r3 > r4) goto L_0x0066;
    L_0x0058:
        r3 = r2.f4014b;
        r4 = -1;
        if (r3 == r4) goto L_0x0063;
    L_0x005d:
        r3 = r2.f4014b;
        r4 = r1.f5130e;
        if (r3 > r4) goto L_0x0066;
    L_0x0063:
        r3 = r17;
        goto L_0x0067;
    L_0x0066:
        r3 = 0;
    L_0x0067:
        if (r3 != 0) goto L_0x006d;
    L_0x0069:
        r4 = r1.f5131f;
        if (r4 == 0) goto L_0x00b5;
    L_0x006d:
        if (r3 == 0) goto L_0x0071;
    L_0x006f:
        r4 = 2;
        goto L_0x0073;
    L_0x0071:
        r4 = r17;
    L_0x0073:
        r0 = r14[r6];
        r1 = 0;
        r0 = m17361a(r0, r1);
        if (r0 == 0) goto L_0x007e;
    L_0x007c:
        r4 = r4 + 1000;
    L_0x007e:
        if (r4 <= r9) goto L_0x0083;
    L_0x0080:
        r16 = r17;
        goto L_0x0085;
    L_0x0083:
        r16 = r1;
    L_0x0085:
        if (r4 != r9) goto L_0x00aa;
    L_0x0087:
        r1 = r2.m3574a();
        if (r1 == r10) goto L_0x0096;
    L_0x008d:
        r1 = r2.m3574a();
        r1 = m17355a(r1, r10);
        goto L_0x009c;
    L_0x0096:
        r1 = r2.f4014b;
        r1 = m17355a(r1, r15);
    L_0x009c:
        if (r0 == 0) goto L_0x00a3;
    L_0x009e:
        if (r3 == 0) goto L_0x00a3;
    L_0x00a0:
        if (r1 <= 0) goto L_0x00a8;
    L_0x00a2:
        goto L_0x00a5;
    L_0x00a3:
        if (r1 >= 0) goto L_0x00a8;
    L_0x00a5:
        r16 = r17;
        goto L_0x00aa;
    L_0x00a8:
        r16 = 0;
    L_0x00aa:
        if (r16 == 0) goto L_0x00b5;
    L_0x00ac:
        r15 = r2.f4014b;
        r10 = r2.m3574a();
        r9 = r4;
        r8 = r6;
        r7 = r11;
    L_0x00b5:
        r6 = r6 + 1;
        r0 = r19;
        r1 = r21;
        r3 = -1;
        goto L_0x0025;
    L_0x00be:
        r5 = r5 + 1;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r15;
        r0 = r19;
        r1 = r21;
        r3 = -1;
        goto L_0x000b;
    L_0x00cc:
        if (r6 != 0) goto L_0x00d0;
    L_0x00ce:
        r0 = 0;
        return r0;
    L_0x00d0:
        r0 = new com.google.android.exoplayer2.trackselection.FixedTrackSelection;
        r0.<init>(r6, r7);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.a(com.google.android.exoplayer2.source.TrackGroupArray, int[][], com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters):com.google.android.exoplayer2.trackselection.TrackSelection");
    }

    private static TrackSelection m17359a(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters, Factory factory) throws ExoPlaybackException {
        int i;
        int i2;
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        Parameters parameters2 = parameters;
        Factory factory2 = factory;
        int i3 = 0;
        int i4 = -1;
        int i5 = -1;
        int i6 = 0;
        while (i3 < trackGroupArray2.f4786b) {
            TrackGroup trackGroup = trackGroupArray2.f4787c[i3];
            int[] iArr2 = iArr[i3];
            int i7 = i6;
            i6 = i5;
            i5 = i4;
            for (i4 = 0; i4 < trackGroup.f4782a; i4++) {
                if (m17361a(iArr2[i4], parameters2.f5137l)) {
                    Format format = trackGroup.f4783b[i4];
                    int i8 = iArr2[i4];
                    String str = parameters2.f5126a;
                    i = (format.f4036x & 1) != 0 ? 1 : 0;
                    i2 = m17363a(format, str) ? i != 0 ? 4 : 3 : i != 0 ? 2 : 1;
                    if (m17361a(i8, false)) {
                        i2 += 1000;
                    }
                    if (i2 > i7) {
                        i7 = i2;
                        i5 = i3;
                        i6 = i4;
                    }
                }
            }
            i3++;
            i4 = i5;
            i5 = i6;
            i6 = i7;
        }
        i = 0;
        if (i4 == -1) {
            return null;
        }
        TrackGroup trackGroup2 = trackGroupArray2.f4787c[i4];
        if (factory2 != null) {
            int[] iArr3;
            int[] iArr4 = iArr[i4];
            boolean z = parameters2.f5135j;
            HashSet hashSet = new HashSet();
            AudioConfigurationTuple audioConfigurationTuple = null;
            i4 = 0;
            i6 = i4;
            while (i4 < trackGroup2.f4782a) {
                Format format2 = trackGroup2.f4783b[i4];
                AudioConfigurationTuple audioConfigurationTuple2 = new AudioConfigurationTuple(format2.f4030r, format2.f4031s, z ? null : format2.f4018f);
                if (hashSet.add(audioConfigurationTuple2)) {
                    int a = m17357a(trackGroup2, iArr4, audioConfigurationTuple2);
                    if (a > i6) {
                        i6 = a;
                        audioConfigurationTuple = audioConfigurationTuple2;
                    }
                }
                i4++;
            }
            if (i6 > 1) {
                iArr3 = new int[i6];
                i2 = 0;
                while (i < trackGroup2.f4782a) {
                    if (m17362a(trackGroup2.f4783b[i], iArr4[i], audioConfigurationTuple)) {
                        i3 = i2 + 1;
                        iArr3[i2] = i;
                        i2 = i3;
                    }
                    i++;
                }
            } else {
                iArr3 = f17047c;
            }
            if (iArr3.length > 0) {
                return factory2.mo1454a(trackGroup2, iArr3);
            }
        }
        return new FixedTrackSelection(trackGroup2, i5);
    }

    private static int m17357a(TrackGroup trackGroup, int[] iArr, AudioConfigurationTuple audioConfigurationTuple) {
        int i = 0;
        int i2 = 0;
        while (i < trackGroup.f4782a) {
            if (m17362a(trackGroup.f4783b[i], iArr[i], audioConfigurationTuple)) {
                i2++;
            }
            i++;
        }
        return i2;
    }

    private static boolean m17362a(Format format, int i, AudioConfigurationTuple audioConfigurationTuple) {
        if (m17361a(i, false) == 0 || format.f4030r != audioConfigurationTuple.f5123a || format.f4031s != audioConfigurationTuple.f5124b || (audioConfigurationTuple.f5125c != 0 && TextUtils.equals(audioConfigurationTuple.f5125c, format.f4018f) == null)) {
            return false;
        }
        return true;
    }

    private static TrackSelection m17365b(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) throws ExoPlaybackException {
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        Parameters parameters2 = parameters;
        TrackGroup trackGroup = null;
        int i = 0;
        int i2 = i;
        int i3 = i2;
        while (i < trackGroupArray2.f4786b) {
            TrackGroup trackGroup2 = trackGroupArray2.f4787c[i];
            int[] iArr2 = iArr[i];
            int i4 = i3;
            TrackGroup trackGroup3 = trackGroup;
            for (int i5 = 0; i5 < trackGroup2.f4782a; i5++) {
                if (m17361a(iArr2[i5], parameters2.f5137l)) {
                    int i6;
                    Format format = trackGroup2.f4783b[i5];
                    int i7 = (format.f4036x & 1) != 0 ? 1 : false;
                    int i8 = (format.f4036x & 2) != 0 ? 1 : false;
                    if (m17363a(format, parameters2.f5127b)) {
                        i6 = i7 != 0 ? 6 : i8 == 0 ? 5 : 4;
                    } else if (i7 != 0) {
                        i6 = 3;
                    } else if (i8 != 0) {
                        i6 = m17363a(format, parameters2.f5126a) ? 2 : 1;
                    }
                    if (m17361a(iArr2[i5], false)) {
                        i6 += 1000;
                    }
                    if (i6 > i4) {
                        i2 = i5;
                        trackGroup3 = trackGroup2;
                        i4 = i6;
                    }
                }
            }
            i++;
            trackGroup = trackGroup3;
            i3 = i4;
        }
        if (trackGroup == null) {
            return null;
        }
        return new FixedTrackSelection(trackGroup, i2);
    }

    private static TrackSelection m17367c(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) throws ExoPlaybackException {
        TrackGroup trackGroup = null;
        int i = 0;
        int i2 = i;
        int i3 = i2;
        while (i < trackGroupArray.f4786b) {
            TrackGroup trackGroup2 = trackGroupArray.f4787c[i];
            int[] iArr2 = iArr[i];
            int i4 = i3;
            i3 = i2;
            TrackGroup trackGroup3 = trackGroup;
            for (int i5 = 0; i5 < trackGroup2.f4782a; i5++) {
                if (m17361a(iArr2[i5], parameters.f5137l)) {
                    int i6 = 1;
                    if (((trackGroup2.f4783b[i5].f4036x & 1) != 0 ? 1 : false) != 0) {
                        i6 = 2;
                    }
                    if (m17361a(iArr2[i5], false)) {
                        i6 += 1000;
                    }
                    if (i6 > i4) {
                        i3 = i5;
                        trackGroup3 = trackGroup2;
                        i4 = i6;
                    }
                }
            }
            i++;
            trackGroup = trackGroup3;
            i2 = i3;
            i3 = i4;
        }
        if (trackGroup == null) {
            return null;
        }
        return new FixedTrackSelection(trackGroup, i2);
    }

    private static boolean m17363a(Format format, String str) {
        return (str == null || TextUtils.equals(str, Util.m4319b(format.f4037y)) == null) ? null : true;
    }

    private static List<Integer> m17360a(TrackGroup trackGroup, int i, int i2, boolean z) {
        List<Integer> arrayList = new ArrayList(trackGroup.f4782a);
        for (int i3 = 0; i3 < trackGroup.f4782a; i3++) {
            arrayList.add(Integer.valueOf(i3));
        }
        if (i != RedditJobManager.f10810d) {
            if (i2 != RedditJobManager.f10810d) {
                int i4 = 0;
                boolean z2 = true;
                while (true) {
                    int i5 = 1;
                    if (i4 >= trackGroup.f4782a) {
                        break;
                    }
                    Format format = trackGroup.f4783b[i4];
                    if (format.f4022j > 0 && format.f4023k > 0) {
                        int i6;
                        int i7;
                        int i8;
                        Point point;
                        boolean z3;
                        int i9 = format.f4022j;
                        int i10 = format.f4023k;
                        if (z) {
                            i6 = i9 > i10 ? 1 : 0;
                            if (i <= i2) {
                                i5 = 0;
                            }
                            if (i6 != i5) {
                                i5 = i;
                                i6 = i2;
                                i7 = i9 * i5;
                                i8 = i10 * i6;
                                if (i7 < i8) {
                                    point = new Point(i6, Util.m4296a(i8, i9));
                                } else {
                                    point = new Point(Util.m4296a(i7, i10), i5);
                                }
                                z3 = format.f4022j * format.f4023k;
                                if (format.f4022j >= ((int) (((float) point.x) * 0.98f)) && format.f4023k >= ((int) (((float) point.y) * 0.98f)) && z3 < z2) {
                                    z2 = z3;
                                }
                            }
                        }
                        i6 = i;
                        i5 = i2;
                        i7 = i9 * i5;
                        i8 = i10 * i6;
                        if (i7 < i8) {
                            point = new Point(Util.m4296a(i7, i10), i5);
                        } else {
                            point = new Point(i6, Util.m4296a(i8, i9));
                        }
                        z3 = format.f4022j * format.f4023k;
                        z2 = z3;
                    }
                    i4++;
                }
                if (!z2) {
                    for (i = arrayList.size() - 1; i >= 0; i--) {
                        boolean a = trackGroup.f4783b[((Integer) arrayList.get(i)).intValue()].m3574a();
                        if (a || a > z2) {
                            arrayList.remove(i);
                        }
                    }
                }
                return arrayList;
            }
        }
        return arrayList;
    }
}
