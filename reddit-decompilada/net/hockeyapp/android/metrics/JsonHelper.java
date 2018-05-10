package net.hockeyapp.android.metrics;

public final class JsonHelper {
    private static final String[] f26540a = new String[128];

    static {
        for (int i = 0; i <= 31; i++) {
            f26540a[i] = String.format("\\u%04X", new Object[]{Integer.valueOf(i)});
        }
        f26540a[34] = "\\\"";
        f26540a[92] = "\\\\";
        f26540a[8] = "\\b";
        f26540a[12] = "\\f";
        f26540a[10] = "\\n";
        f26540a[13] = "\\r";
        f26540a[9] = "\\t";
    }

    public static String m28184a(String str) {
        if (str == null) {
            return "null";
        }
        if (str.length() == 0) {
            return "\"\"";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\"");
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt < '') {
                String str2 = f26540a[charAt];
                if (str2 == null) {
                    stringBuilder.append(charAt);
                } else {
                    stringBuilder.append(str2);
                }
            } else if (charAt == ' ') {
                stringBuilder.append("\\u2028");
            } else if (charAt == ' ') {
                stringBuilder.append("\\u2029");
            } else {
                stringBuilder.append(charAt);
            }
        }
        stringBuilder.append("\"");
        return stringBuilder.toString();
    }
}
