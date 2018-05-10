package com.reddit.social.presentation.chatrequests.presentation;

import com.reddit.social.presentation.chatinbox.ChatInboxItem;
import com.reddit.social.presentation.chatrequests.ChatRequestListContract.View;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u001d\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "p1", "", "Lcom/reddit/social/presentation/chatinbox/ChatInboxItem;", "Lkotlin/ParameterName;", "name", "chatRequests", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRequestListPresenter.kt */
final class ChatRequestListPresenter$loadChatRequestListItems$4 extends FunctionReference implements Function1<List<? extends ChatInboxItem>, Unit> {
    ChatRequestListPresenter$loadChatRequestListItems$4(View view) {
        super(1, view);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(View.class);
    }

    public final String mo5687b() {
        return "showChatRequests";
    }

    public final String mo6932c() {
        return "showChatRequests(Ljava/util/List;)V";
    }

    public final /* bridge */ /* synthetic */ Object mo6492a(Object obj) {
        ((View) this.b).mo7502a((List) obj);
        return Unit.f25273a;
    }
}
