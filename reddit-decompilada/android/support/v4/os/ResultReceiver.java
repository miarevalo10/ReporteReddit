package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.IResultReceiver.Stub;

public class ResultReceiver implements Parcelable {
    public static final Creator<ResultReceiver> CREATOR = new C01171();
    final boolean f1323a = false;
    final Handler f1324b = null;
    IResultReceiver f1325c;

    static class C01171 implements Creator<ResultReceiver> {
        C01171() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ResultReceiver[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }
    }

    class MyRunnable implements Runnable {
        final int f1320a;
        final Bundle f1321b;
        final /* synthetic */ ResultReceiver f1322c;

        MyRunnable(ResultReceiver resultReceiver, int i, Bundle bundle) {
            this.f1322c = resultReceiver;
            this.f1320a = i;
            this.f1321b = bundle;
        }

        public void run() {
            this.f1322c.mo278a(this.f1320a, this.f1321b);
        }
    }

    class MyResultReceiver extends Stub {
        final /* synthetic */ ResultReceiver f16502a;

        MyResultReceiver(ResultReceiver resultReceiver) {
            this.f16502a = resultReceiver;
        }

        public final void mo349a(int i, Bundle bundle) {
            if (this.f16502a.f1324b != null) {
                this.f16502a.f1324b.post(new MyRunnable(this.f16502a, i, bundle));
            } else {
                this.f16502a.mo278a(i, bundle);
            }
        }
    }

    public void mo278a(int i, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.f1325c == 0) {
                this.f1325c = new MyResultReceiver(this);
            }
            parcel.writeStrongBinder(this.f1325c.asBinder());
        }
    }

    ResultReceiver(Parcel parcel) {
        this.f1325c = Stub.m10111a(parcel.readStrongBinder());
    }
}
