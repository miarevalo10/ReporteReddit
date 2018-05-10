package com.twitter.sdk.android.core.identity;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.instabug.library.model.State;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.User;
import io.fabric.sdk.android.Fabric;

class ShareEmailController {
    final ResultReceiver f23935a;
    private final ShareEmailClient f23936b;

    class C27221 extends Callback<User> {
        final /* synthetic */ ShareEmailController f34638a;

        C27221(ShareEmailController shareEmailController) {
            this.f34638a = shareEmailController;
        }

        public final void mo6518a(Result<User> result) {
            ShareEmailController shareEmailController = this.f34638a;
            User user = (User) result.f23920a;
            if (user.f24105a == null) {
                shareEmailController.m25854a(new TwitterException("Your application may not have access to email addresses or the user may not have an email address. To request access, please visit https://support.twitter.com/forms/platform."));
            } else if ("".equals(user.f24105a)) {
                shareEmailController.m25854a(new TwitterException("This user does not have an email address."));
            } else {
                result = user.f24105a;
                Bundle bundle = new Bundle();
                bundle.putString(State.KEY_EMAIL, result);
                shareEmailController.f23935a.send(-1, bundle);
            }
        }

        public final void mo6519a(TwitterException twitterException) {
            Fabric.m26243b().mo5568c("Twitter", "Failed to get email address.", twitterException);
            this.f34638a.m25854a(new TwitterException("Failed to get email address."));
        }
    }

    public ShareEmailController(ShareEmailClient shareEmailClient, ResultReceiver resultReceiver) {
        this.f23936b = shareEmailClient;
        this.f23935a = resultReceiver;
    }

    public final void m25853a() {
        this.f23936b.m31743a(new C27221(this));
    }

    final void m25854a(TwitterException twitterException) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("error", twitterException);
        this.f23935a.send(1, bundle);
    }

    public final void m25855b() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("msg", "The user chose not to share their email address at this time.");
        this.f23935a.send(0, bundle);
    }
}
