package org.jcodec.common.io;

import org.jcodec.common.IntArrayList;
import org.jcodec.common.IntIntMap;

public class VLCBuilder {
    private IntArrayList codes = new IntArrayList();
    private IntArrayList codesSizes = new IntArrayList();
    private IntIntMap forward = new IntIntMap();
    private IntIntMap inverse = new IntIntMap();

    public VLCBuilder(int[] iArr, int[] iArr2, int[] iArr3) {
        for (int i = 0; i < iArr.length; i++) {
            set(iArr[i], iArr2[i], iArr3[i]);
        }
    }

    public VLCBuilder set(int i, String str) {
        set(Integer.parseInt(str, 2), str.length(), i);
        return this;
    }

    public VLCBuilder set(int i, int i2, int i3) {
        this.codes.add(i << (32 - i2));
        this.codesSizes.add(i2);
        this.forward.put(i3, this.codes.size() - 1);
        this.inverse.put(this.codes.size() - 1, i3);
        return this;
    }

    public VLC getVLC() {
        return new VLC(this, this.codes.toArray(), this.codesSizes.toArray()) {
            final /* synthetic */ VLCBuilder f33280a;

            public int readVLC(BitReader bitReader) {
                return this.f33280a.inverse.get(super.readVLC(bitReader));
            }

            public int readVLC16(BitReader bitReader) {
                return this.f33280a.inverse.get(super.readVLC16(bitReader));
            }

            public void writeVLC(BitWriter bitWriter, int i) {
                super.writeVLC(bitWriter, this.f33280a.forward.get(i));
            }
        };
    }
}
