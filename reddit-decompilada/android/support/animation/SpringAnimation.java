package android.support.animation;

public final class SpringAnimation extends DynamicAnimation<SpringAnimation> {
    private SpringForce f16392x = null;
    private float f16393y = Float.MAX_VALUE;
    private boolean f16394z = null;

    public <K> SpringAnimation(K k, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k, floatPropertyCompat);
    }

    public final SpringAnimation m16501a(SpringForce springForce) {
        this.f16392x = springForce;
        return this;
    }

    final boolean mo3071b(long j) {
        if (this.f16394z) {
            if (r0.f16393y != Float.MAX_VALUE) {
                r0.f16392x.f42e = (double) r0.f16393y;
                r0.f16393y = Float.MAX_VALUE;
            }
            r0.p = (float) r0.f16392x.f42e;
            r0.o = 0.0f;
            r0.f16394z = false;
            return true;
        }
        MassState a;
        if (r0.f16393y != Float.MAX_VALUE) {
            long j2 = j / 2;
            a = r0.f16392x.m18a((double) r0.p, (double) r0.o, j2);
            r0.f16392x.f42e = (double) r0.f16393y;
            r0.f16393y = Float.MAX_VALUE;
            a = r0.f16392x.m18a((double) a.f35a, (double) a.f36b, j2);
            r0.p = a.f35a;
            r0.o = a.f36b;
        } else {
            a = r0.f16392x.m18a((double) r0.p, (double) r0.o, j);
            r0.p = a.f35a;
            r0.o = a.f36b;
        }
        r0.p = Math.max(r0.p, r0.v);
        r0.p = Math.min(r0.p, r0.u);
        float f = r0.p;
        float f2 = r0.o;
        SpringForce springForce = r0.f16392x;
        boolean z = ((double) Math.abs(f2)) < springForce.f41d && ((double) Math.abs(f - ((float) springForce.f42e))) < springForce.f40c;
        if (!z) {
            return false;
        }
        r0.p = (float) r0.f16392x.f42e;
        r0.o = 0.0f;
        return true;
    }

    public final void mo3069a() {
        if (this.f16392x == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double d = (double) ((float) this.f16392x.f42e);
        if (d > ((double) this.u)) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        } else if (d < ((double) this.v)) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        } else {
            SpringForce springForce = this.f16392x;
            springForce.f40c = Math.abs((double) (this.f10981w * 0.75f));
            springForce.f41d = springForce.f40c * 62.5d;
            super.mo3069a();
        }
    }

    public final void mo3070a(float f) {
        if (this.f10978t) {
            this.f16393y = f;
            return;
        }
        if (this.f16392x == null) {
            this.f16392x = new SpringForce(f);
        }
        this.f16392x.f42e = (double) f;
        mo3069a();
    }
}
