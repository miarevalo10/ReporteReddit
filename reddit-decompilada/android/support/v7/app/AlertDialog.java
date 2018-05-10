package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AlertController.AlertParams;
import android.support.v7.app.AlertController.AlertParams.C01541;
import android.support.v7.app.AlertController.AlertParams.C01552;
import android.support.v7.app.AlertController.AlertParams.C01563;
import android.support.v7.app.AlertController.AlertParams.C01574;
import android.support.v7.app.AlertController.C01513;
import android.support.v7.app.AlertController.C01524;
import android.support.v7.app.AlertController.C01535;
import android.support.v7.app.AlertController.C10102;
import android.support.v7.app.AlertController.RecycleListView;
import android.support.v7.appcompat.C0164R;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;

public class AlertDialog extends AppCompatDialog implements DialogInterface {
    final AlertController f16538a = new AlertController(getContext(), this, getWindow());

    public static class Builder {
        public final AlertParams f1801a;
        private final int f1802b;

        public Builder(Context context) {
            this(context, AlertDialog.m16717a(context, 0));
        }

        private Builder(Context context, int i) {
            this.f1801a = new AlertParams(new ContextThemeWrapper(context, AlertDialog.m16717a(context, i)));
            this.f1802b = i;
        }

        public final Builder m1507a(int i) {
            this.f1801a.f1736f = this.f1801a.f1731a.getText(i);
            return this;
        }

        public final Builder m1513a(CharSequence charSequence) {
            this.f1801a.f1736f = charSequence;
            return this;
        }

        public final Builder m1517b(int i) {
            this.f1801a.f1738h = this.f1801a.f1731a.getText(i);
            return this;
        }

        public final Builder m1519b(CharSequence charSequence) {
            this.f1801a.f1738h = charSequence;
            return this;
        }

        public final Builder m1506a() {
            this.f1801a.f1733c = C1761R.drawable.snoo_logo_large;
            return this;
        }

        public final Builder m1511a(Drawable drawable) {
            this.f1801a.f1734d = drawable;
            return this;
        }

        public final Builder m1508a(int i, OnClickListener onClickListener) {
            this.f1801a.f1739i = this.f1801a.f1731a.getText(i);
            this.f1801a.f1740j = onClickListener;
            return this;
        }

        public final Builder m1514a(CharSequence charSequence, OnClickListener onClickListener) {
            this.f1801a.f1739i = charSequence;
            this.f1801a.f1740j = onClickListener;
            return this;
        }

        public final Builder m1518b(int i, OnClickListener onClickListener) {
            this.f1801a.f1741k = this.f1801a.f1731a.getText(i);
            this.f1801a.f1742l = onClickListener;
            return this;
        }

        public final Builder m1520b(CharSequence charSequence, OnClickListener onClickListener) {
            this.f1801a.f1741k = charSequence;
            this.f1801a.f1742l = onClickListener;
            return this;
        }

        public final Builder m1515a(boolean z) {
            this.f1801a.f1745o = z;
            return this;
        }

        public final Builder m1510a(OnDismissListener onDismissListener) {
            this.f1801a.f1747q = onDismissListener;
            return this;
        }

        public final Builder m1509a(OnClickListener onClickListener) {
            this.f1801a.f1749s = this.f1801a.f1731a.getResources().getTextArray(C1761R.array.report_reasons);
            this.f1801a.f1751u = onClickListener;
            return this;
        }

        public final Builder m1516a(CharSequence[] charSequenceArr, OnClickListener onClickListener) {
            this.f1801a.f1749s = charSequenceArr;
            this.f1801a.f1751u = onClickListener;
            return this;
        }

        public final Builder m1512a(View view) {
            this.f1801a.f1753w = view;
            this.f1801a.f1752v = 0;
            this.f1801a.f1720B = false;
            return this;
        }

