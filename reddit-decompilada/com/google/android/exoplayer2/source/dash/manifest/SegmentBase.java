package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.util.Util;
import java.util.List;

public abstract class SegmentBase {
    final RangedUri f4846a;
    final long f4847b;
    final long f4848c;

    public static class SegmentTimelineElement {
        final long f4844a;
        final long f4845b;

        public SegmentTimelineElement(long j, long j2) {
            this.f4844a = j;
            this.f4845b = j2;
        }
    }

    public static abstract class MultiSegmentBase extends SegmentBase {
        final int f13390d;
        final long f13391e;
        final List<SegmentTimelineElement> f13392f;

        public abstract int mo3364a(long j);

        public abstract RangedUri mo3365a(Representation representation, int i);

        public MultiSegmentBase(RangedUri rangedUri, long j, long j2, int i, long j3, List<SegmentTimelineElement> list) {
            super(rangedUri, j, j2);
            this.f13390d = i;
            this.f13391e = j3;
            this.f13392f = list;
        }

        public final long m12479a(int i) {
            long j;
            if (this.f13392f != null) {
                j = ((SegmentTimelineElement) this.f13392f.get(i - this.f13390d)).f4844a - this.c;
            } else {
                j = ((long) (i - this.f13390d)) * this.f13391e;
            }
            return Util.m4303a(j, 1000000, this.b);
        }

        public boolean mo3366a() {
            return this.f13392f != null;
        }
    }

    public static class SingleSegmentBase extends SegmentBase {
        final long f13393d;
        final long f13394e;

        public SingleSegmentBase(RangedUri rangedUri, long j, long j2, long j3, long j4) {
            super(rangedUri, j, j2);
            this.f13393d = j3;
            this.f13394e = j4;
        }

        public SingleSegmentBase() {
            this(null, 1, 0, 0, 0);
        }
    }

    public static class SegmentList extends MultiSegmentBase {
        final List<RangedUri> f16993g;

        public final boolean mo3366a() {
            return true;
        }

        public SegmentList(RangedUri rangedUri, long j, long j2, int i, long j3, List<SegmentTimelineElement> list, List<RangedUri> list2) {
            super(rangedUri, j, j2, i, j3, list);
            this.f16993g = list2;
        }

        public final RangedUri mo3365a(Representation representation, int i) {
            return (RangedUri) this.f16993g.get(i - this.d);
        }

        public final int mo3364a(long j) {
            return this.f16993g.size();
        }
    }

    public static class SegmentTemplate extends MultiSegmentBase {
        final UrlTemplate f16994g;
        final UrlTemplate f16995h;

        public SegmentTemplate(RangedUri rangedUri, long j, long j2, int i, long j3, List<SegmentTimelineElement> list, UrlTemplate urlTemplate, UrlTemplate urlTemplate2) {
            super(rangedUri, j, j2, i, j3, list);
            this.f16994g = urlTemplate;
            this.f16995h = urlTemplate2;
        }

        public final RangedUri mo3367a(Representation representation) {
            if (this.f16994g != null) {
                return new RangedUri(this.f16994g.m4010a(representation.f4839c.f4013a, 0, representation.f4839c.f4014b, 0), 0, -1);
            }
            return super.mo3367a(representation);
        }

        public final RangedUri mo3365a(Representation representation, int i) {
            long j;
            Representation representation2 = representation;
            if (this.f != null) {
                j = ((SegmentTimelineElement) r0.f.get(i - r0.d)).f4844a;
            } else {
                j = ((long) (i - r0.d)) * r0.e;
            }
            long j2 = j;
            return new RangedUri(r0.f16995h.m4010a(representation2.f4839c.f4013a, i, representation2.f4839c.f4014b, j2), 0, -1);
        }

        public final int mo3364a(long j) {
            if (this.f != null) {
                return this.f.size();
            }
            return j != -9223372036854775807L ? (int) Util.m4302a(j, (this.e * 1000000) / this.b) : -1;
        }
    }

    public SegmentBase(RangedUri rangedUri, long j, long j2) {
        this.f4846a = rangedUri;
        this.f4847b = j;
        this.f4848c = j2;
    }

    public RangedUri mo3367a(Representation representation) {
        return this.f4846a;
    }
}
