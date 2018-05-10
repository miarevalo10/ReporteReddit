package com.mp4parser.iso23001.part7;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.UUIDConverter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class ProtectionSystemSpecificHeaderBox extends AbstractFullBox {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static byte[] OMA2_SYSTEM_ID = UUIDConverter.m7724a(UUID.fromString("A2B55680-6F43-11E0-9A3F-0002A5D5C51B"));
    public static byte[] PLAYREADY_SYSTEM_ID = UUIDConverter.m7724a(UUID.fromString("9A04F079-9840-4286-AB92-E65BE0885F95"));
    public static final String TYPE = "pssh";
    public static byte[] WIDEVINE = UUIDConverter.m7724a(UUID.fromString("edef8ba9-79d6-4ace-a3c8-27dcd51d21ed"));
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    byte[] content;
    List<UUID> keyIds = new ArrayList();
    byte[] systemId;

    private static void ajc$preClinit() {
        Factory factory = new Factory("ProtectionSystemSpecificHeaderBox.java", ProtectionSystemSpecificHeaderBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getKeyIds", "com.mp4parser.iso23001.part7.ProtectionSystemSpecificHeaderBox", "", "", "", "java.util.List"), 50);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setKeyIds", "com.mp4parser.iso23001.part7.ProtectionSystemSpecificHeaderBox", "java.util.List", "keyIds", "", "void"), 54);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "getSystemId", "com.mp4parser.iso23001.part7.ProtectionSystemSpecificHeaderBox", "", "", "", "[B"), 61);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "setSystemId", "com.mp4parser.iso23001.part7.ProtectionSystemSpecificHeaderBox", "[B", "systemId", "", "void"), 65);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "getContent", "com.mp4parser.iso23001.part7.ProtectionSystemSpecificHeaderBox", "", "", "", "[B"), 70);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "setContent", "com.mp4parser.iso23001.part7.ProtectionSystemSpecificHeaderBox", "[B", "content", "", "void"), 74);
    }

    static {
        ajc$preClinit();
    }

    public ProtectionSystemSpecificHeaderBox(byte[] bArr, byte[] bArr2) {
        super(TYPE);
        this.content = bArr2;
        this.systemId = bArr;
    }

    public List<UUID> getKeyIds() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.keyIds;
    }

    public void setKeyIds(List<UUID> list) {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this, list);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.keyIds = list;
    }

    public byte[] getSystemId() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.systemId;
    }

    public void setSystemId(byte[] bArr) {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this, bArr);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.systemId = bArr;
    }

    public byte[] getContent() {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.content;
    }

    public void setContent(byte[] bArr) {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this, bArr);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.content = bArr;
    }

    public ProtectionSystemSpecificHeaderBox() {
        super(TYPE);
    }

    protected long getContentSize() {
        long length = (long) (24 + this.content.length);
        return getVersion() > 0 ? (length + 4) + ((long) (16 * this.keyIds.size())) : length;
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(this.systemId, 0, 16);
        if (getVersion() > 0) {
            IsoTypeWriter.m3300b(byteBuffer, (long) this.keyIds.size());
            for (UUID a : this.keyIds) {
                byteBuffer.put(UUIDConverter.m7724a(a));
            }
        }
        IsoTypeWriter.m3300b(byteBuffer, (long) this.content.length);
        byteBuffer.put(this.content);
    }

    protected void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.systemId = new byte[16];
        byteBuffer.get(this.systemId);
        if (getVersion() > 0) {
            int a = CastUtils.m7705a(IsoTypeReader.m3280a(byteBuffer));
            while (true) {
                int i = a - 1;
                if (a <= 0) {
                    break;
                }
                byte[] bArr = new byte[16];
                byteBuffer.get(bArr);
                this.keyIds.add(UUIDConverter.m7723a(bArr));
                a = i;
            }
        }
        IsoTypeReader.m3280a(byteBuffer);
        this.content = new byte[byteBuffer.remaining()];
        byteBuffer.get(this.content);
    }
}
