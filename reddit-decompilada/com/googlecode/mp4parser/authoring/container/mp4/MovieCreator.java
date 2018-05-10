package com.googlecode.mp4parser.authoring.container.mp4;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.boxes.SchemeTypeBox;
import com.coremedia.iso.boxes.TrackBox;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.authoring.CencMp4TrackImplImpl;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Mp4TrackImpl;
import com.googlecode.mp4parser.util.Path;
import java.io.IOException;

public class MovieCreator {
    public static Movie m7659a(DataSource dataSource) throws IOException {
        IsoFile isoFile = new IsoFile(dataSource);
        Movie movie = new Movie();
        for (AbstractContainerBox abstractContainerBox : isoFile.m17058a().getBoxes(TrackBox.class)) {
            SchemeTypeBox schemeTypeBox = (SchemeTypeBox) Path.m7716a(abstractContainerBox, "mdia[0]/minf[0]/stbl[0]/stsd[0]/enc.[0]/sinf[0]/schm[0]");
            StringBuilder stringBuilder;
            if (schemeTypeBox == null || !(schemeTypeBox.getSchemeType().equals("cenc") || schemeTypeBox.getSchemeType().equals("cbc1"))) {
                stringBuilder = new StringBuilder(String.valueOf(dataSource.toString()));
                stringBuilder.append("[");
                stringBuilder.append(abstractContainerBox.getTrackHeaderBox().getTrackId());
                stringBuilder.append("]");
                movie.m7629a(new Mp4TrackImpl(stringBuilder.toString(), abstractContainerBox, new IsoFile[0]));
            } else {
                stringBuilder = new StringBuilder(String.valueOf(dataSource.toString()));
                stringBuilder.append("[");
                stringBuilder.append(abstractContainerBox.getTrackHeaderBox().getTrackId());
                stringBuilder.append("]");
                movie.m7629a(new CencMp4TrackImplImpl(stringBuilder.toString(), abstractContainerBox, new IsoFile[0]));
            }
        }
        movie.f8886a = isoFile.m17058a().getMovieHeaderBox().getMatrix();
        return movie;
    }
}
