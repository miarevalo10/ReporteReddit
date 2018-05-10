package com.google.android.exoplayer2.extractor.mp4;

import android.util.Log;
import com.coremedia.iso.boxes.GenreBox;
import com.coremedia.iso.boxes.RatingBox;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;

final class MetadataUtil {
    private static final int f4418A = Util.m4326g("sosn");
    private static final int f4419B = Util.m4326g("tvsh");
    private static final int f4420C = Util.m4326g("----");
    private static final String[] f4421D = new String[]{"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};
    private static final int f4422a = Util.m4326g("nam");
    private static final int f4423b = Util.m4326g("trk");
    private static final int f4424c = Util.m4326g("cmt");
    private static final int f4425d = Util.m4326g("day");
    private static final int f4426e = Util.m4326g("ART");
    private static final int f4427f = Util.m4326g("too");
    private static final int f4428g = Util.m4326g("alb");
    private static final int f4429h = Util.m4326g("com");
    private static final int f4430i = Util.m4326g("wrt");
    private static final int f4431j = Util.m4326g("lyr");
    private static final int f4432k = Util.m4326g("gen");
    private static final int f4433l = Util.m4326g("covr");
    private static final int f4434m = Util.m4326g(GenreBox.TYPE);
    private static final int f4435n = Util.m4326g("grp");
    private static final int f4436o = Util.m4326g("disk");
    private static final int f4437p = Util.m4326g("trkn");
    private static final int f4438q = Util.m4326g("tmpo");
    private static final int f4439r = Util.m4326g("cpil");
    private static final int f4440s = Util.m4326g("aART");
    private static final int f4441t = Util.m4326g("sonm");
    private static final int f4442u = Util.m4326g("soal");
    private static final int f4443v = Util.m4326g("soar");
    private static final int f4444w = Util.m4326g("soaa");
    private static final int f4445x = Util.m4326g("soco");
    private static final int f4446y = Util.m4326g(RatingBox.TYPE);
    private static final int f4447z = Util.m4326g("pgap");

    private static TextInformationFrame m3811a(int i, String str, ParsableByteArray parsableByteArray) {
        int j = parsableByteArray.m4259j();
        if (parsableByteArray.m4259j() == Atom.aF) {
            parsableByteArray.m4251d(8);
            return new TextInformationFrame(str, null, parsableByteArray.m4255f(j - 16));
        }
        parsableByteArray = new StringBuilder("Failed to parse text attribute: ");
        parsableByteArray.append(Atom.m3789c(i));
        Log.w("MetadataUtil", parsableByteArray.toString());
        return null;
    }

    private static Id3Frame m3809a(int i, String str, ParsableByteArray parsableByteArray, boolean z, boolean z2) {
        parsableByteArray = m3812b(parsableByteArray);
        if (z2) {
            parsableByteArray = Math.min(true, parsableByteArray);
        }
        if (parsableByteArray < null) {
            parsableByteArray = new StringBuilder("Failed to parse uint8 attribute: ");
            parsableByteArray.append(Atom.m3789c(i));
            Log.w("MetadataUtil", parsableByteArray.toString());
            return null;
        } else if (z) {
            return new TextInformationFrame(str, null, Integer.toString(parsableByteArray));
        } else {
            return new CommentFrame("und", str, Integer.toString(parsableByteArray));
        }
    }

    private static TextInformationFrame m3813b(int i, String str, ParsableByteArray parsableByteArray) {
        int j = parsableByteArray.m4259j();
        if (parsableByteArray.m4259j() == Atom.aF && j >= 22) {
            parsableByteArray.m4251d(10);
            j = parsableByteArray.m4252e();
            if (j > 0) {
                i = String.valueOf(j);
                parsableByteArray = parsableByteArray.m4252e();
                if (parsableByteArray > null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(i);
                    stringBuilder.append(Operation.DIVISION);
                    stringBuilder.append(parsableByteArray);
                    i = stringBuilder.toString();
                }
                return new TextInformationFrame(str, null, i);
            }
        }
        parsableByteArray = new StringBuilder("Failed to parse index/count attribute: ");
        parsableByteArray.append(Atom.m3789c(i));
        Log.w("MetadataUtil", parsableByteArray.toString());
        return null;
    }

    private static int m3812b(ParsableByteArray parsableByteArray) {
        parsableByteArray.m4251d(4);
        if (parsableByteArray.m4259j() == Atom.aF) {
            parsableByteArray.m4251d(8);
            return parsableByteArray.m4250d();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    public static Entry m3808a(ParsableByteArray parsableByteArray) {
        String str;
        Entry b;
        StringBuilder stringBuilder;
        int j = parsableByteArray.f5257b + parsableByteArray.m4259j();
        int j2 = parsableByteArray.m4259j();
        int i = (j2 >> 24) & 255;
        Entry entry = null;
        if (i != 169) {
            if (i != 65533) {
                try {
                    if (j2 == f4434m) {
                        Entry textInformationFrame;
                        j2 = m3812b(parsableByteArray);
                        str = (j2 <= 0 || j2 > f4421D.length) ? null : f4421D[j2 - 1];
                        if (str != null) {
                            textInformationFrame = new TextInformationFrame("TCON", null, str);
                        } else {
                            Log.w("MetadataUtil", "Failed to parse standard genre code");
                            textInformationFrame = null;
                        }
                        parsableByteArray.m4249c(j);
                        return textInformationFrame;
                    } else if (j2 == f4436o) {
                        b = m3813b(j2, "TPOS", parsableByteArray);
                        parsableByteArray.m4249c(j);
                        return b;
                    } else if (j2 == f4437p) {
                        b = m3813b(j2, "TRCK", parsableByteArray);
                        parsableByteArray.m4249c(j);
                        return b;
                    } else if (j2 == f4438q) {
                        b = m3809a(j2, "TBPM", parsableByteArray, true, false);
                        parsableByteArray.m4249c(j);
                        return b;
                    } else if (j2 == f4439r) {
                        b = m3809a(j2, "TCMP", parsableByteArray, true, true);
                        parsableByteArray.m4249c(j);
                        return b;
                    } else if (j2 == f4433l) {
                        j2 = parsableByteArray.m4259j();
                        if (parsableByteArray.m4259j() == Atom.aF) {
                            i = Atom.m3788b(parsableByteArray.m4259j());
                            String str2 = i == 13 ? "image/jpeg" : i == 14 ? "image/png" : null;
                            if (str2 == null) {
                                stringBuilder = new StringBuilder("Unrecognized cover art flags: ");
                                stringBuilder.append(i);
                                Log.w("MetadataUtil", stringBuilder.toString());
                            } else {
                                parsableByteArray.m4251d(4);
                                byte[] bArr = new byte[(j2 - 16)];
                                parsableByteArray.m4245a(bArr, 0, bArr.length);
                                entry = new ApicFrame(str2, null, 3, bArr);
                            }
                        } else {
                            Log.w("MetadataUtil", "Failed to parse cover art attribute");
                        }
                        parsableByteArray.m4249c(j);
                        return entry;
                    } else if (j2 == f4440s) {
                        b = m3811a(j2, "TPE2", parsableByteArray);
                        parsableByteArray.m4249c(j);
                        return b;
                    } else if (j2 == f4441t) {
                        b = m3811a(j2, "TSOT", parsableByteArray);
                        parsableByteArray.m4249c(j);
                        return b;
                    } else if (j2 == f4442u) {
                        b = m3811a(j2, "TSO2", parsableByteArray);
                        parsableByteArray.m4249c(j);
                        return b;
                    } else if (j2 == f4443v) {
                        b = m3811a(j2, "TSOA", parsableByteArray);
                        parsableByteArray.m4249c(j);
                        return b;
                    } else if (j2 == f4444w) {
                        b = m3811a(j2, "TSOP", parsableByteArray);
                        parsableByteArray.m4249c(j);
                        return b;
                    } else if (j2 == f4445x) {
                        b = m3811a(j2, "TSOC", parsableByteArray);
                        parsableByteArray.m4249c(j);
                        return b;
                    } else if (j2 == f4446y) {
                        b = m3809a(j2, "ITUNESADVISORY", parsableByteArray, false, false);
                        parsableByteArray.m4249c(j);
                        return b;
                    } else if (j2 == f4447z) {
                        b = m3809a(j2, "ITUNESGAPLESS", parsableByteArray, false, true);
                        parsableByteArray.m4249c(j);
                        return b;
                    } else if (j2 == f4418A) {
                        b = m3811a(j2, "TVSHOWSORT", parsableByteArray);
                        parsableByteArray.m4249c(j);
                        return b;
                    } else if (j2 == f4419B) {
                        b = m3811a(j2, "TVSHOW", parsableByteArray);
                        parsableByteArray.m4249c(j);
                        return b;
                    } else {
                        if (j2 == f4420C) {
                            b = m3810a(parsableByteArray, j);
                            parsableByteArray.m4249c(j);
                            return b;
                        }
                        stringBuilder = new StringBuilder("Skipped unknown metadata entry: ");
                        stringBuilder.append(Atom.m3789c(j2));
                        Log.d("MetadataUtil", stringBuilder.toString());
                        parsableByteArray.m4249c(j);
                        return null;
                    }
                } catch (Throwable th) {
                    parsableByteArray.m4249c(j);
                }
            }
        }
        i = 16777215 & j2;
        if (i == f4424c) {
            i = parsableByteArray.m4259j();
            if (parsableByteArray.m4259j() == Atom.aF) {
                parsableByteArray.m4251d(8);
                str = parsableByteArray.m4255f(i - 16);
                entry = new CommentFrame("und", str, str);
            } else {
                stringBuilder = new StringBuilder("Failed to parse comment attribute: ");
                stringBuilder.append(Atom.m3789c(j2));
                Log.w("MetadataUtil", stringBuilder.toString());
            }
            parsableByteArray.m4249c(j);
            return entry;
        }
        if (i != f4422a) {
            if (i != f4423b) {
                if (i != f4429h) {
                    if (i != f4430i) {
                        if (i == f4425d) {
                            b = m3811a(j2, "TDRC", parsableByteArray);
                            parsableByteArray.m4249c(j);
                            return b;
                        } else if (i == f4426e) {
                            b = m3811a(j2, "TPE1", parsableByteArray);
                            parsableByteArray.m4249c(j);
                            return b;
                        } else if (i == f4427f) {
                            b = m3811a(j2, "TSSE", parsableByteArray);
                            parsableByteArray.m4249c(j);
                            return b;
                        } else if (i == f4428g) {
                            b = m3811a(j2, "TALB", parsableByteArray);
                            parsableByteArray.m4249c(j);
                            return b;
                        } else if (i == f4431j) {
                            b = m3811a(j2, "USLT", parsableByteArray);
                            parsableByteArray.m4249c(j);
                            return b;
                        } else if (i == f4432k) {
                            b = m3811a(j2, "TCON", parsableByteArray);
                            parsableByteArray.m4249c(j);
                            return b;
                        } else {
                            if (i == f4435n) {
                                b = m3811a(j2, "TIT1", parsableByteArray);
                                parsableByteArray.m4249c(j);
                                return b;
                            }
                            stringBuilder = new StringBuilder("Skipped unknown metadata entry: ");
                            stringBuilder.append(Atom.m3789c(j2));
                            Log.d("MetadataUtil", stringBuilder.toString());
                            parsableByteArray.m4249c(j);
                            return null;
                        }
                    }
                }
                b = m3811a(j2, "TCOM", parsableByteArray);
                parsableByteArray.m4249c(j);
                return b;
            }
        }
        b = m3811a(j2, "TIT2", parsableByteArray);
        parsableByteArray.m4249c(j);
        return b;
    }

    private static Id3Frame m3810a(ParsableByteArray parsableByteArray, int i) {
        int i2 = -1;
        int i3 = i2;
        Object obj = null;
        String str = obj;
        while (parsableByteArray.f5257b < i) {
            int i4 = parsableByteArray.f5257b;
            int j = parsableByteArray.m4259j();
            int j2 = parsableByteArray.m4259j();
            parsableByteArray.m4251d(4);
            if (j2 == Atom.aD) {
                obj = parsableByteArray.m4255f(j - 12);
            } else if (j2 == Atom.aE) {
                str = parsableByteArray.m4255f(j - 12);
            } else {
                if (j2 == Atom.aF) {
                    i2 = i4;
                    i3 = j;
                }
                parsableByteArray.m4251d(j - 12);
            }
        }
        if (!("com.apple.iTunes".equals(obj) == 0 || "iTunSMPB".equals(str) == 0)) {
            if (i2 != -1) {
                parsableByteArray.m4249c(i2);
                parsableByteArray.m4251d(16);
                return new CommentFrame("und", str, parsableByteArray.m4255f(i3 - 16));
            }
        }
        return null;
    }
}
