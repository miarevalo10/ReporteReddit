package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.C0377C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener.EventDispatcher;
import com.google.android.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader.Callback;
import com.google.android.exoplayer2.upstream.Loader.Loadable;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.UriUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

public final class HlsPlaylistTracker implements Callback<ParsingLoadable<HlsPlaylist>> {
    public final Uri f13499a;
    public final HlsDataSourceFactory f13500b;
    public final HlsPlaylistParser f13501c = new HlsPlaylistParser();
    public final int f13502d;
    public final IdentityHashMap<HlsUrl, MediaPlaylistBundle> f13503e = new IdentityHashMap();
    public final Handler f13504f = new Handler();
    public final List<PlaylistEventListener> f13505g = new ArrayList();
    public final Loader f13506h = new Loader("HlsPlaylistTracker:MasterPlaylist");
    public HlsMasterPlaylist f13507i;
    public HlsUrl f13508j;
    public boolean f13509k;
    private final PrimaryPlaylistListener f13510l;
    private final EventDispatcher f13511m;
    private HlsMediaPlaylist f13512n;

    public interface PlaylistEventListener {
        void mo3373b(HlsUrl hlsUrl);

        void mo3375g();
    }

    public static final class PlaylistResetException extends IOException {
        public final String f4895a;

        private PlaylistResetException(String str) {
            this.f4895a = str;
        }
    }

    public static final class PlaylistStuckException extends IOException {
        public final String f4896a;

        private PlaylistStuckException(String str) {
            this.f4896a = str;
        }
    }

    public interface PrimaryPlaylistListener {
        void mo1439a(HlsMediaPlaylist hlsMediaPlaylist);
    }

    private final class MediaPlaylistBundle implements Callback<ParsingLoadable<HlsPlaylist>>, Runnable {
        public final Loader f13488a = new Loader("HlsPlaylistTracker:MediaPlaylist");
        public HlsMediaPlaylist f13489b;
        public long f13490c;
        long f13491d;
        IOException f13492e;
        final /* synthetic */ HlsPlaylistTracker f13493f;
        private final HlsUrl f13494g;
        private final ParsingLoadable<HlsPlaylist> f13495h;
        private long f13496i;
        private long f13497j;
        private boolean f13498k;

        public final /* synthetic */ int mo1418a(Loadable loadable, long j, long j2, IOException iOException) {
            ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
            IOException iOException2 = iOException;
            boolean z = iOException2 instanceof ParserException;
            this.f13493f.f13511m.m3928a(parsingLoadable.f13682a, 4, j, j2, parsingLoadable.f13685d, iOException2, z);
            if (z) {
                return 3;
            }
            int i = 1;
            if (ChunkedTrackBlacklistUtil.m3982a(iOException)) {
                m12552b();
                if (r0.f13493f.f13508j != r0.f13494g || HlsPlaylistTracker.m12569g(r0.f13493f)) {
                    i = 0;
                }
            }
            if (i != 0) {
                return 0;
            }
            return 2;
        }

        public final /* synthetic */ void mo1419a(Loadable loadable, long j, long j2) {
            ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
            HlsPlaylist hlsPlaylist = (HlsPlaylist) parsingLoadable.f13684c;
            if (hlsPlaylist instanceof HlsMediaPlaylist) {
                m12549a((HlsMediaPlaylist) hlsPlaylist);
                this.f13493f.f13511m.m3927a(parsingLoadable.f13682a, 4, j, j2, parsingLoadable.f13685d);
                return;
            }
            this.f13492e = new ParserException("Loaded playlist has unexpected type.");
        }

        public final /* synthetic */ void mo1420a(Loadable loadable, long j, long j2, boolean z) {
            ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
            this.f13493f.f13511m.m3930b(parsingLoadable.f13682a, 4, j, j2, parsingLoadable.f13685d);
        }

        public MediaPlaylistBundle(HlsPlaylistTracker hlsPlaylistTracker, HlsUrl hlsUrl, long j) {
            this.f13493f = hlsPlaylistTracker;
            this.f13494g = hlsUrl;
            this.f13491d = j;
            this.f13495h = new ParsingLoadable(hlsPlaylistTracker.f13500b.mo1438a(), UriUtil.m4291a(hlsPlaylistTracker.f13507i.o, hlsUrl.f4879a), 4, hlsPlaylistTracker.f13501c);
        }

