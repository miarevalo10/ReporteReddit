package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;
import org.jcodec.common.logging.Logger;

public class AES3PCMDescriptor extends WaveAudioDescriptor {
    private byte auxBitsMode;
    private short blockStartOffset;
    private ByteBuffer channelStatusMode;
    private byte emphasis;
    private ByteBuffer fixedChannelStatusData;
    private ByteBuffer fixedUserData;
    private ByteBuffer userDataMode;

    public AES3PCMDescriptor(UL ul) {
        super(ul);
    }

    protected void read(Map<Integer, ByteBuffer> map) {
        super.read(map);
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            ByteBuffer byteBuffer = (ByteBuffer) entry.getValue();
            int intValue = ((Integer) entry.getKey()).intValue();
            if (intValue == 15624) {
                this.auxBitsMode = byteBuffer.get();
            } else if (intValue != 15629) {
                switch (intValue) {
                    case 15631:
                        this.blockStartOffset = byteBuffer.getShort();
                        break;
                    case 15632:
                        this.channelStatusMode = byteBuffer;
                        break;
                    case 15633:
                        this.fixedChannelStatusData = byteBuffer;
                        break;
                    case 15634:
                        this.userDataMode = byteBuffer;
                        break;
                    case 15635:
                        this.fixedUserData = byteBuffer;
                        break;
                    default:
                        StringBuilder stringBuilder = new StringBuilder("Unknown tag [ ");
                        stringBuilder.append(this.ul);
                        stringBuilder.append("]: %04x");
                        Logger.warn(String.format(stringBuilder.toString(), new Object[]{entry.getKey()}));
                        continue;
                }
            } else {
                this.emphasis = byteBuffer.get();
            }
            map.remove();
        }
    }

    public byte getEmphasis() {
        return this.emphasis;
    }

    public short getBlockStartOffset() {
        return this.blockStartOffset;
    }

    public byte getAuxBitsMode() {
        return this.auxBitsMode;
    }

    public ByteBuffer getChannelStatusMode() {
        return this.channelStatusMode;
    }

    public ByteBuffer getFixedChannelStatusData() {
        return this.fixedChannelStatusData;
    }

    public ByteBuffer getUserDataMode() {
        return this.userDataMode;
    }

    public ByteBuffer getFixedUserData() {
        return this.fixedUserData;
    }
}
