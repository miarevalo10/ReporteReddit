package com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: DiscoveryUnit.kt */
final class DiscoveryUnit$convertVersionNameToValue$1 extends Lambda implements Function0<String> {
    final /* synthetic */ String $versionName;

    DiscoveryUnit$convertVersionNameToValue$1(String str) {
        this.$versionName = str;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        StringBuilder stringBuilder = new StringBuilder("The version name ");
        stringBuilder.append(this.$versionName);
        stringBuilder.append(" is invalid");
        return stringBuilder.toString();
    }
}