        public final void m12555a() {
            this.f13497j = 0;
            if (!this.f13498k && !this.f13488a.m12693a()) {
                this.f13488a.m12692a(this.f13495h, this, this.f13493f.f13502d);
            }
        }

        public final void run() {
            this.f13498k = false;
            m12555a();
        }

        private void m12549a(HlsMediaPlaylist hlsMediaPlaylist) {
            long j;
            HlsMediaPlaylist hlsMediaPlaylist2 = this.f13489b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f13490c = elapsedRealtime;
            this.f13489b = HlsPlaylistTracker.m12560a(this.f13493f, hlsMediaPlaylist2, hlsMediaPlaylist);
            if (this.f13489b != hlsMediaPlaylist2) {
                this.f13492e = null;
                this.f13496i = elapsedRealtime;
                if (HlsPlaylistTracker.m12563a(this.f13493f, this.f13494g, this.f13489b) != null) {
                    j = this.f13489b.f13459h;
                    if (j == -9223372036854775807L) {
                        this.f13498k = this.f13493f.f13504f.postDelayed(this, C0377C.m3539a(j));
                    }
                }
            } else if (!this.f13489b.f13461j) {
                if (((double) (elapsedRealtime - this.f13496i)) > ((double) C0377C.m3539a(this.f13489b.f13459h)) * 3.5d) {
                    this.f13492e = new PlaylistStuckException(this.f13494g.f4879a);
                    m12552b();
                } else if (hlsMediaPlaylist.f13457f + hlsMediaPlaylist.f13464m.size() < this.f13489b.f13457f) {
                    this.f13492e = new PlaylistResetException(this.f13494g.f4879a);
                }
                j = this.f13489b.f13459h / 2;
                if (j == -9223372036854775807L) {
                    this.f13498k = this.f13493f.f13504f.postDelayed(this, C0377C.m3539a(j));
                }
            }
            j = -9223372036854775807L;
            if (j == -9223372036854775807L) {
                this.f13498k = this.f13493f.f13504f.postDelayed(this, C0377C.m3539a(j));
            }
        }

        private void m12552b() {
            this.f13497j = SystemClock.elapsedRealtime() + 60000;
            HlsPlaylistTracker.m12561a(this.f13493f, this.f13494g);
        }
    }

    public final /* synthetic */ void mo1419a(Loadable loadable, long j, long j2) {
        HlsMasterPlaylist a;
        HlsPlaylistTracker hlsPlaylistTracker = this;
        ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
        HlsPlaylist hlsPlaylist = (HlsPlaylist) parsingLoadable.f13684c;
        boolean z = hlsPlaylist instanceof HlsMediaPlaylist;
        if (z) {
            a = HlsMasterPlaylist.m12534a(hlsPlaylist.f4890o);
        } else {
            a = (HlsMasterPlaylist) hlsPlaylist;
        }
        hlsPlaylistTracker.f13507i = a;
        hlsPlaylistTracker.f13508j = (HlsUrl) a.f13447a.get(0);
        List arrayList = new ArrayList();
        arrayList.addAll(a.f13447a);
        arrayList.addAll(a.f13448b);
        arrayList.addAll(a.f13449c);
        m12562a(arrayList);
        MediaPlaylistBundle mediaPlaylistBundle = (MediaPlaylistBundle) hlsPlaylistTracker.f13503e.get(hlsPlaylistTracker.f13508j);
        if (z) {
            mediaPlaylistBundle.m12549a((HlsMediaPlaylist) hlsPlaylist);
        } else {
            mediaPlaylistBundle.m12555a();
        }
        hlsPlaylistTracker.f13511m.m3927a(parsingLoadable.f13682a, 4, j, j2, parsingLoadable.f13685d);
    }

    public final /* synthetic */ void mo1420a(Loadable loadable, long j, long j2, boolean z) {
        ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
        this.f13511m.m3930b(parsingLoadable.f13682a, 4, j, j2, parsingLoadable.f13685d);
    }

