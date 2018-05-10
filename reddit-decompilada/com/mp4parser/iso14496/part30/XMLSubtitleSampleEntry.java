package com.mp4parser.iso14496.part30;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry;
import com.googlecode.mp4parser.DataSource;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public class XMLSubtitleSampleEntry extends AbstractSampleEntry {
    public static final String TYPE = "stpp";
    private String auxiliaryMimeTypes = "";
    private String namespace = "";
    private String schemaLocation = "";

    public XMLSubtitleSampleEntry() {
        super(TYPE);
    }

    public long getSize() {
        int i = 8;
        long containerSize = getContainerSize() + ((long) ((((this.namespace.length() + 8) + this.schemaLocation.length()) + this.auxiliaryMimeTypes.length()) + 3));
        if (this.largeBox || 8 + containerSize >= 4294967296L) {
            i = 16;
        }
        return containerSize + ((long) i);
    }

    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        dataSource.read((ByteBuffer) allocate.rewind());
        allocate.position(6);
        this.dataReferenceIndex = IsoTypeReader.m3283c(allocate);
        long position = dataSource.position();
        ByteBuffer allocate2 = ByteBuffer.allocate(1024);
        dataSource.read((ByteBuffer) allocate2.rewind());
        this.namespace = IsoTypeReader.m3285e((ByteBuffer) allocate2.rewind());
        dataSource.position((((long) this.namespace.length()) + position) + 1);
        dataSource.read((ByteBuffer) allocate2.rewind());
        this.schemaLocation = IsoTypeReader.m3285e((ByteBuffer) allocate2.rewind());
        dataSource.position(((((long) this.namespace.length()) + position) + ((long) this.schemaLocation.length())) + 2);
        dataSource.read((ByteBuffer) allocate2.rewind());
        this.auxiliaryMimeTypes = IsoTypeReader.m3285e((ByteBuffer) allocate2.rewind());
        dataSource.position((((position + ((long) this.namespace.length())) + ((long) this.schemaLocation.length())) + ((long) this.auxiliaryMimeTypes.length())) + 3);
        initContainer(dataSource, j - ((long) ((((byteBuffer.remaining() + this.namespace.length()) + this.schemaLocation.length()) + this.auxiliaryMimeTypes.length()) + 3)), boxParser);
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate((((8 + this.namespace.length()) + this.schemaLocation.length()) + this.auxiliaryMimeTypes.length()) + 3);
        allocate.position(6);
        IsoTypeWriter.m3299b(allocate, this.dataReferenceIndex);
        IsoTypeWriter.m3301b(allocate, this.namespace);
        IsoTypeWriter.m3301b(allocate, this.schemaLocation);
        IsoTypeWriter.m3301b(allocate, this.auxiliaryMimeTypes);
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        writeContainer(writableByteChannel);
    }

    public String getNamespace() {
        return this.namespace;
    }

    public void setNamespace(String str) {
        this.namespace = str;
    }

    public String getSchemaLocation() {
        return this.schemaLocation;
    }

    public void setSchemaLocation(String str) {
        this.schemaLocation = str;
    }

    public String getAuxiliaryMimeTypes() {
        return this.auxiliaryMimeTypes;
    }

    public void setAuxiliaryMimeTypes(String str) {
        this.auxiliaryMimeTypes = str;
    }
}
