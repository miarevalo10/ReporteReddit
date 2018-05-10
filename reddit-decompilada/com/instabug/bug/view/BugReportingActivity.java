package com.instabug.bug.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.instabug.bug.BugPlugin;
import com.instabug.bug.C0465R;
import com.instabug.bug.C0470c;
import com.instabug.bug.C0474d;
import com.instabug.bug.OnSdkDismissedCallback.DismissType;
import com.instabug.bug.model.C0478b;
import com.instabug.bug.settings.C0485a;
import com.instabug.bug.view.C0506b.C1281b;
import com.instabug.bug.view.C1730c.C0510a;
import com.instabug.bug.view.p002a.C1728b;
import com.instabug.bug.view.p002a.C1728b.C0497a;
import com.instabug.library.FragmentVisibilityChangedListener;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugCustomTextPlaceHolder.Key;
import com.instabug.library.InstabugState;
import com.instabug.library._InstabugActivity;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.VideoProcessingServiceEventBus;
import com.instabug.library.core.ui.BaseFragmentActivity;
import com.instabug.library.internal.storage.cache.Cache;
import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.internal.video.VideoProcessingService.Action;
import com.instabug.library.model.Attachment.Type;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.OrientationUtils;
import com.instabug.library.util.PlaceHolderUtils;
import java.util.ArrayList;
import java.util.Collection;

public class BugReportingActivity extends BaseFragmentActivity<C1631f> implements OnBackStackChangedListener, OnClickListener, C0497a, C1281b, C0510a, _InstabugActivity {
    private static int m21601b(int i) {
        return i != 161 ? i != 167 ? i != 169 ? 162 : 169 : 167 : 161;
    }

    protected void initViews() {
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.presenter = new C1631f(this);
        ((C1631f) this.presenter).m19400a(m21601b(intent.getIntExtra("com.instabug.library.process", 162)));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        OrientationUtils.handelOrientation(this);
        getSupportFragmentManager().mo221a((OnBackStackChangedListener) this);
        this.presenter = new C1631f(this);
        int intExtra = getIntent().getIntExtra("com.instabug.library.process", 162);
        if (bundle == null) {
            ((C1631f) this.presenter).m19400a(m21601b(intExtra));
        }
    }

    public void onStart() {
        super.onStart();
        BugPlugin bugPlugin = (BugPlugin) InstabugCore.getXPlugin(BugPlugin.class);
        if (bugPlugin != null) {
            bugPlugin.setState(1);
        }
        InstabugSDKLogger.m8356d(this, "onStart(),  SDK Invoking State Changed: true");
    }

    public void onStop() {
        super.onStop();
        BugPlugin bugPlugin = (BugPlugin) InstabugCore.getXPlugin(BugPlugin.class);
        if (!(bugPlugin == null || bugPlugin.getState() == 2)) {
            bugPlugin.setState(0);
        }
        InstabugSDKLogger.m8356d(this, "onPause(),  SDK Invoking State Changed: false");
    }

    protected void onDestroy() {
        if (!C0474d.m7762a().f9101b && C0474d.m7762a().f9102c == DismissType.ADD_ATTACHMENT) {
            C0474d.m7762a().f9102c = DismissType.CANCEL;
        }
        OrientationUtils.unlockOrientation(this);
        super.onDestroy();
    }

    protected int getLayout() {
        return C0465R.layout.instabug_activity_bug_reporting;
    }

    public void onClick(View view) {
        StringBuilder stringBuilder = new StringBuilder("onClick: ");
        stringBuilder.append(view.getId());
        InstabugSDKLogger.m8356d(this, stringBuilder.toString());
        view = new ArrayList(getSupportFragmentManager().mo229f());
        Collection arrayList = new ArrayList();
        arrayList.add(null);
        view.removeAll(arrayList);
        stringBuilder = new StringBuilder("Dark space clicked, fragments size is ");
        stringBuilder.append(view.size());
        stringBuilder.append(" fragments are ");
        stringBuilder.append(view);
        InstabugSDKLogger.m8360v(this, stringBuilder.toString());
    }

    public void onBackPressed() {
        if (getSupportFragmentManager().mo228e() <= 0) {
            C0474d.m7762a().f9102c = DismissType.CANCEL;
            InstabugSDKLogger.m8356d(this, "Reporting bug canceled. Deleting attachments");
            Cache cache = CacheManager.getInstance().getCache(CacheManager.DEFAULT_IN_MEMORY_CACHE_KEY);
            if (cache != null) {
                cache.delete("video.path");
            }
            VideoProcessingServiceEventBus.getInstance().post(Action.STOP);
            C0470c.m7757a();
        }
        if ((Instabug.getState() == InstabugState.TAKING_SCREENSHOT_FOR_CHAT || Instabug.getState() == InstabugState.IMPORTING_IMAGE_FROM_GALLERY_FOR_CHAT) && (getSupportFragmentManager().mo216a(C0465R.id.instabug_fragment_container) instanceof C1728b)) {
            Instabug.setState(InstabugState.ENABLED);
        }
        m21600a(false, C0465R.id.instabug_fragment_container);
        super.onBackPressed();
    }

    public final void mo4426a() {
        StringBuilder stringBuilder = new StringBuilder("Back stack changed, back stack size: ");
        stringBuilder.append(getSupportFragmentManager().mo228e());
        InstabugSDKLogger.m8360v(this, stringBuilder.toString());
        m21600a(true, C0465R.id.instabug_fragment_container);
    }

