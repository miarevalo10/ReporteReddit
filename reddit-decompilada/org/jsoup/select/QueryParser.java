package org.jsoup.select;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.parser.TokenQueue;
import org.jsoup.select.Evaluator.AllElements;
import org.jsoup.select.Evaluator.Attribute;
import org.jsoup.select.Evaluator.AttributeStarting;
import org.jsoup.select.Evaluator.AttributeWithValue;
import org.jsoup.select.Evaluator.AttributeWithValueContaining;
import org.jsoup.select.Evaluator.AttributeWithValueEnding;
import org.jsoup.select.Evaluator.AttributeWithValueMatching;
import org.jsoup.select.Evaluator.AttributeWithValueNot;
import org.jsoup.select.Evaluator.AttributeWithValueStarting;
import org.jsoup.select.Evaluator.Class;
import org.jsoup.select.Evaluator.ContainsData;
import org.jsoup.select.Evaluator.ContainsOwnText;
import org.jsoup.select.Evaluator.ContainsText;
import org.jsoup.select.Evaluator.Id;
import org.jsoup.select.Evaluator.IndexEquals;
import org.jsoup.select.Evaluator.IndexGreaterThan;
import org.jsoup.select.Evaluator.IndexLessThan;
import org.jsoup.select.Evaluator.IsEmpty;
import org.jsoup.select.Evaluator.IsFirstChild;
import org.jsoup.select.Evaluator.IsFirstOfType;
import org.jsoup.select.Evaluator.IsLastChild;
import org.jsoup.select.Evaluator.IsLastOfType;
import org.jsoup.select.Evaluator.IsNthChild;
import org.jsoup.select.Evaluator.IsNthLastChild;
import org.jsoup.select.Evaluator.IsNthLastOfType;
import org.jsoup.select.Evaluator.IsNthOfType;
import org.jsoup.select.Evaluator.IsOnlyChild;
import org.jsoup.select.Evaluator.IsOnlyOfType;
import org.jsoup.select.Evaluator.IsRoot;
import org.jsoup.select.Evaluator.Matches;
import org.jsoup.select.Evaluator.MatchesOwn;
import org.jsoup.select.Evaluator.Tag;
import org.jsoup.select.Evaluator.TagEndsWith;
import org.jsoup.select.Selector.SelectorParseException;

public class QueryParser {
    private static final String[] f27171a = new String[]{",", Operation.GREATER_THAN, Operation.PLUS, "~", " "};
    private static final String[] f27172b = new String[]{Operation.EQUALS, Operation.NOT_EQUALS, "^=", "$=", "*=", "~="};
    private static final Pattern f27173f = Pattern.compile("((\\+|-)?(\\d+)?)n(\\s*(\\+|-)?\\s*\\d+)?", 2);
    private static final Pattern f27174g = Pattern.compile("(\\+|-)?(\\d+)");
    private TokenQueue f27175c;
    private String f27176d;
    private List<Evaluator> f27177e = new ArrayList();

    private QueryParser(String str) {
        this.f27176d = str;
        this.f27175c = new TokenQueue(str);
    }

    public static Evaluator m28630a(String str) {
        QueryParser queryParser = new QueryParser(str);
        queryParser.f27175c.m28590d();
        if (queryParser.f27175c.m28584a(f27171a) != null) {
            queryParser.f27177e.add(new Root());
            queryParser.m28632a(queryParser.f27175c.m28587c());
        } else {
            queryParser.m28631a();
        }
        while (queryParser.f27175c.m28582a() == null) {
            str = queryParser.f27175c.m28590d();
            if (queryParser.f27175c.m28584a(f27171a)) {
                queryParser.m28632a(queryParser.f27175c.m28587c());
            } else if (str != null) {
                queryParser.m28632a(' ');
            } else {
                queryParser.m28631a();
            }
        }
        if (queryParser.f27177e.size() == 1) {
            return (Evaluator) queryParser.f27177e.get(0);
        }
        return new And(queryParser.f27177e);
    }

