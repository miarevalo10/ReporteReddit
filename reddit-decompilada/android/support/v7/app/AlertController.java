package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.NestedScrollView.OnScrollChangeListener;
import android.support.v7.appcompat.C0164R;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.lang.ref.WeakReference;

class AlertController {
    TextView f1760A;
    TextView f1761B;
    View f1762C;
    ListAdapter f1763D;
    int f1764E = -1;
    int f1765F;
    int f1766G;
    int f1767H;
    int f1768I;
    int f1769J;
    int f1770K;
    boolean f1771L;
    int f1772M = 0;
    Handler f1773N;
    final OnClickListener f1774O = new C01501(this);
    final Context f1775a;
    final AppCompatDialog f1776b;
    final Window f1777c;
    CharSequence f1778d;
    CharSequence f1779e;
    ListView f1780f;
    View f1781g;
    int f1782h;
    int f1783i;
    int f1784j;
    int f1785k;
    int f1786l;
    boolean f1787m = false;
    Button f1788n;
    CharSequence f1789o;
    Message f1790p;
    Button f1791q;
    CharSequence f1792r;
    Message f1793s;
    Button f1794t;
    CharSequence f1795u;
    Message f1796v;
    NestedScrollView f1797w;
    int f1798x = 0;
    Drawable f1799y;
    ImageView f1800z;

    class C01501 implements OnClickListener {
        final /* synthetic */ AlertController f1697a;

        C01501(AlertController alertController) {
            this.f1697a = alertController;
        }

        public void onClick(View view) {
            view = (view != this.f1697a.f1788n || this.f1697a.f1790p == null) ? (view != this.f1697a.f1791q || this.f1697a.f1793s == null) ? (view != this.f1697a.f1794t || this.f1697a.f1796v == null) ? null : Message.obtain(this.f1697a.f1796v) : Message.obtain(this.f1697a.f1793s) : Message.obtain(this.f1697a.f1790p);
            if (view != null) {
                view.sendToTarget();
            }
            this.f1697a.f1773N.obtainMessage(1, this.f1697a.f1776b).sendToTarget();
        }
    }

    class C01513 implements Runnable {
        final /* synthetic */ View f1698a;
        final /* synthetic */ View f1699b;
        final /* synthetic */ AlertController f1700c;

        C01513(AlertController alertController, View view, View view2) {
            this.f1700c = alertController;
            this.f1698a = view;
            this.f1699b = view2;
        }

        public void run() {
            AlertController.m1500a(this.f1700c.f1797w, this.f1698a, this.f1699b);
        }
    }

    class C01524 implements OnScrollListener {
        final /* synthetic */ View f1701a;
        final /* synthetic */ View f1702b;
        final /* synthetic */ AlertController f1703c;

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        C01524(AlertController alertController, View view, View view2) {
            this.f1703c = alertController;
            this.f1701a = view;
            this.f1702b = view2;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AlertController.m1500a(absListView, this.f1701a, this.f1702b);
        }
    }

    class C01535 implements Runnable {
        final /* synthetic */ View f1704a;
        final /* synthetic */ View f1705b;
        final /* synthetic */ AlertController f1706c;

        C01535(AlertController alertController, View view, View view2) {
            this.f1706c = alertController;
            this.f1704a = view;
            this.f1705b = view2;
        }

        public void run() {
            AlertController.m1500a(this.f1706c.f1780f, this.f1704a, this.f1705b);
        }
    }

    public static class AlertParams {
        public int f1719A;
        public boolean f1720B = false;
        public boolean[] f1721C;
        public boolean f1722D;
        public boolean f1723E;
        public int f1724F = -1;
        public OnMultiChoiceClickListener f1725G;
        public Cursor f1726H;
        public String f1727I;
        public String f1728J;
        public OnItemSelectedListener f1729K;
        public boolean f1730L = true;
        public final Context f1731a;
        public final LayoutInflater f1732b;
        public int f1733c = 0;
        public Drawable f1734d;
        public int f1735e = 0;
        public CharSequence f1736f;
        public View f1737g;
        public CharSequence f1738h;
        public CharSequence f1739i;
        public DialogInterface.OnClickListener f1740j;
        public CharSequence f1741k;
        public DialogInterface.OnClickListener f1742l;
        public CharSequence f1743m;
        public DialogInterface.OnClickListener f1744n;
        public boolean f1745o;
        public OnCancelListener f1746p;
        public OnDismissListener f1747q;
        public OnKeyListener f1748r;
        public CharSequence[] f1749s;
        public ListAdapter f1750t;
        public DialogInterface.OnClickListener f1751u;
        public int f1752v;
        public View f1753w;
        public int f1754x;
        public int f1755y;
        public int f1756z;

        class C01541 extends ArrayAdapter<CharSequence> {
            final /* synthetic */ RecycleListView f1707a;
            final /* synthetic */ AlertParams f1708b;

            C01541(AlertParams alertParams, Context context, int i, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                this.f1708b = alertParams;
                this.f1707a = recycleListView;
                super(context, i, 16908308, charSequenceArr);
            }

            public View getView(int i, View view, ViewGroup viewGroup) {
                view = super.getView(i, view, viewGroup);
                if (!(this.f1708b.f1721C == null || this.f1708b.f1721C[i] == null)) {
                    this.f1707a.setItemChecked(i, true);
                }
                return view;
            }
        }

        class C01552 extends CursorAdapter {
            final /* synthetic */ RecycleListView f1709a;
            final /* synthetic */ AlertController f1710b;
            final /* synthetic */ AlertParams f1711c;
            private final int f1712d;
            private final int f1713e;

