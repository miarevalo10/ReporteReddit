package com.birbit.android.jobqueue.persistentQueue.sqlite;

import android.support.v4.util.LruCache;
import com.birbit.android.jobqueue.Constraint;
import com.birbit.android.jobqueue.TagConstraint;

class WhereQueryCache {
    final LruCache<Long, Where> f3073a = new C10471(this);
    final String f3074b;

    class C10471 extends LruCache<Long, Where> {
        final /* synthetic */ WhereQueryCache f12217a;

        C10471(WhereQueryCache whereQueryCache) {
            this.f12217a = whereQueryCache;
            super(15);
        }

        protected /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
            Where where = (Where) obj2;
            if (where.f3069d) {
                where.f3069d.close();
                where.f3069d = null;
            }
            if (where.f3071f) {
                where.f3071f.close();
                where.f3071f = null;
            }
        }
    }

    public WhereQueryCache(long j) {
        this.f3074b = Long.toString(j);
    }

    static Where m2590a(long j, Constraint constraint, StringBuilder stringBuilder) {
        int i;
        stringBuilder.setLength(0);
        stringBuilder.append("( (");
        stringBuilder.append(DbOpenHelper.f3024j.f3038a);
        stringBuilder.append(" != ");
        stringBuilder.append(Where.f3065i);
        stringBuilder.append(" AND ");
        stringBuilder.append(DbOpenHelper.f3024j.f3038a);
        stringBuilder.append(" <= ?) OR ");
        stringBuilder.append(DbOpenHelper.f3023i.f3038a);
        stringBuilder.append(" <= ?)");
        stringBuilder.append(" AND (");
        stringBuilder.append(DbOpenHelper.f3026l.f3038a);
        stringBuilder.append(" IS NULL OR ");
        stringBuilder.append(DbOpenHelper.f3026l.f3038a);
        stringBuilder.append(" != 1)");
        if (constraint.f2854g != null) {
            stringBuilder.append(" AND ");
            stringBuilder.append(DbOpenHelper.f3021g.f3038a);
            stringBuilder.append(" <= ?");
            i = 3;
        } else {
            i = 2;
        }
        if (constraint.f2849b != null) {
            if (constraint.f2850c.isEmpty()) {
                stringBuilder.append(" AND 0 ");
            } else {
                stringBuilder.append(" AND ");
                stringBuilder.append(DbOpenHelper.f3016b.f3038a);
                stringBuilder.append(" IN ( SELECT ");
                stringBuilder.append(DbOpenHelper.f3028n.f3038a);
                stringBuilder.append(" FROM job_holder_tags WHERE ");
                stringBuilder.append(DbOpenHelper.f3029o.f3038a);
                stringBuilder.append(" IN (");
                SqlHelper.m2584a(stringBuilder, constraint.f2850c.size());
                stringBuilder.append(")");
                if (constraint.f2849b == TagConstraint.ANY) {
                    stringBuilder.append(")");
                } else if (constraint.f2849b == TagConstraint.ALL) {
                    stringBuilder.append(" GROUP BY (`");
                    stringBuilder.append(DbOpenHelper.f3028n.f3038a);
                    stringBuilder.append("`) HAVING count(*) = ");
                    stringBuilder.append(constraint.f2850c.size());
                    stringBuilder.append(")");
                } else {
                    StringBuilder stringBuilder2 = new StringBuilder("unknown constraint ");
                    stringBuilder2.append(constraint);
                    throw new IllegalArgumentException(stringBuilder2.toString());
                }
                i += constraint.f2850c.size();
            }
        }
        if (!constraint.f2851d.isEmpty()) {
            stringBuilder.append(" AND (");
            stringBuilder.append(DbOpenHelper.f3018d.f3038a);
            stringBuilder.append(" IS NULL OR ");
            stringBuilder.append(DbOpenHelper.f3018d.f3038a);
            stringBuilder.append(" NOT IN(");
            SqlHelper.m2584a(stringBuilder, constraint.f2851d.size());
            stringBuilder.append("))");
            i += constraint.f2851d.size();
        }
        if (!constraint.f2852e.isEmpty()) {
            stringBuilder.append(" AND ");
            stringBuilder.append(DbOpenHelper.f3016b.f3038a);
            stringBuilder.append(" NOT IN(");
            SqlHelper.m2584a(stringBuilder, constraint.f2852e.size());
            stringBuilder.append(")");
            i += constraint.f2852e.size();
        }
        if (constraint.f2853f != null) {
            stringBuilder.append(" AND ");
            stringBuilder.append(DbOpenHelper.f3022h.f3038a);
            stringBuilder.append(" != ?");
            i++;
        }
        return new Where(j, stringBuilder.toString(), new String[i]);
    }

    static boolean m2591a(Constraint constraint) {
        return (constraint.f2850c.size() >= 64 || constraint.f2851d.size() >= 64 || constraint.f2852e.size() >= 64) ? null : true;
    }

    static long m2592b(Constraint constraint) {
        int i;
        if (constraint.f2849b == null) {
            i = 2;
        } else {
            i = constraint.f2849b.ordinal();
        }
        int i2 = 0;
        i = ((((i << 0) | (constraint.f2850c.size() << 2)) | (constraint.f2851d.size() << 8)) | (constraint.f2852e.size() << 14)) | (constraint.f2853f << 20);
        if (constraint.f2854g == null) {
            i2 = 1;
        }
        return (long) ((i2 << 21) | i);
    }
}
