package kotlin.reflect.jvm.internal.impl.storage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;
import kotlin.text.StringsKt__StringsKt;

public class LockBasedStorageManager implements StorageManager {
    public static final StorageManager f33053a = new LockBasedStorageManager("NO_LOCKS", ExceptionHandlingStrategy.f26299a, NoLock.f26309a) {
        protected final <T> RecursionDetectedResult<T> mo6732a() {
            return RecursionDetectedResult.m27917a();
        }
    };
    static final /* synthetic */ boolean f33054c = true;
    private static final String f33055d = StringsKt__StringsKt.m42462c(LockBasedStorageManager.class.getCanonicalName(), ".", "");
    protected final Lock f33056b;
    private final ExceptionHandlingStrategy f33057e;
    private final String f33058f;

    public interface ExceptionHandlingStrategy {
        public static final ExceptionHandlingStrategy f26299a = new C25951();

        static class C25951 implements ExceptionHandlingStrategy {
            C25951() {
            }

            public final RuntimeException mo5924a(Throwable th) {
                throw ExceptionUtilsKt.m28104a(th);
            }
        }

        RuntimeException mo5924a(Throwable th);
    }

    private static class KeyWithComputation<K, V> {
        private final K f26300a;
        private final Function0<? extends V> f26301b;

        public KeyWithComputation(K k, Function0<? extends V> function0) {
            this.f26300a = k;
            this.f26301b = function0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    return this.f26300a.equals(((KeyWithComputation) obj).f26300a) != null;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.f26300a.hashCode();
        }
    }

    private enum NotValue {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED
    }

    private static class RecursionDetectedResult<T> {
        static final /* synthetic */ boolean f26306b = true;
        final boolean f26307a;
        private final T f26308c;

        static {
            Class cls = LockBasedStorageManager.class;
        }

        public static <T> RecursionDetectedResult<T> m27918a(T t) {
            return new RecursionDetectedResult(t, false);
        }

        public static <T> RecursionDetectedResult<T> m27917a() {
            return new RecursionDetectedResult(null, true);
        }

        private RecursionDetectedResult(T t, boolean z) {
            this.f26308c = t;
            this.f26307a = z;
        }

        public final T m27919b() {
            if (f26306b || !this.f26307a) {
                return this.f26308c;
            }
            StringBuilder stringBuilder = new StringBuilder("A value requested from FALL_THROUGH in ");
            stringBuilder.append(this);
            throw new AssertionError(stringBuilder.toString());
        }

        public String toString() {
            return this.f26307a ? "FALL_THROUGH" : String.valueOf(this.f26308c);
        }
    }

    private static class LockBasedLazyValue<T> implements NullableLazyValue<T> {
        private final LockBasedStorageManager f38911a;
        private final Function0<? extends T> f38912b;
        private volatile Object f38913c;

        protected void mo7614a(T t) {
        }

