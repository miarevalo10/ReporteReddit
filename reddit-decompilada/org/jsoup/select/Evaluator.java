package org.jsoup.select;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.XmlDeclaration;

public abstract class Evaluator {

    public static final class AllElements extends Evaluator {
        public final boolean mo6353a(Element element, Element element2) {
            return true;
        }

        public final String toString() {
            return Operation.MULTIPLY;
        }
    }

    public static final class Attribute extends Evaluator {
        private String f33385a;

        public Attribute(String str) {
            this.f33385a = str;
        }

        public final boolean mo6353a(Element element, Element element2) {
            return element2.mo6342c(this.f33385a);
        }

        public final String toString() {
            return String.format("[%s]", new Object[]{this.f33385a});
        }
    }

    public static abstract class AttributeKeyPair extends Evaluator {
        String f33386a;
        String f33387b;

        public AttributeKeyPair(String str, String str2) {
            Validate.m28454a(str);
            Validate.m28454a(str2);
            this.f33386a = str.trim().toLowerCase();
            if (!((str2.startsWith("\"") == null || str2.endsWith("\"") == null) && (str2.startsWith("'") == null || str2.endsWith("'") == null))) {
                str2 = str2.substring(1, str2.length() - 1);
            }
            this.f33387b = str2.trim().toLowerCase();
        }
    }

    public static final class AttributeStarting extends Evaluator {
        private String f33388a;

        public AttributeStarting(String str) {
            Validate.m28454a(str);
            this.f33388a = str.toLowerCase();
        }

        public final boolean mo6353a(Element element, Element element2) {
            element = element2.mo6344m();
            if (element.f26966a == null) {
                element = Collections.emptyList();
            } else {
                element2 = new ArrayList(element.f26966a.size());
                for (Entry value : element.f26966a.entrySet()) {
                    element2.add(value.getValue());
                }
                element = Collections.unmodifiableList(element2);
            }
            for (org.jsoup.nodes.Attribute attribute : r2) {
                if (attribute.f26964a.toLowerCase().startsWith(this.f33388a) != null) {
                    return true;
                }
            }
            return null;
        }

        public final String toString() {
            return String.format("[^%s]", new Object[]{this.f33388a});
        }
    }

    public static final class AttributeWithValueMatching extends Evaluator {
        String f33389a;
        Pattern f33390b;

        public AttributeWithValueMatching(String str, Pattern pattern) {
            this.f33389a = str.trim().toLowerCase();
            this.f33390b = pattern;
        }

        public final boolean mo6353a(Element element, Element element2) {
            return (element2.mo6342c(this.f33389a) == null || this.f33390b.matcher(element2.mo6341b(this.f33389a)).find() == null) ? null : true;
        }

        public final String toString() {
            return String.format("[%s~=%s]", new Object[]{this.f33389a, this.f33390b.toString()});
        }
    }

    public static final class Class extends Evaluator {
        private String f33391a;

        public Class(String str) {
            this.f33391a = str;
        }

        public final boolean mo6353a(Element element, Element element2) {
            element = this.f33391a;
            element2 = element2.f.m28468a("class");
            int length = element2.length();
            int length2 = element.length();
            if (length != 0) {
                if (length >= length2) {
                    if (length == length2) {
                        return element.equalsIgnoreCase(element2);
                    }
                    boolean z = false;
                    int i = z;
                    int i2 = i;
                    while (i < length) {
                        if (Character.isWhitespace(element2.charAt(i))) {
                            if (!z) {
                                continue;
                            } else if (i - i2 == length2 && element2.regionMatches(true, i2, element, 0, length2)) {
                                return true;
                            } else {
                                z = false;
                            }
                        } else if (!z) {
                            i2 = i;
                            z = true;
                        }
                        i++;
                    }
                    if (z && length - i2 == length2) {
                        return element2.regionMatches(true, i2, element, 0, length2);
                    }
                    return false;
                }
            }
            return false;
        }

        public final String toString() {
            return String.format(".%s", new Object[]{this.f33391a});
        }
    }

    public static final class ContainsData extends Evaluator {
        private String f33392a;

        public ContainsData(String str) {
            this.f33392a = str.toLowerCase();
        }

