package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;
import paperparcel.TypeAdapter;
import paperparcel.internal.ListAdapter;
import paperparcel.internal.ParcelableAdapter;
import paperparcel.internal.SerializableAdapter;
import paperparcel.internal.StaticAdapters;
import paperparcel.internal.Utils;

final class PaperParcelLink {
    static final TypeAdapter<List<AdEvent>> AD_EVENT_LIST_ADAPTER = new ListAdapter(AD_EVENT_PARCELABLE_ADAPTER);
    static final TypeAdapter<AdEvent> AD_EVENT_PARCELABLE_ADAPTER = new ParcelableAdapter();
    static final Creator<Link> CREATOR = new C17911();
    static final TypeAdapter<List<FlairRichTextItem>> FLAIR_RICH_TEXT_ITEM_LIST_ADAPTER = new ListAdapter(Utils.a(FLAIR_RICH_TEXT_ITEM_SERIALIZABLE_ADAPTER));
    static final TypeAdapter<FlairRichTextItem> FLAIR_RICH_TEXT_ITEM_SERIALIZABLE_ADAPTER = new SerializableAdapter();
    static final TypeAdapter<List<Link>> LINK_LIST_ADAPTER = new ListAdapter(LINK_PARCELABLE_ADAPTER);
    static final TypeAdapter<LinkMedia> LINK_MEDIA_PARCELABLE_ADAPTER = new ParcelableAdapter();
    static final TypeAdapter<Link> LINK_PARCELABLE_ADAPTER = new ParcelableAdapter();
    static final TypeAdapter<OutboundLink> OUTBOUND_LINK_PARCELABLE_ADAPTER = new ParcelableAdapter();
    static final TypeAdapter<Preview> PREVIEW_PARCELABLE_ADAPTER = new ParcelableAdapter();
    static final TypeAdapter<List<String>> STRING_LIST_ADAPTER = new ListAdapter(StaticAdapters.x);
    static final TypeAdapter<List<List<String>>> STRING_LIST_LIST_ADAPTER = new ListAdapter(Utils.a(STRING_LIST_ADAPTER));
    static final TypeAdapter<SubredditDetail> SUBREDDIT_DETAIL_PARCELABLE_ADAPTER = new ParcelableAdapter();

    static class C17911 implements Creator<Link> {
        C17911() {
        }

        public final Link createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            return new Link((String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), parcel.readLong(), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), parcel.readInt(), (Boolean) Utils.a(parcel2, StaticAdapters.b), parcel.readInt(), parcel.readInt(), parcel.readLong(), (Long) Utils.a(parcel2, StaticAdapters.e), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (List) Utils.a(parcel2, PaperParcelLink.FLAIR_RICH_TEXT_ITEM_LIST_ADAPTER), (List) Utils.a(parcel2, PaperParcelLink.FLAIR_RICH_TEXT_ITEM_LIST_ADAPTER), (String) StaticAdapters.x.a(parcel2), parcel.readInt() == 1, parcel.readInt(), parcel.readInt() == 1, parcel.readInt() == 1, (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (Preview) PaperParcelLink.PREVIEW_PARCELABLE_ADAPTER.a(parcel2), (LinkMedia) PaperParcelLink.LINK_MEDIA_PARCELABLE_ADAPTER.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), parcel.readInt() == 1, (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, (Integer) Utils.a(parcel2, StaticAdapters.a), parcel.readInt() == 1, parcel.readInt() == 1, (String) StaticAdapters.x.a(parcel2), (List) PaperParcelLink.STRING_LIST_LIST_ADAPTER.a(parcel2), (List) PaperParcelLink.STRING_LIST_LIST_ADAPTER.a(parcel2), (List) Utils.a(parcel2, PaperParcelLink.LINK_LIST_ADAPTER), (SubredditDetail) PaperParcelLink.SUBREDDIT_DETAIL_PARCELABLE_ADAPTER.a(parcel2), parcel.readInt() == 1, parcel.readInt() == 1, (List) Utils.a(parcel2, PaperParcelLink.AD_EVENT_LIST_ADAPTER), (OutboundLink) PaperParcelLink.OUTBOUND_LINK_PARCELABLE_ADAPTER.a(parcel2), (String) StaticAdapters.x.a(parcel2), parcel.readInt() == 1);
        }

