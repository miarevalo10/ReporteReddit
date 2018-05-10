package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import java.util.ArrayList;
import java.util.List;

public class MediaSessionCompat {

    public static final class QueueItem implements Parcelable {
        public static final Creator<QueueItem> CREATOR = new C01111();
        private final MediaDescriptionCompat f1292a;
        private final long f1293b;
        private Object f1294c;

        static class C01111 implements Creator<QueueItem> {
            C01111() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new QueueItem[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }
        }

        public final int describeContents() {
            return 0;
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            } else if (j == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            } else {
                this.f1292a = mediaDescriptionCompat;
                this.f1293b = j;
                this.f1294c = obj;
            }
        }

        QueueItem(Parcel parcel) {
            this.f1292a = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f1293b = parcel.readLong();
        }

        public final void writeToParcel(Parcel parcel, int i) {
            this.f1292a.writeToParcel(parcel, i);
            parcel.writeLong(this.f1293b);
        }

        public static List<QueueItem> m951a(List<?> list) {
            if (list != null) {
                if (VERSION.SDK_INT >= 21) {
                    List<QueueItem> arrayList = new ArrayList();
                    for (Object next : list) {
                        Object queueItem;
                        if (next != null) {
                            if (VERSION.SDK_INT >= 21) {
                                queueItem = new QueueItem(next, MediaDescriptionCompat.m855a(QueueItem.m952a(next)), QueueItem.m953b(next));
                                arrayList.add(queueItem);
                            }
                        }
                        queueItem = null;
                        arrayList.add(queueItem);
                    }
                    return arrayList;
                }
            }
            return null;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("MediaSession.QueueItem {Description=");
            stringBuilder.append(this.f1292a);
            stringBuilder.append(", Id=");
            stringBuilder.append(this.f1293b);
            stringBuilder.append(" }");
            return stringBuilder.toString();
        }
    }

    static final class ResultReceiverWrapper implements Parcelable {
        public static final Creator<ResultReceiverWrapper> CREATOR = new C01121();
        private ResultReceiver f1295a;

        static class C01121 implements Creator<ResultReceiverWrapper> {
            C01121() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ResultReceiverWrapper[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }
        }

        public final int describeContents() {
            return 0;
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.f1295a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public final void writeToParcel(Parcel parcel, int i) {
            this.f1295a.writeToParcel(parcel, i);
        }
    }

    public static final class Token implements Parcelable {
        public static final Creator<Token> CREATOR = new C01131();
        private final Object f1296a;
        private final IMediaSession f1297b;

        static class C01131 implements Creator<Token> {
            C01131() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new Token[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                if (VERSION.SDK_INT >= 21) {
                    parcel = parcel.readParcelable(null);
                } else {
                    parcel = parcel.readStrongBinder();
                }
                return new Token(parcel);
            }
        }

        public final int describeContents() {
            return 0;
        }

        Token(Object obj) {
            this(obj, (byte) 0);
        }

        private Token(Object obj, byte b) {
            this.f1296a = obj;
            this.f1297b = null;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            if (VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.f1296a, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.f1296a);
            }
        }

        public final int hashCode() {
            if (this.f1296a == null) {
                return 0;
            }
            return this.f1296a.hashCode();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            if (this.f1296a == null) {
                return token.f1296a == null;
            } else {
                if (token.f1296a == null) {
                    return false;
                }
                return this.f1296a.equals(token.f1296a);
            }
        }
    }
}
