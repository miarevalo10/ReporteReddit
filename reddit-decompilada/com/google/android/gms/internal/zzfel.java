package com.google.android.gms.internal;

public abstract class zzfel<MessageType extends zzfek<MessageType, BuilderType>, BuilderType extends zzfel<MessageType, BuilderType>> implements zzfhf {
    protected abstract BuilderType mo4034a(MessageType messageType);

    public final /* synthetic */ zzfhf mo3501a(zzfhe com_google_android_gms_internal_zzfhe) {
        if (mo4038j().getClass().isInstance(com_google_android_gms_internal_zzfhe)) {
            return mo4034a((zzfek) com_google_android_gms_internal_zzfhe);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    public abstract BuilderType mo4035c();

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return mo4035c();
    }
}
