package com.bumptech.glide.load.resource.bitmap;

public abstract class DownsampleStrategy {
    public static final DownsampleStrategy f3518a = new FitCenter();
    public static final DownsampleStrategy f3519b = new CenterOutside();
    public static final DownsampleStrategy f3520c = new AtLeast();
    public static final DownsampleStrategy f3521d = new AtMost();
    public static final DownsampleStrategy f3522e = new CenterInside();
    public static final DownsampleStrategy f3523f = new None();
    public static final DownsampleStrategy f3524g = f3519b;

    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    private static class AtLeast extends DownsampleStrategy {
        AtLeast() {
        }

        public final float mo990a(int i, int i2, int i3, int i4) {
            i = Math.min(i2 / i4, i / i3);
            if (i == 0) {
                return 1.0f;
            }
            return 1065353216 / ((float) Integer.highestOneBit(i));
        }

        public final SampleSizeRounding mo991a() {
            return SampleSizeRounding.QUALITY;
        }
    }

    private static class AtMost extends DownsampleStrategy {
        AtMost() {
        }

        public final float mo990a(int i, int i2, int i3, int i4) {
            i = (int) Math.ceil((double) Math.max(((float) i2) / ((float) i4), ((float) i) / ((float) i3)));
            i3 = 1;
            i2 = Math.max(1, Integer.highestOneBit(i));
            if (i2 >= i) {
                i3 = 0;
            }
            return 1065353216 / ((float) (i2 << i3));
        }

        public final SampleSizeRounding mo991a() {
            return SampleSizeRounding.MEMORY;
        }
    }

    private static class CenterInside extends DownsampleStrategy {
        CenterInside() {
        }

        public final float mo990a(int i, int i2, int i3, int i4) {
            return Math.min(1065353216, a.mo990a(i, i2, i3, i4));
        }

        public final SampleSizeRounding mo991a() {
            return SampleSizeRounding.QUALITY;
        }
    }

    private static class CenterOutside extends DownsampleStrategy {
        CenterOutside() {
        }

        public final float mo990a(int i, int i2, int i3, int i4) {
            return Math.max(((float) i3) / ((float) i), ((float) i4) / ((float) i2));
        }

        public final SampleSizeRounding mo991a() {
            return SampleSizeRounding.QUALITY;
        }
    }

    private static class FitCenter extends DownsampleStrategy {
        FitCenter() {
        }

        public final float mo990a(int i, int i2, int i3, int i4) {
            return Math.min(((float) i3) / ((float) i), ((float) i4) / ((float) i2));
        }

        public final SampleSizeRounding mo991a() {
            return SampleSizeRounding.QUALITY;
        }
    }

    private static class None extends DownsampleStrategy {
        public final float mo990a(int i, int i2, int i3, int i4) {
            return 1.0f;
        }

        None() {
        }

        public final SampleSizeRounding mo991a() {
            return SampleSizeRounding.QUALITY;
        }
    }

    public abstract float mo990a(int i, int i2, int i3, int i4);

    public abstract SampleSizeRounding mo991a();
}
