package com.chung.ws.soap.mtom.config;

import com.chung.ws.soap.mtom.FilewsImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {
    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint(){
        Endpoint endpoint = new EndpointImpl(bus,new FilewsImpl());
        endpoint.publish("/filews");
        SOAPBinding binding = (SOAPBinding) endpoint.getBinding();
        binding.setMTOMEnabled(true);
        return endpoint;
    }
}