    private void m28632a(char c) {
        Evaluator evaluator;
        int i;
        Evaluator evaluator2;
        this.f27175c.m28590d();
        StringBuilder stringBuilder = new StringBuilder();
        while (!this.f27175c.m28582a()) {
            if (!this.f27175c.m28583a("(")) {
                if (!this.f27175c.m28583a("[")) {
                    if (this.f27175c.m28584a(f27171a)) {
                        break;
                    }
                    stringBuilder.append(this.f27175c.m28587c());
                } else {
                    stringBuilder.append("[");
                    stringBuilder.append(this.f27175c.m28581a('[', ']'));
                    stringBuilder.append("]");
                }
            } else {
                stringBuilder.append("(");
                stringBuilder.append(this.f27175c.m28581a('(', ')'));
                stringBuilder.append(")");
            }
        }
        Evaluator a = m28630a(stringBuilder.toString());
        if (this.f27177e.size() == 1) {
            evaluator = (Evaluator) this.f27177e.get(0);
            if ((evaluator instanceof Or) && c != ',') {
                Or or = (Or) evaluator;
                i = 1;
                Evaluator evaluator3 = or.f33384b > 0 ? (Evaluator) or.f33383a.get(or.f33384b - 1) : null;
                evaluator2 = evaluator;
                evaluator = evaluator3;
                this.f27177e.clear();
                if (c == '>') {
                    c = new And(a, new ImmediateParent(evaluator));
                } else if (c == ' ') {
                    c = new And(a, new Parent(evaluator));
                } else if (c == '+') {
                    c = new And(a, new ImmediatePreviousSibling(evaluator));
                } else if (c == '~') {
                    c = new And(a, new PreviousSibling(evaluator));
                } else if (c == ',') {
                    StringBuilder stringBuilder2 = new StringBuilder("Unknown combinator: ");
                    stringBuilder2.append(c);
                    throw new SelectorParseException(stringBuilder2.toString(), new Object[0]);
                } else if ((evaluator instanceof Or) == '\u0000') {
                    Or or2 = (Or) evaluator;
                    or2.m36609a(a);
                    c = or2;
                } else {
                    c = new Or();
                    c.m36609a(evaluator);
                    c.m36609a(a);
                }
                if (i != 0) {
                    Or or3 = (Or) evaluator2;
                    or3.f33383a.set(or3.f33384b - 1, c);
                    c = evaluator2;
                }
                this.f27177e.add(c);
            }
        }
        evaluator = new And(this.f27177e);
        evaluator2 = evaluator;
        i = 0;
        this.f27177e.clear();
        if (c == '>') {
            c = new And(a, new ImmediateParent(evaluator));
        } else if (c == ' ') {
            c = new And(a, new Parent(evaluator));
        } else if (c == '+') {
            c = new And(a, new ImmediatePreviousSibling(evaluator));
        } else if (c == '~') {
            c = new And(a, new PreviousSibling(evaluator));
        } else if (c == ',') {
            StringBuilder stringBuilder22 = new StringBuilder("Unknown combinator: ");
            stringBuilder22.append(c);
            throw new SelectorParseException(stringBuilder22.toString(), new Object[0]);
        } else if ((evaluator instanceof Or) == '\u0000') {
            c = new Or();
            c.m36609a(evaluator);
            c.m36609a(a);
        } else {
            Or or22 = (Or) evaluator;
            or22.m36609a(a);
            c = or22;
        }
        if (i != 0) {
            Or or32 = (Or) evaluator2;
            or32.f33383a.set(or32.f33384b - 1, c);
            c = evaluator2;
        }
        this.f27177e.add(c);
    }

