package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Creator<MediaDescriptionCompat> CREATOR = new C01081();
    private final String f1261a;
    private final CharSequence f1262b;
    private final CharSequence f1263c;
    private final CharSequence f1264d;
    private final Bitmap f1265e;
    private final Uri f1266f;
    private final Bundle f1267g;
    private final Uri f1268h;
    private Object f1269i;

    static class C01081 implements Creator<MediaDescriptionCompat> {
        C01081() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            if (VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.m855a(MediaDescriptionCompatApi21.m865a(parcel));
        }
    }

    public static final class Builder {
        String f1253a;
        CharSequence f1254b;
        CharSequence f1255c;
        CharSequence f1256d;
        Bitmap f1257e;
        Uri f1258f;
        Bundle f1259g;
        Uri f1260h;
    }

    public final int describeContents() {
        return 0;
    }

    private MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f1261a = str;
        this.f1262b = charSequence;
        this.f1263c = charSequence2;
        this.f1264d = charSequence3;
        this.f1265e = bitmap;
        this.f1266f = uri;
        this.f1267g = bundle;
        this.f1268h = uri2;
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.f1261a = parcel.readString();
        this.f1262b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1263c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1264d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1265e = (Bitmap) parcel.readParcelable(null);
        this.f1266f = (Uri) parcel.readParcelable(null);
        this.f1267g = parcel.readBundle();
        this.f1268h = (Uri) parcel.readParcelable(null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (VERSION.SDK_INT < 21) {
            parcel.writeString(this.f1261a);
            TextUtils.writeToParcel(this.f1262b, parcel, i);
            TextUtils.writeToParcel(this.f1263c, parcel, i);
            TextUtils.writeToParcel(this.f1264d, parcel, i);
            parcel.writeParcelable(this.f1265e, i);
            parcel.writeParcelable(this.f1266f, i);
            parcel.writeBundle(this.f1267g);
            parcel.writeParcelable(this.f1268h, i);
            return;
        }
        Object a;
        if (this.f1269i == null) {
            if (VERSION.SDK_INT >= 21) {
                a = Builder.m856a();
                Builder.m862a(a, this.f1261a);
                Builder.m861a(a, this.f1262b);
                Builder.m863b(a, this.f1263c);
                Builder.m864c(a, this.f1264d);
                Builder.m858a(a, this.f1265e);
                Builder.m859a(a, this.f1266f);
                Bundle bundle = this.f1267g;
                if (VERSION.SDK_INT < 23 && this.f1268h != null) {
                    if (bundle == null) {
                        bundle = new Bundle();
                        bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                    }
                    bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f1268h);
                }
                Builder.m860a(a, bundle);
                if (VERSION.SDK_INT >= 23) {
                    Builder.m10036b(a, this.f1268h);
                }
                this.f1269i = Builder.m857a(a);
                a = this.f1269i;
                MediaDescriptionCompatApi21.m867a(a, parcel, i);
            }
        }
        a = this.f1269i;
        MediaDescriptionCompatApi21.m867a(a, parcel, i);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f1262b);
        stringBuilder.append(", ");
        stringBuilder.append(this.f1263c);
        stringBuilder.append(", ");
        stringBuilder.append(this.f1264d);
        return stringBuilder.toString();
    }

    public static MediaDescriptionCompat m855a(Object obj) {
        Bundle bundle = null;
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Uri uri;
        MediaDescriptionCompat mediaDescriptionCompat;
        Builder builder = new Builder();
        builder.f1253a = MediaDescriptionCompatApi21.m866a(obj);
        builder.f1254b = MediaDescriptionCompatApi21.m868b(obj);
        builder.f1255c = MediaDescriptionCompatApi21.m869c(obj);
        builder.f1256d = MediaDescriptionCompatApi21.m870d(obj);
        builder.f1257e = MediaDescriptionCompatApi21.m871e(obj);
        builder.f1258f = MediaDescriptionCompatApi21.m872f(obj);
        Bundle g = MediaDescriptionCompatApi21.m873g(obj);
        if (g == null) {
            uri = null;
        } else {
            uri = (Uri) g.getParcelable("android.support.v4.media.description.MEDIA_URI");
        }
        if (uri != null) {
            if (g.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && g.size() == 2) {
                builder.f1259g = bundle;
                if (uri != null) {
                    builder.f1260h = uri;
                } else if (VERSION.SDK_INT >= 23) {
                    builder.f1260h = MediaDescriptionCompatApi23.m10037h(obj);
                }
                mediaDescriptionCompat = new MediaDescriptionCompat(builder.f1253a, builder.f1254b, builder.f1255c, builder.f1256d, builder.f1257e, builder.f1258f, builder.f1259g, builder.f1260h);
                mediaDescriptionCompat.f1269i = obj;
                return mediaDescriptionCompat;
            }
            g.remove("android.support.v4.media.description.MEDIA_URI");
            g.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        }
        bundle = g;
        builder.f1259g = bundle;
        if (uri != null) {
            builder.f1260h = uri;
        } else if (VERSION.SDK_INT >= 23) {
            builder.f1260h = MediaDescriptionCompatApi23.m10037h(obj);
        }
        mediaDescriptionCompat = new MediaDescriptionCompat(builder.f1253a, builder.f1254b, builder.f1255c, builder.f1256d, builder.f1257e, builder.f1258f, builder.f1259g, builder.f1260h);
        mediaDescriptionCompat.f1269i = obj;
        return mediaDescriptionCompat;
    }
}
