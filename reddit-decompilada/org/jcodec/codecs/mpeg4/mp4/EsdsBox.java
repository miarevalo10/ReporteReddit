package org.jcodec.codecs.mpeg4.mp4;

import com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox;
import java.nio.ByteBuffer;
import org.jcodec.codecs.aac.ADTSParser;
import org.jcodec.codecs.mpeg4.es.DecoderConfig;
import org.jcodec.codecs.mpeg4.es.DecoderSpecific;
import org.jcodec.codecs.mpeg4.es.Descriptor;
import org.jcodec.codecs.mpeg4.es.ES;
import org.jcodec.codecs.mpeg4.es.SL;
import org.jcodec.common.io.BitWriter;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.FullBox;
import org.jcodec.containers.mp4.boxes.Header;

public class EsdsBox extends FullBox {
    private int avgBitrate;
    private int bufSize;
    private int maxBitrate;
    private int objectType;
    private ByteBuffer streamInfo;
    private int trackId;

    public static String fourcc() {
        return ESDescriptorBox.TYPE;
    }

    public EsdsBox(Header header) {
        super(header);
    }

    public EsdsBox() {
        super(new Header(fourcc()));
    }

    public EsdsBox(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5) {
        super(new Header(fourcc()));
        this.objectType = i;
        this.bufSize = i2;
        this.maxBitrate = i3;
        this.avgBitrate = i4;
        this.trackId = i5;
        this.streamInfo = byteBuffer;
    }

    protected void doWrite(ByteBuffer byteBuffer) {
        super.doWrite(byteBuffer);
        if (this.streamInfo == null || this.streamInfo.remaining() <= 0) {
            new ES(this.trackId, new DecoderConfig(this.objectType, this.bufSize, this.maxBitrate, this.avgBitrate, new Descriptor[0]), new SL()).write(byteBuffer);
            return;
        }
        int i = this.trackId;
        Descriptor[] descriptorArr = new Descriptor[2];
        descriptorArr[0] = new DecoderConfig(this.objectType, this.bufSize, this.maxBitrate, this.avgBitrate, new DecoderSpecific(this.streamInfo));
        descriptorArr[1] = new SL();
        new ES(i, descriptorArr).write(byteBuffer);
    }

    public void parse(ByteBuffer byteBuffer) {
        super.parse(byteBuffer);
        ES es = (ES) Descriptor.read(byteBuffer);
        this.trackId = es.getTrackId();
        DecoderConfig decoderConfig = (DecoderConfig) Descriptor.find(es, DecoderConfig.class, DecoderConfig.tag());
        this.objectType = decoderConfig.getObjectType();
        this.bufSize = decoderConfig.getBufSize();
        this.maxBitrate = decoderConfig.getMaxBitrate();
        this.avgBitrate = decoderConfig.getAvgBitrate();
        this.streamInfo = ((DecoderSpecific) Descriptor.find(decoderConfig, DecoderSpecific.class, DecoderSpecific.tag())).getData();
    }

    public ByteBuffer getStreamInfo() {
        return this.streamInfo;
    }

    public int getObjectType() {
        return this.objectType;
    }

    public int getBufSize() {
        return this.bufSize;
    }

    public int getMaxBitrate() {
        return this.maxBitrate;
    }

    public int getAvgBitrate() {
        return this.avgBitrate;
    }

    public int getTrackId() {
        return this.trackId;
    }

    public static Box fromADTS(ADTSParser.Header header) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        BitWriter bitWriter = new BitWriter(allocate);
        bitWriter.writeNBit(header.getObjectType(), 5);
        bitWriter.writeNBit(header.getSamplingIndex(), 4);
        bitWriter.writeNBit(header.getChanConfig(), 4);
        bitWriter.flush();
        allocate.clear();
        return new EsdsBox(allocate, header.getObjectType() << 5, 0, 210750, 133350, 2);
    }
}
