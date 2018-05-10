package org.jsoup.parser;

import org.jsoup.nodes.Document;

public class Parser {
    private TreeBuilder f27056a;
    private int f27057b = 0;
    private ParseErrorList f27058c;
    private ParseSettings f27059d;

    private Parser(TreeBuilder treeBuilder) {
        this.f27056a = treeBuilder;
        this.f27059d = treeBuilder.mo6346a();
    }

    public static Parser m28564a() {
        return new Parser(new HtmlTreeBuilder());
    }

    public static Parser m28565b() {
        return new Parser(new XmlTreeBuilder());
    }

    public final Document m28566a(String str, String str2) {
        this.f27058c = (this.f27057b > 0 ? 1 : null) != null ? ParseErrorList.m28559a(this.f27057b) : ParseErrorList.m28560b();
        return this.f27056a.mo6345a(str, str2, this.f27058c, this.f27059d);
    }
}