    public HlsPlaylistTracker(Uri uri, HlsDataSourceFactory hlsDataSourceFactory, EventDispatcher eventDispatcher, int i, PrimaryPlaylistListener primaryPlaylistListener) {
        this.f13499a = uri;
        this.f13500b = hlsDataSourceFactory;
        this.f13511m = eventDispatcher;
        this.f13502d = i;
        this.f13510l = primaryPlaylistListener;
    }

    public final HlsMediaPlaylist m12572a(HlsUrl hlsUrl) {
        MediaPlaylistBundle mediaPlaylistBundle = (MediaPlaylistBundle) this.f13503e.get(hlsUrl);
        mediaPlaylistBundle.f13491d = SystemClock.elapsedRealtime();
        HlsMediaPlaylist hlsMediaPlaylist = mediaPlaylistBundle.f13489b;
        if (hlsMediaPlaylist != null && this.f13507i.f13447a.contains(hlsUrl)) {
            if (this.f13512n == null || !this.f13512n.f13461j) {
                if (((MediaPlaylistBundle) this.f13503e.get(this.f13508j)).f13491d - SystemClock.elapsedRealtime() > 15000) {
                    this.f13508j = hlsUrl;
                    ((MediaPlaylistBundle) this.f13503e.get(this.f13508j)).m12555a();
                }
            }
        }
        return hlsMediaPlaylist;
    }

    public final void m12575b(HlsUrl hlsUrl) throws IOException {
        MediaPlaylistBundle mediaPlaylistBundle = (MediaPlaylistBundle) this.f13503e.get(hlsUrl);
        mediaPlaylistBundle.f13488a.mo1477c();
        if (mediaPlaylistBundle.f13492e != null) {
            throw mediaPlaylistBundle.f13492e;
        }
    }

