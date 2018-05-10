package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

public abstract class Representation {
    public final String f4837a;
    public final long f4838b;
    public final Format f4839c;
    public final String f4840d;
    public final long f4841e;
    public final List<Descriptor> f4842f;
    public final RangedUri f4843g;

    public static class MultiSegmentRepresentation extends Representation implements DashSegmentIndex {
        private final MultiSegmentBase f13384h;

        public final RangedUri mo1431c() {
            return null;
        }

        public final DashSegmentIndex mo1432d() {
            return this;
        }

        public final String mo1433e() {
            return null;
        }

        public MultiSegmentRepresentation(String str, Format format, String str2, MultiSegmentBase multiSegmentBase, List<Descriptor> list) {
            super(str, format, str2, multiSegmentBase, list);
            this.f13384h = multiSegmentBase;
        }

        public final RangedUri mo1428b(int i) {
            return this.f13384h.mo3365a(this, i);
        }

        public final int mo1425a(long j, long j2) {
            MultiSegmentBase multiSegmentBase = this.f13384h;
            int i = multiSegmentBase.f13390d;
            j2 = multiSegmentBase.mo3364a(j2);
            if (j2 == null) {
                return i;
            }
            int i2;
            if (multiSegmentBase.f13392f == null) {
                i2 = multiSegmentBase.f13390d + ((int) (j / ((multiSegmentBase.f13391e * 1000000) / multiSegmentBase.b)));
                if (i2 < i) {
                    return i;
                }
                if (j2 == -1) {
                    return i2;
                }
                return Math.min(i2, (i + j2) - 1);
            }
            i2 = (j2 + i) - 1;
            j2 = i;
            while (j2 <= i2) {
                int i3 = ((i2 - j2) / 2) + j2;
                int i4 = (multiSegmentBase.m12479a(i3) > j ? 1 : (multiSegmentBase.m12479a(i3) == j ? 0 : -1));
                if (i4 < 0) {
                    j2 = i3 + 1;
                } else if (i4 <= 0) {
                    return i3;
                } else {
                    i2 = i3 - 1;
                }
            }
            return j2 == i ? j2 : i2;
        }

        public final long mo1426a(int i) {
            return this.f13384h.m12479a(i);
        }

        public final long mo1427a(int i, long j) {
            MultiSegmentBase multiSegmentBase = this.f13384h;
            if (multiSegmentBase.f13392f != null) {
                return (((SegmentTimelineElement) multiSegmentBase.f13392f.get(i - multiSegmentBase.f13390d)).f4845b * 1000000) / multiSegmentBase.b;
            }
            int a = multiSegmentBase.mo3364a(j);
            return (a == -1 || i != (multiSegmentBase.f13390d + a) - 1) ? (multiSegmentBase.f13391e * 1000000) / multiSegmentBase.b : j - multiSegmentBase.m12479a(i);
        }

        public final int mo1423a() {
            return this.f13384h.f13390d;
        }

        public final int mo1424a(long j) {
            return this.f13384h.mo3364a(j);
        }

        public final boolean mo1429b() {
            return this.f13384h.mo3366a();
        }
    }

    public static class SingleSegmentRepresentation extends Representation {
        public final Uri f13385h;
        public final long f13386i;
        private final String f13387j;
        private final RangedUri f13388k;
        private final SingleSegmentIndex f13389l;

        public SingleSegmentRepresentation(String str, Format format, String str2, SingleSegmentBase singleSegmentBase, List<Descriptor> list) {
            super(str, format, str2, singleSegmentBase, list);
            this.f13385h = Uri.parse(str2);
            list = null;
            if (singleSegmentBase.f13394e <= 0) {
                str2 = null;
            } else {
                String rangedUri = new RangedUri(null, singleSegmentBase.f13393d, singleSegmentBase.f13394e);
            }
            this.f13388k = str2;
            if (str != null) {
                str2 = new StringBuilder();
                str2.append(str);
                str2.append(".");
                str2.append(format.f4013a);
                str2.append(".-1");
                str = str2.toString();
            } else {
                str = null;
            }
            this.f13387j = str;
            this.f13386i = -1;
            if (this.f13388k == null) {
                list = new SingleSegmentIndex(new RangedUri(null, 0, -1));
            }
            this.f13389l = list;
        }

        public final RangedUri mo1431c() {
            return this.f13388k;
        }

        public final DashSegmentIndex mo1432d() {
            return this.f13389l;
        }

        public final String mo1433e() {
            return this.f13387j;
        }
    }

    public abstract RangedUri mo1431c();

    public abstract DashSegmentIndex mo1432d();

    public abstract String mo1433e();

    private Representation(String str, Format format, String str2, SegmentBase segmentBase, List<Descriptor> list) {
        this.f4837a = str;
        this.f4838b = -1;
        this.f4839c = format;
        this.f4840d = str2;
        if (list == null) {
            str = Collections.emptyList();
        } else {
            str = Collections.unmodifiableList(list);
        }
        this.f4842f = str;
        this.f4843g = segmentBase.mo3367a(this);
        this.f4841e = Util.m4303a(segmentBase.f4848c, 1000000, segmentBase.f4847b);
    }

    public static Representation m4004a(String str, Format format, String str2, SegmentBase segmentBase, List<Descriptor> list) {
        if (segmentBase instanceof SingleSegmentBase) {
            return new SingleSegmentRepresentation(str, format, str2, (SingleSegmentBase) segmentBase, list);
        } else if (segmentBase instanceof MultiSegmentBase) {
            return new MultiSegmentRepresentation(str, format, str2, (MultiSegmentBase) segmentBase, list);
        } else {
            throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
        }
    }
}
