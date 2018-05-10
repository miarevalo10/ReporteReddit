package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

public class DrawableCrossFadeFactory implements TransitionFactory<Drawable> {
    private final int f12662a;
    private final boolean f12663b;
    private DrawableCrossFadeTransition f12664c;

    public static class Builder {
        private final int f3654a;
        private boolean f3655b;

        public Builder() {
            this(300);
        }

        public Builder(int i) {
            this.f3654a = i;
        }

        public final DrawableCrossFadeFactory m3197a() {
            return new DrawableCrossFadeFactory(this.f3654a, this.f3655b);
        }
    }

    protected DrawableCrossFadeFactory(int i, boolean z) {
        this.f12662a = i;
        this.f12663b = z;
    }

    public final Transition<Drawable> mo1027a(DataSource dataSource) {
        if (dataSource == DataSource.MEMORY_CACHE) {
            return NoTransition.m11728b();
        }
        if (this.f12664c == null) {
            this.f12664c = new DrawableCrossFadeTransition(this.f12662a, this.f12663b);
        }
        return this.f12664c;
    }
}
