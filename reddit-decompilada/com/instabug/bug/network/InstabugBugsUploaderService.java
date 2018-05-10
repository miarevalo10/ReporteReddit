package com.instabug.bug.network;

import com.instabug.bug.cache.BugsCacheManager;
import com.instabug.bug.model.Bug;
import com.instabug.bug.model.Bug.BugState;
import com.instabug.library.network.InstabugNetworkBasedBackgroundService;
import com.instabug.library.network.Request.Callbacks;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.FileNotFoundException;
import org.json.JSONException;

public class InstabugBugsUploaderService extends InstabugNetworkBasedBackgroundService {
    private void m19362a(final Bug bug) {
        StringBuilder stringBuilder = new StringBuilder("START uploading all logs related to this bug id = ");
        stringBuilder.append(bug.getId());
        InstabugSDKLogger.m8356d(this, stringBuilder.toString());
        C0479a.m7775a().m7778c(this, bug, new Callbacks<Boolean, Bug>(this) {
            final /* synthetic */ InstabugBugsUploaderService f15326b;

            public /* synthetic */ void onFailed(Object obj) {
                InstabugSDKLogger.m8356d(this.f15326b, "Something went wrong while uploading bug logs");
            }

            public /* synthetic */ void onSucceeded(Object obj) {
                InstabugSDKLogger.m8356d(this.f15326b, "Bug logs uploaded successfully, change its state");
                bug.f15315f = BugState.ATTACHMENTS_READY_TO_BE_UPLOADED;
                BugsCacheManager.saveCacheToDisk();
                try {
                    this.f15326b.m19364b(bug);
                } catch (Object obj2) {
                    InstabugBugsUploaderService instabugBugsUploaderService = this.f15326b;
                    StringBuilder stringBuilder = new StringBuilder("Something went wrong while uploading bug attachments e: ");
                    stringBuilder.append(obj2.getMessage());
                    InstabugSDKLogger.m8357e(instabugBugsUploaderService, stringBuilder.toString());
                }
            }
        });
    }

    private void m19364b(final Bug bug) throws JSONException, FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder("Found ");
        stringBuilder.append(bug.f15314e.size());
        stringBuilder.append(" attachments related to bug: ");
        stringBuilder.append(bug.f15313d);
        InstabugSDKLogger.m8356d(this, stringBuilder.toString());
        C0479a.m7775a().m7777b(this, bug, new Callbacks<Boolean, Bug>(this) {
            final /* synthetic */ InstabugBugsUploaderService f15328b;

            public /* synthetic */ void onFailed(Object obj) {
                InstabugSDKLogger.m8356d(this.f15328b, "Something went wrong while uploading bug attachments");
            }

            public /* synthetic */ void onSucceeded(Object obj) {
                InstabugSDKLogger.m8356d(this.f15328b, "Bug attachments uploaded successfully, deleting bug");
                BugsCacheManager.deleteBug(bug.getId());
                BugsCacheManager.saveCacheToDisk();
            }
        });
    }

    protected void runBackgroundTask() throws Exception {
        StringBuilder stringBuilder = new StringBuilder("Found ");
        stringBuilder.append(BugsCacheManager.getBugs().size());
        stringBuilder.append(" bugs in cache");
        InstabugSDKLogger.m8356d(this, stringBuilder.toString());
        for (final Bug bug : BugsCacheManager.getBugs()) {
            StringBuilder stringBuilder2;
            if (bug.f15315f.equals(BugState.READY_TO_BE_SENT)) {
                stringBuilder2 = new StringBuilder("Uploading bug: ");
                stringBuilder2.append(bug.toString());
                InstabugSDKLogger.m8356d(this, stringBuilder2.toString());
                C0479a.m7775a().m7776a(this, bug, new Callbacks<String, Throwable>(this) {
                    final /* synthetic */ InstabugBugsUploaderService f15324b;

                    public /* synthetic */ void onSucceeded(Object obj) {
                        String str = (String) obj;
                        InstabugBugsUploaderService instabugBugsUploaderService = this.f15324b;
                        StringBuilder stringBuilder = new StringBuilder("Bug uploaded successfully, setting bug TemporaryServerToken equal ");
                        stringBuilder.append(str);
                        InstabugSDKLogger.m8356d(instabugBugsUploaderService, stringBuilder.toString());
                        bug.f15311b = str;
                        bug.f15315f = BugState.LOGS_READY_TO_BE_UPLOADED;
                        BugsCacheManager.saveCacheToDisk();
                        this.f15324b.m19362a(bug);
                    }

                    public /* synthetic */ void onFailed(Object obj) {
                        InstabugSDKLogger.m8356d(this.f15324b, "Something went wrong while uploading bug");
                    }
                });
            } else if (bug.f15315f.equals(BugState.LOGS_READY_TO_BE_UPLOADED)) {
                stringBuilder2 = new StringBuilder("Bug: ");
                stringBuilder2.append(bug.toString());
                stringBuilder2.append(" already uploaded but has unsent logs, uploading now");
                InstabugSDKLogger.m8356d(this, stringBuilder2.toString());
                m19362a(bug);
            } else if (bug.f15315f.equals(BugState.ATTACHMENTS_READY_TO_BE_UPLOADED)) {
                stringBuilder2 = new StringBuilder("Bug: ");
                stringBuilder2.append(bug.toString());
                stringBuilder2.append(" already uploaded but has unsent attachments, uploading now");
                InstabugSDKLogger.m8356d(this, stringBuilder2.toString());
                m19364b(bug);
            }
        }
    }
}
