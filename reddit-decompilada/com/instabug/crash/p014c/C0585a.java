package com.instabug.crash.p014c;

import com.instabug.library.util.InstabugSDKLogger;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import org.json.JSONObject;

/* compiled from: ExceptionFormatter */
public class C0585a {
    public static JSONObject m8007a(Throwable th, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            Object name = th.getClass().getName();
            if (str != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(name);
                stringBuilder.append(Operation.MINUS);
                stringBuilder.append(str);
                name = stringBuilder.toString();
            }
            jSONObject.put("name", name);
            StackTraceElement stackTraceElement = null;
            if (th.getStackTrace() != null && th.getStackTrace().length > 0) {
                stackTraceElement = th.getStackTrace()[0];
            }
            if (stackTraceElement == null || stackTraceElement.getFileName() == null) {
                InstabugSDKLogger.m8361w(C0585a.class, "Incomplete crash stacktrace, if you're using Proguard, add the following line to your configuration file to have file name and line number in your crash report:");
                InstabugSDKLogger.m8361w(C0585a.class, "-keepattributes SourceFile,LineNumberTable");
            } else {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(stackTraceElement.getFileName());
                stringBuilder2.append(":");
                stringBuilder2.append(stackTraceElement.getLineNumber());
                jSONObject.put("location", stringBuilder2.toString());
            }
            jSONObject.put("exception", th.toString());
            if (th.getMessage() != null) {
                jSONObject.put("message", th.getMessage());
            }
            jSONObject.put("stackTrace", C0585a.m8006a(th));
            if (th.getCause() != null) {
                jSONObject.put("cause", C0585a.m8007a(th.getCause(), str));
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return jSONObject;
    }

    private static String m8006a(Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(th.toString());
        stringBuilder.append("\n");
        String stringBuilder2 = stringBuilder.toString();
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(stringBuilder2);
            stringBuilder3.append("\t at ");
            stringBuilder3.append(stackTraceElement.toString());
            stringBuilder3.append("\n");
            stringBuilder2 = stringBuilder3.toString();
        }
        return stringBuilder2;
    }
}
