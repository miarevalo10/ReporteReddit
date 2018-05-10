package com.reddit.datalibrary.frontpage.data.common.converter;

import com.reddit.datalibrary.frontpage.data.model.Envelope;
import com.reddit.datalibrary.frontpage.data.model.ListingEnvelope;
import com.reddit.datalibrary.frontpage.requests.models.v1.Kind;
import com.reddit.frontpage.domain.model.Comment;
import com.reddit.frontpage.domain.model.CommentResponse;
import com.reddit.frontpage.domain.model.IComment;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.model.MoreComment;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Moshi.Builder;
import com.squareup.moshi.ToJson;
import com.squareup.moshi.Types;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J'\u0010\u0018\u001a\u00020\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f0\u001bH\u0000¢\u0006\u0002\b\u001cJ\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0015H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R2\u0010\u0006\u001a&\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b \t*\u0012\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000Rz\u0010\n\u001an\u00120\u0012.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f \t*\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f\u0018\u00010\u000b0\u000b \t*6\u00120\u0012.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f \t*\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f\u0018\u00010\u000b0\u000b\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000RJ\u0010\u000e\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000f \t*\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b0\u000b \t*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000f \t*\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b0\u000b\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R2\u0010\u0010\u001a&\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00110\u0011 \t*\u0012\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00110\u0011\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \t*\u0004\u0018\u00010\u00130\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/converter/CommentResponseAdapter;", "", "()V", "COMMENTS_INDEX", "", "LINK_INDEX", "commentAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/reddit/frontpage/domain/model/Comment;", "kotlin.jvm.PlatformType", "envelopeMapAdapter", "Lcom/reddit/datalibrary/frontpage/data/model/ListingEnvelope;", "", "", "linkAdapter", "Lcom/reddit/frontpage/domain/model/Link;", "moreCommentAdapter", "Lcom/reddit/frontpage/domain/model/MoreComment;", "moshi", "Lcom/squareup/moshi/Moshi;", "fromJson", "Lcom/reddit/frontpage/domain/model/CommentResponse;", "reader", "Lcom/squareup/moshi/JsonReader;", "parseComment", "Lcom/reddit/frontpage/domain/model/IComment;", "envelope", "Lcom/reddit/datalibrary/frontpage/data/model/Envelope;", "parseComment$app_standardRelease", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommentResponseAdapter.kt */
public final class CommentResponseAdapter {
    private static final int COMMENTS_INDEX = 1;
    public static final CommentResponseAdapter INSTANCE = new CommentResponseAdapter();
    private static final int LINK_INDEX = 0;
    private static final JsonAdapter<Comment> commentAdapter = moshi.a(Comment.class);
    private static final JsonAdapter<ListingEnvelope<Map<String, Object>>> envelopeMapAdapter;
    private static final JsonAdapter<ListingEnvelope<Link>> linkAdapter;
    private static final JsonAdapter<MoreComment> moreCommentAdapter = moshi.a(MoreComment.class);
    private static final Moshi moshi;

    @ToJson
    public final void toJson(JsonWriter jsonWriter, CommentResponse commentResponse) {
        Intrinsics.b(jsonWriter, "writer");
    }

    static {
        Moshi a = new Builder().a();
        moshi = a;
        linkAdapter = a.a(Types.a(ListingEnvelope.class, new Type[]{Link.class}));
        a = moshi;
        Type type = ListingEnvelope.class;
        Type[] typeArr = new Type[1];
        typeArr[0] = Types.a(Map.class, new Type[]{String.class, Object.class});
        envelopeMapAdapter = a.a(Types.a(type, typeArr));
    }

    private CommentResponseAdapter() {
    }

    @FromJson
    public final CommentResponse fromJson(JsonReader jsonReader) {
        Intrinsics.b(jsonReader, "reader");
        jsonReader = jsonReader.o();
        if (jsonReader == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<*>");
        }
        List list = (List) jsonReader;
        Object fromJsonValue = linkAdapter.fromJsonValue(list.get(0));
        if (fromJsonValue == null) {
            Intrinsics.a();
        }
        Link link = (Link) ((Envelope) ((ListingEnvelope) fromJsonValue).getData().getChildren().get(0)).getData();
        jsonReader = envelopeMapAdapter.fromJsonValue(list.get(1));
        if (jsonReader == null) {
            Intrinsics.a();
        }
        Iterable<Envelope> children = ((ListingEnvelope) jsonReader).getData().getChildren();
        Collection arrayList = new ArrayList(CollectionsKt.b(children));
        for (Envelope parseComment$app_standardRelease : children) {
            arrayList.add(INSTANCE.parseComment$app_standardRelease(parseComment$app_standardRelease));
        }
        List list2 = (List) arrayList;
        if (link == null) {
            Intrinsics.a();
        }
        return new CommentResponse(link, list2);
    }

    public final IComment parseComment$app_standardRelease(Envelope<? extends Map<String, ? extends Object>> envelope) {
        Intrinsics.b(envelope, "envelope");
        Object data = envelope.getData();
        if (data == null) {
            Intrinsics.a();
        }
        Map map = (Map) data;
        Object fromJsonValue = commentAdapter.fromJsonValue(map);
        if (fromJsonValue == null) {
            Intrinsics.a();
        }
        Comment comment = (Comment) fromJsonValue;
        String kind = envelope.getKind();
        if (kind != null) {
            int hashCode = kind.hashCode();
            if (hashCode != 3645) {
                if (hashCode == 3357525) {
                    if (kind.equals(Kind.MORE)) {
                        data = moreCommentAdapter.fromJsonValue(map);
                        if (data == null) {
                            Intrinsics.a();
                        }
                        return (IComment) data;
                    }
                }
            } else if (kind.equals(Kind.COMMENT)) {
                data = map.get("replies");
                if (data instanceof String) {
                    Intrinsics.a(comment, "result");
                    return comment;
                }
                data = envelopeMapAdapter.fromJsonValue(data);
                if (data == null) {
                    Intrinsics.a();
                }
                Iterable<Envelope> children = ((ListingEnvelope) data).getData().getChildren();
                Collection arrayList = new ArrayList(CollectionsKt.b(children));
                for (Envelope parseComment$app_standardRelease : children) {
                    arrayList.add(INSTANCE.parseComment$app_standardRelease(parseComment$app_standardRelease));
                }
                return Comment.copy$default(comment, null, null, null, null, null, 0, null, null, null, 0, false, null, null, null, false, null, null, null, null, false, null, false, null, null, null, null, null, null, null, 0, (List) arrayList, 1073741823, null);
            }
        }
        throw new RuntimeException("Unsupported link type");
    }
}
