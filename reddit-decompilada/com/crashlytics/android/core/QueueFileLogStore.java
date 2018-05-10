package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.QueueFile;
import io.fabric.sdk.android.services.common.QueueFile.ElementReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

class QueueFileLogStore implements FileLogStore {
    private QueueFile logFile;
    private final int maxLogSize;
    private final File workingFile;

    public QueueFileLogStore(File file, int i) {
        this.workingFile = file;
        this.maxLogSize = i;
    }

    public void writeToLog(long j, String str) {
        openLogFile();
        doWriteToLog(j, str);
    }

    public ByteString getLogAsByteString() {
        if (!this.workingFile.exists()) {
            return null;
        }
        openLogFile();
        if (this.logFile == null) {
            return null;
        }
        final int[] iArr = new int[]{0};
        final byte[] bArr = new byte[this.logFile.a()];
        try {
            this.logFile.a(new ElementReader() {
                public void read(InputStream inputStream, int i) throws IOException {
                    try {
                        inputStream.read(bArr, iArr[0], i);
                        int[] iArr = iArr;
                        iArr[0] = iArr[0] + i;
                    } finally {
                        inputStream.close();
                    }
                }
            });
        } catch (Throwable e) {
            Fabric.b().c(CrashlyticsCore.TAG, "A problem occurred while reading the Crashlytics log file.", e);
        }
        return ByteString.copyFrom(bArr, 0, iArr[0]);
    }

    public void closeLogFile() {
        CommonUtils.a(this.logFile, "There was a problem closing the Crashlytics log file.");
        this.logFile = null;
    }

    public void deleteLogFile() {
        closeLogFile();
        this.workingFile.delete();
    }

    private void openLogFile() {
        if (this.logFile == null) {
            try {
                this.logFile = new QueueFile(this.workingFile);
            } catch (Throwable e) {
                Logger b = Fabric.b();
                String str = CrashlyticsCore.TAG;
                StringBuilder stringBuilder = new StringBuilder("Could not open log file: ");
                stringBuilder.append(this.workingFile);
                b.c(str, stringBuilder.toString(), e);
            }
        }
    }

    private void doWriteToLog(long j, String str) {
        if (this.logFile != null) {
            if (str == null) {
                str = "null";
            }
            try {
                int i = this.maxLogSize / 4;
                if (str.length() > i) {
                    StringBuilder stringBuilder = new StringBuilder("...");
                    stringBuilder.append(str.substring(str.length() - i));
                    str = stringBuilder.toString();
                }
                str = str.replaceAll("\r", " ").replaceAll("\n", " ");
                j = String.format(Locale.US, "%d %s%n", new Object[]{Long.valueOf(j), str}).getBytes("UTF-8");
                this.logFile.a(j, j.length);
                while (this.logFile.b() == null && this.logFile.a() > this.maxLogSize) {
                    this.logFile.c();
                }
            } catch (long j2) {
                Fabric.b().c(CrashlyticsCore.TAG, "There was a problem writing to the Crashlytics log.", j2);
            }
        }
    }
}
