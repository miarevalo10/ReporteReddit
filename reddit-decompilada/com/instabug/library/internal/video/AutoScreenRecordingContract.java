package com.instabug.library.internal.video;

import android.net.Uri;

public interface AutoScreenRecordingContract {
    void clear();

    void delete();

    Uri getAutoScreenRecordingFileUri();

    boolean isEnabled();
}
