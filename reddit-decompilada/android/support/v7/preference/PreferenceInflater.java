package android.support.v7.preference;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class PreferenceInflater {
    private static final Class<?>[] f1915a = new Class[]{Context.class, AttributeSet.class};
    private static final HashMap<String, Constructor> f1916b = new HashMap();
    private final Context f1917c;
    private final Object[] f1918d = new Object[2];
    private PreferenceManager f1919e;
    private String[] f1920f;

    public PreferenceInflater(Context context, PreferenceManager preferenceManager) {
        this.f1917c = context;
        this.f1919e = preferenceManager;
        this.f1920f = new String[]{"android.support.v14.preference.", "android.support.v7.preference."};
    }

    private Preference m1638a(XmlPullParser xmlPullParser, PreferenceGroup preferenceGroup) {
        Preference preference;
        synchronized (this.f1918d) {
            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
            this.f1918d[0] = this.f1917c;
            int next;
            do {
                try {
                    next = xmlPullParser.next();
                    if (next == 2) {
                        break;
                    }
                } catch (XmlPullParser xmlPullParser2) {
                    throw xmlPullParser2;
                } catch (XmlPullParser xmlPullParser22) {
                    preferenceGroup = new InflateException(xmlPullParser22.getMessage());
                    preferenceGroup.initCause(xmlPullParser22);
                    throw preferenceGroup;
                } catch (PreferenceGroup preferenceGroup2) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(xmlPullParser22.getPositionDescription());
                    stringBuilder.append(": ");
                    stringBuilder.append(preferenceGroup2.getMessage());
                    InflateException inflateException = new InflateException(stringBuilder.toString());
                    inflateException.initCause(preferenceGroup2);
                    throw inflateException;
                }
            } while (next != 1);
            if (next != 2) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(xmlPullParser22.getPositionDescription());
                stringBuilder2.append(": No start tag found!");
                throw new InflateException(stringBuilder2.toString());
            }
            Preference preference2 = (PreferenceGroup) m1636a(xmlPullParser22.getName(), asAttributeSet);
            if (preferenceGroup2 == null) {
                preference2.m1593a((PreferenceManager) this.f1919e);
                preference = preference2;
            }
            m1640a(xmlPullParser22, preference, asAttributeSet);
        }
        return preference;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.support.v7.preference.Preference m1637a(java.lang.String r9, java.lang.String[] r10, android.util.AttributeSet r11) throws java.lang.ClassNotFoundException, android.view.InflateException {
        /*
        r8 = this;
        r0 = f1916b;
        r0 = r0.get(r9);
        r0 = (java.lang.reflect.Constructor) r0;
        r1 = 1;
        if (r0 != 0) goto L_0x0072;
    L_0x000b:
        r0 = r8.f1917c;	 Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x006e }
        r0 = r0.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x006e }
        if (r10 == 0) goto L_0x005b;
    L_0x0013:
        r2 = r10.length;	 Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x006e }
        if (r2 != 0) goto L_0x0017;
    L_0x0016:
        goto L_0x005b;
    L_0x0017:
        r2 = r10.length;	 Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x006e }
        r3 = 0;
        r4 = 0;
        r5 = r4;
    L_0x001b:
        if (r3 >= r2) goto L_0x0038;
    L_0x001d:
        r6 = r10[r3];	 Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x006e }
        r7 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0034, Exception -> 0x006e }
        r7.<init>();	 Catch:{ ClassNotFoundException -> 0x0034, Exception -> 0x006e }
        r7.append(r6);	 Catch:{ ClassNotFoundException -> 0x0034, Exception -> 0x006e }
        r7.append(r9);	 Catch:{ ClassNotFoundException -> 0x0034, Exception -> 0x006e }
        r6 = r7.toString();	 Catch:{ ClassNotFoundException -> 0x0034, Exception -> 0x006e }
        r6 = r0.loadClass(r6);	 Catch:{ ClassNotFoundException -> 0x0034, Exception -> 0x006e }
        r4 = r6;
        goto L_0x0038;
    L_0x0034:
        r5 = move-exception;
        r3 = r3 + 1;
        goto L_0x001b;
    L_0x0038:
        if (r4 != 0) goto L_0x005f;
    L_0x003a:
        if (r5 != 0) goto L_0x005a;
    L_0x003c:
        r10 = new android.view.InflateException;	 Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x006e }
        r0 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x006e }
        r0.<init>();	 Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x006e }
        r1 = r11.getPositionDescription();	 Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x006e }
        r0.append(r1);	 Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x006e }
        r1 = ": Error inflating class ";
        r0.append(r1);	 Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x006e }
        r0.append(r9);	 Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x006e }
        r0 = r0.toString();	 Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x006e }
        r10.<init>(r0);	 Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x006e }
        throw r10;	 Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x006e }
    L_0x005a:
        throw r5;	 Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x006e }
    L_0x005b:
        r4 = r0.loadClass(r9);	 Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x006e }
    L_0x005f:
        r10 = f1915a;	 Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x006e }
        r0 = r4.getConstructor(r10);	 Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x006e }
        r0.setAccessible(r1);	 Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x006e }
        r10 = f1916b;	 Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x006e }
        r10.put(r9, r0);	 Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x006e }
        goto L_0x0072;
    L_0x006e:
        r10 = move-exception;
        goto L_0x007d;
    L_0x0070:
        r9 = move-exception;
        goto L_0x009e;
    L_0x0072:
        r10 = r8.f1918d;	 Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x006e }
        r10[r1] = r11;	 Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x006e }
        r10 = r0.newInstance(r10);	 Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x006e }
        r10 = (android.support.v7.preference.Preference) r10;	 Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x006e }
        return r10;
    L_0x007d:
        r0 = new android.view.InflateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r11 = r11.getPositionDescription();
        r1.append(r11);
        r11 = ": Error inflating class ";
        r1.append(r11);
        r1.append(r9);
        r9 = r1.toString();
        r0.<init>(r9);
        r0.initCause(r10);
        throw r0;
    L_0x009e:
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.preference.PreferenceInflater.a(java.lang.String, java.lang.String[], android.util.AttributeSet):android.support.v7.preference.Preference");
    }

    private Preference m1636a(String str, AttributeSet attributeSet) {
        StringBuilder stringBuilder;
        InflateException inflateException;
        try {
            return -1 == str.indexOf(46) ? m1637a(str, this.f1920f, attributeSet) : m1637a(str, null, attributeSet);
        } catch (String str2) {
            throw str2;
        } catch (Throwable e) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(attributeSet.getPositionDescription());
            stringBuilder.append(": Error inflating class (not found)");
            stringBuilder.append(str2);
            inflateException = new InflateException(stringBuilder.toString());
            inflateException.initCause(e);
            throw inflateException;
        } catch (Throwable e2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(attributeSet.getPositionDescription());
            stringBuilder.append(": Error inflating class ");
            stringBuilder.append(str2);
            inflateException = new InflateException(stringBuilder.toString());
            inflateException.initCause(e2);
            throw inflateException;
        }
    }

    private void m1640a(XmlPullParser xmlPullParser, Preference preference, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if ("intent".equals(name)) {
                    try {
                        preference.f1899r = Intent.parseIntent(this.f1917c.getResources(), xmlPullParser, attributeSet);
                    } catch (XmlPullParser xmlPullParser2) {
                        preference = new XmlPullParserException("Error parsing preference");
                        preference.initCause(xmlPullParser2);
                        throw preference;
                    }
                } else if ("extra".equals(name)) {
                    Resources resources = this.f1917c.getResources();
                    String str = "extra";
                    if (preference.f1901t == null) {
                        preference.f1901t = new Bundle();
                    }
                    resources.parseBundleExtra(str, attributeSet, preference.f1901t);
                    try {
                        m1639a(xmlPullParser2);
                    } catch (XmlPullParser xmlPullParser22) {
                        preference = new XmlPullParserException("Error parsing preference");
                        preference.initCause(xmlPullParser22);
                        throw preference;
                    }
                } else {
                    Preference a = m1636a(name, attributeSet);
                    ((PreferenceGroup) preference).m10345b(a);
                    m1640a(xmlPullParser22, a, attributeSet);
                }
            }
        }
    }

    private static void m1639a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return;
            }
        }
    }

    public final Preference m1641a(int i, PreferenceGroup preferenceGroup) {
        XmlPullParser xml = this.f1917c.getResources().getXml(i);
        try {
            preferenceGroup = m1638a(xml, preferenceGroup);
            return preferenceGroup;
        } finally {
            xml.close();
        }
    }
}
