package org.jcodec.containers.mp4.boxes;

public class MovieExtendsBox extends NodeBox {
    public static String fourcc() {
        return com.coremedia.iso.boxes.fragment.MovieExtendsBox.TYPE;
    }

    public MovieExtendsBox() {
        super(new Header(fourcc()));
    }
}
