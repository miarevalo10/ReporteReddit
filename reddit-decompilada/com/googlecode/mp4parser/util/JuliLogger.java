package com.googlecode.mp4parser.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JuliLogger extends Logger {
    Logger f15298a;

    public JuliLogger(String str) {
        this.f15298a = Logger.getLogger(str);
    }

    public final void mo2531a(String str) {
        this.f15298a.log(Level.FINE, str);
    }

    public final void mo2532b(String str) {
        this.f15298a.log(Level.WARNING, str);
    }

    public final void mo2533c(String str) {
        this.f15298a.log(Level.SEVERE, str);
    }
}
