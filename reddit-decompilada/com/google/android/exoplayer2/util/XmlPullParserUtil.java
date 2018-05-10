package com.google.android.exoplayer2.util;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class XmlPullParserUtil {
    public static boolean m4332b(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        return (!m4330a(xmlPullParser) || xmlPullParser.getName().equals(str) == null) ? null : true;
    }

    public static boolean m4330a(XmlPullParser xmlPullParser) throws XmlPullParserException {
        return xmlPullParser.getEventType() == 2 ? true : null;
    }

    public static String m4333c(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (str.equals(xmlPullParser.getAttributeName(i))) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }

    public static boolean m4331a(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        return (xmlPullParser.getEventType() == 3) && xmlPullParser.getName().equals(str) != null;
    }
}
