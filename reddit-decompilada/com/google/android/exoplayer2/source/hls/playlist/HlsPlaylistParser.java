package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.C0377C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment;
import com.google.android.exoplayer2.upstream.ParsingLoadable.Parser;
import com.google.android.exoplayer2.util.Util;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jcodec.codecs.mjpeg.JpegConst;

public final class HlsPlaylistParser implements Parser<HlsPlaylist> {
    private static final Pattern f13466a = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    private static final Pattern f13467b = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    private static final Pattern f13468c = Pattern.compile("CODECS=\"(.+?)\"");
    private static final Pattern f13469d = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    private static final Pattern f13470e = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    private static final Pattern f13471f = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    private static final Pattern f13472g = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    private static final Pattern f13473h = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final Pattern f13474i = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    private static final Pattern f13475j = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern f13476k = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern f13477l = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern f13478m = Pattern.compile("METHOD=(NONE|AES-128)");
    private static final Pattern f13479n = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern f13480o = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern f13481p = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern f13482q = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern f13483r = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern f13484s = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern f13485t = m12539a("AUTOSELECT");
    private static final Pattern f13486u = m12539a("DEFAULT");
    private static final Pattern f13487v = m12539a("FORCED");

    private static class LineIterator {
        private final BufferedReader f4892a;
        private final Queue<String> f4893b;
        private String f4894c;

        public LineIterator(Queue<String> queue, BufferedReader bufferedReader) {
            this.f4893b = queue;
            this.f4892a = bufferedReader;
        }

        public final boolean m4015a() throws IOException {
            if (this.f4894c != null) {
                return true;
            }
            if (this.f4893b.isEmpty()) {
                do {
                    String readLine = this.f4892a.readLine();
                    this.f4894c = readLine;
                    if (readLine == null) {
                        return false;
                    }
                    this.f4894c = this.f4894c.trim();
                } while (this.f4894c.isEmpty());
                return true;
            }
            this.f4894c = (String) this.f4893b.poll();
            return true;
        }

        public final String m4016b() throws IOException {
            if (!m4015a()) {
                return null;
            }
            String str = this.f4894c;
            this.f4894c = null;
            return str;
        }
    }

    public final /* synthetic */ Object mo1422a(Uri uri, InputStream inputStream) throws IOException {
        return m12543b(uri, inputStream);
    }

    private static HlsPlaylist m12543b(Uri uri, InputStream inputStream) throws IOException {
        Closeable bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        inputStream = new LinkedList();
        try {
            if (m12540a((BufferedReader) bufferedReader)) {
                String readLine;
                while (true) {
                    readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        readLine = readLine.trim();
                        if (!readLine.isEmpty()) {
                            if (!readLine.startsWith("#EXT-X-STREAM-INF")) {
                                if (readLine.startsWith("#EXT-X-TARGETDURATION") || readLine.startsWith("#EXT-X-MEDIA-SEQUENCE") || readLine.startsWith("#EXTINF") || readLine.startsWith("#EXT-X-KEY") || readLine.startsWith("#EXT-X-BYTERANGE") || readLine.equals("#EXT-X-DISCONTINUITY") || readLine.equals("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                                    break;
                                } else if (readLine.equals("#EXT-X-ENDLIST")) {
                                    break;
                                } else {
                                    inputStream.add(readLine);
                                }
                            } else {
                                inputStream.add(readLine);
                                uri = m12538a(new LineIterator(inputStream, bufferedReader), uri.toString());
                                Util.m4308a(bufferedReader);
                                return uri;
                            }
                        }
                    } else {
                        Util.m4308a(bufferedReader);
                        throw new ParserException("Failed to parse the playlist, could not identify any tags.");
                    }
                }
                inputStream.add(readLine);
                uri = m12542b(new LineIterator(inputStream, bufferedReader), uri.toString());
                return uri;
            }
            throw new UnrecognizedInputFormatException("Input does not start with the #EXTM3U header.", uri);
        } finally {
            Util.m4308a(bufferedReader);
        }
    }

