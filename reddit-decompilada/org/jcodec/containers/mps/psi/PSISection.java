package org.jcodec.containers.mps.psi;

import java.nio.ByteBuffer;

public class PSISection {
    private int currentNextIndicator;
    private int lastSectionNumber;
    private int sectionNumber;
    private int specificId;
    private int tableId;
    private int versionNumber;

    public PSISection(PSISection pSISection) {
        this(pSISection.tableId, pSISection.specificId, pSISection.versionNumber, pSISection.currentNextIndicator, pSISection.sectionNumber, pSISection.lastSectionNumber);
    }

    public PSISection(int i, int i2, int i3, int i4, int i5, int i6) {
        this.tableId = i;
        this.specificId = i2;
        this.versionNumber = i3;
        this.currentNextIndicator = i4;
        this.sectionNumber = i5;
        this.lastSectionNumber = i6;
    }

    public static PSISection parse(ByteBuffer byteBuffer) {
        int i = byteBuffer.get() & 255;
        int i2 = byteBuffer.getShort() & 65535;
        if ((49152 & i2) != 32768) {
            throw new RuntimeException("Invalid section data");
        }
        byteBuffer.limit(byteBuffer.position() + (i2 & 4095));
        i2 = byteBuffer.get() & 255;
        return new PSISection(i, byteBuffer.getShort() & 65535, (i2 >> 1) & 31, i2 & 1, byteBuffer.get() & 255, byteBuffer.get() & 255);
    }

    public int getTableId() {
        return this.tableId;
    }

    public int getSpecificId() {
        return this.specificId;
    }

    public int getVersionNumber() {
        return this.versionNumber;
    }

    public int getCurrentNextIndicator() {
        return this.currentNextIndicator;
    }

    public int getSectionNumber() {
        return this.sectionNumber;
    }

    public int getLastSectionNumber() {
        return this.lastSectionNumber;
    }
}
