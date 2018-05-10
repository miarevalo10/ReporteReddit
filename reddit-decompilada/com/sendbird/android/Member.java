package com.sendbird.android;

import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonNull;

public class Member extends User {
    boolean f30104a;
    boolean f30105b;
    private InvitationState f30106f;

    public enum InvitationState {
        INVITED,
        JOINED
    }

    protected Member(JsonElement jsonElement) {
        super(jsonElement);
        if (!(jsonElement instanceof JsonNull)) {
            jsonElement = jsonElement.m25073h();
            InvitationState invitationState = (jsonElement.m31129a("state") && jsonElement.m31130b("state").mo5244c().equals("invited")) ? InvitationState.INVITED : InvitationState.JOINED;
            this.f30106f = invitationState;
            boolean z = false;
            boolean z2 = jsonElement.m31129a("is_blocking_me") && jsonElement.m31130b("is_blocking_me").mo5248g();
            this.f30104a = z2;
            if (jsonElement.m31129a("is_blocked_by_me") && jsonElement.m31130b("is_blocked_by_me").mo5248g() != null) {
                z = true;
            }
            this.f30105b = z;
        }
    }

    final JsonElement mo5219a() {
        JsonElement h = super.mo5219a().m25073h();
        if (this.f30106f == InvitationState.INVITED) {
            h.m31128a("state", "invited");
        } else {
            h.m31128a("state", "joined");
        }
        h.m31126a("is_blocking_me", Boolean.valueOf(this.f30104a));
        h.m31126a("is_blocked_by_me", Boolean.valueOf(this.f30105b));
        return h;
    }

    public final InvitationState m30994b() {
        return this.f30106f;
    }

    public final boolean m30995c() {
        return this.f30105b;
    }
}
