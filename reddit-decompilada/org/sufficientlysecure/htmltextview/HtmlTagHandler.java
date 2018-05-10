package org.sufficientlysecure.htmltextview;

import android.text.Editable;
import android.text.Html.TagHandler;
import android.text.Layout.Alignment;
import android.text.TextPaint;
import android.text.style.AlignmentSpan;
import android.text.style.BulletSpan;
import android.text.style.LeadingMarginSpan.Standard;
import android.text.style.StrikethroughSpan;
import android.text.style.TypefaceSpan;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.Stack;
import org.xml.sax.XMLReader;

public class HtmlTagHandler implements TagHandler {
    private static final BulletSpan f27240h = new BulletSpan(10);
    Stack<String> f27241a = new Stack();
    Stack<Integer> f27242b = new Stack();
    StringBuilder f27243c = new StringBuilder();
    int f27244d = 0;
    ClickableTableSpan f27245e;
    DrawTableLinkSpan f27246f;
    private final TextPaint f27247g;

    private static class Center {
        private Center() {
        }
    }

    private static class Code {
        private Code() {
        }
    }

    private static class Ol {
        private Ol() {
        }
    }

    private static class Strike {
        private Strike() {
        }
    }

    private static class Table {
        private Table() {
        }
    }

    private static class Td {
        private Td() {
        }
    }

    private static class Th {
        private Th() {
        }
    }

    private static class Tr {
        private Tr() {
        }
    }

    private static class Ul {
        private Ul() {
        }
    }

    public HtmlTagHandler(TextPaint textPaint) {
        this.f27247g = textPaint;
    }

    static String m28724a(String str) {
        if (str == null) {
            return null;
        }
        return str.replace("<ul", "<HTML_TEXTVIEW_ESCAPED_UL_TAG").replace("</ul>", "</HTML_TEXTVIEW_ESCAPED_UL_TAG>").replace("<ol", "<HTML_TEXTVIEW_ESCAPED_OL_TAG").replace("</ol>", "</HTML_TEXTVIEW_ESCAPED_OL_TAG>").replace("<li", "<HTML_TEXTVIEW_ESCAPED_LI_TAG").replace("</li>", "</HTML_TEXTVIEW_ESCAPED_LI_TAG>");
    }

