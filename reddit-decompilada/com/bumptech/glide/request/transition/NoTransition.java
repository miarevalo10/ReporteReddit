package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.Transition.ViewAdapter;

public class NoTransition<R> implements Transition<R> {
    static final NoTransition<?> f12667a = new NoTransition();
    private static final TransitionFactory<?> f12668b = new NoAnimationFactory();

    public static class NoAnimationFactory<R> implements TransitionFactory<R> {
        public final Transition<R> mo1027a(DataSource dataSource) {
            return NoTransition.f12667a;
        }
    }

    public final boolean mo1028a(Object obj, ViewAdapter viewAdapter) {
        return false;
    }

    public static <R> TransitionFactory<R> m11727a() {
        return f12668b;
    }

    public static <R> Transition<R> m11728b() {
        return f12667a;
    }
}
