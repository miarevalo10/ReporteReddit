package com.facebook.stetho.dumpapp;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class GlobalOptions {
    public final Option optionHelp = new Option("h", "help", false, "Print this help");
    public final Option optionListPlugins = new Option("l", "list", false, "List available plugins");
    public final Option optionProcess = new Option("p", "process", true, "Specify target process");
    public final Options options = new Options();

    public GlobalOptions() {
        this.options.a(this.optionHelp);
        this.options.a(this.optionListPlugins);
        this.options.a(this.optionProcess);
    }
}
