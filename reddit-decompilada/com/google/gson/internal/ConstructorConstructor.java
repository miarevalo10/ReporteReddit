package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public final class ConstructorConstructor {
    private final Map<Type, InstanceCreator<?>> f8748a;

    class C12224 implements ObjectConstructor<T> {
        final /* synthetic */ ConstructorConstructor f15011a;

        C12224(ConstructorConstructor constructorConstructor) {
            this.f15011a = constructorConstructor;
        }

        public final T mo2466a() {
            return new TreeSet();
        }
    }

    class C12246 implements ObjectConstructor<T> {
        final /* synthetic */ ConstructorConstructor f15014a;

        C12246(ConstructorConstructor constructorConstructor) {
            this.f15014a = constructorConstructor;
        }

        public final T mo2466a() {
            return new LinkedHashSet();
        }
    }

    class C12257 implements ObjectConstructor<T> {
        final /* synthetic */ ConstructorConstructor f15015a;

        C12257(ConstructorConstructor constructorConstructor) {
            this.f15015a = constructorConstructor;
        }

        public final T mo2466a() {
            return new ArrayDeque();
        }
    }

    class C12268 implements ObjectConstructor<T> {
        final /* synthetic */ ConstructorConstructor f15016a;

        C12268(ConstructorConstructor constructorConstructor) {
            this.f15016a = constructorConstructor;
        }

        public final T mo2466a() {
            return new ArrayList();
        }
    }

    class C12279 implements ObjectConstructor<T> {
        final /* synthetic */ ConstructorConstructor f15017a;

        C12279(ConstructorConstructor constructorConstructor) {
            this.f15017a = constructorConstructor;
        }

        public final T mo2466a() {
            return new ConcurrentSkipListMap();
        }
    }

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map) {
        this.f8748a = map;
    }

    private <T> com.google.gson.internal.ObjectConstructor<T> m7536a(java.lang.Class<? super T> r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r1 = this;
        r0 = 0;
        r0 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x0017 }
        r2 = r2.getDeclaredConstructor(r0);	 Catch:{ NoSuchMethodException -> 0x0017 }
        r0 = r2.isAccessible();	 Catch:{ NoSuchMethodException -> 0x0017 }
        if (r0 != 0) goto L_0x0011;	 Catch:{ NoSuchMethodException -> 0x0017 }
    L_0x000d:
        r0 = 1;	 Catch:{ NoSuchMethodException -> 0x0017 }
        r2.setAccessible(r0);	 Catch:{ NoSuchMethodException -> 0x0017 }
    L_0x0011:
        r0 = new com.google.gson.internal.ConstructorConstructor$3;	 Catch:{ NoSuchMethodException -> 0x0017 }
        r0.<init>(r1, r2);	 Catch:{ NoSuchMethodException -> 0x0017 }
        return r0;
    L_0x0017:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.ConstructorConstructor.a(java.lang.Class):com.google.gson.internal.ObjectConstructor<T>");
    }

    public final String toString() {
        return this.f8748a.toString();
    }

    public final <T> ObjectConstructor<T> m7537a(TypeToken<T> typeToken) {
        final Type type = typeToken.f8835b;
        final Class cls = typeToken.f8834a;
        final InstanceCreator instanceCreator = (InstanceCreator) this.f8748a.get(type);
        if (instanceCreator != null) {
            return new ObjectConstructor<T>(this) {
                final /* synthetic */ ConstructorConstructor f15005c;

                public final T mo2466a() {
                    return instanceCreator.m7491a();
                }
            };
        }
        instanceCreator = (InstanceCreator) this.f8748a.get(cls);
        if (instanceCreator != null) {
            return new ObjectConstructor<T>(this) {
                final /* synthetic */ ConstructorConstructor f15008c;

                public final T mo2466a() {
                    return instanceCreator.m7491a();
                }
            };
        }
        ObjectConstructor<T> a = m7536a(cls);
        if (a != null) {
            return a;
        }
        a = Collection.class.isAssignableFrom(cls) ? SortedSet.class.isAssignableFrom(cls) ? new C12224(this) : EnumSet.class.isAssignableFrom(cls) ? new ObjectConstructor<T>(this) {
            final /* synthetic */ ConstructorConstructor f15013b;

            public final T mo2466a() {
                if (type instanceof ParameterizedType) {
                    Type type = ((ParameterizedType) type).getActualTypeArguments()[0];
                    if (type instanceof Class) {
                        return EnumSet.noneOf((Class) type);
                    }
                    StringBuilder stringBuilder = new StringBuilder("Invalid EnumSet type: ");
                    stringBuilder.append(type.toString());
                    throw new JsonIOException(stringBuilder.toString());
                }
                stringBuilder = new StringBuilder("Invalid EnumSet type: ");
                stringBuilder.append(type.toString());
                throw new JsonIOException(stringBuilder.toString());
            }
        } : Set.class.isAssignableFrom(cls) ? new C12246(this) : Queue.class.isAssignableFrom(cls) ? new C12257(this) : new C12268(this) : Map.class.isAssignableFrom(cls) ? ConcurrentNavigableMap.class.isAssignableFrom(cls) ? new C12279(this) : ConcurrentMap.class.isAssignableFrom(cls) ? new ObjectConstructor<T>(this) {
            final /* synthetic */ ConstructorConstructor f14995a;

            {
                this.f14995a = r1;
            }

            public final T mo2466a() {
                return new ConcurrentHashMap();
            }
        } : SortedMap.class.isAssignableFrom(cls) ? new ObjectConstructor<T>(this) {
            final /* synthetic */ ConstructorConstructor f14996a;

            {
                this.f14996a = r1;
            }

            public final T mo2466a() {
                return new TreeMap();
            }
        } : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(TypeToken.m7571a(((ParameterizedType) type).getActualTypeArguments()[0]).f8834a)) ? new ObjectConstructor<T>(this) {
            final /* synthetic */ ConstructorConstructor f14998a;

            {
                this.f14998a = r1;
            }

            public final T mo2466a() {
                return new LinkedTreeMap();
            }
        } : new ObjectConstructor<T>(this) {
            final /* synthetic */ ConstructorConstructor f14997a;

            {
                this.f14997a = r1;
            }

            public final T mo2466a() {
                return new LinkedHashMap();
            }
        } : null;
        return a != null ? a : new ObjectConstructor<T>(this) {
            final /* synthetic */ ConstructorConstructor f15001c;
            private final UnsafeAllocator f15002d = UnsafeAllocator.m7556a();

            public final T mo2466a() {
                try {
                    return this.f15002d.mo2468a(cls);
                } catch (Throwable e) {
                    StringBuilder stringBuilder = new StringBuilder("Unable to invoke no-args constructor for ");
                    stringBuilder.append(type);
                    stringBuilder.append(". Register an InstanceCreator with Gson for this type may fix this problem.");
                    throw new RuntimeException(stringBuilder.toString(), e);
                }
            }
        };
    }
}
