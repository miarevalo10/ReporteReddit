package org.jcodec.containers.mp4.boxes;

import com.coremedia.iso.boxes.DataEntryUrlBox;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.jcodec.common.NIOUtils;

public class UrlBox extends FullBox {
    private String url;

    public static String fourcc() {
        return DataEntryUrlBox.TYPE;
    }

    public UrlBox(String str) {
        super(new Header(fourcc()));
        this.url = str;
    }

    public UrlBox(Header header) {
        super(header);
    }

    public void parse(ByteBuffer byteBuffer) {
        super.parse(byteBuffer);
        if ((this.flags & 1) == 0) {
            this.url = NIOUtils.readNullTermString(byteBuffer, Charset.forName("utf-8"));
        }
    }

    protected void doWrite(ByteBuffer byteBuffer) {
        super.doWrite(byteBuffer);
        Charset forName = Charset.forName("utf-8");
        if (this.url != null) {
            NIOUtils.write(byteBuffer, ByteBuffer.wrap(this.url.getBytes(forName)));
            byteBuffer.put((byte) 0);
        }
    }

    public String getUrl() {
        return this.url;
    }
}
