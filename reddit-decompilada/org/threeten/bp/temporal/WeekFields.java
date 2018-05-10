package org.threeten.bp.temporal;

import com.instabug.library.model.State;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Year;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.jdk8.Jdk8Methods;

public final class WeekFields implements Serializable {
    public static final WeekFields f41087a = new WeekFields(DayOfWeek.a, 4);
    public static final WeekFields f41088b = m43208a(DayOfWeek.g, 1);
    private static final ConcurrentMap<String, WeekFields> f41089i = new ConcurrentHashMap(4, 0.75f, 2);
    final DayOfWeek f41090c;
    final int f41091d;
    public final transient TemporalField f41092e = ComputedDayOfField.m43631a(this);
    public final transient TemporalField f41093f = ComputedDayOfField.m43633b(this);
    public final transient TemporalField f41094g = ComputedDayOfField.m43635d(this);
    public final transient TemporalField f41095h = ComputedDayOfField.m43636e(this);
    private final transient TemporalField f41096j = ComputedDayOfField.m43634c(this);

    static class ComputedDayOfField implements TemporalField {
        private static final ValueRange f41536f = ValueRange.m43200a(1, 7);
        private static final ValueRange f41537g = ValueRange.m43201a(0, 4, 6);
        private static final ValueRange f41538h = ValueRange.m43201a(0, 52, 54);
        private static final ValueRange f41539i = ValueRange.m43202b(52, 53);
        private static final ValueRange f41540j = ChronoField.YEAR.f41500E;
        private final String f41541a;
        private final WeekFields f41542b;
        private final TemporalUnit f41543c;
        private final TemporalUnit f41544d;
        private final ValueRange f41545e;

        public final boolean mo7858b() {
            return true;
        }

        public final boolean mo7860c() {
            return false;
        }

        static ComputedDayOfField m43631a(WeekFields weekFields) {
            return new ComputedDayOfField("DayOfWeek", weekFields, ChronoUnit.DAYS, ChronoUnit.WEEKS, f41536f);
        }

        static ComputedDayOfField m43633b(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfMonth", weekFields, ChronoUnit.WEEKS, ChronoUnit.MONTHS, f41537g);
        }

        static ComputedDayOfField m43634c(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfYear", weekFields, ChronoUnit.WEEKS, ChronoUnit.YEARS, f41538h);
        }

        static ComputedDayOfField m43635d(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfWeekBasedYear", weekFields, ChronoUnit.WEEKS, IsoFields.f41074e, f41539i);
        }

        static ComputedDayOfField m43636e(WeekFields weekFields) {
            return new ComputedDayOfField("WeekBasedYear", weekFields, IsoFields.f41074e, ChronoUnit.FOREVER, f41540j);
        }

        private ComputedDayOfField(String str, WeekFields weekFields, TemporalUnit temporalUnit, TemporalUnit temporalUnit2, ValueRange valueRange) {
            this.f41541a = str;
            this.f41542b = weekFields;
            this.f41543c = temporalUnit;
            this.f41544d = temporalUnit2;
            this.f41545e = valueRange;
        }

