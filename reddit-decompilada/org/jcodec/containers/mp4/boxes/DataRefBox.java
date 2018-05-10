package org.jcodec.containers.mp4.boxes;

import com.coremedia.iso.boxes.DataReferenceBox;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class DataRefBox extends NodeBox {
    private static final MyFactory FACTORY = new MyFactory();

    public static class MyFactory extends BoxFactory {
        private Map<String, Class<? extends Box>> mappings = new HashMap();

        public MyFactory() {
            this.mappings.put(UrlBox.fourcc(), UrlBox.class);
            this.mappings.put(AliasBox.fourcc(), AliasBox.class);
            this.mappings.put("cios", AliasBox.class);
        }

        public Class<? extends Box> toClass(String str) {
            return (Class) this.mappings.get(str);
        }
    }

    public static String fourcc() {
        return DataReferenceBox.TYPE;
    }

    public DataRefBox() {
        this(new Header(fourcc()));
    }

    private DataRefBox(Header header) {
        super(header);
        this.factory = FACTORY;
    }

    public void parse(ByteBuffer byteBuffer) {
        byteBuffer.getInt();
        byteBuffer.getInt();
        super.parse(byteBuffer);
    }

    public void doWrite(ByteBuffer byteBuffer) {
        byteBuffer.putInt(0);
        byteBuffer.putInt(this.boxes.size());
        super.doWrite(byteBuffer);
    }
}
