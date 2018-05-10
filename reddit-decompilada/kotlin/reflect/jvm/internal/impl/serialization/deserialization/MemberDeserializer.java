package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.serialization.Flags;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Constructor;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.MemberKind;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.ValueParameter;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Visibility;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Package;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotationsWithPossibleTargets;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedSimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: MemberDeserializer.kt */
public final class MemberDeserializer {
    public final AnnotationDeserializer f26256a = new AnnotationDeserializer(this.f26257b.f26245c.f26230c, this.f26257b.f26245c.f26239l);
    public final DeserializationContext f26257b;

    private static int m27842a(int i) {
        return (i & 63) + ((i >> 8) << 6);
    }

    public MemberDeserializer(DeserializationContext deserializationContext) {
        Intrinsics.m26847b(deserializationContext, "c");
        this.f26257b = deserializationContext;
    }

    public final PropertyDescriptor m27851a(Property property) {
        int i;
        MessageLite messageLite;
        Annotations a;
        KotlinType a2;
        Object a3;
        int i2;
        Object a4;
        boolean z;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        PropertyDescriptor propertyDescriptor;
        MemberDeserializer memberDeserializer = this;
        Property property2 = property;
        Intrinsics.m26847b(property2, "proto");
        if (property.m41744h()) {
            i = property2.f40420e;
        } else {
            i = m27842a(property2.f40421f);
        }
        int i3 = i;
        DeclarationDescriptor declarationDescriptor = memberDeserializer.f26257b.f26247e;
        MessageLite messageLite2 = property2;
        Annotations a5 = m27845a(messageLite2, i3, AnnotatedCallableKind.PROPERTY);
        Modality a6 = Deserialization.m27828a((ProtoBuf.Modality) Flags.f26153d.mo5920b(i3));
        Object a7 = Deserialization.m27829a((Visibility) Flags.f26152c.mo5920b(i3));
        Intrinsics.m26843a(a7, "Deserialization.visibili…gs.VISIBILITY.get(flags))");
        Object a8 = Flags.f26166q.m33502a(i3);
        Intrinsics.m26843a(a8, "Flags.IS_VAR.get(flags)");
        boolean booleanValue = a8.booleanValue();
        Object b = memberDeserializer.f26257b.f26246d.mo5830b(property2.f40422g);
        Intrinsics.m26843a(b, "c.nameResolver.getName(proto.name)");
        Kind a9 = Deserialization.m27826a((MemberKind) Flags.f26159j.mo5920b(i3));
        a8 = Flags.f26170u.m33502a(i3);
        Intrinsics.m26843a(a8, "Flags.IS_LATEINIT.get(flags)");
        boolean booleanValue2 = a8.booleanValue();
        a8 = Flags.f26169t.m33502a(i3);
        Intrinsics.m26843a(a8, "Flags.IS_CONST.get(flags)");
        boolean booleanValue3 = a8.booleanValue();
        a8 = Flags.f26172w.m33502a(i3);
        Intrinsics.m26843a(a8, "Flags.IS_EXTERNAL_PROPERTY.get(flags)");
        boolean booleanValue4 = a8.booleanValue();
        a8 = Flags.f26173x.m33502a(i3);
        Intrinsics.m26843a(a8, "Flags.IS_DELEGATED.get(flags)");
        boolean booleanValue5 = a8.booleanValue();
        NameResolver nameResolver = memberDeserializer.f26257b.f26246d;
        TypeTable typeTable = memberDeserializer.f26257b.f26248f;
        MessageLite messageLite3 = messageLite2;
        DeserializedPropertyDescriptor deserializedPropertyDescriptor = r1;
        int i4 = i3;
        DeserializedPropertyDescriptor deserializedPropertyDescriptor2 = new DeserializedPropertyDescriptor(declarationDescriptor, null, a5, a6, a7, booleanValue, b, a9, booleanValue2, booleanValue3, booleanValue4, booleanValue5, property2, nameResolver, typeTable, memberDeserializer.f26257b.f26249g, memberDeserializer.f26257b.f26250h);
        DeserializationContext deserializationContext = memberDeserializer.f26257b;
        DeserializedPropertyDescriptor deserializedPropertyDescriptor3 = deserializedPropertyDescriptor;
        DeclarationDescriptor declarationDescriptor2 = deserializedPropertyDescriptor3;
        Property property3 = property;
        Object obj = property3.f40425j;
        Intrinsics.m26843a(obj, "proto.typeParameterList");
        deserializationContext = deserializationContext.m27835a(declarationDescriptor2, obj, deserializationContext.f26246d, deserializationContext.f26248f);
        int i5 = i4;
        obj = Flags.f26167r.m33502a(i5);
        Intrinsics.m26843a(obj, "hasGetter");
        if (obj.booleanValue() && ProtoTypeTableUtilKt.m27875a(property)) {
            messageLite = messageLite3;
            a = new DeserializedAnnotationsWithPossibleTargets(memberDeserializer.f26257b.f26245c.f26229b, new MemberDeserializer$getReceiverParameterAnnotations$1(memberDeserializer, messageLite, AnnotatedCallableKind.PROPERTY_GETTER));
        } else {
            messageLite = messageLite3;
            Companion companion = Annotations.f32643a;
            a = Companion.m27115a();
        }
        KotlinType a10 = Annotations.f32643a;
        List a11 = deserializationContext.f26243a.m27889a();
        ReceiverParameterDescriptor a12 = m27844a();
        Type b2 = ProtoTypeTableUtilKt.m27877b(property3, memberDeserializer.f26257b.f26248f);
        PropertySetterDescriptorImpl propertySetterDescriptorImpl = null;
        if (b2 != null) {
            a2 = deserializationContext.f26243a.m27890a(b2, a);
        } else {
            a2 = null;
        }
        deserializedPropertyDescriptor3.m42991a(a10, a11, a12, a2);
        Intrinsics.m26843a(obj, "hasGetter");
        if (obj.booleanValue()) {
            boolean z2;
            Companion companion2;
            int i6 = property3.f40429n;
            if (property.m41750n()) {
                a3 = Flags.f26147B.m33502a(i6);
                Intrinsics.m26843a(a3, "Flags.IS_NOT_DEFAULT.get(getterFlags)");
                if (a3.booleanValue()) {
                    i2 = 1;
                    if (property.m41750n()) {
                        a4 = Flags.f26148C.m33502a(i6);
                        Intrinsics.m26843a(a4, "Flags.IS_EXTERNAL_ACCESSOR.get(getterFlags)");
                        if (a4.booleanValue()) {
                            z = true;
                            if (property.m41750n()) {
                                a4 = Flags.f26149D.m33502a(i6);
                                Intrinsics.m26843a(a4, "Flags.IS_INLINE_ACCESSOR.get(getterFlags)");
                                if (a4.booleanValue()) {
                                    z2 = true;
                                    if (i2 == 0) {
                                        propertyGetterDescriptorImpl = new PropertyGetterDescriptorImpl(deserializedPropertyDescriptor3, m27845a(messageLite, i6, AnnotatedCallableKind.PROPERTY_GETTER), Deserialization.m27828a((ProtoBuf.Modality) Flags.f26153d.mo5920b(i6)), Deserialization.m27829a((Visibility) Flags.f26152c.mo5920b(i6)), i2 ^ 1, z, z2, deserializedPropertyDescriptor3.mo7760t(), null, SourceElement.f25498a);
                                    } else {
                                        propertyDescriptor = deserializedPropertyDescriptor3;
                                        companion2 = Annotations.f32643a;
                                        propertyGetterDescriptorImpl = DescriptorFactory.m27634b(propertyDescriptor, Companion.m27115a());
                                        Intrinsics.m26843a((Object) propertyGetterDescriptorImpl, "DescriptorFactory.create…perty, Annotations.EMPTY)");
                                    }
                                    propertyGetterDescriptorImpl.m43066a(deserializedPropertyDescriptor3.aN_());
                                }
                            }
                            z2 = false;
                            if (i2 == 0) {
                                propertyDescriptor = deserializedPropertyDescriptor3;
                                companion2 = Annotations.f32643a;
                                propertyGetterDescriptorImpl = DescriptorFactory.m27634b(propertyDescriptor, Companion.m27115a());
                                Intrinsics.m26843a((Object) propertyGetterDescriptorImpl, "DescriptorFactory.create…perty, Annotations.EMPTY)");
                            } else {
                                propertyGetterDescriptorImpl = new PropertyGetterDescriptorImpl(deserializedPropertyDescriptor3, m27845a(messageLite, i6, AnnotatedCallableKind.PROPERTY_GETTER), Deserialization.m27828a((ProtoBuf.Modality) Flags.f26153d.mo5920b(i6)), Deserialization.m27829a((Visibility) Flags.f26152c.mo5920b(i6)), i2 ^ 1, z, z2, deserializedPropertyDescriptor3.mo7760t(), null, SourceElement.f25498a);
                            }
                            propertyGetterDescriptorImpl.m43066a(deserializedPropertyDescriptor3.aN_());
                        }
                    }
                    z = false;
                    if (property.m41750n()) {
                        a4 = Flags.f26149D.m33502a(i6);
                        Intrinsics.m26843a(a4, "Flags.IS_INLINE_ACCESSOR.get(getterFlags)");
                        if (a4.booleanValue()) {
                            z2 = true;
                            if (i2 == 0) {
                                propertyGetterDescriptorImpl = new PropertyGetterDescriptorImpl(deserializedPropertyDescriptor3, m27845a(messageLite, i6, AnnotatedCallableKind.PROPERTY_GETTER), Deserialization.m27828a((ProtoBuf.Modality) Flags.f26153d.mo5920b(i6)), Deserialization.m27829a((Visibility) Flags.f26152c.mo5920b(i6)), i2 ^ 1, z, z2, deserializedPropertyDescriptor3.mo7760t(), null, SourceElement.f25498a);
                            } else {
                                propertyDescriptor = deserializedPropertyDescriptor3;
                                companion2 = Annotations.f32643a;
                                propertyGetterDescriptorImpl = DescriptorFactory.m27634b(propertyDescriptor, Companion.m27115a());
                                Intrinsics.m26843a((Object) propertyGetterDescriptorImpl, "DescriptorFactory.create…perty, Annotations.EMPTY)");
                            }
                            propertyGetterDescriptorImpl.m43066a(deserializedPropertyDescriptor3.aN_());
                        }
                    }
                    z2 = false;
                    if (i2 == 0) {
                        propertyDescriptor = deserializedPropertyDescriptor3;
                        companion2 = Annotations.f32643a;
                        propertyGetterDescriptorImpl = DescriptorFactory.m27634b(propertyDescriptor, Companion.m27115a());
                        Intrinsics.m26843a((Object) propertyGetterDescriptorImpl, "DescriptorFactory.create…perty, Annotations.EMPTY)");
                    } else {
                        propertyGetterDescriptorImpl = new PropertyGetterDescriptorImpl(deserializedPropertyDescriptor3, m27845a(messageLite, i6, AnnotatedCallableKind.PROPERTY_GETTER), Deserialization.m27828a((ProtoBuf.Modality) Flags.f26153d.mo5920b(i6)), Deserialization.m27829a((Visibility) Flags.f26152c.mo5920b(i6)), i2 ^ 1, z, z2, deserializedPropertyDescriptor3.mo7760t(), null, SourceElement.f25498a);
                    }
                    propertyGetterDescriptorImpl.m43066a(deserializedPropertyDescriptor3.aN_());
                }
            }
            i2 = 0;
            if (property.m41750n()) {
                a4 = Flags.f26148C.m33502a(i6);
                Intrinsics.m26843a(a4, "Flags.IS_EXTERNAL_ACCESSOR.get(getterFlags)");
                if (a4.booleanValue()) {
                    z = true;
                    if (property.m41750n()) {
                        a4 = Flags.f26149D.m33502a(i6);
                        Intrinsics.m26843a(a4, "Flags.IS_INLINE_ACCESSOR.get(getterFlags)");
                        if (a4.booleanValue()) {
                            z2 = true;
                            if (i2 == 0) {
                                propertyGetterDescriptorImpl = new PropertyGetterDescriptorImpl(deserializedPropertyDescriptor3, m27845a(messageLite, i6, AnnotatedCallableKind.PROPERTY_GETTER), Deserialization.m27828a((ProtoBuf.Modality) Flags.f26153d.mo5920b(i6)), Deserialization.m27829a((Visibility) Flags.f26152c.mo5920b(i6)), i2 ^ 1, z, z2, deserializedPropertyDescriptor3.mo7760t(), null, SourceElement.f25498a);
                            } else {
                                propertyDescriptor = deserializedPropertyDescriptor3;
                                companion2 = Annotations.f32643a;
                                propertyGetterDescriptorImpl = DescriptorFactory.m27634b(propertyDescriptor, Companion.m27115a());
                                Intrinsics.m26843a((Object) propertyGetterDescriptorImpl, "DescriptorFactory.create…perty, Annotations.EMPTY)");
                            }
                            propertyGetterDescriptorImpl.m43066a(deserializedPropertyDescriptor3.aN_());
                        }
                    }
                    z2 = false;
                    if (i2 == 0) {
                        propertyDescriptor = deserializedPropertyDescriptor3;
                        companion2 = Annotations.f32643a;
                        propertyGetterDescriptorImpl = DescriptorFactory.m27634b(propertyDescriptor, Companion.m27115a());
                        Intrinsics.m26843a((Object) propertyGetterDescriptorImpl, "DescriptorFactory.create…perty, Annotations.EMPTY)");
                    } else {
                        propertyGetterDescriptorImpl = new PropertyGetterDescriptorImpl(deserializedPropertyDescriptor3, m27845a(messageLite, i6, AnnotatedCallableKind.PROPERTY_GETTER), Deserialization.m27828a((ProtoBuf.Modality) Flags.f26153d.mo5920b(i6)), Deserialization.m27829a((Visibility) Flags.f26152c.mo5920b(i6)), i2 ^ 1, z, z2, deserializedPropertyDescriptor3.mo7760t(), null, SourceElement.f25498a);
                    }
                    propertyGetterDescriptorImpl.m43066a(deserializedPropertyDescriptor3.aN_());
                }
            }
            z = false;
            if (property.m41750n()) {
                a4 = Flags.f26149D.m33502a(i6);
                Intrinsics.m26843a(a4, "Flags.IS_INLINE_ACCESSOR.get(getterFlags)");
                if (a4.booleanValue()) {
                    z2 = true;
                    if (i2 == 0) {
                        propertyGetterDescriptorImpl = new PropertyGetterDescriptorImpl(deserializedPropertyDescriptor3, m27845a(messageLite, i6, AnnotatedCallableKind.PROPERTY_GETTER), Deserialization.m27828a((ProtoBuf.Modality) Flags.f26153d.mo5920b(i6)), Deserialization.m27829a((Visibility) Flags.f26152c.mo5920b(i6)), i2 ^ 1, z, z2, deserializedPropertyDescriptor3.mo7760t(), null, SourceElement.f25498a);
                    } else {
                        propertyDescriptor = deserializedPropertyDescriptor3;
                        companion2 = Annotations.f32643a;
                        propertyGetterDescriptorImpl = DescriptorFactory.m27634b(propertyDescriptor, Companion.m27115a());
                        Intrinsics.m26843a((Object) propertyGetterDescriptorImpl, "DescriptorFactory.create…perty, Annotations.EMPTY)");
                    }
                    propertyGetterDescriptorImpl.m43066a(deserializedPropertyDescriptor3.aN_());
                }
            }
            z2 = false;
            if (i2 == 0) {
                propertyDescriptor = deserializedPropertyDescriptor3;
                companion2 = Annotations.f32643a;
                propertyGetterDescriptorImpl = DescriptorFactory.m27634b(propertyDescriptor, Companion.m27115a());
                Intrinsics.m26843a((Object) propertyGetterDescriptorImpl, "DescriptorFactory.create…perty, Annotations.EMPTY)");
            } else {
                propertyGetterDescriptorImpl = new PropertyGetterDescriptorImpl(deserializedPropertyDescriptor3, m27845a(messageLite, i6, AnnotatedCallableKind.PROPERTY_GETTER), Deserialization.m27828a((ProtoBuf.Modality) Flags.f26153d.mo5920b(i6)), Deserialization.m27829a((Visibility) Flags.f26152c.mo5920b(i6)), i2 ^ 1, z, z2, deserializedPropertyDescriptor3.mo7760t(), null, SourceElement.f25498a);
            }
            propertyGetterDescriptorImpl.m43066a(deserializedPropertyDescriptor3.aN_());
        } else {
            propertyGetterDescriptorImpl = null;
        }
        a3 = Flags.f26168s.m33502a(i5);
        Intrinsics.m26843a(a3, "Flags.HAS_SETTER.get(flags)");
        if (a3.booleanValue()) {
            int i7;
            Object a13;
            boolean z3;
            Companion companion3;
            i2 = property3.f40430o;
            if (property.m41751o()) {
                a4 = Flags.f26147B.m33502a(i2);
                Intrinsics.m26843a(a4, "Flags.IS_NOT_DEFAULT.get(setterFlags)");
                if (a4.booleanValue()) {
                    i7 = 1;
                    if (property.m41751o()) {
                        a13 = Flags.f26148C.m33502a(i2);
                        Intrinsics.m26843a(a13, "Flags.IS_EXTERNAL_ACCESSOR.get(setterFlags)");
                        if (a13.booleanValue()) {
                            z3 = true;
                            if (property.m41750n()) {
                                a13 = Flags.f26149D.m33502a(i2);
                                Intrinsics.m26843a(a13, "Flags.IS_INLINE_ACCESSOR.get(setterFlags)");
                                if (a13.booleanValue()) {
                                    z = true;
                                    if (i7 == 0) {
                                        propertySetterDescriptorImpl = new PropertySetterDescriptorImpl(deserializedPropertyDescriptor3, m27845a(messageLite, i2, AnnotatedCallableKind.PROPERTY_SETTER), Deserialization.m27828a((ProtoBuf.Modality) Flags.f26153d.mo5920b(i2)), Deserialization.m27829a((Visibility) Flags.f26152c.mo5920b(i2)), i7 ^ 1, z3, z, deserializedPropertyDescriptor3.mo7760t(), null, SourceElement.f25498a);
                                        propertySetterDescriptorImpl.m43075a((ValueParameterDescriptor) CollectionsKt___CollectionsKt.m41441h(deserializationContext.m27835a(propertySetterDescriptorImpl, CollectionsKt__CollectionsKt.m26790a(), deserializationContext.f26246d, deserializationContext.f26248f).f26244b.m27843a(CollectionsKt__CollectionsKt.m26791a((Object) property3.f40428m), messageLite, AnnotatedCallableKind.PROPERTY_SETTER)));
                                    } else {
                                        propertyDescriptor = deserializedPropertyDescriptor3;
                                        companion3 = Annotations.f32643a;
                                        propertySetterDescriptorImpl = DescriptorFactory.m27631a(propertyDescriptor, Companion.m27115a());
                                        Intrinsics.m26843a((Object) propertySetterDescriptorImpl, "DescriptorFactory.create…perty, Annotations.EMPTY)");
                                    }
                                }
                            }
                            z = false;
                            if (i7 == 0) {
                                propertyDescriptor = deserializedPropertyDescriptor3;
                                companion3 = Annotations.f32643a;
                                propertySetterDescriptorImpl = DescriptorFactory.m27631a(propertyDescriptor, Companion.m27115a());
                                Intrinsics.m26843a((Object) propertySetterDescriptorImpl, "DescriptorFactory.create…perty, Annotations.EMPTY)");
                            } else {
                                propertySetterDescriptorImpl = new PropertySetterDescriptorImpl(deserializedPropertyDescriptor3, m27845a(messageLite, i2, AnnotatedCallableKind.PROPERTY_SETTER), Deserialization.m27828a((ProtoBuf.Modality) Flags.f26153d.mo5920b(i2)), Deserialization.m27829a((Visibility) Flags.f26152c.mo5920b(i2)), i7 ^ 1, z3, z, deserializedPropertyDescriptor3.mo7760t(), null, SourceElement.f25498a);
                                propertySetterDescriptorImpl.m43075a((ValueParameterDescriptor) CollectionsKt___CollectionsKt.m41441h(deserializationContext.m27835a(propertySetterDescriptorImpl, CollectionsKt__CollectionsKt.m26790a(), deserializationContext.f26246d, deserializationContext.f26248f).f26244b.m27843a(CollectionsKt__CollectionsKt.m26791a((Object) property3.f40428m), messageLite, AnnotatedCallableKind.PROPERTY_SETTER)));
                            }
                        }
                    }
                    z3 = false;
                    if (property.m41750n()) {
                        a13 = Flags.f26149D.m33502a(i2);
                        Intrinsics.m26843a(a13, "Flags.IS_INLINE_ACCESSOR.get(setterFlags)");
                        if (a13.booleanValue()) {
                            z = true;
                            if (i7 == 0) {
                                propertySetterDescriptorImpl = new PropertySetterDescriptorImpl(deserializedPropertyDescriptor3, m27845a(messageLite, i2, AnnotatedCallableKind.PROPERTY_SETTER), Deserialization.m27828a((ProtoBuf.Modality) Flags.f26153d.mo5920b(i2)), Deserialization.m27829a((Visibility) Flags.f26152c.mo5920b(i2)), i7 ^ 1, z3, z, deserializedPropertyDescriptor3.mo7760t(), null, SourceElement.f25498a);
                                propertySetterDescriptorImpl.m43075a((ValueParameterDescriptor) CollectionsKt___CollectionsKt.m41441h(deserializationContext.m27835a(propertySetterDescriptorImpl, CollectionsKt__CollectionsKt.m26790a(), deserializationContext.f26246d, deserializationContext.f26248f).f26244b.m27843a(CollectionsKt__CollectionsKt.m26791a((Object) property3.f40428m), messageLite, AnnotatedCallableKind.PROPERTY_SETTER)));
                            } else {
                                propertyDescriptor = deserializedPropertyDescriptor3;
                                companion3 = Annotations.f32643a;
                                propertySetterDescriptorImpl = DescriptorFactory.m27631a(propertyDescriptor, Companion.m27115a());
                                Intrinsics.m26843a((Object) propertySetterDescriptorImpl, "DescriptorFactory.create…perty, Annotations.EMPTY)");
                            }
                        }
                    }
                    z = false;
                    if (i7 == 0) {
                        propertyDescriptor = deserializedPropertyDescriptor3;
                        companion3 = Annotations.f32643a;
                        propertySetterDescriptorImpl = DescriptorFactory.m27631a(propertyDescriptor, Companion.m27115a());
                        Intrinsics.m26843a((Object) propertySetterDescriptorImpl, "DescriptorFactory.create…perty, Annotations.EMPTY)");
                    } else {
                        propertySetterDescriptorImpl = new PropertySetterDescriptorImpl(deserializedPropertyDescriptor3, m27845a(messageLite, i2, AnnotatedCallableKind.PROPERTY_SETTER), Deserialization.m27828a((ProtoBuf.Modality) Flags.f26153d.mo5920b(i2)), Deserialization.m27829a((Visibility) Flags.f26152c.mo5920b(i2)), i7 ^ 1, z3, z, deserializedPropertyDescriptor3.mo7760t(), null, SourceElement.f25498a);
                        propertySetterDescriptorImpl.m43075a((ValueParameterDescriptor) CollectionsKt___CollectionsKt.m41441h(deserializationContext.m27835a(propertySetterDescriptorImpl, CollectionsKt__CollectionsKt.m26790a(), deserializationContext.f26246d, deserializationContext.f26248f).f26244b.m27843a(CollectionsKt__CollectionsKt.m26791a((Object) property3.f40428m), messageLite, AnnotatedCallableKind.PROPERTY_SETTER)));
                    }
                }
            }
            i7 = 0;
            if (property.m41751o()) {
                a13 = Flags.f26148C.m33502a(i2);
                Intrinsics.m26843a(a13, "Flags.IS_EXTERNAL_ACCESSOR.get(setterFlags)");
                if (a13.booleanValue()) {
                    z3 = true;
                    if (property.m41750n()) {
                        a13 = Flags.f26149D.m33502a(i2);
                        Intrinsics.m26843a(a13, "Flags.IS_INLINE_ACCESSOR.get(setterFlags)");
                        if (a13.booleanValue()) {
                            z = true;
                            if (i7 == 0) {
                                propertySetterDescriptorImpl = new PropertySetterDescriptorImpl(deserializedPropertyDescriptor3, m27845a(messageLite, i2, AnnotatedCallableKind.PROPERTY_SETTER), Deserialization.m27828a((ProtoBuf.Modality) Flags.f26153d.mo5920b(i2)), Deserialization.m27829a((Visibility) Flags.f26152c.mo5920b(i2)), i7 ^ 1, z3, z, deserializedPropertyDescriptor3.mo7760t(), null, SourceElement.f25498a);
                                propertySetterDescriptorImpl.m43075a((ValueParameterDescriptor) CollectionsKt___CollectionsKt.m41441h(deserializationContext.m27835a(propertySetterDescriptorImpl, CollectionsKt__CollectionsKt.m26790a(), deserializationContext.f26246d, deserializationContext.f26248f).f26244b.m27843a(CollectionsKt__CollectionsKt.m26791a((Object) property3.f40428m), messageLite, AnnotatedCallableKind.PROPERTY_SETTER)));
                            } else {
                                propertyDescriptor = deserializedPropertyDescriptor3;
                                companion3 = Annotations.f32643a;
                                propertySetterDescriptorImpl = DescriptorFactory.m27631a(propertyDescriptor, Companion.m27115a());
                                Intrinsics.m26843a((Object) propertySetterDescriptorImpl, "DescriptorFactory.create…perty, Annotations.EMPTY)");
                            }
                        }
                    }
                    z = false;
                    if (i7 == 0) {
                        propertyDescriptor = deserializedPropertyDescriptor3;
                        companion3 = Annotations.f32643a;
                        propertySetterDescriptorImpl = DescriptorFactory.m27631a(propertyDescriptor, Companion.m27115a());
                        Intrinsics.m26843a((Object) propertySetterDescriptorImpl, "DescriptorFactory.create…perty, Annotations.EMPTY)");
                    } else {
                        propertySetterDescriptorImpl = new PropertySetterDescriptorImpl(deserializedPropertyDescriptor3, m27845a(messageLite, i2, AnnotatedCallableKind.PROPERTY_SETTER), Deserialization.m27828a((ProtoBuf.Modality) Flags.f26153d.mo5920b(i2)), Deserialization.m27829a((Visibility) Flags.f26152c.mo5920b(i2)), i7 ^ 1, z3, z, deserializedPropertyDescriptor3.mo7760t(), null, SourceElement.f25498a);
                        propertySetterDescriptorImpl.m43075a((ValueParameterDescriptor) CollectionsKt___CollectionsKt.m41441h(deserializationContext.m27835a(propertySetterDescriptorImpl, CollectionsKt__CollectionsKt.m26790a(), deserializationContext.f26246d, deserializationContext.f26248f).f26244b.m27843a(CollectionsKt__CollectionsKt.m26791a((Object) property3.f40428m), messageLite, AnnotatedCallableKind.PROPERTY_SETTER)));
                    }
                }
            }
            z3 = false;
            if (property.m41750n()) {
                a13 = Flags.f26149D.m33502a(i2);
                Intrinsics.m26843a(a13, "Flags.IS_INLINE_ACCESSOR.get(setterFlags)");
                if (a13.booleanValue()) {
                    z = true;
                    if (i7 == 0) {
                        propertySetterDescriptorImpl = new PropertySetterDescriptorImpl(deserializedPropertyDescriptor3, m27845a(messageLite, i2, AnnotatedCallableKind.PROPERTY_SETTER), Deserialization.m27828a((ProtoBuf.Modality) Flags.f26153d.mo5920b(i2)), Deserialization.m27829a((Visibility) Flags.f26152c.mo5920b(i2)), i7 ^ 1, z3, z, deserializedPropertyDescriptor3.mo7760t(), null, SourceElement.f25498a);
                        propertySetterDescriptorImpl.m43075a((ValueParameterDescriptor) CollectionsKt___CollectionsKt.m41441h(deserializationContext.m27835a(propertySetterDescriptorImpl, CollectionsKt__CollectionsKt.m26790a(), deserializationContext.f26246d, deserializationContext.f26248f).f26244b.m27843a(CollectionsKt__CollectionsKt.m26791a((Object) property3.f40428m), messageLite, AnnotatedCallableKind.PROPERTY_SETTER)));
                    } else {
                        propertyDescriptor = deserializedPropertyDescriptor3;
                        companion3 = Annotations.f32643a;
                        propertySetterDescriptorImpl = DescriptorFactory.m27631a(propertyDescriptor, Companion.m27115a());
                        Intrinsics.m26843a((Object) propertySetterDescriptorImpl, "DescriptorFactory.create…perty, Annotations.EMPTY)");
                    }
                }
            }
            z = false;
            if (i7 == 0) {
                propertyDescriptor = deserializedPropertyDescriptor3;
                companion3 = Annotations.f32643a;
                propertySetterDescriptorImpl = DescriptorFactory.m27631a(propertyDescriptor, Companion.m27115a());
                Intrinsics.m26843a((Object) propertySetterDescriptorImpl, "DescriptorFactory.create…perty, Annotations.EMPTY)");
            } else {
                propertySetterDescriptorImpl = new PropertySetterDescriptorImpl(deserializedPropertyDescriptor3, m27845a(messageLite, i2, AnnotatedCallableKind.PROPERTY_SETTER), Deserialization.m27828a((ProtoBuf.Modality) Flags.f26153d.mo5920b(i2)), Deserialization.m27829a((Visibility) Flags.f26152c.mo5920b(i2)), i7 ^ 1, z3, z, deserializedPropertyDescriptor3.mo7760t(), null, SourceElement.f25498a);
                propertySetterDescriptorImpl.m43075a((ValueParameterDescriptor) CollectionsKt___CollectionsKt.m41441h(deserializationContext.m27835a(propertySetterDescriptorImpl, CollectionsKt__CollectionsKt.m26790a(), deserializationContext.f26246d, deserializationContext.f26248f).f26244b.m27843a(CollectionsKt__CollectionsKt.m26791a((Object) property3.f40428m), messageLite, AnnotatedCallableKind.PROPERTY_SETTER)));
            }
        }
        a8 = Flags.f26171v.m33502a(i5);
        Intrinsics.m26843a(a8, "Flags.HAS_CONSTANT.get(flags)");
        if (a8.booleanValue()) {
            deserializedPropertyDescriptor3.m42825a(memberDeserializer.f26257b.f26245c.f26229b.mo5931b((Function0) new MemberDeserializer$loadProperty$2(memberDeserializer, property3, deserializedPropertyDescriptor3)));
        }
        deserializedPropertyDescriptor3.m42990a(propertyGetterDescriptorImpl, (PropertySetterDescriptor) propertySetterDescriptorImpl);
        return deserializedPropertyDescriptor3;
    }

