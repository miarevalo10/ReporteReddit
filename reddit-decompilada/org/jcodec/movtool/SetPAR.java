package org.jcodec.movtool;

import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.googlecode.mp4parser.boxes.apple.TrackApertureModeDimensionAtom;
import java.io.File;
import org.jcodec.common.model.Rational;
import org.jcodec.common.model.Size;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.MovieFragmentBox;
import org.jcodec.containers.mp4.boxes.SampleDescriptionBox;
import org.jcodec.containers.mp4.boxes.VideoSampleEntry;

public class SetPAR {
    public static void main(String[] strArr) throws Exception {
        if (strArr.length < 2) {
            System.out.println("Syntax: setpasp <movie> <num:den>");
            System.exit(-1);
        }
        final Rational parse = Rational.parse(strArr[1]);
        new InplaceMP4Editor().modify(new File(strArr[0]), new MP4Edit() {
            public final void apply(MovieBox movieBox) {
                movieBox = movieBox.getVideoTrack();
                movieBox.setPAR(parse);
                Box box = (Box) ((SampleDescriptionBox) Box.findFirst(movieBox, SampleDescriptionBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, com.coremedia.iso.boxes.SampleDescriptionBox.TYPE)).getBoxes().get(0);
                if (box != null && (box instanceof VideoSampleEntry)) {
                    VideoSampleEntry videoSampleEntry = (VideoSampleEntry) box;
                    int width = videoSampleEntry.getWidth();
                    int height = videoSampleEntry.getHeight();
                    int num = (parse.getNum() * width) / parse.getDen();
                    movieBox.getTrackHeader().setWidth((float) num);
                    if (Box.findFirst(movieBox, TrackApertureModeDimensionAtom.TYPE) != null) {
                        movieBox.setAperture(new Size(width, height), new Size(num, height));
                    }
                }
            }

            public final void apply(MovieBox movieBox, MovieFragmentBox[] movieFragmentBoxArr) {
                throw new RuntimeException("Unsupported");
            }
        });
    }
}
