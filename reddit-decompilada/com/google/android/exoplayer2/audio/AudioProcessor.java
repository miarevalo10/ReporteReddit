package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public interface AudioProcessor {
    public static final ByteBuffer f4104a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    public static final class UnhandledFormatException extends Exception {
        public UnhandledFormatException(int i, int i2, int i3) {
            StringBuilder stringBuilder = new StringBuilder("Unhandled format: ");
            stringBuilder.append(i);
            stringBuilder.append(" Hz, ");
            stringBuilder.append(i2);
            stringBuilder.append(" channels in encoding ");
            stringBuilder.append(i3);
            super(stringBuilder.toString());
        }
    }

    void mo1308a(ByteBuffer byteBuffer);

    boolean mo1309a();

    boolean mo1310a(int i, int i2, int i3) throws UnhandledFormatException;

    int mo1311b();

    int mo1312c();

    void mo1313d();

    ByteBuffer mo1314e();

    boolean mo1315f();

    void mo1316g();

    void mo1317h();
}
