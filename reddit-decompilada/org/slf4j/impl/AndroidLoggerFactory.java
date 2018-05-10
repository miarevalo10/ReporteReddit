package org.slf4j.impl;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

class AndroidLoggerFactory implements ILoggerFactory {
    private final ConcurrentMap<String, Logger> f33454a = new ConcurrentHashMap();

    AndroidLoggerFactory() {
    }

    private static String m34243b(String str) {
        int length = str.length();
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            lastIndexOf++;
            if (length - lastIndexOf <= 23) {
                return str.substring(lastIndexOf);
            }
        }
        StringBuilder stringBuilder = new StringBuilder(Operation.MULTIPLY);
        stringBuilder.append(str.substring((length - 23) + 1));
        return stringBuilder.toString();
    }

    public final Logger mo6375a(String str) {
        if (str == null) {
            str = "null";
        } else {
            int length = str.length();
            if (length > 23) {
                StringBuilder stringBuilder = new StringBuilder(26);
                int i = 0;
                int i2 = 0;
                do {
                    int indexOf = str.indexOf(46, i);
                    if (indexOf != -1) {
                        stringBuilder.append(str.charAt(i));
                        if (indexOf - i > 1) {
                            stringBuilder.append('*');
                        }
                        stringBuilder.append('.');
                        i = indexOf + 1;
                        i2 = stringBuilder.length();
                    } else {
                        int i3 = length - i;
                        if (i2 != 0) {
                            if (i2 + i3 <= 23) {
                                stringBuilder.append(str, i, length);
                                str = stringBuilder.toString();
                            }
                        }
                        str = m34243b(str);
                    }
                } while (i2 <= 23);
                str = m34243b(str);
            }
        }
        Logger logger = (Logger) this.f33454a.get(str);
        if (logger != null) {
            return logger;
        }
        logger = new AndroidLoggerAdapter(str);
        Logger logger2 = (Logger) this.f33454a.putIfAbsent(str, logger);
        return logger2 == null ? logger : logger2;
    }
}
