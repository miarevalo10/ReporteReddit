package com.reddit.data.events;

import com.reddit.data.events.models.Event;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlin.text.Regex;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/reddit/data/events/AnalyticsValidator;", "", "()V", "RANGE_TIMESTAMP", "Lkotlin/ranges/LongRange;", "REGEX_FULLNAME", "Lkotlin/text/Regex;", "REGEX_STRINGLOWER", "validate", "", "event", "Lcom/reddit/data/events/models/Event;", "verify", "expression", "", "errorMessage", "", "events_release"}, k = 1, mv = {1, 1, 9})
/* compiled from: AnalyticsValidator.kt */
public final class AnalyticsValidator {
    public static final AnalyticsValidator f10285a = new AnalyticsValidator();
    private static final Regex f10286b = new Regex("^t[0-9]_[a-z0-9]+$");
    private static final Regex f10287c = new Regex("^[-_a-z0-9]+$");
    private static final LongRange f10288d = new LongRange(1104537600000L, 1735689600000L);

    public static final void m8742a(Event event) {
        Intrinsics.b(event, "event");
    }

    private AnalyticsValidator() {
    }
}
