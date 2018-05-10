package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: DescriptorRenderer.kt */
public interface DescriptorRendererOptions {

    /* compiled from: DescriptorRenderer.kt */
    public static final class DefaultImpls {
        public static boolean m27598a(DescriptorRendererOptions descriptorRendererOptions) {
            return descriptorRendererOptions.mo5896a().f26005d;
        }

        public static boolean m27599b(DescriptorRendererOptions descriptorRendererOptions) {
            return descriptorRendererOptions.mo5896a().f26006e;
        }
    }

    AnnotationArgumentsRenderingPolicy mo5896a();

    void mo5897a(Set<FqName> set);

    void mo5898a(AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy);

    void mo5899a(ClassifierNamePolicy classifierNamePolicy);

    void mo5900a(ParameterNameRenderingPolicy parameterNameRenderingPolicy);

    void mo5901a(RenderingFormat renderingFormat);

    void mo5902a(boolean z);

    void mo5903b(Set<? extends DescriptorRendererModifier> set);

    void mo5904b(boolean z);

    boolean mo5905b();

    Set<FqName> mo5906c();

    void mo5907c(boolean z);

    void mo5908d(boolean z);

    void mo5909e(boolean z);

    void mo5910f(boolean z);

    void mo5911g(boolean z);

    void mo5912h(boolean z);
}
