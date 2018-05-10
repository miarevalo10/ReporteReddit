package com.google.common.reflect;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Maps;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public final class TypeResolver {
    private final TypeTable f8530a;

    private static class TypeTable {
        private final ImmutableMap<TypeVariableKey, Type> f8527a;

        class C11871 extends TypeTable {
            final /* synthetic */ TypeVariable f14945a;
            final /* synthetic */ TypeTable f14946b;
            final /* synthetic */ TypeTable f14947c;

            C11871(TypeTable typeTable, TypeVariable typeVariable, TypeTable typeTable2) {
                this.f14947c = typeTable;
                this.f14945a = typeVariable;
                this.f14946b = typeTable2;
            }

            public final Type mo2434a(TypeVariable<?> typeVariable, TypeTable typeTable) {
                if (typeVariable.getGenericDeclaration().equals(this.f14945a.getGenericDeclaration())) {
                    return typeVariable;
                }
                return this.f14946b.mo2434a(typeVariable, typeTable);
            }
        }

        TypeTable() {
            this.f8527a = ImmutableMap.m7126a();
        }

        private TypeTable(ImmutableMap<TypeVariableKey, Type> immutableMap) {
            this.f8527a = immutableMap;
        }

        final TypeTable m7291a(Map<TypeVariableKey, ? extends Type> map) {
            Builder b = ImmutableMap.m7129b();
            b.m7123a(this.f8527a.entrySet());
            map = map.entrySet().iterator();
            while (map.hasNext()) {
                Entry entry = (Entry) map.next();
                Object obj = (TypeVariableKey) entry.getKey();
                Type type = (Type) entry.getValue();
                Preconditions.m6917a(obj.m7295b(type) ^ 1, "Type variable %s bound to itself", obj);
                b.m7124a(obj, type);
            }
            return new TypeTable(b.m7125a());
        }

        Type mo2434a(TypeVariable<?> typeVariable, TypeTable typeTable) {
            Type type = (Type) this.f8527a.get(new TypeVariableKey(typeVariable));
            if (type != null) {
                return new TypeResolver(typeTable).m7302b(type);
            }
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length == 0) {
                return typeVariable;
            }
            Type[] a = new TypeResolver(typeTable).m7301a(bounds);
            if (NativeTypeVariableEquals.f8545a && Arrays.equals(bounds, a)) {
                return typeVariable;
            }
            return Types.m7326a(typeVariable.getGenericDeclaration(), typeVariable.getName(), a);
        }
    }

    static final class TypeVariableKey {
        private final TypeVariable<?> f8528a;

        TypeVariableKey(TypeVariable<?> typeVariable) {
            this.f8528a = (TypeVariable) Preconditions.m6908a((Object) typeVariable);
        }

        public final int hashCode() {
            return Objects.m14556a(this.f8528a.getGenericDeclaration(), this.f8528a.getName());
        }

        public final boolean equals(Object obj) {
            return obj instanceof TypeVariableKey ? m7294a(((TypeVariableKey) obj).f8528a) : null;
        }

        public final String toString() {
            return this.f8528a.toString();
        }

        static TypeVariableKey m7293a(Type type) {
            return type instanceof TypeVariable ? new TypeVariableKey((TypeVariable) type) : null;
        }

        final boolean m7295b(Type type) {
            return type instanceof TypeVariable ? m7294a((TypeVariable) type) : null;
        }

        private boolean m7294a(TypeVariable<?> typeVariable) {
            return (!this.f8528a.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) || this.f8528a.getName().equals(typeVariable.getName()) == null) ? null : true;
        }
    }

    private static class WildcardCapturer {
        private final AtomicInteger f8529a;

        WildcardCapturer() {
            this(new AtomicInteger());
        }

        private WildcardCapturer(AtomicInteger atomicInteger) {
            this.f8529a = atomicInteger;
        }

        final Type m7297a(Type type) {
            Preconditions.m6908a((Object) type);
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return Types.m7325a(m7296a().m7297a(((GenericArrayType) type).getGenericComponentType()));
            } else if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Class cls = (Class) parameterizedType.getRawType();
                TypeVariable[] typeParameters = cls.getTypeParameters();
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    final TypeVariable typeVariable = typeParameters[i];
                    actualTypeArguments[i] = new WildcardCapturer(this, this.f8529a) {
                        final /* synthetic */ WildcardCapturer f14949b;

                        final TypeVariable<?> mo2435a(Type[] typeArr) {
                            Set linkedHashSet = new LinkedHashSet(Arrays.asList(typeArr));
                            linkedHashSet.addAll(Arrays.asList(typeVariable.getBounds()));
                            if (linkedHashSet.size() > 1) {
                                linkedHashSet.remove(Object.class);
                            }
                            return super.mo2435a((Type[]) linkedHashSet.toArray(new Type[null]));
                        }
                    }.m7297a(actualTypeArguments[i]);
                }
                WildcardCapturer a = m7296a();
                type = parameterizedType.getOwnerType();
                return Types.m7324a(type == null ? null : a.m7297a(type), cls, actualTypeArguments);
            } else if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                return wildcardType.getLowerBounds().length == 0 ? mo2435a(wildcardType.getUpperBounds()) : type;
            } else {
                throw new AssertionError("must have been one of the known types");
            }
        }

        TypeVariable<?> mo2435a(Type[] typeArr) {
            StringBuilder stringBuilder = new StringBuilder("capture#");
            stringBuilder.append(this.f8529a.incrementAndGet());
            stringBuilder.append("-of ? extends ");
            stringBuilder.append(Joiner.m6881a().m6886a(Arrays.asList(typeArr)));
            return Types.m7326a((GenericDeclaration) WildcardCapturer.class, stringBuilder.toString(), typeArr);
        }

        private WildcardCapturer m7296a() {
            return new WildcardCapturer(this.f8529a);
        }
    }

    private static final class TypeMappingIntrospector extends TypeVisitor {
        private static final WildcardCapturer f14943a = new WildcardCapturer();
        private final Map<TypeVariableKey, Type> f14944b = Maps.m7226b();

        private TypeMappingIntrospector() {
        }

        static ImmutableMap<TypeVariableKey, Type> m14825a(Type type) {
            TypeMappingIntrospector typeMappingIntrospector = new TypeMappingIntrospector();
            typeMappingIntrospector.m7313a(f14943a.m7297a(type));
            return ImmutableMap.m7128a(typeMappingIntrospector.f14944b);
        }

        final void mo2430a(Class<?> cls) {
            m7313a(cls.getGenericSuperclass());
            m7313a((Type[]) cls.getGenericInterfaces());
        }

        final void mo2431a(ParameterizedType parameterizedType) {
            TypeVariable[] typeParameters = ((Class) parameterizedType.getRawType()).getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Preconditions.m6921b(typeParameters.length == actualTypeArguments.length);
            for (int i = 0; i < typeParameters.length; i++) {
                TypeVariableKey typeVariableKey = new TypeVariableKey(typeParameters[i]);
                Type type = actualTypeArguments[i];
                if (!this.f14944b.containsKey(typeVariableKey)) {
                    Type type2 = type;
                    while (type2 != null) {
                        if (typeVariableKey.m7295b(type2)) {
                            while (type != null) {
                                type = (Type) this.f14944b.remove(TypeVariableKey.m7293a(type));
                            }
                        } else {
                            type2 = (Type) this.f14944b.get(TypeVariableKey.m7293a(type2));
                        }
                    }
                    this.f14944b.put(typeVariableKey, type);
                }
            }
            m7313a(r0);
            m7313a(parameterizedType.getOwnerType());
        }

        final void mo2432a(TypeVariable<?> typeVariable) {
            m7313a((Type[]) typeVariable.getBounds());
        }

        final void mo2433a(WildcardType wildcardType) {
            m7313a((Type[]) wildcardType.getUpperBounds());
        }
    }

    public TypeResolver() {
        this.f8530a = new TypeTable();
    }

    private TypeResolver(TypeTable typeTable) {
        this.f8530a = typeTable;
    }

    static TypeResolver m7299a(Type type) {
        TypeResolver typeResolver = new TypeResolver();
        return new TypeResolver(typeResolver.f8530a.m7291a(TypeMappingIntrospector.m14825a(type)));
    }

    public final Type m7302b(Type type) {
        Preconditions.m6908a((Object) type);
        if (type instanceof TypeVariable) {
            TypeTable typeTable = this.f8530a;
            TypeVariable typeVariable = (TypeVariable) type;
            return typeTable.mo2434a(typeVariable, new C11871(typeTable, typeVariable, typeTable));
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type ownerType = parameterizedType.getOwnerType();
            if (ownerType == null) {
                ownerType = null;
            } else {
                ownerType = m7302b(ownerType);
            }
            return Types.m7324a(ownerType, (Class) m7302b(parameterizedType.getRawType()), m7301a(parameterizedType.getActualTypeArguments()));
        } else if (type instanceof GenericArrayType) {
            return Types.m7325a(m7302b(((GenericArrayType) type).getGenericComponentType()));
        } else {
            if (!(type instanceof WildcardType)) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            return new WildcardTypeImpl(m7301a(wildcardType.getLowerBounds()), m7301a(wildcardType.getUpperBounds()));
        }
    }

    private Type[] m7301a(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            typeArr2[i] = m7302b(typeArr[i]);
        }
        return typeArr2;
    }
}
