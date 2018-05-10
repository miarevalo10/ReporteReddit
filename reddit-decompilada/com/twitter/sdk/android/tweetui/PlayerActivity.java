package com.twitter.sdk.android.tweetui;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.twitter.sdk.android.core.internal.scribe.ScribeItem;
import com.twitter.sdk.android.tweetui.PlayerController.C20701;
import com.twitter.sdk.android.tweetui.PlayerController.C20712;
import com.twitter.sdk.android.tweetui.PlayerController.C20723;
import com.twitter.sdk.android.tweetui.PlayerController.C20734;
import com.twitter.sdk.android.tweetui.PlayerController.C20745;
import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener;
import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener.Callback;
import com.twitter.sdk.android.tweetui.internal.VideoView;
import io.fabric.sdk.android.Fabric;
import java.io.Serializable;

public class PlayerActivity extends Activity {
    static final VideoScribeClient f24183a = new VideoScribeClientImpl(TweetUi.m31786a());
    PlayerController f24184b;

    public static class PlayerItem implements Serializable {
        public String f24179a;
        public boolean f24180b;
        public String f24181c;
        public String f24182d;

        public PlayerItem(String str, boolean z) {
            this.f24179a = str;
            this.f24180b = z;
        }

        public PlayerItem(String str, String str2, String str3) {
            this.f24179a = str;
            this.f24180b = true;
            this.f24182d = str2;
            this.f24181c = str3;
        }
    }

    class C25331 implements Callback {
        final /* synthetic */ PlayerActivity f30778a;

        C25331(PlayerActivity playerActivity) {
            this.f30778a = playerActivity;
        }

        public final void mo5493a() {
            this.f30778a.finish();
            this.f30778a.overridePendingTransition(0, C2075R.anim.tw__slide_out);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2075R.layout.tw__player_activity);
        PlayerItem playerItem = (PlayerItem) getIntent().getSerializableExtra("PLAYER_ITEM");
        this.f24184b = new PlayerController(findViewById(16908290), new C25331(this));
        PlayerController playerController = this.f24184b;
        try {
            if (!(playerItem.f24182d == null || playerItem.f24181c == null)) {
                playerController.f24194d.setVisibility(0);
                playerController.f24194d.setText(playerItem.f24182d);
                playerController.f24194d.setOnClickListener(new C20734(playerController, playerItem.f24181c));
                playerController.f24195e.setOnClickListener(new C20745(playerController));
            }
            if (playerItem.f24180b) {
                playerController.f24192b.setVisibility(4);
                playerController.f24191a.setOnClickListener(new C20723(playerController));
            } else {
                playerController.f24191a.setMediaController(playerController.f24192b);
            }
            playerController.f24191a.setOnTouchListener(SwipeToDismissTouchListener.m25964a(playerController.f24191a, playerController.f24198h));
            playerController.f24191a.setOnPreparedListener(new C20701(playerController));
            playerController.f24191a.setOnInfoListener(new C20712(playerController));
            Uri parse = Uri.parse(playerItem.f24179a);
            VideoView videoView = playerController.f24191a;
            bundle = playerItem.f24180b;
            videoView.f30804a = parse;
            videoView.f30809f = bundle;
            videoView.f30808e = 0;
            videoView.m31839d();
            videoView.requestLayout();
            videoView.invalidate();
            playerController.f24191a.requestFocus();
        } catch (Bundle bundle2) {
            Fabric.m26243b().mo5568c("PlayerController", "Error occurred during video playback", bundle2);
        }
        f24183a.mo5508b((ScribeItem) getIntent().getSerializableExtra("SCRIBE_ITEM"));
    }

    protected void onResume() {
        super.onResume();
        PlayerController playerController = this.f24184b;
        if (playerController.f24196f != 0) {
            playerController.f24191a.mo5515a(playerController.f24196f);
        }
        if (playerController.f24197g) {
            playerController.f24191a.mo5514a();
            playerController.f24192b.f24272f.sendEmptyMessage(CredentialsApi.ACTIVITY_RESULT_OTHER_ACCOUNT);
        }
    }

    protected void onPause() {
        PlayerController playerController = this.f24184b;
        playerController.f24197g = playerController.f24191a.mo5517c();
        playerController.f24196f = playerController.f24191a.getCurrentPosition();
        playerController.f24191a.mo5516b();
        super.onPause();
    }

    public void onDestroy() {
        VideoView videoView = this.f24184b.f24191a;
        if (videoView.f30807d != null) {
            videoView.f30807d.stop();
            videoView.f30807d.release();
            videoView.f30807d = null;
            videoView.f30805b = 0;
            videoView.f30806c = 0;
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, C2075R.anim.tw__slide_out);
    }
}
