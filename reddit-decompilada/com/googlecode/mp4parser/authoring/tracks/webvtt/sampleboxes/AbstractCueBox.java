package com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.util.CastUtils;
import com.mp4parser.streaming.WriteOnlyBox;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public abstract class AbstractCueBox extends WriteOnlyBox {
    String content = "";

    public AbstractCueBox(String str) {
        super(str);
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public long getSize() {
        return (long) (8 + Utf8.m3309b(this.content));
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(CastUtils.m7705a(getSize()));
        IsoTypeWriter.m3300b(allocate, getSize());
        allocate.put(IsoFile.m17057a(getType()));
        allocate.put(Utf8.m3308a(this.content));
        writableByteChannel.write((ByteBuffer) allocate.rewind());
    }
}
