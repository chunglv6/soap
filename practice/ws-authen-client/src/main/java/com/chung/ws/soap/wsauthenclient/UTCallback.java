package com.chung.ws.soap.wsauthenclient;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

public class UTCallback implements CallbackHandler {
    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback callback: callbacks) {
            WSPasswordCallback pwdCallback = (WSPasswordCallback) callback;
            if(pwdCallback.getIdentifier().equals("cxf")){
                pwdCallback.setPassword("cxf");
                return;
            }
        }
    }
}
