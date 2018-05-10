package org.apache.commons.cli;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.ArrayList;
import java.util.List;

public class GnuParser extends Parser {
    protected final String[] mo6792b(Options options, String[] strArr) {
        List arrayList = new ArrayList();
        int i = 0;
        int i2 = i;
        while (i < strArr.length) {
            String str = strArr[i];
            if ("--".equals(str)) {
                arrayList.add("--");
            } else {
                if (Operation.MINUS.equals(str)) {
                    arrayList.add(Operation.MINUS);
                } else if (str.startsWith(Operation.MINUS)) {
                    String a = Util.m28331a(str);
                    if (options.m28329a(a)) {
                        arrayList.add(str);
                    } else if (a.indexOf(61) != -1 && options.m28329a(a.substring(0, a.indexOf(61)))) {
                        arrayList.add(str.substring(0, str.indexOf(61)));
                        arrayList.add(str.substring(str.indexOf(61) + 1));
                    } else if (options.m28329a(str.substring(0, 2))) {
                        arrayList.add(str.substring(0, 2));
                        arrayList.add(str.substring(2));
                    } else {
                        arrayList.add(str);
                    }
                } else {
                    arrayList.add(str);
                }
                if (i2 != 0) {
                    while (true) {
                        i++;
                        if (i < strArr.length) {
                            break;
                        }
                        arrayList.add(strArr[i]);
                    }
                }
                i++;
            }
            i2 = 1;
            if (i2 != 0) {
                while (true) {
                    i++;
                    if (i < strArr.length) {
                        break;
                    }
                    arrayList.add(strArr[i]);
                }
            }
            i++;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
