package com.coremedia.iso.boxes;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.util.CastUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.LinkedList;
import java.util.List;

public class FreeBox implements Box {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TYPE = "free";
    ByteBuffer data;
    private long offset;
    private Container parent;
    List<Box> replacers;

    public String getType() {
        return TYPE;
    }

    public FreeBox() {
        this.replacers = new LinkedList();
        this.data = ByteBuffer.wrap(new byte[0]);
    }

    public FreeBox(int i) {
        this.replacers = new LinkedList();
        this.data = ByteBuffer.allocate(i);
    }

    public long getOffset() {
        return this.offset;
    }

    public ByteBuffer getData() {
        return this.data != null ? (ByteBuffer) this.data.duplicate().rewind() : null;
    }

    public void setData(ByteBuffer byteBuffer) {
        this.data = byteBuffer;
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        for (Box box : this.replacers) {
            box.getBox(writableByteChannel);
        }
        ByteBuffer allocate = ByteBuffer.allocate(8);
        IsoTypeWriter.m3300b(allocate, (long) (8 + this.data.limit()));
        allocate.put(TYPE.getBytes());
        allocate.rewind();
        writableByteChannel.write(allocate);
        allocate.rewind();
        this.data.rewind();
        writableByteChannel.write(this.data);
        this.data.rewind();
    }

    public Container getParent() {
        return this.parent;
    }

    public void setParent(Container container) {
        this.parent = container;
    }

    public long getSize() {
        long j = 8;
        for (Box size : this.replacers) {
            j += size.getSize();
        }
        return j + ((long) this.data.limit());
    }

    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        this.offset = dataSource.position() - ((long) byteBuffer.remaining());
        if (j > 1048576) {
            this.data = dataSource.map(dataSource.position(), j);
            dataSource.position(dataSource.position() + j);
            return;
        }
        this.data = ByteBuffer.allocate(CastUtils.m7705a(j));
        dataSource.read(this.data);
    }

    public void addAndReplace(Box box) {
        this.data.position(CastUtils.m7705a(box.getSize()));
        this.data = this.data.slice();
        this.replacers.add(box);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                FreeBox freeBox = (FreeBox) obj;
                if (getData() == null) {
                    return freeBox.getData() == null;
                } else {
                    if (getData().equals(freeBox.getData()) == null) {
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return this.data != null ? this.data.hashCode() : 0;
    }
}
