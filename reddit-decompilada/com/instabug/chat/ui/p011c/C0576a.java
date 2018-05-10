package com.instabug.chat.ui.p011c;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.instabug.chat.C0520R;
import com.instabug.chat.model.Attachment;
import com.instabug.chat.model.Chat;
import com.instabug.chat.model.Message;
import com.instabug.chat.model.Message.C0546a;
import com.instabug.chat.ui.view.CircularImageView;
import com.instabug.library.C0593R;
import com.instabug.library.internal.storage.cache.AssetsCacheManager;
import com.instabug.library.internal.storage.cache.AssetsCacheManager.OnDownloadFinished;
import com.instabug.library.model.AssetEntity;
import com.instabug.library.model.AssetEntity.AssetType;
import com.instabug.library.util.Colorizer;
import com.instabug.library.util.InstabugAppData;
import com.instabug.library.util.InstabugDateFormatter;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.FileInputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: ChatsAdapter */
class C0576a extends BaseAdapter {
    List<Chat> f9343a;
    private InstabugAppData f9344b;

    /* compiled from: ChatsAdapter */
    private static class C0575a {
        private final TextView f9337a;
        private final CircularImageView f9338b;
        private final TextView f9339c;
        private final TextView f9340d;
        private final TextView f9341e;
        private final LinearLayout f9342f;

        C0575a(View view) {
            this.f9342f = (LinearLayout) view.findViewById(C0520R.id.conversation_list_item_container);
            this.f9337a = (TextView) view.findViewById(C0520R.id.instabug_txt_message_sender);
            this.f9338b = (CircularImageView) view.findViewById(C0520R.id.instabug_message_sender_avatar);
            this.f9339c = (TextView) view.findViewById(C0520R.id.instabug_txt_message_time);
            this.f9341e = (TextView) view.findViewById(C0520R.id.instabug_unread_messages_count);
            this.f9340d = (TextView) view.findViewById(C0520R.id.instabug_txt_message_snippet);
        }
    }

    public /* synthetic */ Object getItem(int i) {
        return m7988a(i);
    }

    C0576a(Context context, List<Chat> list) {
        this.f9343a = list;
        this.f9344b = new InstabugAppData(context);
    }

    public int getCount() {
        return this.f9343a.size();
    }

    private Chat m7988a(int i) {
        return (Chat) this.f9343a.get(i);
    }

