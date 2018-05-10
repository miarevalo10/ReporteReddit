package io.reactivex.internal.functions;

import io.reactivex.Notification;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscription;

public final class Functions {
    static final Function<Object, Object> f25012a = new Identity();
    public static final Runnable f25013b = new EmptyRunnable();
    public static final Action f25014c = new EmptyAction();
    static final Consumer<Object> f25015d = new EmptyConsumer();
    public static final Consumer<Throwable> f25016e = new ErrorConsumer();
    public static final Consumer<Throwable> f25017f = new OnErrorMissingConsumer();
    public static final LongConsumer f25018g = new EmptyLongConsumer();
    static final Predicate<Object> f25019h = new TruePredicate();
    static final Predicate<Object> f25020i = new FalsePredicate();
    static final Callable<Object> f25021j = new NullCallable();
    static final Comparator<Object> f25022k = new NaturalObjectComparator();
    public static final Consumer<Subscription> f25023l = new MaxRequestSubscription();

    static final class ArrayListCapacityCallable<T> implements Callable<List<T>> {
        final int f25007a;

        ArrayListCapacityCallable(int i) {
            this.f25007a = i;
        }

        public final /* synthetic */ Object call() throws Exception {
            return new ArrayList(this.f25007a);
        }
    }

    static final class EmptyRunnable implements Runnable {
        public final void run() {
        }

        public final String toString() {
            return "EmptyRunnable";
        }

        EmptyRunnable() {
        }
    }

    enum HashSetCallable implements Callable<Set<Object>> {
        ;

        private HashSetCallable(String str) {
        }
    }

    enum NaturalComparator implements Comparator<Object> {
        ;

        private NaturalComparator(String str) {
        }

