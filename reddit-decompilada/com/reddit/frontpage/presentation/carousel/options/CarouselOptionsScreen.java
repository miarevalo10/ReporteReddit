package com.reddit.frontpage.presentation.carousel.options;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.options.CarouselOptionsContract.Presenter;
import com.reddit.frontpage.presentation.common.ui.view.RedditBottomSheetDialog;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/options/CarouselOptionsScreen;", "Lcom/reddit/frontpage/presentation/common/ui/view/RedditBottomSheetDialog;", "Lcom/reddit/frontpage/presentation/carousel/options/CarouselOptionsContract$View;", "context", "Landroid/content/Context;", "presenter", "Lcom/reddit/frontpage/presentation/carousel/options/CarouselOptionsContract$Presenter;", "item", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;", "idsSeen", "", "", "listablePosition", "", "(Landroid/content/Context;Lcom/reddit/frontpage/presentation/carousel/options/CarouselOptionsContract$Presenter;Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;Ljava/util/Set;I)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CarouselOptionsScreen.kt */
public final class CarouselOptionsScreen extends RedditBottomSheetDialog {
    private final Presenter f39068d;
    private final CarouselCollectionPresentationModel f39069e;
    private final Set<String> f39070f;
    private final int f39071g;

    public CarouselOptionsScreen(Context context, Presenter presenter, CarouselCollectionPresentationModel carouselCollectionPresentationModel, Set<String> set, int i) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(presenter, "presenter");
        Intrinsics.m26847b(carouselCollectionPresentationModel, "item");
        Intrinsics.m26847b(set, "idsSeen");
        super(context, false);
        this.f39068d = presenter;
        this.f39069e = carouselCollectionPresentationModel;
        this.f39070f = set;
        this.f39071g = i;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C1761R.layout.carousel_options);
        Object obj = (TextView) findViewById(C1761R.id.show_me_less_item);
        Intrinsics.m26843a(obj, "show_me_less_item");
        ((View) obj).setOnClickListener(new CarouselOptionsScreen$inlined$sam$OnClickListener$i$7f478c20(new CarouselOptionsScreen$onCreate$1(this)));
    }
}
