package com.reddit.frontpage.widgets;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/widgets/ListingFooterState;", "", "()V", "Error", "Hidden", "Loading", "Lcom/reddit/frontpage/widgets/ListingFooterState$Error;", "Lcom/reddit/frontpage/widgets/ListingFooterState$Loading;", "Lcom/reddit/frontpage/widgets/ListingFooterState$Hidden;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ListingFooterState.kt */
public abstract class ListingFooterState {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/widgets/ListingFooterState$Error;", "Lcom/reddit/frontpage/widgets/ListingFooterState;", "messageRes", "", "(I)V", "getMessageRes", "()I", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ListingFooterState.kt */
    public static final class Error extends ListingFooterState {
        public final int f29473a;

        public Error(int i) {
            super();
            this.f29473a = i;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/reddit/frontpage/widgets/ListingFooterState$Hidden;", "Lcom/reddit/frontpage/widgets/ListingFooterState;", "()V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ListingFooterState.kt */
    public static final class Hidden extends ListingFooterState {
        public static final Hidden f29474a = new Hidden();

        private Hidden() {
            super();
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/reddit/frontpage/widgets/ListingFooterState$Loading;", "Lcom/reddit/frontpage/widgets/ListingFooterState;", "()V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ListingFooterState.kt */
    public static final class Loading extends ListingFooterState {
        public static final Loading f29475a = new Loading();

        private Loading() {
            super();
        }
    }

    private ListingFooterState() {
    }
}
