package org.jcodec.codecs.mpeg4.es;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class NodeDescriptor extends Descriptor {
    private Collection<Descriptor> children = new ArrayList();

    public NodeDescriptor(int i, int i2) {
        super(i, i2);
    }

    public NodeDescriptor(int i) {
        super(i);
    }

    public NodeDescriptor(int i, Descriptor[] descriptorArr) {
        super(i);
        this.children.addAll(Arrays.asList(descriptorArr));
    }

    protected void doWrite(ByteBuffer byteBuffer) {
        for (Descriptor write : this.children) {
            write.write(byteBuffer);
        }
    }

    public Collection<Descriptor> getChildren() {
        return this.children;
    }

    protected void parse(ByteBuffer byteBuffer) {
        Descriptor read;
        do {
            read = Descriptor.read(byteBuffer);
            if (read != null) {
                this.children.add(read);
                continue;
            }
        } while (read != null);
    }
}
