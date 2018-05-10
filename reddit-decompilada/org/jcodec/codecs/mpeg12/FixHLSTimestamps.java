package org.jcodec.codecs.mpeg12;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FixHLSTimestamps extends FixTimestamp {
    private long[] lastPts = new long[256];

    public static void main(String[] strArr) throws IOException {
        new FixHLSTimestamps().doIt(strArr[0], Integer.parseInt(strArr[1]));
    }

    private void doIt(String str, int i) throws IOException {
        Arrays.fill(this.lastPts, -1);
        while (true) {
            File file = new File(String.format(str, new Object[]{Integer.valueOf(i)}));
            System.out.println(file.getAbsolutePath());
            if (file.exists()) {
                fix(file);
                i++;
            } else {
                return;
            }
        }
    }

    protected long doWithTimestamp(int i, long j, boolean z) {
        if (!z) {
            return j;
        }
        if (this.lastPts[i] == -1) {
            this.lastPts[i] = j;
            return j;
        } else if (isVideo(i) != null) {
            j = this.lastPts;
            j[i] = j[i] + 3003;
            return this.lastPts[i];
        } else if (isAudio(i) != null) {
            j = this.lastPts;
            j[i] = j[i] + 1920;
            return this.lastPts[i];
        } else {
            throw new RuntimeException("Unexpected!!!");
        }
    }
}
