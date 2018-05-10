package com.reddit.frontpage.ui.submit;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import com.reddit.datalibrary.frontpage.job.EditCommentJob.CancelEvent;
import com.reddit.datalibrary.frontpage.job.EditCommentJob.ResultEvent;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentEditResponse.CommentEditList;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentWrapper;
import com.reddit.frontpage.BaseActivity;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.CommentUtil;
import com.reddit.frontpage.util.ViewUtils;

public class CommentEditFragmentLegacy extends EditFragmentLegacy {
    public final int mo7468b() {
        return C1761R.string.title_edit_comment;
    }

    public static CommentEditFragmentLegacy m41077a(Comment comment) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("comment", comment);
        comment = new CommentEditFragmentLegacy();
        comment.setArguments(bundle);
        return comment;
    }

    public final String mo7467a() {
        Comment comment = (Comment) getArguments().getSerializable("comment");
        return comment != null ? comment.body : "";
    }

    public final void mo7469c() {
        String name;
        Session session = SessionManager.b().c;
        Comment comment = (Comment) getArguments().getSerializable("comment");
        if (comment != null) {
            name = comment.getName();
        } else {
            name = "";
        }
        CommentUtil.m23669a(session, name, this.a.getText().toString(), this.editIdentifier);
    }

    public void onEventMainThread(ResultEvent resultEvent) {
        if (TextUtils.equals(resultEvent.a, this.editIdentifier)) {
            this.b.dismiss();
            if (resultEvent.b.a()) {
                Snackbar.a(this.e, resultEvent.b.b(), -1).a();
                return;
            }
            BaseActivity baseActivity = (BaseActivity) getActivity();
            if (baseActivity != null) {
                CommentWrapper commentWrapper = (CommentWrapper) ((CommentEditList) resultEvent.b.json.data).things.get(0);
                Bundle bundle = new Bundle();
                bundle.putSerializable("comment", commentWrapper);
                resultEvent = new Intent();
                resultEvent.putExtra("comment_bundle", bundle);
                baseActivity.setResult(-1, resultEvent);
                baseActivity.finish();
            }
        }
    }

    public void onEventMainThread(CancelEvent cancelEvent) {
        if (TextUtils.equals(cancelEvent.a, this.editIdentifier) != null) {
            this.b.dismiss();
            ViewUtils.m24059a(this.e, (int) C1761R.string.error_network_error, -1).a();
        }
    }

    protected final boolean mo7470d() {
        return !TextUtils.isEmpty(this.a.getText().toString().trim());
    }
}