        public final long mo7859c(TemporalAccessor temporalAccessor) {
            int a = Jdk8Methods.m43163a(temporalAccessor.mo7853c(ChronoField.DAY_OF_WEEK) - (this.f41542b.f41090c.ordinal() + 1)) + 1;
            if (this.f41544d == ChronoUnit.WEEKS) {
                return (long) a;
            }
            int c;
            if (this.f41544d == ChronoUnit.MONTHS) {
                c = temporalAccessor.mo7853c(ChronoField.DAY_OF_MONTH);
                return (long) m43632b(m43629a(c, a), c);
            } else if (this.f41544d == ChronoUnit.YEARS) {
                c = temporalAccessor.mo7853c(ChronoField.DAY_OF_YEAR);
                return (long) m43632b(m43629a(c, a), c);
            } else {
                int i = 365;
                long a2;
                if (this.f41544d == IsoFields.f41074e) {
                    a = Jdk8Methods.m43163a(temporalAccessor.mo7853c(ChronoField.DAY_OF_WEEK) - (this.f41542b.f41090c.ordinal() + 1)) + 1;
                    a2 = m43630a(temporalAccessor, a);
                    if (a2 == 0) {
                        temporalAccessor = ((int) m43630a(Chronology.m43116a(temporalAccessor).mo7847b(temporalAccessor).m44172d(1, ChronoUnit.WEEKS), a)) + 1;
                    } else {
                        if (a2 >= 53) {
                            a = m43629a(temporalAccessor.mo7853c(ChronoField.DAY_OF_YEAR), a);
                            if (Year.a((long) temporalAccessor.mo7853c(ChronoField.YEAR)) != null) {
                                i = 366;
                            }
                            temporalAccessor = m43632b(a, i + this.f41542b.f41091d);
                            if (a2 >= ((long) temporalAccessor)) {
                                temporalAccessor = (int) (a2 - ((long) (temporalAccessor - 1)));
                            }
                        }
                        temporalAccessor = (int) a2;
                    }
                    return (long) temporalAccessor;
                } else if (this.f41544d == ChronoUnit.FOREVER) {
                    a = Jdk8Methods.m43163a(temporalAccessor.mo7853c(ChronoField.DAY_OF_WEEK) - (this.f41542b.f41090c.ordinal() + 1)) + 1;
                    int c2 = temporalAccessor.mo7853c(ChronoField.YEAR);
                    a2 = m43630a(temporalAccessor, a);
                    if (a2 == 0) {
                        c2--;
                    } else if (a2 >= 53) {
                        temporalAccessor = m43629a(temporalAccessor.mo7853c(ChronoField.DAY_OF_YEAR), a);
                        if (Year.a((long) c2)) {
                            i = 366;
                        }
                        if (a2 >= ((long) m43632b(temporalAccessor, i + this.f41542b.f41091d))) {
                            c2++;
                        }
                    }
                    return (long) c2;
                } else {
                    throw new IllegalStateException("unreachable");
                }
            }
        }

        private long m43630a(TemporalAccessor temporalAccessor, int i) {
            int c = temporalAccessor.mo7853c(ChronoField.DAY_OF_YEAR);
            return (long) m43632b(m43629a(c, i), c);
        }

        private int m43629a(int i, int i2) {
            i = Jdk8Methods.m43163a(i - i2);
            return i + 1 > this.f41542b.f41091d ? 7 - i : -i;
        }

        private static int m43632b(int i, int i2) {
            return ((i + 7) + (i2 - 1)) / 7;
        }

        public final <R extends Temporal> R mo7854a(R r, long j) {
            int b = this.f41545e.m43205b(j, (TemporalField) this);
            int c = r.mo7853c(this);
            if (b == c) {
                return r;
            }
            if (this.f41544d != ChronoUnit.FOREVER) {
                return r.mo7934b((long) (b - c), this.f41543c);
            }
            int c2 = r.mo7853c(this.f41542b.f41094g);
            r = r.mo7934b((long) (((double) (j - ((long) c))) * 4632540147608159519L), ChronoUnit.WEEKS);
            if (r.mo7853c(this) > b) {
                r = r.mo7925a((long) r.mo7853c(this.f41542b.f41094g), ChronoUnit.WEEKS);
            } else {
                if (r.mo7853c(this) < b) {
                    r = r.mo7934b(2, ChronoUnit.WEEKS);
                }
                r = r.mo7934b((long) (c2 - r.mo7853c(this.f41542b.f41094g)), ChronoUnit.WEEKS);
                if (r.mo7853c(this) > b) {
                    r = r.mo7925a(1, ChronoUnit.WEEKS);
                }
            }
            return r;
        }

        public final ValueRange mo7855a() {
            return this.f41545e;
        }

        public final boolean mo7856a(TemporalAccessor temporalAccessor) {
            if (temporalAccessor.mo7919a(ChronoField.DAY_OF_WEEK)) {
                if (this.f41544d == ChronoUnit.WEEKS) {
                    return true;
                }
                if (this.f41544d == ChronoUnit.MONTHS) {
                    return temporalAccessor.mo7919a(ChronoField.DAY_OF_MONTH);
                }
                if (this.f41544d == ChronoUnit.YEARS) {
                    return temporalAccessor.mo7919a(ChronoField.DAY_OF_YEAR);
                }
                if (this.f41544d == IsoFields.f41074e) {
                    return temporalAccessor.mo7919a(ChronoField.EPOCH_DAY);
                }
                if (this.f41544d == ChronoUnit.FOREVER) {
                    return temporalAccessor.mo7919a(ChronoField.EPOCH_DAY);
                }
            }
            return null;
        }

