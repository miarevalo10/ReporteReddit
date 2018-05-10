package net.hockeyapp.android.tasks;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import net.hockeyapp.android.C2158R;
import net.hockeyapp.android.FeedbackActivity;
import net.hockeyapp.android.FeedbackManager;
import net.hockeyapp.android.FeedbackManagerListener;
import net.hockeyapp.android.UpdateFragment;
import net.hockeyapp.android.objects.FeedbackMessage;
import net.hockeyapp.android.objects.FeedbackResponse;
import net.hockeyapp.android.utils.FeedbackParser;
import net.hockeyapp.android.utils.Util;

@SuppressLint({"StaticFieldLeak"})
public class ParseFeedbackTask extends AsyncTask<Void, Void, FeedbackResponse> {
    private Context f26593a;
    private String f26594b;
    private Handler f26595c;
    private String f26596d;
    private String f26597e = null;

    protected /* synthetic */ void onPostExecute(Object obj) {
        FeedbackResponse feedbackResponse = (FeedbackResponse) obj;
        if (feedbackResponse != null && this.f26595c != null) {
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putSerializable("parse_feedback_response", feedbackResponse);
            message.setData(bundle);
            this.f26595c.sendMessage(message);
        }
    }

    public ParseFeedbackTask(Context context, String str, Handler handler, String str2) {
        this.f26593a = context;
        this.f26594b = str;
        this.f26595c = handler;
        this.f26596d = str2;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        Class cls = null;
        if (this.f26593a == null || this.f26594b == null) {
            return null;
        }
        FeedbackParser.m28203a();
        objArr = FeedbackParser.m28202a(this.f26594b);
        if (!(objArr == null || objArr.f26561b == null)) {
            ArrayList arrayList = objArr.f26561b.f26545e;
            if (!(arrayList == null || arrayList.isEmpty())) {
                int i = ((FeedbackMessage) arrayList.get(arrayList.size() - 1)).f26552g;
                SharedPreferences sharedPreferences = this.f26593a.getSharedPreferences("net.hockeyapp.android.feedback", 0);
                if (this.f26596d.equals("send")) {
                    sharedPreferences.edit().putInt("idLastMessageSend", i).putInt("idLastMessageProcessed", i).apply();
                } else if (this.f26596d.equals("fetch")) {
                    int i2 = sharedPreferences.getInt("idLastMessageSend", -1);
                    int i3 = sharedPreferences.getInt("idLastMessageProcessed", -1);
                    if (!(i == i2 || i == i3)) {
                        sharedPreferences.edit().putInt("idLastMessageProcessed", i).apply();
                        FeedbackManagerListener a = FeedbackManager.m28168a();
                        if (!((a != null ? a.m28172b() : false) || this.f26597e == null)) {
                            Context context = this.f26593a;
                            String str = this.f26597e;
                            if (FeedbackManager.m28168a() != null) {
                                FeedbackManager.m28168a();
                                cls = FeedbackManagerListener.m28171a();
                            }
                            if (cls == null) {
                                cls = FeedbackActivity.class;
                            }
                            int identifier = context.getResources().getIdentifier("ic_menu_refresh", "drawable", "android");
                            Intent intent = new Intent();
                            intent.setFlags(805306368);
                            intent.setClass(context, cls);
                            intent.putExtra(UpdateFragment.FRAGMENT_URL, str);
                            Util.m28236a(context, Util.m28231a(context, PendingIntent.getActivity(context, 0, intent, 1073741824), context.getString(C2158R.string.hockeyapp_feedback_notification_title), context.getString(C2158R.string.hockeyapp_feedback_new_answer_notification_message), identifier, "net.hockeyapp.android.NOTIFICATION"), "net.hockeyapp.android.NOTIFICATION", context.getString(C2158R.string.hockeyapp_feedback_notification_channel));
                        }
                    }
                }
            }
        }
        return objArr;
    }
}
