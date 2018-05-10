package com.reddit.frontpage.util;

import android.content.Context;
import android.net.Uri;
import android.support.v4.util.LruCache;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.job.DeleteCommentJob;
import com.reddit.datalibrary.frontpage.job.EditCommentJob;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import com.reddit.datalibrary.frontpage.job.SaveJobs.Save;
import com.reddit.datalibrary.frontpage.job.SaveJobs.Unsave;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.SharePiggyback;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;

public class CommentUtil {
    public static final EventLruCache<String, Boolean> f21706a = new C23771();
    private static final LruCache<String, Boolean> f21707b = new LruCache(20);

    static class C23771 extends EventLruCache<String, Boolean> {
        C23771() {
            super(50);
        }

        public final /* synthetic */ Object createEvent(Object obj) {
            return new Object();
        }
    }

    public static String m23666a(Link link, Comment comment) {
        link = String.format(Util.m24027f((int) C1761R.string.fmt_permalink_base), new Object[]{link.getPermalink()});
        return Uri.parse(link).buildUpon().appendPath(comment.getId()).build().toString();
    }

    public static void m23669a(Session session, String str, String str2, String str3) {
        if (session.isAnonymous() == null) {
            RedditJobManager.a().a(new EditCommentJob(str, str2, str3));
        }
    }

    public static void m23668a(Session session, Comment comment) {
        if (!session.isAnonymous()) {
            f21706a.putAndNotify(comment.getName(), Boolean.TRUE);
            RedditJobManager.a().a(new Save(session, comment.getName()));
        }
    }

    public static void m23670b(Session session, Comment comment) {
        if (!session.isAnonymous()) {
            f21706a.putAndNotify(comment.getName(), Boolean.FALSE);
            RedditJobManager.a().a(new Unsave(session, comment.getName()));
        }
    }

    public static boolean m23671b(Comment comment) {
        Boolean bool = (Boolean) f21706a.get(comment.getName());
        if (bool != null) {
            return bool.booleanValue();
        }
        return comment.saved;
    }

    public static Boolean m23664a(String str) {
        if (str == null) {
            return Boolean.valueOf(false);
        }
        Boolean bool = (Boolean) f21707b.get(str);
        return bool == null ? Boolean.valueOf(false) : bool;
    }

    public static void m23672c(Session session, Comment comment) {
        f21707b.put(comment.getId(), Boolean.valueOf(true));
        RedditJobManager.a().a(new DeleteCommentJob(session, comment));
    }

    public static void m23667a(Context context, Comment comment, String str) {
        String a;
        comment = comment.body;
        if (comment.length() > 50) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(comment.substring(0, 49));
            stringBuilder.append("...");
            comment = stringBuilder.toString();
        }
        str = LinkUtil.m23778a(str);
        AppConfiguration t = FrontpageSettings.a().t();
        if (t.g()) {
            SharePiggyback sharePiggyback = t.experiments.share_copy_link;
            a = Util.m23960a((int) C1761R.string.share_post_link_with_app_link, comment, str, sharePiggyback.copy, sharePiggyback.link);
        } else {
            a = Util.m23960a((int) C1761R.string.share_post_link, comment, str);
        }
        context.startActivity(IntentUtil.m23746a(context, a));
    }

    public static java.lang.String m23665a(com.reddit.datalibrary.frontpage.requests.models.v1.Comment r6) {
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
        r0 = r6.link_title;
        r1 = " ";
        r2 = "_";
        r0 = r0.replaceAll(r1, r2);
        r1 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0011 }
        r1 = com.reddit.frontpage.util.URLEncoder.m23942a(r0, r1);	 Catch:{ UnsupportedEncodingException -> 0x0011 }
        goto L_0x0019;
    L_0x0011:
        r1 = "[^A-Za-z0-9 ]";
        r2 = "";
        r1 = r0.replaceAll(r1, r2);
    L_0x0019:
        r0 = r6.link_id;
        r2 = "t3";
        r2 = r0.startsWith(r2);
        if (r2 == 0) goto L_0x002b;
    L_0x0023:
        r2 = "t3_";
        r3 = "";
        r0 = r0.replace(r2, r3);
    L_0x002b:
        r2 = 2131886499; // 0x7f1201a3 float:1.9407579E38 double:1.05329188E-314;
        r3 = 4;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = r6.subreddit;
        r3[r4] = r5;
        r4 = 1;
        r3[r4] = r0;
        r0 = 2;
        r3[r0] = r1;
        r0 = 3;
        r6 = r6.getId();
        r3[r0] = r6;
        r6 = com.reddit.frontpage.util.Util.m23960a(r2, r3);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.util.CommentUtil.a(com.reddit.datalibrary.frontpage.requests.models.v1.Comment):java.lang.String");
    }
}