    public long getItemId(int i) {
        return (long) m7988a(i).getId().hashCode();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        CharSequence c;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(C0520R.layout.instabug_conversation_list_item, viewGroup, false);
            viewGroup = new C0575a(view);
            view.setTag(viewGroup);
        } else {
            viewGroup = (C0575a) view.getTag();
        }
        Context context = view.getContext();
        i = m7988a(i);
        StringBuilder stringBuilder = new StringBuilder("Binding chat ");
        stringBuilder.append(i);
        stringBuilder.append(" to view");
        InstabugSDKLogger.m8360v(this, stringBuilder.toString());
        Collections.sort(i.f15373a, new C0546a());
        Message e = i.m15276e();
        if (!(e == null || e.f15379c == null || TextUtils.isEmpty(e.f15379c.trim()))) {
            if (!e.f15379c.equals("null")) {
                viewGroup.f9340d.setText(e.f15379c);
                c = i.m15274c();
                if (c != null || c.equals("") || c.equals("null") || e.m15281a()) {
                    viewGroup.f9337a.setText(String.format(context.getString(C0593R.string.instabug_str_notification_title), new Object[]{this.f9344b.getAppName()}));
                } else {
                    stringBuilder = new StringBuilder("chat SenderName: ");
                    stringBuilder.append(c);
                    InstabugSDKLogger.m8360v(this, stringBuilder.toString());
                    viewGroup.f9337a.setText(c);
                }
                viewGroup.f9339c.setText(InstabugDateFormatter.formatConversationLastMessageDate(i.m15275d()));
                if (i.m15270a() == 0) {
                    TypedValue typedValue = new TypedValue();
                    context.getTheme().resolveAttribute(C0593R.attr.instabug_unread_message_background_color, typedValue, true);
                    viewGroup.f9342f.setBackgroundColor(typedValue.data);
                    viewGroup.f9341e.setBackgroundDrawable(Colorizer.getPrimaryColorTintedDrawable(ContextCompat.m714a(context, C0593R.drawable.instabug_bg_white_oval)));
                    viewGroup.f9341e.setText(String.valueOf(i.m15270a()));
                    viewGroup.f9341e.setVisibility(0);
                } else {
                    viewGroup.f9342f.setBackgroundColor(0);
                    viewGroup.f9341e.setVisibility(8);
                }
                if (i.m15273b() == null) {
                    AssetsCacheManager.getAssetEntity(context, AssetsCacheManager.createEmptyEntity(context, i.m15273b(), AssetType.IMAGE), new OnDownloadFinished(this) {
                        final /* synthetic */ C0576a f15416b;

                        public void onSuccess(AssetEntity assetEntity) {
                            StringBuilder stringBuilder = new StringBuilder("Asset Entity downloaded: ");
                            stringBuilder.append(assetEntity.getFile().getPath());
                            InstabugSDKLogger.m8356d(this, stringBuilder.toString());
                            try {
                                viewGroup.f9338b.setImageDrawable(null);
                                viewGroup.f9338b.setImageBitmap(BitmapFactory.decodeStream(new FileInputStream(assetEntity.getFile())));
                            } catch (AssetEntity assetEntity2) {
                                InstabugSDKLogger.m8358e(this, "Asset Entity downloading got FileNotFoundException error", assetEntity2);
                            }
                        }

                        public void onFailed(Throwable th) {
                            InstabugSDKLogger.m8358e(this, "Asset Entity downloading got error", th);
                        }
                    });
                } else {
                    viewGroup.f9338b.setImageResource(C0520R.drawable.instabug_ic_avatar);
                }
                return view;
            }
        }
        if (e != null && e.f15384h.size() > 0) {
            boolean z;
            String type = ((Attachment) e.f15384h.get(e.f15384h.size() - 1)).getType();
            int hashCode = type.hashCode();
            if (hashCode == 93166550) {
                if (type.equals(Attachment.TYPE_AUDIO)) {
                    z = true;
                    switch (z) {
                        case false:
                            viewGroup.f9340d.setText(C0593R.string.instabug_str_image);
                            break;
                        case true:
                            viewGroup.f9340d.setText(C0593R.string.instabug_str_audio);
                            break;
                        case true:
                            viewGroup.f9340d.setText(C0593R.string.instabug_str_video);
                            break;
                        default:
                            break;
                    }
                }
            } else if (hashCode == 100313435) {
                if (type.equals(Attachment.TYPE_IMAGE)) {
                    z = false;
                    switch (z) {
                        case false:
                            viewGroup.f9340d.setText(C0593R.string.instabug_str_image);
                            break;
                        case true:
                            viewGroup.f9340d.setText(C0593R.string.instabug_str_audio);
                            break;
                        case true:
                            viewGroup.f9340d.setText(C0593R.string.instabug_str_video);
                            break;
                        default:
                            break;
                    }
                }
            } else if (hashCode == 112202875) {
                if (type.equals(Attachment.TYPE_VIDEO)) {
                    z = true;
                    switch (z) {
                        case false:
                            viewGroup.f9340d.setText(C0593R.string.instabug_str_image);
                            break;
                        case true:
                            viewGroup.f9340d.setText(C0593R.string.instabug_str_audio);
                            break;
                        case true:
                            viewGroup.f9340d.setText(C0593R.string.instabug_str_video);
                            break;
                        default:
                            break;
                    }
                }
            }
            z = true;
            switch (z) {
                case false:
                    viewGroup.f9340d.setText(C0593R.string.instabug_str_image);
                    break;
                case true:
                    viewGroup.f9340d.setText(C0593R.string.instabug_str_audio);
                    break;
                case true:
                    viewGroup.f9340d.setText(C0593R.string.instabug_str_video);
                    break;
                default:
                    break;
            }
        }
        c = i.m15274c();
        if (c != null) {
        }
        viewGroup.f9337a.setText(String.format(context.getString(C0593R.string.instabug_str_notification_title), new Object[]{this.f9344b.getAppName()}));
        viewGroup.f9339c.setText(InstabugDateFormatter.formatConversationLastMessageDate(i.m15275d()));
        if (i.m15270a() == 0) {
            viewGroup.f9342f.setBackgroundColor(0);
            viewGroup.f9341e.setVisibility(8);
        } else {
            TypedValue typedValue2 = new TypedValue();
            context.getTheme().resolveAttribute(C0593R.attr.instabug_unread_message_background_color, typedValue2, true);
            viewGroup.f9342f.setBackgroundColor(typedValue2.data);
            viewGroup.f9341e.setBackgroundDrawable(Colorizer.getPrimaryColorTintedDrawable(ContextCompat.m714a(context, C0593R.drawable.instabug_bg_white_oval)));
            viewGroup.f9341e.setText(String.valueOf(i.m15270a()));
            viewGroup.f9341e.setVisibility(0);
        }
        if (i.m15273b() == null) {
            viewGroup.f9338b.setImageResource(C0520R.drawable.instabug_ic_avatar);
        } else {
            AssetsCacheManager.getAssetEntity(context, AssetsCacheManager.createEmptyEntity(context, i.m15273b(), AssetType.IMAGE), /* anonymous class already generated */);
        }
        return view;
    }
}
