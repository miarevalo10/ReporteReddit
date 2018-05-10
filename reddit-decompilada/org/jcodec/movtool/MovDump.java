package org.jcodec.movtool;

import com.coremedia.iso.boxes.FileTypeBox;
import com.coremedia.iso.boxes.MovieBox;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.jcodec.common.NIOUtils;
import org.jcodec.containers.mp4.MP4Util;
import org.jcodec.containers.mp4.MP4Util.Atom;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.NodeBox;

public class MovDump {
    public static void main(String[] strArr) throws Exception {
        if (strArr.length <= 0) {
            System.out.println("Syntax: movdump [options] <filename>");
            System.out.println("Options: \n\t-f <filename> save header to a file\n\t-a <atom name> dump only a specific atom\n");
            return;
        }
        int i = 0;
        File file = null;
        String str = null;
        while (i < strArr.length) {
            if (!"-f".equals(strArr[i])) {
                if (!"-a".equals(strArr[i])) {
                    break;
                }
                i++;
                int i2 = i + 1;
                str = strArr[i];
                i = i2;
            } else {
                i++;
                int i3 = i + 1;
                file = new File(strArr[i]);
                i = i3;
            }
        }
        File file2 = new File(strArr[i]);
        if (file != null) {
            dumpHeader(file, file2);
        }
        if (str == null) {
            System.out.println(print(file2));
            return;
        }
        strArr = print(file2, str);
        if (strArr != null) {
            System.out.println(strArr);
        }
    }

    private static void dumpHeader(File file, File file2) throws IOException, FileNotFoundException {
        Throwable th;
        try {
            file2 = NIOUtils.readableFileChannel(file2);
            try {
                file = NIOUtils.writableFileChannel(file);
                try {
                    for (Atom atom : MP4Util.getRootAtoms(file2)) {
                        String fourcc = atom.getHeader().getFourcc();
                        if (MovieBox.TYPE.equals(fourcc) || FileTypeBox.TYPE.equals(fourcc)) {
                            atom.copy(file2, file);
                        }
                    }
                    file2.close();
                    file.close();
                } catch (Throwable th2) {
                    th = th2;
                    file2.close();
                    file.close();
                    throw th;
                }
            } catch (File file3) {
                th = file3;
                file3 = null;
                file2.close();
                file3.close();
                throw th;
            }
        } catch (File file32) {
            file2 = null;
            th = file32;
            file32 = file2;
            file2.close();
            file32.close();
            throw th;
        }
    }

    public static String print(File file) throws IOException {
        return MP4Util.parseMovie(file).toString();
    }

    private static Box findDeep(NodeBox nodeBox, String str) {
        for (Box box : nodeBox.getBoxes()) {
            Box box2;
            if (str.equalsIgnoreCase(box2.getFourcc())) {
                return box2;
            }
            if (box2 instanceof NodeBox) {
                box2 = findDeep((NodeBox) box2, str);
                if (box2 != null) {
                    return box2;
                }
            }
        }
        return null;
    }

    public static String print(File file, String str) throws IOException {
        file = findDeep(MP4Util.parseMovie(file), str);
        if (file != null) {
            return file.toString();
        }
        file = System.out;
        StringBuilder stringBuilder = new StringBuilder("Atom ");
        stringBuilder.append(str);
        stringBuilder.append(" not found.");
        file.println(stringBuilder.toString());
        return null;
    }
}
