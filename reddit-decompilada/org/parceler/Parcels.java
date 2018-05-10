package org.parceler;

import android.os.Parcelable;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class Parcels {
    private static final ParcelCodeRepository f27206a;

    private static final class ParcelCodeRepository {
        ConcurrentMap<Class, ParcelableFactory> f27205a;

        private ParcelCodeRepository() {
            this.f27205a = new ConcurrentHashMap();
        }

        static String m28669a(Class cls) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(cls.getName());
            stringBuilder.append("$$Parcelable");
            return stringBuilder.toString();
        }

        public static org.parceler.Parcels.ParcelableFactory m28670b(java.lang.Class r2) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = m28669a(r2);	 Catch:{ ClassNotFoundException -> 0x000e }
            r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x000e }
            r1 = new org.parceler.Parcels$ParcelableFactoryReflectionProxy;	 Catch:{ ClassNotFoundException -> 0x000e }
            r1.<init>(r2, r0);	 Catch:{ ClassNotFoundException -> 0x000e }
            return r1;
        L_0x000e:
            r2 = 0;
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.parceler.Parcels.ParcelCodeRepository.b(java.lang.Class):org.parceler.Parcels$ParcelableFactory");
        }
    }

    public interface ParcelableFactory<T> {
        Parcelable mo6359a(T t);
    }

    private static final class ParcelableFactoryReflectionProxy<T> implements ParcelableFactory<T> {
        private final Constructor<? extends Parcelable> f33431a;

        public ParcelableFactoryReflectionProxy(Class<T> cls, Class<? extends Parcelable> cls2) {
            try {
                this.f33431a = cls2.getConstructor(new Class[]{cls});
            } catch (Class<T> cls3) {
                throw new ParcelerRuntimeException("Unable to create ParcelFactory Type", cls3);
            }
        }

        public final Parcelable mo6359a(T t) {
            try {
                return (Parcelable) this.f33431a.newInstance(new Object[]{t});
            } catch (T t2) {
                throw new ParcelerRuntimeException("Unable to create ParcelFactory Type", t2);
            } catch (T t22) {
                throw new ParcelerRuntimeException("Unable to create ParcelFactory Type", t22);
            } catch (T t222) {
                throw new ParcelerRuntimeException("Unable to create ParcelFactory Type", t222);
            }
        }
    }

    static {
        ParcelCodeRepository parcelCodeRepository = new ParcelCodeRepository();
        f27206a = parcelCodeRepository;
        parcelCodeRepository.f27205a.putAll(NonParcelRepository.m34208a().mo6360b());
    }

    public static <T> Parcelable m28672a(T t) {
        if (t == null) {
            return null;
        }
        Class cls = t.getClass();
        if (t == null) {
            return null;
        }
        ParcelCodeRepository parcelCodeRepository = f27206a;
        ParcelableFactory parcelableFactory = (ParcelableFactory) parcelCodeRepository.f27205a.get(cls);
        if (parcelableFactory == null) {
            parcelableFactory = ParcelCodeRepository.m28670b(cls);
            if (Parcelable.class.isAssignableFrom(cls)) {
                parcelableFactory = new ParcelableParcelableFactory();
            }
            if (parcelableFactory == null) {
                StringBuilder stringBuilder = new StringBuilder("Unable to find generated Parcelable class for ");
                stringBuilder.append(cls.getName());
                stringBuilder.append(", verify that your class is configured properly and that the Parcelable class ");
                stringBuilder.append(ParcelCodeRepository.m28669a(cls));
                stringBuilder.append(" is generated by Parceler.");
                throw new ParcelerRuntimeException(stringBuilder.toString());
            }
            ParcelableFactory parcelableFactory2 = (ParcelableFactory) parcelCodeRepository.f27205a.putIfAbsent(cls, parcelableFactory);
            if (parcelableFactory2 != null) {
                parcelableFactory = parcelableFactory2;
            }
        }
        return parcelableFactory.mo6359a(t);
    }

    public static <T> T m28673a(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        return ((ParcelWrapper) parcelable).getParcel();
    }
}
