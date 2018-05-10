package net.hockeyapp.android;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.instabug.library.model.NetworkLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import net.hockeyapp.android.listeners.DownloadFileListener;
import net.hockeyapp.android.tasks.DownloadFileTask;
import net.hockeyapp.android.tasks.GetFileSizeTask;
import net.hockeyapp.android.utils.AsyncTaskUtils;
import net.hockeyapp.android.utils.PermissionsUtil;
import net.hockeyapp.android.utils.Util;
import net.hockeyapp.android.utils.VersionHelper;

public class UpdateFragment extends DialogFragment implements OnClickListener, UpdateInfoListener {
    public static final String FRAGMENT_DIALOG = "dialog";
    public static final String FRAGMENT_TAG = "hockey_update_dialog";
    public static final String FRAGMENT_URL = "url";
    public static final String FRAGMENT_VERSION_INFO = "versionInfo";
    private String mUrlString;
    private String mVersionInfo;

    class C25992 extends DownloadFileListener {
        final /* synthetic */ UpdateFragment f33149a;

        public final void mo5953a(DownloadFileTask downloadFileTask) {
        }

        C25992(UpdateFragment updateFragment) {
            this.f33149a = updateFragment;
        }

        public final void mo5954a(Boolean bool) {
            if (bool.booleanValue() != null) {
                this.f33149a.startDownloadTask();
            }
        }
    }

    public static UpdateFragment newInstance(String str, String str2, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString(FRAGMENT_URL, str2);
        bundle.putString(FRAGMENT_VERSION_INFO, str);
        bundle.putBoolean(FRAGMENT_DIALOG, z);
        str = new UpdateFragment();
        str.setArguments(bundle);
        return str;
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && dialog.getWindow() != null) {
            dialog.getWindow().setLayout(-1, -1);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        bundle = getArguments();
        this.mUrlString = bundle.getString(FRAGMENT_URL);
        this.mVersionInfo = bundle.getString(FRAGMENT_VERSION_INFO);
        setShowsDialog(bundle.getBoolean(FRAGMENT_DIALOG));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = getLayoutView();
        viewGroup = new VersionHelper(getActivity(), this.mVersionInfo, this);
        TextView textView = (TextView) layoutInflater.findViewById(C2158R.id.label_title);
        textView.setText(Util.m28241c(getActivity()));
        textView.setContentDescription(textView.getText());
        textView = (TextView) layoutInflater.findViewById(C2158R.id.label_version);
        String string = getString(C2158R.string.hockeyapp_update_version);
        Object[] objArr = new Object[1];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(VersionHelper.m28245a(viewGroup.f26622a, "shortversion", ""));
        stringBuilder.append(" (");
        stringBuilder.append(VersionHelper.m28245a(viewGroup.f26622a, "version", ""));
        stringBuilder.append(")");
        objArr[0] = stringBuilder.toString();
        string = String.format(string, objArr);
        final String format = new SimpleDateFormat("dd.MM.yyyy").format(new Date(VersionHelper.m28244a(viewGroup.f26622a, "timestamp") * 1000));
        String string2 = getString(C2158R.string.hockeyapp_update_unknown_size);
        boolean booleanValue = Boolean.valueOf(VersionHelper.m28245a(viewGroup.f26622a, "external", "false")).booleanValue();
        long a = VersionHelper.m28244a(viewGroup.f26622a, "appsize");
        if (booleanValue && a == 0) {
            a = -1;
        }
        if (a >= 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(String.format(Locale.US, "%.2f", new Object[]{Float.valueOf(((float) a) / 1048576.0f)}));
            stringBuilder.append(" MB");
            string2 = stringBuilder.toString();
        } else {
            AsyncTaskUtils.m28200a(new GetFileSizeTask(getActivity(), this.mUrlString, new DownloadFileListener(this) {
                final /* synthetic */ UpdateFragment f33148d;

                public final void mo5953a(DownloadFileTask downloadFileTask) {
                    if (downloadFileTask instanceof GetFileSizeTask) {
                        long j = ((GetFileSizeTask) downloadFileTask).f33150g;
                        downloadFileTask = new StringBuilder();
                        downloadFileTask.append(String.format(Locale.US, "%.2f", new Object[]{Float.valueOf(((float) j) / 1048576.0f)}));
                        downloadFileTask.append(" MB");
                        downloadFileTask = downloadFileTask.toString();
                        textView.setText(this.f33148d.getString(C2158R.string.hockeyapp_update_version_details_label, new Object[]{string, format, downloadFileTask}));
                    }
                }
            }));
        }
        textView.setText(getString(C2158R.string.hockeyapp_update_version_details_label, new Object[]{string, format, string2}));
        ((Button) layoutInflater.findViewById(C2158R.id.button_update)).setOnClickListener(this);
        WebView webView = (WebView) layoutInflater.findViewById(C2158R.id.web_update_details);
        webView.clearCache(true);
        webView.destroyDrawingCache();
        webView.loadDataWithBaseURL("https://sdk.hockeyapp.net/", viewGroup.m28249a(), NetworkLog.HTML, "utf-8", null);
        return layoutInflater;
    }