    public final void mo4429b() {
        InstabugSDKLogger.m8360v(this, "startBugReporter");
        C0474d.m7762a().f9100a.f15312c = C0478b.BUG;
        String str = C0474d.m7762a().f9100a.f15310a;
        if (!(C0474d.m7762a().f9100a.m15216b() || str == null)) {
            C0474d.m7762a().f9100a.m15214a(Uri.parse(str), Type.MAIN_SCREENSHOT);
        }
        m21600a(false, C0465R.id.instabug_fragment_container);
        C0485a.m7793a();
        if (C0485a.m7819j() || str == null) {
            m21599a(C0465R.id.instabug_fragment_container, C1730c.m21292a(C0478b.BUG, C0474d.m7762a().f9100a.f15313d, m21598a(162)), "feedback");
        } else {
            m21599a(C0465R.id.instabug_fragment_container, C1728b.m21285a(PlaceHolderUtils.getPlaceHolder(Key.BUG_REPORT_HEADER, getString(C0465R.string.instabug_str_bug_header)), Uri.parse(str), 0), "annotation");
        }
        ((C1631f) this.presenter).m19399a();
    }

    public final void mo4430c() {
        InstabugSDKLogger.m8360v(this, "startFeedbackSender");
        C0474d.m7762a().f9100a.f15312c = C0478b.FEEDBACK;
        String str = C0474d.m7762a().f9100a.f15310a;
        if (!(C0474d.m7762a().f9100a.m15216b() || str == null)) {
            C0474d.m7762a().f9100a.m15214a(Uri.parse(str), Type.MAIN_SCREENSHOT);
        }
        m21600a(false, C0465R.id.instabug_fragment_container);
        m21599a(C0465R.id.instabug_fragment_container, C1730c.m21292a(C0478b.FEEDBACK, C0474d.m7762a().f9100a.f15313d, m21598a(161)), "feedback");
        ((C1631f) this.presenter).m19399a();
    }

    public final void mo4427a(Bitmap bitmap, Uri uri) {
        InstabugSDKLogger.m8360v(this, "onImageEditingDone");
        if (bitmap != null) {
            BitmapUtils.saveBitmap(bitmap, uri, (Context) this);
        }
        m21600a((boolean) null, C0465R.id.instabug_fragment_container);
        getSupportFragmentManager().mo219a().mo196a(getSupportFragmentManager().mo218a("annotation")).mo203c();
        getSupportFragmentManager().mo226c();
        if (getSupportFragmentManager().mo218a("feedback") == null) {
            InstabugSDKLogger.m8360v(this, "Instabug Feedback fragment equal null");
            m21599a(C0465R.id.instabug_fragment_container, C1730c.m21292a(C0474d.m7762a().f9100a.f15312c, C0474d.m7762a().f9100a.f15313d, m21598a(C0474d.m7762a().f9100a.f15312c == C0478b.BUG ? 162 : 161)), "feedback");
        }
        C0474d.m7762a();
        C0474d.m7763a((Context) this);
    }

    public final void mo4431d() {
        InstabugSDKLogger.m8360v(this, "startWithHangingBug");
        StringBuilder stringBuilder = new StringBuilder("bug attachment size): ");
        stringBuilder.append(C0474d.m7762a().f9100a.f15314e.size());
        InstabugSDKLogger.m8360v(this, stringBuilder.toString());
        C0474d.m7762a().f9101b = false;
        if (getSupportFragmentManager().mo218a("feedback") == null) {
            m21600a(false, C0465R.id.instabug_fragment_container);
            getSupportFragmentManager().mo219a().mo195a(C0465R.id.instabug_fragment_container, C1730c.m21292a(C0474d.m7762a().f9100a.f15312c, C0474d.m7762a().f9100a.f15313d, m21598a(C0474d.m7762a().f9100a.f15312c == C0478b.BUG ? 162 : 161)), "feedback").mo203c();
        }
        C0474d.m7762a();
        C0474d.m7763a((Context) this);
        ((C1631f) this.presenter).m19399a();
    }

    private void m21600a(boolean z, int i) {
        if (getSupportFragmentManager().mo216a(i) instanceof FragmentVisibilityChangedListener) {
            ((FragmentVisibilityChangedListener) getSupportFragmentManager().mo216a(i)).onVisibilityChanged(z);
        }
    }

    private String m21598a(int i) {
        if (i == 161) {
            return PlaceHolderUtils.getPlaceHolder(Key.COMMENT_FIELD_HINT_FOR_FEEDBACK, getString(C0465R.string.instabug_str_feedback_comment_hint));
        }
        return PlaceHolderUtils.getPlaceHolder(Key.COMMENT_FIELD_HINT_FOR_BUG_REPORT, getString(C0465R.string.instabug_str_bug_comment_hint));
    }

    public final void mo4428a(boolean z) {
        findViewById(C0465R.id.instabug_pbi_footer).setVisibility(z ? false : true);
    }

    public final void mo4432e() {
        Cache cache = CacheManager.getInstance().getCache(CacheManager.DEFAULT_IN_MEMORY_CACHE_KEY);
        if (cache != null) {
            cache.delete("video.path");
        }
        finish();
    }

    private void m21599a(int i, Fragment fragment, String str) {
        getSupportFragmentManager().mo219a().mo201b(i, fragment, str).mo203c();
    }
}
