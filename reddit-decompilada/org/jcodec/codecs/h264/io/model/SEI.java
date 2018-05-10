package org.jcodec.codecs.h264.io.model;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.codecs.h264.io.write.CAVLCWriter;
import org.jcodec.common.io.BitWriter;

public class SEI {
    public SEIMessage[] messages;

    public static class SEIMessage {
        public byte[] payload;
        public int payloadSize;
        public int payloadType;

        public SEIMessage(int i, int i2, byte[] bArr) {
            this.payload = bArr;
            this.payloadType = i;
            this.payloadSize = i2;
        }
    }

    public SEI(SEIMessage[] sEIMessageArr) {
        this.messages = sEIMessageArr;
    }

    public static SEI read(ByteBuffer byteBuffer) {
        List arrayList = new ArrayList();
        SEIMessage sei_message;
        do {
            sei_message = sei_message(byteBuffer);
            if (sei_message != null) {
                arrayList.add(sei_message);
                continue;
            }
        } while (sei_message != null);
        return new SEI((SEIMessage[]) arrayList.toArray(new SEIMessage[0]));
    }

    private static SEIMessage sei_message(ByteBuffer byteBuffer) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = byteBuffer.get() & 255;
            if (i3 != 255) {
                break;
            }
            i2 += 255;
        }
        if (i3 == -1) {
            return null;
        }
        i2 += i3;
        while (true) {
            i3 = byteBuffer.get() & 255;
            if (i3 != 255) {
                break;
            }
            i += 255;
        }
        if (i3 == -1) {
            return null;
        }
        i += i3;
        byteBuffer = sei_payload(i2, i, byteBuffer);
        if (byteBuffer.length != i) {
            return null;
        }
        return new SEIMessage(i2, i, byteBuffer);
    }

    private static byte[] sei_payload(int i, int i2, ByteBuffer byteBuffer) {
        i = new byte[i2];
        byteBuffer.get(i);
        return i;
    }

    public void write(ByteBuffer byteBuffer) {
        CAVLCWriter.writeTrailingBits(new BitWriter(byteBuffer));
    }
}
