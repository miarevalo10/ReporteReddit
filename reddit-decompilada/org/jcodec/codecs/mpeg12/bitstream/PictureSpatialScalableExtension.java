package org.jcodec.codecs.mpeg12.bitstream;

import java.nio.ByteBuffer;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;

public class PictureSpatialScalableExtension implements MPEGHeader {
    public int lower_layer_deinterlaced_field_select;
    public int lower_layer_horizontal_offset;
    public int lower_layer_progressive_frame;
    public int lower_layer_temporal_reference;
    public int lower_layer_vertical_offset;
    public int spatial_temporal_weight_code_table_index;

    public static PictureSpatialScalableExtension read(BitReader bitReader) {
        PictureSpatialScalableExtension pictureSpatialScalableExtension = new PictureSpatialScalableExtension();
        pictureSpatialScalableExtension.lower_layer_temporal_reference = bitReader.readNBit(10);
        bitReader.read1Bit();
        pictureSpatialScalableExtension.lower_layer_horizontal_offset = bitReader.readNBit(15);
        bitReader.read1Bit();
        pictureSpatialScalableExtension.lower_layer_vertical_offset = bitReader.readNBit(15);
        pictureSpatialScalableExtension.spatial_temporal_weight_code_table_index = bitReader.readNBit(2);
        pictureSpatialScalableExtension.lower_layer_progressive_frame = bitReader.read1Bit();
        pictureSpatialScalableExtension.lower_layer_deinterlaced_field_select = bitReader.read1Bit();
        return pictureSpatialScalableExtension;
    }

    public void write(ByteBuffer byteBuffer) {
        BitWriter bitWriter = new BitWriter(byteBuffer);
        bitWriter.writeNBit(9, 4);
        bitWriter.writeNBit(this.lower_layer_temporal_reference, 10);
        bitWriter.write1Bit(1);
        bitWriter.writeNBit(this.lower_layer_horizontal_offset, 15);
        bitWriter.write1Bit(1);
        bitWriter.writeNBit(this.lower_layer_vertical_offset, 15);
        bitWriter.writeNBit(this.spatial_temporal_weight_code_table_index, 2);
        bitWriter.write1Bit(this.lower_layer_progressive_frame);
        bitWriter.write1Bit(this.lower_layer_deinterlaced_field_select);
        bitWriter.flush();
    }
}
