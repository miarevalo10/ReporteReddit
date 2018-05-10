package com.googlecode.mp4parser.h264.model;

public class ChromaFormat {
    public static ChromaFormat f9000a = new ChromaFormat(0, 0, 0);
    public static ChromaFormat f9001b = new ChromaFormat(1, 2, 2);
    public static ChromaFormat f9002c = new ChromaFormat(2, 2, 1);
    public static ChromaFormat f9003d = new ChromaFormat(3, 1, 1);
    private int f9004e;
    private int f9005f;
    private int f9006g;

    private ChromaFormat(int i, int i2, int i3) {
        this.f9004e = i;
        this.f9005f = i2;
        this.f9006g = i3;
    }

    public static ChromaFormat m7699a(int i) {
        if (i == f9000a.f9004e) {
            return f9000a;
        }
        if (i == f9001b.f9004e) {
            return f9001b;
        }
        if (i == f9002c.f9004e) {
            return f9002c;
        }
        return i == f9003d.f9004e ? f9003d : 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ChromaFormat{\nid=");
        stringBuilder.append(this.f9004e);
        stringBuilder.append(",\n subWidth=");
        stringBuilder.append(this.f9005f);
        stringBuilder.append(",\n subHeight=");
        stringBuilder.append(this.f9006g);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
