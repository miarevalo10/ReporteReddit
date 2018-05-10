package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import java.nio.ByteBuffer;

public abstract class GroupEntry {
    public abstract String mo2526a();

    public abstract void mo2527a(ByteBuffer byteBuffer);

    public abstract ByteBuffer mo2528b();

    public int mo2655c() {
        return mo2528b().limit();
    }
}
