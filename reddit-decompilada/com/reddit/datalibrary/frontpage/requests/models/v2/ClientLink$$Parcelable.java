package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.reddit.datalibrary.frontpage.requests.models.v1.AdEvent;
import com.reddit.datalibrary.frontpage.requests.models.v1.AdEvent$;
import com.reddit.datalibrary.frontpage.requests.models.v1.ImageResolution;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkMedia$;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkPreview$;
import com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit;
import java.util.ArrayList;
import java.util.List;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class ClientLink$$Parcelable implements Parcelable, ParcelWrapper<ClientLink> {
    public static final Creator<ClientLink$$Parcelable> CREATOR = new C17411();
    private ClientLink clientLink$$0;

    /* compiled from: ClientLink$$Parcelable */
    static class C17411 implements Creator<ClientLink$$Parcelable> {
        C17411() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ClientLink$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ClientLink$$Parcelable(ClientLink$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public ClientLink$$Parcelable(ClientLink clientLink) {
        this.clientLink$$0 = clientLink;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.clientLink$$0, parcel, i, new IdentityCollection());
    }

    public static void write(ClientLink clientLink, Parcel parcel, int i, IdentityCollection identityCollection) {
        int b = identityCollection.m28663b((Object) clientLink);
        if (b != -1) {
            parcel.writeInt(b);
            return;
        }
        parcel.writeInt(identityCollection.m28660a((Object) clientLink));
        parcel.writeString(clientLink.video_scrubber_media_url);
        if (clientLink.link_flair_richtext == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(clientLink.link_flair_richtext.size());
            for (FlairRichTextItem write : clientLink.link_flair_richtext) {
                FlairRichTextItem$$Parcelable.write(write, parcel, i, identityCollection);
            }
        }
        if (clientLink.author_flair_richtext == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(clientLink.author_flair_richtext.size());
            for (FlairRichTextItem write2 : clientLink.author_flair_richtext) {
                FlairRichTextItem$$Parcelable.write(write2, parcel, i, identityCollection);
            }
        }
        parcel.writeInt(clientLink.is_blank);
        parcel.writeInt(clientLink.saved);
        parcel.writeInt(clientLink._read);
        parcel.writeInt(clientLink.over_18);
        parcel.writeString(clientLink.domainOverride);
        parcel.writeInt(clientLink.hide_score);
        parcel.writeString(clientLink.rvp_hls_url);
        parcel.writeString(clientLink.body);
        parcel.writeInt(clientLink.promoted);
        parcel.writeString(clientLink.rvp_transcoder_status);
        parcel.writeString(clientLink.subreddit_id);
        parcel.writeString(clientLink.subreddit);
        parcel.writeInt(clientLink.score);
        parcel.writeLong(clientLink.num_comments);
        parcel.writeString(clientLink.suggested_sort);
        parcel.writeInt(clientLink.approved);
        if (clientLink._sourceData == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(clientLink._sourceData.size());
            for (ImageResolution writeParcelable : clientLink._sourceData) {
                parcel.writeParcelable(writeParcelable, i);
            }
        }
        parcel.writeInt(clientLink.rvp_duration);
        parcel.writeString(clientLink.rvp_dash_url);
        parcel.writeInt(clientLink.spoiler);
        parcel.writeLong(clientLink._readUtc);
        parcel.writeString(clientLink.id);
        parcel.writeString(clientLink.post_hint);
        parcel.writeString(clientLink.websocket_url);
        parcel.writeLong(clientLink.created_utc);
        parcel.writeInt(clientLink.locked);
        parcel.writeInt(clientLink._dirty);
        if (clientLink.events == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(clientLink.events.size());
            for (AdEvent write3 : clientLink.events) {
                AdEvent$.Parcelable.write(write3, parcel, i, identityCollection);
            }
        }
        int i2 = 1;
        if (clientLink.likes == null) {
            i2 = -1;
        } else {
            parcel.writeInt(1);
            if (!clientLink.likes.booleanValue()) {
                i2 = 0;
            }
        }
        parcel.writeInt(i2);
        parcel.writeInt(clientLink.has_reddit_video_preview);
        parcel.writeInt(clientLink._linkType);
        parcel.writeString(clientLink.thumbnail);
        parcel.writeParcelable(clientLink._mp4Preview, i);
        parcel.writeString(clientLink.circlepost_websocket_url);
        parcel.writeString(clientLink.author);
        parcel.writeInt(clientLink.rvp_width);
        parcel.writeString(clientLink.video_dash_url);
        parcel.writeInt(clientLink.brand_safe);
        if (clientLink._nsfwData == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(clientLink._nsfwData.size());
            for (ImageResolution writeParcelable2 : clientLink._nsfwData) {
                parcel.writeParcelable(writeParcelable2, i);
            }
        }
        parcel.writeString(clientLink.approved_by);
        parcel.writeInt(clientLink.is_video);
        parcel.writeString(clientLink.location_name);
        parcel.writeParcelable(clientLink._nsfwPreview, i);
        parcel.writeString(clientLink.subreddit_name_prefixed);
        OutboundLink$$Parcelable.write(clientLink.outboundLink, parcel, i, identityCollection);
        parcel.writeString(clientLink.domain);
        parcel.writeString(clientLink.name);
        parcel.writeLong(clientLink._id);
        parcel.writeString(clientLink.permalink);
        parcel.writeString(clientLink.rvp_fallback_url);
        parcel.writeString(clientLink.link_flair_id);
        parcel.writeInt(clientLink.num_reports);
        LinkPreview$.Parcelable.write(clientLink.preview, parcel, i, identityCollection);
        parcel.writeInt(clientLink.video_height);
        parcel.writeInt(clientLink.video_duration);
        parcel.writeString(clientLink.from_kind);
        parcel.writeString(clientLink.from_id);
        if (clientLink.mod_reports == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(clientLink.mod_reports.length);
            for (String[] strArr : clientLink.mod_reports) {
                if (strArr == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(strArr.length);
                    for (String writeString : strArr) {
                        parcel.writeString(writeString);
                    }
                }
            }
        }
        parcel.writeInt(clientLink.rvp_is_gif);
        parcel.writeInt(clientLink.gilded);
        parcel.writeInt(clientLink.hidden);
        parcel.writeString(clientLink.vote_key);
        parcel.writeInt(clientLink.video_width);
        LinkMedia$.Parcelable.write(clientLink.media, parcel, i, identityCollection);
        parcel.writeInt(clientLink.quarantined);
        parcel.writeString(clientLink.title);
        if (clientLink._mp4Data == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(clientLink._mp4Data.size());
            for (ImageResolution writeParcelable22 : clientLink._mp4Data) {
                parcel.writeParcelable(writeParcelable22, i);
            }
        }
        parcel.writeString(clientLink.author_flair_text);
        parcel.writeInt(clientLink.archived);
        parcel.writeInt(clientLink.is_betrayed);
        parcel.writeInt(clientLink.video_is_gif);
        parcel.writeString(clientLink.instanceId);
        if (clientLink._gifData == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(clientLink._gifData.size());
            for (ImageResolution writeParcelable222 : clientLink._gifData) {
                parcel.writeParcelable(writeParcelable222, i);
            }
        }
        parcel.writeParcelable(clientLink._sourcePreview, i);
        parcel.writeString(clientLink.scrubber_media_url);
        parcel.writeInt(clientLink.is_self);
        parcel.writeString(clientLink.link_flair_text);
        parcel.writeString(clientLink.selftext);
        parcel.writeString(clientLink.selftext_html);
        if (clientLink.crosspost_parent_list == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(clientLink.crosspost_parent_list.size());
            for (ClientLink write4 : clientLink.crosspost_parent_list) {
                write(write4, parcel, i, identityCollection);
            }
        }
        parcel.writeInt(clientLink.author_cakeday);
        if (clientLink.user_reports == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(clientLink.user_reports.length);
            for (String[] strArr2 : clientLink.user_reports) {
                if (strArr2 == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(strArr2.length);
                    for (String writeString2 : strArr2) {
                        parcel.writeString(writeString2);
                    }
                }
            }
        }
        parcel.writeSerializable(clientLink.sr_detail);
        parcel.writeString(clientLink.distinguished);
        parcel.writeString(clientLink.rvp_scrubber_media_url);
        parcel.writeString(clientLink.url);
        parcel.writeInt(clientLink.rvp_height);
        parcel.writeInt(clientLink.stickied);
        parcel.writeInt(clientLink.removed);
        parcel.writeParcelable(clientLink._gifPreview, i);
        parcel.writeInt(clientLink.spam);
        parcel.writeLong(clientLink.view_count);
    }

    public ClientLink getParcel() {
        return this.clientLink$$0;
    }

    public static ClientLink read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.m28662a(readInt)) {
            List list;
            int i;
            List list2;
            int i2;
            Boolean bool;
            String[][] strArr;
            int readInt2;
            String[] strArr2;
            int i3;
            int a = identityCollection.m28660a(IdentityCollection.f27202a);
            ClientLink clientLink = new ClientLink();
            identityCollection.m28661a(a, clientLink);
            clientLink.video_scrubber_media_url = parcel.readString();
            a = parcel.readInt();
            String[][] strArr3 = null;
            boolean z = false;
            if (a < 0) {
                list = null;
            } else {
                list = new ArrayList(a);
                for (i = 0; i < a; i++) {
                    list.add(FlairRichTextItem$$Parcelable.read(parcel, identityCollection));
                }
            }
            clientLink.link_flair_richtext = list;
            a = parcel.readInt();
            if (a < 0) {
                list = null;
            } else {
                list = new ArrayList(a);
                for (i = 0; i < a; i++) {
                    list.add(FlairRichTextItem$$Parcelable.read(parcel, identityCollection));
                }
            }
            clientLink.author_flair_richtext = list;
            clientLink.is_blank = parcel.readInt() == 1;
            clientLink.saved = parcel.readInt() == 1;
            clientLink._read = parcel.readInt() == 1;
            clientLink.over_18 = parcel.readInt() == 1;
            clientLink.domainOverride = parcel.readString();
            clientLink.hide_score = parcel.readInt() == 1;
            clientLink.rvp_hls_url = parcel.readString();
            clientLink.body = parcel.readString();
            clientLink.promoted = parcel.readInt() == 1;
            clientLink.rvp_transcoder_status = parcel.readString();
            clientLink.subreddit_id = parcel.readString();
            clientLink.subreddit = parcel.readString();
            clientLink.score = parcel.readInt();
            clientLink.num_comments = parcel.readLong();
            clientLink.suggested_sort = parcel.readString();
            clientLink.approved = parcel.readInt() == 1;
            a = parcel.readInt();
            if (a < 0) {
                list2 = null;
            } else {
                list2 = new ArrayList(a);
                for (i2 = 0; i2 < a; i2++) {
                    list2.add((ImageResolution) parcel.readParcelable(ClientLink$$Parcelable.class.getClassLoader()));
                }
            }
            clientLink._sourceData = list2;
            clientLink.rvp_duration = parcel.readInt();
            clientLink.rvp_dash_url = parcel.readString();
            clientLink.spoiler = parcel.readInt() == 1;
            clientLink._readUtc = parcel.readLong();
            clientLink.id = parcel.readString();
            clientLink.post_hint = parcel.readString();
            clientLink.websocket_url = parcel.readString();
            clientLink.created_utc = parcel.readLong();
            clientLink.locked = parcel.readInt() == 1;
            clientLink._dirty = parcel.readInt() == 1;
            a = parcel.readInt();
            if (a < 0) {
                list2 = null;
            } else {
                list2 = new ArrayList(a);
                for (i2 = 0; i2 < a; i2++) {
                    list2.add(AdEvent$.Parcelable.read(parcel, identityCollection));
                }
            }
            clientLink.events = list2;
            if (parcel.readInt() < 0) {
                bool = null;
            } else {
                bool = Boolean.valueOf(parcel.readInt() == 1);
            }
            clientLink.likes = bool;
            clientLink.has_reddit_video_preview = parcel.readInt() == 1;
            clientLink._linkType = parcel.readInt();
            clientLink.thumbnail = parcel.readString();
            clientLink._mp4Preview = (ImageResolution) parcel.readParcelable(ClientLink$$Parcelable.class.getClassLoader());
            clientLink.circlepost_websocket_url = parcel.readString();
            clientLink.author = parcel.readString();
            clientLink.rvp_width = parcel.readInt();
            clientLink.video_dash_url = parcel.readString();
            clientLink.brand_safe = parcel.readInt() == 1;
            a = parcel.readInt();
            if (a < 0) {
                list2 = null;
            } else {
                list2 = new ArrayList(a);
                for (i2 = 0; i2 < a; i2++) {
                    list2.add((ImageResolution) parcel.readParcelable(ClientLink$$Parcelable.class.getClassLoader()));
                }
            }
            clientLink._nsfwData = list2;
            clientLink.approved_by = parcel.readString();
            clientLink.is_video = parcel.readInt() == 1;
            clientLink.location_name = parcel.readString();
            clientLink._nsfwPreview = (ImageResolution) parcel.readParcelable(ClientLink$$Parcelable.class.getClassLoader());
            clientLink.subreddit_name_prefixed = parcel.readString();
            clientLink.outboundLink = OutboundLink$$Parcelable.read(parcel, identityCollection);
            clientLink.domain = parcel.readString();
            clientLink.name = parcel.readString();
            clientLink._id = parcel.readLong();
            clientLink.permalink = parcel.readString();
            clientLink.rvp_fallback_url = parcel.readString();
            clientLink.link_flair_id = parcel.readString();
            clientLink.num_reports = parcel.readInt();
            clientLink.preview = LinkPreview$.Parcelable.read(parcel, identityCollection);
            clientLink.video_height = parcel.readInt();
            clientLink.video_duration = parcel.readInt();
            clientLink.from_kind = parcel.readString();
            clientLink.from_id = parcel.readString();
            a = parcel.readInt();
            if (a < 0) {
                strArr = null;
            } else {
                strArr = new String[a][];
                for (i2 = 0; i2 < a; i2++) {
                    readInt2 = parcel.readInt();
                    if (readInt2 < 0) {
                        strArr2 = null;
                    } else {
                        strArr2 = new String[readInt2];
                        for (i3 = 0; i3 < readInt2; i3++) {
                            strArr2[i3] = parcel.readString();
                        }
                    }
                    strArr[i2] = strArr2;
                }
            }
            clientLink.mod_reports = strArr;
            clientLink.rvp_is_gif = parcel.readInt() == 1;
            clientLink.gilded = parcel.readInt();
            clientLink.hidden = parcel.readInt() == 1;
            clientLink.vote_key = parcel.readString();
            clientLink.video_width = parcel.readInt();
            clientLink.media = LinkMedia$.Parcelable.read(parcel, identityCollection);
            clientLink.quarantined = parcel.readInt() == 1;
            clientLink.title = parcel.readString();
            a = parcel.readInt();
            if (a < 0) {
                list2 = null;
            } else {
                list2 = new ArrayList(a);
                for (i2 = 0; i2 < a; i2++) {
                    list2.add((ImageResolution) parcel.readParcelable(ClientLink$$Parcelable.class.getClassLoader()));
                }
            }
            clientLink._mp4Data = list2;
            clientLink.author_flair_text = parcel.readString();
            clientLink.archived = parcel.readInt() == 1;
            clientLink.is_betrayed = parcel.readInt() == 1;
            clientLink.video_is_gif = parcel.readInt() == 1;
            clientLink.instanceId = parcel.readString();
            a = parcel.readInt();
            if (a < 0) {
                list2 = null;
            } else {
                list2 = new ArrayList(a);
                for (i2 = 0; i2 < a; i2++) {
                    list2.add((ImageResolution) parcel.readParcelable(ClientLink$$Parcelable.class.getClassLoader()));
                }
            }
            clientLink._gifData = list2;
            clientLink._sourcePreview = (ImageResolution) parcel.readParcelable(ClientLink$$Parcelable.class.getClassLoader());
            clientLink.scrubber_media_url = parcel.readString();
            clientLink.is_self = parcel.readInt() == 1;
            clientLink.link_flair_text = parcel.readString();
            clientLink.selftext = parcel.readString();
            clientLink.selftext_html = parcel.readString();
            a = parcel.readInt();
            if (a < 0) {
                list2 = null;
            } else {
                list2 = new ArrayList(a);
                for (i2 = 0; i2 < a; i2++) {
                    list2.add(read(parcel, identityCollection));
                }
            }
            clientLink.crosspost_parent_list = list2;
            clientLink.author_cakeday = parcel.readInt() == 1;
            a = parcel.readInt();
            if (a >= 0) {
                strArr = new String[a][];
                for (i2 = 0; i2 < a; i2++) {
                    readInt2 = parcel.readInt();
                    if (readInt2 < 0) {
                        strArr2 = null;
                    } else {
                        strArr2 = new String[readInt2];
                        for (i3 = 0; i3 < readInt2; i3++) {
                            strArr2[i3] = parcel.readString();
                        }
                    }
                    strArr[i2] = strArr2;
                }
                strArr3 = strArr;
            }
            clientLink.user_reports = strArr3;
            clientLink.sr_detail = (Subreddit) parcel.readSerializable();
            clientLink.distinguished = parcel.readString();
            clientLink.rvp_scrubber_media_url = parcel.readString();
            clientLink.url = parcel.readString();
            clientLink.rvp_height = parcel.readInt();
            clientLink.stickied = parcel.readInt() == 1;
            clientLink.removed = parcel.readInt() == 1;
            clientLink._gifPreview = (ImageResolution) parcel.readParcelable(ClientLink$$Parcelable.class.getClassLoader());
            if (parcel.readInt() == 1) {
                z = true;
            }
            clientLink.spam = z;
            clientLink.view_count = parcel.readLong();
            identityCollection.m28661a(readInt, clientLink);
            return clientLink;
        } else if (identityCollection.m28664b(readInt) == null) {
            return (ClientLink) identityCollection.m28665c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
