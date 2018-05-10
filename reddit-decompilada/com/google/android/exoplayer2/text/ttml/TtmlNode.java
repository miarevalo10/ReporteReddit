package com.google.android.exoplayer2.text.ttml;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

final class TtmlNode {
    public final String f5050a;
    public final String f5051b;
    public final boolean f5052c;
    public final long f5053d;
    public final long f5054e;
    public final TtmlStyle f5055f;
    public final String f5056g;
    private final String[] f5057h;
    private final HashMap<String, Integer> f5058i;
    private final HashMap<String, Integer> f5059j;
    private List<TtmlNode> f5060k;

    public static TtmlNode m4079a(String str) {
        return new TtmlNode(null, TtmlRenderUtil.m4088a(str), -9223372036854775807L, -9223372036854775807L, null, null, "");
    }

    public static TtmlNode m4080a(String str, long j, long j2, TtmlStyle ttmlStyle, String[] strArr, String str2) {
        return new TtmlNode(str, null, j, j2, ttmlStyle, strArr, str2);
    }

    private TtmlNode(String str, String str2, long j, long j2, TtmlStyle ttmlStyle, String[] strArr, String str3) {
        this.f5050a = str;
        this.f5051b = str2;
        this.f5055f = ttmlStyle;
        this.f5057h = strArr;
        this.f5052c = str2 != null ? true : null;
        this.f5053d = j;
        this.f5054e = j2;
        this.f5056g = (String) Assertions.m4182a((Object) str3);
        this.f5058i = new HashMap();
        this.f5059j = new HashMap();
    }

    public final void m4084a(TtmlNode ttmlNode) {
        if (this.f5060k == null) {
            this.f5060k = new ArrayList();
        }
        this.f5060k.add(ttmlNode);
    }