    private void m28631a() {
        String e;
        if (this.f27175c.m28586b("#")) {
            e = this.f27175c.m28591e();
            Validate.m28454a(e);
            this.f27177e.add(new Id(e));
        } else if (this.f27175c.m28586b(".")) {
            e = this.f27175c.m28591e();
            Validate.m28454a(e);
            this.f27177e.add(new Class(e.trim()));
        } else {
            TokenQueue tokenQueue;
            if (!this.f27175c.m28585b()) {
                if (!this.f27175c.m28583a("*|")) {
                    if (this.f27175c.m28583a("[")) {
                        tokenQueue = new TokenQueue(this.f27175c.m28581a('[', ']'));
                        String[] strArr = f27172b;
                        int i = tokenQueue.f27087b;
                        while (!tokenQueue.m28582a() && !tokenQueue.m28584a(strArr)) {
                            tokenQueue.f27087b++;
                        }
                        String substring = tokenQueue.f27086a.substring(i, tokenQueue.f27087b);
                        Validate.m28454a(substring);
                        tokenQueue.m28590d();
                        if (tokenQueue.m28582a()) {
                            if (substring.startsWith("^")) {
                                this.f27177e.add(new AttributeStarting(substring.substring(1)));
                                return;
                            } else {
                                this.f27177e.add(new Attribute(substring));
                                return;
                            }
                        } else if (tokenQueue.m28586b(Operation.EQUALS)) {
                            this.f27177e.add(new AttributeWithValue(substring, tokenQueue.m28593f()));
                            return;
                        } else if (tokenQueue.m28586b(Operation.NOT_EQUALS)) {
                            this.f27177e.add(new AttributeWithValueNot(substring, tokenQueue.m28593f()));
                            return;
                        } else if (tokenQueue.m28586b("^=")) {
                            this.f27177e.add(new AttributeWithValueStarting(substring, tokenQueue.m28593f()));
                            return;
                        } else if (tokenQueue.m28586b("$=")) {
                            this.f27177e.add(new AttributeWithValueEnding(substring, tokenQueue.m28593f()));
                            return;
                        } else if (tokenQueue.m28586b("*=")) {
                            this.f27177e.add(new AttributeWithValueContaining(substring, tokenQueue.m28593f()));
                            return;
                        } else if (tokenQueue.m28586b("~=")) {
                            this.f27177e.add(new AttributeWithValueMatching(substring, Pattern.compile(tokenQueue.m28593f())));
                            return;
                        } else {
                            throw new SelectorParseException("Could not parse attribute query '%s': unexpected token at '%s'", this.f27176d, tokenQueue.m28593f());
                        }
                    } else if (this.f27175c.m28586b(Operation.MULTIPLY)) {
                        this.f27177e.add(new AllElements());
                        return;
                    } else if (this.f27175c.m28586b(":lt(")) {
                        this.f27177e.add(new IndexLessThan(m28635b()));
                        return;
                    } else if (this.f27175c.m28586b(":gt(")) {
                        this.f27177e.add(new IndexGreaterThan(m28635b()));
                        return;
                    } else if (this.f27175c.m28586b(":eq(")) {
                        this.f27177e.add(new IndexEquals(m28635b()));
                        return;
                    } else if (this.f27175c.m28583a(":has(")) {
                        this.f27175c.m28588c(":has");
                        e = this.f27175c.m28581a('(', ')');
                        Validate.m28455a(e, ":has(el) subselect must not be empty");
                        this.f27177e.add(new Has(m28630a(e)));
                        return;
                    } else if (this.f27175c.m28583a(":contains(")) {
                        m28633a(false);
                        return;
                    } else if (this.f27175c.m28583a(":containsOwn(")) {
                        m28633a(true);
                        return;
                    } else if (this.f27175c.m28583a(":containsData(")) {
                        this.f27175c.m28588c(":containsData");
                        e = TokenQueue.m28579f(this.f27175c.m28581a('(', ')'));
                        Validate.m28455a(e, ":containsData(text) query must not be empty");
                        this.f27177e.add(new ContainsData(e));
                        return;
                    } else if (this.f27175c.m28583a(":matches(")) {
                        m28636b(false);
                        return;
                    } else if (this.f27175c.m28583a(":matchesOwn(")) {
                        m28636b(true);
                        return;
                    } else if (this.f27175c.m28583a(":not(")) {
                        this.f27175c.m28588c(":not");
                        e = this.f27175c.m28581a('(', ')');
                        Validate.m28455a(e, ":not(selector) subselect must not be empty");
                        this.f27177e.add(new Not(m28630a(e)));
                        return;
                    } else if (this.f27175c.m28586b(":nth-child(")) {
                        m28634a(false, false);
                        return;
                    } else if (this.f27175c.m28586b(":nth-last-child(")) {
                        m28634a(true, false);
                        return;
                    } else if (this.f27175c.m28586b(":nth-of-type(")) {
                        m28634a(false, true);
                        return;
                    } else if (this.f27175c.m28586b(":nth-last-of-type(")) {
                        m28634a(true, true);
                        return;
                    } else if (this.f27175c.m28586b(":first-child")) {
                        this.f27177e.add(new IsFirstChild());
                        return;
                    } else if (this.f27175c.m28586b(":last-child")) {
                        this.f27177e.add(new IsLastChild());
                        return;
                    } else if (this.f27175c.m28586b(":first-of-type")) {
                        this.f27177e.add(new IsFirstOfType());
                        return;
                    } else if (this.f27175c.m28586b(":last-of-type")) {
                        this.f27177e.add(new IsLastOfType());
                        return;
                    } else if (this.f27175c.m28586b(":only-child")) {
                        this.f27177e.add(new IsOnlyChild());
                        return;
                    } else if (this.f27175c.m28586b(":only-of-type")) {
                        this.f27177e.add(new IsOnlyOfType());
                        return;
                    } else if (this.f27175c.m28586b(":empty")) {
                        this.f27177e.add(new IsEmpty());
                        return;
                    } else if (this.f27175c.m28586b(":root")) {
                        this.f27177e.add(new IsRoot());
                        return;
                    } else {
                        throw new SelectorParseException("Could not parse query '%s': unexpected token at '%s'", this.f27176d, this.f27175c.m28593f());
                    }
                }
            }
            tokenQueue = this.f27175c;
            int i2 = tokenQueue.f27087b;
            while (!tokenQueue.m28582a() && (tokenQueue.m28585b() || tokenQueue.m28584a("*|", "|", EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR, Operation.MINUS))) {
                tokenQueue.f27087b++;
            }
            e = tokenQueue.f27086a.substring(i2, tokenQueue.f27087b);
            Validate.m28454a(e);
            if (e.startsWith("*|")) {
                this.f27177e.add(new Or(new Tag(e.trim().toLowerCase()), new TagEndsWith(e.replace("*|", ":").trim().toLowerCase())));
                return;
            }
            if (e.contains("|")) {
                e = e.replace("|", ":");
            }
            this.f27177e.add(new Tag(e.trim()));
        }
    }

