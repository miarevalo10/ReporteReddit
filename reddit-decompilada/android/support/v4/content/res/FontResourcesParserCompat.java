package android.support.v4.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.compat.C0003R;
import android.support.v4.provider.FontRequest;
import android.util.Base64;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class FontResourcesParserCompat {

    public interface FamilyResourceEntry {
    }

    public static final class FontFileResourceEntry {
        public final String f1231a;
        public int f1232b;
        public boolean f1233c;
        public int f1234d;

        public FontFileResourceEntry(String str, int i, boolean z, int i2) {
            this.f1231a = str;
            this.f1232b = i;
            this.f1233c = z;
            this.f1234d = i2;
        }
    }

    public static final class FontFamilyFilesResourceEntry implements FamilyResourceEntry {
        public final FontFileResourceEntry[] f11416a;

        public FontFamilyFilesResourceEntry(FontFileResourceEntry[] fontFileResourceEntryArr) {
            this.f11416a = fontFileResourceEntryArr;
        }
    }

    public static final class ProviderResourceEntry implements FamilyResourceEntry {
        public final FontRequest f11417a;
        public final int f11418b;
        public final int f11419c;

        public ProviderResourceEntry(FontRequest fontRequest, int i, int i2) {
            this.f11417a = fontRequest;
            this.f11419c = i;
            this.f11418b = i2;
        }
    }

    public static FamilyResourceEntry m761a(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return m765b(xmlPullParser, resources);
        }
        m764a(xmlPullParser);
        return null;
    }

    private static FamilyResourceEntry m765b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), C0003R.styleable.FontFamily);
        String string = obtainAttributes.getString(C0003R.styleable.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(C0003R.styleable.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(C0003R.styleable.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(C0003R.styleable.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(C0003R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(C0003R.styleable.FontFamily_fontProviderFetchTimeout, 500);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            List arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(m766c(xmlPullParser, resources));
                    } else {
                        m764a(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty() != null) {
                return null;
            }
            return new FontFamilyFilesResourceEntry((FontFileResourceEntry[]) arrayList.toArray(new FontFileResourceEntry[arrayList.size()]));
        }
        while (xmlPullParser.next() != 3) {
            m764a(xmlPullParser);
        }
        return new ProviderResourceEntry(new FontRequest(string, string2, string3, m762a(resources, resourceId)), integer, integer2);
    }

    public static List<List<byte[]>> m762a(Resources resources, int i) {
        List<List<byte[]>> list = null;
        if (i != 0) {
            TypedArray obtainTypedArray = resources.obtainTypedArray(i);
            if (obtainTypedArray.length() > 0) {
                list = new ArrayList();
                if ((obtainTypedArray.getResourceId(0, 0) != 0 ? 1 : 0) != 0) {
                    for (i = 0; i < obtainTypedArray.length(); i++) {
                        list.add(m763a(resources.getStringArray(obtainTypedArray.getResourceId(i, 0))));
                    }
                } else {
                    list.add(m763a(resources.getStringArray(i)));
                }
            }
            obtainTypedArray.recycle();
        }
        if (list != null) {
            return list;
        }
        return Collections.emptyList();
    }

    private static List<byte[]> m763a(String[] strArr) {
        List<byte[]> arrayList = new ArrayList();
        for (String decode : strArr) {
            arrayList.add(Base64.decode(decode, 0));
        }
        return arrayList;
    }

    private static FontFileResourceEntry m766c(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        resources = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), C0003R.styleable.FontFamilyFont);
        int i = resources.getInt(resources.hasValue(C0003R.styleable.FontFamilyFont_fontWeight) ? C0003R.styleable.FontFamilyFont_fontWeight : C0003R.styleable.FontFamilyFont_android_fontWeight, 400);
        boolean z = true;
        if (1 != resources.getInt(resources.hasValue(C0003R.styleable.FontFamilyFont_fontStyle) ? C0003R.styleable.FontFamilyFont_fontStyle : C0003R.styleable.FontFamilyFont_android_fontStyle, 0)) {
            z = false;
        }
        int i2 = resources.hasValue(C0003R.styleable.FontFamilyFont_font) ? C0003R.styleable.FontFamilyFont_font : C0003R.styleable.FontFamilyFont_android_font;
        int resourceId = resources.getResourceId(i2, 0);
        String string = resources.getString(i2);
        resources.recycle();
        while (xmlPullParser.next() != 3) {
            m764a(xmlPullParser);
        }
        return new FontFileResourceEntry(string, i, z, resourceId);
    }

    private static void m764a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            switch (xmlPullParser.next()) {
                case 2:
                    i++;
                    break;
                case 3:
                    i--;
                    break;
                default:
                    break;
            }
        }
    }
}
