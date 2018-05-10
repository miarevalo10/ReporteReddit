package com.coremedia.iso.boxes.sampleentry;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.DataSource;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;

public class TextSampleEntry extends AbstractSampleEntry {
    public static final String TYPE1 = "tx3g";
    public static final String TYPE_ENCRYPTED = "enct";
    private int[] backgroundColorRgba;
    private BoxRecord boxRecord;
    private long displayFlags;
    private int horizontalJustification;
    private StyleRecord styleRecord;
    private int verticalJustification;

    public static class BoxRecord {
        int bottom;
        int left;
        int right;
        int top;

        public int getSize() {
            return 8;
        }

        public BoxRecord(int i, int i2, int i3, int i4) {
            this.top = i;
            this.left = i2;
            this.bottom = i3;
            this.right = i4;
        }

        public void parse(ByteBuffer byteBuffer) {
            this.top = IsoTypeReader.m3283c(byteBuffer);
            this.left = IsoTypeReader.m3283c(byteBuffer);
            this.bottom = IsoTypeReader.m3283c(byteBuffer);
            this.right = IsoTypeReader.m3283c(byteBuffer);
        }

        public void getContent(ByteBuffer byteBuffer) {
            IsoTypeWriter.m3299b(byteBuffer, this.top);
            IsoTypeWriter.m3299b(byteBuffer, this.left);
            IsoTypeWriter.m3299b(byteBuffer, this.bottom);
            IsoTypeWriter.m3299b(byteBuffer, this.right);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    BoxRecord boxRecord = (BoxRecord) obj;
                    return this.bottom == boxRecord.bottom && this.left == boxRecord.left && this.right == boxRecord.right && this.top == boxRecord.top;
                }
            }
            return false;
        }

        public int hashCode() {
            return (31 * ((((this.top * 31) + this.left) * 31) + this.bottom)) + this.right;
        }
    }

    public static class StyleRecord {
        int endChar;
        int faceStyleFlags;
        int fontId;
        int fontSize;
        int startChar;
        int[] textColor = new int[]{255, 255, 255, 255};

        public int getSize() {
            return 12;
        }

        public StyleRecord(int i, int i2, int i3, int i4, int i5, int[] iArr) {
            this.startChar = i;
            this.endChar = i2;
            this.fontId = i3;
            this.faceStyleFlags = i4;
            this.fontSize = i5;
            this.textColor = iArr;
        }

        public void parse(ByteBuffer byteBuffer) {
            this.startChar = IsoTypeReader.m3283c(byteBuffer);
            this.endChar = IsoTypeReader.m3283c(byteBuffer);
            this.fontId = IsoTypeReader.m3283c(byteBuffer);
            this.faceStyleFlags = IsoTypeReader.m3284d(byteBuffer);
            this.fontSize = IsoTypeReader.m3284d(byteBuffer);
            this.textColor = new int[4];
            this.textColor[0] = IsoTypeReader.m3284d(byteBuffer);
            this.textColor[1] = IsoTypeReader.m3284d(byteBuffer);
            this.textColor[2] = IsoTypeReader.m3284d(byteBuffer);
            this.textColor[3] = IsoTypeReader.m3284d(byteBuffer);
        }

        public void getContent(ByteBuffer byteBuffer) {
            IsoTypeWriter.m3299b(byteBuffer, this.startChar);
            IsoTypeWriter.m3299b(byteBuffer, this.endChar);
            IsoTypeWriter.m3299b(byteBuffer, this.fontId);
            IsoTypeWriter.m3303c(byteBuffer, this.faceStyleFlags);
            IsoTypeWriter.m3303c(byteBuffer, this.fontSize);
            IsoTypeWriter.m3303c(byteBuffer, this.textColor[0]);
            IsoTypeWriter.m3303c(byteBuffer, this.textColor[1]);
            IsoTypeWriter.m3303c(byteBuffer, this.textColor[2]);
            IsoTypeWriter.m3303c(byteBuffer, this.textColor[3]);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    StyleRecord styleRecord = (StyleRecord) obj;
                    return this.endChar == styleRecord.endChar && this.faceStyleFlags == styleRecord.faceStyleFlags && this.fontId == styleRecord.fontId && this.fontSize == styleRecord.fontSize && this.startChar == styleRecord.startChar && Arrays.equals(this.textColor, styleRecord.textColor) != null;
                }
            }
            return false;
        }

        public int hashCode() {
            return (31 * ((((((((this.startChar * 31) + this.endChar) * 31) + this.fontId) * 31) + this.faceStyleFlags) * 31) + this.fontSize)) + (this.textColor != null ? Arrays.hashCode(this.textColor) : 0);
        }
    }

    public String toString() {
        return "TextSampleEntry";
    }

    public TextSampleEntry() {
        super(TYPE1);
        this.backgroundColorRgba = new int[4];
        this.boxRecord = new BoxRecord();
        this.styleRecord = new StyleRecord();
    }

    public TextSampleEntry(String str) {
        super(str);
        this.backgroundColorRgba = new int[4];
        this.boxRecord = new BoxRecord();
        this.styleRecord = new StyleRecord();
    }

    public void setType(String str) {
        this.type = str;
    }

    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        byteBuffer = ByteBuffer.allocate(38);
        dataSource.read(byteBuffer);
        byteBuffer.position(6);
        this.dataReferenceIndex = IsoTypeReader.m3283c(byteBuffer);
        this.displayFlags = IsoTypeReader.m3280a(byteBuffer);
        this.horizontalJustification = IsoTypeReader.m3284d(byteBuffer);
        this.verticalJustification = IsoTypeReader.m3284d(byteBuffer);
        this.backgroundColorRgba = new int[4];
        this.backgroundColorRgba[0] = IsoTypeReader.m3284d(byteBuffer);
        this.backgroundColorRgba[1] = IsoTypeReader.m3284d(byteBuffer);
        this.backgroundColorRgba[2] = IsoTypeReader.m3284d(byteBuffer);
        this.backgroundColorRgba[3] = IsoTypeReader.m3284d(byteBuffer);
        this.boxRecord = new BoxRecord();
        this.boxRecord.parse(byteBuffer);
        this.styleRecord = new StyleRecord();
        this.styleRecord.parse(byteBuffer);
        initContainer(dataSource, j - 38, boxParser);
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(38);
        allocate.position(6);
        IsoTypeWriter.m3299b(allocate, this.dataReferenceIndex);
        IsoTypeWriter.m3300b(allocate, this.displayFlags);
        IsoTypeWriter.m3303c(allocate, this.horizontalJustification);
        IsoTypeWriter.m3303c(allocate, this.verticalJustification);
        IsoTypeWriter.m3303c(allocate, this.backgroundColorRgba[0]);
        IsoTypeWriter.m3303c(allocate, this.backgroundColorRgba[1]);
        IsoTypeWriter.m3303c(allocate, this.backgroundColorRgba[2]);
        IsoTypeWriter.m3303c(allocate, this.backgroundColorRgba[3]);
        this.boxRecord.getContent(allocate);
        this.styleRecord.getContent(allocate);
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        writeContainer(writableByteChannel);
    }

    public BoxRecord getBoxRecord() {
        return this.boxRecord;
    }

    public void setBoxRecord(BoxRecord boxRecord) {
        this.boxRecord = boxRecord;
    }

    public StyleRecord getStyleRecord() {
        return this.styleRecord;
    }

    public void setStyleRecord(StyleRecord styleRecord) {
        this.styleRecord = styleRecord;
    }

    public boolean isScrollIn() {
        return (this.displayFlags & 32) == 32;
    }

    public void setScrollIn(boolean z) {
        if (z) {
            this.displayFlags |= 32;
        } else {
            this.displayFlags &= -33;
        }
    }

    public boolean isScrollOut() {
        return (this.displayFlags & 64) == 64;
    }

    public void setScrollOut(boolean z) {
        if (z) {
            this.displayFlags |= 64;
        } else {
            this.displayFlags &= -65;
        }
    }

    public boolean isScrollDirection() {
        return (this.displayFlags & 384) == 384;
    }

    public void setScrollDirection(boolean z) {
        if (z) {
            this.displayFlags |= 384;
        } else {
            this.displayFlags &= -385;
        }
    }

    public boolean isContinuousKaraoke() {
        return (this.displayFlags & 2048) == 2048;
    }

    public void setContinuousKaraoke(boolean z) {
        if (z) {
            this.displayFlags |= 2048;
        } else {
            this.displayFlags &= -2049;
        }
    }

    public boolean isWriteTextVertically() {
        return (this.displayFlags & 131072) == 131072;
    }

    public void setWriteTextVertically(boolean z) {
        if (z) {
            this.displayFlags |= 131072;
        } else {
            this.displayFlags &= -131073;
        }
    }

    public boolean isFillTextRegion() {
        return (this.displayFlags & 262144) == 262144;
    }

    public void setFillTextRegion(boolean z) {
        if (z) {
            this.displayFlags |= 262144;
        } else {
            this.displayFlags &= -262145;
        }
    }

    public int getHorizontalJustification() {
        return this.horizontalJustification;
    }

    public void setHorizontalJustification(int i) {
        this.horizontalJustification = i;
    }

    public int getVerticalJustification() {
        return this.verticalJustification;
    }

    public void setVerticalJustification(int i) {
        this.verticalJustification = i;
    }

    public int[] getBackgroundColorRgba() {
        return this.backgroundColorRgba;
    }

    public void setBackgroundColorRgba(int[] iArr) {
        this.backgroundColorRgba = iArr;
    }

    public long getSize() {
        int i;
        long containerSize = getContainerSize() + 38;
        if (!this.largeBox) {
            if (containerSize < 4294967296L) {
                i = 8;
                return containerSize + ((long) i);
            }
        }
        i = 16;
        return containerSize + ((long) i);
    }
}
