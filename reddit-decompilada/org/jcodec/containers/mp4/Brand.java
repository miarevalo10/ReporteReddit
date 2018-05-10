package org.jcodec.containers.mp4;

import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.google.android.gms.ads.AdRequest;
import java.util.Arrays;
import org.jcodec.containers.mp4.boxes.FileTypeBox;

public enum Brand {
    MOV("qt  ", AdRequest.MAX_CONTENT_URL_LENGTH, new String[]{"qt  "}),
    MP4("isom", AdRequest.MAX_CONTENT_URL_LENGTH, new String[]{"isom", "iso2", VisualSampleEntry.TYPE3, "mp41"});
    
    private FileTypeBox ftyp;

    private Brand(String str, int i, String[] strArr) {
        this.ftyp = new FileTypeBox(str, i, Arrays.asList(strArr));
    }

    public final FileTypeBox getFileTypeBox() {
        return this.ftyp;
    }
}
