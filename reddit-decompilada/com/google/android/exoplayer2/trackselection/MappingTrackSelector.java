package com.google.android.exoplayer2.trackselection;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection.Factory;
import java.util.Arrays;
import java.util.Map;

public abstract class MappingTrackSelector extends TrackSelector {
    public MappedTrackInfo f13589a;
    private final SparseArray<Map<TrackGroupArray, SelectionOverride>> f13590c = new SparseArray();
    private final SparseBooleanArray f13591d = new SparseBooleanArray();
    private int f13592e = 0;

    public static final class MappedTrackInfo {
        public final int f5138a;
        public final TrackGroupArray[] f5139b;
        public final int[] f5140c;
        public final int[][][] f5141d;
        public final TrackGroupArray f5142e;
        private final int[] f5143f;

        MappedTrackInfo(int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            this.f5143f = iArr;
            this.f5139b = trackGroupArrayArr;
            this.f5141d = iArr3;
            this.f5140c = iArr2;
            this.f5142e = trackGroupArray;
            this.f5138a = trackGroupArrayArr.length;
        }

        public final int m4118a(int i, int i2, int i3) {
            return this.f5141d[i][i2][i3] & 7;
        }
    }

    public static final class SelectionOverride {
        public final Factory f5144a;
        public final int f5145b;
        public final int[] f5146c;
    }

    protected abstract TrackSelection[] mo3382a(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray[] trackGroupArrayArr, int[][][] iArr) throws ExoPlaybackException;

