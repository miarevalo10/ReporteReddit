package android.support.v7.app;

public class TwilightCalculator {
    private static TwilightCalculator f1841d;
    public long f1842a;
    public long f1843b;
    public int f1844c;

    TwilightCalculator() {
    }

    public static TwilightCalculator m1562a() {
        if (f1841d == null) {
            f1841d = new TwilightCalculator();
        }
        return f1841d;
    }

    public final void m1563a(long j, double d, double d2) {
        TwilightCalculator twilightCalculator = this;
        float f = ((float) (j - 946728000000L)) / 8.64E7f;
        float f2 = 6.24006f + (0.01720197f * f);
        double d3 = (double) f2;
        double sin = (((((0.03341960161924362d * Math.sin(d3)) + d3) + (3.4906598739326E-4d * Math.sin((double) (2.0f * f2)))) + (5.236000106378924E-6d * Math.sin((double) (3.0f * f2)))) + 1.796593063d) + 3.141592653589793d;
        double d4 = (-d2) / 360.0d;
        double round = ((((double) (((float) Math.round(((double) (f - 9.0E-4f)) - d4)) + 9.0E-4f)) + d4) + (0.0053d * Math.sin(d3))) + (-0.0069d * Math.sin(2.0d * sin));
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d5 = 0.01745329238474369d * d;
        sin = (Math.sin(-0.10471975803375244d) - (Math.sin(d5) * Math.sin(asin))) / (Math.cos(d5) * Math.cos(asin));
        if (sin >= 1.0d) {
            twilightCalculator.f1844c = 1;
            twilightCalculator.f1842a = -1;
            twilightCalculator.f1843b = -1;
        } else if (sin <= -1.0d) {
            twilightCalculator.f1844c = 0;
            twilightCalculator.f1842a = -1;
            twilightCalculator.f1843b = -1;
        } else {
            d5 = (double) ((float) (Math.acos(sin) / 6.283185307179586d));
            twilightCalculator.f1842a = Math.round((round + d5) * 8.64E7d) + 946728000000L;
            twilightCalculator.f1843b = Math.round((round - d5) * 8.64E7d) + 946728000000L;
            if (twilightCalculator.f1843b >= j || twilightCalculator.f1842a <= j) {
                twilightCalculator.f1844c = 1;
            } else {
                twilightCalculator.f1844c = 0;
            }
        }
    }
}
