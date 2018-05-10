package com.reddit.datalibrary.frontpage.data.provider;

public abstract class ProviderSpec<T extends BaseOtherProvider> {
    final String ownerId;

    protected abstract T createProvider();

    protected ProviderSpec(String str) {
        this.ownerId = str;
    }
}
