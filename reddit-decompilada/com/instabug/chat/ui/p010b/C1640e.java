package com.instabug.chat.ui.p010b;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.instabug.chat.C0520R;
import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.storage.cache.AssetsCacheManager;
import com.instabug.library.internal.storage.cache.AssetsCacheManager.OnDownloadFinished;
import com.instabug.library.model.AssetEntity;
import com.instabug.library.model.AssetEntity.AssetType;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.view.ScaleImageView;
import java.io.FileInputStream;

/* compiled from: ImageAttachmentViewerFragment */
public class C1640e extends Fragment {
    private String f18534a;
    private ProgressBar f18535b;
    private ScaleImageView f18536c;
    private float f18537d;
    private float f18538e;

    /* compiled from: ImageAttachmentViewerFragment */
    class C13231 implements OnDownloadFinished {
        final /* synthetic */ C1640e f15406a;

        C13231(C1640e c1640e) {
            this.f15406a = c1640e;
        }

        public void onSuccess(AssetEntity assetEntity) {
            StringBuilder stringBuilder = new StringBuilder("Asset Entity downloaded: ");
            stringBuilder.append(assetEntity.getFile().getPath());
            InstabugSDKLogger.m8356d(this, stringBuilder.toString());
            try {
                assetEntity = BitmapUtils.resizeBitmap(BitmapFactory.decodeStream(new FileInputStream(assetEntity.getFile())), this.f15406a.f18537d, this.f15406a.f18538e);
                if (assetEntity != null) {
                    this.f15406a.f18536c.setImageBitmap(assetEntity);
                } else {
                    Toast.makeText(this.f15406a.getActivity(), C0520R.string.instabug_str_image_loading_error, 0).show();
                }
                if (this.f15406a.f18535b.getVisibility() == null) {
                    this.f15406a.f18535b.setVisibility(8);
                }
            } catch (AssetEntity assetEntity2) {
                InstabugSDKLogger.m8358e(this, "Asset Entity downloading got FileNotFoundException error", assetEntity2);
            }
        }

        public void onFailed(Throwable th) {
            InstabugSDKLogger.m8358e(this, "Asset Entity downloading got error", th);
        }
    }

    public static C1640e m19442a(String str) {
        C1640e c1640e = new C1640e();
        Bundle bundle = new Bundle();
        bundle.putString("img_url", str);
        c1640e.setArguments(bundle);
        return c1640e;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f18534a = getArguments().getString("img_url");
            return;
        }
        if (bundle != null) {
            this.f18534a = bundle.getString("img_url");
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("img_url", this.f18534a);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(C0520R.layout.instabug_fragment_image_attachment_viewer, viewGroup, false);
        this.f18535b = (ProgressBar) layoutInflater.findViewById(C0520R.id.instabug_attachment_progress_bar);
        this.f18536c = (ScaleImageView) layoutInflater.findViewById(C0520R.id.instabug_img_attachment);
        if (InstabugCore.getFeatureState(Feature.WHITE_LABELING) == State.DISABLED) {
            getActivity().findViewById(C0520R.id.instabug_pbi_footer).setVisibility(8);
        }
        return layoutInflater;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(view);
        this.f18537d = (float) (view.widthPixels - ((int) C1640e.m19440a(getActivity())));
        this.f18538e = (float) (view.heightPixels - ((int) C1640e.m19440a(getActivity())));
        if (URLUtil.isValidUrl(this.f18534a) != null) {
            AssetsCacheManager.getAssetEntity(getActivity(), AssetsCacheManager.createEmptyEntity(getActivity(), this.f18534a, AssetType.IMAGE), new C13231(this));
            return;
        }
        BitmapUtils.loadBitmap(this.f18534a, this.f18536c, this.f18537d, this.f18538e);
    }

    private static float m19440a(Context context) {
        return 24.0f * (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f);
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (InstabugCore.getFeatureState(Feature.WHITE_LABELING) == State.DISABLED) {
            getActivity().findViewById(C0520R.id.instabug_pbi_footer).setVisibility(0);
        }
    }
}
