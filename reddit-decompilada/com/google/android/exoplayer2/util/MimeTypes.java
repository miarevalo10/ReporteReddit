package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.boxes.AC3SpecificBox;
import com.googlecode.mp4parser.boxes.EC3SpecificBox;
import com.instabug.chat.model.Attachment;

public final class MimeTypes {
    public static boolean m4212a(String str) {
        return Attachment.TYPE_AUDIO.equals(m4220i(str));
    }

    public static boolean m4213b(String str) {
        return Attachment.TYPE_VIDEO.equals(m4220i(str));
    }

    public static boolean m4214c(String str) {
        return "text".equals(m4220i(str));
    }

    public static String m4215d(String str) {
        if (str == null) {
            return null;
        }
        for (String f : str.split(",")) {
            String f2 = m4217f(f2);
            if (f2 != null && m4213b(f2)) {
                return f2;
            }
        }
        return null;
    }

    public static String m4216e(String str) {
        if (str == null) {
            return null;
        }
        for (String f : str.split(",")) {
            String f2 = m4217f(f2);
            if (f2 != null && m4212a(f2)) {
                return f2;
            }
        }
        return null;
    }

    public static String m4217f(String str) {
        if (str == null) {
            return null;
        }
        str = str.trim();
        if (!str.startsWith(VisualSampleEntry.TYPE3)) {
            if (!str.startsWith(VisualSampleEntry.TYPE4)) {
                if (!str.startsWith(VisualSampleEntry.TYPE7)) {
                    if (!str.startsWith(VisualSampleEntry.TYPE6)) {
                        if (!str.startsWith("vp9")) {
                            if (!str.startsWith("vp09")) {
                                if (!str.startsWith("vp8")) {
                                    if (!str.startsWith("vp08")) {
                                        if (str.startsWith(AudioSampleEntry.TYPE3)) {
                                            return "audio/mp4a-latm";
                                        }
                                        if (!str.startsWith(AudioSampleEntry.TYPE8)) {
                                            if (!str.startsWith(AC3SpecificBox.TYPE)) {
                                                if (!str.startsWith(AudioSampleEntry.TYPE9)) {
                                                    if (!str.startsWith(EC3SpecificBox.TYPE)) {
                                                        if (!str.startsWith("dtsc")) {
                                                            if (!str.startsWith(AudioSampleEntry.TYPE13)) {
                                                                if (!str.startsWith(AudioSampleEntry.TYPE12)) {
                                                                    if (!str.startsWith(AudioSampleEntry.TYPE11)) {
                                                                        if (str.startsWith("opus")) {
                                                                            return "audio/opus";
                                                                        }
                                                                        if (str.startsWith("vorbis") != null) {
                                                                            return "audio/vorbis";
                                                                        }
                                                                        return null;
                                                                    }
                                                                }
                                                                return "audio/vnd.dts.hd";
                                                            }
                                                        }
                                                        return "audio/vnd.dts";
                                                    }
                                                }
                                                return "audio/eac3";
                                            }
                                        }
                                        return "audio/ac3";
                                    }
                                }
                                return "video/x-vnd.on2.vp8";
                            }
                        }
                        return "video/x-vnd.on2.vp9";
                    }
                }
                return "video/hevc";
            }
        }
        return "video/avc";
    }

    public static int m4218g(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (m4212a(str)) {
            return 1;
        }
        if (m4213b(str)) {
            return 2;
        }
        if (!(m4214c(str) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str))) {
            if (!"application/dvbsubs".equals(str)) {
                if (!("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str))) {
                    if ("application/x-camera-motion".equals(str) == null) {
                        return -1;
                    }
                }
                return 4;
            }
        }
        return 3;
    }

    public static int m4219h(String str) {
        return m4218g(m4217f(str));
    }

    private static String m4220i(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        StringBuilder stringBuilder = new StringBuilder("Invalid mime type: ");
        stringBuilder.append(str);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
