package com.googlecode.mp4parser.util;

public abstract class Logger {
    public abstract void mo2531a(String str);

    public abstract void mo2532b(String str);

    public abstract void mo2533c(String str);

    public static Logger m7708a(Class cls) {
        if (System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik")) {
            return new AndroidLogger(cls.getSimpleName());
        }
        return new JuliLogger(cls.getSimpleName());
    }
}
