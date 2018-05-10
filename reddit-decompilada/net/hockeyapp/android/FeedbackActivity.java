package net.hockeyapp.android;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.stetho.server.http.HttpStatus;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import net.hockeyapp.android.adapters.MessagesAdapter;
import net.hockeyapp.android.objects.FeedbackMessage;
import net.hockeyapp.android.objects.FeedbackResponse;
import net.hockeyapp.android.objects.FeedbackUserDataElement;
import net.hockeyapp.android.tasks.ParseFeedbackTask;
import net.hockeyapp.android.tasks.SendFeedbackTask;
import net.hockeyapp.android.utils.AsyncTaskUtils;
import net.hockeyapp.android.utils.HockeyLog;
import net.hockeyapp.android.utils.PrefsUtil;
import net.hockeyapp.android.utils.Util;
import net.hockeyapp.android.views.AttachmentListView;
import net.hockeyapp.android.views.AttachmentView;

public class FeedbackActivity extends Activity implements OnClickListener, OnFocusChangeListener {
    private String f26488a;
    private String f26489b;
    private String f26490c;
    private String f26491d;
    private List<Uri> f26492e = new ArrayList();
    private Context f26493f;
    private TextView f26494g;
    private EditText f26495h;
    private EditText f26496i;
    private EditText f26497j;
    private EditText f26498k;
    private Button f26499l;
    private ListView f26500m;
    private AttachmentListView f26501n;
    private SendFeedbackTask f26502o;
    private Handler f26503p;
    private ParseFeedbackTask f26504q;
    private Handler f26505r;
    private String f26506s;
    private MessagesAdapter f26507t;
    private boolean f26508u;
    private boolean f26509v;
    private boolean f26510w;
    private String f26511x;

    class C21501 extends AsyncTask<Void, Object, Object> {
        final /* synthetic */ FeedbackActivity f26476a;

        C21501(FeedbackActivity feedbackActivity) {
            this.f26476a = feedbackActivity;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            PrefsUtil.m28225a().m28226a(this.f26476a, null);
            this.f26476a.getSharedPreferences("net.hockeyapp.android.feedback", 0).edit().remove("idLastMessageSend").remove("idLastMessageProcessed").apply();
            return null;
        }
    }

    private static class FeedbackHandler extends Handler {
        private final WeakReference<FeedbackActivity> f26483a;

        FeedbackHandler(FeedbackActivity feedbackActivity) {
            this.f26483a = new WeakReference(feedbackActivity);
        }

        public void handleMessage(Message message) {
            FeedbackActivity feedbackActivity = (FeedbackActivity) this.f26483a.get();
            if (feedbackActivity != null) {
                int i;
                int i2 = 0;
                if (message == null || message.getData() == null) {
                    i = C2158R.string.hockeyapp_feedback_send_generic_error;
                } else {
                    message = message.getData();
                    String string = message.getString("feedback_response");
                    String string2 = message.getString("feedback_status");
                    message = message.getString("request_type");
                    if (!"send".equals(message) || (string != null && Integer.parseInt(string2) == 201)) {
                        if ("fetch".equals(message) && string2 != null && (Integer.parseInt(string2) == HttpStatus.HTTP_NOT_FOUND || Integer.parseInt(string2) == 422)) {
                            FeedbackActivity.m28162b(feedbackActivity);
                        } else if (string != null) {
                            FeedbackActivity.m28159a(feedbackActivity, string, message);
                            if ("send".equals(message) != null) {
                                feedbackActivity.f26492e.removeAll(feedbackActivity.f26501n.getAttachments());
                                Toast.makeText(feedbackActivity, C2158R.string.hockeyapp_feedback_sent_toast, 1).show();
                            }
                        } else {
                            i = C2158R.string.hockeyapp_feedback_send_network_error;
                        }
                        i = null;
                        i2 = 1;
                    } else {
                        i = C2158R.string.hockeyapp_feedback_send_generic_error;
                    }
                }
                if (i2 == 0) {
                    new Builder(feedbackActivity).setTitle(C2158R.string.hockeyapp_dialog_error_title).setMessage(i).setCancelable(0).setPositiveButton(C2158R.string.hockeyapp_dialog_positive_button, null).create().show();
                }
            }
        }
    }

    private static class ParseFeedbackHandler extends Handler {
        private final WeakReference<FeedbackActivity> f26487a;

        ParseFeedbackHandler(FeedbackActivity feedbackActivity) {
            this.f26487a = new WeakReference(feedbackActivity);
        }

