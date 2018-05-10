package com.reddit.frontpage.presentation.modtools.util;

import com.reddit.frontpage.C1761R;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00048'X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/util/ModToolsAction;", "", "(Ljava/lang/String;I)V", "iconRes", "", "getIconRes", "()I", "stringRes", "getStringRes", "setStringRes", "(I)V", "ModQueue", "ModMail", "BannedUsers", "MutedUsers", "ApprovedSubmitters", "Moderators", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModToolsAction.kt */
public enum ModToolsAction {
    ;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/util/ModToolsAction$ApprovedSubmitters;", "Lcom/reddit/frontpage/presentation/modtools/util/ModToolsAction;", "(Ljava/lang/String;I)V", "iconRes", "", "getIconRes", "()I", "stringRes", "getStringRes", "setStringRes", "(I)V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ModToolsAction.kt */
    static final class ApprovedSubmitters extends ModToolsAction {
        private final int f28693g;
        private int f28694h;

        ApprovedSubmitters(String str) {
            super(str, 4);
            this.f28693g = C1761R.drawable.ic_approved_submitters;
            this.f28694h = C1761R.string.mod_tools_approved_submitters;
        }

        public final int mo4914b() {
            return this.f28693g;
        }

        public final int mo4912a() {
            return this.f28694h;
        }

        public final void mo4913a(int i) {
            this.f28694h = i;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/util/ModToolsAction$BannedUsers;", "Lcom/reddit/frontpage/presentation/modtools/util/ModToolsAction;", "(Ljava/lang/String;I)V", "iconRes", "", "getIconRes", "()I", "stringRes", "getStringRes", "setStringRes", "(I)V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ModToolsAction.kt */
    static final class BannedUsers extends ModToolsAction {
        private final int f28695g;
        private int f28696h;

        BannedUsers(String str) {
            super(str, 2);
            this.f28695g = C1761R.drawable.ic_icon_ban;
            this.f28696h = C1761R.string.mod_tools_ban_users;
        }

        public final int mo4914b() {
            return this.f28695g;
        }

        public final int mo4912a() {
            return this.f28696h;
        }

        public final void mo4913a(int i) {
            this.f28696h = i;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/util/ModToolsAction$ModMail;", "Lcom/reddit/frontpage/presentation/modtools/util/ModToolsAction;", "(Ljava/lang/String;I)V", "iconRes", "", "getIconRes", "()I", "stringRes", "getStringRes", "setStringRes", "(I)V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ModToolsAction.kt */
    static final class ModMail extends ModToolsAction {
        private final int f28697g;
        private int f28698h;

        ModMail(String str) {
            super(str, 1);
            this.f28697g = C1761R.drawable.ic_icon_message;
            this.f28698h = C1761R.string.mod_tools_mod_mail;
        }

        public final int mo4914b() {
            return this.f28697g;
        }

        public final int mo4912a() {
            return this.f28698h;
        }

        public final void mo4913a(int i) {
            this.f28698h = i;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/util/ModToolsAction$ModQueue;", "Lcom/reddit/frontpage/presentation/modtools/util/ModToolsAction;", "(Ljava/lang/String;I)V", "iconRes", "", "getIconRes", "()I", "stringRes", "getStringRes", "setStringRes", "(I)V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ModToolsAction.kt */
    static final class ModQueue extends ModToolsAction {
        private final int f28699g;
        private int f28700h;

        ModQueue(String str) {
            super(str, 0);
            this.f28699g = C1761R.drawable.ic_icon_mod_queue;
            this.f28700h = C1761R.string.mod_tools_mod_queue;
        }

        public final int mo4914b() {
            return this.f28699g;
        }

        public final int mo4912a() {
            return this.f28700h;
        }

        public final void mo4913a(int i) {
            this.f28700h = i;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/util/ModToolsAction$Moderators;", "Lcom/reddit/frontpage/presentation/modtools/util/ModToolsAction;", "(Ljava/lang/String;I)V", "iconRes", "", "getIconRes", "()I", "stringRes", "getStringRes", "setStringRes", "(I)V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ModToolsAction.kt */
    static final class Moderators extends ModToolsAction {
        private final int f28701g;
        private int f28702h;

        Moderators(String str) {
            super(str, 5);
            this.f28701g = C1761R.drawable.ic_icon_distinguish;
            this.f28702h = C1761R.string.mod_tools_moderator_list;
        }

        public final int mo4914b() {
            return this.f28701g;
        }

        public final int mo4912a() {
            return this.f28702h;
        }

        public final void mo4913a(int i) {
            this.f28702h = i;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/util/ModToolsAction$MutedUsers;", "Lcom/reddit/frontpage/presentation/modtools/util/ModToolsAction;", "(Ljava/lang/String;I)V", "iconRes", "", "getIconRes", "()I", "stringRes", "getStringRes", "setStringRes", "(I)V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ModToolsAction.kt */
    static final class MutedUsers extends ModToolsAction {
        private final int f28703g;
        private int f28704h;

        MutedUsers(String str) {
            super(str, 3);
            this.f28703g = C1761R.drawable.ic_mute;
            this.f28704h = C1761R.string.mod_tools_mute_users;
        }

        public final int mo4914b() {
            return this.f28703g;
        }

        public final int mo4912a() {
            return this.f28704h;
        }

        public final void mo4913a(int i) {
            this.f28704h = i;
        }
    }

    public abstract int mo4912a();

    public abstract void mo4913a(int i);

    public abstract int mo4914b();
}
