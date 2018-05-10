package com.nytimes.android.external.fs3;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class Util {
    public static void m8687a(String[] strArr, Stack<String> stack) {
        for (String str : strArr) {
            if (!Operation.DIVISION.equals(str)) {
                if ("..".equals(str)) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (!(".".equals(str) || str.isEmpty())) {
                    stack.push(str);
                }
            }
        }
    }

    public static void m8686a(File file) throws IOException {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                StringBuilder stringBuilder = new StringBuilder("Unable to create parent directories of ");
                stringBuilder.append(file);
                throw new IOException(stringBuilder.toString());
            }
        }
    }
}
