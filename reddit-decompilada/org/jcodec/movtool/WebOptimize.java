package org.jcodec.movtool;

import java.io.File;
import java.io.IOException;
import org.jcodec.containers.mp4.MP4Util;

public class WebOptimize {
    public static void main(String[] strArr) throws IOException {
        if (strArr.length <= 0) {
            System.out.println("Syntax: optimize <movie>");
            System.exit(-1);
        }
        File file = new File(strArr[0]);
        strArr = Remux.hidFile(file);
        file.renameTo(strArr);
        try {
            new Flattern().flattern(MP4Util.createRefMovie(strArr), file);
        } catch (Throwable th) {
            th.printStackTrace();
            File parentFile = file.getParentFile();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(file.getName());
            stringBuilder.append(".error");
            file.renameTo(new File(parentFile, stringBuilder.toString()));
            strArr.renameTo(file);
        }
    }
}
