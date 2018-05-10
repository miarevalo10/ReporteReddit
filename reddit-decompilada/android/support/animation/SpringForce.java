package android.support.animation;

public final class SpringForce {
    double f38a = Math.sqrt(1500.0d);
    double f39b = 0.5d;
    double f40c;
    double f41d;
    double f42e = Double.MAX_VALUE;
    private boolean f43f = false;
    private double f44g;
    private double f45h;
    private double f46i;
    private final MassState f47j = new MassState();

    public SpringForce(float f) {
        this.f42e = (double) f;
    }

    public final SpringForce m19a() {
        this.f39b = 1.0d;
        this.f43f = false;
        return this;
    }

    final MassState m18a(double d, double d2, long j) {
        double d3;
        double pow;
        if (!this.f43f) {
            if (r0.f42e == Double.MAX_VALUE) {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
            if (r0.f39b > 1.0d) {
                r0.f44g = ((-r0.f39b) * r0.f38a) + (r0.f38a * Math.sqrt((r0.f39b * r0.f39b) - 1.0d));
                r0.f45h = ((-r0.f39b) * r0.f38a) - (r0.f38a * Math.sqrt((r0.f39b * r0.f39b) - 1.0d));
            } else if (r0.f39b >= 0.0d && r0.f39b < 1.0d) {
                r0.f46i = r0.f38a * Math.sqrt(1.0d - (r0.f39b * r0.f39b));
            }
            r0.f43f = true;
        }
        double d4 = ((double) j) / 1000.0d;
        double d5 = d - r0.f42e;
        if (r0.f39b > 1.0d) {
            d3 = d5 - (((r0.f45h * d5) - d2) / (r0.f45h - r0.f44g));
            double d6 = ((r0.f45h * d5) - d2) / (r0.f45h - r0.f44g);
            pow = (Math.pow(2.718281828459045d, r0.f45h * d4) * d3) + (Math.pow(2.718281828459045d, r0.f44g * d4) * d6);
            d3 = ((d3 * r0.f45h) * Math.pow(2.718281828459045d, r0.f45h * d4)) + ((d6 * r0.f44g) * Math.pow(2.718281828459045d, r0.f44g * d4));
        } else if (r0.f39b == 1.0d) {
            pow = d2 + (r0.f38a * d5);
            d5 += pow * d4;
            d3 = Math.pow(2.718281828459045d, (-r0.f38a) * d4) * d5;
            double pow2 = (pow * Math.pow(2.718281828459045d, (-r0.f38a) * d4)) + ((d5 * Math.pow(2.718281828459045d, (-r0.f38a) * d4)) * (-r0.f38a));
            pow = d3;
            d3 = pow2;
        } else {
            double d7 = (1.0d / r0.f46i) * (((r0.f39b * r0.f38a) * d5) + d2);
            pow = Math.pow(2.718281828459045d, ((-r0.f39b) * r0.f38a) * d4) * ((Math.cos(r0.f46i * d4) * d5) + (Math.sin(r0.f46i * d4) * d7));
            d3 = (((-r0.f38a) * pow) * r0.f39b) + (Math.pow(2.718281828459045d, ((-r0.f39b) * r0.f38a) * d4) * ((((-r0.f46i) * d5) * Math.sin(r0.f46i * d4)) + ((r0.f46i * d7) * Math.cos(r0.f46i * d4))));
        }
        r0.f47j.f35a = (float) (pow + r0.f42e);
        r0.f47j.f36b = (float) d3;
        return r0.f47j;
    }
}
