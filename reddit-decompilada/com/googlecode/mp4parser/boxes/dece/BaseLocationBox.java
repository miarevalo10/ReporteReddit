package com.googlecode.mp4parser.boxes.dece;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.Utf8;
import com.google.android.gms.ads.AdRequest;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class BaseLocationBox extends AbstractFullBox {
    public static final String TYPE = "bloc";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    private static final StaticPart ajc$tjp_6 = null;
    String baseLocation = "";
    String purchaseLocation = "";

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("BaseLocationBox.java", BaseLocationBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getBaseLocation", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "", "", "", "java.lang.String"), 44);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setBaseLocation", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "java.lang.String", "baseLocation", "", "void"), 48);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "getPurchaseLocation", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "", "", "", "java.lang.String"), 52);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "setPurchaseLocation", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "java.lang.String", "purchaseLocation", "", "void"), 56);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "equals", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "java.lang.Object", "o", "", "boolean"), 86);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "hashCode", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "", "", "", "int"), 100);
        ajc$tjp_6 = factory.a("method-execution", factory.a("1", "toString", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "", "", "", "java.lang.String"), 107);
    }

    protected long getContentSize() {
        return 1028;
    }

    public BaseLocationBox() {
        super(TYPE);
    }

    public BaseLocationBox(String str, String str2) {
        super(TYPE);
        this.baseLocation = str;
        this.purchaseLocation = str2;
    }

    public String getBaseLocation() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.baseLocation;
    }

    public void setBaseLocation(String str) {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.baseLocation = str;
    }

    public String getPurchaseLocation() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.purchaseLocation;
    }

    public void setPurchaseLocation(String str) {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.purchaseLocation = str;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.baseLocation = IsoTypeReader.m3285e(byteBuffer);
        byteBuffer.get(new byte[((256 - Utf8.m3309b(this.baseLocation)) - 1)]);
        this.purchaseLocation = IsoTypeReader.m3285e(byteBuffer);
        byteBuffer.get(new byte[((256 - Utf8.m3309b(this.purchaseLocation)) - 1)]);
        byteBuffer.get(new byte[AdRequest.MAX_CONTENT_URL_LENGTH]);
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(Utf8.m3308a(this.baseLocation));
        byteBuffer.put(new byte[(256 - Utf8.m3309b(this.baseLocation))]);
        byteBuffer.put(Utf8.m3308a(this.purchaseLocation));
        byteBuffer.put(new byte[(256 - Utf8.m3309b(this.purchaseLocation))]);
        byteBuffer.put(new byte[AdRequest.MAX_CONTENT_URL_LENGTH]);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = ajc$tjp_4;
        r0 = org.mp4parser.aspectj.runtime.reflect.Factory.a(r0, r4, r4, r5);
        com.googlecode.mp4parser.RequiresParseDetailAspect.m7623a();
        com.googlecode.mp4parser.RequiresParseDetailAspect.m7624a(r0);
        r0 = 1;
        if (r4 != r5) goto L_0x0010;
    L_0x000f:
        return r0;
    L_0x0010:
        r1 = 0;
        if (r5 == 0) goto L_0x0049;
    L_0x0013:
        r2 = r4.getClass();
        r3 = r5.getClass();
        if (r2 == r3) goto L_0x001e;
    L_0x001d:
        goto L_0x0049;
    L_0x001e:
        r5 = (com.googlecode.mp4parser.boxes.dece.BaseLocationBox) r5;
        r2 = r4.baseLocation;
        if (r2 == 0) goto L_0x002f;
    L_0x0024:
        r2 = r4.baseLocation;
        r3 = r5.baseLocation;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0034;
    L_0x002e:
        goto L_0x0033;
    L_0x002f:
        r2 = r5.baseLocation;
        if (r2 == 0) goto L_0x0034;
    L_0x0033:
        return r1;
    L_0x0034:
        r2 = r4.purchaseLocation;
        if (r2 == 0) goto L_0x0043;
    L_0x0038:
        r2 = r4.purchaseLocation;
        r5 = r5.purchaseLocation;
        r5 = r2.equals(r5);
        if (r5 != 0) goto L_0x0048;
    L_0x0042:
        goto L_0x0047;
    L_0x0043:
        r5 = r5.purchaseLocation;
        if (r5 == 0) goto L_0x0048;
    L_0x0047:
        return r1;
    L_0x0048:
        return r0;
    L_0x0049:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.googlecode.mp4parser.boxes.dece.BaseLocationBox.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        int i = 0;
        int hashCode = 31 * (this.baseLocation != null ? this.baseLocation.hashCode() : 0);
        if (this.purchaseLocation != null) {
            i = this.purchaseLocation.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        JoinPoint a = Factory.a(ajc$tjp_6, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        StringBuilder stringBuilder = new StringBuilder("BaseLocationBox{baseLocation='");
        stringBuilder.append(this.baseLocation);
        stringBuilder.append('\'');
        stringBuilder.append(", purchaseLocation='");
        stringBuilder.append(this.purchaseLocation);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
