package com.reddit.frontpage.presentation.detail;

import android.view.View;
import android.widget.EditText;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/EditText;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: EditFragment.kt */
final class EditFragment$editableTextView$2 extends Lambda implements Function0<EditText> {
    final /* synthetic */ EditFragment f36456a;

    EditFragment$editableTextView$2(EditFragment editFragment) {
        this.f36456a = editFragment;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        View a = this.f36456a.e;
        if (a == null) {
            Intrinsics.m26842a();
        }
        return (EditText) a.findViewById(C1761R.id.edit_text);
    }
}
