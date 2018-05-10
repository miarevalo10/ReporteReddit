package org.jcodec.containers.mp4.boxes;

import com.coremedia.iso.boxes.OriginalFormatBox;
import java.nio.ByteBuffer;
import org.jcodec.common.JCodecUtil;
import org.jcodec.common.NIOUtils;

public class FormatBox extends Box {
    private String fmt;

    public static String fourcc() {
        return OriginalFormatBox.TYPE;
    }

    public FormatBox(Box box) {
        super(box);
    }

    public FormatBox(Header header) {
        super(header);
    }

    public FormatBox(String str) {
        super(new Header(fourcc()));
        this.fmt = str;
    }

    public void parse(ByteBuffer byteBuffer) {
        this.fmt = NIOUtils.readString(byteBuffer, 4);
    }

    protected void doWrite(ByteBuffer byteBuffer) {
        byteBuffer.put(JCodecUtil.asciiString(this.fmt));
    }
}
