package kotlin.reflect.jvm.internal.impl.renderer;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.Companion;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NotFoundClasses.MockClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.AbbreviatedType;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils.UninferredParameterTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.WrappedType;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: DescriptorRendererImpl.kt */
public final class DescriptorRendererImpl extends DescriptorRenderer implements DescriptorRendererOptions {
    static final /* synthetic */ KProperty[] f32888k = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(DescriptorRendererImpl.class), "functionTypeAnnotationsRenderer", "getFunctionTypeAnnotationsRenderer()Lorg/jetbrains/kotlin/renderer/DescriptorRendererImpl;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(DescriptorRendererImpl.class), "functionTypeParameterTypesRenderer", "getFunctionTypeParameterTypesRenderer()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer;"))};
    final DescriptorRendererOptionsImpl f32889j;
    private final Lazy f32890l;
    private final Lazy f32891m;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f26017a;
        public static final /* synthetic */ int[] f26018b;
        public static final /* synthetic */ int[] f26019c;
        public static final /* synthetic */ int[] f26020d;
        public static final /* synthetic */ int[] f26021e;

        static {
            int[] iArr = new int[RenderingFormat.values().length];
            f26017a = iArr;
            iArr[RenderingFormat.f26048a.ordinal()] = 1;
            f26017a[RenderingFormat.f26049b.ordinal()] = 2;
            iArr = new int[RenderingFormat.values().length];
            f26018b = iArr;
            iArr[RenderingFormat.f26048a.ordinal()] = 1;
            f26018b[RenderingFormat.f26049b.ordinal()] = 2;
            iArr = new int[RenderingFormat.values().length];
            f26019c = iArr;
            iArr[RenderingFormat.f26048a.ordinal()] = 1;
            f26019c[RenderingFormat.f26049b.ordinal()] = 2;
            iArr = new int[RenderingFormat.values().length];
            f26020d = iArr;
            iArr[RenderingFormat.f26048a.ordinal()] = 1;
            f26020d[RenderingFormat.f26049b.ordinal()] = 2;
            iArr = new int[ParameterNameRenderingPolicy.values().length];
            f26021e = iArr;
            iArr[ParameterNameRenderingPolicy.f26044a.ordinal()] = 1;
            f26021e[ParameterNameRenderingPolicy.f26045b.ordinal()] = 2;
            f26021e[ParameterNameRenderingPolicy.f26046c.ordinal()] = 3;
        }
    }

    /* compiled from: DescriptorRendererImpl.kt */
    private final class RenderDeclarationDescriptorVisitor implements DeclarationDescriptorVisitor<Unit, StringBuilder> {
        final /* synthetic */ DescriptorRendererImpl f32887a;

        public RenderDeclarationDescriptorVisitor(DescriptorRendererImpl descriptorRendererImpl) {
            this.f32887a = descriptorRendererImpl;
        }

        public final /* synthetic */ Object mo5727a(ClassDescriptor classDescriptor, Object obj) {
            StringBuilder stringBuilder = (StringBuilder) obj;
            Intrinsics.m26847b(classDescriptor, "descriptor");
            Intrinsics.m26847b(stringBuilder, "builder");
            DescriptorRendererImpl.m33387a(this.f32887a, classDescriptor, stringBuilder);
            return Unit.f25273a;
        }

        public final /* synthetic */ Object mo5728a(ConstructorDescriptor constructorDescriptor, Object obj) {
            StringBuilder stringBuilder = (StringBuilder) obj;
            Intrinsics.m26847b(constructorDescriptor, "constructorDescriptor");
            Intrinsics.m26847b(stringBuilder, "builder");
            DescriptorRendererImpl.m33388a(this.f32887a, constructorDescriptor, stringBuilder);
            return Unit.f25273a;
        }

        public final /* synthetic */ Object mo5730a(ModuleDescriptor moduleDescriptor, Object obj) {
            StringBuilder stringBuilder = (StringBuilder) obj;
            Intrinsics.m26847b(moduleDescriptor, "descriptor");
            Intrinsics.m26847b(stringBuilder, "builder");
            this.f32887a.m33378a((DeclarationDescriptor) moduleDescriptor, stringBuilder);
            return Unit.f25273a;
        }

        public final /* synthetic */ Object mo5731a(PackageFragmentDescriptor packageFragmentDescriptor, Object obj) {
            StringBuilder stringBuilder = (StringBuilder) obj;
            Intrinsics.m26847b(packageFragmentDescriptor, "descriptor");
            Intrinsics.m26847b(stringBuilder, "builder");
            DescriptorRendererImpl.m33391a(this.f32887a, packageFragmentDescriptor, stringBuilder);
            return Unit.f25273a;
        }

        public final /* synthetic */ Object mo5732a(PackageViewDescriptor packageViewDescriptor, Object obj) {
            StringBuilder stringBuilder = (StringBuilder) obj;
            Intrinsics.m26847b(packageViewDescriptor, "descriptor");
            Intrinsics.m26847b(stringBuilder, "builder");
            DescriptorRendererImpl.m33392a(this.f32887a, packageViewDescriptor, stringBuilder);
            return Unit.f25273a;
        }

        public final /* synthetic */ Object mo5733a(PropertyDescriptor propertyDescriptor, Object obj) {
            StringBuilder stringBuilder = (StringBuilder) obj;
            Intrinsics.m26847b(propertyDescriptor, "descriptor");
            Intrinsics.m26847b(stringBuilder, "builder");
            DescriptorRendererImpl.m33393a(this.f32887a, propertyDescriptor, stringBuilder);
            return Unit.f25273a;
        }

        public final /* synthetic */ Object mo5734a(PropertyGetterDescriptor propertyGetterDescriptor, Object obj) {
            StringBuilder stringBuilder = (StringBuilder) obj;
            Intrinsics.m26847b(propertyGetterDescriptor, "descriptor");
            Intrinsics.m26847b(stringBuilder, "builder");
            if (this.f32887a.m33441d()) {
                DescriptorRendererImpl.m33408d(propertyGetterDescriptor, stringBuilder);
                stringBuilder.append("getter for ");
                DescriptorRendererImpl descriptorRendererImpl = this.f32887a;
                PropertyDescriptor D = propertyGetterDescriptor.mo7822D();
                Intrinsics.m26843a((Object) D, "descriptor.correspondingProperty");
                DescriptorRendererImpl.m33393a(descriptorRendererImpl, D, stringBuilder);
            } else {
                m33347a((FunctionDescriptor) propertyGetterDescriptor, stringBuilder);
            }
            return Unit.f25273a;
        }

        public final /* synthetic */ Object mo5735a(PropertySetterDescriptor propertySetterDescriptor, Object obj) {
            StringBuilder stringBuilder = (StringBuilder) obj;
            Intrinsics.m26847b(propertySetterDescriptor, "descriptor");
            Intrinsics.m26847b(stringBuilder, "builder");
            if (this.f32887a.m33441d()) {
                DescriptorRendererImpl.m33408d(propertySetterDescriptor, stringBuilder);
                stringBuilder.append("setter for ");
                DescriptorRendererImpl descriptorRendererImpl = this.f32887a;
                PropertyDescriptor D = propertySetterDescriptor.mo7822D();
                Intrinsics.m26843a((Object) D, "descriptor.correspondingProperty");
                DescriptorRendererImpl.m33393a(descriptorRendererImpl, D, stringBuilder);
            } else {
                m33347a((FunctionDescriptor) propertySetterDescriptor, stringBuilder);
            }
            return Unit.f25273a;
        }

        public final /* synthetic */ Object mo5736a(ReceiverParameterDescriptor receiverParameterDescriptor, Object obj) {
            StringBuilder stringBuilder = (StringBuilder) obj;
            Intrinsics.m26847b(receiverParameterDescriptor, "descriptor");
            Intrinsics.m26847b(stringBuilder, "data");
            throw ((Throwable) new UnsupportedOperationException("Don't render receiver parameters"));
        }

        public final /* synthetic */ Object mo5737a(TypeAliasDescriptor typeAliasDescriptor, Object obj) {
            StringBuilder stringBuilder = (StringBuilder) obj;
            Intrinsics.m26847b(typeAliasDescriptor, "descriptor");
            Intrinsics.m26847b(stringBuilder, "builder");
            DescriptorRendererImpl.m33394a(this.f32887a, typeAliasDescriptor, stringBuilder);
            return Unit.f25273a;
        }

        public final /* synthetic */ Object mo5738a(TypeParameterDescriptor typeParameterDescriptor, Object obj) {
            StringBuilder stringBuilder = (StringBuilder) obj;
            Intrinsics.m26847b(typeParameterDescriptor, "descriptor");
            Intrinsics.m26847b(stringBuilder, "builder");
            this.f32887a.m33382a(typeParameterDescriptor, stringBuilder, true);
            return Unit.f25273a;
        }

        public final /* synthetic */ Object mo5739a(ValueParameterDescriptor valueParameterDescriptor, Object obj) {
            StringBuilder stringBuilder = (StringBuilder) obj;
            Intrinsics.m26847b(valueParameterDescriptor, "descriptor");
            Intrinsics.m26847b(stringBuilder, "builder");
            this.f32887a.m33383a(valueParameterDescriptor, true, stringBuilder, true);
            return Unit.f25273a;
        }

        private void m33347a(FunctionDescriptor functionDescriptor, StringBuilder stringBuilder) {
            Intrinsics.m26847b(functionDescriptor, "descriptor");
            Intrinsics.m26847b(stringBuilder, "builder");
            DescriptorRendererImpl.m33390a(this.f32887a, functionDescriptor, stringBuilder);
        }
    }

    public final AnnotationArgumentsRenderingPolicy mo5896a() {
        return this.f32889j.mo5896a();
    }

    public final void mo5897a(Set<FqName> set) {
        Intrinsics.m26847b(set, "<set-?>");
        this.f32889j.mo5897a((Set) set);
    }

    public final void mo5898a(AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        Intrinsics.m26847b(annotationArgumentsRenderingPolicy, "<set-?>");
        this.f32889j.mo5898a(annotationArgumentsRenderingPolicy);
    }

    public final void mo5899a(ClassifierNamePolicy classifierNamePolicy) {
        Intrinsics.m26847b(classifierNamePolicy, "<set-?>");
        this.f32889j.mo5899a(classifierNamePolicy);
    }

    public final void mo5900a(ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        Intrinsics.m26847b(parameterNameRenderingPolicy, "<set-?>");
        this.f32889j.mo5900a(parameterNameRenderingPolicy);
    }

    public final void mo5901a(RenderingFormat renderingFormat) {
        Intrinsics.m26847b(renderingFormat, "<set-?>");
        this.f32889j.mo5901a(renderingFormat);
    }

    public final void mo5902a(boolean z) {
        this.f32889j.mo5902a(z);
    }

    public final void mo5903b(Set<? extends DescriptorRendererModifier> set) {
        Intrinsics.m26847b(set, "<set-?>");
        this.f32889j.mo5903b((Set) set);
    }

    public final void mo5904b(boolean z) {
        this.f32889j.mo5904b(z);
    }

    public final boolean mo5905b() {
        return this.f32889j.mo5905b();
    }

    public final Set<FqName> mo5906c() {
        return this.f32889j.mo5906c();
    }

    public final void mo5907c(boolean z) {
        this.f32889j.mo5907c(z);
    }

    public final void mo5908d(boolean z) {
        this.f32889j.mo5908d(z);
    }

    public final void mo5909e(boolean z) {
        this.f32889j.mo5909e(z);
    }

    public final void mo5910f(boolean z) {
        this.f32889j.mo5910f(z);
    }

    public final void mo5911g(boolean z) {
        this.f32889j.mo5911g(z);
    }

    public final void mo5912h(boolean z) {
        this.f32889j.mo5912h(z);
    }

    public DescriptorRendererImpl(DescriptorRendererOptionsImpl descriptorRendererOptionsImpl) {
        Intrinsics.m26847b(descriptorRendererOptionsImpl, "options");
        this.f32889j = descriptorRendererOptionsImpl;
        descriptorRendererOptionsImpl = this.f32889j.f32903a;
        if (_Assertions.f25274a && descriptorRendererOptionsImpl == null) {
            throw new AssertionError("Assertion failed");
        }
        this.f32890l = LazyKt.m26777a((Function0) new DescriptorRendererImpl$functionTypeAnnotationsRenderer$2(this));
        this.f32891m = LazyKt.m26777a((Function0) new DescriptorRendererImpl$functionTypeParameterTypesRenderer$2(this));
    }

    private final String m33361a(String str) {
        switch (WhenMappings.f26017a[m33417m().ordinal()]) {
            case 1:
                return str;
            case 2:
                StringBuilder stringBuilder = new StringBuilder("<b>");
                stringBuilder.append(str);
                stringBuilder.append("</b>");
                return stringBuilder.toString();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final String m33399b(String str) {
        return m33417m().mo5913a(str);
    }

    public final String mo5893a(Name name) {
        Intrinsics.m26847b(name, "name");
        return m33399b(RenderingUtilsKt.m27622a(name));
    }

    private final void m33378a(DeclarationDescriptor declarationDescriptor, StringBuilder stringBuilder) {
        Name i = declarationDescriptor.mo6689i();
        Intrinsics.m26843a((Object) i, "descriptor.name");
        stringBuilder.append(mo5893a(i));
    }

    public final String mo5892a(FqNameUnsafe fqNameUnsafe) {
        Intrinsics.m26847b(fqNameUnsafe, "fqName");
        List f = fqNameUnsafe.m27422f();
        Intrinsics.m26843a((Object) f, "fqName.pathSegments()");
        return m33399b(RenderingUtilsKt.m27620a(f));
    }

    public final String mo5894a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "type");
        StringBuilder stringBuilder = new StringBuilder();
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.f32889j;
        m33371a(stringBuilder, (KotlinType) ((Function1) descriptorRendererOptionsImpl.f32919q.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.f32892H[16])).mo6492a(kotlinType));
        Object stringBuilder2 = stringBuilder.toString();
        Intrinsics.m26843a(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder2;
    }

    private final void m33371a(StringBuilder stringBuilder, KotlinType kotlinType) {
        UnwrappedType h = kotlinType.mo6738h();
        if (!(h instanceof AbbreviatedType)) {
            h = null;
        }
        AbbreviatedType abbreviatedType = (AbbreviatedType) h;
        if (abbreviatedType != null) {
            m33401b(stringBuilder, abbreviatedType.f40540b);
            kotlinType = this.f32889j;
            if (((Boolean) kotlinType.f32897E.getValue(kotlinType, DescriptorRendererOptionsImpl.f32892H[32])).booleanValue() != null) {
                if (Intrinsics.m26845a(m33417m(), RenderingFormat.f26049b) != null) {
                    stringBuilder.append("<font color=\"808080\"><i>");
                }
                stringBuilder.append(" /* = ");
                m33401b(stringBuilder, abbreviatedType.f40539a);
                stringBuilder.append(" */");
                if (Intrinsics.m26845a(m33417m(), RenderingFormat.f26049b) != null) {
                    stringBuilder.append("</i></font>");
                }
            }
            return;
        }
        m33401b(stringBuilder, kotlinType);
    }

    private final void m33401b(StringBuilder stringBuilder, KotlinType kotlinType) {
        if ((kotlinType instanceof WrappedType) && this.f32889j.mo5905b() && !((WrappedType) kotlinType).mo7118f()) {
            stringBuilder.append("<Not computed yet>");
            return;
        }
        kotlinType = kotlinType.mo6738h();
        if (kotlinType instanceof FlexibleType) {
            stringBuilder.append(((FlexibleType) kotlinType).mo7270a(this, this));
            return;
        }
        if (kotlinType instanceof SimpleType) {
            Object obj = (SimpleType) kotlinType;
            if (!Intrinsics.m26845a(obj, TypeUtils.f26331b)) {
                KotlinType kotlinType2 = (KotlinType) obj;
                if (!TypeUtils.m28010a(kotlinType2)) {
                    if (ErrorUtils.m27939a(kotlinType2)) {
                        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.f32889j;
                        if (((Boolean) descriptorRendererOptionsImpl.f32915m.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.f32892H[12])).booleanValue()) {
                            kotlinType = obj.mo6743g();
                            if (kotlinType == null) {
                                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.ErrorUtils.UninferredParameterTypeConstructor");
                            }
                            kotlinType = ((UninferredParameterTypeConstructor) kotlinType).f33066a;
                            if (kotlinType == null) {
                                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor", "getTypeParameterDescriptor"}));
                            }
                            kotlinType = kotlinType.mo6689i().toString();
                            Intrinsics.m26843a((Object) kotlinType, "(type.constructor as Uni…escriptor.name.toString()");
                            switch (WhenMappings.f26018b[m33417m().ordinal()]) {
                                case 1:
                                    break;
                                case 2:
                                    StringBuilder stringBuilder2 = new StringBuilder("<font color=red><b>");
                                    stringBuilder2.append(kotlinType);
                                    stringBuilder2.append("</b></font>");
                                    kotlinType = stringBuilder2.toString();
                                    break;
                                default:
                                    throw new NoWhenBranchMatchedException();
                            }
                            stringBuilder.append(kotlinType);
                            return;
                        }
                        stringBuilder.append("???");
                        return;
                    } else if (obj.mo6742d() != null || m33405b(kotlinType2) == null) {
                        m33370a(stringBuilder, (Annotated) kotlinType2);
                        if (kotlinType2.mo6742d() != null) {
                            stringBuilder.append(kotlinType2.mo6743g().toString());
                            stringBuilder.append(m33363a(kotlinType2.mo6739a()));
                        } else {
                            TypeConstructor g = kotlinType2.mo6743g();
                            PossiblyInnerType a = TypeParameterUtilsKt.m27090a(kotlinType2);
                            if (a == null) {
                                stringBuilder.append(m33365a(g));
                                stringBuilder.append(m33363a(kotlinType2.mo6739a()));
                            } else {
                                m33369a(stringBuilder, a);
                            }
                        }
                        if (kotlinType2.mo6741c() != null) {
                            stringBuilder.append(Operation.EMPTY_PARAM);
                        }
                    } else {
                        m33406c(stringBuilder, kotlinType2);
                        return;
                    }
                }
            }
            stringBuilder.append("???");
        }
    }

    private static boolean m33405b(KotlinType kotlinType) {
        if (FunctionTypesKt.m26950c(kotlinType)) {
            for (TypeProjection a : kotlinType.mo6739a()) {
                if (a.mo6734a()) {
                    kotlinType = null;
                    break;
                }
            }
            kotlinType = 1;
            if (kotlinType != null) {
                return true;
            }
        }
        return false;
    }

    public final String mo5889a(String str, String str2, KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics.m26847b(str, "lowerRendered");
        Intrinsics.m26847b(str2, "upperRendered");
        Intrinsics.m26847b(kotlinBuiltIns, "builtIns");
        if (!m33397a(str, str2)) {
            ClassifierNamePolicy f = m33410f();
            Object a = KotlinBuiltIns.m26967a(Name.m27424a("Collection"), ((PackageFragments) kotlinBuiltIns.f25424i.invoke()).f25407b);
            if (a == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByName"}));
            } else if (a == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getCollectionClassByName"}));
            } else if (a == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getCollection"}));
            } else {
                Intrinsics.m26843a(a, "builtIns.collection");
                DescriptorRenderer descriptorRenderer = this;
                String c = StringsKt__StringsKt.m42461c(f.mo5884a((ClassifierDescriptor) a, descriptorRenderer), "Collection");
                String str3 = "Mutable";
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(c);
                stringBuilder.append(str3);
                String stringBuilder2 = stringBuilder.toString();
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(c);
                stringBuilder3.append("(");
                stringBuilder3.append(str3);
                stringBuilder3.append(")");
                str3 = m33362a(str, stringBuilder2, str2, c, stringBuilder3.toString());
                if (str3 != null) {
                    return str3;
                }
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(c);
                stringBuilder4.append("MutableMap.MutableEntry");
                str3 = stringBuilder4.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(c);
                stringBuilder.append("Map.Entry");
                stringBuilder2 = stringBuilder.toString();
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(c);
                stringBuilder3.append("(Mutable)Map.(Mutable)Entry");
                c = m33362a(str, str3, str2, stringBuilder2, stringBuilder3.toString());
                if (c != null) {
                    return c;
                }
                f = m33410f();
                Object i = kotlinBuiltIns.m27011i();
                Intrinsics.m26843a(i, "builtIns.array");
                kotlinBuiltIns = StringsKt__StringsKt.m42461c((String) f.mo5884a((ClassifierDescriptor) i, descriptorRenderer), "Array");
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append(kotlinBuiltIns);
                stringBuilder5.append(m33399b("Array<"));
                c = stringBuilder5.toString();
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append(kotlinBuiltIns);
                stringBuilder4.append(m33399b("Array<out "));
                str3 = stringBuilder4.toString();
                StringBuilder stringBuilder6 = new StringBuilder();
                stringBuilder6.append(kotlinBuiltIns);
                stringBuilder6.append(m33399b("Array<(out) "));
                kotlinBuiltIns = m33362a(str, c, str2, str3, stringBuilder6.toString());
                if (kotlinBuiltIns != null) {
                    return kotlinBuiltIns;
                }
                kotlinBuiltIns = new StringBuilder("(");
                kotlinBuiltIns.append(str);
                kotlinBuiltIns.append("..");
                kotlinBuiltIns.append(str2);
                kotlinBuiltIns.append(")");
                return kotlinBuiltIns.toString();
            }
        } else if (StringsKt__StringsJVMKt.m41944a(str2, "(") != null) {
            str2 = new StringBuilder("(");
            str2.append(str);
            str2.append(")!");
            return str2.toString();
        } else {
            str2 = new StringBuilder();
            str2.append(str);
            str2.append("!");
            return str2.toString();
        }
    }

    private String m33363a(List<? extends TypeProjection> list) {
        Intrinsics.m26847b(list, "typeArguments");
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(m33399b(Operation.LESS_THAN));
        m33368a(stringBuilder, (List) list);
        stringBuilder.append(m33399b(Operation.GREATER_THAN));
        Object stringBuilder2 = stringBuilder.toString();
        Intrinsics.m26843a(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder2;
    }

    private String m33365a(TypeConstructor typeConstructor) {
        Intrinsics.m26847b(typeConstructor, "typeConstructor");
        TypeConstructor c = typeConstructor.mo5724c();
        if (!((c instanceof TypeParameterDescriptor) || (c instanceof ClassDescriptor))) {
            if (!(c instanceof TypeAliasDescriptor)) {
                if (Intrinsics.m26845a((Object) c, null)) {
                    return typeConstructor.toString();
                }
                typeConstructor = new StringBuilder("Unexpected classifier: ");
                typeConstructor.append(c.getClass());
                throw new IllegalStateException(typeConstructor.toString().toString());
            }
        }
        Intrinsics.m26847b(c, "klass");
        if (ErrorUtils.m27938a((DeclarationDescriptor) c) != null) {
            return c.mo7610c().toString();
        }
        return m33410f().mo5884a(c, this);
    }

    public final String mo5895a(TypeProjection typeProjection) {
        Intrinsics.m26847b(typeProjection, "typeProjection");
        StringBuilder stringBuilder = new StringBuilder();
        m33368a(stringBuilder, CollectionsKt__CollectionsKt.m26791a((Object) typeProjection));
        Object stringBuilder2 = stringBuilder.toString();
        Intrinsics.m26843a(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder2;
    }

    private final void m33368a(StringBuilder stringBuilder, List<? extends TypeProjection> list) {
        Iterable<TypeProjection> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (TypeProjection typeProjection : iterable) {
            Object obj;
            if (typeProjection.mo6734a()) {
                obj = Operation.MULTIPLY;
            } else {
                KotlinType c = typeProjection.mo6736c();
                Intrinsics.m26843a((Object) c, "it.type");
                String a = mo5894a(c);
                if (Intrinsics.m26845a(typeProjection.mo6735b(), Variance.f26337a)) {
                    obj = a;
                } else {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(typeProjection.mo6735b());
                    stringBuilder2.append(" ");
                    stringBuilder2.append(a);
                    obj = stringBuilder2.toString();
                }
            }
            arrayList.add(obj);
        }
        CollectionsKt___CollectionsKt.m41410a((List) arrayList, stringBuilder, ", ", null, null, 0, null, null, 124);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m33406c(java.lang.StringBuilder r9, kotlin.reflect.jvm.internal.impl.types.KotlinType r10) {
        /*
        r8 = this;
        r0 = r9.length();
        r1 = r8.f32890l;
        r1 = r1.mo5678b();
        r1 = (kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl) r1;
        r2 = r10;
        r2 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated) r2;
        r1.m33370a(r9, r2);
        r1 = r9.length();
        r2 = 0;
        r3 = 1;
        if (r1 == r0) goto L_0x001c;
    L_0x001a:
        r0 = r3;
        goto L_0x001d;
    L_0x001c:
        r0 = r2;
    L_0x001d:
        r1 = r10.mo6741c();
        r4 = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.m26951d(r10);
        if (r1 != 0) goto L_0x002e;
    L_0x0027:
        if (r0 == 0) goto L_0x002c;
    L_0x0029:
        if (r4 == 0) goto L_0x002c;
    L_0x002b:
        goto L_0x002e;
    L_0x002c:
        r5 = r2;
        goto L_0x002f;
    L_0x002e:
        r5 = r3;
    L_0x002f:
        if (r5 == 0) goto L_0x0067;
    L_0x0031:
        if (r0 == 0) goto L_0x0067;
    L_0x0033:
        r0 = r9;
        r0 = (java.lang.CharSequence) r0;
        r6 = kotlin.text.StringsKt___StringsKt.m42685h(r0);
        r7 = 32;
        if (r6 != r7) goto L_0x0040;
    L_0x003e:
        r6 = r3;
        goto L_0x0041;
    L_0x0040:
        r6 = r2;
    L_0x0041:
        r7 = kotlin._Assertions.f25274a;
        if (r7 == 0) goto L_0x0051;
    L_0x0045:
        if (r6 != 0) goto L_0x0051;
    L_0x0047:
        r9 = "Assertion failed";
        r10 = new java.lang.AssertionError;
        r10.<init>(r9);
        r10 = (java.lang.Throwable) r10;
        throw r10;
    L_0x0051:
        r6 = kotlin.text.StringsKt__StringsKt.m42467e(r0);
        r6 = r6 - r3;
        r6 = r9.charAt(r6);
        r7 = 41;
        if (r6 == r7) goto L_0x0067;
    L_0x005e:
        r0 = kotlin.text.StringsKt__StringsKt.m42467e(r0);
        r6 = "()";
        r9.insert(r0, r6);
    L_0x0067:
        if (r5 == 0) goto L_0x006e;
    L_0x0069:
        r0 = "(";
        r9.append(r0);
    L_0x006e:
        r0 = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.m26949b(r10);
        if (r0 == 0) goto L_0x0079;
    L_0x0074:
        r0 = "suspend ";
        r9.append(r0);
    L_0x0079:
        if (r4 == 0) goto L_0x00b4;
    L_0x007b:
        r0 = m33405b(r4);
        if (r0 == 0) goto L_0x0087;
    L_0x0081:
        r0 = r4.mo6741c();
        if (r0 == 0) goto L_0x009d;
    L_0x0087:
        r0 = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.m26949b(r4);
        if (r0 != 0) goto L_0x009a;
    L_0x008d:
        r0 = r4.mo5718q();
        r0 = r0.mo6680a();
        if (r0 != 0) goto L_0x0098;
    L_0x0097:
        goto L_0x009a;
    L_0x0098:
        r0 = r2;
        goto L_0x009b;
    L_0x009a:
        r0 = r3;
    L_0x009b:
        if (r0 == 0) goto L_0x009e;
    L_0x009d:
        r2 = r3;
    L_0x009e:
        if (r2 == 0) goto L_0x00a5;
    L_0x00a0:
        r0 = "(";
        r9.append(r0);
    L_0x00a5:
        r8.m33371a(r9, r4);
        if (r2 == 0) goto L_0x00af;
    L_0x00aa:
        r0 = ")";
        r9.append(r0);
    L_0x00af:
        r0 = ".";
        r9.append(r0);
    L_0x00b4:
        r0 = "(";
        r9.append(r0);
        r0 = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.m26953f(r10);
        r0 = (java.lang.Iterable) r0;
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.m41452q(r0);
        r0 = r0.iterator();
    L_0x00c7:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x011e;
    L_0x00cd:
        r2 = r0.next();
        r2 = (kotlin.collections.IndexedValue) r2;
        r3 = r2.f25277a;
        r2 = r2.f25278b;
        r2 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r2;
        if (r3 <= 0) goto L_0x00e0;
    L_0x00db:
        r3 = ", ";
        r9.append(r3);
    L_0x00e0:
        r3 = r8.f32889j;
        r4 = r3.f32899G;
        r6 = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.f32892H;
        r7 = 34;
        r6 = r6[r7];
        r3 = r4.getValue(r3, r6);
        r3 = (java.lang.Boolean) r3;
        r3 = r3.booleanValue();
        if (r3 == 0) goto L_0x00ff;
    L_0x00f6:
        r3 = r2.mo6736c();
        r3 = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.m26954g(r3);
        goto L_0x0100;
    L_0x00ff:
        r3 = 0;
    L_0x0100:
        if (r3 == 0) goto L_0x010e;
    L_0x0102:
        r3 = r8.mo5893a(r3);
        r9.append(r3);
        r3 = ": ";
        r9.append(r3);
    L_0x010e:
        r3 = r8.f32891m;
        r3 = r3.mo5678b();
        r3 = (kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer) r3;
        r2 = r3.mo5895a(r2);
        r9.append(r2);
        goto L_0x00c7;
    L_0x011e:
        r0 = ") ";
        r9.append(r0);
        r0 = r8.m33417m();
        r2 = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.WhenMappings.f26019c;
        r0 = r0.ordinal();
        r0 = r2[r0];
        switch(r0) {
            case 1: goto L_0x013b;
            case 2: goto L_0x0138;
            default: goto L_0x0132;
        };
    L_0x0132:
        r9 = new kotlin.NoWhenBranchMatchedException;
        r9.<init>();
        throw r9;
    L_0x0138:
        r0 = "&rarr;";
        goto L_0x0141;
    L_0x013b:
        r0 = "->";
        r0 = r8.m33399b(r0);
    L_0x0141:
        r9.append(r0);
        r0 = " ";
        r9.append(r0);
        r10 = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.m26952e(r10);
        r8.m33371a(r9, r10);
        if (r5 == 0) goto L_0x0157;
    L_0x0152:
        r10 = ")";
        r9.append(r10);
    L_0x0157:
        if (r1 == 0) goto L_0x015e;
    L_0x0159:
        r10 = "?";
        r9.append(r10);
    L_0x015e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.c(java.lang.StringBuilder, kotlin.reflect.jvm.internal.impl.types.KotlinType):void");
    }

    private final void m33370a(StringBuilder stringBuilder, Annotated annotated) {
        if ((m33411g().contains(DescriptorRendererModifier.f26025d) ^ 1) == 0) {
            Set c;
            if (annotated instanceof KotlinType) {
                c = this.f32889j.mo5906c();
            } else {
                DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.f32889j;
                c = (Set) descriptorRendererOptionsImpl.f32894B.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.f32892H[27]);
            }
            for (AnnotationWithTarget annotationWithTarget : annotated.mo5718q().mo6683c()) {
                AnnotationDescriptor annotationDescriptor = annotationWithTarget.f25535a;
                AnnotationUseSiteTarget annotationUseSiteTarget = annotationWithTarget.f25536b;
                ClassifierDescriptor c2 = annotationDescriptor.mo5719a().mo6743g().mo5724c();
                if (c2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                } else if (!c.contains(DescriptorUtils.m27654d((ClassDescriptor) c2))) {
                    stringBuilder.append(mo5891a(annotationDescriptor, annotationUseSiteTarget));
                    stringBuilder.append(" ");
                }
            }
        }
    }

    public final String mo5891a(AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget) {
        Intrinsics.m26847b(annotationDescriptor, "annotation");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('@');
        if (annotationUseSiteTarget != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(annotationUseSiteTarget.f25533j);
            stringBuilder2.append(":");
            stringBuilder.append(stringBuilder2.toString());
        }
        KotlinType a = annotationDescriptor.mo5719a();
        Intrinsics.m26843a((Object) a, "annotationType");
        stringBuilder.append(mo5894a(a));
        if (DefaultImpls.m27598a(this.f32889j)) {
            annotationDescriptor = m33366a(annotationDescriptor);
            if (DefaultImpls.m27599b(this.f32889j) || (((Collection) annotationDescriptor).isEmpty() ^ 1) != 0) {
                CollectionsKt___CollectionsKt.m41410a((Iterable) annotationDescriptor, stringBuilder, ", ", "(", ")", 0, null, null, 112);
            }
        }
        if (!(m33419o() == null || (a.mo6742d() == null && (a.mo6743g().mo5724c() instanceof MockClassDescriptor) == null))) {
            stringBuilder.append(" /* annotation class not found */");
        }
        Object stringBuilder3 = stringBuilder.toString();
        Intrinsics.m26843a(stringBuilder3, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder3;
    }

    private final List<String> m33366a(AnnotationDescriptor annotationDescriptor) {
        List list;
        Collection arrayList;
        Object value;
        Iterable<ValueParameterDescriptor> iterable;
        Collection collection;
        List list2;
        Iterable<Entry> entrySet;
        String a;
        Map b = annotationDescriptor.mo5720b();
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.f32889j;
        annotationDescriptor = ((Boolean) descriptorRendererOptionsImpl.f32893A.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.f32892H[26])).booleanValue() ? TypeUtils.m28017f(annotationDescriptor.mo5719a()) : null;
        if (annotationDescriptor != null) {
            annotationDescriptor = annotationDescriptor.aH_();
            if (annotationDescriptor != null) {
                annotationDescriptor = annotationDescriptor.mo7757k();
                if (annotationDescriptor != null) {
                    Collection arrayList2 = new ArrayList();
                    for (Object next : (Iterable) annotationDescriptor) {
                        if (((ValueParameterDescriptor) next).mo7802h()) {
                            arrayList2.add(next);
                        }
                    }
                    list = (List) arrayList2;
                    arrayList = new ArrayList();
                    for (Object value2 : list) {
                        if ((b.containsKey((ValueParameterDescriptor) value2) ^ 1) != 0) {
                            arrayList.add(value2);
                        }
                    }
                    iterable = (List) arrayList;
                    collection = (Collection) new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                    for (ValueParameterDescriptor valueParameterDescriptor : iterable) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(valueParameterDescriptor.mo6689i().m27429a());
                        stringBuilder.append(" = ...");
                        collection.add(stringBuilder.toString());
                    }
                    list2 = (List) collection;
                    entrySet = b.entrySet();
                    arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(entrySet));
                    for (Entry entry : entrySet) {
                        String a2 = ((ValueParameterDescriptor) entry.getKey()).mo6689i().m27429a();
                        if (list.contains(entry.getKey())) {
                            value2 = entry.getValue();
                            Intrinsics.m26843a(value2, "entry.value");
                            a = m33364a((ConstantValue) value2);
                        } else {
                            a = "...";
                        }
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(a2);
                        stringBuilder2.append(" = ");
                        stringBuilder2.append(a);
                        arrayList.add(stringBuilder2.toString());
                    }
                    return CollectionsKt___CollectionsKt.m41448m(CollectionsKt___CollectionsKt.m41423b((Collection) list2, (Iterable) (List) arrayList));
                }
            }
        }
        list = CollectionsKt__CollectionsKt.m26790a();
        arrayList = new ArrayList();
        for (Object value22 : list) {
            if ((b.containsKey((ValueParameterDescriptor) value22) ^ 1) != 0) {
                arrayList.add(value22);
            }
        }
        iterable = (List) arrayList;
        collection = (Collection) new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (ValueParameterDescriptor valueParameterDescriptor2 : iterable) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(valueParameterDescriptor2.mo6689i().m27429a());
            stringBuilder3.append(" = ...");
            collection.add(stringBuilder3.toString());
        }
        list2 = (List) collection;
        entrySet = b.entrySet();
        arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(entrySet));
        for (Entry entry2 : entrySet) {
            String a22 = ((ValueParameterDescriptor) entry2.getKey()).mo6689i().m27429a();
            if (list.contains(entry2.getKey())) {
                a = "...";
            } else {
                value22 = entry2.getValue();
                Intrinsics.m26843a(value22, "entry.value");
                a = m33364a((ConstantValue) value22);
            }
            StringBuilder stringBuilder22 = new StringBuilder();
            stringBuilder22.append(a22);
            stringBuilder22.append(" = ");
            stringBuilder22.append(a);
            arrayList.add(stringBuilder22.toString());
        }
        return CollectionsKt___CollectionsKt.m41448m(CollectionsKt___CollectionsKt.m41423b((Collection) list2, (Iterable) (List) arrayList));
    }

    private final String m33364a(ConstantValue<?> constantValue) {
        if (constantValue instanceof ArrayValue) {
            Iterable<ConstantValue> iterable = (Iterable) ((ArrayValue) constantValue).mo5919b();
            Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
            for (ConstantValue a : iterable) {
                arrayList.add(m33364a(a));
            }
            return CollectionsKt___CollectionsKt.m41412a((Iterable) (List) arrayList, (CharSequence) ", ", (CharSequence) "{", (CharSequence) "}", 0, null, null, 56);
        } else if (constantValue instanceof AnnotationValue) {
            return StringsKt__StringsKt.m42447a((String) mo5891a((AnnotationDescriptor) ((AnnotationValue) constantValue).mo5919b(), null), (CharSequence) "@");
        } else {
            if (!(constantValue instanceof KClassValue)) {
                return constantValue.toString();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(mo5894a(((KClassValue) constantValue).m33490c()));
            stringBuilder.append("::class");
            return stringBuilder.toString();
        }
    }

    private final void m33385a(Visibility visibility, StringBuilder stringBuilder) {
        if ((m33411g().contains(DescriptorRendererModifier.f26022a) ^ 1) == 0) {
            Object b;
            DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.f32889j;
            if (((Boolean) descriptorRendererOptionsImpl.f32913k.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.f32892H[10])).booleanValue()) {
                b = visibility.mo5763b();
            }
            descriptorRendererOptionsImpl = this.f32889j;
            if (((Boolean) descriptorRendererOptionsImpl.f32914l.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.f32892H[11])).booleanValue() || !Intrinsics.m26845a(b, Visibilities.f25514k)) {
                stringBuilder.append(m33361a(b.mo5717a()));
                stringBuilder.append(" ");
            }
        }
    }

    private final void m33380a(Modality modality, StringBuilder stringBuilder) {
        if ((m33411g().contains(DescriptorRendererModifier.f26023b) ^ 1) == 0) {
            modality = modality.name();
            if (modality == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String toLowerCase = ((String) modality).toLowerCase();
            Intrinsics.m26843a((Object) toLowerCase, "(this as java.lang.String).toLowerCase()");
            stringBuilder.append(m33361a(toLowerCase));
            stringBuilder.append(" ");
        }
    }

    private final void m33376a(CallableMemberDescriptor callableMemberDescriptor, StringBuilder stringBuilder) {
        if ((!DescriptorUtils.m27655e(callableMemberDescriptor) || (Intrinsics.m26845a(callableMemberDescriptor.aG_(), Modality.f25488a) ^ 1) != 0) && (!m33398a(callableMemberDescriptor) || !Intrinsics.m26845a(m33412h(), OverrideRenderingPolicy.f26040a) || !Intrinsics.m26845a(callableMemberDescriptor.aG_(), Modality.f25490c))) {
            Modality aG_ = callableMemberDescriptor.aG_();
            Intrinsics.m26843a((Object) aG_, "callable.modality");
            m33380a(aG_, stringBuilder);
        }
    }

    private final void m33403b(CallableMemberDescriptor callableMemberDescriptor, StringBuilder stringBuilder) {
        if ((m33411g().contains(DescriptorRendererModifier.f26024c) ^ 1) == 0 && m33398a(callableMemberDescriptor) && (Intrinsics.m26845a(m33412h(), OverrideRenderingPolicy.f26041b) ^ 1) != 0) {
            stringBuilder.append("override ");
            if (m33419o()) {
                stringBuilder.append("/*");
                stringBuilder.append(callableMemberDescriptor.mo7609m().size());
                stringBuilder.append("*/ ");
            }
        }
    }

    private final void m33407c(CallableMemberDescriptor callableMemberDescriptor, StringBuilder stringBuilder) {
        if ((m33411g().contains(DescriptorRendererModifier.f26027f) ^ 1) == 0 && m33419o() && (Intrinsics.m26845a(callableMemberDescriptor.mo7760t(), Kind.DECLARATION) ^ 1) != 0) {
            stringBuilder.append("/*");
            callableMemberDescriptor = callableMemberDescriptor.mo7760t().name();
            if (callableMemberDescriptor == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            Object toLowerCase = ((String) callableMemberDescriptor).toLowerCase();
            Intrinsics.m26843a(toLowerCase, "(this as java.lang.String).toLowerCase()");
            stringBuilder.append(toLowerCase);
            stringBuilder.append("*/ ");
        }
    }

    private static void m33408d(CallableMemberDescriptor callableMemberDescriptor, StringBuilder stringBuilder) {
        m33379a((MemberDescriptor) callableMemberDescriptor, stringBuilder);
        if (callableMemberDescriptor.mo7743n()) {
            stringBuilder.append("header ");
        }
        if (callableMemberDescriptor.mo7744o() != null) {
            stringBuilder.append("impl ");
        }
    }

    private static void m33379a(MemberDescriptor memberDescriptor, StringBuilder stringBuilder) {
        if (memberDescriptor.mo7745p() != null) {
            stringBuilder.append("external ");
        }
    }

    public final String mo5890a(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.m26847b(declarationDescriptor, "declarationDescriptor");
        StringBuilder stringBuilder = new StringBuilder();
        declarationDescriptor.mo7078a(new RenderDeclarationDescriptorVisitor(this), stringBuilder);
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.f32889j;
        if (((Boolean) descriptorRendererOptionsImpl.f32905c.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.f32892H[1])).booleanValue() && !(declarationDescriptor instanceof PackageFragmentDescriptor)) {
            if (!(declarationDescriptor instanceof PackageViewDescriptor)) {
                if (declarationDescriptor instanceof ModuleDescriptor) {
                    stringBuilder.append(" is a module");
                } else {
                    declarationDescriptor = declarationDescriptor.aD_();
                    if (!(declarationDescriptor == null || (declarationDescriptor instanceof ModuleDescriptor))) {
                        stringBuilder.append(" ");
                        String str = "defined in";
                        Intrinsics.m26847b(str, "message");
                        switch (WhenMappings.f26020d[m33417m().ordinal()]) {
                            case 1:
                                break;
                            case 2:
                                StringBuilder stringBuilder2 = new StringBuilder("<i>");
                                stringBuilder2.append(str);
                                stringBuilder2.append("</i>");
                                str = stringBuilder2.toString();
                                break;
                            default:
                                throw new NoWhenBranchMatchedException();
                        }
                        stringBuilder.append(str);
                        stringBuilder.append(" ");
                        FqNameUnsafe c = DescriptorUtils.m27653c(declarationDescriptor);
                        if (c.f25861b.isEmpty()) {
                            declarationDescriptor = "root package";
                        } else {
                            Intrinsics.m26843a((Object) c, "fqName");
                            declarationDescriptor = mo5892a(c);
                        }
                        stringBuilder.append(declarationDescriptor);
                    }
                }
            }
        }
        Object stringBuilder3 = stringBuilder.toString();
        Intrinsics.m26843a(stringBuilder3, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder3;
    }

    private final void m33374a(List<? extends TypeParameterDescriptor> list, StringBuilder stringBuilder, boolean z) {
        if (!(m33420p() || list.isEmpty())) {
            stringBuilder.append(m33399b(Operation.LESS_THAN));
            m33400b(stringBuilder, (List) list);
            stringBuilder.append(m33399b(Operation.GREATER_THAN));
            if (z) {
                stringBuilder.append(" ");
            }
        }
    }

    private final void m33400b(StringBuilder stringBuilder, List<? extends TypeParameterDescriptor> list) {
        list = list.iterator();
        while (list.hasNext()) {
            m33382a((TypeParameterDescriptor) list.next(), stringBuilder, false);
            if (list.hasNext()) {
                stringBuilder.append(", ");
            }
        }
    }

    private final void m33402b(CallableDescriptor callableDescriptor, StringBuilder stringBuilder) {
        callableDescriptor = callableDescriptor.mo7755d();
        if (callableDescriptor != null) {
            KotlinType x = callableDescriptor.mo7777x();
            Intrinsics.m26843a((Object) x, "type");
            String a = mo5894a(x);
            Intrinsics.m26843a((Object) x, "type");
            if (m33405b(x) && TypeUtils.m28015d(x) == null) {
                callableDescriptor = new StringBuilder("(");
                callableDescriptor.append(a);
                callableDescriptor.append(")");
                a = callableDescriptor.toString();
            }
            stringBuilder.append(a);
            stringBuilder.append(".");
        }
    }

    private final void m33373a(List<? extends TypeParameterDescriptor> list, StringBuilder stringBuilder) {
        if (!m33420p()) {
            ArrayList arrayList = new ArrayList(0);
            for (TypeParameterDescriptor typeParameterDescriptor : list) {
                for (KotlinType kotlinType : CollectionsKt___CollectionsKt.m41444j((Iterable) typeParameterDescriptor.mo7715j())) {
                    Collection collection = arrayList;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    Name i = typeParameterDescriptor.mo6689i();
                    Intrinsics.m26843a((Object) i, "typeParameter.name");
                    stringBuilder2.append(mo5893a(i));
                    stringBuilder2.append(" : ");
                    Intrinsics.m26843a((Object) kotlinType, "it");
                    stringBuilder2.append(mo5894a(kotlinType));
                    collection.add(stringBuilder2.toString());
                }
            }
            if (arrayList.isEmpty() == null) {
                stringBuilder.append(" ");
                stringBuilder.append(m33361a("where"));
                stringBuilder.append(" ");
                CollectionsKt___CollectionsKt.m41410a(arrayList, stringBuilder, ", ", null, null, 0, null, null, 124);
            }
        }
    }

    private final void m33383a(ValueParameterDescriptor valueParameterDescriptor, boolean z, StringBuilder stringBuilder, boolean z2) {
        KotlinType kotlinType;
        if (z2) {
            stringBuilder.append(m33361a("value-parameter"));
            stringBuilder.append(" ");
        }
        if (m33419o()) {
            stringBuilder.append("/*");
            stringBuilder.append(valueParameterDescriptor.mo7801c());
            stringBuilder.append("*/ ");
        }
        m33370a(stringBuilder, (Annotated) valueParameterDescriptor);
        if (valueParameterDescriptor.mo7805p()) {
            stringBuilder.append("crossinline ");
        }
        if (valueParameterDescriptor.mo7806s()) {
            stringBuilder.append("noinline ");
        }
        VariableDescriptor variableDescriptor = valueParameterDescriptor;
        KotlinType x = variableDescriptor.mo7777x();
        ValueParameterDescriptor valueParameterDescriptor2 = (ValueParameterDescriptor) (!(variableDescriptor instanceof ValueParameterDescriptor) ? null : variableDescriptor);
        KotlinType n = valueParameterDescriptor2 != null ? valueParameterDescriptor2.mo7803n() : null;
        if (n == null) {
            Intrinsics.m26843a((Object) x, "realType");
            kotlinType = x;
        } else {
            kotlinType = n;
        }
        if (n != null) {
            stringBuilder.append(m33361a("vararg"));
            stringBuilder.append(" ");
        }
        if (z2 && !m33416l()) {
            m33384a(variableDescriptor, stringBuilder);
        }
        if (z) {
            m33378a((DeclarationDescriptor) variableDescriptor, stringBuilder);
            stringBuilder.append(": ");
        }
        stringBuilder.append(mo5894a(kotlinType));
        m33404b(variableDescriptor, stringBuilder);
        if (m33419o() && n != null) {
            stringBuilder.append(" /*");
            Intrinsics.m26843a((Object) x, "realType");
            stringBuilder.append(mo5894a(x));
            stringBuilder.append("*/");
        }
        z = this.f32889j;
        if (((Boolean) z.f32920r.getValue(z, DescriptorRendererOptionsImpl.f32892H[17])).booleanValue()) {
            if ((this.f32889j.mo5905b() ? valueParameterDescriptor.mo7802h() : DescriptorUtilsKt.m27740a(valueParameterDescriptor)) != null) {
                valueParameterDescriptor = true;
                if (valueParameterDescriptor != null) {
                    stringBuilder.append(" = ...");
                }
            }
        }
        valueParameterDescriptor = null;
        if (valueParameterDescriptor != null) {
            stringBuilder.append(" = ...");
        }
    }

    private final void m33384a(VariableDescriptor variableDescriptor, StringBuilder stringBuilder) {
        if (!(variableDescriptor instanceof ValueParameterDescriptor)) {
            stringBuilder.append(m33361a(variableDescriptor.mo7807y() != null ? "var" : "val"));
            stringBuilder.append(" ");
        }
    }

    private final void m33377a(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, StringBuilder stringBuilder) {
        List s = classifierDescriptorWithTypeParameters.mo7719s();
        List b = classifierDescriptorWithTypeParameters.mo7610c().mo5723b();
        if (m33419o() && classifierDescriptorWithTypeParameters.mo7742l() != null && b.size() > s.size()) {
            stringBuilder.append(" /*captured type parameters: ");
            m33400b(stringBuilder, b.subList(s.size(), b.size()));
            stringBuilder.append("*/");
        }
    }

    private final void m33386a(FqName fqName, String str, StringBuilder stringBuilder) {
        stringBuilder.append(m33361a(str));
        FqNameUnsafe b = fqName.m27409b();
        Intrinsics.m26843a((Object) b, "fqName.toUnsafe()");
        fqName = mo5892a(b);
        if ((((CharSequence) fqName).length() > null ? true : null) != null) {
            stringBuilder.append(" ");
            stringBuilder.append(fqName);
        }
    }

    private static void m33367a(StringBuilder stringBuilder) {
        int length = stringBuilder.length();
        if (length == 0 || stringBuilder.charAt(length - 1) != ' ') {
            stringBuilder.append(' ');
        }
    }

    private static String m33362a(String str, String str2, String str3, String str4, String str5) {
        if (StringsKt__StringsJVMKt.m41944a(str, str2) && StringsKt__StringsJVMKt.m41944a(str3, str4)) {
            str2 = str2.length();
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            str = str.substring(str2);
            Intrinsics.m26843a((Object) str, "(this as java.lang.String).substring(startIndex)");
            str2 = str4.length();
            if (str3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            str2 = str3.substring(str2);
            Intrinsics.m26843a((Object) str2, "(this as java.lang.String).substring(startIndex)");
            str3 = new StringBuilder();
            str3.append(str5);
            str3.append(str);
            str3 = str3.toString();
            if (Intrinsics.m26845a((Object) str, (Object) str2) != null) {
                return str3;
            }
            if (m33397a(str, str2) != null) {
                str = new StringBuilder();
                str.append(str3);
                str.append("!");
                return str.toString();
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m33397a(java.lang.String r2, java.lang.String r3) {
        /*
        r0 = "?";
        r1 = "";
        r0 = kotlin.text.StringsKt__StringsJVMKt.m41942a(r3, r0, r1);
        r0 = kotlin.jvm.internal.Intrinsics.m26845a(r2, r0);
        if (r0 != 0) goto L_0x0049;
    L_0x000e:
        r0 = "?";
        r0 = kotlin.text.StringsKt__StringsJVMKt.m41948b(r3, r0);
        if (r0 == 0) goto L_0x002d;
    L_0x0016:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0.append(r2);
        r1 = "?";
        r0.append(r1);
        r0 = r0.toString();
        r0 = kotlin.jvm.internal.Intrinsics.m26845a(r0, r3);
        if (r0 != 0) goto L_0x0049;
    L_0x002d:
        r0 = new java.lang.StringBuilder;
        r1 = "(";
        r0.<init>(r1);
        r0.append(r2);
        r2 = ")?";
        r0.append(r2);
        r2 = r0.toString();
        r2 = kotlin.jvm.internal.Intrinsics.m26845a(r2, r3);
        if (r2 == 0) goto L_0x0047;
    L_0x0046:
        goto L_0x0049;
    L_0x0047:
        r2 = 0;
        return r2;
    L_0x0049:
        r2 = 1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.a(java.lang.String, java.lang.String):boolean");
    }

    private static boolean m33398a(CallableMemberDescriptor callableMemberDescriptor) {
        return callableMemberDescriptor.mo7609m().isEmpty() == null ? true : null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m33369a(java.lang.StringBuilder r3, kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType r4) {
        /*
        r2 = this;
        r0 = r4.f25497c;
        if (r0 == 0) goto L_0x0025;
    L_0x0004:
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType) r0;
        r2.m33369a(r3, r0);
        r0 = 46;
        r3.append(r0);
        r0 = r4.f25495a;
        r0 = r0.mo6689i();
        r1 = "possiblyInnerType.classifierDescriptor.name";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r1);
        r0 = r2.mo5893a(r0);
        r3.append(r0);
        r0 = r3;
        r0 = (java.lang.StringBuilder) r0;
        if (r0 != 0) goto L_0x0037;
    L_0x0025:
        r0 = r4.f25495a;
        r0 = r0.mo7610c();
        r1 = "possiblyInnerType.classi…escriptor.typeConstructor";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r1);
        r0 = r2.m33365a(r0);
        r3.append(r0);
    L_0x0037:
        r4 = r4.f25496b;
        r4 = r2.m33363a(r4);
        r3.append(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.a(java.lang.StringBuilder, kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType):void");
    }

    private final void m33382a(TypeParameterDescriptor typeParameterDescriptor, StringBuilder stringBuilder, boolean z) {
        if (z) {
            stringBuilder.append(m33399b(Operation.LESS_THAN));
        }
        if (m33419o()) {
            stringBuilder.append("/*");
            stringBuilder.append(typeParameterDescriptor.mo7713g());
            stringBuilder.append("*/ ");
        }
        if (typeParameterDescriptor.mo7717l()) {
            stringBuilder.append(m33361a("reified"));
            stringBuilder.append(" ");
        }
        String str = typeParameterDescriptor.mo7716k().f26341d;
        Object obj = 1;
        if ((((CharSequence) str).length() == 0 ? 1 : null) == null) {
            stringBuilder.append(m33361a(str));
            stringBuilder.append(" ");
        }
        m33370a(stringBuilder, (Annotated) typeParameterDescriptor);
        m33378a((DeclarationDescriptor) typeParameterDescriptor, stringBuilder);
        int size = typeParameterDescriptor.mo7715j().size();
        if ((size > 1 && !z) || size == 1) {
            KotlinType kotlinType = (KotlinType) typeParameterDescriptor.mo7715j().iterator().next();
            if (!KotlinBuiltIns.m26993i(kotlinType)) {
                stringBuilder.append(" : ");
                Intrinsics.m26843a((Object) kotlinType, "upperBound");
                stringBuilder.append(mo5894a(kotlinType));
            }
        } else if (z) {
            for (KotlinType kotlinType2 : typeParameterDescriptor.mo7715j()) {
                if (!KotlinBuiltIns.m26993i(kotlinType2)) {
                    if (obj != null) {
                        stringBuilder.append(" : ");
                    } else {
                        stringBuilder.append(" & ");
                    }
                    Intrinsics.m26843a((Object) kotlinType2, "upperBound");
                    stringBuilder.append(mo5894a(kotlinType2));
                    obj = null;
                }
            }
        }
        if (z) {
            stringBuilder.append(m33399b(Operation.GREATER_THAN));
        }
    }

    private final void m33375a(CallableDescriptor callableDescriptor, StringBuilder stringBuilder) {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.f32889j;
        if (((Boolean) descriptorRendererOptionsImpl.f32926x.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.f32892H[23])).booleanValue()) {
            callableDescriptor = callableDescriptor.mo7755d();
            if (callableDescriptor != null) {
                stringBuilder.append(" on ");
                KotlinType x = callableDescriptor.mo7777x();
                Intrinsics.m26843a((Object) x, "receiver.type");
                stringBuilder.append(mo5894a(x));
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m33372a(java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> r6, boolean r7, java.lang.StringBuilder r8) {
        /*
        r5 = this;
        r0 = r5.f32889j;
        r1 = r0.f32925w;
        r2 = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.f32892H;
        r3 = 22;
        r2 = r2[r3];
        r0 = r1.getValue(r0, r2);
        r0 = (kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy) r0;
        r1 = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.WhenMappings.f26021e;
        r0 = r0.ordinal();
        r0 = r1[r0];
        r1 = 1;
        r2 = 0;
        switch(r0) {
            case 1: goto L_0x0027;
            case 2: goto L_0x0025;
            case 3: goto L_0x0023;
            default: goto L_0x001d;
        };
    L_0x001d:
        r6 = new kotlin.NoWhenBranchMatchedException;
        r6.<init>();
        throw r6;
    L_0x0023:
        r1 = r2;
        goto L_0x0027;
    L_0x0025:
        if (r7 != 0) goto L_0x0023;
    L_0x0027:
        r7 = r6.size();
        r0 = r5.m33418n();
        r0.mo5885a(r8);
        r6 = (java.lang.Iterable) r6;
        r6 = kotlin.collections.CollectionsKt___CollectionsKt.m41452q(r6);
        r6 = r6.iterator();
    L_0x003c:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x0060;
    L_0x0042:
        r0 = r6.next();
        r0 = (kotlin.collections.IndexedValue) r0;
        r3 = r0.f25277a;
        r0 = r0.f25278b;
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r0;
        r4 = r5.m33418n();
        r4.mo5887a(r0, r8);
        r5.m33383a(r0, r1, r8, r2);
        r4 = r5.m33418n();
        r4.mo5886a(r0, r3, r7, r8);
        goto L_0x003c;
    L_0x0060:
        r6 = r5.m33418n();
        r6.mo5888b(r8);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.a(java.util.Collection, boolean, java.lang.StringBuilder):void");
    }

    private final void m33404b(VariableDescriptor variableDescriptor, StringBuilder stringBuilder) {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.f32889j;
        if (((Boolean) descriptorRendererOptionsImpl.f32916n.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.f32892H[13])).booleanValue()) {
            variableDescriptor = variableDescriptor.mo7808z();
            if (variableDescriptor != null) {
                ConstantValue constantValue = (ConstantValue) variableDescriptor;
                stringBuilder.append(" = ");
                Intrinsics.m26843a((Object) constantValue, "constant");
                stringBuilder.append(m33399b(m33364a(constantValue)));
            }
        }
    }

    private boolean m33409e() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.f32889j;
        return ((Boolean) descriptorRendererOptionsImpl.f32895C.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.f32892H[30])).booleanValue();
    }

    private ClassifierNamePolicy m33410f() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.f32889j;
        return (ClassifierNamePolicy) descriptorRendererOptionsImpl.f32904b.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.f32892H[0]);
    }

    private Set<DescriptorRendererModifier> m33411g() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.f32889j;
        return (Set) descriptorRendererOptionsImpl.f32906d.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.f32892H[2]);
    }

    private OverrideRenderingPolicy m33412h() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.f32889j;
        return (OverrideRenderingPolicy) descriptorRendererOptionsImpl.f32922t.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.f32892H[19]);
    }

    public final boolean m33441d() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.f32889j;
        return ((Boolean) descriptorRendererOptionsImpl.f32928z.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.f32892H[25])).booleanValue();
    }

    private boolean m33413i() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.f32889j;
        return ((Boolean) descriptorRendererOptionsImpl.f32896D.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.f32892H[31])).booleanValue();
    }

    private boolean m33414j() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.f32889j;
        return ((Boolean) descriptorRendererOptionsImpl.f32921s.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.f32892H[18])).booleanValue();
    }

    private boolean m33415k() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.f32889j;
        return ((Boolean) descriptorRendererOptionsImpl.f32908f.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.f32892H[4])).booleanValue();
    }

    private boolean m33416l() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.f32889j;
        return ((Boolean) descriptorRendererOptionsImpl.f32907e.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.f32892H[3])).booleanValue();
    }

    private RenderingFormat m33417m() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.f32889j;
        return (RenderingFormat) descriptorRendererOptionsImpl.f32924v.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.f32892H[21]);
    }

    private ValueParametersHandler m33418n() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.f32889j;
        return (ValueParametersHandler) descriptorRendererOptionsImpl.f32923u.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.f32892H[20]);
    }

    private boolean m33419o() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.f32889j;
        return ((Boolean) descriptorRendererOptionsImpl.f32910h.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.f32892H[7])).booleanValue();
    }

    private boolean m33420p() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.f32889j;
        return ((Boolean) descriptorRendererOptionsImpl.f32917o.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.f32892H[14])).booleanValue();
    }

    public static final /* synthetic */ void m33393a(DescriptorRendererImpl descriptorRendererImpl, PropertyDescriptor propertyDescriptor, StringBuilder stringBuilder) {
        if (!descriptorRendererImpl.m33416l()) {
            if (!descriptorRendererImpl.m33415k()) {
                descriptorRendererImpl.m33370a(stringBuilder, (Annotated) propertyDescriptor);
                Visibility j = propertyDescriptor.mo7257j();
                Intrinsics.m26843a((Object) j, "property.visibility");
                descriptorRendererImpl.m33385a(j, stringBuilder);
                if (propertyDescriptor.mo7776A()) {
                    stringBuilder.append("const ");
                }
                CallableMemberDescriptor callableMemberDescriptor = propertyDescriptor;
                m33408d(callableMemberDescriptor, stringBuilder);
                descriptorRendererImpl.m33376a(callableMemberDescriptor, stringBuilder);
                descriptorRendererImpl.m33403b(callableMemberDescriptor, stringBuilder);
                if (propertyDescriptor.mo7830w()) {
                    stringBuilder.append("lateinit ");
                }
                descriptorRendererImpl.m33407c(callableMemberDescriptor, stringBuilder);
            }
            descriptorRendererImpl.m33384a((VariableDescriptor) propertyDescriptor, stringBuilder);
            List f = propertyDescriptor.mo7735f();
            Intrinsics.m26843a((Object) f, "property.typeParameters");
            descriptorRendererImpl.m33374a(f, stringBuilder, true);
            descriptorRendererImpl.m33402b((CallableDescriptor) propertyDescriptor, stringBuilder);
        }
        descriptorRendererImpl.m33378a((DeclarationDescriptor) propertyDescriptor, stringBuilder);
        stringBuilder.append(": ");
        KotlinType x = propertyDescriptor.mo7777x();
        Intrinsics.m26843a((Object) x, "property.type");
        stringBuilder.append(descriptorRendererImpl.mo5894a(x));
        descriptorRendererImpl.m33375a((CallableDescriptor) propertyDescriptor, stringBuilder);
        descriptorRendererImpl.m33404b((VariableDescriptor) propertyDescriptor, stringBuilder);
        List f2 = propertyDescriptor.mo7735f();
        Intrinsics.m26843a((Object) f2, "property.typeParameters");
        descriptorRendererImpl.m33373a(f2, stringBuilder);
    }

    public static final /* synthetic */ void m33390a(DescriptorRendererImpl descriptorRendererImpl, FunctionDescriptor functionDescriptor, StringBuilder stringBuilder) {
        if (!descriptorRendererImpl.m33416l()) {
            if (!descriptorRendererImpl.m33415k()) {
                descriptorRendererImpl.m33370a(stringBuilder, (Annotated) functionDescriptor);
                Visibility j = functionDescriptor.mo7257j();
                Intrinsics.m26843a((Object) j, "function.visibility");
                descriptorRendererImpl.m33385a(j, stringBuilder);
                CallableMemberDescriptor callableMemberDescriptor = functionDescriptor;
                descriptorRendererImpl.m33376a(callableMemberDescriptor, stringBuilder);
                DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = descriptorRendererImpl.f32889j;
                if (((Boolean) descriptorRendererOptionsImpl.f32898F.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.f32892H[33])).booleanValue()) {
                    boolean z = false;
                    if (functionDescriptor.mo7764y()) {
                        boolean z2;
                        for (FunctionDescriptor y : functionDescriptor.mo7609m()) {
                            if (y.mo7764y()) {
                                z2 = false;
                                break;
                            }
                        }
                        z2 = true;
                        if (z2 || descriptorRendererImpl.m33409e()) {
                            stringBuilder.append("operator ");
                        }
                    }
                    if (functionDescriptor.mo7765z()) {
                        for (FunctionDescriptor y2 : functionDescriptor.mo7609m()) {
                            if (y2.mo7765z()) {
                                break;
                            }
                        }
                        z = true;
                        if (z || descriptorRendererImpl.m33409e()) {
                            stringBuilder.append("infix ");
                        }
                    }
                    m33408d(callableMemberDescriptor, stringBuilder);
                    if (functionDescriptor.mo7752b()) {
                        stringBuilder.append("inline ");
                    }
                    if (functionDescriptor.mo7753c()) {
                        stringBuilder.append("tailrec ");
                    }
                    if (functionDescriptor.mo7747B()) {
                        stringBuilder.append("suspend ");
                    }
                }
                descriptorRendererImpl.m33403b(callableMemberDescriptor, stringBuilder);
                descriptorRendererImpl.m33407c(callableMemberDescriptor, stringBuilder);
                if (descriptorRendererImpl.m33419o()) {
                    if (functionDescriptor.mo7763x()) {
                        stringBuilder.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (functionDescriptor.mo7746A()) {
                        stringBuilder.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            stringBuilder.append(descriptorRendererImpl.m33361a("fun"));
            stringBuilder.append(" ");
            List f = functionDescriptor.mo7735f();
            Intrinsics.m26843a((Object) f, "function.typeParameters");
            descriptorRendererImpl.m33374a(f, stringBuilder, true);
            descriptorRendererImpl.m33402b((CallableDescriptor) functionDescriptor, stringBuilder);
        }
        descriptorRendererImpl.m33378a((DeclarationDescriptor) functionDescriptor, stringBuilder);
        Object k = functionDescriptor.mo7757k();
        Intrinsics.m26843a(k, "function.valueParameters");
        descriptorRendererImpl.m33372a((Collection) k, functionDescriptor.mo7758l(), stringBuilder);
        descriptorRendererImpl.m33375a((CallableDescriptor) functionDescriptor, stringBuilder);
        KotlinType aN_ = functionDescriptor.aN_();
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl2 = descriptorRendererImpl.f32889j;
        if (!((Boolean) descriptorRendererOptionsImpl2.f32912j.getValue(descriptorRendererOptionsImpl2, DescriptorRendererOptionsImpl.f32892H[9])).booleanValue()) {
            descriptorRendererOptionsImpl2 = descriptorRendererImpl.f32889j;
            if (((Boolean) descriptorRendererOptionsImpl2.f32911i.getValue(descriptorRendererOptionsImpl2, DescriptorRendererOptionsImpl.f32892H[8])).booleanValue() || aN_ == null || !KotlinBuiltIns.m26994j(aN_)) {
                stringBuilder.append(": ");
                stringBuilder.append(aN_ == null ? "[NULL]" : descriptorRendererImpl.mo5894a(aN_));
            }
        }
        List f2 = functionDescriptor.mo7735f();
        Intrinsics.m26843a((Object) f2, "function.typeParameters");
        descriptorRendererImpl.m33373a(f2, stringBuilder);
    }

    public static final /* synthetic */ void m33388a(DescriptorRendererImpl descriptorRendererImpl, ConstructorDescriptor constructorDescriptor, StringBuilder stringBuilder) {
        Object u;
        descriptorRendererImpl.m33370a(stringBuilder, (Annotated) constructorDescriptor);
        Visibility j = constructorDescriptor.mo7257j();
        Intrinsics.m26843a((Object) j, "constructor.visibility");
        descriptorRendererImpl.m33385a(j, stringBuilder);
        descriptorRendererImpl.m33407c((CallableMemberDescriptor) constructorDescriptor, stringBuilder);
        if (descriptorRendererImpl.m33413i()) {
            stringBuilder.append(descriptorRendererImpl.m33361a("constructor"));
        }
        if (descriptorRendererImpl.m33414j()) {
            u = constructorDescriptor.mo7820u();
            if (descriptorRendererImpl.m33413i()) {
                stringBuilder.append(" ");
            }
            Intrinsics.m26843a(u, "classDescriptor");
            descriptorRendererImpl.m33378a((DeclarationDescriptor) u, stringBuilder);
            List f = constructorDescriptor.mo7735f();
            Intrinsics.m26843a((Object) f, "constructor.typeParameters");
            descriptorRendererImpl.m33374a(f, stringBuilder, false);
        }
        u = constructorDescriptor.mo7757k();
        Intrinsics.m26843a(u, "constructor.valueParameters");
        descriptorRendererImpl.m33372a((Collection) u, constructorDescriptor.mo7758l(), stringBuilder);
        if (descriptorRendererImpl.m33414j()) {
            List f2 = constructorDescriptor.mo7735f();
            Intrinsics.m26843a((Object) f2, "constructor.typeParameters");
            descriptorRendererImpl.m33373a(f2, stringBuilder);
        }
    }

    public static final /* synthetic */ void m33391a(DescriptorRendererImpl descriptorRendererImpl, PackageFragmentDescriptor packageFragmentDescriptor, StringBuilder stringBuilder) {
        descriptorRendererImpl.m33386a(packageFragmentDescriptor.mo7722d(), "package-fragment", stringBuilder);
        if (descriptorRendererImpl.f32889j.mo5905b()) {
            stringBuilder.append(" in ");
            descriptorRendererImpl.m33378a((DeclarationDescriptor) packageFragmentDescriptor.mo7721c(), stringBuilder);
        }
    }

    public static final /* synthetic */ void m33392a(DescriptorRendererImpl descriptorRendererImpl, PackageViewDescriptor packageViewDescriptor, StringBuilder stringBuilder) {
        descriptorRendererImpl.m33386a(packageViewDescriptor.mo7080b(), "package", stringBuilder);
        if (descriptorRendererImpl.f32889j.mo5905b()) {
            stringBuilder.append(" in context of ");
            descriptorRendererImpl.m33378a((DeclarationDescriptor) packageViewDescriptor.mo7082d(), stringBuilder);
        }
    }

    public static final /* synthetic */ void m33387a(DescriptorRendererImpl descriptorRendererImpl, ClassDescriptor classDescriptor, StringBuilder stringBuilder) {
        boolean a = Intrinsics.m26845a(classDescriptor.mo7771g(), ClassKind.ENUM_ENTRY);
        if (!descriptorRendererImpl.m33416l()) {
            descriptorRendererImpl.m33370a(stringBuilder, (Annotated) classDescriptor);
            if (!a) {
                Visibility j = classDescriptor.mo7257j();
                Intrinsics.m26843a((Object) j, "klass.visibility");
                descriptorRendererImpl.m33385a(j, stringBuilder);
            }
            m33379a((MemberDescriptor) classDescriptor, stringBuilder);
            if (!((Intrinsics.m26845a(classDescriptor.mo7771g(), ClassKind.INTERFACE) && Intrinsics.m26845a(classDescriptor.aG_(), Modality.f25491d)) || (classDescriptor.mo7771g().m27042a() && Intrinsics.m26845a(classDescriptor.aG_(), Modality.f25488a)))) {
                Modality aG_ = classDescriptor.aG_();
                Intrinsics.m26843a((Object) aG_, "klass.modality");
                descriptorRendererImpl.m33380a(aG_, stringBuilder);
            }
            boolean n = classDescriptor.mo7743n();
            if ((descriptorRendererImpl.m33411g().contains(DescriptorRendererModifier.f26029h) ^ 1) == 0 && n) {
                stringBuilder.append(descriptorRendererImpl.m33361a("header"));
                stringBuilder.append(" ");
            }
            n = classDescriptor.mo7744o();
            if ((descriptorRendererImpl.m33411g().contains(DescriptorRendererModifier.f26030i) ^ 1) == 0 && n) {
                stringBuilder.append(descriptorRendererImpl.m33361a("impl"));
                stringBuilder.append(" ");
            }
            n = classDescriptor.mo7742l();
            if ((descriptorRendererImpl.m33411g().contains(DescriptorRendererModifier.f26026e) ^ 1) == 0 && n) {
                stringBuilder.append(descriptorRendererImpl.m33361a("inner"));
                stringBuilder.append(" ");
            }
            n = classDescriptor.mo7773m();
            if ((descriptorRendererImpl.m33411g().contains(DescriptorRendererModifier.f26028g) ^ 1) == 0) {
                if (n) {
                    stringBuilder.append(descriptorRendererImpl.m33361a("data"));
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append(descriptorRendererImpl.m33361a(Companion.m27583a((ClassifierDescriptorWithTypeParameters) classDescriptor)));
        }
        DeclarationDescriptor declarationDescriptor = classDescriptor;
        if (DescriptorUtils.m27657g(declarationDescriptor)) {
            DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = descriptorRendererImpl.f32889j;
            if (((Boolean) descriptorRendererOptionsImpl.f32927y.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.f32892H[24])).booleanValue()) {
                if (descriptorRendererImpl.m33416l()) {
                    stringBuilder.append("companion object");
                }
                m33367a(stringBuilder);
                DeclarationDescriptor aD_ = declarationDescriptor.aD_();
                if (aD_ != null) {
                    stringBuilder.append("of ");
                    Name i = aD_.mo6689i();
                    Intrinsics.m26843a((Object) i, "containingDeclaration.name");
                    stringBuilder.append(descriptorRendererImpl.mo5893a(i));
                }
            }
            if (descriptorRendererImpl.m33419o() || (Intrinsics.m26845a(declarationDescriptor.mo6689i(), SpecialNames.f25872c) ^ 1) != 0) {
                if (!descriptorRendererImpl.m33416l()) {
                    m33367a(stringBuilder);
                }
                Name i2 = declarationDescriptor.mo6689i();
                Intrinsics.m26843a((Object) i2, "descriptor.name");
                stringBuilder.append(descriptorRendererImpl.mo5893a(i2));
            }
        } else {
            if (!descriptorRendererImpl.m33416l()) {
                m33367a(stringBuilder);
            }
            descriptorRendererImpl.m33378a(declarationDescriptor, stringBuilder);
        }
        if (!a) {
            DescriptorRendererOptionsImpl descriptorRendererOptionsImpl2;
            List s = classDescriptor.mo7719s();
            Intrinsics.m26843a((Object) s, "typeParameters");
            descriptorRendererImpl.m33374a(s, stringBuilder, false);
            descriptorRendererImpl.m33377a((ClassifierDescriptorWithTypeParameters) classDescriptor, stringBuilder);
            if (!classDescriptor.mo7771g().m27042a()) {
                descriptorRendererOptionsImpl2 = descriptorRendererImpl.f32889j;
                if (((Boolean) descriptorRendererOptionsImpl2.f32909g.getValue(descriptorRendererOptionsImpl2, DescriptorRendererOptionsImpl.f32892H[6])).booleanValue()) {
                    ClassConstructorDescriptor aH_ = classDescriptor.aH_();
                    if (aH_ != null) {
                        stringBuilder.append(" ");
                        descriptorRendererImpl.m33370a(stringBuilder, (Annotated) aH_);
                        Visibility j2 = aH_.mo7257j();
                        Intrinsics.m26843a((Object) j2, "primaryConstructor.visibility");
                        descriptorRendererImpl.m33385a(j2, stringBuilder);
                        stringBuilder.append("constructor");
                        Object k = aH_.mo7757k();
                        Intrinsics.m26843a(k, "primaryConstructor.valueParameters");
                        descriptorRendererImpl.m33372a((Collection) k, aH_.mo7758l(), stringBuilder);
                    }
                }
            }
            descriptorRendererOptionsImpl2 = descriptorRendererImpl.f32889j;
            if (!(((Boolean) descriptorRendererOptionsImpl2.f32918p.getValue(descriptorRendererOptionsImpl2, DescriptorRendererOptionsImpl.f32892H[15])).booleanValue() || KotlinBuiltIns.m26989e(classDescriptor.mo7714h()))) {
                classDescriptor = classDescriptor.mo7610c().aL_();
                if (!classDescriptor.isEmpty()) {
                    if (classDescriptor.size() != 1 || !KotlinBuiltIns.m26991g((KotlinType) classDescriptor.iterator().next())) {
                        m33367a(stringBuilder);
                        stringBuilder.append(": ");
                        Iterable<KotlinType> iterable = (Iterable) classDescriptor;
                        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                        for (KotlinType kotlinType : iterable) {
                            Intrinsics.m26843a((Object) kotlinType, "it");
                            arrayList.add(descriptorRendererImpl.mo5894a(kotlinType));
                        }
                        CollectionsKt___CollectionsKt.m41410a((List) arrayList, stringBuilder, ", ", null, null, 0, null, null, 124);
                    }
                }
            }
            Intrinsics.m26843a((Object) s, "typeParameters");
            descriptorRendererImpl.m33373a(s, stringBuilder);
        }
    }

    public static final /* synthetic */ void m33394a(DescriptorRendererImpl descriptorRendererImpl, TypeAliasDescriptor typeAliasDescriptor, StringBuilder stringBuilder) {
        descriptorRendererImpl.m33370a(stringBuilder, (Annotated) typeAliasDescriptor);
        Visibility j = typeAliasDescriptor.mo7257j();
        Intrinsics.m26843a((Object) j, "typeAlias.visibility");
        descriptorRendererImpl.m33385a(j, stringBuilder);
        stringBuilder.append(descriptorRendererImpl.m33361a("typealias"));
        stringBuilder.append(" ");
        descriptorRendererImpl.m33378a((DeclarationDescriptor) typeAliasDescriptor, stringBuilder);
        List s = typeAliasDescriptor.mo7719s();
        Intrinsics.m26843a((Object) s, "typeAlias.declaredTypeParameters");
        descriptorRendererImpl.m33374a(s, stringBuilder, true);
        descriptorRendererImpl.m33377a((ClassifierDescriptorWithTypeParameters) typeAliasDescriptor, stringBuilder);
        stringBuilder.append(" = ");
        stringBuilder.append(descriptorRendererImpl.mo5894a((KotlinType) typeAliasDescriptor.mo7809b()));
    }
}
