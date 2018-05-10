package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* compiled from: BackStackRecord */
final class BackStackState implements Parcelable {
    public static final Creator<BackStackState> CREATOR = new C00791();
    final int[] f940a;
    final int f941b;
    final int f942c;
    final String f943d;
    final int f944e;
    final int f945f;
    final CharSequence f946g;
    final int f947h;
    final CharSequence f948i;
    final ArrayList<String> f949j;
    final ArrayList<String> f950k;
    final boolean f951l;

    /* compiled from: BackStackRecord */
    static class C00791 implements Creator<BackStackState> {
        C00791() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BackStackState[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public BackStackState(BackStackRecord backStackRecord) {
        int size = backStackRecord.f11253b.size();
        this.f940a = new int[(size * 6)];
        if (backStackRecord.f11260i) {
            int i = 0;
            int i2 = 0;
            while (i < size) {
                Op op = (Op) backStackRecord.f11253b.get(i);
                int i3 = i2 + 1;
                this.f940a[i2] = op.f934a;
                int i4 = i3 + 1;
                this.f940a[i3] = op.f935b != null ? op.f935b.mIndex : -1;
                i3 = i4 + 1;
                this.f940a[i4] = op.f936c;
                i4 = i3 + 1;
                this.f940a[i3] = op.f937d;
                i3 = i4 + 1;
                this.f940a[i4] = op.f938e;
                i4 = i3 + 1;
                this.f940a[i3] = op.f939f;
                i++;
                i2 = i4;
            }
            this.f941b = backStackRecord.f11258g;
            this.f942c = backStackRecord.f11259h;
            this.f943d = backStackRecord.f11262k;
            this.f944e = backStackRecord.f11264m;
            this.f945f = backStackRecord.f11265n;
            this.f946g = backStackRecord.f11266o;
            this.f947h = backStackRecord.f11267p;
            this.f948i = backStackRecord.f11268q;
            this.f949j = backStackRecord.f11269r;
            this.f950k = backStackRecord.f11270s;
            this.f951l = backStackRecord.f11271t;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackState(Parcel parcel) {
        this.f940a = parcel.createIntArray();
        this.f941b = parcel.readInt();
        this.f942c = parcel.readInt();
        this.f943d = parcel.readString();
        this.f944e = parcel.readInt();
        this.f945f = parcel.readInt();
        this.f946g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f947h = parcel.readInt();
        this.f948i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f949j = parcel.createStringArrayList();
        this.f950k = parcel.createStringArrayList();
        this.f951l = parcel.readInt() != null ? true : null;
    }

    public final BackStackRecord m523a(FragmentManagerImpl fragmentManagerImpl) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManagerImpl);
        int i = 0;
        int i2 = 0;
        while (i < this.f940a.length) {
            Op op = new Op();
            int i3 = i + 1;
            op.f934a = this.f940a[i];
            if (FragmentManagerImpl.f11300a) {
                StringBuilder stringBuilder = new StringBuilder("Instantiate ");
                stringBuilder.append(backStackRecord);
                stringBuilder.append(" op #");
                stringBuilder.append(i2);
                stringBuilder.append(" base fragment #");
                stringBuilder.append(this.f940a[i3]);
                Log.v("FragmentManager", stringBuilder.toString());
            }
            int i4 = i3 + 1;
            i = this.f940a[i3];
            if (i >= 0) {
                op.f935b = (Fragment) fragmentManagerImpl.f11311f.get(i);
            } else {
                op.f935b = null;
            }
            i3 = i4 + 1;
            op.f936c = this.f940a[i4];
            i4 = i3 + 1;
            op.f937d = this.f940a[i3];
            i3 = i4 + 1;
            op.f938e = this.f940a[i4];
            i4 = i3 + 1;
            op.f939f = this.f940a[i3];
            backStackRecord.f11254c = op.f936c;
            backStackRecord.f11255d = op.f937d;
            backStackRecord.f11256e = op.f938e;
            backStackRecord.f11257f = op.f939f;
            backStackRecord.m9776a(op);
            i2++;
            i = i4;
        }
        backStackRecord.f11258g = this.f941b;
        backStackRecord.f11259h = this.f942c;
        backStackRecord.f11262k = this.f943d;
        backStackRecord.f11264m = this.f944e;
        backStackRecord.f11260i = true;
        backStackRecord.f11265n = this.f945f;
        backStackRecord.f11266o = this.f946g;
        backStackRecord.f11267p = this.f947h;
        backStackRecord.f11268q = this.f948i;
        backStackRecord.f11269r = this.f949j;
        backStackRecord.f11270s = this.f950k;
        backStackRecord.f11271t = this.f951l;
        backStackRecord.m9775a(1);
        return backStackRecord;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f940a);
        parcel.writeInt(this.f941b);
        parcel.writeInt(this.f942c);
        parcel.writeString(this.f943d);
        parcel.writeInt(this.f944e);
        parcel.writeInt(this.f945f);
        TextUtils.writeToParcel(this.f946g, parcel, 0);
        parcel.writeInt(this.f947h);
        TextUtils.writeToParcel(this.f948i, parcel, 0);
        parcel.writeStringList(this.f949j);
        parcel.writeStringList(this.f950k);
        parcel.writeInt(this.f951l);
    }
}
