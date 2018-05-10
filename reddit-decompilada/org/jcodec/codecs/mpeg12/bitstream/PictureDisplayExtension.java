package org.jcodec.codecs.mpeg12.bitstream;

import java.nio.ByteBuffer;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;
import org.jcodec.common.model.Point;

public class PictureDisplayExtension implements MPEGHeader {
    public Point[] frame_centre_offsets;

    public static PictureDisplayExtension read(BitReader bitReader, SequenceExtension sequenceExtension, PictureCodingExtension pictureCodingExtension) {
        PictureDisplayExtension pictureDisplayExtension = new PictureDisplayExtension();
        pictureDisplayExtension.frame_centre_offsets = new Point[numberOfFrameCentreOffsets(sequenceExtension, pictureCodingExtension)];
        for (sequenceExtension = null; sequenceExtension < pictureDisplayExtension.frame_centre_offsets.length; sequenceExtension++) {
            int readNBit = bitReader.readNBit(16);
            bitReader.read1Bit();
            pictureCodingExtension = bitReader.readNBit(16);
            bitReader.read1Bit();
            pictureDisplayExtension.frame_centre_offsets[sequenceExtension] = new Point(readNBit, pictureCodingExtension);
        }
        return pictureDisplayExtension;
    }

    private static int numberOfFrameCentreOffsets(SequenceExtension sequenceExtension, PictureCodingExtension pictureCodingExtension) {
        if (sequenceExtension != null) {
            if (pictureCodingExtension != null) {
                if (sequenceExtension.progressive_sequence == 1) {
                    if (pictureCodingExtension.repeat_first_field == 1) {
                        return pictureCodingExtension.top_field_first == 1 ? 3 : 2;
                    } else {
                        return 1;
                    }
                } else if (pictureCodingExtension.picture_structure != 3) {
                    return 1;
                } else {
                    return pictureCodingExtension.repeat_first_field == 1 ? 3 : 2;
                }
            }
        }
        throw new IllegalArgumentException("PictureDisplayExtension requires SequenceExtension and PictureCodingExtension to be present");
    }

    public void write(ByteBuffer byteBuffer) {
        BitWriter bitWriter = new BitWriter(byteBuffer);
        bitWriter.writeNBit(7, 4);
        for (Point point : this.frame_centre_offsets) {
            bitWriter.writeNBit(point.getX(), 16);
            bitWriter.writeNBit(point.getY(), 16);
        }
        bitWriter.flush();
    }
}