    private void m28634a(boolean z, boolean z2) {
        CharSequence toLowerCase = this.f27175c.m28592e(")").trim().toLowerCase();
        Matcher matcher = f27173f.matcher(toLowerCase);
        Matcher matcher2 = f27174g.matcher(toLowerCase);
        int i = 2;
        int i2 = 0;
        if ("odd".equals(toLowerCase)) {
            i2 = 1;
        } else if (!"even".equals(toLowerCase)) {
            int parseInt;
            if (matcher.matches()) {
                i = matcher.group(3) != null ? Integer.parseInt(matcher.group(1).replaceFirst("^\\+", "")) : 1;
                if (matcher.group(4) != null) {
                    parseInt = Integer.parseInt(matcher.group(4).replaceFirst("^\\+", ""));
                }
            } else if (matcher2.matches()) {
                parseInt = Integer.parseInt(matcher2.group().replaceFirst("^\\+", ""));
                i = 0;
            } else {
                throw new SelectorParseException("Could not parse nth-index '%s': unexpected format", toLowerCase);
            }
            i2 = parseInt;
        }
        if (z2) {
            if (z) {
                this.f27177e.add(new IsNthLastOfType(i, i2));
            } else {
                this.f27177e.add(new IsNthOfType(i, i2));
            }
        } else if (z) {
            this.f27177e.add(new IsNthLastChild(i, i2));
        } else {
            this.f27177e.add(new IsNthChild(i, i2));
        }
    }

    private int m28635b() {
        String trim = this.f27175c.m28592e(")").trim();
        Validate.m28457a(StringUtil.m28450b(trim), "Index must be numeric");
        return Integer.parseInt(trim);
    }

    private void m28633a(boolean z) {
        this.f27175c.m28588c(z ? ":containsOwn" : ":contains");
        String f = TokenQueue.m28579f(this.f27175c.m28581a('(', ')'));
        Validate.m28455a(f, ":contains(text) query must not be empty");
        if (z) {
            this.f27177e.add(new ContainsOwnText(f));
        } else {
            this.f27177e.add(new ContainsText(f));
        }
    }

    private void m28636b(boolean z) {
        this.f27175c.m28588c(z ? ":matchesOwn" : ":matches");
        String a = this.f27175c.m28581a('(', ')');
        Validate.m28455a(a, ":matches(regex) query must not be empty");
        if (z) {
            this.f27177e.add(new MatchesOwn(Pattern.compile(a)));
        } else {
            this.f27177e.add(new Matches(Pattern.compile(a)));
        }
    }
}
