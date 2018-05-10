package com.coremedia.iso.boxes.vodafone;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class AlbumArtistBox extends AbstractFullBox {
    public static final String TYPE = "albr";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private String albumArtist;
    private String language;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("AlbumArtistBox.java", AlbumArtistBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getLanguage", "com.coremedia.iso.boxes.vodafone.AlbumArtistBox", "", "", "", "java.lang.String"), 42);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "getAlbumArtist", "com.coremedia.iso.boxes.vodafone.AlbumArtistBox", "", "", "", "java.lang.String"), 46);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "setLanguage", "com.coremedia.iso.boxes.vodafone.AlbumArtistBox", "java.lang.String", "language", "", "void"), 50);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "setAlbumArtist", "com.coremedia.iso.boxes.vodafone.AlbumArtistBox", "java.lang.String", "albumArtist", "", "void"), 54);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "toString", "com.coremedia.iso.boxes.vodafone.AlbumArtistBox", "", "", "", "java.lang.String"), 76);
    }

    public AlbumArtistBox() {
        super(TYPE);
    }

    public String getLanguage() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.language;
    }

    public String getAlbumArtist() {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.albumArtist;
    }

    public void setLanguage(String str) {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.language = str;
    }

    public void setAlbumArtist(String str) {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.albumArtist = str;
    }

    protected long getContentSize() {
        return (long) ((6 + Utf8.m3309b(this.albumArtist)) + 1);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.language = IsoTypeReader.m3290j(byteBuffer);
        this.albumArtist = IsoTypeReader.m3285e(byteBuffer);
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.m3297a(byteBuffer, this.language);
        byteBuffer.put(Utf8.m3308a(this.albumArtist));
        byteBuffer.put((byte) 0);
    }

    public String toString() {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        StringBuilder stringBuilder = new StringBuilder("AlbumArtistBox[language=");
        stringBuilder.append(getLanguage());
        stringBuilder.append(";albumArtist=");
        stringBuilder.append(getAlbumArtist());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
