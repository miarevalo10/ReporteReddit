package com.danikula.videocache.file;

import com.danikula.videocache.Cache;
import com.danikula.videocache.ProxyCacheException;
import java.io.File;
import java.io.RandomAccessFile;

public class FileCache implements Cache {
    private static final String TEMP_POSTFIX = ".download";
    private RandomAccessFile dataFile;
    private final DiskUsage diskUsage;
    public File file;

    public FileCache(File file) throws ProxyCacheException {
        this(file, new UnlimitedDiskUsage());
    }

    public FileCache(File file, DiskUsage diskUsage) throws ProxyCacheException {
        if (diskUsage == null) {
            try {
                throw new NullPointerException();
            } catch (DiskUsage diskUsage2) {
                StringBuilder stringBuilder = new StringBuilder("Error using file ");
                stringBuilder.append(file);
                stringBuilder.append(" as disc cache");
                throw new ProxyCacheException(stringBuilder.toString(), diskUsage2);
            }
        }
        File file2;
        this.diskUsage = diskUsage2;
        Files.m3357a(file.getParentFile());
        diskUsage2 = file.exists();
        if (diskUsage2 != null) {
            file2 = file;
        } else {
            File parentFile = file.getParentFile();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(file.getName());
            stringBuilder2.append(TEMP_POSTFIX);
            file2 = new File(parentFile, stringBuilder2.toString());
        }
        this.file = file2;
        this.dataFile = new RandomAccessFile(this.file, diskUsage2 != null ? "r" : "rw");
    }

    public synchronized long available() throws ProxyCacheException {
        try {
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder("Error reading length of file ");
            stringBuilder.append(this.file);
            throw new ProxyCacheException(stringBuilder.toString(), e);
        }
        return (long) ((int) this.dataFile.length());
    }

    public synchronized int read(byte[] bArr, long j, int i) throws ProxyCacheException {
        try {
            this.dataFile.seek(j);
        } catch (Throwable e) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(available()), Integer.valueOf(bArr.length)}), e);
        }
        return this.dataFile.read(bArr, 0, i);
    }

    public synchronized void append(byte[] bArr, int i) throws ProxyCacheException {
        try {
            if (isCompleted()) {
                StringBuilder stringBuilder = new StringBuilder("Error append cache: cache file ");
                stringBuilder.append(this.file);
                stringBuilder.append(" is completed!");
                throw new ProxyCacheException(stringBuilder.toString());
            }
            this.dataFile.seek(available());
            this.dataFile.write(bArr, 0, i);
        } catch (Throwable e) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", new Object[]{Integer.valueOf(i), this.dataFile, Integer.valueOf(bArr.length)}), e);
        }
    }

    public synchronized void close() throws ProxyCacheException {
        try {
            this.dataFile.close();
            this.diskUsage.mo1103a(this.file);
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder("Error closing file ");
            stringBuilder.append(this.file);
            throw new ProxyCacheException(stringBuilder.toString(), e);
        }
    }

    public synchronized void complete() throws ProxyCacheException {
        StringBuilder stringBuilder;
        if (!isCompleted()) {
            close();
            File file = new File(this.file.getParentFile(), this.file.getName().substring(0, this.file.getName().length() - 9));
            if (this.file.renameTo(file)) {
                this.file = file;
                try {
                    this.dataFile = new RandomAccessFile(this.file, "r");
                    this.diskUsage.mo1103a(this.file);
                    return;
                } catch (Throwable e) {
                    stringBuilder = new StringBuilder("Error opening ");
                    stringBuilder.append(this.file);
                    stringBuilder.append(" as disc cache");
                    throw new ProxyCacheException(stringBuilder.toString(), e);
                }
            }
            stringBuilder = new StringBuilder("Error renaming file ");
            stringBuilder.append(this.file);
            stringBuilder.append(" to ");
            stringBuilder.append(file);
            stringBuilder.append(" for completion!");
            throw new ProxyCacheException(stringBuilder.toString());
        }
    }

    public synchronized boolean isCompleted() {
        return !isTempFile(this.file);
    }

    public File getFile() {
        return this.file;
    }

    private boolean isTempFile(File file) {
        return file.getName().endsWith(TEMP_POSTFIX);
    }
}
