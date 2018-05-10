package org.jcodec.containers.mkv.boxes;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class EbmlString extends EbmlBin {
    public String charset = "UTF-8";

    public EbmlString(byte[] bArr) {
        super(bArr);
    }

    public EbmlString(byte[] bArr, String str) {
        super(bArr);
        set(str);
    }

    public String get() {
        try {
            return new String(this.data.array(), this.charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void set(String str) {
        try {
            this.data = ByteBuffer.wrap(str.getBytes(this.charset));
        } catch (String str2) {
            str2.printStackTrace();
        }
    }
}
