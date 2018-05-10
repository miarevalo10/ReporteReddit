package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class AssetDataSource implements DataSource {
    private final AssetManager f13628a;
    private final TransferListener<? super AssetDataSource> f13629b;
    private Uri f13630c;
    private InputStream f13631d;
    private long f13632e;
    private boolean f13633f;

    public static final class AssetDataSourceException extends IOException {
        public AssetDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public AssetDataSource(Context context, TransferListener<? super AssetDataSource> transferListener) {
        this.f13628a = context.getAssets();
        this.f13629b = transferListener;
    }

    public final long mo1435a(DataSpec dataSpec) throws AssetDataSourceException {
        try {
            this.f13630c = dataSpec.f5167a;
            String path = this.f13630c.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith(Operation.DIVISION)) {
                path = path.substring(1);
            }
            this.f13631d = this.f13628a.open(path, 1);
            if (this.f13631d.skip(dataSpec.f5170d) < dataSpec.f5170d) {
                throw new EOFException();
            }
            if (dataSpec.f5171e != -1) {
                this.f13632e = dataSpec.f5171e;
            } else {
                this.f13632e = (long) this.f13631d.available();
                if (this.f13632e == 2147483647L) {
                    this.f13632e = -1;
                }
            }
            this.f13633f = true;
            if (this.f13629b != null) {
                this.f13629b.mo1473b();
            }
            return this.f13632e;
        } catch (DataSpec dataSpec2) {
            throw new AssetDataSourceException(dataSpec2);
        }
    }

    public final int mo1434a(byte[] bArr, int i, int i2) throws AssetDataSourceException {
        if (i2 == 0) {
            return null;
        }
        if (this.f13632e == 0) {
            return -1;
        }
        try {
            if (this.f13632e != -1) {
                i2 = (int) Math.min(this.f13632e, (long) i2);
            }
            bArr = this.f13631d.read(bArr, i, i2);
            if (bArr != -1) {
                if (this.f13632e != -1) {
                    this.f13632e -= (long) bArr;
                }
                if (this.f13629b != 0) {
                    this.f13629b.mo1472a(bArr);
                }
                return bArr;
            } else if (this.f13632e == -1) {
                return -1;
            } else {
                throw new AssetDataSourceException(new EOFException());
            }
        } catch (byte[] bArr2) {
            throw new AssetDataSourceException(bArr2);
        }
    }

    public final Uri mo1437b() {
        return this.f13630c;
    }

    public final void mo1436a() throws AssetDataSourceException {
        this.f13630c = null;
        try {
            if (this.f13631d != null) {
                this.f13631d.close();
            }
            this.f13631d = null;
            if (this.f13633f) {
                this.f13633f = false;
                if (this.f13629b != null) {
                    this.f13629b.mo1474c();
                }
            }
        } catch (IOException e) {
            throw new AssetDataSourceException(e);
        } catch (Throwable th) {
            this.f13631d = null;
            if (this.f13633f) {
                this.f13633f = false;
                if (this.f13629b != null) {
                    this.f13629b.mo1474c();
                }
            }
        }
    }
}
