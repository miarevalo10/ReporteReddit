package com.reddit.frontpage.commons;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.reddit.datalibrary.frontpage.requests.models.v1.Kind;
import com.reddit.frontpage.C1761R;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public class Sorting {
    private static final SparseArray<String> f19940a = new C17671();
    private static final Map<String, Integer> f19941b = new C17682();
    private static final SparseArray<String> f19942c = new C17693();
    private static final Map<String, Integer> f19943d = ImmutableMap.b().a("hour", Integer.valueOf(0)).a("day", Integer.valueOf(1)).a("week", Integer.valueOf(2)).a("month", Integer.valueOf(3)).a("year", Integer.valueOf(4)).a("all", Integer.valueOf(5)).a();
    private static final SparseBooleanArray f19944e = new C17704();
    private static final Map<Integer, Integer> f19945f = new Builder().a(Integer.valueOf(16), Integer.valueOf(C1761R.string.label_sort_best_posts)).a(Integer.valueOf(2), Integer.valueOf(C1761R.string.label_sort_hot_posts)).a(Integer.valueOf(1), Integer.valueOf(C1761R.string.label_sort_new_posts)).a(Integer.valueOf(3), Integer.valueOf(C1761R.string.label_sort_top_posts)).a(Integer.valueOf(6), Integer.valueOf(C1761R.string.label_sort_controversial_posts)).a();
    private static final Map<Integer, Integer> f19946g = new Builder().a(Integer.valueOf(8), Integer.valueOf(C1761R.string.label_sort_best_comments)).a(Integer.valueOf(9), Integer.valueOf(C1761R.string.label_sort_live_comments)).a(Integer.valueOf(1), Integer.valueOf(C1761R.string.label_sort_new_comments)).a(Integer.valueOf(3), Integer.valueOf(C1761R.string.label_sort_top_comments)).a(Integer.valueOf(6), Integer.valueOf(C1761R.string.label_sort_controversial_comments)).a(Integer.valueOf(5), Integer.valueOf(C1761R.string.label_sort_qa_comments)).a(Integer.valueOf(7), Integer.valueOf(C1761R.string.label_sort_old_comments)).a();
    private static final SparseIntArray f19947h = new C17715();
    private static final Map<Integer, Integer> f19948i = new Builder().a(Integer.valueOf(2), Integer.valueOf(C1761R.drawable.ic_icon_sort_hot)).a(Integer.valueOf(16), Integer.valueOf(C1761R.drawable.ic_icon_sort_best)).a(Integer.valueOf(0), Integer.valueOf(C1761R.drawable.ic_icon_sort_best)).a(Integer.valueOf(8), Integer.valueOf(C1761R.drawable.ic_icon_sort_hot)).a(Integer.valueOf(1), Integer.valueOf(C1761R.drawable.ic_icon_sort_new)).a(Integer.valueOf(9), Integer.valueOf(C1761R.drawable.ic_icon_sort_new)).a(Integer.valueOf(3), Integer.valueOf(C1761R.drawable.ic_icon_sort_top)).a(Integer.valueOf(6), Integer.valueOf(C1761R.drawable.ic_icon_sort_controversial)).a(Integer.valueOf(5), Integer.valueOf(C1761R.drawable.ic_icon_sort_qa)).a(Integer.valueOf(7), Integer.valueOf(C1761R.drawable.ic_icon_sort_recent)).a(Integer.valueOf(4), Integer.valueOf(C1761R.drawable.ic_icon_comments)).a();

    static class C17671 extends SparseArray<String> {
        C17671() {
            put(0, "relevance");
            put(16, "best");
            put(1, "new");
            put(2, "hot");
            put(3, "top");
            put(4, "comments");
            put(5, "qa");
            put(6, "controversial");
            put(7, "old");
            put(8, "confidence");
            put(9, Kind.LIVE);
        }
    }

    static class C17682 extends HashMap<String, Integer> {
        C17682() {
            put("confidence", Integer.valueOf(8));
            put("new", Integer.valueOf(1));
            put("hot", Integer.valueOf(2));
            put("top", Integer.valueOf(3));
            put("qa", Integer.valueOf(5));
            put("controversial", Integer.valueOf(6));
            put("old", Integer.valueOf(7));
            put("best", Integer.valueOf(16));
            put("relevance", Integer.valueOf(0));
            put(Kind.LIVE, Integer.valueOf(9));
        }
    }

    static class C17693 extends SparseArray<String> {
        C17693() {
            put(0, "hour");
            put(1, "day");
            put(2, "week");
            put(3, "month");
            put(4, "year");
            put(5, "all");
        }
    }

    static class C17704 extends SparseBooleanArray {
        C17704() {
            put(3, true);
            put(4, true);
            put(6, true);
        }
    }

    static class C17715 extends SparseIntArray {
        C17715() {
            put(0, C1761R.string.label_past_hour);
            put(1, C1761R.string.label_past_24_hours);
            put(2, C1761R.string.label_past_week);
            put(3, C1761R.string.label_past_month);
            put(4, C1761R.string.label_past_year);
            put(5, C1761R.string.label_all_time);
        }
    }

    public static String m21806a(int i) {
        return (String) f19940a.get(i);
    }

    public static int m21805a(String str) {
        return f19941b.containsKey(str) ? ((Integer) f19941b.get(str)).intValue() : null;
    }

    public static int m21808b(String str) {
        return str == null ? -1 : ((Integer) f19943d.get(str)).intValue();
    }

    public static int m21807b(int i) {
        Integer num = (Integer) f19945f.get(Integer.valueOf(i));
        return num != null ? num.intValue() : C1761R.string.label_sort_hot_posts;
    }

    public static int m21809c(int i) {
        Integer num = (Integer) f19946g.get(Integer.valueOf(i));
        return num != null ? num.intValue() : C1761R.string.label_sort_best_comments;
    }

    public static String m21810d(int i) {
        return (String) f19942c.get(i);
    }

    public static int m21811e(int i) {
        return f19947h.get(i);
    }

    public static boolean m21812f(int i) {
        return f19944e.get(i);
    }

    public static int m21813g(int i) {
        Integer num = (Integer) f19948i.get(Integer.valueOf(i));
        return num != null ? num.intValue() : C1761R.drawable.ic_icon_sort;
    }
}
