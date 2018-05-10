package com.googlecode.mp4parser.boxes.microsoft;

import com.facebook.stetho.server.http.HttpStatus;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.internal.Conversions;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class XtraBox extends AbstractBox {
    private static final long FILETIME_EPOCH_DIFF = 11644473600000L;
    private static final long FILETIME_ONE_MILLISECOND = 10000;
    public static final int MP4_XTRA_BT_FILETIME = 21;
    public static final int MP4_XTRA_BT_GUID = 72;
    public static final int MP4_XTRA_BT_INT64 = 19;
    public static final int MP4_XTRA_BT_UNICODE = 8;
    public static final String TYPE = "Xtra";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_10 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    private static final StaticPart ajc$tjp_6 = null;
    private static final StaticPart ajc$tjp_7 = null;
    private static final StaticPart ajc$tjp_8 = null;
    private static final StaticPart ajc$tjp_9 = null;
    ByteBuffer data;
    private boolean successfulParse = false;
    Vector<XtraTag> tags = new Vector();

    private static class XtraTag {
        private int f8940a;
        private String f8941b;
        private Vector<XtraValue> f8942c;

        private XtraTag() {
            this.f8942c = new Vector();
        }

        private XtraTag(String str) {
            this();
            this.f8941b = str;
        }

        private int m7665a() {
            int length = 12 + this.f8941b.length();
            for (int i = 0; i < this.f8942c.size(); i++) {
                length += ((XtraValue) this.f8942c.elementAt(i)).m7671a();
            }
            return length;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.f8941b);
            stringBuffer.append(" [");
            stringBuffer.append(this.f8940a);
            stringBuffer.append(Operation.DIVISION);
            stringBuffer.append(this.f8942c.size());
            stringBuffer.append("]:\n");
            for (int i = 0; i < this.f8942c.size(); i++) {
                stringBuffer.append("  ");
                stringBuffer.append(((XtraValue) this.f8942c.elementAt(i)).toString());
                stringBuffer.append("\n");
            }
            return stringBuffer.toString();
        }

        static /* synthetic */ void m7667a(XtraTag xtraTag, ByteBuffer byteBuffer) {
            xtraTag.f8940a = byteBuffer.getInt();
            xtraTag.f8941b = XtraBox.readAsciiString(byteBuffer, byteBuffer.getInt());
            int i = byteBuffer.getInt();
            for (int i2 = 0; i2 < i; i2++) {
                XtraValue xtraValue = new XtraValue();
                XtraValue.m7673a(xtraValue, byteBuffer);
                xtraTag.f8942c.addElement(xtraValue);
            }
            if (xtraTag.f8940a != xtraTag.m7665a()) {
                StringBuilder stringBuilder = new StringBuilder("Improperly handled Xtra tag: Sizes don't match ( ");
                stringBuilder.append(xtraTag.f8940a);
                stringBuilder.append(Operation.DIVISION);
                stringBuilder.append(xtraTag.m7665a());
                stringBuilder.append(") on ");
                stringBuilder.append(xtraTag.f8941b);
                throw new RuntimeException(stringBuilder.toString());
            }
        }

        static /* synthetic */ void m7669b(XtraTag xtraTag, ByteBuffer byteBuffer) {
            byteBuffer.putInt(xtraTag.m7665a());
            byteBuffer.putInt(xtraTag.f8941b.length());
            XtraBox.writeAsciiString(byteBuffer, xtraTag.f8941b);
            byteBuffer.putInt(xtraTag.f8942c.size());
            for (int i = 0; i < xtraTag.f8942c.size(); i++) {
                XtraValue.m7675b((XtraValue) xtraTag.f8942c.elementAt(i), byteBuffer);
            }
        }
    }

    private static class XtraValue {
        public int f8943a;
        public String f8944b;
        public long f8945c;
        public byte[] f8946d;
        public Date f8947e;

        private XtraValue() {
        }

        private XtraValue(String str) {
            this.f8943a = 8;
            this.f8944b = str;
        }

        private XtraValue(long j) {
            this.f8943a = 19;
            this.f8945c = j;
        }

        private XtraValue(Date date) {
            this.f8943a = 21;
            this.f8947e = date;
        }

        private int m7671a() {
            int i = this.f8943a;
            if (i != 8) {
                return (i == 19 || i == 21) ? 14 : 6 + this.f8946d.length;
            } else {
                return 6 + ((this.f8944b.length() * 2) + 2);
            }
        }

        public String toString() {
            int i = this.f8943a;
            StringBuilder stringBuilder;
            if (i == 8) {
                stringBuilder = new StringBuilder("[string]");
                stringBuilder.append(this.f8944b);
                return stringBuilder.toString();
            } else if (i == 19) {
                stringBuilder = new StringBuilder("[long]");
                stringBuilder.append(String.valueOf(this.f8945c));
                return stringBuilder.toString();
            } else if (i != 21) {
                return "[GUID](nonParsed)";
            } else {
                stringBuilder = new StringBuilder("[filetime]");
                stringBuilder.append(this.f8947e.toString());
                return stringBuilder.toString();
            }
        }

        static /* synthetic */ void m7673a(XtraValue xtraValue, ByteBuffer byteBuffer) {
            int i = byteBuffer.getInt() - 6;
            xtraValue.f8943a = byteBuffer.getShort();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            int i2 = xtraValue.f8943a;
            if (i2 == 8) {
                xtraValue.f8944b = XtraBox.readUtf16String(byteBuffer, i);
            } else if (i2 == 19) {
                xtraValue.f8945c = byteBuffer.getLong();
            } else if (i2 != 21) {
                xtraValue.f8946d = new byte[i];
                byteBuffer.get(xtraValue.f8946d);
            } else {
                xtraValue.f8947e = new Date(XtraBox.filetimeToMillis(byteBuffer.getLong()));
            }
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        static /* synthetic */ void m7675b(XtraValue xtraValue, ByteBuffer byteBuffer) {
            try {
                byteBuffer.putInt(xtraValue.m7671a());
                byteBuffer.putShort((short) xtraValue.f8943a);
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                int i = xtraValue.f8943a;
                if (i == 8) {
                    XtraBox.writeUtf16String(byteBuffer, xtraValue.f8944b);
                } else if (i == 19) {
                    byteBuffer.putLong(xtraValue.f8945c);
                } else if (i != 21) {
                    byteBuffer.put(xtraValue.f8946d);
                } else {
                    byteBuffer.putLong(XtraBox.millisToFiletime(xtraValue.f8947e.getTime()));
                }
                byteBuffer.order(ByteOrder.BIG_ENDIAN);
            } catch (Throwable th) {
                byteBuffer.order(ByteOrder.BIG_ENDIAN);
            }
        }

        static /* synthetic */ Object m7674b(XtraValue xtraValue) {
            int i = xtraValue.f8943a;
            if (i == 8) {
                return xtraValue.f8944b;
            }
            if (i == 19) {
                return new Long(xtraValue.f8945c);
            }
            if (i != 21) {
                return xtraValue.f8946d;
            }
            return xtraValue.f8947e;
        }
    }

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("XtraBox.java", XtraBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "toString", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "", "", "", "java.lang.String"), 88);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "getAllTagNames", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "", "", "", "[Ljava.lang.String;"), 151);
        ajc$tjp_10 = factory.a("method-execution", factory.a("1", "setTagValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String:long", "name:value", "", "void"), 289);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "getFirstStringValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", "name", "", "java.lang.String"), 166);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "getFirstDateValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", "name", "", "java.util.Date"), MPEGConst.SEQUENCE_END_CODE);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "getFirstLongValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", "name", "", "java.lang.Long"), HttpStatus.HTTP_OK);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "getValues", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", "name", "", "[Ljava.lang.Object;"), JpegConst.SOI);
        ajc$tjp_6 = factory.a("method-execution", factory.a("1", "removeTag", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", "name", "", "void"), JpegConst.APPC);
        ajc$tjp_7 = factory.a("method-execution", factory.a("1", "setTagValues", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String:[Ljava.lang.String;", "name:values", "", "void"), 249);
        ajc$tjp_8 = factory.a("method-execution", factory.a("1", "setTagValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String:java.lang.String", "name:value", "", "void"), 265);
        ajc$tjp_9 = factory.a("method-execution", factory.a("1", "setTagValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String:java.util.Date", "name:date", "", "void"), 276);
    }

    private static long millisToFiletime(long j) {
        return (j + FILETIME_EPOCH_DIFF) * FILETIME_ONE_MILLISECOND;
    }

    public XtraBox() {
        super(TYPE);
    }

    public XtraBox(String str) {
        super(str);
    }

    protected long getContentSize() {
        if (this.successfulParse) {
            return (long) detailSize();
        }
        return (long) this.data.limit();
    }

    private int detailSize() {
        int i = 0;
        int i2 = 0;
        while (i < this.tags.size()) {
            i2 += ((XtraTag) this.tags.elementAt(i)).m7665a();
            i++;
        }
        return i2;
    }

    public String toString() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        if (!isParsed()) {
            parseDetails();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("XtraBox[");
        Iterator it = this.tags.iterator();
        while (it.hasNext()) {
            XtraTag xtraTag = (XtraTag) it.next();
            Iterator it2 = xtraTag.f8942c.iterator();
            while (it2.hasNext()) {
                XtraValue xtraValue = (XtraValue) it2.next();
                stringBuffer.append(xtraTag.f8941b);
                stringBuffer.append(Operation.EQUALS);
                stringBuffer.append(xtraValue.toString());
                stringBuffer.append(";");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        this.data = byteBuffer.slice();
        this.successfulParse = false;
        try {
            this.tags.clear();
            while (byteBuffer.remaining() > 0) {
                XtraTag xtraTag = new XtraTag();
                XtraTag.m7667a(xtraTag, byteBuffer);
                this.tags.addElement(xtraTag);
            }
            int detailSize = detailSize();
            if (remaining != detailSize) {
                StringBuilder stringBuilder = new StringBuilder("Improperly handled Xtra tag: Calculated sizes don't match ( ");
                stringBuilder.append(remaining);
                stringBuilder.append(Operation.DIVISION);
                stringBuilder.append(detailSize);
                stringBuilder.append(")");
                throw new RuntimeException(stringBuilder.toString());
            }
            this.successfulParse = true;
        } catch (Exception e) {
            this.successfulParse = false;
            PrintStream printStream = System.err;
            StringBuilder stringBuilder2 = new StringBuilder("Malformed Xtra Tag detected: ");
            stringBuilder2.append(e.toString());
            printStream.println(stringBuilder2.toString());
            e.printStackTrace();
            byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
        } finally {
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }
    }

    protected void getContent(ByteBuffer byteBuffer) {
        if (this.successfulParse) {
            for (int i = 0; i < this.tags.size(); i++) {
                XtraTag.m7669b((XtraTag) this.tags.elementAt(i), byteBuffer);
            }
            return;
        }
        this.data.rewind();
        byteBuffer.put(this.data);
    }

    public String[] getAllTagNames() {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        String[] strArr = new String[this.tags.size()];
        for (int i = 0; i < this.tags.size(); i++) {
            strArr[i] = ((XtraTag) this.tags.elementAt(i)).f8941b;
        }
        return strArr;
    }

    public String getFirstStringValue(String str) {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        for (Object obj : getValues(str)) {
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return null;
    }

    public Date getFirstDateValue(String str) {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        for (Object obj : getValues(str)) {
            if (obj instanceof Date) {
                return (Date) obj;
            }
        }
        return null;
    }

    public Long getFirstLongValue(String str) {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        for (Object obj : getValues(str)) {
            if (obj instanceof Long) {
                return (Long) obj;
            }
        }
        return null;
    }

    public Object[] getValues(String str) {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        str = getTagByName(str);
        int i = 0;
        if (str == null) {
            return new Object[0];
        }
        Object[] objArr = new Object[str.f8942c.size()];
        while (i < str.f8942c.size()) {
            objArr[i] = XtraValue.m7674b((XtraValue) str.f8942c.elementAt(i));
            i++;
        }
        return objArr;
    }

    public void removeTag(String str) {
        JoinPoint a = Factory.a(ajc$tjp_6, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        str = getTagByName(str);
        if (str != null) {
            this.tags.remove(str);
        }
    }

    public void setTagValues(String str, String[] strArr) {
        JoinPoint a = Factory.a(ajc$tjp_7, this, this, str, strArr);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        removeTag(str);
        XtraTag xtraTag = new XtraTag(str);
        for (String xtraValue : strArr) {
            xtraTag.f8942c.addElement(new XtraValue(xtraValue));
        }
        this.tags.addElement(xtraTag);
    }

    public void setTagValue(String str, String str2) {
        JoinPoint a = Factory.a(ajc$tjp_8, this, this, str, str2);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        setTagValues(str, new String[]{str2});
    }

    public void setTagValue(String str, Date date) {
        JoinPoint a = Factory.a(ajc$tjp_9, this, this, str, date);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        removeTag(str);
        XtraTag xtraTag = new XtraTag(str);
        xtraTag.f8942c.addElement(new XtraValue(date));
        this.tags.addElement(xtraTag);
    }

    public void setTagValue(String str, long j) {
        JoinPoint a = Factory.a(ajc$tjp_10, this, this, str, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        removeTag(str);
        XtraTag xtraTag = new XtraTag(str);
        xtraTag.f8942c.addElement(new XtraValue(j));
        this.tags.addElement(xtraTag);
    }

    private XtraTag getTagByName(String str) {
        Iterator it = this.tags.iterator();
        while (it.hasNext()) {
            XtraTag xtraTag = (XtraTag) it.next();
            if (xtraTag.f8941b.equals(str)) {
                return xtraTag;
            }
        }
        return null;
    }

    private static long filetimeToMillis(long j) {
        return (j / FILETIME_ONE_MILLISECOND) - FILETIME_EPOCH_DIFF;
    }

    private static void writeAsciiString(ByteBuffer byteBuffer, String str) {
        try {
            byteBuffer.put(str.getBytes("US-ASCII"));
        } catch (ByteBuffer byteBuffer2) {
            throw new RuntimeException("Shouldn't happen", byteBuffer2);
        }
    }

    private static String readAsciiString(ByteBuffer byteBuffer, int i) {
        i = new byte[i];
        byteBuffer.get(i);
        try {
            return new String(i, "US-ASCII");
        } catch (ByteBuffer byteBuffer2) {
            throw new RuntimeException("Shouldn't happen", byteBuffer2);
        }
    }

    private static String readUtf16String(ByteBuffer byteBuffer, int i) {
        i = (i / 2) - 1;
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = byteBuffer.getChar();
        }
        byteBuffer.getChar();
        return new String(cArr);
    }

    private static void writeUtf16String(ByteBuffer byteBuffer, String str) {
        str = str.toCharArray();
        for (char putChar : str) {
            byteBuffer.putChar(putChar);
        }
        byteBuffer.putChar('\u0000');
    }
}
