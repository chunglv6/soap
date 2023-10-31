package com.example.wsdlFirst.config;

import com.example.wsdlFirst.CustomerOrdersImpl;
import com.example.wsdlFirst.handler.SiteHandler;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Binding;
import javax.xml.ws.Endpoint;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.soap.SOAPBinding;
import java.util.ArrayList;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint(){
        Endpoint endpoint = new EndpointImpl(bus,new CustomerOrdersImpl());
        endpoint.publish("/customerordersservice");
        SOAPBinding  binding = (SOAPBinding) endpoint.getBinding();
        ArrayList<Handler> chain = new ArrayList<>();
        chain.add(new SiteHandler());
        binding.setHandlerChain(chain);
        return endpoint;
    }
}
