package org.threeten.bp.temporal;

public interface TemporalAccessor {
    <R> R mo7851a(TemporalQuery<R> temporalQuery);

    boolean mo7919a(TemporalField temporalField);

    ValueRange mo7852b(TemporalField temporalField);

    int mo7853c(TemporalField temporalField);

    long mo7920d(TemporalField temporalField);
}