        public final boolean mo6353a(Element element, Element element2) {
            return element2.m33940k().toLowerCase().contains(this.f33392a);
        }

        public final String toString() {
            return String.format(":containsData(%s)", new Object[]{this.f33392a});
        }
    }

    public static final class ContainsOwnText extends Evaluator {
        private String f33393a;

        public ContainsOwnText(String str) {
            this.f33393a = str.toLowerCase();
        }

        public final boolean mo6353a(Element element, Element element2) {
            return element2.m33939j().toLowerCase().contains(this.f33393a);
        }

        public final String toString() {
            return String.format(":containsOwn(%s)", new Object[]{this.f33393a});
        }
    }

    public static final class ContainsText extends Evaluator {
        private String f33394a;

        public ContainsText(String str) {
            this.f33394a = str.toLowerCase();
        }

        public final boolean mo6353a(Element element, Element element2) {
            return element2.m33938i().toLowerCase().contains(this.f33394a);
        }

        public final String toString() {
            return String.format(":contains(%s)", new Object[]{this.f33394a});
        }
    }

    public static abstract class CssNthEvaluator extends Evaluator {
        protected final int f33395a;
        protected final int f33396b;

        protected abstract int mo6858a(Element element);

        protected abstract String mo6859a();

        public CssNthEvaluator(int i, int i2) {
            this.f33395a = i;
            this.f33396b = i2;
        }

        public String toString() {
            if (this.f33395a == 0) {
                return String.format(":%s(%d)", new Object[]{mo6859a(), Integer.valueOf(this.f33396b)});
            } else if (this.f33396b == 0) {
                return String.format(":%s(%dn)", new Object[]{mo6859a(), Integer.valueOf(this.f33395a)});
            } else {
                return String.format(":%s(%dn%+d)", new Object[]{mo6859a(), Integer.valueOf(this.f33395a), Integer.valueOf(this.f33396b)});
            }
        }