        public final ValueRange mo7857b(TemporalAccessor temporalAccessor) {
            if (this.f41544d == ChronoUnit.WEEKS) {
                return this.f41545e;
            }
            TemporalField temporalField;
            if (this.f41544d == ChronoUnit.MONTHS) {
                temporalField = ChronoField.DAY_OF_MONTH;
            } else if (this.f41544d == ChronoUnit.YEARS) {
                temporalField = ChronoField.DAY_OF_YEAR;
            } else if (this.f41544d == IsoFields.f41074e) {
                while (true) {
                    int a = Jdk8Methods.m43163a(temporalAccessor.mo7853c(ChronoField.DAY_OF_WEEK) - (this.f41542b.f41090c.ordinal() + 1)) + 1;
                    long a2 = m43630a(temporalAccessor, a);
                    if (a2 == 0) {
                        temporalAccessor = Chronology.m43116a(temporalAccessor).mo7847b(temporalAccessor).m44172d(2, ChronoUnit.WEEKS);
                    } else {
                        a = m43632b(m43629a(temporalAccessor.mo7853c(ChronoField.DAY_OF_YEAR), a), (Year.a((long) temporalAccessor.mo7853c(ChronoField.YEAR)) ? 366 : 365) + this.f41542b.f41091d);
                        if (a2 < ((long) a)) {
                            return ValueRange.m43200a(1, (long) (a - 1));
                        }
                        temporalAccessor = Chronology.m43116a(temporalAccessor).mo7847b(temporalAccessor).m44173e(2, ChronoUnit.WEEKS);
                    }
                }
            } else if (this.f41544d == ChronoUnit.FOREVER) {
                return temporalAccessor.mo7852b(ChronoField.YEAR);
            } else {
                throw new IllegalStateException("unreachable");
            }
            int a3 = m43629a(temporalAccessor.mo7853c(temporalField), Jdk8Methods.m43163a(temporalAccessor.mo7853c(ChronoField.DAY_OF_WEEK) - (this.f41542b.f41090c.ordinal() + 1)) + 1);
            temporalAccessor = temporalAccessor.mo7852b(temporalField);
            return ValueRange.m43200a((long) m43632b(a3, (int) temporalAccessor.f41083a), (long) m43632b(a3, (int) temporalAccessor.f41086d));
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f41541a);
            stringBuilder.append("[");
            stringBuilder.append(this.f41542b.toString());
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public static WeekFields m43207a(Locale locale) {
        Jdk8Methods.m43168a((Object) locale, State.KEY_LOCALE);
        locale = new GregorianCalendar(new Locale(locale.getLanguage(), locale.getCountry()));
        int firstDayOfWeek = locale.getFirstDayOfWeek();
        return m43208a(DayOfWeek.i[(DayOfWeek.g.ordinal() + (((int) (((long) (firstDayOfWeek - 1)) % 7)) + 7)) % 7], locale.getMinimalDaysInFirstWeek());
    }

    private static WeekFields m43208a(DayOfWeek dayOfWeek, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(dayOfWeek.toString());
        stringBuilder.append(i);
        String stringBuilder2 = stringBuilder.toString();
        WeekFields weekFields = (WeekFields) f41089i.get(stringBuilder2);
        if (weekFields != null) {
            return weekFields;
        }
        f41089i.putIfAbsent(stringBuilder2, new WeekFields(dayOfWeek, i));
        return (WeekFields) f41089i.get(stringBuilder2);
    }

    private WeekFields(DayOfWeek dayOfWeek, int i) {
        Jdk8Methods.m43168a((Object) dayOfWeek, "firstDayOfWeek");
        if (i > 0) {
            if (i <= 7) {
                this.f41090c = dayOfWeek;
                this.f41091d = i;
                return;
            }
        }
        throw new IllegalArgumentException("Minimal number of days is invalid");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WeekFields) && hashCode() == obj.hashCode();
    }

    public final int hashCode() {
        return (this.f41090c.ordinal() * 7) + this.f41091d;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("WeekFields[");
        stringBuilder.append(this.f41090c);
        stringBuilder.append(',');
        stringBuilder.append(this.f41091d);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
