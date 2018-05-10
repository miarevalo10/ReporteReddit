package com.reddit.datalibrary.frontpage.data.feature.comments;

import com.reddit.datalibrary.frontpage.data.feature.common.CommentSortType;
import com.reddit.frontpage.domain.model.CreateEditCommentResponse;
import com.reddit.frontpage.domain.model.Result.Error;
import com.reddit.frontpage.domain.model.Result.Success;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lcom/reddit/frontpage/domain/model/Result;", "Lcom/reddit/frontpage/domain/model/Comment;", "kotlin.jvm.PlatformType", "response", "Lcom/reddit/frontpage/domain/model/CreateEditCommentResponse;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditCommentRepository.kt */
final class RedditCommentRepository$comment$1<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ RedditCommentRepository f15812a;
    final /* synthetic */ CommentSortType f15813b;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "e", "", "test"}, k = 3, mv = {1, 1, 9})
    /* compiled from: RedditCommentRepository.kt */
    static final class C14951<T> implements Predicate<Throwable> {
        public static final C14951 f15811a = new C14951();

        C14951() {
        }

        public final /* synthetic */ boolean test(Object obj) {
            Throwable th = (Throwable) obj;
            Intrinsics.b(th, "e");
            Timber.c(th, "Unable to insert reply to local data source.", new Object[0]);
            return true;
        }
    }

    RedditCommentRepository$comment$1(RedditCommentRepository redditCommentRepository, CommentSortType commentSortType) {
        this.f15812a = redditCommentRepository;
        this.f15813b = commentSortType;
    }

    public final /* synthetic */ Object apply(Object obj) {
        CreateEditCommentResponse createEditCommentResponse = (CreateEditCommentResponse) obj;
        Intrinsics.b(createEditCommentResponse, "response");
        if (createEditCommentResponse.hasErrors()) {
            String firstError = createEditCommentResponse.getFirstError();
            if (firstError == null) {
                Intrinsics.a();
            }
            return Single.just(new Error(firstError, createEditCommentResponse.isTextFirstError()));
        }
        obj = createEditCommentResponse.getComment();
        if (obj == null) {
            Intrinsics.a();
        }
        if (this.f15813b != null) {
            return RedditCommentRepository.m15900a(this.f15812a.f15816c.mo2924a(obj, this.f15813b)).onErrorComplete(C14951.f15811a).andThen(Single.just(new Success(obj)));
        }
        return Single.just(new Success(obj));
    }
}
