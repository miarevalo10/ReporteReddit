package org.jcodec.movtool;

import java.util.List;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.MovieFragmentBox;

public class CompoundMP4Edit implements MP4Edit {
    private List<MP4Edit> edits;

    public CompoundMP4Edit(List<MP4Edit> list) {
        this.edits = list;
    }

    public void apply(MovieBox movieBox, MovieFragmentBox[] movieFragmentBoxArr) {
        for (MP4Edit apply : this.edits) {
            apply.apply(movieBox, movieFragmentBoxArr);
        }
    }

    public void apply(MovieBox movieBox) {
        for (MP4Edit apply : this.edits) {
            apply.apply(movieBox);
        }
    }
}