    public final TrackSelectorResult mo1464a(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray) throws ExoPlaybackException {
        int i;
        int i2;
        MappingTrackSelector mappingTrackSelector = this;
        RendererCapabilities[] rendererCapabilitiesArr2 = rendererCapabilitiesArr;
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        int i3 = 1;
        int[] iArr = new int[(rendererCapabilitiesArr2.length + 1)];
        TrackGroup[][] trackGroupArr = new TrackGroup[(rendererCapabilitiesArr2.length + 1)][];
        int[][][] iArr2 = new int[(rendererCapabilitiesArr2.length + 1)][][];
        for (i = 0; i < trackGroupArr.length; i++) {
            trackGroupArr[i] = new TrackGroup[trackGroupArray2.f4786b];
            iArr2[i] = new int[trackGroupArray2.f4786b][];
        }
        int[] iArr3 = new int[rendererCapabilitiesArr2.length];
        for (i = 0; i < iArr3.length; i++) {
            iArr3[i] = rendererCapabilitiesArr2[i].mo3327m();
        }
        for (i = 0; i < trackGroupArray2.f4786b; i++) {
            int[] iArr4;
            TrackGroup trackGroup = trackGroupArray2.f4787c[i];
            int length = rendererCapabilitiesArr2.length;
            int i4 = 0;
            int i5 = 0;
            while (i4 < rendererCapabilitiesArr2.length) {
                RendererCapabilities rendererCapabilities = rendererCapabilitiesArr2[i4];
                int i6 = length;
                for (length = 0; length < trackGroup.f4782a; length++) {
                    int a = rendererCapabilities.mo3912a(trackGroup.f4783b[length]) & 7;
                    if (a > i5) {
                        if (a == 4) {
                            length = i4;
                            break;
                        }
                        i5 = a;
                        i6 = i4;
                    }
                }
                i4++;
                length = i6;
            }
            if (length == rendererCapabilitiesArr2.length) {
                iArr4 = new int[trackGroup.f4782a];
            } else {
                RendererCapabilities rendererCapabilities2 = rendererCapabilitiesArr2[length];
                int[] iArr5 = new int[trackGroup.f4782a];
                for (i5 = 0; i5 < trackGroup.f4782a; i5++) {
                    iArr5[i5] = rendererCapabilities2.mo3912a(trackGroup.f4783b[i5]);
                }
                iArr4 = iArr5;
            }
            i4 = iArr[length];
            trackGroupArr[length][i4] = trackGroup;
            iArr2[length][i4] = iArr4;
            iArr[length] = iArr[length] + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[rendererCapabilitiesArr2.length];
        int[] iArr6 = new int[rendererCapabilitiesArr2.length];
        for (i = 0; i < rendererCapabilitiesArr2.length; i++) {
            i4 = iArr[i];
            trackGroupArrayArr[i] = new TrackGroupArray((TrackGroup[]) Arrays.copyOf(trackGroupArr[i], i4));
            iArr2[i] = (int[][]) Arrays.copyOf(iArr2[i], i4);
            iArr6[i] = rendererCapabilitiesArr2[i].mo3310a();
        }
        TrackGroupArray trackGroupArray3 = new TrackGroupArray((TrackGroup[]) Arrays.copyOf(trackGroupArr[rendererCapabilitiesArr2.length], iArr[rendererCapabilitiesArr2.length]));
        TrackSelection[] a2 = mo3382a(rendererCapabilitiesArr2, trackGroupArrayArr, iArr2);
        int i7 = 0;
        while (true) {
            TrackSelection trackSelection = null;
            if (i7 >= rendererCapabilitiesArr2.length) {
                break;
            }
            if (!mappingTrackSelector.f13591d.get(i7)) {
                TrackGroupArray trackGroupArray4 = trackGroupArrayArr[i7];
                Map map = (Map) mappingTrackSelector.f13590c.get(i7);
                i4 = (map == null || !map.containsKey(trackGroupArray4)) ? 0 : 1;
                if (i4 != 0) {
                    SelectionOverride selectionOverride = (SelectionOverride) ((Map) mappingTrackSelector.f13590c.get(i7)).get(trackGroupArray4);
                    if (selectionOverride != null) {
                        trackSelection = selectionOverride.f5144a.mo1454a(trackGroupArray4.f4787c[selectionOverride.f5145b], selectionOverride.f5146c);
                    }
                } else {
                    i7++;
                }
            }
            a2[i7] = trackSelection;
            i7++;
        }
        MappedTrackInfo mappedTrackInfo = new MappedTrackInfo(iArr6, trackGroupArrayArr, iArr3, iArr2, trackGroupArray3);
        RendererConfiguration[] rendererConfigurationArr = new RendererConfiguration[rendererCapabilitiesArr2.length];
        for (i2 = 0; i2 < rendererCapabilitiesArr2.length; i2++) {
            rendererConfigurationArr[i2] = a2[i2] != null ? RendererConfiguration.f4058a : null;
        }
        i2 = mappingTrackSelector.f13592e;
        if (i2 != 0) {
            int i8;
            int i9;
            int i10 = 0;
            length = -1;
            i5 = -1;
            while (i10 < rendererCapabilitiesArr2.length) {
                int a3 = rendererCapabilitiesArr2[i10].mo3310a();
                TrackSelection trackSelection2 = a2[i10];
                if (a3 != i3) {
                    if (a3 == 2) {
                    }
                    i8 = i3;
                    i10++;
                    i3 = i8;
                    mappingTrackSelector = this;
                    rendererCapabilitiesArr2 = rendererCapabilitiesArr;
                }
                if (trackSelection2 != null) {
                    Object obj;
                    int[][] iArr7 = iArr2[i10];
                    TrackGroupArray trackGroupArray5 = trackGroupArrayArr[i10];
                    if (trackSelection2 != null) {
                        i8 = trackGroupArray5.m3975a(trackSelection2.mo1459d());
                        i3 = 0;
                        while (i3 < trackSelection2.mo1461e()) {
                            int i11 = i8;
                            if ((iArr7[i8][trackSelection2.mo1457b(i3)] & 32) == 32) {
                                i3++;
                                i8 = i11;
                            }
                        }
                        obj = 1;
                        if (obj != null) {
                            i8 = 1;
                            if (a3 != 1) {
                                i9 = -1;
                                if (length != -1) {
                                    length = i10;
                                    i10++;
                                    i3 = i8;
                                    mappingTrackSelector = this;
                                    rendererCapabilitiesArr2 = rendererCapabilitiesArr;
                                }
                            } else {
                                i9 = -1;
                                if (i5 != -1) {
                                    i5 = i10;
                                    i10++;
                                    i3 = i8;
                                    mappingTrackSelector = this;
                                    rendererCapabilitiesArr2 = rendererCapabilitiesArr;
                                }
                            }
                            a = 0;
                            break;
                        }
                        i8 = 1;
                        i10++;
                        i3 = i8;
                        mappingTrackSelector = this;
                        rendererCapabilitiesArr2 = rendererCapabilitiesArr;
                    }
                    obj = null;
                    if (obj != null) {
                        i8 = 1;
                        if (a3 != 1) {
                            i9 = -1;
                            if (i5 != -1) {
                                i5 = i10;
                                i10++;
                                i3 = i8;
                                mappingTrackSelector = this;
                                rendererCapabilitiesArr2 = rendererCapabilitiesArr;
                            }
                        } else {
                            i9 = -1;
                            if (length != -1) {
                                length = i10;
                                i10++;
                                i3 = i8;
                                mappingTrackSelector = this;
                                rendererCapabilitiesArr2 = rendererCapabilitiesArr;
                            }
                        }
                        a = 0;
                        break;
                    }
                    i8 = 1;
                    i10++;
                    i3 = i8;
                    mappingTrackSelector = this;
                    rendererCapabilitiesArr2 = rendererCapabilitiesArr;
                }
                i8 = i3;
                i10++;
                i3 = i8;
                mappingTrackSelector = this;
                rendererCapabilitiesArr2 = rendererCapabilitiesArr;
            }
            i8 = i3;
            i9 = -1;
            a = i8;
            int i12 = (length == i9 || i5 == i9) ? 0 : i8;
            if ((a & i12) != 0) {
                RendererConfiguration rendererConfiguration = new RendererConfiguration(i2);
                rendererConfigurationArr[length] = rendererConfiguration;
                rendererConfigurationArr[i5] = rendererConfiguration;
            }
        }
        return new TrackSelectorResult(trackGroupArray2, new TrackSelectionArray(a2), mappedTrackInfo, rendererConfigurationArr);
    }

    public final void mo1465a(Object obj) {
        this.f13589a = (MappedTrackInfo) obj;
    }
}
