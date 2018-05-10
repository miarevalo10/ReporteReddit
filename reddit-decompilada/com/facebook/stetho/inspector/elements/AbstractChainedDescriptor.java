package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.Util;

public abstract class AbstractChainedDescriptor<E> extends Descriptor<E> implements ChainedDescriptor<E> {
    private Descriptor<? super E> mSuper;

    public void onGetAttributes(E e, AttributeAccumulator attributeAccumulator) {
    }

    public void onGetChildren(E e, Accumulator<Object> accumulator) {
    }

    public void onGetComputedStyles(E e, ComputedStyleAccumulator computedStyleAccumulator) {
    }

    public void onGetStyleRuleNames(E e, StyleRuleNameAccumulator styleRuleNameAccumulator) {
    }

    public void onGetStyles(E e, String str, StyleAccumulator styleAccumulator) {
    }

    protected void onHook(E e) {
    }

    protected void onSetStyle(E e, String str, String str2, String str3) {
    }

    protected void onUnhook(E e) {
    }

    public void setSuper(Descriptor<? super E> descriptor) {
        Util.throwIfNull(descriptor);
        if (descriptor == this.mSuper) {
            return;
        }
        if (this.mSuper != null) {
            throw new IllegalStateException();
        }
        this.mSuper = descriptor;
    }

    final Descriptor<? super E> getSuper() {
        return this.mSuper;
    }

    public final void hook(E e) {
        verifyThreadAccess();
        this.mSuper.hook(e);
        onHook(e);
    }

    public final void unhook(E e) {
        verifyThreadAccess();
        onUnhook(e);
        this.mSuper.unhook(e);
    }

    public final NodeType getNodeType(E e) {
        return onGetNodeType(e);
    }

    protected NodeType onGetNodeType(E e) {
        return this.mSuper.getNodeType(e);
    }

    public final String getNodeName(E e) {
        return onGetNodeName(e);
    }

    public String onGetNodeName(E e) {
        return this.mSuper.getNodeName(e);
    }

    public final String getLocalName(E e) {
        return onGetLocalName(e);
    }

    protected String onGetLocalName(E e) {
        return this.mSuper.getLocalName(e);
    }

    public final String getNodeValue(E e) {
        return onGetNodeValue(e);
    }

    public String onGetNodeValue(E e) {
        return this.mSuper.getNodeValue(e);
    }

    public final void getChildren(E e, Accumulator<Object> accumulator) {
        this.mSuper.getChildren(e, accumulator);
        onGetChildren(e, accumulator);
    }

    public final void getAttributes(E e, AttributeAccumulator attributeAccumulator) {
        this.mSuper.getAttributes(e, attributeAccumulator);
        onGetAttributes(e, attributeAccumulator);
    }

    public final void setAttributesAsText(E e, String str) {
        onSetAttributesAsText(e, str);
    }

    public void onSetAttributesAsText(E e, String str) {
        this.mSuper.setAttributesAsText(e, str);
    }

    public final void getStyleRuleNames(E e, StyleRuleNameAccumulator styleRuleNameAccumulator) {
        this.mSuper.getStyleRuleNames(e, styleRuleNameAccumulator);
        onGetStyleRuleNames(e, styleRuleNameAccumulator);
    }

    public final void getStyles(E e, String str, StyleAccumulator styleAccumulator) {
        this.mSuper.getStyles(e, str, styleAccumulator);
        onGetStyles(e, str, styleAccumulator);
    }

    public final void setStyle(E e, String str, String str2, String str3) {
        this.mSuper.setStyle(e, str, str2, str3);
        onSetStyle(e, str, str2, str3);
    }

    public void getComputedStyles(E e, ComputedStyleAccumulator computedStyleAccumulator) {
        this.mSuper.getComputedStyles(e, computedStyleAccumulator);
        onGetComputedStyles(e, computedStyleAccumulator);
    }
}
