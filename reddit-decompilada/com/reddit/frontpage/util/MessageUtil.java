package com.reddit.frontpage.util;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.common.base.Strings;
import com.reddit.datalibrary.frontpage.data.feature.inboxcount.InboxCountRepository;
import com.reddit.datalibrary.frontpage.job.MarkNotificationReadJob;
import com.reddit.datalibrary.frontpage.job.MarkReadJob;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Kind;
import com.reddit.datalibrary.frontpage.requests.models.v1.Message;
import com.reddit.datalibrary.frontpage.requests.models.v1.Notification;
import com.reddit.datalibrary.frontpage.service.api.ComposeService;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.inbox.MessageThread;
import java.util.ArrayList;
import timber.log.Timber;

public class MessageUtil {
    public static int m23813a(MessageThread messageThread) {
        if (messageThread.f21245c.m23360a(0).f21182a.getKind().equals(Kind.NOTIFICATION)) {
            return 4;
        }
        if (messageThread.f21243a.startsWith("t4_")) {
            return 0;
        }
        messageThread = m23821c(messageThread);
        if (messageThread == null) {
            return -1;
        }
        if (messageThread.equals("comment reply")) {
            return 1;
        }
        if (messageThread.equals("post reply")) {
            return 2;
        }
        if (messageThread.equals("username mention") != null) {
            return 3;
        }
        return -1;
    }

    public static Message m23819b(MessageThread messageThread) {
        return (Message) messageThread.f21245c.m23360a(messageThread.f21245c.f21186b.size() - 1).f21182a.getData();
    }

    private static java.lang.String m23821c(com.reddit.frontpage.ui.inbox.MessageThread r1) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = 0;
        r1 = r1.f21245c;	 Catch:{ Exception -> 0x0012 }
        r1 = r1.m23360a(r0);	 Catch:{ Exception -> 0x0012 }
        r1 = r1.f21182a;	 Catch:{ Exception -> 0x0012 }
        r1 = r1.getData();	 Catch:{ Exception -> 0x0012 }
        r1 = (com.reddit.datalibrary.frontpage.requests.models.v1.Message) r1;	 Catch:{ Exception -> 0x0012 }
        r1 = r1.subject;	 Catch:{ Exception -> 0x0012 }
        goto L_0x001a;
    L_0x0012:
        r1 = "Error: InboxFilterableListingProvider: no subject available";
        r0 = new java.lang.Object[r0];
        timber.log.Timber.e(r1, r0);
        r1 = 0;
    L_0x001a:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.util.MessageUtil.c(com.reddit.frontpage.ui.inbox.MessageThread):java.lang.String");
    }

    public static void m23816a(Context context, String str, String str2, String str3, String str4) {
        Intent intent = new Intent(context, ComposeService.class);
        intent.putExtra("request_id", str);
        intent.putExtra(ComposeService.EXTRA_TO, str2);
        intent.putExtra(ComposeService.EXTRA_SUBJECT, str3);
        intent.putExtra(ComposeService.EXTRA_TEXT, str4);
        context.startService(intent);
    }

    private static void m23815a(int i) {
        switch (i) {
            case 0:
                i = InboxCountRepository.a;
                InboxCountRepository.a();
                return;
            case 1:
                i = InboxCountRepository.a;
                InboxCountRepository.b();
                return;
            case 2:
                i = InboxCountRepository.a;
                InboxCountRepository.b();
                return;
            case 4:
                i = InboxCountRepository.a;
                InboxCountRepository.b();
                return;
            case 5:
                i = InboxCountRepository.a;
                InboxCountRepository.c();
                return;
            default:
                StringBuilder stringBuilder = new StringBuilder("Unknown message type: ");
                stringBuilder.append(i);
                Timber.e(stringBuilder.toString(), new Object[0]);
                return;
        }
    }

    public static String m23814a(Message message) {
        Object b = m23820b(message);
        CharSequence username = SessionManager.b().c.getUsername();
        if (!TextUtils.isEmpty(b) && !TextUtils.equals(b, username)) {
            return b;
        }
        if (message.dest.contains("#")) {
            return message.subreddit_name_prefixed;
        }
        return Util.m23960a((int) C1761R.string.fmt_u_name, message.dest);
    }

    public static void m23818a(Session session, Notification notification) {
        if (notification._new) {
            m23815a(4);
            RedditJobManager.a().a(new MarkNotificationReadJob(session, notification.getId()));
        }
    }

    public static void m23817a(Session session, Message message, int i) {
        if (message._new) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(message.getName());
            m23815a(i);
            RedditJobManager.a().a(new MarkReadJob(session, arrayList));
        }
    }

    public static String m23820b(Message message) {
        if (Strings.a(message.author)) {
            return message.subreddit_name_prefixed;
        }
        return Util.m23960a((int) C1761R.string.fmt_u_name, message.author);
    }
}
