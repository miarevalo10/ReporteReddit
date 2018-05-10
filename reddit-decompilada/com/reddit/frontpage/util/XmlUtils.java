package com.reddit.frontpage.util;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class XmlUtils {

    public static class XMLObject {
        HashMap<String, String> f21821a;
        List<XMLObject> f21822b;
        public String f21823c;
        public String f21824d;

        public final XMLObject m24067a(String str) {
            if (this.f21822b == null) {
                return null;
            }
            for (XMLObject xMLObject : this.f21822b) {
                if (str.equalsIgnoreCase(xMLObject.f21824d)) {
                    return xMLObject;
                }
            }
            return null;
        }
    }

    public static final int m24068a(CharSequence charSequence) {
        if (charSequence == null) {
            return -1;
        }
        int i;
        int i2;
        charSequence = charSequence.toString();
        int length = charSequence.length();
        int i3 = 10;
        if ('-' == charSequence.charAt(0)) {
            i = -1;
            i2 = 1;
        } else {
            i2 = 0;
            i = 1;
        }
        if ('0' != charSequence.charAt(i2)) {
            if ('#' == charSequence.charAt(i2)) {
                i2++;
            }
            return Integer.parseInt(charSequence.substring(i2), i3) * i;
        } else if (i2 == length - 1) {
            return 0;
        } else {
            length = i2 + 1;
            char charAt = charSequence.charAt(length);
            if ('x' != charAt) {
                if ('X' != charAt) {
                    i3 = 8;
                    i2 = length;
                    return Integer.parseInt(charSequence.substring(i2), i3) * i;
                }
            }
            i2 += 2;
        }
        i3 = 16;
        return Integer.parseInt(charSequence.substring(i2), i3) * i;
    }

    public static XMLObject m24069a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        HashMap hashMap = new HashMap();
        int eventType = xmlPullParser.getEventType();
        XMLObject xMLObject = null;
        Deque deque = xMLObject;
        String str = deque;
        while (eventType != 1) {
            if (eventType == 0) {
                deque = new ArrayDeque();
            } else if (eventType == 2) {
                r1 = xmlPullParser.getName();
                xMLObject = new XMLObject();
                xMLObject.f21824d = r1;
                deque.push(r1);
                int attributeCount = xmlPullParser.getAttributeCount();
                if (attributeCount > 0) {
                    HashMap hashMap2 = new HashMap(attributeCount);
                    for (int i = 0; i < attributeCount; i++) {
                        hashMap2.put(xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i));
                    }
                    xMLObject.f21821a = hashMap2;
                }
                hashMap.put(r1, xMLObject);
            } else if (eventType == 3) {
                r1 = xmlPullParser.getName();
                String str2 = (String) deque.pop();
                if (deque.size() == 0) {
                    xMLObject = (XMLObject) hashMap.get(r1);
                    xMLObject.f21823c = str;
                    hashMap.put(str2, xMLObject);
                } else {
                    str2 = (String) deque.getLast();
                    if (hashMap.containsKey(r1)) {
                        XMLObject xMLObject2 = (XMLObject) hashMap.get(r1);
                        hashMap.remove(r1);
                        xMLObject2.f21823c = str;
                        XMLObject xMLObject3 = (XMLObject) hashMap.get(str2);
                        List list = xMLObject3.f21822b;
                        if (list == null) {
                            list = new ArrayList();
                        }
                        list.add(xMLObject2);
                        xMLObject3.f21822b = list;
                        hashMap.put(str2, xMLObject3);
                    }
                }
                str = null;
            } else if (eventType == 4) {
                str = xmlPullParser.getText();
            }
            eventType = xmlPullParser.next();
        }
        return xMLObject;
    }
}
