package org.jcodec.codecs.mjpeg;

import java.nio.ByteBuffer;

public class FrameHeader {
    int bitsPerSample;
    Component[] components;
    int headerLength;
    int height;
    int nComp;
    int width;

    public static class Component {
        int index;
        int quantTable;
        int subH;
        int subV;
    }

    public int getHmax() {
        Component[] componentArr = this.components;
        int i = 0;
        int length = componentArr.length;
        int i2 = 0;
        while (i < length) {
            i2 = Math.max(i2, componentArr[i].subH);
            i++;
        }
        return i2;
    }

    public int getVmax() {
        Component[] componentArr = this.components;
        int i = 0;
        int length = componentArr.length;
        int i2 = 0;
        while (i < length) {
            i2 = Math.max(i2, componentArr[i].subV);
            i++;
        }
        return i2;
    }

    public static FrameHeader read(ByteBuffer byteBuffer) {
        FrameHeader frameHeader = new FrameHeader();
        frameHeader.headerLength = byteBuffer.getShort() & 65535;
        frameHeader.bitsPerSample = byteBuffer.get() & 255;
        frameHeader.height = byteBuffer.getShort() & 65535;
        frameHeader.width = byteBuffer.getShort() & 65535;
        frameHeader.nComp = byteBuffer.get() & 255;
        frameHeader.components = new Component[frameHeader.nComp];
        for (int i = 0; i < frameHeader.components.length; i++) {
            Component[] componentArr = frameHeader.components;
            Component component = new Component();
            componentArr[i] = component;
            component.index = byteBuffer.get() & 255;
            int i2 = byteBuffer.get() & 255;
            component.subH = (i2 & 240) >>> 4;
            component.subV = i2 & 15;
            component.quantTable = byteBuffer.get() & 255;
        }
        return frameHeader;
    }
}
