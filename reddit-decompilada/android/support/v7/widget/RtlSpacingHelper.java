package android.support.v7.widget;

class RtlSpacingHelper {
    int f2471a = 0;
    int f2472b = 0;
    int f2473c = Integer.MIN_VALUE;
    int f2474d = Integer.MIN_VALUE;
    int f2475e = 0;
    int f2476f = 0;
    boolean f2477g = false;
    boolean f2478h = false;

    RtlSpacingHelper() {
    }

    public final void m2255a(int i, int i2) {
        this.f2473c = i;
        this.f2474d = i2;
        this.f2478h = true;
        if (this.f2477g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f2471a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f2472b = i;
                return;
            }
        }
        if (i != Integer.MIN_VALUE) {
            this.f2471a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f2472b = i2;
        }
    }
}
