package org.jcodec.codecs.aac.blocks;

import org.jcodec.codecs.aac.BlockType;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.VLC;

public class BlockCCE extends Block {
    static VLC vlc = new VLC(AACTab.ff_aac_scalefactor_code, AACTab.ff_aac_scalefactor_bits);
    private BandType[] bandType;
    private BlockICS blockICS;
    private Object[] cce_scale;
    private int[] ch_select;
    private int coupling_point;
    private int[] id_select;
    private int num_coupled;
    private Object scale;
    private int sign;
    private BlockType[] type;

    enum CouplingPoint {
        BEFORE_TNS,
        BETWEEN_TNS_AND_IMDCT,
        UNDEF,
        AFTER_IMDCT
    }

    public BlockCCE(BandType[] bandTypeArr) {
        this.bandType = bandTypeArr;
    }

    public void parse(BitReader bitReader) {
        this.coupling_point = bitReader.read1Bit() * 2;
        this.num_coupled = bitReader.readNBit(3);
        int i = 0;
        int i2 = i;
        while (i <= this.num_coupled) {
            i2++;
            this.type[i] = bitReader.read1Bit() != 0 ? BlockType.TYPE_CPE : BlockType.TYPE_SCE;
            this.id_select[i] = bitReader.readNBit(4);
            if (this.type[i] == BlockType.TYPE_CPE) {
                this.ch_select[i] = bitReader.readNBit(2);
                if (this.ch_select[i] == 3) {
                    i2++;
                }
            } else {
                this.ch_select[i] = 2;
            }
            i++;
        }
        this.coupling_point += bitReader.read1Bit() | (this.coupling_point >> 1);
        this.sign = bitReader.read1Bit();
        this.scale = this.cce_scale[bitReader.readNBit(2)];
        this.blockICS = new BlockICS();
        this.blockICS.parse(bitReader);
        for (int i3 = 0; i3 < i2; i3++) {
            int read1Bit;
            if (i3 != 0) {
                read1Bit = this.coupling_point == CouplingPoint.AFTER_IMDCT.ordinal() ? 1 : bitReader.read1Bit();
                if (read1Bit != 0) {
                    vlc.readVLC(bitReader);
                }
            } else {
                read1Bit = 1;
            }
            if (this.coupling_point != CouplingPoint.AFTER_IMDCT.ordinal()) {
                i = 0;
                int i4 = i;
                while (i < this.blockICS.num_window_groups) {
                    int i5 = i4;
                    i4 = 0;
                    while (i4 < this.blockICS.maxSfb) {
                        if (this.bandType[i5] != BandType.ZERO_BT && r1 == 0) {
                            vlc.readVLC(bitReader);
                        }
                        i4++;
                        i5++;
                    }
                    i++;
                    i4 = i5;
                }
            }
        }
    }
}
