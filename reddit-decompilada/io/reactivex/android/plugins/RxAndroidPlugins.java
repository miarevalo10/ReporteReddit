package io.reactivex.android.plugins;

import io.reactivex.Scheduler;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;

public final class RxAndroidPlugins {
    private static volatile Function<Callable<Scheduler>, Scheduler> f25000a;
    private static volatile Function<Scheduler, Scheduler> f25001b;

    public static Scheduler m26506a(Callable<Scheduler> callable) {
        Function function = f25000a;
        if (function == null) {
            return m26508b(callable);
        }
        Scheduler scheduler = (Scheduler) m26507a(function, callable);
        if (scheduler != null) {
            return scheduler;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    public static Scheduler m26505a(Scheduler scheduler) {
        if (scheduler == null) {
            throw new NullPointerException("scheduler == null");
        }
        Function function = f25001b;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) m26507a(function, scheduler);
    }

    private static Scheduler m26508b(Callable<Scheduler> callable) {
        try {
            Scheduler scheduler = (Scheduler) callable.call();
            if (scheduler != null) {
                return scheduler;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Callable<Scheduler> callable2) {
            callable2 = Exceptions.m26520a(callable2);
        }
    }

    private static <T, R> R m26507a(Function<T, R> function, T t) {
        try {
            return function.apply(t);
        } catch (Function<T, R> function2) {
            function2 = Exceptions.m26520a(function2);
        }
    }
}
