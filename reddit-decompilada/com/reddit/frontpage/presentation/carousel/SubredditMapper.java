package com.reddit.frontpage.presentation.carousel;

import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.presentation.carousel.model.SubredditCarouselItemPresentationModel;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.Companion;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModelType;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationSection;
import com.reddit.frontpage.presentation.formatter.NumberFormatter;
import com.reddit.frontpage.util.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J0\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J:\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/SubredditMapper;", "", "()V", "CAROUSEL_NUM_VISIBLE_TIME_VALUES", "", "formatStats", "", "numberFormatter", "Lcom/reddit/frontpage/presentation/formatter/NumberFormatter;", "subreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "toCarouselItemPresentationModel", "Lcom/reddit/frontpage/presentation/carousel/model/SubredditCarouselItemPresentationModel;", "item", "color", "hasDescription", "", "hasMetaData", "toCarouselItemPresentationModels", "", "items", "colorGenerator", "Lcom/reddit/frontpage/presentation/carousel/ColorGenerator;", "toPresentationModel", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "type", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModelType;", "section", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationSection;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SubredditMapper.kt */
public final class SubredditMapper {
    public static final SubredditMapper f20341a = new SubredditMapper();

    private SubredditMapper() {
    }

    public static CommunityPresentationModel m22680a(CommunityPresentationModelType communityPresentationModelType, CommunityPresentationSection communityPresentationSection, Subreddit subreddit) {
        CommunityPresentationModelType communityPresentationModelType2 = communityPresentationModelType;
        Intrinsics.m26847b(communityPresentationModelType2, "type");
        CommunityPresentationSection communityPresentationSection2 = communityPresentationSection;
        Intrinsics.m26847b(communityPresentationSection2, "section");
        Intrinsics.m26847b(subreddit, "subreddit");
        String id = subreddit.getId();
        String displayNamePrefixed = subreddit.getDisplayNamePrefixed();
        String displayName = subreddit.getDisplayName();
        String iconImg = subreddit.getIconImg();
        String keyColor = subreddit.getKeyColor();
        Boolean userHasFavorited = subreddit.getUserHasFavorited();
        boolean isUser = subreddit.isUser();
        Companion companion = CommunityPresentationModel.f20468o;
        return new CommunityPresentationModel(id, communityPresentationModelType2, communityPresentationSection2, displayNamePrefixed, displayName, iconImg, keyColor, userHasFavorited, null, null, null, isUser, Companion.m22800a(subreddit.getId(), String.valueOf(communityPresentationSection.ordinal())), subreddit.getOver18(), 1792);
    }

    public static List<SubredditCarouselItemPresentationModel> m22681a(List<Subreddit> list, boolean z, NumberFormatter numberFormatter, ColorGenerator colorGenerator) {
        Intrinsics.m26847b(list, "items");
        Intrinsics.m26847b(numberFormatter, "numberFormatter");
        Intrinsics.m26847b(colorGenerator, "colorGenerator");
        Iterable<Subreddit> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        int i = 0;
        for (Subreddit subreddit : iterable) {
            int i2 = i + 1;
            int a = colorGenerator.mo4784a(i);
            String a2 = numberFormatter.mo4823a(subreddit.getSubscribers());
            if (subreddit.isUser()) {
                a2 = Util.m23960a((int) C1761R.string.fmt_num_karma_simple, a2, numberFormatter.mo4824b(subreddit.getCreatedUtc()));
                Intrinsics.m26843a((Object) a2, "Util.getString(\n        …ALUES\n          )\n      )");
            } else {
                Object a3 = Util.m23960a((int) C1761R.string.fmt_num_subscribers_simple, a2);
                Intrinsics.m26843a(a3, "Util.getString(\n        …   countFormatted\n      )");
            }
            String str = a2;
            Boolean userIsSubscriber = subreddit.getUserIsSubscriber();
            arrayList.add(new SubredditCarouselItemPresentationModel(subreddit, str, a, userIsSubscriber != null ? userIsSubscriber.booleanValue() : false, z, false));
            i = i2;
        }
        return (List) arrayList;
    }
}
