package com.google.android.exoplayer2.text.ttml;

import android.util.Log;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class TtmlDecoder extends SimpleSubtitleDecoder {
    private static final Pattern f19043c = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern f19044d = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern f19045e = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    private static final Pattern f19046f = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final FrameAndTickRate f19047g = new FrameAndTickRate(30.0f, 1, 1);
    private final XmlPullParserFactory f19048h;

    private static final class FrameAndTickRate {
        final float f5047a;
        final int f5048b;
        final int f5049c;

        FrameAndTickRate(float f, int i, int i2) {
            this.f5047a = f;
            this.f5048b = i;
            this.f5049c = i2;
        }
    }

    public TtmlDecoder() {
        super("TtmlDecoder");
        try {
            this.f19048h = XmlPullParserFactory.newInstance();
            this.f19048h.setNamespaceAware(true);
        } catch (Throwable e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    private TtmlSubtitle m20108a(byte[] bArr, int i) throws SubtitleDecoderException {
        try {
            XmlPullParser newPullParser = this.f19048h.newPullParser();
            Map hashMap = new HashMap();
            Map hashMap2 = new HashMap();
            hashMap2.put("", new TtmlRegion());
            int i2 = 0;
            TtmlSubtitle ttmlSubtitle = null;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            LinkedList linkedList = new LinkedList();
            int eventType = newPullParser.getEventType();
            FrameAndTickRate frameAndTickRate = f19047g;
            int i3 = 0;
            while (true) {
                int i4 = 1;
                if (eventType == 1) {
                    return ttmlSubtitle;
                }
                TtmlNode ttmlNode = (TtmlNode) linkedList.peekLast();
                if (i3 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        FrameAndTickRate frameAndTickRate2;
                        if ("tt".equals(name)) {
                            float parseInt;
                            eventType = 30;
                            String attributeValue = newPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
                            if (attributeValue != null) {
                                eventType = Integer.parseInt(attributeValue);
                            }
                            attributeValue = newPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
                            if (attributeValue != null) {
                                String[] split = attributeValue.split(" ");
                                if (split.length != 2) {
                                    throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
                                }
                                parseInt = ((float) Integer.parseInt(split[i2])) / ((float) Integer.parseInt(split[1]));
                            } else {
                                parseInt = 1.0f;
                            }
                            int i5 = f19047g.f5048b;
                            String attributeValue2 = newPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
                            if (attributeValue2 != null) {
                                i5 = Integer.parseInt(attributeValue2);
                            }
                            int i6 = f19047g.f5049c;
                            String attributeValue3 = newPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
                            if (attributeValue3 != null) {
                                i6 = Integer.parseInt(attributeValue3);
                            }
                            frameAndTickRate2 = new FrameAndTickRate(((float) eventType) * parseInt, i5, i6);
                        } else {
                            frameAndTickRate2 = frameAndTickRate;
                        }
                        if (!(name.equals("tt") || name.equals("head") || name.equals("body") || name.equals("div") || name.equals("p") || name.equals("span") || name.equals("br") || name.equals("style") || name.equals("styling") || name.equals("layout") || name.equals("region") || name.equals("metadata") || name.equals("smpte:image") || name.equals("smpte:data"))) {
                            if (!name.equals("smpte:information")) {
                                i4 = 0;
                            }
                        }
                        if (i4 == 0) {
                            StringBuilder stringBuilder = new StringBuilder("Ignoring unsupported tag: ");
                            stringBuilder.append(newPullParser.getName());
                            Log.i("TtmlDecoder", stringBuilder.toString());
                            i3++;
                        } else if ("head".equals(name)) {
                            m20109a(newPullParser, hashMap, hashMap2);
                        } else {
                            try {
                                TtmlNode a = m20104a(newPullParser, ttmlNode, hashMap2, frameAndTickRate2);
                                linkedList.addLast(a);
                                if (ttmlNode != null) {
                                    ttmlNode.m4084a(a);
                                }
                            } catch (Throwable e) {
                                Log.w("TtmlDecoder", "Suppressing parser error", e);
                                i3++;
                            }
                        }
                        frameAndTickRate = frameAndTickRate2;
                    } else if (eventType == 4) {
                        ttmlNode.m4084a(TtmlNode.m4079a(newPullParser.getText()));
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals("tt")) {
                            ttmlSubtitle = new TtmlSubtitle((TtmlNode) linkedList.getLast(), hashMap, hashMap2);
                        }
                        linkedList.removeLast();
                    }
                } else if (eventType == 2) {
                    i3++;
                } else if (eventType == 3) {
                    i3--;
                }
                newPullParser.next();
                eventType = newPullParser.getEventType();
                i2 = 0;
            }
        } catch (Throwable e2) {
            throw new SubtitleDecoderException("Unable to decode source", e2);
        } catch (Throwable e22) {
            throw new IllegalStateException("Unexpected error when reading input.", e22);
        }
    }

    private static Map<String, TtmlStyle> m20109a(XmlPullParser xmlPullParser, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2) throws IOException, XmlPullParserException {
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.m4332b(xmlPullParser, "style")) {
                String c = XmlPullParserUtil.m4333c(xmlPullParser, "style");
                TtmlStyle a = m20107a(xmlPullParser, new TtmlStyle());
                if (c != null) {
                    for (Object obj : c.split("\\s+")) {
                        a.m4093a((TtmlStyle) map.get(obj));
                    }
                }
                if (a.f5078l != null) {
                    map.put(a.f5078l, a);
                }
            } else if (XmlPullParserUtil.m4332b(xmlPullParser, "region")) {
                TtmlRegion a2 = m20105a(xmlPullParser);
                if (a2 != null) {
                    map2.put(a2.f5061a, a2);
                }
            }
        } while (!XmlPullParserUtil.m4331a(xmlPullParser, "head"));
        return map;
    }

    private static com.google.android.exoplayer2.text.ttml.TtmlRegion m20105a(org.xmlpull.v1.XmlPullParser r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "id";
        r2 = com.google.android.exoplayer2.util.XmlPullParserUtil.m4333c(r11, r0);
        r0 = 0;
        if (r2 != 0) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r1 = "origin";
        r1 = com.google.android.exoplayer2.util.XmlPullParserUtil.m4333c(r11, r1);
        if (r1 == 0) goto L_0x00fd;
    L_0x0012:
        r3 = f19046f;
        r3 = r3.matcher(r1);
        r4 = r3.matches();
        if (r4 == 0) goto L_0x00e9;
    L_0x001e:
        r4 = 1;
        r5 = r3.group(r4);	 Catch:{ NumberFormatException -> 0x00d5 }
        r5 = java.lang.Float.parseFloat(r5);	 Catch:{ NumberFormatException -> 0x00d5 }
        r6 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;	 Catch:{ NumberFormatException -> 0x00d5 }
        r5 = r5 / r6;	 Catch:{ NumberFormatException -> 0x00d5 }
        r7 = 2;	 Catch:{ NumberFormatException -> 0x00d5 }
        r3 = r3.group(r7);	 Catch:{ NumberFormatException -> 0x00d5 }
        r3 = java.lang.Float.parseFloat(r3);	 Catch:{ NumberFormatException -> 0x00d5 }
        r3 = r3 / r6;
        r8 = "extent";
        r8 = com.google.android.exoplayer2.util.XmlPullParserUtil.m4333c(r11, r8);
        if (r8 == 0) goto L_0x00cd;
    L_0x003c:
        r9 = f19046f;
        r8 = r9.matcher(r8);
        r9 = r8.matches();
        if (r9 == 0) goto L_0x00b9;
    L_0x0048:
        r9 = r8.group(r4);	 Catch:{ NumberFormatException -> 0x00a5 }
        r9 = java.lang.Float.parseFloat(r9);	 Catch:{ NumberFormatException -> 0x00a5 }
        r9 = r9 / r6;	 Catch:{ NumberFormatException -> 0x00a5 }
        r8 = r8.group(r7);	 Catch:{ NumberFormatException -> 0x00a5 }
        r8 = java.lang.Float.parseFloat(r8);	 Catch:{ NumberFormatException -> 0x00a5 }
        r8 = r8 / r6;
        r0 = "displayAlign";
        r11 = com.google.android.exoplayer2.util.XmlPullParserUtil.m4333c(r11, r0);
        r0 = 0;
        if (r11 == 0) goto L_0x0098;
    L_0x0063:
        r11 = com.google.android.exoplayer2.util.Util.m4323d(r11);
        r1 = -1;
        r6 = r11.hashCode();
        r10 = -1364013995; // 0xffffffffaeb2cc55 float:-8.1307995E-11 double:NaN;
        if (r6 == r10) goto L_0x0081;
    L_0x0071:
        r10 = 92734940; // 0x58705dc float:1.2697491E-35 double:4.5817148E-316;
        if (r6 == r10) goto L_0x0077;
    L_0x0076:
        goto L_0x008a;
    L_0x0077:
        r6 = "after";
        r11 = r11.equals(r6);
        if (r11 == 0) goto L_0x008a;
    L_0x007f:
        r1 = r4;
        goto L_0x008a;
    L_0x0081:
        r6 = "center";
        r11 = r11.equals(r6);
        if (r11 == 0) goto L_0x008a;
    L_0x0089:
        r1 = r0;
    L_0x008a:
        switch(r1) {
            case 0: goto L_0x0092;
            case 1: goto L_0x008e;
            default: goto L_0x008d;
        };
    L_0x008d:
        goto L_0x0098;
    L_0x008e:
        r3 = r3 + r8;
        r4 = r3;
        r6 = r7;
        goto L_0x009a;
    L_0x0092:
        r11 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r8 = r8 / r11;
        r3 = r3 + r8;
        r6 = r4;
        goto L_0x0099;
    L_0x0098:
        r6 = r0;
    L_0x0099:
        r4 = r3;
    L_0x009a:
        r11 = new com.google.android.exoplayer2.text.ttml.TtmlRegion;
        r0 = 0;
        r1 = r11;
        r3 = r5;
        r5 = r0;
        r7 = r9;
        r1.<init>(r2, r3, r4, r5, r6, r7);
        return r11;
    L_0x00a5:
        r11 = "TtmlDecoder";
        r2 = new java.lang.StringBuilder;
        r3 = "Ignoring region with malformed extent: ";
        r2.<init>(r3);
        r2.append(r1);
        r1 = r2.toString();
        android.util.Log.w(r11, r1);
        return r0;
    L_0x00b9:
        r11 = "TtmlDecoder";
        r2 = new java.lang.StringBuilder;
        r3 = "Ignoring region with unsupported extent: ";
        r2.<init>(r3);
        r2.append(r1);
        r1 = r2.toString();
        android.util.Log.w(r11, r1);
        return r0;
    L_0x00cd:
        r11 = "TtmlDecoder";
        r1 = "Ignoring region without an extent";
        android.util.Log.w(r11, r1);
        return r0;
    L_0x00d5:
        r11 = "TtmlDecoder";
        r2 = new java.lang.StringBuilder;
        r3 = "Ignoring region with malformed origin: ";
        r2.<init>(r3);
        r2.append(r1);
        r1 = r2.toString();
        android.util.Log.w(r11, r1);
        return r0;
    L_0x00e9:
        r11 = "TtmlDecoder";
        r2 = new java.lang.StringBuilder;
        r3 = "Ignoring region with unsupported origin: ";
        r2.<init>(r3);
        r2.append(r1);
        r1 = r2.toString();
        android.util.Log.w(r11, r1);
        return r0;
    L_0x00fd:
        r11 = "TtmlDecoder";
        r1 = "Ignoring region without an origin";
        android.util.Log.w(r11, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ttml.TtmlDecoder.a(org.xmlpull.v1.XmlPullParser):com.google.android.exoplayer2.text.ttml.TtmlRegion");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.text.ttml.TtmlStyle m20107a(org.xmlpull.v1.XmlPullParser r12, com.google.android.exoplayer2.text.ttml.TtmlStyle r13) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r12.getAttributeCount();
        r1 = 0;
        r2 = r13;
        r13 = r1;
    L_0x0007:
        if (r13 >= r0) goto L_0x02d6;
    L_0x0009:
        r3 = r12.getAttributeValue(r13);
        r4 = r12.getAttributeName(r13);
        r5 = r4.hashCode();
        r6 = 4;
        r7 = -1;
        r8 = 3;
        r9 = 2;
        r10 = 1;
        switch(r5) {
            case -1550943582: goto L_0x0070;
            case -1224696685: goto L_0x0066;
            case -1065511464: goto L_0x005c;
            case -879295043: goto L_0x0051;
            case -734428249: goto L_0x0047;
            case 3355: goto L_0x003d;
            case 94842723: goto L_0x0033;
            case 365601008: goto L_0x0029;
            case 1287124693: goto L_0x001f;
            default: goto L_0x001d;
        };
    L_0x001d:
        goto L_0x007a;
    L_0x001f:
        r5 = "backgroundColor";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x007a;
    L_0x0027:
        r4 = r10;
        goto L_0x007b;
    L_0x0029:
        r5 = "fontSize";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x007a;
    L_0x0031:
        r4 = r6;
        goto L_0x007b;
    L_0x0033:
        r5 = "color";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x007a;
    L_0x003b:
        r4 = r9;
        goto L_0x007b;
    L_0x003d:
        r5 = "id";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x007a;
    L_0x0045:
        r4 = r1;
        goto L_0x007b;
    L_0x0047:
        r5 = "fontWeight";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x007a;
    L_0x004f:
        r4 = 5;
        goto L_0x007b;
    L_0x0051:
        r5 = "textDecoration";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x007a;
    L_0x0059:
        r4 = 8;
        goto L_0x007b;
    L_0x005c:
        r5 = "textAlign";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x007a;
    L_0x0064:
        r4 = 7;
        goto L_0x007b;
    L_0x0066:
        r5 = "fontFamily";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x007a;
    L_0x006e:
        r4 = r8;
        goto L_0x007b;
    L_0x0070:
        r5 = "fontStyle";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x007a;
    L_0x0078:
        r4 = 6;
        goto L_0x007b;
    L_0x007a:
        r4 = r7;
    L_0x007b:
        switch(r4) {
            case 0: goto L_0x02c0;
            case 1: goto L_0x02a0;
            case 2: goto L_0x0280;
            case 3: goto L_0x0270;
            case 4: goto L_0x0194;
            case 5: goto L_0x017d;
            case 6: goto L_0x0166;
            case 7: goto L_0x00f1;
            case 8: goto L_0x0080;
            default: goto L_0x007e;
        };
    L_0x007e:
        goto L_0x02d2;
    L_0x0080:
        r3 = com.google.android.exoplayer2.util.Util.m4323d(r3);
        r4 = r3.hashCode();
        r5 = -1461280213; // 0xffffffffa8e6a22b float:-2.5605459E-14 double:NaN;
        if (r4 == r5) goto L_0x00bb;
    L_0x008d:
        r5 = -1026963764; // 0xffffffffc2c9c6cc float:-100.888275 double:NaN;
        if (r4 == r5) goto L_0x00b1;
    L_0x0092:
        r5 = 913457136; // 0x36723ff0 float:3.6098027E-6 double:4.5130779E-315;
        if (r4 == r5) goto L_0x00a7;
    L_0x0097:
        r5 = 1679736913; // 0x641ec051 float:1.1713774E22 double:8.29900303E-315;
        if (r4 == r5) goto L_0x009d;
    L_0x009c:
        goto L_0x00c4;
    L_0x009d:
        r4 = "linethrough";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x00c4;
    L_0x00a5:
        r7 = r1;
        goto L_0x00c4;
    L_0x00a7:
        r4 = "nolinethrough";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x00c4;
    L_0x00af:
        r7 = r10;
        goto L_0x00c4;
    L_0x00b1:
        r4 = "underline";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x00c4;
    L_0x00b9:
        r7 = r9;
        goto L_0x00c4;
    L_0x00bb:
        r4 = "nounderline";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x00c4;
    L_0x00c3:
        r7 = r8;
    L_0x00c4:
        switch(r7) {
            case 0: goto L_0x00e7;
            case 1: goto L_0x00dd;
            case 2: goto L_0x00d3;
            case 3: goto L_0x00c9;
            default: goto L_0x00c7;
        };
    L_0x00c7:
        goto L_0x02d2;
    L_0x00c9:
        r2 = m20106a(r2);
        r2 = r2.m4096b(r1);
        goto L_0x02d2;
    L_0x00d3:
        r2 = m20106a(r2);
        r2 = r2.m4096b(r10);
        goto L_0x02d2;
    L_0x00dd:
        r2 = m20106a(r2);
        r2 = r2.m4094a(r1);
        goto L_0x02d2;
    L_0x00e7:
        r2 = m20106a(r2);
        r2 = r2.m4094a(r10);
        goto L_0x02d2;
    L_0x00f1:
        r3 = com.google.android.exoplayer2.util.Util.m4323d(r3);
        r4 = r3.hashCode();
        switch(r4) {
            case -1364013995: goto L_0x0125;
            case 100571: goto L_0x011b;
            case 3317767: goto L_0x0111;
            case 108511772: goto L_0x0107;
            case 109757538: goto L_0x00fd;
            default: goto L_0x00fc;
        };
    L_0x00fc:
        goto L_0x012e;
    L_0x00fd:
        r4 = "start";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x012e;
    L_0x0105:
        r6 = r10;
        goto L_0x012f;
    L_0x0107:
        r4 = "right";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x012e;
    L_0x010f:
        r6 = r9;
        goto L_0x012f;
    L_0x0111:
        r4 = "left";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x012e;
    L_0x0119:
        r6 = r1;
        goto L_0x012f;
    L_0x011b:
        r4 = "end";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x012e;
    L_0x0123:
        r6 = r8;
        goto L_0x012f;
    L_0x0125:
        r4 = "center";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x012e;
    L_0x012d:
        goto L_0x012f;
    L_0x012e:
        r6 = r7;
    L_0x012f:
        switch(r6) {
            case 0: goto L_0x015c;
            case 1: goto L_0x0152;
            case 2: goto L_0x0148;
            case 3: goto L_0x013e;
            case 4: goto L_0x0134;
            default: goto L_0x0132;
        };
    L_0x0132:
        goto L_0x02d2;
    L_0x0134:
        r2 = m20106a(r2);
        r3 = android.text.Layout.Alignment.ALIGN_CENTER;
        r2.f5080n = r3;
        goto L_0x02d2;
    L_0x013e:
        r2 = m20106a(r2);
        r3 = android.text.Layout.Alignment.ALIGN_OPPOSITE;
        r2.f5080n = r3;
        goto L_0x02d2;
    L_0x0148:
        r2 = m20106a(r2);
        r3 = android.text.Layout.Alignment.ALIGN_OPPOSITE;
        r2.f5080n = r3;
        goto L_0x02d2;
    L_0x0152:
        r2 = m20106a(r2);
        r3 = android.text.Layout.Alignment.ALIGN_NORMAL;
        r2.f5080n = r3;
        goto L_0x02d2;
    L_0x015c:
        r2 = m20106a(r2);
        r3 = android.text.Layout.Alignment.ALIGN_NORMAL;
        r2.f5080n = r3;
        goto L_0x02d2;
    L_0x0166:
        r2 = m20106a(r2);
        r4 = "italic";
        r3 = r4.equalsIgnoreCase(r3);
        r4 = r2.f5079m;
        if (r4 != 0) goto L_0x0175;
    L_0x0174:
        goto L_0x0176;
    L_0x0175:
        r10 = r1;
    L_0x0176:
        com.google.android.exoplayer2.util.Assertions.m4186b(r10);
        r2.f5075i = r3;
        goto L_0x02d2;
    L_0x017d:
        r2 = m20106a(r2);
        r4 = "bold";
        r3 = r4.equalsIgnoreCase(r3);
        r4 = r2.f5079m;
        if (r4 != 0) goto L_0x018c;
    L_0x018b:
        goto L_0x018d;
    L_0x018c:
        r10 = r1;
    L_0x018d:
        com.google.android.exoplayer2.util.Assertions.m4186b(r10);
        r2.f5074h = r3;
        goto L_0x02d2;
    L_0x0194:
        r4 = m20106a(r2);	 Catch:{ SubtitleDecoderException -> 0x025c }
        r2 = "\\s+";	 Catch:{ SubtitleDecoderException -> 0x025b }
        r2 = r3.split(r2);	 Catch:{ SubtitleDecoderException -> 0x025b }
        r5 = r2.length;	 Catch:{ SubtitleDecoderException -> 0x025b }
        if (r5 != r10) goto L_0x01a8;	 Catch:{ SubtitleDecoderException -> 0x025b }
    L_0x01a1:
        r2 = f19045e;	 Catch:{ SubtitleDecoderException -> 0x025b }
        r2 = r2.matcher(r3);	 Catch:{ SubtitleDecoderException -> 0x025b }
        goto L_0x01ba;	 Catch:{ SubtitleDecoderException -> 0x025b }
    L_0x01a8:
        r5 = r2.length;	 Catch:{ SubtitleDecoderException -> 0x025b }
        if (r5 != r9) goto L_0x0241;	 Catch:{ SubtitleDecoderException -> 0x025b }
    L_0x01ab:
        r5 = f19045e;	 Catch:{ SubtitleDecoderException -> 0x025b }
        r2 = r2[r10];	 Catch:{ SubtitleDecoderException -> 0x025b }
        r2 = r5.matcher(r2);	 Catch:{ SubtitleDecoderException -> 0x025b }
        r5 = "TtmlDecoder";	 Catch:{ SubtitleDecoderException -> 0x025b }
        r6 = "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.";	 Catch:{ SubtitleDecoderException -> 0x025b }
        android.util.Log.w(r5, r6);	 Catch:{ SubtitleDecoderException -> 0x025b }
    L_0x01ba:
        r5 = r2.matches();	 Catch:{ SubtitleDecoderException -> 0x025b }
        if (r5 == 0) goto L_0x0228;	 Catch:{ SubtitleDecoderException -> 0x025b }
    L_0x01c0:
        r5 = r2.group(r8);	 Catch:{ SubtitleDecoderException -> 0x025b }
        r6 = r5.hashCode();	 Catch:{ SubtitleDecoderException -> 0x025b }
        r11 = 37;	 Catch:{ SubtitleDecoderException -> 0x025b }
        if (r6 == r11) goto L_0x01e9;	 Catch:{ SubtitleDecoderException -> 0x025b }
    L_0x01cc:
        r11 = 3240; // 0xca8 float:4.54E-42 double:1.601E-320;	 Catch:{ SubtitleDecoderException -> 0x025b }
        if (r6 == r11) goto L_0x01df;	 Catch:{ SubtitleDecoderException -> 0x025b }
    L_0x01d0:
        r11 = 3592; // 0xe08 float:5.033E-42 double:1.7747E-320;	 Catch:{ SubtitleDecoderException -> 0x025b }
        if (r6 == r11) goto L_0x01d5;	 Catch:{ SubtitleDecoderException -> 0x025b }
    L_0x01d4:
        goto L_0x01f2;	 Catch:{ SubtitleDecoderException -> 0x025b }
    L_0x01d5:
        r6 = "px";	 Catch:{ SubtitleDecoderException -> 0x025b }
        r6 = r5.equals(r6);	 Catch:{ SubtitleDecoderException -> 0x025b }
        if (r6 == 0) goto L_0x01f2;	 Catch:{ SubtitleDecoderException -> 0x025b }
    L_0x01dd:
        r7 = r1;	 Catch:{ SubtitleDecoderException -> 0x025b }
        goto L_0x01f2;	 Catch:{ SubtitleDecoderException -> 0x025b }
    L_0x01df:
        r6 = "em";	 Catch:{ SubtitleDecoderException -> 0x025b }
        r6 = r5.equals(r6);	 Catch:{ SubtitleDecoderException -> 0x025b }
        if (r6 == 0) goto L_0x01f2;	 Catch:{ SubtitleDecoderException -> 0x025b }
    L_0x01e7:
        r7 = r10;	 Catch:{ SubtitleDecoderException -> 0x025b }
        goto L_0x01f2;	 Catch:{ SubtitleDecoderException -> 0x025b }
    L_0x01e9:
        r6 = "%";	 Catch:{ SubtitleDecoderException -> 0x025b }
        r6 = r5.equals(r6);	 Catch:{ SubtitleDecoderException -> 0x025b }
        if (r6 == 0) goto L_0x01f2;	 Catch:{ SubtitleDecoderException -> 0x025b }
    L_0x01f1:
        r7 = r9;	 Catch:{ SubtitleDecoderException -> 0x025b }
    L_0x01f2:
        switch(r7) {
            case 0: goto L_0x01fe;
            case 1: goto L_0x01fb;
            case 2: goto L_0x01f8;
            default: goto L_0x01f5;
        };	 Catch:{ SubtitleDecoderException -> 0x025b }
    L_0x01f5:
        r2 = new com.google.android.exoplayer2.text.SubtitleDecoderException;	 Catch:{ SubtitleDecoderException -> 0x025b }
        goto L_0x0211;	 Catch:{ SubtitleDecoderException -> 0x025b }
    L_0x01f8:
        r4.f5076j = r8;	 Catch:{ SubtitleDecoderException -> 0x025b }
        goto L_0x0200;	 Catch:{ SubtitleDecoderException -> 0x025b }
    L_0x01fb:
        r4.f5076j = r9;	 Catch:{ SubtitleDecoderException -> 0x025b }
        goto L_0x0200;	 Catch:{ SubtitleDecoderException -> 0x025b }
    L_0x01fe:
        r4.f5076j = r10;	 Catch:{ SubtitleDecoderException -> 0x025b }
    L_0x0200:
        r2 = r2.group(r10);	 Catch:{ SubtitleDecoderException -> 0x025b }
        r2 = java.lang.Float.valueOf(r2);	 Catch:{ SubtitleDecoderException -> 0x025b }
        r2 = r2.floatValue();	 Catch:{ SubtitleDecoderException -> 0x025b }
        r4.f5077k = r2;	 Catch:{ SubtitleDecoderException -> 0x025b }
        r2 = r4;	 Catch:{ SubtitleDecoderException -> 0x025b }
        goto L_0x02d2;	 Catch:{ SubtitleDecoderException -> 0x025b }
    L_0x0211:
        r6 = new java.lang.StringBuilder;	 Catch:{ SubtitleDecoderException -> 0x025b }
        r7 = "Invalid unit for fontSize: '";	 Catch:{ SubtitleDecoderException -> 0x025b }
        r6.<init>(r7);	 Catch:{ SubtitleDecoderException -> 0x025b }
        r6.append(r5);	 Catch:{ SubtitleDecoderException -> 0x025b }
        r5 = "'.";	 Catch:{ SubtitleDecoderException -> 0x025b }
        r6.append(r5);	 Catch:{ SubtitleDecoderException -> 0x025b }
        r5 = r6.toString();	 Catch:{ SubtitleDecoderException -> 0x025b }
        r2.<init>(r5);	 Catch:{ SubtitleDecoderException -> 0x025b }
        throw r2;	 Catch:{ SubtitleDecoderException -> 0x025b }
    L_0x0228:
        r2 = new com.google.android.exoplayer2.text.SubtitleDecoderException;	 Catch:{ SubtitleDecoderException -> 0x025b }
        r5 = new java.lang.StringBuilder;	 Catch:{ SubtitleDecoderException -> 0x025b }
        r6 = "Invalid expression for fontSize: '";	 Catch:{ SubtitleDecoderException -> 0x025b }
        r5.<init>(r6);	 Catch:{ SubtitleDecoderException -> 0x025b }
        r5.append(r3);	 Catch:{ SubtitleDecoderException -> 0x025b }
        r6 = "'.";	 Catch:{ SubtitleDecoderException -> 0x025b }
        r5.append(r6);	 Catch:{ SubtitleDecoderException -> 0x025b }
        r5 = r5.toString();	 Catch:{ SubtitleDecoderException -> 0x025b }
        r2.<init>(r5);	 Catch:{ SubtitleDecoderException -> 0x025b }
        throw r2;	 Catch:{ SubtitleDecoderException -> 0x025b }
    L_0x0241:
        r5 = new com.google.android.exoplayer2.text.SubtitleDecoderException;	 Catch:{ SubtitleDecoderException -> 0x025b }
        r6 = new java.lang.StringBuilder;	 Catch:{ SubtitleDecoderException -> 0x025b }
        r7 = "Invalid number of entries for fontSize: ";	 Catch:{ SubtitleDecoderException -> 0x025b }
        r6.<init>(r7);	 Catch:{ SubtitleDecoderException -> 0x025b }
        r2 = r2.length;	 Catch:{ SubtitleDecoderException -> 0x025b }
        r6.append(r2);	 Catch:{ SubtitleDecoderException -> 0x025b }
        r2 = ".";	 Catch:{ SubtitleDecoderException -> 0x025b }
        r6.append(r2);	 Catch:{ SubtitleDecoderException -> 0x025b }
        r2 = r6.toString();	 Catch:{ SubtitleDecoderException -> 0x025b }
        r5.<init>(r2);	 Catch:{ SubtitleDecoderException -> 0x025b }
        throw r5;	 Catch:{ SubtitleDecoderException -> 0x025b }
    L_0x025b:
        r2 = r4;
    L_0x025c:
        r4 = "TtmlDecoder";
        r5 = new java.lang.StringBuilder;
        r6 = "Failed parsing fontSize value: ";
        r5.<init>(r6);
        r5.append(r3);
        r3 = r5.toString();
        android.util.Log.w(r4, r3);
        goto L_0x02d2;
    L_0x0270:
        r2 = m20106a(r2);
        r4 = r2.f5079m;
        if (r4 != 0) goto L_0x0279;
    L_0x0278:
        goto L_0x027a;
    L_0x0279:
        r10 = r1;
    L_0x027a:
        com.google.android.exoplayer2.util.Assertions.m4186b(r10);
        r2.f5067a = r3;
        goto L_0x02d2;
    L_0x0280:
        r2 = m20106a(r2);
        r4 = com.google.android.exoplayer2.util.ColorParser.m4200a(r3);	 Catch:{ IllegalArgumentException -> 0x028c }
        r2.m4092a(r4);	 Catch:{ IllegalArgumentException -> 0x028c }
        goto L_0x02d2;
    L_0x028c:
        r4 = "TtmlDecoder";
        r5 = new java.lang.StringBuilder;
        r6 = "Failed parsing color value: ";
        r5.<init>(r6);
        r5.append(r3);
        r3 = r5.toString();
        android.util.Log.w(r4, r3);
        goto L_0x02d2;
    L_0x02a0:
        r2 = m20106a(r2);
        r4 = com.google.android.exoplayer2.util.ColorParser.m4200a(r3);	 Catch:{ IllegalArgumentException -> 0x02ac }
        r2.m4095b(r4);	 Catch:{ IllegalArgumentException -> 0x02ac }
        goto L_0x02d2;
    L_0x02ac:
        r4 = "TtmlDecoder";
        r5 = new java.lang.StringBuilder;
        r6 = "Failed parsing background value: ";
        r5.<init>(r6);
        r5.append(r3);
        r3 = r5.toString();
        android.util.Log.w(r4, r3);
        goto L_0x02d2;
    L_0x02c0:
        r4 = "style";
        r5 = r12.getName();
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x02d2;
    L_0x02cc:
        r2 = m20106a(r2);
        r2.f5078l = r3;
    L_0x02d2:
        r13 = r13 + 1;
        goto L_0x0007;
    L_0x02d6:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ttml.TtmlDecoder.a(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlStyle):com.google.android.exoplayer2.text.ttml.TtmlStyle");
    }

    private static TtmlStyle m20106a(TtmlStyle ttmlStyle) {
        return ttmlStyle == null ? new TtmlStyle() : ttmlStyle;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.text.ttml.TtmlNode m20104a(org.xmlpull.v1.XmlPullParser r19, com.google.android.exoplayer2.text.ttml.TtmlNode r20, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlRegion> r21, com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate r22) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        /*
        r0 = r19;
        r1 = r20;
        r2 = r22;
        r3 = "";
        r4 = r19.getAttributeCount();
        r5 = 0;
        r11 = m20107a(r0, r5);
        r16 = r5;
        r9 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r12 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r14 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r5 = r3;
        r3 = 0;
    L_0x0024:
        if (r3 >= r4) goto L_0x00a1;
    L_0x0026:
        r6 = r0.getAttributeName(r3);
        r7 = r0.getAttributeValue(r3);
        r17 = r6.hashCode();
        switch(r17) {
            case -934795532: goto L_0x005e;
            case 99841: goto L_0x0054;
            case 100571: goto L_0x004a;
            case 93616297: goto L_0x0040;
            case 109780401: goto L_0x0036;
            default: goto L_0x0035;
        };
    L_0x0035:
        goto L_0x0068;
    L_0x0036:
        r8 = "style";
        r6 = r6.equals(r8);
        if (r6 == 0) goto L_0x0068;
    L_0x003e:
        r6 = 3;
        goto L_0x0069;
    L_0x0040:
        r8 = "begin";
        r6 = r6.equals(r8);
        if (r6 == 0) goto L_0x0068;
    L_0x0048:
        r6 = 0;
        goto L_0x0069;
    L_0x004a:
        r8 = "end";
        r6 = r6.equals(r8);
        if (r6 == 0) goto L_0x0068;
    L_0x0052:
        r6 = 1;
        goto L_0x0069;
    L_0x0054:
        r8 = "dur";
        r6 = r6.equals(r8);
        if (r6 == 0) goto L_0x0068;
    L_0x005c:
        r6 = 2;
        goto L_0x0069;
    L_0x005e:
        r8 = "region";
        r6 = r6.equals(r8);
        if (r6 == 0) goto L_0x0068;
    L_0x0066:
        r6 = 4;
        goto L_0x0069;
    L_0x0068:
        r6 = -1;
    L_0x0069:
        switch(r6) {
            case 0: goto L_0x0097;
            case 1: goto L_0x008f;
            case 2: goto L_0x0087;
            case 3: goto L_0x0079;
            case 4: goto L_0x006f;
            default: goto L_0x006c;
        };
    L_0x006c:
        r6 = r21;
        goto L_0x009e;
    L_0x006f:
        r6 = r21;
        r8 = r6.containsKey(r7);
        if (r8 == 0) goto L_0x009e;
    L_0x0077:
        r5 = r7;
        goto L_0x009e;
    L_0x0079:
        r6 = r21;
        r8 = "\\s+";
        r7 = r7.split(r8);
        r8 = r7.length;
        if (r8 <= 0) goto L_0x009e;
    L_0x0084:
        r16 = r7;
        goto L_0x009e;
    L_0x0087:
        r6 = r21;
        r7 = m20103a(r7, r2);
        r14 = r7;
        goto L_0x009e;
    L_0x008f:
        r6 = r21;
        r7 = m20103a(r7, r2);
        r12 = r7;
        goto L_0x009e;
    L_0x0097:
        r6 = r21;
        r7 = m20103a(r7, r2);
        r9 = r7;
    L_0x009e:
        r3 = r3 + 1;
        goto L_0x0024;
    L_0x00a1:
        if (r1 == 0) goto L_0x00bd;
    L_0x00a3:
        r2 = r1.f5053d;
        r6 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x00c2;
    L_0x00ae:
        r2 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x00b5;
    L_0x00b2:
        r2 = r1.f5053d;
        r9 = r9 + r2;
    L_0x00b5:
        r2 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x00c2;
    L_0x00b9:
        r2 = r1.f5053d;
        r12 = r12 + r2;
        goto L_0x00c2;
    L_0x00bd:
        r6 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
    L_0x00c2:
        r2 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1));
        if (r2 != 0) goto L_0x00d8;
    L_0x00c6:
        r2 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x00cd;
    L_0x00ca:
        r14 = r14 + r9;
        r12 = r14;
        goto L_0x00d8;
    L_0x00cd:
        if (r1 == 0) goto L_0x00d8;
    L_0x00cf:
        r2 = r1.f5054e;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x00d8;
    L_0x00d5:
        r1 = r1.f5054e;
        r12 = r1;
    L_0x00d8:
        r6 = r19.getName();
        r7 = r9;
        r9 = r12;
        r12 = r16;
        r13 = r5;
        r0 = com.google.android.exoplayer2.text.ttml.TtmlNode.m4080a(r6, r7, r9, r11, r12, r13);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ttml.TtmlDecoder.a(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlNode, java.util.Map, com.google.android.exoplayer2.text.ttml.TtmlDecoder$FrameAndTickRate):com.google.android.exoplayer2.text.ttml.TtmlNode");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long m20103a(java.lang.String r14, com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate r15) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        /*
        r0 = f19043c;
        r0 = r0.matcher(r14);
        r1 = r0.matches();
        r2 = 4696837146684686336; // 0x412e848000000000 float:0.0 double:1000000.0;
        r4 = 5;
        r5 = 4;
        r6 = 3;
        r7 = 2;
        r8 = 1;
        if (r1 == 0) goto L_0x0073;
    L_0x0016:
        r14 = r0.group(r8);
        r8 = java.lang.Long.parseLong(r14);
        r10 = 3600; // 0xe10 float:5.045E-42 double:1.7786E-320;
        r8 = r8 * r10;
        r8 = (double) r8;
        r14 = r0.group(r7);
        r10 = java.lang.Long.parseLong(r14);
        r12 = 60;
        r10 = r10 * r12;
        r10 = (double) r10;
        r8 = r8 + r10;
        r14 = r0.group(r6);
        r6 = java.lang.Long.parseLong(r14);
        r6 = (double) r6;
        r8 = r8 + r6;
        r14 = r0.group(r5);
        r5 = 0;
        if (r14 == 0) goto L_0x0046;
    L_0x0041:
        r10 = java.lang.Double.parseDouble(r14);
        goto L_0x0047;
    L_0x0046:
        r10 = r5;
    L_0x0047:
        r8 = r8 + r10;
        r14 = r0.group(r4);
        if (r14 == 0) goto L_0x0058;
    L_0x004e:
        r10 = java.lang.Long.parseLong(r14);
        r14 = (float) r10;
        r1 = r15.f5047a;
        r14 = r14 / r1;
        r10 = (double) r14;
        goto L_0x0059;
    L_0x0058:
        r10 = r5;
    L_0x0059:
        r8 = r8 + r10;
        r14 = 6;
        r14 = r0.group(r14);
        if (r14 == 0) goto L_0x006f;
    L_0x0061:
        r0 = java.lang.Long.parseLong(r14);
        r0 = (double) r0;
        r14 = r15.f5048b;
        r4 = (double) r14;
        r0 = r0 / r4;
        r14 = r15.f5047a;
        r14 = (double) r14;
        r5 = r0 / r14;
    L_0x006f:
        r8 = r8 + r5;
        r8 = r8 * r2;
        r14 = (long) r8;
        return r14;
    L_0x0073:
        r0 = f19044d;
        r0 = r0.matcher(r14);
        r1 = r0.matches();
        if (r1 == 0) goto L_0x0102;
    L_0x007f:
        r14 = r0.group(r8);
        r9 = java.lang.Double.parseDouble(r14);
        r14 = r0.group(r7);
        r0 = -1;
        r1 = r14.hashCode();
        r11 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        if (r1 == r11) goto L_0x00d5;
    L_0x0094:
        r5 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        if (r1 == r5) goto L_0x00cb;
    L_0x0098:
        r5 = 109; // 0x6d float:1.53E-43 double:5.4E-322;
        if (r1 == r5) goto L_0x00c1;
    L_0x009c:
        r5 = 3494; // 0xda6 float:4.896E-42 double:1.7263E-320;
        if (r1 == r5) goto L_0x00b7;
    L_0x00a0:
        switch(r1) {
            case 115: goto L_0x00ad;
            case 116: goto L_0x00a4;
            default: goto L_0x00a3;
        };
    L_0x00a3:
        goto L_0x00df;
    L_0x00a4:
        r1 = "t";
        r14 = r14.equals(r1);
        if (r14 == 0) goto L_0x00df;
    L_0x00ac:
        goto L_0x00e0;
    L_0x00ad:
        r1 = "s";
        r14 = r14.equals(r1);
        if (r14 == 0) goto L_0x00df;
    L_0x00b5:
        r4 = r7;
        goto L_0x00e0;
    L_0x00b7:
        r1 = "ms";
        r14 = r14.equals(r1);
        if (r14 == 0) goto L_0x00df;
    L_0x00bf:
        r4 = r6;
        goto L_0x00e0;
    L_0x00c1:
        r1 = "m";
        r14 = r14.equals(r1);
        if (r14 == 0) goto L_0x00df;
    L_0x00c9:
        r4 = r8;
        goto L_0x00e0;
    L_0x00cb:
        r1 = "h";
        r14 = r14.equals(r1);
        if (r14 == 0) goto L_0x00df;
    L_0x00d3:
        r4 = 0;
        goto L_0x00e0;
    L_0x00d5:
        r1 = "f";
        r14 = r14.equals(r1);
        if (r14 == 0) goto L_0x00df;
    L_0x00dd:
        r4 = r5;
        goto L_0x00e0;
    L_0x00df:
        r4 = r0;
    L_0x00e0:
        switch(r4) {
            case 0: goto L_0x00f9;
            case 1: goto L_0x00f5;
            case 2: goto L_0x00ff;
            case 3: goto L_0x00ee;
            case 4: goto L_0x00e9;
            case 5: goto L_0x00e4;
            default: goto L_0x00e3;
        };
    L_0x00e3:
        goto L_0x00ff;
    L_0x00e4:
        r14 = r15.f5049c;
        r14 = (double) r14;
        r9 = r9 / r14;
        goto L_0x00ff;
    L_0x00e9:
        r14 = r15.f5047a;
        r14 = (double) r14;
        r9 = r9 / r14;
        goto L_0x00ff;
    L_0x00ee:
        r14 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r9 = r9 / r14;
        goto L_0x00ff;
    L_0x00f5:
        r14 = 4633641066610819072; // 0x404e000000000000 float:0.0 double:60.0;
        r9 = r9 * r14;
        goto L_0x00ff;
    L_0x00f9:
        r14 = 4660134898793709568; // 0x40ac200000000000 float:0.0 double:3600.0;
        r9 = r9 * r14;
    L_0x00ff:
        r9 = r9 * r2;
        r14 = (long) r9;
        return r14;
    L_0x0102:
        r15 = new com.google.android.exoplayer2.text.SubtitleDecoderException;
        r0 = new java.lang.StringBuilder;
        r1 = "Malformed time expression: ";
        r0.<init>(r1);
        r0.append(r14);
        r14 = r0.toString();
        r15.<init>(r14);
        throw r15;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ttml.TtmlDecoder.a(java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlDecoder$FrameAndTickRate):long");
    }
}
