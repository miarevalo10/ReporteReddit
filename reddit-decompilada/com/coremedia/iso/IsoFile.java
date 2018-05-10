package com.coremedia.iso;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.MovieBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.util.Logger;
import java.io.Closeable;
import java.io.IOException;

public class IsoFile extends BasicContainer implements Closeable {
    private static Logger f16748a = Logger.m7708a(IsoFile.class);

    public IsoFile(DataSource dataSource) throws IOException {
        this(dataSource, new PropertyBoxParserImpl());
    }

    private IsoFile(DataSource dataSource, BoxParser boxParser) throws IOException {
        initContainer(dataSource, dataSource.size(), boxParser);
    }

    public static byte[] m17057a(String str) {
        byte[] bArr = new byte[4];
        if (str != null) {
            for (int i = 0; i < Math.min(4, str.length()); i++) {
                bArr[i] = (byte) str.charAt(i);
            }
        }
        return bArr;
    }

    public static String m17056a(byte[] bArr) {
        Object obj = new byte[4];
        System.arraycopy(bArr, 0, obj, 0, Math.min(4, 4));
        try {
            return new String(obj, "ISO-8859-1");
        } catch (byte[] bArr2) {
            throw new Error("Required character encoding is missing", bArr2);
        }
    }

    public final MovieBox m17058a() {
        for (Box box : getBoxes()) {
            if (box instanceof MovieBox) {
                return (MovieBox) box;
            }
        }
        return null;
    }

    public void close() throws IOException {
        this.dataSource.close();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("model(");
        stringBuilder.append(this.dataSource.toString());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
