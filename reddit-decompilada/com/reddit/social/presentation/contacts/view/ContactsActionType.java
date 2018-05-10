package com.reddit.social.presentation.contacts.view;

import com.reddit.social.presentation.presentationobjects.ContactData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/social/presentation/contacts/view/ContactsActionType;", "", "()V", "ADD", "CREATE", "Lcom/reddit/social/presentation/contacts/view/ContactsActionType$CREATE;", "Lcom/reddit/social/presentation/contacts/view/ContactsActionType$ADD;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ContactsScreen.kt */
public abstract class ContactsActionType {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/reddit/social/presentation/contacts/view/ContactsActionType$ADD;", "Lcom/reddit/social/presentation/contacts/view/ContactsActionType;", "channelUrl", "", "(Ljava/lang/String;)V", "getChannelUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ContactsScreen.kt */
    public static final class ADD extends ContactsActionType {
        public final String f29726a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof ADD) {
                    if (Intrinsics.m26845a(this.f29726a, ((ADD) obj).f29726a)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f29726a;
            return str != null ? str.hashCode() : 0;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("ADD(channelUrl=");
            stringBuilder.append(this.f29726a);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public ADD(String str) {
            Intrinsics.m26847b(str, "channelUrl");
            super();
            this.f29726a = str;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/reddit/social/presentation/contacts/view/ContactsActionType$CREATE;", "Lcom/reddit/social/presentation/contacts/view/ContactsActionType;", "defaultSelectedContact", "Lcom/reddit/social/presentation/presentationobjects/ContactData;", "(Lcom/reddit/social/presentation/presentationobjects/ContactData;)V", "getDefaultSelectedContact", "()Lcom/reddit/social/presentation/presentationobjects/ContactData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ContactsScreen.kt */
    public static final class CREATE extends ContactsActionType {
        public final ContactData f29727a;

        public CREATE(byte b) {
            this();
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof CREATE) {
                    if (Intrinsics.m26845a(this.f29727a, ((CREATE) obj).f29727a)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            ContactData contactData = this.f29727a;
            return contactData != null ? contactData.hashCode() : 0;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("CREATE(defaultSelectedContact=");
            stringBuilder.append(this.f29727a);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        private /* synthetic */ CREATE() {
            this(null);
        }

        public CREATE(ContactData contactData) {
            super();
            this.f29727a = contactData;
        }
    }

    private ContactsActionType() {
    }
}
