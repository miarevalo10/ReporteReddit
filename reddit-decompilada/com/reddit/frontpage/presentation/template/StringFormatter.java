package com.reddit.frontpage.presentation.template;

import com.reddit.frontpage.presentation.template.StringFormatterResult.Error;
import com.reddit.frontpage.presentation.template.StringFormatterResult.Success;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005B\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0004H\u0002R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/reddit/frontpage/presentation/template/StringFormatter;", "", "map", "", "", "(Ljava/util/Map;)V", "stringResolver", "Lcom/reddit/frontpage/presentation/template/TemplateResolver;", "(Lcom/reddit/frontpage/presentation/template/TemplateResolver;)V", "parser", "Lcom/reddit/frontpage/presentation/template/TemplateParser;", "getParser", "()Lcom/reddit/frontpage/presentation/template/TemplateParser;", "format", "Lcom/reddit/frontpage/presentation/template/StringFormatterResult;", "text", "formatSuccess", "parse", "Lcom/reddit/frontpage/presentation/template/StringFormatterResultBuilder;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: StringFormatter.kt */
public final class StringFormatter {
    private final TemplateParser<String> f20975a;

    private StringFormatter(TemplateResolver<String> templateResolver) {
        Intrinsics.m26847b(templateResolver, "stringResolver");
        this.f20975a = new TemplateParser(templateResolver);
    }

    public StringFormatter(Map<String, String> map) {
        Intrinsics.m26847b(map, "map");
        this((TemplateResolver) new MapTemplateResolver(map));
    }

    public final String m23202a(String str) {
        Intrinsics.m26847b(str, "text");
        Intrinsics.m26847b(str, "text");
        TemplateResultBuilder stringFormatterResultBuilder = new StringFormatterResultBuilder();
        TemplateParser templateParser = this.f20975a;
        TemplateResultBuilder templateResultBuilder = stringFormatterResultBuilder;
        Intrinsics.m26847b(str, "text");
        Intrinsics.m26847b(templateResultBuilder, "resultBuilder");
        BooleanRef booleanRef = new BooleanRef();
        int i = 0;
        booleanRef.f25288a = false;
        ObjectRef objectRef = new ObjectRef();
        objectRef.f25291a = null;
        StringBuilder stringBuilder = new StringBuilder();
        TemplateParser$parse$1 templateParser$parse$1 = new TemplateParser$parse$1(stringBuilder, objectRef);
        TemplateParser$parse$2 templateParser$parse$2 = new TemplateParser$parse$2(booleanRef, templateResultBuilder, objectRef);
        TemplateParser$parse$3 templateParser$parse$3 = new TemplateParser$parse$3(templateParser, booleanRef, objectRef, templateResultBuilder, templateParser$parse$2);
        int length = str.length();
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == '{') {
                templateParser$parse$1.m37465a();
                templateParser$parse$2.m37466a();
                booleanRef.f25288a = true;
            } else if (charAt != '}') {
                stringBuilder.append(charAt);
            } else {
                templateParser$parse$1.m37465a();
                templateParser$parse$3.m37467a();
            }
            i++;
        }
        templateParser$parse$1.m37465a();
        templateParser$parse$2.m37466a();
        if (stringFormatterResultBuilder.f20978a == null) {
            str = (StringFormatterResult) new Success(stringFormatterResultBuilder.m29881a());
        } else {
            Throwable th = stringFormatterResultBuilder.f20978a;
            if (th == null) {
                Intrinsics.m26842a();
            }
            str = (StringFormatterResult) new Error(th, stringFormatterResultBuilder.m29881a());
        }
        if (str instanceof Success) {
            return ((Success) str).f28806a;
        }
        if ((str instanceof Error) != null) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}
