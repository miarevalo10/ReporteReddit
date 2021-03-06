package io.gsonfire.annotations;

import io.gsonfire.gson.ExclusionByValueStrategy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcludeByValue {
    Class<? extends ExclusionByValueStrategy> m26454a();
}
