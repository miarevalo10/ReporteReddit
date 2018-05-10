package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.ProtectionElement;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement;
import com.google.android.exoplayer2.upstream.ParsingLoadable.Parser;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.Util;
import com.googlecode.mp4parser.boxes.AC3SpecificBox;
import com.googlecode.mp4parser.boxes.EC3SpecificBox;
import com.instabug.chat.model.Attachment;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class SsManifestParser implements Parser<SsManifest> {
    private final XmlPullParserFactory f13556a;

    private static abstract class ElementParser {
        private final String f4924a;
        private final String f4925b;
        private final ElementParser f4926c;
        private final List<Pair<String, Object>> f4927d = new LinkedList();

        protected abstract Object mo1442a();

        protected void mo1447a(Object obj) {
        }

        protected void mo1443b(XmlPullParser xmlPullParser) throws ParserException {
        }

        protected boolean mo1444b(String str) {
            return false;
        }

        protected void mo1445c(XmlPullParser xmlPullParser) {
        }

        protected void mo1446d(XmlPullParser xmlPullParser) {
        }

        public ElementParser(ElementParser elementParser, String str, String str2) {
            this.f4926c = elementParser;
            this.f4924a = str;
            this.f4925b = str2;
        }

        public final Object m4030a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            Object obj = null;
            int i = 0;
            while (true) {
                ElementParser elementParser = null;
                String name;
                switch (xmlPullParser.getEventType()) {
                    case 1:
                        return null;
                    case 2:
                        name = xmlPullParser.getName();
                        if (!this.f4925b.equals(name)) {
                            if (obj != null) {
                                if (i <= 0) {
                                    if (!mo1444b(name)) {
                                        String str = this.f4924a;
                                        if ("QualityLevel".equals(name)) {
                                            elementParser = new QualityLevelParser(this, str);
                                        } else if ("Protection".equals(name)) {
                                            elementParser = new ProtectionParser(this, str);
                                        } else if ("StreamIndex".equals(name)) {
                                            elementParser = new StreamIndexParser(this, str);
                                        }
                                        if (elementParser != null) {
                                            mo1447a(elementParser.m4030a(xmlPullParser));
                                            break;
                                        }
                                        i = 1;
                                        break;
                                    }
                                    mo1443b(xmlPullParser);
                                    break;
                                }
                                i++;
                                break;
                            }
                            break;
                        }
                        mo1443b(xmlPullParser);
                        obj = 1;
                        break;
                    case 3:
                        if (obj != null) {
                            if (i <= 0) {
                                name = xmlPullParser.getName();
                                mo1446d(xmlPullParser);
                                if (mo1444b(name)) {
                                    break;
                                }
                                return mo1442a();
                            }
                            i--;
                            break;
                        }
                        continue;
                    case 4:
                        if (obj != null && i == 0) {
                            mo1445c(xmlPullParser);
                            break;
                        }
                    default:
                        break;
                }
                xmlPullParser.next();
            }
        }

        protected final void m4032a(String str, Object obj) {
            this.f4927d.add(Pair.create(str, obj));
        }

        protected final Object m4029a(String str) {
            ElementParser elementParser = this;
            while (true) {
                for (int i = 0; i < elementParser.f4927d.size(); i++) {
                    Pair pair = (Pair) elementParser.f4927d.get(i);
                    if (((String) pair.first).equals(str)) {
                        return pair.second;
                    }
                }
                if (elementParser.f4926c == null) {
                    return null;
                }
                elementParser = elementParser.f4926c;
            }
        }

        protected static String m4024a(XmlPullParser xmlPullParser, String str) throws MissingFieldException {
            xmlPullParser = xmlPullParser.getAttributeValue(null, str);
            if (xmlPullParser != null) {
                return xmlPullParser;
            }
            throw new MissingFieldException(str);
        }

        protected static int m4025b(XmlPullParser xmlPullParser, String str) throws ParserException {
            xmlPullParser = xmlPullParser.getAttributeValue(null, str);
            if (xmlPullParser == null) {
                return -1;
            }
            try {
                return Integer.parseInt(xmlPullParser);
            } catch (Throwable e) {
                throw new ParserException(e);
            }
        }

        protected static int m4026c(XmlPullParser xmlPullParser, String str) throws ParserException {
            xmlPullParser = xmlPullParser.getAttributeValue(null, str);
            if (xmlPullParser != null) {
                try {
                    return Integer.parseInt(xmlPullParser);
                } catch (Throwable e) {
                    throw new ParserException(e);
                }
            }
            throw new MissingFieldException(str);
        }

        protected static long m4023a(XmlPullParser xmlPullParser, String str, long j) throws ParserException {
            xmlPullParser = xmlPullParser.getAttributeValue(null, str);
            if (xmlPullParser == null) {
                return j;
            }
            try {
                return Long.parseLong(xmlPullParser);
            } catch (Throwable e) {
                throw new ParserException(e);
            }
        }

        protected static long m4027d(XmlPullParser xmlPullParser, String str) throws ParserException {
            xmlPullParser = xmlPullParser.getAttributeValue(null, str);
            if (xmlPullParser != null) {
                try {
                    return Long.parseLong(xmlPullParser);
                } catch (Throwable e) {
                    throw new ParserException(e);
                }
            }
            throw new MissingFieldException(str);
        }
    }

    public static class MissingFieldException extends ParserException {
        public MissingFieldException(String str) {
            StringBuilder stringBuilder = new StringBuilder("Missing required field: ");
            stringBuilder.append(str);
            super(stringBuilder.toString());
        }
    }

    private static class ProtectionParser extends ElementParser {
        private boolean f13529a;
        private UUID f13530b;
        private byte[] f13531c;

        public ProtectionParser(ElementParser elementParser, String str) {
            super(elementParser, str, "Protection");
        }

        public final boolean mo1444b(String str) {
            return "ProtectionHeader".equals(str);
        }

        public final void mo1443b(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f13529a = true;
                xmlPullParser = xmlPullParser.getAttributeValue(null, "SystemID");
                if (xmlPullParser.charAt(0) == '{' && xmlPullParser.charAt(xmlPullParser.length() - 1) == '}') {
                    xmlPullParser = xmlPullParser.substring(1, xmlPullParser.length() - 1);
                }
                this.f13530b = UUID.fromString(xmlPullParser);
            }
        }

        public final void mo1445c(XmlPullParser xmlPullParser) {
            if (this.f13529a) {
                this.f13531c = Base64.decode(xmlPullParser.getText(), 0);
            }
        }

        public final void mo1446d(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName()) != null) {
                this.f13529a = null;
            }
        }

        public final Object mo1442a() {
            return new ProtectionElement(this.f13530b, PsshAtomUtil.m3815a(this.f13530b, this.f13531c));
        }
    }

    private static class QualityLevelParser extends ElementParser {
        private Format f13532a;

        public QualityLevelParser(ElementParser elementParser, String str) {
            super(elementParser, str, "QualityLevel");
        }

        public final void mo1443b(XmlPullParser xmlPullParser) throws ParserException {
            String str;
            int c;
            int c2;
            int intValue = ((Integer) m4029a("Type")).intValue();
            String attributeValue = xmlPullParser.getAttributeValue(null, "Index");
            int c3 = ElementParser.m4026c(xmlPullParser, "Bitrate");
            String a = ElementParser.m4024a(xmlPullParser, "FourCC");
            if (!(a.equalsIgnoreCase("H264") || a.equalsIgnoreCase("X264") || a.equalsIgnoreCase("AVC1"))) {
                if (!a.equalsIgnoreCase("DAVC")) {
                    if (!(a.equalsIgnoreCase("AAC") || a.equalsIgnoreCase("AACL") || a.equalsIgnoreCase("AACH"))) {
                        if (!a.equalsIgnoreCase("AACP")) {
                            if (a.equalsIgnoreCase("TTML")) {
                                a = "application/ttml+xml";
                            } else {
                                if (!a.equalsIgnoreCase(AudioSampleEntry.TYPE8)) {
                                    if (!a.equalsIgnoreCase(AC3SpecificBox.TYPE)) {
                                        if (!a.equalsIgnoreCase(AudioSampleEntry.TYPE9)) {
                                            if (!a.equalsIgnoreCase(EC3SpecificBox.TYPE)) {
                                                if (a.equalsIgnoreCase("dtsc")) {
                                                    a = "audio/vnd.dts";
                                                } else {
                                                    if (!a.equalsIgnoreCase(AudioSampleEntry.TYPE12)) {
                                                        if (!a.equalsIgnoreCase(AudioSampleEntry.TYPE11)) {
                                                            if (a.equalsIgnoreCase(AudioSampleEntry.TYPE13)) {
                                                                a = "audio/vnd.dts.hd;profile=lbr";
                                                            } else if (a.equalsIgnoreCase("opus")) {
                                                                a = "audio/opus";
                                                            } else {
                                                                str = null;
                                                                if (intValue != 2) {
                                                                    this.f13532a = Format.m3566a(attributeValue, "video/mp4", str, null, c3, ElementParser.m4026c(xmlPullParser, "MaxWidth"), ElementParser.m4026c(xmlPullParser, "MaxHeight"), -1.0f, m12594c(xmlPullParser.getAttributeValue(null, "CodecPrivateData")), 0);
                                                                } else if (intValue != 1) {
                                                                    if (str == null) {
                                                                        str = "audio/mp4a-latm";
                                                                    }
                                                                    c = ElementParser.m4026c(xmlPullParser, "Channels");
                                                                    c2 = ElementParser.m4026c(xmlPullParser, "SamplingRate");
                                                                    xmlPullParser = m12594c(xmlPullParser.getAttributeValue(null, "CodecPrivateData"));
                                                                    if (xmlPullParser.isEmpty() && "audio/mp4a-latm".equals(str)) {
                                                                        xmlPullParser = Collections.singletonList(CodecSpecificDataUtil.m4193a(c2, c));
                                                                    }
                                                                    this.f13532a = Format.m3567a(attributeValue, "audio/mp4", str, null, c3, c, c2, (List) xmlPullParser, 0, (String) m4029a("Language"));
                                                                } else if (intValue != 3) {
                                                                    this.f13532a = Format.m3565a(attributeValue, "application/mp4", str, c3, (int) null, (String) m4029a("Language"));
                                                                } else {
                                                                    this.f13532a = Format.m3568a(attributeValue, "application/mp4", str, null, c3, 0, null);
                                                                }
                                                            }
                                                        }
                                                    }
                                                    a = "audio/vnd.dts.hd";
                                                }
                                            }
                                        }
                                        a = "audio/eac3";
                                    }
                                }
                                a = "audio/ac3";
                            }
                            str = a;
                            if (intValue != 2) {
                                this.f13532a = Format.m3566a(attributeValue, "video/mp4", str, null, c3, ElementParser.m4026c(xmlPullParser, "MaxWidth"), ElementParser.m4026c(xmlPullParser, "MaxHeight"), -1.0f, m12594c(xmlPullParser.getAttributeValue(null, "CodecPrivateData")), 0);
                            } else if (intValue != 1) {
                                if (str == null) {
                                    str = "audio/mp4a-latm";
                                }
                                c = ElementParser.m4026c(xmlPullParser, "Channels");
                                c2 = ElementParser.m4026c(xmlPullParser, "SamplingRate");
                                xmlPullParser = m12594c(xmlPullParser.getAttributeValue(null, "CodecPrivateData"));
                                xmlPullParser = Collections.singletonList(CodecSpecificDataUtil.m4193a(c2, c));
                                this.f13532a = Format.m3567a(attributeValue, "audio/mp4", str, null, c3, c, c2, (List) xmlPullParser, 0, (String) m4029a("Language"));
                            } else if (intValue != 3) {
                                this.f13532a = Format.m3568a(attributeValue, "application/mp4", str, null, c3, 0, null);
                            } else {
                                this.f13532a = Format.m3565a(attributeValue, "application/mp4", str, c3, (int) null, (String) m4029a("Language"));
                            }
                        }
                    }
                    a = "audio/mp4a-latm";
                    str = a;
                    if (intValue != 2) {
                        this.f13532a = Format.m3566a(attributeValue, "video/mp4", str, null, c3, ElementParser.m4026c(xmlPullParser, "MaxWidth"), ElementParser.m4026c(xmlPullParser, "MaxHeight"), -1.0f, m12594c(xmlPullParser.getAttributeValue(null, "CodecPrivateData")), 0);
                    } else if (intValue != 1) {
                        if (str == null) {
                            str = "audio/mp4a-latm";
                        }
                        c = ElementParser.m4026c(xmlPullParser, "Channels");
                        c2 = ElementParser.m4026c(xmlPullParser, "SamplingRate");
                        xmlPullParser = m12594c(xmlPullParser.getAttributeValue(null, "CodecPrivateData"));
                        xmlPullParser = Collections.singletonList(CodecSpecificDataUtil.m4193a(c2, c));
                        this.f13532a = Format.m3567a(attributeValue, "audio/mp4", str, null, c3, c, c2, (List) xmlPullParser, 0, (String) m4029a("Language"));
                    } else if (intValue != 3) {
                        this.f13532a = Format.m3565a(attributeValue, "application/mp4", str, c3, (int) null, (String) m4029a("Language"));
                    } else {
                        this.f13532a = Format.m3568a(attributeValue, "application/mp4", str, null, c3, 0, null);
                    }
                }
            }
            a = "video/avc";
            str = a;
            if (intValue != 2) {
                this.f13532a = Format.m3566a(attributeValue, "video/mp4", str, null, c3, ElementParser.m4026c(xmlPullParser, "MaxWidth"), ElementParser.m4026c(xmlPullParser, "MaxHeight"), -1.0f, m12594c(xmlPullParser.getAttributeValue(null, "CodecPrivateData")), 0);
            } else if (intValue != 1) {
                if (str == null) {
                    str = "audio/mp4a-latm";
                }
                c = ElementParser.m4026c(xmlPullParser, "Channels");
                c2 = ElementParser.m4026c(xmlPullParser, "SamplingRate");
                xmlPullParser = m12594c(xmlPullParser.getAttributeValue(null, "CodecPrivateData"));
                xmlPullParser = Collections.singletonList(CodecSpecificDataUtil.m4193a(c2, c));
                this.f13532a = Format.m3567a(attributeValue, "audio/mp4", str, null, c3, c, c2, (List) xmlPullParser, 0, (String) m4029a("Language"));
            } else if (intValue != 3) {
                this.f13532a = Format.m3568a(attributeValue, "application/mp4", str, null, c3, 0, null);
            } else {
                this.f13532a = Format.m3565a(attributeValue, "application/mp4", str, c3, (int) null, (String) m4029a("Language"));
            }
        }

        public final Object mo1442a() {
            return this.f13532a;
        }

        private static List<byte[]> m12594c(String str) {
            Object arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                byte[] h = Util.m4327h(str);
                Object[] b = CodecSpecificDataUtil.m4198b(h);
                if (b == null) {
                    arrayList.add(h);
                } else {
                    Collections.addAll(arrayList, b);
                }
            }
            return arrayList;
        }
    }

    private static class SmoothStreamingMediaParser extends ElementParser {
        private final List<StreamElement> f13533a = new LinkedList();
        private int f13534b;
        private int f13535c;
        private long f13536d;
        private long f13537e;
        private long f13538f;
        private int f13539g = -1;
        private boolean f13540h;
        private ProtectionElement f13541i = null;

        public SmoothStreamingMediaParser(String str) {
            super(null, str, "SmoothStreamingMedia");
        }

        public final void mo1443b(XmlPullParser xmlPullParser) throws ParserException {
            this.f13534b = ElementParser.m4026c(xmlPullParser, "MajorVersion");
            this.f13535c = ElementParser.m4026c(xmlPullParser, "MinorVersion");
            this.f13536d = ElementParser.m4023a(xmlPullParser, "TimeScale", 10000000);
            this.f13537e = ElementParser.m4027d(xmlPullParser, "Duration");
            this.f13538f = ElementParser.m4023a(xmlPullParser, "DVRWindowLength", 0);
            this.f13539g = ElementParser.m4025b(xmlPullParser, "LookaheadCount");
            xmlPullParser = xmlPullParser.getAttributeValue(null, "IsLive");
            if (xmlPullParser != null) {
                xmlPullParser = Boolean.parseBoolean(xmlPullParser);
            } else {
                xmlPullParser = null;
            }
            this.f13540h = xmlPullParser;
            m4032a("TimeScale", (Object) Long.valueOf(this.f13536d));
        }

        public final void mo1447a(Object obj) {
            if (obj instanceof StreamElement) {
                this.f13533a.add((StreamElement) obj);
                return;
            }
            if (obj instanceof ProtectionElement) {
                Assertions.m4186b(this.f13541i == null);
                this.f13541i = (ProtectionElement) obj;
            }
        }

        public final Object mo1442a() {
            StreamElement[] streamElementArr = new StreamElement[this.f13533a.size()];
            this.f13533a.toArray(streamElementArr);
            if (this.f13541i != null) {
                DrmInitData drmInitData = new DrmInitData(new SchemeData(this.f13541i.f4898a, "video/mp4", this.f13541i.f4899b));
                for (StreamElement streamElement : streamElementArr) {
                    for (int i = 0; i < streamElement.f4909j.length; i++) {
                        streamElement.f4909j[i] = streamElement.f4909j[i].m3576a(drmInitData);
                    }
                }
            }
            return new SsManifest(this.f13534b, this.f13535c, this.f13536d, this.f13537e, this.f13538f, this.f13539g, this.f13540h, this.f13541i, streamElementArr);
        }
    }

    private static class StreamIndexParser extends ElementParser {
        private final String f13542a;
        private final List<Format> f13543b = new LinkedList();
        private int f13544c;
        private String f13545d;
        private long f13546e;
        private String f13547f;
        private String f13548g;
        private int f13549h;
        private int f13550i;
        private int f13551j;
        private int f13552k;
        private String f13553l;
        private ArrayList<Long> f13554m;
        private long f13555n;

        public StreamIndexParser(ElementParser elementParser, String str) {
            super(elementParser, str, "StreamIndex");
            this.f13542a = str;
        }

        public final boolean mo1444b(String str) {
            return "c".equals(str);
        }

        public final void mo1443b(XmlPullParser xmlPullParser) throws ParserException {
            int i = 1;
            if ("c".equals(xmlPullParser.getName())) {
                int size = this.f13554m.size();
                long a = ElementParser.m4023a(xmlPullParser, "t", -9223372036854775807L);
                if (a == -9223372036854775807L) {
                    if (size == 0) {
                        a = 0;
                    } else if (this.f13555n != -1) {
                        a = this.f13555n + ((Long) this.f13554m.get(size - 1)).longValue();
                    } else {
                        throw new ParserException("Unable to infer start time");
                    }
                }
                this.f13554m.add(Long.valueOf(a));
                this.f13555n = ElementParser.m4023a(xmlPullParser, "d", -9223372036854775807L);
                long a2 = ElementParser.m4023a(xmlPullParser, "r", 1);
                if (a2 <= 1 || this.f13555n != -9223372036854775807L) {
                    while (true) {
                        long j = (long) i;
                        if (j < a2) {
                            this.f13554m.add(Long.valueOf((this.f13555n * j) + a));
                            i++;
                        } else {
                            return;
                        }
                    }
                }
                throw new ParserException("Repeated chunk with unspecified duration");
            }
            String attributeValue = xmlPullParser.getAttributeValue(null, "Type");
            if (attributeValue != null) {
                if (!Attachment.TYPE_AUDIO.equalsIgnoreCase(attributeValue)) {
                    if (Attachment.TYPE_VIDEO.equalsIgnoreCase(attributeValue)) {
                        i = 2;
                    } else if ("text".equalsIgnoreCase(attributeValue)) {
                        i = 3;
                    } else {
                        StringBuilder stringBuilder = new StringBuilder("Invalid key value[");
                        stringBuilder.append(attributeValue);
                        stringBuilder.append("]");
                        throw new ParserException(stringBuilder.toString());
                    }
                }
                this.f13544c = i;
                m4032a("Type", (Object) Integer.valueOf(this.f13544c));
                if (this.f13544c == 3) {
                    this.f13545d = ElementParser.m4024a(xmlPullParser, "Subtype");
                } else {
                    this.f13545d = xmlPullParser.getAttributeValue(null, "Subtype");
                }
                this.f13547f = xmlPullParser.getAttributeValue(null, "Name");
                this.f13548g = ElementParser.m4024a(xmlPullParser, "Url");
                this.f13549h = ElementParser.m4025b(xmlPullParser, "MaxWidth");
                this.f13550i = ElementParser.m4025b(xmlPullParser, "MaxHeight");
                this.f13551j = ElementParser.m4025b(xmlPullParser, "DisplayWidth");
                this.f13552k = ElementParser.m4025b(xmlPullParser, "DisplayHeight");
                this.f13553l = xmlPullParser.getAttributeValue(null, "Language");
                m4032a("Language", (Object) this.f13553l);
                this.f13546e = (long) ElementParser.m4025b(xmlPullParser, "TimeScale");
                if (this.f13546e == -1) {
                    this.f13546e = ((Long) m4029a("TimeScale")).longValue();
                }
                this.f13554m = new ArrayList();
                return;
            }
            throw new MissingFieldException("Type");
        }

        public final void mo1447a(Object obj) {
            if (obj instanceof Format) {
                this.f13543b.add((Format) obj);
            }
        }

        public final Object mo1442a() {
            Format[] formatArr = new Format[this.f13543b.size()];
            this.f13543b.toArray(formatArr);
            String str = this.f13542a;
            String str2 = this.f13548g;
            int i = this.f13544c;
            String str3 = this.f13545d;
            long j = this.f13546e;
            String str4 = this.f13547f;
            int i2 = this.f13549h;
            int i3 = this.f13550i;
            int i4 = this.f13551j;
            int i5 = this.f13552k;
            String str5 = this.f13553l;
            String str6 = str5;
            Format[] formatArr2 = formatArr;
            return new StreamElement(str, str2, i, str3, j, str4, i2, i3, i4, i5, str6, formatArr2, this.f13554m, this.f13555n);
        }
    }

    public final /* synthetic */ Object mo1422a(Uri uri, InputStream inputStream) throws IOException {
        return m12604b(uri, inputStream);
    }

    public SsManifestParser() {
        try {
            this.f13556a = XmlPullParserFactory.newInstance();
        } catch (Throwable e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    private SsManifest m12604b(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser newPullParser = this.f13556a.newPullParser();
            newPullParser.setInput(inputStream, null);
            return (SsManifest) new SmoothStreamingMediaParser(uri.toString()).m4030a(newPullParser);
        } catch (Throwable e) {
            throw new ParserException(e);
        }
    }
}
