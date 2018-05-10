package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class FileDataSource implements DataSource {
    private final TransferListener<? super FileDataSource> f13670a;
    private RandomAccessFile f13671b;
    private Uri f13672c;
    private long f13673d;
    private boolean f13674e;

    public static class FileDataSourceException extends IOException {
        public FileDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public FileDataSource() {
        this(null);
    }

    public FileDataSource(TransferListener<? super FileDataSource> transferListener) {
        this.f13670a = transferListener;
    }

    public final long mo1435a(DataSpec dataSpec) throws FileDataSourceException {
        try {
            this.f13672c = dataSpec.f5167a;
            this.f13671b = new RandomAccessFile(dataSpec.f5167a.getPath(), "r");
            this.f13671b.seek(dataSpec.f5170d);
            this.f13673d = dataSpec.f5171e == -1 ? this.f13671b.length() - dataSpec.f5170d : dataSpec.f5171e;
            if (this.f13673d < 0) {
                throw new EOFException();
            }
            this.f13674e = true;
            if (this.f13670a != null) {
                this.f13670a.mo1473b();
            }
            return this.f13673d;
        } catch (DataSpec dataSpec2) {
            throw new FileDataSourceException(dataSpec2);
        }
    }

    public final int mo1434a(byte[] bArr, int i, int i2) throws FileDataSourceException {
        if (i2 == 0) {
            return null;
        }
        if (this.f13673d == 0) {
            return -1;
        }
        try {
            bArr = this.f13671b.read(bArr, i, (int) Math.min(this.f13673d, (long) i2));
            if (bArr > null) {
                this.f13673d -= (long) bArr;
                if (this.f13670a != 0) {
                    this.f13670a.mo1472a(bArr);
                }
            }
            return bArr;
        } catch (byte[] bArr2) {
            throw new FileDataSourceException(bArr2);
        }
    }

    public final Uri mo1437b() {
        return this.f13672c;
    }

    public final void mo1436a() throws FileDataSourceException {
        this.f13672c = null;
        try {
            if (this.f13671b != null) {
                this.f13671b.close();
            }
            this.f13671b = null;
            if (this.f13674e) {
                this.f13674e = false;
                if (this.f13670a != null) {
                    this.f13670a.mo1474c();
                }
            }
        } catch (IOException e) {
            throw new FileDataSourceException(e);
        } catch (Throwable th) {
            this.f13671b = null;
            if (this.f13674e) {
                this.f13674e = false;
                if (this.f13670a != null) {
                    this.f13670a.mo1474c();
                }
            }
        }
    }
}
