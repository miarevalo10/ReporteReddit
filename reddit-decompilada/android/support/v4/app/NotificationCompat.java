package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RemoteViews;
import com.google.android.gms.ads.AdRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NotificationCompat {

    public static class Action {
        final Bundle f1098a;
        final RemoteInput[] f1099b;
        final RemoteInput[] f1100c;
        boolean f1101d;
        public int f1102e;
        public CharSequence f1103f;
        public PendingIntent f1104g;

        public static final class Builder {
            private final int f1092a;
            private final CharSequence f1093b;
            private final PendingIntent f1094c;
            private boolean f1095d;
            private final Bundle f1096e;
            private ArrayList<RemoteInput> f1097f;

            public Builder(int i, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i, charSequence, pendingIntent, new Bundle());
            }

            private Builder(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
                this.f1095d = true;
                this.f1092a = i;
                this.f1093b = Builder.m672d(charSequence);
                this.f1094c = pendingIntent;
                this.f1096e = bundle;
                this.f1097f = 0;
                this.f1095d = true;
            }

            public final Action m671a() {
                RemoteInput[] remoteInputArr;
                List arrayList = new ArrayList();
                List arrayList2 = new ArrayList();
                if (this.f1097f != null) {
                    Iterator it = this.f1097f.iterator();
                    while (it.hasNext()) {
                        RemoteInput remoteInput = (RemoteInput) it.next();
                        Object obj = (remoteInput.f11401d || (!(remoteInput.f11400c == null || remoteInput.f11400c.length == 0) || remoteInput.f11403f == null || remoteInput.f11403f.isEmpty())) ? null : 1;
                        if (obj != null) {
                            arrayList.add(remoteInput);
                        } else {
                            arrayList2.add(remoteInput);
                        }
                    }
                }
                RemoteInput[] remoteInputArr2 = null;
                if (arrayList.isEmpty()) {
                    remoteInputArr = null;
                } else {
                    remoteInputArr = (RemoteInput[]) arrayList.toArray(new RemoteInput[arrayList.size()]);
                }
                if (!arrayList2.isEmpty()) {
                    remoteInputArr2 = (RemoteInput[]) arrayList2.toArray(new RemoteInput[arrayList2.size()]);
                }
                return new Action(this.f1092a, this.f1093b, this.f1094c, this.f1096e, remoteInputArr2, remoteInputArr, this.f1095d);
            }
        }

        Action(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, RemoteInput[] remoteInputArr2, boolean z) {
            this.f1102e = i;
            this.f1103f = Builder.m672d(charSequence);
            this.f1104g = pendingIntent;
            if (bundle == null) {
                bundle = new Bundle();
            }
            this.f1098a = bundle;
            this.f1099b = remoteInputArr;
            this.f1100c = remoteInputArr2;
            this.f1101d = z;
        }
    }

    public static class Builder {
        Bundle f1105A;
        public int f1106B;
        int f1107C;
        Notification f1108D;
        RemoteViews f1109E;
        RemoteViews f1110F;
        RemoteViews f1111G;
        public String f1112H;
        int f1113I;
        String f1114J;
        long f1115K;
        int f1116L;
        public Notification f1117M;
        @Deprecated
        public ArrayList<String> f1118N;
        public Context f1119a;
        public ArrayList<Action> f1120b;
        CharSequence f1121c;
        CharSequence f1122d;
        public PendingIntent f1123e;
        PendingIntent f1124f;
        RemoteViews f1125g;
        public Bitmap f1126h;
        CharSequence f1127i;
        public int f1128j;
        public int f1129k;
        boolean f1130l;
        boolean f1131m;
        Style f1132n;
        CharSequence f1133o;
        CharSequence[] f1134p;
        int f1135q;
        int f1136r;
        boolean f1137s;
        public String f1138t;
        public boolean f1139u;
        String f1140v;
        public boolean f1141w;
        boolean f1142x;
        boolean f1143y;
        public String f1144z;

        public final void m681a(int r1, boolean r2) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: android.support.v4.app.NotificationCompat.Builder.a(int, boolean):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-int
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 6 more
*/
            /*
            // Can't load method instructions.
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.NotificationCompat.Builder.a(int, boolean):void");
        }

        public Builder(Context context, String str) {
            this.f1120b = new ArrayList();
            this.f1130l = true;
            this.f1141w = false;
            this.f1106B = 0;
            this.f1107C = 0;
            this.f1113I = 0;
            this.f1116L = 0;
            this.f1117M = new Notification();
            this.f1119a = context;
            this.f1112H = str;
            this.f1117M.when = System.currentTimeMillis();
            this.f1117M.audioStreamType = -1;
            this.f1129k = 0;
            this.f1118N = new ArrayList();
        }

        @Deprecated
        public Builder(Context context) {
            this(context, null);
        }

        public final Builder m674a(int i) {
            this.f1117M.icon = i;
            return this;
        }

        public final Builder m679a(CharSequence charSequence) {
            this.f1121c = m672d(charSequence);
            return this;
        }

        public final Builder m682b(CharSequence charSequence) {
            this.f1122d = m672d(charSequence);
            return this;
        }

        public final Builder m675a(int i, int i2, boolean z) {
            this.f1135q = i;
            this.f1136r = i2;
            this.f1137s = z;
            return this;
        }

        public final Builder m683c(CharSequence charSequence) {
            this.f1117M.tickerText = m672d(charSequence);
            return this;
        }

        public final Builder m676a(Uri uri) {
            this.f1117M.sound = uri;
            this.f1117M.audioStreamType = -1;
            return this;
        }

        public final Builder m680a(boolean z) {
            m681a(16, z);
            return this;
        }

        public final Builder m677a(Action action) {
            this.f1120b.add(action);
            return this;
        }

        public final Builder m678a(Style style) {
            if (this.f1132n != style) {
                this.f1132n = style;
                if (this.f1132n != null) {
                    this.f1132n.m685a(this);
                }
            }
            return this;
        }

        public final Notification m673a() {
            Notification build;
            NotificationBuilderWithBuilderAccessor notificationCompatBuilder = new NotificationCompatBuilder(this);
            Style style = notificationCompatBuilder.f11383b.f1132n;
            if (style != null) {
                style.mo255a(notificationCompatBuilder);
            }
            if (VERSION.SDK_INT >= 26) {
                build = notificationCompatBuilder.f11382a.build();
            } else if (VERSION.SDK_INT >= 24) {
                build = notificationCompatBuilder.f11382a.build();
                if (notificationCompatBuilder.f11388g != 0) {
                    if (!(build.getGroup() == null || (build.flags & AdRequest.MAX_CONTENT_URL_LENGTH) == 0 || notificationCompatBuilder.f11388g != 2)) {
                        NotificationCompatBuilder.m9998a(build);
                    }
                    if (build.getGroup() != null && (build.flags & AdRequest.MAX_CONTENT_URL_LENGTH) == 0 && notificationCompatBuilder.f11388g == 1) {
                        NotificationCompatBuilder.m9998a(build);
                    }
                }
            } else if (VERSION.SDK_INT >= 21) {
                notificationCompatBuilder.f11382a.setExtras(notificationCompatBuilder.f11387f);
                build = notificationCompatBuilder.f11382a.build();
                if (notificationCompatBuilder.f11384c != null) {
                    build.contentView = notificationCompatBuilder.f11384c;
                }
                if (notificationCompatBuilder.f11385d != null) {
                    build.bigContentView = notificationCompatBuilder.f11385d;
                }
                if (notificationCompatBuilder.f11389h != null) {
                    build.headsUpContentView = notificationCompatBuilder.f11389h;
                }
                if (notificationCompatBuilder.f11388g != 0) {
                    if (!(build.getGroup() == null || (build.flags & AdRequest.MAX_CONTENT_URL_LENGTH) == 0 || notificationCompatBuilder.f11388g != 2)) {
                        NotificationCompatBuilder.m9998a(build);
                    }
                    if (build.getGroup() != null && (build.flags & AdRequest.MAX_CONTENT_URL_LENGTH) == 0 && notificationCompatBuilder.f11388g == 1) {
                        NotificationCompatBuilder.m9998a(build);
                    }
                }
            } else if (VERSION.SDK_INT >= 20) {
                notificationCompatBuilder.f11382a.setExtras(notificationCompatBuilder.f11387f);
                build = notificationCompatBuilder.f11382a.build();
                if (notificationCompatBuilder.f11384c != null) {
                    build.contentView = notificationCompatBuilder.f11384c;
                }
                if (notificationCompatBuilder.f11385d != null) {
                    build.bigContentView = notificationCompatBuilder.f11385d;
                }
                if (notificationCompatBuilder.f11388g != 0) {
                    if (!(build.getGroup() == null || (build.flags & AdRequest.MAX_CONTENT_URL_LENGTH) == 0 || notificationCompatBuilder.f11388g != 2)) {
                        NotificationCompatBuilder.m9998a(build);
                    }
                    if (build.getGroup() != null && (build.flags & AdRequest.MAX_CONTENT_URL_LENGTH) == 0 && notificationCompatBuilder.f11388g == 1) {
                        NotificationCompatBuilder.m9998a(build);
                    }
                }
            } else if (VERSION.SDK_INT >= 19) {
                SparseArray a = NotificationCompatJellybean.m689a(notificationCompatBuilder.f11386e);
                if (a != null) {
                    notificationCompatBuilder.f11387f.putSparseParcelableArray("android.support.actionExtras", a);
                }
                notificationCompatBuilder.f11382a.setExtras(notificationCompatBuilder.f11387f);
                build = notificationCompatBuilder.f11382a.build();
                if (notificationCompatBuilder.f11384c != null) {
                    build.contentView = notificationCompatBuilder.f11384c;
                }
                if (notificationCompatBuilder.f11385d != null) {
                    build.bigContentView = notificationCompatBuilder.f11385d;
                }
            } else if (VERSION.SDK_INT >= 16) {
                build = notificationCompatBuilder.f11382a.build();
                Bundle a2 = NotificationCompat.m686a(build);
                Bundle bundle = new Bundle(notificationCompatBuilder.f11387f);
                for (String str : notificationCompatBuilder.f11387f.keySet()) {
                    if (a2.containsKey(str)) {
                        bundle.remove(str);
                    }
                }
                a2.putAll(bundle);
                SparseArray a3 = NotificationCompatJellybean.m689a(notificationCompatBuilder.f11386e);
                if (a3 != null) {
                    NotificationCompat.m686a(build).putSparseParcelableArray("android.support.actionExtras", a3);
                }
                if (notificationCompatBuilder.f11384c != null) {
                    build.contentView = notificationCompatBuilder.f11384c;
                }
                if (notificationCompatBuilder.f11385d != null) {
                    build.bigContentView = notificationCompatBuilder.f11385d;
                }
            } else {
                build = notificationCompatBuilder.f11382a.getNotification();
            }
            if (notificationCompatBuilder.f11383b.f1109E != null) {
                build.contentView = notificationCompatBuilder.f11383b.f1109E;
            }
            int i = VERSION.SDK_INT;
            i = VERSION.SDK_INT;
            if (VERSION.SDK_INT >= 16 && style != null) {
                NotificationCompat.m686a(build);
            }
            return build;
        }

        protected static CharSequence m672d(CharSequence charSequence) {
            if (charSequence == null) {
                return charSequence;
            }
            if (charSequence.length() > 5120) {
                charSequence = charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }
    }

    public static abstract class Style {
        protected Builder f1145b;
        CharSequence f1146c;
        CharSequence f1147d;
        boolean f1148e = false;

        public void mo255a(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        }

        public final void m685a(Builder builder) {
            if (this.f1145b != builder) {
                this.f1145b = builder;
                if (this.f1145b != null) {
                    this.f1145b.m678a(this);
                }
            }
        }
    }

    public static class BigPictureStyle extends Style {
        public Bitmap f11378a;
        private Bitmap f11379f;
        private boolean f11380g;

        public final void mo255a(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (VERSION.SDK_INT >= 16) {
                notificationBuilderWithBuilderAccessor = new android.app.Notification.BigPictureStyle(notificationBuilderWithBuilderAccessor.mo256a()).setBigContentTitle(this.c).bigPicture(this.f11378a);
                if (this.f11380g) {
                    notificationBuilderWithBuilderAccessor.bigLargeIcon(this.f11379f);
                }
                if (this.e) {
                    notificationBuilderWithBuilderAccessor.setSummaryText(this.d);
                }
            }
        }
    }

    public static class BigTextStyle extends Style {
        private CharSequence f11381a;

        public final BigTextStyle m9995a(CharSequence charSequence) {
            this.d = Builder.m672d(charSequence);
            this.e = true;
            return this;
        }

        public final BigTextStyle m9997b(CharSequence charSequence) {
            this.f11381a = Builder.m672d(charSequence);
            return this;
        }

        public final void mo255a(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (VERSION.SDK_INT >= 16) {
                notificationBuilderWithBuilderAccessor = new android.app.Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.mo256a()).setBigContentTitle(this.c).bigText(this.f11381a);
                if (this.e) {
                    notificationBuilderWithBuilderAccessor.setSummaryText(this.d);
                }
            }
        }
    }

    public static Bundle m686a(Notification notification) {
        if (VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        return VERSION.SDK_INT >= 16 ? NotificationCompatJellybean.m688a(notification) : null;
    }
}