    public final SimpleFunctionDescriptor m27852a(Function function) {
        int i;
        Annotations a;
        KotlinType a2;
        MemberDeserializer memberDeserializer = this;
        Function function2 = function;
        Intrinsics.m26847b(function2, "proto");
        if (function.m41665h()) {
            i = function2.f40373e;
        } else {
            i = m27842a(function2.f40374f);
        }
        int i2 = i;
        MessageLite messageLite = function2;
        Annotations a3 = m27845a(messageLite, i2, AnnotatedCallableKind.FUNCTION);
        if (ProtoTypeTableUtilKt.m27874a(function)) {
            a = new DeserializedAnnotationsWithPossibleTargets(memberDeserializer.f26257b.f26245c.f26229b, new MemberDeserializer$getReceiverParameterAnnotations$1(memberDeserializer, messageLite, AnnotatedCallableKind.FUNCTION));
        } else {
            Companion companion = Annotations.f32643a;
            a = Companion.m27115a();
        }
        Annotations annotations = a;
        DeclarationDescriptor declarationDescriptor = memberDeserializer.f26257b.f26247e;
        Object b = memberDeserializer.f26257b.f26246d.mo5830b(function2.f40375g);
        Intrinsics.m26843a(b, "c.nameResolver.getName(proto.name)");
        FunctionDescriptorImpl deserializedSimpleFunctionDescriptor = new DeserializedSimpleFunctionDescriptor(declarationDescriptor, a3, b, Deserialization.m27826a((MemberKind) Flags.f26159j.mo5920b(i2)), function2, memberDeserializer.f26257b.f26246d, memberDeserializer.f26257b.f26248f, memberDeserializer.f26257b.f26249g, memberDeserializer.f26257b.f26250h);
        DeserializationContext deserializationContext = memberDeserializer.f26257b;
        declarationDescriptor = deserializedSimpleFunctionDescriptor;
        Object obj = function2.f40378j;
        Intrinsics.m26843a(obj, "proto.typeParameterList");
        deserializationContext = deserializationContext.m27835a(declarationDescriptor, obj, deserializationContext.f26246d, deserializationContext.f26248f);
        Type b2 = ProtoTypeTableUtilKt.m27876b(function2, memberDeserializer.f26257b.f26248f);
        if (b2 != null) {
            a2 = deserializationContext.f26243a.m27890a(b2, annotations);
        } else {
            a2 = null;
        }
        KotlinType kotlinType = a2;
        ReceiverParameterDescriptor a4 = m27844a();
        List a5 = deserializationContext.f26243a.m27889a();
        MemberDeserializer memberDeserializer2 = deserializationContext.f26244b;
        List list = function2.f40381m;
        Intrinsics.m26843a((Object) list, "proto.valueParameterList");
        deserializedSimpleFunctionDescriptor.mo7833b(kotlinType, a4, a5, memberDeserializer2.m27843a(list, messageLite, AnnotatedCallableKind.FUNCTION), Annotations.f32643a, Deserialization.m27828a((ProtoBuf.Modality) Flags.f26153d.mo5920b(i2)), Deserialization.m27829a((Visibility) Flags.f26152c.mo5920b(i2)));
        Object a6 = Flags.f26160k.m33502a(i2);
        Intrinsics.m26843a(a6, "Flags.IS_OPERATOR.get(flags)");
        deserializedSimpleFunctionDescriptor.f40767e = a6.booleanValue();
        a6 = Flags.f26161l.m33502a(i2);
        Intrinsics.m26843a(a6, "Flags.IS_INFIX.get(flags)");
        deserializedSimpleFunctionDescriptor.f40768f = a6.booleanValue();
        a6 = Flags.f26164o.m33502a(i2);
        Intrinsics.m26843a(a6, "Flags.IS_EXTERNAL_FUNCTION.get(flags)");
        deserializedSimpleFunctionDescriptor.f40769g = a6.booleanValue();
        a6 = Flags.f26162m.m33502a(i2);
        Intrinsics.m26843a(a6, "Flags.IS_INLINE.get(flags)");
        deserializedSimpleFunctionDescriptor.f40770h = a6.booleanValue();
        a6 = Flags.f26163n.m33502a(i2);
        Intrinsics.m26843a(a6, "Flags.IS_TAILREC.get(flags)");
        deserializedSimpleFunctionDescriptor.f40771i = a6.booleanValue();
        a6 = Flags.f26165p.m33502a(i2);
        Intrinsics.m26843a(a6, "Flags.IS_SUSPEND.get(flags)");
        deserializedSimpleFunctionDescriptor.f40774l = a6.booleanValue();
        return (SimpleFunctionDescriptor) deserializedSimpleFunctionDescriptor;
    }

