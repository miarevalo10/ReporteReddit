package com.bumptech.glide.load.resource.file;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.File;
import java.io.IOException;

public class FileDecoder implements ResourceDecoder<File, File> {
    public final /* bridge */ /* synthetic */ boolean mo980a(Object obj, Options options) throws IOException {
        return true;
    }

    public final /* synthetic */ Resource mo979a(Object obj, int i, int i2, Options options) throws IOException {
        return new FileResource((File) obj);
    }
}
