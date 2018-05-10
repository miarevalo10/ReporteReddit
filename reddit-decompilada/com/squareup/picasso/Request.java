package com.squareup.picasso;

import android.graphics.Bitmap.Config;
import android.net.Uri;
import com.squareup.picasso.Picasso.Priority;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class Request {
    private static final long TOO_LONG_LOG = TimeUnit.SECONDS.toNanos(5);
    public final boolean centerCrop;
    public final boolean centerInside;
    public final Config config;
    public final boolean hasRotationPivot;
    int id;
    int networkPolicy;
    public final boolean onlyScaleDown;
    public final Priority priority;
    public final int resourceId;
    public final float rotationDegrees;
    public final float rotationPivotX;
    public final float rotationPivotY;
    public final String stableKey;
    long started;
    public final int targetHeight;
    public final int targetWidth;
    public final List<Transformation> transformations;
    public final Uri uri;

    public static final class Builder {
        Uri f23853a;
        int f23854b;
        String f23855c;
        int f23856d;
        int f23857e;
        boolean f23858f;
        boolean f23859g;
        boolean f23860h;
        float f23861i;
        float f23862j;
        float f23863k;
        boolean f23864l;
        List<Transformation> f23865m;
        Config f23866n;
        Priority f23867o;

        Builder(Uri uri, Config config) {
            this.f23853a = uri;
            this.f23854b = null;
            this.f23866n = config;
        }

        private Builder(Request request) {
            this.f23853a = request.uri;
            this.f23854b = request.resourceId;
            this.f23855c = request.stableKey;
            this.f23856d = request.targetWidth;
            this.f23857e = request.targetHeight;
            this.f23858f = request.centerCrop;
            this.f23859g = request.centerInside;
            this.f23861i = request.rotationDegrees;
            this.f23862j = request.rotationPivotX;
            this.f23863k = request.rotationPivotY;
            this.f23864l = request.hasRotationPivot;
            this.f23860h = request.onlyScaleDown;
            if (request.transformations != null) {
                this.f23865m = new ArrayList(request.transformations);
            }
            this.f23866n = request.config;
            this.f23867o = request.priority;
        }

        public final boolean m25786a() {
            if (this.f23853a == null) {
                if (this.f23854b == 0) {
                    return false;
                }
            }
            return true;
        }

        public final Builder m25785a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            } else if (i2 < 0) {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            } else if (i2 == 0 && i == 0) {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            } else {
                this.f23856d = i;
                this.f23857e = i2;
                return this;
            }
        }
    }

    private Request(Uri uri, int i, String str, List<Transformation> list, int i2, int i3, boolean z, boolean z2, boolean z3, float f, float f2, float f3, boolean z4, Config config, Priority priority) {
        this.uri = uri;
        this.resourceId = i;
        this.stableKey = str;
        if (list == null) {
            this.transformations = null;
        } else {
            this.transformations = Collections.unmodifiableList(list);
        }
        this.targetWidth = i2;
        this.targetHeight = i3;
        this.centerCrop = z;
        this.centerInside = z2;
        this.onlyScaleDown = z3;
        this.rotationDegrees = f;
        this.rotationPivotX = f2;
        this.rotationPivotY = f3;
        this.hasRotationPivot = z4;
        this.config = config;
        this.priority = priority;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Request{");
        if (this.resourceId > 0) {
            stringBuilder.append(this.resourceId);
        } else {
            stringBuilder.append(this.uri);
        }
        if (!(this.transformations == null || this.transformations.isEmpty())) {
            for (Transformation transformation : this.transformations) {
                stringBuilder.append(' ');
                stringBuilder.append(transformation.m25807b());
            }
        }
        if (this.stableKey != null) {
            stringBuilder.append(" stableKey(");
            stringBuilder.append(this.stableKey);
            stringBuilder.append(')');
        }
        if (this.targetWidth > 0) {
            stringBuilder.append(" resize(");
            stringBuilder.append(this.targetWidth);
            stringBuilder.append(',');
            stringBuilder.append(this.targetHeight);
            stringBuilder.append(')');
        }
        if (this.centerCrop) {
            stringBuilder.append(" centerCrop");
        }
        if (this.centerInside) {
            stringBuilder.append(" centerInside");
        }
        if (this.rotationDegrees != 0.0f) {
            stringBuilder.append(" rotation(");
            stringBuilder.append(this.rotationDegrees);
            if (this.hasRotationPivot) {
                stringBuilder.append(" @ ");
                stringBuilder.append(this.rotationPivotX);
                stringBuilder.append(',');
                stringBuilder.append(this.rotationPivotY);
            }
            stringBuilder.append(')');
        }
        if (this.config != null) {
            stringBuilder.append(' ');
            stringBuilder.append(this.config);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    final String logId() {
        long nanoTime = System.nanoTime() - this.started;
        if (nanoTime > TOO_LONG_LOG) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(plainId());
            stringBuilder.append('+');
            stringBuilder.append(TimeUnit.NANOSECONDS.toSeconds(nanoTime));
            stringBuilder.append('s');
            return stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(plainId());
        stringBuilder.append('+');
        stringBuilder.append(TimeUnit.NANOSECONDS.toMillis(nanoTime));
        stringBuilder.append("ms");
        return stringBuilder.toString();
    }

    final String plainId() {
        StringBuilder stringBuilder = new StringBuilder("[R");
        stringBuilder.append(this.id);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    final String getName() {
        if (this.uri != null) {
            return String.valueOf(this.uri.getPath());
        }
        return Integer.toHexString(this.resourceId);
    }

    public final boolean hasSize() {
        if (this.targetWidth == 0) {
            if (this.targetHeight == 0) {
                return false;
            }
        }
        return true;
    }

    final boolean needsTransformation() {
        if (!needsMatrixTransform()) {
            if (!hasCustomTransformations()) {
                return false;
            }
        }
        return true;
    }

    final boolean needsMatrixTransform() {
        if (!hasSize()) {
            if (this.rotationDegrees == 0.0f) {
                return false;
            }
        }
        return true;
    }

    final boolean hasCustomTransformations() {
        return this.transformations != null;
    }

    public final Builder buildUpon() {
        return new Builder();
    }
}
