package com.reddit.frontpage.presentation.listing.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.remote.DistinguishType;
import com.reddit.frontpage.domain.model.AdEvent;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.model.LinkMedia;
import com.reddit.frontpage.domain.model.LinkType;
import com.reddit.frontpage.domain.model.OutboundLink;
import com.reddit.frontpage.domain.model.Preview;
import java.util.List;
import paperparcel.TypeAdapter;
import paperparcel.internal.EnumAdapter;
import paperparcel.internal.ListAdapter;
import paperparcel.internal.ParcelableAdapter;
import paperparcel.internal.StaticAdapters;
import paperparcel.internal.Utils;

final class PaperParcelLinkPresentationModel {
    static final TypeAdapter<LinkType> f20620a = new EnumAdapter(LinkType.class);
    static final TypeAdapter<DistinguishType> f20621b = new EnumAdapter(DistinguishType.class);
    static final TypeAdapter<ImageLinkPreviewPresentationModel> f20622c = new ParcelableAdapter();
    static final TypeAdapter<Mp4LinkPreviewPresentationModel> f20623d = new ParcelableAdapter();
    static final TypeAdapter<ImageResolutionPresentationModel> f20624e = new ParcelableAdapter();
    static final TypeAdapter<AdEvent> f20625f = new ParcelableAdapter();
    static final TypeAdapter<List<AdEvent>> f20626g = new ListAdapter(f20625f);
    static final TypeAdapter<OutboundLink> f20627h = new ParcelableAdapter();
    static final TypeAdapter<List<String>> f20628i = new ListAdapter(StaticAdapters.x);
    static final TypeAdapter<List<List<String>>> f20629j = new ListAdapter(Utils.a(f20628i));
    static final TypeAdapter<LinkPresentationModel> f20630k = new ParcelableAdapter();
    static final TypeAdapter<List<LinkPresentationModel>> f20631l = new ListAdapter(f20630k);
    static final TypeAdapter<Preview> f20632m = new ParcelableAdapter();
    static final TypeAdapter<LinkMedia> f20633n = new ParcelableAdapter();
    static final TypeAdapter<Link> f20634o = new ParcelableAdapter();
    static final Creator<LinkPresentationModel> f20635p = new C18281();

