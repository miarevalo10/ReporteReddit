package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.util.UriUtil;

public final class RangedUri {
    public final long f4833a;
    public final long f4834b;
    private final String f4835c;
    private int f4836d;

    public RangedUri(String str, long j, long j2) {
        if (str == null) {
            str = "";
        }
        this.f4835c = str;
        this.f4833a = j;
        this.f4834b = j2;
    }

    public final Uri m4002a(String str) {
        return UriUtil.m4291a(str, this.f4835c);
    }

    private String m4001b(String str) {
        return UriUtil.m4294b(str, this.f4835c);
    }

    public final RangedUri m4003a(RangedUri rangedUri, String str) {
        String b = m4001b(str);
        if (rangedUri != null) {
            if (b.equals(rangedUri.m4001b(str)) != null) {
                long j = -1;
                long j2;
                if (this.f4834b != -1 && this.f4833a + this.f4834b == rangedUri.f4833a) {
                    j2 = this.f4833a;
                    if (rangedUri.f4834b != -1) {
                        j = this.f4834b + rangedUri.f4834b;
                    }
                    return new RangedUri(b, j2, j);
                } else if (rangedUri.f4834b == -1 || rangedUri.f4833a + rangedUri.f4834b != this.f4833a) {
                    return null;
                } else {
                    j2 = rangedUri.f4833a;
                    if (this.f4834b != -1) {
                        j = rangedUri.f4834b + this.f4834b;
                    }
                    return new RangedUri(b, j2, j);
                }
            }
        }
        return null;
    }

    public final int hashCode() {
        if (this.f4836d == 0) {
            this.f4836d = (31 * (((527 + ((int) this.f4833a)) * 31) + ((int) this.f4834b))) + this.f4835c.hashCode();
        }
        return this.f4836d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                RangedUri rangedUri = (RangedUri) obj;
                return this.f4833a == rangedUri.f4833a && this.f4834b == rangedUri.f4834b && this.f4835c.equals(rangedUri.f4835c) != null;
            }
        }
        return false;
    }
}