        public final AlertDialog m1521b() {
            AlertDialog alertDialog = new AlertDialog(this.f1801a.f1731a, this.f1802b);
            AlertParams alertParams = this.f1801a;
            AlertController alertController = alertDialog.f16538a;
            if (alertParams.f1737g != null) {
                alertController.f1762C = alertParams.f1737g;
            } else {
                if (alertParams.f1736f != null) {
                    alertController.m1505a(alertParams.f1736f);
                }
                if (alertParams.f1734d != null) {
                    Drawable drawable = alertParams.f1734d;
                    alertController.f1799y = drawable;
                    alertController.f1798x = 0;
                    if (alertController.f1800z != null) {
                        if (drawable != null) {
                            alertController.f1800z.setVisibility(0);
                            alertController.f1800z.setImageDrawable(drawable);
                        } else {
                            alertController.f1800z.setVisibility(8);
                        }
                    }
                }
                if (alertParams.f1733c != 0) {
                    alertController.m1503a(alertParams.f1733c);
                }
                if (alertParams.f1735e != 0) {
                    int i = alertParams.f1735e;
                    TypedValue typedValue = new TypedValue();
                    alertController.f1775a.getTheme().resolveAttribute(i, typedValue, true);
                    alertController.m1503a(typedValue.resourceId);
                }
            }
            if (alertParams.f1738h != null) {
                CharSequence charSequence = alertParams.f1738h;
                alertController.f1779e = charSequence;
                if (alertController.f1761B != null) {
                    alertController.f1761B.setText(charSequence);
                }
            }
            if (alertParams.f1739i != null) {
                alertController.m1504a(-1, alertParams.f1739i, alertParams.f1740j, null);
            }
            if (alertParams.f1741k != null) {
                alertController.m1504a(-2, alertParams.f1741k, alertParams.f1742l, null);
            }
            if (alertParams.f1743m != null) {
                alertController.m1504a(-3, alertParams.f1743m, alertParams.f1744n, null);
            }
            if (!(alertParams.f1749s == null && alertParams.f1726H == null && alertParams.f1750t == null)) {
                ListAdapter simpleCursorAdapter;
                RecycleListView recycleListView = (RecycleListView) alertParams.f1732b.inflate(alertController.f1767H, null);
                if (!alertParams.f1722D) {
                    if (alertParams.f1723E) {
                        i = alertController.f1769J;
                    } else {
                        i = alertController.f1770K;
                    }
                    if (alertParams.f1726H != null) {
                        simpleCursorAdapter = new SimpleCursorAdapter(alertParams.f1731a, i, alertParams.f1726H, new String[]{alertParams.f1727I}, new int[]{16908308});
                    } else if (alertParams.f1750t != null) {
                        simpleCursorAdapter = alertParams.f1750t;
                    } else {
                        simpleCursorAdapter = new CheckedItemAdapter(alertParams.f1731a, i, alertParams.f1749s);
                    }
                } else if (alertParams.f1726H == null) {
                    r4 = new C01541(alertParams, alertParams.f1731a, alertController.f1768I, alertParams.f1749s, recycleListView);
                } else {
                    r4 = new C01552(alertParams, alertParams.f1731a, alertParams.f1726H, recycleListView, alertController);
                }
                alertController.f1763D = simpleCursorAdapter;
                alertController.f1764E = alertParams.f1724F;
                if (alertParams.f1751u != null) {
                    recycleListView.setOnItemClickListener(new C01563(alertParams, alertController));
                } else if (alertParams.f1725G != null) {
                    recycleListView.setOnItemClickListener(new C01574(alertParams, recycleListView, alertController));
                }
                if (alertParams.f1729K != null) {
                    recycleListView.setOnItemSelectedListener(alertParams.f1729K);
                }
                if (alertParams.f1723E) {
                    recycleListView.setChoiceMode(1);
                } else if (alertParams.f1722D) {
                    recycleListView.setChoiceMode(2);
                }
                alertController.f1780f = recycleListView;
            }
            int i2;
            if (alertParams.f1753w != null) {
                if (alertParams.f1720B) {
                    View view = alertParams.f1753w;
                    int i3 = alertParams.f1754x;
                    int i4 = alertParams.f1755y;
                    int i5 = alertParams.f1756z;
                    i2 = alertParams.f1719A;
                    alertController.f1781g = view;
                    alertController.f1782h = 0;
                    alertController.f1787m = true;
                    alertController.f1783i = i3;
                    alertController.f1784j = i4;
                    alertController.f1785k = i5;
                    alertController.f1786l = i2;
                } else {
                    alertController.f1781g = alertParams.f1753w;
                    alertController.f1782h = 0;
                    alertController.f1787m = false;
                }
            } else if (alertParams.f1752v != 0) {
                i2 = alertParams.f1752v;
                alertController.f1781g = null;
                alertController.f1782h = i2;
                alertController.f1787m = false;
            }
            alertDialog.setCancelable(r0.f1801a.f1745o);
            if (r0.f1801a.f1745o) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(r0.f1801a.f1746p);
            alertDialog.setOnDismissListener(r0.f1801a.f1747q);
            if (r0.f1801a.f1748r != null) {
                alertDialog.setOnKeyListener(r0.f1801a.f1748r);
            }
            return alertDialog;
        }

