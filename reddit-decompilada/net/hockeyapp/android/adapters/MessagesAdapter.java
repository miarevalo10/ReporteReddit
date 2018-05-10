package net.hockeyapp.android.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import net.hockeyapp.android.objects.FeedbackMessage;
import net.hockeyapp.android.views.FeedbackMessageView;

public class MessagesAdapter extends BaseAdapter {
    public ArrayList<FeedbackMessage> f26538a;
    private Context f26539b;

    public long getItemId(int i) {
        return (long) i;
    }

    public MessagesAdapter(Context context, ArrayList<FeedbackMessage> arrayList) {
        this.f26539b = context;
        this.f26538a = arrayList;
    }

    public int getCount() {
        return this.f26538a.size();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        FeedbackMessage feedbackMessage = (FeedbackMessage) this.f26538a.get(i);
        if (view == null) {
            view = new FeedbackMessageView(this.f26539b);
        } else {
            view = (FeedbackMessageView) view;
        }
        if (feedbackMessage != null) {
            view.setFeedbackMessage(feedbackMessage);
        }
        view.setIndex(i);
        return view;
    }

    public Object getItem(int i) {
        return this.f26538a.get(i);
    }
}
