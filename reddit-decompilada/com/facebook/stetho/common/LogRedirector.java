package com.facebook.stetho.common;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class LogRedirector {
    private static volatile Logger sLogger;

    public interface Logger {
        boolean isLoggable(String str, int i);

        void log(int i, String str, String str2);
    }

    public static void setLogger(Logger logger) {
        Util.throwIfNull(logger);
        Util.throwIfNotNull(sLogger);
        sLogger = logger;
    }

    public static void m3424e(String str, String str2, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append("\n");
        stringBuilder.append(formatThrowable(th));
        m3423e(str, stringBuilder.toString());
    }

    public static void m3423e(String str, String str2) {
        log(6, str, str2);
    }

    public static void m3430w(String str, String str2, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append("\n");
        stringBuilder.append(formatThrowable(th));
        m3429w(str, stringBuilder.toString());
    }

    public static void m3429w(String str, String str2) {
        log(5, str, str2);
    }

    public static void m3426i(String str, String str2, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append("\n");
        stringBuilder.append(formatThrowable(th));
        m3425i(str, stringBuilder.toString());
    }

    public static void m3425i(String str, String str2) {
        log(4, str, str2);
    }

    public static void m3422d(String str, String str2, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append("\n");
        stringBuilder.append(formatThrowable(th));
        m3421d(str, stringBuilder.toString());
    }

    public static void m3421d(String str, String str2) {
        log(3, str, str2);
    }

    public static void m3428v(String str, String str2, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append("\n");
        stringBuilder.append(formatThrowable(th));
        m3427v(str, stringBuilder.toString());
    }

    public static void m3427v(String str, String str2) {
        log(2, str, str2);
    }

    private static String formatThrowable(Throwable th) {
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace();
        printWriter.flush();
        return stringWriter.toString();
    }

    private static void log(int i, String str, String str2) {
        Logger logger = sLogger;
        if (logger != null) {
            logger.log(i, str, str2);
        } else {
            Log.println(i, str, str2);
        }
    }

    public static boolean isLoggable(String str, int i) {
        Logger logger = sLogger;
        if (logger != null) {
            return logger.isLoggable(str, i);
        }
        return Log.isLoggable(str, i);
    }
}
