package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeReaderVariable;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.IsoTypeWriterVariable;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.internal.Conversions;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class ItemLocationBox extends AbstractFullBox {
    public static final String TYPE = "iloc";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_10 = null;
    private static final StaticPart ajc$tjp_11 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    private static final StaticPart ajc$tjp_6 = null;
    private static final StaticPart ajc$tjp_7 = null;
    private static final StaticPart ajc$tjp_8 = null;
    private static final StaticPart ajc$tjp_9 = null;
    public int baseOffsetSize = 8;
    public int indexSize = 0;
    public List<Item> items = new LinkedList();
    public int lengthSize = 8;
    public int offsetSize = 8;

    public class Extent {
        public long extentIndex;
        public long extentLength;
        public long extentOffset;

        public Extent(long j, long j2, long j3) {
            this.extentOffset = j;
            this.extentLength = j2;
            this.extentIndex = j3;
        }

        public Extent(ByteBuffer byteBuffer) {
            if (ItemLocationBox.this.getVersion() == 1 && ItemLocationBox.this.indexSize > 0) {
                this.extentIndex = IsoTypeReaderVariable.m3293a(byteBuffer, ItemLocationBox.this.indexSize);
            }
            this.extentOffset = IsoTypeReaderVariable.m3293a(byteBuffer, ItemLocationBox.this.offsetSize);
            this.extentLength = IsoTypeReaderVariable.m3293a(byteBuffer, ItemLocationBox.this.lengthSize);
        }

        public void getContent(ByteBuffer byteBuffer) {
            if (ItemLocationBox.this.getVersion() == 1 && ItemLocationBox.this.indexSize > 0) {
                IsoTypeWriterVariable.m3306a(this.extentIndex, byteBuffer, ItemLocationBox.this.indexSize);
            }
            IsoTypeWriterVariable.m3306a(this.extentOffset, byteBuffer, ItemLocationBox.this.offsetSize);
            IsoTypeWriterVariable.m3306a(this.extentLength, byteBuffer, ItemLocationBox.this.lengthSize);
        }

        public int getSize() {
            return ((ItemLocationBox.this.indexSize > 0 ? ItemLocationBox.this.indexSize : 0) + ItemLocationBox.this.offsetSize) + ItemLocationBox.this.lengthSize;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    Extent extent = (Extent) obj;
                    return this.extentIndex == extent.extentIndex && this.extentLength == extent.extentLength && this.extentOffset == extent.extentOffset;
                }
            }
            return false;
        }

        public int hashCode() {
            return (31 * ((((int) (this.extentOffset ^ (this.extentOffset >>> 32))) * 31) + ((int) (this.extentLength ^ (this.extentLength >>> 32))))) + ((int) (this.extentIndex ^ (this.extentIndex >>> 32)));
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Extent");
            stringBuilder.append("{extentOffset=");
            stringBuilder.append(this.extentOffset);
            stringBuilder.append(", extentLength=");
            stringBuilder.append(this.extentLength);
            stringBuilder.append(", extentIndex=");
            stringBuilder.append(this.extentIndex);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public class Item {
        public long baseOffset;
        public int constructionMethod;
        public int dataReferenceIndex;
        public List<Extent> extents = new LinkedList();
        public int itemId;

        public Item(ByteBuffer byteBuffer) {
            this.itemId = IsoTypeReader.m3283c(byteBuffer);
            if (ItemLocationBox.this.getVersion() == 1) {
                this.constructionMethod = IsoTypeReader.m3283c(byteBuffer) & 15;
            }
            this.dataReferenceIndex = IsoTypeReader.m3283c(byteBuffer);
            if (ItemLocationBox.this.baseOffsetSize > 0) {
                this.baseOffset = IsoTypeReaderVariable.m3293a(byteBuffer, ItemLocationBox.this.baseOffsetSize);
            } else {
                this.baseOffset = 0;
            }
            int c = IsoTypeReader.m3283c(byteBuffer);
            for (int i = 0; i < c; i++) {
                this.extents.add(new Extent(byteBuffer));
            }
        }

        public Item(int i, int i2, int i3, long j, List<Extent> list) {
            this.itemId = i;
            this.constructionMethod = i2;
            this.dataReferenceIndex = i3;
            this.baseOffset = j;
            this.extents = list;
        }

        public int getSize() {
            int i = (((ItemLocationBox.this.getVersion() == 1 ? 4 : 2) + 2) + ItemLocationBox.this.baseOffsetSize) + 2;
            for (Extent size : this.extents) {
                i += size.getSize();
            }
            return i;
        }

        public void setBaseOffset(long j) {
            this.baseOffset = j;
        }

        public void getContent(ByteBuffer byteBuffer) {
            IsoTypeWriter.m3299b(byteBuffer, this.itemId);
            if (ItemLocationBox.this.getVersion() == 1) {
                IsoTypeWriter.m3299b(byteBuffer, this.constructionMethod);
            }
            IsoTypeWriter.m3299b(byteBuffer, this.dataReferenceIndex);
            if (ItemLocationBox.this.baseOffsetSize > 0) {
                IsoTypeWriterVariable.m3306a(this.baseOffset, byteBuffer, ItemLocationBox.this.baseOffsetSize);
            }
            IsoTypeWriter.m3299b(byteBuffer, this.extents.size());
            for (Extent content : this.extents) {
                content.getContent(byteBuffer);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    Item item = (Item) obj;
                    if (this.baseOffset != item.baseOffset || this.constructionMethod != item.constructionMethod || this.dataReferenceIndex != item.dataReferenceIndex || this.itemId != item.itemId) {
                        return false;
                    }
                    if (this.extents == null) {
                        return item.extents == null;
                    } else {
                        if (this.extents.equals(item.extents) == null) {
                        }
                    }
                }
            }
            return false;
        }

        public int hashCode() {
            return (31 * ((((((this.itemId * 31) + this.constructionMethod) * 31) + this.dataReferenceIndex) * 31) + ((int) (this.baseOffset ^ (this.baseOffset >>> 32))))) + (this.extents != null ? this.extents.hashCode() : 0);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Item{baseOffset=");
            stringBuilder.append(this.baseOffset);
            stringBuilder.append(", itemId=");
            stringBuilder.append(this.itemId);
            stringBuilder.append(", constructionMethod=");
            stringBuilder.append(this.constructionMethod);
            stringBuilder.append(", dataReferenceIndex=");
            stringBuilder.append(this.dataReferenceIndex);
            stringBuilder.append(", extents=");
            stringBuilder.append(this.extents);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("ItemLocationBox.java", ItemLocationBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 119);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "offsetSize", "", "void"), 123);
        ajc$tjp_10 = factory.a("method-execution", factory.a("1", "createItem", "com.coremedia.iso.boxes.ItemLocationBox", "int:int:int:long:java.util.List", "itemId:constructionMethod:dataReferenceIndex:baseOffset:extents", "", "com.coremedia.iso.boxes.ItemLocationBox$Item"), 160);
        ajc$tjp_11 = factory.a("method-execution", factory.a("1", "createExtent", "com.coremedia.iso.boxes.ItemLocationBox", "long:long:long", "extentOffset:extentLength:extentIndex", "", "com.coremedia.iso.boxes.ItemLocationBox$Extent"), 285);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "getLengthSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 127);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "setLengthSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "lengthSize", "", "void"), 131);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "getBaseOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 135);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "setBaseOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "baseOffsetSize", "", "void"), 139);
        ajc$tjp_6 = factory.a("method-execution", factory.a("1", "getIndexSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 143);
        ajc$tjp_7 = factory.a("method-execution", factory.a("1", "setIndexSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "indexSize", "", "void"), 147);
        ajc$tjp_8 = factory.a("method-execution", factory.a("1", "getItems", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "java.util.List"), 151);
        ajc$tjp_9 = factory.a("method-execution", factory.a("1", "setItems", "com.coremedia.iso.boxes.ItemLocationBox", "java.util.List", "items", "", "void"), 155);
    }

    public ItemLocationBox() {
        super(TYPE);
    }

    protected long getContentSize() {
        long j = 8;
        for (Item size : this.items) {
            j += (long) size.getSize();
        }
        return j;
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.m3303c(byteBuffer, (this.offsetSize << 4) | this.lengthSize);
        if (getVersion() == 1) {
            IsoTypeWriter.m3303c(byteBuffer, (this.baseOffsetSize << 4) | this.indexSize);
        } else {
            IsoTypeWriter.m3303c(byteBuffer, this.baseOffsetSize << 4);
        }
        IsoTypeWriter.m3299b(byteBuffer, this.items.size());
        for (Item content : this.items) {
            content.getContent(byteBuffer);
        }
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        int d = IsoTypeReader.m3284d(byteBuffer);
        this.offsetSize = d >>> 4;
        this.lengthSize = d & 15;
        d = IsoTypeReader.m3284d(byteBuffer);
        this.baseOffsetSize = d >>> 4;
        if (getVersion() == 1) {
            this.indexSize = d & 15;
        }
        d = IsoTypeReader.m3283c(byteBuffer);
        for (int i = 0; i < d; i++) {
            this.items.add(new Item(byteBuffer));
        }
    }

    public int getOffsetSize() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.offsetSize;
    }

    public void setOffsetSize(int i) {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.offsetSize = i;
    }

    public int getLengthSize() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.lengthSize;
    }

    public void setLengthSize(int i) {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.lengthSize = i;
    }

    public int getBaseOffsetSize() {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.baseOffsetSize;
    }

    public void setBaseOffsetSize(int i) {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.baseOffsetSize = i;
    }

    public int getIndexSize() {
        JoinPoint a = Factory.a(ajc$tjp_6, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.indexSize;
    }

    public void setIndexSize(int i) {
        JoinPoint a = Factory.a(ajc$tjp_7, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.indexSize = i;
    }

    public List<Item> getItems() {
        JoinPoint a = Factory.a(ajc$tjp_8, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.items;
    }

    public void setItems(List<Item> list) {
        JoinPoint a = Factory.a(ajc$tjp_9, this, this, list);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.items = list;
    }

    public Item createItem(int i, int i2, int i3, long j, List<Extent> list) {
        JoinPoint a = Factory.a(ajc$tjp_10, this, this, new Object[]{Conversions.a(i), Conversions.a(i2), Conversions.a(i3), Conversions.a(j), list});
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return new Item(i, i2, i3, j, list);
    }

    Item createItem(ByteBuffer byteBuffer) {
        return new Item(byteBuffer);
    }

    public Extent createExtent(long j, long j2, long j3) {
        JoinPoint a = Factory.a(ajc$tjp_11, this, this, new Object[]{Conversions.a(j), Conversions.a(j2), Conversions.a(j3)});
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return new Extent(j, j2, j3);
    }

    Extent createExtent(ByteBuffer byteBuffer) {
        return new Extent(byteBuffer);
    }
}