        public final boolean mo6353a(Element element, Element element2) {
            element = element2.d;
            if (element != null) {
                if ((element instanceof Document) == null) {
                    element = mo6858a(element2);
                    if (this.f33395a == null) {
                        if (element == this.f33396b) {
                            return true;
                        }
                        return false;
                    } else if ((element - this.f33396b) * this.f33395a < null || (element - this.f33396b) % this.f33395a != null) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static final class Id extends Evaluator {
        private String f33397a;

        public Id(String str) {
            this.f33397a = str;
        }

        public final boolean mo6353a(Element element, Element element2) {
            return this.f33397a.equals(element2.f.m28473b("id"));
        }

        public final String toString() {
            return String.format("#%s", new Object[]{this.f33397a});
        }
    }

    public static abstract class IndexEvaluator extends Evaluator {
        int f33398a;

        public IndexEvaluator(int i) {
            this.f33398a = i;
        }
    }

    public static final class IsEmpty extends Evaluator {
        public final String toString() {
            return ":empty";
        }

        public final boolean mo6353a(Element element, Element element2) {
            for (Node node : Collections.unmodifiableList(element2.f26997e)) {
                if (!(node instanceof Comment) && !(node instanceof XmlDeclaration) && (node instanceof DocumentType) == null) {
                    return null;
                }
            }
            return true;
        }
    }

    public static final class IsFirstChild extends Evaluator {
        public final String toString() {
            return ":first-child";
        }

        public final boolean mo6353a(Element element, Element element2) {
            element = element2.d;
            return (element != null && (element instanceof Document) == null && element2.m33937h().intValue() == null) ? true : null;
        }
    }

    public static final class IsLastChild extends Evaluator {
        public final String toString() {
            return ":last-child";
        }

        public final boolean mo6353a(Element element, Element element2) {
            element = element2.d;
            return (element == null || (element instanceof Document) || element2.m33937h().intValue() != element.m33935f().size() - 1) ? null : true;
        }
    }

    public static final class IsOnlyChild extends Evaluator {
        public final String toString() {
            return ":only-child";
        }

        public final boolean mo6353a(Element element, Element element2) {
            element = element2.d;
            if (element != null && (element instanceof Document) == null) {
                if (element2.d == null) {
                    element = new Elements(0);
                } else {
                    Element<Element> f = element2.d.m33935f();
                    Elements elements = new Elements(f.size() - 1);
                    for (Element element3 : f) {
                        if (element3 != element2) {
                            elements.add(element3);
                        }
                    }
                    element = elements;
                }
                if (element.size() == null) {
                    return true;
                }
            }
            return false;
        }
    }

    public static final class IsOnlyOfType extends Evaluator {
        public final String toString() {
            return ":only-of-type";
        }

        public final boolean mo6353a(Element element, Element element2) {
            element = element2.d;
            if (element != null) {
                if (!(element instanceof Document)) {
                    element = element.m33935f().iterator();
                    int i = 0;
                    while (element.hasNext()) {
                        if (((Element) element.next()).f33334c.equals(element2.f33334c)) {
                            i++;
                        }
                    }
                    if (i == 1) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        }
    }

    public static final class IsRoot extends Evaluator {
        public final String toString() {
            return ":root";
        }

        public final boolean mo6353a(Element element, Element element2) {
            if (element instanceof Document) {
                element = element.m33934e();
            }
            return element2 == element ? true : null;
        }
    }

    public static final class Matches extends Evaluator {
        private Pattern f33399a;

        public Matches(Pattern pattern) {
            this.f33399a = pattern;
        }

        public final boolean mo6353a(Element element, Element element2) {
            return this.f33399a.matcher(element2.m33938i()).find();
        }

        public final String toString() {
            return String.format(":matches(%s)", new Object[]{this.f33399a});
        }
    }

    public static final class MatchesOwn extends Evaluator {
        private Pattern f33400a;

        public MatchesOwn(Pattern pattern) {
            this.f33400a = pattern;
        }

        public final boolean mo6353a(Element element, Element element2) {
            return this.f33400a.matcher(element2.m33939j()).find();
        }

        public final String toString() {
            return String.format(":matchesOwn(%s)", new Object[]{this.f33400a});
        }
    }

    public static final class Tag extends Evaluator {
        private String f33401a;

        public Tag(String str) {
            this.f33401a = str;
        }

        public final String toString() {
            return String.format("%s", new Object[]{this.f33401a});
        }

        public final boolean mo6353a(Element element, Element element2) {
            return element2.f33334c.f27068a.equalsIgnoreCase(this.f33401a);
        }
    }

    public static final class TagEndsWith extends Evaluator {
        private String f33402a;

        public TagEndsWith(String str) {
            this.f33402a = str;
        }

        public final String toString() {
            return String.format("%s", new Object[]{this.f33402a});
        }

        public final boolean mo6353a(Element element, Element element2) {
            return element2.f33334c.f27068a.endsWith(this.f33402a);
        }
    }

    public static final class AttributeWithValue extends AttributeKeyPair {
        public AttributeWithValue(String str, String str2) {
            super(str, str2);
        }

        public final boolean mo6353a(Element element, Element element2) {
            return (element2.mo6342c(this.a) == null || this.b.equalsIgnoreCase(element2.mo6341b(this.a).trim()) == null) ? null : true;
        }

        public final String toString() {
            return String.format("[%s=%s]", new Object[]{this.a, this.b});
        }
    }

    public static final class AttributeWithValueContaining extends AttributeKeyPair {
        public AttributeWithValueContaining(String str, String str2) {
            super(str, str2);
        }

        public final boolean mo6353a(Element element, Element element2) {
            return (element2.mo6342c(this.a) == null || element2.mo6341b((String) this.a).toLowerCase().contains(this.b) == null) ? null : true;
        }

        public final String toString() {
            return String.format("[%s*=%s]", new Object[]{this.a, this.b});
        }
    }

    public static final class AttributeWithValueEnding extends AttributeKeyPair {
        public AttributeWithValueEnding(String str, String str2) {
            super(str, str2);
        }

        public final boolean mo6353a(Element element, Element element2) {
            return (element2.mo6342c(this.a) == null || element2.mo6341b((String) this.a).toLowerCase().endsWith(this.b) == null) ? null : true;
        }

        public final String toString() {
            return String.format("[%s$=%s]", new Object[]{this.a, this.b});
        }
    }

    public static final class AttributeWithValueNot extends AttributeKeyPair {
        public AttributeWithValueNot(String str, String str2) {
            super(str, str2);
        }

        public final boolean mo6353a(Element element, Element element2) {
            return this.b.equalsIgnoreCase(element2.mo6341b(this.a)) == null ? true : null;
        }

        public final String toString() {
            return String.format("[%s!=%s]", new Object[]{this.a, this.b});
        }
    }

    public static final class AttributeWithValueStarting extends AttributeKeyPair {
        public AttributeWithValueStarting(String str, String str2) {
            super(str, str2);
        }

        public final boolean mo6353a(Element element, Element element2) {
            return (element2.mo6342c(this.a) == null || element2.mo6341b((String) this.a).toLowerCase().startsWith(this.b) == null) ? null : true;
        }

        public final String toString() {
            return String.format("[%s^=%s]", new Object[]{this.a, this.b});
        }
    }

    public static final class IndexEquals extends IndexEvaluator {
        public IndexEquals(int i) {
            super(i);
        }

        public final boolean mo6353a(Element element, Element element2) {
            return element2.m33937h().intValue() == this.a ? true : null;
        }

        public final String toString() {
            return String.format(":eq(%d)", new Object[]{Integer.valueOf(this.a)});
        }
    }

    public static final class IndexGreaterThan extends IndexEvaluator {
        public IndexGreaterThan(int i) {
            super(i);
        }

        public final boolean mo6353a(Element element, Element element2) {
            return element2.m33937h().intValue() > this.a ? true : null;
        }

        public final String toString() {
            return String.format(":gt(%d)", new Object[]{Integer.valueOf(this.a)});
        }
    }

    public static final class IndexLessThan extends IndexEvaluator {
        public IndexLessThan(int i) {
            super(i);
        }

        public final boolean mo6353a(Element element, Element element2) {
            return element2.m33937h().intValue() < this.a ? true : null;
        }

        public final String toString() {
            return String.format(":lt(%d)", new Object[]{Integer.valueOf(this.a)});
        }
    }

    public static final class IsNthChild extends CssNthEvaluator {
        protected final String mo6859a() {
            return "nth-child";
        }

        public IsNthChild(int i, int i2) {
            super(i, i2);
        }

        protected final int mo6858a(Element element) {
            return element.m33937h().intValue() + 1;
        }
    }

    public static final class IsNthLastChild extends CssNthEvaluator {
        protected final String mo6859a() {
            return "nth-last-child";
        }

        public IsNthLastChild(int i, int i2) {
            super(i, i2);
        }

        protected final int mo6858a(Element element) {
            return ((Element) element.d).m33935f().size() - element.m33937h().intValue();
        }
    }

    public static class IsNthLastOfType extends CssNthEvaluator {
        protected final String mo6859a() {
            return "nth-last-of-type";
        }

        public IsNthLastOfType(int i, int i2) {
            super(i, i2);
        }

        protected final int mo6858a(Element element) {
            Elements f = ((Element) element.d).m33935f();
            int i = 0;
            for (int intValue = element.m33937h().intValue(); intValue < f.size(); intValue++) {
                if (((Element) f.get(intValue)).f33334c.equals(element.f33334c)) {
                    i++;
                }
            }
            return i;
        }
    }

    public static class IsNthOfType extends CssNthEvaluator {
        protected final String mo6859a() {
            return "nth-of-type";
        }

        public IsNthOfType(int i, int i2) {
            super(i, i2);
        }

        protected final int mo6858a(Element element) {
            Iterator it = ((Element) element.d).m33935f().iterator();
            int i = 0;
            while (it.hasNext()) {
                Element element2 = (Element) it.next();
                if (element2.f33334c.equals(element.f33334c)) {
                    i++;
                    continue;
                }
                if (element2 == element) {
                    break;
                }
            }
            return i;
        }
    }

    public static final class IsFirstOfType extends IsNthOfType {
        public final String toString() {
            return ":first-of-type";
        }

        public IsFirstOfType() {
            super(0, 1);
        }
    }

    public static final class IsLastOfType extends IsNthLastOfType {
        public final String toString() {
            return ":last-of-type";
        }

        public IsLastOfType() {
            super(0, 1);
        }
    }

    public abstract boolean mo6353a(Element element, Element element2);

    protected Evaluator() {
    }
}
