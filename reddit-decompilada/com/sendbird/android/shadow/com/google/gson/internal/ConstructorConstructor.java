package com.sendbird.android.shadow.com.google.gson.internal;

import com.sendbird.android.shadow.com.google.gson.InstanceCreator;
import com.sendbird.android.shadow.com.google.gson.JsonIOException;
import com.sendbird.android.shadow.com.google.gson.reflect.TypeToken;
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
    private final Map<Type, InstanceCreator<?>> f22909a;

    class C24304 implements ObjectConstructor<T> {
        final /* synthetic */ ConstructorConstructor f30255a;

        C24304(ConstructorConstructor constructorConstructor) {
            this.f30255a = constructorConstructor;
        }

        public final T mo5249a() {
            return new TreeSet();
        }
    }

    class C24326 implements ObjectConstructor<T> {
        final /* synthetic */ ConstructorConstructor f30258a;

        C24326(ConstructorConstructor constructorConstructor) {
            this.f30258a = constructorConstructor;
        }

        public final T mo5249a() {
            return new LinkedHashSet();
        }
    }

    class C24337 implements ObjectConstructor<T> {
        final /* synthetic */ ConstructorConstructor f30259a;

        C24337(ConstructorConstructor constructorConstructor) {
            this.f30259a = constructorConstructor;
        }

        public final T mo5249a() {
            return new ArrayDeque();
        }
    }

    class C24348 implements ObjectConstructor<T> {
        final /* synthetic */ ConstructorConstructor f30260a;

        C24348(ConstructorConstructor constructorConstructor) {
            this.f30260a = constructorConstructor;
        }

        public final T mo5249a() {
            return new ArrayList();
        }
    }

    class C24359 implements ObjectConstructor<T> {
        final /* synthetic */ ConstructorConstructor f30261a;

        C24359(ConstructorConstructor constructorConstructor) {
            this.f30261a = constructorConstructor;
        }

        public final T mo5249a() {
            return new ConcurrentSkipListMap();
        }
    }

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map) {
        this.f22909a = map;
    }

    private <T> com.sendbird.android.shadow.com.google.gson.internal.ObjectConstructor<T> m25109a(java.lang.Class<? super T> r2) {
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
        r0 = new com.sendbird.android.shadow.com.google.gson.internal.ConstructorConstructor$3;	 Catch:{ NoSuchMethodException -> 0x0017 }
        r0.<init>(r1, r2);	 Catch:{ NoSuchMethodException -> 0x0017 }
        return r0;
    L_0x0017:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.com.google.gson.internal.ConstructorConstructor.a(java.lang.Class):com.sendbird.android.shadow.com.google.gson.internal.ObjectConstructor<T>");
    }

    public final String toString() {
        return this.f22909a.toString();
    }

    public final <T> ObjectConstructor<T> m25110a(TypeToken<T> typeToken) {
        final Type type = typeToken.f22997b;
        final Class cls = typeToken.f22996a;
        final InstanceCreator instanceCreator = (InstanceCreator) this.f22909a.get(type);
        if (instanceCreator != null) {
            return new ObjectConstructor<T>(this) {
                final /* synthetic */ ConstructorConstructor f30249c;

                public final T mo5249a() {
                    return instanceCreator.m25065a();
                }
            };
        }
        instanceCreator = (InstanceCreator) this.f22909a.get(cls);
        if (instanceCreator != null) {
            return new ObjectConstructor<T>(this) {
                final /* synthetic */ ConstructorConstructor f30252c;

                public final T mo5249a() {
                    return instanceCreator.m25065a();
                }
            };
        }
        ObjectConstructor<T> a = m25109a(cls);
        if (a != null) {
            return a;
        }
        a = Collection.class.isAssignableFrom(cls) ? SortedSet.class.isAssignableFrom(cls) ? new C24304(this) : EnumSet.class.isAssignableFrom(cls) ? new ObjectConstructor<T>(this) {
            final /* synthetic */ ConstructorConstructor f30257b;

            public final T mo5249a() {
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
        } : Set.class.isAssignableFrom(cls) ? new C24326(this) : Queue.class.isAssignableFrom(cls) ? new C24337(this) : new C24348(this) : Map.class.isAssignableFrom(cls) ? ConcurrentNavigableMap.class.isAssignableFrom(cls) ? new C24359(this) : ConcurrentMap.class.isAssignableFrom(cls) ? new ObjectConstructor<T>(this) {
            final /* synthetic */ ConstructorConstructor f30239a;

            {
                this.f30239a = r1;
            }

            public final T mo5249a() {
                return new ConcurrentHashMap();
            }
        } : SortedMap.class.isAssignableFrom(cls) ? new ObjectConstructor<T>(this) {
            final /* synthetic */ ConstructorConstructor f30240a;

            {
                this.f30240a = r1;
            }

            public final T mo5249a() {
                return new TreeMap();
            }
        } : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(TypeToken.m25142a(((ParameterizedType) type).getActualTypeArguments()[0]).f22996a)) ? new ObjectConstructor<T>(this) {
            final /* synthetic */ ConstructorConstructor f30242a;

            {
                this.f30242a = r1;
            }

            public final T mo5249a() {
                return new LinkedTreeMap();
            }
        } : new ObjectConstructor<T>(this) {
            final /* synthetic */ ConstructorConstructor f30241a;

            {
                this.f30241a = r1;
            }

            public final T mo5249a() {
                return new LinkedHashMap();
            }
        } : null;
        return a != null ? a : new ObjectConstructor<T>(this) {
            final /* synthetic */ ConstructorConstructor f30245c;
            private final UnsafeAllocator f30246d = UnsafeAllocator.m25128a();

            public final T mo5249a() {
                try {
                    return this.f30246d.mo5251a(cls);
                } catch (Throwable e) {
                    StringBuilder stringBuilder = new StringBuilder("Unable to invoke no-args constructor for ");
                    stringBuilder.append(type);
                    stringBuilder.append(". Registering an InstanceCreator with Gson for this type may fix this problem.");
                    throw new RuntimeException(stringBuilder.toString(), e);
                }
            }
        };
    }
}
