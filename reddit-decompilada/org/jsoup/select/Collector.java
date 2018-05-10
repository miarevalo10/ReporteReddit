package org.jsoup.select;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

public class Collector {

    private static class Accumulator implements NodeVisitor {
        private final Element f33380a;
        private final Elements f33381b;
        private final Evaluator f33382c;

        public final void mo6333b(Node node, int i) {
        }

        Accumulator(Element element, Elements elements, Evaluator evaluator) {
            this.f33380a = element;
            this.f33381b = elements;
            this.f33382c = evaluator;
        }

        public final void mo6332a(Node node, int i) {
            if ((node instanceof Element) != 0) {
                Element element = (Element) node;
                if (this.f33382c.mo6353a(this.f33380a, element) != 0) {
                    this.f33381b.add(element);
                }
            }
        }
    }

    public static Elements m28624a(Evaluator evaluator, Element element) {
        Elements elements = new Elements();
        new NodeTraversor(new Accumulator(element, elements, evaluator)).m28627a(element);
        return elements;
    }
}
