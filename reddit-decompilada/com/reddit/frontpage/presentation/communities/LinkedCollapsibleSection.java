package com.reddit.frontpage.presentation.communities;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 1*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u00011B5\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ>\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0005H\u0016J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000eH\u0002J)\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00028\u00002\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\u001bH\u0016¢\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020\n2\u0006\u0010#\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u001eH\u0016J\u0015\u0010)\u001a\u00020\"2\u0006\u0010#\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010*J\b\u0010+\u001a\u00020\"H\u0002J\u0010\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u000eH\u0002J)\u0010.\u001a\u00020\"2\u0006\u0010#\u001a\u00028\u00002\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\u001bH\u0002¢\u0006\u0002\u0010%J)\u0010/\u001a\u00020\"2\u0006\u0010#\u001a\u00028\u00002\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\u001bH\u0016¢\u0006\u0002\u0010%J\b\u00100\u001a\u00020\u0019H\u0002R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u00062"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/LinkedCollapsibleSection;", "T", "Lcom/reddit/frontpage/presentation/communities/Section;", "Lcom/reddit/frontpage/presentation/communities/LinkedSection;", "items", "", "previousSection", "section", "Lcom/reddit/frontpage/presentation/communities/CollapseSection;", "initiallyCollapsed", "", "(Ljava/util/List;Lcom/reddit/frontpage/presentation/communities/LinkedSection;Lcom/reddit/frontpage/presentation/communities/CollapseSection;Z)V", "collapsed", "linkedSize", "", "getLinkedSize", "()I", "previousSectionLinkedSize", "getPreviousSectionLinkedSize", "getSection", "()Lcom/reddit/frontpage/presentation/communities/CollapseSection;", "visibleItems", "getVisibleItems", "()Ljava/util/List;", "changeAll", "", "predicate", "Lkotlin/Function1;", "action", "positionsChanged", "Lcom/reddit/frontpage/presentation/communities/SectionChangeSet;", "convertRelativePositionToAbsolute", "position", "insert", "Lcom/reddit/frontpage/presentation/communities/RangeChange;", "item", "comparison", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lcom/reddit/frontpage/presentation/communities/RangeChange;", "isSectionItem", "(Ljava/lang/Object;)Z", "onSectionClicked", "processInvalidListInsertion", "(Ljava/lang/Object;)Lcom/reddit/frontpage/presentation/communities/RangeChange;", "processRemovalCreatesInvalidList", "processRemovalMaintainsValidList", "startPosition", "processValidListInsertion", "remove", "setSectionState", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkedCollapsibleSection.kt */
public final class LinkedCollapsibleSection<T> implements LinkedSection, Section<T> {
    public static final Companion f28131a = new Companion();
    private boolean f28132b;
    private final List<T> f28133c;
    private final LinkedSection f28134d;
    private final CollapseSection<T> f28135e;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/LinkedCollapsibleSection$Companion;", "", "()V", "COLLAPSED_LIST_SIZE", "", "DEFAULT_COLLAPSED_STATE", "", "DEFAULT_PREVIOUS_LINKED_SIZE", "LIST_MODIFICATION_START_INDEX", "MIN_VALID_LIST_SIZE", "NUM_ITEMS_REMOVED_FROM_COLLAPSED", "SECTION_ITEM_POSITION", "VALID_LIST_POSITION", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkedCollapsibleSection.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public LinkedCollapsibleSection(List<T> list, LinkedSection linkedSection, CollapseSection<? extends T> collapseSection, boolean z) {
        Intrinsics.m26847b(list, "items");
        Intrinsics.m26847b(collapseSection, "section");
        this.f28133c = list;
        this.f28134d = linkedSection;
        this.f28135e = collapseSection;
        this.f28132b = z;
        if ((this.f28133c.isEmpty() ^ 1) != null) {
            this.f28133c.add(null, this.f28135e.mo6450a());
            m29484d();
        }
    }

    public final List<T> mo4809b() {
        if (this.f28133c.size() < 2) {
            return new ArrayList();
        }
        if (this.f28132b) {
            return CollectionsKt___CollectionsKt.m41428c(this.f28133c.subList(0, 1));
        }
        return CollectionsKt___CollectionsKt.m41428c(this.f28133c);
    }

    public final boolean mo4807a(T t) {
        if (!Intrinsics.m26845a((Object) t, this.f28135e.mo6450a())) {
            if (Intrinsics.m26845a((Object) t, this.f28135e.mo6451b()) == null) {
                return null;
            }
        }
        return true;
    }

    public final RangeChange mo4805a(T t, Function1<? super T, Integer> function1) {
        Intrinsics.m26847b(function1, "comparison");
        if (this.f28133c.size() < 2) {
            function1 = this.f28133c;
            function1.add(this.f28135e.mo6450a());
            function1.add(t);
            return new RangeChange(RangeChangeType.f20462b, 0 + m29485e(), 2);
        }
        function1 = CollectionsKt__CollectionsKt.m26788a(this.f28133c, (Function1) function1);
        if (function1 < null) {
            function1 = Math.abs(function1) - 1;
            this.f28133c.add(function1, t);
            if (this.f28132b == null) {
                return new RangeChange(RangeChangeType.f20462b, function1 + m29485e(), 1);
            }
            t = RangeChange.f20456a;
            return com.reddit.frontpage.presentation.communities.RangeChange.Companion.m22792a();
        }
        StringBuilder stringBuilder = new StringBuilder("Item already exists in list at position ");
        stringBuilder.append(function1);
        throw ((Throwable) new RuntimeException(stringBuilder.toString()));
    }

    public final RangeChange mo4808b(T t, Function1<? super T, Integer> function1) {
        Intrinsics.m26847b(function1, "comparison");
        t = CollectionsKt__CollectionsKt.m26788a((List) this.f28133c, (Function1) function1);
        if (t < null) {
            throw ((Throwable) new RuntimeException("Item not found"));
        }
        this.f28133c.remove(t);
        int i = 1;
        if (this.f28133c.size() < 2) {
            if (this.f28132b == null) {
                i = 2;
            }
            this.f28132b = false;
            this.f28133c.clear();
            return new RangeChange(RangeChangeType.f20463c, null + m29485e(), i);
        } else if (this.f28132b == null) {
            return new RangeChange(RangeChangeType.f20463c, t + m29485e(), 1);
        } else {
            t = RangeChange.f20456a;
            return com.reddit.frontpage.presentation.communities.RangeChange.Companion.m22792a();
        }
    }

    public final SectionChangeSet mo4810c() {
        this.f28132b ^= 1;
        m29484d();
        int e = m29485e();
        return new SectionChangeSet(Integer.valueOf(e), new RangeChange(this.f28132b ? RangeChangeType.f20463c : RangeChangeType.f20462b, e + 1, this.f28133c.size() - 1));
    }

    public final void mo4806a(Function1<? super T, Boolean> function1, Function1<? super T, ? extends T> function12, List<SectionChangeSet> list) {
        Intrinsics.m26847b(function1, "predicate");
        Intrinsics.m26847b(function12, "action");
        Intrinsics.m26847b(list, "positionsChanged");
        list = CollectionsKt__CollectionsKt.m26787a((List) this.f28133c);
        if (list >= null) {
            int i = 0;
            while (true) {
                if (((Boolean) function1.mo6492a(this.f28133c.get(i))).booleanValue()) {
                    this.f28133c.set(i, function12.mo6492a(this.f28133c.get(i)));
                }
                if (i != list) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final int mo4804a() {
        int size = this.f28132b ? 1 : this.f28133c.size();
        LinkedSection linkedSection = this.f28134d;
        return size + (linkedSection != null ? linkedSection.mo4804a() : 0);
    }

    private final void m29484d() {
        Object b;
        List list = this.f28133c;
        if (this.f28132b) {
            b = this.f28135e.mo6451b();
        } else {
            b = this.f28135e.mo6450a();
        }
        list.set(0, b);
    }

    private final int m29485e() {
        LinkedSection linkedSection = this.f28134d;
        return linkedSection != null ? linkedSection.mo4804a() : 0;
    }
}
