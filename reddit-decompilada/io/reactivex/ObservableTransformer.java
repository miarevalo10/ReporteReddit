package io.reactivex;

public interface ObservableTransformer<Upstream, Downstream> {
    ObservableSource<Downstream> m26493a(Observable<Upstream> observable);
}
