package com.chung.ws.soap.wsauthenclient;

import com.vds.chung.ws.soap.PaymentProcessor;
import com.vds.chung.ws.soap.PaymentProcessorImplService;
import com.vds.chung.ws.soap.PaymentProcessorRequest;
import com.vds.chung.ws.soap.PaymentProcessorResponse;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class PaymentWSClient {
    public static void main(String[] args) {
        try {
            PaymentProcessorImplService service = new PaymentProcessorImplService(new URL("http://localhost:9999/javafirstws/paymentProcessor?wsdl"));
            PaymentProcessor paymentProcessorImplPort = service.getPaymentProcessorImplPort();
            Client client = ClientProxy.getClient(paymentProcessorImplPort);
            Endpoint endpoint = client.getEndpoint();
            Map<String,Object> props = new HashMap<>();
            props.put(WSHandlerConstants.ACTION,WSHandlerConstants.USERNAME_TOKEN);
            props.put(WSHandlerConstants.USER,"cxf");
            props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
            props.put(WSHandlerConstants.PW_CALLBACK_CLASS,UTCallback.class.getName());
            WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(props);
            endpoint.getOutInterceptors().add(wssOut);
            PaymentProcessorResponse response = paymentProcessorImplPort.processPayment(new PaymentProcessorRequest());
            System.out.println(response.isResult());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
