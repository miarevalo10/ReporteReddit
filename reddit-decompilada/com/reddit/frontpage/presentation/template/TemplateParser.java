package com.reddit.frontpage.presentation.template;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0001\fB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/presentation/template/TemplateParser;", "T", "", "resolver", "Lcom/reddit/frontpage/presentation/template/TemplateResolver;", "(Lcom/reddit/frontpage/presentation/template/TemplateResolver;)V", "parse", "", "text", "", "resultBuilder", "Lcom/reddit/frontpage/presentation/template/TemplateResultBuilder;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: TemplateParser.kt */
public final class TemplateParser<T> {
    public static final Companion f20976a = new Companion();
    private final TemplateResolver<T> f20977b;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/presentation/template/TemplateParser$Companion;", "", "()V", "BEGIN_MARKER", "", "BEGIN_MARKER_STRING", "", "END_MARKER", "END_MARKER_STRING", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: TemplateParser.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public TemplateParser(TemplateResolver<? extends T> templateResolver) {
        Intrinsics.m26847b(templateResolver, "resolver");
        this.f20977b = templateResolver;
    }
}
