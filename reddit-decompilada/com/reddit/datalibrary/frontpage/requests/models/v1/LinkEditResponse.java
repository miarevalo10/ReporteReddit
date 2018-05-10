package com.reddit.datalibrary.frontpage.requests.models.v1;

import java.util.List;

public class LinkEditResponse extends GenericResponse<LinkEditList> {

    public class LinkEditList {
        public final List<LinkWrapper> things;
        final /* synthetic */ LinkEditResponse this$0;
    }
}