    private static boolean m12540a(BufferedReader bufferedReader) throws IOException {
        int read = bufferedReader.read();
        if (read == JpegConst.APPF) {
            if (bufferedReader.read() == 187) {
                if (bufferedReader.read() == 191) {
                    read = bufferedReader.read();
                }
            }
            return false;
        }
        char a = m12536a(bufferedReader, true, read);
        for (read = 0; read < 7; read++) {
            if (a != "#EXTM3U".charAt(read)) {
                return false;
            }
            a = bufferedReader.read();
        }
        return Util.m4311a(m12536a(bufferedReader, false, a));
    }

    private static int m12536a(BufferedReader bufferedReader, boolean z, int i) throws IOException {
        while (i != -1 && Character.isWhitespace(i) && (z || !Util.m4311a(i))) {
            i = bufferedReader.read();
        }
        return i;
    }

    private static HlsMasterPlaylist m12538a(LineIterator lineIterator, String str) throws IOException {
        HashSet hashSet = new HashSet();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List arrayList3 = new ArrayList();
        List arrayList4 = new ArrayList();
        Format format = null;
        List list = format;
        int i = 0;
        while (lineIterator.m4015a()) {
            String b = lineIterator.m4016b();
            if (b.startsWith("#EXT")) {
                arrayList4.add(b);
            }
            String c;
            int hashCode;
            int parseInt;
            if (b.startsWith("#EXT-X-MEDIA")) {
                int i2;
                Format a;
                int i3;
                String str2;
                int e = (m12546e(b, f13486u) | (m12546e(b, f13487v) ? 2 : 0)) | (m12546e(b, f13485t) ? 4 : 0);
                c = m12544c(b, f13479n);
                String d = m12545d(b, f13483r);
                String c2 = m12544c(b, f13482q);
                String d2 = m12545d(b, f13481p);
                hashCode = d2.hashCode();
                if (hashCode == -959297733) {
                    if (d2.equals("SUBTITLES")) {
                        i2 = 1;
                        switch (i2) {
                            case 0:
                                a = Format.m3567a(d, "application/x-mpegURL", null, null, -1, -1, -1, null, e, c2);
                                if (c != null) {
                                    arrayList2.add(new HlsUrl(c, a));
                                    break;
                                }
                                format = a;
                                break;
                            case 1:
                                arrayList3.add(new HlsUrl(c, Format.m3565a(d, "application/x-mpegURL", "text/vtt", -1, e, c2)));
                                break;
                            case 2:
                                b = m12545d(b, f13484s);
                                if (b.startsWith("CC")) {
                                    c = "application/cea-708";
                                    parseInt = Integer.parseInt(b.substring(7));
                                } else {
                                    c = "application/cea-608";
                                    parseInt = Integer.parseInt(b.substring(2));
                                }
                                i3 = parseInt;
                                str2 = c;
                                if (list == null) {
                                    list = new ArrayList();
                                }
                                list.add(Format.m3569a(d, null, str2, null, -1, e, c2, i3));
                                break;
                            default:
                                break;
                        }
                    }
                } else if (hashCode == -333210994) {
                    if (d2.equals("CLOSED-CAPTIONS")) {
                        i2 = 2;
                        switch (i2) {
                            case 0:
                                a = Format.m3567a(d, "application/x-mpegURL", null, null, -1, -1, -1, null, e, c2);
                                if (c != null) {
                                    format = a;
                                    break;
                                }
                                arrayList2.add(new HlsUrl(c, a));
                                break;
                            case 1:
                                arrayList3.add(new HlsUrl(c, Format.m3565a(d, "application/x-mpegURL", "text/vtt", -1, e, c2)));
                                break;
                            case 2:
                                b = m12545d(b, f13484s);
                                if (b.startsWith("CC")) {
                                    c = "application/cea-708";
                                    parseInt = Integer.parseInt(b.substring(7));
                                } else {
                                    c = "application/cea-608";
                                    parseInt = Integer.parseInt(b.substring(2));
                                }
                                i3 = parseInt;
                                str2 = c;
                                if (list == null) {
                                    list = new ArrayList();
                                }
                                list.add(Format.m3569a(d, null, str2, null, -1, e, c2, i3));
                                break;
                            default:
                                break;
                        }
                    }
                } else if (hashCode == 62628790) {
                    if (d2.equals("AUDIO")) {
                        i2 = 0;
                        switch (i2) {
                            case 0:
                                a = Format.m3567a(d, "application/x-mpegURL", null, null, -1, -1, -1, null, e, c2);
                                if (c != null) {
                                    arrayList2.add(new HlsUrl(c, a));
                                    break;
                                }
                                format = a;
                                break;
                            case 1:
                                arrayList3.add(new HlsUrl(c, Format.m3565a(d, "application/x-mpegURL", "text/vtt", -1, e, c2)));
                                break;
                            case 2:
                                b = m12545d(b, f13484s);
                                if (b.startsWith("CC")) {
                                    c = "application/cea-608";
                                    parseInt = Integer.parseInt(b.substring(2));
                                } else {
                                    c = "application/cea-708";
                                    parseInt = Integer.parseInt(b.substring(7));
                                }
                                i3 = parseInt;
                                str2 = c;
                                if (list == null) {
                                    list = new ArrayList();
                                }
                                list.add(Format.m3569a(d, null, str2, null, -1, e, c2, i3));
                                break;
                            default:
                                break;
                        }
                    }
                }
                i2 = -1;
                switch (i2) {
                    case 0:
                        a = Format.m3567a(d, "application/x-mpegURL", null, null, -1, -1, -1, null, e, c2);
                        if (c != null) {
                            format = a;
                            break;
                        }
                        arrayList2.add(new HlsUrl(c, a));
                        break;
                    case 1:
                        arrayList3.add(new HlsUrl(c, Format.m3565a(d, "application/x-mpegURL", "text/vtt", -1, e, c2)));
                        break;
                    case 2:
                        b = m12545d(b, f13484s);
                        if (b.startsWith("CC")) {
                            c = "application/cea-708";
                            parseInt = Integer.parseInt(b.substring(7));
                        } else {
                            c = "application/cea-608";
                            parseInt = Integer.parseInt(b.substring(2));
                        }
                        i3 = parseInt;
                        str2 = c;
                        if (list == null) {
                            list = new ArrayList();
                        }
                        list.add(Format.m3569a(d, null, str2, null, -1, e, c2, i3));
                        break;
                    default:
                        break;
                }
            } else if (b.startsWith("#EXT-X-STREAM-INF")) {
                int i4;
                int i5;
                int a2 = m12537a(b, f13467b);
                String c3 = m12544c(b, f13466a);
                if (c3 != null) {
                    a2 = Integer.parseInt(c3);
                }
                int i6 = a2;
                String c4 = m12544c(b, f13468c);
                c = m12544c(b, f13469d);
                i |= b.contains("CLOSED-CAPTIONS=NONE");
                if (c != null) {
                    String[] split = c.split("x");
                    hashCode = Integer.parseInt(split[0]);
                    parseInt = Integer.parseInt(split[1]);
                    if (hashCode <= 0 || parseInt <= 0) {
                        parseInt = -1;
                        hashCode = -1;
                    }
                    i4 = parseInt;
                    i5 = hashCode;
                } else {
                    i5 = -1;
                    i4 = -1;
                }
                b = lineIterator.m4016b();
                if (hashSet.add(b)) {
                    arrayList.add(new HlsUrl(b, Format.m3566a(Integer.toString(arrayList.size()), "application/x-mpegURL", null, c4, i6, i5, i4, -1.0f, null, 0)));
                }
            }
        }
        if (i != 0) {
            list = Collections.emptyList();
        }
        return new HlsMasterPlaylist(str, arrayList4, arrayList, arrayList2, arrayList3, format, list);
    }

