package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010&\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\"\u0010\u0002\u001a\u001e\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00010\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "entry", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditLinkRepository.kt */
final class RedditLinkRepository$LinkListingPersister$keyToString$params$1 extends Lambda implements Function1<Entry<? extends String, ? extends String>, String> {
    public static final RedditLinkRepository$LinkListingPersister$keyToString$params$1 f19406a = new RedditLinkRepository$LinkListingPersister$keyToString$params$1();

    RedditLinkRepository$LinkListingPersister$keyToString$params$1() {
        super(1);
    }

    public final /* synthetic */ Object m20628a(Object obj) {
        Entry entry = (Entry) obj;
        Intrinsics.b(entry, "entry");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String) entry.getKey());
        stringBuilder.append('=');
        stringBuilder.append((String) entry.getValue());
        return stringBuilder.toString();
    }
}
