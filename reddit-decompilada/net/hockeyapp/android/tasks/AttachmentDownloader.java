package net.hockeyapp.android.tasks;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import net.hockeyapp.android.C2158R;
import net.hockeyapp.android.Constants;
import net.hockeyapp.android.objects.FeedbackAttachment;
import net.hockeyapp.android.utils.AsyncTaskUtils;
import net.hockeyapp.android.utils.HockeyLog;
import net.hockeyapp.android.utils.ImageUtils;
import net.hockeyapp.android.views.AttachmentView;

public class AttachmentDownloader {
    public Queue<DownloadJob> f26581a;
    private boolean f26582b;
    private final Handler f26583c;

    private static class AttachmentDownloaderHolder {
        static final AttachmentDownloader f26568a = new AttachmentDownloader();
    }

    private static class DownloadHandler extends Handler {
        private final AttachmentDownloader f26571a;

        DownloadHandler(AttachmentDownloader attachmentDownloader) {
            this.f26571a = attachmentDownloader;
        }

        public void handleMessage(Message message) {
            final DownloadJob downloadJob = (DownloadJob) this.f26571a.f26581a.poll();
            if (!downloadJob.f26574c) {
                int i = 1;
                int i2 = downloadJob.f26575d - 1;
                downloadJob.f26575d = i2;
                if (i2 < 0) {
                    i = 0;
                }
                if (i != 0) {
                    postDelayed(new Runnable(this) {
                        final /* synthetic */ DownloadHandler f26570b;

                        public void run() {
                            this.f26570b.f26571a.f26581a.add(downloadJob);
                            this.f26570b.f26571a.m28193b();
                        }
                    }, 3000);
                }
            }
            this.f26571a.f26582b = false;
            this.f26571a.m28193b();
        }
    }

    private static class DownloadJob {
        final FeedbackAttachment f26572a;
        final AttachmentView f26573b;
        boolean f26574c;
        int f26575d;

        private DownloadJob(FeedbackAttachment feedbackAttachment, AttachmentView attachmentView) {
            this.f26572a = feedbackAttachment;
            this.f26573b = attachmentView;
            this.f26574c = null;
            this.f26575d = 2;
        }
    }

    @SuppressLint({"StaticFieldLeak"})
    private static class DownloadTask extends AsyncTask<Void, Integer, Boolean> {
        private final DownloadJob f26576a;
        private final Handler f26577b;
        private final Context f26578c;
        private Bitmap f26579d = null;
        private int f26580e = 1;

        protected void onPreExecute() {
        }

        protected /* bridge */ /* synthetic */ void onProgressUpdate(Object[] objArr) {
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m28186a();
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            Boolean bool = (Boolean) obj;
            AttachmentView attachmentView = this.f26576a.f26573b;
            this.f26576a.f26574c = bool.booleanValue();
            boolean z = true;
            if (bool.booleanValue() != null) {
                Bitmap bitmap = this.f26579d;
                int i = this.f26580e;
                attachmentView.f26638d.setText(attachmentView.f26637c);
                attachmentView.f26638d.setContentDescription(attachmentView.f26638d.getText());
                attachmentView.f26639e = i;
                if (bitmap == null) {
                    attachmentView.m28261a(true);
                } else {
                    attachmentView.m28260a(bitmap, true);
                }
            } else {
                if (this.f26576a.f26575d <= null) {
                    z = false;
                }
                if (!z) {
                    attachmentView.f26638d.setText(C2158R.string.hockeyapp_feedback_attachment_error);
                    attachmentView.f26638d.setContentDescription(attachmentView.f26638d.getText());
                }
            }
            this.f26577b.sendEmptyMessage(0);
        }

        DownloadTask(DownloadJob downloadJob, Handler handler) {
            this.f26576a = downloadJob;
            this.f26577b = handler;
            this.f26578c = downloadJob.f26573b.getContext();
        }

        private Boolean m28186a() {
            FeedbackAttachment feedbackAttachment = this.f26576a.f26572a;
            File file = new File(Constants.m28152b(this.f26578c), feedbackAttachment.getCacheId());
            if (file.exists()) {
                HockeyLog.m28209c("Cached...");
                m28187a(file);
                return Boolean.valueOf(true);
            }
            HockeyLog.m28209c("Downloading...");
            boolean a = m28188a(feedbackAttachment.getUrl(), file);
            if (a) {
                m28187a(file);
            }
            return Boolean.valueOf(a);
        }

