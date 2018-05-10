package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

public interface zzawb extends IInterface {
    void mo3479a() throws RemoteException;

    void mo3480a(Status status) throws RemoteException;

    void mo3481a(Status status, Credential credential) throws RemoteException;
}
