package org.jcodec.codecs.common.biari;

import java.io.IOException;

public class TreeBinarizer {
    private Context[] models;

    public TreeBinarizer() {
        initContextModels();
    }

    private void initContextModels() {
        this.models = new Context[255];
        for (int i = 0; i < 255; i++) {
            this.models[i] = new Context(0, 0);
        }
    }

    public void binarize(int i, MQEncoder mQEncoder) throws IOException {
        int i2 = 0;
        int i3 = 0;
        int i4 = i3;
        int i5 = i4;
        while (i2 < 8) {
            int i6 = (i >> (7 - i2)) & 1;
            mQEncoder.encode(i6, this.models[i3]);
            i4 |= i6 << i2;
            i5 += 1 << i2;
            i3 = i5 + i4;
            i2++;
        }
    }

    public int debinarize(MQDecoder mQDecoder) throws IOException {
        int i = 0;
        int i2 = 0;
        int i3 = i2;
        int i4 = i3;
        int i5 = i4;
        while (i < 8) {
            i2 = mQDecoder.decode(this.models[i2]);
            i3 |= i2 << (7 - i);
            i4 |= i2 << i;
            i5 += 1 << i;
            i2 = i5 + i4;
            i++;
        }
        return i3;
    }
}