            C01552(AlertParams alertParams, Context context, Cursor cursor, RecycleListView recycleListView, AlertController alertController) {
                this.f1711c = alertParams;
                this.f1709a = recycleListView;
                this.f1710b = alertController;
                super(context, cursor, null);
                alertParams = getCursor();
                this.f1712d = alertParams.getColumnIndexOrThrow(this.f1711c.f1727I);
                this.f1713e = alertParams.getColumnIndexOrThrow(this.f1711c.f1728J);
            }

            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f1712d));
                view = this.f1709a;
                context = cursor.getPosition();
                boolean z = true;
                if (cursor.getInt(this.f1713e) != 1) {
                    z = false;
                }
                view.setItemChecked(context, z);
            }

            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return this.f1711c.f1732b.inflate(this.f1710b.f1768I, viewGroup, false);
            }
        }

        class C01563 implements OnItemClickListener {
            final /* synthetic */ AlertController f1714a;
            final /* synthetic */ AlertParams f1715b;

            C01563(AlertParams alertParams, AlertController alertController) {
                this.f1715b = alertParams;
                this.f1714a = alertController;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.f1715b.f1751u.onClick(this.f1714a.f1776b, i);
                if (this.f1715b.f1723E == null) {
                    this.f1714a.f1776b.dismiss();
                }
            }
        }

        class C01574 implements OnItemClickListener {
            final /* synthetic */ RecycleListView f1716a;
            final /* synthetic */ AlertController f1717b;
            final /* synthetic */ AlertParams f1718c;

            C01574(AlertParams alertParams, RecycleListView recycleListView, AlertController alertController) {
                this.f1718c = alertParams;
                this.f1716a = recycleListView;
                this.f1717b = alertController;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.f1718c.f1721C != null) {
                    this.f1718c.f1721C[i] = this.f1716a.isItemChecked(i);
                }
                this.f1718c.f1725G.onClick(this.f1717b.f1776b, i, this.f1716a.isItemChecked(i));
            }
        }

        public AlertParams(Context context) {
            this.f1731a = context;
            this.f1745o = true;
            this.f1732b = (LayoutInflater) context.getSystemService("layout_inflater");
        }
    }

    private static final class ButtonHandler extends Handler {
        private WeakReference<DialogInterface> f1757a;

        public ButtonHandler(DialogInterface dialogInterface) {
            this.f1757a = new WeakReference(dialogInterface);
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                switch (i) {
                    case -3:
                    case -2:
                    case -1:
                        ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f1757a.get(), message.what);
                        return;
                    default:
                        break;
                }
            }
            ((DialogInterface) message.obj).dismiss();
        }
    }

    private static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }

        public CheckedItemAdapter(Context context, int i, CharSequence[] charSequenceArr) {
            super(context, i, 16908308, charSequenceArr);
        }
    }

    public static class RecycleListView extends ListView {
        final int f1758a;
        final int f1759b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, C0164R.styleable.RecycleListView);
            this.f1759b = context.getDimensionPixelOffset(C0164R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f1758a = context.getDimensionPixelOffset(C0164R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    class C10102 implements OnScrollChangeListener {
        final /* synthetic */ View f11538a;
        final /* synthetic */ View f11539b;
        final /* synthetic */ AlertController f11540c;

        C10102(AlertController alertController, View view, View view2) {
            this.f11540c = alertController;
            this.f11538a = view;
            this.f11539b = view2;
        }

        public final void mo409a(NestedScrollView nestedScrollView) {
            AlertController.m1500a(nestedScrollView, this.f11538a, this.f11539b);
        }
    }

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        this.f1775a = context;
        this.f1776b = appCompatDialog;
        this.f1777c = window;
        this.f1773N = new ButtonHandler(appCompatDialog);
        context = context.obtainStyledAttributes(null, C0164R.styleable.AlertDialog, C0164R.attr.alertDialogStyle, 0);
        this.f1765F = context.getResourceId(C0164R.styleable.AlertDialog_android_layout, 0);
        this.f1766G = context.getResourceId(C0164R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.f1767H = context.getResourceId(C0164R.styleable.AlertDialog_listLayout, 0);
        this.f1768I = context.getResourceId(C0164R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.f1769J = context.getResourceId(C0164R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.f1770K = context.getResourceId(C0164R.styleable.AlertDialog_listItemLayout, 0);
        this.f1771L = context.getBoolean(C0164R.styleable.AlertDialog_showTitle, true);
        context.recycle();
        appCompatDialog.x_();
    }

    static boolean m1502a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (m1502a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public final void m1505a(CharSequence charSequence) {
        this.f1778d = charSequence;
        if (this.f1760A != null) {
            this.f1760A.setText(charSequence);
        }
    }

    public final void m1504a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (onClickListener != null) {
            message = this.f1773N.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.f1795u = charSequence;
                this.f1796v = message;
                return;
            case -2:
                this.f1792r = charSequence;
                this.f1793s = message;
                return;
            case -1:
                this.f1789o = charSequence;
                this.f1790p = message;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public final void m1503a(int i) {
        this.f1799y = null;
        this.f1798x = i;
        if (this.f1800z != null) {
            if (i != 0) {
                this.f1800z.setVisibility(0);
                this.f1800z.setImageResource(this.f1798x);
                return;
            }
            this.f1800z.setVisibility(8);
        }
    }

    static ViewGroup m1499a(View view, View view2) {
        if (view == null) {
            if ((view2 instanceof ViewStub) != null) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if ((view instanceof ViewStub) != null) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    static void m1500a(View view, View view2, View view3) {
        int i = 4;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (view.canScrollVertically(1) != null) {
                i = 0;
            }
            view3.setVisibility(i);
        }
    }

    static void m1501a(Button button) {
        LayoutParams layoutParams = (LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }
}
