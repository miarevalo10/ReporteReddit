package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.Format;
import java.util.Collections;
import java.util.List;

public final class HlsMasterPlaylist extends HlsPlaylist {
    public final List<HlsUrl> f13447a;
    public final List<HlsUrl> f13448b;
    public final List<HlsUrl> f13449c;
    public final Format f13450d;
    public final List<Format> f13451e;

    public static final class HlsUrl {
        public final String f4879a;
        public final Format f4880b;

        public static HlsUrl m4014a(String str) {
            return new HlsUrl(str, Format.m3568a("0", "application/x-mpegURL", null, null, -1, 0, null));
        }

        public HlsUrl(String str, Format format) {
            this.f4879a = str;
            this.f4880b = format;
        }
    }

    public HlsMasterPlaylist(String str, List<String> list, List<HlsUrl> list2, List<HlsUrl> list3, List<HlsUrl> list4, Format format, List<Format> list5) {
        super(str, list);
        this.f13447a = Collections.unmodifiableList(list2);
        this.f13448b = Collections.unmodifiableList(list3);
        this.f13449c = Collections.unmodifiableList(list4);
        this.f13450d = format;
        this.f13451e = list5 != null ? Collections.unmodifiableList(list5) : null;
    }

    public static HlsMasterPlaylist m12534a(String str) {
        List singletonList = Collections.singletonList(HlsUrl.m4014a(str));
        List emptyList = Collections.emptyList();
        return new HlsMasterPlaylist(null, Collections.emptyList(), singletonList, emptyList, emptyList, null, null);
    }
}