        public final Link[] newArray(int i) {
            return new Link[i];
        }
    }

    private PaperParcelLink() {
    }

    static void writeToParcel(Link link, Parcel parcel, int i) {
        StaticAdapters.x.a(link.getId(), parcel, i);
        StaticAdapters.x.a(link.getKindWithId(), parcel, i);
        parcel.writeLong(link.getCreatedUtc());
        StaticAdapters.x.a(link.getTitle(), parcel, i);
        StaticAdapters.x.a(link.getDomain(), parcel, i);
        StaticAdapters.x.a(link.getUrl(), parcel, i);
        parcel.writeInt(link.getScore());
        Utils.a(link.getLikes(), parcel, i, StaticAdapters.b);
        parcel.writeInt(link.getUpvoteCount());
        parcel.writeInt(link.getDownvoteCount());
        parcel.writeLong(link.getNumComments());
        Utils.a(link.getViewCount(), parcel, i, StaticAdapters.e);
        StaticAdapters.x.a(link.getSubreddit(), parcel, i);
        StaticAdapters.x.a(link.getSubredditId(), parcel, i);
        StaticAdapters.x.a(link.getSubredditNamePrefixed(), parcel, i);
        StaticAdapters.x.a(link.getLinkFlairText(), parcel, i);
        StaticAdapters.x.a(link.getLinkFlairId(), parcel, i);
        Utils.a(link.getLinkFlairRichTextObject(), parcel, i, FLAIR_RICH_TEXT_ITEM_LIST_ADAPTER);
        Utils.a(link.getAuthorFlairRichTextObject(), parcel, i, FLAIR_RICH_TEXT_ITEM_LIST_ADAPTER);
        StaticAdapters.x.a(link.getAuthor(), parcel, i);
        parcel.writeInt(link.getAuthorCakeday());
        parcel.writeInt(link.getGilded());
        parcel.writeInt(link.getOver18());
        parcel.writeInt(link.getSpoiler());
        StaticAdapters.x.a(link.getSuggestedSort(), parcel, i);
        StaticAdapters.x.a(link.getThumbnail(), parcel, i);
        StaticAdapters.x.a(link.getBody(), parcel, i);
        PREVIEW_PARCELABLE_ADAPTER.a(link.getPreview(), parcel, i);
        LINK_MEDIA_PARCELABLE_ADAPTER.a(link.getMedia(), parcel, i);
        StaticAdapters.x.a(link.getSelftext(), parcel, i);
        StaticAdapters.x.a(link.getSelftextHtml(), parcel, i);
        StaticAdapters.x.a(link.getPermalink(), parcel, i);
        parcel.writeInt(link.isSelf());
        StaticAdapters.x.a(link.getPostHint(), parcel, i);
        StaticAdapters.x.a(link.getAuthorFlairText(), parcel, i);
        StaticAdapters.x.a(link.getWebsocketUrl(), parcel, i);
        parcel.writeInt(link.getArchived());
        parcel.writeInt(link.getLocked());
        parcel.writeInt(link.getQuarantine());
        parcel.writeInt(link.getHidden());
        parcel.writeInt(link.getSaved());
        parcel.writeInt(link.getHideScore());
        parcel.writeInt(link.getStickied());
        parcel.writeInt(link.getCanGild());
        parcel.writeInt(link.getCanMod());
        StaticAdapters.x.a(link.getDistinguished(), parcel, i);
        StaticAdapters.x.a(link.getApprovedBy(), parcel, i);
        parcel.writeInt(link.getApproved());
        parcel.writeInt(link.getRemoved());
        parcel.writeInt(link.getSpam());
        Utils.a(link.getNumReports(), parcel, i, StaticAdapters.a);
        parcel.writeInt(link.getBrandSafe());
        parcel.writeInt(link.isVideo());
        StaticAdapters.x.a(link.getLocationName(), parcel, i);
        STRING_LIST_LIST_ADAPTER.a(link.getModReports(), parcel, i);
        STRING_LIST_LIST_ADAPTER.a(link.getUserReports(), parcel, i);
        Utils.a(link.getCrossPostParentList(), parcel, i, LINK_LIST_ADAPTER);
        SUBREDDIT_DETAIL_PARCELABLE_ADAPTER.a(link.getSubredditDetail(), parcel, i);
        parcel.writeInt(link.getPromoted());
        parcel.writeInt(link.isBlankAd());
        Utils.a(link.getEvents(), parcel, i, AD_EVENT_LIST_ADAPTER);
        OUTBOUND_LINK_PARCELABLE_ADAPTER.a(link.getOutboundLink(), parcel, i);
        StaticAdapters.x.a(link.getDomainOverride(), parcel, i);
        parcel.writeInt(link.isRead());
    }
}
