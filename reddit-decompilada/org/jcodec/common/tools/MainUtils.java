package org.jcodec.common.tools;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jcodec.common.StringUtils;

public class MainUtils {
    private static final String JCODEC_LOG_SINK_COLOR = "jcodec.colorPrint";
    private static Pattern flagPattern = Pattern.compile("^--([^=]+)=(.*)$");
    public static boolean isColorSupported;

    public enum ANSIColor {
        BLACK,
        RED,
        GREEN,
        BROWN,
        BLUE,
        MAGENTA,
        CYAN,
        GREY
    }

    public static class Cmd {
        public String[] args;
        public Map<String, String> flags;

        public Cmd(Map<String, String> map, String[] strArr) {
            this.flags = map;
            this.args = strArr;
        }

        public Long getLongFlag(String str, Long l) {
            return this.flags.containsKey(str) ? new Long((String) this.flags.get(str)) : l;
        }

        public Integer getIntegerFlag(String str, Integer num) {
            return this.flags.containsKey(str) ? new Integer((String) this.flags.get(str)) : num;
        }

        public Boolean getBooleanFlag(String str, Boolean bool) {
            return this.flags.containsKey(str) ? new Boolean((String) this.flags.get(str)) : bool;
        }

        public Double getDoubleFlag(String str, Long l) {
            return Double.valueOf(this.flags.containsKey(str) ? new Double((String) this.flags.get(str)).doubleValue() : (double) l.longValue());
        }

        public String getStringFlag(String str, String str2) {
            return this.flags.containsKey(str) ? (String) this.flags.get(str) : str2;
        }

        public int[] getMultiIntegerFlag(String str, int[] iArr) {
            if (!this.flags.containsKey(str)) {
                return iArr;
            }
            str = StringUtils.split((String) this.flags.get(str), ",");
            iArr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                iArr[i] = Integer.parseInt(str[i]);
            }
            return iArr;
        }

        public Long getLongFlag(String str) {
            return getLongFlag(str, null);
        }

        public Integer getIntegerFlag(String str) {
            return getIntegerFlag(str, null);
        }

        public Boolean getBooleanFlag(String str) {
            return getBooleanFlag(str, null);
        }

        public Double getDoubleFlag(String str) {
            return getDoubleFlag(str, null);
        }

        public String getStringFlag(String str) {
            return getStringFlag(str, null);
        }

        public int[] getMultiIntegerFlag(String str) {
            return getMultiIntegerFlag(str, new int[0]);
        }

        public String getArg(int i) {
            return i < this.args.length ? this.args[i] : 0;
        }

        public int argsLength() {
            return this.args.length;
        }
    }

    static {
        boolean z;
        if (System.console() == null) {
            if (!Boolean.parseBoolean(System.getProperty(JCODEC_LOG_SINK_COLOR))) {
                z = false;
                isColorSupported = z;
            }
        }
        z = true;
        isColorSupported = z;
    }

    public static Cmd parseArguments(String[] strArr) {
        Map hashMap = new HashMap();
        int i = 0;
        while (i < strArr.length) {
            if (!strArr[i].startsWith("--")) {
                if (!strArr[i].startsWith(Operation.MINUS)) {
                    break;
                }
                i++;
                hashMap.put(strArr[i].substring(1), strArr[i]);
            } else {
                Matcher matcher = flagPattern.matcher(strArr[i]);
                if (matcher.matches()) {
                    hashMap.put(matcher.group(1), matcher.group(2));
                } else {
                    hashMap.put(strArr[i].substring(2), "true");
                }
            }
            i++;
        }
        return new Cmd(hashMap, (String[]) Arrays.copyOfRange(strArr, i, strArr.length));
    }

    public static void printHelp(Map<String, String> map, String... strArr) {
        System.out.print(bold("Syntax:"));
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            StringBuilder stringBuilder3 = new StringBuilder(" [");
            StringBuilder stringBuilder4 = new StringBuilder("--");
            stringBuilder4.append((String) entry.getKey());
            stringBuilder4.append("=<value>");
            stringBuilder3.append(bold(color(stringBuilder4.toString(), ANSIColor.MAGENTA)));
            stringBuilder3.append("]");
            stringBuilder.append(stringBuilder3.toString());
            stringBuilder3 = new StringBuilder("\t");
            stringBuilder4 = new StringBuilder("--");
            stringBuilder4.append((String) entry.getKey());
            stringBuilder3.append(bold(color(stringBuilder4.toString(), ANSIColor.MAGENTA)));
            stringBuilder3.append("\t\t");
            stringBuilder3.append((String) entry.getValue());
            stringBuilder3.append("\n");
            stringBuilder2.append(stringBuilder3.toString());
        }
        for (String str : strArr) {
            stringBuilder4 = new StringBuilder(" <");
            stringBuilder4.append(str);
            stringBuilder4.append(Operation.GREATER_THAN);
            stringBuilder.append(bold(stringBuilder4.toString()));
        }
        System.out.println(stringBuilder);
        System.out.println(bold("Where:"));
        System.out.println(stringBuilder2);
    }

    public static String bold(String str) {
        if (!isColorSupported) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder("\u001b[1m");
        stringBuilder.append(str);
        stringBuilder.append("\u001b[0m");
        return stringBuilder.toString();
    }

    public static String colorString(String str, String str2) {
        if (!isColorSupported) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder("\u001b[");
        stringBuilder.append(str2);
        stringBuilder.append("m");
        stringBuilder.append(str);
        stringBuilder.append("\u001b[0m");
        return stringBuilder.toString();
    }

    public static String color(String str, ANSIColor aNSIColor) {
        if (!isColorSupported) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder("\u001b[");
        stringBuilder.append(30 + (aNSIColor.ordinal() & 7));
        stringBuilder.append("m");
        stringBuilder.append(str);
        stringBuilder.append("\u001b[0m");
        return stringBuilder.toString();
    }

    public static String color(String str, ANSIColor aNSIColor, boolean z) {
        if (!isColorSupported) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder("\u001b[");
        stringBuilder.append(30 + (aNSIColor.ordinal() & 7));
        stringBuilder.append(";");
        stringBuilder.append(z ? true : 2);
        stringBuilder.append("m");
        stringBuilder.append(str);
        stringBuilder.append("\u001b[0m");
        return stringBuilder.toString();
    }

    public static String color(String str, ANSIColor aNSIColor, ANSIColor aNSIColor2) {
        if (!isColorSupported) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder("\u001b[");
        stringBuilder.append(30 + (aNSIColor.ordinal() & 7));
        stringBuilder.append(";");
        stringBuilder.append(40 + (aNSIColor2.ordinal() & 7));
        stringBuilder.append(";1m");
        stringBuilder.append(str);
        stringBuilder.append("\u001b[0m");
        return stringBuilder.toString();
    }

    public static String color(String str, ANSIColor aNSIColor, ANSIColor aNSIColor2, boolean z) {
        if (!isColorSupported) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder("\u001b[");
        stringBuilder.append(30 + (aNSIColor.ordinal() & 7));
        stringBuilder.append(";");
        stringBuilder.append(40 + (aNSIColor2.ordinal() & 7));
        stringBuilder.append(";");
        stringBuilder.append(z ? true : 2);
        stringBuilder.append("m");
        stringBuilder.append(str);
        stringBuilder.append("\u001b[0m");
        return stringBuilder.toString();
    }
}
