package com.chung.ws.soap.mtom;

import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface Filews {
    void upload(@WebParam(name = "file") DataHandler dataHandler);

    DataHandler download();
}
