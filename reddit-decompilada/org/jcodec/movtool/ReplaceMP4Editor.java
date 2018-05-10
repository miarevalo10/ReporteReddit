package org.jcodec.movtool;

import java.io.File;
import java.io.IOException;
import org.jcodec.containers.mp4.MP4Util;
import org.jcodec.containers.mp4.boxes.MovieBox;

public class ReplaceMP4Editor {
    public void modifyOrReplace(File file, MP4Edit mP4Edit) throws IOException {
        if (!new InplaceMP4Editor().modify(file, mP4Edit)) {
            replace(file, mP4Edit);
        }
    }

    public void replace(File file, MP4Edit mP4Edit) throws IOException {
        File parentFile = file.getParentFile();
        StringBuilder stringBuilder = new StringBuilder(".");
        stringBuilder.append(file.getName());
        File file2 = new File(parentFile, stringBuilder.toString());
        copy(file, file2, mP4Edit);
        file2.renameTo(file);
    }

    public void copy(File file, File file2, MP4Edit mP4Edit) throws IOException {
        MovieBox createRefMovie = MP4Util.createRefMovie(file);
        mP4Edit.apply(createRefMovie);
        new Flattern().flattern(createRefMovie, file2);
    }
}