        private void m28187a(File file) {
            try {
                AttachmentView attachmentView = this.f26576a.f26573b;
                this.f26580e = ImageUtils.m28218a(file);
                this.f26579d = ImageUtils.m28221a(file, this.f26580e == 0 ? attachmentView.getWidthLandscape() : attachmentView.getWidthPortrait(), this.f26580e == 0 ? attachmentView.getMaxHeightLandscape() : attachmentView.getMaxHeightPortrait());
            } catch (Throwable e) {
                HockeyLog.m28206a("Failed to load image thumbnail", e);
                this.f26579d = null;
            }
        }

        private boolean m28188a(java.lang.String r19, java.io.File r20) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r18 = this;
            r1 = r20;
            r2 = 0;
            r3 = 0;
            r4 = new java.net.URL;	 Catch:{ IOException -> 0x00ae, all -> 0x00a7 }
            r5 = r19;	 Catch:{ IOException -> 0x00ae, all -> 0x00a7 }
            r4.<init>(r5);	 Catch:{ IOException -> 0x00ae, all -> 0x00a7 }
            r4 = r4.openConnection();	 Catch:{ IOException -> 0x00ae, all -> 0x00a7 }
            r4 = (java.net.HttpURLConnection) r4;	 Catch:{ IOException -> 0x00ae, all -> 0x00a7 }
            r5 = "User-Agent";	 Catch:{ IOException -> 0x00ae, all -> 0x00a7 }
            r6 = "HockeySDK/Android 5.1.0";	 Catch:{ IOException -> 0x00ae, all -> 0x00a7 }
            r4.addRequestProperty(r5, r6);	 Catch:{ IOException -> 0x00ae, all -> 0x00a7 }
            r5 = 1;	 Catch:{ IOException -> 0x00ae, all -> 0x00a7 }
            r4.setInstanceFollowRedirects(r5);	 Catch:{ IOException -> 0x00ae, all -> 0x00a7 }
            r4 = (java.net.HttpURLConnection) r4;	 Catch:{ IOException -> 0x00ae, all -> 0x00a7 }
            r4.connect();	 Catch:{ IOException -> 0x00a2, all -> 0x009c }
            r6 = r4.getContentLength();	 Catch:{ IOException -> 0x00a2, all -> 0x009c }
            r7 = "Status";	 Catch:{ IOException -> 0x00a2, all -> 0x009c }
            r7 = r4.getHeaderField(r7);	 Catch:{ IOException -> 0x00a2, all -> 0x009c }
            if (r7 == 0) goto L_0x003b;	 Catch:{ IOException -> 0x00a2, all -> 0x009c }
        L_0x002d:
            r8 = "200";	 Catch:{ IOException -> 0x00a2, all -> 0x009c }
            r7 = r7.startsWith(r8);	 Catch:{ IOException -> 0x00a2, all -> 0x009c }
            if (r7 != 0) goto L_0x003b;
        L_0x0035:
            if (r4 == 0) goto L_0x003a;
        L_0x0037:
            r4.disconnect();
        L_0x003a:
            return r3;
        L_0x003b:
            r7 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x00a2, all -> 0x009c }
            r8 = r4.getInputStream();	 Catch:{ IOException -> 0x00a2, all -> 0x009c }
            r7.<init>(r8);	 Catch:{ IOException -> 0x00a2, all -> 0x009c }
            r8 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0097, all -> 0x0092 }
            r8.<init>(r1);	 Catch:{ IOException -> 0x0097, all -> 0x0092 }
            r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
            r2 = new byte[r2];	 Catch:{ IOException -> 0x008e, all -> 0x008a }
            r11 = 0;	 Catch:{ IOException -> 0x008e, all -> 0x008a }
        L_0x004f:
            r13 = r7.read(r2);	 Catch:{ IOException -> 0x008e, all -> 0x008a }
            r14 = -1;	 Catch:{ IOException -> 0x008e, all -> 0x008a }
            if (r13 == r14) goto L_0x0070;	 Catch:{ IOException -> 0x008e, all -> 0x008a }
        L_0x0056:
            r14 = (long) r13;	 Catch:{ IOException -> 0x008e, all -> 0x008a }
            r11 = r11 + r14;	 Catch:{ IOException -> 0x008e, all -> 0x008a }
            r14 = new java.lang.Integer[r5];	 Catch:{ IOException -> 0x008e, all -> 0x008a }
            r15 = 100;	 Catch:{ IOException -> 0x008e, all -> 0x008a }
            r15 = r15 * r11;	 Catch:{ IOException -> 0x008e, all -> 0x008a }
            r9 = (long) r6;	 Catch:{ IOException -> 0x008e, all -> 0x008a }
            r9 = r15 / r9;	 Catch:{ IOException -> 0x008e, all -> 0x008a }
            r9 = (int) r9;	 Catch:{ IOException -> 0x008e, all -> 0x008a }
            r9 = java.lang.Integer.valueOf(r9);	 Catch:{ IOException -> 0x008e, all -> 0x008a }
            r14[r3] = r9;	 Catch:{ IOException -> 0x008e, all -> 0x008a }
            r9 = r18;
            r9.publishProgress(r14);	 Catch:{ IOException -> 0x0088 }
            r8.write(r2, r3, r13);	 Catch:{ IOException -> 0x0088 }
            goto L_0x004f;	 Catch:{ IOException -> 0x0088 }
        L_0x0070:
            r9 = r18;	 Catch:{ IOException -> 0x0088 }
            r8.flush();	 Catch:{ IOException -> 0x0088 }
            r13 = 0;
            r1 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1));
            if (r1 <= 0) goto L_0x007c;
        L_0x007b:
            r3 = r5;
        L_0x007c:
            r8.close();	 Catch:{ IOException -> 0x0082 }
            r7.close();	 Catch:{ IOException -> 0x0082 }
        L_0x0082:
            if (r4 == 0) goto L_0x0087;
        L_0x0084:
            r4.disconnect();
        L_0x0087:
            return r3;
        L_0x0088:
            r0 = move-exception;
            goto L_0x00b4;
        L_0x008a:
            r0 = move-exception;
            r9 = r18;
            goto L_0x00d7;
        L_0x008e:
            r0 = move-exception;
            r9 = r18;
            goto L_0x00b4;
        L_0x0092:
            r0 = move-exception;
            r9 = r18;
            r1 = r0;
            goto L_0x00d9;
        L_0x0097:
            r0 = move-exception;
            r9 = r18;
            r8 = r2;
            goto L_0x00b4;
        L_0x009c:
            r0 = move-exception;
            r9 = r18;
            r1 = r0;
            r7 = r2;
            goto L_0x00d9;
        L_0x00a2:
            r0 = move-exception;
            r9 = r18;
            r7 = r2;
            goto L_0x00b3;
        L_0x00a7:
            r0 = move-exception;
            r9 = r18;
            r1 = r0;
            r4 = r2;
            r7 = r4;
            goto L_0x00d9;
        L_0x00ae:
            r0 = move-exception;
            r9 = r18;
            r4 = r2;
            r7 = r4;
        L_0x00b3:
            r8 = r7;
        L_0x00b4:
            r2 = r0;
            r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d6 }
            r6 = "Failed to download attachment to ";	 Catch:{ all -> 0x00d6 }
            r5.<init>(r6);	 Catch:{ all -> 0x00d6 }
            r5.append(r1);	 Catch:{ all -> 0x00d6 }
            r1 = r5.toString();	 Catch:{ all -> 0x00d6 }
            net.hockeyapp.android.utils.HockeyLog.m28206a(r1, r2);	 Catch:{ all -> 0x00d6 }
            if (r8 == 0) goto L_0x00cb;
        L_0x00c8:
            r8.close();	 Catch:{ IOException -> 0x00d0 }
        L_0x00cb:
            if (r7 == 0) goto L_0x00d0;	 Catch:{ IOException -> 0x00d0 }
        L_0x00cd:
            r7.close();	 Catch:{ IOException -> 0x00d0 }
        L_0x00d0:
            if (r4 == 0) goto L_0x00d5;
        L_0x00d2:
            r4.disconnect();
        L_0x00d5:
            return r3;
        L_0x00d6:
            r0 = move-exception;
        L_0x00d7:
            r1 = r0;
            r2 = r8;
        L_0x00d9:
            if (r2 == 0) goto L_0x00de;
        L_0x00db:
            r2.close();	 Catch:{ IOException -> 0x00e3 }
        L_0x00de:
            if (r7 == 0) goto L_0x00e3;	 Catch:{ IOException -> 0x00e3 }
        L_0x00e0:
            r7.close();	 Catch:{ IOException -> 0x00e3 }
        L_0x00e3:
            if (r4 == 0) goto L_0x00e8;
        L_0x00e5:
            r4.disconnect();
        L_0x00e8:
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.tasks.AttachmentDownloader.DownloadTask.a(java.lang.String, java.io.File):boolean");
        }
    }

    public static AttachmentDownloader m28190a() {
        return AttachmentDownloaderHolder.f26568a;
    }

    private AttachmentDownloader() {
        this.f26583c = new DownloadHandler(this);
        this.f26581a = new LinkedList();
        this.f26582b = false;
    }

    public final void m28193b() {
        if (!this.f26582b) {
            DownloadJob downloadJob = (DownloadJob) this.f26581a.peek();
            if (downloadJob != null) {
                this.f26582b = true;
                AsyncTaskUtils.m28200a(new DownloadTask(downloadJob, this.f26583c));
            }
        }
    }
}
