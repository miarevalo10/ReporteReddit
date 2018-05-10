package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class ColorParser {
    private static final Pattern f5220a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern f5221b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern f5222c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    private static final Map<String, Integer> f5223d;

    private static int m4199a(int i, int i2, int i3, int i4) {
        return (((i << 24) | (i2 << 16)) | (i3 << 8)) | i4;
    }

    static {
        Map hashMap = new HashMap();
        f5223d = hashMap;
        hashMap.put("aliceblue", Integer.valueOf(-984833));
        f5223d.put("antiquewhite", Integer.valueOf(-332841));
        f5223d.put("aqua", Integer.valueOf(-16711681));
        f5223d.put("aquamarine", Integer.valueOf(-8388652));
        f5223d.put("azure", Integer.valueOf(-983041));
        f5223d.put("beige", Integer.valueOf(-657956));
        f5223d.put("bisque", Integer.valueOf(-6972));
        f5223d.put("black", Integer.valueOf(-16777216));
        f5223d.put("blanchedalmond", Integer.valueOf(-5171));
        f5223d.put("blue", Integer.valueOf(-16776961));
        f5223d.put("blueviolet", Integer.valueOf(-7722014));
        f5223d.put("brown", Integer.valueOf(-5952982));
        f5223d.put("burlywood", Integer.valueOf(-2180985));
        f5223d.put("cadetblue", Integer.valueOf(-10510688));
        f5223d.put("chartreuse", Integer.valueOf(-8388864));
        f5223d.put("chocolate", Integer.valueOf(-2987746));
        f5223d.put("coral", Integer.valueOf(-32944));
        f5223d.put("cornflowerblue", Integer.valueOf(-10185235));
        f5223d.put("cornsilk", Integer.valueOf(-1828));
        f5223d.put("crimson", Integer.valueOf(-2354116));
        f5223d.put("cyan", Integer.valueOf(-16711681));
        f5223d.put("darkblue", Integer.valueOf(-16777077));
        f5223d.put("darkcyan", Integer.valueOf(-16741493));
        f5223d.put("darkgoldenrod", Integer.valueOf(-4684277));
        f5223d.put("darkgray", Integer.valueOf(-5658199));
        f5223d.put("darkgreen", Integer.valueOf(-16751616));
        f5223d.put("darkgrey", Integer.valueOf(-5658199));
        f5223d.put("darkkhaki", Integer.valueOf(-4343957));
        f5223d.put("darkmagenta", Integer.valueOf(-7667573));
        f5223d.put("darkolivegreen", Integer.valueOf(-11179217));
        f5223d.put("darkorange", Integer.valueOf(-29696));
        f5223d.put("darkorchid", Integer.valueOf(-6737204));
        f5223d.put("darkred", Integer.valueOf(-7667712));
        f5223d.put("darksalmon", Integer.valueOf(-1468806));
        f5223d.put("darkseagreen", Integer.valueOf(-7357297));
        f5223d.put("darkslateblue", Integer.valueOf(-12042869));
        f5223d.put("darkslategray", Integer.valueOf(-13676721));
        f5223d.put("darkslategrey", Integer.valueOf(-13676721));
        f5223d.put("darkturquoise", Integer.valueOf(-16724271));
        f5223d.put("darkviolet", Integer.valueOf(-7077677));
        f5223d.put("deeppink", Integer.valueOf(-60269));
        f5223d.put("deepskyblue", Integer.valueOf(-16728065));
        f5223d.put("dimgray", Integer.valueOf(-9868951));
        f5223d.put("dimgrey", Integer.valueOf(-9868951));
        f5223d.put("dodgerblue", Integer.valueOf(-14774017));
        f5223d.put("firebrick", Integer.valueOf(-5103070));
        f5223d.put("floralwhite", Integer.valueOf(-1296));
        f5223d.put("forestgreen", Integer.valueOf(-14513374));
        f5223d.put("fuchsia", Integer.valueOf(-65281));
        f5223d.put("gainsboro", Integer.valueOf(-2302756));
        f5223d.put("ghostwhite", Integer.valueOf(-460545));
        f5223d.put("gold", Integer.valueOf(-10496));
        f5223d.put("goldenrod", Integer.valueOf(-2448096));
        f5223d.put("gray", Integer.valueOf(-8355712));
        f5223d.put("green", Integer.valueOf(-16744448));
        f5223d.put("greenyellow", Integer.valueOf(-5374161));
        f5223d.put("grey", Integer.valueOf(-8355712));
        f5223d.put("honeydew", Integer.valueOf(-983056));
        f5223d.put("hotpink", Integer.valueOf(-38476));
        f5223d.put("indianred", Integer.valueOf(-3318692));
        f5223d.put("indigo", Integer.valueOf(-11861886));
        f5223d.put("ivory", Integer.valueOf(-16));
        f5223d.put("khaki", Integer.valueOf(-989556));
        f5223d.put("lavender", Integer.valueOf(-1644806));
        f5223d.put("lavenderblush", Integer.valueOf(-3851));
        f5223d.put("lawngreen", Integer.valueOf(-8586240));
        f5223d.put("lemonchiffon", Integer.valueOf(-1331));
        f5223d.put("lightblue", Integer.valueOf(-5383962));
        f5223d.put("lightcoral", Integer.valueOf(-1015680));
        f5223d.put("lightcyan", Integer.valueOf(-2031617));
        f5223d.put("lightgoldenrodyellow", Integer.valueOf(-329006));
        f5223d.put("lightgray", Integer.valueOf(-2894893));
        f5223d.put("lightgreen", Integer.valueOf(-7278960));
        f5223d.put("lightgrey", Integer.valueOf(-2894893));
        f5223d.put("lightpink", Integer.valueOf(-18751));
        f5223d.put("lightsalmon", Integer.valueOf(-24454));
        f5223d.put("lightseagreen", Integer.valueOf(-14634326));
        f5223d.put("lightskyblue", Integer.valueOf(-7876870));
        f5223d.put("lightslategray", Integer.valueOf(-8943463));
        f5223d.put("lightslategrey", Integer.valueOf(-8943463));
        f5223d.put("lightsteelblue", Integer.valueOf(-5192482));
        f5223d.put("lightyellow", Integer.valueOf(-32));
        f5223d.put("lime", Integer.valueOf(-16711936));
        f5223d.put("limegreen", Integer.valueOf(-13447886));
        f5223d.put("linen", Integer.valueOf(-331546));
        f5223d.put("magenta", Integer.valueOf(-65281));
        f5223d.put("maroon", Integer.valueOf(-8388608));
        f5223d.put("mediumaquamarine", Integer.valueOf(-10039894));
        f5223d.put("mediumblue", Integer.valueOf(-16777011));
        f5223d.put("mediumorchid", Integer.valueOf(-4565549));
        f5223d.put("mediumpurple", Integer.valueOf(-7114533));
        f5223d.put("mediumseagreen", Integer.valueOf(-12799119));
        f5223d.put("mediumslateblue", Integer.valueOf(-8689426));
        f5223d.put("mediumspringgreen", Integer.valueOf(-16713062));
        f5223d.put("mediumturquoise", Integer.valueOf(-12004916));
        f5223d.put("mediumvioletred", Integer.valueOf(-3730043));
        f5223d.put("midnightblue", Integer.valueOf(-15132304));
        f5223d.put("mintcream", Integer.valueOf(-655366));
        f5223d.put("mistyrose", Integer.valueOf(-6943));
        f5223d.put("moccasin", Integer.valueOf(-6987));
        f5223d.put("navajowhite", Integer.valueOf(-8531));
        f5223d.put("navy", Integer.valueOf(-16777088));
        f5223d.put("oldlace", Integer.valueOf(-133658));
        f5223d.put("olive", Integer.valueOf(-8355840));
        f5223d.put("olivedrab", Integer.valueOf(-9728477));
        f5223d.put("orange", Integer.valueOf(-23296));
        f5223d.put("orangered", Integer.valueOf(-47872));
        f5223d.put("orchid", Integer.valueOf(-2461482));
        f5223d.put("palegoldenrod", Integer.valueOf(-1120086));
        f5223d.put("palegreen", Integer.valueOf(-6751336));
        f5223d.put("paleturquoise", Integer.valueOf(-5247250));
        f5223d.put("palevioletred", Integer.valueOf(-2396013));
        f5223d.put("papayawhip", Integer.valueOf(-4139));
        f5223d.put("peachpuff", Integer.valueOf(-9543));
        f5223d.put("peru", Integer.valueOf(-3308225));
        f5223d.put("pink", Integer.valueOf(-16181));
        f5223d.put("plum", Integer.valueOf(-2252579));
        f5223d.put("powderblue", Integer.valueOf(-5185306));
        f5223d.put("purple", Integer.valueOf(-8388480));
        f5223d.put("rebeccapurple", Integer.valueOf(-10079335));
        f5223d.put("red", Integer.valueOf(-65536));
        f5223d.put("rosybrown", Integer.valueOf(-4419697));
        f5223d.put("royalblue", Integer.valueOf(-12490271));
        f5223d.put("saddlebrown", Integer.valueOf(-7650029));
        f5223d.put("salmon", Integer.valueOf(-360334));
        f5223d.put("sandybrown", Integer.valueOf(-744352));
        f5223d.put("seagreen", Integer.valueOf(-13726889));
        f5223d.put("seashell", Integer.valueOf(-2578));
        f5223d.put("sienna", Integer.valueOf(-6270419));
        f5223d.put("silver", Integer.valueOf(-4144960));
        f5223d.put("skyblue", Integer.valueOf(-7876885));
        f5223d.put("slateblue", Integer.valueOf(-9807155));
        f5223d.put("slategray", Integer.valueOf(-9404272));
        f5223d.put("slategrey", Integer.valueOf(-9404272));
        f5223d.put("snow", Integer.valueOf(-1286));
        f5223d.put("springgreen", Integer.valueOf(-16711809));
        f5223d.put("steelblue", Integer.valueOf(-12156236));
        f5223d.put("tan", Integer.valueOf(-2968436));
        f5223d.put("teal", Integer.valueOf(-16744320));
        f5223d.put("thistle", Integer.valueOf(-2572328));
        f5223d.put("tomato", Integer.valueOf(-40121));
        f5223d.put("transparent", Integer.valueOf(0));
        f5223d.put("turquoise", Integer.valueOf(-12525360));
        f5223d.put("violet", Integer.valueOf(-1146130));
        f5223d.put("wheat", Integer.valueOf(-663885));
        f5223d.put("white", Integer.valueOf(-1));
        f5223d.put("whitesmoke", Integer.valueOf(-657931));
        f5223d.put("yellow", Integer.valueOf(-256));
        f5223d.put("yellowgreen", Integer.valueOf(-6632142));
    }

    public static int m4200a(String str) {
        return m4201a(str, false);
    }

    public static int m4202b(String str) {
        return m4201a(str, true);
    }

    private static int m4201a(String str, boolean z) {
        Assertions.m4184a(TextUtils.isEmpty(str) ^ true);
        str = str.replace(" ", "");
        if (str.charAt(0) == '#') {
            z = (int) Long.parseLong(str.substring(1), 16);
            if (str.length() == 7) {
                str = -16777216 | z;
            } else if (str.length() == 9) {
                str = ((z & 255) << 24) | (z >>> 8);
            } else {
                throw new IllegalArgumentException();
            }
            return str;
        }
        if (str.startsWith("rgba")) {
            str = (z ? f5222c : f5221b).matcher(str);
            if (str.matches()) {
                if (z) {
                    z = (int) (true * Float.parseFloat(str.group(4)));
                } else {
                    z = Integer.parseInt(str.group(4), 10);
                }
                return m4199a(z, Integer.parseInt(str.group(1), 10), Integer.parseInt(str.group(2), 10), Integer.parseInt(str.group(3), 10));
            }
        } else if (str.startsWith("rgb")) {
            str = f5220a.matcher(str);
            if (str.matches()) {
                return m4199a(255, Integer.parseInt(str.group(1), 10), Integer.parseInt(str.group(2), 10), Integer.parseInt(str.group(3), 10));
            }
        } else {
            Integer num = (Integer) f5223d.get(Util.m4323d(str));
            if (num != null) {
                return num.intValue();
            }
        }
        throw new IllegalArgumentException();
    }
}