        public final AlertDialog m1522c() {
            AlertDialog b = m1521b();
            b.show();
            return b;
        }
    }

    protected AlertDialog(Context context, int i) {
        super(context, m16717a(context, i));
    }

    static int m16717a(Context context, int i) {
        if (((i >>> 24) & 255) > 0) {
            return i;
        }
        i = new TypedValue();
        context.getTheme().resolveAttribute(C0164R.attr.alertDialogTheme, i, true);
        return i.resourceId;
    }

    public final Button m16718a(int i) {
        AlertController alertController = this.f16538a;
        switch (i) {
            case -3:
                return alertController.f1794t;
            case -2:
                return alertController.f1791q;
            case -1:
                return alertController.f1788n;
            default:
                return 0;
        }
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f16538a.m1505a(charSequence);
    }

    protected void onCreate(Bundle bundle) {
        int i;
        int i2;
        super.onCreate(bundle);
        bundle = this.f16538a;
        if (bundle.f1766G == 0 || bundle.f1772M != 1) {
            i = bundle.f1765F;
        } else {
            i = bundle.f1766G;
        }
        bundle.f1776b.setContentView(i);
        View findViewById = bundle.f1777c.findViewById(C0164R.id.parentPanel);
        View findViewById2 = findViewById.findViewById(C0164R.id.topPanel);
        View findViewById3 = findViewById.findViewById(C0164R.id.contentPanel);
        View findViewById4 = findViewById.findViewById(C0164R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(C0164R.id.customPanel);
        int i3 = 0;
        View inflate = bundle.f1781g != null ? bundle.f1781g : bundle.f1782h != 0 ? LayoutInflater.from(bundle.f1775a).inflate(bundle.f1782h, viewGroup, false) : null;
        boolean z = inflate != null;
        if (!(z && AlertController.m1502a(inflate))) {
            bundle.f1777c.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) bundle.f1777c.findViewById(C0164R.id.custom);
            frameLayout.addView(inflate, new LayoutParams(-1, -1));
            if (bundle.f1787m) {
                frameLayout.setPadding(bundle.f1783i, bundle.f1784j, bundle.f1785k, bundle.f1786l);
            }
            if (bundle.f1780f != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).f2298g = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        inflate = viewGroup.findViewById(C0164R.id.topPanel);
        View findViewById5 = viewGroup.findViewById(C0164R.id.contentPanel);
        View findViewById6 = viewGroup.findViewById(C0164R.id.buttonPanel);
        ViewGroup a = AlertController.m1499a(inflate, findViewById2);
        ViewGroup a2 = AlertController.m1499a(findViewById5, findViewById3);
        ViewGroup a3 = AlertController.m1499a(findViewById6, findViewById4);
        bundle.f1797w = (NestedScrollView) bundle.f1777c.findViewById(C0164R.id.scrollView);
        bundle.f1797w.setFocusable(false);
        bundle.f1797w.setNestedScrollingEnabled(false);
        bundle.f1761B = (TextView) a2.findViewById(16908299);
        if (bundle.f1761B != null) {
            if (bundle.f1779e != null) {
                bundle.f1761B.setText(bundle.f1779e);
            } else {
                bundle.f1761B.setVisibility(8);
                bundle.f1797w.removeView(bundle.f1761B);
                if (bundle.f1780f != null) {
                    ViewGroup viewGroup2 = (ViewGroup) bundle.f1797w.getParent();
                    int indexOfChild = viewGroup2.indexOfChild(bundle.f1797w);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(bundle.f1780f, indexOfChild, new LayoutParams(-1, -1));
                } else {
                    a2.setVisibility(8);
                }
            }
        }
        bundle.f1788n = (Button) a3.findViewById(16908313);
        bundle.f1788n.setOnClickListener(bundle.f1774O);
        if (TextUtils.isEmpty(bundle.f1789o)) {
            bundle.f1788n.setVisibility(8);
            i2 = 0;
        } else {
            bundle.f1788n.setText(bundle.f1789o);
            bundle.f1788n.setVisibility(0);
            i2 = 1;
        }
        bundle.f1791q = (Button) a3.findViewById(16908314);
        bundle.f1791q.setOnClickListener(bundle.f1774O);
        if (TextUtils.isEmpty(bundle.f1792r)) {
            bundle.f1791q.setVisibility(8);
        } else {
            bundle.f1791q.setText(bundle.f1792r);
            bundle.f1791q.setVisibility(0);
            i2 |= 2;
        }
        bundle.f1794t = (Button) a3.findViewById(16908315);
        bundle.f1794t.setOnClickListener(bundle.f1774O);
        if (TextUtils.isEmpty(bundle.f1795u)) {
            bundle.f1794t.setVisibility(8);
        } else {
            bundle.f1794t.setText(bundle.f1795u);
            bundle.f1794t.setVisibility(0);
            i2 |= 4;
        }
        Context context = bundle.f1775a;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0164R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (i2 == 1) {
                AlertController.m1501a(bundle.f1788n);
            } else if (i2 == 2) {
                AlertController.m1501a(bundle.f1791q);
            } else if (i2 == 4) {
                AlertController.m1501a(bundle.f1794t);
            }
        }
        if (!(i2 != 0)) {
            a3.setVisibility(8);
        }
        if (bundle.f1762C != null) {
            a.addView(bundle.f1762C, 0, new LayoutParams(-1, -2));
            bundle.f1777c.findViewById(C0164R.id.title_template).setVisibility(8);
        } else {
            bundle.f1800z = (ImageView) bundle.f1777c.findViewById(16908294);
            if ((TextUtils.isEmpty(bundle.f1778d) ^ 1) == 0 || !bundle.f1771L) {
                bundle.f1777c.findViewById(C0164R.id.title_template).setVisibility(8);
                bundle.f1800z.setVisibility(8);
                a.setVisibility(8);
            } else {
                bundle.f1760A = (TextView) bundle.f1777c.findViewById(C0164R.id.alertTitle);
                bundle.f1760A.setText(bundle.f1778d);
                if (bundle.f1798x != 0) {
                    bundle.f1800z.setImageResource(bundle.f1798x);
                } else if (bundle.f1799y != null) {
                    bundle.f1800z.setImageDrawable(bundle.f1799y);
                } else {
                    bundle.f1760A.setPadding(bundle.f1800z.getPaddingLeft(), bundle.f1800z.getPaddingTop(), bundle.f1800z.getPaddingRight(), bundle.f1800z.getPaddingBottom());
                    bundle.f1800z.setVisibility(8);
                }
            }
        }
        boolean z2 = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        i2 = (a == null || a.getVisibility() == 8) ? 0 : 1;
        boolean z3 = (a3 == null || a3.getVisibility() == 8) ? false : true;
        if (!(z3 || a2 == null)) {
            findViewById5 = a2.findViewById(C0164R.id.textSpacerNoButtons);
            if (findViewById5 != null) {
                findViewById5.setVisibility(0);
            }
        }
        if (i2 != 0) {
            if (bundle.f1797w != null) {
                bundle.f1797w.setClipToPadding(true);
            }
            if (bundle.f1779e == null) {
                if (bundle.f1780f == null) {
                    findViewById2 = null;
                    if (findViewById2 != null) {
                        findViewById2.setVisibility(0);
                    }
                }
            }
            findViewById2 = a.findViewById(C0164R.id.titleDividerNoCustom);
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
        } else if (a2 != null) {
            findViewById2 = a2.findViewById(C0164R.id.textSpacerNoTitle);
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
        }
        if (bundle.f1780f instanceof RecycleListView) {
            RecycleListView recycleListView = (RecycleListView) bundle.f1780f;
            if (!z3 || i2 == 0) {
                recycleListView.setPadding(recycleListView.getPaddingLeft(), i2 != 0 ? recycleListView.getPaddingTop() : recycleListView.f1758a, recycleListView.getPaddingRight(), z3 ? recycleListView.getPaddingBottom() : recycleListView.f1759b);
            }
        }
        if (!z2) {
            findViewById = bundle.f1780f != null ? bundle.f1780f : bundle.f1797w;
            if (findViewById != null) {
                if (z3) {
                    i3 = 2;
                }
                int i4 = i2 | i3;
                findViewById4 = bundle.f1777c.findViewById(C0164R.id.scrollIndicatorUp);
                inflate = bundle.f1777c.findViewById(C0164R.id.scrollIndicatorDown);
                if (VERSION.SDK_INT >= 23) {
                    ViewCompat.m1239d(findViewById, i4);
                    if (findViewById4 != null) {
                        a2.removeView(findViewById4);
                    }
                    if (inflate != null) {
                        a2.removeView(inflate);
                    }
                } else {
                    if (findViewById4 != null && (i4 & 1) == 0) {
                        a2.removeView(findViewById4);
                        findViewById4 = null;
                    }
                    if (inflate != null && (i4 & 2) == 0) {
                        a2.removeView(inflate);
                        inflate = null;
                    }
                    if (!(findViewById4 == null && inflate == null)) {
                        if (bundle.f1779e != null) {
                            bundle.f1797w.setOnScrollChangeListener(new C10102(bundle, findViewById4, inflate));
                            bundle.f1797w.post(new C01513(bundle, findViewById4, inflate));
                        } else if (bundle.f1780f != null) {
                            bundle.f1780f.setOnScrollListener(new C01524(bundle, findViewById4, inflate));
                            bundle.f1780f.post(new C01535(bundle, findViewById4, inflate));
                        } else {
                            if (findViewById4 != null) {
                                a2.removeView(findViewById4);
                            }
                            if (inflate != null) {
                                a2.removeView(inflate);
                            }
                        }
                    }
                }
            }
        }
        ListView listView = bundle.f1780f;
        if (listView != null && bundle.f1763D != null) {
            listView.setAdapter(bundle.f1763D);
            bundle = bundle.f1764E;
            if (bundle >= null) {
                listView.setItemChecked(bundle, true);
                listView.setSelection(bundle);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AlertController alertController = this.f16538a;
        boolean z = alertController.f1797w != null && alertController.f1797w.m16711a(keyEvent);
        return z ? true : super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AlertController alertController = this.f16538a;
        boolean z = alertController.f1797w != null && alertController.f1797w.m16711a(keyEvent);
        return z ? true : super.onKeyUp(i, keyEvent);
    }
}
