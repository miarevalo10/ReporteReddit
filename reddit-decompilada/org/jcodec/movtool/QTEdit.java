package org.jcodec.movtool;

import java.io.File;
import java.io.PrintStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.movtool.Flattern.ProgressListener;

public class QTEdit {
    protected final EditFactory[] factories;
    private final List<ProgressListener> listeners = new ArrayList();

    public interface EditFactory {
        String getHelp();

        String getName();

        MP4Edit parseArgs(List<String> list);
    }

    public static abstract class BaseCommand implements MP4Edit {
        public abstract void apply(MovieBox movieBox);

        public void apply(MovieBox movieBox, FileChannel[][] fileChannelArr) {
            apply(movieBox);
        }
    }

    public QTEdit(EditFactory... editFactoryArr) {
        this.factories = editFactoryArr;
    }

    public void addProgressListener(ProgressListener progressListener) {
        this.listeners.add(progressListener);
    }

    public void execute(String[] strArr) throws Exception {
        LinkedList linkedList = new LinkedList(Arrays.asList(strArr));
        strArr = new LinkedList();
        while (linkedList.size() > 0) {
            int i = 0;
            while (i < this.factories.length) {
                if (((String) linkedList.get(0)).equals(this.factories[i].getName())) {
                    linkedList.remove(0);
                    try {
                        strArr.add(this.factories[i].parseArgs(linkedList));
                        break;
                    } catch (String[] strArr2) {
                        PrintStream printStream = System.err;
                        StringBuilder stringBuilder = new StringBuilder("ERROR: ");
                        stringBuilder.append(strArr2.getMessage());
                        printStream.println(stringBuilder.toString());
                        return;
                    }
                }
                i++;
            }
            if (i == this.factories.length) {
                break;
            }
        }
        if (linkedList.size() == 0) {
            System.err.println("ERROR: A movie file should be specified");
            help();
        }
        if (strArr2.size() == 0) {
            System.err.println("ERROR: At least one command should be specified");
            help();
        }
        File file = new File((String) linkedList.remove(0));
        if (!file.exists()) {
            printStream = System.err;
            StringBuilder stringBuilder2 = new StringBuilder("ERROR: Input file '");
            stringBuilder2.append(file.getAbsolutePath());
            stringBuilder2.append("' doesn't exist");
            printStream.println(stringBuilder2.toString());
            help();
        }
        new ReplaceMP4Editor().replace(file, new CompoundMP4Edit(strArr2));
    }

    protected void help() {
        System.out.println("Quicktime movie editor");
        System.out.println("Syntax: qtedit <command1> <options> ... <commandN> <options> <movie>");
        System.out.println("Where options:");
        for (EditFactory editFactory : this.factories) {
            PrintStream printStream = System.out;
            StringBuilder stringBuilder = new StringBuilder("\t");
            stringBuilder.append(editFactory.getHelp());
            printStream.println(stringBuilder.toString());
        }
        System.exit(-1);
    }
}
