package net.hockeyapp.android.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import net.hockeyapp.android.C2158R;
import net.hockeyapp.android.objects.FeedbackAttachment;
import net.hockeyapp.android.objects.FeedbackMessage;
import net.hockeyapp.android.tasks.AttachmentDownloader;
import net.hockeyapp.android.utils.HockeyLog;

public class FeedbackMessageView extends LinearLayout {
    private TextView f26648a = ((TextView) findViewById(C2158R.id.label_author));
    private TextView f26649b = ((TextView) findViewById(C2158R.id.label_date));
    private TextView f26650c = ((TextView) findViewById(C2158R.id.label_text));
    private AttachmentListView f26651d = ((AttachmentListView) findViewById(C2158R.id.list_attachments));
    private final Context f26652e;

    public FeedbackMessageView(Context context) {
        super(context, null);
        this.f26652e = context;
        LayoutInflater.from(context).inflate(C2158R.layout.hockeyapp_view_feedback_message, this);
    }

    public void setFeedbackMessage(FeedbackMessage feedbackMessage) {
        try {
            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(3, 3);
            Date parse = simpleDateFormat.parse(feedbackMessage.f26551f);
            this.f26649b.setText(dateTimeInstance.format(parse));
            this.f26649b.setContentDescription(dateTimeInstance.format(parse));
        } catch (Throwable e) {
            HockeyLog.m28206a("Failed to set feedback message", e);
        }
        this.f26648a.setText(feedbackMessage.f26557l);
        this.f26648a.setContentDescription(feedbackMessage.f26557l);
        this.f26650c.setText(feedbackMessage.f26547b);
        this.f26650c.setContentDescription(feedbackMessage.f26547b);
        this.f26651d.removeAllViews();
        for (FeedbackAttachment feedbackAttachment : feedbackMessage.f26559n) {
            View attachmentView = new AttachmentView(this.f26652e, this.f26651d, feedbackAttachment);
            AttachmentDownloader a = AttachmentDownloader.m28190a();
            a.f26581a.add(new DownloadJob(feedbackAttachment, attachmentView));
            a.m28193b();
            this.f26651d.addView(attachmentView);
        }
    }

    public void setIndex(int i) {
        if (i % 2 == 0) {
            setBackgroundColor(getResources().getColor(C2158R.color.hockeyapp_background_light));
        } else {
            setBackgroundColor(getResources().getColor(C2158R.color.hockeyapp_background_white));
        }
    }
}
