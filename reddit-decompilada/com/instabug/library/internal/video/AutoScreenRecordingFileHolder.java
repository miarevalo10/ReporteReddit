package com.instabug.library.internal.video;

import android.net.Uri;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;

public class AutoScreenRecordingFileHolder {
    private static final AutoScreenRecordingFileHolder INSTANCE = new AutoScreenRecordingFileHolder();
    private File autoScreenRecordingFile;

    public static AutoScreenRecordingFileHolder getInstance() {
        return INSTANCE;
    }

    public Uri getAutoScreenRecordingFileUri() {
        return this.autoScreenRecordingFile != null ? Uri.fromFile(this.autoScreenRecordingFile) : null;
    }

    public void setAutoScreenRecordingFile(File file) {
        this.autoScreenRecordingFile = file;
    }

    public boolean delete() {
        if (this.autoScreenRecordingFile == null) {
            return true;
        }
        if (!this.autoScreenRecordingFile.delete()) {
            return false;
        }
        InstabugSDKLogger.m8356d(this, "Screen recording file deleted");
        return true;
    }

    public void clear() {
        this.autoScreenRecordingFile = null;
    }
}