    public void onDestroyView() {
        Dialog dialog = getDialog();
        if (dialog != null && getRetainInstance()) {
            dialog.setDismissMessage(null);
        }
        super.onDestroyView();
    }

    public void onClick(View view) {
        prepareDownload();
    }

    public int getCurrentVersionCode() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r0 = r3.getActivity();	 Catch:{ NameNotFoundException -> 0x0019, NameNotFoundException -> 0x0019 }
        r0 = r0.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0019, NameNotFoundException -> 0x0019 }
        r1 = r3.getActivity();	 Catch:{ NameNotFoundException -> 0x0019, NameNotFoundException -> 0x0019 }
        r1 = r1.getPackageName();	 Catch:{ NameNotFoundException -> 0x0019, NameNotFoundException -> 0x0019 }
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ NameNotFoundException -> 0x0019, NameNotFoundException -> 0x0019 }
        r0 = r0.getPackageInfo(r1, r2);	 Catch:{ NameNotFoundException -> 0x0019, NameNotFoundException -> 0x0019 }
        r0 = r0.versionCode;	 Catch:{ NameNotFoundException -> 0x0019, NameNotFoundException -> 0x0019 }
        goto L_0x001a;
    L_0x0019:
        r0 = -1;
    L_0x001a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.UpdateFragment.getCurrentVersionCode():int");
    }

    private void showError(int i) {
        new Builder(getActivity()).setTitle(C2158R.string.hockeyapp_dialog_error_title).setMessage(i).setCancelable(false).setPositiveButton(C2158R.string.hockeyapp_dialog_positive_button, null).create().show();
    }

    private static String[] requiredPermissions() {
        ArrayList arrayList = new ArrayList();
        if (VERSION.SDK_INT < 19) {
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    protected void prepareDownload() {
        Context activity = getActivity();
        if (!Util.m28239b(activity)) {
            showError(C2158R.string.hockeyapp_error_no_network_message);
        } else if (!PermissionsUtil.m28223a(PermissionsUtil.m28224a(activity, requiredPermissions()))) {
            showError(C2158R.string.hockeyapp_error_no_external_storage_permission);
        } else if (PermissionsUtil.m28222a(activity)) {
            startDownloadTask();
            if (getShowsDialog()) {
                dismiss();
            }
        } else if (VERSION.SDK_INT >= 26) {
            Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
            StringBuilder stringBuilder = new StringBuilder("package:");
            stringBuilder.append(activity.getPackageName());
            intent.setData(Uri.parse(stringBuilder.toString()));
            activity.startActivity(intent);
        } else {
            showError(C2158R.string.hockeyapp_error_install_form_unknown_sources_disabled);
        }
    }

    protected void startDownloadTask() {
        AsyncTaskUtils.m28200a(new DownloadFileTask(getActivity(), this.mUrlString, new C25992(this)));
    }

    public View getLayoutView() {
        View linearLayout = new LinearLayout(getActivity());
        LayoutInflater.from(getActivity()).inflate(C2158R.layout.hockeyapp_fragment_update, linearLayout);
        return linearLayout;
    }
}
