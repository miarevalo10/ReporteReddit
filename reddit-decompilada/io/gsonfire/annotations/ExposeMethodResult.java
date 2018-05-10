package io.gsonfire.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExposeMethodResult {

    public enum ConflictResolutionStrategy {
        OVERWRITE,
        SKIP
    }

    String m26455a();

    ConflictResolutionStrategy m26456b() default ConflictResolutionStrategy.OVERWRITE;
}
