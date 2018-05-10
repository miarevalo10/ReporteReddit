package org.jcodec.codecs.mjpeg;

import java.nio.ByteBuffer;

public class ScanHeader {
    int ah;
    int al;
    Component[] components;
    int ls;
    int ns;
    int se;
    int ss;

    public static class Component {
        int cs;
        int ta;
        int td;
    }

    public boolean isInterleaved() {
        return this.ns > 1;
    }

    public static ScanHeader read(ByteBuffer byteBuffer) {
        ScanHeader scanHeader = new ScanHeader();
        scanHeader.ls = byteBuffer.getShort() & 65535;
        scanHeader.ns = byteBuffer.get() & 255;
        scanHeader.components = new Component[scanHeader.ns];
        for (int i = 0; i < scanHeader.components.length; i++) {
            Component[] componentArr = scanHeader.components;
            Component component = new Component();
            componentArr[i] = component;
            component.cs = byteBuffer.get() & 255;
            int i2 = byteBuffer.get() & 255;
            component.td = (i2 & 240) >>> 4;
            component.ta = i2 & 15;
        }
        scanHeader.ss = byteBuffer.get() & 255;
        scanHeader.se = byteBuffer.get() & 255;
        byteBuffer = byteBuffer.get() & 255;
        scanHeader.ah = (byteBuffer & 240) >>> 4;
        scanHeader.al = byteBuffer & 15;
        return scanHeader;
    }
}