    static class C18281 implements Creator<LinkPresentationModel> {
        C18281() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LinkPresentationModel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            return new LinkPresentationModel((LinkType) PaperParcelLinkPresentationModel.f20620a.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), parcel.readLong(), (String) StaticAdapters.x.a(parcel2), parcel.readInt(), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), parcel.readLong(), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), parcel.readInt() == 1, (String) StaticAdapters.x.a(parcel2), parcel.readInt() == 1, parcel.readInt(), (Integer) Utils.a(parcel2, StaticAdapters.a), parcel.readInt() == 1, (DistinguishType) PaperParcelLinkPresentationModel.f20621b.a(parcel2), (String) StaticAdapters.x.a(parcel2), parcel.readInt() == 1, parcel.readInt() == 1, (String) StaticAdapters.x.a(parcel2), parcel.readInt() == 1, (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), parcel.readInt() == 1, (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), parcel.readInt() == 1, (ImageLinkPreviewPresentationModel) PaperParcelLinkPresentationModel.f20622c.a(parcel2), (Mp4LinkPreviewPresentationModel) PaperParcelLinkPresentationModel.f20623d.a(parcel2), (ImageResolutionPresentationModel) PaperParcelLinkPresentationModel.f20624e.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), parcel.readInt() == 1, (List) PaperParcelLinkPresentationModel.f20626g.a(parcel2), parcel.readInt() == 1, (OutboundLink) PaperParcelLinkPresentationModel.f20627h.a(parcel2), (String) StaticAdapters.x.a(parcel2), parcel.readInt(), parcel.readInt() == 1, parcel.readLong(), (Long) Utils.a(parcel2, StaticAdapters.e), parcel.readInt() == 1, parcel.readInt(), (List) PaperParcelLinkPresentationModel.f20629j.a(parcel2), (List) PaperParcelLinkPresentationModel.f20629j.a(parcel2), parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), parcel.readInt() == 1, parcel.readInt() == 1, (List) PaperParcelLinkPresentationModel.f20631l.a(parcel2), (LinkPresentationModel) PaperParcelLinkPresentationModel.f20630k.a(parcel2), (Boolean) Utils.a(parcel2, StaticAdapters.b), parcel.readInt() == 1, (String) StaticAdapters.x.a(parcel2), parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, (Preview) PaperParcelLinkPresentationModel.f20632m.a(parcel2), (LinkMedia) PaperParcelLinkPresentationModel.f20633n.a(parcel2), (Link) PaperParcelLinkPresentationModel.f20634o.a(parcel2));
        }
    }

    private PaperParcelLinkPresentationModel() {
    }

    static void writeToParcel(LinkPresentationModel linkPresentationModel, Parcel parcel, int i) {
        f20620a.a(linkPresentationModel.f33975b, parcel, i);
        StaticAdapters.x.a(linkPresentationModel.f33976c, parcel, i);
        StaticAdapters.x.a(linkPresentationModel.f33977d, parcel, i);
        parcel.writeLong(linkPresentationModel.f33978e);
        StaticAdapters.x.a(linkPresentationModel.getName(), parcel, i);
        parcel.writeInt(linkPresentationModel.getListableType());
        StaticAdapters.x.a(linkPresentationModel.f33979f, parcel, i);
        StaticAdapters.x.a(linkPresentationModel.f33980g, parcel, i);
        StaticAdapters.x.a(linkPresentationModel.f33981h, parcel, i);
        parcel.writeLong(linkPresentationModel.f33982i);
        StaticAdapters.x.a(linkPresentationModel.f33983j, parcel, i);
        StaticAdapters.x.a(linkPresentationModel.f33984k, parcel, i);
        StaticAdapters.x.a(linkPresentationModel.f33985l, parcel, i);
        StaticAdapters.x.a(linkPresentationModel.f33986m, parcel, i);
        parcel.writeInt(linkPresentationModel.f33987n);
        StaticAdapters.x.a(linkPresentationModel.f33988o, parcel, i);
        parcel.writeInt(linkPresentationModel.f33989p);
        parcel.writeInt(linkPresentationModel.f33990q);
        Utils.a(linkPresentationModel.f33991r, parcel, i, StaticAdapters.a);
        parcel.writeInt(linkPresentationModel.f33992s);
        f20621b.a(linkPresentationModel.f33993t, parcel, i);
        StaticAdapters.x.a(linkPresentationModel.f33994u, parcel, i);
        parcel.writeInt(linkPresentationModel.f33995v);
        parcel.writeInt(linkPresentationModel.f33996w);
        StaticAdapters.x.a(linkPresentationModel.f33997x, parcel, i);
        parcel.writeInt(linkPresentationModel.f33998y);
        StaticAdapters.x.a(linkPresentationModel.f33999z, parcel, i);
        StaticAdapters.x.a(linkPresentationModel.f33948A, parcel, i);
        StaticAdapters.x.a(linkPresentationModel.f33949B, parcel, i);
        parcel.writeInt(linkPresentationModel.f33950C);
        StaticAdapters.x.a(linkPresentationModel.f33951D, parcel, i);
        StaticAdapters.x.a(linkPresentationModel.f33952E, parcel, i);
        parcel.writeInt(linkPresentationModel.f33953F);
        f20622c.a(linkPresentationModel.f33954G, parcel, i);
        f20623d.a(linkPresentationModel.f33955H, parcel, i);
        f20624e.a(linkPresentationModel.f33956I, parcel, i);
        StaticAdapters.x.a(linkPresentationModel.f33957J, parcel, i);
        StaticAdapters.x.a(linkPresentationModel.f33958K, parcel, i);
        StaticAdapters.x.a(linkPresentationModel.f33959L, parcel, i);
        parcel.writeInt(linkPresentationModel.f33960M);
        f20626g.a(linkPresentationModel.f33961N, parcel, i);
        parcel.writeInt(linkPresentationModel.f33962O);
        f20627h.a(linkPresentationModel.f33963P, parcel, i);
        StaticAdapters.x.a(linkPresentationModel.f33964Q, parcel, i);
        parcel.writeInt(linkPresentationModel.getScore());
        parcel.writeInt(linkPresentationModel.f33965R);
        parcel.writeLong(linkPresentationModel.f33966S);
        Utils.a(linkPresentationModel.f33967T, parcel, i, StaticAdapters.e);
        parcel.writeInt(linkPresentationModel.f33968U);
        parcel.writeInt(linkPresentationModel.f33969V);
        f20629j.a(linkPresentationModel.f33970W, parcel, i);
        f20629j.a(linkPresentationModel.f33971X, parcel, i);
        parcel.writeInt(linkPresentationModel.f33972Y);
        parcel.writeInt(linkPresentationModel.f33973Z);
        parcel.writeInt(linkPresentationModel.aa);
        parcel.writeInt(linkPresentationModel.ab);
        parcel.writeInt(linkPresentationModel.ac);
        StaticAdapters.x.a(linkPresentationModel.ad, parcel, i);
        StaticAdapters.x.a(linkPresentationModel.ae, parcel, i);
        StaticAdapters.x.a(linkPresentationModel.getDomain(), parcel, i);
        StaticAdapters.x.a(linkPresentationModel.af, parcel, i);
        StaticAdapters.x.a(linkPresentationModel.ag, parcel, i);
        StaticAdapters.x.a(linkPresentationModel.ah, parcel, i);
        StaticAdapters.x.a(linkPresentationModel.ai, parcel, i);
        parcel.writeInt(linkPresentationModel.aj);
        parcel.writeInt(linkPresentationModel.ak);
        f20631l.a(linkPresentationModel.al, parcel, i);
        f20630k.a(linkPresentationModel.am, parcel, i);
        Utils.a(linkPresentationModel.an, parcel, i, StaticAdapters.b);
        parcel.writeInt(linkPresentationModel.ao);
        StaticAdapters.x.a(linkPresentationModel.ap, parcel, i);
        parcel.writeInt(linkPresentationModel.aq);
        parcel.writeInt(linkPresentationModel.ar);
        parcel.writeInt(linkPresentationModel.as);
        f20632m.a(linkPresentationModel.at, parcel, i);
        f20633n.a(linkPresentationModel.au, parcel, i);
        f20634o.a(linkPresentationModel.av, parcel, i);
    }
}