    private static HlsMediaPlaylist m12542b(LineIterator lineIterator, String str) throws IOException {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        long j = -9223372036854775807L;
        long j2 = j;
        int i = 0;
        int i2 = i;
        int i3 = i2;
        int i4 = i3;
        int i5 = i4;
        int i6 = i5;
        int i7 = i6;
        boolean z = i7;
        boolean z2 = z;
        int i8 = 1;
        long j3 = 0;
        Segment segment = null;
        long j4 = 0;
        long j5 = -1;
        long j6 = 0;
        String str2 = null;
        long j7 = 0;
        loop0:
        while (true) {
            String str3 = null;
            while (lineIterator.m4015a()) {
                String b = lineIterator.m4016b();
                if (b.startsWith("#EXT")) {
                    arrayList2.add(b);
                }
                if (b.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                    b = m12545d(b, f13472g);
                    if ("VOD".equals(b)) {
                        i2 = 1;
                    } else if ("EVENT".equals(b)) {
                        i2 = 2;
                    }
                } else if (b.startsWith("#EXT-X-START")) {
                    j = (long) (m12541b(b, f13475j) * 1000000.0d);
                } else if (b.startsWith("#EXT-X-MAP")) {
                    String d = m12545d(b, f13479n);
                    b = m12544c(b, f13477l);
                    if (b != null) {
                        r4 = b.split("@");
                        j5 = Long.parseLong(r4[0]);
                        if (r4.length > 1) {
                            j4 = Long.parseLong(r4[1]);
                        }
                    }
                    segment = new Segment(d, j4, j5);
                    j4 = 0;
                    j5 = -1;
                } else if (b.startsWith("#EXT-X-TARGETDURATION")) {
                    j2 = 1000000 * ((long) m12537a(b, f13470e));
                } else if (b.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                    i3 = m12537a(b, f13473h);
                    i6 = i3;
                } else if (b.startsWith("#EXT-X-VERSION")) {
                    i8 = m12537a(b, f13471f);
                } else if (b.startsWith("#EXTINF")) {
                    j7 = (long) (m12541b(b, f13474i) * 1000000.0d);
                } else if (b.startsWith("#EXT-X-KEY")) {
                    z2 = "AES-128".equals(m12545d(b, f13478m));
                    if (z2) {
                        str3 = m12545d(b, f13479n);
                        str2 = m12544c(b, f13480o);
                    } else {
                        str2 = null;
                    }
                } else if (b.startsWith("#EXT-X-BYTERANGE")) {
                    r4 = m12545d(b, f13476k).split("@");
                    j5 = Long.parseLong(r4[0]);
                    if (r4.length > 1) {
                        j4 = Long.parseLong(r4[1]);
                    }
                } else if (b.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                    i5 = Integer.parseInt(b.substring(b.indexOf(58) + 1));
                    i4 = 1;
                } else if (b.equals("#EXT-X-DISCONTINUITY")) {
                    i++;
                } else if (b.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                    if (j3 == 0) {
                        j3 = C0377C.m3540b(Util.m4325f(b.substring(b.indexOf(58) + 1))) - j6;
                    }
                } else if (!b.startsWith("#")) {
                    String toHexString = !z2 ? null : str2 != null ? str2 : Integer.toHexString(i3);
                    i3++;
                    int i9 = (j5 > -1 ? 1 : (j5 == -1 ? 0 : -1));
                    if (i9 == 0) {
                        j4 = 0;
                    }
                    arrayList.add(new Segment(b, j7, i, j6, z2, str3, toHexString, j4, j5));
                    j6 += j7;
                    if (i9 != 0) {
                        j4 += j5;
                    }
                    j5 = -1;
                    j7 = 0;
                } else if (b.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                    i7 = 1;
                } else if (b.equals("#EXT-X-ENDLIST")) {
                    z = true;
                }
            }
            break loop0;
        }
        return new HlsMediaPlaylist(i2, str, arrayList2, j, j3, i4, i5, i6, i8, j2, i7, z, j3 != 0, segment, arrayList);
    }

    private static int m12537a(String str, Pattern pattern) throws ParserException {
        return Integer.parseInt(m12545d(str, pattern));
    }

    private static double m12541b(String str, Pattern pattern) throws ParserException {
        return Double.parseDouble(m12545d(str, pattern));
    }

    private static String m12544c(String str, Pattern pattern) {
        str = pattern.matcher(str);
        return str.find() != null ? str.group(1) : null;
    }

    private static String m12545d(String str, Pattern pattern) throws ParserException {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() == 1) {
            return matcher.group(1);
        }
        StringBuilder stringBuilder = new StringBuilder("Couldn't match ");
        stringBuilder.append(pattern.pattern());
        stringBuilder.append(" in ");
        stringBuilder.append(str);
        throw new ParserException(stringBuilder.toString());
    }

    private static boolean m12546e(String str, Pattern pattern) {
        str = pattern.matcher(str);
        return str.find() != null ? str.group(1).equals("YES") : null;
    }

    private static Pattern m12539a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("=(NO|YES)");
        return Pattern.compile(stringBuilder.toString());
    }
}
