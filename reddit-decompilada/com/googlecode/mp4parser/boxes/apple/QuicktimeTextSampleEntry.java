package com.googlecode.mp4parser.boxes.apple;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.util.CastUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.List;

public class QuicktimeTextSampleEntry extends AbstractSampleEntry {
    public static final String TYPE = "text";
    int backgroundB;
    int backgroundG;
    int backgroundR;
    int dataReferenceIndex;
    long defaultTextBox;
    int displayFlags;
    short fontFace;
    String fontName = "";
    short fontNumber;
    int foregroundB = 65535;
    int foregroundG = 65535;
    int foregroundR = 65535;
    long reserved1;
    byte reserved2;
    short reserved3;
    int textJustification;

    public QuicktimeTextSampleEntry() {
        super("text");
    }

    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        byteBuffer = ByteBuffer.allocate(CastUtils.m7705a(j));
        dataSource.read(byteBuffer);
        byteBuffer.position(6);
        this.dataReferenceIndex = IsoTypeReader.m3283c(byteBuffer);
        this.displayFlags = byteBuffer.getInt();
        this.textJustification = byteBuffer.getInt();
        this.backgroundR = IsoTypeReader.m3283c(byteBuffer);
        this.backgroundG = IsoTypeReader.m3283c(byteBuffer);
        this.backgroundB = IsoTypeReader.m3283c(byteBuffer);
        this.defaultTextBox = IsoTypeReader.m3286f(byteBuffer);
        this.reserved1 = IsoTypeReader.m3286f(byteBuffer);
        this.fontNumber = byteBuffer.getShort();
        this.fontFace = byteBuffer.getShort();
        this.reserved2 = byteBuffer.get();
        this.reserved3 = byteBuffer.getShort();
        this.foregroundR = IsoTypeReader.m3283c(byteBuffer);
        this.foregroundG = IsoTypeReader.m3283c(byteBuffer);
        this.foregroundB = IsoTypeReader.m3283c(byteBuffer);
        if (byteBuffer.remaining() > null) {
            dataSource = new byte[IsoTypeReader.m3284d(byteBuffer)];
            byteBuffer.get(dataSource);
            this.fontName = new String(dataSource);
            return;
        }
        this.fontName = null;
    }

    public void setBoxes(List<Box> list) {
        throw new RuntimeException("QuicktimeTextSampleEntries may not have child boxes");
    }

    public void addBox(Box box) {
        throw new RuntimeException("QuicktimeTextSampleEntries may not have child boxes");
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(52 + (this.fontName != null ? this.fontName.length() : 0));
        allocate.position(6);
        IsoTypeWriter.m3299b(allocate, this.dataReferenceIndex);
        allocate.putInt(this.displayFlags);
        allocate.putInt(this.textJustification);
        IsoTypeWriter.m3299b(allocate, this.backgroundR);
        IsoTypeWriter.m3299b(allocate, this.backgroundG);
        IsoTypeWriter.m3299b(allocate, this.backgroundB);
        IsoTypeWriter.m3296a(allocate, this.defaultTextBox);
        IsoTypeWriter.m3296a(allocate, this.reserved1);
        allocate.putShort(this.fontNumber);
        allocate.putShort(this.fontFace);
        allocate.put(this.reserved2);
        allocate.putShort(this.reserved3);
        IsoTypeWriter.m3299b(allocate, this.foregroundR);
        IsoTypeWriter.m3299b(allocate, this.foregroundG);
        IsoTypeWriter.m3299b(allocate, this.foregroundB);
        if (this.fontName != null) {
            IsoTypeWriter.m3303c(allocate, this.fontName.length());
            allocate.put(this.fontName.getBytes());
        }
        writableByteChannel.write((ByteBuffer) allocate.rewind());
    }

    public long getSize() {
        int i;
        long containerSize = (getContainerSize() + 52) + ((long) (this.fontName != null ? this.fontName.length() : 0));
        if (!this.largeBox) {
            if (8 + containerSize < 4294967296L) {
                i = 8;
                return containerSize + ((long) i);
            }
        }
        i = 16;
        return containerSize + ((long) i);
    }

    public int getDisplayFlags() {
        return this.displayFlags;
    }

    public void setDisplayFlags(int i) {
        this.displayFlags = i;
    }

    public int getTextJustification() {
        return this.textJustification;
    }

    public void setTextJustification(int i) {
        this.textJustification = i;
    }

    public int getBackgroundR() {
        return this.backgroundR;
    }

    public void setBackgroundR(int i) {
        this.backgroundR = i;
    }

    public int getBackgroundG() {
        return this.backgroundG;
    }

    public void setBackgroundG(int i) {
        this.backgroundG = i;
    }

    public int getBackgroundB() {
        return this.backgroundB;
    }

    public void setBackgroundB(int i) {
        this.backgroundB = i;
    }

    public long getDefaultTextBox() {
        return this.defaultTextBox;
    }

    public void setDefaultTextBox(long j) {
        this.defaultTextBox = j;
    }

    public long getReserved1() {
        return this.reserved1;
    }

    public void setReserved1(long j) {
        this.reserved1 = j;
    }

    public short getFontNumber() {
        return this.fontNumber;
    }

    public void setFontNumber(short s) {
        this.fontNumber = s;
    }

    public short getFontFace() {
        return this.fontFace;
    }

    public void setFontFace(short s) {
        this.fontFace = s;
    }

    public byte getReserved2() {
        return this.reserved2;
    }

    public void setReserved2(byte b) {
        this.reserved2 = b;
    }

    public short getReserved3() {
        return this.reserved3;
    }

    public void setReserved3(short s) {
        this.reserved3 = s;
    }

    public int getForegroundR() {
        return this.foregroundR;
    }

    public void setForegroundR(int i) {
        this.foregroundR = i;
    }

    public int getForegroundG() {
        return this.foregroundG;
    }

    public void setForegroundG(int i) {
        this.foregroundG = i;
    }

    public int getForegroundB() {
        return this.foregroundB;
    }

    public void setForegroundB(int i) {
        this.foregroundB = i;
    }

    public String getFontName() {
        return this.fontName;
    }

    public void setFontName(String str) {
        this.fontName = str;
    }
}
