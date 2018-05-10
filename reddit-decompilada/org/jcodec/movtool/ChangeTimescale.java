package org.jcodec.movtool;

import com.coremedia.iso.boxes.MediaBox;
import java.io.File;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.MediaHeaderBox;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.MovieFragmentBox;
import org.jcodec.containers.mp4.boxes.NodeBox;

public class ChangeTimescale {
    public static void main(String[] strArr) throws Exception {
        if (strArr.length < 2) {
            System.out.println("Syntax: chts <movie> <timescale>");
            System.exit(-1);
        }
        final int parseInt = Integer.parseInt(strArr[1]);
        if (parseInt < 600) {
            System.out.println("Could not set timescale < 600");
            System.exit(-1);
        }
        new InplaceMP4Editor().modify(new File(strArr[0]), new MP4Edit() {
            public final void apply(MovieBox movieBox) {
                NodeBox videoTrack = movieBox.getVideoTrack();
                int timescale = ((MediaHeaderBox) Box.findFirst(videoTrack, MediaHeaderBox.class, MediaBox.TYPE, com.coremedia.iso.boxes.MediaHeaderBox.TYPE)).getTimescale();
                if (timescale > parseInt) {
                    StringBuilder stringBuilder = new StringBuilder("Old timescale (");
                    stringBuilder.append(timescale);
                    stringBuilder.append(") is greater then new timescale (");
                    stringBuilder.append(parseInt);
                    stringBuilder.append("), not touching.");
                    throw new RuntimeException(stringBuilder.toString());
                }
                videoTrack.fixMediaTimescale(parseInt);
                movieBox.fixTimescale(parseInt);
            }

            public final void apply(MovieBox movieBox, MovieFragmentBox[] movieFragmentBoxArr) {
                throw new RuntimeException("Unsupported");
            }
        });
    }
}
