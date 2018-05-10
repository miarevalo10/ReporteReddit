package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.Rational;

public class GenericSoundEssenceDescriptor extends FileDescriptor {
    private byte audioRefLevel;
    private Rational audioSamplingRate;
    private int channelCount;
    private byte dialNorm;
    private byte electroSpatialFormulation;
    private byte locked;
    private int quantizationBits;
    private UL soundEssenceCompression;

    public GenericSoundEssenceDescriptor(UL ul) {
        super(ul);
    }

    protected void read(Map<Integer, ByteBuffer> map) {
        super.read(map);
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            ByteBuffer byteBuffer = (ByteBuffer) entry.getValue();
            int intValue = ((Integer) entry.getKey()).intValue();
            if (intValue != 15628) {
                switch (intValue) {
                    case 15617:
                        this.quantizationBits = byteBuffer.getInt();
                        break;
                    case 15618:
                        this.locked = byteBuffer.get();
                        break;
                    case 15619:
                        this.audioSamplingRate = new Rational(byteBuffer.getInt(), byteBuffer.getInt());
                        break;
                    case 15620:
                        this.audioRefLevel = byteBuffer.get();
                        break;
                    case 15621:
                        this.electroSpatialFormulation = byteBuffer.get();
                        break;
                    case 15622:
                        this.soundEssenceCompression = UL.read(byteBuffer);
                        break;
                    case 15623:
                        this.channelCount = byteBuffer.getInt();
                        break;
                    default:
                        StringBuilder stringBuilder = new StringBuilder("Unknown tag [ ");
                        stringBuilder.append(this.ul);
                        stringBuilder.append("]: %04x");
                        Logger.warn(String.format(stringBuilder.toString(), new Object[]{entry.getKey()}));
                        continue;
                }
            } else {
                this.dialNorm = byteBuffer.get();
            }
            map.remove();
        }
    }

    public Rational getAudioSamplingRate() {
        return this.audioSamplingRate;
    }

    public byte getLocked() {
        return this.locked;
    }

    public byte getAudioRefLevel() {
        return this.audioRefLevel;
    }

    public byte getElectroSpatialFormulation() {
        return this.electroSpatialFormulation;
    }

    public int getChannelCount() {
        return this.channelCount;
    }

    public int getQuantizationBits() {
        return this.quantizationBits;
    }

    public byte getDialNorm() {
        return this.dialNorm;
    }

    public UL getSoundEssenceCompression() {
        return this.soundEssenceCompression;
    }
}
