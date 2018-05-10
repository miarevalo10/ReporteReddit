package com.reddit.frontpage.ui.detail.web;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;
import com.reddit.frontpage.BaseActivity;
import com.reddit.frontpage.BaseActivity.OnBackPressedListener;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import net.hockeyapp.android.UpdateFragment;
import timber.log.Timber;

public class WebBrowserFragment extends Fragment {
    private View f34277a;
    protected View f34278b;
    protected View f34279c;
    protected Toolbar f34280d;
    protected TextView f34281e;
    protected WebView f34282f;
    private View f34283g;
    private BaseActivity f34284h;
    private boolean f34285i;
    private String f34286j;
    private final OnBackPressedListener f34287k = new C23321(this);

    class C18842 extends WebChromeClient {
        final /* synthetic */ WebBrowserFragment f21205a;

        C18842(WebBrowserFragment webBrowserFragment) {
            this.f21205a = webBrowserFragment;
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            Timber.b("console: %s", new Object[]{consoleMessage.message()});
            return super.onConsoleMessage(consoleMessage);
        }
    }

    protected class DefaultWebViewClient extends WebViewClient {
        final /* synthetic */ WebBrowserFragment f21206b;

        protected DefaultWebViewClient(WebBrowserFragment webBrowserFragment) {
            this.f21206b = webBrowserFragment;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Timber.b(str, new Object[0]);
            Context context = webView.getContext();
            if (!(str == null || context == null)) {
                Uri parse = Uri.parse(str);
                Timber.b("scheme is %s", new Object[]{parse.getScheme()});
                String scheme = parse.getScheme();
                if (!scheme.equals("http") && !scheme.equals("https")) {
                    webView = new Intent("android.intent.action.VIEW", parse);
                    if (FrontpageApplication.f27402a.getPackageManager().resolveActivity(webView, 0) != null) {
                        context.startActivity(webView);
                    }
                    return true;
                } else if (parse.getHost().startsWith("www.reddit.com")) {
                    str = str.replaceFirst("www.reddit.com", "h.reddit.com");
                }
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            WebBrowserFragment.m34990a(this.f21206b, this.f21206b.f34285i != null ? this.f21206b.f34286j : Uri.parse(str).getHost());
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            WebBrowserFragment.m34990a(this.f21206b, this.f21206b.f34285i ? this.f21206b.f34286j : Uri.parse(str).getHost());
        }
    }

    class C23321 implements OnBackPressedListener {
        final /* synthetic */ WebBrowserFragment f28986a;

        C23321(WebBrowserFragment webBrowserFragment) {
            this.f28986a = webBrowserFragment;
        }

        public final boolean mo4975a() {
            if (!this.f28986a.f34282f.canGoBack()) {
                return false;
            }
            this.f28986a.f34282f.goBack();
            return true;
        }
    }

    protected int mo6998a() {
        return C1761R.layout.fragment_web_browser;
    }

    public static WebBrowserFragment m34989a(String str, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("com.reddit.args.initial_url", str);
        bundle.putString("com.reddit.arg.title_override", null);
        bundle.putInt("com.reddit.arg.color", i);
        str = new WebBrowserFragment();
        str.setArguments(bundle);
        return str;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f34286j = getArguments().getString("com.reddit.arg.title_override", null);
        this.f34285i = TextUtils.isEmpty(this.f34286j) ^ 1;
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f34279c = layoutInflater.inflate(mo6998a(), viewGroup, false);
        this.f34280d = (Toolbar) this.f34279c.findViewById(C1761R.id.toolbar);
        this.f34281e = (TextView) this.f34280d.findViewById(C1761R.id.address);
        this.f34282f = (WebView) this.f34279c.findViewById(C1761R.id.web_view);
        this.f34280d.setBackgroundColor(getArguments().getInt("com.reddit.arg.color"));
        this.f34284h.a(this.f34280d);
        layoutInflater = this.f34284h.c().a();
        layoutInflater.a(true);
        layoutInflater.b(true);
        this.f34278b = this.f34280d.findViewById(C1761R.id.web_view_control);
        this.f34277a = this.f34278b.findViewById(C1761R.id.web_view_control_back);
        this.f34283g = this.f34278b.findViewById(C1761R.id.web_view_control_forward);
        this.f34277a.setOnClickListener(new WebBrowserFragment$$Lambda$0(this));
        this.f34283g.setOnClickListener(new WebBrowserFragment$$Lambda$1(this));
        layoutInflater = this.f34282f.getSettings();
        layoutInflater.setJavaScriptEnabled(true);
        layoutInflater.setDomStorageEnabled(true);
        layoutInflater.setLoadWithOverviewMode(true);
        layoutInflater.setUseWideViewPort(true);
        layoutInflater.setBuiltInZoomControls(true);
        layoutInflater.setDisplayZoomControls(false);
        layoutInflater.setDomStorageEnabled(true);
        layoutInflater.setMediaPlaybackRequiresUserGesture(false);
        this.f34282f.setWebChromeClient(new C18842(this));
        this.f34282f.setWebViewClient(mo7000b());
        this.f34282f.setDownloadListener(new WebBrowserFragment$$Lambda$2(this));
        this.f34282f.loadUrl(getArguments().getString("com.reddit.args.initial_url"));
        return this.f34279c;
    }

    final /* synthetic */ void m34997d() {
        this.f34282f.goBack();
    }

    final /* synthetic */ void m34996c() {
        this.f34282f.goForward();
    }

    public void onResume() {
        super.onResume();
        this.f34282f.onResume();
        this.f34284h.m42470a(this.f34287k);
    }

    public void onPause() {
        super.onPause();
        this.f34282f.onPause();
        this.f34284h.m42471b(this.f34287k);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f34284h = (BaseActivity) activity;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        if (!this.f34285i) {
            menuInflater.inflate(C1761R.menu.menu_web_browser, menu);
            this.f34281e.setPadding(0, 0, 0, 0);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            getActivity().finish();
            return true;
        } else if (itemId == C1761R.id.action_copy_uri) {
            ((ClipboardManager) getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(UpdateFragment.FRAGMENT_URL, this.f34282f.getUrl()));
            return true;
        } else if (itemId == C1761R.id.action_open_external) {
            try {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f34282f.getUrl())));
            } catch (MenuItem menuItem2) {
                Timber.b(menuItem2, "No activity found to open web link: %s", new Object[]{this.f34282f.getUrl()});
                Toast.makeText(getContext(), C1761R.string.error_no_app_found_to_open, 1).show();
            }
            return true;
        } else if (itemId != C1761R.id.action_refresh) {
            return super.onOptionsItemSelected(menuItem2);
        } else {
            this.f34282f.reload();
            return true;
        }
    }

    protected void mo6999a(String str) {
        this.f34281e.setText(str);
    }

    protected WebViewClient mo7000b() {
        return new DefaultWebViewClient(this);
    }

    static /* synthetic */ void m34990a(WebBrowserFragment webBrowserFragment, String str) {
        webBrowserFragment.mo6999a(str);
        int i = 4;
        webBrowserFragment.f34277a.setVisibility(webBrowserFragment.f34282f.canGoBack() ? 0 : 4);
        str = webBrowserFragment.f34283g;
        if (webBrowserFragment.f34282f.canGoForward() != null) {
            i = 0;
        }
        str.setVisibility(i);
    }
}