        public LockBasedLazyValue(LockBasedStorageManager lockBasedStorageManager, Function0<? extends T> function0) {
            if (lockBasedStorageManager == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"storageManager", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue", "<init>"}));
            } else if (function0 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"computable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue", "<init>"}));
            } else {
                this.f38913c = NotValue.NOT_COMPUTED;
                this.f38911a = lockBasedStorageManager;
                this.f38912b = function0;
            }
        }

        public final boolean m38653a() {
            return (this.f38913c == NotValue.NOT_COMPUTED || this.f38913c == NotValue.COMPUTING) ? false : true;
        }

        public T invoke() {
            Object obj = this.f38913c;
            if (!(obj instanceof NotValue)) {
                return WrappedValues.m28125c(obj);
            }
            this.f38911a.f33056b.lock();
            try {
                T b;
                NotValue notValue = this.f38913c;
                if (notValue instanceof NotValue) {
                    if (notValue == NotValue.COMPUTING) {
                        this.f38913c = NotValue.RECURSION_WAS_DETECTED;
                        RecursionDetectedResult a = mo7613a(true);
                        if (!a.f26307a) {
                            b = a.m27919b();
                        }
                    }
                    if (notValue == NotValue.RECURSION_WAS_DETECTED) {
                        RecursionDetectedResult a2 = mo7613a(false);
                        if (!a2.f26307a) {
                            b = a2.m27919b();
                        }
                    }
                    this.f38913c = NotValue.COMPUTING;
                    obj = this.f38912b.invoke();
                    this.f38913c = obj;
                    mo7614a(obj);
                } else {
                    b = WrappedValues.m28125c(notValue);
                }
                this.f38911a.f33056b.unlock();
                return b;
            } catch (Throwable th) {
                this.f38911a.f33056b.unlock();
            }
        }

        protected RecursionDetectedResult<T> mo7613a(boolean z) {
            z = this.f38911a.mo6732a();
            if (z) {
                return z;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue", "recursionDetected"}));
        }
    }

    private static class MapBasedMemoizedFunction<K, V> implements MemoizedFunctionToNullable<K, V> {
        private final ConcurrentMap<K, Object> f38914a;
        final LockBasedStorageManager f38915b;
        private final Function1<? super K, ? extends V> f38916c;

        public MapBasedMemoizedFunction(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap<K, Object> concurrentMap, Function1<? super K, ? extends V> function1) {
            if (lockBasedStorageManager == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"storageManager", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction", "<init>"}));
            } else if (concurrentMap == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"map", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction", "<init>"}));
            } else if (function1 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"compute", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction", "<init>"}));
            } else {
                this.f38915b = lockBasedStorageManager;
                this.f38914a = concurrentMap;
                this.f38916c = function1;
            }
        }

        public V mo6492a(K k) {
            Throwable a;
            NotValue notValue = this.f38914a.get(k);
            if (notValue != null && notValue != NotValue.COMPUTING) {
                return WrappedValues.m28124b(notValue);
            }
            this.f38915b.f33056b.lock();
            try {
                notValue = this.f38914a.get(k);
                if (notValue == NotValue.COMPUTING) {
                    StringBuilder stringBuilder = new StringBuilder("Recursion detected on input: ");
                    stringBuilder.append(k);
                    stringBuilder.append(" under ");
                    stringBuilder.append(this.f38915b);
                    AssertionError assertionError = (AssertionError) LockBasedStorageManager.m33562b(new AssertionError(stringBuilder.toString()));
                    if (assertionError == null) {
                        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction", "recursionDetected"}));
                    }
                    throw assertionError;
                } else if (notValue != null) {
                    k = WrappedValues.m28124b(notValue);
                    return k;
                } else {
                    Throwable th = null;
                    try {
                        this.f38914a.put(k, NotValue.COMPUTING);
                        Object a2 = this.f38916c.mo6492a(k);
                        NotValue put = this.f38914a.put(k, WrappedValues.m28122a(a2));
                        if (put != NotValue.COMPUTING) {
                            a = m38654a(k, put);
                            try {
                                throw a;
                            } catch (Throwable th2) {
                                Throwable th3 = a;
                                a = th2;
                                th2 = th3;
                            }
                        } else {
                            this.f38915b.f33056b.unlock();
                            return a2;
                        }
                    } catch (Throwable th4) {
                        a = th4;
                        if (a == th2) {
                            throw this.f38915b.f33057e.mo5924a(a);
                        }
                        notValue = this.f38914a.put(k, WrappedValues.m28123a(a));
                        if (notValue != NotValue.COMPUTING) {
                            throw m38654a(k, notValue);
                        }
                        throw this.f38915b.f33057e.mo5924a(a);
                    }
                }
            } finally {
                this.f38915b.f33056b.unlock();
            }
        }

        private AssertionError m38654a(K k, Object obj) {
            StringBuilder stringBuilder = new StringBuilder("Race condition detected on input ");
            stringBuilder.append(k);
            stringBuilder.append(". Old value is ");
            stringBuilder.append(obj);
            stringBuilder.append(" under ");
            stringBuilder.append(this.f38915b);
            AssertionError assertionError = (AssertionError) LockBasedStorageManager.m33562b(new AssertionError(stringBuilder.toString()));
            if (assertionError != null) {
                return assertionError;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction", "raceCondition"}));
        }
    }

    private static class CacheWithNullableValuesBasedOnMemoizedFunction<K, V> extends MapBasedMemoizedFunction<KeyWithComputation<K, V>, V> {

        class C27991 implements Function1<KeyWithComputation<K, V>, V> {
            C27991() {
            }

            public final /* synthetic */ Object mo6492a(Object obj) {
                return ((KeyWithComputation) obj).f26301b.invoke();
            }
        }

        private CacheWithNullableValuesBasedOnMemoizedFunction(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap<KeyWithComputation<K, V>, Object> concurrentMap) {
            if (lockBasedStorageManager == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"storageManager", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction", "<init>"}));
            } else if (concurrentMap == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"map", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction", "<init>"}));
            } else {
                super(lockBasedStorageManager, concurrentMap, new C27991());
            }
        }

        public V mo7615a(K k, Function0<? extends V> function0) {
            if (function0 != null) {
                return mo6492a(new KeyWithComputation(k, function0));
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"computation", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction", "computeIfAbsent"}));
        }
    }

    private static class LockBasedNotNullLazyValue<T> extends LockBasedLazyValue<T> implements NotNullLazyValue<T> {
        static final /* synthetic */ boolean f39975d = true;

        static {
            Class cls = LockBasedStorageManager.class;
        }

        public LockBasedNotNullLazyValue(LockBasedStorageManager lockBasedStorageManager, Function0<? extends T> function0) {
            if (lockBasedStorageManager == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"storageManager", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue", "<init>"}));
            } else if (function0 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"computable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue", "<init>"}));
            } else {
                super(lockBasedStorageManager, function0);
            }
        }

        public T invoke() {
            T invoke = super.invoke();
            if (!f39975d && invoke == null) {
                throw new AssertionError("compute() returned null");
            } else if (invoke != null) {
                return invoke;
            } else {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue", "invoke"}));
            }
        }
    }

    private static class MapBasedMemoizedFunctionToNotNull<K, V> extends MapBasedMemoizedFunction<K, V> implements MemoizedFunctionToNotNull<K, V> {
        static final /* synthetic */ boolean f39976a = true;

        static {
            Class cls = LockBasedStorageManager.class;
        }

        public MapBasedMemoizedFunctionToNotNull(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap<K, Object> concurrentMap, Function1<? super K, ? extends V> function1) {
            if (lockBasedStorageManager == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"storageManager", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull", "<init>"}));
            } else if (concurrentMap == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"map", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull", "<init>"}));
            } else if (function1 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"compute", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull", "<init>"}));
            } else {
                super(lockBasedStorageManager, concurrentMap, function1);
            }
        }

        public final V mo6492a(K k) {
            k = super.mo6492a(k);
            if (!f39976a && k == null) {
                StringBuilder stringBuilder = new StringBuilder("compute() returned null under ");
                stringBuilder.append(this.f38915b);
                throw new AssertionError(stringBuilder.toString());
            } else if (k != null) {
                return k;
            } else {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull", "invoke"}));
            }
        }
    }

    private static class CacheWithNotNullValuesBasedOnMemoizedFunction<K, V> extends CacheWithNullableValuesBasedOnMemoizedFunction<K, V> implements CacheWithNotNullValues<K, V> {
        static final /* synthetic */ boolean f40538a = true;

        static {
            Class cls = LockBasedStorageManager.class;
        }

        private CacheWithNotNullValuesBasedOnMemoizedFunction(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap<KeyWithComputation<K, V>, Object> concurrentMap) {
            if (lockBasedStorageManager == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"storageManager", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction", "<init>"}));
            } else if (concurrentMap == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"map", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction", "<init>"}));
            } else {
                super(concurrentMap);
            }
        }

        public final V mo7615a(K k, Function0<? extends V> function0) {
            if (function0 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"computation", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction", "computeIfAbsent"}));
            }
            k = super.mo7615a(k, function0);
            if (f40538a == null && k == null) {
                function0 = new StringBuilder("computeIfAbsent() returned null under ");
                function0.append(this.f38915b);
                throw new AssertionError(function0.toString());
            } else if (k != null) {
                return k;
            } else {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction", "computeIfAbsent"}));
            }
        }
    }

    private LockBasedStorageManager(String str, ExceptionHandlingStrategy exceptionHandlingStrategy, Lock lock) {
        if (str == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"debugText", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "<init>"}));
        } else if (exceptionHandlingStrategy == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"exceptionHandlingStrategy", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "<init>"}));
        } else if (lock == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"lock", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "<init>"}));
        } else {
            this.f33056b = lock;
            this.f33057e = exceptionHandlingStrategy;
            this.f33058f = str;
        }
    }

    public LockBasedStorageManager() {
        this("<unknown creating class>", ExceptionHandlingStrategy.f26299a, new ReentrantLock());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        stringBuilder.append(" (");
        stringBuilder.append(this.f33058f);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final <K, V> MemoizedFunctionToNotNull<K, V> mo5925a(Function1<? super K, ? extends V> function1) {
        return new MapBasedMemoizedFunctionToNotNull(this, m33563c(), function1);
    }

    public final <K, V> MemoizedFunctionToNullable<K, V> mo5930b(Function1<? super K, ? extends V> function1) {
        return new MapBasedMemoizedFunction(this, m33563c(), function1);
    }

    public final <T> NotNullLazyValue<T> mo5926a(Function0<? extends T> function0) {
        if (function0 != null) {
            return new LockBasedNotNullLazyValue(this, function0);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"computable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createLazyValue"}));
    }

    public final <T> NotNullLazyValue<T> mo5927a(Function0<? extends T> function0, final T t) {
        if (t != null) {
            return new LockBasedNotNullLazyValue<T>(this, this, function0) {
                final /* synthetic */ LockBasedStorageManager f40534b;

                protected final RecursionDetectedResult<T> mo7613a(boolean z) {
                    return RecursionDetectedResult.m27918a(t);
                }
            };
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"onRecursiveCall", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createRecursionTolerantLazyValue"}));
    }

    public final <T> NotNullLazyValue<T> mo5928a(Function0<? extends T> function0, Function1<? super Boolean, ? extends T> function1, Function1<? super T, Unit> function12) {
        final Function1<? super Boolean, ? extends T> function13 = function1;
        final Function1<? super T, Unit> function14 = function12;
        return new LockBasedNotNullLazyValue<T>(this, this, function0) {
            final /* synthetic */ LockBasedStorageManager f40537c;

            protected final RecursionDetectedResult<T> mo7613a(boolean z) {
                if (function13 != null) {
                    return RecursionDetectedResult.m27918a(function13.mo6492a(Boolean.valueOf(z)));
                }
                z = super.mo7613a(z);
                if (z) {
                    return z;
                }
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$3", "recursionDetected"}));
            }

            protected final void mo7614a(T t) {
                if (t == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"value", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$3", "postCompute"}));
                } else {
                    function14.mo6492a(t);
                }
            }
        };
    }

    public final <T> NullableLazyValue<T> mo5931b(Function0<? extends T> function0) {
        return new LockBasedLazyValue(this, function0);
    }

    private static <K> ConcurrentMap<K, Object> m33563c() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    protected <T> RecursionDetectedResult<T> mo6732a() {
        StringBuilder stringBuilder = new StringBuilder("Recursive call in a lazy value under ");
        stringBuilder.append(this);
        throw ((IllegalStateException) m33562b(new IllegalStateException(stringBuilder.toString())));
    }

    private static <T extends Throwable> T m33562b(T t) {
        if (t == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "sanitizeStackTrace"}));
        }
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (!stackTrace[i2].getClassName().startsWith(f33055d)) {
                i = i2;
                break;
            }
        }
        if (f33054c || i >= 0) {
            List subList = Arrays.asList(stackTrace).subList(i, length);
            t.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
            if (t != null) {
                return t;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "sanitizeStackTrace"}));
        }
        throw new AssertionError("This method should only be called on exceptions created in LockBasedStorageManager");
    }

    public final <K, V> CacheWithNotNullValues<K, V> mo5929b() {
        return new CacheWithNotNullValuesBasedOnMemoizedFunction(m33563c());
    }
}
