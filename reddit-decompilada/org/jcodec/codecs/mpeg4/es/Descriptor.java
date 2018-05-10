package org.jcodec.codecs.mpeg4.es;

import java.nio.ByteBuffer;
import org.jcodec.common.JCodecUtil;
import org.jcodec.common.NIOUtils;

public abstract class Descriptor {
    private static DescriptorFactory factory = new DescriptorFactory();
    private int size;
    private int tag;

    protected abstract void doWrite(ByteBuffer byteBuffer);

    protected abstract void parse(ByteBuffer byteBuffer);

    public Descriptor(int i) {
        this(i, 0);
    }

    public Descriptor(int i, int i2) {
        this.tag = i;
        this.size = i2;
    }

    public void write(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        NIOUtils.skip(byteBuffer, 5);
        doWrite(byteBuffer);
        byteBuffer = (byteBuffer.position() - duplicate.position()) - 5;
        duplicate.put((byte) this.tag);
        JCodecUtil.writeBER32(duplicate, byteBuffer);
    }

    public static Descriptor read(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() < 2) {
            return null;
        }
        int i = byteBuffer.get() & 255;
        try {
            Descriptor descriptor = (Descriptor) factory.byTag(i).getConstructor(new Class[]{Integer.TYPE, Integer.TYPE}).newInstance(new Object[]{Integer.valueOf(i), Integer.valueOf(r2)});
            descriptor.parse(NIOUtils.read(byteBuffer, JCodecUtil.readBER32(byteBuffer)));
            return descriptor;
        } catch (ByteBuffer byteBuffer2) {
            throw new RuntimeException(byteBuffer2);
        }
    }

    public static <T> T find(Descriptor descriptor, Class<T> cls, int i) {
        if (descriptor.getTag() == i) {
            return descriptor;
        }
        if (descriptor instanceof NodeDescriptor) {
            for (Descriptor find : ((NodeDescriptor) descriptor).getChildren()) {
                T find2 = find(find, cls, i);
                if (find2 != null) {
                    return find2;
                }
            }
        }
        return null;
    }

    private int getTag() {
        return this.tag;
    }
}
