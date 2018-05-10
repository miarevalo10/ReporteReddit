package com.reddit.social.presentation.chatinbox.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.reddit.social.presentation.chatinbox.view.ChatInboxScreen.ChatNavType;
import com.reddit.social.presentation.chatinbox.view.ChatInboxScreen.DeepLinker;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class ChatInboxScreen$DeepLinker$$Parcelable implements Parcelable, ParcelWrapper<DeepLinker> {
    public static final Creator<ChatInboxScreen$DeepLinker$$Parcelable> CREATOR = new C19371();
    private DeepLinker deepLinker$$0;

    /* compiled from: ChatInboxScreen$DeepLinker$$Parcelable */
    static class C19371 implements Creator<ChatInboxScreen$DeepLinker$$Parcelable> {
        C19371() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ChatInboxScreen$DeepLinker$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ChatInboxScreen$DeepLinker$$Parcelable(ChatInboxScreen$DeepLinker$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public ChatInboxScreen$DeepLinker$$Parcelable(DeepLinker deepLinker) {
        this.deepLinker$$0 = deepLinker;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.deepLinker$$0, parcel, i, new IdentityCollection());
    }

    public static void write(DeepLinker deepLinker, Parcel parcel, int i, IdentityCollection identityCollection) {
        i = identityCollection.m28663b((Object) deepLinker);
        if (i != -1) {
            parcel.writeInt(i);
            return;
        }
        parcel.writeInt(identityCollection.m28660a((Object) deepLinker));
        i = deepLinker.chatNavType;
        if (i == 0) {
            i = 0;
        } else {
            i = i.name();
        }
        parcel.writeString(i);
        parcel.writeString(deepLinker.channelUrl);
    }

    public DeepLinker getParcel() {
        return this.deepLinker$$0;
    }

    public static DeepLinker read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.m28662a(readInt)) {
            ChatNavType chatNavType;
            int a = identityCollection.m28660a(IdentityCollection.f27202a);
            DeepLinker deepLinker = new DeepLinker();
            identityCollection.m28661a(a, deepLinker);
            String readString = parcel.readString();
            if (readString == null) {
                chatNavType = null;
            } else {
                chatNavType = (ChatNavType) Enum.valueOf(ChatNavType.class, readString);
            }
            deepLinker.chatNavType = chatNavType;
            deepLinker.channelUrl = parcel.readString();
            identityCollection.m28661a(readInt, deepLinker);
            return deepLinker;
        } else if (identityCollection.m28664b(readInt) == null) {
            return (DeepLinker) identityCollection.m28665c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
