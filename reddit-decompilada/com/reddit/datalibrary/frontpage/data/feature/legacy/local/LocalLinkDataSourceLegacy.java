package com.reddit.datalibrary.frontpage.data.feature.legacy.local;

import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import java.util.List;

public interface LocalLinkDataSourceLegacy {
    Link mo2929a(Link link);

    Link mo2930a(String str);

    List<ClientLink> mo2931a(Listing<? extends Listable> listing);
}
