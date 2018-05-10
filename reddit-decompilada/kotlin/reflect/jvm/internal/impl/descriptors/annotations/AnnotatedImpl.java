package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

public abstract class AnnotatedImpl implements Annotated {
    private final Annotations f32639a;

    public AnnotatedImpl(Annotations annotations) {
        if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl", "<init>"}));
        } else {
            this.f32639a = annotations;
        }
    }

    public Annotations mo5718q() {
        Annotations annotations = this.f32639a;
        if (annotations != null) {
            return annotations;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl", "getAnnotations"}));
    }
}
