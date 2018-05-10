package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class TypeToken<T> extends TypeCapture<T> implements Serializable {
    final Type f14957a;
    private transient TypeResolver f14958b;

    private static abstract class TypeCollector<K> {
        static final TypeCollector<TypeToken<?>> f8531a = new C11901();
        static final TypeCollector<Class<?>> f8532b = new C11912();

        static class C11901 extends TypeCollector<TypeToken<?>> {
            C11901() {
                super();
            }

            final /* synthetic */ Class mo2437a(Object obj) {
                return ((TypeToken) obj).m14851b();
            }

            final /* synthetic */ Iterable mo2438b(Object obj) {
                TypeToken typeToken = (TypeToken) obj;
                if (typeToken.f14957a instanceof TypeVariable) {
                    return TypeToken.m14843a(((TypeVariable) typeToken.f14957a).getBounds());
                }
                if (typeToken.f14957a instanceof WildcardType) {
                    return TypeToken.m14843a(((WildcardType) typeToken.f14957a).getUpperBounds());
                }
                Builder e = ImmutableList.m14736e();
                for (Type b : typeToken.m14851b().getGenericInterfaces()) {
                    e.m19281c(typeToken.m14850b(b));
                }
                return e.m19278a();
            }

            final /* synthetic */ Object mo2439c(Object obj) {
                TypeToken typeToken = (TypeToken) obj;
                if (typeToken.f14957a instanceof TypeVariable) {
                    return TypeToken.m14848c(((TypeVariable) typeToken.f14957a).getBounds()[0]);
                }
                if (typeToken.f14957a instanceof WildcardType) {
                    return TypeToken.m14848c(((WildcardType) typeToken.f14957a).getUpperBounds()[0]);
                }
                Type genericSuperclass = typeToken.m14851b().getGenericSuperclass();
                if (genericSuperclass == null) {
                    return null;
                }
                return typeToken.m14850b(genericSuperclass);
            }
        }

        static class C11912 extends TypeCollector<Class<?>> {
            C11912() {
                super();
            }

            final /* bridge */ /* synthetic */ Class mo2437a(Object obj) {
                return (Class) obj;
            }

            final /* synthetic */ Iterable mo2438b(Object obj) {
                return Arrays.asList(((Class) obj).getInterfaces());
            }

            final /* synthetic */ Object mo2439c(Object obj) {
                return ((Class) obj).getSuperclass();
            }
        }

        abstract Class<?> mo2437a(K k);

        abstract Iterable<? extends K> mo2438b(K k);

        abstract K mo2439c(K k);

        private TypeCollector() {
        }

        final ImmutableList<K> m7304a(Iterable<? extends K> iterable) {
            final Map b = Maps.m7226b();
            for (Object a : iterable) {
                m7303a(a, b);
            }
            iterable = Ordering.m7245b().mo2422a();
            return ImmutableList.m14731a(new Ordering<K>() {
                public final int compare(K k, K k2) {
                    return iterable.compare(b.get(k), b.get(k2));
                }
            }, b.keySet());
        }

        private int m7303a(K k, Map<? super K, Integer> map) {
            Integer num = (Integer) map.get(k);
            if (num != null) {
                return num.intValue();
            }
            int isInterface = mo2437a((Object) k).isInterface();
            for (Object a : mo2438b(k)) {
                isInterface = Math.max(isInterface, m7303a(a, map));
            }
            Object c = mo2439c(k);
            if (c != null) {
                isInterface = Math.max(isInterface, m7303a(c, map));
            }
            isInterface++;
            map.put(k, Integer.valueOf(isInterface));
            return isInterface;
        }
    }

    private enum TypeFilter implements Predicate<TypeToken<?>> {
    }

    private static final class SimpleTypeToken<T> extends TypeToken<T> {
        SimpleTypeToken(Type type) {
            super(type);
        }
    }

    public class TypeSet extends ForwardingSet<TypeToken<? super T>> implements Serializable {
        final /* synthetic */ TypeToken f19265a;
        private transient ImmutableSet<TypeToken<? super T>> f19266b;

        protected final /* synthetic */ Collection mo3603a() {
            return mo4055b();
        }

        protected /* synthetic */ Object delegate() {
            return mo4055b();
        }

        TypeSet(TypeToken typeToken) {
            this.f19265a = typeToken;
        }

        protected final Set<TypeToken<? super T>> mo4055b() {
            Set set = this.f19266b;
            if (set != null) {
                return set;
            }
            FluentIterable a = FluentIterable.m7110a(TypeCollector.f8531a.m7304a(ImmutableList.m14726a(this.f19265a)));
            set = ImmutableSet.m14744a(FluentIterable.m7110a(Iterables.m7141b(a.m7111a(), TypeFilter.f14954a)).m7111a());
            this.f19266b = set;
            return set;
        }

        public final Set<Class<? super T>> m20501c() {
            return ImmutableSet.m14747a(TypeCollector.f8532b.m7304a(this.f19265a.m14849d()));
        }
    }

    protected TypeToken() {
        this.f14957a = m7290a();
        Preconditions.m6923b(!(this.f14957a instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", this.f14957a);
    }

    private TypeToken(Type type) {
        this.f14957a = (Type) Preconditions.m6908a((Object) type);
    }

    public static <T> TypeToken<T> m14845a(Class<T> cls) {
        return new SimpleTypeToken(cls);
    }

    public static TypeToken<?> m14846a(Type type) {
        return new SimpleTypeToken(type);
    }

    public final Class<? super T> m14851b() {
        return (Class) m14849d().mo2397a().next();
    }

    static TypeToken<? super T> m14848c(Type type) {
        type = m14846a(type);
        return type.m14851b().isInterface() ? null : type;
    }

    static ImmutableList<TypeToken<? super T>> m14843a(Type[] typeArr) {
        Builder e = ImmutableList.m14736e();
        for (Type a : typeArr) {
            TypeToken a2 = m14846a(a);
            if (a2.m14851b().isInterface()) {
                e.m19281c(a2);
            }
        }
        return e.m19278a();
    }

    public final TypeSet m14852c() {
        return new TypeSet(this);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TypeToken)) {
            return null;
        }
        return this.f14957a.equals(((TypeToken) obj).f14957a);
    }

    public int hashCode() {
        return this.f14957a.hashCode();
    }

    public String toString() {
        return Types.m7330b(this.f14957a);
    }

    private ImmutableSet<Class<? super T>> m14849d() {
        final ImmutableSet.Builder g = ImmutableSet.m14752g();
        new TypeVisitor(this) {
            final /* synthetic */ TypeToken f14951b;

            final void mo2432a(TypeVariable<?> typeVariable) {
                m7313a((Type[]) typeVariable.getBounds());
            }

            final void mo2433a(WildcardType wildcardType) {
                m7313a((Type[]) wildcardType.getUpperBounds());
            }

            final void mo2431a(ParameterizedType parameterizedType) {
                g.m19288c((Class) parameterizedType.getRawType());
            }

            final void mo2430a(Class<?> cls) {
                g.m19288c(cls);
            }

            final void mo2436a(GenericArrayType genericArrayType) {
                g.m19288c(Types.m7322a(TypeToken.m14846a(genericArrayType.getGenericComponentType()).m14851b()));
            }
        }.m7313a(this.f14957a);
        return g.m19286a();
    }

    final TypeToken<?> m14850b(Type type) {
        Preconditions.m6908a((Object) type);
        TypeResolver typeResolver = this.f14958b;
        if (typeResolver == null) {
            typeResolver = TypeResolver.m7299a(this.f14957a);
            this.f14958b = typeResolver;
        }
        type = m14846a(typeResolver.m7302b(type));
        type.f14958b = this.f14958b;
        return type;
    }
}
