package org.threeten.bp.jdk8;

import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalUnit;

public abstract class DefaultInterfaceTemporal extends DefaultInterfaceTemporalAccessor implements Temporal {
    public Temporal mo7926a(TemporalAdjuster temporalAdjuster) {
        return temporalAdjuster.mo7863a(this);
    }

    public Temporal mo7925a(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? mo7934b(Long.MAX_VALUE, temporalUnit).mo7934b(1, temporalUnit) : mo7934b(-j, temporalUnit);
    }
}
