package org.jsoup.parser;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document.OutputSettings.Syntax;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.nodes.XmlDeclaration;

public class XmlTreeBuilder extends TreeBuilder {
    public final /* bridge */ /* synthetic */ boolean mo6347a(String str, Attributes attributes) {
        return super.mo6347a(str, attributes);
    }

    final ParseSettings mo6346a() {
        return ParseSettings.f27053b;
    }

    protected final void mo6352b(String str, String str2, ParseErrorList parseErrorList, ParseSettings parseSettings) {
        super.mo6352b(str, str2, parseErrorList, parseSettings);
        this.o.add(this.n);
        this.n.f36228a.f26975f = Syntax.xml;
    }

    protected final boolean mo6348a(Token token) {
        Element element;
        switch (token.f27085a) {
            case StartTag:
                StartTag startTag = (StartTag) token;
                Tag a = Tag.m28567a(startTag.m34069j(), this.s);
                Node element2 = new Element(a, this.p, this.s.m28563a(startTag.g));
                m34139a(element2);
                if (startTag.f33375f == null) {
                    this.o.add(element2);
                    break;
                }
                this.m.f27102n = true;
                if (a.m28570b() == null) {
                    a.f27072e = true;
                    break;
                }
                break;
            case EndTag:
                token = ((EndTag) token).m34069j();
                Element element3 = null;
                for (int size = this.o.size() - 1; size >= 0; size--) {
                    Element element4 = (Element) this.o.get(size);
                    if (element4.mo6328a().equals(token)) {
                        element3 = element4;
                        if (element3 != null) {
                            for (token = this.o.size() - 1; token >= null; token--) {
                                element = (Element) this.o.get(token);
                                this.o.remove(token);
                                if (element == element3) {
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
                if (element3 != null) {
                    while (token >= null) {
                        element = (Element) this.o.get(token);
                        this.o.remove(token);
                        if (element == element3) {
                        }
                    }
                }
                break;
            case Comment:
                Comment comment = (Comment) token;
                Node comment2 = new Comment(comment.f33364b.toString(), this.p);
                if (comment.f33365c != null) {
                    token = comment2.m33904b();
                    if (token.length() > 1 && (token.startsWith("!") || token.startsWith(Operation.EMPTY_PARAM))) {
                        StringBuilder stringBuilder = new StringBuilder(Operation.LESS_THAN);
                        stringBuilder.append(token.substring(1, token.length() - 1));
                        stringBuilder.append(Operation.GREATER_THAN);
                        element = Jsoup.m28434a(stringBuilder.toString(), this.p, Parser.m28565b()).m33934e();
                        Node xmlDeclaration = new XmlDeclaration(this.s.m28562a(element.f33334c.f27068a), comment2.f26999g, token.startsWith("!"));
                        xmlDeclaration.mo6344m().m28472a(element.mo6344m());
                        comment2 = xmlDeclaration;
                    }
                }
                m34139a(comment2);
                break;
            case Character:
                m34139a(new TextNode(((Character) token).f33363b, this.p));
                break;
            case Doctype:
                Doctype doctype = (Doctype) token;
                m34139a(new DocumentType(this.s.m28562a(doctype.f33366b.toString()), doctype.f33367c, doctype.f33368d.toString(), doctype.f33369e.toString(), this.p));
                break;
            case EOF:
                break;
            default:
                StringBuilder stringBuilder2 = new StringBuilder("Unexpected token type: ");
                stringBuilder2.append(token.f27085a);
                Validate.m28459b(stringBuilder2.toString());
                break;
        }
        return true;
    }

    private void m34139a(Node node) {
        m28623p().mo6334a(node);
    }
}
