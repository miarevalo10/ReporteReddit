package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import org.jcodec.common.JCodecUtil;
import org.jcodec.common.NIOUtils;

public class NameBox extends Box {
    private String name;

    public static String fourcc() {
        return "name";
    }

    public NameBox(String str) {
        this();
        this.name = str;
    }

    public NameBox() {
        super(new Header(fourcc()));
    }

    private NameBox(Header header) {
        super(header);
    }

    public void parse(ByteBuffer byteBuffer) {
        this.name = NIOUtils.readNullTermString(byteBuffer);
    }

    protected void doWrite(ByteBuffer byteBuffer) {
        byteBuffer.put(JCodecUtil.asciiString(this.name));
        byteBuffer.putInt(0);
    }

    public String getName() {
        return this.name;
    }
}