    private TtmlNode m4078a(int i) {
        if (this.f5060k != null) {
            return (TtmlNode) this.f5060k.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    private int m4082b() {
        return this.f5060k == null ? 0 : this.f5060k.size();
    }

    public final long[] m4086a() {
        TreeSet treeSet = new TreeSet();
        int i = 0;
        m4081a(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            int i2 = i + 1;
            jArr[i] = ((Long) it.next()).longValue();
            i = i2;
        }
        return jArr;
    }

    private void m4081a(TreeSet<Long> treeSet, boolean z) {
        boolean equals = "p".equals(this.f5050a);
        if (z || equals) {
            if (this.f5053d != -9223372036854775807L) {
                treeSet.add(Long.valueOf(this.f5053d));
            }
            if (this.f5054e != -9223372036854775807L) {
                treeSet.add(Long.valueOf(this.f5054e));
            }
        }
        if (this.f5060k != null) {
            for (int i = 0; i < this.f5060k.size(); i++) {
                boolean z2;
                TtmlNode ttmlNode = (TtmlNode) this.f5060k.get(i);
                if (!z) {
                    if (!equals) {
                        z2 = false;
                        ttmlNode.m4081a((TreeSet) treeSet, z2);
                    }
                }
                z2 = true;
                ttmlNode.m4081a((TreeSet) treeSet, z2);
            }
        }
    }

    final void m4083a(long j, boolean z, String str, Map<String, SpannableStringBuilder> map) {
        this.f5058i.clear();
        this.f5059j.clear();
        String str2 = this.f5056g;
        if (!"".equals(str2)) {
            str = str2;
        }
        if (this.f5052c && z) {
            m4077a(str, (Map) map).append(this.f5051b);
        } else if ("br".equals(this.f5050a) && z) {
            m4077a(str, (Map) map).append('\n');
        } else {
            if (!"metadata".equals(this.f5050a)) {
                Object obj = (!(this.f5053d == -9223372036854775807L && this.f5054e == -9223372036854775807L) && ((this.f5053d > j || this.f5054e != -9223372036854775807L) && ((this.f5053d != -9223372036854775807L || j >= this.f5054e) && (this.f5053d > j || j >= this.f5054e)))) ? null : 1;
                if (obj != null) {
                    boolean equals = "p".equals(this.f5050a);
                    for (Entry entry : map.entrySet()) {
                        this.f5058i.put(entry.getKey(), Integer.valueOf(((SpannableStringBuilder) entry.getValue()).length()));
                    }
                    for (int i = 0; i < m4082b(); i++) {
                        boolean z2;
                        TtmlNode a = m4078a(i);
                        if (!z) {
                            if (!equals) {
                                z2 = false;
                                a.m4083a(j, z2, str, map);
                            }
                        }
                        z2 = true;
                        a.m4083a(j, z2, str, map);
                    }
                    if (equals) {
                        TtmlRenderUtil.m4089a(m4077a(str, (Map) map));
                    }
                    for (Entry entry2 : map.entrySet()) {
                        this.f5059j.put(entry2.getKey(), Integer.valueOf(((SpannableStringBuilder) entry2.getValue()).length()));
                    }
                }
            }
        }
    }

    private static SpannableStringBuilder m4077a(String str, Map<String, SpannableStringBuilder> map) {
        if (!map.containsKey(str)) {
            map.put(str, new SpannableStringBuilder());
        }
        return (SpannableStringBuilder) map.get(str);
    }

    final void m4085a(Map<String, TtmlStyle> map, Map<String, SpannableStringBuilder> map2) {
        for (Entry entry : this.f5059j.entrySet()) {
            String str = (String) entry.getKey();
            int i = 0;
            int intValue = this.f5058i.containsKey(str) ? ((Integer) this.f5058i.get(str)).intValue() : 0;
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) map2.get(str);
            int intValue2 = ((Integer) entry.getValue()).intValue();
            if (intValue != intValue2) {
                TtmlStyle a = TtmlRenderUtil.m4087a(this.f5055f, this.f5057h, map);
                if (a != null) {
                    TtmlRenderUtil.m4090a(spannableStringBuilder, intValue, intValue2, a);
                }
            }
            while (i < m4082b()) {
                m4078a(i).m4085a((Map) map, (Map) map2);
                i++;
            }
        }
    }

    static SpannableStringBuilder m4076a(SpannableStringBuilder spannableStringBuilder) {
        int i;
        int i2 = 0;
        int length = spannableStringBuilder.length();
        for (i = 0; i < length; i++) {
            if (spannableStringBuilder.charAt(i) == ' ') {
                int i3 = i + 1;
                int i4 = i3;
                while (i4 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i4) == ' ') {
                    i4++;
                }
                i4 -= i3;
                if (i4 > 0) {
                    spannableStringBuilder.delete(i, i + i4);
                    length -= i4;
                }
            }
        }
        if (length > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
            length--;
        }
        i = 0;
        while (true) {
            i3 = length - 1;
            if (i >= i3) {
                break;
            }
            if (spannableStringBuilder.charAt(i) == '\n') {
                i3 = i + 1;
                if (spannableStringBuilder.charAt(i3) == ' ') {
                    spannableStringBuilder.delete(i3, i + 2);
                    length--;
                }
            }
            i++;
        }
        if (length > 0 && spannableStringBuilder.charAt(i3) == ' ') {
            spannableStringBuilder.delete(i3, length);
            length--;
        }
        while (true) {
            i = length - 1;
            if (i2 >= i) {
                break;
            }
            if (spannableStringBuilder.charAt(i2) == ' ') {
                i = i2 + 1;
                if (spannableStringBuilder.charAt(i) == '\n') {
                    spannableStringBuilder.delete(i2, i);
                    length--;
                }
            }
            i2++;
        }
        if (length > 0 && spannableStringBuilder.charAt(i) == '\n') {
            spannableStringBuilder.delete(i, length);
        }
        return spannableStringBuilder;
    }
}
