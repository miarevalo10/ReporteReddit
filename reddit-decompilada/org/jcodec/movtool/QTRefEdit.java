package org.jcodec.movtool;

import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;
import org.jcodec.containers.mp4.MP4Util;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.movtool.QTEdit.EditFactory;

public class QTRefEdit {
    protected final EditFactory[] factories;

    public QTRefEdit(EditFactory... editFactoryArr) {
        this.factories = editFactoryArr;
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
        if (linkedList.size() == 0) {
            System.err.println("ERROR: A movie output file should be specified");
            help();
        }
        File file2 = new File((String) linkedList.remove(0));
        if (!file.exists()) {
            printStream = System.err;
            StringBuilder stringBuilder2 = new StringBuilder("ERROR: Input file '");
            stringBuilder2.append(file.getAbsolutePath());
            stringBuilder2.append("' doesn't exist");
            printStream.println(stringBuilder2.toString());
            help();
        }
        if (file2.exists()) {
            printStream = System.err;
            stringBuilder2 = new StringBuilder("WARNING: Output file '");
            stringBuilder2.append(file2.getAbsolutePath());
            stringBuilder2.append("' exist, overwritting");
            printStream.println(stringBuilder2.toString());
        }
        MovieBox createRefMovie = MP4Util.createRefMovie(file);
        new CompoundMP4Edit(strArr2).apply(createRefMovie);
        MP4Util.writeMovie(file2, createRefMovie);
        strArr2 = System.out;
        StringBuilder stringBuilder3 = new StringBuilder("INFO: Created reference file: ");
        stringBuilder3.append(file2.getAbsolutePath());
        strArr2.println(stringBuilder3.toString());
    }

    protected void help() {
        System.out.println("Quicktime movie editor");
        System.out.println("Syntax: qtedit <command1> <options> ... <commandN> <options> <movie> <output>");
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
