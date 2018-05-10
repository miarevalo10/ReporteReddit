package com.nytimes.android.external.fs3.filesystem;

import com.nytimes.android.external.fs3.Util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

class FSFile {
    final String f10227a;
    final File f10228b;

    FSFile(File file, String str) throws IOException {
        this.f10227a = str;
        this.f10228b = new File(file, str);
        if (this.f10228b.exists() == null || this.f10228b.isDirectory() == null) {
            file = new Util();
            Util.m8686a(this.f10228b);
            return;
        }
        throw new FileNotFoundException(String.format("expecting a file at %s, instead found a directory", new Object[]{str}));
    }
}
