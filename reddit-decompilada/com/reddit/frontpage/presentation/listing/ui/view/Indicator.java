package com.reddit.frontpage.presentation.listing.ui.view;

import com.reddit.frontpage.C1761R;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/Indicator;", "", "(Ljava/lang/String;I)V", "iconRes", "", "getIconRes", "()I", "id", "", "getId", "()Ljava/lang/String;", "AdminDistinguish", "ModDistinguish", "Self", "Author", "Cakeday", "Gilded", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UserIndicatorsView.kt */
public enum Indicator {
    ;
    
    final String f20739g;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/Indicator$AdminDistinguish;", "Lcom/reddit/frontpage/presentation/listing/ui/view/Indicator;", "(Ljava/lang/String;I)V", "iconRes", "", "getIconRes", "()I", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: UserIndicatorsView.kt */
    static final class AdminDistinguish extends Indicator {
        private final int f28471h;

        AdminDistinguish(String str) {
            super(str, 0);
            this.f28471h = C1761R.drawable.ind_admin;
        }

        public final int mo4892a() {
            return this.f28471h;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/Indicator$Author;", "Lcom/reddit/frontpage/presentation/listing/ui/view/Indicator;", "(Ljava/lang/String;I)V", "iconRes", "", "getIconRes", "()I", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: UserIndicatorsView.kt */
    static final class Author extends Indicator {
        private final int f28472h;

        Author(String str) {
            super(str, 3);
            this.f28472h = C1761R.drawable.ind_op;
        }

        public final int mo4892a() {
            return this.f28472h;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/Indicator$Cakeday;", "Lcom/reddit/frontpage/presentation/listing/ui/view/Indicator;", "(Ljava/lang/String;I)V", "iconRes", "", "getIconRes", "()I", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: UserIndicatorsView.kt */
    static final class Cakeday extends Indicator {
        private final int f28473h;

        Cakeday(String str) {
            super(str, 4);
            this.f28473h = C1761R.drawable.ind_user_cakeday;
        }

        public final int mo4892a() {
            return this.f28473h;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/Indicator$Gilded;", "Lcom/reddit/frontpage/presentation/listing/ui/view/Indicator;", "(Ljava/lang/String;I)V", "iconRes", "", "getIconRes", "()I", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: UserIndicatorsView.kt */
    static final class Gilded extends Indicator {
        private final int f28474h;

        Gilded(String str) {
            super(str, 5);
            this.f28474h = C1761R.drawable.ind_gilded;
        }

        public final int mo4892a() {
            return this.f28474h;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/Indicator$ModDistinguish;", "Lcom/reddit/frontpage/presentation/listing/ui/view/Indicator;", "(Ljava/lang/String;I)V", "iconRes", "", "getIconRes", "()I", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: UserIndicatorsView.kt */
    static final class ModDistinguish extends Indicator {
        private final int f28475h;

        ModDistinguish(String str) {
            super(str, 1);
            this.f28475h = C1761R.drawable.ind_moderator;
        }

        public final int mo4892a() {
            return this.f28475h;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/Indicator$Self;", "Lcom/reddit/frontpage/presentation/listing/ui/view/Indicator;", "(Ljava/lang/String;I)V", "iconRes", "", "getIconRes", "()I", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: UserIndicatorsView.kt */
    static final class Self extends Indicator {
        private final int f28476h;

        Self(String str) {
            super(str, 2);
            this.f28476h = C1761R.drawable.ind_user_self;
        }

        public final int mo4892a() {
            return this.f28476h;
        }
    }

    public abstract int mo4892a();
}
