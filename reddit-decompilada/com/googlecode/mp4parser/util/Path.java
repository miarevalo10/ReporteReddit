package com.googlecode.mp4parser.util;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Path {
    static Pattern f9081a = Pattern.compile("(....|\\.\\.)(\\[(.*)\\])?");
    static final /* synthetic */ boolean f9082b = true;

    private Path() {
    }

    private static <T extends Box> List<T> m7721a(Container container, String str, boolean z) {
        return m7722a((Object) container, str, z);
    }

    private static <T extends Box> List<T> m7719a(Box box, String str, boolean z) {
        return m7722a((Object) box, str, z);
    }

    private static <T extends Box> List<T> m7722a(Object obj, String str, boolean z) {
        if (str.startsWith(Operation.DIVISION)) {
            String substring = str.substring(1);
            while ((obj instanceof Box) != null) {
                obj = ((Box) obj).getParent();
            }
            str = substring;
        }
        if (str.length() != 0) {
            String substring2;
            int i = 0;
            if (str.contains(Operation.DIVISION)) {
                substring2 = str.substring(str.indexOf(47) + 1);
                str = str.substring(0, str.indexOf(47));
            } else {
                substring2 = "";
            }
            Matcher matcher = f9081a.matcher(str);
            if (matcher.matches()) {
                str = matcher.group(1);
                if ("..".equals(str)) {
                    if ((obj instanceof Box) != null) {
                        return m7721a(((Box) obj).getParent(), substring2, z);
                    }
                    return Collections.emptyList();
                } else if (!(obj instanceof Container)) {
                    return Collections.emptyList();
                } else {
                    int parseInt = matcher.group(2) != null ? Integer.parseInt(matcher.group(3)) : -1;
                    List<T> linkedList = new LinkedList();
                    for (Box box : ((Container) obj).getBoxes()) {
                        if (box.getType().matches(str)) {
                            if (parseInt == -1 || parseInt == i) {
                                linkedList.addAll(m7719a(box, substring2, z));
                            }
                            i++;
                        }
                        if ((z || parseInt >= 0) && !linkedList.isEmpty()) {
                            return linkedList;
                        }
                    }
                    return linkedList;
                }
            }
            z = new StringBuilder(String.valueOf(str));
            z.append(" is invalid path.");
            throw new RuntimeException(z.toString());
        } else if ((obj instanceof Box) != null) {
            return Collections.singletonList((Box) obj);
        } else {
            throw new RuntimeException("Result of path expression seems to be the root container. This is not allowed!");
        }
    }

    public static String m7717a(Box box) {
        String str = "";
        while (true) {
            Container parent = box.getParent();
            int i = 0;
            for (Box box2 : parent.getBoxes()) {
                if (box2.getType().equals(box.getType())) {
                    if (box2 == box) {
                        break;
                    }
                    i++;
                }
            }
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(String.format("/%s[%d]", new Object[]{box.getType(), Integer.valueOf(i)})));
            stringBuilder.append(str);
            str = stringBuilder.toString();
            if ((parent instanceof Box) == null) {
                return str;
            }
            box = (Box) parent;
        }
    }

    public static <T extends Box> T m7716a(AbstractContainerBox abstractContainerBox, String str) {
        abstractContainerBox = m7722a((Object) abstractContainerBox, str, true);
        return abstractContainerBox.isEmpty() != null ? null : (Box) abstractContainerBox.get(null);
    }

    public static <T extends Box> List<T> m7718a(Box box, String str) {
        return m7722a((Object) box, str, false);
    }

    public static <T extends Box> List<T> m7720a(Container container, String str) {
        return m7722a((Object) container, str, false);
    }
}
