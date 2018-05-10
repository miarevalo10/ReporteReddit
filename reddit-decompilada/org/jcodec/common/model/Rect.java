package org.jcodec.common.model;

public class Rect {
    private int height;
    private int width;
    private int f26808x;
    private int f26809y;

    public Rect(int i, int i2, int i3, int i4) {
        this.f26808x = i;
        this.f26809y = i2;
        this.width = i3;
        this.height = i4;
    }

    public int getX() {
        return this.f26808x;
    }

    public int getY() {
        return this.f26809y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int hashCode() {
        return (31 * (((((this.height + 31) * 31) + this.width) * 31) + this.f26808x)) + this.f26809y;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Rect rect = (Rect) obj;
        return this.height == rect.height && this.width == rect.width && this.f26808x == rect.f26808x && this.f26809y == rect.f26809y;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Rect [x=");
        stringBuilder.append(this.f26808x);
        stringBuilder.append(", y=");
        stringBuilder.append(this.f26809y);
        stringBuilder.append(", width=");
        stringBuilder.append(this.width);
        stringBuilder.append(", height=");
        stringBuilder.append(this.height);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
