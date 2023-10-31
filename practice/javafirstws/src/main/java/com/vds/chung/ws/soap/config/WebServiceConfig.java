package com.vds.chung.ws.soap.config;

import com.vds.chung.ws.soap.PaymentProcessorImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.common.ConfigurationConstants;
import org.apache.wss4j.dom.WSConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;
    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpoint = new EndpointImpl(bus,new PaymentProcessorImpl());
        endpoint.publish("/paymentProcessor");
        Map<String,Object> inProps = new HashMap<>();
        inProps.put(ConfigurationConstants.ACTION,ConfigurationConstants.USERNAME_TOKEN);
        inProps.put(ConfigurationConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
        inProps.put(ConfigurationConstants.PW_CALLBACK_CLASS,UTPasswordCallbak.class.getName());
        WSS4JInInterceptor wssin = new WSS4JInInterceptor(inProps);
        endpoint.getInInterceptors().add(wssin);
        return endpoint;
    }
}
