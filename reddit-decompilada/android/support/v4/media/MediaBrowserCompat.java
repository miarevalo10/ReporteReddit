package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import java.util.ArrayList;

public final class MediaBrowserCompat {
    static final boolean f1252a = Log.isLoggable("MediaBrowserCompat", 3);

    public static abstract class CustomActionCallback {
    }

    public static class MediaItem implements Parcelable {
        public static final Creator<MediaItem> CREATOR = new C01071();
        private final int f1250a;
        private final MediaDescriptionCompat f1251b;

        static class C01071 implements Creator<MediaItem> {
            C01071() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new MediaItem[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }
        }

        public int describeContents() {
            return 0;
        }

        MediaItem(Parcel parcel) {
            this.f1250a = parcel.readInt();
            this.f1251b = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1250a);
            this.f1251b.writeToParcel(parcel, i);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("MediaItem{");
            stringBuilder.append("mFlags=");
            stringBuilder.append(this.f1250a);
            stringBuilder.append(", mDescription=");
            stringBuilder.append(this.f1251b);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    private static class CustomActionResultReceiver extends ResultReceiver {
        private final Bundle f11429d;
        private final CustomActionCallback f11430e;

        protected final void mo278a(int i, Bundle bundle) {
            if (this.f11430e != null) {
                switch (i) {
                    case -1:
                        return;
                    case 0:
                        return;
                    case 1:
                        return;
                    default:
                        StringBuilder stringBuilder = new StringBuilder("Unknown result code: ");
                        stringBuilder.append(i);
                        stringBuilder.append(" (extras=");
                        stringBuilder.append(this.f11429d);
                        stringBuilder.append(", resultData=");
                        stringBuilder.append(bundle);
                        stringBuilder.append(")");
                        Log.w("MediaBrowserCompat", stringBuilder.toString());
                        return;
                }
            }
        }
    }

    private static class ItemReceiver extends ResultReceiver {
        protected final void mo278a(int i, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (i == 0 && bundle != null) {
                if (bundle.containsKey("media_item") != 0) {
                    bundle.getParcelable("media_item");
                }
            }
        }
    }

    private static class SearchResultReceiver extends ResultReceiver {
        protected final void mo278a(int i, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (i == 0 && bundle != null) {
                if (bundle.containsKey("search_results") != 0) {
                    i = bundle.getParcelableArray("search_results");
                    if (i != 0) {
                        bundle = new ArrayList();
                        for (Object obj : i) {
                            bundle.add((MediaItem) obj);
                        }
                    }
                }
            }
        }
    }
}
