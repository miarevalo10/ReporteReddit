package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.C0377C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentList;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTemplate;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase;
import com.google.android.exoplayer2.upstream.ParsingLoadable.Parser;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import com.instabug.chat.model.Attachment;
import com.instabug.library.model.State;
import com.mp4parser.iso14496.part30.WebVTTSampleEntry;
import com.mp4parser.iso14496.part30.XMLSubtitleSampleEntry;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class DashManifestParser extends DefaultHandler implements Parser<DashManifest> {
    private static final Pattern f13379a = Pattern.compile("(\\d+)(?:/(\\d+))?");
    private static final Pattern f13380b = Pattern.compile("CC([1-4])=.*");
    private static final Pattern f13381c = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");
    private final String f13382d;
    private final XmlPullParserFactory f13383e;

    private static final class RepresentationInfo {
        public final Format f4822a;
        public final String f4823b;
        public final SegmentBase f4824c;
        public final ArrayList<SchemeData> f4825d;
        public final ArrayList<Descriptor> f4826e;

        public RepresentationInfo(Format format, String str, SegmentBase segmentBase, ArrayList<SchemeData> arrayList, ArrayList<Descriptor> arrayList2) {
            this.f4822a = format;
            this.f4823b = str;
            this.f4824c = segmentBase;
            this.f4825d = arrayList;
            this.f4826e = arrayList2;
        }
    }

    public final /* synthetic */ Object mo1422a(Uri uri, InputStream inputStream) throws IOException {
        return m12464b(uri, inputStream);
    }

    public DashManifestParser() {
        this((byte) 0);
    }

    private DashManifestParser(byte b) {
        this.f13382d = (byte) 0;
        try {
            this.f13383e = XmlPullParserFactory.newInstance();
        } catch (byte b2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", b2);
        }
    }

    public final DashManifest m12464b(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser newPullParser = this.f13383e.newPullParser();
            String str = null;
            newPullParser.setInput(inputStream, null);
            if (newPullParser.next() == 2) {
                if ("MPD".equals(newPullParser.getName())) {
                    long j;
                    long j2;
                    String uri2 = uri.toString();
                    String attributeValue = newPullParser.getAttributeValue(null, "availabilityStartTime");
                    if (attributeValue == null) {
                        j = -9223372036854775807L;
                    } else {
                        j = Util.m4325f(attributeValue);
                    }
                    long b = m12454b(newPullParser, "mediaPresentationDuration", -9223372036854775807L);
                    long b2 = m12454b(newPullParser, "minBufferTime", -9223372036854775807L);
                    attributeValue = newPullParser.getAttributeValue(null, "type");
                    Object obj = null;
                    boolean z = attributeValue != null && attributeValue.equals("dynamic");
                    long b3 = z ? m12454b(newPullParser, "minimumUpdatePeriod", -9223372036854775807L) : -9223372036854775807L;
                    long b4 = z ? m12454b(newPullParser, "timeShiftBufferDepth", -9223372036854775807L) : -9223372036854775807L;
                    long b5 = z ? m12454b(newPullParser, "suggestedPresentationDelay", -9223372036854775807L) : -9223372036854775807L;
                    List arrayList = new ArrayList();
                    Object obj2 = null;
                    long j3 = z ? -9223372036854775807L : 0;
                    UtcTimingElement utcTimingElement = null;
                    Uri uri3 = utcTimingElement;
                    while (true) {
                        Object obj3;
                        long j4;
                        String str2;
                        newPullParser.next();
                        if (!XmlPullParserUtil.m4332b(newPullParser, "BaseURL")) {
                            if (XmlPullParserUtil.m4332b(newPullParser, "UTCTiming")) {
                                obj3 = obj;
                                utcTimingElement = new UtcTimingElement(newPullParser.getAttributeValue(str, "schemeIdUri"), newPullParser.getAttributeValue(str, "value"));
                            } else {
                                obj3 = obj;
                                if (XmlPullParserUtil.m4332b(newPullParser, HttpRequest.HEADER_LOCATION)) {
                                    uri3 = Uri.parse(newPullParser.nextText());
                                } else if (XmlPullParserUtil.m4332b(newPullParser, "Period") && r14 == null) {
                                    Pair a = m12443a(newPullParser, uri2, j3);
                                    Period period = (Period) a.first;
                                    j4 = j3;
                                    if (period.f4831b != -9223372036854775807L) {
                                        j3 = ((Long) a.second).longValue();
                                        if (j3 == -9223372036854775807L) {
                                            str2 = uri2;
                                            j3 = -9223372036854775807L;
                                        } else {
                                            str2 = uri2;
                                            j3 += period.f4831b;
                                        }
                                        arrayList.add(period);
                                        obj = obj3;
                                        uri2 = str2;
                                        if (XmlPullParserUtil.m4331a(newPullParser, "MPD")) {
                                            break;
                                        }
                                        str = null;
                                    } else if (z) {
                                        obj = obj3;
                                        j3 = j4;
                                        obj2 = 1;
                                        if (XmlPullParserUtil.m4331a(newPullParser, "MPD")) {
                                            break;
                                        }
                                        str = null;
                                    } else {
                                        StringBuilder stringBuilder = new StringBuilder("Unable to determine start of period ");
                                        stringBuilder.append(arrayList.size());
                                        throw new ParserException(stringBuilder.toString());
                                    }
                                } else {
                                    str2 = uri2;
                                    j4 = j3;
                                }
                            }
                            obj = obj3;
                            if (XmlPullParserUtil.m4331a(newPullParser, "MPD")) {
                                break;
                            }
                            str = null;
                        } else if (obj == null) {
                            uri2 = m12456b(newPullParser, uri2);
                            obj = 1;
                            if (XmlPullParserUtil.m4331a(newPullParser, "MPD")) {
                                break;
                            }
                            str = null;
                        } else {
                            str2 = uri2;
                            j4 = j3;
                            obj3 = obj;
                        }
                        obj = obj3;
                        j3 = j4;
                        uri2 = str2;
                        if (XmlPullParserUtil.m4331a(newPullParser, "MPD")) {
                            break;
                        }
                        str = null;
                    }
                    if (b == -9223372036854775807L) {
                        if (j3 != -9223372036854775807L) {
                            j2 = j3;
                            if (arrayList.isEmpty()) {
                                return new DashManifest(j, j2, b2, z, b3, b4, b5, utcTimingElement, uri3, arrayList);
                            }
                            throw new ParserException("No periods found.");
                        } else if (!z) {
                            throw new ParserException("Unable to determine duration of static manifest.");
                        }
                    }
                    j2 = b;
                    if (arrayList.isEmpty()) {
                        return new DashManifest(j, j2, b2, z, b3, b4, b5, utcTimingElement, uri3, arrayList);
                    }
                    throw new ParserException("No periods found.");
                }
            }
            throw new ParserException("inputStream does not contain a valid media presentation description");
        } catch (Throwable e) {
            throw new ParserException(e);
        }
    }

    private Pair<Period, Long> m12443a(XmlPullParser xmlPullParser, String str, long j) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        j = m12454b(xmlPullParser, "start", j);
        long b = m12454b(xmlPullParser, State.KEY_DURATION, -9223372036854775807L);
        List arrayList = new ArrayList();
        Object obj = null;
        SegmentBase segmentBase = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.m4332b(xmlPullParser, "BaseURL")) {
                if (obj == null) {
                    str = m12456b(xmlPullParser, str);
                    obj = 1;
                }
            } else if (XmlPullParserUtil.m4332b(xmlPullParser, "AdaptationSet")) {
                arrayList.add(m12444a(xmlPullParser, str, segmentBase));
            } else if (XmlPullParserUtil.m4332b(xmlPullParser, "SegmentBase")) {
                segmentBase = m12450a(xmlPullParser, null);
            } else if (XmlPullParserUtil.m4332b(xmlPullParser, "SegmentList")) {
                segmentBase = m12448a(xmlPullParser, null);
            } else if (XmlPullParserUtil.m4332b(xmlPullParser, "SegmentTemplate")) {
                segmentBase = m12449a(xmlPullParser, null);
            }
        } while (!XmlPullParserUtil.m4331a(xmlPullParser, "Period"));
        return Pair.create(new Period(attributeValue, j, arrayList), Long.valueOf(b));
    }

    private AdaptationSet m12444a(XmlPullParser xmlPullParser, String str, SegmentBase segmentBase) throws XmlPullParserException, IOException {
        int i;
        List list;
        ArrayList arrayList;
        ArrayList arrayList2;
        DashManifestParser dashManifestParser;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        int a = m12442a(xmlPullParser2, "id", -1);
        int a2 = m12441a(xmlPullParser);
        String str2 = null;
        String attributeValue = xmlPullParser2.getAttributeValue(null, "mimeType");
        String attributeValue2 = xmlPullParser2.getAttributeValue(null, "codecs");
        int a3 = m12442a(xmlPullParser2, "width", -1);
        int a4 = m12442a(xmlPullParser2, "height", -1);
        float a5 = m12438a(xmlPullParser2, -1.0f);
        int a6 = m12442a(xmlPullParser2, "audioSamplingRate", -1);
        String attributeValue3 = xmlPullParser2.getAttributeValue(null, "lang");
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        String str3 = str;
        SegmentBase segmentBase2 = segmentBase;
        int i2 = a2;
        String str4 = attributeValue3;
        int i3 = -1;
        int i4 = 0;
        int i5 = i4;
        while (true) {
            ArrayList arrayList8;
            String str5;
            Collection collection;
            Collection collection2;
            List list2;
            xmlPullParser.next();
            int i6;
            String str6;
            String str7;
            if (!XmlPullParserUtil.m4332b(xmlPullParser2, "BaseURL")) {
                if (XmlPullParserUtil.m4332b(xmlPullParser2, "ContentProtection")) {
                    SchemeData b = m12455b(xmlPullParser);
                    if (b != null) {
                        arrayList3.add(b);
                    }
                } else {
                    if (XmlPullParserUtil.m4332b(xmlPullParser2, "ContentComponent")) {
                        String attributeValue4 = xmlPullParser2.getAttributeValue(str2, "lang");
                        if (str4 == null) {
                            str4 = attributeValue4;
                        } else if (attributeValue4 != null) {
                            Assertions.m4186b(str4.equals(attributeValue4));
                        }
                        i2 = m12439a(i2, m12441a(xmlPullParser));
                    } else if (XmlPullParserUtil.m4332b(xmlPullParser2, "Role")) {
                        i5 |= m12458c(xmlPullParser);
                    } else if (XmlPullParserUtil.m4332b(xmlPullParser2, "AudioChannelConfiguration")) {
                        i3 = m12462f(xmlPullParser);
                    } else if (XmlPullParserUtil.m4332b(xmlPullParser2, "Accessibility")) {
                        arrayList5.add(m12446a(xmlPullParser2, "Accessibility"));
                    } else if (XmlPullParserUtil.m4332b(xmlPullParser2, "SupplementalProperty")) {
                        arrayList6.add(m12446a(xmlPullParser2, "SupplementalProperty"));
                    } else {
                        ArrayList arrayList9;
                        if (XmlPullParserUtil.m4332b(xmlPullParser2, "Representation")) {
                            int i7;
                            i6 = i2;
                            str6 = str4;
                            str7 = str3;
                            i = a;
                            list = arrayList7;
                            arrayList = arrayList6;
                            arrayList2 = arrayList5;
                            arrayList9 = arrayList4;
                            arrayList8 = arrayList3;
                            str5 = str2;
                            RepresentationInfo a7 = m12445a(xmlPullParser2, str3, attributeValue, attributeValue2, a3, a4, a5, i3, a6, str6, i5, arrayList2, segmentBase2);
                            attributeValue3 = a7.f4822a.f4018f;
                            if (!TextUtils.isEmpty(attributeValue3)) {
                                if (MimeTypes.m4213b(attributeValue3)) {
                                    i7 = 2;
                                } else if (MimeTypes.m4212a(attributeValue3)) {
                                    i7 = 1;
                                } else if (m12452a(attributeValue3)) {
                                    i7 = 3;
                                }
                                i7 = m12439a(i6, i7);
                                list.add(a7);
                                i2 = i7;
                            }
                            i7 = -1;
                            i7 = m12439a(i6, i7);
                            list.add(a7);
                            i2 = i7;
                        } else {
                            SegmentBase a8;
                            i6 = i2;
                            str6 = str4;
                            str7 = str3;
                            arrayList = arrayList6;
                            arrayList2 = arrayList5;
                            arrayList9 = arrayList4;
                            arrayList8 = arrayList3;
                            str5 = str2;
                            i = a;
                            list = arrayList7;
                            if (!XmlPullParserUtil.m4332b(xmlPullParser2, "SegmentBase")) {
                                if (!XmlPullParserUtil.m4332b(xmlPullParser2, "SegmentList")) {
                                    if (!XmlPullParserUtil.m4332b(xmlPullParser2, "SegmentTemplate")) {
                                        if (XmlPullParserUtil.m4332b(xmlPullParser2, "InbandEventStream")) {
                                            collection = arrayList9;
                                            collection.add(m12446a(xmlPullParser2, "InbandEventStream"));
                                        } else {
                                            collection = arrayList9;
                                            XmlPullParserUtil.m4330a(xmlPullParser);
                                        }
                                        i2 = i6;
                                        str4 = str6;
                                        str3 = str7;
                                        if (XmlPullParserUtil.m4331a(xmlPullParser2, "AdaptationSet")) {
                                            break;
                                        }
                                        dashManifestParser = this;
                                        collection2 = collection;
                                        list2 = list;
                                        a = i;
                                        arrayList6 = arrayList;
                                        arrayList5 = arrayList2;
                                        arrayList3 = arrayList8;
                                        str2 = str5;
                                    } else {
                                        a8 = m12449a(xmlPullParser2, (SegmentTemplate) segmentBase2);
                                    }
                                } else {
                                    a8 = m12448a(xmlPullParser2, (SegmentList) segmentBase2);
                                }
                            } else {
                                a8 = m12450a(xmlPullParser2, (SingleSegmentBase) segmentBase2);
                            }
                            segmentBase2 = a8;
                            i2 = i6;
                        }
                        str4 = str6;
                        str3 = str7;
                        collection = arrayList9;
                        if (XmlPullParserUtil.m4331a(xmlPullParser2, "AdaptationSet")) {
                            break;
                        }
                        dashManifestParser = this;
                        collection2 = collection;
                        list2 = list;
                        a = i;
                        arrayList6 = arrayList;
                        arrayList5 = arrayList2;
                        arrayList3 = arrayList8;
                        str2 = str5;
                    }
                    arrayList = arrayList6;
                    arrayList2 = arrayList5;
                    Object obj = arrayList4;
                    arrayList8 = arrayList3;
                    str5 = str2;
                    i = a;
                }
                i6 = i2;
                str6 = str4;
                str7 = str3;
                arrayList = arrayList6;
                arrayList2 = arrayList5;
                collection = arrayList4;
                arrayList8 = arrayList3;
                str5 = str2;
                i = a;
                list = arrayList7;
                i2 = i6;
                str4 = str6;
                str3 = str7;
                if (XmlPullParserUtil.m4331a(xmlPullParser2, "AdaptationSet")) {
                    break;
                }
                dashManifestParser = this;
                collection2 = collection;
                list2 = list;
                a = i;
                arrayList6 = arrayList;
                arrayList5 = arrayList2;
                arrayList3 = arrayList8;
                str2 = str5;
            } else {
                if (i4 == 0) {
                    str3 = m12456b(xmlPullParser2, str3);
                    arrayList = arrayList6;
                    arrayList2 = arrayList5;
                    collection = arrayList4;
                    arrayList8 = arrayList3;
                    str5 = str2;
                    i = a;
                    i4 = 1;
                }
                i6 = i2;
                str6 = str4;
                str7 = str3;
                arrayList = arrayList6;
                arrayList2 = arrayList5;
                collection = arrayList4;
                arrayList8 = arrayList3;
                str5 = str2;
                i = a;
                list = arrayList7;
                i2 = i6;
                str4 = str6;
                str3 = str7;
                if (XmlPullParserUtil.m4331a(xmlPullParser2, "AdaptationSet")) {
                    break;
                }
                dashManifestParser = this;
                collection2 = collection;
                list2 = list;
                a = i;
                arrayList6 = arrayList;
                arrayList5 = arrayList2;
                arrayList3 = arrayList8;
                str2 = str5;
            }
            list = arrayList7;
            if (XmlPullParserUtil.m4331a(xmlPullParser2, "AdaptationSet")) {
                break;
            }
            dashManifestParser = this;
            collection2 = collection;
            list2 = list;
            a = i;
            arrayList6 = arrayList;
            arrayList5 = arrayList2;
            arrayList3 = arrayList8;
            str2 = str5;
        }
        List arrayList10 = new ArrayList(list.size());
        int i8 = 0;
        while (i8 < list.size()) {
            RepresentationInfo representationInfo = (RepresentationInfo) list.get(i8);
            str4 = this.f13382d;
            Format format = representationInfo.f4822a;
            List list3 = representationInfo.f4825d;
            arrayList5 = arrayList8;
            list3.addAll(arrayList5);
            if (!list3.isEmpty()) {
                format = format.m3576a(new DrmInitData(list3));
            }
            list3 = representationInfo.f4826e;
            list3.addAll(collection);
            arrayList10.add(Representation.m4004a(str4, format, representationInfo.f4823b, representationInfo.f4824c, list3));
            i8++;
            arrayList8 = arrayList5;
        }
        dashManifestParser = this;
        return new AdaptationSet(i, i2, arrayList10, arrayList2, arrayList);
    }

    private static int m12441a(XmlPullParser xmlPullParser) {
        xmlPullParser = xmlPullParser.getAttributeValue(null, "contentType");
        if (!TextUtils.isEmpty(xmlPullParser)) {
            if (Attachment.TYPE_AUDIO.equals(xmlPullParser)) {
                return 1;
            }
            if (Attachment.TYPE_VIDEO.equals(xmlPullParser)) {
                return 2;
            }
            if ("text".equals(xmlPullParser) != null) {
                return 3;
            }
        }
        return -1;
    }

    private static SchemeData m12455b(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        boolean equals = "urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95".equals(xmlPullParser.getAttributeValue(null, "schemeIdUri"));
        String attributeValue = xmlPullParser.getAttributeValue(null, "value");
        byte[] bArr = null;
        UUID uuid = bArr;
        boolean z = false;
        while (true) {
            byte[] bArr2;
            boolean z2;
            xmlPullParser.next();
            if (bArr == null && XmlPullParserUtil.m4332b(xmlPullParser, "cenc:pssh") && xmlPullParser.next() == 4) {
                bArr = Base64.decode(xmlPullParser.getText(), 0);
                uuid = PsshAtomUtil.m3814a(bArr);
                if (uuid == null) {
                    Log.w("MpdParser", "Skipping malformed cenc:pssh data");
                    bArr2 = null;
                    z2 = z;
                    if (XmlPullParserUtil.m4331a(xmlPullParser, "ContentProtection")) {
                        break;
                    }
                    bArr = bArr2;
                    z = z2;
                }
            } else if (bArr == null && equals && XmlPullParserUtil.m4332b(xmlPullParser, "mspr:pro") && xmlPullParser.next() == 4) {
                bArr = PsshAtomUtil.m3815a(C0377C.f3974e, Base64.decode(xmlPullParser.getText(), 0));
                uuid = C0377C.f3974e;
            } else if (XmlPullParserUtil.m4332b(xmlPullParser, "widevine:license")) {
                String attributeValue2 = xmlPullParser.getAttributeValue(null, "robustness_level");
                z = attributeValue2 != null && attributeValue2.startsWith("HW");
            }
            bArr2 = bArr;
            z2 = z;
            if (XmlPullParserUtil.m4331a(xmlPullParser, "ContentProtection")) {
                break;
            }
            bArr = bArr2;
            z = z2;
        }
        if (bArr2 != null) {
            return new SchemeData(uuid, attributeValue, "video/mp4", bArr2, z2);
        }
        return null;
    }

    private static int m12458c(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String b = m12457b(xmlPullParser, "schemeIdUri", null);
        String b2 = m12457b(xmlPullParser, "value", null);
        do {
            xmlPullParser.next();
        } while (!XmlPullParserUtil.m4331a(xmlPullParser, "Role"));
        return ("urn:mpeg:dash:role:2011".equals(b) == null || "main".equals(b2) == null) ? null : 1;
    }

    private static RepresentationInfo m12445a(XmlPullParser xmlPullParser, String str, String str2, String str3, int i, int i2, float f, int i3, int i4, String str4, int i5, List<Descriptor> list, SegmentBase segmentBase) throws XmlPullParserException, IOException {
        String b;
        String e;
        String str5;
        Format a;
        int a2;
        int i6;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        String attributeValue = xmlPullParser2.getAttributeValue(null, "id");
        int a3 = m12442a(xmlPullParser2, "bandwidth", -1);
        String b2 = m12457b(xmlPullParser2, "mimeType", str2);
        String b3 = m12457b(xmlPullParser2, "codecs", str3);
        int a4 = m12442a(xmlPullParser2, "width", i);
        int a5 = m12442a(xmlPullParser2, "height", i2);
        float a6 = m12438a(xmlPullParser2, f);
        int a7 = m12442a(xmlPullParser2, "audioSamplingRate", i4);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Object obj = null;
        String str6 = str;
        int i7 = i3;
        SegmentBase segmentBase2 = segmentBase;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.m4332b(xmlPullParser2, "BaseURL")) {
                if (obj == null) {
                    b = m12456b(xmlPullParser2, str6);
                    obj = 1;
                    if (XmlPullParserUtil.m4331a(xmlPullParser2, "Representation")) {
                        break;
                    }
                    str6 = b;
                }
            } else if (XmlPullParserUtil.m4332b(xmlPullParser2, "AudioChannelConfiguration")) {
                i7 = m12462f(xmlPullParser);
            } else {
                SegmentBase a8;
                if (XmlPullParserUtil.m4332b(xmlPullParser2, "SegmentBase")) {
                    a8 = m12450a(xmlPullParser2, (SingleSegmentBase) segmentBase2);
                } else if (XmlPullParserUtil.m4332b(xmlPullParser2, "SegmentList")) {
                    a8 = m12448a(xmlPullParser2, (SegmentList) segmentBase2);
                } else if (XmlPullParserUtil.m4332b(xmlPullParser2, "SegmentTemplate")) {
                    a8 = m12449a(xmlPullParser2, (SegmentTemplate) segmentBase2);
                } else if (XmlPullParserUtil.m4332b(xmlPullParser2, "ContentProtection")) {
                    SchemeData b4 = m12455b(xmlPullParser);
                    if (b4 != null) {
                        arrayList.add(b4);
                    }
                } else if (XmlPullParserUtil.m4332b(xmlPullParser2, "InbandEventStream")) {
                    arrayList2.add(m12446a(xmlPullParser2, "InbandEventStream"));
                }
                segmentBase2 = a8;
            }
            b = str6;
            if (XmlPullParserUtil.m4331a(xmlPullParser2, "Representation")) {
                break;
            }
            str6 = b;
        }
        if (MimeTypes.m4212a(b2)) {
            e = MimeTypes.m4216e(b3);
        } else if (MimeTypes.m4213b(b2)) {
            e = MimeTypes.m4215d(b3);
        } else {
            if (m12452a(b2)) {
                str5 = b2;
            } else {
                if ("application/mp4".equals(b2)) {
                    if (XMLSubtitleSampleEntry.TYPE.equals(b3)) {
                        e = "application/ttml+xml";
                    } else if (WebVTTSampleEntry.TYPE.equals(b3)) {
                        e = "application/x-mp4-vtt";
                    }
                } else if ("application/x-rawcc".equals(b2) && b3 != null) {
                    if (b3.contains("cea708")) {
                        e = "application/cea-708";
                    } else if (b3.contains("eia608") || b3.contains("cea608")) {
                        e = "application/cea-608";
                    }
                }
                str5 = null;
            }
            if (str5 != null) {
                if (MimeTypes.m4213b(str5)) {
                    a = Format.m3566a(attributeValue, b2, str5, b3, a3, a4, a5, a6, null, i5);
                } else if (MimeTypes.m4212a(str5)) {
                    a = Format.m3567a(attributeValue, b2, str5, b3, a3, i7, a7, null, i5, str4);
                } else if (m12452a(str5)) {
                    if ("application/cea-608".equals(str5)) {
                        a2 = m12440a((List) list);
                    } else if ("application/cea-708".equals(str5)) {
                        i6 = -1;
                        a = Format.m3569a(attributeValue, b2, str5, b3, a3, i5, str4, i6);
                    } else {
                        a2 = m12453b((List) list);
                    }
                    i6 = a2;
                    a = Format.m3569a(attributeValue, b2, str5, b3, a3, i5, str4, i6);
                }
                return new RepresentationInfo(a, b, segmentBase2 == null ? segmentBase2 : new SingleSegmentBase(), arrayList, arrayList2);
            }
            a = Format.m3568a(attributeValue, b2, str5, b3, a3, i5, str4);
            if (segmentBase2 == null) {
            }
            return new RepresentationInfo(a, b, segmentBase2 == null ? segmentBase2 : new SingleSegmentBase(), arrayList, arrayList2);
        }
        str5 = e;
        if (str5 != null) {
            if (MimeTypes.m4213b(str5)) {
                a = Format.m3566a(attributeValue, b2, str5, b3, a3, a4, a5, a6, null, i5);
            } else if (MimeTypes.m4212a(str5)) {
                a = Format.m3567a(attributeValue, b2, str5, b3, a3, i7, a7, null, i5, str4);
            } else if (m12452a(str5)) {
                if ("application/cea-608".equals(str5)) {
                    a2 = m12440a((List) list);
                } else if ("application/cea-708".equals(str5)) {
                    i6 = -1;
                    a = Format.m3569a(attributeValue, b2, str5, b3, a3, i5, str4, i6);
                } else {
                    a2 = m12453b((List) list);
                }
                i6 = a2;
                a = Format.m3569a(attributeValue, b2, str5, b3, a3, i5, str4, i6);
            }
            if (segmentBase2 == null) {
            }
            return new RepresentationInfo(a, b, segmentBase2 == null ? segmentBase2 : new SingleSegmentBase(), arrayList, arrayList2);
        }
        a = Format.m3568a(attributeValue, b2, str5, b3, a3, i5, str4);
        if (segmentBase2 == null) {
        }
        return new RepresentationInfo(a, b, segmentBase2 == null ? segmentBase2 : new SingleSegmentBase(), arrayList, arrayList2);
    }

    private static SingleSegmentBase m12450a(XmlPullParser xmlPullParser, SingleSegmentBase singleSegmentBase) throws XmlPullParserException, IOException {
        long parseLong;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        SingleSegmentBase singleSegmentBase2 = singleSegmentBase;
        long c = m12459c(xmlPullParser2, "timescale", singleSegmentBase2 != null ? singleSegmentBase2.b : 1);
        long j = 0;
        long c2 = m12459c(xmlPullParser2, "presentationTimeOffset", singleSegmentBase2 != null ? singleSegmentBase2.c : 0);
        long j2 = singleSegmentBase2 != null ? singleSegmentBase2.f13393d : 0;
        if (singleSegmentBase2 != null) {
            j = singleSegmentBase2.f13394e;
        }
        String str = null;
        String attributeValue = xmlPullParser2.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split(Operation.MINUS);
            j = Long.parseLong(split[0]);
            parseLong = (Long.parseLong(split[1]) - j) + 1;
        } else {
            parseLong = j;
            j = j2;
        }
        if (singleSegmentBase2 != null) {
            str = singleSegmentBase2.a;
        }
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.m4332b(xmlPullParser2, "Initialization")) {
                str = m12461e(xmlPullParser);
            }
        } while (!XmlPullParserUtil.m4331a(xmlPullParser2, "SegmentBase"));
        return new SingleSegmentBase(str, c, c2, j, parseLong);
    }

    private static SegmentList m12448a(XmlPullParser xmlPullParser, SegmentList segmentList) throws XmlPullParserException, IOException {
        long c = m12459c(xmlPullParser, "timescale", segmentList != null ? segmentList.b : 1);
        long c2 = m12459c(xmlPullParser, "presentationTimeOffset", segmentList != null ? segmentList.c : 0);
        long c3 = m12459c(xmlPullParser, State.KEY_DURATION, segmentList != null ? segmentList.e : -9223372036854775807L);
        int a = m12442a(xmlPullParser, "startNumber", segmentList != null ? segmentList.d : 1);
        List list = null;
        RangedUri rangedUri = null;
        List list2 = rangedUri;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.m4332b(xmlPullParser, "Initialization")) {
                rangedUri = m12461e(xmlPullParser);
            } else if (XmlPullParserUtil.m4332b(xmlPullParser, "SegmentTimeline")) {
                list2 = m12460d(xmlPullParser);
            } else if (XmlPullParserUtil.m4332b(xmlPullParser, "SegmentURL")) {
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(m12447a(xmlPullParser, "media", "mediaRange"));
            }
        } while (!XmlPullParserUtil.m4331a(xmlPullParser, "SegmentList"));
        if (segmentList != null) {
            if (rangedUri == null) {
                rangedUri = segmentList.a;
            }
            if (list2 == null) {
                list2 = segmentList.f;
            }
            if (list == null) {
                list = segmentList.f16993g;
            }
        }
        return new SegmentList(rangedUri, c, c2, a, c3, list2, list);
    }

    private static SegmentTemplate m12449a(XmlPullParser xmlPullParser, SegmentTemplate segmentTemplate) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        SegmentTemplate segmentTemplate2 = segmentTemplate;
        long c = m12459c(xmlPullParser2, "timescale", segmentTemplate2 != null ? segmentTemplate2.b : 1);
        long c2 = m12459c(xmlPullParser2, "presentationTimeOffset", segmentTemplate2 != null ? segmentTemplate2.c : 0);
        long c3 = m12459c(xmlPullParser2, State.KEY_DURATION, segmentTemplate2 != null ? segmentTemplate2.e : -9223372036854775807L);
        int a = m12442a(xmlPullParser2, "startNumber", segmentTemplate2 != null ? segmentTemplate2.d : 1);
        RangedUri rangedUri = null;
        UrlTemplate a2 = m12451a(xmlPullParser2, "media", segmentTemplate2 != null ? segmentTemplate2.f16995h : null);
        UrlTemplate a3 = m12451a(xmlPullParser2, "initialization", segmentTemplate2 != null ? segmentTemplate2.f16994g : null);
        List list = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.m4332b(xmlPullParser2, "Initialization")) {
                rangedUri = m12461e(xmlPullParser);
            } else if (XmlPullParserUtil.m4332b(xmlPullParser2, "SegmentTimeline")) {
                list = m12460d(xmlPullParser);
            }
        } while (!XmlPullParserUtil.m4331a(xmlPullParser2, "SegmentTemplate"));
        if (segmentTemplate2 != null) {
            if (rangedUri == null) {
                rangedUri = segmentTemplate2.a;
            }
            if (list == null) {
                list = segmentTemplate2.f;
            }
        }
        return new SegmentTemplate(rangedUri, c, c2, a, c3, list, a3, a2);
    }

    private static List<SegmentTimelineElement> m12460d(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        List<SegmentTimelineElement> arrayList = new ArrayList();
        long j = 0;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.m4332b(xmlPullParser, "S")) {
                j = m12459c(xmlPullParser, "t", j);
                long c = m12459c(xmlPullParser, "d", -9223372036854775807L);
                int i = 0;
                int a = 1 + m12442a(xmlPullParser, "r", 0);
                while (i < a) {
                    arrayList.add(new SegmentTimelineElement(j, c));
                    j += c;
                    i++;
                }
            }
        } while (!XmlPullParserUtil.m4331a(xmlPullParser, "SegmentTimeline"));
        return arrayList;
    }

    private static UrlTemplate m12451a(XmlPullParser xmlPullParser, String str, UrlTemplate urlTemplate) {
        xmlPullParser = xmlPullParser.getAttributeValue(null, str);
        return xmlPullParser != null ? UrlTemplate.m4009a(xmlPullParser) : urlTemplate;
    }

    private static RangedUri m12461e(XmlPullParser xmlPullParser) {
        return m12447a(xmlPullParser, "sourceURL", "range");
    }

    private static RangedUri m12447a(XmlPullParser xmlPullParser, String str, String str2) {
        long parseLong;
        long parseLong2;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        xmlPullParser = xmlPullParser.getAttributeValue(null, str2);
        if (xmlPullParser != null) {
            xmlPullParser = xmlPullParser.split(Operation.MINUS);
            parseLong = Long.parseLong(xmlPullParser[0]);
            if (xmlPullParser.length == 2) {
                parseLong2 = (Long.parseLong(xmlPullParser[1]) - parseLong) + 1;
                return new RangedUri(attributeValue, parseLong, parseLong2);
            }
        }
        parseLong = 0;
        parseLong2 = -1;
        return new RangedUri(attributeValue, parseLong, parseLong2);
    }

    private static int m12462f(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = -1;
        if ("urn:mpeg:dash:23003:3:audio_channel_configuration:2011".equals(m12457b(xmlPullParser, "schemeIdUri", null))) {
            i = m12442a(xmlPullParser, "value", -1);
        }
        do {
            xmlPullParser.next();
        } while (!XmlPullParserUtil.m4331a(xmlPullParser, "AudioChannelConfiguration"));
        return i;
    }

    private static boolean m12452a(String str) {
        if (!(MimeTypes.m4214c(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/cea-708".equals(str))) {
            if ("application/cea-608".equals(str) == null) {
                return null;
            }
        }
        return true;
    }

    private static int m12439a(int i, int i2) {
        if (i == -1) {
            return i2;
        }
        if (i2 == -1) {
            return i;
        }
        Assertions.m4186b(i == i2 ? 1 : 0);
        return i;
    }

    private static Descriptor m12446a(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String b = m12457b(xmlPullParser, "schemeIdUri", "");
        String b2 = m12457b(xmlPullParser, "value", null);
        String b3 = m12457b(xmlPullParser, "id", null);
        do {
            xmlPullParser.next();
        } while (!XmlPullParserUtil.m4331a(xmlPullParser, str));
        return new Descriptor(b, b2, b3);
    }

    private static int m12440a(List<Descriptor> list) {
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = (Descriptor) list.get(i);
            if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.f4827a) && descriptor.f4828b != null) {
                Matcher matcher = f13380b.matcher(descriptor.f4828b);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                StringBuilder stringBuilder = new StringBuilder("Unable to parse CEA-608 channel number from: ");
                stringBuilder.append(descriptor.f4828b);
                Log.w("MpdParser", stringBuilder.toString());
            }
        }
        return -1;
    }

    private static int m12453b(List<Descriptor> list) {
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = (Descriptor) list.get(i);
            if ("urn:scte:dash:cc:cea-708:2015".equals(descriptor.f4827a) && descriptor.f4828b != null) {
                Matcher matcher = f13381c.matcher(descriptor.f4828b);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                StringBuilder stringBuilder = new StringBuilder("Unable to parse CEA-708 service block number from: ");
                stringBuilder.append(descriptor.f4828b);
                Log.w("MpdParser", stringBuilder.toString());
            }
        }
        return -1;
    }

    private static float m12438a(XmlPullParser xmlPullParser, float f) {
        xmlPullParser = xmlPullParser.getAttributeValue(null, "frameRate");
        if (xmlPullParser == null) {
            return f;
        }
        xmlPullParser = f13379a.matcher(xmlPullParser);
        if (!xmlPullParser.matches()) {
            return f;
        }
        f = Integer.parseInt(xmlPullParser.group(Float.MIN_VALUE));
        xmlPullParser = xmlPullParser.group(2);
        return !TextUtils.isEmpty(xmlPullParser) ? ((float) f) / ((float) Integer.parseInt(xmlPullParser)) : (float) f;
    }

    private static long m12454b(XmlPullParser xmlPullParser, String str, long j) {
        xmlPullParser = xmlPullParser.getAttributeValue(null, str);
        if (xmlPullParser == null) {
            return j;
        }
        return Util.m4324e(xmlPullParser);
    }

    private static String m12456b(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        xmlPullParser.next();
        return UriUtil.m4294b(str, xmlPullParser.getText());
    }

    private static int m12442a(XmlPullParser xmlPullParser, String str, int i) {
        xmlPullParser = xmlPullParser.getAttributeValue(null, str);
        if (xmlPullParser == null) {
            return i;
        }
        return Integer.parseInt(xmlPullParser);
    }

    private static long m12459c(XmlPullParser xmlPullParser, String str, long j) {
        xmlPullParser = xmlPullParser.getAttributeValue(null, str);
        if (xmlPullParser == null) {
            return j;
        }
        return Long.parseLong(xmlPullParser);
    }

    private static String m12457b(XmlPullParser xmlPullParser, String str, String str2) {
        xmlPullParser = xmlPullParser.getAttributeValue(null, str);
        return xmlPullParser == null ? str2 : xmlPullParser;
    }
}