    private final ReceiverParameterDescriptor m27844a() {
        DeclarationDescriptor declarationDescriptor = this.f26257b.f26247e;
        if (!(declarationDescriptor instanceof ClassDescriptor)) {
            declarationDescriptor = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
        return classDescriptor != null ? classDescriptor.mo7740u() : null;
    }

    public final ClassConstructorDescriptor m27850a(Constructor constructor, boolean z) {
        Intrinsics.m26847b(constructor, "proto");
        DeclarationDescriptor declarationDescriptor = this.f26257b.f26247e;
        if (declarationDescriptor == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
        MessageLite messageLite = constructor;
        DeserializedClassConstructorDescriptor deserializedClassConstructorDescriptor = new DeserializedClassConstructorDescriptor(classDescriptor, m27845a(messageLite, constructor.f40343e, AnnotatedCallableKind.FUNCTION), z, Kind.DECLARATION, constructor, this.f26257b.f26246d, this.f26257b.f26248f, this.f26257b.f26249g, this.f26257b.f26250h);
        z = this.f26257b.m27835a(deserializedClassConstructorDescriptor, CollectionsKt__CollectionsKt.m26790a(), this.f26257b.f26246d, this.f26257b.f26248f).f26244b;
        List list = constructor.f40344f;
        Intrinsics.m26843a((Object) list, "proto.valueParameterList");
        deserializedClassConstructorDescriptor.m42889a((List) z.m27843a(list, messageLite, AnnotatedCallableKind.FUNCTION), (kotlin.reflect.jvm.internal.impl.descriptors.Visibility) Deserialization.m27829a((Visibility) Flags.f26152c.mo5920b(constructor.f40343e)));
        deserializedClassConstructorDescriptor.m42608a((KotlinType) classDescriptor.mo7714h());
        return deserializedClassConstructorDescriptor;
    }

    private final Annotations m27845a(MessageLite messageLite, int i, AnnotatedCallableKind annotatedCallableKind) {
        if (Flags.f26151b.m33502a(i).booleanValue() != 0) {
            return (Annotations) new DeserializedAnnotationsWithPossibleTargets(this.f26257b.f26245c.f26229b, new MemberDeserializer$getAnnotations$1(this, messageLite, annotatedCallableKind));
        }
        messageLite = Annotations.f32643a;
        return Companion.m27115a();
    }

    private final List<ValueParameterDescriptor> m27843a(List<ValueParameter> list, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        DeclarationDescriptor declarationDescriptor = this.f26257b.f26247e;
        if (declarationDescriptor == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        }
        CallableDescriptor callableDescriptor = (CallableDescriptor) declarationDescriptor;
        ProtoContainer a = m27848a(callableDescriptor.aD_());
        Iterable iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        Iterator it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            Iterator it2;
            Collection collection;
            Annotations deserializedAnnotations;
            KotlinType a2;
            int i3 = i + 1;
            ValueParameter valueParameter = (ValueParameter) it.next();
            if (valueParameter.m41912h()) {
                i2 = valueParameter.f40524e;
            } else {
                i2 = 0;
            }
            if (a != null) {
                it2 = it;
                collection = arrayList;
                deserializedAnnotations = new DeserializedAnnotations(r9.f26257b.f26245c.f26229b, new MemberDeserializer$valueParameters$$inlined$mapIndexed$lambda$1(a, i, valueParameter, r9, callableDescriptor, a, messageLite, annotatedCallableKind));
            } else {
                it2 = it;
                collection = arrayList;
                Companion companion = Annotations.f32643a;
                deserializedAnnotations = Companion.m27115a();
            }
            Name b = r9.f26257b.f26246d.mo5830b(valueParameter.f40525f);
            Intrinsics.m26843a((Object) b, "c.nameResolver.getName(proto.name)");
            KotlinType a3 = Annotations.f32643a;
            Object a4 = Flags.f26174y.m33502a(i2);
            Intrinsics.m26843a(a4, "Flags.DECLARES_DEFAULT_VALUE.get(flags)");
            boolean booleanValue = a4.booleanValue();
            a4 = Flags.f26175z.m33502a(i2);
            Intrinsics.m26843a(a4, "Flags.IS_CROSSINLINE.get(flags)");
            boolean booleanValue2 = a4.booleanValue();
            a4 = Flags.f26146A.m33502a(i2);
            Intrinsics.m26843a(a4, "Flags.IS_NOINLINE.get(flags)");
            boolean booleanValue3 = a4.booleanValue();
            Type b2 = ProtoTypeTableUtilKt.m27880b(valueParameter, r9.f26257b.f26248f);
            if (b2 != null) {
                a2 = Annotations.f32643a;
            } else {
                a2 = null;
            }
            KotlinType kotlinType = a2;
            SourceElement sourceElement = SourceElement.f25498a;
            Intrinsics.m26843a((Object) sourceElement, "SourceElement.NO_SOURCE");
            ValueParameterDescriptorImpl valueParameterDescriptorImpl = r10;
            Iterator it3 = it2;
            Collection collection2 = collection;
            CallableDescriptor callableDescriptor2 = callableDescriptor;
            ValueParameterDescriptorImpl valueParameterDescriptorImpl2 = new ValueParameterDescriptorImpl(callableDescriptor, null, i, deserializedAnnotations, b, a3, booleanValue, booleanValue2, booleanValue3, kotlinType, sourceElement);
            collection2.add(valueParameterDescriptorImpl);
            it = it3;
            arrayList = collection2;
            callableDescriptor = callableDescriptor2;
            i = i3;
        }
        return CollectionsKt.m28089a((Collection) (List) arrayList);
    }

    private final ProtoContainer m27848a(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor instanceof PackageFragmentDescriptor) {
            return new Package(((PackageFragmentDescriptor) declarationDescriptor).mo7722d(), this.f26257b.f26246d, this.f26257b.f26248f, this.f26257b.f26250h);
        }
        return declarationDescriptor instanceof DeserializedClassDescriptor ? (ProtoContainer) ((DeserializedClassDescriptor) declarationDescriptor).f40871f : null;
    }
}
