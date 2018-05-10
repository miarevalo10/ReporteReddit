package com.reddit.social.presentation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.anko.sdk21.listeners.__TextWatcher;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lorg/jetbrains/anko/sdk21/listeners/__TextWatcher;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: EditTextWithCounter.kt */
final class EditTextWithCounter$init$1 extends Lambda implements Function1<__TextWatcher, Unit> {
    final /* synthetic */ EditTextWithCounter f37504a;

    EditTextWithCounter$init$1(EditTextWithCounter editTextWithCounter) {
        this.f37504a = editTextWithCounter;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        __TextWatcher org_jetbrains_anko_sdk21_listeners___TextWatcher = (__TextWatcher) obj;
        Intrinsics.m26847b(org_jetbrains_anko_sdk21_listeners___TextWatcher, "$receiver");
        org_jetbrains_anko_sdk21_listeners___TextWatcher.m28426a(new Function4<CharSequence, Integer, Integer, Integer, Unit>() {
            public final /* synthetic */ Object mo6942a(Object obj, Object obj2, Object obj3, Object obj4) {
                CharSequence charSequence = (CharSequence) obj;
                ((Number) obj2).intValue();
                ((Number) obj3).intValue();
                ((Number) obj4).intValue();
                if (charSequence != null) {
                    this.f37504a.getCharCounter().setText(Integer.toString(this.f37504a.f22312b - charSequence.length()));
                }
                return Unit.f25273a;
            }
        });
        return Unit.f25273a;
    }
}
