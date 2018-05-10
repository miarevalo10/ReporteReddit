package retrofit2;

import java.io.IOException;

public interface Call<T> extends Cloneable {
    Response<T> mo7883a() throws IOException;

    void mo7884a(Callback<T> callback);

    void mo7885b();

    boolean mo7886c();

    Call<T> mo7887d();
}