    private void m12562a(List<HlsUrl> list) {
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            HlsUrl hlsUrl = (HlsUrl) list.get(i);
            this.f13503e.put(hlsUrl, new MediaPlaylistBundle(this, hlsUrl, elapsedRealtime));
        }
    }

    private static Segment m12559a(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        hlsMediaPlaylist2 = hlsMediaPlaylist2.f13457f - hlsMediaPlaylist.f13457f;
        hlsMediaPlaylist = hlsMediaPlaylist.f13464m;
        return hlsMediaPlaylist2 < hlsMediaPlaylist.size() ? (Segment) hlsMediaPlaylist.get(hlsMediaPlaylist2) : null;
    }

    static /* synthetic */ boolean m12569g(HlsPlaylistTracker hlsPlaylistTracker) {
        List list = hlsPlaylistTracker.f13507i.f13447a;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            MediaPlaylistBundle mediaPlaylistBundle = (MediaPlaylistBundle) hlsPlaylistTracker.f13503e.get(list.get(i));
            if (elapsedRealtime > mediaPlaylistBundle.f13497j) {
                hlsPlaylistTracker.f13508j = mediaPlaylistBundle.f13494g;
                mediaPlaylistBundle.m12555a();
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ HlsMediaPlaylist m12560a(HlsPlaylistTracker hlsPlaylistTracker, HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        HlsPlaylistTracker hlsPlaylistTracker2 = hlsPlaylistTracker;
        HlsMediaPlaylist hlsMediaPlaylist3 = hlsMediaPlaylist;
        HlsMediaPlaylist hlsMediaPlaylist4 = hlsMediaPlaylist2;
        int i = 1;
        if (hlsMediaPlaylist3 != null) {
            if (hlsMediaPlaylist4.f13457f <= hlsMediaPlaylist3.f13457f) {
                if (hlsMediaPlaylist4.f13457f >= hlsMediaPlaylist3.f13457f) {
                    int size = hlsMediaPlaylist4.f13464m.size();
                    int size2 = hlsMediaPlaylist3.f13464m.size();
                    if (size <= size2) {
                        if (size == size2 && hlsMediaPlaylist4.f13461j && !hlsMediaPlaylist3.f13461j) {
                        }
                    }
                }
                i = 0;
            }
        }
        if (i != 0) {
            long j;
            int i2;
            if (hlsMediaPlaylist4.f13462k) {
                j = hlsMediaPlaylist4.f13454c;
            } else {
                j = hlsPlaylistTracker2.f13512n != null ? hlsPlaylistTracker2.f13512n.f13454c : 0;
                if (hlsMediaPlaylist3 != null) {
                    i = hlsMediaPlaylist3.f13464m.size();
                    Segment a = m12559a(hlsMediaPlaylist, hlsMediaPlaylist2);
                    if (a != null) {
                        j = hlsMediaPlaylist3.f13454c + a.f4884d;
                    } else if (i == hlsMediaPlaylist4.f13457f - hlsMediaPlaylist3.f13457f) {
                        j = hlsMediaPlaylist.m12535a();
                    }
                }
            }
            long j2 = j;
            if (hlsMediaPlaylist4.f13455d) {
                i2 = hlsMediaPlaylist4.f13456e;
            } else {
                i2 = hlsPlaylistTracker2.f13512n != null ? hlsPlaylistTracker2.f13512n.f13456e : 0;
                if (hlsMediaPlaylist3 != null) {
                    Segment a2 = m12559a(hlsMediaPlaylist, hlsMediaPlaylist2);
                    if (a2 != null) {
                        i2 = (hlsMediaPlaylist3.f13456e + a2.f4883c) - ((Segment) hlsMediaPlaylist4.f13464m.get(0)).f4883c;
                    }
                }
            }
            return new HlsMediaPlaylist(hlsMediaPlaylist4.f13452a, hlsMediaPlaylist4.o, hlsMediaPlaylist4.p, hlsMediaPlaylist4.f13453b, j2, true, i2, hlsMediaPlaylist4.f13457f, hlsMediaPlaylist4.f13458g, hlsMediaPlaylist4.f13459h, hlsMediaPlaylist4.f13460i, hlsMediaPlaylist4.f13461j, hlsMediaPlaylist4.f13462k, hlsMediaPlaylist4.f13463l, hlsMediaPlaylist4.f13464m);
        } else if (!hlsMediaPlaylist4.f13461j || hlsMediaPlaylist3.f13461j) {
            return hlsMediaPlaylist3;
        } else {
            return new HlsMediaPlaylist(hlsMediaPlaylist3.f13452a, hlsMediaPlaylist3.o, hlsMediaPlaylist3.p, hlsMediaPlaylist3.f13453b, hlsMediaPlaylist3.f13454c, hlsMediaPlaylist3.f13455d, hlsMediaPlaylist3.f13456e, hlsMediaPlaylist3.f13457f, hlsMediaPlaylist3.f13458g, hlsMediaPlaylist3.f13459h, hlsMediaPlaylist3.f13460i, true, hlsMediaPlaylist3.f13462k, hlsMediaPlaylist3.f13463l, hlsMediaPlaylist3.f13464m);
        }
    }

    static /* synthetic */ boolean m12563a(HlsPlaylistTracker hlsPlaylistTracker, HlsUrl hlsUrl, HlsMediaPlaylist hlsMediaPlaylist) {
        if (hlsUrl == hlsPlaylistTracker.f13508j) {
            if (hlsPlaylistTracker.f13512n == null) {
                hlsPlaylistTracker.f13509k = hlsMediaPlaylist.f13461j ^ true;
            }
            hlsPlaylistTracker.f13512n = hlsMediaPlaylist;
            hlsPlaylistTracker.f13510l.mo1439a(hlsMediaPlaylist);
        }
        int size = hlsPlaylistTracker.f13505g.size();
        for (int i = 0; i < size; i++) {
            ((PlaylistEventListener) hlsPlaylistTracker.f13505g.get(i)).mo3375g();
        }
        if (hlsUrl == hlsPlaylistTracker.f13508j && hlsMediaPlaylist.f13461j == null) {
            return true;
        }
        return false;
    }

    static /* synthetic */ void m12561a(HlsPlaylistTracker hlsPlaylistTracker, HlsUrl hlsUrl) {
        int size = hlsPlaylistTracker.f13505g.size();
        for (int i = 0; i < size; i++) {
            ((PlaylistEventListener) hlsPlaylistTracker.f13505g.get(i)).mo3373b(hlsUrl);
        }
    }
}
