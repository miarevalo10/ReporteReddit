package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;
import org.jcodec.common.logging.Logger;

public class RGBAEssenceDescriptor extends GenericPictureEssenceDescriptor {
    private int alphaMaxRef;
    private int alphaMinRef;
    private int componentMaxRef;
    private int componentMinRef;
    private ByteBuffer palette;
    private ByteBuffer paletteLayout;
    private ByteBuffer pixelLayout;
    private byte scanningDirection;

    public RGBAEssenceDescriptor(UL ul) {
        super(ul);
    }

    protected void read(Map<Integer, ByteBuffer> map) {
        super.read(map);
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            ByteBuffer byteBuffer = (ByteBuffer) entry.getValue();
            switch (((Integer) entry.getKey()).intValue()) {
                case 13313:
                    this.pixelLayout = byteBuffer;
                    break;
                case 13315:
                    this.palette = byteBuffer;
                    break;
                case 13316:
                    this.paletteLayout = byteBuffer;
                    break;
                case 13317:
                    this.scanningDirection = byteBuffer.get();
                    break;
                case 13318:
                    this.componentMaxRef = byteBuffer.getInt();
                    break;
                case 13319:
                    this.componentMinRef = byteBuffer.getInt();
                    break;
                case 13320:
                    this.alphaMaxRef = byteBuffer.getInt();
                    break;
                case 13321:
                    this.alphaMinRef = byteBuffer.getInt();
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder("Unknown tag [ ");
                    stringBuilder.append(this.ul);
                    stringBuilder.append("]: %04x");
                    Logger.warn(String.format(stringBuilder.toString(), new Object[]{entry.getKey()}));
                    continue;
            }
            map.remove();
        }
    }

    public int getComponentMaxRef() {
        return this.componentMaxRef;
    }

    public int getComponentMinRef() {
        return this.componentMinRef;
    }

    public int getAlphaMaxRef() {
        return this.alphaMaxRef;
    }

    public int getAlphaMinRef() {
        return this.alphaMinRef;
    }

    public byte getScanningDirection() {
        return this.scanningDirection;
    }

    public ByteBuffer getPixelLayout() {
        return this.pixelLayout;
    }

    public ByteBuffer getPalette() {
        return this.palette;
    }

    public ByteBuffer getPaletteLayout() {
        return this.paletteLayout;
    }
}
