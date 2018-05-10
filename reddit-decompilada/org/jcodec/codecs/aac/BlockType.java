package org.jcodec.codecs.aac;

public enum BlockType {
    TYPE_SCE(0),
    TYPE_CPE(1),
    TYPE_CCE(2),
    TYPE_LFE(3),
    TYPE_DSE(4),
    TYPE_PCE(5),
    TYPE_FIL(6),
    TYPE_END(7);
    
    private int code;

    public static BlockType fromCode(long j) {
        return null;
    }

    private BlockType(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }
}
