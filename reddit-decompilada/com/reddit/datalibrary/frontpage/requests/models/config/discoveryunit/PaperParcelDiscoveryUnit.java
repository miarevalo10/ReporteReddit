package com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit.SurfaceParameters;
import com.reddit.frontpage.ui.carousel.CarouselItemLayout;
import com.reddit.frontpage.ui.carousel.SubheaderIcon;
import java.util.List;
import java.util.Map;
import paperparcel.TypeAdapter;
import paperparcel.internal.EnumAdapter;
import paperparcel.internal.ListAdapter;
import paperparcel.internal.MapAdapter;
import paperparcel.internal.ParcelableAdapter;
import paperparcel.internal.StaticAdapters;
import paperparcel.internal.Utils;

final class PaperParcelDiscoveryUnit {
    static final TypeAdapter<CarouselItemLayout> CAROUSEL_ITEM_LAYOUT_ENUM_ADAPTER = new EnumAdapter(CarouselItemLayout.class);
    static final Creator<DiscoveryUnit> CREATOR = new C09511();
    static final TypeAdapter<SurfaceParameters> DISCOVERY_UNIT__SURFACE_PARAMETERS_PARCELABLE_ADAPTER = new ParcelableAdapter();
    static final TypeAdapter<OrderBy> ORDER_BY_PARCELABLE_ADAPTER = new ParcelableAdapter();
    static final TypeAdapter<List<String>> STRING_LIST_ADAPTER = new ListAdapter(StaticAdapters.x);
    static final TypeAdapter<Map<String, String>> STRING_STRING_MAP_ADAPTER = new MapAdapter(StaticAdapters.x, StaticAdapters.x);
    static final TypeAdapter<SubheaderIcon> SUBHEADER_ICON_ENUM_ADAPTER = new EnumAdapter(SubheaderIcon.class);

    static class C09511 implements Creator<DiscoveryUnit> {
        C09511() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DiscoveryUnit[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            boolean z = parcel.readInt() == 1;
            DiscoveryUnit discoveryUnit = new DiscoveryUnit((String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), parcel.readInt() == 1, parcel.readInt(), (String) StaticAdapters.x.a(parcel2), parcel.readInt(), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (SubheaderIcon) Utils.a(parcel2, PaperParcelDiscoveryUnit.SUBHEADER_ICON_ENUM_ADAPTER), (CarouselItemLayout) PaperParcelDiscoveryUnit.CAROUSEL_ITEM_LAYOUT_ENUM_ADAPTER.a(parcel2), (List) PaperParcelDiscoveryUnit.STRING_LIST_ADAPTER.a(parcel2), (OrderBy) PaperParcelDiscoveryUnit.ORDER_BY_PARCELABLE_ADAPTER.a(parcel2), (Map) Utils.a(parcel2, PaperParcelDiscoveryUnit.STRING_STRING_MAP_ADAPTER), (String) StaticAdapters.x.a(parcel2), parcel.readInt(), (String) StaticAdapters.x.a(parcel2), (SurfaceParameters) PaperParcelDiscoveryUnit.DISCOVERY_UNIT__SURFACE_PARAMETERS_PARCELABLE_ADAPTER.a(parcel2));
            discoveryUnit.m16412a(z);
            return discoveryUnit;
        }
    }

    private PaperParcelDiscoveryUnit() {
    }

    static void writeToParcel(DiscoveryUnit discoveryUnit, Parcel parcel, int i) {
        parcel.writeInt(discoveryUnit.enabled);
        StaticAdapters.x.a(discoveryUnit.unique_id, parcel, i);
        StaticAdapters.x.a(discoveryUnit.unit_type, parcel, i);
        StaticAdapters.x.a(discoveryUnit.surface, parcel, i);
        StaticAdapters.x.a(discoveryUnit.url, parcel, i);
        parcel.writeInt(discoveryUnit.enabled_for_minimum_app_version);
        parcel.writeInt(discoveryUnit.min_app_version);
        StaticAdapters.x.a(discoveryUnit.min_app_version_name, parcel, i);
        parcel.writeInt(discoveryUnit.index);
        StaticAdapters.x.a(discoveryUnit.title, parcel, i);
        StaticAdapters.x.a(discoveryUnit.subtitle, parcel, i);
        Utils.a(discoveryUnit.subtitle_icon, parcel, i, SUBHEADER_ICON_ENUM_ADAPTER);
        CAROUSEL_ITEM_LAYOUT_ENUM_ADAPTER.a(discoveryUnit.layout, parcel, i);
        STRING_LIST_ADAPTER.a(discoveryUnit.options, parcel, i);
        ORDER_BY_PARCELABLE_ADAPTER.a(discoveryUnit.orderBy, parcel, i);
        Utils.a(discoveryUnit.parameters, parcel, i, STRING_STRING_MAP_ADAPTER);
        StaticAdapters.x.a(discoveryUnit.custom_hide_key, parcel, i);
        parcel.writeInt(discoveryUnit.versionCode);
        StaticAdapters.x.a(discoveryUnit.versionName, parcel, i);
        DISCOVERY_UNIT__SURFACE_PARAMETERS_PARCELABLE_ADAPTER.a(discoveryUnit.surface_parameters, parcel, i);
    }
}
