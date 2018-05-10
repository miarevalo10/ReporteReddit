package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.Pair;

/* compiled from: VarianceChecker.kt */
public interface TypeHolder<D extends TypeHolder<? extends D>> {
    Pair<D, D> mo5845a();

    List<TypeHolderArgument<D>> mo5846b();

    KotlinType mo5847c();
}
