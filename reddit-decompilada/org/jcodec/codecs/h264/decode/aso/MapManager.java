package org.jcodec.codecs.h264.decode.aso;

import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.h264.io.model.PictureParameterSet;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.codecs.h264.io.model.SliceHeader;

public class MapManager {
    private MBToSliceGroupMap mbToSliceGroupMap;
    private PictureParameterSet pps;
    private int prevSliceGroupChangeCycle;
    private SeqParameterSet sps;

    public MapManager(SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet) {
        this.sps = seqParameterSet;
        this.pps = pictureParameterSet;
        this.mbToSliceGroupMap = buildMap(seqParameterSet, pictureParameterSet);
    }

    private MBToSliceGroupMap buildMap(SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet) {
        int i = pictureParameterSet.num_slice_groups_minus1 + 1;
        if (i <= 1) {
            return null;
        }
        int i2 = seqParameterSet.pic_width_in_mbs_minus1 + 1;
        seqParameterSet = H264Utils.getPicHeightInMbs(seqParameterSet);
        if (pictureParameterSet.slice_group_map_type == 0) {
            int[] iArr = new int[i];
            for (int i3 = 0; i3 < i; i3++) {
                iArr[i3] = pictureParameterSet.run_length_minus1[i3] + 1;
            }
            seqParameterSet = SliceGroupMapBuilder.buildInterleavedMap(i2, seqParameterSet, iArr);
        } else if (pictureParameterSet.slice_group_map_type == 1) {
            seqParameterSet = SliceGroupMapBuilder.buildDispersedMap(i2, seqParameterSet, i);
        } else if (pictureParameterSet.slice_group_map_type == 2) {
            seqParameterSet = SliceGroupMapBuilder.buildForegroundMap(i2, seqParameterSet, i, pictureParameterSet.top_left, pictureParameterSet.bottom_right);
        } else if (pictureParameterSet.slice_group_map_type >= 3 && pictureParameterSet.slice_group_map_type <= 5) {
            return null;
        } else {
            if (pictureParameterSet.slice_group_map_type == 6) {
                seqParameterSet = pictureParameterSet.slice_group_id;
            } else {
                throw new RuntimeException("Unsupported slice group map type");
            }
        }
        return buildMapIndices(seqParameterSet, i);
    }

    private MBToSliceGroupMap buildMapIndices(int[] iArr, int i) {
        int[] iArr2 = new int[i];
        int i2 = 0;
        int[] iArr3 = new int[iArr.length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int i4 = iArr[i3];
            int i5 = iArr2[i4];
            iArr2[i4] = i5 + 1;
            iArr3[i3] = i5;
        }
        int[][] iArr4 = new int[i][];
        for (i4 = 0; i4 < i; i4++) {
            iArr4[i4] = new int[iArr2[i4]];
        }
        i = new int[i];
        while (i2 < iArr.length) {
            int i6 = iArr[i2];
            int[] iArr5 = iArr4[i6];
            i5 = i[i6];
            i[i6] = i5 + 1;
            iArr5[i5] = i2;
            i2++;
        }
        return new MBToSliceGroupMap(iArr, iArr3, iArr4);
    }

    private void updateMap(SliceHeader sliceHeader) {
        int i = this.pps.slice_group_map_type;
        int i2 = this.pps.num_slice_groups_minus1 + 1;
        if (i2 > 1 && i >= 3 && i <= 5) {
            if (sliceHeader.slice_group_change_cycle != this.prevSliceGroupChangeCycle || this.mbToSliceGroupMap == null) {
                this.prevSliceGroupChangeCycle = sliceHeader.slice_group_change_cycle;
                int i3 = this.sps.pic_width_in_mbs_minus1 + 1;
                int picHeightInMbs = H264Utils.getPicHeightInMbs(this.sps);
                int i4 = i3 * picHeightInMbs;
                sliceHeader = sliceHeader.slice_group_change_cycle * (this.pps.slice_group_change_rate_minus1 + 1);
                if (sliceHeader > i4) {
                    sliceHeader = i4;
                }
                int i5 = this.pps.slice_group_change_direction_flag ? i4 - sliceHeader : sliceHeader;
                if (i == 3) {
                    sliceHeader = SliceGroupMapBuilder.buildBoxOutMap(i3, picHeightInMbs, this.pps.slice_group_change_direction_flag, sliceHeader);
                } else if (i == 4) {
                    sliceHeader = SliceGroupMapBuilder.buildRasterScanMap(i3, picHeightInMbs, i5, this.pps.slice_group_change_direction_flag);
                } else {
                    sliceHeader = SliceGroupMapBuilder.buildWipeMap(i3, picHeightInMbs, i5, this.pps.slice_group_change_direction_flag);
                }
                this.mbToSliceGroupMap = buildMapIndices(sliceHeader, i2);
            }
        }
    }

    public Mapper getMapper(SliceHeader sliceHeader) {
        updateMap(sliceHeader);
        sliceHeader = sliceHeader.first_mb_in_slice;
        if (this.pps.num_slice_groups_minus1 > 0) {
            return new PrebuiltMBlockMapper(this.mbToSliceGroupMap, sliceHeader, this.sps.pic_width_in_mbs_minus1 + 1);
        }
        return new FlatMBlockMapper(this.sps.pic_width_in_mbs_minus1 + 1, sliceHeader);
    }
}
