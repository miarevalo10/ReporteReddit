package android.support.v4.app;

import android.app.RemoteInput.Builder;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import java.util.Set;

public final class RemoteInput extends android.support.v4.app.RemoteInputCompatBase.RemoteInput {
    final String f11398a;
    final CharSequence f11399b;
    final CharSequence[] f11400c;
    final boolean f11401d;
    final Bundle f11402e;
    final Set<String> f11403f;

    @RequiresApi(20)
    static android.app.RemoteInput[] m10003a(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        android.app.RemoteInput[] remoteInputArr2 = new android.app.RemoteInput[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            RemoteInput remoteInput = remoteInputArr[i];
            remoteInputArr2[i] = new Builder(remoteInput.f11398a).setLabel(remoteInput.f11399b).setChoices(remoteInput.f11400c).setAllowFreeFormInput(remoteInput.f11401d).addExtras(remoteInput.f11402e).build();
        }
        return remoteInputArr2;
    }
}
