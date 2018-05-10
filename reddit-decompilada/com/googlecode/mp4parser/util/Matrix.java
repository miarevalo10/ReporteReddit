package com.googlecode.mp4parser.util;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import java.nio.ByteBuffer;

public class Matrix {
    public static final Matrix f9068j = new Matrix(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final Matrix f9069k = new Matrix(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final Matrix f9070l = new Matrix(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final Matrix f9071m = new Matrix(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    double f9072a;
    double f9073b;
    double f9074c;
    double f9075d;
    double f9076e;
    double f9077f;
    double f9078g;
    double f9079h;
    double f9080i;

    private Matrix(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.f9072a = d5;
        this.f9073b = d6;
        this.f9074c = d7;
        this.f9075d = d;
        this.f9076e = d2;
        this.f9077f = d3;
        this.f9078g = d4;
        this.f9079h = d8;
        this.f9080i = d9;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                Matrix matrix = (Matrix) obj;
                return Double.compare(matrix.f9075d, this.f9075d) == 0 && Double.compare(matrix.f9076e, this.f9076e) == 0 && Double.compare(matrix.f9077f, this.f9077f) == 0 && Double.compare(matrix.f9078g, this.f9078g) == 0 && Double.compare(matrix.f9079h, this.f9079h) == 0 && Double.compare(matrix.f9080i, this.f9080i) == 0 && Double.compare(matrix.f9072a, this.f9072a) == 0 && Double.compare(matrix.f9073b, this.f9073b) == 0 && Double.compare(matrix.f9074c, this.f9074c) == null;
            }
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f9072a);
        int i = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        long doubleToLongBits2 = Double.doubleToLongBits(this.f9073b);
        i = (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        doubleToLongBits2 = Double.doubleToLongBits(this.f9074c);
        i = (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        doubleToLongBits2 = Double.doubleToLongBits(this.f9075d);
        i = (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        doubleToLongBits2 = Double.doubleToLongBits(this.f9076e);
        i = (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        doubleToLongBits2 = Double.doubleToLongBits(this.f9077f);
        i = (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        doubleToLongBits2 = Double.doubleToLongBits(this.f9078g);
        i = (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        doubleToLongBits2 = Double.doubleToLongBits(this.f9079h);
        i = (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        doubleToLongBits2 = Double.doubleToLongBits(this.f9080i);
        return (31 * i) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public String toString() {
        if (equals(f9068j)) {
            return "Rotate 0°";
        }
        if (equals(f9069k)) {
            return "Rotate 90°";
        }
        if (equals(f9070l)) {
            return "Rotate 180°";
        }
        if (equals(f9071m)) {
            return "Rotate 270°";
        }
        StringBuilder stringBuilder = new StringBuilder("Matrix{u=");
        stringBuilder.append(this.f9072a);
        stringBuilder.append(", v=");
        stringBuilder.append(this.f9073b);
        stringBuilder.append(", w=");
        stringBuilder.append(this.f9074c);
        stringBuilder.append(", a=");
        stringBuilder.append(this.f9075d);
        stringBuilder.append(", b=");
        stringBuilder.append(this.f9076e);
        stringBuilder.append(", c=");
        stringBuilder.append(this.f9077f);
        stringBuilder.append(", d=");
        stringBuilder.append(this.f9078g);
        stringBuilder.append(", tx=");
        stringBuilder.append(this.f9079h);
        stringBuilder.append(", ty=");
        stringBuilder.append(this.f9080i);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static Matrix m7713a(ByteBuffer byteBuffer) {
        double g = IsoTypeReader.m3287g(byteBuffer);
        double g2 = IsoTypeReader.m3287g(byteBuffer);
        double h = IsoTypeReader.m3288h(byteBuffer);
        return new Matrix(g, g2, IsoTypeReader.m3287g(byteBuffer), IsoTypeReader.m3287g(byteBuffer), h, IsoTypeReader.m3288h(byteBuffer), IsoTypeReader.m3288h(byteBuffer), IsoTypeReader.m3287g(byteBuffer), IsoTypeReader.m3287g(byteBuffer));
    }

    public final void m7714b(ByteBuffer byteBuffer) {
        IsoTypeWriter.m3294a(byteBuffer, this.f9075d);
        IsoTypeWriter.m3294a(byteBuffer, this.f9076e);
        IsoTypeWriter.m3298b(byteBuffer, this.f9072a);
        IsoTypeWriter.m3294a(byteBuffer, this.f9077f);
        IsoTypeWriter.m3294a(byteBuffer, this.f9078g);
        IsoTypeWriter.m3298b(byteBuffer, this.f9073b);
        IsoTypeWriter.m3294a(byteBuffer, this.f9079h);
        IsoTypeWriter.m3294a(byteBuffer, this.f9080i);
        IsoTypeWriter.m3298b(byteBuffer, this.f9074c);
    }
}
