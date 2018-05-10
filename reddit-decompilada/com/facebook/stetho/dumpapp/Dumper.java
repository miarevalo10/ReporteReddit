package com.facebook.stetho.dumpapp;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Dumper {
    private final Map<String, DumperPlugin> mDumperPlugins;
    private final GlobalOptions mGlobalOptions;
    private final CommandLineParser mParser;

    public Dumper(Iterable<DumperPlugin> iterable) {
        this(iterable, new GnuParser());
    }

    public Dumper(Iterable<DumperPlugin> iterable, CommandLineParser commandLineParser) {
        this.mDumperPlugins = generatePluginMap(iterable);
        this.mParser = commandLineParser;
        this.mGlobalOptions = new GlobalOptions();
    }

    private static Map<String, DumperPlugin> generatePluginMap(Iterable<DumperPlugin> iterable) {
        Map hashMap = new HashMap();
        for (DumperPlugin dumperPlugin : iterable) {
            hashMap.put(dumperPlugin.getName(), dumperPlugin);
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public int dump(InputStream inputStream, PrintStream printStream, PrintStream printStream2, String[] strArr) {
        try {
            return doDump(inputStream, printStream, printStream2, strArr);
        } catch (InputStream inputStream2) {
            printStream2.println(inputStream2.getMessage());
            dumpUsage(printStream2);
            return 1;
        } catch (InputStream inputStream22) {
            printStream2.println(inputStream22.getMessage());
            return 1;
        } catch (InputStream inputStream222) {
            throw inputStream222;
        } catch (InputStream inputStream2222) {
            inputStream2222.printStackTrace(printStream2);
            return 1;
        }
    }

    private int doDump(InputStream inputStream, PrintStream printStream, PrintStream printStream2, String[] strArr) throws ParseException, DumpException {
        strArr = this.mParser.a(this.mGlobalOptions.options, strArr);
        if (strArr.a(this.mGlobalOptions.optionHelp.a)) {
            dumpUsage(printStream);
            return 0;
        } else if (strArr.a(this.mGlobalOptions.optionListPlugins.a)) {
            dumpAvailablePlugins(printStream);
            return 0;
        } else if (strArr.a.isEmpty()) {
            dumpUsage(printStream2);
            return 1;
        } else {
            dumpPluginOutput(inputStream, printStream, printStream2, strArr);
            return 0;
        }
    }

    private void dumpAvailablePlugins(PrintStream printStream) {
        List<String> arrayList = new ArrayList();
        for (DumperPlugin name : this.mDumperPlugins.values()) {
            arrayList.add(name.getName());
        }
        Collections.sort(arrayList);
        for (String println : arrayList) {
            printStream.println(println);
        }
    }

    private void dumpPluginOutput(InputStream inputStream, PrintStream printStream, PrintStream printStream2, CommandLine commandLine) throws DumpException {
        List arrayList = new ArrayList(commandLine.a);
        if (arrayList.size() <= null) {
            throw new DumpException("Expected plugin argument");
        }
        String str = (String) arrayList.remove(null);
        DumperPlugin dumperPlugin = (DumperPlugin) this.mDumperPlugins.get(str);
        if (dumperPlugin == null) {
            printStream = new StringBuilder("No plugin named '");
            printStream.append(str);
            printStream.append("'");
            throw new DumpException(printStream.toString());
        }
        dumperPlugin.dump(new DumperContext(inputStream, printStream, printStream2, this.mParser, arrayList));
    }

    private void dumpUsage(PrintStream printStream) {
        HelpFormatter helpFormatter = new HelpFormatter();
        printStream.println("Usage: dumpapp [options] <plugin> [plugin-options]");
        PrintWriter printWriter = new PrintWriter(printStream);
        try {
            int i = helpFormatter.a;
            Options options = this.mGlobalOptions.options;
            int i2 = helpFormatter.b;
            int i3 = helpFormatter.c;
            printStream = new StringBuffer();
            helpFormatter.a(printStream, i, options, i2, i3);
            printWriter.println(printStream.toString());
        } finally {
            printWriter.flush();
        }
    }
}
