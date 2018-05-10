package com.coremedia.iso.boxes.sampleentry;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.util.CastUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public class Ovc1VisualSampleEntryImpl extends AbstractSampleEntry {
    public static final String TYPE = "ovc1";
    private byte[] vc1Content = new byte[0];

    public Ovc1VisualSampleEntryImpl() {
        super(TYPE);
    }

    public byte[] getVc1Content() {
        return this.vc1Content;
    }

    public void setVc1Content(byte[] bArr) {
        this.vc1Content = bArr;
    }

    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        byteBuffer = ByteBuffer.allocate(CastUtils.m7705a(j));
        dataSource.read(byteBuffer);
        byteBuffer.position(6);
        this.dataReferenceIndex = IsoTypeReader.m3283c(byteBuffer);
        this.vc1Content = new byte[byteBuffer.remaining()];
        byteBuffer.get(this.vc1Content);
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.position(6);
        IsoTypeWriter.m3299b(allocate, this.dataReferenceIndex);
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        writableByteChannel.write(ByteBuffer.wrap(this.vc1Content));
    }

    public long getSize() {
        int i = 16;
        if (!this.largeBox) {
            if (((long) (this.vc1Content.length + 16)) < 4294967296L) {
                i = 8;
            }
        }
        return (((long) i) + ((long) this.vc1Content.length)) + 8;
    }
}
