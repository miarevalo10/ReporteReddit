package com.reddit.frontpage.presentation.communities;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J>\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004H&J)\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u00002\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130\nH&¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u000eH&J)\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u00002\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130\nH&¢\u0006\u0002\u0010\u0014R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/Section;", "T", "", "visibleItems", "", "getVisibleItems", "()Ljava/util/List;", "changeAll", "", "predicate", "Lkotlin/Function1;", "", "action", "positionsChanged", "Lcom/reddit/frontpage/presentation/communities/SectionChangeSet;", "insert", "Lcom/reddit/frontpage/presentation/communities/RangeChange;", "item", "comparison", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lcom/reddit/frontpage/presentation/communities/RangeChange;", "isSectionItem", "(Ljava/lang/Object;)Z", "onSectionClicked", "remove", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Section.kt */
public interface Section<T> {
    RangeChange mo4805a(T t, Function1<? super T, Integer> function1);

    void mo4806a(Function1<? super T, Boolean> function1, Function1<? super T, ? extends T> function12, List<SectionChangeSet> list);

    boolean mo4807a(T t);

    RangeChange mo4808b(T t, Function1<? super T, Integer> function1);

    List<T> mo4809b();

    SectionChangeSet mo4810c();
}
