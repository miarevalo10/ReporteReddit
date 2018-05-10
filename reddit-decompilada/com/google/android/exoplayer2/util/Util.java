package com.google.android.exoplayer2.util;

import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Util {
    public static final int f5283a;
    public static final String f5284b = Build.DEVICE;
    public static final String f5285c = Build.MANUFACTURER;
    public static final String f5286d = Build.MODEL;
    public static final String f5287e;
    private static final Pattern f5288f = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
    private static final Pattern f5289g = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
    private static final Pattern f5290h = Pattern.compile("%([A-Fa-f0-9]{2})");
    private static final int[] f5291i = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};

    public static int m4301a(long[] r1, long r2, boolean r4, boolean r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.google.android.exoplayer2.util.Util.a(long[], long, boolean, boolean):int
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-int
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 7 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.Util.a(long[], long, boolean, boolean):int");
    }

    public static boolean m4311a(int i) {
        if (i != 10) {
            if (i != 13) {
                return false;
            }
        }
        return true;
    }

    public static int m4316b(int i) {
        return i != 8 ? i != 16 ? i != 24 ? i != 32 ? 0 : 1073741824 : Integer.MIN_VALUE : 2 : 3;
    }

    public static int m4320c(int i) {
        switch (i) {
            case 1:
            case 12:
            case 14:
                return 3;
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 13:
                return 1;
            default:
                return 3;
        }
    }

    static {
        int i = (VERSION.SDK_INT == 25 && VERSION.CODENAME.charAt(0) == 'O') ? 26 : VERSION.SDK_INT;
        f5283a = i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f5284b);
        stringBuilder.append(", ");
        stringBuilder.append(f5286d);
        stringBuilder.append(", ");
        stringBuilder.append(f5285c);
        stringBuilder.append(", ");
        stringBuilder.append(f5283a);
        f5287e = stringBuilder.toString();
    }

    public static boolean m4312a(Uri uri) {
        uri = uri.getScheme();
        if (!TextUtils.isEmpty(uri)) {
            if (uri.equals("file") == null) {
                return null;
            }
        }
        return true;
    }

    public static boolean m4313a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null ? true : null;
        } else {
            return obj.equals(obj2);
        }
    }

    public static ExecutorService m4306a(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() {
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, str);
            }
        });
    }

    public static void m4307a(com.google.android.exoplayer2.upstream.DataSource r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        if (r0 == 0) goto L_0x0007;
    L_0x0002:
        r0.mo1436a();	 Catch:{ IOException -> 0x0006 }
        goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.Util.a(com.google.android.exoplayer2.upstream.DataSource):void");
    }

    public static void m4308a(java.io.Closeable r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        if (r0 == 0) goto L_0x0007;
    L_0x0002:
        r0.close();	 Catch:{ IOException -> 0x0006 }
        goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.Util.a(java.io.Closeable):void");
    }

    public static String m4319b(String str) {
        return str == null ? null : new Locale(str).getLanguage();
    }

    public static byte[] m4321c(String str) {
        return str.getBytes(Charset.forName("UTF-8"));
    }

    public static String m4323d(String str) {
        return str == null ? null : str.toLowerCase(Locale.US);
    }

    public static int m4296a(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    public static long m4302a(long j, long j2) {
        return ((j + j2) - 1) / j2;
    }

    public static int m4297a(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i, i3));
    }

    public static long m4318b(long j, long j2) {
        return Math.max(0, Math.min(j, j2));
    }

    public static float m4295a(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f, f3));
    }

    public static int m4300a(long[] jArr, long j, boolean z) {
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            jArr = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0) {
                    break;
                }
            } while (jArr[binarySearch] == j);
            jArr = binarySearch + 1;
        }
        return z ? Math.max(0, jArr) : jArr;
    }

    public static <T> int m4298a(List<? extends Comparable<? super T>> list, T t, boolean z) {
        int binarySearch = Collections.binarySearch(list, t);
        if (binarySearch < 0) {
            list = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0) {
                    break;
                }
            } while (((Comparable) list.get(binarySearch)).compareTo(t) == 0);
            list = binarySearch + 1;
        }
        return z ? Math.max(null, list) : list;
    }

    public static long m4324e(String str) {
        Matcher matcher = f5289g.matcher(str);
        if (!matcher.matches()) {
            return (long) ((Double.parseDouble(str) * 3600.0d) * 1000.0d);
        }
        str = 1 ^ TextUtils.isEmpty(matcher.group(1));
        String group = matcher.group(3);
        double d = 0.0d;
        double parseDouble = group != null ? Double.parseDouble(group) * 3.1556908E7d : 0.0d;
        group = matcher.group(5);
        parseDouble += group != null ? Double.parseDouble(group) * 2629739.0d : 0.0d;
        group = matcher.group(7);
        parseDouble += group != null ? Double.parseDouble(group) * 86400.0d : 0.0d;
        group = matcher.group(10);
        parseDouble += group != null ? 3600.0d * Double.parseDouble(group) : 0.0d;
        group = matcher.group(12);
        parseDouble += group != null ? Double.parseDouble(group) * 60.0d : 0.0d;
        String group2 = matcher.group(14);
        if (group2 != null) {
            d = Double.parseDouble(group2);
        }
        long j = (long) ((parseDouble + d) * 1000.0d);
        if (str != null) {
            j = -j;
        }
        return j;
    }

    public static long m4325f(String str) throws ParserException {
        Matcher matcher = f5288f.matcher(str);
        if (matcher.matches()) {
            int i = 0;
            if (matcher.group(9) != null) {
                if (matcher.group(9).equalsIgnoreCase("Z") == null) {
                    i = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
                    if (matcher.group(11).equals(Operation.MINUS) != null) {
                        i *= -1;
                    }
                }
            }
            str = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
            str.clear();
            str.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
            if (!TextUtils.isEmpty(matcher.group(8))) {
                StringBuilder stringBuilder = new StringBuilder("0.");
                stringBuilder.append(matcher.group(8));
                str.set(14, new BigDecimal(stringBuilder.toString()).movePointRight(3).intValue());
            }
            long timeInMillis = str.getTimeInMillis();
            return i != 0 ? timeInMillis - ((long) (i * 60000)) : timeInMillis;
        } else {
            StringBuilder stringBuilder2 = new StringBuilder("Invalid date/time format: ");
            stringBuilder2.append(str);
            throw new ParserException(stringBuilder2.toString());
        }
    }

    public static long m4303a(long j, long j2, long j3) {
        int i = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
        if (i >= 0 && j3 % j2 == 0) {
            return j / (j3 / j2);
        }
        if (i < 0 && j2 % j3 == 0) {
            return j * (j2 / j3);
        }
        return (long) (((double) j) * (((double) j2) / ((double) j3)));
    }

    public static long[] m4315a(List<Long> list, long j) {
        long[] jArr = new long[list.size()];
        int i = (j > 1000000 ? 1 : (j == 1000000 ? 0 : -1));
        int i2 = 0;
        if (i >= 0 && j % 1000000 == 0) {
            j /= 1000000;
            while (i2 < jArr.length) {
                jArr[i2] = ((Long) list.get(i2)).longValue() / j;
                i2++;
            }
        } else if (i >= 0 || 1000000 % j != 0) {
            double d = 1000000.0d / ((double) j);
            while (i2 < jArr.length) {
                jArr[i2] = (long) (((double) ((Long) list.get(i2)).longValue()) * d);
                i2++;
            }
        } else {
            long j2 = 1000000 / j;
            while (i2 < jArr.length) {
                jArr[i2] = ((Long) list.get(i2)).longValue() * j2;
                i2++;
            }
        }
        return jArr;
    }

    public static void m4310a(long[] jArr, long j) {
        int i = (j > 1000000 ? 1 : (j == 1000000 ? 0 : -1));
        int i2 = 0;
        if (i >= 0 && j % 1000000 == 0) {
            j /= 1000000;
            while (i2 < jArr.length) {
                jArr[i2] = jArr[i2] / j;
                i2++;
            }
        } else if (i >= 0 || 1000000 % j != 0) {
            double d = 1000000.0d / ((double) j);
            while (i2 < jArr.length) {
                jArr[i2] = (long) (((double) jArr[i2]) * d);
                i2++;
            }
        } else {
            long j2 = 1000000 / j;
            while (i2 < jArr.length) {
                jArr[i2] = jArr[i2] * j2;
                i2++;
            }
        }
    }

    public static int[] m4314a(List<Integer> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = ((Integer) list.get(i)).intValue();
        }
        return iArr;
    }

    public static int m4326g(String str) {
        int length = str.length();
        int i = 0;
        Assertions.m4184a(length <= 4);
        int i2 = 0;
        while (i < length) {
            i2 = (i2 << 8) | str.charAt(i);
            i++;
        }
        return i2;
    }

    public static byte[] m4327h(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
        }
        return bArr;
    }

    public static String m4305a(Object[] objArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < objArr.length; i++) {
            stringBuilder.append(objArr[i].getClass().getSimpleName());
            if (i < objArr.length - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }

    public static int m4317b(int i, int i2) {
        if (i == Integer.MIN_VALUE) {
            return i2 * 3;
        }
        if (i == 1073741824) {
            return i2 * 4;
        }
        switch (i) {
            case 2:
                return i2 * 2;
            case 3:
                return i2;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static int m4328i(String str) {
        str = m4323d(str);
        if (str.endsWith(".mpd")) {
            return null;
        }
        if (str.endsWith(".m3u8")) {
            return 2;
        }
        if (!(str.endsWith(".ism") || str.endsWith(".isml") || str.endsWith(".ism/manifest"))) {
            if (str.endsWith(".isml/manifest") == null) {
                return 3;
            }
        }
        return 1;
    }

    public static String m4304a(StringBuilder stringBuilder, Formatter formatter, long j) {
        if (j == -9223372036854775807L) {
            j = 0;
        }
        j = (j + 500) / 1000;
        long j2 = j % 60;
        long j3 = (j / 60) % 60;
        j /= 3600;
        stringBuilder.setLength(0);
        if (j > 0) {
            return formatter.format("%d:%02d:%02d", new Object[]{Long.valueOf(j), Long.valueOf(j3), Long.valueOf(j2)}).toString();
        }
        return formatter.format("%02d:%02d", new Object[]{Long.valueOf(j3), Long.valueOf(j2)}).toString();
    }

    public static int m4322d(int i) {
        switch (i) {
            case 0:
                return 16777216;
            case 1:
                return 3538944;
            case 2:
                return 13107200;
            case 3:
                return 131072;
            case 4:
                return 131072;
            default:
                throw new IllegalStateException();
        }
    }

    public static String m4329j(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        int i3 = i2;
        while (i2 < length) {
            if (str.charAt(i2) == '%') {
                i3++;
            }
            i2++;
        }
        if (i3 == 0) {
            return str;
        }
        i2 = length - (i3 * 2);
        StringBuilder stringBuilder = new StringBuilder(i2);
        Matcher matcher = f5290h.matcher(str);
        while (i3 > 0 && matcher.find()) {
            char parseInt = (char) Integer.parseInt(matcher.group(1), 16);
            stringBuilder.append(str, i, matcher.start());
            stringBuilder.append(parseInt);
            i = matcher.end();
            i3--;
        }
        if (i < length) {
            stringBuilder.append(str, i, length);
        }
        if (stringBuilder.length() != i2) {
            return null;
        }
        return stringBuilder.toString();
    }

    public static int m4299a(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i; i3++) {
            i2 = f5291i[((i2 >>> 24) ^ (bArr[i3] & 255)) & 255] ^ (i2 << 8);
        }
        return i2;
    }

    public static void m4309a(Throwable th) {
        throw th;
    }
}
