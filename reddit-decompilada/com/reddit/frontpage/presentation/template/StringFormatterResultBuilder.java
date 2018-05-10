package com.reddit.frontpage.presentation.template;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016R\u0012\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/presentation/template/StringFormatterResultBuilder;", "Lcom/reddit/frontpage/presentation/template/TemplateResultBuilder;", "", "()V", "resultBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "append", "", "string", "value", "name", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: StringFormatter.kt */
public final class StringFormatterResultBuilder extends TemplateResultBuilder<String> {
    private final StringBuilder f28807b = new StringBuilder();

    public final /* synthetic */ void mo4930a(Object obj) {
        String str = (String) obj;
        Intrinsics.m26847b(str, "value");
        this.f28807b.append(str);
    }

    public final String m29881a() {
        Object stringBuilder = this.f28807b.toString();
        Intrinsics.m26843a(stringBuilder, "resultBuilder.toString()");
        return stringBuilder;
    }

    public final void mo4931a(String str) {
        Intrinsics.m26847b(str, "string");
        this.f28807b.append(str);
    }
}
