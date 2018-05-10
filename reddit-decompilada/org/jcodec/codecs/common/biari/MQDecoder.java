package org.jcodec.codecs.common.biari;

import java.io.IOException;
import java.io.InputStream;

public class MQDecoder {
    private int availableBits;
    private int decodedBytes;
    private InputStream is;
    private int lastByte;
    private int range = 32768;
    private int value = null;

    public MQDecoder(InputStream inputStream) throws IOException {
        this.is = inputStream;
        fetchByte();
        this.value <<= 8;
        fetchByte();
        this.value <<= this.availableBits - 1;
        this.availableBits = 1;
    }

    public int decode(Context context) throws IOException {
        int i = MQConst.pLps[context.getState()];
        if (this.value > i) {
            this.range -= i;
            this.value -= i;
            if (this.range < 32768) {
                while (this.range < 32768) {
                    renormalize();
                }
                context.setState(MQConst.transitMPS[context.getState()]);
            }
            return context.getMps();
        }
        this.range = i;
        while (this.range < 32768) {
            renormalize();
        }
        if (MQConst.mpsSwitch[context.getState()] != 0) {
            context.setMps(1 - context.getMps());
        }
        context.setState(MQConst.transitLPS[context.getState()]);
        return 1 - context.getMps();
    }

    private void fetchByte() throws IOException {
        this.availableBits = 8;
        if (this.decodedBytes > 0 && this.lastByte == 255) {
            this.availableBits = 7;
        }
        this.lastByte = this.is.read();
        this.value += this.lastByte << (8 - this.availableBits);
        this.decodedBytes++;
    }

    private void renormalize() throws IOException {
        this.value <<= 1;
        this.range <<= 1;
        this.range &= 65535;
        this.availableBits--;
        if (this.availableBits == 0) {
            fetchByte();
        }
    }
}
