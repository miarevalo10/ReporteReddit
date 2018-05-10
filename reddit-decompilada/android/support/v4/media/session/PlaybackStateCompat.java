package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Creator<PlaybackStateCompat> CREATOR = new C01151();
    final int f1308a;
    final long f1309b;
    final long f1310c;
    final float f1311d;
    final long f1312e;
    final int f1313f;
    final CharSequence f1314g;
    final long f1315h;
    List<CustomAction> f1316i;
    final long f1317j;
    final Bundle f1318k;
    private Object f1319l;

    static class C01151 implements Creator<PlaybackStateCompat> {
        C01151() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }
    }

    public static final class CustomAction implements Parcelable {
        public static final Creator<CustomAction> CREATOR = new C01161();
        private final String f1303a;
        private final CharSequence f1304b;
        private final int f1305c;
        private final Bundle f1306d;
        private Object f1307e;

        static class C01161 implements Creator<CustomAction> {
            C01161() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new CustomAction[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }
        }

        public final int describeContents() {
            return 0;
        }

        private CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.f1303a = str;
            this.f1304b = charSequence;
            this.f1305c = i;
            this.f1306d = bundle;
        }

        CustomAction(Parcel parcel) {
            this.f1303a = parcel.readString();
            this.f1304b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f1305c = parcel.readInt();
            this.f1306d = parcel.readBundle();
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f1303a);
            TextUtils.writeToParcel(this.f1304b, parcel, i);
            parcel.writeInt(this.f1305c);
            parcel.writeBundle(this.f1306d);
        }

        public static CustomAction m954a(Object obj) {
            if (obj != null) {
                if (VERSION.SDK_INT >= 21) {
                    CustomAction customAction = new CustomAction(CustomAction.m956a(obj), CustomAction.m957b(obj), CustomAction.m958c(obj), CustomAction.m959d(obj));
                    customAction.f1307e = obj;
                    return customAction;
                }
            }
            return null;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Action:mName='");
            stringBuilder.append(this.f1304b);
            stringBuilder.append(", mIcon=");
            stringBuilder.append(this.f1305c);
            stringBuilder.append(", mExtras=");
            stringBuilder.append(this.f1306d);
            return stringBuilder.toString();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public final int describeContents() {
        return 0;
    }

    private PlaybackStateCompat(int i, long j, long j2, float f, long j3, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.f1308a = i;
        this.f1309b = j;
        this.f1310c = j2;
        this.f1311d = f;
        this.f1312e = j3;
        this.f1313f = 0;
        this.f1314g = charSequence;
        this.f1315h = j4;
        this.f1316i = new ArrayList(list);
        this.f1317j = j5;
        this.f1318k = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f1308a = parcel.readInt();
        this.f1309b = parcel.readLong();
        this.f1311d = parcel.readFloat();
        this.f1315h = parcel.readLong();
        this.f1310c = parcel.readLong();
        this.f1312e = parcel.readLong();
        this.f1314g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1316i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f1317j = parcel.readLong();
        this.f1318k = parcel.readBundle();
        this.f1313f = parcel.readInt();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("PlaybackState {");
        stringBuilder.append("state=");
        stringBuilder.append(this.f1308a);
        stringBuilder.append(", position=");
        stringBuilder.append(this.f1309b);
        stringBuilder.append(", buffered position=");
        stringBuilder.append(this.f1310c);
        stringBuilder.append(", speed=");
        stringBuilder.append(this.f1311d);
        stringBuilder.append(", updated=");
        stringBuilder.append(this.f1315h);
        stringBuilder.append(", actions=");
        stringBuilder.append(this.f1312e);
        stringBuilder.append(", error code=");
        stringBuilder.append(this.f1313f);
        stringBuilder.append(", error message=");
        stringBuilder.append(this.f1314g);
        stringBuilder.append(", custom actions=");
        stringBuilder.append(this.f1316i);
        stringBuilder.append(", active item id=");
        stringBuilder.append(this.f1317j);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1308a);
        parcel.writeLong(this.f1309b);
        parcel.writeFloat(this.f1311d);
        parcel.writeLong(this.f1315h);
        parcel.writeLong(this.f1310c);
        parcel.writeLong(this.f1312e);
        TextUtils.writeToParcel(this.f1314g, parcel, i);
        parcel.writeTypedList(this.f1316i);
        parcel.writeLong(this.f1317j);
        parcel.writeBundle(this.f1318k);
        parcel.writeInt(this.f1313f);
    }

    public static PlaybackStateCompat m955a(Object obj) {
        Object obj2 = obj;
        PlaybackStateCompat playbackStateCompat = null;
        if (obj2 == null || VERSION.SDK_INT < 21) {
            return null;
        }
        List list;
        List<Object> h = PlaybackStateCompatApi21.m967h(obj);
        if (h != null) {
            List arrayList = new ArrayList(h.size());
            for (Object a : h) {
                arrayList.add(CustomAction.m954a(a));
            }
            list = arrayList;
        } else {
            list = null;
        }
        if (VERSION.SDK_INT >= 22) {
            playbackStateCompat = PlaybackStateCompatApi22.m969a(obj);
        }
        PlaybackStateCompat playbackStateCompat2 = new PlaybackStateCompat(PlaybackStateCompatApi21.m960a(obj), PlaybackStateCompatApi21.m961b(obj), PlaybackStateCompatApi21.m962c(obj), PlaybackStateCompatApi21.m963d(obj), PlaybackStateCompatApi21.m964e(obj), PlaybackStateCompatApi21.m965f(obj), PlaybackStateCompatApi21.m966g(obj), list, PlaybackStateCompatApi21.m968i(obj), playbackStateCompat);
        playbackStateCompat2.f1319l = obj2;
        return playbackStateCompat2;
    }
}
