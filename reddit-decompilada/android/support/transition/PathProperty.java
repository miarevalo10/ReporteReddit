package android.support.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

class PathProperty<T> extends Property<T, Float> {
    private final Property<T, PointF> f843a;
    private final PathMeasure f844b;
    private final float f845c;
    private final float[] f846d = new float[2];
    private final PointF f847e = new PointF();
    private float f848f;

    public /* synthetic */ void set(Object obj, Object obj2) {
        Float f = (Float) obj2;
        this.f848f = f.floatValue();
        this.f844b.getPosTan(this.f845c * f.floatValue(), this.f846d, null);
        this.f847e.x = this.f846d[0];
        this.f847e.y = this.f846d[1];
        this.f843a.set(obj, this.f847e);
    }

    PathProperty(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f843a = property;
        this.f844b = new PathMeasure(path, false);
        this.f845c = this.f844b.getLength();
    }

    public /* synthetic */ Object get(Object obj) {
        return Float.valueOf(this.f848f);
    }
}
