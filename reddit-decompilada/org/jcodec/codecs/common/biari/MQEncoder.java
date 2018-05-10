package org.jcodec.codecs.common.biari;

import java.io.IOException;
import java.io.OutputStream;

public class MQEncoder {
    public static final int CARRY_MASK = 134217728;
    private int bitsToCode = 12;
    private int byteToGo;
    private long bytesOutput;
    private int offset = 0;
    private OutputStream out;
    private int range = 32768;

    public MQEncoder(OutputStream outputStream) {
        this.out = outputStream;
    }

    public void encode(int i, Context context) throws IOException {
        int i2 = MQConst.pLps[context.getState()];
        if (i == context.getMps()) {
            this.range -= i2;
            this.offset += i2;
            if (this.range < 32768) {
                while (this.range < 32768) {
                    renormalize();
                }
                context.setState(MQConst.transitMPS[context.getState()]);
                return;
            }
        }
        this.range = i2;
        while (this.range < 32768) {
            renormalize();
        }
        if (MQConst.mpsSwitch[context.getState()] != 0) {
            context.setMps(1 - context.getMps());
        }
        context.setState(MQConst.transitLPS[context.getState()]);
    }

    public void finish() throws IOException {
        finalizeValue();
        this.offset <<= this.bitsToCode;
        int i = 12 - this.bitsToCode;
        outputByte();
        if (i - this.bitsToCode > 0) {
            this.offset <<= this.bitsToCode;
            outputByte();
        }
        this.out.write(this.byteToGo);
    }

    private void finalizeValue() {
        int i = this.offset & 32768;
        this.offset &= -65536;
        if (i == 0) {
            this.offset |= 32768;
        } else {
            this.offset += 65536;
        }
    }

    private void renormalize() throws IOException {
        this.offset <<= 1;
        this.range <<= 1;
        this.range = (int) (((long) this.range) & 65535);
        this.bitsToCode--;
        if (this.bitsToCode == 0) {
            outputByte();
        }
    }

    private void outputByte() throws IOException {
        if (this.bytesOutput != 0) {
            if (this.byteToGo == 255) {
                outputByteWithStuffing();
                return;
            } else if ((this.offset & CARRY_MASK) != 0) {
                this.byteToGo++;
                this.offset &= 134217727;
                if (this.byteToGo == 255) {
                    outputByteWithStuffing();
                    return;
                } else {
                    outputByteNoStuffing();
                    return;
                }
            }
        }
        outputByteNoStuffing();
    }

    private void outputByteWithStuffing() throws IOException {
        this.bitsToCode = 7;
        if (this.bytesOutput > 0) {
            this.out.write(this.byteToGo);
        }
        this.byteToGo = (this.offset >> 20) & 255;
        this.offset &= 1048575;
        this.bytesOutput++;
    }

    private void outputByteNoStuffing() throws IOException {
        this.bitsToCode = 8;
        if (this.bytesOutput > 0) {
            this.out.write(this.byteToGo);
        }
        this.byteToGo = (this.offset >> 19) & 255;
        this.offset &= 524287;
        this.bytesOutput++;
    }
}
