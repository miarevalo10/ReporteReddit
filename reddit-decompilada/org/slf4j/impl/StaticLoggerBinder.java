package org.slf4j.impl;

import org.slf4j.ILoggerFactory;

public class StaticLoggerBinder {
    public static String f27230a = "1.6.99";
    private static final StaticLoggerBinder f27231c = new StaticLoggerBinder();
    private static final String f27232d = AndroidLoggerFactory.class.getName();
    public final ILoggerFactory f27233b = new AndroidLoggerFactory();

    public static StaticLoggerBinder m28715a() {
        return f27231c;
    }

    private StaticLoggerBinder() {
    }

    public static String m28716b() {
        return f27232d;
    }
}
