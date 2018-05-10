package com.reddit.datalibrary.frontpage.data.common.converter;

import com.reddit.datalibrary.frontpage.data.model.ChildrenEnvelope;
import com.reddit.datalibrary.frontpage.data.model.Envelope;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.datalibrary.frontpage.data.model.ListingEnvelope;
import com.reddit.datalibrary.frontpage.data.model.RecommendedCategory;
import com.reddit.datalibrary.frontpage.data.model.RecommendedCategoryEnvelope;
import com.reddit.frontpage.domain.model.Subreddit;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonAdapter.Factory;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0015\b\u0002\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/converter/RecommendedCategoryJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "", "delegate", "Lcom/reddit/datalibrary/frontpage/data/model/RecommendedCategoryEnvelope;", "(Lcom/squareup/moshi/JsonAdapter;)V", "fromJson", "Lcom/reddit/datalibrary/frontpage/data/model/RecommendedCategory;", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RecommendedCategoryJsonAdapter.kt */
public final class RecommendedCategoryJsonAdapter extends JsonAdapter<Object> {
    public static final Companion Companion = new Companion();
    private static final Factory FACTORY = new RecommendedCategoryJsonAdapter$Companion$FACTORY$1();
    private final JsonAdapter<RecommendedCategoryEnvelope> delegate;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/converter/RecommendedCategoryJsonAdapter$Companion;", "", "()V", "FACTORY", "Lcom/squareup/moshi/JsonAdapter$Factory;", "getFACTORY", "()Lcom/squareup/moshi/JsonAdapter$Factory;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RecommendedCategoryJsonAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Factory getFACTORY() {
            return RecommendedCategoryJsonAdapter.FACTORY;
        }
    }

    private RecommendedCategoryJsonAdapter(JsonAdapter<RecommendedCategoryEnvelope> jsonAdapter) {
        this.delegate = jsonAdapter;
    }

    public final RecommendedCategory fromJson(JsonReader jsonReader) {
        Intrinsics.b(jsonReader, "reader");
        RecommendedCategoryEnvelope recommendedCategoryEnvelope = (RecommendedCategoryEnvelope) this.delegate.fromJson(jsonReader);
        if (recommendedCategoryEnvelope == null) {
            return null;
        }
        String icon = recommendedCategoryEnvelope.getIcon();
        String color = recommendedCategoryEnvelope.getColor();
        jsonReader = recommendedCategoryEnvelope.getSubreddits().getData();
        Collection arrayList = new ArrayList();
        for (Envelope data : jsonReader.getChildren()) {
            Subreddit subreddit = (Subreddit) data.getData();
            if (subreddit != null) {
                arrayList.add(subreddit);
            }
        }
        return new RecommendedCategory(icon, color, new Listing((List) arrayList, jsonReader.getAfter(), jsonReader.getBefore(), null, 8, null));
    }

    public final void toJson(JsonWriter jsonWriter, Object obj) {
        Intrinsics.b(jsonWriter, "writer");
        if ((obj instanceof RecommendedCategory) == null) {
            obj = null;
        }
        RecommendedCategory recommendedCategory = (RecommendedCategory) obj;
        if (recommendedCategory != null) {
            Iterable<Subreddit> children = recommendedCategory.getSubreddits().getChildren();
            Collection arrayList = new ArrayList(CollectionsKt.b(children));
            for (Subreddit envelope : children) {
                arrayList.add(new Envelope(envelope, null, 2, null));
            }
            this.delegate.toJson(new RecommendedCategoryEnvelope(recommendedCategory.getIcon(), recommendedCategory.getColor(), new ListingEnvelope(new ChildrenEnvelope((List) arrayList, null, null, null))));
        }
    }
}