        @SuppressLint({"StaticFieldLeak"})
        public void handleMessage(Message message) {
            final FeedbackActivity feedbackActivity = (FeedbackActivity) this.f26487a.get();
            if (feedbackActivity != null) {
                boolean z = false;
                if (!(message == null || message.getData() == null)) {
                    final FeedbackResponse feedbackResponse = (FeedbackResponse) message.getData().getSerializable("parse_feedback_response");
                    if (feedbackResponse != null && feedbackResponse.f26560a.equalsIgnoreCase("success")) {
                        if (feedbackResponse.f26562c != null) {
                            feedbackActivity.f26511x = feedbackResponse.f26562c;
                            AsyncTaskUtils.m28200a(new AsyncTask<Void, Object, Object>(this) {
                                final /* synthetic */ ParseFeedbackHandler f26486c;

                                protected /* synthetic */ Object doInBackground(Object[] objArr) {
                                    PrefsUtil.m28225a().m28226a(feedbackActivity, feedbackResponse.f26562c);
                                    return null;
                                }
                            });
                            FeedbackActivity.m28160a(feedbackActivity, feedbackResponse);
                            feedbackActivity.f26508u = false;
                        }
                        z = true;
                    }
                }
                if (!z) {
                    new Builder(feedbackActivity).setTitle(C2158R.string.hockeyapp_dialog_error_title).setMessage(C2158R.string.hockeyapp_dialog_error_message).setCancelable(0).setPositiveButton(C2158R.string.hockeyapp_dialog_positive_button, null).create().show();
                }
                feedbackActivity.m28167a(true);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getLayoutInflater().inflate(C2158R.layout.hockeyapp_activity_feedback, null));
        setTitle(C2158R.string.hockeyapp_feedback_title);
        this.f26493f = this;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f26506s = extras.getString(UpdateFragment.FRAGMENT_URL);
            this.f26511x = extras.getString("token");
            this.f26509v = extras.getBoolean("forceNewThread");
            this.f26488a = extras.getString("initialUserName");
            this.f26489b = extras.getString("initialUserEmail");
            this.f26490c = extras.getString("initialUserSubject");
            this.f26491d = extras.getString("userId");
            Parcelable[] parcelableArray = extras.getParcelableArray("initialAttachments");
            if (parcelableArray != null) {
                this.f26492e.clear();
                for (Parcelable parcelable : parcelableArray) {
                    this.f26492e.add((Uri) parcelable);
                }
            }
        }
        if (bundle != null) {
            this.f26510w = bundle.getBoolean("feedbackViewInitialized");
            this.f26508u = bundle.getBoolean("inSendFeedback");
            this.f26511x = bundle.getString("token");
        } else {
            this.f26508u = false;
            this.f26510w = false;
        }
        Util.m28235a((Context) this);
        this.f26503p = new FeedbackHandler(this);
        this.f26505r = new ParseFeedbackHandler(this);
        bundle = getLastNonConfigurationInstance();
        if (bundle != null && (bundle instanceof SendFeedbackTask)) {
            this.f26502o = (SendFeedbackTask) bundle;
            this.f26502o.f33159b = this.f26503p;
        }
        m28155a();
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        if (bundle != null) {
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("attachments");
            if (parcelableArrayList != null) {
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    Uri uri = (Uri) it.next();
                    if (!this.f26492e.contains(uri)) {
                        this.f26501n.addView(new AttachmentView((Context) this, this.f26501n, uri));
                    }
                }
            }
            this.f26510w = bundle.getBoolean("feedbackViewInitialized");
        }
        super.onRestoreInstanceState(bundle);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelableArrayList("attachments", this.f26501n.getAttachments());
        bundle.putBoolean("feedbackViewInitialized", this.f26510w);
        bundle.putBoolean("inSendFeedback", this.f26508u);
        bundle.putString("token", this.f26511x);
        super.onSaveInstanceState(bundle);
    }

    protected void onStart() {
        super.onStart();
        if (this.f26502o != null) {
            SendFeedbackTask sendFeedbackTask = this.f26502o;
            sendFeedbackTask.f33158a = this;
            if (sendFeedbackTask.getStatus() != Status.RUNNING) {
                return;
            }
            if ((sendFeedbackTask.f33160c == null || !sendFeedbackTask.f33160c.isShowing()) && sendFeedbackTask.f33161d) {
                sendFeedbackTask.f33160c = ProgressDialog.show(sendFeedbackTask.f33158a, "", sendFeedbackTask.m33747b(), true, false);
            }
        }
    }

    protected void onStop() {
        super.onStop();
        if (this.f26502o != null) {
            this.f26502o.m33746a();
        }
    }

    public Object onRetainNonConfigurationInstance() {
        if (this.f26502o != null) {
            this.f26502o.m33746a();
        }
        return this.f26502o;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.f26508u != 0) {
            this.f26508u = false;
            m28155a();
        } else {
            finish();
        }
        return true;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == C2158R.id.button_send) {
            if (Util.m28239b((Context) this)) {
                m28167a(false);
                String str = (!this.f26509v || this.f26508u) ? this.f26511x : null;
                String str2 = str;
                final String trim = this.f26495h.getText().toString().trim();
                final String trim2 = this.f26496i.getText().toString().trim();
                final String trim3 = this.f26497j.getText().toString().trim();
                CharSequence trim4 = this.f26498k.getText().toString().trim();
                if (TextUtils.isEmpty(trim3)) {
                    this.f26497j.setVisibility(0);
                    m28156a(this.f26497j, C2158R.string.hockeyapp_feedback_validate_subject_error);
                    return;
                } else if (FeedbackManager.m28169b() == FeedbackUserDataElement.REQUIRED && TextUtils.isEmpty(trim)) {
                    m28156a(this.f26495h, C2158R.string.hockeyapp_feedback_validate_name_error);
                    return;
                } else if (FeedbackManager.m28170c() == FeedbackUserDataElement.REQUIRED && TextUtils.isEmpty(trim2)) {
                    m28156a(this.f26496i, C2158R.string.hockeyapp_feedback_validate_email_empty);
                    return;
                } else if (TextUtils.isEmpty(trim4)) {
                    m28156a(this.f26498k, C2158R.string.hockeyapp_feedback_validate_text_error);
                    return;
                } else if (FeedbackManager.m28170c() != FeedbackUserDataElement.REQUIRED || Util.m28240b(trim2)) {
                    AsyncTaskUtils.m28200a(new AsyncTask<Void, Object, Object>(this) {
                        final /* synthetic */ FeedbackActivity f26480d;

                        protected /* synthetic */ Object doInBackground(Object[] objArr) {
                            objArr = PrefsUtil.m28225a();
                            Context a = this.f26480d.f26493f;
                            String str = trim;
                            String str2 = trim2;
                            String str3 = trim3;
                            if (a != null) {
                                objArr.f26611a = a.getSharedPreferences("net.hockeyapp.android.prefs_name_email", 0);
                                if (objArr.f26611a != null) {
                                    objArr = objArr.f26611a.edit();
                                    if (!(str == null || str2 == null)) {
                                        if (str3 != null) {
                                            objArr.putString("net.hockeyapp.android.prefs_key_name_email", String.format("%s|%s|%s", new Object[]{str, str2, str3}));
                                            objArr.apply();
                                        }
                                    }
                                    objArr.putString("net.hockeyapp.android.prefs_key_name_email", null);
                                    objArr.apply();
                                }
                            }
                            return null;
                        }
                    });
                    m28157a(this.f26506s, trim, trim2, trim3, trim4, this.f26491d, this.f26501n.getAttachments(), str2, this.f26503p, false);
                    m28161b();
                    return;
                } else {
                    m28156a(this.f26496i, C2158R.string.hockeyapp_feedback_validate_email_error);
                    return;
                }
            }
            Toast.makeText(this, C2158R.string.hockeyapp_error_no_network_message, 1).show();
        } else if (id == C2158R.id.button_attachment) {
            if (this.f26501n.getChildCount() >= 3) {
                Toast.makeText(this, getString(C2158R.string.hockeyapp_feedback_max_attachments_allowed, new Object[]{Integer.valueOf(3)}), 0).show();
            } else {
                openContextMenu(view);
            }
        } else if (id == C2158R.id.button_add_response) {
            this.f26508u = true;
            m28163b(false);
        } else {
            if (id == C2158R.id.button_refresh) {
                m28157a(this.f26506s, null, null, null, null, null, null, this.f26511x, this.f26503p, true);
            }
        }
    }

    public void onFocusChange(View view, boolean z) {
        if (z) {
            if (view instanceof EditText) {
                ((InputMethodManager) getSystemService("input_method")).showSoftInput(view, 1);
            } else if ((view instanceof Button) || (view instanceof ImageButton) != null) {
                m28161b();
            }
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        contextMenu.add(0, 2, 0, getString(C2158R.string.hockeyapp_feedback_attach_file));
        contextMenu.add(0, 1, 0, getString(C2158R.string.hockeyapp_feedback_attach_picture));
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
            case 2:
                menuItem = menuItem.getItemId();
                if (menuItem == 2) {
                    menuItem = new Intent();
                    menuItem.setType("*/*");
                    menuItem.setAction("android.intent.action.GET_CONTENT");
                    startActivityForResult(Intent.createChooser(menuItem, getString(C2158R.string.hockeyapp_feedback_select_file)), 2);
                    return true;
                } else if (menuItem != 1) {
                    return null;
                } else {
                    menuItem = new Intent();
                    menuItem.setType("image/*");
                    menuItem.setAction("android.intent.action.GET_CONTENT");
                    startActivityForResult(Intent.createChooser(menuItem, getString(C2158R.string.hockeyapp_feedback_select_picture)), 1);
                    return true;
                }
            default:
                return super.onContextItemSelected(menuItem);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            Uri data;
            if (i == 2) {
                data = intent.getData();
                if (data != 0) {
                    this.f26501n.addView(new AttachmentView((Context) this, this.f26501n, data));
                    Util.m28237a(this.f26501n, getString(C2158R.string.hockeyapp_feedback_attachment_added));
                }
            } else if (i == 1) {
                i = intent.getData();
                if (i != 0) {
                    try {
                        i2 = new Intent(this, PaintActivity.class);
                        i2.putExtra("imageUri", i);
                        startActivityForResult(i2, 3);
                    } catch (Throwable e) {
                        HockeyLog.m28206a("Paint activity not declared!", e);
                    }
                }
            } else {
                if (i == 3) {
                    data = (Uri) intent.getParcelableExtra("imageUri");
                    if (data != null) {
                        this.f26501n.addView(new AttachmentView((Context) this, this.f26501n, data));
                        Util.m28237a(this.f26501n, getString(C2158R.string.hockeyapp_feedback_attachment_added));
                    }
                }
            }
        }
    }

    public final void m28167a(boolean z) {
        if (this.f26499l != null) {
            this.f26499l.setEnabled(z);
        }
    }

    private void m28163b(boolean z) {
        ScrollView scrollView = (ScrollView) findViewById(C2158R.id.wrapper_feedback_scroll);
        LinearLayout linearLayout = (LinearLayout) findViewById(C2158R.id.wrapper_messages);
        this.f26500m = (ListView) findViewById(C2158R.id.list_feedback_messages);
        this.f26501n = (AttachmentListView) findViewById(C2158R.id.wrapper_attachments);
        if (z) {
            linearLayout.setVisibility(0);
            scrollView.setVisibility(8);
            this.f26494g = (TextView) findViewById(C2158R.id.label_last_updated);
            this.f26494g.setVisibility(4);
            Button button = (Button) findViewById(C2158R.id.button_add_response);
            button.setOnClickListener(this);
            button.setOnFocusChangeListener(this);
            button = (Button) findViewById(C2158R.id.button_refresh);
            button.setOnClickListener(this);
            button.setOnFocusChangeListener(this);
            return;
        }
        linearLayout.setVisibility(8);
        scrollView.setVisibility(0);
        this.f26495h = (EditText) findViewById(C2158R.id.input_name);
        this.f26495h.setOnFocusChangeListener(this);
        this.f26496i = (EditText) findViewById(C2158R.id.input_email);
        this.f26496i.setOnFocusChangeListener(this);
        this.f26497j = (EditText) findViewById(C2158R.id.input_subject);
        this.f26497j.setOnFocusChangeListener(this);
        this.f26498k = (EditText) findViewById(C2158R.id.input_message);
        this.f26498k.setOnFocusChangeListener(this);
        if (FeedbackManager.m28169b() == FeedbackUserDataElement.REQUIRED) {
            this.f26495h.setHint(getString(C2158R.string.hockeyapp_feedback_name_hint_required));
        }
        if (FeedbackManager.m28170c() == FeedbackUserDataElement.REQUIRED) {
            this.f26496i.setHint(getString(C2158R.string.hockeyapp_feedback_email_hint_required));
        }
        this.f26497j.setHint(getString(C2158R.string.hockeyapp_feedback_subject_hint_required));
        this.f26498k.setHint(getString(C2158R.string.hockeyapp_feedback_message_hint_required));
        if (!this.f26510w) {
            this.f26495h.setText(this.f26488a);
            this.f26496i.setText(this.f26489b);
            this.f26497j.setText(this.f26490c);
            if (TextUtils.isEmpty(this.f26488a)) {
                this.f26495h.requestFocus();
            } else if (TextUtils.isEmpty(this.f26489b)) {
                this.f26496i.requestFocus();
            } else if (TextUtils.isEmpty(this.f26490c)) {
                this.f26497j.requestFocus();
            } else {
                this.f26498k.requestFocus();
            }
            this.f26510w = true;
        }
        this.f26495h.setVisibility(FeedbackManager.m28169b() == FeedbackUserDataElement.DONT_SHOW ? 8 : 0);
        this.f26496i.setVisibility(FeedbackManager.m28170c() == FeedbackUserDataElement.DONT_SHOW ? 8 : 0);
        this.f26498k.setText("");
        if ((!this.f26509v || this.f26508u) && this.f26511x) {
            this.f26497j.setVisibility(8);
        } else {
            this.f26497j.setVisibility(0);
        }
        this.f26501n.removeAllViews();
        for (Uri attachmentView : this.f26492e) {
            this.f26501n.addView(new AttachmentView((Context) this, this.f26501n, attachmentView));
        }
        button = (Button) findViewById(C2158R.id.button_attachment);
        button.setOnClickListener(this);
        button.setOnFocusChangeListener(this);
        registerForContextMenu(button);
        this.f26499l = (Button) findViewById(C2158R.id.button_send);
        this.f26499l.setOnClickListener(this);
        button.setOnFocusChangeListener(this);
    }

    private void m28155a() {
        if (this.f26511x != null) {
            if (!this.f26508u) {
                m28163b(true);
                m28157a(this.f26506s, null, null, null, null, null, null, this.f26511x, this.f26503p, true);
                return;
            }
        }
        m28163b(false);
    }

    private void m28161b() {
        if (this.f26498k != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.f26498k.getWindowToken(), 0);
        }
    }

    private void m28156a(final EditText editText, int i) {
        editText.setError(getString(i));
        new Handler(Looper.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ FeedbackActivity f26482b;

            public void run() {
                editText.requestFocus();
            }
        });
        m28167a(true);
    }

    private void m28157a(String str, String str2, String str3, String str4, String str5, String str6, List<Uri> list, String str7, Handler handler, boolean z) {
        this.f26502o = new SendFeedbackTask(this.f26493f, str, str2, str3, str4, str5, str6, list, str7, handler, z);
        AsyncTaskUtils.m28200a(this.f26502o);
    }

    static /* synthetic */ void m28162b(FeedbackActivity feedbackActivity) {
        feedbackActivity.f26511x = null;
        AsyncTaskUtils.m28200a(new C21501(feedbackActivity));
        feedbackActivity.m28163b(false);
    }

    static /* synthetic */ void m28159a(FeedbackActivity feedbackActivity, String str, String str2) {
        feedbackActivity.f26504q = new ParseFeedbackTask(feedbackActivity, str, feedbackActivity.f26505r, str2);
        AsyncTaskUtils.m28200a(feedbackActivity.f26504q);
    }

    static /* synthetic */ void m28160a(FeedbackActivity feedbackActivity, FeedbackResponse feedbackResponse) {
        feedbackActivity.m28163b(true);
        if (feedbackResponse != null && feedbackResponse.f26561b != null && feedbackResponse.f26561b.f26545e != null && feedbackResponse.f26561b.f26545e.size() > 0) {
            feedbackResponse = feedbackResponse.f26561b.f26545e;
            Collections.reverse(feedbackResponse);
            try {
                DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(3, 3);
                Date parse = simpleDateFormat.parse(((FeedbackMessage) feedbackResponse.get(0)).f26551f);
                feedbackActivity.f26494g.setText(String.format(feedbackActivity.getString(C2158R.string.hockeyapp_feedback_last_updated_text), new Object[]{dateTimeInstance.format(parse)}));
                feedbackActivity.f26494g.setContentDescription(feedbackActivity.f26494g.getText());
                feedbackActivity.f26494g.setVisibility(0);
            } catch (Throwable e) {
                HockeyLog.m28206a("Failed to parse feedback", e);
            }
            if (feedbackActivity.f26507t == null) {
                feedbackActivity.f26507t = new MessagesAdapter(feedbackActivity.f26493f, feedbackResponse);
            } else {
                MessagesAdapter messagesAdapter = feedbackActivity.f26507t;
                if (messagesAdapter.f26538a != null) {
                    messagesAdapter.f26538a.clear();
                }
                feedbackResponse = feedbackResponse.iterator();
                while (feedbackResponse.hasNext()) {
                    FeedbackMessage feedbackMessage = (FeedbackMessage) feedbackResponse.next();
                    MessagesAdapter messagesAdapter2 = feedbackActivity.f26507t;
                    if (!(feedbackMessage == null || messagesAdapter2.f26538a == null)) {
                        messagesAdapter2.f26538a.add(feedbackMessage);
                    }
                }
                feedbackActivity.f26507t.notifyDataSetChanged();
            }
            feedbackActivity.f26500m.setAdapter(feedbackActivity.f26507t);
        }
    }
}
