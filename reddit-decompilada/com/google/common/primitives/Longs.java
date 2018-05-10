package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class Longs {

    private static class LongArrayAsList extends AbstractList<Long> implements Serializable, RandomAccess {
        final long[] f8524a;
        final int f8525b;
        final int f8526c;

        public boolean isEmpty() {
            return false;
        }

        public /* synthetic */ Object set(int i, Object obj) {
            obj = (Long) obj;
            Preconditions.m6907a(i, size());
            long j = this.f8524a[this.f8525b + i];
            this.f8524a[this.f8525b + i] = ((Long) Preconditions.m6908a(obj)).longValue();
            return Long.valueOf(j);
        }

        LongArrayAsList(long[] jArr) {
            this(jArr, 0, jArr.length);
        }

        private LongArrayAsList(long[] jArr, int i, int i2) {
            this.f8524a = jArr;
            this.f8525b = i;
            this.f8526c = i2;
        }

        public int size() {
            return this.f8526c - this.f8525b;
        }

        public boolean contains(Object obj) {
            return (!(obj instanceof Long) || Longs.m7286a(this.f8524a, ((Long) obj).longValue(), this.f8525b, this.f8526c) == -1) ? null : true;
        }

        public int indexOf(Object obj) {
            if (obj instanceof Long) {
                obj = Longs.m7286a(this.f8524a, ((Long) obj).longValue(), this.f8525b, this.f8526c);
                if (obj >= null) {
                    return obj - this.f8525b;
                }
            }
            return -1;
        }

        public int lastIndexOf(Object obj) {
            if (obj instanceof Long) {
                obj = Longs.m7288b(this.f8524a, ((Long) obj).longValue(), this.f8525b, this.f8526c);
                if (obj >= null) {
                    return obj - this.f8525b;
                }
            }
            return -1;
        }

        public List<Long> subList(int i, int i2) {
            Preconditions.m6912a(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            return new LongArrayAsList(this.f8524a, this.f8525b + i, this.f8525b + i2);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LongArrayAsList)) {
                return super.equals(obj);
            }
            LongArrayAsList longArrayAsList = (LongArrayAsList) obj;
            int size = size();
            if (longArrayAsList.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.f8524a[this.f8525b + i] != longArrayAsList.f8524a[longArrayAsList.f8525b + i]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 1;
            for (int i2 = this.f8525b; i2 < this.f8526c; i2++) {
                i = Longs.m7285a(this.f8524a[i2]) + (31 * i);
            }
            return i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(size() * 10);
            stringBuilder.append('[');
            stringBuilder.append(this.f8524a[this.f8525b]);
            int i = this.f8525b;
            while (true) {
                i++;
                if (i < this.f8526c) {
                    stringBuilder.append(", ");
                    stringBuilder.append(this.f8524a[i]);
                } else {
                    stringBuilder.append(']');
                    return stringBuilder.toString();
                }
            }
        }

        public /* synthetic */ Object get(int i) {
            Preconditions.m6907a(i, size());
            return Long.valueOf(this.f8524a[this.f8525b + i]);
        }
    }

    public static int m7285a(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static List<Long> m7287a(long... jArr) {
        if (jArr.length == 0) {
            return Collections.emptyList();
        }
        return new LongArrayAsList(jArr);
    }

    static /* synthetic */ int m7286a(long[] jArr, long j, int i, int i2) {
        while (i < i2) {
            if (jArr[i] == j) {
                return i;
            }
            i++;
        }
        return -1;
    }

    static /* synthetic */ int m7288b(long[] jArr, long j, int i, int i2) {
        for (i2--; i2 >= i; i2--) {
            if (jArr[i2] == j) {
                return i2;
            }
        }
        return -1;
    }
}
