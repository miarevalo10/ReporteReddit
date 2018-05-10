package com.instabug.chat.ui.p010b;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.instabug.chat.C0520R;
import com.instabug.chat.settings.C0554a;
import com.instabug.library.C0593R;
import com.instabug.library.FragmentVisibilityChangedListener;
import com.instabug.library.InstabugBaseFragment;
import com.instabug.library.InstabugCustomTextPlaceHolder.Key;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.PlaceHolderUtils;

/* compiled from: AttachmentsBottomSheetFragment */
public class C1709a extends InstabugBaseFragment implements OnClickListener, FragmentVisibilityChangedListener {
    C0561a f19284a;

    /* compiled from: AttachmentsBottomSheetFragment */
    public interface C0561a {
        void mo4328a();

        void mo4332b();

        void mo4334c();
    }

    protected void consumeNewInstanceSavedArguments() {
    }

    protected void restoreState(Bundle bundle) {
    }

    protected void saveState(Bundle bundle) {
    }

    public static C1709a m20528a(C0561a c0561a) {
        C1709a c1709a = new C1709a();
        c1709a.f19284a = c0561a;
        return c1709a;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (C0554a.m7941b().isScreenshotEnabled() != null) {
            view.findViewById(C0520R.id.instabug_attach_screenshot).setOnClickListener(this);
        } else {
            view.findViewById(C0520R.id.instabug_attach_screenshot).setVisibility(8);
        }
        if (C0554a.m7941b().isImageFromGalleryEnabled() != null) {
            view.findViewById(C0520R.id.instabug_attach_gallery_image).setOnClickListener(this);
        } else {
            view.findViewById(C0520R.id.instabug_attach_gallery_image).setVisibility(8);
        }
        if (C0554a.m7941b().isScreenRecordingEnabled() != null) {
            view.findViewById(C0520R.id.instabug_attach_video).setOnClickListener(this);
        } else {
            view.findViewById(C0520R.id.instabug_attach_video).setVisibility(8);
        }
        view.findViewById(C0520R.id.instabug_attachments_bottom_sheet_dim_view).setOnClickListener(this);
        ((TextView) view.findViewById(C0520R.id.instabug_attach_gallery_image_text)).setText(PlaceHolderUtils.getPlaceHolder(Key.ADD_IMAGE_FROM_GALLERY, getString(C0593R.string.instabug_str_add_photo)));
        ((TextView) view.findViewById(C0520R.id.instabug_attach_screenshot_text)).setText(PlaceHolderUtils.getPlaceHolder(Key.ADD_EXTRA_SCREENSHOT, getString(C0593R.string.instabug_str_take_screenshot)));
        ((TextView) view.findViewById(C0520R.id.instabug_attach_video_text)).setText(PlaceHolderUtils.getPlaceHolder(Key.ADD_VIDEO, getString(C0593R.string.instabug_str_record_video)));
        if (VERSION.SDK_INT >= 12) {
            view = view.findViewById(C0520R.id.instabug_attachments_actions_bottom_sheet);
            view.setAlpha(null);
            view.post(new Runnable(this) {
                final /* synthetic */ C1709a f9302b;

                public void run() {
                    if (VERSION.SDK_INT >= 12) {
                        int height = view.getHeight();
                        view.setTranslationY((float) height);
                        view.setAlpha(1.0f);
                        view.animate().setDuration(100).translationYBy((float) (-height));
                    }
                }
            });
        }
    }

    protected int getLayout() {
        return C0520R.layout.instabug_fragment_attachments_bottom_sheet;
    }

    protected String getTitle() {
        return getString(C0593R.string.instabug_str_empty);
    }

    public void onClick(View view) {
        view = view.getId();
        if (view == C0520R.id.instabug_attach_screenshot) {
            m20529a();
            this.f19284a.mo4328a();
        } else if (view == C0520R.id.instabug_attach_gallery_image) {
            m20529a();
            this.f19284a.mo4332b();
        } else if (view == C0520R.id.instabug_attach_video) {
            m20529a();
            this.f19284a.mo4334c();
        } else {
            if (view == C0520R.id.instabug_attachments_bottom_sheet_dim_view) {
                m20529a();
            }
        }
    }

    private void m20529a() {
        getActivity().getSupportFragmentManager().mo219a().mo196a((Fragment) this).mo203c();
        getActivity().getSupportFragmentManager().mo224b("attachments_bottom_sheet_fragment");
    }

    public void onVisibilityChanged(boolean z) {
        StringBuilder stringBuilder = new StringBuilder("Is visible ");
        stringBuilder.append(z);
        InstabugSDKLogger.m8356d(this, stringBuilder.toString());
    }
}
