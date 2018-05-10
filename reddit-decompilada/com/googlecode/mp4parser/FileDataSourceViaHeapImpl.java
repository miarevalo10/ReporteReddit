package com.googlecode.mp4parser;

import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class FileDataSourceViaHeapImpl implements DataSource {
    private static Logger f15118c = Logger.m7708a(FileDataSourceViaHeapImpl.class);
    FileChannel f15119a;
    String f15120b;

    public FileDataSourceViaHeapImpl(String str) throws FileNotFoundException {
        File file = new File(str);
        this.f15119a = new FileInputStream(file).getChannel();
        this.f15120b = file.getName();
    }

    public synchronized int read(ByteBuffer byteBuffer) throws IOException {
        return this.f15119a.read(byteBuffer);
    }

    public synchronized long size() throws IOException {
        return this.f15119a.size();
    }

    public synchronized long position() throws IOException {
        return this.f15119a.position();
    }

    public synchronized void position(long j) throws IOException {
        this.f15119a.position(j);
    }

    public synchronized long transferTo(long j, long j2, WritableByteChannel writableByteChannel) throws IOException {
        return this.f15119a.transferTo(j, j2, writableByteChannel);
    }

    public synchronized ByteBuffer map(long j, long j2) throws IOException {
        j2 = ByteBuffer.allocate(CastUtils.m7705a(j2));
        this.f15119a.read(j2, j);
        return (ByteBuffer) j2.rewind();
    }

    public void close() throws IOException {
        this.f15119a.close();
    }

    public String toString() {
        return this.f15120b;
    }
}