        public final int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    static final class NaturalObjectComparator implements Comparator<Object> {
        NaturalObjectComparator() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    static final class NullCallable implements Callable<Object> {
        public final Object call() {
            return null;
        }

        NullCallable() {
        }
    }

    static final class ActionConsumer<T> implements Consumer<T> {
        final Action f31100a;

        ActionConsumer(Action action) {
            this.f31100a = action;
        }

        public final void accept(T t) throws Exception {
            this.f31100a.run();
        }
    }

    static final class Array2Func<T1, T2, R> implements Function<Object[], R> {
        final BiFunction<? super T1, ? super T2, ? extends R> f31101a;

        public final /* synthetic */ Object apply(Object obj) throws Exception {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 2) {
                return this.f31101a.apply(objArr[0], objArr[1]);
            }
            StringBuilder stringBuilder = new StringBuilder("Array of size 2 expected but got ");
            stringBuilder.append(objArr.length);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        Array2Func(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
            this.f31101a = biFunction;
        }
    }

    static final class Array3Func<T1, T2, T3, R> implements Function<Object[], R> {
        final Function3<T1, T2, T3, R> f31102a;

        public final /* synthetic */ Object apply(Object obj) throws Exception {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 3) {
                return this.f31102a.mo4932a(objArr[0], objArr[1], objArr[2]);
            }
            StringBuilder stringBuilder = new StringBuilder("Array of size 3 expected but got ");
            stringBuilder.append(objArr.length);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        Array3Func(Function3<T1, T2, T3, R> function3) {
            this.f31102a = function3;
        }
    }

    static final class Array4Func<T1, T2, T3, T4, R> implements Function<Object[], R> {
        final Function4<T1, T2, T3, T4, R> f31103a;

        public final /* synthetic */ Object apply(Object obj) throws Exception {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 4) {
                return this.f31103a.m26526a();
            }
            StringBuilder stringBuilder = new StringBuilder("Array of size 4 expected but got ");
            stringBuilder.append(objArr.length);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        Array4Func(Function4<T1, T2, T3, T4, R> function4) {
            this.f31103a = function4;
        }
    }

    static final class Array5Func<T1, T2, T3, T4, T5, R> implements Function<Object[], R> {
        private final Function5<T1, T2, T3, T4, T5, R> f31104a;

        public final /* synthetic */ Object apply(Object obj) throws Exception {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 5) {
                return this.f31104a.mo4803a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            }
            StringBuilder stringBuilder = new StringBuilder("Array of size 5 expected but got ");
            stringBuilder.append(objArr.length);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        Array5Func(Function5<T1, T2, T3, T4, T5, R> function5) {
            this.f31104a = function5;
        }
    }

    static final class Array6Func<T1, T2, T3, T4, T5, T6, R> implements Function<Object[], R> {
        final Function6<T1, T2, T3, T4, T5, T6, R> f31105a;

        public final /* synthetic */ Object apply(Object obj) throws Exception {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 6) {
                return this.f31105a.m26528a();
            }
            StringBuilder stringBuilder = new StringBuilder("Array of size 6 expected but got ");
            stringBuilder.append(objArr.length);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        Array6Func(Function6<T1, T2, T3, T4, T5, T6, R> function6) {
            this.f31105a = function6;
        }
    }

    static final class Array7Func<T1, T2, T3, T4, T5, T6, T7, R> implements Function<Object[], R> {
        final Function7<T1, T2, T3, T4, T5, T6, T7, R> f31106a;

        public final /* synthetic */ Object apply(Object obj) throws Exception {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 7) {
                return this.f31106a.m26529a();
            }
            StringBuilder stringBuilder = new StringBuilder("Array of size 7 expected but got ");
            stringBuilder.append(objArr.length);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        Array7Func(Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
            this.f31106a = function7;
        }
    }

    static final class Array8Func<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Function<Object[], R> {
        final Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> f31107a;

        public final /* synthetic */ Object apply(Object obj) throws Exception {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 8) {
                return this.f31107a.m26530a();
            }
            StringBuilder stringBuilder = new StringBuilder("Array of size 8 expected but got ");
            stringBuilder.append(objArr.length);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        Array8Func(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
            this.f31107a = function8;
        }
    }

    static final class Array9Func<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Function<Object[], R> {
        final Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f31108a;

        public final /* synthetic */ Object apply(Object obj) throws Exception {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 9) {
                return this.f31108a.m26531a();
            }
            StringBuilder stringBuilder = new StringBuilder("Array of size 9 expected but got ");
            stringBuilder.append(objArr.length);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        Array9Func(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
            this.f31108a = function9;
        }
    }

    static final class BooleanSupplierPredicateReverse<T> implements Predicate<T> {
        final BooleanSupplier f31109a;

        BooleanSupplierPredicateReverse(BooleanSupplier booleanSupplier) {
            this.f31109a = booleanSupplier;
        }

        public final boolean test(T t) throws Exception {
            return this.f31109a.mo6617a() == null ? true : null;
        }
    }

    static final class CastToClass<T, U> implements Function<T, U> {
        final Class<U> f31110a;

        CastToClass(Class<U> cls) {
            this.f31110a = cls;
        }

        public final U apply(T t) throws Exception {
            return this.f31110a.cast(t);
        }
    }

    static final class ClassFilter<T, U> implements Predicate<T> {
        final Class<U> f31111a;

        ClassFilter(Class<U> cls) {
            this.f31111a = cls;
        }

        public final boolean test(T t) throws Exception {
            return this.f31111a.isInstance(t);
        }
    }

    static final class EmptyAction implements Action {
        public final void run() {
        }

        public final String toString() {
            return "EmptyAction";
        }

        EmptyAction() {
        }
    }

    static final class EmptyConsumer implements Consumer<Object> {
        public final void accept(Object obj) {
        }

        public final String toString() {
            return "EmptyConsumer";
        }

        EmptyConsumer() {
        }
    }

    static final class EmptyLongConsumer implements LongConsumer {
        EmptyLongConsumer() {
        }
    }

    static final class EqualsPredicate<T> implements Predicate<T> {
        final T f31112a;

        EqualsPredicate(T t) {
            this.f31112a = t;
        }

        public final boolean test(T t) throws Exception {
            return ObjectHelper.m26574a((Object) t, this.f31112a);
        }
    }

    static final class ErrorConsumer implements Consumer<Throwable> {
        ErrorConsumer() {
        }

        public final /* synthetic */ void accept(Object obj) throws Exception {
            RxJavaPlugins.m26757a((Throwable) obj);
        }
    }

    static final class FalsePredicate implements Predicate<Object> {
        public final boolean test(Object obj) {
            return false;
        }

        FalsePredicate() {
        }
    }

    static final class FutureAction implements Action {
        final Future<?> f31113a;

        FutureAction(Future<?> future) {
            this.f31113a = future;
        }

        public final void run() throws Exception {
            this.f31113a.get();
        }
    }

    static final class Identity implements Function<Object, Object> {
        public final Object apply(Object obj) {
            return obj;
        }

        public final String toString() {
            return "IdentityFunction";
        }

        Identity() {
        }
    }

    static final class JustValue<T, U> implements Function<T, U>, Callable<U> {
        final U f31114a;

        JustValue(U u) {
            this.f31114a = u;
        }

        public final U call() throws Exception {
            return this.f31114a;
        }

        public final U apply(T t) throws Exception {
            return this.f31114a;
        }
    }

    static final class ListSorter<T> implements Function<List<T>, List<T>> {
        final Comparator<? super T> f31115a;

        public final /* synthetic */ Object apply(Object obj) throws Exception {
            List list = (List) obj;
            Collections.sort(list, this.f31115a);
            return list;
        }

        ListSorter(Comparator<? super T> comparator) {
            this.f31115a = comparator;
        }
    }

    static final class MaxRequestSubscription implements Consumer<Subscription> {
        MaxRequestSubscription() {
        }

        public final /* synthetic */ void accept(Object obj) throws Exception {
            ((Subscription) obj).request(Long.MAX_VALUE);
        }
    }

    static final class NotificationOnComplete<T> implements Action {
        final Consumer<? super Notification<T>> f31116a;

        NotificationOnComplete(Consumer<? super Notification<T>> consumer) {
            this.f31116a = consumer;
        }

        public final void run() throws Exception {
            this.f31116a.accept(Notification.m26485e());
        }
    }

    static final class NotificationOnError<T> implements Consumer<Throwable> {
        final Consumer<? super Notification<T>> f31117a;

        public final /* synthetic */ void accept(Object obj) throws Exception {
            this.f31117a.accept(Notification.m26484a((Throwable) obj));
        }

        NotificationOnError(Consumer<? super Notification<T>> consumer) {
            this.f31117a = consumer;
        }
    }

    static final class NotificationOnNext<T> implements Consumer<T> {
        final Consumer<? super Notification<T>> f31118a;

        NotificationOnNext(Consumer<? super Notification<T>> consumer) {
            this.f31118a = consumer;
        }

        public final void accept(T t) throws Exception {
            this.f31118a.accept(Notification.m26483a((Object) t));
        }
    }

    static final class OnErrorMissingConsumer implements Consumer<Throwable> {
        OnErrorMissingConsumer() {
        }

        public final /* synthetic */ void accept(Object obj) throws Exception {
            RxJavaPlugins.m26757a(new OnErrorNotImplementedException((Throwable) obj));
        }
    }

    static final class TimestampFunction<T> implements Function<T, Timed<T>> {
        final TimeUnit f31119a;
        final Scheduler f31120b;

        TimestampFunction(TimeUnit timeUnit, Scheduler scheduler) {
            this.f31119a = timeUnit;
            this.f31120b = scheduler;
        }

        public final /* synthetic */ Object apply(Object obj) throws Exception {
            return new Timed(obj, Scheduler.m26494a(this.f31119a), this.f31119a);
        }
    }

    static final class ToMapKeySelector<K, T> implements BiConsumer<Map<K, T>, T> {
        private final Function<? super T, ? extends K> f31121a;

        public final /* synthetic */ void mo4825a(Object obj, Object obj2) throws Exception {
            ((Map) obj).put(this.f31121a.apply(obj2), obj2);
        }

        ToMapKeySelector(Function<? super T, ? extends K> function) {
            this.f31121a = function;
        }
    }

    static final class ToMapKeyValueSelector<K, V, T> implements BiConsumer<Map<K, V>, T> {
        private final Function<? super T, ? extends V> f31122a;
        private final Function<? super T, ? extends K> f31123b;

        public final /* synthetic */ void mo4825a(Object obj, Object obj2) throws Exception {
            ((Map) obj).put(this.f31123b.apply(obj2), this.f31122a.apply(obj2));
        }

        ToMapKeyValueSelector(Function<? super T, ? extends V> function, Function<? super T, ? extends K> function2) {
            this.f31122a = function;
            this.f31123b = function2;
        }
    }

    static final class ToMultimapKeyValueSelector<K, V, T> implements BiConsumer<Map<K, Collection<V>>, T> {
        private final Function<? super K, ? extends Collection<? super V>> f31124a;
        private final Function<? super T, ? extends V> f31125b;
        private final Function<? super T, ? extends K> f31126c;

        public final /* synthetic */ void mo4825a(Object obj, Object obj2) throws Exception {
            Map map = (Map) obj;
            Object apply = this.f31126c.apply(obj2);
            Collection collection = (Collection) map.get(apply);
            if (collection == null) {
                collection = (Collection) this.f31124a.apply(apply);
                map.put(apply, collection);
            }
            collection.add(this.f31125b.apply(obj2));
        }

        ToMultimapKeyValueSelector(Function<? super K, ? extends Collection<? super V>> function, Function<? super T, ? extends V> function2, Function<? super T, ? extends K> function3) {
            this.f31124a = function;
            this.f31125b = function2;
            this.f31126c = function3;
        }
    }

    static final class TruePredicate implements Predicate<Object> {
        public final boolean test(Object obj) {
            return true;
        }

        TruePredicate() {
        }
    }

    public static <T1, T2, R> Function<Object[], R> m26542a(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.m26573a((Object) biFunction, "f is null");
        return new Array2Func(biFunction);
    }

    public static <T1, T2, T3, R> Function<Object[], R> m26543a(Function3<T1, T2, T3, R> function3) {
        ObjectHelper.m26573a((Object) function3, "f is null");
        return new Array3Func(function3);
    }

    public static <T1, T2, T3, T4, R> Function<Object[], R> m26544a(Function4<T1, T2, T3, T4, R> function4) {
        ObjectHelper.m26573a((Object) function4, "f is null");
        return new Array4Func(function4);
    }

    public static <T1, T2, T3, T4, T5, R> Function<Object[], R> m26545a(Function5<T1, T2, T3, T4, T5, R> function5) {
        ObjectHelper.m26573a((Object) function5, "f is null");
        return new Array5Func(function5);
    }

    public static <T1, T2, T3, T4, T5, T6, R> Function<Object[], R> m26546a(Function6<T1, T2, T3, T4, T5, T6, R> function6) {
        ObjectHelper.m26573a((Object) function6, "f is null");
        return new Array6Func(function6);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Function<Object[], R> m26547a(Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
        ObjectHelper.m26573a((Object) function7, "f is null");
        return new Array7Func(function7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Function<Object[], R> m26548a(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
        ObjectHelper.m26573a((Object) function8, "f is null");
        return new Array8Func(function8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Function<Object[], R> m26549a(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
        ObjectHelper.m26573a((Object) function9, "f is null");
        return new Array9Func(function9);
    }

    public static <T> Function<T, T> m26541a() {
        return f25012a;
    }

    public static <T> Consumer<T> m26556b() {
        return f25015d;
    }

    public static <T> Predicate<T> m26561c() {
        return f25019h;
    }

    public static <T> Predicate<T> m26563d() {
        return f25020i;
    }

    public static <T> Callable<T> m26564e() {
        return f25021j;
    }

    public static <T> Comparator<T> m26565f() {
        return f25022k;
    }

    public static Action m26535a(Future<?> future) {
        return new FutureAction(future);
    }

    public static <T> Callable<T> m26555a(T t) {
        return new JustValue(t);
    }

    public static <T, U> Function<T, U> m26558b(U u) {
        return new JustValue(u);
    }

    public static <T, U> Function<T, U> m26550a(Class<U> cls) {
        return new CastToClass(cls);
    }

    public static <T> Callable<List<T>> m26554a(int i) {
        return new ArrayListCapacityCallable(i);
    }

    public static <T> Predicate<T> m26562c(T t) {
        return new EqualsPredicate(t);
    }

    public static <T> Callable<Set<T>> m26566g() {
        return HashSetCallable.f25008a;
    }

    public static <T> Consumer<T> m26540a(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnNext(consumer);
    }

    public static <T> Consumer<Throwable> m26557b(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnError(consumer);
    }

    public static <T> Action m26560c(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnComplete(consumer);
    }

    public static <T> Consumer<T> m26539a(Action action) {
        return new ActionConsumer(action);
    }

    public static <T, U> Predicate<T> m26559b(Class<U> cls) {
        return new ClassFilter(cls);
    }

    public static <T> Predicate<T> m26553a(BooleanSupplier booleanSupplier) {
        return new BooleanSupplierPredicateReverse(booleanSupplier);
    }

    public static <T> Function<T, Timed<T>> m26552a(TimeUnit timeUnit, Scheduler scheduler) {
        return new TimestampFunction(timeUnit, scheduler);
    }

    public static <T, K> BiConsumer<Map<K, T>, T> m26536a(Function<? super T, ? extends K> function) {
        return new ToMapKeySelector(function);
    }

    public static <T, K, V> BiConsumer<Map<K, V>, T> m26537a(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return new ToMapKeyValueSelector(function2, function);
    }

    public static <T, K, V> BiConsumer<Map<K, Collection<V>>, T> m26538a(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Function<? super K, ? extends Collection<? super V>> function3) {
        return new ToMultimapKeyValueSelector(function3, function2, function);
    }

    public static <T> Comparator<T> m26567h() {
        return NaturalComparator.f25010a;
    }

    public static <T> Function<List<T>, List<T>> m26551a(Comparator<? super T> comparator) {
        return new ListSorter(comparator);
    }
}
