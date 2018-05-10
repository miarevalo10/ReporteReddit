package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class ContentDataSource implements DataSource {
    private final ContentResolver f13634a;
    private final TransferListener<? super ContentDataSource> f13635b;
    private Uri f13636c;
    private AssetFileDescriptor f13637d;
    private InputStream f13638e;
    private long f13639f;
    private boolean f13640g;

    public static class ContentDataSourceException extends IOException {
        public ContentDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public ContentDataSource(Context context, TransferListener<? super ContentDataSource> transferListener) {
        this.f13634a = context.getContentResolver();
        this.f13635b = transferListener;
    }

    public final long mo1435a(DataSpec dataSpec) throws ContentDataSourceException {
        try {
            this.f13636c = dataSpec.f5167a;
            this.f13637d = this.f13634a.openAssetFileDescriptor(this.f13636c, "r");
            if (this.f13637d == null) {
                StringBuilder stringBuilder = new StringBuilder("Could not open file descriptor for: ");
                stringBuilder.append(this.f13636c);
                throw new FileNotFoundException(stringBuilder.toString());
            }
            this.f13638e = new FileInputStream(this.f13637d.getFileDescriptor());
            long startOffset = this.f13637d.getStartOffset();
            long skip = this.f13638e.skip(dataSpec.f5170d + startOffset) - startOffset;
            if (skip != dataSpec.f5170d) {
                throw new EOFException();
            }
            if (dataSpec.f5171e != -1) {
                this.f13639f = dataSpec.f5171e;
            } else {
                startOffset = this.f13637d.getLength();
                if (startOffset == -1) {
                    this.f13639f = (long) this.f13638e.available();
                    if (this.f13639f == 0) {
                        this.f13639f = -1;
                    }
                } else {
                    this.f13639f = startOffset - skip;
                }
            }
            this.f13640g = true;
            if (this.f13635b != null) {
                this.f13635b.mo1473b();
            }
            return this.f13639f;
        } catch (DataSpec dataSpec2) {
            throw new ContentDataSourceException(dataSpec2);
        }
    }

    public final int mo1434a(byte[] bArr, int i, int i2) throws ContentDataSourceException {
        if (i2 == 0) {
            return null;
        }
        if (this.f13639f == 0) {
            return -1;
        }
        try {
            if (this.f13639f != -1) {
                i2 = (int) Math.min(this.f13639f, (long) i2);
            }
            bArr = this.f13638e.read(bArr, i, i2);
            if (bArr != -1) {
                if (this.f13639f != -1) {
                    this.f13639f -= (long) bArr;
                }
                if (this.f13635b != 0) {
                    this.f13635b.mo1472a(bArr);
                }
                return bArr;
            } else if (this.f13639f == -1) {
                return -1;
            } else {
                throw new ContentDataSourceException(new EOFException());
            }
        } catch (byte[] bArr2) {
            throw new ContentDataSourceException(bArr2);
        }
    }

    public final Uri mo1437b() {
        return this.f13636c;
    }

    public final void mo1436a() throws ContentDataSourceException {
        this.f13636c = null;
        try {
            if (this.f13638e != null) {
                this.f13638e.close();
            }
            this.f13638e = null;
            try {
                if (this.f13637d != null) {
                    this.f13637d.close();
                }
                this.f13637d = null;
                if (this.f13640g) {
                    this.f13640g = false;
                    if (this.f13635b != null) {
                        this.f13635b.mo1474c();
                    }
                }
            } catch (IOException e) {
                throw new ContentDataSourceException(e);
            } catch (Throwable th) {
                this.f13637d = null;
                if (this.f13640g) {
                    this.f13640g = false;
                    if (this.f13635b != null) {
                        this.f13635b.mo1474c();
                    }
                }
            }
        } catch (IOException e2) {
            throw new ContentDataSourceException(e2);
        } catch (Throwable th2) {
            this.f13638e = null;
            try {
                if (this.f13637d != null) {
                    this.f13637d.close();
                }
                this.f13637d = null;
                if (this.f13640g) {
                    this.f13640g = false;
                    if (this.f13635b != null) {
                        this.f13635b.mo1474c();
                    }
                }
            } catch (IOException e22) {
                throw new ContentDataSourceException(e22);
            } catch (Throwable th3) {
                this.f13637d = null;
                if (this.f13640g) {
                    this.f13640g = false;
                    if (this.f13635b != null) {
                        this.f13635b.mo1474c();
                    }
                }
            }
        }
    }
}
