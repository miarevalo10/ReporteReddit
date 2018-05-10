package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import kotlin._Assertions;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy.SOURCE_CODE_QUALIFIED;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler.DEFAULT;

/* compiled from: DescriptorRendererOptionsImpl.kt */
public final class DescriptorRendererOptionsImpl implements DescriptorRendererOptions {
    static final /* synthetic */ KProperty[] f32892H = new KProperty[]{Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "withDefinedIn", "getWithDefinedIn()Z")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "modifiers", "getModifiers()Ljava/util/Set;")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "startFromName", "getStartFromName()Z")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "debugMode", "getDebugMode()Z")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "verbose", "getVerbose()Z")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "unitReturnType", "getUnitReturnType()Z")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "withoutReturnType", "getWithoutReturnType()Z")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "normalizedVisibilities", "getNormalizedVisibilities()Z")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "showInternalKeyword", "getShowInternalKeyword()Z")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "includePropertyConstant", "getIncludePropertyConstant()Z")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "withoutTypeParameters", "getWithoutTypeParameters()Z")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "withoutSuperTypes", "getWithoutSuperTypes()Z")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "renderDefaultValues", "getRenderDefaultValues()Z")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "receiverAfterName", "getReceiverAfterName()Z")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "renderAccessors", "getRenderAccessors()Z")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(DescriptorRendererOptionsImpl.class), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z"))};
    final ReadWriteProperty f32893A = m33446a(Boolean.valueOf(false));
    final ReadWriteProperty f32894B = m33446a(SetsKt__SetsKt.m26799a());
    final ReadWriteProperty f32895C;
    final ReadWriteProperty f32896D;
    final ReadWriteProperty f32897E;
    final ReadWriteProperty f32898F;
    final ReadWriteProperty f32899G;
    private final ReadWriteProperty f32900I = m33446a(Boolean.valueOf(false));
    private final ReadWriteProperty f32901J;
    private final ReadWriteProperty f32902K;
    boolean f32903a;
    final ReadWriteProperty f32904b = m33446a(SOURCE_CODE_QUALIFIED.f32885a);
    final ReadWriteProperty f32905c = m33446a(Boolean.valueOf(true));
    final ReadWriteProperty f32906d = m33446a(DescriptorRendererModifier.f26031j);
    final ReadWriteProperty f32907e = m33446a(Boolean.valueOf(false));
    final ReadWriteProperty f32908f = m33446a(Boolean.valueOf(false));
    final ReadWriteProperty f32909g = m33446a(Boolean.valueOf(false));
    final ReadWriteProperty f32910h = m33446a(Boolean.valueOf(false));
    final ReadWriteProperty f32911i = m33446a(Boolean.valueOf(true));
    final ReadWriteProperty f32912j = m33446a(Boolean.valueOf(false));
    final ReadWriteProperty f32913k = m33446a(Boolean.valueOf(false));
    final ReadWriteProperty f32914l = m33446a(Boolean.valueOf(true));
    final ReadWriteProperty f32915m = m33446a(Boolean.valueOf(false));
    final ReadWriteProperty f32916n = m33446a(Boolean.valueOf(false));
    final ReadWriteProperty f32917o = m33446a(Boolean.valueOf(false));
    final ReadWriteProperty f32918p = m33446a(Boolean.valueOf(false));
    final ReadWriteProperty f32919q = m33446a(DescriptorRendererOptionsImpl$typeNormalizer$2.f38801a);
    final ReadWriteProperty f32920r = m33446a(Boolean.valueOf(true));
    final ReadWriteProperty f32921s = m33446a(Boolean.valueOf(true));
    final ReadWriteProperty f32922t = m33446a(OverrideRenderingPolicy.f26041b);
    final ReadWriteProperty f32923u = m33446a(DEFAULT.f32886a);
    final ReadWriteProperty f32924v = m33446a(RenderingFormat.f26048a);
    final ReadWriteProperty f32925w = m33446a(ParameterNameRenderingPolicy.f26044a);
    final ReadWriteProperty f32926x = m33446a(Boolean.valueOf(false));
    final ReadWriteProperty f32927y = m33446a(Boolean.valueOf(false));
    final ReadWriteProperty f32928z = m33446a(Boolean.valueOf(false));

    public final AnnotationArgumentsRenderingPolicy mo5896a() {
        return (AnnotationArgumentsRenderingPolicy) this.f32902K.getValue(this, f32892H[29]);
    }

    public final void mo5897a(Set<FqName> set) {
        Intrinsics.m26847b(set, "<set-?>");
        this.f32901J.setValue(this, f32892H[28], set);
    }

    public final void mo5898a(AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        Intrinsics.m26847b(annotationArgumentsRenderingPolicy, "<set-?>");
        this.f32902K.setValue(this, f32892H[29], annotationArgumentsRenderingPolicy);
    }

    public final void mo5899a(ClassifierNamePolicy classifierNamePolicy) {
        Intrinsics.m26847b(classifierNamePolicy, "<set-?>");
        this.f32904b.setValue(this, f32892H[0], classifierNamePolicy);
    }

    public final void mo5900a(ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        Intrinsics.m26847b(parameterNameRenderingPolicy, "<set-?>");
        this.f32925w.setValue(this, f32892H[22], parameterNameRenderingPolicy);
    }

    public final void mo5901a(RenderingFormat renderingFormat) {
        Intrinsics.m26847b(renderingFormat, "<set-?>");
        this.f32924v.setValue(this, f32892H[21], renderingFormat);
    }

    public final void mo5902a(boolean z) {
        this.f32900I.setValue(this, f32892H[5], Boolean.valueOf(z));
    }

    public final void mo5903b(Set<? extends DescriptorRendererModifier> set) {
        Intrinsics.m26847b(set, "<set-?>");
        this.f32906d.setValue(this, f32892H[2], set);
    }

    public final void mo5904b(boolean z) {
        this.f32926x.setValue(this, f32892H[23], Boolean.valueOf(z));
    }

    public final boolean mo5905b() {
        return ((Boolean) this.f32900I.getValue(this, f32892H[5])).booleanValue();
    }

    public final Set<FqName> mo5906c() {
        return (Set) this.f32901J.getValue(this, f32892H[28]);
    }

    public final void mo5907c(boolean z) {
        this.f32927y.setValue(this, f32892H[24], Boolean.valueOf(z));
    }

    public final void mo5908d(boolean z) {
        this.f32907e.setValue(this, f32892H[3], Boolean.valueOf(z));
    }

    public final void mo5909e(boolean z) {
        this.f32910h.setValue(this, f32892H[7], Boolean.valueOf(z));
    }

    public final void mo5910f(boolean z) {
        this.f32905c.setValue(this, f32892H[1], Boolean.valueOf(z));
    }

    public final void mo5911g(boolean z) {
        this.f32918p.setValue(this, f32892H[15], Boolean.valueOf(z));
    }

    public final void mo5912h(boolean z) {
        this.f32917o.setValue(this, f32892H[14], Boolean.valueOf(z));
    }

    public DescriptorRendererOptionsImpl() {
        ExcludedTypeAnnotations excludedTypeAnnotations = ExcludedTypeAnnotations.f26036a;
        Set a = ExcludedTypeAnnotations.m27617a();
        ExcludedTypeAnnotations excludedTypeAnnotations2 = ExcludedTypeAnnotations.f26036a;
        this.f32901J = m33446a(SetsKt___SetsKt.m32819a(a, (Iterable) ExcludedTypeAnnotations.m27618b()));
        this.f32902K = m33446a(AnnotationArgumentsRenderingPolicy.f26001a);
        this.f32895C = m33446a(Boolean.valueOf(false));
        this.f32896D = m33446a(Boolean.valueOf(true));
        this.f32897E = m33446a(Boolean.valueOf(true));
        this.f32898F = m33446a(Boolean.valueOf(true));
        this.f32899G = m33446a(Boolean.valueOf(true));
    }

    public final void m33459d() {
        int i = this.f32903a ^ 1;
        if (_Assertions.f25274a && i == 0) {
            throw new AssertionError("Assertion failed");
        }
        this.f32903a = true;
    }

    final <T> ReadWriteProperty<DescriptorRendererOptionsImpl, T> m33446a(T t) {
        Delegates delegates = Delegates.f25296a;
        return new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(t, t, this);
    }
}