    public void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
        xMLReader = 10;
        if (z) {
            if (str.equalsIgnoreCase("HTML_TEXTVIEW_ESCAPED_UL_TAG")) {
                this.f27241a.push(str);
            } else if (str.equalsIgnoreCase("HTML_TEXTVIEW_ESCAPED_OL_TAG")) {
                this.f27241a.push(str);
                this.f27242b.push(Integer.valueOf(1));
            } else if (str.equalsIgnoreCase("HTML_TEXTVIEW_ESCAPED_LI_TAG")) {
                if (editable.length() > 0 && editable.charAt(editable.length() - 1) != '\n') {
                    editable.append("\n");
                }
                if (this.f27241a.isEmpty() == null) {
                    String str2 = (String) this.f27241a.peek();
                    if (str2.equalsIgnoreCase("HTML_TEXTVIEW_ESCAPED_OL_TAG")) {
                        m28726a(editable, new Ol());
                        this.f27242b.push(Integer.valueOf(((Integer) this.f27242b.pop()).intValue() + 1));
                    } else if (str2.equalsIgnoreCase("HTML_TEXTVIEW_ESCAPED_UL_TAG") != null) {
                        m28726a(editable, new Ul());
                    }
                }
            } else if (str.equalsIgnoreCase("code") != null) {
                m28726a(editable, new Code());
            } else if (str.equalsIgnoreCase("center") != null) {
                m28726a(editable, new Center());
            } else {
                if (str.equalsIgnoreCase("s") == null) {
                    if (str.equalsIgnoreCase("strike") == null) {
                        if (str.equalsIgnoreCase("table") != null) {
                            m28726a(editable, new Table());
                            if (this.f27244d == null) {
                                this.f27243c = new StringBuilder();
                                editable.append("table placeholder");
                            }
                            this.f27244d += 1;
                        } else if (str.equalsIgnoreCase("tr") != null) {
                            m28726a(editable, new Tr());
                        } else if (str.equalsIgnoreCase("th") != null) {
                            m28726a(editable, new Th());
                        } else if (str.equalsIgnoreCase("td") != null) {
                            m28726a(editable, new Td());
                        }
                    }
                }
                m28726a(editable, new Strike());
            }
        } else if (str.equalsIgnoreCase("HTML_TEXTVIEW_ESCAPED_UL_TAG")) {
            this.f27241a.pop();
        } else if (str.equalsIgnoreCase("HTML_TEXTVIEW_ESCAPED_OL_TAG")) {
            this.f27241a.pop();
            this.f27242b.pop();
        } else if (str.equalsIgnoreCase("HTML_TEXTVIEW_ESCAPED_LI_TAG")) {
            if (!this.f27241a.isEmpty()) {
                if (((String) this.f27241a.peek()).equalsIgnoreCase("HTML_TEXTVIEW_ESCAPED_UL_TAG")) {
                    if (editable.length() > 0 && editable.charAt(editable.length() - 1) != '\n') {
                        editable.append("\n");
                    }
                    if (this.f27241a.size() > 1) {
                        xMLReader = 10 - f27240h.getLeadingMargin(true);
                        if (this.f27241a.size() > 2) {
                            xMLReader -= (this.f27241a.size() - 2) * 20;
                        }
                    }
                    BulletSpan bulletSpan = new BulletSpan(xMLReader);
                    m28725a(editable, Ul.class, false, new Standard(20 * (this.f27241a.size() - 1)), bulletSpan);
                } else if (((String) this.f27241a.peek()).equalsIgnoreCase("HTML_TEXTVIEW_ESCAPED_OL_TAG")) {
                    if (editable.length() > 0 && editable.charAt(editable.length() - 1) != '\n') {
                        editable.append("\n");
                    }
                    xMLReader = (this.f27241a.size() - 1) * 20;
                    if (this.f27241a.size() > 2) {
                        xMLReader -= (this.f27241a.size() - 2) * 20;
                    }
                    NumberSpan numberSpan = new NumberSpan(this.f27247g, ((Integer) this.f27242b.lastElement()).intValue() - 1);
                    m28725a(editable, Ol.class, false, new Standard(xMLReader), numberSpan);
                }
            }
        } else if (str.equalsIgnoreCase("code") != null) {
            m28725a(editable, Code.class, false, new TypefaceSpan("monospace"));
        } else if (str.equalsIgnoreCase("center") != null) {
            m28725a(editable, Center.class, true, new AlignmentSpan.Standard(Alignment.ALIGN_CENTER));
        } else {
            if (str.equalsIgnoreCase("s") == null) {
                if (str.equalsIgnoreCase("strike") == null) {
                    if (str.equalsIgnoreCase("table") != null) {
                        this.f27244d -= 1;
                        if (this.f27244d == null) {
                            ClickableTableSpan a;
                            xMLReader = this.f27243c.toString();
                            DrawTableLinkSpan drawTableLinkSpan = null;
                            if (this.f27245e != null) {
                                a = this.f27245e.mo5069a();
                                a.m28718a(xMLReader);
                            } else {
                                a = null;
                            }
                            if (this.f27246f != null) {
                                drawTableLinkSpan = this.f27246f.m28720a();
                            }
                            m28725a(editable, Table.class, false, drawTableLinkSpan, a);
                        } else {
                            m28725a(editable, Table.class, false, new Object[0]);
                        }
                    } else if (str.equalsIgnoreCase("tr") != null) {
                        m28725a(editable, Tr.class, false, new Object[0]);
                    } else if (str.equalsIgnoreCase("th") != null) {
                        m28725a(editable, Th.class, false, new Object[0]);
                    } else if (str.equalsIgnoreCase("td") != null) {
                        m28725a(editable, Td.class, false, new Object[0]);
                    }
                }
            }
            m28725a(editable, Strike.class, false, new StrikethroughSpan());
        }
        if (this.f27244d > null || str.equalsIgnoreCase("table") != null) {
            this.f27243c.append(Operation.LESS_THAN);
            if (!z) {
                this.f27243c.append(Operation.DIVISION);
            }
            z = this.f27243c;
            z.append(str.toLowerCase());
            z.append(Operation.GREATER_THAN);
        }
    }

    private static void m28726a(Editable editable, Object obj) {
        int length = editable.length();
        editable.setSpan(obj, length, length, 17);
    }

    private void m28725a(Editable editable, Class cls, boolean z, Object... objArr) {
        Object a = m28723a(editable, cls);
        int spanStart = editable.getSpanStart(a);
        int length = editable.length();
        if (this.f27244d > 0) {
            cls = editable.getSpanStart(m28723a(editable, cls));
            int length2 = editable.length();
            CharSequence subSequence = editable.subSequence(cls, length2);
            editable.delete(cls, length2);
            this.f27243c.append(subSequence);
        }
        editable.removeSpan(a);
        if (spanStart != length) {
            if (z) {
                editable.append("\n");
                length++;
            }
            for (Object a2 : objArr) {
                editable.setSpan(a2, spanStart, length, 33);
            }
        }
    }

    private static Object m28723a(Editable editable, Class cls) {
        cls = editable.getSpans(0, editable.length(), cls);
        if (cls.length == 0) {
            return null;
        }
        for (int length = cls.length; length > 0; length--) {
            int i = length - 1;
            if (editable.getSpanFlags(cls[i]) == 17) {
                return cls[i];
            }
        }
        return null;
    }
}
